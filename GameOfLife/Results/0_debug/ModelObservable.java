
//#if 214121957 
// Compilation Unit of /ModelObservable.java 
 

//#if -1638090241 
import java.util.LinkedList;
//#endif 


//#if -1848332072 
import java.util.List;
//#endif 


//#if 403512712 
import java.util.Iterator;
//#endif 


//#if 1533544789 
import generator.GeneratorStrategy;
//#endif 


//#if 589394239 
public abstract class ModelObservable  { 

//#if -416279900 
private List observers=new LinkedList();
//#endif 


//#if 984480425 
public abstract void setPlayground(  int[][] pg);
//#endif 


//#if -1268507031 
public abstract boolean undoAvailable();
//#endif 


//#if 16820254 
public abstract void redo();
//#endif 


//#if -1186101180 
public abstract void setGenerator(GeneratorStrategy generator);
//#endif 


//#if -1035273643 
public abstract void generate();
//#endif 


//#if 1959962763 
public abstract void nextGeneration();
//#endif 


//#if -987041576 
public abstract List getGeneratorStrategies();
//#endif 


//#if -1241134833 
public abstract boolean redoAvailable();
//#endif 


//#if -404888589 
public void attach(ModelObserver o)
    { 

//#if 1192151968 
if(o == null)//1
{ 

//#if 255781651 
throw new IllegalArgumentException("Parameter is null");
//#endif 

} 

//#endif 


//#if -991427876 
observers.add(o);
//#endif 

} 

//#endif 


//#if -1269490454 
public abstract int[][] getPlayground();
//#endif 


//#if 1627797240 
public void notifyObservers()
    { 

//#if -346890529 
Iterator it = observers.iterator();
//#endif 


//#if 1150766578 
while(it.hasNext()) //1
{ 

//#if -1416794908 
ModelObserver x;
//#endif 


//#if 160113459 
x = (ModelObserver) it.next();
//#endif 


//#if 1709087197 
x.update();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1099386559 
public void detach(  ModelObserver o)
    { 

//#if 288412294 
if(o == null)//1
{ 

//#if -435620199 
throw new IllegalArgumentException("Parameter is null");
//#endif 

} 

//#endif 


//#if 2003167329 
observers.remove(o);
//#endif 

} 

//#endif 


//#if 1675908398 
public abstract void setLifeform(  int coord,  int coord2,  int i);
//#endif 


//#if 111019396 
public abstract void undo();
//#endif 

 } 

//#endif 


//#if 529193780 
class ModelObservable  { 

//#if -25421099 
public abstract void generate();
//#endif 


//#if -685061948 
public abstract void setGenerator(GeneratorStrategy generator);
//#endif 


//#if -1298583208 
public abstract List getGeneratorStrategies();
//#endif 

 } 

//#endif 


//#endif 

