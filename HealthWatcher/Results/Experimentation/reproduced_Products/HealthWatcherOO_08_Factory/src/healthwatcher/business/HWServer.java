package healthwatcher.business;
import healthwatcher.business.factories.FacadeFactory;
public class HWServer
{
    public static void main(String[] args)
    {
        try { //1
            FacadeFactory.getRepositoryFactory().createServerFacade();
        } catch (Exception e) { //1
            e.printStackTrace();
        }
    }

}
