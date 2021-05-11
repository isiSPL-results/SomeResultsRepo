
//#if -973436199
// Compilation Unit of /Print.java


//#if -1366944410
import java.awt.*;
//#endif


//#if -1491644281
import java.awt.print.*;
//#endif


//#if 12294688
import javax.swing.*;
//#endif


//#if -112244512
public class Print implements
//#if 10954462
    Printable
//#endif

{

//#if -1022708729
    private Component componentToBePrinted;
//#endif


//#if -417448008
    public static void disableDoubleBuffering(Component c)
    {

//#if 179407490
        RepaintManager currentManager = RepaintManager.currentManager(c);
//#endif


//#if 1184065345
        currentManager.setDoubleBufferingEnabled(false);
//#endif

    }

//#endif


//#if -1749918913
    public static void printComponent(Component c)
    {

//#if -1842583596
        new Print(c).print();
//#endif

    }

//#endif


//#if -948922168
    public void print()
    {

//#if 788769725
        PrinterJob printJob = PrinterJob.getPrinterJob();
//#endif


//#if -112145680
        printJob.setPrintable(this);
//#endif


//#if 37293520
        if(printJob.printDialog()) { //1

//#if 205235038
            try { //1

//#if -1948094024
                printJob.print();
//#endif

            }

//#if -344945609
            catch(PrinterException pe) { //1

//#if -1678459826
                System.out.println("Error printing: " + pe);
//#endif

            }

//#endif


//#endif

        }

//#endif

    }

//#endif


//#if -412574187
    public static void enableDoubleBuffering(Component c)
    {

//#if -1101371277
        RepaintManager currentManager = RepaintManager.currentManager(c);
//#endif


//#if 1788281411
        currentManager.setDoubleBufferingEnabled(true);
//#endif

    }

//#endif


//#if -1238231544
    public Print(Component componentToBePrinted)
    {

//#if 418188140
        this.componentToBePrinted = componentToBePrinted;
//#endif

    }

//#endif


//#if -308714435
    public int print(Graphics g, PageFormat pageFormat, int pageIndex)
    {

//#if -1428120319
        if(pageIndex > 0) { //1

//#if -791594434
            return(NO_SUCH_PAGE);
//#endif

        } else {

//#if -743089060
            Graphics2D g2d = (Graphics2D)g;
//#endif


//#if 1149044109
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
//#endif


//#if 878433631
            disableDoubleBuffering(componentToBePrinted);
//#endif


//#if 1958010791
            componentToBePrinted.paint(g2d);
//#endif


//#if -961956000
            enableDoubleBuffering(componentToBePrinted);
//#endif


//#if -608745655
            return(PAGE_EXISTS);
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

