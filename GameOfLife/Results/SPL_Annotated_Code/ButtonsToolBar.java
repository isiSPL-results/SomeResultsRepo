
//#if  IO
// Compilation Unit of /ButtonsToolBar.java


//#if  IO
import java.awt.FlowLayout;
//#endif


//#if  IO
import java.awt.event.ActionEvent;
//#endif


//#if  IO
import java.awt.event.ActionListener;
//#endif


//#if  IO
import java.awt.event.MouseAdapter;
//#endif


//#if  IO
import java.awt.event.MouseEvent;
//#endif


//#if  IO
import java.io.File;
//#endif


//#if  IO
import java.io.IOException;
//#endif


//#if  IO
import java.net.URL;
//#endif


//#if  IO
import javax.swing.AbstractAction;
//#endif


//#if  IO
import javax.swing.Action;
//#endif


//#if  IO
import javax.swing.ImageIcon;
//#endif


//#if  IO
import javax.swing.JButton;
//#endif


//#if  IO
import javax.swing.JFileChooser;
//#endif


//#if  IO
import javax.swing.JPanel;
//#endif


//#if  IO
import javax.swing.JToolBar;
//#endif

class ButtonsToolBar
{
    ButtonsToolBar(ModelObservable mod,  final GenerationScheduler sched)
    {
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
    }

}


//#endif

