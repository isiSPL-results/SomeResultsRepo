
//#if -1563714736 
// Compilation Unit of /InsertAnimalComplaint.java 
 

//#if 240252787 
package healthwatcher.view.command;
//#endif 


//#if -1413403065 
import healthwatcher.model.address.Address;
//#endif 


//#if 1468479029 
import healthwatcher.model.complaint.AnimalComplaint;
//#endif 


//#if -2130957863 
import healthwatcher.model.complaint.Complaint;
//#endif 


//#if 372851680 
import healthwatcher.view.IFacade;
//#endif 


//#if -576895423 
import java.io.IOException;
//#endif 


//#if 43324810 
import java.io.PrintWriter;
//#endif 


//#if 938733739 
import java.rmi.RemoteException;
//#endif 


//#if -1423832598 
import java.util.Calendar;
//#endif 


//#if 296151092 
import lib.exceptions.CommunicationException;
//#endif 


//#if 865628259 
import lib.exceptions.InvalidDateException;
//#endif 


//#if 667973871 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 1804901762 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if -529097724 
import lib.exceptions.RepositoryException;
//#endif 


//#if 714839484 
import lib.exceptions.TransactionException;
//#endif 


//#if 1983578429 
import lib.util.Date;
//#endif 


//#if -1011280365 
import lib.util.HTMLCode;
//#endif 


//#if -820856140 
import lib.exceptions.FacadeUnavailableException;
//#endif 


//#if -1623292491 
public class InsertAnimalComplaint extends 
//#if -1612269961 
Command
//#endif 

  { 

//#if -655026779 
public void execute()
    { 

//#if -842273045 
PrintWriter out = null;
//#endif 


//#if 1732312517 
Complaint queixa;
//#endif 


//#if 115736953 
response.setContentType("text/html");
//#endif 


//#if 592055100 
try //1
{ 

//#if -1128205817 
out = response.getWriter();
//#endif 

} 

//#if 581918785 
catch (IOException e1) //1
{ 

//#if 1612715923 
e1.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if -1517124107 
try //2
{ 

//#if -1522058069 
String descricaoQueixa = request.getParameter("descricaoQueixa");
//#endif 


//#if 1222965485 
String observacaoQueixa = request.getParameter("observacaoQueixa");
//#endif 


//#if 2030134955 
String nomeSolicitante = request.getParameter("nomeSolicitante");
//#endif 


//#if -1095815347 
String ruaSolicitante = request.getParameter("ruaSolicitante");
//#endif 


//#if -413511401 
String compSolicitante = request.getParameter("compSolicitante");
//#endif 


//#if 75795843 
String bairroSolicitante = request.getParameter("bairroSolicitante");
//#endif 


//#if -322680703 
String cidadeSolicitante = request.getParameter("cidadeSolicitante");
//#endif 


//#if -704840101 
String ufSolicitante = request.getParameter("ufSolicitante");
//#endif 


//#if -2082336435 
String cepSolicitante = request.getParameter("cepSolicitante ");
//#endif 


//#if -1792814067 
String telefoneSolicitante = request.getParameter("telefoneSolicitante");
//#endif 


//#if -205513396 
String descricaoQueixa = request.getInput("descricaoQueixa");
//#endif 


//#if 1787266668 
String observacaoQueixa = request.getInput("observacaoQueixa");
//#endif 


//#if -1336096948 
String nomeSolicitante = request.getInput("nomeSolicitante");
//#endif 


//#if 641601036 
String ruaSolicitante = request.getInput("ruaSolicitante");
//#endif 


//#if 488676536 
String compSolicitante = request.getInput("compSolicitante");
//#endif 


//#if 1429393380 
String bairroSolicitante = request.getInput("bairroSolicitante");
//#endif 


//#if -493067678 
String cidadeSolicitante = request.getInput("cidadeSolicitante");
//#endif 


//#if 1036635964 
String ufSolicitante = request.getInput("ufSolicitante");
//#endif 


//#if -665024500 
String cepSolicitante = request.getInput("cepSolicitante ");
//#endif 


//#if 1657310382 
String telefoneSolicitante = request.getInput("telefoneSolicitante");
//#endif 


//#if 1779772060 
Address endSolicitante = new Address(ruaSolicitante,
                                                 compSolicitante,
                                                 cepSolicitante,
                                                 ufSolicitante,
                                                 telefoneSolicitante,
                                                 cidadeSolicitante,
                                                 bairroSolicitante);
//#endif 


//#if -1704786547 
String emailSolicitante = request.getParameter("emailSolicitante");
//#endif 


//#if -937368755 
String nomeAnimal = request.getParameter("nomeAnimal");
//#endif 


//#if -2012465312 
short qtdeAnimal = Short.parseShort(request.getParameter("qtdeAnimal"));
//#endif 


//#if 917501516 
int diaIncomodo = Integer.parseInt(request.getParameter("diaIncomodo"));
//#endif 


//#if 78000108 
int mesIncomodo = Integer.parseInt(request.getParameter("mesIncomodo"));
//#endif 


//#if -853935988 
int anoIncomodo = Integer.parseInt(request.getParameter("anoIncomodo"));
//#endif 


//#if 2075043381 
String ruaOcorrencia = request.getParameter("ruaOcorrencia");
//#endif 


//#if -63816531 
String compOcorrencia = request.getParameter("compOcorrencia");
//#endif 


//#if 1408943405 
String bairroOcorrencia = request.getParameter("bairroOcorrencia");
//#endif 


//#if -22957555 
String cidadeOcorrencia = request.getParameter("cidadeOcorrencia");
//#endif 


//#if -1427953619 
String ufOcorrencia = request.getParameter("ufOcorrencia");
//#endif 


//#if 586720917 
String cepOcorrencia = request.getParameter("cepOcorrencia ");
//#endif 


//#if 778390989 
String telefoneOcorrencia = request.getParameter("telefoneOcorrencia");
//#endif 


//#if -779021940 
String emailSolicitante = request.getInput("emailSolicitante");
//#endif 


//#if 2026064268 
String nomeAnimal = request.getInput("nomeAnimal");
//#endif 


//#if 195681153 
short qtdeAnimal = Short.parseShort(request.getInput("qtdeAnimal"));
//#endif 


//#if 1843689035 
int diaIncomodo = Integer.parseInt(request.getInput("diaIncomodo"));
//#endif 


//#if -1929758613 
int mesIncomodo = Integer.parseInt(request.getInput("mesIncomodo"));
//#endif 


//#if 278361483 
int anoIncomodo = Integer.parseInt(request.getInput("anoIncomodo"));
//#endif 


//#if -651307626 
String ruaOcorrencia = request.getInput("ruaOcorrencia");
//#endif 


//#if -180032532 
String compOcorrencia = request.getInput("compOcorrencia");
//#endif 


//#if 1405467564 
String bairroOcorrencia = request.getInput("bairroOcorrencia");
//#endif 


//#if -349806580 
String cidadeOcorrencia = request.getInput("cidadeOcorrencia");
//#endif 


//#if 1588390956 
String ufOcorrencia = request.getInput("ufOcorrencia");
//#endif 


//#if 1667853814 
String cepOcorrencia = request.getInput("cepOcorrencia ");
//#endif 


//#if 1974127372 
String telefoneOcorrencia = request.getInput("telefoneOcorrencia");
//#endif 


//#if 1818142760 
Address endOcorrencia = new Address(ruaOcorrencia,
                                                compOcorrencia,
                                                cepOcorrencia,
                                                ufOcorrencia,
                                                telefoneOcorrencia,
                                                cidadeOcorrencia,
                                                bairroOcorrencia);
//#endif 


//#if 1623756971 
Calendar agora              = Calendar.getInstance();
//#endif 


//#if -1577084731 
queixa = new AnimalComplaint(nomeSolicitante, descricaoQueixa, observacaoQueixa,
                                         emailSolicitante, null, 1, null,
                                         new Date(agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH),
                                                  agora.get(Calendar.YEAR)), endSolicitante, qtdeAnimal,
                                         new Date(diaIncomodo, mesIncomodo,anoIncomodo), nomeAnimal,endOcorrencia);
//#endif 


//#if 1105291783 
int codigo = facade.insertComplaint(queixa);
//#endif 


//#if -1829327847 
out.println(HTMLCode.htmlPage("Complaint inserted",
                                          "<p> <h2> Animal Complaint inserted</h2> </p>" +
                                          "<p> <h2> Save the complaint number: " + codigo + "</h2> </p>"));
//#endif 

} 

//#if 542225005 
catch(RemoteException e) //1
{ 

//#if 1657018004 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif 

} 

//#endif 


//#if -975908367 
catch (RepositoryException e) //1
{ 

//#if 158576658 
out.println(HTMLCode.errorPage("Problemas com o banco de dados"));
//#endif 

} 

//#endif 


//#if 472469651 
catch (TransactionException e) //1
{ 

//#if -2065928093 
out.println(HTMLCode.errorPage("Erro no mecanismo de persist?ncia"));
//#endif 

} 

//#endif 


//#if -819185658 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if 991660529 
out.println(HTMLCode.errorPage("Complaint already inserted"));
//#endif 

} 

//#endif 


//#if 1798295279 
catch (ObjectNotValidException e) //1
{ 

//#if -351684725 
out.println(HTMLCode.errorPage("Unespected error. Try to contact the support team."));
//#endif 

} 

//#endif 


//#if -168414773 
catch (CommunicationException e) //1
{ 

//#if 570942707 
out.println(HTMLCode.errorPage("Erro ao inserir esta queixa"));
//#endif 


//#if 2089856719 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1348108218 
catch(InvalidDateException e) //1
{ 

//#if 303003045 
out.println(HTMLCode.errorPage("Invalid date."));
//#endif 

} 

//#endif 

finally { 

//#if -1251752225 
out.println(HTMLCode.close());
//#endif 


//#if -1983057677 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -322776041 
public InsertAnimalComplaint(IFacade f)
    { 

//#if 1371703378 
super(f);
//#endif 

} 

//#endif 


//#if -1583952835 
public void execute() throws Exception
    { 

//#if 1375924873 
PrintWriter out = response.getWriter();
//#endif 


//#if -1607633639 
Complaint queixa;
//#endif 


//#if 1244650384 
try //1
{ 

//#if -1901941849 
String descricaoQueixa = request.getInput("descricaoQueixa");
//#endif 


//#if -687871481 
String observacaoQueixa = request.getInput("observacaoQueixa");
//#endif 


//#if 1262441895 
String nomeSolicitante = request.getInput("nomeSolicitante");
//#endif 


//#if 899053351 
String ruaSolicitante = request.getInput("ruaSolicitante");
//#endif 


//#if -1207751917 
String compSolicitante = request.getInput("compSolicitante");
//#endif 


//#if -2061453121 
String bairroSolicitante = request.getInput("bairroSolicitante");
//#endif 


//#if 311053117 
String cidadeSolicitante = request.getInput("cidadeSolicitante");
//#endif 


//#if 1993327383 
String ufSolicitante = request.getInput("ufSolicitante");
//#endif 


//#if -407572185 
String cepSolicitante = request.getInput("cepSolicitante ");
//#endif 


//#if -1517252599 
String telefoneSolicitante = request.getInput("telefoneSolicitante");
//#endif 


//#if 1597020791 
Address endSolicitante = new Address(ruaSolicitante,
                                                 compSolicitante,
                                                 cepSolicitante,
                                                 ufSolicitante,
                                                 telefoneSolicitante,
                                                 cidadeSolicitante,
                                                 bairroSolicitante);
//#endif 


//#if 1040807207 
String emailSolicitante = request.getInput("emailSolicitante");
//#endif 


//#if 450362791 
String nomeAnimal = request.getInput("nomeAnimal");
//#endif 


//#if -1569292090 
short qtdeAnimal = Short.parseShort(request.getInput("qtdeAnimal"));
//#endif 


//#if 78715792 
int diaIncomodo = Integer.parseInt(request.getInput("diaIncomodo"));
//#endif 


//#if 600235440 
int mesIncomodo = Integer.parseInt(request.getInput("mesIncomodo"));
//#endif 


//#if -1486611760 
int anoIncomodo = Integer.parseInt(request.getInput("anoIncomodo"));
//#endif 


//#if 305383793 
String ruaOcorrencia = request.getInput("ruaOcorrencia");
//#endif 


//#if 77419783 
String compOcorrencia = request.getInput("compOcorrencia");
//#endif 


//#if -1069670585 
String bairroOcorrencia = request.getInput("bairroOcorrencia");
//#endif 


//#if 1470022567 
String cidadeOcorrencia = request.getInput("cidadeOcorrencia");
//#endif 


//#if -1060889913 
String ufOcorrencia = request.getInput("ufOcorrencia");
//#endif 


//#if -1670422063 
String cepOcorrencia = request.getInput("cepOcorrencia ");
//#endif 


//#if 1640098087 
String telefoneOcorrencia = request.getInput("telefoneOcorrencia");
//#endif 


//#if 940122883 
Address endOcorrencia = new Address(ruaOcorrencia,
                                                compOcorrencia,
                                                cepOcorrencia,
                                                ufOcorrencia,
                                                telefoneOcorrencia,
                                                cidadeOcorrencia,
                                                bairroOcorrencia);
//#endif 


//#if -1573167248 
Calendar agora              = Calendar.getInstance();
//#endif 


//#if -9092448 
queixa = new AnimalComplaint(nomeSolicitante, descricaoQueixa, observacaoQueixa,
                                         emailSolicitante, null, 1, null,
                                         new Date(agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH),
                                                  agora.get(Calendar.YEAR)), endSolicitante, qtdeAnimal,
                                         new Date(diaIncomodo, mesIncomodo,anoIncomodo), nomeAnimal,endOcorrencia);
//#endif 


//#if -602583476 
int codigo = facade.insertComplaint(queixa);
//#endif 


//#if 1021460852 
out.println(HTMLCode.htmlPage("Complaint inserted",
                                          "<p> <h2> Animal Complaint inserted</h2> </p>" +
                                          "<p> <h2> Save the complaint number: " + codigo + "</h2> </p>"));
//#endif 


//#if 588503994 
out.println(HTMLCode.close());
//#endif 

} 

//#if 526982964 
catch (RepositoryException e) //1
{ 

//#if -570980325 
out.println(HTMLCode.errorPage("Problemas com o banco de dados"));
//#endif 

} 

//#endif 


//#if -182539344 
catch (TransactionException e) //1
{ 

//#if 88326007 
out.println(HTMLCode.errorPage("Erro no mecanismo de persist?ncia"));
//#endif 

} 

//#endif 


//#if -481029405 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if -650462639 
out.println(HTMLCode.errorPage("Complaint already inserted"));
//#endif 

} 

//#endif 


//#if 461750962 
catch (ObjectNotValidException e) //1
{ 

//#if -1887675511 
out.println(HTMLCode.errorPage("Unespected error. Try to contact the support team."));
//#endif 

} 

//#endif 


//#if 1728133544 
catch (CommunicationException e) //1
{ 

//#if -928964912 
throw new FacadeUnavailableException();
//#endif 

} 

//#endif 


//#if 693099223 
catch(InvalidDateException e) //1
{ 

//#if -579137785 
out.println(HTMLCode.errorPage("Invalid date."));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

