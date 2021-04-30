
//#if 859116195 
// Compilation Unit of /PersistenceMechanism.java 
 

//#if 1217493016 
package lib.persistence;
//#endif 


//#if -1460705742 
import healthwatcher.Constants;
//#endif 


//#if 1088187273 
import java.sql.Connection;
//#endif 


//#if 1405518986 
import java.sql.DriverManager;
//#endif 


//#if -1508692771 
import java.sql.PreparedStatement;
//#endif 


//#if -1971746394 
import java.sql.SQLException;
//#endif 


//#if 1918254789 
import java.util.HashMap;
//#endif 


//#if 870260745 
import lib.exceptions.ExceptionMessages;
//#endif 


//#if 288199311 
import lib.exceptions.PersistenceMechanismException;
//#endif 


//#if -1950748799 
import lib.exceptions.TransactionException;
//#endif 


//#if -520321587 
import lib.exceptions.ConnectionPersistenceMechanismException;
//#endif 


//#if 1324578207 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1872157707 
import lib.exceptions.SQLPersistenceMechanismException;
//#endif 


//#if 1422586710 
public class PersistenceMechanism implements 
//#if 854926845 
IPersistenceMechanism
//#endif 

  { 

//#if -679616587 
private static PersistenceMechanism singleton;
//#endif 


//#if 1416742940 
private static int numConexoes = 2;
//#endif 


//#if -91723379 
private Connection conexoesCriadas[];
//#endif 


//#if 21153967 
private Connection conexoesLivres[];
//#endif 


//#if 2116766158 
private HashMap conexoesAlocadas;
//#endif 


//#if 954702778 
private String url;
//#endif 


//#if -468960126 
private String user;
//#endif 


//#if 156802738 
private String password;
//#endif 


//#if -1661553802 
private boolean indisponivel;
//#endif 


//#if 1281480866 
private int currentMirror = 0;
//#endif 


//#if 1200397315 
private synchronized void releaseCommunicationChannel(boolean porTransacao)
    throws RepositoryException
    { 

//#if -887330079 
try //1
{ 

//#if 1868389745 
Thread currentThread = Thread.currentThread();
//#endif 


//#if -1547035931 
int threadId = currentThread.hashCode();
//#endif 


//#if 174415932 
if(porTransacao || !porTransacao && !conexoesAlocadas.containsKey("T" + threadId))//1
{ 

//#if -9904322 
Object canal = conexoesAlocadas.get("" + threadId);
//#endif 


//#if 665798002 
boolean achou = false;
//#endif 


//#if 678186558 
for (int i = 0; !achou && i < PersistenceMechanism.numConexoes; i++) //1
{ 

//#if -2113906219 
if(conexoesLivres[i] != null)//1
{ 

//#if 159502905 
continue;
//#endif 

} 

//#endif 


//#if 833746951 
achou = true;
//#endif 


//#if 411386619 
conexoesAlocadas.remove("" + threadId);
//#endif 


//#if -1031026355 
if(conexoesAlocadas.containsKey("T" + threadId))//1
{ 

//#if -366583820 
conexoesAlocadas.remove("T" + threadId);
//#endif 

} 

//#endif 


//#if 677420917 
conexoesLivres[i] = (java.sql.Connection) canal;
//#endif 

} 

//#endif 


//#if -954962308 
indisponivel = false;
//#endif 

} 

//#endif 

} 

//#if -1458810095 
catch (Exception ex) //1
{ 

//#if 1375236120 
ex.printStackTrace();
//#endif 


//#if -1315457 
throw new PersistenceMechanismException(
                ExceptionMessages.EXC_FALHA_LIBERAR_CANAL_COMUNICACAO);
//#endif 

} 

//#endif 

finally { 

//#if 1479663240 
notifyAll();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 281291859 
private synchronized void releaseCommunicationChannel(boolean porTransacao)
    throws PersistenceMechanismException
    { 

//#if -51441369 
try //1
{ 

//#if 1584004022 
Thread currentThread = Thread.currentThread();
//#endif 


//#if 120066282 
int threadId = currentThread.hashCode();
//#endif 


//#if 1144455169 
if(porTransacao || !porTransacao && !conexoesAlocadas.containsKey("T" + threadId))//1
{ 

//#if 711613731 
Object canal = conexoesAlocadas.get("" + threadId);
//#endif 


//#if 1857378989 
boolean achou = false;
//#endif 


//#if 2082253241 
for (int i = 0; !achou && i < PersistenceMechanism.numConexoes; i++) //1
{ 

//#if 992479735 
if(conexoesLivres[i] != null)//1
{ 

//#if -890023153 
continue;
//#endif 

} 

//#endif 


//#if -1565456603 
achou = true;
//#endif 


//#if -1338013543 
conexoesAlocadas.remove("" + threadId);
//#endif 


//#if 417632747 
if(conexoesAlocadas.containsKey("T" + threadId))//1
{ 

//#if 1200401050 
conexoesAlocadas.remove("T" + threadId);
//#endif 

} 

//#endif 


//#if 1514301203 
conexoesLivres[i] = (java.sql.Connection) canal;
//#endif 

} 

//#endif 


//#if 236618679 
indisponivel = false;
//#endif 

} 

//#endif 

} 

//#if 1024305743 
catch (Exception ex) //1
{ 

//#if 1304557285 
ex.printStackTrace();
//#endif 


//#if -98078900 
throw new PersistenceMechanismException(
                ExceptionMessages.EXC_FALHA_LIBERAR_CANAL_COMUNICACAO);
//#endif 

} 

//#endif 

finally { 

//#if -1847511837 
notifyAll();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1579831148 
public synchronized void connect() throws PersistenceMechanismException
    { 

//#if 1516684098 
if(conexoesCriadas == null)//1
{ 

//#if 1073012403 
try //1
{ 

//#if -474191563 
conexoesLivres = new Connection[PersistenceMechanism.numConexoes];
//#endif 


//#if 1931022233 
conexoesCriadas = new Connection[PersistenceMechanism.numConexoes];
//#endif 


//#if 80230308 
for (int i = 0; i < PersistenceMechanism.numConexoes; i++) //1
{ 

//#if 1979241877 
conexoesCriadas[i] = DriverManager.getConnection(url, user, password);
//#endif 


//#if -883437696 
conexoesLivres[i] = conexoesCriadas[i];
//#endif 

} 

//#endif 

} 

//#if -397979028 
catch (Exception e) //1
{ 

//#if -1336466957 
e.printStackTrace();
//#endif 


//#if -1806506464 
throw new PersistenceMechanismException(ExceptionMessages.EXC_CONECTAR);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -538430534 
public synchronized void releaseCommunicationChannel() throws RepositoryException
    { 

//#if 1196589956 
releaseCommunicationChannel(false);
//#endif 

} 

//#endif 


//#if 449688126 
public void incCurrentMirror()
    { 

//#if -988366669 
currentMirror = currentMirror + 1;
//#endif 

} 

//#endif 


//#if -959346898 
public static synchronized PersistenceMechanism getInstance(String DB_URL, String DB_LOGIN, String DB_PASS, String DB_DRIVER)
    throws RepositoryException
    { 

//#if 852219078 
if(singleton == null)//1
{ 

//#if 1449265734 
singleton = new PersistenceMechanism(DB_URL, DB_LOGIN,DB_PASS, DB_DRIVER);
//#endif 

} 

//#endif 


//#if -240918569 
return singleton;
//#endif 

} 

//#endif 


//#if 351452543 
private PersistenceMechanism(String url, String user, String password, String driverClass)
    throws RepositoryException
    { 

//#if 1610492396 
conexoesAlocadas = new HashMap();
//#endif 


//#if 1326528873 
this.url = url;
//#endif 


//#if 554547853 
this.user = user;
//#endif 


//#if 1438263949 
this.password = password;
//#endif 


//#if -1976446150 
indisponivel = false;
//#endif 


//#if -1998453289 
try //1
{ 

//#if 1608550300 
Class.forName(driverClass);
//#endif 

} 

//#if 884398691 
catch (ClassNotFoundException e) //1
{ 

//#if 2083123289 
throw new PersistenceMechanismException("EXC_CLASSE_NAO_ENCONTRADA");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -245047025 
public synchronized void commitTransaction() throws TransactionException
    { 

//#if -619437145 
try //1
{ 

//#if 1739716764 
Connection con = (Connection) getCommunicationChannel(true);
//#endif 


//#if -1407516900 
con.commit();
//#endif 


//#if -1158440793 
con.setAutoCommit(true);
//#endif 


//#if 777815887 
releaseCommunicationChannel(true);
//#endif 

} 

//#if -520752682 
catch (Exception e) //1
{ 

//#if -1933998112 
e.printStackTrace();
//#endif 


//#if -336815675 
throw new TransactionException("EXC_CONFIRMAR_TRANSACAO");
//#endif 

} 

//#endif 

finally { 

//#if 749223005 
notifyAll();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1214008263 
public static synchronized PersistenceMechanism getInstance()
    throws PersistenceMechanismException
    { 

//#if -270407501 
if(singleton == null)//1

//#if 2123945828 
singleton = new PersistenceMechanism(Constants.DB_URL, Constants.DB_LOGIN,
                                                 Constants.DB_PASS, Constants.DB_DRIVER);
//#endif 


//#endif 


//#if -299980412 
return singleton;
//#endif 

} 

//#endif 


//#if -1822444353 
public synchronized PreparedStatement getPreparedStatement(String sql)
    throws PersistenceMechanismException
    { 

//#if 1816001066 
try //1
{ 

//#if -1217547779 
return getCommunicationChannel(false).prepareStatement(sql);
//#endif 

} 

//#if 116112756 
catch (SQLException ex) //1
{ 

//#if 1947929753 
throw new PersistenceMechanismException("SQLException: " + ex.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 2000288854 
public synchronized Object getCommunicationChannel() throws RepositoryException
    { 

//#if 2141433971 
try //1
{ 

//#if 1079152494 
return getCommunicationChannel(false).createStatement();
//#endif 

} 

//#if 813430114 
catch (Exception ex) //1
{ 

//#if 2019517293 
incCurrentMirror();
//#endif 


//#if 352467945 
try //1
{ 

//#if -796634776 
this.connect();
//#endif 


//#if -1391508286 
return getCommunicationChannel(false).createStatement();
//#endif 

} 

//#if -2115201319 
catch (Exception ex1) //1
{ 

//#if -185190749 
ex1.printStackTrace();
//#endif 


//#if -2122327285 
throw new ConnectionPersistenceMechanismException(
                    ExceptionMessages.EXC_FALHA_GET_CANAL_COMUNICACAO,this.url);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 468434039 
public static synchronized PersistenceMechanism getInstance()
    throws RepositoryException
    { 

//#if -963626932 
if(singleton == null)//1

//#if -1341959946 
singleton = new PersistenceMechanism(Constants.DB_URL, Constants.DB_LOGIN,
                                                 Constants.DB_PASS, Constants.DB_DRIVER);
//#endif 


//#endif 


//#if 994238429 
return singleton;
//#endif 

} 

//#endif 


//#if 1432322278 
public synchronized Object getCommunicationChannel() throws PersistenceMechanismException
    { 

//#if -1190800773 
try //1
{ 

//#if 96138117 
return getCommunicationChannel(false).createStatement();
//#endif 

} 

//#if 1375506590 
catch (Exception ex) //1
{ 

//#if 1918221326 
ex.printStackTrace();
//#endif 


//#if 837345576 
throw new PersistenceMechanismException(
                ExceptionMessages.EXC_FALHA_GET_CANAL_COMUNICACAO);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 214519172 
public synchronized void connect() throws RepositoryException
    { 

//#if -1621370884 
if(conexoesCriadas == null)//1
{ 

//#if 319794015 
try //1
{ 

//#if 1819207510 
conexoesLivres = new Connection[PersistenceMechanism.numConexoes];
//#endif 


//#if 11949464 
conexoesCriadas = new Connection[PersistenceMechanism.numConexoes];
//#endif 


//#if -908412155 
for (int i = 0; i < PersistenceMechanism.numConexoes; i++) //1
{ 

//#if 1725857298 
if(currentMirror > 0)//1
{ 

//#if -383677738 
conexoesCriadas[i] = DriverManager.getConnection(url+currentMirror, user, password);
//#endif 

} 
else
{ 

//#if -1456629960 
conexoesCriadas[i] = DriverManager.getConnection(url, user, password);
//#endif 

} 

//#endif 


//#if -1226403221 
conexoesLivres[i] = conexoesCriadas[i];
//#endif 

} 

//#endif 

} 

//#if -1819120888 
catch (Exception e) //1
{ 

//#if 480376366 
incCurrentMirror();
//#endif 


//#if -677166200 
try //1
{ 

//#if 1345346422 
this.connect();
//#endif 

} 

//#if -1402062450 
catch (Exception ex1) //1
{ 

//#if 1868141144 
ex1.printStackTrace();
//#endif 


//#if 1346644224 
throw new ConnectionPersistenceMechanismException(
                        ExceptionMessages.EXC_FALHA_GET_CANAL_COMUNICACAO,this.url);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 1887150799 
private PersistenceMechanism(String url, String user, String password, String driverClass)
    throws PersistenceMechanismException
    { 

//#if 448620247 
conexoesAlocadas = new HashMap();
//#endif 


//#if -828556002 
this.url = url;
//#endif 


//#if -307780350 
this.user = user;
//#endif 


//#if -904867838 
this.password = password;
//#endif 


//#if 1245149999 
indisponivel = false;
//#endif 


//#if -1646160958 
try //1
{ 

//#if 264319972 
Class.forName(driverClass);
//#endif 

} 

//#if 949175763 
catch (ClassNotFoundException e) //1
{ 

//#if -864044745 
throw new PersistenceMechanismException("EXC_CLASSE_NAO_ENCONTRADA");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 194604162 
public synchronized void rollbackTransaction() throws TransactionException
    { 

//#if -291959261 
try //1
{ 

//#if 642015053 
Connection con = (Connection) getCommunicationChannel(true);
//#endif 


//#if -602565058 
con.rollback();
//#endif 


//#if -1484455080 
con.setAutoCommit(true);
//#endif 


//#if -36632384 
releaseCommunicationChannel(true);
//#endif 

} 

//#if 640787608 
catch (Exception e) //1
{ 

//#if 1592852633 
e.printStackTrace();
//#endif 


//#if -1654157124 
throw new TransactionException("EXC_CANCELAR_TRANSACAO");
//#endif 

} 

//#endif 

finally { 

//#if -1400296062 
try //1
{ 

//#if -524566716 
notifyAll();
//#endif 

} 

//#if -3800840 
catch (Exception e) //1
{ 

//#if 695355942 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -2008364214 
public synchronized void releaseCommunicationChannel() throws PersistenceMechanismException
    { 

//#if 439051285 
releaseCommunicationChannel(false);
//#endif 

} 

//#endif 


//#if -548716972 
public synchronized void disconnect() throws PersistenceMechanismException
    { 

//#if 1513628694 
try //1
{ 

//#if 1631818669 
if(conexoesCriadas != null)//1
{ 

//#if -889446579 
int fechadas = 0;
//#endif 


//#if 269839685 
for (int i = 0; i < PersistenceMechanism.numConexoes; i++) //1
{ 

//#if -2123188622 
System.out.println("Conexao " + i + " " + conexoesLivres[i]);
//#endif 

} 

//#endif 


//#if -142680694 
System.out.println("Conexoes alocadas " + conexoesAlocadas.size());
//#endif 


//#if -1384645812 
for (int i = 0; i < PersistenceMechanism.numConexoes; i++) //2
{ 

//#if 1410858103 
if(conexoesCriadas[i] != null)//1
{ 

//#if 1082648885 
conexoesCriadas[i].close();
//#endif 


//#if 1999384687 
fechadas++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 369796657 
conexoesCriadas = null;
//#endif 


//#if -1370063524 
System.out.println("Foram fechadas " + fechadas + " conexoes");
//#endif 

} 

//#endif 

} 

//#if -453907130 
catch (Exception e) //1
{ 

//#if -954150068 
e.printStackTrace();
//#endif 


//#if -2136311662 
throw new PersistenceMechanismException(ExceptionMessages.EXC_FALHA_DESCONECTAR);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -640777560 
private synchronized Connection getCommunicationChannel(boolean porTransacao)
    throws RepositoryException
    { 

//#if 1904841709 
Connection resposta = null;
//#endif 


//#if 680826893 
try //1
{ 

//#if -2016577142 
Thread currentThread = Thread.currentThread();
//#endif 


//#if -383550018 
int threadId = currentThread.hashCode();
//#endif 


//#if 1008022301 
if(conexoesAlocadas.containsKey("" + threadId))//1
{ 

//#if 1327799093 
resposta = (Connection) conexoesAlocadas.get("" + threadId);
//#endif 

} 
else
{ 

//#if 1469499920 
boolean achou = false;
//#endif 


//#if -1799101511 
do{ 

//#if 1200762025 
if(achou)//1
{ 

//#if 1715053862 
break;

//#endif 

} 

//#endif 


//#if 1587553085 
for (int i = 0; !achou && i < PersistenceMechanism.numConexoes; i++) //1
{ 

//#if -216205113 
if(conexoesLivres[i] == null)//1
{ 

//#if 1605109816 
continue;
//#endif 

} 

//#endif 


//#if -279234759 
achou = true;
//#endif 


//#if -145880524 
resposta = conexoesLivres[i];
//#endif 


//#if 284963380 
conexoesLivres[i] = null;
//#endif 


//#if 1338819319 
conexoesAlocadas.put("" + threadId, resposta);
//#endif 


//#if 1169769749 
if(porTransacao)//1
{ 

//#if 998997486 
conexoesAlocadas.put("T" + threadId, null);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -267653154 
if(!achou)//1
{ 

//#if -1646303113 
indisponivel = true;
//#endif 


//#if 1799547448 
wait();
//#endif 

} 

//#endif 

} 
 while (true);//1

//#endif 

} 

//#endif 

} 

//#if -398742215 
catch (Exception ex) //1
{ 

//#if 1570570078 
try //1
{ 

//#if -269531306 
this.url = this.url + "1";
//#endif 


//#if -717546560 
this.connect();
//#endif 


//#if 1439930032 
resposta =  this.getCommunicationChannel(porTransacao);
//#endif 

} 

//#if -1244953372 
catch (Exception ex1) //1
{ 

//#if 1285740639 
ex.printStackTrace();
//#endif 


//#if -1117482284 
throw new ConnectionPersistenceMechanismException(
                    ExceptionMessages.EXC_FALHA_GET_CANAL_COMUNICACAO,this.url);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#endif 


//#if 1063495315 
return resposta;
//#endif 

} 

//#endif 


//#if -562594961 
public synchronized PreparedStatement getPreparedStatement(String sql)
    throws RepositoryException
    { 

//#if -1289636645 
try //1
{ 

//#if -899105008 
return getCommunicationChannel(false).prepareStatement(sql);
//#endif 

} 

//#if 605514646 
catch (SQLException ex) //1
{ 

//#if 1944848018 
throw new SQLPersistenceMechanismException("SQLException: " + ex.getMessage(),sql);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 2139163460 
public synchronized void disconnect() throws RepositoryException
    { 

//#if -681921933 
try //1
{ 

//#if -224844326 
if(conexoesCriadas != null)//1
{ 

//#if 483486453 
int fechadas = 0;
//#endif 


//#if -103295843 
for (int i = 0; i < PersistenceMechanism.numConexoes; i++) //1
{ 

//#if 1275359839 
System.out.println("Conexao " + i + " " + conexoesLivres[i]);
//#endif 

} 

//#endif 


//#if 1229584098 
System.out.println("Conexoes alocadas " + conexoesAlocadas.size());
//#endif 


//#if -2089798412 
for (int i = 0; i < PersistenceMechanism.numConexoes; i++) //2
{ 

//#if 1972570878 
if(conexoesCriadas[i] != null)//1
{ 

//#if 2056379107 
conexoesCriadas[i].close();
//#endif 


//#if -1149551075 
fechadas++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 511733129 
conexoesCriadas = null;
//#endif 


//#if -2075216124 
System.out.println("Foram fechadas " + fechadas + " conexoes");
//#endif 

} 

//#endif 

} 

//#if -83968722 
catch (Exception e) //1
{ 

//#if -939374957 
e.printStackTrace();
//#endif 


//#if -1634562837 
throw new PersistenceMechanismException(ExceptionMessages.EXC_FALHA_DESCONECTAR);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -171587400 
private synchronized Connection getCommunicationChannel(boolean porTransacao)
    throws PersistenceMechanismException
    { 

//#if 760009716 
Connection resposta = null;
//#endif 


//#if 952146900 
try //1
{ 

//#if -1909835073 
Thread currentThread = Thread.currentThread();
//#endif 


//#if -1616737613 
int threadId = currentThread.hashCode();
//#endif 


//#if -2131105016 
if(conexoesAlocadas.containsKey("" + threadId))//1
{ 

//#if 1654836891 
resposta = (Connection) conexoesAlocadas.get("" + threadId);
//#endif 

} 
else
{ 

//#if 1907142942 
boolean achou = false;
//#endif 


//#if -1156349497 
do{ 

//#if -535927450 
if(achou)//1
{ 

//#if 273943377 
break;

//#endif 

} 

//#endif 


//#if -1002794976 
for (int i = 0; !achou && i < PersistenceMechanism.numConexoes; i++) //1
{ 

//#if 2055942102 
if(conexoesLivres[i] == null)//1
{ 

//#if -521266557 
continue;
//#endif 

} 

//#endif 


//#if 820950154 
achou = true;
//#endif 


//#if 705086853 
resposta = conexoesLivres[i];
//#endif 


//#if -5161467 
conexoesLivres[i] = null;
//#endif 


//#if -1385251768 
conexoesAlocadas.put("" + threadId, resposta);
//#endif 


//#if -1742282394 
if(porTransacao)//1
{ 

//#if -1008358362 
conexoesAlocadas.put("T" + threadId, null);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1729547969 
if(!achou)//1
{ 

//#if 247578128 
indisponivel = true;
//#endif 


//#if -799139265 
wait();
//#endif 

} 

//#endif 

} 
 while (true);//1

//#endif 

} 

//#endif 

} 

//#if -1893646847 
catch (Exception ex) //1
{ 

//#if -1871810535 
ex.printStackTrace();
//#endif 


//#if 2070462387 
throw new PersistenceMechanismException(
                ExceptionMessages.EXC_FALHA_GET_CANAL_COMUNICACAO);
//#endif 

} 

//#endif 


//#endif 


//#if 1646391980 
return resposta;
//#endif 

} 

//#endif 


//#if -753923861 
public synchronized void beginTransaction() throws TransactionException
    { 

//#if 95431616 
try //1
{ 

//#if -1619048528 
while (indisponivel) //1
{ 

//#if 1223748657 
wait();
//#endif 

} 

//#endif 


//#if -44891176 
Connection con = (Connection) getCommunicationChannel(true);
//#endif 


//#if 1464906066 
con.setAutoCommit(false);
//#endif 

} 

//#if -1325664688 
catch (Exception e) //1
{ 

//#if 697824129 
e.printStackTrace();
//#endif 


//#if -1317613028 
throw new TransactionException("EXC_INICIAR_TRANSACAO");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

