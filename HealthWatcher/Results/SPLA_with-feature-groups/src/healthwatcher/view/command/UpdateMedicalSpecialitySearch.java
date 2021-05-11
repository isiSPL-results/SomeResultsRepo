
//#if 585651626
// Compilation Unit of /UpdateMedicalSpecialitySearch.java

package healthwatcher.view.command;

//#if -1559035463
import healthwatcher.Constants;
//#endif


//#if 849808085
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif


//#if 1591397268
import healthwatcher.view.IFacade;
//#endif


//#if 1312702733
import java.io.IOException;
//#endif


//#if 1932922966
import java.io.PrintWriter;
//#endif


//#if -511490048
import lib.exceptions.CommunicationException;
//#endif


//#if -1321635379
import lib.exceptions.InvalidSessionException;
//#endif


//#if -591261892
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 1321152440
import lib.exceptions.RepositoryException;
//#endif


//#if -2056947576
import lib.exceptions.TransactionException;
//#endif


//#if -843951137
import lib.util.HTMLCode;
//#endif


//#if -1763552128
import lib.exceptions.FacadeUnavailableException;
//#endif

public class UpdateMedicalSpecialitySearch extends Command
{
    public static final String SPECIALITY = "speciality";

//#if 441211519
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

            out.println("Update Medical Speciality");
            out.println("<script language=\"javascript\">");
            out.println("function submeterDados(modulo)");
            out.println("{");
            String a1 = "\"";
            String a2 = "\"";
            out.println("   var f = document.formAlterarUnidade2;");
            out.println("   if(f.descricao.value ==" + a1 + a2 + ")");
            out.println("   {");
            out.println("           alert(\"Digite a nova descri��o da especialidade!\");");
            out.println("           f.descricao.select();");
            out.println("           return;");
            out.println("   }");
            out.println("   f.operation.value = \"UpdateMedicalSpecialityData\";");
            out.println("   f.submit();");
            out.println("}");
            out.println("//--></script>");
            out.println("<body><h1>Update Medical Speciality:</h1>");
            int specialityCode = (new Integer(request.getInput("specialityCode"))).intValue();
            MedicalSpeciality speciality = facade.searchSpecialitiesByCode(specialityCode);
            speciality.addObserver(facade);
            request.put(SPECIALITY, speciality);
            out.println("<form method=\"POST\" name=\"formAlterarUnidade2\" action=\"http://"+Constants.SERVLET_SERVER_PATH+"HWServlet\">");
            out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateMedicalSpecialityData\">" );
            out.println("<div align=\"center\"><center><h4>Medical Speciality: " + specialityCode + "</h4></center></div>");
            out.println("<div align=\"center\"><center><p><strong>Name:</strong><br><input type=\"text\" name=\"descricao\" value=\"" + speciality.getDescricao() + "\" size=\"60\"></p></center></div>");
            out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"UpdateMedicalSpecialityData\" name=\"operation\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" name=\"bt2\"></h4></center></div></form>");
            out.println(HTMLCode.closeAdministrator());
        } catch (ObjectNotFoundException e) { //1
            out.println("Medical Speciality does not exist!");
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

    public UpdateMedicalSpecialitySearch(IFacade f)
    {
        super(f);
    }


//#if 2089154595
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        try { //1
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }

            int specialityCode = (new Integer(request.getInput("specialityCode"))).intValue();
            MedicalSpeciality speciality = facade.searchSpecialitiesByCode(specialityCode);
            speciality.addObserver(facade);
            request.put(SPECIALITY, speciality);
            out.println("Update Medical Speciality");
            out.println("<script language=\"javascript\">");
            out.println("function submeterDados(modulo)");
            out.println("{");
            String a1 = "\"";
            String a2 = "\"";
            out.println("   var f = document.formAlterarUnidade2;");
            out.println("   if(f.descricao.value ==" + a1 + a2 + ")");
            out.println("   {");
            out.println("           alert(\"Digite a nova descri��o da especialidade!\");");
            out.println("           f.descricao.select();");
            out.println("           return;");
            out.println("   }");
            out.println("   f.operation.value = \"UpdateMedicalSpecialityData\";");
            out.println("   f.submit();");
            out.println("}");
            out.println("//--></script>");
            out.println("<body><h1>Update Medical Speciality:</h1>");
            out.println("<form method=\"POST\" name=\"formAlterarUnidade2\" action=\"http://"+Constants.SERVLET_SERVER_PATH+"HWServlet\">");
            out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateMedicalSpecialityData\">" );
            out.println("<div align=\"center\"><center><h4>Medical Speciality: " + specialityCode + "</h4></center></div>");
            out.println("<div align=\"center\"><center><p><strong>Name:</strong><br><input type=\"text\" name=\"descricao\" value=\"" + speciality.getDescricao() + "\" size=\"60\"></p></center></div>");
            out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"Update\" name=\"bt1\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" name=\"bt2\"></h4></center></div></form>");
            out.println(HTMLCode.closeAdministrator());
        } catch (ObjectNotFoundException e) { //1
            out.println("Medical Speciality does not exist!");
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

