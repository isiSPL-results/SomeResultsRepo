
//#if -1000242266 
// Compilation Unit of /LoadFileListener.java 
 

//#if 989013251 
package p;
//#endif 


//#if -1237215340 
import java.awt.event.ActionEvent;
//#endif 


//#if 277854836 
import java.awt.event.ActionListener;
//#endif 


//#if -1955652479 
import java.io.IOException;
//#endif 


//#if 2129045003 
import javax.swing.JFileChooser;
//#endif 


//#if 93185647 
import javax.swing.JOptionPane;
//#endif 


//#if 1998146839 
public class LoadFileListener extends 
//#if -1304163897 
JFileChooser
//#endif 

 implements 
//#if -1163880196 
ActionListener
//#endif 

  { 

//#if -1556944403 
protected BoardManager bM;
//#endif 


//#if -1333335845 
public void actionPerformed(ActionEvent e)
    { 

//#if 135264197 
showOpenDialog(null);
//#endif 


//#if -307740011 
if(null != getSelectedFile())//1
{ 

//#if -1697338631 
try //1
{ 

//#if -1961469849 
boolean loaded = false;
//#endif 


//#if 1238382879 
if(p.R4Feature.SOLVER)//1
{ 

//#if -1568736452 
loaded = true;
//#endif 


//#if -1853670796 
if(!bM.tryLoadFile(getSelectedFile()))//1

//#if -757221451 
JOptionPane.showMessageDialog(null,
                                                      "Invalid sudoku! File was not loaded.");
//#endif 


//#endif 

} 

//#endif 


//#if 134721250 
if(!loaded)//1
{ 

//#if 1178648539 
bM.loadFile(getSelectedFile());
//#endif 

} 

//#endif 

} 

//#if 1595530027 
catch (IOException ex)//1
{ 

//#if 130766279 
ex.printStackTrace();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -76147840 
public LoadFileListener(BoardManager bM)
    { 

//#if -2098425381 
this.bM = bM;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

