// Compilation Unit of /PersistenceMechanism.java 
 
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

//#if -520321587 
import lib.exceptions.ConnectionPersistenceMechanismException;
//#endif 


//#if 1324578207 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1872157707 
import lib.exceptions.SQLPersistenceMechanismException;
//#endif 

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

//#if 1281480866 
private int currentMirror = 0;
//#endif 


//#if 1200397315 
private synchronized void releaseCommunicationChannel(boolean porTransacao)
    throws RepositoryException
    { 
try //1
{ 
Thread currentThread = Thread.currentThread();
int threadId = currentThread.hashCode();
if(porTransacao || !porTransacao && !conexoesAlocadas.containsKey("T" + threadId))//1
{ 
Object canal = conexoesAlocadas.get("" + threadId);
boolean achou = false;
for (int i = 0; !achou && i < PersistenceMechanism.numConexoes; i++) //1
{ 
if(conexoesLivres[i] != null)//1
{ 
continue;
} 

achou = true;
conexoesAlocadas.remove("" + threadId);
if(conexoesAlocadas.containsKey("T" + threadId))//1
{ 
conexoesAlocadas.remove("T" + threadId);
} 

conexoesLivres[i] = (java.sql.Connection) canal;
} 

indisponivel = false;
} 

} 
catch (Exception ex) //1
{ 
ex.printStackTrace();
throw new PersistenceMechanismException(
                ExceptionMessages.EXC_FALHA_LIBERAR_CANAL_COMUNICACAO);
} 

finally { 
notifyAll();
} 

} 

//#endif 


//#if 281291859 
private synchronized void releaseCommunicationChannel(boolean porTransacao)
    throws PersistenceMechanismException
    { 
try //1
{ 
Thread currentThread = Thread.currentThread();
int threadId = currentThread.hashCode();
if(porTransacao || !porTransacao && !conexoesAlocadas.containsKey("T" + threadId))//1
{ 
Object canal = conexoesAlocadas.get("" + threadId);
boolean achou = false;
for (int i = 0; !achou && i < PersistenceMechanism.numConexoes; i++) //1
{ 
if(conexoesLivres[i] != null)//1
{ 
continue;
} 

achou = true;
conexoesAlocadas.remove("" + threadId);
if(conexoesAlocadas.containsKey("T" + threadId))//1
{ 
conexoesAlocadas.remove("T" + threadId);
} 

conexoesLivres[i] = (java.sql.Connection) canal;
} 

indisponivel = false;
} 

} 

//#if 1024305743 
catch (Exception ex) //1
{ 
ex.printStackTrace();
throw new PersistenceMechanismException(
                ExceptionMessages.EXC_FALHA_LIBERAR_CANAL_COMUNICACAO);
} 

//#endif 

finally { 
notifyAll();
} 

} 

//#endif 


//#if -1579831148 
public synchronized void connect() throws PersistenceMechanismException
    { 
if(conexoesCriadas == null)//1
{ 
try //1
{ 
conexoesLivres = new Connection[PersistenceMechanism.numConexoes];
conexoesCriadas = new Connection[PersistenceMechanism.numConexoes];
for (int i = 0; i < PersistenceMechanism.numConexoes; i++) //1
{ 
conexoesCriadas[i] = DriverManager.getConnection(url, user, password);
conexoesLivres[i] = conexoesCriadas[i];
} 

} 

//#if -397979028 
catch (Exception e) //1
{ 
e.printStackTrace();
throw new PersistenceMechanismException(ExceptionMessages.EXC_CONECTAR);
} 

//#endif 


} 

} 

//#endif 


//#if -538430534 
public synchronized void releaseCommunicationChannel() throws RepositoryException
    { 
releaseCommunicationChannel(false);
} 

//#endif 


//#if 449688126 
public void incCurrentMirror()
    { 
currentMirror = currentMirror + 1;
} 

//#endif 


//#if -959346898 
public static synchronized PersistenceMechanism getInstance(String DB_URL, String DB_LOGIN, String DB_PASS, String DB_DRIVER)
    throws RepositoryException
    { 
if(singleton == null)//1
{ 
singleton = new PersistenceMechanism(DB_URL, DB_LOGIN,DB_PASS, DB_DRIVER);
} 

return singleton;
} 

//#endif 


//#if 351452543 
private PersistenceMechanism(String url, String user, String password, String driverClass)
    throws RepositoryException
    { 
conexoesAlocadas = new HashMap();
this.url = url;
this.user = user;
this.password = password;
indisponivel = false;
try //1
{ 
Class.forName(driverClass);
} 
catch (ClassNotFoundException e) //1
{ 
throw new PersistenceMechanismException("EXC_CLASSE_NAO_ENCONTRADA");
} 


} 

//#endif 

public synchronized void commitTransaction() throws TransactionException
    { 
try //1
{ 
Connection con = (Connection) getCommunicationChannel(true);
con.commit();
con.setAutoCommit(true);
releaseCommunicationChannel(true);
} 
catch (Exception e) //1
{ 
e.printStackTrace();
throw new TransactionException("EXC_CONFIRMAR_TRANSACAO");
} 

finally { 
notifyAll();
} 

} 


//#if 1214008263 
public static synchronized PersistenceMechanism getInstance()
    throws PersistenceMechanismException
    { 
if(singleton == null)//1

//#if 2123945828 
singleton = new PersistenceMechanism(Constants.DB_URL, Constants.DB_LOGIN,
                                                 Constants.DB_PASS, Constants.DB_DRIVER);
//#endif 


return singleton;
} 

//#endif 


//#if -1822444353 
public synchronized PreparedStatement getPreparedStatement(String sql)
    throws PersistenceMechanismException
    { 
try //1
{ 
return getCommunicationChannel(false).prepareStatement(sql);
} 

//#if 116112756 
catch (SQLException ex) //1
{ 
throw new PersistenceMechanismException("SQLException: " + ex.getMessage());
} 

//#endif 


} 

//#endif 


//#if 2000288854 
public synchronized Object getCommunicationChannel() throws RepositoryException
    { 
try //1
{ 
return getCommunicationChannel(false).createStatement();
} 
catch (Exception ex) //1
{ 
incCurrentMirror();
try //1
{ 
this.connect();
return getCommunicationChannel(false).createStatement();
} 
catch (Exception ex1) //1
{ 
ex1.printStackTrace();
throw new ConnectionPersistenceMechanismException(
                    ExceptionMessages.EXC_FALHA_GET_CANAL_COMUNICACAO,this.url);
} 


} 


} 

//#endif 


//#if 468434039 
public static synchronized PersistenceMechanism getInstance()
    throws RepositoryException
    { 
if(singleton == null)//1
singleton = new PersistenceMechanism(Constants.DB_URL, Constants.DB_LOGIN,
                                                 Constants.DB_PASS, Constants.DB_DRIVER);

return singleton;
} 

//#endif 


//#if 1432322278 
public synchronized Object getCommunicationChannel() throws PersistenceMechanismException
    { 
try //1
{ 
return getCommunicationChannel(false).createStatement();
} 

//#if 1375506590 
catch (Exception ex) //1
{ 
ex.printStackTrace();
throw new PersistenceMechanismException(
                ExceptionMessages.EXC_FALHA_GET_CANAL_COMUNICACAO);
} 

//#endif 


} 

//#endif 


//#if 214519172 
public synchronized void connect() throws RepositoryException
    { 
if(conexoesCriadas == null)//1
{ 
try //1
{ 
conexoesLivres = new Connection[PersistenceMechanism.numConexoes];
conexoesCriadas = new Connection[PersistenceMechanism.numConexoes];
for (int i = 0; i < PersistenceMechanism.numConexoes; i++) //1
{ 
if(currentMirror > 0)//1
{ 
conexoesCriadas[i] = DriverManager.getConnection(url+currentMirror, user, password);
} 
else
{ 
conexoesCriadas[i] = DriverManager.getConnection(url, user, password);
} 

conexoesLivres[i] = conexoesCriadas[i];
} 

} 
catch (Exception e) //1
{ 
incCurrentMirror();
try //1
{ 
this.connect();
} 
catch (Exception ex1) //1
{ 
ex1.printStackTrace();
throw new ConnectionPersistenceMechanismException(
                        ExceptionMessages.EXC_FALHA_GET_CANAL_COMUNICACAO,this.url);
} 


} 


} 

} 

//#endif 


//#if 1887150799 
private PersistenceMechanism(String url, String user, String password, String driverClass)
    throws PersistenceMechanismException
    { 
conexoesAlocadas = new HashMap();
this.url = url;
this.user = user;
this.password = password;
indisponivel = false;
try //1
{ 
Class.forName(driverClass);
} 

//#if 949175763 
catch (ClassNotFoundException e) //1
{ 
throw new PersistenceMechanismException("EXC_CLASSE_NAO_ENCONTRADA");
} 

//#endif 


} 

//#endif 

public synchronized void rollbackTransaction() throws TransactionException
    { 
try //1
{ 
Connection con = (Connection) getCommunicationChannel(true);
con.rollback();
con.setAutoCommit(true);
releaseCommunicationChannel(true);
} 
catch (Exception e) //1
{ 
e.printStackTrace();
throw new TransactionException("EXC_CANCELAR_TRANSACAO");
} 

finally { 
try //1
{ 
notifyAll();
} 
catch (Exception e) //1
{ 
e.printStackTrace();
} 


} 

} 


//#if -2008364214 
public synchronized void releaseCommunicationChannel() throws PersistenceMechanismException
    { 
releaseCommunicationChannel(false);
} 

//#endif 


//#if -548716972 
public synchronized void disconnect() throws PersistenceMechanismException
    { 
try //1
{ 
if(conexoesCriadas != null)//1
{ 
int fechadas = 0;
for (int i = 0; i < PersistenceMechanism.numConexoes; i++) //1
{ 
System.out.println("Conexao " + i + " " + conexoesLivres[i]);
} 

System.out.println("Conexoes alocadas " + conexoesAlocadas.size());
for (int i = 0; i < PersistenceMechanism.numConexoes; i++) //2
{ 
if(conexoesCriadas[i] != null)//1
{ 
conexoesCriadas[i].close();
fechadas++;
} 

} 

conexoesCriadas = null;
System.out.println("Foram fechadas " + fechadas + " conexoes");
} 

} 

//#if -453907130 
catch (Exception e) //1
{ 
e.printStackTrace();
throw new PersistenceMechanismException(ExceptionMessages.EXC_FALHA_DESCONECTAR);
} 

//#endif 


} 

//#endif 


//#if -640777560 
private synchronized Connection getCommunicationChannel(boolean porTransacao)
    throws RepositoryException
    { 
Connection resposta = null;
try //1
{ 
Thread currentThread = Thread.currentThread();
int threadId = currentThread.hashCode();
if(conexoesAlocadas.containsKey("" + threadId))//1
{ 
resposta = (Connection) conexoesAlocadas.get("" + threadId);
} 
else
{ 
boolean achou = false;
do{ 
if(achou)//1
{ 
break;

} 

for (int i = 0; !achou && i < PersistenceMechanism.numConexoes; i++) //1
{ 
if(conexoesLivres[i] == null)//1
{ 
continue;
} 

achou = true;
resposta = conexoesLivres[i];
conexoesLivres[i] = null;
conexoesAlocadas.put("" + threadId, resposta);
if(porTransacao)//1
{ 
conexoesAlocadas.put("T" + threadId, null);
} 

} 

if(!achou)//1
{ 
indisponivel = true;
wait();
} 

} 
 while (true);//1

} 

} 
catch (Exception ex) //1
{ 
try //1
{ 
this.url = this.url + "1";
this.connect();
resposta =  this.getCommunicationChannel(porTransacao);
} 
catch (Exception ex1) //1
{ 
ex.printStackTrace();
throw new ConnectionPersistenceMechanismException(
                    ExceptionMessages.EXC_FALHA_GET_CANAL_COMUNICACAO,this.url);
} 


} 


return resposta;
} 

//#endif 


//#if -562594961 
public synchronized PreparedStatement getPreparedStatement(String sql)
    throws RepositoryException
    { 
try //1
{ 
return getCommunicationChannel(false).prepareStatement(sql);
} 
catch (SQLException ex) //1
{ 
throw new SQLPersistenceMechanismException("SQLException: " + ex.getMessage(),sql);
} 


} 

//#endif 


//#if 2139163460 
public synchronized void disconnect() throws RepositoryException
    { 
try //1
{ 
if(conexoesCriadas != null)//1
{ 
int fechadas = 0;
for (int i = 0; i < PersistenceMechanism.numConexoes; i++) //1
{ 
System.out.println("Conexao " + i + " " + conexoesLivres[i]);
} 

System.out.println("Conexoes alocadas " + conexoesAlocadas.size());
for (int i = 0; i < PersistenceMechanism.numConexoes; i++) //2
{ 
if(conexoesCriadas[i] != null)//1
{ 
conexoesCriadas[i].close();
fechadas++;
} 

} 

conexoesCriadas = null;
System.out.println("Foram fechadas " + fechadas + " conexoes");
} 

} 
catch (Exception e) //1
{ 
e.printStackTrace();
throw new PersistenceMechanismException(ExceptionMessages.EXC_FALHA_DESCONECTAR);
} 


} 

//#endif 


//#if -171587400 
private synchronized Connection getCommunicationChannel(boolean porTransacao)
    throws PersistenceMechanismException
    { 
Connection resposta = null;
try //1
{ 
Thread currentThread = Thread.currentThread();
int threadId = currentThread.hashCode();
if(conexoesAlocadas.containsKey("" + threadId))//1
{ 
resposta = (Connection) conexoesAlocadas.get("" + threadId);
} 
else
{ 
boolean achou = false;
do{ 
if(achou)//1
{ 
break;

} 

for (int i = 0; !achou && i < PersistenceMechanism.numConexoes; i++) //1
{ 
if(conexoesLivres[i] == null)//1
{ 
continue;
} 

achou = true;
resposta = conexoesLivres[i];
conexoesLivres[i] = null;
conexoesAlocadas.put("" + threadId, resposta);
if(porTransacao)//1
{ 
conexoesAlocadas.put("T" + threadId, null);
} 

} 

if(!achou)//1
{ 
indisponivel = true;
wait();
} 

} 
 while (true);//1

} 

} 

//#if -1893646847 
catch (Exception ex) //1
{ 
ex.printStackTrace();
throw new PersistenceMechanismException(
                ExceptionMessages.EXC_FALHA_GET_CANAL_COMUNICACAO);
} 

//#endif 


return resposta;
} 

//#endif 

public synchronized void beginTransaction() throws TransactionException
    { 
try //1
{ 
while (indisponivel) //1
{ 
wait();
} 

Connection con = (Connection) getCommunicationChannel(true);
con.setAutoCommit(false);
} 
catch (Exception e) //1
{ 
e.printStackTrace();
throw new TransactionException("EXC_INICIAR_TRANSACAO");
} 


} 

 } 


