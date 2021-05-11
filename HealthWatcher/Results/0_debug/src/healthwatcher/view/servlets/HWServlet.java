
//#if 2106811074
// Compilation Unit of /HWServlet.java


//#if -1545063554
package healthwatcher.view.servlets;
//#endif


//#if -714960396
import healthwatcher.view.IFacade;
//#endif


//#if -257537900
import javax.servlet.ServletConfig;
//#endif


//#if 650073233
import javax.servlet.ServletException;
//#endif


//#if 2125458884
import javax.servlet.http.HttpServlet;
//#endif


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
public abstract class HWServlet extends
//#if 848731861
    HttpServlet
//#endif

{

//#if -729728370
    protected IFacade facade = null;
//#endif


//#if 1265500106
    public void init(ServletConfig config) throws ServletException
    {

//#if 19625860
        try { //1

//#if -959541006
            System.out.println("About to lookup...");
//#endif


//#if 982314059
            facade = (IFacade) java.rmi.Naming.lookup("//" + healthwatcher.Constants.SERVER_NAME + "/" + healthwatcher.Constants.SYSTEM_NAME);
//#endif


//#if -413439253
            System.out.println("Remote DisqueSaude found");
//#endif

        }

//#if -646680482
        catch (java.rmi.RemoteException rmiEx) { //1

//#if -1792877245
            rmiInitExceptionHandling(rmiEx);
//#endif

        }

//#endif


//#if 643709891
        catch (java.rmi.NotBoundException rmiEx) { //1

//#if -2098677403
            rmiInitExceptionHandling(rmiEx);
//#endif

        }

//#endif


//#if -19234851
        catch (java.net.MalformedURLException rmiEx) { //1

//#if -221963668
            rmiInitExceptionHandling(rmiEx);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if 2012758146
    protected void rmiInitExceptionHandling(Throwable exception)
    {

//#if 1906046231
        String error =  "<p>****************************************************<br>" +
                        "Error during servlet initialization!<br>" +
                        "The exception message is:<br><dd>" + exception.getMessage() +
                        "<p>You may have to restart the servlet container.<br>" +
                        "*******************************************************";
//#endif


//#if 1641442347
        System.out.println(error);
//#endif

    }

//#endif

}

//#endif


//#if -692958751
public class HWServlet extends
//#if 14424804
    HttpServlet
//#endif

{

//#if -420512161
    protected IFacade facade = null;
//#endif


//#if 967470562
    private Hashtable commandTable;
//#endif


//#if 2077956016
    private static final String CommandConfigRMI		             = "ConfigRMI";
//#endif


//#if 523978297
    private static final String CommandGetDataForSearchByDiseaseType = "SearchByDiseaseType";
//#endif


//#if -1390625087
    private static final String CommandGetDataForSearchByHealthUnit  = "SearchByHealthUnit";
//#endif


//#if 70534202
    private static final String CommandGetDataForSearchBySpeciality  = "SearchBySpecialty";
//#endif


//#if 1212327408
    private static final String CommandInsertAnimalComplaint         = "InsertAnimalComplaint";
//#endif


//#if 1704834600
    private static final String CommandInsertEmployee                = "InsertEmployee";
//#endif


//#if 848660464
    private static final String CommandInsertFoodComplaint           = "InsertFoodComplaint";
//#endif


//#if -457778000
    private static final String CommandInsertSpecialComplaint        = "InsertSpecialComplaint";
//#endif


//#if 649872528
    private static final String CommandLogin                         = "Login";
//#endif


//#if 1476391472
    private static final String CommandLoginMenu                     = "LoginMenu";
//#endif


//#if -1740958320
    private static final String CommandSearchComplaintData           = "SearchComplaintData";
//#endif


//#if -1674734736
    private static final String CommandSearchDiseaseData             = "SearchDiseaseData";
//#endif


//#if -361728942
    private static final String CommandSearchHealthUnitsBySpecialty  = "SearchHealthUnitsBySpecialty";
//#endif


//#if -1715339696
    private static final String CommandSearchSpecialtiesByHealthUnit = "SearchSpecialtiesByHealthUnit";
//#endif


//#if -1195568400
    private static final String CommandUpdateComplaintData           = "UpdateComplaintData";
//#endif


//#if -803941520
    private static final String CommandUpdateComplaintList           = "UpdateComplaintList";
//#endif


//#if 1528655728
    private static final String CommandUpdateComplaintSearch         = "UpdateComplaintSearch";
//#endif


//#if -846150948
    private static final String CommandUpdateEmployeeData            = "UpdateEmployeeData";
//#endif


//#if -1594690984
    private static final String CommandUpdateEmployeeSearch          = "UpdateEmployeeSearch";
//#endif


//#if -244883200
    private static final String CommandUpdateHealthUnitData          = "UpdateHealthUnitData";
//#endif


//#if 452748156
    private static final String CommandUpdateHealthUnitSearch        = "UpdateHealthUnitSearch";
//#endif


//#if 508287464
    private static final String CommandUpdateHealthUnitList          = "UpdateHealthUnitList";
//#endif


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

//#if -1321511022
        String operation = request.getParameter("operation");
//#endif


//#if 802051639
        Command command = (Command) commandTable.get(operation);
//#endif


//#if 988877289
        command.setRequest(new ServletRequestAdapter(request));
//#endif


//#if 1202746292
        command.setReponse(new ServletResponseAdapter(response));
//#endif


//#if -299302734
        return command;
//#endif

    }

//#endif


//#if 573373009
    protected void rmiInitExceptionHandling(Throwable exception)
    {

//#if -864994478
        String error =  "<p>****************************************************<br>" +
                        "Error during servlet initialization!<br>" +
                        "The exception message is:<br><dd>" + exception.getMessage() +
                        "<p>You may have to restart the servlet container.<br>" +
                        "*******************************************************";
//#endif


//#if -274107696
        System.out.println(error);
//#endif

    }

//#endif


//#if 845119522
    protected void retry(HttpServletRequest request, HttpServletResponse response)
    {

//#if 793370587
        try { //1

//#if 1420739280
            initFacade();
//#endif


//#if 462529158
            Command command = getCommand(request, response);
//#endif


//#if 110578888
            command.execute();
//#endif

        }

//#if -1585859292
        catch (Exception e) { //1

//#if 1236910491
            e.printStackTrace();
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if 238131456
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

//#if -981859461
        handleRequest(request,response);
//#endif

    }

//#endif


//#if -1861375148
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

//#if -310494663
        handleRequest(request,response);
//#endif

    }

//#endif


//#if 1470963255
    private void initCommands()
    {

//#if 395734196
        commandTable = new Hashtable();
//#endif


//#if -1178699768
        commandTable.put(HWServlet.CommandConfigRMI, new ConfigRMI(facade));
//#endif


//#if 2083688776
        commandTable.put(HWServlet.CommandGetDataForSearchByDiseaseType, new GetDataForSearchByDiseaseType(facade));
//#endif


//#if 364355520
        commandTable.put(HWServlet.CommandGetDataForSearchByHealthUnit, new GetDataForSearchByHealthUnit(facade));
//#endif


//#if 1284939242
        commandTable.put(HWServlet.CommandGetDataForSearchBySpeciality, new GetDataForSearchBySpeciality(facade));
//#endif


//#if 2086326856
        commandTable.put(HWServlet.CommandInsertAnimalComplaint, new InsertAnimalComplaint(facade));
//#endif


//#if -1667695298
        commandTable.put(HWServlet.CommandInsertEmployee, new InsertEmployee(facade));
//#endif


//#if 713357192
        commandTable.put(HWServlet.CommandInsertFoodComplaint, new InsertFoodComplaint(facade));
//#endif


//#if -1415311930
        commandTable.put(HWServlet.CommandInsertSpecialComplaint, new InsertSpecialComplaint(facade));
//#endif


//#if -410771544
        commandTable.put(HWServlet.CommandLogin, new Login(facade));
//#endif


//#if 517988744
        commandTable.put(HWServlet.CommandLoginMenu, new LoginMenu(facade));
//#endif


//#if -217782424
        commandTable.put(HWServlet.CommandSearchComplaintData, new SearchComplaintData(facade));
//#endif


//#if -1736797880
        commandTable.put(HWServlet.CommandSearchDiseaseData, new SearchDiseaseData(facade));
//#endif


//#if -961042072
        commandTable.put(HWServlet.CommandSearchHealthUnitsBySpecialty, new SearchHealthUnitsBySpecialty(facade));
//#endif


//#if 1234298088
        commandTable.put(HWServlet.CommandSearchSpecialtiesByHealthUnit, new SearchSpecialtiesByHealthUnit(facade));
//#endif


//#if -1813995384
        commandTable.put(HWServlet.CommandUpdateComplaintData, new UpdateComplaintData(facade));
//#endif


//#if 2112482824
        commandTable.put(HWServlet.CommandUpdateComplaintList, new UpdateComplaintList(facade));
//#endif


//#if -1756811064
        commandTable.put(HWServlet.CommandUpdateComplaintSearch, new UpdateComplaintSearch(facade));
//#endif


//#if -361217806
        commandTable.put(HWServlet.CommandUpdateEmployeeData, new UpdateEmployeeData(facade));
//#endif


//#if -303578706
        commandTable.put(HWServlet.CommandUpdateEmployeeSearch, new UpdateEmployeeSearch(facade));
//#endif


//#if -824155306
        commandTable.put(HWServlet.CommandUpdateHealthUnitData, new UpdateHealthUnitData(facade));
//#endif


//#if -330791150
        commandTable.put(HWServlet.CommandUpdateHealthUnitSearch, new UpdateHealthUnitSearch(facade));
//#endif


//#if 752420670
        commandTable.put(HWServlet.CommandUpdateHealthUnitList, new UpdateHealthUnitList(facade));
//#endif


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

//#endif


//#if -173885031
    public void init(ServletConfig config) throws ServletException
    {

//#if -1124745655
        LogMechanism.configure(Constants.LOG_PATH);
//#endif


//#if -475156615
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

//#if -1502383883
            rmiInitExceptionHandling(rmiEx);
//#endif

        }

//#endif


//#if -757726537
        catch (java.rmi.NotBoundException rmiEx) { //1

//#if -1358196223
            rmiInitExceptionHandling(rmiEx);
//#endif

        }

//#endif


//#if -1955746607
        catch (java.net.MalformedURLException rmiEx) { //1

//#if 100993778
            rmiInitExceptionHandling(rmiEx);
//#endif

        }

//#endif


//#if 875688504
        catch (Exception e) { //1

//#if -835777935
            e.printStackTrace();
//#endif


//#if -1814884455
            throw new ServletException(e.getMessage());
//#endif

        }

//#endif


//#if 815704698
        catch (CommunicationException e) { //1

//#if -1482689472
            e.printStackTrace();
//#endif


//#if 2103422250
            throw new ServletException(e.getMessage());
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if -618314886
    protected void initFacade() throws CommunicationException
    {

//#if 1719769314
        facade = FacadeFactory.getRepositoryFactory().createClientFacade();
//#endif


//#if 540778509
        initCommands();
//#endif

    }

//#endif


//#if 1236860528
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

//#if -116797681
            Command command = getCommand(request, response);
//#endif


//#if -1889168751
            command.execute();
//#endif

        }

//#if -147518607
        catch (CommunicationException e) { //1

//#if -1329576604
            retry(request, response);
//#endif

        }

//#endif


//#if 130441329
        catch (FacadeUnavailableException e) { //1

//#if -1393360948
            retry(request, response);
//#endif

        }

//#endif


//#if 329141217
        catch (Exception e) { //1

//#if -1098049401
            e.printStackTrace();
//#endif

        }

//#endif


//#endif

    }

//#endif

}

//#endif


//#endif

