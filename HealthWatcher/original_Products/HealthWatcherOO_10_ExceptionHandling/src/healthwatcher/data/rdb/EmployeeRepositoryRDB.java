package healthwatcher.data.rdb;

import healthwatcher.data.IEmployeeRepository;
import healthwatcher.model.employee.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lib.exceptions.ExceptionMessages;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.PersistenceMechanismException;
import lib.exceptions.RepositoryException;
import lib.exceptions.SQLPersistenceMechanismException;
import lib.persistence.IPersistenceMechanism;



public class EmployeeRepositoryRDB implements IEmployeeRepository
{

    private IPersistenceMechanism pm;

    protected ResultSet resultSet; //Para consultas apenas

    public EmployeeRepositoryRDB(IPersistenceMechanism pm)
    {
        this.pm = pm;
    }

    public void insert(Employee employee) throws RepositoryException
    {
        String sql = null;
        try {
            //Inserir na tabela agora
            sql = "insert into SCBS_funcionario (login,nome,senha) values ('";

            sql += employee.getLogin() + "',";
            sql += "'" + employee.getName() + "',";
            sql += "'" + employee.getPassword() + "')";

            Statement stmt = (Statement) this.pm.getCommunicationChannel();
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (PersistenceMechanismException e) {
            throw new RepositoryException(e.getMessage());
        } catch (SQLException e) {
            throw new SQLPersistenceMechanismException(e.getMessage(),sql);
        }
    }

    public Employee search(String login) throws ObjectNotFoundException, RepositoryException
    {
        Employee employee = null;
        String sql = null;
        try {

            sql = "select * from SCBS_funcionario where login='" + login + "'";

            Statement stmt = (Statement) this.pm.getCommunicationChannel();
            resultSet = stmt.executeQuery(sql);
            if (resultSet.next()) {
                employee = new Employee(resultSet.getString("login"), resultSet.getString("senha"),
                                        resultSet.getString("nome"));
            } else {
                System.out.println("not found " + login);
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
            }
            resultSet.close();
            stmt.close();
        } catch (PersistenceMechanismException e) {
            throw new RepositoryException(e.getMessage());
        } catch (SQLException e) {
            throw new SQLPersistenceMechanismException(e.getMessage(),sql);
        }
        return employee;
    }

    public boolean exists(String login) throws RepositoryException
    {
        boolean response = false;
        String sql = null;
        try {
            sql = "select * from SCBS_funcionario where login='" + login + "'";

            Statement stmt = (Statement) this.pm.getCommunicationChannel();
            resultSet = stmt.executeQuery(sql);
            response = resultSet.next();
            resultSet.close();
            stmt.close();
        } catch (PersistenceMechanismException e) {
            throw new RepositoryException(e.getMessage());
        } catch (SQLException e) {
            throw new SQLPersistenceMechanismException(e.getMessage(),sql);
        }
        return response;
    }

    public void update(Employee employee) throws ObjectNotFoundException, ObjectNotValidException, RepositoryException
    {
        String sql = null;
        try {
            //Inserir na tabela agora
            sql = "UPDATE SCBS_funcionario SET senha='" + employee.getPassword() + "', nome='"
                  + employee.getName() + "' where login='" + employee.getLogin() + "'";
            Statement stmt = (Statement) this.pm.getCommunicationChannel();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (PersistenceMechanismException e) {
            throw new RepositoryException(e.getMessage());
        } catch (SQLException e) {
            throw new SQLPersistenceMechanismException(e.getMessage(),sql);
        }
    }

    public void remove(String login) throws ObjectNotFoundException
    {

    }
}
