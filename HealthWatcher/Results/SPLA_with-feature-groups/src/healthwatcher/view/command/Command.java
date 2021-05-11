
//#if -2126644641
// Compilation Unit of /Command.java

package healthwatcher.view.command;

//#if -860842463
import healthwatcher.view.IFacade;
//#endif


//#if -1784166474
import javax.servlet.http.HttpServletRequest;
//#endif


//#if -2128604880
import javax.servlet.http.HttpServletResponse;
//#endif

public abstract class Command
{
    protected IFacade facade;

//#if -503647418
    protected HttpServletRequest request;
//#endif


//#if 421386852
    protected HttpServletResponse response;
//#endif


//#if -1119363368
    protected CommandRequest request;
//#endif


//#if 1423845750
    protected CommandResponse response;
//#endif


//#if 1358649009
    public abstract void execute();
//#endif


//#if -682591645
    public void setReponse(HttpServletResponse response)
    {
        this.response = response;
    }

//#endif

    public Command(IFacade f)
    {
        facade= f;
    }


//#if 2040183524
    public void setRequest(HttpServletRequest request)
    {
        this.request = request;
    }

//#endif


//#if -1176568202
    public void setRequest(CommandRequest request)
    {
        this.request = request;
    }

//#endif


//#if -348292619
    public void setReponse(CommandResponse response)
    {
        this.response = response;
    }

//#endif


//#if -117648975
    public abstract void execute() throws Exception;
//#endif

}


//#endif

