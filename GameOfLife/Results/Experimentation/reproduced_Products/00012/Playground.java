import java.util.Arrays;
import java.util.Iterator;
class Playground implements Iterable
{
    int[][] field;
    int xSize;
    int ySize;
    private int generation;
    int[] getNeighbourhood(int x, int y)
    {
        int xCurrent = x - 1;
        int yCurrent = y - 1;
        int[] result = new int[8];
        for(int i = 0; i < 8; i++) { //1
            if(xCurrent < 0 || xCurrent >= xSize || yCurrent < 0 || yCurrent >= ySize) { //1
                result[i] = 0;
            } else {
                result[i] = field[xCurrent][yCurrent];
            }
            xCurrent++;
            if(xCurrent > x + 1) { //1
                xCurrent = x - 1;
                yCurrent++;
            }
            if(xCurrent == x && yCurrent == y) { //1
                xCurrent++;
            }
        }
        return result;
    }
    public int getGeneration()
    {
        return generation;
    }
    public void set(int x, int y, int value)
    {
        field[x][y] = value;
    }
    public Playground(int xSize, int ySize, int generation)
    {
        this.xSize = xSize;
        this.ySize = ySize;
        field = new int[xSize][ySize];
        for(int i = 0; i < xSize; i++) { //1
            field[i] = new int[ySize];
            Arrays.fill(field[i], 0);
        }
        this.generation = generation;
    }
    public Iterator iterator()
    {
        return new LifeFormIterator(this);
    }
    public int getXSize()
    {
        return xSize;
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Gen: " + generation);
        sb.append("\n");
        for(int i = 0; i < xSize; i++) { //1
            for (int j = 0; j < ySize; j++) { //1
                sb.append(field[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public boolean equals(Object o)
    {
        if(o == null) { //1
            return false;
        } else if(o instanceof Playground) { //1
            Playground op = (Playground) o;
            return op.generation == this.generation && op.xSize == this.xSize &&
                   op.ySize == this.ySize && Arrays.deepEquals(op.field, this.field);
        } else {
            return false;
        }
    }
    public int[][] getField()
    {
        int[][] result = new int[field.length][];
        for(int i = 0; i < field.length; i++) { //1
            result[i] = new int[field[i].length];
            System.arraycopy(field[i], 0, result[i], 0, field[i].length);
        }
        return result;
    }
    public int getYSize()
    {
        return ySize;
    }

}
