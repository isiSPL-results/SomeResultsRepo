
//#if -875931327 
// Compilation Unit of /SearchComplaintData.java 
 
package healthwatcher.view.command;

//#if -966744253 
import healthwatcher.model.address.Address;
//#endif 


//#if -1135565775 
import healthwatcher.model.complaint.AnimalComplaint;
//#endif 


//#if -587283243 
import healthwatcher.model.complaint.Complaint;
//#endif 


//#if -1209477805 
import healthwatcher.model.complaint.FoodComplaint;
//#endif 


//#if 1978208738 
import healthwatcher.model.complaint.Situation;
//#endif 


//#if -720798972 
import healthwatcher.model.complaint.SpecialComplaint;
//#endif 


//#if -1381335196 
import healthwatcher.view.IFacade;
//#endif 


//#if -521783491 
import java.io.IOException;
//#endif 


//#if 98436742 
import java.io.PrintWriter;
//#endif 


//#if 986070319 
import java.rmi.RemoteException;
//#endif 


//#if 38539824 
import lib.exceptions.CommunicationException;
//#endif 


//#if -720205044 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -1345973368 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1161498296 
import lib.exceptions.TransactionException;
//#endif 


//#if 88217103 
import lib.util.HTMLCode;
//#endif 


//#if 886736560 
import lib.exceptions.FacadeUnavailableException;
//#endif 

public class SearchComplaintData extends Command
  { 

//#if -12148212 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
int codQueixa = Integer.parseInt(request.getInput("codQueixa"));
try //1
{ 
Complaint q = facade.searchComplaint(codQueixa);
out.println(HTMLCode.open("Queries - Complaints"));
out.println("<body><h1>Search response<br>Complaint: " + codQueixa
                        + "</h1>");
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
out.println("<P>Complaint's description: " + q.getDescricao()
                        + "</P>");
out.println("<P>Observation: " + q.getObservacao() + "</P>");
if(q.getDataQueixa() != null)//1
{ 
out.println("<P>Date: "
                            + lib.util.Date.format(q.getDataQueixa(),
                                                   lib.util.Date.FORMATO1) + "</P>");
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
out.println("<P>Observation Date: "
                                + lib.util.Date.format(q.getDataParecer(),
                                                       lib.util.Date.FORMATO1) + "</P>");
} 

} 

Address end = q.getEnderecoSolicitante();
if(end != null)//1
{ 
out.println("<P>Complainer's address: " + end.getStreet() + ","
                            + end.getComplement() + " Province: "
                            + end.getNeighbourhood() + " </P>");
out.println("<P>ZIP code: " + end.getZip() + " City: "
                            + end.getCity() + " State: " + end.getState() + "</P>");
out.println("<P> Phone number: " + end.getPhone() + "</P>");
} 

if(q instanceof FoodComplaint)//1
{ 
out.println("<P>Amount of people that ate the meal: "
                            + ((FoodComplaint) q).getQtdeComensais() + "</P>");
out.println("<P>Amount of sick people: "
                            + ((FoodComplaint) q).getQtdeDoentes() + "</P>");
out.println("<P>Amount of people checked into a hospital: "
                            + ((FoodComplaint) q).getQtdeInternacoes() + "</P>");
out.println("<P>Amount of deaths: "
                            + ((FoodComplaint) q).getQtdeObitos() + "</P>");
out.println("<P>Place of medical care: "
                            + ((FoodComplaint) q).getLocalAtendimento() + "</P>");
out.println("<P>Suspicious meal: "
                            + ((FoodComplaint) q).getRefeicaoSuspeita() + "</P>");
end = ((FoodComplaint) q).getEnderecoDoente();
if(end != null)//1
{ 
out.println("<P>Person sick's address: " + end.getStreet()
                                + "," + end.getComplement() + " Province: "
                                + end.getNeighbourhood() + " </P>");
out.println("<P>ZIP code: " + end.getZip() + " City: "
                                + end.getCity() + " State: " + end.getState()
                                + "</P>");
out.println("<P> Phone number: " + end.getPhone() + "</P>");
} 

} 

if(q instanceof AnimalComplaint)//1
{ 
out.println("<P>Animal: " + ((AnimalComplaint) q).getAnimal()
                            + "</P>");
out.println("<P>Amount of animals: "
                            + ((AnimalComplaint) q).getAnimalQuantity() + "</P>");
if(((AnimalComplaint) q).getInconvenienceDate() != null)//1
{ 
out.println("<P>Date: "
                                + lib.util.Date.format(((AnimalComplaint) q)
                                                       .getInconvenienceDate(),
                                                       lib.util.Date.FORMATO1) + "</P>");
} 

end = ((AnimalComplaint) q).getOccurenceLocalAddress();
if(end != null)//1
{ 
out.println("<P>Person sick's address: " + end.getStreet()
                                + "," + end.getComplement() + " Province: "
                                + end.getNeighbourhood() + " </P>");
out.println("<P>ZIP code: " + end.getZip() + " City: "
                                + end.getCity() + " State: " + end.getState()
                                + "</P>");
out.println("<P> Phone number: " + end.getPhone() + "</P>");
} 

} 

if(q instanceof SpecialComplaint)//2
{ 
out.println("<P>Years old: "
                            + ((SpecialComplaint) q).getIdade() + "</P>");
out.println("<P>School level: "
                            + ((SpecialComplaint) q).getInstrucao() + "</P>");
out.println("<P>Ocuppation: "
                            + ((SpecialComplaint) q).getOcupacao() + "</P>");
end = ((SpecialComplaint) q).getEnderecoOcorrencia();
if(end != null)//1
{ 
out.println("<P>Person sick's address: " + end.getStreet()
                                + "," + end.getComplement() + " Province: "
                                + end.getNeighbourhood() + " </P>");
out.println("<P>ZIP code: " + end.getZip() + " City: "
                                + end.getCity() + " State: " + end.getState()
                                + "</P>");
out.println("<P> Phone number: " + end.getPhone() + "</P>");
} 

} 

out.println(HTMLCode.closeQueries());
} 
catch (ObjectNotFoundException e) //1
{ 
out.println(lib.util.HTMLCode.errorPageQueries("Complaint "
                        + codQueixa + " not found"));
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
throw new FacadeUnavailableException();
} 

catch (Exception e) //1
{ 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
e.printStackTrace(out);
} 


} 

//#endif 

public SearchComplaintData(IFacade f)
    { 
super(f);
} 


//#if -1660666954 
public void execute()
    { 
PrintWriter out = null;
try //1
{ 
out = response.getWriter();
} 

//#if 1164090615 
catch (IOException e1) //1
{ 
e1.printStackTrace();
} 

//#endif 



//#if -1590284153 
response.setContentType("text/html");
//#endif 


//#if -1840675579 
int codQueixa = Integer.parseInt(request.getParameter("codQueixa"));
//#endif 


//#if -407540284 
int codQueixa = Integer.parseInt(request.getInput("codQueixa"));
//#endif 

try //2
{ 
Complaint q = facade.searchComplaint(codQueixa);
out.println(HTMLCode.open("Queries - Complaints"));
out.println("<body><h1>Search response<br>Complaint: " + codQueixa
                        + "</h1>");
out.println("<P>Complaint code: " + q.getCodigo() + "</P>");
String t = null;
if(q instanceof SpecialComplaint)//1
{ 
t = "Special";
} 
else

//#if 2070590098 
if(q instanceof FoodComplaint)//1
{ 
t = "Food";
} 
else

//#if -1603211509 
if(q instanceof AnimalComplaint)//1
{ 
t = "Animal";
} 

//#endif 


//#endif 


out.println("<P>Complaint kind: " + t + "</P>");
out.println("<P>Complainer: " + q.getSolicitante() + "</P>");
out.println("<P>E-mail: " + q.getEmail() + "</P>");
out.println("<P>Complaint's description: " + q.getDescricao()
                        + "</P>");
out.println("<P>Observation: " + q.getObservacao() + "</P>");
if(q.getDataQueixa() != null)//1
{ 
out.println("<P>Date: "
                            + lib.util.Date.format(q.getDataQueixa(),
                                                   lib.util.Date.FORMATO1) + "</P>");
} 

String sit;
if(q.getSituacao() == Situation.QUEIXA_ABERTA)//1
{ 
sit = "Open";
} 
else

//#if -1078208180 
if(q.getSituacao() == Situation.QUEIXA_FECHADA)//1
{ 
sit = "Closed";
} 
else
{ 
sit = "Suspended";
} 

//#endif 


out.println("<P>Status: " + sit + "</P>");
if(q.getSituacao() == Situation.QUEIXA_FECHADA)//1
{ 
if(q.getDataParecer() != null)//1
{ 
out.println("<P>Observation Date: "
                                + lib.util.Date.format(q.getDataParecer(),
                                                       lib.util.Date.FORMATO1) + "</P>");
} 

} 

Address end = q.getEnderecoSolicitante();
if(end != null)//1
{ 
out.println("<P>Complainer's address: " + end.getStreet() + ","
                            + end.getComplement() + " Province: "
                            + end.getNeighbourhood() + " </P>");
out.println("<P>ZIP code: " + end.getZip() + " City: "
                            + end.getCity() + " State: " + end.getState() + "</P>");
out.println("<P> Phone number: " + end.getPhone() + "</P>");
} 

if(q instanceof FoodComplaint)//1
{ 
out.println("<P>Amount of people that ate the meal: "
                            + ((FoodComplaint) q).getQtdeComensais() + "</P>");
out.println("<P>Amount of sick people: "
                            + ((FoodComplaint) q).getQtdeDoentes() + "</P>");
out.println("<P>Amount of people checked into a hospital: "
                            + ((FoodComplaint) q).getQtdeInternacoes() + "</P>");
out.println("<P>Amount of deaths: "
                            + ((FoodComplaint) q).getQtdeObitos() + "</P>");
out.println("<P>Place of medical care: "
                            + ((FoodComplaint) q).getLocalAtendimento() + "</P>");
out.println("<P>Suspicious meal: "
                            + ((FoodComplaint) q).getRefeicaoSuspeita() + "</P>");
end = ((FoodComplaint) q).getEnderecoDoente();
if(end != null)//1
{ 
out.println("<P>Person sick's address: " + end.getStreet()
                                + "," + end.getComplement() + " Province: "
                                + end.getNeighbourhood() + " </P>");
out.println("<P>ZIP code: " + end.getZip() + " City: "
                                + end.getCity() + " State: " + end.getState()
                                + "</P>");
out.println("<P> Phone number: " + end.getPhone() + "</P>");
} 

} 

if(q instanceof AnimalComplaint)//1
{ 
out.println("<P>Animal: " + ((AnimalComplaint) q).getAnimal()
                            + "</P>");
out.println("<P>Amount of animals: "
                            + ((AnimalComplaint) q).getAnimalQuantity() + "</P>");
if(((AnimalComplaint) q).getInconvenienceDate() != null)//1
{ 
out.println("<P>Date: "
                                + lib.util.Date.format(((AnimalComplaint) q)
                                                       .getInconvenienceDate(),
                                                       lib.util.Date.FORMATO1) + "</P>");
} 

end = ((AnimalComplaint) q).getOccurenceLocalAddress();
if(end != null)//1
{ 
out.println("<P>Person sick's address: " + end.getStreet()
                                + "," + end.getComplement() + " Province: "
                                + end.getNeighbourhood() + " </P>");
out.println("<P>ZIP code: " + end.getZip() + " City: "
                                + end.getCity() + " State: " + end.getState()
                                + "</P>");
out.println("<P> Phone number: " + end.getPhone() + "</P>");
} 

} 

if(q instanceof SpecialComplaint)//2
{ 
out.println("<P>Years old: "
                            + ((SpecialComplaint) q).getIdade() + "</P>");
out.println("<P>School level: "
                            + ((SpecialComplaint) q).getInstrucao() + "</P>");
out.println("<P>Ocuppation: "
                            + ((SpecialComplaint) q).getOcupacao() + "</P>");
end = ((SpecialComplaint) q).getEnderecoOcorrencia();
if(end != null)//1
{ 
out.println("<P>Person sick's address: " + end.getStreet()
                                + "," + end.getComplement() + " Province: "
                                + end.getNeighbourhood() + " </P>");
out.println("<P>ZIP code: " + end.getZip() + " City: "
                                + end.getCity() + " State: " + end.getState()
                                + "</P>");
out.println("<P> Phone number: " + end.getPhone() + "</P>");
} 

} 

out.println(HTMLCode.closeQueries());
} 

//#if -771786370 
catch (RemoteException e) //1
{ 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
e.printStackTrace(out);
} 

//#endif 


//#if 1306024454 
catch (ObjectNotFoundException e) //1
{ 
out.println(lib.util.HTMLCode.errorPageQueries("Complaint "
                        + codQueixa + " not found"));
} 

//#endif 


//#if -835278718 
catch (RepositoryException e) //1
{ 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
e.printStackTrace(out);
} 

//#endif 


//#if 537021474 
catch (TransactionException e) //1
{ 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
e.printStackTrace(out);
} 

//#endif 


//#if 1736344986 
catch (CommunicationException e) //1
{ 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
e.printStackTrace(out);
} 

//#endif 


//#if -754154728 
catch (Exception e) //1
{ 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
e.printStackTrace(out);
} 

//#endif 

finally { 
out.close();
} 

} 

//#endif 

 } 


//#endif 

