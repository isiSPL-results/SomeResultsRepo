
//#if -1560550994
// Compilation Unit of /EmployeeRepositoryRDB.java


//#if -873833334
package healthwatcher.data.rdb;
//#endif


//#if -187460324
import healthwatcher.data.IEmployeeRepository;
//#endif


//#if -974263980
import healthwatcher.model.employee.Employee;
//#endif


//#if 906777518
import java.sql.ResultSet;
//#endif


//#if 1422973282
import java.sql.SQLException;
//#endif


//#if 1263575684
import java.sql.Statement;
//#endif


//#if -710548787
import lib.exceptions.ExceptionMessages;
//#endif


//#if 712354151
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if -453521055
import lib.exceptions.ObjectNotValidException;
//#endif


//#if 556945235
import lib.exceptions.PersistenceMechanismException;
//#endif


//#if 1700647816
import lib.exceptions.PersistenceSoftException;
//#endif


//#if 894611364
import lib.persistence.IPersistenceMechanism;
//#endif


//#if -1709926557
import lib.exceptions.RepositoryException;
//#endif


//#if -2032027449
import lib.exceptions.SQLPersistenceMechanismException;
//#endif


//#if -28305896
public class EmployeeRepositoryRDB implements
//#if -421623567
    IEmployeeRepository
//#endif

{

//#if -1258934706
    private IPersistenceMechanism pm;
//#endif


//#if -517589539
    protected ResultSet resultSet;
//#endif


//#if 1462062226
    public EmployeeRepositoryRDB(IPersistenceMechanism pm)
    {

//#if -692799194
        this.pm = pm;
//#endif

    }

//#endif


//#if 1673421802
    public boolean exists(String login) throws RepositoryException
    {

//#if 1964153062
        boolean response = false;
//#endif


//#if -155236998
        String sql = null;
//#endif


//#if -748656080
        try { //1

//#if 126368021
            sql = "select * from SCBS_funcionario where login='" + login + "'";
//#endif


//#if -1694076458
            Statement stmt = (Statement) this.pm.getCommunicationChannel();
//#endif


//#if 87103035
            resultSet = stmt.executeQuery(sql);
//#endif


//#if -923789184
            response = resultSet.next();
//#endif


//#if 1281407145
            resultSet.close();
//#endif


//#if 1619692938
            stmt.close();
//#endif

        }

//#if -1001330972
        catch (PersistenceMechanismException e) { //1

//#if -1352189124
            throw new RepositoryException(e.getMessage());
//#endif

        }

//#endif


//#if 521654304
        catch (SQLException e) { //1

//#if 1803086592
            throw new SQLPersistenceMechanismException(e.getMessage(),sql);
//#endif

        }

//#endif


//#endif


//#if 768361136
        return response;
//#endif

    }

//#endif


//#if -653782516
    public void remove(String login) throws ObjectNotFoundException
    {
    }
//#endif


//#if -1729574802
    public boolean exists(String login)
    {

//#if -1145481021
        boolean response = false;
//#endif


//#if -1889668035
        String sql = null;
//#endif


//#if 146048013
        try { //1

//#if 375790178
            sql = "select * from SCBS_funcionario where login='" + login + "'";
//#endif


//#if -1452019351
            Statement stmt = (Statement) this.pm.getCommunicationChannel();
//#endif


//#if -1240897650
            resultSet = stmt.executeQuery(sql);
//#endif


//#if 1782468237
            response = resultSet.next();
//#endif


//#if 561531830
            resultSet.close();
//#endif


//#if -1543731619
            stmt.close();
//#endif

        }

//#if 1708627606
        catch (PersistenceMechanismException e) { //1

//#if -1980014076
            throw new PersistenceSoftException(e);
//#endif

        }

//#endif


//#if -1370145234
        catch (SQLException e) { //1

//#if -958759078
            System.out.println(sql);
//#endif


//#if 1539534849
            throw new PersistenceSoftException(e);
//#endif

        }

//#endif


//#endif


//#if -966069901
        return response;
//#endif

    }

//#endif


//#if 1832176941
    public void insert(Employee employee) throws RepositoryException
    {

//#if -780078581
        String sql = null;
//#endif


//#if 549201535
        try { //1

//#if 691910126
            sql = "insert into SCBS_funcionario (login,nome,senha) values ('";
//#endif


//#if -974102374
            sql += employee.getLogin() + "',";
//#endif


//#if -1488227340
            sql += "'" + employee.getName() + "',";
//#endif


//#if 1826830145
            sql += "'" + employee.getPassword() + "')";
//#endif


//#if -2001120541
            Statement stmt = (Statement) this.pm.getCommunicationChannel();
//#endif


//#if -1686031263
            stmt.executeUpdate(sql);
//#endif


//#if 947064151
            stmt.close();
//#endif

        }

//#if 447974147
        catch (PersistenceMechanismException e) { //1

//#if -1341675063
            throw new RepositoryException(e.getMessage());
//#endif

        }

//#endif


//#if -656224735
        catch (SQLException e) { //1

//#if 1735384816
            throw new SQLPersistenceMechanismException(e.getMessage(),sql);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if 2022341005
    public void update(Employee employee) throws ObjectNotFoundException, ObjectNotValidException, RepositoryException
    {

//#if -1973120788
        String sql = null;
//#endif


//#if 1235031678
        try { //1

//#if -192997298
            sql = "UPDATE SCBS_funcionario SET senha='" + employee.getPassword() + "', nome='"
                  + employee.getName() + "' where login='" + employee.getLogin() + "'";
//#endif


//#if -1670549691
            Statement stmt = (Statement) this.pm.getCommunicationChannel();
//#endif


//#if 1481784127
            stmt.executeUpdate(sql);
//#endif


//#if -2109627079
            stmt.close();
//#endif

        }

//#if 1401306769
        catch (PersistenceMechanismException e) { //1

//#if -1433916632
            throw new RepositoryException(e.getMessage());
//#endif

        }

//#endif


//#if -982248237
        catch (SQLException e) { //1

//#if 677615302
            throw new SQLPersistenceMechanismException(e.getMessage(),sql);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if 680374731
    public void insert(Employee employee)
    {

//#if -1194820576
        String sql = null;
//#endif


//#if -328335158
        try { //1

//#if 1504886153
            sql = "insert into SCBS_funcionario (login,nome,senha) values ('";
//#endif


//#if -574373089
            sql += employee.getLogin() + "',";
//#endif


//#if 1197557583
            sql += "'" + employee.getName() + "',";
//#endif


//#if -1663441636
            sql += "'" + employee.getPassword() + "')";
//#endif


//#if -1188144514
            Statement stmt = (Statement) this.pm.getCommunicationChannel();
//#endif


//#if -467788122
            stmt.executeUpdate(sql);
//#endif


//#if 522312754
            stmt.close();
//#endif

        }

//#if 1645464400
        catch (PersistenceMechanismException e) { //1

//#if 163825
            throw new PersistenceSoftException(e);
//#endif

        }

//#endif


//#if -1829284300
        catch (SQLException e) { //1

//#if 865238569
            System.out.println(sql);
//#endif


//#if 1247850576
            throw new PersistenceSoftException(e);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if 27218740
    public void update(Employee employee) throws ObjectNotFoundException, ObjectNotValidException
    {

//#if 1565580920
        String sql = null;
//#endif


//#if 1165302642
        try { //1

//#if -1337512788
            sql = "UPDATE SCBS_funcionario SET senha='" + employee.getPassword() + "', nome='"
                  + employee.getName() + "' where login='" + employee.getLogin() + "'";
//#endif


//#if 1511090471
            Statement stmt = (Statement) this.pm.getCommunicationChannel();
//#endif


//#if -303672163
            stmt.executeUpdate(sql);
//#endif


//#if -25183589
            stmt.close();
//#endif

        }

//#if -1092832381
        catch (PersistenceMechanismException e) { //1

//#if 629705442
            throw new PersistenceSoftException(e);
//#endif

        }

//#endif


//#if -365849183
        catch (SQLException e) { //1

//#if -2141823723
            System.out.println(sql);
//#endif


//#if 185699644
            throw new PersistenceSoftException(e);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if -890623254
    public Employee search(String login) throws ObjectNotFoundException
    {

//#if -611849698
        Employee employee = null;
//#endif


//#if 694087657
        String sql = null;
//#endif


//#if -529172767
        try { //1

//#if -567155357
            sql = "select * from SCBS_funcionario where login='" + login + "'";
//#endif


//#if 638630600
            Statement stmt = (Statement) this.pm.getCommunicationChannel();
//#endif


//#if 1073981869
            resultSet = stmt.executeQuery(sql);
//#endif


//#if 571553700
            if(resultSet.next()) { //1

//#if 1813449210
                employee = new Employee(resultSet.getString("login"), resultSet.getString("senha"),
                                        resultSet.getString("nome"));
//#endif

            } else {

//#if -1409537733
                System.out.println("not found " + login);
//#endif


//#if -822358614
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif

            }

//#endif


//#if 73133943
            resultSet.close();
//#endif


//#if -27275780
            stmt.close();
//#endif

        }

//#if 1606253280
        catch (PersistenceMechanismException e) { //1

//#if -2072336095
            throw new PersistenceSoftException(e);
//#endif

        }

//#endif


//#if -67349340
        catch (SQLException e) { //1

//#if -23650538
            System.out.println(sql);
//#endif


//#if 1656903101
            throw new PersistenceSoftException(e);
//#endif

        }

//#endif


//#endif


//#if 1920624722
        return employee;
//#endif

    }

//#endif


//#if 599939651
    public Employee search(String login) throws ObjectNotFoundException, RepositoryException
    {

//#if -548345797
        Employee employee = null;
//#endif


//#if 1294526572
        String sql = null;
//#endif


//#if 565202686
        try { //1

//#if 790732273
            sql = "select * from SCBS_funcionario where login='" + login + "'";
//#endif


//#if -827945094
            Statement stmt = (Statement) this.pm.getCommunicationChannel();
//#endif


//#if 1121515743
            resultSet = stmt.executeQuery(sql);
//#endif


//#if -1720418986
            if(resultSet.next()) { //1

//#if -1813885897
                employee = new Employee(resultSet.getString("login"), resultSet.getString("senha"),
                                        resultSet.getString("nome"));
//#endif

            } else {

//#if 1654880566
                System.out.println("not found " + login);
//#endif


//#if 523006373
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif

            }

//#endif


//#if 1143759493
            resultSet.close();
//#endif


//#if -23385554
            stmt.close();
//#endif

        }

//#if 304628345
        catch (PersistenceMechanismException e) { //1

//#if 1588136530
            throw new RepositoryException(e.getMessage());
//#endif

        }

//#endif


//#if -870374421
        catch (SQLException e) { //1

//#if 1329683434
            throw new SQLPersistenceMechanismException(e.getMessage(),sql);
//#endif

        }

//#endif


//#endif


//#if -1773903659
        return employee;
//#endif

    }

//#endif

}

//#endif


//#endif

