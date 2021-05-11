
//#if -1088616423 
// Compilation Unit of /UMLLinkedList.java 
 

//#if 955341488 
package org.argouml.uml.ui;
//#endif 


//#if -1498310071 
import java.awt.Color;
//#endif 


//#if 1812174723 
import javax.swing.ListModel;
//#endif 


//#if -1092637523 
import javax.swing.ListSelectionModel;
//#endif 


//#if 1157917858 
public class UMLLinkedList extends 
//#if 732920990 
UMLList2
//#endif 

  { 

//#if -1867257711 
public UMLLinkedList(ListModel dataModel)
    { 

//#if 1905207009 
this(dataModel, true);
//#endif 

} 

//#endif 


//#if -1296660543 
public UMLLinkedList(ListModel dataModel,
                         boolean showIcon, boolean showPath)
    { 

//#if -1300592813 
super(dataModel, new UMLLinkedListCellRenderer(showIcon, showPath));
//#endif 


//#if 1899490029 
setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//#endif 


//#if -1031265208 
setForeground(Color.blue);
//#endif 


//#if -1563767438 
setSelectionForeground(Color.blue.darker());
//#endif 


//#if -1701344630 
UMLLinkMouseListener mouseListener = new UMLLinkMouseListener(this);
//#endif 


//#if 2029558857 
addMouseListener(mouseListener);
//#endif 

} 

//#endif 


//#if 891281215 
public UMLLinkedList(ListModel dataModel,
                         boolean showIcon)
    { 

//#if -490223060 
this(dataModel, showIcon, true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

