package healthwatcher.data.rdb;
import healthwatcher.data.ISymptomRepository;
import healthwatcher.model.complaint.Symptom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lib.exceptions.ExceptionMessages;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.PersistenceMechanismException;
import lib.exceptions.RepositoryException;
import lib.persistence.IPersistenceMechanism;
import lib.util.ConcreteIterator;
import lib.util.IteratorDsk;
import lib.exceptions.SQLPersistenceMechanismException;
public class SymptomRepositoryRDB implements ISymptomRepository
{
    private IPersistenceMechanism mp;
    private ResultSet resultSet;
    public IteratorDsk getSymptomList() throws ObjectNotFoundException, RepositoryException
    {
        List listaSymptom = new ArrayList();
        String    sql = "SELECT * FROM SCBS_sintoma";
        ResultSet rs  = null;
        Symptom symptom;
        try { //1
            Statement stmt = (Statement)this.mp.getCommunicationChannel();
            rs = stmt.executeQuery(sql);
            if(rs.next()) { //1
                symptom = search((new Integer(rs.getString("codigo"))).intValue());
                listaSymptom.add(symptom);
            } else {
                throw new ObjectNotFoundException(ExceptionMessages
                                                  .EXC_FALHA_PROCURA);
            }
            while (rs.next()) { //1
                symptom = search((new Integer(rs.getString("codigo"))).intValue());
                listaSymptom.add(symptom);
            }
            rs.close();
            stmt.close();
        } catch (PersistenceMechanismException e) { //1
            e.printStackTrace();
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
        } catch (SQLException e) { //1
            e.printStackTrace();
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_PROCURA,sql);
        } finally {
            try { //1
                mp.releaseCommunicationChannel();
            } catch (PersistenceMechanismException e) { //1
                throw new RepositoryException(e.getMessage());
            }
        }
        return new ConcreteIterator(listaSymptom);
    }
    public SymptomRepositoryRDB(IPersistenceMechanism mp)
    {
        this.mp = mp;
    }
    public void update(Symptom symptom) throws ObjectNotValidException, ObjectNotFoundException,
               ObjectNotValidException, RepositoryException
    {
        if(symptom != null) { //1
            String sql=null;
            try { //1
                Statement stmt = (Statement) this.mp.getCommunicationChannel();
                sql = "update SCBS_sintoma set " +
                      "descricao='" + symptom.getDescription() + "'" +
                      " where codigo = '"+symptom.getCode()+"'";
                stmt.executeUpdate(sql);
                stmt.close();
            } catch (SQLException sqlException) { //1
                throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
            } catch (PersistenceMechanismException mpException) { //1
                throw new RepositoryException(ExceptionMessages.EXC_FALHA_ATUALIZACAO);
            } finally {
                try { //1
                    mp.releaseCommunicationChannel();
                } catch (PersistenceMechanismException e) { //1
                    throw new RepositoryException(e.getMessage());
                }
            }
        } else {
            throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
        }
    }
    public void insert(Symptom symptom) throws ObjectNotValidException, ObjectAlreadyInsertedException,
        ObjectNotValidException, RepositoryException
    {
        if(symptom != null) { //1
            String sql=null;
            try { //1
                Statement stmt = (Statement) this.mp.getCommunicationChannel();
                sql = "insert into SCBS_sintoma (codigo,DESCRICAO) values ('";
                sql += symptom.getCode() + "','";
                sql += symptom.getDescription() + "')";
                stmt.executeUpdate(sql);
                stmt.close();
            } catch (SQLException e) { //1
                throw new SQLPersistenceMechanismException(e.getMessage(),sql);
            } catch (PersistenceMechanismException e) { //1
                throw new RepositoryException(e.getMessage());
            } finally {
                try { //1
                    mp.releaseCommunicationChannel();
                } catch (PersistenceMechanismException e) { //1
                    throw new RepositoryException(e.getMessage());
                }
            }
        } else {
            throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
        }
    }
    public void remove(int code) throws ObjectNotFoundException, RepositoryException
    {
    } public Symptom search(int symptomCode) throws ObjectNotFoundException, RepositoryException
    {
        Symptom symptom = null;
        String sql=null;
        Statement stmt=null;
        try { //1
            sql = "select * from SCBS_sintoma where "
                  + "codigo = '" + symptomCode + "'";
            stmt = (Statement)this.mp.getCommunicationChannel();
            resultSet  = stmt.executeQuery(sql);
            if(resultSet.next()) { //1
                symptom = new Symptom(resultSet.getString("descricao"));
                symptom.setCode((new Integer(resultSet.getString("codigo"))).intValue());
            } else {
                throw new ObjectNotFoundException(ExceptionMessages
                                                  .EXC_FALHA_PROCURA);
            }
            resultSet.close();
            stmt.close();
        } catch (PersistenceMechanismException e) { //1
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
        } catch (SQLException e) { //1
            e.printStackTrace();
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
        } finally {
            try { //1
                mp.releaseCommunicationChannel();
            } catch (PersistenceMechanismException e) { //1
                throw new RepositoryException(e.getMessage());
            }
        }
        return symptom;
    }
    public boolean exists(int code) throws RepositoryException
    {
        boolean response = false;
        String sql=null;
        try { //1
            sql = "select * from SCBS_sintoma where " + "codigo = '" + code + "'";
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
            resultSet  = stmt.executeQuery(sql);
            response = resultSet.next();
            resultSet.close();
            stmt.close();
        } catch (PersistenceMechanismException e) { //1
            throw new RepositoryException(e.getMessage());
        } catch (SQLException e) { //1
            throw new SQLPersistenceMechanismException(e.getMessage(),sql);
        }
        return response;
    }

}
