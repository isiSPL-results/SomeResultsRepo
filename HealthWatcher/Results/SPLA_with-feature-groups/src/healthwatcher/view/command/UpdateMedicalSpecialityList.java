
//#if -1984511081
// Compilation Unit of /UpdateMedicalSpecialityList.java

package healthwatcher.view.command;

//#if -566842460
import healthwatcher.Constants;
//#endif


//#if 428070144
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif


//#if 2048218569
import healthwatcher.view.IFacade;
//#endif


//#if -754870152
import java.io.IOException;
//#endif


//#if -134649919
import java.io.PrintWriter;
//#endif


//#if -1191855445
import lib.exceptions.CommunicationException;
//#endif


//#if -938126206
import lib.exceptions.InvalidSessionException;
//#endif


//#if -207752719
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 637187309
import lib.exceptions.RepositoryException;
//#endif


//#if -1785030157
import lib.exceptions.TransactionException;
//#endif


//#if -274036214
import lib.util.HTMLCode;
//#endif


//#if 210604870
import lib.util.IteratorDsk;
//#endif


//#if -1254786645
import lib.exceptions.FacadeUnavailableException;
//#endif

public class UpdateMedicalSpecialityList extends Command
{

//#if -428372377
    public void execute()
    {
        PrintWriter out = null;
        try { //1
            try { //1
                out = response.getWriter();
            } catch (IOException e1) { //1
                e1.printStackTrace();
            }


            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException("Invalid Session! <br><a href=\"" + Constants.SYSTEM_LOGIN + "\">Try again</a>");
            }

            out.println("Queries - Medical Speciality information");
            out.println("<body><h1>Queries:<br>Querie about medical specialities</h1>");
            out.println("<p>Choose a speciality: </p>");
            out.println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateMedicalSpecialitySearch\">");
            out.println("<div align=\"center\"><center><p><select name=\"specialityCode\" size=\"1\">");
            IteratorDsk repTP = facade.getSpecialityList();
            if(repTP == null || !repTP.hasNext()) { //1
                out.println("</select></p></center></div>");
                out.println("<p><font color=\"red\"><b> There isn't any medical speciality.</b></font></p>");
            } else {
                MedicalSpeciality speciality;
                do {
                    speciality = (MedicalSpeciality) repTP.next();
                    out.println("<option value=\"" + speciality.getCodigo() + "\"> "
                                + speciality.getDescricao() + " </OPTION>");
                } while (repTP.hasNext()); //1

                repTP.close();
                out.println("</select></p></center></div>");
                out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"UpdateMedicalSpecialitySearch\" name=\"operation\"></p></center></div></form>");
            }

            out.println(HTMLCode.closeAdministrator());
        } catch (ObjectNotFoundException e) { //1
            out.println("There isn't any medical speciality");
        }

        catch (RepositoryException e) { //1
            e.printStackTrace();
        }

        catch (TransactionException e) { //1
            e.printStackTrace();
        }

        catch (CommunicationException e) { //1
            e.printStackTrace();
        }

        catch (InvalidSessionException e) { //1
            out.println(e.getMessage());
        }

        finally {
            out.close();
        }

    }

//#endif

    public UpdateMedicalSpecialityList(IFacade f)
    {
        super(f);
    }


//#if -262179013
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        try { //1
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException("Invalid Session! <br><a href=\"" + Constants.SYSTEM_LOGIN + "\">Try again</a>");
            }

            IteratorDsk repTP = facade.getSpecialityList();
            out.println("Queries - Medical Speciality information");
            out.println("<body><h1>Queries:<br>Querie about medical specialities</h1>");
            out.println("<p>Choose a speciality: </p>");
            out.println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateMedicalSpecialitySearch\">");
            out.println("<div align=\"center\"><center><p><select name=\"specialityCode\" size=\"1\">");
            if(repTP == null || !repTP.hasNext()) { //1
                out.println("</select></p></center></div>");
                out.println("<p><font color=\"red\"><b> There isn't any medical speciality.</b></font></p>");
            } else {
                MedicalSpeciality speciality;
                do {
                    speciality = (MedicalSpeciality) repTP.next();
                    out.println("<option value=\"" + speciality.getCodigo() + "\"> "
                                + speciality.getDescricao() + " </OPTION>");
                } while (repTP.hasNext()); //1

                repTP.close();
                out.println("</select></p></center></div>");
                out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"UpdateMedicalSpecialitySearch\" name=\"operation\"></p></center></div></form>");
            }

            out.println(HTMLCode.closeAdministrator());
        } catch (ObjectNotFoundException e) { //1
            out.println("There isn't any medical speciality");
        }

        catch (RepositoryException e) { //1
            e.printStackTrace();
        }

        catch (TransactionException e) { //1
            e.printStackTrace();
        }

        catch (CommunicationException e) { //1
            throw new FacadeUnavailableException();
        }

        catch (InvalidSessionException e) { //1
            out.println(e.getMessage());
        }


    }

//#endif

}


//#endif

