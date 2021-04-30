
//#if -229464219 
// Compilation Unit of /GetDataForSearchBySpeciality.java 
 

//#if 607498553 
package healthwatcher.view.command;
//#endif 


//#if -1813521997 
import healthwatcher.Constants;
//#endif 


//#if 280460879 
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif 


//#if 800340314 
import healthwatcher.view.IFacade;
//#endif 


//#if 769795591 
import java.io.IOException;
//#endif 


//#if 1390015824 
import java.io.PrintWriter;
//#endif 


//#if 1287781541 
import java.rmi.RemoteException;
//#endif 


//#if -707157382 
import lib.exceptions.CommunicationException;
//#endif 


//#if 1932985346 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 113866622 
import lib.exceptions.RepositoryException;
//#endif 


//#if -828102270 
import lib.exceptions.TransactionException;
//#endif 


//#if -719376551 
import lib.util.HTMLCode;
//#endif 


//#if 230602647 
import lib.util.IteratorDsk;
//#endif 


//#if 1798496762 
import lib.exceptions.FacadeUnavailableException;
//#endif 


//#if -968725320 
public class GetDataForSearchBySpeciality extends 
//#if 208322022 
Command
//#endif 

  { 

//#if -1536649362 
public void execute() throws Exception
    { 

//#if 145766741 
PrintWriter out = response.getWriter();
//#endif 


//#if 1531498332 
try //1
{ 

//#if 1700078759 
IteratorDsk repEsp = facade.getSpecialityList();
//#endif 


//#if 468784376 
out.println(HTMLCode.open("Queries - Health Units"));
//#endif 


//#if -2064786803 
out
            .println("<body><h1>Queries:<br>Search Health units by Medical specialty</h1>");
//#endif 


//#if 599221186 
out.println("<p>Choose a specialty: </p>");
//#endif 


//#if 796590472 
out.println("<form method=\"POST\"action=\""+Constants.SYSTEM_ACTION+"?operation=SearchHealthUnitsBySpecialty\">");
//#endif 


//#if -1885087378 
out
            .println("<div align=\"center\"><center><p><select name=\"codEspecialidade\" size=\"1\">");
//#endif 


//#if 1954554807 
if(!repEsp.hasNext())//1
{ 

//#if 1328534632 
out.println("</select></p></center></div>");
//#endif 


//#if 670288686 
out.println("<P>There isn't registered specialties.</P>");
//#endif 

} 
else
{ 

//#if 1136609753 
MedicalSpeciality esp;
//#endif 


//#if 2030376093 
do{ 

//#if 1034762180 
esp = (MedicalSpeciality) repEsp.next();
//#endif 


//#if 1554694728 
out.println("<option value=\"" + esp.getCodigo() + "\"> "
                                + esp.getDescricao() + " </OPTION>");
//#endif 

} 
 while (repEsp.hasNext());//1

//#endif 


//#if 1782436165 
repEsp.close();
//#endif 


//#if -177102357 
out.println("</select></p></center></div>");
//#endif 


//#if -1610962890 
out
                .println(" <div align=\"center\"><center><p><input type=\"submit\" value=\"SearchHealthUnitsBySpecialty\" name=\"operation\"></p></center></div></form>");
//#endif 

} 

//#endif 


//#if 715595178 
out.println(HTMLCode.closeQueries());
//#endif 

} 

//#if -1365637958 
catch (ObjectNotFoundException e) //1
{ 

//#if 1358709661 
out.println("</select></p></center></div>");
//#endif 


//#if -224883265 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 


//#if 812374975 
out.println("<P> Nenhuma especialidade foi cadastrada</P>");
//#endif 

} 

//#endif 


//#if -1488859850 
catch (RepositoryException e) //1
{ 

//#if -1608774793 
out.println("</select></p></center></div>");
//#endif 


//#if -181443547 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if 1750842862 
catch (TransactionException e) //1
{ 

//#if 363915280 
out.println("</select></p></center></div>");
//#endif 


//#if 984380972 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if -12405658 
catch (CommunicationException e) //1
{ 

//#if -42513776 
throw new FacadeUnavailableException();
//#endif 

} 

//#endif 


//#if -827836212 
catch (Exception e) //1
{ 

//#if 1710186217 
out.println("Error!");
//#endif 


//#if -1736419188 
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
//#endif 


//#if 232913218 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1619628396 
public void execute()
    { 

//#if -1360449418 
PrintWriter out = null;
//#endif 


//#if -1459050674 
response.setContentType("text/html");
//#endif 


//#if 2070547463 
try //1
{ 

//#if -131163297 
out = response.getWriter();
//#endif 

} 

//#if 1170798080 
catch (IOException e1) //1
{ 

//#if -2069329652 
e1.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if 2098246741 
out.println(HTMLCode.open("Queries - Health Units"));
//#endif 


//#if -1300300694 
out
        .println("<body><h1>Queries:<br>Search Health units by Medical specialty</h1>");
//#endif 


//#if -214424737 
out.println("<p>Choose a specialty: </p>");
//#endif 


//#if 1118910693 
out.println("<form method=\"POST\"action=\""+Constants.SYSTEM_ACTION+"?operation=SearchHealthUnitsBySpecialty\">");
//#endif 


//#if -640758454 
try //2
{ 

//#if -589277496 
out
            .println("<div align=\"center\"><center><p><select name=\"codEspecialidade\" size=\"1\">");
//#endif 


//#if -428437631 
IteratorDsk repEsp = facade.getSpecialityList();
//#endif 


//#if 1907123357 
if(!repEsp.hasNext())//1
{ 

//#if 1820733631 
out.println("</select></p></center></div>");
//#endif 


//#if -307551625 
out.println("<P>There isn't registered specialties.</P>");
//#endif 

} 
else
{ 

//#if 787730084 
MedicalSpeciality esp;
//#endif 


//#if -698903256 
do{ 

//#if -121275157 
esp = (MedicalSpeciality) repEsp.next();
//#endif 


//#if -636320191 
out.println("<option value=\"" + esp.getCodigo() + "\"> "
                                + esp.getDescricao() + " </OPTION>");
//#endif 

} 
 while (repEsp.hasNext());//1

//#endif 


//#if 1698466384 
repEsp.close();
//#endif 


//#if 1386539200 
out.println("</select></p></center></div>");
//#endif 


//#if -1143366773 
out
                .println(" <div align=\"center\"><center><p><input type=\"submit\" value=\"SearchHealthUnitsBySpecialty\" name=\"operation\"></p></center></div></form>");
//#endif 

} 

//#endif 


//#if 1420165764 
out.println(HTMLCode.closeQueries());
//#endif 

} 

//#if 2126950895 
catch (RemoteException e) //1
{ 

//#if -2027964685 
out.println("Error!");
//#endif 


//#if 1176460482 
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
//#endif 


//#if 314352248 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1373859465 
catch (ObjectNotFoundException e) //1
{ 

//#if 1525074333 
out.println("</select></p></center></div>");
//#endif 


//#if -164902977 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 


//#if 1086153151 
out.println("<P> Nenhuma especialidade foi cadastrada</P>");
//#endif 

} 

//#endif 


//#if -623230861 
catch (RepositoryException e) //1
{ 

//#if 986584689 
out.println("</select></p></center></div>");
//#endif 


//#if 560974699 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if -1479429551 
catch (TransactionException e) //1
{ 

//#if 2087015697 
out.println("</select></p></center></div>");
//#endif 


//#if -366866229 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if 957160457 
catch (CommunicationException e) //1
{ 

//#if -883795178 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if 301933641 
catch (Exception e) //1
{ 

//#if 401459739 
out.println("Error!");
//#endif 


//#if 1411095194 
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
//#endif 


//#if -1682901936 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if -2024720804 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -260742199 
public GetDataForSearchBySpeciality(IFacade f)
    { 

//#if -1892378122 
super(f);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

