
//#if 1369422113
// Compilation Unit of /ButtonsToolBar.java


//#if -893861552
import java.awt.FlowLayout;
//#endif


//#if -2043437858
import java.awt.event.ActionEvent;
//#endif


//#if -440059670
import java.awt.event.ActionListener;
//#endif


//#if 568517962
import java.awt.event.MouseAdapter;
//#endif


//#if 55871199
import java.awt.event.MouseEvent;
//#endif


//#if 569369306
import java.io.File;
//#endif


//#if -2080106889
import java.io.IOException;
//#endif


//#if -1905328640
import java.net.URL;
//#endif


//#if 6948562
import javax.swing.AbstractAction;
//#endif


//#if -1393137580
import javax.swing.Action;
//#endif


//#if 287693912
import javax.swing.ImageIcon;
//#endif


//#if -916079152
import javax.swing.JButton;
//#endif


//#if 1296922069
import javax.swing.JFileChooser;
//#endif


//#if 1738066768
import javax.swing.JPanel;
//#endif


//#if 1790192281
import javax.swing.JToolBar;
//#endif


//#if -1793765138
class ButtonsToolBar
{

//#if 722711028
    ButtonsToolBar(ModelObservable mod,  final GenerationScheduler sched)
    {

//#if -1562281798
        add(makeNavigationButton("open24","Load","Laden","Laden",new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc=new JFileChooser();
                int resp=fc.showOpenDialog(ButtonsToolBar.this);
                if (resp == JFileChooser.APPROVE_OPTION) {
                    File selected=fc.getSelectedFile();
                    if (selected == null || !selected.exists()) {
                        return;
                    }
                    try {
                        model.setPlayground(PlaygroundIO.loadFromFile(selected));
                    } catch (          IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
                                ));
//#endif


//#if 1663552570
        add(makeNavigationButton("Save24","Save","Speichern","Speichern",new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc=new JFileChooser();
                int resp=fc.showSaveDialog(ButtonsToolBar.this);
                if (resp == JFileChooser.APPROVE_OPTION) {
                    File selected=fc.getSelectedFile();
                    if (selected == null) {
                        return;
                    }
                    try {
                        PlaygroundIO.saveToFile(model.getPlayground(),selected);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
                                ));
//#endif

    }

//#endif

}

//#endif


//#endif

