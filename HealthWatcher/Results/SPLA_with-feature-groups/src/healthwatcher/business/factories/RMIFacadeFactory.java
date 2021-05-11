
//#if 1549299179
// Compilation Unit of /RMIFacadeFactory.java

package healthwatcher.business.factories;

//#if 1056711305
import healthwatcher.Constants;
//#endif


//#if -2107353213
import healthwatcher.business.RMIFacadeAdapter;
//#endif


//#if -583255868
import healthwatcher.view.IFacade;
//#endif


//#if -1107069873
import healthwatcher.view.RMIServletAdapter;
//#endif


//#if 1631239376
import lib.exceptions.CommunicationException;
//#endif

public class RMIFacadeFactory extends AbstractFacadeFactory
{
    public void createServerFacade() throws CommunicationException
    {
        try { //1
            RMIFacadeAdapter.getInstance();
        }

//#if 763963309
        catch (Exception e) { //1
            throw new CommunicationException(e.getMessage());
        }

//#endif


    }

    public IFacade createClientFacade() throws CommunicationException
    {
        return new RMIServletAdapter("//" + Constants.SERVER_NAME + "/" + Constants.SYSTEM_NAME);
    }

}


//#endif

