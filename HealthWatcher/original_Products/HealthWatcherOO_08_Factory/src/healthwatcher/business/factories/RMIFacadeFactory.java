package healthwatcher.business.factories;

import healthwatcher.Constants;
import healthwatcher.business.RMIFacadeAdapter;
import healthwatcher.view.IFacade;
import healthwatcher.view.RMIServletAdapter;
import lib.exceptions.CommunicationException;

/*
 * A factory for a rmi facade
 */
public class RMIFacadeFactory extends AbstractFacadeFactory
{

    public IFacade createClientFacade() throws CommunicationException
    {
        return new RMIServletAdapter("//" + Constants.SERVER_NAME + "/" + Constants.SYSTEM_NAME);
    }


    public void createServerFacade() throws CommunicationException
    {
        try {
            RMIFacadeAdapter.getInstance();
        } catch (Exception e) {
            throw new CommunicationException(e.getMessage());
        }
    }
}
