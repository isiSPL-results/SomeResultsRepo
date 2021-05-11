
//#if 2040589001
// Compilation Unit of /SymptomRepositoryRDB.java

package healthwatcher.data.rdb;

//#if -1077269227
import healthwatcher.data.ISymptomRepository;
//#endif


//#if 226155778
import healthwatcher.model.complaint.Symptom;
//#endif


//#if -175106296
import java.sql.ResultSet;
//#endif


//#if 456859592
import java.sql.SQLException;
//#endif


//#if 181691870
import java.sql.Statement;
//#endif


//#if -753020066
import java.util.ArrayList;
//#endif


//#if -95141821
import java.util.List;
//#endif


//#if 1828438183
import lib.exceptions.ExceptionMessages;
//#endif


//#if -891621226
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if -79676479
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if -1245551685
import lib.exceptions.ObjectNotValidException;
//#endif


//#if -1724369363
import lib.exceptions.PersistenceMechanismException;
//#endif


//#if -1377465234
import lib.exceptions.PersistenceSoftException;
//#endif


//#if -1284872515
import lib.exceptions.RepositoryException;
//#endif


//#if 2115987978
import lib.persistence.IPersistenceMechanism;
//#endif


//#if -1763165025
import lib.util.ConcreteIterator;
//#endif


//#if 1957540118
import lib.util.IteratorDsk;
//#endif


//#if -1112724563
import lib.exceptions.SQLPersistenceMechanismException;
//#endif

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
        }

//#if 1241546805
        catch (PersistenceMechanismException e) { //1
            e.printStackTrace();
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
        }

//#endif


//#if -1776269649
        catch (SQLException e) { //1

//#if -1784258741
            System.out.println(sql);
//#endif

            e.printStackTrace();

//#if 1457713257
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif


//#if 1011839751
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_PROCURA,sql);
//#endif

        }

//#endif

        finally {
            try { //1
                mp.releaseCommunicationChannel();
            }

//#if 1895069569
            catch (PersistenceMechanismException e) { //1

//#if 1400919331
                throw new PersistenceSoftException(e);
//#endif


//#if 1824438430
                throw new RepositoryException(e.getMessage());
//#endif

            }

//#endif


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
            }

//#if 290016206
            catch (SQLException sqlException) { //1

//#if -2057574260
                System.out.println(sql);
//#endif


//#if -1884227700
                throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if -500028592
                throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

            }

//#endif


//#if 1480842083
            catch (PersistenceMechanismException mpException) { //1
                throw new RepositoryException(ExceptionMessages.EXC_FALHA_ATUALIZACAO);
            }

//#endif

            finally {
                try { //1
                    mp.releaseCommunicationChannel();
                }

//#if -2073570367
                catch (PersistenceMechanismException e) { //1

//#if 1863741106
                    throw new PersistenceSoftException(e);
//#endif


//#if 325440301
                    throw new RepositoryException(e.getMessage());
//#endif

                }

//#endif


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
            }

//#if 1890259195
            catch (SQLException e) { //1

//#if -1468971475
                System.out.println(sql);
//#endif


//#if 2036306516
                throw new PersistenceSoftException(e);
//#endif


//#if 1370098545
                throw new SQLPersistenceMechanismException(e.getMessage(),sql);
//#endif

            }

//#endif


//#if 208803689
            catch (PersistenceMechanismException e) { //1

//#if 1588779373
                throw new PersistenceSoftException(e);
//#endif


//#if 1257591528
                throw new RepositoryException(e.getMessage());
//#endif

            }

//#endif

            finally {
                try { //1
                    mp.releaseCommunicationChannel();
                }

//#if -1110959957
                catch (PersistenceMechanismException e) { //1

//#if -222208929
                    throw new PersistenceSoftException(e);
//#endif


//#if -636304422
                    throw new RepositoryException(e.getMessage());
//#endif

                }

//#endif


            }

        } else {
            throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
        }

    }

    public void remove(int code) throws ObjectNotFoundException, RepositoryException
    {
    }
    public Symptom search(int symptomCode) throws ObjectNotFoundException, RepositoryException
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
        }

//#if 1762647948
        catch (PersistenceMechanismException e) { //1
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
        }

//#endif


//#if -140324232
        catch (SQLException e) { //1

//#if 473542233
            System.out.println(sql);
//#endif

            e.printStackTrace();

//#if -1623942439
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if 1810492323
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

        }

//#endif

        finally {
            try { //1
                mp.releaseCommunicationChannel();
            }

//#if 419063091
            catch (PersistenceMechanismException e) { //1

//#if 1357802424
                throw new PersistenceSoftException(e);
//#endif


//#if 1233873459
                throw new RepositoryException(e.getMessage());
//#endif

            }

//#endif


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
        }

//#if -1600759375
        catch (PersistenceMechanismException e) { //1

//#if 1083991237
            throw new PersistenceSoftException(e);
//#endif


//#if 1403651648
            throw new RepositoryException(e.getMessage());
//#endif

        }

//#endif


//#if -717105741
        catch (SQLException e) { //1

//#if -1512916900
            System.out.println(sql);
//#endif


//#if -1875626493
            throw new PersistenceSoftException(e);
//#endif


//#if 1959959202
            throw new SQLPersistenceMechanismException(e.getMessage(),sql);
//#endif

        }

//#endif


        return response;
    }

}


//#endif

