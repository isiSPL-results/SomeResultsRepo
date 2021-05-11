import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import generator.FormGeneratorStrategy;
import generator.GeneratorStrategy;
import generator.ClearGeneratorStrategy;
import java.util.LinkedList;
public class GODLModel extends ModelObservable
{
    private RuleSet rules;
    private Playground playground;
    private List generators;
    private GeneratorStrategy generator = null;
    private final LinkedList undoList;
    private final LinkedList redoList;
    public void redo()
    {
        undoList.push((Object) playground);
        playground = (Playground) redoList.pop();
        notifyObservers();
    }
    public void undo()
    {
        redoList.push((Object) playground);
        playground = (Playground) undoList.pop();
        notifyObservers();
    }
    public GODLModel(int xSize, int ySize, RuleSet rules)
    {
        this.undoList = new LinkedList();
        this.redoList = new LinkedList();
        for (int i = 0;  i < generators.size(); i++) { //1
            if(generators.get(i) instanceof FormGeneratorStrategy) { //1
                generator = (GeneratorStrategy) generators.get(i);
                break;

            }
        }
        FormGeneratorStrategy fgs = new FormGeneratorStrategy(playground.getXSize(), playground.getYSize());
        generators.add(fgs);
        generators.add(new ClearGeneratorStrategy());
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
    public boolean undoAvailable()
    {
        return undoList != null && !undoList.isEmpty();
    }
    public int[][] getPlayground()
    {
        return playground.getField();
    }
    public void setGenerator(GeneratorStrategy generator)
    {
        this.generator = generator;
    }
    public boolean redoAvailable()
    {
        return redoList != null && !redoList.isEmpty();
    }
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
