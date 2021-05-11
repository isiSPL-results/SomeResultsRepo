package healthwatcher.data.rdb;
import healthwatcher.data.IAddressRepository;
import healthwatcher.model.address.Address;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lib.exceptions.ExceptionMessages;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.PersistenceMechanismException;
import lib.exceptions.RepositoryException;
import lib.persistence.IPersistenceMechanism;
import lib.exceptions.SQLPersistenceMechanismException;
public class AddressRepositoryRDB implements IAddressRepository
{
    private IPersistenceMechanism mp;
    private ResultSet resultSet;
    public boolean exists(int codigo) throws RepositoryException
    {
        return false;
    }
    public void update(Address end) throws RepositoryException, ObjectNotFoundException
    {
    } public Address search(int code) throws RepositoryException, ObjectNotFoundException
    {
        Address end = null;
        String sql = null;
        try { //1
            sql = "select * from SCBS_endereco where " + " codigo = '" + code + "'";
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
            resultSet = stmt.executeQuery(sql);
            if(resultSet.next()) { //1
                code = (new Integer(resultSet.getString("codigo"))).intValue();
                String rua = resultSet.getString("rua");
                String complemento = resultSet.getString("complemento");
                String cep = resultSet.getString("cep");
                String uf = resultSet.getString("uf");
                String fone = resultSet.getString("fone");
                String cidade = resultSet.getString("cidade");
                String bairro = resultSet.getString("bairro");
                end = new Address(rua, complemento, cep, uf, fone, cidade, bairro);
                end.setCode(code);
            } else {
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
            }
            resultSet.close();
            stmt.close();
        } catch (PersistenceMechanismException e) { //1
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
        } catch (SQLException e) { //1
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
        }
        return end;
    }
    public int insert(Address end) throws ObjectAlreadyInsertedException, ObjectNotValidException,
               ObjectNotValidException, RepositoryException
    {
        if(end == null) { //1
            throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
        }
        Statement stmt;
        try { //1
            String consulta = null;
            try { //1
                consulta = "select * from SCBS_endereco";
                stmt = (Statement) mp.getCommunicationChannel();
                resultSet = stmt.executeQuery(consulta);
                int count = 0;
                while (resultSet.next()) { //1
                    count++;
                }
                end.setCode(count + 1);
                count++;
                resultSet.close();
                stmt.close();
            } catch (SQLException e) { //1
                throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD, consulta);
            }
            String sql = null;
            try { //2
                stmt = (Statement) mp.getCommunicationChannel();
                sql = "SELECT * FROM SCBS_endereco WHERE codigo = '" + end.getCode() + "'";
                resultSet = stmt.executeQuery(sql);
                if(resultSet.next()) { //1
                    throw new ObjectAlreadyInsertedException(ExceptionMessages.EXC_JA_EXISTE);
                }
                resultSet.close();
                stmt.close();
            } catch (SQLException e) { //1
                throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD, sql);
            }
            try { //3
                sql = "INSERT INTO SCBS_endereco VALUES(";
                sql += "'" + end.getCode() + "',";
                sql += "'" + end.getStreet() + "',";
                sql += "'" + end.getComplement() + "',";
                sql += "'" + end.getZip() + "',";
                sql += "'" + end.getState() + "',";
                sql += "'" + end.getPhone() + "',";
                sql += "'" + end.getCity() + "',";
                sql += "'" + end.getNeighbourhood() + "')";
                stmt = (Statement) this.mp.getCommunicationChannel();
                stmt.executeUpdate(sql);
                stmt.close();
            } catch (SQLException e) { //1
                throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD, sql);
            }
        } catch (PersistenceMechanismException e) { //1
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_INCLUSAO);
        }
        return -1;
    }
    public void remove(int code) throws ObjectNotFoundException, RepositoryException
    {
    } public AddressRepositoryRDB(IPersistenceMechanism mp)
    {
        this.mp = mp;
    }

}
