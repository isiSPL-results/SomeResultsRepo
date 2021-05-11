
//#if 413135318 
// Compilation Unit of /PerspectiveComboBox.java 
 

//#if -1541713176 
package org.argouml.ui.explorer;
//#endif 


//#if -1228514754 
import javax.swing.JComboBox;
//#endif 


//#if -1715007225 
public class PerspectiveComboBox extends 
//#if -927833134 
JComboBox
//#endif 

 implements 
//#if 1919067418 
PerspectiveManagerListener
//#endif 

  { 

//#if 2001200935 
public void addPerspective(Object perspective)
    { 

//#if 1314076362 
addItem(perspective);
//#endif 

} 

//#endif 


//#if 1387143900 
public PerspectiveComboBox()
    { 

//#if 1259557244 
this.setMaximumRowCount(9);
//#endif 


//#if -934657416 
PerspectiveManager.getInstance().addListener(this);
//#endif 

} 

//#endif 


//#if 1829918254 
public void removePerspective(Object perspective)
    { 

//#if 1437298424 
removeItem(perspective);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

