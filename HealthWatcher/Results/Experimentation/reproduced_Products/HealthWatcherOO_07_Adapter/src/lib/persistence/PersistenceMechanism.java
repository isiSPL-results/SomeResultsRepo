package lib.persistence;
import healthwatcher.Constants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import lib.exceptions.ExceptionMessages;
import lib.exceptions.PersistenceMechanismException;
import lib.exceptions.TransactionException;
public class PersistenceMechanism implements IPersistenceMechanism
{
    private static PersistenceMechanism singleton;
    private static int numConexoes = 2;
    private Connection conexoesCriadas[];
    private Connection conexoesLivres[];
    private HashMap conexoesAlocadas;
    private String url;
    private String user;
    private String password;
    private boolean indisponivel;
    private synchronized void releaseCommunicationChannel(boolean porTransacao)
    throws PersistenceMechanismException
    {
        try { //1
            Thread currentThread = Thread.currentThread();
            int threadId = currentThread.hashCode();
            if(porTransacao || !porTransacao && !conexoesAlocadas.containsKey("T" + threadId)) { //1
                Object canal = conexoesAlocadas.get("" + threadId);
                boolean achou = false;
                for (int i = 0; !achou && i < PersistenceMechanism.numConexoes; i++) { //1
                    if(conexoesLivres[i] != null) { //1
                        continue;
                    }
                    achou = true;
                    conexoesAlocadas.remove("" + threadId);
                    if(conexoesAlocadas.containsKey("T" + threadId)) { //1
                        conexoesAlocadas.remove("T" + threadId);
                    }
                    conexoesLivres[i] = (java.sql.Connection) canal;
                }
                indisponivel = false;
            }
        } catch (Exception ex) { //1
            ex.printStackTrace();
            throw new PersistenceMechanismException(
                ExceptionMessages.EXC_FALHA_LIBERAR_CANAL_COMUNICACAO);
        } finally {
            notifyAll();
        }
    }
    public synchronized void connect() throws PersistenceMechanismException
    {
        if(conexoesCriadas == null) { //1
            try { //1
                conexoesLivres = new Connection[PersistenceMechanism.numConexoes];
                conexoesCriadas = new Connection[PersistenceMechanism.numConexoes];
                for (int i = 0; i < PersistenceMechanism.numConexoes; i++) { //1
                    conexoesCriadas[i] = DriverManager.getConnection(url, user, password);
                    conexoesLivres[i] = conexoesCriadas[i];
                }
            } catch (Exception e) { //1
                e.printStackTrace();
                throw new PersistenceMechanismException(ExceptionMessages.EXC_CONECTAR);
            }
        }
    }
    public synchronized void commitTransaction() throws TransactionException
    {
        try { //1
            Connection con = (Connection) getCommunicationChannel(true);
            con.commit();
            con.setAutoCommit(true);
            releaseCommunicationChannel(true);
        } catch (Exception e) { //1
            e.printStackTrace();
            throw new TransactionException("EXC_CONFIRMAR_TRANSACAO");
        } finally {
            notifyAll();
        }
    }
    public static synchronized PersistenceMechanism getInstance()
    throws PersistenceMechanismException
    {
        if(singleton == null)//1
            singleton = new PersistenceMechanism(Constants.DB_URL, Constants.DB_LOGIN,
                                                 Constants.DB_PASS, Constants.DB_DRIVER);
        return singleton;
    }
    public synchronized PreparedStatement getPreparedStatement(String sql)
    throws PersistenceMechanismException
    {
        try { //1
            return getCommunicationChannel(false).prepareStatement(sql);
        } catch (SQLException ex) { //1
            throw new PersistenceMechanismException("SQLException: " + ex.getMessage());
        }
    }
    public synchronized Object getCommunicationChannel() throws PersistenceMechanismException
    {
        try { //1
            return getCommunicationChannel(false).createStatement();
        } catch (Exception ex) { //1
            ex.printStackTrace();
            throw new PersistenceMechanismException(
                ExceptionMessages.EXC_FALHA_GET_CANAL_COMUNICACAO);
        }
    }
    private PersistenceMechanism(String url, String user, String password, String driverClass)
    throws PersistenceMechanismException
    {
        conexoesAlocadas = new HashMap();
        this.url = url;
        this.user = user;
        this.password = password;
        indisponivel = false;
        try { //1
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) { //1
            throw new PersistenceMechanismException("EXC_CLASSE_NAO_ENCONTRADA");
        }
    }
    public synchronized void rollbackTransaction() throws TransactionException
    {
        try { //1
            Connection con = (Connection) getCommunicationChannel(true);
            con.rollback();
            con.setAutoCommit(true);
            releaseCommunicationChannel(true);
        } catch (Exception e) { //1
            e.printStackTrace();
            throw new TransactionException("EXC_CANCELAR_TRANSACAO");
        } finally {
            try { //1
                notifyAll();
            } catch (Exception e) { //1
                e.printStackTrace();
            }
        }
    }
    public synchronized void releaseCommunicationChannel() throws PersistenceMechanismException
    {
        releaseCommunicationChannel(false);
    }
    public synchronized void disconnect() throws PersistenceMechanismException
    {
        try { //1
            if(conexoesCriadas != null) { //1
                int fechadas = 0;
                for (int i = 0; i < PersistenceMechanism.numConexoes; i++) { //1
                    System.out.println("Conexao " + i + " " + conexoesLivres[i]);
                }
                System.out.println("Conexoes alocadas " + conexoesAlocadas.size());
                for (int i = 0; i < PersistenceMechanism.numConexoes; i++) { //2
                    if(conexoesCriadas[i] != null) { //1
                        conexoesCriadas[i].close();
                        fechadas++;
                    }
                }
                conexoesCriadas = null;
                System.out.println("Foram fechadas " + fechadas + " conexoes");
            }
        } catch (Exception e) { //1
            e.printStackTrace();
            throw new PersistenceMechanismException(ExceptionMessages.EXC_FALHA_DESCONECTAR);
        }
    }
    private synchronized Connection getCommunicationChannel(boolean porTransacao)
    throws PersistenceMechanismException
    {
        Connection resposta = null;
        try { //1
            Thread currentThread = Thread.currentThread();
            int threadId = currentThread.hashCode();
            if(conexoesAlocadas.containsKey("" + threadId)) { //1
                resposta = (Connection) conexoesAlocadas.get("" + threadId);
            } else {
                boolean achou = false;
                do {
                    if(achou) { //1
                        break;

                    }
                    for (int i = 0; !achou && i < PersistenceMechanism.numConexoes; i++) { //1
                        if(conexoesLivres[i] == null) { //1
                            continue;
                        }
                        achou = true;
                        resposta = conexoesLivres[i];
                        conexoesLivres[i] = null;
                        conexoesAlocadas.put("" + threadId, resposta);
                        if(porTransacao) { //1
                            conexoesAlocadas.put("T" + threadId, null);
                        }
                    }
                    if(!achou) { //1
                        indisponivel = true;
                        wait();
                    }
                } while (true); //1
            }
        } catch (Exception ex) { //1
            ex.printStackTrace();
            throw new PersistenceMechanismException(
                ExceptionMessages.EXC_FALHA_GET_CANAL_COMUNICACAO);
        }
        return resposta;
    }
    public synchronized void beginTransaction() throws TransactionException
    {
        try { //1
            while (indisponivel) { //1
                wait();
            }
            Connection con = (Connection) getCommunicationChannel(true);
            con.setAutoCommit(false);
        } catch (Exception e) { //1
            e.printStackTrace();
            throw new TransactionException("EXC_INICIAR_TRANSACAO");
        }
    }

}
