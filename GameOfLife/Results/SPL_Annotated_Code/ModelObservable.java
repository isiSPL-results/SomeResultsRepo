// Compilation Unit of /ModelObservable.java 
 

//#if  ModelBase  
import java.util.LinkedList;
//#endif 


//#if  ModelBase  
import java.util.List;
//#endif 


//#if  ModelBase  
import java.util.Iterator;
//#endif 


//#if  Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator  
import generator.GeneratorStrategy;
//#endif 


//#if  ModelBase  
public abstract class ModelObservable  { 
private List observers=new LinkedList();
public abstract void setPlayground(  int[][] pg);

//#if  Composed  &&  UndoRedoGenerator  &&  UndoRedo  
public abstract boolean undoAvailable();
//#endif 


//#if  Composed  &&  UndoRedoGenerator  &&  UndoRedo  
public abstract void redo();
//#endif 


//#if  ( ModelBase  &&  GameOfLife  &&  View  &&  Model  &&  Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator ) 
public abstract void setGenerator(GeneratorStrategy generator);
//#endif 


//#if  ( ModelBase  &&  GameOfLife  &&  View  &&  Model  &&  Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator ) 
public abstract void generate();
//#endif 

public abstract void nextGeneration();

//#if  ( ModelBase  &&  GameOfLife  &&  View  &&  Model  &&  Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator ) 
public abstract List getGeneratorStrategies();
//#endif 


//#if  Composed  &&  UndoRedoGenerator  &&  UndoRedo  
public abstract boolean redoAvailable();
//#endif 

public void attach(ModelObserver o)
    { 
if(o == null)//1
{ 
throw new IllegalArgumentException("Parameter is null");
} 

observers.add(o);
} 

public abstract int[][] getPlayground();
public void notifyObservers()
    { 
Iterator it = observers.iterator();
while(it.hasNext()) //1
{ 
ModelObserver x;
x = (ModelObserver) it.next();
x.update();
} 

} 

public void detach(  ModelObserver o)
    { 
if(o == null)//1
{ 
throw new IllegalArgumentException("Parameter is null");
} 

observers.remove(o);
} 

public abstract void setLifeform(  int coord,  int coord2,  int i);

//#if  Composed  &&  UndoRedoGenerator  &&  UndoRedo  
public abstract void undo();
//#endif 

 } 

//#endif 


//#if  ( Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator  &&  GameOfLife  &&  View  &&  Model ) && ! ( Composed  &&  UndoRedoGenerator  &&  UndoRedo )  && ! Test  && ! ModelBase  
class ModelObservable  { 
public abstract void generate();
public abstract void setGenerator(GeneratorStrategy generator);
public abstract List getGeneratorStrategies();
 } 

//#endif 


