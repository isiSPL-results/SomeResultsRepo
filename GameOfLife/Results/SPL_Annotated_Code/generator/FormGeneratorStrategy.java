
//#if  Options  &&  Generator  &&  DefaultGenerator  &&  FormDefaultGenerator  &&  ConcretGenerator  &&  FormGenerator  &&  AbstractGenerator
// Compilation Unit of /FormGeneratorStrategy.java

package generator;
public class FormGeneratorStrategy implements GeneratorStrategy
{
    private final int xSize;
    private final int ySize;
    public int getNext(int x, int y)
    {
        if(x == 0 || x == xSize || y == 0 || y == ySize) { //1
            return 0;
        } else {
            if(x == y || x+1 == y || y+1 == x) { //1
                return 1;
            } else {
                return 0;
            }

        }

    }

    public String toString()
    {
        return "Form Generator";
    }

    public FormGeneratorStrategy(int xSize, int ySize)
    {
        this.xSize = xSize;
        this.ySize = ySize;
    }

}


//#endif

