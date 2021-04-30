


import generator.FormGeneratorStrategy;


import generator.GeneratorStrategy;
import generator.ClearGeneratorStrategy;



class  GODLModel
{

    GODLModel  (int xSize, int ySize, RuleSet rules)
    {
        for (int i = 0;  i < generators.size(); i++) {
            if (generators.get(i) instanceof FormGeneratorStrategy) {
                generator = (GeneratorStrategy) generators.get(i);
                break;
            }
        }

        FormGeneratorStrategy fgs = new FormGeneratorStrategy(playground.getXSize(), playground.getYSize());
        generators.add(fgs);

        generators.add(new ClearGeneratorStrategy());
    }



    private GeneratorStrategy generator = null;


    public void setGenerator(GeneratorStrategy generator)
    {
        this.generator = generator;
    }


    public List getGeneratorStrategies()
    {
        return java.util.Collections.unmodifiableList(this.generators);
    }



    public void generate()
    {
        if (generator == null) {
            generator = new ClearGeneratorStrategy();
        }
        Playground newGround = new Playground(playground.getXSize(), playground.getYSize(), 0);
        Iterator it = playground.iterator();
        while(it.hasNext()) {
            LifeForm current = (LifeForm) it.next();
            newGround.set(current.getX(), current.getY(), generator.getNext(current.getX(), current.getY()));
        }
        this.playground = newGround;
        notifyObservers();
    }


}
