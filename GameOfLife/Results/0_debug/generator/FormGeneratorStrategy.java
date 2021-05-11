
//#if 1903602258
// Compilation Unit of /FormGeneratorStrategy.java


//#if -1188017914
package generator;
//#endif


//#if 23187995
public class FormGeneratorStrategy implements
//#if 2063406688
    GeneratorStrategy
//#endif

{

//#if -56081128
    private final int xSize;
//#endif


//#if -27451977
    private final int ySize;
//#endif


//#if 1188960027
    public int getNext(int x, int y)
    {

//#if 304026357
        if(x == 0 || x == xSize || y == 0 || y == ySize) { //1

//#if -761064158
            return 0;
//#endif

        } else {

//#if 633881445
            if(x == y || x+1 == y || y+1 == x) { //1

//#if -1889323950
                return 1;
//#endif

            } else {

//#if 2111464236
                return 0;
//#endif

            }

//#endif

        }

//#endif

    }

//#endif


//#if 194271469
    public String toString()
    {

//#if 346256374
        return "Form Generator";
//#endif

    }

//#endif


//#if 1110046577
    public FormGeneratorStrategy(int xSize, int ySize)
    {

//#if 1724088553
        this.xSize = xSize;
//#endif


//#if 1881800423
        this.ySize = ySize;
//#endif

    }

//#endif

}

//#endif


//#endif

