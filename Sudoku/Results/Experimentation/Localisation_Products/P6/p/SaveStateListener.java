package p;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFileChooser;
@p.R4Feature(p.R4Feature.STATES)
public class SaveStateListener extends JFileChooser
 implements ActionListener
  { 
private BoardManager bm;
public void actionPerformed(ActionEvent e)
    { 
showSaveDialog(null);
if(null != getSelectedFile())//1
{ 
try//1
{ 
bm.saveState(getSelectedFile());
} 
catch (IOException ex)//1
{ 
ex.printStackTrace();
} 
} 
} 
public SaveStateListener(BoardManager bm)
    { 
this.bm = bm;
} 

 } 
