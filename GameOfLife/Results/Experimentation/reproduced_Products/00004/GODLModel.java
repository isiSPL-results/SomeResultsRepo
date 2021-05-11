import generator.FormGeneratorStrategy;
import generator.GeneratorStrategy;
import generator.ClearGeneratorStrategy;
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
