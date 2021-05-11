package healthwatcher.business;
import healthwatcher.business.factories.FacadeFactory;
import healthwatcher.Constants;
import lib.logging.*;
public class HWServer
{
    public static void main(String[] args)
    {
        try { //1
            LogMechanism.configure(Constants.LOG_PATH);
            FacadeFactory.getRepositoryFactory().createServerFacade();
            LogMechanism.addLogToThreads();
        } catch (Exception e) { //1
            e.printStackTrace();
        }
    }

}
