package healthwatcher.data.rdb;
import healthwatcher.data.ISpecialityRepository;
import healthwatcher.model.healthguide.MedicalSpeciality;
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
public class SpecialityRepositoryRDB implements ISpecialityRepository
  { 
private IPersistenceMechanism mp;
protected ResultSet resultSet;
public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException
    { 
List listaEsp = new ArrayList();
String sql = "SELECT * FROM SCBS_especialidade";
ResultSet rs = null;
try//1
{ 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
rs = stmt.executeQuery(sql);
if(!rs.next())//1
{ 
throw new ObjectNotFoundException("");
} 
do{ 
MedicalSpeciality esp = search((new Integer(rs.getString("codigo"))).intValue());
listaEsp.add(esp);
} 
 while (rs.next());//1
rs.close();
stmt.close();
} 
catch (PersistenceMechanismException e) //1
{ 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
} 
catch (SQLException e) //1
{ 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_PROCURA,sql);
} 
finally { 
try//1
{ 
mp.releaseCommunicationChannel();
} 
catch (PersistenceMechanismException e) //1
{ 
throw new RepositoryException(e.getMessage());
} 
} 
return new ConcreteIterator(listaEsp);
} 
public boolean exists(int code) throws RepositoryException
    { 
boolean response = false;
String sql=null;
try//1
{ 
sql = "select * from SCBS_especialidade where "
                  + "codigo = '" + code + "'";
Statement stmt = (Statement) this.mp.getCommunicationChannel();
resultSet  = stmt.executeQuery(sql);
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
public void insert(MedicalSpeciality spec) throws RepositoryException,
        ObjectAlreadyInsertedException, ObjectNotValidException
    { 
if(spec != null)//1
{ 
String sql = null;
try//1
{ 
Statement stmt = (Statement) mp.getCommunicationChannel();
sql = "insert into SCBS_especialidade (codigo,descricao) values (";
sql += spec.getCodigo() + ",'";
sql += spec.getDescricao() + "')";
stmt.executeUpdate(sql);
stmt.close();
} 
catch (SQLException e) //1
{ 
throw new SQLPersistenceMechanismException(e.getMessage(),sql);
} 
catch (PersistenceMechanismException e) //1
{ 
throw new RepositoryException(e.getMessage());
} 
finally { 
try//1
{ 
mp.releaseCommunicationChannel();
} 
catch (PersistenceMechanismException e) //1
{ 
throw new RepositoryException(e.getMessage());
} 
} 
} 
else
{ 
throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
} 
} 
public SpecialityRepositoryRDB(IPersistenceMechanism mp)
    { 
this.mp = mp;
} 
public void remove(int code) throws RepositoryException, ObjectNotFoundException
    {
}public void update(MedicalSpeciality esp) throws RepositoryException, ObjectNotFoundException,
               ObjectNotValidException
    { 
if(esp != null)//1
{ 
String sql=null;
try//1
{ 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
sql = "update SCBS_especialidade set " +
                      "descricao='" + esp.getDescricao() + "'" +
                      " where codigo = '"+esp.getCodigo()+"'";
stmt.executeUpdate(sql);
stmt.close();
} 
catch (SQLException sqlException) //1
{ 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
} 
catch (PersistenceMechanismException mpException) //1
{ 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_ATUALIZACAO);
} 
finally { 
try//1
{ 
mp.releaseCommunicationChannel();
} 
catch (PersistenceMechanismException e) //1
{ 
throw new RepositoryException(e.getMessage());
} 
} 
} 
else
{ 
throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
} 
} 
public MedicalSpeciality search(int code) throws RepositoryException, ObjectNotFoundException
    { 
MedicalSpeciality esp = null;
String sql = null;
try//1
{ 
sql = "select * from SCBS_especialidade where " + "codigo = '" + code + "'";
Statement stmt = (Statement) this.mp.getCommunicationChannel();
resultSet = stmt.executeQuery(sql);
if(resultSet.next())//1
{ 
esp = new MedicalSpeciality(resultSet.getString("descricao"));
esp.setCodigo((new Integer(resultSet.getString("codigo"))).intValue());
} 
else
{ 
throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
} 
resultSet.close();
stmt.close();
} 
catch (PersistenceMechanismException e) //1
{ 
e.printStackTrace();
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
} 
catch (java.sql.SQLException e) //1
{ 
e.printStackTrace();
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
} 
finally { 
try//1
{ 
mp.releaseCommunicationChannel();
} 
catch (PersistenceMechanismException e) //1
{ 
throw new RepositoryException(e.getMessage());
} 
} 
return esp;
} 

 } 
