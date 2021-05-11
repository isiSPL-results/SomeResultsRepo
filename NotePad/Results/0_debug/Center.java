
//#if 2116419250
// Compilation Unit of /Center.java


//#if 2043311699
import java.awt.*;
//#endif


//#if -453354129
public class Center
{

//#if -1466712253
    Notepad n;
//#endif


//#if 111222126
    Fonts f;
//#endif


//#if 553828412
    public void nCenter()
    {

//#if -430811097
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//#endif


//#if -1534764881
        n.setLocation((screenSize.width-n.getWidth())/2,(screenSize.height-n.getHeight())/2);
//#endif

    }

//#endif


//#if -1330716835
    public Center(Notepad n)
    {

//#if -1036204292
        this.n = n;
//#endif

    }

//#endif


//#if 2128562228
    public void fCenter()
    {

//#if 2091489879
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//#endif


//#if -1611248777
        f.setLocation((screenSize.width-f.getWidth())/2,(screenSize.height-f.getHeight())/2);
//#endif

    }

//#endif


//#if -1189193592
    public Center(Fonts f)
    {

//#if 2036060011
        this.f = f;
//#endif

    }

//#endif

}

//#endif


//#endif

