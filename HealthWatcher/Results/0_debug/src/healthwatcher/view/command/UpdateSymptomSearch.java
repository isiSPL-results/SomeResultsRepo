
//#if 337533357 
// Compilation Unit of /UpdateSymptomSearch.java 
 

//#if 1707679068 
package healthwatcher.view.command;
//#endif 


//#if -1106981034 
import healthwatcher.Constants;
//#endif 


//#if -1915067132 
import healthwatcher.model.complaint.Symptom;
//#endif 


//#if -272548649 
import healthwatcher.view.IFacade;
//#endif 


//#if 701064490 
import java.io.IOException;
//#endif 


//#if 1321284723 
import java.io.PrintWriter;
//#endif 


//#if 1381662429 
import lib.exceptions.CommunicationException;
//#endif 


//#if 1531516560 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if -2033077249 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -1668436485 
import lib.exceptions.RepositoryException;
//#endif 


//#if -244923739 
import lib.exceptions.TransactionException;
//#endif 


//#if -1090397380 
import lib.util.HTMLCode;
//#endif 


//#if -916925219 
import lib.exceptions.FacadeUnavailableException;
//#endif 


//#if -1444081488 
public class UpdateSymptomSearch extends 
//#if 1000275664 
Command
//#endif 

  { 

//#if 1804025289 
public static final String SYMPTOM = "symptom";
//#endif 


//#if -1411241982 
public UpdateSymptomSearch(IFacade f)
    { 

//#if -1938898351 
super(f);
//#endif 

} 

//#endif 


//#if 1712234622 
public void execute()
    { 

//#if -684399600 
PrintWriter out=null;
//#endif 


//#if -423054047 
try //1
{ 

//#if 1189481731 
try //1
{ 

//#if 1462955686 
out = response.getWriter();
//#endif 

} 

//#if 773985223 
catch (IOException e1) //1
{ 

//#if 1972784257 
e1.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if 641828112 
if(! request.isAuthorized())//1
{ 

//#if -517578064 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if -1021066128 
out.println("Update Symptom");
//#endif 


//#if -817418007 
out.println("<script language=\"javascript\">");
//#endif 


//#if -1516842757 
out.println("function submeterDados(modulo)");
//#endif 


//#if -1474965227 
out.println("{");
//#endif 


//#if -943648878 
String a1 = "\"";
//#endif 


//#if -56145197 
String a2 = "\"";
//#endif 


//#if -1317881841 
out.println("   var f = document.formAlterarUnidade2;");
//#endif 


//#if 644699344 
out.println("   if(f.descricao.value ==" + a1 + a2 + ")");
//#endif 


//#if 1121374493 
out.println("   {");
//#endif 


//#if 814710231 
out.println("           alert(\"Digite a nova descri��o do sintoma!\");");
//#endif 


//#if 137441759 
out.println("           f.descricao.select();");
//#endif 


//#if 1019181445 
out.println("           return;");
//#endif 


//#if -1474905645 
out.println("   }");
//#endif 


//#if -2126685012 
out.println("   f.operation.value = \"UpdateSymptomData\";");
//#endif 


//#if 1513230710 
out.println("   f.submit();");
//#endif 


//#if -1398585441 
out.println("}");
//#endif 


//#if -1086282378 
out.println("//--></script>");
//#endif 


//#if -1760749215 
out.println("<body><h1>Update Symptom:</h1>");
//#endif 


//#if 462859631 
int symptomCode = (new Integer(request.getInput("symptomCode"))).intValue();
//#endif 


//#if 21586717 
Symptom symptom = facade.searchSymptom(symptomCode);
//#endif 


//#if -1869730833 
symptom.addObserver(facade);
//#endif 


//#if 209345619 
request.put(SYMPTOM, symptom);
//#endif 


//#if -1890899654 
out.println("<form method=\"POST\" name=\"formAlterarUnidade2\" action=\"http://"+Constants.SERVLET_SERVER_PATH+"HWServlet\">");
//#endif 


//#if 1149850832 
out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateSymptomData\">" );
//#endif 


//#if 1854326017 
out.println("<div align=\"center\"><center><h4>Symptom: " + symptomCode + "</h4></center></div>");
//#endif 


//#if -1218905319 
out.println("<div align=\"center\"><center><p><strong>Name:</strong><br><input type=\"text\" name=\"descricao\" value=\"" + symptom.getDescription() + "\" size=\"60\"></p></center></div>");
//#endif 


//#if -469974799 
out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"UpdateSymptomData\" name=\"operation\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" name=\"bt2\"></h4></center></div></form>");
//#endif 


//#if 1336010904 
out.println(HTMLCode.closeAdministrator());
//#endif 

} 

//#if 88046341 
catch (ObjectNotFoundException e) //1
{ 

//#if -68015951 
out.println("Symptom does not exist!");
//#endif 

} 

//#endif 


//#if 858860822 
catch (InvalidSessionException e) //1
{ 

//#if 1513398645 
out.println(e.getMessage());
//#endif 

} 

//#endif 


//#if 1578901761 
catch (RepositoryException e) //1
{ 

//#if -999230177 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if -1932795005 
catch (TransactionException e) //1
{ 

//#if -1353455689 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if -935343941 
catch(CommunicationException e) //1
{ 

//#if 659291090 
out.println(e.getMessage());
//#endif 

} 

//#endif 

finally { 

//#if -1621688945 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -174255036 
public void execute() throws Exception
    { 

//#if 620560280 
PrintWriter out = response.getWriter();
//#endif 


//#if 160160991 
try //1
{ 

//#if 1009987985 
if(! request.isAuthorized())//1
{ 

//#if 1834658375 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if -1331025744 
int symptomCode = (new Integer(request.getInput("symptomCode"))).intValue();
//#endif 


//#if 273497340 
Symptom symptom = facade.searchSymptom(symptomCode);
//#endif 


//#if -2074934096 
symptom.addObserver(facade);
//#endif 


//#if -1856988238 
request.put(SYMPTOM, symptom);
//#endif 


//#if 1207567311 
out.println("Update Symptom");
//#endif 


//#if 1256584840 
out.println("<script language=\"javascript\">");
//#endif 


//#if 2065199706 
out.println("function submeterDados(modulo)");
//#endif 


//#if -775887116 
out.println("{");
//#endif 


//#if 1869995539 
String a1 = "\"";
//#endif 


//#if -1537468076 
String a2 = "\"";
//#endif 


//#if -2098587120 
out.println("   var f = document.formAlterarUnidade2;");
//#endif 


//#if 514278161 
out.println("   if(f.descricao.value ==" + a1 + a2 + ")");
//#endif 


//#if 1060960990 
out.println("   {");
//#endif 


//#if 1640582872 
out.println("           alert(\"Digite a nova descri��o do sintoma!\");");
//#endif 


//#if 868065854 
out.println("           f.descricao.select();");
//#endif 


//#if 831810596 
out.println("           return;");
//#endif 


//#if -775827534 
out.println("   }");
//#endif 


//#if 1963555309 
out.println("   f.operation.value = \"UpdateSymptomData\";");
//#endif 


//#if 536779925 
out.println("   f.submit();");
//#endif 


//#if -1458998944 
out.println("}");
//#endif 


//#if -718122505 
out.println("//--></script>");
//#endif 


//#if 1821293248 
out.println("<body><h1>Update Symptom:</h1>");
//#endif 


//#if 1458156697 
out.println("<form method=\"POST\" name=\"formAlterarUnidade2\" action=\"http://"+Constants.SERVLET_SERVER_PATH+"HWServlet\">");
//#endif 


//#if 606467823 
out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateSymptomData\">" );
//#endif 


//#if 1826952642 
out.println("<div align=\"center\"><center><h4>Symptom: " + symptomCode + "</h4></center></div>");
//#endif 


//#if 673370330 
out.println("<div align=\"center\"><center><p><strong>Name:</strong><br><input type=\"text\" name=\"descricao\" value=\"" + symptom.getDescription() + "\" size=\"60\"></p></center></div>");
//#endif 


//#if 1618246339 
out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"Update\" name=\"bt1\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" name=\"bt2\"></h4></center></div></form>");
//#endif 


//#if -41265737 
out.println(HTMLCode.closeAdministrator());
//#endif 

} 

//#if -1316782838 
catch (ObjectNotFoundException e) //1
{ 

//#if -1495649434 
out.println("Symptom does not exist!");
//#endif 

} 

//#endif 


//#if -545968357 
catch (InvalidSessionException e) //1
{ 

//#if 1707321359 
out.println(e.getMessage());
//#endif 

} 

//#endif 


//#if 2077486470 
catch (RepositoryException e) //1
{ 

//#if 385114009 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 638429086 
catch (TransactionException e) //1
{ 

//#if 869194428 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 404812310 
catch(CommunicationException e) //1
{ 

//#if 206092863 
throw new FacadeUnavailableException();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

