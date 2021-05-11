
//#if 227775529 
// Compilation Unit of /UMLSingleRowSelector.java 
 

//#if -341762968 
package org.argouml.uml.ui;
//#endif 


//#if -1266780660 
import java.awt.BorderLayout;
//#endif 


//#if -28093586 
import java.awt.Dimension;
//#endif 


//#if -388270754 
import javax.swing.JList;
//#endif 


//#if 955475158 
import javax.swing.JPanel;
//#endif 


//#if -670484409 
import javax.swing.JScrollPane;
//#endif 


//#if 835308347 
import javax.swing.ListModel;
//#endif 


//#if -1185390834 
public class UMLSingleRowSelector extends 
//#if 921974323 
JPanel
//#endif 

  { 

//#if -1306482119 
private JScrollPane scroll;
//#endif 


//#if -382201763 
private Dimension preferredSize = null;
//#endif 


//#if 177880592 
public Dimension getMaximumSize()
    { 

//#if -781157786 
Dimension size = super.getMaximumSize();
//#endif 


//#if -1371771393 
size.height = preferredSize.height;
//#endif 


//#if 1805379690 
return size;
//#endif 

} 

//#endif 


//#if 1136615330 
public UMLSingleRowSelector(ListModel model)
    { 

//#if 991908262 
super(new BorderLayout());
//#endif 


//#if -367459447 
scroll = new ScrollList(model, 1);
//#endif 


//#if 488550780 
add(scroll);
//#endif 


//#if -256907650 
preferredSize = scroll.getPreferredSize();
//#endif 


//#if -99515640 
scroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//#endif 


//#if -156960220 
scroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//#endif 

} 

//#endif 


//#if 1945959473 
public Dimension getPreferredSize()
    { 

//#if 1223227637 
return preferredSize;
//#endif 

} 

//#endif 


//#if 2000186750 
public Dimension getMinimumSize()
    { 

//#if 559609972 
Dimension size = super.getMinimumSize();
//#endif 


//#if -823366725 
size.height = preferredSize.height;
//#endif 


//#if 1342233382 
return size;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

