
//#if 2070980319 
// Compilation Unit of /SpecialityRepositoryRDB.java 
 

//#if 414263708 
package healthwatcher.data.rdb;
//#endif 


//#if 574335747 
import healthwatcher.data.ISpecialityRepository;
//#endif 


//#if -1026968996 
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif 


//#if 1769612124 
import java.sql.ResultSet;
//#endif 


//#if 749454068 
import java.sql.SQLException;
//#endif 


//#if 2126410290 
import java.sql.Statement;
//#endif 


//#if -596291190 
import java.util.ArrayList;
//#endif 


//#if 674862743 
import java.util.List;
//#endif 


//#if -2074105349 
import lib.exceptions.ExceptionMessages;
//#endif 


//#if 94359490 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if -1545808363 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 1583283727 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if 939835777 
import lib.exceptions.PersistenceMechanismException;
//#endif 


//#if 417086618 
import lib.exceptions.PersistenceSoftException;
//#endif 


//#if -2122757359 
import lib.exceptions.RepositoryException;
//#endif 


//#if -1256442570 
import lib.persistence.IPersistenceMechanism;
//#endif 


//#if 1807444427 
import lib.util.ConcreteIterator;
//#endif 


//#if -1773799318 
import lib.util.IteratorDsk;
//#endif 


//#if 1521938393 
import lib.exceptions.SQLPersistenceMechanismException;
//#endif 


//#if -2101252381 
public class SpecialityRepositoryRDB implements 
//#if 1926702206 
ISpecialityRepository
//#endif 

  { 

//#if 1054778318 
private IPersistenceMechanism mp;
//#endif 


//#if 912654135 
protected ResultSet resultSet;
//#endif 


//#if -1213148738 
public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException
    { 

//#if 1225267429 
List listaEsp = new ArrayList();
//#endif 


//#if -858362202 
String sql = "SELECT * FROM SCBS_especialidade";
//#endif 


//#if -486692293 
ResultSet rs = null;
//#endif 


//#if -834268136 
try //1
{ 

//#if 623009925 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif 


//#if -378804866 
rs = stmt.executeQuery(sql);
//#endif 


//#if 128495754 
if(!rs.next())//1
{ 

//#if -1936700807 
throw new ObjectNotFoundException("");
//#endif 

} 

//#endif 


//#if -1260495522 
do{ 

//#if -551583002 
MedicalSpeciality esp = search((new Integer(rs.getString("codigo"))).intValue());
//#endif 


//#if 1157779846 
listaEsp.add(esp);
//#endif 

} 
 while (rs.next());//1

//#endif 


//#if -1702384698 
rs.close();
//#endif 


//#if -964116385 
stmt.close();
//#endif 

} 

//#if -87356431 
catch (PersistenceMechanismException e) //1
{ 

//#if 518545095 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif 

} 

//#endif 


//#if -1563337869 
catch (SQLException e) //1
{ 

//#if 1233984022 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif 


//#if -424527622 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_PROCURA,sql);
//#endif 

} 

//#endif 

finally { 

//#if 1977403391 
try //1
{ 

//#if 2015068457 
mp.releaseCommunicationChannel();
//#endif 

} 

//#if 1155660609 
catch (PersistenceMechanismException e) //1
{ 

//#if 1596388036 
throw new PersistenceSoftException(e);
//#endif 


//#if -1451088577 
throw new RepositoryException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1609093112 
return new ConcreteIterator(listaEsp);
//#endif 

} 

//#endif 


//#if -74191660 
public boolean exists(int code) throws RepositoryException
    { 

//#if 1864953418 
boolean response = false;
//#endif 


//#if -1327859562 
String sql=null;
//#endif 


//#if -403306604 
try //1
{ 

//#if 1427806084 
sql = "select * from SCBS_especialidade where "
                  + "codigo = '" + code + "'";
//#endif 


//#if -1974022066 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif 


//#if 1209968025 
resultSet  = stmt.executeQuery(sql);
//#endif 


//#if -2009073950 
response = resultSet.next();
//#endif 


//#if 1826494731 
resultSet.close();
//#endif 


//#if 1403451368 
stmt.close();
//#endif 

} 

//#if -1199835056 
catch (PersistenceMechanismException e) //1
{ 

//#if 1929184739 
throw new PersistenceSoftException(e);
//#endif 


//#if -1881233058 
throw new RepositoryException(e.getMessage());
//#endif 

} 

//#endif 


//#if -652506828 
catch (SQLException e) //1
{ 

//#if -993264568 
System.out.println(sql);
//#endif 


//#if 757790703 
throw new PersistenceSoftException(e);
//#endif 


//#if -996173258 
throw new SQLPersistenceMechanismException(e.getMessage(),sql);
//#endif 

} 

//#endif 


//#endif 


//#if -404261428 
return response;
//#endif 

} 

//#endif 


//#if -764015811 
public void insert(MedicalSpeciality spec) throws RepositoryException,
        ObjectAlreadyInsertedException, ObjectNotValidException
    { 

//#if -549044014 
if(spec != null)//1
{ 

//#if 1926590705 
String sql = null;
//#endif 


//#if -1302319911 
try //1
{ 

//#if 1531896888 
Statement stmt = (Statement) mp.getCommunicationChannel();
//#endif 


//#if 1470747909 
sql = "insert into SCBS_especialidade (codigo,descricao) values (";
//#endif 


//#if 2108349910 
sql += spec.getCodigo() + ",'";
//#endif 


//#if -1806231701 
sql += spec.getDescricao() + "')";
//#endif 


//#if 353474626 
stmt.executeUpdate(sql);
//#endif 


//#if -2078651370 
stmt.close();
//#endif 

} 

//#if 950983312 
catch (SQLException e) //1
{ 

//#if -338307096 
System.out.println(sql);
//#endif 


//#if 925393807 
throw new PersistenceSoftException(e);
//#endif 


//#if -19627370 
throw new SQLPersistenceMechanismException(e.getMessage(),sql);
//#endif 

} 

//#endif 


//#if -566097292 
catch (PersistenceMechanismException e) //1
{ 

//#if 1595576228 
throw new PersistenceSoftException(e);
//#endif 


//#if 1979376159 
throw new RepositoryException(e.getMessage());
//#endif 

} 

//#endif 

finally { 

//#if -102044632 
try //1
{ 

//#if 1218787984 
mp.releaseCommunicationChannel();
//#endif 

} 

//#if -107488304 
catch (PersistenceMechanismException e) //1
{ 

//#if 322103777 
throw new PersistenceSoftException(e);
//#endif 


//#if -177754276 
throw new RepositoryException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 
else
{ 

//#if 118397384 
throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1728036435 
public SpecialityRepositoryRDB(IPersistenceMechanism mp)
    { 

//#if -435873211 
this.mp = mp;
//#endif 

} 

//#endif 


//#if 962464195 
public void remove(int code) throws RepositoryException, ObjectNotFoundException
    {
}
//#endif 


//#if -786574189 
public void update(MedicalSpeciality esp) throws RepositoryException, ObjectNotFoundException,
               ObjectNotValidException
    { 

//#if -775978946 
if(esp != null)//1
{ 

//#if -1771351769 
String sql=null;
//#endif 


//#if 1753290723 
try //1
{ 

//#if -2098988639 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif 


//#if 425266094 
sql = "update SCBS_especialidade set " +
                      "descricao='" + esp.getDescricao() + "'" +
                      " where codigo = '"+esp.getCodigo()+"'";
//#endif 


//#if 476297405 
stmt.executeUpdate(sql);
//#endif 


//#if -730355077 
stmt.close();
//#endif 

} 

//#if -339684470 
catch (SQLException sqlException) //1
{ 

//#if 1980063746 
System.out.println(sql);
//#endif 


//#if 847670274 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif 


//#if 1504801178 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif 

} 

//#endif 


//#if 898394911 
catch (PersistenceMechanismException mpException) //1
{ 

//#if -2022795280 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_ATUALIZACAO);
//#endif 

} 

//#endif 

finally { 

//#if -2007186077 
try //1
{ 

//#if 100330098 
mp.releaseCommunicationChannel();
//#endif 

} 

//#if 70645752 
catch (PersistenceMechanismException e) //1
{ 

//#if -1492156386 
throw new PersistenceSoftException(e);
//#endif 


//#if 1520220313 
throw new RepositoryException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 
else
{ 

//#if 871018730 
throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1215256909 
public MedicalSpeciality search(int code) throws RepositoryException, ObjectNotFoundException
    { 

//#if -696877923 
MedicalSpeciality esp = null;
//#endif 


//#if 935965418 
String sql = null;
//#endif 


//#if -200270144 
try //1
{ 

//#if -2015198197 
sql = "select * from SCBS_especialidade where " + "codigo = '" + code + "'";
//#endif 


//#if 627978901 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif 


//#if -1618160992 
resultSet = stmt.executeQuery(sql);
//#endif 


//#if -1145543593 
if(resultSet.next())//1
{ 

//#if 1534166719 
esp = new MedicalSpeciality(resultSet.getString("descricao"));
//#endif 


//#if -30693736 
esp.setCodigo((new Integer(resultSet.getString("codigo"))).intValue());
//#endif 

} 
else
{ 

//#if 1328198193 
throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif 

} 

//#endif 


//#if 1650613988 
resultSet.close();
//#endif 


//#if 1935847023 
stmt.close();
//#endif 

} 

//#if -341096464 
catch (PersistenceMechanismException e) //1
{ 

//#if -1233047596 
e.printStackTrace();
//#endif 


//#if -410427837 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif 

} 

//#endif 


//#if 1635511320 
catch (java.sql.SQLException e) //1
{ 

//#if -1645677065 
System.out.println(sql);
//#endif 


//#if 217383176 
e.printStackTrace();
//#endif 


//#if -492770441 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif 


//#if -693032251 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif 

} 

//#endif 

finally { 

//#if -779383825 
try //1
{ 

//#if -1684669180 
mp.releaseCommunicationChannel();
//#endif 

} 

//#if -22125666 
catch (PersistenceMechanismException e) //1
{ 

//#if 1664741475 
throw new PersistenceSoftException(e);
//#endif 


//#if 868815838 
throw new RepositoryException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1832616141 
return esp;
//#endif 

} 

//#endif 


//#if 1105840381 
public boolean exists(int num) throws RepositoryException
    { 

//#if 1929001582 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

