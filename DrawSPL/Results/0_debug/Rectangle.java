
//#if -1002576972
// Compilation Unit of /Rectangle.java


//#if 1975519655
import java.awt.Graphics;
//#endif


//#if 1636645377
import java.awt.Color;
//#endif


//#if -695423858
public class Rectangle
{

//#if 113930736
    private int x, y, width, height ;
//#endif


//#if 405989317
    private int dx, dy;
//#endif


//#if 913943847
    private int x2, y2;
//#endif


//#if -1492944349
    private Color color;
//#endif


//#if -1260022667
    /** Called after rectangle is drawn.
    	 *  Adjusts the coordinate values of x and y
    	 */
    public void updateCorner()
    {

//#if -679495660
        int cornerX = x, cornerY = y;
//#endif


//#if -829638728
        if(dy < 0) { //1

//#if 1164865212
            if(dx >=0) { //1

//#if -986255204
                cornerX = x;
//#endif


//#if -508215990
                cornerY = y2;
//#endif

            } else {

//#if 1634426801
                cornerX = x2;
//#endif


//#if 1635351283
                cornerY = y2;
//#endif

            }

//#endif

        } else {

//#if 396899547
            if(dx >=0) { //1

//#if -499211130
                cornerX = x;
//#endif


//#if -499181308
                cornerY = y;
//#endif

            } else {

//#if 1912300240
                cornerX = x2;
//#endif


//#if 477358930
                cornerY = y;
//#endif

            }

//#endif

        }

//#endif


//#if 1238651393
        x = cornerX;
//#endif


//#if 1042137919
        y = cornerY;
//#endif

    }

//#endif


//#if 724651944
    /**
    	 * Called when the component Canvas is repainted
    	 * @param g
    	 */
    public void paint(Graphics g)
    {

//#if -1926489367
        int cornerX = x, cornerY = y;
//#endif


//#if -1640041971
        if(dy < 0) { //1

//#if 863431414
            if(dx >=0) { //1

//#if 688788554
                cornerX = x;
//#endif


//#if -121467044
                cornerY = y2;
//#endif

            } else {

//#if -1049412354
                cornerX = x2;
//#endif


//#if -1048487872
                cornerY = y2;
//#endif

            }

//#endif

        } else {

//#if -1720462358
            if(dx >=0) { //1

//#if 1063464140
                cornerX = x;
//#endif


//#if 1063493962
                cornerY = y;
//#endif

            } else {

//#if -1299983948
                cornerX = x2;
//#endif


//#if -1150283794
                cornerY = y;
//#endif

            }

//#endif

        }

//#endif


//#if 1324190916
        g.setColor(color);
//#endif


//#if -1528298726
        g.drawRect(cornerX, cornerY, width, height);
//#endif

    }

//#endif


//#if -1314804147
    public void setEnd(int newX, int newY)
    {

//#if 519920186
        width = StrictMath.abs(newX-x);
//#endif


//#if 1433321707
        height = StrictMath.abs(newY-y);
//#endif


//#if 383564614
        dx = newX - x;
//#endif


//#if -1423860027
        dy = newY - y;
//#endif


//#if 1924611831
        x2 = newX;
//#endif


//#if -627545099
        y2 = newY;
//#endif

    }

//#endif


//#if 1396511683
    public int getHeight()
    {

//#if 965933977
        return height;
//#endif

    }

//#endif


//#if 1451274046
    public int getX()
    {

//#if 2140454931
        return x;
//#endif

    }

//#endif


//#if -1176544421
    public Rectangle(

        Color color,

        int x, int y)
    {

//#if 1965261581
        this.color = color;
//#endif


//#if -1395316893
        this.x = x;
//#endif


//#if -1395287071
        this.y = y;
//#endif

    }

//#endif


//#if 71674281
    public Rectangle(



        int x, int y)
    {

//#if -1977480905
        this.x = x;
//#endif


//#if -1977451083
        this.y = y;
//#endif

    }

//#endif


//#if -109750644
    public int getWidth()
    {

//#if 969541219
        return width;
//#endif

    }

//#endif


//#if 1451275007
    public int getY()
    {

//#if 837551890
        return y;
//#endif

    }

//#endif

}

//#endif


//#endif

