
//#if -1112114356 
// Compilation Unit of /ServletInsertFoodComplaint.java 
 

//#if -759150454 
package healthwatcher.view.servlets;
//#endif 


//#if -1504650201 
import healthwatcher.model.address.Address;
//#endif 


//#if 776071097 
import healthwatcher.model.complaint.Complaint;
//#endif 


//#if -1688738249 
import healthwatcher.model.complaint.FoodComplaint;
//#endif 


//#if -1643858911 
import java.io.IOException;
//#endif 


//#if -1023638678 
import java.io.PrintWriter;
//#endif 


//#if 510013131 
import java.rmi.RemoteException;
//#endif 


//#if -349872118 
import java.util.Calendar;
//#endif 


//#if -1681763 
import javax.servlet.ServletException;
//#endif 


//#if -423161225 
import javax.servlet.http.HttpServletRequest;
//#endif 


//#if 1407852175 
import javax.servlet.http.HttpServletResponse;
//#endif 


//#if -1493000684 
import lib.exceptions.CommunicationException;
//#endif 


//#if 1351110351 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if -2119195742 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if -532041180 
import lib.exceptions.RepositoryException;
//#endif 


//#if 623592348 
import lib.exceptions.TransactionException;
//#endif 


//#if -1128114403 
import lib.util.Date;
//#endif 


//#if 685931507 
import lib.util.HTMLCode;
//#endif 


//#if -2060903664 
public class ServletInsertFoodComplaint extends 
//#if 1840303993 
HWServlet
//#endif 

  { 

//#if 1904255088 
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 

//#if -698646780 
PrintWriter out = response.getWriter();
//#endif 


//#if 768878986 
response.setContentType("text/html");
//#endif 


//#if -883629749 
try //1
{ 

//#if 2139077511 
String descricaoQueixa = request.getParameter("descricaoQueixa");
//#endif 


//#if 1996042441 
String observacaoQueixa = request.getParameter("observacaoQueixa");
//#endif 


//#if 1396303239 
String nomeSolicitante = request.getParameter("nomeSolicitante");
//#endif 


//#if -1083067095 
String ruaSolicitante = request.getParameter("ruaSolicitante");
//#endif 


//#if -1047343117 
String compSolicitante = request.getParameter("compSolicitante");
//#endif 


//#if -26591649 
String bairroSolicitante = request.getParameter("bairroSolicitante");
//#endif 


//#if -425068195 
String cidadeSolicitante = request.getParameter("cidadeSolicitante");
//#endif 


//#if 1444891447 
String ufSolicitante = request.getParameter("ufSolicitante");
//#endif 


//#if -2069588183 
String cepSolicitante = request.getParameter("cepSolicitante ");
//#endif 


//#if -791824663 
String telefoneSolicitante = request.getParameter("telefoneSolicitante");
//#endif 


//#if 1911616888 
Address endSolicitante = new Address(ruaSolicitante, compSolicitante,cepSolicitante,ufSolicitante,
                                                 telefoneSolicitante,cidadeSolicitante, bairroSolicitante);
//#endif 


//#if -931709591 
String emailSolicitante = request.getParameter("emailSolicitante");
//#endif 


//#if -524239801 
String ruaVitima = request.getParameter("ruaVitima");
//#endif 


//#if 553649769 
String compVitima = request.getParameter("compVitima");
//#endif 


//#if 792043177 
String bairroVitima = request.getParameter("bairroVitima");
//#endif 


//#if -1906871543 
String cidadeVitima = request.getParameter("cidadeVitima");
//#endif 


//#if 1838587433 
String ufVitima = request.getParameter("ufVitima");
//#endif 


//#if 509052071 
String cepVitima = request.getParameter("cepVitima ");
//#endif 


//#if -905730423 
String telefoneVitima = request.getParameter("telefoneVitima");
//#endif 


//#if -1968813650 
Address endVitima = new Address(ruaVitima, compVitima,cepVitima, ufVitima,telefoneVitima,
                                            cidadeVitima, bairroVitima);
//#endif 


//#if 534973708 
short qtdeComensais = Short.parseShort(request.getParameter("qtdeComensais"));
//#endif 


//#if 1604723340 
short qtdeDoentes = Short.parseShort(request.getParameter("qtdeDoentes"));
//#endif 


//#if 192018476 
short qtdeInternacoes = Short.parseShort(request.getParameter("qtdeInternacoes"));
//#endif 


//#if 282084048 
short qtdeObitos = Short.parseShort(request.getParameter("qtdeObitos"));
//#endif 


//#if 1208210729 
String localAtendimento = request.getParameter("localAtendimento");
//#endif 


//#if -1415596855 
String refeicaoSuspeita = request.getParameter("refeicaoSuspeita");
//#endif 


//#if 1924690511 
Calendar agora = Calendar.getInstance();
//#endif 


//#if -1007917330 
Complaint queixa = new FoodComplaint(nomeSolicitante, descricaoQueixa, observacaoQueixa,emailSolicitante,
                                                 null, 1, null, new Date(agora.get(Calendar.DAY_OF_MONTH),
                                                         agora.get(Calendar.MONTH),
                                                         agora.get(Calendar.YEAR)),
                                                 endSolicitante, qtdeComensais, qtdeDoentes, qtdeInternacoes,
                                                 qtdeObitos, localAtendimento, refeicaoSuspeita, endVitima);
//#endif 


//#if 805296555 
int codigo = facade.insertComplaint(queixa);
//#endif 


//#if 22365463 
out.println(HTMLCode.htmlPage("Complaint inserted","<p> <h2> Food Complaint inserted</h2> </p>" +"<p> <h2> Save the complaint number: " + codigo + "</h2> </p>"));
//#endif 

} 

//#if -1644920106 
catch(RemoteException e) //1
{ 

//#if 1687364911 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif 


//#if -1814932379 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 458704346 
catch (RepositoryException e) //1
{ 

//#if 698171109 
out.println(HTMLCode.errorPage("Problemas com o banco de dados"));
//#endif 


//#if 402799019 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1995790794 
catch (TransactionException e) //1
{ 

//#if 1988544192 
out.println(HTMLCode.errorPage("Erro no mecanismo de persist?ncia"));
//#endif 


//#if 1782484962 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 576940157 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if 717382144 
out.println(HTMLCode.errorPage("Esta queixa jah existe no BD"));
//#endif 


//#if 333740862 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1860950440 
catch (ObjectNotValidException e) //1
{ 

//#if -1588699982 
out.println(HTMLCode.errorPage("Erro ao inserir esta queixa"));
//#endif 


//#if -1755080178 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -840644286 
catch (CommunicationException e) //1
{ 

//#if -488732092 
out.println(HTMLCode.errorPage("Erro ao inserir esta queixa"));
//#endif 


//#if 804006048 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -663130512 
catch(Exception e) //1
{ 

//#if -1051595928 
e.printStackTrace();
//#endif 


//#if 900612692 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif 


//#if -536346870 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if -2123450949 
out.println(HTMLCode.close());
//#endif 


//#if 1614618319 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

