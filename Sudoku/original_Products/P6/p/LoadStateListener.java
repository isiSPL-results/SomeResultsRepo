package p;

//#if STATES
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFileChooser;

@p.R4Feature(p.R4Feature.STATES)
public class LoadStateListener extends JFileChooser implements ActionListener
{
    private BoardManager bM;

    public LoadStateListener(BoardManager bM)
    {
        this.bM = bM;
    }


    public void actionPerformed(ActionEvent e)
    {
        showOpenDialog(null);
        if (null != getSelectedFile()) {
            try {
                bM.loadState(getSelectedFile());
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
// #endif
