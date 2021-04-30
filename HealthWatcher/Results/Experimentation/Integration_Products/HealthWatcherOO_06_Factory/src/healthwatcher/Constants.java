package healthwatcher;
public class Constants  { 
public static final String DB_URL = "jdbc:odbc:test";
public static final String DB_LOGIN = "orbi2";
public static final String DB_PASS = "orbi2";
public static final String DB_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
public static final String SERVER_NAME = "localhost";
public static final String SYSTEM_NAME = "HealthWatcher";
public static final String SERVLET_SERVER_PATH = "localhost:8080/servlet/healthwatcher.view.servlets.";
public static final String SYSTEM_ROOT = "http://" + SERVLET_SERVER_PATH + "ServletWebServer?file=";
public static final String SYSTEM_ACTION = "http://" + SERVLET_SERVER_PATH + "HWServlet";
public static final String SYSTEM_LOGIN = SYSTEM_ROOT + "Login.html";
public static final String SYSTEM_QUERIES = SYSTEM_ROOT + "QueriesMenu.html";
public static final String SYSTEM_INDEX = SYSTEM_ROOT + "index.html";
public static final String SYSTEM_INDEX_ADMINISTRATOR = SYSTEM_ACTION + "?operation=LoginMenu";
public static final String FORM_PATH = "c:\\Users\\greenwop\\workspace\\HealthWatcherOO_06_Factory\\web\\healthwatcher\\formularios\\";
public static boolean isPersistent()
    { 
return true;
} 

 } 
