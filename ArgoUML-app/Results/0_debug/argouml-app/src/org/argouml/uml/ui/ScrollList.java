
//#if 1420598349 
// Compilation Unit of /ScrollList.java 
 

//#if 855612271 
package org.argouml.uml.ui;
//#endif 


//#if -301122147 
import java.awt.Point;
//#endif 


//#if 889007386 
import java.awt.event.KeyEvent;
//#endif 


//#if 401403694 
import java.awt.event.KeyListener;
//#endif 


//#if -1173616091 
import javax.swing.JList;
//#endif 


//#if 1047714766 
import javax.swing.JScrollPane;
//#endif 


//#if 461677698 
import javax.swing.ListModel;
//#endif 


//#if -1679451117 
import javax.swing.ScrollPaneConstants;
//#endif 


//#if 1567303157 
public class ScrollList extends 
//#if 127213821 
JScrollPane
//#endif 

 implements 
//#if -350246575 
KeyListener
//#endif 

  { 

//#if -950176298 
private static final long serialVersionUID = 6711776013279497682L;
//#endif 


//#if 1090456467 
private UMLLinkedList list;
//#endif 


//#if 613661831 
public ScrollList(ListModel listModel, boolean showIcon, boolean showPath)
    { 

//#if -1940663350 
setHorizontalScrollBarPolicy(
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//#endif 


//#if 1194364705 
list = new UMLLinkedList(listModel, showIcon, showPath);
//#endif 


//#if 1144100373 
setViewportView(list);
//#endif 

} 

//#endif 


//#if -858262775 
public void keyReleased(KeyEvent arg0)
    { 
} 

//#endif 


//#if -1535885681 
@Deprecated
    public ScrollList(JList alist)
    { 

//#if 787125419 
setHorizontalScrollBarPolicy(
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//#endif 


//#if 673897898 
this.list = (UMLLinkedList) alist;
//#endif 


//#if -591349164 
setViewportView(list);
//#endif 

} 

//#endif 


//#if -941247145 
public ScrollList(ListModel listModel)
    { 

//#if 1639424431 
this(listModel, true, true);
//#endif 

} 

//#endif 


//#if 1259551469 
public void removeNotify()
    { 

//#if 1302624380 
super.removeNotify();
//#endif 


//#if -1329701509 
list.removeKeyListener(this);
//#endif 

} 

//#endif 


//#if -562403860 
public void addNotify()
    { 

//#if -910472023 
super.addNotify();
//#endif 


//#if 1554704220 
list.addKeyListener(this);
//#endif 

} 

//#endif 


//#if -1337516681 
public ScrollList(ListModel listModel, int visibleRowCount)
    { 

//#if 644490270 
setHorizontalScrollBarPolicy(
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//#endif 


//#if 961869001 
list = new UMLLinkedList(listModel, true, true);
//#endif 


//#if -1354757808 
list.setVisibleRowCount(visibleRowCount);
//#endif 


//#if 433439809 
setViewportView(list);
//#endif 

} 

//#endif 


//#if 1609936293 
public void keyPressed(KeyEvent e)
    { 

//#if -1801952429 
if(e.getKeyCode() == KeyEvent.VK_LEFT)//1
{ 

//#if 1332278899 
final Point posn = getViewport().getViewPosition();
//#endif 


//#if -1588080724 
if(posn.x > 0)//1
{ 

//#if -1617780458 
getViewport().setViewPosition(new Point(posn.x - 1, posn.y));
//#endif 

} 

//#endif 

} 
else

//#if 855948508 
if(e.getKeyCode() == KeyEvent.VK_RIGHT)//1
{ 

//#if -9242849 
final Point posn = getViewport().getViewPosition();
//#endif 


//#if -1633077762 
if(list.getWidth() - posn.x > getViewport().getWidth())//1
{ 

//#if -1030050738 
getViewport().setViewPosition(new Point(posn.x + 1, posn.y));
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1266764746 
public void keyTyped(KeyEvent arg0)
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

