
//#if -1118698310
// Compilation Unit of /LoadStateListener.java


//#if 705959200
package p;
//#endif


//#if -2029305679
import java.awt.event.ActionEvent;
//#endif


//#if -335110089
import java.awt.event.ActionListener;
//#endif


//#if -925709820
import java.io.IOException;
//#endif


//#if 1028780648
import javax.swing.JFileChooser;
//#endif


//#if -548727999

//#if -1420857082
@p.R4Feature(p.R4Feature.STATES)
//#endif

public class LoadStateListener extends
//#if 1616358398
    JFileChooser
//#endif

    implements
//#if 844401011
    ActionListener
//#endif

{

//#if 1014980975
    private BoardManager bM;
//#endif


//#if -769221564
    public void actionPerformed(ActionEvent e)
    {

//#if 794389330
        showOpenDialog(null);
//#endif


//#if 1925414312
        if(null != getSelectedFile()) { //1

//#if 1659485410
            try { //1

//#if -1706608340
                bM.loadState(getSelectedFile());
//#endif

            }

//#if 2006425580
            catch (IOException ex) { //1

//#if -125692318
                ex.printStackTrace();
//#endif

            }

//#endif


//#if 1897811899
            catch (ClassNotFoundException ex) { //1

//#if -2027779513
                ex.printStackTrace();
//#endif

            }

//#endif


//#endif

        }

//#endif

    }

//#endif


//#if -820266404
    public LoadStateListener(BoardManager bM)
    {

//#if 167370414
        this.bM = bM;
//#endif

    }

//#endif

}

//#endif


//#endif

