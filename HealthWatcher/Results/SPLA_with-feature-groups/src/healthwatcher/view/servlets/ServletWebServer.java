// Compilation Unit of /ServletWebServer.java

package healthwatcher.view.servlets;
import healthwatcher.Constants;
import java.io.IOException;
import java.io.PrintWriter;

//#if -2019994833
import javax.servlet.ServletException;
//#endif

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lib.util.HTMLCode;
import lib.util.Library;

//#if -1214110380
import java.io.FileNotFoundException;
//#endif

public class ServletWebServer extends HWServlet
{
    private String[] keywords = { "##SYSTEM_ROOT##", "##SYSTEM_ACTION##",
                                  "##SERVLET_SERVER_PATH##", "##CLOSE##"
                                };
    private String[] newWords = { Constants.SYSTEM_ROOT,
                                  Constants.SYSTEM_ACTION, Constants.SERVLET_SERVER_PATH,
                                  HTMLCode.closeAdministrator()
                                };

//#if -18277132
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        PrintWriter out = null;
        response.setContentType("text/html");
        String file = request.getParameter("file");
        if(file == null) { //1
            file = "index.html";
        }

        try { //1
            out = response.getWriter();
        }

//#if 670824655
        catch (IOException e) { //1
            e.printStackTrace();
        }

//#endif


        try { //2
            out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+file));
        }

//#if 395810335
        catch (FileNotFoundException e) { //1
            e.printStackTrace();
        }

//#endif


        out.close();
    }

//#endif


//#if -184156280
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out;
        response.setContentType("text/html");
        String file = request.getParameter("file");
        if(file == null) { //1
            file = "index.html";
        }

        out = response.getWriter();
        out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+file));
        out.close();
    }

//#endif


//#if -2067393076
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out;
        response.setContentType("text/html");
        String file = request.getParameter("file");
        out = response.getWriter();
        out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+file));
        out.close();
    }

//#endif


//#if -779090888
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        PrintWriter out = null;
        response.setContentType("text/html");
        String file = request.getParameter("file");
        try { //1
            out = response.getWriter();
        }

//#if 1754280387
        catch (IOException e) { //1
            e.printStackTrace();
        }

//#endif


        try { //2
            out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+file));
        }

//#if -2058132330
        catch (FileNotFoundException e) { //1
            e.printStackTrace();
        }

//#endif


        out.close();
    }

//#endif

}


