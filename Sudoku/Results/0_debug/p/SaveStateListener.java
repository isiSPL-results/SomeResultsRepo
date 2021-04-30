
//#if -66326705 
// Compilation Unit of /SaveStateListener.java 
 

//#if 177408895 
package p;
//#endif 


//#if -982201840 
import java.awt.event.ActionEvent;
//#endif 


//#if -412113288 
import java.awt.event.ActionListener;
//#endif 


//#if 1434549637 
import java.io.IOException;
//#endif 


//#if -1124317305 
import javax.swing.JFileChooser;
//#endif 


//#if 446913355 

//#if -923728309 
@p.R4Feature(p.R4Feature.STATES)
//#endif 

public class SaveStateListener extends 
//#if 1752356291 
JFileChooser
//#endif 

 implements 
//#if -1605609992 
ActionListener
//#endif 

  { 

//#if 1400429780 
private BoardManager bm;
//#endif 


//#if 1546944351 
public void actionPerformed(ActionEvent e)
    { 

//#if 645610699 
showSaveDialog(null);
//#endif 


//#if -203005604 
if(null != getSelectedFile())//1
{ 

//#if -1592470273 
try //1
{ 

//#if 1685801368 
bm.saveState(getSelectedFile());
//#endif 

} 

//#if -151731604 
catch (IOException ex)//1
{ 

//#if 775167195 
ex.printStackTrace();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 254894112 
public SaveStateListener(BoardManager bm)
    { 

//#if -2138986023 
this.bm = bm;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

