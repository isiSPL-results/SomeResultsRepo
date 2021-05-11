import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
public abstract class ModelObservable
{
    private List observers=new LinkedList();
    public abstract void setPlayground(  int[][] pg);
    public abstract void nextGeneration();
    public void attach(ModelObserver o)
    {
        if(o == null) { //1
            throw new IllegalArgumentException("Parameter is null");
        }
        observers.add(o);
    }
    public abstract int[][] getPlayground();
    public void notifyObservers()
    {
        Iterator it = observers.iterator();
        while(it.hasNext()) { //1
            ModelObserver x;
            x = (ModelObserver) it.next();
            x.update();
        }
    }
    public void detach(  ModelObserver o)
    {
        if(o == null) { //1
            throw new IllegalArgumentException("Parameter is null");
        }
        observers.remove(o);
    }
    public abstract void setLifeform(  int coord,  int coord2,  int i);
}
