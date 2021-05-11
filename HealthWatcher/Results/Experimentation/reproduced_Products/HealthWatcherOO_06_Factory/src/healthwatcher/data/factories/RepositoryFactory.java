package healthwatcher.data.factories;
import healthwatcher.Constants;
import healthwatcher.business.HealthWatcherFacade;
public class RepositoryFactory
{
    protected static AbstractRepositoryFactory instance = null;
    public static AbstractRepositoryFactory getRepositoryFactory()
    {
        if(instance == null) { //1
            if(Constants.isPersistent()) { //1
                instance = new RDBRepositoryFactory(HealthWatcherFacade.getPm());
            } else {
                instance = new ArrayRepositoryFactory();
            }
        }
        return instance;
    }

}
