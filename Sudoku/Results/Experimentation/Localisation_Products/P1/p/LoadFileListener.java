package p;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class LoadFileListener extends JFileChooser
 implements ActionListener
  { 
protected BoardManager bM;
public void actionPerformed(ActionEvent e)
    { 
showOpenDialog(null);
if(null != getSelectedFile())//1
{ 
try//1
{ 
boolean loaded = false;
if(!loaded)//1
{ 
bM.loadFile(getSelectedFile());
} 
} 
catch (IOException ex)//1
{ 
ex.printStackTrace();
} 
} 
} 
public LoadFileListener(BoardManager bM)
    { 
this.bM = bM;
} 

 } 
