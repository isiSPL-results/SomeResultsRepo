// Compilation Unit of /Constants.java 
 
package healthwatcher;
public class Constants  { 
public static final String DB_URL = "jdbc:odbc:test";
public static final String DB_LOGIN = "orbi2";
public static final String DB_PASS = "orbi2";
public static final String DB_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
public static final String SERVER_NAME = "localhost";
public static final String SYSTEM_NAME = "HealthWatcher";

//#if -620937199 
public static final String FORM_PATH = "c:\\Users\\greenwop\\workspace\\HealthWatcherOO_01_Base\\web\\healthwatcher\\formularios\\first\\";
//#endif 

public static final String SERVLET_SERVER_PATH = "localhost:8080/servlet/healthwatcher.view.servlets.";
public static final String SYSTEM_ROOT = "http://" + SERVLET_SERVER_PATH + "ServletWebServer?file=";
public static final String SYSTEM_ACTION = "http://" + SERVLET_SERVER_PATH + "HWServlet";

//#if 89442719 
public static final String SYSTEM_INDEX = "http://"+SERVLET_SERVER_PATH + "ServletWebServer?file=index.html";
//#endif 


//#if -1524064042 
public static final String SYSTEM_INDEX_ADMINISTRATOR = "http://"+SERVLET_SERVER_PATH+"ServletLogin";
//#endif 

public static final String SYSTEM_LOGIN = SYSTEM_ROOT + "Login.html";
public static final String SYSTEM_QUERIES = SYSTEM_ROOT + "QueriesMenu.html";

//#if 1268606158 
public static final String FORM_PATH = "c:\\Users\\greenwop\\workspace\\HealthWatcherOO_02_Command\\web\\healthwatcher\\formularios\\";
//#endif 


//#if -1239283089 
public static final String SYSTEM_INDEX = SYSTEM_ROOT + "index.html";
//#endif 


//#if 1785286877 
public static final String SYSTEM_INDEX_ADMINISTRATOR = SYSTEM_ACTION + "?operation=LoginMenu";
//#endif 


//#if -632411289 
public static final String FORM_PATH = "c:\\Users\\greenwop\\workspace\\HealthWatcherOO_03_State\\web\\healthwatcher\\formularios\\";
//#endif 


//#if 1569207215 
public static final String FORM_PATH = "c:\\Users\\greenwop\\workspace\\HealthWatcherOO_04_Observer\\web\\healthwatcher\\formularios\\";
//#endif 


//#if 506608679 
public static final String FORM_PATH = "c:\\Users\\greenwop\\workspace\\HealthWatcherOO_05_Adapter\\web\\healthwatcher\\formularios\\";
//#endif 


//#if 1653064939 
public static final String FORM_PATH = "c:\\Users\\greenwop\\workspace\\HealthWatcherOO_06_Factory\\web\\healthwatcher\\formularios\\";
//#endif 


//#if -1860085915 
public static final String FORM_PATH = "c:\\Users\\greenwop\\workspace\\HealthWatcherOO_07_Adapter\\web\\healthwatcher\\formularios\\";
//#endif 


//#if -713629655 
public static final String FORM_PATH = "c:\\Users\\greenwop\\workspace\\HealthWatcherOO_08_Factory\\web\\healthwatcher\\formularios\\";
//#endif 


//#if -258748169 
public static final String FORM_PATH = "c:\\Users\\greenwop\\workspace\\HealthWatcherOO_09_Evolution\\web\\healthwatcher\\formularios\\";
//#endif 


//#if 2026780904 
public static final String FORM_PATH = "c:\\Users\\greenwop\\workspace\\HealthWatcherOO_10_ExceptionHandling\\web\\healthwatcher\\formularios\\";
//#endif 


//#if -543860784 
public static final String LOG_PATH = "c:\\healthwatcherLog.log";
//#endif 

public static boolean isPersistent()
    { 
return true;
} 

 } 


