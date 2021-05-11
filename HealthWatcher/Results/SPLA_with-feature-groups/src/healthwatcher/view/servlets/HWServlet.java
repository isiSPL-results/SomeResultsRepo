// Compilation Unit of /HWServlet.java

package healthwatcher.view.servlets;
import healthwatcher.view.IFacade;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

//#if -787483313
import healthwatcher.view.command.Command;
//#endif


//#if -809915890
import healthwatcher.view.command.ConfigRMI;
//#endif


//#if -39864884
import healthwatcher.view.command.GetDataForSearchByDiseaseType;
//#endif


//#if -296012
import healthwatcher.view.command.GetDataForSearchByHealthUnit;
//#endif


//#if 1049212671
import healthwatcher.view.command.GetDataForSearchBySpeciality;
//#endif


//#if 1636134308
import healthwatcher.view.command.InsertAnimalComplaint;
//#endif


//#if -1489054539
import healthwatcher.view.command.InsertEmployee;
//#endif


//#if 1318543238
import healthwatcher.view.command.InsertFoodComplaint;
//#endif


//#if -697442319
import healthwatcher.view.command.InsertSpecialComplaint;
//#endif


//#if 582917297
import healthwatcher.view.command.Login;
//#endif


//#if 888936466
import healthwatcher.view.command.LoginMenu;
//#endif


//#if 1156570157
import healthwatcher.view.command.SearchComplaintData;
//#endif


//#if 812754876
import healthwatcher.view.command.SearchDiseaseData;
//#endif


//#if 128831584
import healthwatcher.view.command.SearchHealthUnitsBySpecialty;
//#endif


//#if 302014511
import healthwatcher.view.command.SearchSpecialtiesByHealthUnit;
//#endif


//#if -904846962
import healthwatcher.view.command.UpdateComplaintData;
//#endif


//#if -897220838
import healthwatcher.view.command.UpdateComplaintList;
//#endif


//#if -1449365488
import healthwatcher.view.command.UpdateComplaintSearch;
//#endif


//#if -218824421
import healthwatcher.view.command.UpdateEmployeeData;
//#endif


//#if 688300125
import healthwatcher.view.command.UpdateEmployeeSearch;
//#endif


//#if -470191351
import healthwatcher.view.command.UpdateHealthUnitData;
//#endif


//#if -462565227
import healthwatcher.view.command.UpdateHealthUnitList;
//#endif


//#if -357151029
import healthwatcher.view.command.UpdateHealthUnitSearch;
//#endif


//#if 39773869
import java.io.IOException;
//#endif


//#if 591275418
import java.util.Hashtable;
//#endif


//#if 1759918595
import javax.servlet.http.HttpServletRequest;
//#endif


//#if 363849859
import javax.servlet.http.HttpServletResponse;
//#endif


//#if -1414524545
import healthwatcher.view.RMIServletAdapter;
//#endif


//#if 1950618674
import healthwatcher.business.factories.FacadeFactory;
//#endif


//#if 266618301
import healthwatcher.view.command.InsertDiseaseType;
//#endif


//#if 702327203
import healthwatcher.view.command.InsertHealthUnit;
//#endif


//#if -1905434163
import healthwatcher.view.command.InsertMedicalSpeciality;
//#endif


//#if 1945035978
import healthwatcher.view.command.InsertSymptom;
//#endif


//#if 567732307
import healthwatcher.view.command.UpdateMedicalSpecialityData;
//#endif


//#if 575358431
import healthwatcher.view.command.UpdateMedicalSpecialityList;
//#endif


//#if 655071637
import healthwatcher.view.command.UpdateMedicalSpecialitySearch;
//#endif


//#if 1759967440
import healthwatcher.view.command.UpdateSymptomData;
//#endif


//#if 1767593564
import healthwatcher.view.command.UpdateSymptomList;
//#endif


//#if -363233582
import healthwatcher.view.command.UpdateSymptomSearch;
//#endif


//#if 1697109849
import healthwatcher.Constants;
//#endif


//#if 690079136
import lib.exceptions.CommunicationException;
//#endif


//#if -909573600
import lib.exceptions.FacadeUnavailableException;
//#endif


//#if -586204273
import lib.logging.LogMechanism;
//#endif


//#if -976387197
public abstract class HWServlet extends HttpServlet
{
    protected IFacade facade = null;
    public void init(ServletConfig config) throws ServletException
    {
        try { //1
            System.out.println("About to lookup...");
            facade = (IFacade) java.rmi.Naming.lookup("//" + healthwatcher.Constants.SERVER_NAME + "/" + healthwatcher.Constants.SYSTEM_NAME);
            System.out.println("Remote DisqueSaude found");
        } catch (java.rmi.RemoteException rmiEx) { //1
            rmiInitExceptionHandling(rmiEx);
        }

        catch (java.rmi.NotBoundException rmiEx) { //1
            rmiInitExceptionHandling(rmiEx);
        }

        catch (java.net.MalformedURLException rmiEx) { //1
            rmiInitExceptionHandling(rmiEx);
        }


    }

    protected void rmiInitExceptionHandling(Throwable exception)
    {
        String error =  "<p>****************************************************<br>" +
                        "Error during servlet initialization!<br>" +
                        "The exception message is:<br><dd>" + exception.getMessage() +
                        "<p>You may have to restart the servlet container.<br>" +
                        "*******************************************************";
        System.out.println(error);
    }

}

//#endif


//#if -692958751
public class HWServlet extends HttpServlet
{
    protected IFacade facade = null;
    private Hashtable commandTable;
    private static final String CommandConfigRMI		             = "ConfigRMI";
    private static final String CommandGetDataForSearchByDiseaseType = "SearchByDiseaseType";
    private static final String CommandGetDataForSearchByHealthUnit  = "SearchByHealthUnit";
    private static final String CommandGetDataForSearchBySpeciality  = "SearchBySpecialty";
    private static final String CommandInsertAnimalComplaint         = "InsertAnimalComplaint";
    private static final String CommandInsertEmployee                = "InsertEmployee";
    private static final String CommandInsertFoodComplaint           = "InsertFoodComplaint";
    private static final String CommandInsertSpecialComplaint        = "InsertSpecialComplaint";
    private static final String CommandLogin                         = "Login";
    private static final String CommandLoginMenu                     = "LoginMenu";
    private static final String CommandSearchComplaintData           = "SearchComplaintData";
    private static final String CommandSearchDiseaseData             = "SearchDiseaseData";
    private static final String CommandSearchHealthUnitsBySpecialty  = "SearchHealthUnitsBySpecialty";
    private static final String CommandSearchSpecialtiesByHealthUnit = "SearchSpecialtiesByHealthUnit";
    private static final String CommandUpdateComplaintData           = "UpdateComplaintData";
    private static final String CommandUpdateComplaintList           = "UpdateComplaintList";
    private static final String CommandUpdateComplaintSearch         = "UpdateComplaintSearch";
    private static final String CommandUpdateEmployeeData            = "UpdateEmployeeData";
    private static final String CommandUpdateEmployeeSearch          = "UpdateEmployeeSearch";
    private static final String CommandUpdateHealthUnitData          = "UpdateHealthUnitData";
    private static final String CommandUpdateHealthUnitSearch        = "UpdateHealthUnitSearch";
    private static final String CommandUpdateHealthUnitList          = "UpdateHealthUnitList";

//#if 1581583959
    private static final String CommandInsertSpeciality              = "InsertMedicalSpeciality";
//#endif


//#if 1072401328
    private static final String CommandInsertSymptom                 = "InsertSymptom";
//#endif


//#if -1618381364
    private static final String CommandInsertHealthUnit              = "InsertHealthUnit";
//#endif


//#if -778090224
    private static final String CommandInsertDiseaseType             = "InsertDiseaseType";
//#endif


//#if 1073243120
    private static final String CommandUpdateSymptomData          	 = "UpdateSymptomData";
//#endif


//#if -1784565648
    private static final String CommandUpdateSymptomSearch        	 = "UpdateSymptomSearch";
//#endif


//#if 22665072
    private static final String CommandUpdateSymptomList          	 = "UpdateSymptomList";
//#endif


//#if 2113908176
    private static final String CommandUpdateMedicalSpecialityData   = "UpdateMedicalSpecialityData";
//#endif


//#if 2079986448
    private static final String CommandUpdateMedicalSpecialitySearch = "UpdateMedicalSpecialitySearch";
//#endif


//#if 1234707024
    private static final String CommandUpdateMedicalSpecialityList   = "UpdateMedicalSpecialityList";
//#endif


//#if 1858459318
    protected Command getCommand(HttpServletRequest request, HttpServletResponse response)
    {
        String operation = request.getParameter("operation");
        Command command = (Command) commandTable.get(operation);
        command.setRequest(new ServletRequestAdapter(request));
        command.setReponse(new ServletResponseAdapter(response));
        return command;
    }

//#endif


//#if 573373009
    protected void rmiInitExceptionHandling(Throwable exception)
    {
        String error =  "<p>****************************************************<br>" +
                        "Error during servlet initialization!<br>" +
                        "The exception message is:<br><dd>" + exception.getMessage() +
                        "<p>You may have to restart the servlet container.<br>" +
                        "*******************************************************";
        System.out.println(error);
    }

//#endif


//#if 845119522
    protected void retry(HttpServletRequest request, HttpServletResponse response)
    {
        try { //1
            initFacade();
            Command command = getCommand(request, response);
            command.execute();
        } catch (Exception e) { //1
            e.printStackTrace();
        }


    }

//#endif

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        handleRequest(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        handleRequest(request,response);
    }

    private void initCommands()
    {
        commandTable = new Hashtable();
        commandTable.put(HWServlet.CommandConfigRMI, new ConfigRMI(facade));
        commandTable.put(HWServlet.CommandGetDataForSearchByDiseaseType, new GetDataForSearchByDiseaseType(facade));
        commandTable.put(HWServlet.CommandGetDataForSearchByHealthUnit, new GetDataForSearchByHealthUnit(facade));
        commandTable.put(HWServlet.CommandGetDataForSearchBySpeciality, new GetDataForSearchBySpeciality(facade));
        commandTable.put(HWServlet.CommandInsertAnimalComplaint, new InsertAnimalComplaint(facade));
        commandTable.put(HWServlet.CommandInsertEmployee, new InsertEmployee(facade));
        commandTable.put(HWServlet.CommandInsertFoodComplaint, new InsertFoodComplaint(facade));
        commandTable.put(HWServlet.CommandInsertSpecialComplaint, new InsertSpecialComplaint(facade));
        commandTable.put(HWServlet.CommandLogin, new Login(facade));
        commandTable.put(HWServlet.CommandLoginMenu, new LoginMenu(facade));
        commandTable.put(HWServlet.CommandSearchComplaintData, new SearchComplaintData(facade));
        commandTable.put(HWServlet.CommandSearchDiseaseData, new SearchDiseaseData(facade));
        commandTable.put(HWServlet.CommandSearchHealthUnitsBySpecialty, new SearchHealthUnitsBySpecialty(facade));
        commandTable.put(HWServlet.CommandSearchSpecialtiesByHealthUnit, new SearchSpecialtiesByHealthUnit(facade));
        commandTable.put(HWServlet.CommandUpdateComplaintData, new UpdateComplaintData(facade));
        commandTable.put(HWServlet.CommandUpdateComplaintList, new UpdateComplaintList(facade));
        commandTable.put(HWServlet.CommandUpdateComplaintSearch, new UpdateComplaintSearch(facade));
        commandTable.put(HWServlet.CommandUpdateEmployeeData, new UpdateEmployeeData(facade));
        commandTable.put(HWServlet.CommandUpdateEmployeeSearch, new UpdateEmployeeSearch(facade));
        commandTable.put(HWServlet.CommandUpdateHealthUnitData, new UpdateHealthUnitData(facade));
        commandTable.put(HWServlet.CommandUpdateHealthUnitSearch, new UpdateHealthUnitSearch(facade));
        commandTable.put(HWServlet.CommandUpdateHealthUnitList, new UpdateHealthUnitList(facade));

//#if 1560815617
        commandTable.put(HWServlet.CommandInsertSpeciality, new InsertMedicalSpeciality(facade));
//#endif


//#if 320828808
        commandTable.put(HWServlet.CommandInsertSymptom, new InsertSymptom(facade));
//#endif


//#if -1482931934
        commandTable.put(HWServlet.CommandInsertHealthUnit, new InsertHealthUnit(facade));
//#endif


//#if -841610584
        commandTable.put(HWServlet.CommandInsertDiseaseType, new InsertDiseaseType(facade));
//#endif


//#if 1835953352
        commandTable.put(HWServlet.CommandUpdateSymptomData, new UpdateSymptomData(facade));
//#endif


//#if -1558889208
        commandTable.put(HWServlet.CommandUpdateSymptomSearch, new UpdateSymptomSearch(facade));
//#endif


//#if -1287803576
        commandTable.put(HWServlet.CommandUpdateSymptomList, new UpdateSymptomList(facade));
//#endif


//#if 1927659304
        commandTable.put(HWServlet.CommandUpdateMedicalSpecialityData, new UpdateMedicalSpecialityData(facade));
//#endif


//#if -513804248
        commandTable.put(HWServlet.CommandUpdateMedicalSpecialitySearch, new UpdateMedicalSpecialitySearch(facade));
//#endif


//#if -1898004312
        commandTable.put(HWServlet.CommandUpdateMedicalSpecialityList, new UpdateMedicalSpecialityList(facade));
//#endif

    }

    public void init(ServletConfig config) throws ServletException
    {

//#if -1124745655
        LogMechanism.configure(Constants.LOG_PATH);
//#endif

        try { //1

//#if 1781647156
            System.out.println("About to lookup...");
//#endif


//#if -1592998387
            facade = (IFacade) java.rmi.Naming.lookup("//" + healthwatcher.Constants.SERVER_NAME + "/" + healthwatcher.Constants.SYSTEM_NAME);
//#endif


//#if 1750689709
            System.out.println("Remote DisqueSaude found");
//#endif


//#if 1456808837
            facade = new RMIServletAdapter("//" + healthwatcher.Constants.SERVER_NAME + "/" + healthwatcher.Constants.SYSTEM_NAME);
//#endif


//#if 1928131597
            facade = FacadeFactory.getRepositoryFactory().createClientFacade();
//#endif


//#if -249861128
            initCommands();
//#endif


//#if 492570150
            initFacade();
//#endif

        }

//#if 1801020498
        catch (java.rmi.RemoteException rmiEx) { //1
            rmiInitExceptionHandling(rmiEx);
        }

//#endif


//#if -757726537
        catch (java.rmi.NotBoundException rmiEx) { //1
            rmiInitExceptionHandling(rmiEx);
        }

//#endif


//#if -1955746607
        catch (java.net.MalformedURLException rmiEx) { //1
            rmiInitExceptionHandling(rmiEx);
        }

//#endif


//#if 875688504
        catch (Exception e) { //1
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        }

//#endif


//#if 815704698
        catch (CommunicationException e) { //1
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        }

//#endif


    }


//#if -618314886
    protected void initFacade() throws CommunicationException
    {
        facade = FacadeFactory.getRepositoryFactory().createClientFacade();
        initCommands();
    }

//#endif

    public void handleRequest(HttpServletRequest request, HttpServletResponse response)
    {

//#if -1026840039
        String operation = request.getParameter("operation");
//#endif


//#if 513024766
        Command command = (Command) commandTable.get(operation);
//#endif


//#if -811122014
        command.setRequest(request);
//#endif


//#if 2113648979
        command.setReponse(response);
//#endif


//#if -1888040720
        command.setRequest(new ServletRequestAdapter(request));
//#endif


//#if -1851489029
        command.setReponse(new ServletResponseAdapter(response));
//#endif


//#if -717818623
        command.execute();
//#endif


//#if -1994190097
        try { //1
            Command command = getCommand(request, response);
            command.execute();
        } catch (CommunicationException e) { //1
            retry(request, response);
        }

        catch (FacadeUnavailableException e) { //1
            retry(request, response);
        }

        catch (Exception e) { //1
            e.printStackTrace();
        }


//#endif

    }

}

//#endif


