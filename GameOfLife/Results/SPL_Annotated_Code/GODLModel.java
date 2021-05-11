// Compilation Unit of /GODLModel.java


//#if  ModelBase
import java.util.Iterator;
//#endif


//#if  ModelBase
import java.util.ArrayList;
//#endif


//#if  ModelBase
import java.util.Collections;
//#endif


//#if  ModelBase
import java.util.List;
//#endif


//#if  Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator
import generator.FormGeneratorStrategy;
//#endif


//#if  Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator
import generator.GeneratorStrategy;
//#endif


//#if  Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator
import generator.ClearGeneratorStrategy;
//#endif


//#if  Composed  &&  UndoRedoGenerator  &&  UndoRedo
import java.util.LinkedList;
//#endif


//#if  ( Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator  &&  GameOfLife  &&  View  &&  Model ) && ! ( Composed  &&  UndoRedoGenerator  &&  UndoRedo )  && ! Test  && ! ModelBase
class GODLModel
{
    private GeneratorStrategy generator = null;
    public void generate()
    {
        if(generator == null) { //1
            generator = new ClearGeneratorStrategy();
        }

        Playground newGround = new Playground(playground.getXSize(), playground.getYSize(), 0);
        Iterator it = playground.iterator();
        while(it.hasNext()) { //1
            LifeForm current = (LifeForm) it.next();
            newGround.set(current.getX(), current.getY(), generator.getNext(current.getX(), current.getY()));
        }

        this.playground = newGround;
        notifyObservers();
    }

    public List getGeneratorStrategies()
    {
        return java.util.Collections.unmodifiableList(this.generators);
    }

    GODLModel  (int xSize, int ySize, RuleSet rules)
    {
        for (int i = 0;  i < generators.size(); i++) { //1
            if(generators.get(i) instanceof FormGeneratorStrategy) { //1
                generator = (GeneratorStrategy) generators.get(i);
                break;

            }

        }

        FormGeneratorStrategy fgs = new FormGeneratorStrategy(playground.getXSize(), playground.getYSize());
        generators.add(fgs);
        generators.add(new ClearGeneratorStrategy());
    }

    public void setGenerator(GeneratorStrategy generator)
    {
        this.generator = generator;
    }

}

//#endif


//#if  ModelBase
public class GODLModel extends ModelObservable
{
    private RuleSet rules;
    private Playground playground;
    private List generators;

//#if  ( ModelBase  &&  GameOfLife  &&  View  &&  Model  &&  Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator )
    private GeneratorStrategy generator = null;
//#endif


//#if  Composed  &&  UndoRedoGenerator  &&  UndoRedo
    private final LinkedList undoList;
//#endif


//#if  Composed  &&  UndoRedoGenerator  &&  UndoRedo
    private final LinkedList redoList;
//#endif


//#if  Composed  &&  UndoRedoGenerator  &&  UndoRedo
    public void redo()
    {
        undoList.push((Object) playground);
        playground = (Playground) redoList.pop();
        notifyObservers();
    }

//#endif


//#if  Composed  &&  UndoRedoGenerator  &&  UndoRedo
    public void undo()
    {
        redoList.push((Object) playground);
        playground = (Playground) undoList.pop();
        notifyObservers();
    }

//#endif

    public GODLModel(int xSize, int ySize, RuleSet rules)
    {

//#if  Composed  &&  UndoRedoGenerator  &&  UndoRedo
        this.undoList = new LinkedList();
//#endif


//#if  Composed  &&  UndoRedoGenerator  &&  UndoRedo
        this.redoList = new LinkedList();
//#endif


//#if  ( ModelBase  &&  GameOfLife  &&  View  &&  Model  &&  Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator )
        for (int i = 0;  i < generators.size(); i++) { //1
            if(generators.get(i) instanceof FormGeneratorStrategy) { //1
                generator = (GeneratorStrategy) generators.get(i);
                break;

            }

        }

//#endif


//#if  ( ModelBase  &&  GameOfLife  &&  View  &&  Model  &&  Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator )
        FormGeneratorStrategy fgs = new FormGeneratorStrategy(playground.getXSize(), playground.getYSize());
//#endif


//#if  ( ModelBase  &&  GameOfLife  &&  View  &&  Model  &&  Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator )
        generators.add(fgs);
//#endif


//#if  ( ModelBase  &&  GameOfLife  &&  View  &&  Model  &&  Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator )
        generators.add(new ClearGeneratorStrategy());
//#endif

        this.rules = rules;
        this.playground = new Playground(xSize, ySize, 0);
        this.generators = new java.util.ArrayList();
    }

    public void setPlayground(int[][] pg)
    {
        Playground newGround = new Playground(pg.length, pg[0].length, 0);
        for(int i = 0; i < pg.length; i++) { //1
            for(int j = 0; j < pg[i].length; j++) { //1
                newGround.set(i, j, pg[i][j]);
            }

        }

        this.playground = newGround;
        notifyObservers();
    }


//#if  ( ModelBase  &&  GameOfLife  &&  View  &&  Model  &&  Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator )
    public void generate()
    {
        if(generator == null) { //1
            generator = new ClearGeneratorStrategy();
        }

        Playground newGround = new Playground(playground.getXSize(), playground.getYSize(), 0);
        Iterator it = playground.iterator();
        while(it.hasNext()) { //1
            LifeForm current = (LifeForm) it.next();
            newGround.set(current.getX(), current.getY(), generator.getNext(current.getX(), current.getY()));
        }

        this.playground = newGround;
        notifyObservers();
    }

//#endif


//#if  ( ModelBase  &&  GameOfLife  &&  View  &&  Model  &&  Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator )
    public List getGeneratorStrategies()
    {
        return java.util.Collections.unmodifiableList(this.generators);
    }

//#endif


//#if  Test
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(playground);
        return sb.toString();
    }

//#endif


//#if  Test
    public boolean equals(Object o)
    {
        if(o == null) { //1
            return false;
        } else if(o instanceof GODLModel) { //1
            GODLModel ogm = (GODLModel) o;
            return playground.equals(ogm.playground) && rules.equals(ogm.rules);
        } else {
            return false;
        }


    }

//#endif


//#if  Composed  &&  UndoRedoGenerator  &&  UndoRedo
    public boolean undoAvailable()
    {
        return undoList != null && !undoList.isEmpty();
    }

//#endif

    public int[][] getPlayground()
    {
        return playground.getField();
    }


//#if  ( ModelBase  &&  GameOfLife  &&  View  &&  Model  &&  Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator )
    public void setGenerator(GeneratorStrategy generator)
    {
        this.generator = generator;
    }

//#endif


//#if  Composed  &&  UndoRedoGenerator  &&  UndoRedo
    public boolean redoAvailable()
    {
        return redoList != null && !redoList.isEmpty();
    }

//#endif

    public void setLifeform(int x, int y, int value)
    {
        playground.set(x, y, value);
        notifyObservers();
    }

    public void nextGeneration()
    {
        Playground newGround = new Playground(playground.getXSize(), playground.getYSize(), playground.getGeneration() + 1);
        Iterator it = playground.iterator();
        while(it.hasNext()) { //1
            LifeForm current = (LifeForm) it.next();
            newGround.set(current.getX(), current.getY(),  rules.apply(current));
        }

        this.playground = newGround;
        notifyObservers();
    }

}

//#endif


