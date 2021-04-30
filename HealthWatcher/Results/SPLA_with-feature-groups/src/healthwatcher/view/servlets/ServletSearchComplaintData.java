
//#if 1806364684 
// Compilation Unit of /ServletSearchComplaintData.java 
 
package healthwatcher.view.servlets;
import healthwatcher.model.address.Address;
import healthwatcher.model.complaint.AnimalComplaint;
import healthwatcher.model.complaint.Complaint;
import healthwatcher.model.complaint.FoodComplaint;
import healthwatcher.model.complaint.Situation;
import healthwatcher.model.complaint.SpecialComplaint;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lib.exceptions.CommunicationException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
public class ServletSearchComplaintData extends HWServlet
  { 
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 
PrintWriter out = response.getWriter();
response.setContentType("text/html");
int codQueixa = Integer.parseInt(request.getParameter("codQueixa"));
try //1
{ 
Complaint q = facade.searchComplaint(codQueixa);
out.println(HTMLCode.open("Queries - Complaints"));
out.println("<body><h1>Search response<br>Complaint: " + codQueixa + "</h1>");
out.println("<P>Complaint code: " + q.getCodigo() + "</P>");
String t = null;
if(q instanceof SpecialComplaint)//1
{ 
t = "Special";
} 
else
if(q instanceof FoodComplaint)//1
{ 
t = "Food";
} 
else
if(q instanceof AnimalComplaint)//1
{ 
t = "Animal";
} 



out.println("<P>Complaint kind: " + t + "</P>");
out.println("<P>Complainer: " + q.getSolicitante() + "</P>");
out.println("<P>E-mail: " + q.getEmail() + "</P>");
out.println("<P>Complaint's description: " + q.getDescricao() + "</P>");
out.println("<P>Observation: " + q.getObservacao() + "</P>");
if(q.getDataQueixa() != null)//1
{ 
out.println("<P>Date: "+ lib.util.Date.format(q.getDataQueixa(), lib.util.Date.FORMATO1) + "</P>");
} 

String sit;
if(q.getSituacao() == Situation.QUEIXA_ABERTA)//1
{ 
sit = "Open";
} 
else
if(q.getSituacao() == Situation.QUEIXA_FECHADA)//1
{ 
sit = "Closed";
} 
else
{ 
sit = "Suspended";
} 


out.println("<P>Status: " + sit + "</P>");
if(q.getSituacao() == Situation.QUEIXA_FECHADA)//1
{ 
if(q.getDataParecer() != null)//1
{ 
out.println("<P>Observation Date: "+ lib.util.Date.format(q.getDataParecer(), lib.util.Date.FORMATO1)+ "</P>");
} 

} 

Address end = q.getEnderecoSolicitante();
if(end != null)//1
{ 
out.println("<P>Complainer's address: " + end.getStreet()+ "," + end.getComplement() + " Province: "+ end.getNeighbourhood() + " </P>");
out.println("<P>ZIP code: " + end.getZip() + " City: "+ end.getCity() + " State: " + end.getState()+ "</P>");
out.println("<P> Phone number: " + end.getPhone() + "</P>");
} 

if(q instanceof FoodComplaint)//1
{ 
out.println("<P>Amount of people that ate the meal: " + ((FoodComplaint) q).getQtdeComensais() + "</P>");
out.println("<P>Amount of sick people: " + ((FoodComplaint) q).getQtdeDoentes() + "</P>");
out.println("<P>Amount of people checked into a hospital: " + ((FoodComplaint) q).getQtdeInternacoes() + "</P>");
out.println("<P>Amount of deaths: " + ((FoodComplaint) q).getQtdeObitos() + "</P>");
out.println("<P>Place of medical care: " + ((FoodComplaint) q).getLocalAtendimento() + "</P>");
out.println("<P>Suspicious meal: " + ((FoodComplaint) q).getRefeicaoSuspeita() + "</P>");
end = ((FoodComplaint) q).getEnderecoDoente();
if(end != null)//1
{ 
out.println("<P>Person sick's address: " + end.getStreet()+ "," + end.getComplement() + " Province: "+ end.getNeighbourhood() + " </P>");
out.println("<P>ZIP code: " + end.getZip() + " City: "+ end.getCity() + " State: " + end.getState()+ "</P>");
out.println("<P> Phone number: " + end.getPhone() + "</P>");
} 

} 

if(q instanceof AnimalComplaint)//1
{ 
out.println("<P>Animal: " + ((AnimalComplaint) q).getAnimal() + "</P>");
out.println("<P>Amount of animals: " + ((AnimalComplaint) q).getAnimalQuantity() + "</P>");
if(((AnimalComplaint) q).getInconvenienceDate() != null)//1
{ 
out.println("<P>Date: " +  lib.util.Date.format(((AnimalComplaint) q).getInconvenienceDate(), lib.util.Date.FORMATO1) + "</P>");
} 

end = ((AnimalComplaint) q).getOccurenceLocalAddress();
if(end != null)//1
{ 
out.println("<P>Person sick's address: " + end.getStreet() + "," + end.getComplement() + " Province: " + end.getNeighbourhood() + " </P>");
out.println("<P>ZIP code: " + end.getZip() + " City: "+ end.getCity() + " State: " + end.getState()+ "</P>");
out.println("<P> Phone number: " + end.getPhone() + "</P>");
} 

} 

if(q instanceof SpecialComplaint)//2
{ 
out.println("<P>Years old: " + ((SpecialComplaint) q).getIdade()+"</P>");
out.println("<P>School level: "+ ((SpecialComplaint) q).getInstrucao() + "</P>");
out.println("<P>Ocuppation: "+ ((SpecialComplaint) q).getOcupacao() + "</P>");
end = ((SpecialComplaint) q).getEnderecoOcorrencia();
if(end != null)//1
{ 
out.println("<P>Person sick's address: " + end.getStreet()+ "," + end.getComplement() + " Province: " + end.getNeighbourhood() + " </P>");
out.println("<P>ZIP code: " + end.getZip() + " City: "+ end.getCity() + " State: " + end.getState()+ "</P>");
out.println("<P> Phone number: " + end.getPhone() + "</P>");
} 

} 

out.println(HTMLCode.closeQueries());
} 
catch(RemoteException e) //1
{ 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
e.printStackTrace(out);
} 

catch (ObjectNotFoundException e) //1
{ 
out.println(lib.util.HTMLCode.errorPageQueries("Complaint " + codQueixa + " not found"));
} 

catch (RepositoryException e) //1
{ 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
e.printStackTrace(out);
} 

catch (TransactionException e) //1
{ 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
e.printStackTrace(out);
} 

catch (CommunicationException e) //1
{ 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
e.printStackTrace(out);
} 

catch(Exception e) //1
{ 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
e.printStackTrace(out);
} 

finally { 
out.close();
} 

} 

 } 


//#endif 

