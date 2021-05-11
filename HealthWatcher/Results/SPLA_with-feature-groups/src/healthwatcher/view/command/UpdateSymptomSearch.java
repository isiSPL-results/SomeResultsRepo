
//#if 337533357
// Compilation Unit of /UpdateSymptomSearch.java

package healthwatcher.view.command;

//#if -1106981034
import healthwatcher.Constants;
//#endif


//#if -1915067132
import healthwatcher.model.complaint.Symptom;
//#endif


//#if -272548649
import healthwatcher.view.IFacade;
//#endif


//#if 701064490
import java.io.IOException;
//#endif


//#if 1321284723
import java.io.PrintWriter;
//#endif


//#if 1381662429
import lib.exceptions.CommunicationException;
//#endif


//#if 1531516560
import lib.exceptions.InvalidSessionException;
//#endif


//#if -2033077249
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if -1668436485
import lib.exceptions.RepositoryException;
//#endif


//#if -244923739
import lib.exceptions.TransactionException;
//#endif


//#if -1090397380
import lib.util.HTMLCode;
//#endif


//#if -916925219
import lib.exceptions.FacadeUnavailableException;
//#endif

public class UpdateSymptomSearch extends Command
{
    public static final String SYMPTOM = "symptom";
    public UpdateSymptomSearch(IFacade f)
    {
        super(f);
    }


//#if 1712234622
    public void execute()
    {
        PrintWriter out=null;
        try { //1
            try { //1
                out = response.getWriter();
            } catch (IOException e1) { //1
                e1.printStackTrace();
            }


            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }

            out.println("Update Symptom");
            out.println("<script language=\"javascript\">");
            out.println("function submeterDados(modulo)");
            out.println("{");
            String a1 = "\"";
            String a2 = "\"";
            out.println("   var f = document.formAlterarUnidade2;");
            out.println("   if(f.descricao.value ==" + a1 + a2 + ")");
            out.println("   {");
            out.println("           alert(\"Digite a nova descri��o do sintoma!\");");
            out.println("           f.descricao.select();");
            out.println("           return;");
            out.println("   }");
            out.println("   f.operation.value = \"UpdateSymptomData\";");
            out.println("   f.submit();");
            out.println("}");
            out.println("//--></script>");
            out.println("<body><h1>Update Symptom:</h1>");
            int symptomCode = (new Integer(request.getInput("symptomCode"))).intValue();
            Symptom symptom = facade.searchSymptom(symptomCode);
            symptom.addObserver(facade);
            request.put(SYMPTOM, symptom);
            out.println("<form method=\"POST\" name=\"formAlterarUnidade2\" action=\"http://"+Constants.SERVLET_SERVER_PATH+"HWServlet\">");
            out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateSymptomData\">" );
            out.println("<div align=\"center\"><center><h4>Symptom: " + symptomCode + "</h4></center></div>");
            out.println("<div align=\"center\"><center><p><strong>Name:</strong><br><input type=\"text\" name=\"descricao\" value=\"" + symptom.getDescription() + "\" size=\"60\"></p></center></div>");
            out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"UpdateSymptomData\" name=\"operation\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" name=\"bt2\"></h4></center></div></form>");
            out.println(HTMLCode.closeAdministrator());
        } catch (ObjectNotFoundException e) { //1
            out.println("Symptom does not exist!");
        }

        catch (InvalidSessionException e) { //1
            out.println(e.getMessage());
        }

        catch (RepositoryException e) { //1
            e.printStackTrace();
        }

        catch (TransactionException e) { //1
            e.printStackTrace();
        }

        catch(CommunicationException e) { //1
            out.println(e.getMessage());
        }

        finally {
            out.close();
        }

    }

//#endif


//#if -174255036
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        try { //1
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }

            int symptomCode = (new Integer(request.getInput("symptomCode"))).intValue();
            Symptom symptom = facade.searchSymptom(symptomCode);
            symptom.addObserver(facade);
            request.put(SYMPTOM, symptom);
            out.println("Update Symptom");
            out.println("<script language=\"javascript\">");
            out.println("function submeterDados(modulo)");
            out.println("{");
            String a1 = "\"";
            String a2 = "\"";
            out.println("   var f = document.formAlterarUnidade2;");
            out.println("   if(f.descricao.value ==" + a1 + a2 + ")");
            out.println("   {");
            out.println("           alert(\"Digite a nova descri��o do sintoma!\");");
            out.println("           f.descricao.select();");
            out.println("           return;");
            out.println("   }");
            out.println("   f.operation.value = \"UpdateSymptomData\";");
            out.println("   f.submit();");
            out.println("}");
            out.println("//--></script>");
            out.println("<body><h1>Update Symptom:</h1>");
            out.println("<form method=\"POST\" name=\"formAlterarUnidade2\" action=\"http://"+Constants.SERVLET_SERVER_PATH+"HWServlet\">");
            out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateSymptomData\">" );
            out.println("<div align=\"center\"><center><h4>Symptom: " + symptomCode + "</h4></center></div>");
            out.println("<div align=\"center\"><center><p><strong>Name:</strong><br><input type=\"text\" name=\"descricao\" value=\"" + symptom.getDescription() + "\" size=\"60\"></p></center></div>");
            out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"Update\" name=\"bt1\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" name=\"bt2\"></h4></center></div></form>");
            out.println(HTMLCode.closeAdministrator());
        } catch (ObjectNotFoundException e) { //1
            out.println("Symptom does not exist!");
        }

        catch (InvalidSessionException e) { //1
            out.println(e.getMessage());
        }

        catch (RepositoryException e) { //1
            e.printStackTrace();
        }

        catch (TransactionException e) { //1
            e.printStackTrace();
        }

        catch(CommunicationException e) { //1
            throw new FacadeUnavailableException();
        }


    }

//#endif

}


//#endif

