
//#if 717792597
// Compilation Unit of /AddressRepositoryRDB.java


//#if -511722661
package healthwatcher.data.rdb;
//#endif


//#if -1835784939
import healthwatcher.data.IAddressRepository;
//#endif


//#if 1498631193
import healthwatcher.model.address.Address;
//#endif


//#if -1757858243
import java.sql.ResultSet;
//#endif


//#if -1155417997
import java.sql.SQLException;
//#endif


//#if -1401060077
import java.sql.Statement;
//#endif


//#if -1624269028
import lib.exceptions.ExceptionMessages;
//#endif


//#if -1833109439
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if 1338945142
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 173069936
import lib.exceptions.ObjectNotValidException;
//#endif


//#if -1200550622
import lib.exceptions.PersistenceMechanismException;
//#endif


//#if 673217522
import lib.exceptions.RepositoryException;
//#endif


//#if 1330465973
import lib.persistence.IPersistenceMechanism;
//#endif


//#if 355202200
import lib.exceptions.SQLPersistenceMechanismException;
//#endif


//#if 316290849
public class AddressRepositoryRDB implements
//#if -400346367
    IAddressRepository
//#endif

{

//#if 1471354060
    private IPersistenceMechanism mp;
//#endif


//#if -678154748
    private ResultSet resultSet;
//#endif


//#if 769364862
    public boolean exists(int codigo) throws RepositoryException
    {

//#if 2106272778
        return false;
//#endif

    }

//#endif


//#if -439741535
    public void update(Address end) throws RepositoryException, ObjectNotFoundException
    {
    }
//#endif


//#if -870533985
    public Address search(int code) throws RepositoryException, ObjectNotFoundException
    {

//#if 836208917
        Address end = null;
//#endif


//#if -507528067
        String sql = null;
//#endif


//#if -2098957363
        try { //1

//#if -799057153
            sql = "select * from SCBS_endereco where " + " codigo = '" + code + "'";
//#endif


//#if -838100661
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if -416665386
            resultSet = stmt.executeQuery(sql);
//#endif


//#if 1700130317
            if(resultSet.next()) { //1

//#if 1798724308
                code = (new Integer(resultSet.getString("codigo"))).intValue();
//#endif


//#if -1810716294
                String rua = resultSet.getString("rua");
//#endif


//#if 842854682
                String complemento = resultSet.getString("complemento");
//#endif


//#if -1595981958
                String cep = resultSet.getString("cep");
//#endif


//#if -833494974
                String uf = resultSet.getString("uf");
//#endif


//#if -1486845340
                String fone = resultSet.getString("fone");
//#endif


//#if 834951900
                String cidade = resultSet.getString("cidade");
//#endif


//#if 338090394
                String bairro = resultSet.getString("bairro");
//#endif


//#if 1382070033
                end = new Address(rua, complemento, cep, uf, fone, cidade, bairro);
//#endif


//#if 1770045551
                end.setCode(code);
//#endif

            } else {

//#if -1147937357
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif

            }

//#endif


//#if 1003953006
            resultSet.close();
//#endif


//#if -1114061915
            stmt.close();
//#endif

        }

//#if -1233860348
        catch (PersistenceMechanismException e) { //1

//#if -1836126978
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#if -1467028992
        catch (SQLException e) { //1

//#if -1560039853
            System.out.println(sql);
//#endif


//#if -1827691053
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if -222628887
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

        }

//#endif


//#endif


//#if 1176334727
        return end;
//#endif

    }

//#endif


//#if 509769287
    public int insert(Address end) throws ObjectAlreadyInsertedException, ObjectNotValidException,
               ObjectNotValidException, RepositoryException
    {

//#if 687260818
        if(end == null) { //1

//#if 878651502
            throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
//#endif

        }

//#endif


//#if 1664997719
        Statement stmt;
//#endif


//#if 2123010441
        try { //1

//#if 1149893125
            String consulta = null;
//#endif


//#if -1777261410
            try { //1

//#if -1467513664
                consulta = "select * from SCBS_endereco";
//#endif


//#if 1050155095
                stmt = (Statement) mp.getCommunicationChannel();
//#endif


//#if 2009964332
                resultSet = stmt.executeQuery(consulta);
//#endif


//#if 1163802026
                int count = 0;
//#endif


//#if -242655878
                while (resultSet.next()) { //1

//#if -1217855915
                    count++;
//#endif

                }

//#endif


//#if 971357821
                end.setCode(count + 1);
//#endif


//#if -1081230966
                count++;
//#endif


//#if 938728393
                resultSet.close();
//#endif


//#if -1441401238
                stmt.close();
//#endif

            }

//#if -1440138810
            catch (SQLException e) { //1

//#if 443834946
                System.out.println(consulta);
//#endif


//#if -1475420987
                throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if 1409573008
                throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD, consulta);
//#endif

            }

//#endif


//#endif


//#if -1915853108
            String sql = null;
//#endif


//#if 1962236243
            try { //2

//#if -1135017710
                stmt = (Statement) mp.getCommunicationChannel();
//#endif


//#if -1785412963
                String sql = "SELECT * FROM SCBS_endereco WHERE codigo = '" + end.getCode() + "'";
//#endif


//#if 329557100
                sql = "SELECT * FROM SCBS_endereco WHERE codigo = '" + end.getCode() + "'";
//#endif


//#if 636696662
                resultSet = stmt.executeQuery(sql);
//#endif


//#if 1121605005
                if(resultSet.next()) { //1

//#if -1899088691
                    throw new ObjectAlreadyInsertedException(ExceptionMessages.EXC_JA_EXISTE);
//#endif

                }

//#endif


//#if 1049582
                resultSet.close();
//#endif


//#if -359625947
                stmt.close();
//#endif

            }

//#if -1397667649
            catch (SQLException e) { //1

//#if -1634346528
                throw new PersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if 497813292
                throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD, sql);
//#endif

            }

//#endif


//#endif


//#if 1962266035
            try { //3

//#if 2117125794
                String sql = "INSERT INTO SCBS_endereco VALUES(";
//#endif


//#if 67970931
                sql = "INSERT INTO SCBS_endereco VALUES(";
//#endif


//#if -1723613111
                sql += "'" + end.getCode() + "',";
//#endif


//#if 1878307551
                sql += "'" + end.getStreet() + "',";
//#endif


//#if 922084098
                sql += "'" + end.getComplement() + "',";
//#endif


//#if -1013882319
                sql += "'" + end.getZip() + "',";
//#endif


//#if -1053800159
                sql += "'" + end.getState() + "',";
//#endif


//#if 68982014
                sql += "'" + end.getPhone() + "',";
//#endif


//#if -170439225
                sql += "'" + end.getCity() + "',";
//#endif


//#if 1754659334
                sql += "'" + end.getNeighbourhood() + "')";
//#endif


//#if -1100582000
                stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if -781378687
                stmt.executeUpdate(sql);
//#endif


//#if -84911561
                stmt.close();
//#endif

            }

//#if -280721061
            catch (SQLException e) { //1

//#if 2101347243
                throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if -2000223983
                throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD, sql);
//#endif

            }

//#endif


//#endif

        }

//#if 1873134599
        catch (PersistenceMechanismException e) { //1

//#if 357467833
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_INCLUSAO);
//#endif

        }

//#endif


//#endif


//#if -1020881868
        return -1;
//#endif

    }

//#endif


//#if 1032479877
    public void remove(int code) throws ObjectNotFoundException, RepositoryException
    {
    }
//#endif


//#if -2031523452
    public AddressRepositoryRDB(IPersistenceMechanism mp)
    {

//#if 1618251394
        this.mp = mp;
//#endif

    }

//#endif

}

//#endif


//#endif

