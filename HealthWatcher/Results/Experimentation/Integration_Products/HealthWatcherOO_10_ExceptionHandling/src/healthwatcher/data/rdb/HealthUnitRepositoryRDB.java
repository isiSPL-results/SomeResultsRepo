package healthwatcher.data.rdb;
import healthwatcher.data.IHealthUnitRepository;
import healthwatcher.model.healthguide.HealthUnit;
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
public class HealthUnitRepositoryRDB implements IHealthUnitRepository
  { 
private IPersistenceMechanism mp;
private ResultSet resultSet;
private SpecialityRepositoryRDB specialityRep;
public void insert(HealthUnit hu) throws RepositoryException, ObjectAlreadyInsertedException,
        ObjectNotValidException
    { 
if(hu != null)//1
{ 
String sql = null;
try//1
{ 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
sql = "insert into SCBS_unidadesaude (codigo,DESCRICAO) values (";
sql += hu.getCode() + ",'";
sql += hu.getDescription() + "')";
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
public IteratorDsk getHealthUnitListBySpeciality(int code) throws RepositoryException,
        ObjectNotFoundException
    { 
List listaUS = new ArrayList();
String sql = "select U.codigo from "
                     + "SCBS_unidadeespecialidade R, SCBS_especialidade E, SCBS_unidadesaude U where "
                     + "E.codigo=R.codigoespecialidade AND U.codigo=R.codigounidadesaude AND "
                     + "E.codigo = '" + code + "'";
ResultSet rs = null;
try//1
{ 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
rs = stmt.executeQuery(sql);
if(rs.next())//1
{ 
HealthUnit us = new HealthUnit();
us = partialSearch((new Integer(rs.getString("codigo"))).intValue());
listaUS.add(us);
} 
else
{ 
throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
} 
while (rs.next()) //1
{ 
HealthUnit us = new HealthUnit();
us = search((new Integer(rs.getString("codigo"))).intValue());
listaUS.add(us);
} 
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
return new ConcreteIterator(listaUS);
} 
public boolean exists(int code) throws RepositoryException
    { 
boolean response = false;
String sql=null;
try//1
{ 
sql = "select * from SCBS_unidadesaude where "
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
public void update(HealthUnit us) throws RepositoryException, ObjectNotFoundException,
               ObjectNotValidException
    { 
if(us != null)//1
{ 
String sql = null;
try//1
{ 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
sql = "update SCBS_unidadesaude set " + "descricao='" + us.getDescription() + "'"
                      + " where codigo = '" + us.getCode() + "'";
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
public HealthUnitRepositoryRDB(IPersistenceMechanism mp)
    { 
this.mp = mp;
specialityRep = new SpecialityRepositoryRDB(mp);
} 
public HealthUnit search(int code) throws RepositoryException, ObjectNotFoundException
    { 
HealthUnit us = null;
String sql = null;
try//1
{ 
sql = "select * from SCBS_unidadeespecialidade where " + "codigounidadesaude = '"
                  + code + "'";
Statement stmt = (Statement) this.mp.getCommunicationChannel();
resultSet = stmt.executeQuery(sql);
List specialities = new ArrayList();
while (resultSet.next()) //1
{ 
try//1
{ 
MedicalSpeciality esp = specialityRep.search((new Integer(resultSet
                                            .getString("codigoespecialidade"))).intValue());
System.out.println("medicalspeciality: " + esp.getCodigo() + " "
                                       + esp.getDescricao());
specialities.add(esp);
} 
catch (ObjectNotFoundException ex) //1
{
}} 
resultSet.close();
stmt.close();
sql = "select * from SCBS_unidadesaude where " + "codigo = '" + code + "'";
stmt = (Statement) this.mp.getCommunicationChannel();
resultSet = stmt.executeQuery(sql);
if(resultSet.next())//1
{ 
us = new HealthUnit(resultSet.getString("descricao"), specialities);
us.setCode((new Integer(resultSet.getString("codigo"))).intValue());
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
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
} 
catch (SQLException e) //1
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
return us;
} 
public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException
    { 
List listaUs = new ArrayList();
String sql = "SELECT codigo FROM SCBS_unidadesaude";
ResultSet rs = null;
try//1
{ 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
rs = stmt.executeQuery(sql);
if(rs.next())//1
{ 
HealthUnit us = partialSearch((new Integer(rs.getString("codigo"))).intValue());
listaUs.add(us);
} 
else
{ 
throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
} 
while (rs.next()) //1
{ 
HealthUnit us = new HealthUnit();
us = search((new Integer(rs.getString("codigo"))).intValue());
listaUs.add(us);
} 
rs.close();
stmt.close();
} 
catch (PersistenceMechanismException e) //1
{ 
e.printStackTrace();
throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
} 
catch (SQLException e) //1
{ 
e.printStackTrace();
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_PROCURA,sql);
} 
return new ConcreteIterator(listaUs);
} 
public void remove(int codigo) throws RepositoryException, ObjectNotFoundException
    {
}public HealthUnit partialSearch(int codigo) throws RepositoryException, ObjectNotFoundException
    { 
HealthUnit hu = null;
String sql = null;
try//1
{ 
sql = "select * from SCBS_unidadesaude where " + "codigo = '" + codigo + "'";
Statement stmt = (Statement) this.mp.getCommunicationChannel();
resultSet = stmt.executeQuery(sql);
if(resultSet.next())//1
{ 
hu = new HealthUnit();
hu.setCode((new Integer(resultSet.getString("codigo"))).intValue());
hu.setDescription(resultSet.getString("descricao"));
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
throw new RepositoryException("PersistenceMechanismException: " + e.getMessage());
} 
catch (SQLException e) //1
{ 
throw new SQLPersistenceMechanismException("SQLException: " + e.getMessage(),sql);
} 
finally { 
try//1
{ 
mp.releaseCommunicationChannel();
} 
catch (PersistenceMechanismException e) //1
{ 
throw new RepositoryException("PersistenceMechanismException: " + e.getMessage());
} 
} 
return hu;
} 
public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException
    { 
List listaUs = new ArrayList();
String sql = "SELECT codigo FROM SCBS_unidadesaude";
ResultSet rs = null;
try//1
{ 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
rs = stmt.executeQuery(sql);
if(rs.next())//1
{ 
HealthUnit us = search((new Integer(rs.getString("codigo"))).intValue());
listaUs.add(us);
} 
else
{ 
throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
} 
while (rs.next()) //1
{ 
HealthUnit us = new HealthUnit();
us = search((new Integer(rs.getString("codigo"))).intValue());
listaUs.add(us);
} 
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
return new ConcreteIterator(listaUs);
} 

 } 
