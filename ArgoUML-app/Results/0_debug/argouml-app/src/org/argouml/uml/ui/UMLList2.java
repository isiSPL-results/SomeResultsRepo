
//#if -926487664 
// Compilation Unit of /UMLList2.java 
 

//#if -125594245 
package org.argouml.uml.ui;
//#endif 


//#if 1408398591 
import java.awt.Cursor;
//#endif 


//#if 1797270545 
import java.awt.Point;
//#endif 


//#if -421303956 
import java.awt.event.MouseEvent;
//#endif 


//#if 1873967516 
import java.awt.event.MouseListener;
//#endif 


//#if -1205921999 
import javax.swing.JList;
//#endif 


//#if -1120579044 
import javax.swing.JPopupMenu;
//#endif 


//#if -1320682566 
import javax.swing.ListCellRenderer;
//#endif 


//#if -1879946354 
import javax.swing.ListModel;
//#endif 


//#if -1788810249 
import org.apache.log4j.Logger;
//#endif 


//#if 58726250 
import org.argouml.model.Model;
//#endif 


//#if 629363642 
import org.argouml.ui.LookAndFeelMgr;
//#endif 


//#if 2059588541 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if -1559324591 
import org.argouml.ui.targetmanager.TargettableModelView;
//#endif 


//#if -912212260 
public abstract class UMLList2 extends 
//#if -763613950 
JList
//#endif 

 implements 
//#if 884292855 
TargettableModelView
//#endif 

, 
//#if 1042793299 
MouseListener
//#endif 

  { 

//#if -1091698584 
private static final Logger LOG = Logger.getLogger(UMLList2.class);
//#endif 


//#if -795750788 
public void mouseClicked(MouseEvent e)
    { 

//#if -2119997445 
showPopup(e);
//#endif 

} 

//#endif 


//#if -208797126 
public Object getTarget()
    { 

//#if 1836161140 
return ((UMLModelElementListModel2) getModel()).getTarget();
//#endif 

} 

//#endif 


//#if 1789739617 
public void mousePressed(MouseEvent e)
    { 

//#if -387311957 
showPopup(e);
//#endif 

} 

//#endif 


//#if 361023394 
public void mouseReleased(MouseEvent e)
    { 

//#if -1148130317 
showPopup(e);
//#endif 

} 

//#endif 


//#if 1537980623 
public TargetListener getTargettableModel()
    { 

//#if 229375779 
return (TargetListener) getModel();
//#endif 

} 

//#endif 


//#if 2042610476 
public void mouseEntered(MouseEvent e)
    { 

//#if -2081075177 
if(hasPopup())//1
{ 

//#if 268874933 
setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 144411170 
public void mouseExited(MouseEvent e)
    { 

//#if 851275650 
if(hasPopup())//1
{ 

//#if 613099233 
setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -618741526 
private final void showPopup(MouseEvent event)
    { 

//#if 352230880 
if(event.isPopupTrigger()
                && !Model.getModelManagementHelper().isReadOnly(getTarget()))//1
{ 

//#if 54460340 
Point point = event.getPoint();
//#endif 


//#if -873684121 
int index = locationToIndex(point);
//#endif 


//#if 1481662512 
JPopupMenu popup = new JPopupMenu();
//#endif 


//#if 1130749713 
ListModel lm = getModel();
//#endif 


//#if 340610659 
if(lm instanceof UMLModelElementListModel2)//1
{ 

//#if -683024042 
if(((UMLModelElementListModel2) lm).buildPopup(popup, index))//1
{ 

//#if -821804736 
LOG.debug("Showing popup");
//#endif 


//#if -1590262688 
popup.show(this, point.x, point.y);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1471528397 
protected boolean hasPopup()
    { 

//#if 1517265440 
if(getModel() instanceof UMLModelElementListModel2)//1
{ 

//#if -408079557 
return ((UMLModelElementListModel2) getModel()).hasPopup();
//#endif 

} 

//#endif 


//#if -1852441539 
return false;
//#endif 

} 

//#endif 


//#if 888300235 
protected UMLList2(ListModel dataModel, ListCellRenderer renderer)
    { 

//#if -2141726071 
super(dataModel);
//#endif 


//#if 232088337 
setDoubleBuffered(true);
//#endif 


//#if 1850016222 
if(renderer != null)//1
{ 

//#if 518893265 
setCellRenderer(renderer);
//#endif 

} 

//#endif 


//#if -58485103 
setFont(LookAndFeelMgr.getInstance().getStandardFont());
//#endif 


//#if -1320045563 
addMouseListener(this);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

