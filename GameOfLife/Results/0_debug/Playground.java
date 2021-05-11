
//#if -129041925
// Compilation Unit of /Playground.java


//#if 462372130
import java.util.Arrays;
//#endif


//#if 1385873454
import java.util.Iterator;
//#endif


//#if -1575712519
class Playground implements
//#if 473267334
    Iterable
//#endif

    ,
//#if -1137129821
    Cloneable
//#endif

{

//#if -377864320
    int[][] field;
//#endif


//#if -1497788931
    int xSize;
//#endif


//#if -1469159780
    int ySize;
//#endif


//#if 1258775459
    private int generation;
//#endif


//#if 1904998148
    int[] getNeighbourhood(int x, int y)
    {

//#if 551108137
        int xCurrent = x - 1;
//#endif


//#if 257734921
        int yCurrent = y - 1;
//#endif


//#if 57603702
        int[] result = new int[8];
//#endif


//#if 1499164681
        for(int i = 0; i < 8; i++) { //1

//#if 250963191
            if(xCurrent < 0 || xCurrent >= xSize || yCurrent < 0 || yCurrent >= ySize) { //1

//#if 458144015
                result[i] = 0;
//#endif

            } else {

//#if 820105874
                result[i] = field[xCurrent][yCurrent];
//#endif

            }

//#endif


//#if -1250160869
            xCurrent++;
//#endif


//#if 815528629
            if(xCurrent > x + 1) { //1

//#if -297994085
                xCurrent = x - 1;
//#endif


//#if -1578286949
                yCurrent++;
//#endif

            }

//#endif


//#if 1403805526
            if(xCurrent == x && yCurrent == y) { //1

//#if 2057341817
                xCurrent++;
//#endif

            }

//#endif

        }

//#endif


//#if -321931247
        return result;
//#endif

    }

//#endif


//#if -223789859
    public int getGeneration()
    {

//#if -36956585
        return generation;
//#endif

    }

//#endif


//#if -2015070447
    public void set(int x, int y, int value)
    {

//#if 48278443
        field[x][y] = value;
//#endif

    }

//#endif


//#if 1561505169
    public Playground(int xSize, int ySize, int generation)
    {

//#if -845975035
        this.xSize = xSize;
//#endif


//#if -688263165
        this.ySize = ySize;
//#endif


//#if 42893049
        field = new int[xSize][ySize];
//#endif


//#if 349488958
        for(int i = 0; i < xSize; i++) { //1

//#if -1198714318
            field[i] = new int[ySize];
//#endif


//#if -266379970
            Arrays.fill(field[i], 0);
//#endif

        }

//#endif


//#if -532237411
        this.generation = generation;
//#endif

    }

//#endif


//#if 751727386
    public Iterator iterator()
    {

//#if 2053458058
        return new LifeFormIterator(this);
//#endif

    }

//#endif


//#if -783598570
    public int getXSize()
    {

//#if -1397757851
        return xSize;
//#endif

    }

//#endif


//#if -1152431322
    public Playground clone()
    {

//#if -1827369293
        Playground clone = new Playground(xSize, ySize, generation);
//#endif


//#if 1208522881
        int[][] newField = new int[xSize][ySize];
//#endif


//#if -1276065847
        for(int i = 0; i < xSize; i++) { //1

//#if 572355543
            for (int j = 0; j < ySize; j++) { //1

//#if 432963288
                newField[i][j] = field[i][j];
//#endif

            }

//#endif

        }

//#endif


//#if 2104285649
        clone.field = newField;
//#endif


//#if 1665627114
        return clone;
//#endif

    }

//#endif


//#if 676726971
    public String toString()
    {

//#if -517103790
        StringBuilder sb = new StringBuilder();
//#endif


//#if -1980580522
        sb.append("Gen: " + generation);
//#endif


//#if 1160502953
        sb.append("\n");
//#endif


//#if -2062735065
        for(int i = 0; i < xSize; i++) { //1

//#if 97850474
            for (int j = 0; j < ySize; j++) { //1

//#if -2119295986
                sb.append(field[i][j] + " ");
//#endif

            }

//#endif


//#if -1940603160
            sb.append("\n");
//#endif

        }

//#endif


//#if 47423897
        return sb.toString();
//#endif

    }

//#endif


//#if -505282825
    public boolean equals(Object o)
    {

//#if -447439356
        if(o == null) { //1

//#if 251086631
            return false;
//#endif

        } else

//#if -1707365289
            if(o instanceof Playground) { //1

//#if -331954353
                Playground op = (Playground) o;
//#endif


//#if -2012349009
                return op.generation == this.generation && op.xSize == this.xSize &&
                       op.ySize == this.ySize && Arrays.deepEquals(op.field, this.field);
//#endif

            } else {

//#if 1433960035
                return false;
//#endif

            }

//#endif


//#endif

    }

//#endif


//#if 1173627
    public int[][] getField()
    {

//#if 1185817618
        int[][] result = new int[field.length][];
//#endif


//#if -1063729265
        for(int i = 0; i < field.length; i++) { //1

//#if 1847053542
            result[i] = new int[field[i].length];
//#endif


//#if -262854185
            System.arraycopy(field[i], 0, result[i], 0, field[i].length);
//#endif

        }

//#endif


//#if -854290677
        return result;
//#endif

    }

//#endif


//#if 103905111
    public int getYSize()
    {

//#if -1120751333
        return ySize;
//#endif

    }

//#endif

}

//#endif


//#endif

