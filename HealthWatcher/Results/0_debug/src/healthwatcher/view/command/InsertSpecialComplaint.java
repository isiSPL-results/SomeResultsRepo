
//#if 1528209547 
// Compilation Unit of /InsertSpecialComplaint.java 
 

//#if -1620410900 
package healthwatcher.view.command;
//#endif 


//#if -1957942336 
import healthwatcher.model.address.Address;
//#endif 


//#if 2137637586 
import healthwatcher.model.complaint.Complaint;
//#endif 


//#if -1170131353 
import healthwatcher.model.complaint.SpecialComplaint;
//#endif 


//#if 589924935 
import healthwatcher.view.IFacade;
//#endif 


//#if 115103162 
import java.io.IOException;
//#endif 


//#if 735323395 
import java.io.PrintWriter;
//#endif 


//#if 1698735314 
import java.rmi.RemoteException;
//#endif 


//#if -1401510063 
import java.util.Calendar;
//#endif 


//#if 979921773 
import lib.exceptions.CommunicationException;
//#endif 


//#if 127644456 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 1526956393 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if 1531546475 
import lib.exceptions.RepositoryException;
//#endif 


//#if 170300213 
import lib.exceptions.TransactionException;
//#endif 


//#if -2114625674 
import lib.util.Date;
//#endif 


//#if -1841844276 
import lib.util.HTMLCode;
//#endif 


//#if -394397331 
import lib.exceptions.FacadeUnavailableException;
//#endif 


//#if -1055302797 
public class InsertSpecialComplaint extends 
//#if 489745407 
Command
//#endif 

  { 

//#if -1926021331 
public void execute()
    { 

//#if 312436073 
PrintWriter out = null;
//#endif 


//#if 954439226 
try //1
{ 

//#if -418308455 
out = response.getWriter();
//#endif 

} 

//#if -1941200228 
catch (IOException e1) //1
{ 

//#if 1505148268 
e1.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if -1602578757 
response.setContentType("text/html");
//#endif 


//#if 1015558711 
try //2
{ 

//#if -1819310602 
String descricaoQueixa = request.getParameter("descricaoQueixa");
//#endif 


//#if -968877192 
String observacaoQueixa = request.getParameter("observacaoQueixa");
//#endif 


//#if 1732882422 
String nomeSolicitante = request.getParameter("nomeSolicitante");
//#endif 


//#if -528527528 
String ruaSolicitante = request.getParameter("ruaSolicitante");
//#endif 


//#if -710763934 
String compSolicitante = request.getParameter("compSolicitante");
//#endif 


//#if -1751041714 
String bairroSolicitante = request
                                       .getParameter("bairroSolicitante");
//#endif 


//#if 2145449036 
String cidadeSolicitante = request
                                       .getParameter("cidadeSolicitante");
//#endif 


//#if 886809894 
String ufSolicitante = request.getParameter("ufSolicitante");
//#endif 


//#if -1515048616 
String cepSolicitante = request.getParameter("cepSolicitante ");
//#endif 


//#if -1356881320 
String telefoneSolicitante = request
                                         .getParameter("telefoneSolicitante");
//#endif 


//#if 1386136599 
String descricaoQueixa = request.getInput("descricaoQueixa");
//#endif 


//#if -1940412809 
String observacaoQueixa = request.getInput("observacaoQueixa");
//#endif 


//#if 255553047 
String nomeSolicitante = request.getInput("nomeSolicitante");
//#endif 


//#if -576853097 
String ruaSolicitante = request.getInput("ruaSolicitante");
//#endif 


//#if 2080326531 
String compSolicitante = request.getInput("compSolicitante");
//#endif 


//#if 1132140847 
String bairroSolicitante = request
                                       .getInput("bairroSolicitante");
//#endif 


//#if -790320211 
String cidadeSolicitante = request
                                       .getInput("cidadeSolicitante");
//#endif 


//#if 101290887 
String ufSolicitante = request.getInput("ufSolicitante");
//#endif 


//#if -1883478633 
String cepSolicitante = request.getInput("cepSolicitante ");
//#endif 


//#if -169527175 
String telefoneSolicitante = request
                                         .getInput("telefoneSolicitante");
//#endif 


//#if 1020340967 
Address endSolicitante = new Address(ruaSolicitante,
                                                 compSolicitante, cepSolicitante, ufSolicitante,
                                                 telefoneSolicitante, cidadeSolicitante, bairroSolicitante);
//#endif 


//#if 398338072 
String emailSolicitante = request.getParameter("emailSolicitante");
//#endif 


//#if 702318493 
short idade = Short.parseShort(request.getParameter("idade"));
//#endif 


//#if 468758426 
String instrucao = request.getParameter("instrucao");
//#endif 


//#if 780937496 
String ocupacao = request.getParameter("ocupacao");
//#endif 


//#if -628273920 
String ruaOcorrencia = request.getParameter("ruaOcorrencia");
//#endif 


//#if 503471288 
String compOcorrencia = request.getParameter("compOcorrencia");
//#endif 


//#if -782899272 
String bairroOcorrencia = request.getParameter("bairroOcorrencia");
//#endif 


//#if 2080167064 
String cidadeOcorrencia = request.getParameter("cidadeOcorrencia");
//#endif 


//#if 1648559544 
String ufOcorrencia = request.getParameter("ufOcorrencia");
//#endif 


//#if -2116596384 
String cepOcorrencia = request.getParameter("cepOcorrencia ");
//#endif 


//#if 1829122776 
String telefoneOcorrencia = request
                                        .getParameter("telefoneOcorrencia");
//#endif 


//#if -211734121 
String emailSolicitante = request.getInput("emailSolicitante");
//#endif 


//#if 1704334556 
short idade = Short.parseShort(request.getInput("idade"));
//#endif 


//#if -1959279749 
String instrucao = request.getInput("instrucao");
//#endif 


//#if 542000535 
String ocupacao = request.getInput("ocupacao");
//#endif 


//#if -1586652703 
String ruaOcorrencia = request.getInput("ruaOcorrencia");
//#endif 


//#if -1398486665 
String compOcorrencia = request.getInput("compOcorrencia");
//#endif 


//#if 1972755383 
String bairroOcorrencia = request.getInput("bairroOcorrencia");
//#endif 


//#if 217481239 
String cidadeOcorrencia = request.getInput("cidadeOcorrencia");
//#endif 


//#if -669563081 
String ufOcorrencia = request.getInput("ufOcorrencia");
//#endif 


//#if 732508737 
String cepOcorrencia = request.getInput("cepOcorrencia ");
//#endif 


//#if -217715305 
String telefoneOcorrencia = request
                                        .getInput("telefoneOcorrencia");
//#endif 


//#if -407297165 
Address endOcorrencia = new Address(ruaOcorrencia, compOcorrencia,
                                                cepOcorrencia, ufOcorrencia, telefoneOcorrencia,
                                                cidadeOcorrencia, bairroOcorrencia);
//#endif 


//#if -1427971840 
Calendar agora = Calendar.getInstance();
//#endif 


//#if -834034571 
Complaint queixa = new SpecialComplaint(nomeSolicitante,
                                                    descricaoQueixa, observacaoQueixa, emailSolicitante, null,
                                                    1, null, new Date(agora.get(Calendar.DAY_OF_MONTH), agora
                                                            .get(Calendar.MONTH), agora.get(Calendar.YEAR)),
                                                    endSolicitante, idade, instrucao, ocupacao, endOcorrencia);
//#endif 


//#if 1526826972 
int codigo = facade.insertComplaint(queixa);
//#endif 


//#if -731413839 
out.println(HTMLCode.htmlPage("Complaint inserted",
                                          "<p> <h2> Special Complaint inserted</h2> </p>"
                                          + "<p> <h2> Save the complaint number: " + codigo
                                          + "</h2> </p>"));
//#endif 

} 

//#if -1596042605 
catch (RemoteException e) //1
{ 

//#if -1609991929 
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
//#endif 


//#if -1225409475 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -248975593 
catch (RepositoryException e) //1
{ 

//#if -1065262536 
out.println(HTMLCode.errorPage("Problemas com o banco de dados"));
//#endif 


//#if 995042110 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1532549165 
catch (TransactionException e) //1
{ 

//#if -794836039 
out
            .println(HTMLCode
                     .errorPage("Erro no mecanismo de persist?ncia"));
//#endif 


//#if -59841509 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1265796896 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if -183571889 
out.println(HTMLCode.errorPage("Esta queixa jah existe no BD"));
//#endif 


//#if -1191018739 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1732569365 
catch (ObjectNotValidException e) //1
{ 

//#if -1773203337 
out.println(HTMLCode.errorPage("Erro ao inserir esta queixa"));
//#endif 


//#if -979809197 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 660749029 
catch (CommunicationException e) //1
{ 

//#if -1613308485 
out.println(HTMLCode.errorPage("Erro ao inserir esta queixa"));
//#endif 


//#if 594570135 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 66392045 
catch (Exception e) //1
{ 

//#if 2009592478 
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
//#endif 


//#if -329528748 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if -1132498178 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1537171893 
public void execute() throws Exception
    { 

//#if 1756984261 
PrintWriter out = response.getWriter();
//#endif 


//#if -276632116 
try //1
{ 

//#if -583262513 
String descricaoQueixa = request.getInput("descricaoQueixa");
//#endif 


//#if -452381905 
String observacaoQueixa = request.getInput("observacaoQueixa");
//#endif 


//#if -1713846065 
String nomeSolicitante = request.getInput("nomeSolicitante");
//#endif 


//#if 516068431 
String ruaSolicitante = request.getInput("ruaSolicitante");
//#endif 


//#if 110927419 
String compSolicitante = request.getInput("compSolicitante");
//#endif 


//#if 905730023 
String bairroSolicitante = request
                                       .getInput("bairroSolicitante");
//#endif 


//#if -1016731035 
String cidadeSolicitante = request
                                       .getInput("cidadeSolicitante");
//#endif 


//#if -214889921 
String ufSolicitante = request.getInput("ufSolicitante");
//#endif 


//#if -790557105 
String cepSolicitante = request.getInput("cepSolicitante ");
//#endif 


//#if 867719985 
String telefoneSolicitante = request
                                         .getInput("telefoneSolicitante");
//#endif 


//#if -744619617 
Address endSolicitante = new Address(ruaSolicitante,
                                                 compSolicitante, cepSolicitante, ufSolicitante,
                                                 telefoneSolicitante, cidadeSolicitante, bairroSolicitante);
//#endif 


//#if 1276296783 
String emailSolicitante = request.getInput("emailSolicitante");
//#endif 


//#if 492664100 
short idade = Short.parseShort(request.getInput("idade"));
//#endif 


//#if -1195544013 
String instrucao = request.getInput("instrucao");
//#endif 


//#if -1973403057 
String ocupacao = request.getInput("ocupacao");
//#endif 


//#if -1902833511 
String ruaOcorrencia = request.getInput("ruaOcorrencia");
//#endif 


//#if -305565137 
String compOcorrencia = request.getInput("compOcorrencia");
//#endif 


//#if -834181009 
String bairroOcorrencia = request.getInput("bairroOcorrencia");
//#endif 


//#if 1705512143 
String cidadeOcorrencia = request.getInput("cidadeOcorrencia");
//#endif 


//#if -1885533201 
String ufOcorrencia = request.getInput("ufOcorrencia");
//#endif 


//#if 416327929 
String cepOcorrencia = request.getInput("cepOcorrencia ");
//#endif 


//#if 1244814927 
String telefoneOcorrencia = request
                                        .getInput("telefoneOcorrencia");
//#endif 


//#if -364629461 
Address endOcorrencia = new Address(ruaOcorrencia, compOcorrencia,
                                                cepOcorrencia, ufOcorrencia, telefoneOcorrencia,
                                                cidadeOcorrencia, bairroOcorrencia);
//#endif 


//#if 223560520 
Calendar agora = Calendar.getInstance();
//#endif 


//#if -249074899 
Complaint queixa = new SpecialComplaint(nomeSolicitante,
                                                    descricaoQueixa, observacaoQueixa, emailSolicitante, null,
                                                    1, null, new Date(agora.get(Calendar.DAY_OF_MONTH), agora
                                                            .get(Calendar.MONTH), agora.get(Calendar.YEAR)),
                                                    endSolicitante, idade, instrucao, ocupacao, endOcorrencia);
//#endif 


//#if 1852278308 
int codigo = facade.insertComplaint(queixa);
//#endif 


//#if -829364487 
out.println(HTMLCode.htmlPage("Complaint inserted",
                                          "<p> <h2> Special Complaint inserted</h2> </p>"
                                          + "<p> <h2> Save the complaint number: " + codigo
                                          + "</h2> </p>"));
//#endif 

} 

//#if 798440122 
catch (RepositoryException e) //1
{ 

//#if -171547633 
out.println(HTMLCode.errorPage("Problemas com o banco de dados"));
//#endif 


//#if -367120811 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -357302038 
catch (TransactionException e) //1
{ 

//#if -1453232412 
out
            .println(HTMLCode
                     .errorPage("Erro no mecanismo de persist?ncia"));
//#endif 


//#if -1621105402 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1305716637 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if -673224015 
out.println(HTMLCode.errorPage("Esta queixa jah existe no BD"));
//#endif 


//#if -1742436241 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -393303240 
catch (ObjectNotValidException e) //1
{ 

//#if -45186295 
out.println(HTMLCode.errorPage("Erro ao inserir esta queixa"));
//#endif 


//#if 810524645 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1284909154 
catch (CommunicationException e) //1
{ 

//#if 1971012939 
throw new FacadeUnavailableException();
//#endif 

} 

//#endif 


//#if -983827632 
catch (Exception e) //1
{ 

//#if 1859244996 
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
//#endif 


//#if -2136418182 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1157253406 
public InsertSpecialComplaint(IFacade f)
    { 

//#if 1849439599 
super(f);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

