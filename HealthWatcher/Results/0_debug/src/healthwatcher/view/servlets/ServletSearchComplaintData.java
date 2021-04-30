
//#if 1806364684 
// Compilation Unit of /ServletSearchComplaintData.java 
 

//#if 147690730 
package healthwatcher.view.servlets;
//#endif 


//#if -983112761 
import healthwatcher.model.address.Address;
//#endif 


//#if -1951921227 
import healthwatcher.model.complaint.AnimalComplaint;
//#endif 


//#if 1036722009 
import healthwatcher.model.complaint.Complaint;
//#endif 


//#if -834908713 
import healthwatcher.model.complaint.FoodComplaint;
//#endif 


//#if -692753306 
import healthwatcher.model.complaint.Situation;
//#endif 


//#if -258014208 
import healthwatcher.model.complaint.SpecialComplaint;
//#endif 


//#if 140377025 
import java.io.IOException;
//#endif 


//#if 760597258 
import java.io.PrintWriter;
//#endif 


//#if 2093525803 
import java.rmi.RemoteException;
//#endif 


//#if -405665027 
import javax.servlet.ServletException;
//#endif 


//#if -1736855017 
import javax.servlet.http.HttpServletRequest;
//#endif 


//#if -661949713 
import javax.servlet.http.HttpServletResponse;
//#endif 


//#if 1488272820 
import lib.exceptions.CommunicationException;
//#endif 


//#if 1271844872 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -930859388 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1145129788 
import lib.exceptions.TransactionException;
//#endif 


//#if -903271533 
import lib.util.HTMLCode;
//#endif 


//#if 855024105 
public class ServletSearchComplaintData extends 
//#if -1598917478 
HWServlet
//#endif 

  { 

//#if 329513361 
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 

//#if -806253250 
PrintWriter out = response.getWriter();
//#endif 


//#if 1728045712 
response.setContentType("text/html");
//#endif 


//#if 1094926222 
int codQueixa = Integer.parseInt(request.getParameter("codQueixa"));
//#endif 


//#if -136466171 
try //1
{ 

//#if 1850195707 
Complaint q = facade.searchComplaint(codQueixa);
//#endif 


//#if 1449333227 
out.println(HTMLCode.open("Queries - Complaints"));
//#endif 


//#if -1858222117 
out.println("<body><h1>Search response<br>Complaint: " + codQueixa + "</h1>");
//#endif 


//#if 1700122451 
out.println("<P>Complaint code: " + q.getCodigo() + "</P>");
//#endif 


//#if 668819068 
String t = null;
//#endif 


//#if -1879397174 
if(q instanceof SpecialComplaint)//1
{ 

//#if -502920933 
t = "Special";
//#endif 

} 
else

//#if 55485648 
if(q instanceof FoodComplaint)//1
{ 

//#if -924060480 
t = "Food";
//#endif 

} 
else

//#if 3659516 
if(q instanceof AnimalComplaint)//1
{ 

//#if -620933334 
t = "Animal";
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if 802215307 
out.println("<P>Complaint kind: " + t + "</P>");
//#endif 


//#if -1308435437 
out.println("<P>Complainer: " + q.getSolicitante() + "</P>");
//#endif 


//#if 1577129619 
out.println("<P>E-mail: " + q.getEmail() + "</P>");
//#endif 


//#if -1282371796 
out.println("<P>Complaint's description: " + q.getDescricao() + "</P>");
//#endif 


//#if 1780205279 
out.println("<P>Observation: " + q.getObservacao() + "</P>");
//#endif 


//#if 115574675 
if(q.getDataQueixa() != null)//1
{ 

//#if 60186058 
out.println("<P>Date: "+ lib.util.Date.format(q.getDataQueixa(), lib.util.Date.FORMATO1) + "</P>");
//#endif 

} 

//#endif 


//#if -227609300 
String sit;
//#endif 


//#if -786803667 
if(q.getSituacao() == Situation.QUEIXA_ABERTA)//1
{ 

//#if -464475733 
sit = "Open";
//#endif 

} 
else

//#if -555373218 
if(q.getSituacao() == Situation.QUEIXA_FECHADA)//1
{ 

//#if 568075311 
sit = "Closed";
//#endif 

} 
else
{ 

//#if 883087739 
sit = "Suspended";
//#endif 

} 

//#endif 


//#endif 


//#if 1982494192 
out.println("<P>Status: " + sit + "</P>");
//#endif 


//#if -108592712 
if(q.getSituacao() == Situation.QUEIXA_FECHADA)//1
{ 

//#if -483580644 
if(q.getDataParecer() != null)//1
{ 

//#if 317835277 
out.println("<P>Observation Date: "+ lib.util.Date.format(q.getDataParecer(), lib.util.Date.FORMATO1)+ "</P>");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 473054001 
Address end = q.getEnderecoSolicitante();
//#endif 


//#if -1680743943 
if(end != null)//1
{ 

//#if 354144487 
out.println("<P>Complainer's address: " + end.getStreet()+ "," + end.getComplement() + " Province: "+ end.getNeighbourhood() + " </P>");
//#endif 


//#if 951661630 
out.println("<P>ZIP code: " + end.getZip() + " City: "+ end.getCity() + " State: " + end.getState()+ "</P>");
//#endif 


//#if 635613984 
out.println("<P> Phone number: " + end.getPhone() + "</P>");
//#endif 

} 

//#endif 


//#if 845223589 
if(q instanceof FoodComplaint)//1
{ 

//#if -1792983296 
out.println("<P>Amount of people that ate the meal: " + ((FoodComplaint) q).getQtdeComensais() + "</P>");
//#endif 


//#if 658373663 
out.println("<P>Amount of sick people: " + ((FoodComplaint) q).getQtdeDoentes() + "</P>");
//#endif 


//#if -956671794 
out.println("<P>Amount of people checked into a hospital: " + ((FoodComplaint) q).getQtdeInternacoes() + "</P>");
//#endif 


//#if 694401657 
out.println("<P>Amount of deaths: " + ((FoodComplaint) q).getQtdeObitos() + "</P>");
//#endif 


//#if 1423518384 
out.println("<P>Place of medical care: " + ((FoodComplaint) q).getLocalAtendimento() + "</P>");
//#endif 


//#if 728126951 
out.println("<P>Suspicious meal: " + ((FoodComplaint) q).getRefeicaoSuspeita() + "</P>");
//#endif 


//#if 1213431962 
end = ((FoodComplaint) q).getEnderecoDoente();
//#endif 


//#if 1101957295 
if(end != null)//1
{ 

//#if 428574922 
out.println("<P>Person sick's address: " + end.getStreet()+ "," + end.getComplement() + " Province: "+ end.getNeighbourhood() + " </P>");
//#endif 


//#if -897373570 
out.println("<P>ZIP code: " + end.getZip() + " City: "+ end.getCity() + " State: " + end.getState()+ "</P>");
//#endif 


//#if -1215305376 
out.println("<P> Phone number: " + end.getPhone() + "</P>");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1479149113 
if(q instanceof AnimalComplaint)//1
{ 

//#if -1206540194 
out.println("<P>Animal: " + ((AnimalComplaint) q).getAnimal() + "</P>");
//#endif 


//#if 773726015 
out.println("<P>Amount of animals: " + ((AnimalComplaint) q).getAnimalQuantity() + "</P>");
//#endif 


//#if -1540163546 
if(((AnimalComplaint) q).getInconvenienceDate() != null)//1
{ 

//#if 1520702141 
out.println("<P>Date: " +  lib.util.Date.format(((AnimalComplaint) q).getInconvenienceDate(), lib.util.Date.FORMATO1) + "</P>");
//#endif 

} 

//#endif 


//#if 1011012821 
end = ((AnimalComplaint) q).getOccurenceLocalAddress();
//#endif 


//#if 527962810 
if(end != null)//1
{ 

//#if -1693869571 
out.println("<P>Person sick's address: " + end.getStreet() + "," + end.getComplement() + " Province: " + end.getNeighbourhood() + " </P>");
//#endif 


//#if -1150093775 
out.println("<P>ZIP code: " + end.getZip() + " City: "+ end.getCity() + " State: " + end.getState()+ "</P>");
//#endif 


//#if -465329133 
out.println("<P> Phone number: " + end.getPhone() + "</P>");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 72536487 
if(q instanceof SpecialComplaint)//2
{ 

//#if 1659135288 
out.println("<P>Years old: " + ((SpecialComplaint) q).getIdade()+"</P>");
//#endif 


//#if -1606584584 
out.println("<P>School level: "+ ((SpecialComplaint) q).getInstrucao() + "</P>");
//#endif 


//#if -1299865259 
out.println("<P>Ocuppation: "+ ((SpecialComplaint) q).getOcupacao() + "</P>");
//#endif 


//#if -212873757 
end = ((SpecialComplaint) q).getEnderecoOcorrencia();
//#endif 


//#if -400486567 
if(end != null)//1
{ 

//#if -521776301 
out.println("<P>Person sick's address: " + end.getStreet()+ "," + end.getComplement() + " Province: " + end.getNeighbourhood() + " </P>");
//#endif 


//#if -1712984953 
out.println("<P>ZIP code: " + end.getZip() + " City: "+ end.getCity() + " State: " + end.getState()+ "</P>");
//#endif 


//#if -960747415 
out.println("<P> Phone number: " + end.getPhone() + "</P>");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 732108160 
out.println(HTMLCode.closeQueries());
//#endif 

} 

//#if 1731688303 
catch(RemoteException e) //1
{ 

//#if 975793913 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
//#endif 


//#if 1052095635 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -231745801 
catch (ObjectNotFoundException e) //1
{ 

//#if -451592218 
out.println(lib.util.HTMLCode.errorPageQueries("Complaint " + codQueixa + " not found"));
//#endif 

} 

//#endif 


//#if -362002957 
catch (RepositoryException e) //1
{ 

//#if -1669978894 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
//#endif 


//#if 1978928762 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1971299119 
catch (TransactionException e) //1
{ 

//#if -593558941 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
//#endif 


//#if 2040895977 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 716908169 
catch (CommunicationException e) //1
{ 

//#if 379916474 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
//#endif 


//#if -1348853326 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 970066377 
catch(Exception e) //1
{ 

//#if 467181155 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
//#endif 


//#if 1182563817 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if -953475104 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

