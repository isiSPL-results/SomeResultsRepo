package healthwatcher.business.factories;
public class FacadeFactory
{
    protected static AbstractFacadeFactory instance = null;
    public static AbstractFacadeFactory getRepositoryFactory()
    {
        if(instance == null) { //1
            instance = new RMIFacadeFactory();
        }
        return instance;
    }

}
