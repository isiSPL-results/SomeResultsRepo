
//#if -554514480
// Compilation Unit of /HWServer.java


//#if 2113478338
package healthwatcher.business;
//#endif


//#if -1609620431
import healthwatcher.business.factories.FacadeFactory;
//#endif


//#if 460397114
import healthwatcher.Constants;
//#endif


//#if -1800443959
import lib.logging.*;
//#endif


//#if -1642327066
public class HWServer
{

//#if 1146184445
    public static void main(String[] args)
    {

//#if 2071674301
        try { //1

//#if 1053756296
            LogMechanism.configure(Constants.LOG_PATH);
//#endif


//#if -1362896192
            FacadeFactory.getRepositoryFactory().createServerFacade();
//#endif


//#if -52443964
            LogMechanism.addLogToThreads();
//#endif

        }

//#if 791361220
        catch (Exception e) { //1

//#if -751883335
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

