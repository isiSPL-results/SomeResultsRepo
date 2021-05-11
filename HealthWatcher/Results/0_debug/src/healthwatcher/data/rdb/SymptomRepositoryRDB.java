
//#if 2040589001
// Compilation Unit of /SymptomRepositoryRDB.java


//#if -1596153488
package healthwatcher.data.rdb;
//#endif


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


//#if 875429783
public class SymptomRepositoryRDB implements
//#if -396732809
    ISymptomRepository
//#endif

{

//#if -2142404885
    private IPersistenceMechanism mp;
//#endif


//#if -1864782715
    private ResultSet resultSet;
//#endif


//#if -1525496189
    public IteratorDsk getSymptomList() throws ObjectNotFoundException, RepositoryException
    {

//#if 309460853
        List listaSymptom = new ArrayList();
//#endif


//#if 1458455491
        String    sql = "SELECT * FROM SCBS_sintoma";
//#endif


//#if 1517059826
        ResultSet rs  = null;
//#endif


//#if 899091344
        Symptom symptom;
//#endif


//#if -1376973887
        try { //1

//#if -1495314833
            Statement stmt = (Statement)this.mp.getCommunicationChannel();
//#endif


//#if -1484953004
            rs = stmt.executeQuery(sql);
//#endif


//#if -739703267
            if(rs.next()) { //1

//#if -2095549628
                symptom = search((new Integer(rs.getString("codigo"))).intValue());
//#endif


//#if -1565396529
                listaSymptom.add(symptom);
//#endif

            } else {

//#if -1550182176
                throw new ObjectNotFoundException(ExceptionMessages
                                                  .EXC_FALHA_PROCURA);
//#endif

            }

//#endif


//#if 924531731
            while (rs.next()) { //1

//#if -986732735
                symptom = search((new Integer(rs.getString("codigo"))).intValue());
//#endif


//#if -85369972
                listaSymptom.add(symptom);
//#endif

            }

//#endif


//#if -959195728
            rs.close();
//#endif


//#if 275912649
            stmt.close();
//#endif

        }

//#if 1241546805
        catch (PersistenceMechanismException e) { //1

//#if -475002190
            e.printStackTrace();
//#endif


//#if 8678867
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif

        }

//#endif


//#if -1776269649
        catch (SQLException e) { //1

//#if -1784258741
            System.out.println(sql);
//#endif


//#if -1058786212
            e.printStackTrace();
//#endif


//#if 1457713257
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif


//#if 1011839751
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_PROCURA,sql);
//#endif

        }

//#endif

        finally {

//#if 719623125
            try { //1

//#if -481876899
                mp.releaseCommunicationChannel();
//#endif

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


//#endif

        }

//#endif


//#if -2086555064
        return new ConcreteIterator(listaSymptom);
//#endif

    }

//#endif


//#if 1120555160
    public SymptomRepositoryRDB(IPersistenceMechanism mp)
    {

//#if -577827247
        this.mp = mp;
//#endif

    }

//#endif


//#if 1110684911
    public void update(Symptom symptom) throws ObjectNotValidException, ObjectNotFoundException,
               ObjectNotValidException, RepositoryException
    {

//#if 414826513
        if(symptom != null) { //1

//#if -832356494
            String sql=null;
//#endif


//#if 278190392
            try { //1

//#if -1035047665
                Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if -685838455
                sql = "update SCBS_sintoma set " +
                      "descricao='" + symptom.getDescription() + "'" +
                      " where codigo = '"+symptom.getCode()+"'";
//#endif


//#if -58231793
                stmt.executeUpdate(sql);
//#endif


//#if 1092079209
                stmt.close();
//#endif

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

//#if -1574426116
                throw new RepositoryException(ExceptionMessages.EXC_FALHA_ATUALIZACAO);
//#endif

            }

//#endif

            finally {

//#if 2132349237
                try { //1

//#if 97356823
                    mp.releaseCommunicationChannel();
//#endif

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


//#endif

            }

//#endif

        } else {

//#if 352822902
            throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
//#endif

        }

//#endif

    }

//#endif


//#if 999870792
    public void insert(Symptom symptom) throws ObjectNotValidException, ObjectAlreadyInsertedException,
        ObjectNotValidException, RepositoryException
    {

//#if -1703363137
        if(symptom != null) { //1

//#if -1480793327
            String sql=null;
//#endif


//#if 2005522105
            try { //1

//#if 1509769538
                Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if -7652434
                sql = "insert into SCBS_sintoma (codigo,DESCRICAO) values ('";
//#endif


//#if 1825460377
                sql += symptom.getCode() + "','";
//#endif


//#if 1708956626
                sql += symptom.getDescription() + "')";
//#endif


//#if -2116339524
                stmt.executeUpdate(sql);
//#endif


//#if -472894500
                stmt.close();
//#endif

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

//#if -1872259294
                try { //1

//#if -221637510
                    mp.releaseCommunicationChannel();
//#endif

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


//#endif

            }

//#endif

        } else {

//#if 1578405461
            throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
//#endif

        }

//#endif

    }

//#endif


//#if -151880442
    public void remove(int code) throws ObjectNotFoundException, RepositoryException
    {
    }
//#endif


//#if -302881224
    public Symptom search(int symptomCode) throws ObjectNotFoundException, RepositoryException
    {

//#if 1678932139
        Symptom symptom = null;
//#endif


//#if -657445888
        String sql=null;
//#endif


//#if 1984685082
        Statement stmt=null;
//#endif


//#if -865667862
        try { //1

//#if -1405216663
            sql = "select * from SCBS_sintoma where "
                  + "codigo = '" + symptomCode + "'";
//#endif


//#if 1138843433
            stmt = (Statement)this.mp.getCommunicationChannel();
//#endif


//#if 1691153839
            resultSet  = stmt.executeQuery(sql);
//#endif


//#if 1241988646
            if(resultSet.next()) { //1

//#if -47645975
                symptom = new Symptom(resultSet.getString("descricao"));
//#endif


//#if -1335603977
                symptom.setCode((new Integer(resultSet.getString("codigo"))).intValue());
//#endif

            } else {

//#if -1007440880
                throw new ObjectNotFoundException(ExceptionMessages
                                                  .EXC_FALHA_PROCURA);
//#endif

            }

//#endif


//#if 1450729397
            resultSet.close();
//#endif


//#if -323899650
            stmt.close();
//#endif

        }

//#if 1762647948
        catch (PersistenceMechanismException e) { //1

//#if -2017641986
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#if -140324232
        catch (SQLException e) { //1

//#if 473542233
            System.out.println(sql);
//#endif


//#if -1163576726
            e.printStackTrace();
//#endif


//#if -1623942439
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if 1810492323
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

        }

//#endif

        finally {

//#if 310869568
            try { //1

//#if -593438905
                mp.releaseCommunicationChannel();
//#endif

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


//#endif

        }

//#endif


//#if 625954454
        return symptom;
//#endif

    }

//#endif


//#if 742057009
    public boolean exists(int code) throws RepositoryException
    {

//#if 832917150
        boolean response = false;
//#endif


//#if 186453698
        String sql=null;
//#endif


//#if 1925550056
        try { //1

//#if 1581321463
            sql = "select * from SCBS_sintoma where " + "codigo = '" + code + "'";
//#endif


//#if 1497385141
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if -1371647808
            resultSet  = stmt.executeQuery(sql);
//#endif


//#if -1287423589
            response = resultSet.next();
//#endif


//#if 266888388
            resultSet.close();
//#endif


//#if 1307081871
            stmt.close();
//#endif

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


//#endif


//#if 1110051832
        return response;
//#endif

    }

//#endif

}

//#endif


//#endif

