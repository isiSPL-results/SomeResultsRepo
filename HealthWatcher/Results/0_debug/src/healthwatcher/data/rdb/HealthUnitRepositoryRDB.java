
//#if -1510088996 
// Compilation Unit of /HealthUnitRepositoryRDB.java 
 

//#if -412408751 
package healthwatcher.data.rdb;
//#endif 


//#if -1252460701 
import healthwatcher.data.IHealthUnitRepository;
//#endif 


//#if 1049731871 
import healthwatcher.model.healthguide.HealthUnit;
//#endif 


//#if -588249903 
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif 


//#if -1467905145 
import java.sql.ResultSet;
//#endif 


//#if -341907735 
import java.sql.SQLException;
//#endif 


//#if -1111106979 
import java.sql.Statement;
//#endif 


//#if 2119888575 
import java.util.ArrayList;
//#endif 


//#if -755381182 
import java.util.List;
//#endif 


//#if -1507071258 
import lib.exceptions.ExceptionMessages;
//#endif 


//#if -128736073 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 1523677888 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 357802682 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if -1145570836 
import lib.exceptions.PersistenceMechanismException;
//#endif 


//#if 1081879887 
import lib.exceptions.PersistenceSoftException;
//#endif 


//#if 1631124796 
import lib.exceptions.RepositoryException;
//#endif 


//#if -1711616213 
import lib.persistence.IPersistenceMechanism;
//#endif 


//#if 1944161088 
import lib.util.ConcreteIterator;
//#endif 


//#if 823394773 
import lib.util.IteratorDsk;
//#endif 


//#if 1875467150 
import lib.exceptions.SQLPersistenceMechanismException;
//#endif 


//#if 762602573 
public class HealthUnitRepositoryRDB implements 
//#if 817596871 
IHealthUnitRepository
//#endif 

  { 

//#if -1291619156 
private IPersistenceMechanism mp;
//#endif 


//#if 297755172 
private ResultSet resultSet;
//#endif 


//#if -1107690195 
private SpecialityRepositoryRDB specialityRep;
//#endif 


//#if -1271991229 
public void insert(HealthUnit hu) throws RepositoryException, ObjectAlreadyInsertedException,
        ObjectNotValidException
    { 

//#if -1109900682 
if(hu != null)//1
{ 

//#if 1418217102 
String sql = null;
//#endif 


//#if 1392648860 
try //1
{ 

//#if -682851890 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif 


//#if 259895624 
sql = "insert into SCBS_unidadesaude (codigo,DESCRICAO) values (";
//#endif 


//#if 1630773518 
sql += hu.getCode() + ",'";
//#endif 


//#if 1153875514 
sql += hu.getDescription() + "')";
//#endif 


//#if -392989776 
stmt.executeUpdate(sql);
//#endif 


//#if -1687205528 
stmt.close();
//#endif 

} 

//#if -495927988 
catch (SQLException e) //1
{ 

//#if 1145819798 
System.out.println(sql);
//#endif 


//#if -1719285443 
throw new PersistenceSoftException(e);
//#endif 


//#if 244923560 
throw new SQLPersistenceMechanismException(e.getMessage(),sql);
//#endif 

} 

//#endif 


//#if -211650760 
catch (PersistenceMechanismException e) //1
{ 

//#if -371318556 
throw new PersistenceSoftException(e);
//#endif 


//#if 1639527263 
throw new RepositoryException(e.getMessage());
//#endif 

} 

//#endif 

finally { 

//#if -307206378 
try //1
{ 

//#if -472226256 
mp.releaseCommunicationChannel();
//#endif 

} 

//#if -1947976370 
catch (PersistenceMechanismException e) //1
{ 

//#if -97724612 
throw new PersistenceSoftException(e);
//#endif 


//#if -495447625 
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

//#if -1125001501 
throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1804261601 
public IteratorDsk getHealthUnitListBySpeciality(int code) throws RepositoryException,
        ObjectNotFoundException
    { 

//#if 1975843990 
List listaUS = new ArrayList();
//#endif 


//#if -246441719 
String sql = "select U.codigo from "
                     + "SCBS_unidadeespecialidade R, SCBS_especialidade E, SCBS_unidadesaude U where "
                     + "E.codigo=R.codigoespecialidade AND U.codigo=R.codigounidadesaude AND "
                     + "E.codigo = '" + code + "'";
//#endif 


//#if 610935690 
ResultSet rs = null;
//#endif 


//#if 789075497 
try //1
{ 

//#if -1277923167 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif 


//#if -715918878 
rs = stmt.executeQuery(sql);
//#endif 


//#if -83163349 
if(rs.next())//1
{ 

//#if -620279202 
HealthUnit us = new HealthUnit();
//#endif 


//#if -1498986998 
us = partialSearch((new Integer(rs.getString("codigo"))).intValue());
//#endif 


//#if 1773184191 
listaUS.add(us);
//#endif 

} 
else
{ 

//#if 1440828467 
throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif 

} 

//#endif 


//#if 624162885 
while (rs.next()) //1
{ 

//#if 1828285728 
HealthUnit us = new HealthUnit();
//#endif 


//#if -1921519245 
us = search((new Integer(rs.getString("codigo"))).intValue());
//#endif 


//#if 502476477 
listaUS.add(us);
//#endif 

} 

//#endif 


//#if -1166220318 
rs.close();
//#endif 


//#if -1106222725 
stmt.close();
//#endif 

} 

//#if 880232513 
catch (PersistenceMechanismException e) //1
{ 

//#if -306279868 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif 

} 

//#endif 


//#if 1955444003 
catch (SQLException e) //1
{ 

//#if -848838745 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif 


//#if -1351137399 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_PROCURA,sql);
//#endif 

} 

//#endif 

finally { 

//#if -2095845789 
try //1
{ 

//#if 450548845 
mp.releaseCommunicationChannel();
//#endif 

} 

//#if 1806064299 
catch (PersistenceMechanismException e) //1
{ 

//#if -2141366575 
throw new PersistenceSoftException(e);
//#endif 


//#if 2005806156 
throw new RepositoryException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 541781371 
return new ConcreteIterator(listaUS);
//#endif 

} 

//#endif 


//#if -1606442190 
public boolean exists(int code) throws RepositoryException
    { 

//#if -231444658 
boolean response = false;
//#endif 


//#if -1943776238 
String sql=null;
//#endif 


//#if 462164120 
try //1
{ 

//#if 1150913195 
sql = "select * from SCBS_unidadesaude where "
                  + "codigo = '" + code + "'";
//#endif 


//#if 1678411118 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif 


//#if 1744470713 
resultSet  = stmt.executeQuery(sql);
//#endif 


//#if 1275370946 
response = resultSet.next();
//#endif 


//#if 2074583019 
resultSet.close();
//#endif 


//#if 2130486536 
stmt.close();
//#endif 

} 

//#if 737058645 
catch (PersistenceMechanismException e) //1
{ 

//#if -1552790765 
throw new PersistenceSoftException(e);
//#endif 


//#if -1173111154 
throw new RepositoryException(e.getMessage());
//#endif 

} 

//#endif 


//#if 632783759 
catch (SQLException e) //1
{ 

//#if -798316548 
System.out.println(sql);
//#endif 


//#if -180243037 
throw new PersistenceSoftException(e);
//#endif 


//#if -529142014 
throw new SQLPersistenceMechanismException(e.getMessage(),sql);
//#endif 

} 

//#endif 


//#endif 


//#if -1020178104 
return response;
//#endif 

} 

//#endif 


//#if -185595757 
public void update(HealthUnit us) throws RepositoryException, ObjectNotFoundException,
               ObjectNotValidException
    { 

//#if -1728560634 
if(us != null)//1
{ 

//#if -905873268 
String sql = null;
//#endif 


//#if -611378466 
try //1
{ 

//#if 72380268 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif 


//#if -743025061 
sql = "update SCBS_unidadesaude set " + "descricao='" + us.getDescription() + "'"
                      + " where codigo = '" + us.getCode() + "'";
//#endif 


//#if 24027858 
stmt.executeUpdate(sql);
//#endif 


//#if -1921369210 
stmt.close();
//#endif 

} 

//#if 1580802656 
catch (SQLException sqlException) //1
{ 

//#if -1623559500 
System.out.println(sql);
//#endif 


//#if 483102132 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif 


//#if 497134120 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif 

} 

//#endif 


//#if -408400395 
catch (PersistenceMechanismException mpException) //1
{ 

//#if 346886019 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_ATUALIZACAO);
//#endif 

} 

//#endif 

finally { 

//#if -1653048648 
try //1
{ 

//#if -1401990686 
mp.releaseCommunicationChannel();
//#endif 

} 

//#if -1834361477 
catch (PersistenceMechanismException e) //1
{ 

//#if -412562448 
throw new PersistenceSoftException(e);
//#endif 


//#if -560065941 
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

//#if -1788561890 
throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1706242182 
public HealthUnitRepositoryRDB(IPersistenceMechanism mp)
    { 

//#if -983218013 
this.mp = mp;
//#endif 


//#if -480339796 
specialityRep = new SpecialityRepositoryRDB(mp);
//#endif 

} 

//#endif 


//#if -1455295723 
public HealthUnit search(int code) throws RepositoryException, ObjectNotFoundException
    { 

//#if 1605323729 
HealthUnit us = null;
//#endif 


//#if 1204797720 
String sql = null;
//#endif 


//#if 1448002770 
try //1
{ 

//#if -1784505472 
sql = "select * from SCBS_unidadeespecialidade where " + "codigounidadesaude = '"
                  + code + "'";
//#endif 


//#if -2105695052 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif 


//#if -459592321 
resultSet = stmt.executeQuery(sql);
//#endif 


//#if 1405476081 
List specialities = new ArrayList();
//#endif 


//#if 19343254 
while (resultSet.next()) //1
{ 

//#if 2142853439 
try //1
{ 

//#if -1048889031 
MedicalSpeciality esp = specialityRep.search((new Integer(resultSet
                                            .getString("codigoespecialidade"))).intValue());
//#endif 


//#if -1367614327 
System.out.println("medicalspeciality: " + esp.getCodigo() + " "
                                       + esp.getDescricao());
//#endif 


//#if 2002951224 
specialities.add(esp);
//#endif 

} 

//#if 480515438 
catch (ObjectNotFoundException ex) //1
{
}
//#endif 


//#endif 

} 

//#endif 


//#if -954498587 
resultSet.close();
//#endif 


//#if 835579598 
stmt.close();
//#endif 


//#if -192261083 
sql = "select * from SCBS_unidadesaude where " + "codigo = '" + code + "'";
//#endif 


//#if -1477459623 
stmt = (Statement) this.mp.getCommunicationChannel();
//#endif 


//#if 640951411 
resultSet = stmt.executeQuery(sql);
//#endif 


//#if 502397430 
if(resultSet.next())//1
{ 

//#if -8625896 
us = new HealthUnit(resultSet.getString("descricao"), specialities);
//#endif 


//#if -1579793392 
us.setCode((new Integer(resultSet.getString("codigo"))).intValue());
//#endif 

} 
else
{ 

//#if 982064081 
throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif 

} 

//#endif 


//#if 1511108173 
resultSet.close();
//#endif 


//#if -878596924 
stmt.close();
//#endif 

} 

//#if 1612496842 
catch (PersistenceMechanismException e) //1
{ 

//#if -136500353 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif 

} 

//#endif 


//#if 1970157178 
catch (SQLException e) //1
{ 

//#if -1368778798 
System.out.println(sql);
//#endif 


//#if -1125169053 
e.printStackTrace();
//#endif 


//#if -109610030 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif 


//#if 1973943242 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif 

} 

//#endif 

finally { 

//#if 917006448 
try //1
{ 

//#if -450465193 
mp.releaseCommunicationChannel();
//#endif 

} 

//#if -1539769370 
catch (PersistenceMechanismException e) //1
{ 

//#if 936417219 
throw new PersistenceSoftException(e);
//#endif 


//#if 1349671742 
throw new RepositoryException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1137457519 
return us;
//#endif 

} 

//#endif 


//#if -606155041 
public boolean exists(int num) throws RepositoryException
    { 

//#if -1428939323 
return false;
//#endif 

} 

//#endif 


//#if -13362902 
public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException
    { 

//#if -1993039113 
List listaUs = new ArrayList();
//#endif 


//#if 1320494818 
String sql = "SELECT codigo FROM SCBS_unidadesaude";
//#endif 


//#if -906250485 
ResultSet rs = null;
//#endif 


//#if -1349523128 
try //1
{ 

//#if 556642077 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif 


//#if 1984168934 
rs = stmt.executeQuery(sql);
//#endif 


//#if 2013597231 
if(rs.next())//1
{ 

//#if -1330846826 
HealthUnit us = partialSearch((new Integer(rs.getString("codigo"))).intValue());
//#endif 


//#if -448348213 
listaUs.add(us);
//#endif 

} 
else
{ 

//#if -1786057990 
throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif 

} 

//#endif 


//#if -785751359 
while (rs.next()) //1
{ 

//#if -1670176492 
HealthUnit us = new HealthUnit();
//#endif 


//#if -720027033 
us = search((new Integer(rs.getString("codigo"))).intValue());
//#endif 


//#if 1336820265 
listaUs.add(us);
//#endif 

} 

//#endif 


//#if 1800637022 
rs.close();
//#endif 


//#if -1814603529 
stmt.close();
//#endif 

} 

//#if 763621210 
catch (PersistenceMechanismException e) //1
{ 

//#if -991743889 
e.printStackTrace();
//#endif 


//#if 720172854 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif 

} 

//#endif 


//#if -704269078 
catch (SQLException e) //1
{ 

//#if -1097182659 
e.printStackTrace();
//#endif 


//#if -1240765400 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif 


//#if -761000664 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_PROCURA,sql);
//#endif 

} 

//#endif 


//#endif 


//#if 1553562332 
return new ConcreteIterator(listaUs);
//#endif 

} 

//#endif 


//#if -1196615983 
public void remove(int codigo) throws RepositoryException, ObjectNotFoundException
    {
}
//#endif 


//#if -1199662760 
public HealthUnit partialSearch(int codigo) throws RepositoryException, ObjectNotFoundException
    { 

//#if -221218020 
HealthUnit hu = null;
//#endif 


//#if -608364932 
String sql = null;
//#endif 


//#if 886902510 
try //1
{ 

//#if -267593121 
sql = "select * from SCBS_unidadesaude where " + "codigo = '" + codigo + "'";
//#endif 


//#if 96129230 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif 


//#if -1505606119 
resultSet = stmt.executeQuery(sql);
//#endif 


//#if -1515705584 
if(resultSet.next())//1
{ 

//#if -1628245706 
hu = new HealthUnit();
//#endif 


//#if 519113907 
hu.setCode((new Integer(resultSet.getString("codigo"))).intValue());
//#endif 


//#if 1582931819 
hu.setDescription(resultSet.getString("descricao"));
//#endif 

} 
else
{ 

//#if -1876305508 
throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif 

} 

//#endif 


//#if -184711029 
resultSet.close();
//#endif 


//#if 1786763368 
stmt.close();
//#endif 

} 

//#if -1487768268 
catch (PersistenceMechanismException e) //1
{ 

//#if -290601553 
throw new RepositoryException("PersistenceMechanismException: " + e.getMessage());
//#endif 

} 

//#endif 


//#if 690526160 
catch (SQLException e) //1
{ 

//#if 63411553 
System.out.println(sql);
//#endif 


//#if -1242929725 
throw new RepositoryException("SQLException: " + e.getMessage());
//#endif 


//#if -1612685187 
throw new SQLPersistenceMechanismException("SQLException: " + e.getMessage(),sql);
//#endif 

} 

//#endif 

finally { 

//#if 1536342038 
try //1
{ 

//#if -780216844 
mp.releaseCommunicationChannel();
//#endif 

} 

//#if -730621296 
catch (PersistenceMechanismException e) //1
{ 

//#if -228763413 
throw new RepositoryException("PersistenceMechanismException: " + e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -862599578 
return hu;
//#endif 

} 

//#endif 


//#if -237855983 
public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException
    { 

//#if 1797272597 
List listaUs = new ArrayList();
//#endif 


//#if 1716327684 
String sql = "SELECT codigo FROM SCBS_unidadesaude";
//#endif 


//#if -2104068695 
ResultSet rs = null;
//#endif 


//#if -1032183446 
try //1
{ 

//#if 2009468516 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif 


//#if 2012005311 
rs = stmt.executeQuery(sql);
//#endif 


//#if 1978276168 
if(rs.next())//1
{ 

//#if -2080807009 
HealthUnit us = search((new Integer(rs.getString("codigo"))).intValue());
//#endif 


//#if 174558737 
listaUs.add(us);
//#endif 

} 
else
{ 

//#if 416809372 
throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif 

} 

//#endif 


//#if -768551672 
while (rs.next()) //1
{ 

//#if 15990122 
HealthUnit us = new HealthUnit();
//#endif 


//#if 1809867837 
us = search((new Integer(rs.getString("codigo"))).intValue());
//#endif 


//#if -879750637 
listaUs.add(us);
//#endif 

} 

//#endif 


//#if 605565861 
rs.close();
//#endif 


//#if 773246078 
stmt.close();
//#endif 

} 

//#if 502934714 
catch (PersistenceMechanismException e) //1
{ 

//#if -658344177 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif 

} 

//#endif 


//#if 962825098 
catch (SQLException e) //1
{ 

//#if 969419924 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif 


//#if 361411132 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_PROCURA,sql);
//#endif 

} 

//#endif 

finally { 

//#if 1421906112 
try //1
{ 

//#if 1278966480 
mp.releaseCommunicationChannel();
//#endif 

} 

//#if -730951910 
catch (PersistenceMechanismException e) //1
{ 

//#if -1239862446 
throw new PersistenceSoftException(e);
//#endif 


//#if 1210709965 
throw new RepositoryException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1181289978 
return new ConcreteIterator(listaUs);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

