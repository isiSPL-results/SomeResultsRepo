
//#if -1431649092 
// Compilation Unit of /ServletWebServer.java 
 

//#if -372424292 
package healthwatcher.view.servlets;
//#endif 


//#if -25301381 
import healthwatcher.Constants;
//#endif 


//#if 470933199 
import java.io.IOException;
//#endif 


//#if 1091153432 
import java.io.PrintWriter;
//#endif 


//#if -2019994833 
import javax.servlet.ServletException;
//#endif 


//#if -1720963675 
import javax.servlet.http.HttpServletRequest;
//#endif 


//#if -169318111 
import javax.servlet.http.HttpServletResponse;
//#endif 


//#if 469137953 
import lib.util.HTMLCode;
//#endif 


//#if -2141047774 
import lib.util.Library;
//#endif 


//#if -1214110380 
import java.io.FileNotFoundException;
//#endif 


//#if 986522917 
public class ServletWebServer extends 
//#if -669281067 
HWServlet
//#endif 

  { 

//#if -1236886314 
private String[] keywords = { "##SYSTEM_ROOT##", "##SYSTEM_ACTION##",
                                  "##SERVLET_SERVER_PATH##", "##CLOSE##"
                                };
//#endif 


//#if 393557772 
private String[] newWords = { Constants.SYSTEM_ROOT,
                                  Constants.SYSTEM_ACTION, Constants.SERVLET_SERVER_PATH,
                                  HTMLCode.closeAdministrator()
                                };
//#endif 


//#if -18277132 
public void doGet(HttpServletRequest request, HttpServletResponse response)
    { 

//#if 1228100633 
PrintWriter out = null;
//#endif 


//#if -959717877 
response.setContentType("text/html");
//#endif 


//#if -1057121168 
String file = request.getParameter("file");
//#endif 


//#if 428833378 
if(file == null)//1
{ 

//#if 2118026348 
file = "index.html";
//#endif 

} 

//#endif 


//#if 2054289642 
try //1
{ 

//#if -1489065309 
out = response.getWriter();
//#endif 

} 

//#if 670824655 
catch (IOException e) //1
{ 

//#if 772165997 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if 353800583 
try //2
{ 

//#if -421586968 
out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+file));
//#endif 

} 

//#if 395810335 
catch (FileNotFoundException e) //1
{ 

//#if -8286574 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if -758767562 
out.close();
//#endif 

} 

//#endif 


//#if -184156280 
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 

//#if -1976676591 
PrintWriter out;
//#endif 


//#if -1879426365 
response.setContentType("text/html");
//#endif 


//#if 1798661304 
String file = request.getParameter("file");
//#endif 


//#if 1624335130 
if(file == null)//1
{ 

//#if -1074350688 
file = "index.html";
//#endif 

} 

//#endif 


//#if 1591405203 
out = response.getWriter();
//#endif 


//#if -236212808 
out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+file));
//#endif 


//#if -499932034 
out.close();
//#endif 

} 

//#endif 


//#if -2067393076 
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 

//#if -786533392 
PrintWriter out;
//#endif 


//#if -1649680798 
response.setContentType("text/html");
//#endif 


//#if -29022023 
String file = request.getParameter("file");
//#endif 


//#if -1775909710 
out = response.getWriter();
//#endif 


//#if 436614201 
out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+file));
//#endif 


//#if -1638546433 
out.close();
//#endif 

} 

//#endif 


//#if -779090888 
public void doPost(HttpServletRequest request, HttpServletResponse response)
    { 

//#if -1193969780 
PrintWriter out = null;
//#endif 


//#if -1898139912 
response.setContentType("text/html");
//#endif 


//#if -1645836189 
String file = request.getParameter("file");
//#endif 


//#if -268250723 
try //1
{ 

//#if -142442998 
out = response.getWriter();
//#endif 

} 

//#if 1754280387 
catch (IOException e) //1
{ 

//#if -109086295 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if 1476925428 
try //2
{ 

//#if 1480971087 
out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+file));
//#endif 

} 

//#if -2058132330 
catch (FileNotFoundException e) //1
{ 

//#if 752338690 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if 458253993 
out.close();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

