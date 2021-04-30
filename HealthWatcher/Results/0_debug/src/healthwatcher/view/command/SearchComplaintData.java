
//#if -875931327 
// Compilation Unit of /SearchComplaintData.java 
 

//#if 1695034479 
package healthwatcher.view.command;
//#endif 


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


//#if -2111329144 
public class SearchComplaintData extends 
//#if -1418088952 
Command
//#endif 

  { 

//#if -12148212 
public void execute() throws Exception
    { 

//#if 2119983637 
PrintWriter out = response.getWriter();
//#endif 


//#if 1626099670 
int codQueixa = Integer.parseInt(request.getInput("codQueixa"));
//#endif 


//#if -761214948 
try //1
{ 

//#if 1914298767 
Complaint q = facade.searchComplaint(codQueixa);
//#endif 


//#if 142199423 
out.println(HTMLCode.open("Queries - Complaints"));
//#endif 


//#if -1241601849 
out.println("<body><h1>Search response<br>Complaint: " + codQueixa
                        + "</h1>");
//#endif 


//#if -1992338625 
out.println("<P>Complaint code: " + q.getCodigo() + "</P>");
//#endif 


//#if 490656016 
String t = null;
//#endif 


//#if -1012638026 
if(q instanceof SpecialComplaint)//1
{ 

//#if -830066207 
t = "Special";
//#endif 

} 
else

//#if 829817245 
if(q instanceof FoodComplaint)//1
{ 

//#if -1488075102 
t = "Food";
//#endif 

} 
else

//#if 1856488977 
if(q instanceof AnimalComplaint)//1
{ 

//#if -2067271060 
t = "Animal";
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if -1437607049 
out.println("<P>Complaint kind: " + t + "</P>");
//#endif 


//#if -2120542977 
out.println("<P>Complainer: " + q.getSolicitante() + "</P>");
//#endif 


//#if -730642817 
out.println("<P>E-mail: " + q.getEmail() + "</P>");
//#endif 


//#if 790073624 
out.println("<P>Complaint's description: " + q.getDescricao()
                        + "</P>");
//#endif 


//#if 968097739 
out.println("<P>Observation: " + q.getObservacao() + "</P>");
//#endif 


//#if -89452673 
if(q.getDataQueixa() != null)//1
{ 

//#if 761513962 
out.println("<P>Date: "
                            + lib.util.Date.format(q.getDataQueixa(),
                                                   lib.util.Date.FORMATO1) + "</P>");
//#endif 

} 

//#endif 


//#if -434066664 
String sit;
//#endif 


//#if 686694849 
if(q.getSituacao() == Situation.QUEIXA_ABERTA)//1
{ 

//#if -1440064287 
sit = "Open";
//#endif 

} 
else

//#if -2027122214 
if(q.getSituacao() == Situation.QUEIXA_FECHADA)//1
{ 

//#if -151497412 
sit = "Closed";
//#endif 

} 
else
{ 

//#if -1833330130 
sit = "Suspended";
//#endif 

} 

//#endif 


//#endif 


//#if -2034078588 
out.println("<P>Status: " + sit + "</P>");
//#endif 


//#if -1674778972 
if(q.getSituacao() == Situation.QUEIXA_FECHADA)//1
{ 

//#if -1555781987 
if(q.getDataParecer() != null)//1
{ 

//#if 1196822411 
out.println("<P>Observation Date: "
                                + lib.util.Date.format(q.getDataParecer(),
                                                       lib.util.Date.FORMATO1) + "</P>");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 513349405 
Address end = q.getEnderecoSolicitante();
//#endif 


//#if -756648219 
if(end != null)//1
{ 

//#if 272154977 
out.println("<P>Complainer's address: " + end.getStreet() + ","
                            + end.getComplement() + " Province: "
                            + end.getNeighbourhood() + " </P>");
//#endif 


//#if 1186054072 
out.println("<P>ZIP code: " + end.getZip() + " City: "
                            + end.getCity() + " State: " + end.getState() + "</P>");
//#endif 


//#if 1717026970 
out.println("<P> Phone number: " + end.getPhone() + "</P>");
//#endif 

} 

//#endif 


//#if -1215656903 
if(q instanceof FoodComplaint)//1
{ 

//#if 1322350594 
out.println("<P>Amount of people that ate the meal: "
                            + ((FoodComplaint) q).getQtdeComensais() + "</P>");
//#endif 


//#if 1892296737 
out.println("<P>Amount of sick people: "
                            + ((FoodComplaint) q).getQtdeDoentes() + "</P>");
//#endif 


//#if 904556496 
out.println("<P>Amount of people checked into a hospital: "
                            + ((FoodComplaint) q).getQtdeInternacoes() + "</P>");
//#endif 


//#if -1962371785 
out.println("<P>Amount of deaths: "
                            + ((FoodComplaint) q).getQtdeObitos() + "</P>");
//#endif 


//#if 997339118 
out.println("<P>Place of medical care: "
                            + ((FoodComplaint) q).getLocalAtendimento() + "</P>");
//#endif 


//#if 325036581 
out.println("<P>Suspicious meal: "
                            + ((FoodComplaint) q).getRefeicaoSuspeita() + "</P>");
//#endif 


//#if -1299194340 
end = ((FoodComplaint) q).getEnderecoDoente();
//#endif 


//#if 923321453 
if(end != null)//1
{ 

//#if -1127420292 
out.println("<P>Person sick's address: " + end.getStreet()
                                + "," + end.getComplement() + " Province: "
                                + end.getNeighbourhood() + " </P>");
//#endif 


//#if -916082896 
out.println("<P>ZIP code: " + end.getZip() + " City: "
                                + end.getCity() + " State: " + end.getState()
                                + "</P>");
//#endif 


//#if 378177554 
out.println("<P> Phone number: " + end.getPhone() + "</P>");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2005378469 
if(q instanceof AnimalComplaint)//1
{ 

//#if 1828795576 
out.println("<P>Animal: " + ((AnimalComplaint) q).getAnimal()
                            + "</P>");
//#endif 


//#if 1871024677 
out.println("<P>Amount of animals: "
                            + ((AnimalComplaint) q).getAnimalQuantity() + "</P>");
//#endif 


//#if 1488407808 
if(((AnimalComplaint) q).getInconvenienceDate() != null)//1
{ 

//#if 1118515461 
out.println("<P>Date: "
                                + lib.util.Date.format(((AnimalComplaint) q)
                                                       .getInconvenienceDate(),
                                                       lib.util.Date.FORMATO1) + "</P>");
//#endif 

} 

//#endif 


//#if 764913327 
end = ((AnimalComplaint) q).getOccurenceLocalAddress();
//#endif 


//#if -2046441068 
if(end != null)//1
{ 

//#if -264091567 
out.println("<P>Person sick's address: " + end.getStreet()
                                + "," + end.getComplement() + " Province: "
                                + end.getNeighbourhood() + " </P>");
//#endif 


//#if 1850387077 
out.println("<P>ZIP code: " + end.getZip() + " City: "
                                + end.getCity() + " State: " + end.getState()
                                + "</P>");
//#endif 


//#if -301646745 
out.println("<P> Phone number: " + end.getPhone() + "</P>");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 350931003 
if(q instanceof SpecialComplaint)//2
{ 

//#if -1433114890 
out.println("<P>Years old: "
                            + ((SpecialComplaint) q).getIdade() + "</P>");
//#endif 


//#if 1289331578 
out.println("<P>School level: "
                            + ((SpecialComplaint) q).getInstrucao() + "</P>");
//#endif 


//#if -1310259625 
out.println("<P>Ocuppation: "
                            + ((SpecialComplaint) q).getOcupacao() + "</P>");
//#endif 


//#if 1687642913 
end = ((SpecialComplaint) q).getEnderecoOcorrencia();
//#endif 


//#if -266644457 
if(end != null)//1
{ 

//#if -1748188463 
out.println("<P>Person sick's address: " + end.getStreet()
                                + "," + end.getComplement() + " Province: "
                                + end.getNeighbourhood() + " </P>");
//#endif 


//#if 1050535173 
out.println("<P>ZIP code: " + end.getZip() + " City: "
                                + end.getCity() + " State: " + end.getState()
                                + "</P>");
//#endif 


//#if 973403879 
out.println("<P> Phone number: " + end.getPhone() + "</P>");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1010502676 
out.println(HTMLCode.closeQueries());
//#endif 

} 

//#if 1531935174 
catch (ObjectNotFoundException e) //1
{ 

//#if 1051213552 
out.println(lib.util.HTMLCode.errorPageQueries("Complaint "
                        + codQueixa + " not found"));
//#endif 

} 

//#endif 


//#if -441210814 
catch (RepositoryException e) //1
{ 

//#if 379015776 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
//#endif 


//#if 983250252 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -131775390 
catch (TransactionException e) //1
{ 

//#if 432122474 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
//#endif 


//#if -258072062 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1027314214 
catch (CommunicationException e) //1
{ 

//#if 1511319789 
throw new FacadeUnavailableException();
//#endif 

} 

//#endif 


//#if 1796354776 
catch (Exception e) //1
{ 

//#if -1972944357 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
//#endif 


//#if 122907441 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1983394753 
public SearchComplaintData(IFacade f)
    { 

//#if -1287893714 
super(f);
//#endif 

} 

//#endif 


//#if -1660666954 
public void execute()
    { 

//#if -1623504355 
PrintWriter out = null;
//#endif 


//#if 359073262 
try //1
{ 

//#if -5781097 
out = response.getWriter();
//#endif 

} 

//#if 1164090615 
catch (IOException e1) //1
{ 

//#if -1019736351 
e1.printStackTrace();
//#endif 

} 

//#endif 


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


//#if -1611909629 
try //2
{ 

//#if -772091296 
Complaint q = facade.searchComplaint(codQueixa);
//#endif 


//#if -1176245552 
out.println(HTMLCode.open("Queries - Complaints"));
//#endif 


//#if -72434346 
out.println("<body><h1>Search response<br>Complaint: " + codQueixa
                        + "</h1>");
//#endif 


//#if 1331805582 
out.println("<P>Complaint code: " + q.getCodigo() + "</P>");
//#endif 


//#if 1053771233 
String t = null;
//#endif 


//#if -1479424379 
if(q instanceof SpecialComplaint)//1
{ 

//#if -2119587946 
t = "Special";
//#endif 

} 
else

//#if 2070590098 
if(q instanceof FoodComplaint)//1
{ 

//#if -1269171164 
t = "Food";
//#endif 

} 
else

//#if -1603211509 
if(q instanceof AnimalComplaint)//1
{ 

//#if -147515950 
t = "Animal";
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if 2105279558 
out.println("<P>Complaint kind: " + t + "</P>");
//#endif 


//#if 1221339022 
out.println("<P>Complainer: " + q.getSolicitante() + "</P>");
//#endif 


//#if 1890611150 
out.println("<P>E-mail: " + q.getEmail() + "</P>");
//#endif 


//#if -1386611481 
out.println("<P>Complaint's description: " + q.getDescricao()
                        + "</P>");
//#endif 


//#if 15012442 
out.println("<P>Observation: " + q.getObservacao() + "</P>");
//#endif 


//#if -1062553906 
if(q.getDataQueixa() != null)//1
{ 

//#if 146123030 
out.println("<P>Date: "
                            + lib.util.Date.format(q.getDataQueixa(),
                                                   lib.util.Date.FORMATO1) + "</P>");
//#endif 

} 

//#endif 


//#if -1922314265 
String sit;
//#endif 


//#if 341189202 
if(q.getSituacao() == Situation.QUEIXA_ABERTA)//1
{ 

//#if 697402311 
sit = "Open";
//#endif 

} 
else

//#if -1078208180 
if(q.getSituacao() == Situation.QUEIXA_FECHADA)//1
{ 

//#if 972769461 
sit = "Closed";
//#endif 

} 
else
{ 

//#if 1662834230 
sit = "Suspended";
//#endif 

} 

//#endif 


//#endif 


//#if -962216363 
out.println("<P>Status: " + sit + "</P>");
//#endif 


//#if 499447859 
if(q.getSituacao() == Situation.QUEIXA_FECHADA)//1
{ 

//#if -12840754 
if(q.getDataParecer() != null)//1
{ 

//#if 198368440 
out.println("<P>Observation Date: "
                                + lib.util.Date.format(q.getDataParecer(),
                                                       lib.util.Date.FORMATO1) + "</P>");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -618659988 
Address end = q.getEnderecoSolicitante();
//#endif 


//#if -1133476748 
if(end != null)//1
{ 

//#if -1582175874 
out.println("<P>Complainer's address: " + end.getStreet() + ","
                            + end.getComplement() + " Province: "
                            + end.getNeighbourhood() + " </P>");
//#endif 


//#if 854934869 
out.println("<P>ZIP code: " + end.getZip() + " City: "
                            + end.getCity() + " State: " + end.getState() + "</P>");
//#endif 


//#if 1090447159 
out.println("<P> Phone number: " + end.getPhone() + "</P>");
//#endif 

} 

//#endif 


//#if -1317024054 
if(q instanceof FoodComplaint)//1
{ 

//#if 1784656516 
out.println("<P>Amount of people that ate the meal: "
                            + ((FoodComplaint) q).getQtdeComensais() + "</P>");
//#endif 


//#if -2079681117 
out.println("<P>Amount of sick people: "
                            + ((FoodComplaint) q).getQtdeDoentes() + "</P>");
//#endif 


//#if -1352726446 
out.println("<P>Amount of people checked into a hospital: "
                            + ((FoodComplaint) q).getQtdeInternacoes() + "</P>");
//#endif 


//#if -927580555 
out.println("<P>Amount of deaths: "
                            + ((FoodComplaint) q).getQtdeObitos() + "</P>");
//#endif 


//#if 239330220 
out.println("<P>Place of medical care: "
                            + ((FoodComplaint) q).getLocalAtendimento() + "</P>");
//#endif 


//#if 1747774691 
out.println("<P>Suspicious meal: "
                            + ((FoodComplaint) q).getRefeicaoSuspeita() + "</P>");
//#endif 


//#if 118856990 
end = ((FoodComplaint) q).getEnderecoDoente();
//#endif 


//#if 370445995 
if(end != null)//1
{ 

//#if -1218696420 
out.println("<P>Person sick's address: " + end.getStreet()
                                + "," + end.getComplement() + " Province: "
                                + end.getNeighbourhood() + " </P>");
//#endif 


//#if -123724848 
out.println("<P>ZIP code: " + end.getZip() + " City: "
                                + end.getCity() + " State: " + end.getState()
                                + "</P>");
//#endif 


//#if -1054468942 
out.println("<P> Phone number: " + end.getPhone() + "</P>");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -634962772 
if(q instanceof AnimalComplaint)//1
{ 

//#if 1846289947 
out.println("<P>Animal: " + ((AnimalComplaint) q).getAnimal()
                            + "</P>");
//#endif 


//#if -1106955486 
out.println("<P>Amount of animals: "
                            + ((AnimalComplaint) q).getAnimalQuantity() + "</P>");
//#endif 


//#if -344256989 
if(((AnimalComplaint) q).getInconvenienceDate() != null)//1
{ 

//#if -1615769337 
out.println("<P>Date: "
                                + lib.util.Date.format(((AnimalComplaint) q)
                                                       .getInconvenienceDate(),
                                                       lib.util.Date.FORMATO1) + "</P>");
//#endif 

} 

//#endif 


//#if 274166098 
end = ((AnimalComplaint) q).getOccurenceLocalAddress();
//#endif 


//#if 2051254711 
if(end != null)//1
{ 

//#if -1291050583 
out.println("<P>Person sick's address: " + end.getStreet()
                                + "," + end.getComplement() + " Province: "
                                + end.getNeighbourhood() + " </P>");
//#endif 


//#if -140281891 
out.println("<P>ZIP code: " + end.getZip() + " City: "
                                + end.getCity() + " State: " + end.getState()
                                + "</P>");
//#endif 


//#if -1367850561 
out.println("<P> Phone number: " + end.getPhone() + "</P>");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1422793228 
if(q instanceof SpecialComplaint)//2
{ 

//#if -152846421 
out.println("<P>Years old: "
                            + ((SpecialComplaint) q).getIdade() + "</P>");
//#endif 


//#if 860620069 
out.println("<P>School level: "
                            + ((SpecialComplaint) q).getInstrucao() + "</P>");
//#endif 


//#if 508286658 
out.println("<P>Ocuppation: "
                            + ((SpecialComplaint) q).getOcupacao() + "</P>");
//#endif 


//#if -1933316330 
end = ((SpecialComplaint) q).getEnderecoOcorrencia();
//#endif 


//#if 929983820 
if(end != null)//1
{ 

//#if -1500445626 
out.println("<P>Person sick's address: " + end.getStreet()
                                + "," + end.getComplement() + " Province: "
                                + end.getNeighbourhood() + " </P>");
//#endif 


//#if -1592035334 
out.println("<P>ZIP code: " + end.getZip() + " City: "
                                + end.getCity() + " State: " + end.getState()
                                + "</P>");
//#endif 


//#if 742417116 
out.println("<P> Phone number: " + end.getPhone() + "</P>");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2082364901 
out.println(HTMLCode.closeQueries());
//#endif 

} 

//#if -771786370 
catch (RemoteException e) //1
{ 

//#if 492045248 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
//#endif 


//#if 1948383212 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1306024454 
catch (ObjectNotFoundException e) //1
{ 

//#if -558371715 
out.println(lib.util.HTMLCode.errorPageQueries("Complaint "
                        + codQueixa + " not found"));
//#endif 

} 

//#endif 


//#if -835278718 
catch (RepositoryException e) //1
{ 

//#if -1181669003 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
//#endif 


//#if -691007849 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 537021474 
catch (TransactionException e) //1
{ 

//#if 79350664 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
//#endif 


//#if -2137477340 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1736344986 
catch (CommunicationException e) //1
{ 

//#if 542997460 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
//#endif 


//#if 2119305560 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -754154728 
catch (Exception e) //1
{ 

//#if 2047147423 
out.println(lib.util.HTMLCode.errorPageQueries(e.getMessage()));
//#endif 


//#if 901700397 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if -1772341285 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

