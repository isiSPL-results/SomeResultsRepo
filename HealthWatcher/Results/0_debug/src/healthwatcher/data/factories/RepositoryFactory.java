
//#if -959178123
// Compilation Unit of /RepositoryFactory.java


//#if -1831960141
package healthwatcher.data.factories;
//#endif


//#if -1033606193
import healthwatcher.Constants;
//#endif


//#if 824294604
import healthwatcher.business.HealthWatcherFacade;
//#endif


//#if 1045335265
public class RepositoryFactory
{

//#if 566176074
    protected static AbstractRepositoryFactory instance = null;
//#endif


//#if 404395542
    public static AbstractRepositoryFactory getRepositoryFactory()
    {

//#if -1603773190
        if(instance == null) { //1

//#if 587507558
            if(Constants.isPersistent()) { //1

//#if 2076171296
                instance = new RDBRepositoryFactory(HealthWatcherFacade.getPm());
//#endif

            } else {

//#if -468270041
                instance = new ArrayRepositoryFactory();
//#endif

            }

//#endif

        }

//#endif


//#if 1893747937
        return instance;
//#endif

    }

//#endif

}

//#endif


//#endif

