package p;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFileChooser;
@p.R4Feature(p.R4Feature.STATES)
public class LoadStateListener extends JFileChooser
 implements ActionListener
  { 
private BoardManager bM;
public void actionPerformed(ActionEvent e)
    { 
showOpenDialog(null);
if(null != getSelectedFile())//1
{ 
try//1
{ 
bM.loadState(getSelectedFile());
} 
catch (IOException ex)//1
{ 
ex.printStackTrace();
} 
catch (ClassNotFoundException ex)//1
{ 
ex.printStackTrace();
} 
} 
} 
public LoadStateListener(BoardManager bM)
    { 
this.bM = bM;
} 

 } 
