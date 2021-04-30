
//#if -1631813492 
// Compilation Unit of /InsertFoodComplaint.java 
 

//#if -1659920952 
package healthwatcher.view.command;
//#endif 


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


//#if 1910890472 
public class InsertFoodComplaint extends 
//#if 1680071140 
Command
//#endif 

  { 

//#if 1344276194 
public InsertFoodComplaint(IFacade f)
    { 

//#if 1061122974 
super(f);
//#endif 

} 

//#endif 


//#if -1587577454 
public void execute()
    { 

//#if -1036273595 
PrintWriter out = null;
//#endif 


//#if -408823274 
try //1
{ 

//#if -702891469 
out = response.getWriter();
//#endif 

} 

//#if -1780236789 
catch (IOException e1) //1
{ 

//#if 2010658899 
e1.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if 1143658335 
response.setContentType("text/html");
//#endif 


//#if 1273172187 
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


//#if 1389011049 
Address endSolicitante = new Address(ruaSolicitante,
                                                 compSolicitante, cepSolicitante, ufSolicitante,
                                                 telefoneSolicitante, cidadeSolicitante, bairroSolicitante);
//#endif 


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


//#if 1020426655 
Address endVitima = new Address(ruaVitima, compVitima, cepVitima,
                                            ufVitima, telefoneVitima, cidadeVitima, bairroVitima);
//#endif 


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


//#if -278571202 
Calendar agora = Calendar.getInstance();
//#endif 


//#if 1357467357 
Complaint queixa = new FoodComplaint(nomeSolicitante,
                                                 descricaoQueixa, observacaoQueixa, emailSolicitante, null,
                                                 1, null, new Date(agora.get(Calendar.DAY_OF_MONTH), agora
                                                         .get(Calendar.MONTH), agora.get(Calendar.YEAR)),
                                                 endSolicitante, qtdeComensais, qtdeDoentes,
                                                 qtdeInternacoes, qtdeObitos, localAtendimento,
                                                 refeicaoSuspeita, endVitima);
//#endif 


//#if 281194266 
int codigo = facade.insertComplaint(queixa);
//#endif 


//#if -977127224 
out.println(HTMLCode.htmlPage("Complaint inserted",
                                          "<p> <h2> Food Complaint inserted</h2> </p>"
                                          + "<p> <h2> Save the complaint number: " + codigo
                                          + "</h2> </p>"));
//#endif 

} 

//#if -597574862 
catch (RemoteException e) //1
{ 

//#if -506341696 
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
//#endif 


//#if -1218650762 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1970860086 
catch (RepositoryException e) //1
{ 

//#if -2034284891 
out.println(HTMLCode.errorPage("Problemas com o banco de dados"));
//#endif 


//#if 226759019 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1627978478 
catch (TransactionException e) //1
{ 

//#if -1162532379 
out
            .println(HTMLCode
                     .errorPage("Erro no mecanismo de persist?ncia"));
//#endif 


//#if 47808839 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1790251871 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if -1283700457 
out.println(HTMLCode.errorPage("Esta queixa jah existe no BD"));
//#endif 


//#if 2059117013 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1398882996 
catch (ObjectNotValidException e) //1
{ 

//#if 1332073140 
out.println(HTMLCode.errorPage("Erro ao inserir esta queixa"));
//#endif 


//#if -647567088 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -2120961690 
catch (CommunicationException e) //1
{ 

//#if 1796986064 
out.println(HTMLCode.errorPage("Erro ao inserir esta queixa"));
//#endif 


//#if 1387383084 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -572580916 
catch (Exception e) //1
{ 

//#if -555330531 
e.printStackTrace();
//#endif 


//#if 2042926847 
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
//#endif 


//#if 428662325 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if 1429925804 
out.println(HTMLCode.close());
//#endif 


//#if -570055936 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1010560176 
public void execute() throws Exception
    { 

//#if 134314836 
PrintWriter out = response.getWriter();
//#endif 


//#if -1482536549 
try //1
{ 

//#if 1741147385 
String descricaoQueixa = request.getInput("descricaoQueixa");
//#endif 


//#if -77463847 
String observacaoQueixa = request.getInput("observacaoQueixa");
//#endif 


//#if 610563833 
String nomeSolicitante = request.getInput("nomeSolicitante");
//#endif 


//#if 433571065 
String ruaSolicitante = request.getInput("ruaSolicitante");
//#endif 


//#if -1859629979 
String compSolicitante = request.getInput("compSolicitante");
//#endif 


//#if 424730897 
String bairroSolicitante = request
                                       .getInput("bairroSolicitante");
//#endif 


//#if -1497730161 
String cidadeSolicitante = request
                                       .getInput("cidadeSolicitante");
//#endif 


//#if -1068606103 
String ufSolicitante = request.getInput("ufSolicitante");
//#endif 


//#if -873054471 
String cepSolicitante = request.getInput("cepSolicitante ");
//#endif 


//#if -638566565 
String telefoneSolicitante = request
                                         .getInput("telefoneSolicitante");
//#endif 


//#if -1096426295 
Address endSolicitante = new Address(ruaSolicitante,
                                                 compSolicitante, cepSolicitante, ufSolicitante,
                                                 telefoneSolicitante, cidadeSolicitante, bairroSolicitante);
//#endif 


//#if 1651214841 
String emailSolicitante = request.getInput("emailSolicitante");
//#endif 


//#if -1976701959 
String ruaVitima = request.getInput("ruaVitima");
//#endif 


//#if 165013945 
String compVitima = request.getInput("compVitima");
//#endif 


//#if 1458886841 
String bairroVitima = request.getInput("bairroVitima");
//#endif 


//#if -2051021671 
String cidadeVitima = request.getInput("cidadeVitima");
//#endif 


//#if 1485489849 
String ufVitima = request.getInput("ufVitima");
//#endif 


//#if 567168089 
String cepVitima = request.getInput("cepVitima ");
//#endif 


//#if -641583399 
String telefoneVitima = request.getInput("telefoneVitima");
//#endif 


//#if -1964403201 
Address endVitima = new Address(ruaVitima, compVitima, cepVitima,
                                            ufVitima, telefoneVitima, cidadeVitima, bairroVitima);
//#endif 


//#if 969883674 
short qtdeComensais = Short.parseShort(request
                                                   .getInput("qtdeComensais"));
//#endif 


//#if 1093546714 
short qtdeDoentes = Short.parseShort(request
                                                 .getInput("qtdeDoentes"));
//#endif 


//#if 178539642 
short qtdeInternacoes = Short.parseShort(request
                                    .getInput("qtdeInternacoes"));
//#endif 


//#if -1103012864 
short qtdeObitos = Short.parseShort(request
                                                .getInput("qtdeObitos"));
//#endif 


//#if 2056833209 
String localAtendimento = request.getInput("localAtendimento");
//#endif 


//#if 2109608665 
String refeicaoSuspeita = request.getInput("refeicaoSuspeita");
//#endif 


//#if -1074278690 
Calendar agora = Calendar.getInstance();
//#endif 


//#if 188933757 
Complaint queixa = new FoodComplaint(nomeSolicitante,
                                                 descricaoQueixa, observacaoQueixa, emailSolicitante, null,
                                                 1, null, new Date(agora.get(Calendar.DAY_OF_MONTH), agora
                                                         .get(Calendar.MONTH), agora.get(Calendar.YEAR)),
                                                 endSolicitante, qtdeComensais, qtdeDoentes,
                                                 qtdeInternacoes, qtdeObitos, localAtendimento,
                                                 refeicaoSuspeita, endVitima);
//#endif 


//#if -569354566 
int codigo = facade.insertComplaint(queixa);
//#endif 


//#if 341458216 
out.println(HTMLCode.htmlPage("Complaint inserted",
                                          "<p> <h2> Food Complaint inserted</h2> </p>"
                                          + "<p> <h2> Save the complaint number: " + codigo
                                          + "</h2> </p>"));
//#endif 


//#if -1142305780 
out.println(HTMLCode.close());
//#endif 

} 

//#if 936749825 
catch (RepositoryException e) //1
{ 

//#if 761602489 
out.println(HTMLCode.errorPage("Problemas com o banco de dados"));
//#endif 


//#if -1779557505 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -364668541 
catch (TransactionException e) //1
{ 

//#if -1400063740 
out
            .println(HTMLCode
                     .errorPage("Erro no mecanismo de persist?ncia"));
//#endif 


//#if -580135130 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 762582262 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if 1063416869 
out.println(HTMLCode.errorPage("Esta queixa jah existe no BD"));
//#endif 


//#if 2025405411 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -805462017 
catch (ObjectNotValidException e) //1
{ 

//#if 1732037849 
out.println(HTMLCode.errorPage("Erro ao inserir esta queixa"));
//#endif 


//#if 650547637 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1499332933 
catch (CommunicationException e) //1
{ 

//#if -2078660202 
throw new FacadeUnavailableException();
//#endif 

} 

//#endif 


//#if -1552562089 
catch (Exception e) //1
{ 

//#if 1562737179 
e.printStackTrace();
//#endif 


//#if -1720276671 
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
//#endif 


//#if -1875701897 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

