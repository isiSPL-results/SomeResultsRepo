// Compilation Unit of /EmployeeRepositoryRDB.java 
 
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

//#if 1700647816 
import lib.exceptions.PersistenceSoftException;
//#endif 

import lib.persistence.IPersistenceMechanism;

//#if -1709926557 
import lib.exceptions.RepositoryException;
//#endif 


//#if -2032027449 
import lib.exceptions.SQLPersistenceMechanismException;
//#endif 

public class EmployeeRepositoryRDB implements IEmployeeRepository
  { 
private IPersistenceMechanism pm;
protected ResultSet resultSet;
public EmployeeRepositoryRDB(IPersistenceMechanism pm)
    { 
this.pm = pm;
} 


//#if 1673421802 
public boolean exists(String login) throws RepositoryException
    { 
boolean response = false;
String sql = null;
try //1
{ 
sql = "select * from SCBS_funcionario where login='" + login + "'";
Statement stmt = (Statement) this.pm.getCommunicationChannel();
resultSet = stmt.executeQuery(sql);
response = resultSet.next();
resultSet.close();
stmt.close();
} 
catch (PersistenceMechanismException e) //1
{ 
throw new RepositoryException(e.getMessage());
} 

catch (SQLException e) //1
{ 
throw new SQLPersistenceMechanismException(e.getMessage(),sql);
} 


return response;
} 

//#endif 

public void remove(String login) throws ObjectNotFoundException
    {
}

//#if -1729574802 
public boolean exists(String login)
    { 
boolean response = false;
String sql = null;
try //1
{ 
sql = "select * from SCBS_funcionario where login='" + login + "'";
Statement stmt = (Statement) this.pm.getCommunicationChannel();
resultSet = stmt.executeQuery(sql);
response = resultSet.next();
resultSet.close();
stmt.close();
} 

//#if 1708627606 
catch (PersistenceMechanismException e) //1
{ 
throw new PersistenceSoftException(e);
} 

//#endif 


//#if -1370145234 
catch (SQLException e) //1
{ 
System.out.println(sql);
throw new PersistenceSoftException(e);
} 

//#endif 


return response;
} 

//#endif 


//#if 1832176941 
public void insert(Employee employee) throws RepositoryException
    { 
String sql = null;
try //1
{ 
sql = "insert into SCBS_funcionario (login,nome,senha) values ('";
sql += employee.getLogin() + "',";
sql += "'" + employee.getName() + "',";
sql += "'" + employee.getPassword() + "')";
Statement stmt = (Statement) this.pm.getCommunicationChannel();
stmt.executeUpdate(sql);
stmt.close();
} 
catch (PersistenceMechanismException e) //1
{ 
throw new RepositoryException(e.getMessage());
} 

catch (SQLException e) //1
{ 
throw new SQLPersistenceMechanismException(e.getMessage(),sql);
} 


} 

//#endif 


//#if 2022341005 
public void update(Employee employee) throws ObjectNotFoundException, ObjectNotValidException, RepositoryException
    { 
String sql = null;
try //1
{ 
sql = "UPDATE SCBS_funcionario SET senha='" + employee.getPassword() + "', nome='"
                  + employee.getName() + "' where login='" + employee.getLogin() + "'";
Statement stmt = (Statement) this.pm.getCommunicationChannel();
stmt.executeUpdate(sql);
stmt.close();
} 
catch (PersistenceMechanismException e) //1
{ 
throw new RepositoryException(e.getMessage());
} 

catch (SQLException e) //1
{ 
throw new SQLPersistenceMechanismException(e.getMessage(),sql);
} 


} 

//#endif 


//#if 680374731 
public void insert(Employee employee)
    { 
String sql = null;
try //1
{ 
sql = "insert into SCBS_funcionario (login,nome,senha) values ('";
sql += employee.getLogin() + "',";
sql += "'" + employee.getName() + "',";
sql += "'" + employee.getPassword() + "')";
Statement stmt = (Statement) this.pm.getCommunicationChannel();
stmt.executeUpdate(sql);
stmt.close();
} 

//#if 1645464400 
catch (PersistenceMechanismException e) //1
{ 
throw new PersistenceSoftException(e);
} 

//#endif 


//#if -1829284300 
catch (SQLException e) //1
{ 
System.out.println(sql);
throw new PersistenceSoftException(e);
} 

//#endif 


} 

//#endif 


//#if 27218740 
public void update(Employee employee) throws ObjectNotFoundException, ObjectNotValidException
    { 
String sql = null;
try //1
{ 
sql = "UPDATE SCBS_funcionario SET senha='" + employee.getPassword() + "', nome='"
                  + employee.getName() + "' where login='" + employee.getLogin() + "'";
Statement stmt = (Statement) this.pm.getCommunicationChannel();
stmt.executeUpdate(sql);
stmt.close();
} 

//#if -1092832381 
catch (PersistenceMechanismException e) //1
{ 
throw new PersistenceSoftException(e);
} 

//#endif 


//#if -365849183 
catch (SQLException e) //1
{ 
System.out.println(sql);
throw new PersistenceSoftException(e);
} 

//#endif 


} 

//#endif 


//#if -890623254 
public Employee search(String login) throws ObjectNotFoundException
    { 
Employee employee = null;
String sql = null;
try //1
{ 
sql = "select * from SCBS_funcionario where login='" + login + "'";
Statement stmt = (Statement) this.pm.getCommunicationChannel();
resultSet = stmt.executeQuery(sql);
if(resultSet.next())//1
{ 
employee = new Employee(resultSet.getString("login"), resultSet.getString("senha"),
                                        resultSet.getString("nome"));
} 
else
{ 
System.out.println("not found " + login);
throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
} 

resultSet.close();
stmt.close();
} 

//#if 1606253280 
catch (PersistenceMechanismException e) //1
{ 
throw new PersistenceSoftException(e);
} 

//#endif 


//#if -67349340 
catch (SQLException e) //1
{ 
System.out.println(sql);
throw new PersistenceSoftException(e);
} 

//#endif 


return employee;
} 

//#endif 


//#if 599939651 
public Employee search(String login) throws ObjectNotFoundException, RepositoryException
    { 
Employee employee = null;
String sql = null;
try //1
{ 
sql = "select * from SCBS_funcionario where login='" + login + "'";
Statement stmt = (Statement) this.pm.getCommunicationChannel();
resultSet = stmt.executeQuery(sql);
if(resultSet.next())//1
{ 
employee = new Employee(resultSet.getString("login"), resultSet.getString("senha"),
                                        resultSet.getString("nome"));
} 
else
{ 
System.out.println("not found " + login);
throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
} 

resultSet.close();
stmt.close();
} 
catch (PersistenceMechanismException e) //1
{ 
throw new RepositoryException(e.getMessage());
} 

catch (SQLException e) //1
{ 
throw new SQLPersistenceMechanismException(e.getMessage(),sql);
} 


return employee;
} 

//#endif 

 } 


