package healthwatcher.view.servlets;
import healthwatcher.view.IFacade;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
public abstract class HWServlet extends HttpServlet
  { 
protected IFacade facade = null;
public void init(ServletConfig config) throws ServletException
    { 
try//1
{ 
System.out.println("About to lookup...");
facade = (IFacade) java.rmi.Naming.lookup("//" + healthwatcher.Constants.SERVER_NAME + "/" + healthwatcher.Constants.SYSTEM_NAME);
System.out.println("Remote DisqueSaude found");
} 
catch (java.rmi.RemoteException rmiEx) //1
{ 
rmiInitExceptionHandling(rmiEx);
} 
catch (java.rmi.NotBoundException rmiEx) //1
{ 
rmiInitExceptionHandling(rmiEx);
} 
catch (java.net.MalformedURLException rmiEx) //1
{ 
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
