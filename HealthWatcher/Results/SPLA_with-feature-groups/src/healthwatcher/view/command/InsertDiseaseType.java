
//#if -455109041
// Compilation Unit of /InsertDiseaseType.java

package healthwatcher.view.command;

//#if 800530810
import healthwatcher.model.complaint.DiseaseType;
//#endif


//#if -1438015820
import healthwatcher.view.IFacade;
//#endif


//#if 1580773869
import java.io.IOException;
//#endif


//#if -2093973194
import java.io.PrintWriter;
//#endif


//#if 651641056
import lib.exceptions.CommunicationException;
//#endif


//#if 28082691
import lib.exceptions.InsertEntryException;
//#endif


//#if 375690477
import lib.exceptions.InvalidSessionException;
//#endif


//#if 824403355
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if -59811242
import lib.exceptions.ObjectNotValidException;
//#endif


//#if 1010361048
import lib.exceptions.RepositoryException;
//#endif


//#if 1193421160
import lib.exceptions.TransactionException;
//#endif


//#if 1095990463
import lib.util.HTMLCode;
//#endif


//#if -1378951840
import lib.exceptions.FacadeUnavailableException;
//#endif

public class InsertDiseaseType extends Command
{

//#if -1757075788
    public void execute()
    {
        PrintWriter out=null;
        DiseaseType diseaseType = null;
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
            String name = request.getInput("name");
            String description = request.getInput("description");
            String manifestacao = request.getInput("manifestacao");
            String duration = request.getInput("duration");
            diseaseType = new DiseaseType(name, description, manifestacao, duration, null);
            diseaseType.setCode(Integer.parseInt(code));
            facade.insert(diseaseType);
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "DiseaseType inserted"));
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

    public InsertDiseaseType(IFacade f)
    {
        super(f);
    }


//#if 1619958606
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        DiseaseType diseaseType = null;
        try { //1
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }

            String code = request.getInput("code");
            String name = request.getInput("name");
            String description = request.getInput("description");
            String manifestacao = request.getInput("manifestacao");
            String duration = request.getInput("duration");
            diseaseType = new DiseaseType(name, description, manifestacao, duration, null);
            diseaseType.setCode(Integer.parseInt(code));
            facade.insert(diseaseType);
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "DiseaseType inserted"));
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

}


//#endif

