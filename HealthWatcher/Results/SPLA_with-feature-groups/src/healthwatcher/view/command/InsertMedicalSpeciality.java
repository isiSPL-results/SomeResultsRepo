
//#if -120944686
// Compilation Unit of /InsertMedicalSpeciality.java

package healthwatcher.view.command;

//#if 1339033336
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif


//#if 741079761
import healthwatcher.view.IFacade;
//#endif


//#if 1754729584
import java.io.IOException;
//#endif


//#if -1920017479
import java.io.PrintWriter;
//#endif


//#if -1170005853
import lib.exceptions.CommunicationException;
//#endif


//#if -1895598458
import lib.exceptions.InsertEntryException;
//#endif


//#if -260788854
import lib.exceptions.InvalidSessionException;
//#endif


//#if -1235168674
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if -696290573
import lib.exceptions.ObjectNotValidException;
//#endif


//#if 532664821
import lib.exceptions.RepositoryException;
//#endif


//#if -730259989
import lib.exceptions.TransactionException;
//#endif


//#if -1317233662
import lib.util.HTMLCode;
//#endif


//#if -454089821
import lib.exceptions.FacadeUnavailableException;
//#endif

public class InsertMedicalSpeciality extends Command
{

//#if 1308537732
    public void execute()
    {
        PrintWriter out=null;
        MedicalSpeciality speciality = null;
        try { //1
            try { //1
                out = response.getWriter();
            } catch (IOException e1) { //1
                e1.printStackTrace();
            }


            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }

            String code = request.getInput("code");
            String description = request.getInput("description");
            speciality = new MedicalSpeciality(description);
            speciality.setCodigo(Integer.parseInt(code));
            facade.insert(speciality);
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "MedicalSpecialty inserted"));
        } catch (ObjectAlreadyInsertedException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

        catch (ObjectNotValidException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

        catch(InsertEntryException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

        catch (InvalidSessionException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

        catch(TransactionException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

        catch(CommunicationException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

        catch(RepositoryException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

        finally {
            out.close();
        }

    }

//#endif


//#if 1284494462
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        MedicalSpeciality speciality = null;
        try { //1
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }

            String code = request.getInput("code");
            String description = request.getInput("description");
            speciality = new MedicalSpeciality(description);
            speciality.setCodigo(Integer.parseInt(code));
            facade.insert(speciality);
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "MedicalSpecialty inserted"));
        } catch (ObjectAlreadyInsertedException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

        catch (ObjectNotValidException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

        catch(InsertEntryException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

        catch (InvalidSessionException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

        catch(TransactionException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

        catch(CommunicationException e) { //1
            throw new FacadeUnavailableException();
        }

        catch(RepositoryException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }


    }

//#endif

    public InsertMedicalSpeciality(IFacade f)
    {
        super(f);
    }

}


//#endif

