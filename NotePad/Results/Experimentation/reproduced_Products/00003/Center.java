import java.awt.*;
public class Center
{
    Notepad n;
    Fonts f;
    public void nCenter()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        n.setLocation((screenSize.width-n.getWidth())/2,(screenSize.height-n.getHeight())/2);
    }
    public Center(Notepad n)
    {
        this.n = n;
    }
    public void fCenter()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation((screenSize.width-f.getWidth())/2,(screenSize.height-f.getHeight())/2);
    }
    public Center(Fonts f)
    {
        this.f = f;
    }

}
