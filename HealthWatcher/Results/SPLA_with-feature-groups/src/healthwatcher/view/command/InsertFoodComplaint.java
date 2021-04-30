
//#if -1631813492 
// Compilation Unit of /InsertFoodComplaint.java 
 
package healthwatcher.view.command;

//#if -936267876 
import healthwatcher.model.address.Address;
//#endif 


//#if 66189486 
import healthwatcher.model.complaint.Complaint;
//#endif 


//#if 133985452 
import healthwatcher.model.complaint.FoodComplaint;
//#endif 


//#if -1766654229 
import healthwatcher.view.IFacade;
//#endif 


//#if 1553797526 
import java.io.IOException;
//#endif 


//#if -2120949537 
import java.io.PrintWriter;
//#endif 


//#if 958853750 
import java.rmi.RemoteException;
//#endif 


//#if -939458571 
import java.util.Calendar;
//#endif 


//#if -738432951 
import lib.exceptions.CommunicationException;
//#endif 


//#if 641930244 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if -202432499 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if 871767055 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1191974673 
import lib.exceptions.TransactionException;
//#endif 


//#if 1987522642 
import lib.util.Date;
//#endif 


//#if -580013400 
import lib.util.HTMLCode;
//#endif 


//#if 1808803913 
import lib.exceptions.FacadeUnavailableException;
//#endif 

public class InsertFoodComplaint extends Command
  { 
public InsertFoodComplaint(IFacade f)
    { 
super(f);
} 


//#if -1587577454 
public void execute()
    { 
PrintWriter out = null;
try //1
{ 
out = response.getWriter();
} 

//#if -1780236789 
catch (IOException e1) //1
{ 
e1.printStackTrace();
} 

//#endif 



//#if 1143658335 
response.setContentType("text/html");
//#endif 

try //2
{ 

//#if -1539313288 
String descricaoQueixa = request.getParameter("descricaoQueixa");
//#endif 


//#if 1820569210 
String observacaoQueixa = request.getParameter("observacaoQueixa");
//#endif 


//#if 2012879736 
String nomeSolicitante = request.getParameter("nomeSolicitante");
//#endif 


//#if 1777906522 
String ruaSolicitante = request.getParameter("ruaSolicitante");
//#endif 


//#if -430766620 
String compSolicitante = request.getParameter("compSolicitante");
//#endif 


//#if -1152642096 
String bairroSolicitante = request
                                       .getParameter("bairroSolicitante");
//#endif 


//#if -1551118642 
String cidadeSolicitante = request
                                       .getParameter("cidadeSolicitante");
//#endif 


//#if 1845633448 
String ufSolicitante = request.getParameter("ufSolicitante");
//#endif 


//#if 791385434 
String cepSolicitante = request.getParameter("cepSolicitante ");
//#endif 


//#if -185242662 
String telefoneSolicitante = request
                                         .getParameter("telefoneSolicitante");
//#endif 


//#if -1950007143 
String descricaoQueixa = request.getInput("descricaoQueixa");
//#endif 


//#if 366021241 
String observacaoQueixa = request.getInput("observacaoQueixa");
//#endif 


//#if 1214376601 
String nomeSolicitante = request.getInput("nomeSolicitante");
//#endif 


//#if -1478647655 
String ruaSolicitante = request.getInput("ruaSolicitante");
//#endif 


//#if -1255817211 
String compSolicitante = request.getInput("compSolicitante");
//#endif 


//#if 1412138161 
String bairroSolicitante = request
                                       .getInput("bairroSolicitante");
//#endif 


//#if -510322897 
String cidadeSolicitante = request
                                       .getInput("cidadeSolicitante");
//#endif 


//#if -279535351 
String ufSolicitante = request.getInput("ufSolicitante");
//#endif 


//#if 1509694105 
String cepSolicitante = request.getInput("cepSolicitante ");
//#endif 


//#if 428872443 
String telefoneSolicitante = request
                                         .getInput("telefoneSolicitante");
//#endif 

Address endSolicitante = new Address(ruaSolicitante,
                                                 compSolicitante, cepSolicitante, ufSolicitante,
                                                 telefoneSolicitante, cidadeSolicitante, bairroSolicitante);

//#if -1107182822 
String emailSolicitante = request.getParameter("emailSolicitante");
//#endif 


//#if -1053453384 
String ruaVitima = request.getParameter("ruaVitima");
//#endif 


//#if -1214462566 
String compVitima = request.getParameter("compVitima");
//#endif 


//#if -1643291302 
String bairroVitima = request.getParameter("bairroVitima");
//#endif 


//#if -47238726 
String cidadeVitima = request.getParameter("cidadeVitima");
//#endif 


//#if -208888358 
String ufVitima = request.getParameter("ufVitima");
//#endif 


//#if -20161512 
String cepVitima = request.getParameter("cepVitima ");
//#endif 


//#if 1955243194 
String telefoneVitima = request.getParameter("telefoneVitima");
//#endif 


//#if 2094699929 
String emailSolicitante = request.getInput("emailSolicitante");
//#endif 


//#if 84135833 
String ruaVitima = request.getInput("ruaVitima");
//#endif 


//#if 650208601 
String compVitima = request.getInput("compVitima");
//#endif 


//#if -730233767 
String bairroVitima = request.getInput("bairroVitima");
//#endif 


//#if 54825017 
String cidadeVitima = request.getInput("cidadeVitima");
//#endif 


//#if -121302439 
String ufVitima = request.getInput("ufVitima");
//#endif 


//#if -1666961415 
String cepVitima = request.getInput("cepVitima ");
//#endif 


//#if 1741165177 
String telefoneVitima = request.getInput("telefoneVitima");
//#endif 

Address endVitima = new Address(ruaVitima, compVitima, cepVitima,
                                            ufVitima, telefoneVitima, cidadeVitima, bairroVitima);

//#if 1068222139 
short qtdeComensais = Short.parseShort(request
                                                   .getParameter("qtdeComensais"));
//#endif 


//#if -1066071109 
short qtdeDoentes = Short.parseShort(request
                                                 .getParameter("qtdeDoentes"));
//#endif 


//#if 1071137371 
short qtdeInternacoes = Short.parseShort(request
                                    .getParameter("qtdeInternacoes"));
//#endif 


//#if 2102766527 
short qtdeObitos = Short.parseShort(request
                                                .getParameter("qtdeObitos"));
//#endif 


//#if 1032737498 
String localAtendimento = request.getParameter("localAtendimento");
//#endif 


//#if -1591070086 
String refeicaoSuspeita = request.getParameter("refeicaoSuspeita");
//#endif 


//#if 86159482 
short qtdeComensais = Short.parseShort(request
                                                   .getInput("qtdeComensais"));
//#endif 


//#if -175582406 
short qtdeDoentes = Short.parseShort(request
                                                 .getInput("qtdeDoentes"));
//#endif 


//#if 604540122 
short qtdeInternacoes = Short.parseShort(request
                                    .getInput("qtdeInternacoes"));
//#endif 


//#if -1484221344 
short qtdeObitos = Short.parseShort(request
                                                .getInput("qtdeObitos"));
//#endif 


//#if -1794648999 
String localAtendimento = request.getInput("localAtendimento");
//#endif 


//#if -1741873543 
String refeicaoSuspeita = request.getInput("refeicaoSuspeita");
//#endif 

Calendar agora = Calendar.getInstance();
Complaint queixa = new FoodComplaint(nomeSolicitante,
                                                 descricaoQueixa, observacaoQueixa, emailSolicitante, null,
                                                 1, null, new Date(agora.get(Calendar.DAY_OF_MONTH), agora
                                                         .get(Calendar.MONTH), agora.get(Calendar.YEAR)),
                                                 endSolicitante, qtdeComensais, qtdeDoentes,
                                                 qtdeInternacoes, qtdeObitos, localAtendimento,
                                                 refeicaoSuspeita, endVitima);
int codigo = facade.insertComplaint(queixa);
out.println(HTMLCode.htmlPage("Complaint inserted",
                                          "<p> <h2> Food Complaint inserted</h2> </p>"
                                          + "<p> <h2> Save the complaint number: " + codigo
                                          + "</h2> </p>"));
} 

//#if -597574862 
catch (RemoteException e) //1
{ 
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
e.printStackTrace(out);
} 

//#endif 


//#if 1970860086 
catch (RepositoryException e) //1
{ 
out.println(HTMLCode.errorPage("Problemas com o banco de dados"));
e.printStackTrace(out);
} 

//#endif 


//#if 1627978478 
catch (TransactionException e) //1
{ 
out
            .println(HTMLCode
                     .errorPage("Erro no mecanismo de persist?ncia"));
e.printStackTrace(out);
} 

//#endif 


//#if -1790251871 
catch (ObjectAlreadyInsertedException e) //1
{ 
out.println(HTMLCode.errorPage("Esta queixa jah existe no BD"));
e.printStackTrace(out);
} 

//#endif 


//#if 1398882996 
catch (ObjectNotValidException e) //1
{ 
out.println(HTMLCode.errorPage("Erro ao inserir esta queixa"));
e.printStackTrace(out);
} 

//#endif 


//#if -2120961690 
catch (CommunicationException e) //1
{ 
out.println(HTMLCode.errorPage("Erro ao inserir esta queixa"));
e.printStackTrace(out);
} 

//#endif 


//#if -572580916 
catch (Exception e) //1
{ 
e.printStackTrace();
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
e.printStackTrace(out);
} 

//#endif 

finally { 
out.println(HTMLCode.close());
out.close();
} 

} 

//#endif 


//#if 1010560176 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
try //1
{ 
String descricaoQueixa = request.getInput("descricaoQueixa");
String observacaoQueixa = request.getInput("observacaoQueixa");
String nomeSolicitante = request.getInput("nomeSolicitante");
String ruaSolicitante = request.getInput("ruaSolicitante");
String compSolicitante = request.getInput("compSolicitante");
String bairroSolicitante = request
                                       .getInput("bairroSolicitante");
String cidadeSolicitante = request
                                       .getInput("cidadeSolicitante");
String ufSolicitante = request.getInput("ufSolicitante");
String cepSolicitante = request.getInput("cepSolicitante ");
String telefoneSolicitante = request
                                         .getInput("telefoneSolicitante");
Address endSolicitante = new Address(ruaSolicitante,
                                                 compSolicitante, cepSolicitante, ufSolicitante,
                                                 telefoneSolicitante, cidadeSolicitante, bairroSolicitante);
String emailSolicitante = request.getInput("emailSolicitante");
String ruaVitima = request.getInput("ruaVitima");
String compVitima = request.getInput("compVitima");
String bairroVitima = request.getInput("bairroVitima");
String cidadeVitima = request.getInput("cidadeVitima");
String ufVitima = request.getInput("ufVitima");
String cepVitima = request.getInput("cepVitima ");
String telefoneVitima = request.getInput("telefoneVitima");
Address endVitima = new Address(ruaVitima, compVitima, cepVitima,
                                            ufVitima, telefoneVitima, cidadeVitima, bairroVitima);
short qtdeComensais = Short.parseShort(request
                                                   .getInput("qtdeComensais"));
short qtdeDoentes = Short.parseShort(request
                                                 .getInput("qtdeDoentes"));
short qtdeInternacoes = Short.parseShort(request
                                    .getInput("qtdeInternacoes"));
short qtdeObitos = Short.parseShort(request
                                                .getInput("qtdeObitos"));
String localAtendimento = request.getInput("localAtendimento");
String refeicaoSuspeita = request.getInput("refeicaoSuspeita");
Calendar agora = Calendar.getInstance();
Complaint queixa = new FoodComplaint(nomeSolicitante,
                                                 descricaoQueixa, observacaoQueixa, emailSolicitante, null,
                                                 1, null, new Date(agora.get(Calendar.DAY_OF_MONTH), agora
                                                         .get(Calendar.MONTH), agora.get(Calendar.YEAR)),
                                                 endSolicitante, qtdeComensais, qtdeDoentes,
                                                 qtdeInternacoes, qtdeObitos, localAtendimento,
                                                 refeicaoSuspeita, endVitima);
int codigo = facade.insertComplaint(queixa);
out.println(HTMLCode.htmlPage("Complaint inserted",
                                          "<p> <h2> Food Complaint inserted</h2> </p>"
                                          + "<p> <h2> Save the complaint number: " + codigo
                                          + "</h2> </p>"));
out.println(HTMLCode.close());
} 
catch (RepositoryException e) //1
{ 
out.println(HTMLCode.errorPage("Problemas com o banco de dados"));
e.printStackTrace(out);
} 

catch (TransactionException e) //1
{ 
out
            .println(HTMLCode
                     .errorPage("Erro no mecanismo de persist?ncia"));
e.printStackTrace(out);
} 

catch (ObjectAlreadyInsertedException e) //1
{ 
out.println(HTMLCode.errorPage("Esta queixa jah existe no BD"));
e.printStackTrace(out);
} 

catch (ObjectNotValidException e) //1
{ 
out.println(HTMLCode.errorPage("Erro ao inserir esta queixa"));
e.printStackTrace(out);
} 

catch (CommunicationException e) //1
{ 
throw new FacadeUnavailableException();
} 

catch (Exception e) //1
{ 
e.printStackTrace();
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
e.printStackTrace(out);
} 


} 

//#endif 

 } 


//#endif 

