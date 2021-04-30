
//#if -1250210167
// Compilation Unit of /Loader.java


//#if -1050631897
package p;
//#endif


//#if 2065502264
public class Loader
{

//#if -1276226461
    protected Gui gui;
//#endif


//#if 1433995695
    protected static Loader loader;
//#endif


//#if -1650756614
    public void load()
    {

//#if -1327222664
        BoardManager bm = new BoardManager();
//#endif


//#if -149262216
        ListenerFactory listenerFactory = new ListenerFactory(bm);
//#endif


//#if 1811962915
        gui = new Gui(listenerFactory);
//#endif


//#if -1633238815
        bm.registerSudokuView(gui);
//#endif


//#if -2123365915
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                gui.createAndShowGUI();
            }
        });
//#endif

    }

//#endif


//#if -1118242293
    public static void main(String[] args)
    {

//#if 1006311264
        loader = new Loader();
//#endif


//#if 966686026
        loader.load();
//#endif

    }

//#endif

}

//#endif


//#endif

