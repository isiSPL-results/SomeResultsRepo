
//#if -2126644641
// Compilation Unit of /Command.java


//#if 650440018
package healthwatcher.view.command;
//#endif


//#if -860842463
import healthwatcher.view.IFacade;
//#endif


//#if -1784166474
import javax.servlet.http.HttpServletRequest;
//#endif


//#if -2128604880
import javax.servlet.http.HttpServletResponse;
//#endif


//#if -1792758741
public abstract class Command
{

//#if -1935266394
    protected IFacade facade;
//#endif


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

//#if 1007156672
        this.response = response;
//#endif

    }

//#endif


//#if 1087974458
    public Command(IFacade f)
    {

//#if 368122555
        facade= f;
//#endif

    }

//#endif


//#if 2040183524
    public void setRequest(HttpServletRequest request)
    {

//#if 1138508020
        this.request = request;
//#endif

    }

//#endif


//#if -1176568202
    public void setRequest(CommandRequest request)
    {

//#if -112696407
        this.request = request;
//#endif

    }

//#endif


//#if -348292619
    public void setReponse(CommandResponse response)
    {

//#if 2138377723
        this.response = response;
//#endif

    }

//#endif


//#if -117648975
    public abstract void execute() throws Exception;
//#endif

}

//#endif


//#endif

