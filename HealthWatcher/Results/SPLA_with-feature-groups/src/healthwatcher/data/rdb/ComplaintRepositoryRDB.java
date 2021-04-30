// Compilation Unit of /ComplaintRepositoryRDB.java 
 
package healthwatcher.data.rdb;
import healthwatcher.data.IComplaintRepository;
import healthwatcher.model.address.Address;
import healthwatcher.model.complaint.AnimalComplaint;
import healthwatcher.model.complaint.Complaint;
import healthwatcher.model.complaint.FoodComplaint;
import healthwatcher.model.complaint.SpecialComplaint;
import healthwatcher.model.employee.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import lib.exceptions.ExceptionMessages;
import lib.exceptions.InvalidDateException;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.PersistenceMechanismException;

//#if 429572642 
import lib.exceptions.PersistenceSoftException;
//#endif 

import lib.exceptions.RepositoryException;
import lib.persistence.IPersistenceMechanism;
import lib.persistence.PersistenceMechanism;
import lib.util.ConcreteIterator;
import lib.util.Date;
import lib.util.IteratorDsk;

//#if 259747169 
import lib.exceptions.SQLPersistenceMechanismException;
//#endif 

public class ComplaintRepositoryRDB implements IComplaintRepository
  { 
private IPersistenceMechanism mp;
protected ResultSet resultSet;
private AddressRepositoryRDB addressRep;
private EmployeeRepositoryRDB employeeRep;
private static final int FOOD_COMPLAINT = 1;
private static final int ANIMAL_COMPLAINT = 2;
private static final int SPECIAL_COMPLAINT = 3;
public ComplaintRepositoryRDB(IPersistenceMechanism mp)
    { 
this.mp = mp;
addressRep = new AddressRepositoryRDB(mp);
employeeRep = new EmployeeRepositoryRDB(mp);
} 


//#if 1769825722 
private void accessComplaint(ResultSet resultSet, Complaint complaint) throws
        ObjectNotFoundException, RepositoryException
    { 
try //1
{ 
complaint.setCodigo((new Integer(resultSet.getString("codigo"))).intValue());
complaint.setSolicitante(resultSet.getString("solicitante"));
complaint.setDescricao(resultSet.getString("descricao"));
complaint.setObservacao(resultSet.getString("observacao"));
complaint.setEmail(resultSet.getString("email"));
String funcionario = resultSet.getString("funcionario");
Employee employee = null;
if(funcionario != null && !funcionario.equalsIgnoreCase("null"))//1
{ 
employee = employeeRep.search(funcionario);
} 

complaint.setAtendente(employee);
complaint.setSituacao((new Integer(resultSet.getString("situacao"))).intValue());
try //1
{ 
java.util.Date d = null;
String date = resultSet.getString("dataParecer");
if(!date.equals("NULL"))//1
{ 
StringTokenizer token = new StringTokenizer(date, "/");
int day = (new Integer(token.nextToken())).intValue();
int month = (new Integer(token.nextToken())).intValue();
int year = (new Integer(token.nextToken())).intValue();
d = new java.util.Date(year, month, day);
} 

if(d != null)//1
{ 
try //1
{ 
complaint.setDataParecer(new Date(d.getDate(), d.getMonth() + 1, d
                                                          .getYear() + 1900));
} 
catch (InvalidDateException ex) //1
{
}

} 
else
{ 
complaint.setDataParecer(null);
} 

date = resultSet.getString("dataQueixa");
if(!date.equals("NULL"))//2
{ 
StringTokenizer token = new StringTokenizer(date, "/");
int day = (new Integer(token.nextToken())).intValue();
int month = (new Integer(token.nextToken())).intValue();
int year = (new Integer(token.nextToken())).intValue();
d = new java.util.Date(year, month, day);
} 
else
{ 
d = null;
} 

if(d != null)//2
{ 
try //1
{ 
complaint.setDataQueixa(new Date(d.getDate(), d.getMonth() + 1,
                                                         d.getYear() + 1900));
} 
catch (InvalidDateException ex) //1
{
}

} 
else
{ 
complaint.setDataQueixa(null);
} 

} 
catch (Exception e) //1
{ 
e.printStackTrace();
} 


int codEndereco = resultSet.getInt("enderecosolicitante");
Address endSol = addressRep.search(codEndereco);
complaint.setEnderecoSolicitante(endSol);
} 
catch (RepositoryException e) //1
{ 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
} 

catch (ObjectNotFoundException e) //1
{ 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
} 

catch (SQLException e) //1
{ 
throw new PersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD);
} 


} 

//#endif 


//#if -2055187981 
private void deepInsertCommon(Complaint complaint) throws ObjectAlreadyInsertedException,
        PersistenceMechanismException, RepositoryException
    { 
try //1
{ 
if(complaint.getEnderecoSolicitante() != null)//1
{ 
try //1
{ 
addressRep.insert(complaint.getEnderecoSolicitante());
} 

//#if -927017344 
catch (ObjectNotValidException e) //1
{
}
//#endif 


} 

int complaintType = -1;
if(complaint instanceof SpecialComplaint)//1
{ 
complaintType = SPECIAL_COMPLAINT;
} 
else

//#if 153732892 
if(complaint instanceof FoodComplaint)//1
{ 
complaintType = FOOD_COMPLAINT;
} 
else

//#if -1316861919 
if(complaint instanceof AnimalComplaint)//1
{ 
complaintType = ANIMAL_COMPLAINT;
} 

//#endif 


//#endif 


String sql = "INSERT INTO SCBS_queixa (codigo,tipoqueixa,solicitante,descricao,observacao,email,funcionario,situacao,dataparecer,dataqueixa,enderecosolicitante,ts) VALUES(";
sql += "'" + complaint.getCodigo() + "'" + ",";
sql += "'" + complaintType + "'" + ",";
sql += "'" + complaint.getSolicitante() + "',";
sql += "'" + complaint.getDescricao() + "',";
sql += "'" + complaint.getObservacao() + "',";
sql += "'" + complaint.getEmail() + "',";
if(complaint.getAtendente() != null)//1
{ 
sql += "'" + complaint.getAtendente().getLogin() + "','";
} 
else
{ 
sql += "'NULL',";
} 

sql += "'" + complaint.getSituacao() + "'" + ",";
if(complaint.getDataParecer() != null)//1
{ 
sql += "'" + Date.format(complaint.getDataParecer(), Date.FORMATO1) + "'";
} 
else
{ 
sql += "'NULL',";
} 

if(complaint.getDataQueixa() != null)//1
{ 
sql += "'" + Date.format(complaint.getDataQueixa(), Date.FORMATO1) + "',";
} 
else
{ 
sql += "'',";
} 

if(complaint.getEnderecoSolicitante() != null)//2
{ 
sql += "'" + complaint.getEnderecoSolicitante().getCode() + "'";
} 
else
{ 
sql += "NULL";
} 

sql += ",'" + complaint.getTimestamp() + "');";
Statement stmt = (Statement) this.mp.getCommunicationChannel();
stmt.executeUpdate(sql);
stmt.close();
} 

//#if 298148583 
catch (PersistenceMechanismException e) //1
{ 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
} 

//#endif 


//#if 327623101 
catch (SQLException e) //1
{ 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
} 

//#endif 


} 

//#endif 


//#if -572265662 
private void deepInsertSpecial(SpecialComplaint complaint)
    throws PersistenceMechanismException, RepositoryException,
        ObjectAlreadyInsertedException
    { 
if(complaint.getEnderecoOcorrencia() != null)//1
{ 
try //1
{ 
addressRep.insert(complaint.getEnderecoOcorrencia());
} 

//#if -1882381402 
catch (ObjectNotValidException e) //1
{
}
//#endif 


} 

insertSpecial(complaint);
} 

//#endif 


//#if 1406210319 
private void accessComplaint(ResultSet resultSet, Complaint complaint) throws SQLException,
        ObjectNotFoundException, RepositoryException
    { 
try //1
{ 
complaint.setCodigo((new Integer(resultSet.getString("codigo"))).intValue());
complaint.setSolicitante(resultSet.getString("solicitante"));
complaint.setDescricao(resultSet.getString("descricao"));
complaint.setObservacao(resultSet.getString("observacao"));
complaint.setEmail(resultSet.getString("email"));
String funcionario = resultSet.getString("funcionario");
Employee employee = null;
if(funcionario != null && !funcionario.equalsIgnoreCase("null"))//1
{ 
employee = employeeRep.search(funcionario);
} 

complaint.setAtendente(employee);
complaint.setSituacao((new Integer(resultSet.getString("situacao"))).intValue());
try //1
{ 
java.util.Date d = null;
String date = resultSet.getString("dataParecer");
if(!date.equals("NULL"))//1
{ 
StringTokenizer token = new StringTokenizer(date, "/");
int day = (new Integer(token.nextToken())).intValue();
int month = (new Integer(token.nextToken())).intValue();
int year = (new Integer(token.nextToken())).intValue();
d = new java.util.Date(year, month, day);
} 

if(d != null)//1
{ 
try //1
{ 
complaint.setDataParecer(new Date(d.getDate(), d.getMonth() + 1, d
                                                          .getYear() + 1900));
} 

//#if 426183776 
catch (InvalidDateException ex) //1
{
}
//#endif 


} 
else
{ 
complaint.setDataParecer(null);
} 

date = resultSet.getString("dataQueixa");
if(!date.equals("NULL"))//2
{ 
StringTokenizer token = new StringTokenizer(date, "/");
int day = (new Integer(token.nextToken())).intValue();
int month = (new Integer(token.nextToken())).intValue();
int year = (new Integer(token.nextToken())).intValue();
d = new java.util.Date(year, month, day);
} 
else
{ 
d = null;
} 

if(d != null)//2
{ 
try //1
{ 
complaint.setDataQueixa(new Date(d.getDate(), d.getMonth() + 1,
                                                         d.getYear() + 1900));
} 

//#if -2075706566 
catch (InvalidDateException ex) //1
{
}
//#endif 


} 
else
{ 
complaint.setDataQueixa(null);
} 

} 

//#if 1387111574 
catch (Exception e) //1
{ 
e.printStackTrace();
} 

//#endif 


int codEndereco = resultSet.getInt("enderecosolicitante");
Address endSol = addressRep.search(codEndereco);
complaint.setEnderecoSolicitante(endSol);
} 

//#if 1799023144 
catch (RepositoryException e) //1
{ 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
} 

//#endif 


//#if 1710708908 
catch (ObjectNotFoundException e) //1
{ 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
} 

//#endif 


//#if -574062036 
catch (SQLException e) //1
{ 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
} 

//#endif 


} 

//#endif 

public int insert(Complaint complaint) throws ObjectAlreadyInsertedException,
        RepositoryException, ObjectNotValidException
    { 
String consulta = null;
try //1
{ 
if(complaint != null)//1
{ 
consulta = "select * FROM SCBS_queixa";
Statement stmt = (Statement) mp.getCommunicationChannel();
resultSet = stmt.executeQuery(consulta);
int count = 0;
while (resultSet.next()) //1
{ 
count++;
} 

complaint.setCodigo(count + 1);
deepInsertCommon(complaint);
if(complaint instanceof SpecialComplaint)//1
{ 
SpecialComplaint special = (SpecialComplaint) complaint;
deepInsertSpecial(special);
} 
else
if(complaint instanceof FoodComplaint)//1
{ 
FoodComplaint food = (FoodComplaint) complaint;
deepInsertFood(food);
} 
else
if(complaint instanceof AnimalComplaint)//1
{ 
AnimalComplaint animal = (AnimalComplaint) complaint;
deepInsertAnimal(animal);
} 



} 
else
{ 
throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
} 

} 
catch (PersistenceMechanismException e) //1
{ 
e.printStackTrace();
throw new RepositoryException(ExceptionMessages.EXC_FALHA_INCLUSAO);
} 

catch (SQLException e) //1
{ 

//#if -1575949178 
System.out.println(consulta);
//#endif 

e.printStackTrace();

//#if -1447847628 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_INCLUSAO,consulta);
//#endif 

} 


updateTimestamp(complaint.getTimestamp() + "", "SCBS_queixa", complaint.getCodigo() + "");
return complaint.getCodigo();
} 


//#if -244516725 
private void deepInsertSpecial(SpecialComplaint complaint)
    throws RepositoryException,
        ObjectAlreadyInsertedException
    { 
if(complaint.getEnderecoOcorrencia() != null)//1
{ 
try //1
{ 
addressRep.insert(complaint.getEnderecoOcorrencia());
} 
catch (ObjectNotValidException e) //1
{
}

} 

insertSpecial(complaint);
} 

//#endif 

public Complaint search(int code) throws RepositoryException, ObjectNotFoundException
    { 
String sql = "SELECT tipoqueixa FROM SCBS_queixa WHERE codigo = '" + code + "'";
int tipoQueixa;
Complaint q = null;
try //1
{ 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
ResultSet rs = stmt.executeQuery(sql);
if(rs.next())//1
{ 
tipoQueixa = (new Integer(rs.getString("tipoqueixa"))).intValue();
} 
else
{ 
throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA + " code: "
                                                  + code);
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

//#if 2062570733 
System.out.println(sql);
//#endif 


//#if -1046726393 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif 


//#if -732382679 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_PROCURA,sql);
//#endif 

} 


switch (tipoQueixa) //1
{ 
case Complaint.QUEIXA_ALIMENTAR://1

q = accessFood(code);
break;


case Complaint.QUEIXA_ANIMAL://1

q = accessAnimal(code);
break;


case Complaint.QUEIXA_DIVERSA://1

q = accessSpecial(code);
break;


default://1

throw new IllegalArgumentException();

} 

long timestamp = searchTimestamp("SCBS_queixa", q.getCodigo() + "");
q.setTimestamp(timestamp);
return q;
} 

private FoodComplaint accessFood(int code) throws RepositoryException, ObjectNotFoundException
    { 
FoodComplaint complaint;
String sql = null;
try //1
{ 
complaint = new FoodComplaint();
sql = "select * from SCBS_queixa q,SCBS_queixaalimentar qa where q.codigo=qa.codigo and q."
                  + "codigo = '" + code + "';";
Statement stmt = (Statement) this.mp.getCommunicationChannel();
resultSet = stmt.executeQuery(sql);
if(resultSet.next())//1
{ 
try //1
{ 
accessComplaint(resultSet, complaint);
} 
catch (ObjectNotFoundException e) //1
{ 
e.printStackTrace();
} 


complaint.setQtdeComensais(resultSet.getShort("qtdeComensais"));
complaint.setQtdeDoentes(resultSet.getShort("qtdeDoentes"));
complaint.setQtdeInternacoes(resultSet.getShort("qtdeInternacoes"));
complaint.setQtdeObitos(resultSet.getShort("qtdeObitos"));
complaint.setLocalAtendimento(resultSet.getString("localAtendimento"));
complaint.setRefeicaoSuspeita(resultSet.getString("refeicaoSuspeita"));
String endDoente = resultSet.getString("enderecodoente");
Address endDo = addressRep.search((new Integer(endDoente)).intValue());
complaint.setEnderecoDoente(endDo);
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

//#if 1735751375 
e.printStackTrace();
//#endif 


//#if 1095355966 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif 


//#if 873418462 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif 

} 


return complaint;
} 

private SpecialComplaint accessSpecial(int code) throws RepositoryException,
        ObjectNotFoundException
    { 
SpecialComplaint complaint;
String sql = null;
try //1
{ 
complaint = new SpecialComplaint();
sql = "select * from SCBS_queixa q, SCBS_queixadiversa qd where q.codigo=qd.codigo and q."
                  + "codigo = '" + code + "'";
Statement stmt = (Statement) this.mp.getCommunicationChannel();
resultSet = stmt.executeQuery(sql);
if(resultSet.next())//1
{ 
accessComplaint(resultSet, complaint);
complaint.setTimestamp((new Long(resultSet.getString("ts"))).longValue());
complaint.setIdade(resultSet.getShort("idade"));
complaint.setInstrucao(resultSet.getString("instrucao"));
complaint.setOcupacao(resultSet.getString("ocupacao"));
Address endO = addressRep.search((new Integer(resultSet
                                                  .getString("enderecoocorrencia")).intValue()));
complaint.setEnderecoOcorrencia(endO);
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

catch (SQLException e) //1
{ 

//#if -922690707 
System.out.println(sql);
//#endif 


//#if 144052606 
e.printStackTrace();
//#endif 


//#if -1111110163 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif 


//#if -1930771697 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif 

} 


return complaint;
} 

public void update(Complaint complaint) throws RepositoryException, ObjectNotFoundException,
        ObjectNotValidException
    { 
synchronized (this) //1
{ 
long timestamp;
try //1
{ 
if(complaint != null)//1
{ 
String sql = null;
try //1
{ 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
sql = "select ts from SCBS_queixa " + " where codigo='"
                              + complaint.getCodigo() + "'";
ResultSet resultSet = stmt.executeQuery(sql);
if(resultSet.next())//1
{ 
timestamp = (new Long(resultSet.getString("ts"))).longValue();
if(timestamp != complaint.getTimestamp())//1
{ 
throw new RepositoryException(
                                    ExceptionMessages.EXC_FALHA_ATUALIZACAO_COPIA);
} 
else
{ 
complaint.incTimestamp();
} 

} 
else
{ 
throw new ObjectNotFoundException(
                                ExceptionMessages.EXC_FALHA_ATUALIZACAO);
} 

resultSet.close();
stmt.close();
stmt = (Statement) this.mp.getCommunicationChannel();

//#if 452586906 
sql = "update SCBS_queixa set " + "observacao='"
                              + complaint.getObservacao() + "', " + "situacao= '"
                              + complaint.getSituacao() + "', " + "funcionario= '"
                              + complaint.getAtendente().getLogin() + "', " + "ts= '"
                              + complaint.getTimestamp() + "'";
//#endif 


//#if 1712084762 
sql = "update SCBS_queixa set " + "observacao='"
                              + complaint.getObservacao() + "', " + "situacao= '"
                              + complaint.getSituacao() + "', ts= '"
                              + complaint.getTimestamp() + "'";
//#endif 


//#if -166252376 
if(complaint.getAtendente() != null)//1
{ 
sql += ", funcionario= '" + complaint.getAtendente().getLogin() + "'";
} 

//#endif 

if(complaint.getDataParecer() != null)//1
{ 
sql += ", dataparecer= '" + complaint.getDataParecer() + "'";
} 

sql += " where codigo = '" + complaint.getCodigo() + "'";
int response = stmt.executeUpdate(sql);
if(response == 0)//1
{ 
throw new ObjectNotFoundException(
                                ExceptionMessages.EXC_FALHA_ATUALIZACAO);
} 

stmt.close();
} 
catch (SQLException e) //1
{ 
System.out.println(sql);
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
} 


} 
else
{ 
throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
} 

} 
catch (PersistenceMechanismException e) //1
{ 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_ATUALIZACAO);
} 


updateTimestamp(complaint.getTimestamp() + "", "SCBS_queixa", complaint.getCodigo()
                            + "");
} 

} 

public IteratorDsk getComplaintList() throws ObjectNotFoundException, RepositoryException
    { 
List cList = new ArrayList();
String sql = "SELECT * FROM SCBS_queixa";
ResultSet rs = null;
Complaint complaint = null;
try //1
{ 
Statement stmt = (Statement) this.mp.getCommunicationChannel();
rs = stmt.executeQuery(sql);
if(!rs.next())//1
{ 
throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
} 

do{ 
int tipoQueixa = (new Integer(rs.getString("tipoqueixa"))).intValue();
int code = (new Integer(rs.getString("codigo"))).intValue();
switch (tipoQueixa) //1
{ 
case SPECIAL_COMPLAINT://1

complaint = accessSpecial(code);
break;


case FOOD_COMPLAINT://1

complaint = accessFood(code);
break;


case ANIMAL_COMPLAINT://1

complaint = accessAnimal(code);
break;


default://1

throw new IllegalArgumentException();

} 

cList.add(complaint);
} 
 while (rs.next());//1

rs.close();
stmt.close();
} 
catch (PersistenceMechanismException e) //1
{ 
e.printStackTrace();
throw new RepositoryException("PersistenceMechanismException: " + e.getMessage());
} 

catch (SQLException e) //1
{ 
e.printStackTrace();

//#if -550897225 
throw new RepositoryException("SQLException: " + e.getMessage());
//#endif 


//#if 1550103305 
throw new SQLPersistenceMechanismException("SQLException: " + e.getMessage(),sql);
//#endif 

} 

catch (RepositoryException e) //1
{ 
e.printStackTrace();
throw new RepositoryException("SQLException: " + e.getMessage());
} 


return new ConcreteIterator(cList);
} 

private void insertFood(FoodComplaint complaint) throws RepositoryException
    { 
String sql = null;
try //1
{ 
sql = "insert into SCBS_queixaalimentar (codigo,qtdecomensais,qtdedoentes,qtdeinternacoes,qtdeobitos,localatendimento,refeicaosuspeita,enderecodoente) values (";
sql += "'" + complaint.getCodigo() + "','";
sql += complaint.getQtdeComensais() + "','";
sql += complaint.getQtdeDoentes() + "','";
sql += complaint.getQtdeInternacoes() + "',";
sql += complaint.getQtdeObitos() + ",";
sql += "'" + complaint.getLocalAtendimento() + "',";
sql += "'" + complaint.getRefeicaoSuspeita() + "','";
if(complaint.getEnderecoDoente() != null)//1
{ 
sql += complaint.getEnderecoDoente().getCode() + "')";
} 
else
{ 
sql += "NULL')";
} 

Statement stmt = (Statement) this.mp.getCommunicationChannel();
stmt.executeUpdate(sql);
stmt.close();
} 
catch (PersistenceMechanismException e) //1
{ 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
} 

catch (SQLException e) //1
{ 

//#if 41444147 
System.out.println(sql);
//#endif 


//#if 2081647283 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif 


//#if -2132964599 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif 

} 


} 

private void insertSpecial(SpecialComplaint complaint) throws RepositoryException
    { 
String sql = null;
try //1
{ 
sql = "insert into SCBS_queixadiversa (codigo,idade,ocupacao,instrucao,enderecoocorrencia) values (";
sql += "'" + complaint.getCodigo() + "','";
sql += complaint.getIdade() + "',";
sql += "'" + complaint.getOcupacao() + "',";
sql += "'" + complaint.getInstrucao() + "','";
if(complaint.getEnderecoOcorrencia() != null)//1
{ 
sql += complaint.getEnderecoOcorrencia().getCode() + "')";
} 
else
{ 
sql += "NULL')";
} 

Statement stmt = (Statement) this.mp.getCommunicationChannel();
stmt.executeUpdate(sql);
stmt.close();
} 
catch (PersistenceMechanismException e) //1
{ 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
} 

catch (SQLException e) //1
{ 

//#if -605113524 
System.out.println(sql);
//#endif 


//#if -1341824436 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif 


//#if -915892080 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif 

} 


} 


//#if -801204883 
private void deepInsertFood(FoodComplaint complaint) throws RepositoryException, ObjectAlreadyInsertedException
    { 
if(complaint.getEnderecoDoente() != null)//1
{ 
try //1
{ 
addressRep.insert(complaint.getEnderecoDoente());
} 
catch (ObjectNotValidException e) //1
{
}

} 

insertFood(complaint);
} 

//#endif 


//#if -2076132356 
public boolean exists(int code)
    { 
boolean response = false;
String consulta = null;
try //1
{ 
consulta = "select codigo from SCBS_queixa where codigo='" + code + "'";
Statement stmt = (Statement) mp.getCommunicationChannel();
resultSet = stmt.executeQuery(consulta);
response = resultSet.next();
resultSet.close();
stmt.close();
} 

//#if 1969813049 
catch (PersistenceMechanismException e) //1
{ 
throw new PersistenceSoftException(e);
} 

//#endif 


//#if -1798735829 
catch (SQLException e) //1
{ 
System.out.println(consulta);
throw new PersistenceSoftException(e);
} 

//#endif 


return response;
} 

//#endif 

private AnimalComplaint accessAnimal(int codigo) throws RepositoryException,
                ObjectNotFoundException
    { 
AnimalComplaint complaint;
String sql = null;
try //1
{ 
complaint = new AnimalComplaint();
sql = "select * from SCBS_queixa q,SCBS_queixaanimal qa where q.codigo=qa.codigo and q."
                  + "codigo = '" + codigo + "'";
Statement stmt = (Statement) this.mp.getCommunicationChannel();
resultSet = stmt.executeQuery(sql);
if(resultSet.next())//1
{ 
accessComplaint(resultSet, complaint);
complaint.setAnimalQuantity(resultSet.getShort("qtdeAnimais"));
String date = resultSet.getString("dataIncomodo");
java.util.Date d = null;
if(!date.equals("NULL"))//1
{ 
StringTokenizer token = new StringTokenizer(date, "/");
int day = (new Integer(token.nextToken())).intValue();
int month = (new Integer(token.nextToken())).intValue();
int year = (new Integer(token.nextToken())).intValue();
d = new java.util.Date(year, month, day);
} 

if(d != null)//1
{ 
try //1
{ 
complaint.setInconvenienceDate(new Date(d.getDate(), d.getMonth() + 1, d
                                                                .getYear() + 1900));
} 
catch (InvalidDateException ex) //1
{
}

} 
else
{ 
complaint.setInconvenienceDate(null);
} 

complaint.setAnimal(resultSet.getString("animal"));
String endAnimal = resultSet.getString("enderecolocalocorrencia");
Address endLO = addressRep.search((new Integer(endAnimal)).intValue());
complaint.setOccurenceLocalAddress(endLO);
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

//#if 986795418 
e.printStackTrace();
//#endif 


//#if -996557303 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif 


//#if -362181005 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD, sql);
//#endif 

} 


return complaint;
} 


//#if -2059726675 
private void deepInsertAnimal(AnimalComplaint complaint) throws
        RepositoryException, ObjectAlreadyInsertedException
    { 
if(complaint.getOccurenceLocalAddress() != null)//1
{ 
try //1
{ 
addressRep.insert(complaint.getOccurenceLocalAddress());
} 
catch (ObjectNotValidException e) //1
{
}

} 

insertAnimal(complaint);
} 

//#endif 


//#if -287138844 
private void deepInsertAnimal(AnimalComplaint complaint) throws PersistenceMechanismException,
        RepositoryException, ObjectAlreadyInsertedException
    { 
if(complaint.getOccurenceLocalAddress() != null)//1
{ 
try //1
{ 
addressRep.insert(complaint.getOccurenceLocalAddress());
} 

//#if -509004073 
catch (ObjectNotValidException e) //1
{
}
//#endif 


} 

insertAnimal(complaint);
} 

//#endif 


//#if 142430372 
private void deepInsertFood(FoodComplaint complaint) throws PersistenceMechanismException,
        RepositoryException, ObjectAlreadyInsertedException
    { 
if(complaint.getEnderecoDoente() != null)//1
{ 
try //1
{ 
addressRep.insert(complaint.getEnderecoDoente());
} 

//#if -1076329578 
catch (ObjectNotValidException e) //1
{
}
//#endif 


} 

insertFood(complaint);
} 

//#endif 

private void insertAnimal(AnimalComplaint complaint) throws RepositoryException
    { 
String sql = null;
try //1
{ 
sql = "insert into SCBS_queixaanimal (codigo,qtdeanimais,dataincomodo,animal,enderecolocalocorrencia) values (";
sql += "'" + complaint.getCodigo() + "','";
sql += complaint.getAnimalQuantity() + "',";
sql += "'" + complaint.getInconvenienceDate() + "',";
sql += "'" + complaint.getAnimal() + "','";
if(complaint.getOccurenceLocalAddress() != null)//1
{ 
sql += complaint.getOccurenceLocalAddress().getCode() + "')";
} 
else
{ 
sql += "NULL')";
} 

Statement stmt = (Statement) this.mp.getCommunicationChannel();
stmt.executeUpdate(sql);
stmt.close();
} 
catch (PersistenceMechanismException e) //1
{ 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
} 

catch (SQLException e) //1
{ 

//#if -689124414 
System.out.println(sql);
//#endif 


//#if 1328740290 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif 


//#if 1303764442 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif 

} 


} 

private void updateTimestamp(String value, String tableName, String id)
    { 
Statement stmt = null;
int result = 0;
try //1
{ 
String sql = "update " + tableName + " set ts='" + value + "' where codigo='" + id
                         + "'";
stmt = (Statement) this.mp.getCommunicationChannel();
result = stmt.executeUpdate(sql);
if(result == 0)//1
{ 
throw new RuntimeException("ERRO no aspecto TimestampAspectHealthWatcher ##2");
} 

} 
catch (Exception ex) //1
{ 
ex.printStackTrace();
throw new RuntimeException(ex);
} 

finally { 
try //1
{ 
if(stmt != null)//1
{ 
stmt.close();
} 

} 
catch (Exception ex) //1
{ 
throw new RuntimeException(ex);
} 


} 

} 

public void remove(int codigo) throws RepositoryException, ObjectNotFoundException
    {
}
private long searchTimestamp(String tableName, String id)
    { 
Statement stmt = null;
ResultSet resultSet = null;
long answer = 0;
try //1
{ 
String sql = "SELECT ts FROM " + tableName + " WHERE codigo='" + id + "'";
PersistenceMechanism pm = PersistenceMechanism.getInstance();
stmt = (Statement) pm.getCommunicationChannel();
resultSet = stmt.executeQuery(sql);
if(resultSet.next())//1
{ 
answer = resultSet.getLong(1);
} 
else
{ 
throw new RuntimeException("ERRO no aspecto TimestampAspectHealthWatcher ##2");
} 

return answer;
} 
catch (Exception ex) //1
{ 
ex.printStackTrace();
throw new RuntimeException(ex);
} 

finally { 
try //1
{ 
if(resultSet != null)//1
{ 
resultSet.close();
} 

if(stmt != null)//1
{ 
stmt.close();
} 

} 
catch (Exception ex) //1
{ 
throw new RuntimeException(ex);
} 


} 

} 


//#if -1687804150 
private void deepInsertCommon(Complaint complaint) throws ObjectAlreadyInsertedException,
        RepositoryException
    { 
String sql = null;
try //1
{ 
if(complaint.getEnderecoSolicitante() != null)//1
{ 
try //1
{ 
addressRep.insert(complaint.getEnderecoSolicitante());
} 
catch (ObjectNotValidException e) //1
{
}

} 

int complaintType = -1;
if(complaint instanceof SpecialComplaint)//1
{ 
complaintType = SPECIAL_COMPLAINT;
} 
else
if(complaint instanceof FoodComplaint)//1
{ 
complaintType = FOOD_COMPLAINT;
} 
else
if(complaint instanceof AnimalComplaint)//1
{ 
complaintType = ANIMAL_COMPLAINT;
} 



sql = "INSERT INTO SCBS_queixa (codigo,tipoqueixa,solicitante,descricao,observacao,email,funcionario,situacao,dataparecer,dataqueixa,enderecosolicitante,ts) VALUES(";
sql += "'" + complaint.getCodigo() + "'" + ",";
sql += "'" + complaintType + "'" + ",";
sql += "'" + complaint.getSolicitante() + "',";
sql += "'" + complaint.getDescricao() + "',";
sql += "'" + complaint.getObservacao() + "',";
sql += "'" + complaint.getEmail() + "',";
if(complaint.getAtendente() != null)//1
{ 
sql += "'" + complaint.getAtendente().getLogin() + "','";
} 
else
{ 
sql += "'NULL',";
} 

sql += "'" + complaint.getSituacao() + "'" + ",";
if(complaint.getDataParecer() != null)//1
{ 
sql += "'" + Date.format(complaint.getDataParecer(), Date.FORMATO1) + "'";
} 
else
{ 
sql += "'NULL',";
} 

if(complaint.getDataQueixa() != null)//1
{ 
sql += "'" + Date.format(complaint.getDataQueixa(), Date.FORMATO1) + "',";
} 
else
{ 
sql += "'',";
} 

if(complaint.getEnderecoSolicitante() != null)//2
{ 
sql += "'" + complaint.getEnderecoSolicitante().getCode() + "'";
} 
else
{ 
sql += "NULL";
} 

sql += ",'" + complaint.getTimestamp() + "');";
Statement stmt = (Statement) this.mp.getCommunicationChannel();
stmt.executeUpdate(sql);
stmt.close();
} 
catch (PersistenceMechanismException e) //1
{ 
throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
} 

catch (SQLException e) //1
{ 
throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
} 


} 

//#endif 


//#if 1757015068 
public boolean exists(int code) throws RepositoryException
    { 
boolean response = false;
String consulta = null;
try //1
{ 
consulta = "select codigo from SCBS_queixa where codigo='" + code + "'";
Statement stmt = (Statement) mp.getCommunicationChannel();
resultSet = stmt.executeQuery(consulta);
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
throw new SQLPersistenceMechanismException(e.getMessage(),consulta);
} 


return response;
} 

//#endif 

 } 


