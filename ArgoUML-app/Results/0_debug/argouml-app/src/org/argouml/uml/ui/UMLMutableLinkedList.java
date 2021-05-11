
//#if -1614733402 
// Compilation Unit of /UMLMutableLinkedList.java 
 

//#if -1815004578 
package org.argouml.uml.ui;
//#endif 


//#if 692323170 
import java.awt.Cursor;
//#endif 


//#if 1912718670 
import java.awt.Point;
//#endif 


//#if 2056034319 
import java.awt.event.MouseEvent;
//#endif 


//#if -459496423 
import java.awt.event.MouseListener;
//#endif 


//#if -1917034919 
import javax.swing.JPopupMenu;
//#endif 


//#if -709138598 
import org.apache.log4j.Logger;
//#endif 


//#if 1138397901 
import org.argouml.model.Model;
//#endif 


//#if -464519548 
public class UMLMutableLinkedList extends 
//#if 369207722 
UMLLinkedList
//#endif 

 implements 
//#if 1230823384 
MouseListener
//#endif 

  { 

//#if -394546890 
private static final Logger LOG =
        Logger.getLogger(UMLMutableLinkedList.class);
//#endif 


//#if 296006706 
private boolean deletePossible = true;
//#endif 


//#if 1322068137 
private boolean addPossible = false;
//#endif 


//#if 1488124362 
private boolean newPossible = false;
//#endif 


//#if -1827813773 
private JPopupMenu popupMenu;
//#endif 


//#if 607463830 
private AbstractActionAddModelElement2 addAction = null;
//#endif 


//#if -1193855052 
private AbstractActionNewModelElement newAction = null;
//#endif 


//#if -310806762 
private AbstractActionRemoveElement deleteAction = null;
//#endif 


//#if 1521860999 
@Override
    public void mouseReleased(MouseEvent e)
    { 

//#if 474063597 
if(e.isPopupTrigger()
                && !Model.getModelManagementHelper().isReadOnly(getTarget()))//1
{ 

//#if 1974636245 
Point point = e.getPoint();
//#endif 


//#if -1427463363 
int index = locationToIndex(point);
//#endif 


//#if -665299144 
JPopupMenu popup = getPopupMenu();
//#endif 


//#if 1199146201 
Object model = getModel();
//#endif 


//#if -1608813839 
if(model instanceof UMLModelElementListModel2)//1
{ 

//#if -1395718204 
((UMLModelElementListModel2) model).buildPopup(popup, index);
//#endif 

} 

//#endif 


//#if -854930543 
if(popup.getComponentCount() > 0)//1
{ 

//#if -113038838 
initActions();
//#endif 


//#if -1593594241 
LOG.info("Showing popup at " + e.getX() + "," + e.getY());
//#endif 


//#if 872619485 
popup.show(this, e.getX(), e.getY());
//#endif 

} 

//#endif 


//#if 181223458 
e.consume();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 19635053 
protected void initActions()
    { 

//#if -521677995 
if(isAdd())//1
{ 

//#if -157160493 
addAction.setTarget(getTarget());
//#endif 

} 

//#endif 


//#if -1118238444 
if(isNew())//1
{ 

//#if 2048337056 
newAction.setTarget(getTarget());
//#endif 

} 

//#endif 


//#if -318623191 
if(isDelete())//1
{ 

//#if 1094241882 
deleteAction.setObjectToRemove(getSelectedValue());
//#endif 


//#if -1008256922 
deleteAction.setTarget(getTarget());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1362629905 
public void setDelete(boolean delete)
    { 

//#if 44791436 
deletePossible = delete;
//#endif 

} 

//#endif 


//#if -1775044644 
@Override
    public void mousePressed(MouseEvent e)
    { 

//#if 1276606611 
if(e.isPopupTrigger()
                && !Model.getModelManagementHelper().isReadOnly(getTarget()))//1
{ 

//#if -1616232128 
JPopupMenu popup = getPopupMenu();
//#endif 


//#if -495172471 
if(popup.getComponentCount() > 0)//1
{ 

//#if -1498767426 
initActions();
//#endif 


//#if -1737311908 
LOG.debug("Showing popup at " + e.getX() + "," + e.getY());
//#endif 


//#if 1118232053 
getPopupMenu().show(this, e.getX(), e.getY());
//#endif 

} 

//#endif 


//#if -1981824230 
e.consume();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 569144226 
public AbstractActionAddModelElement2 getAddAction()
    { 

//#if 520025557 
return addAction;
//#endif 

} 

//#endif 


//#if 114853011 
public UMLMutableLinkedList(UMLModelElementListModel2 dataModel,
                                AbstractActionAddModelElement2 theAddAction,
                                AbstractActionNewModelElement theNewAction)
    { 

//#if 1545246393 
this(dataModel, theAddAction, theNewAction, null, true);
//#endif 

} 

//#endif 


//#if -65567753 
@Override
    public void mouseClicked(MouseEvent e)
    { 

//#if 285742317 
if(e.isPopupTrigger()
                && !Model.getModelManagementHelper().isReadOnly(getTarget()))//1
{ 

//#if -1604951895 
JPopupMenu popup = getPopupMenu();
//#endif 


//#if 546799744 
if(popup.getComponentCount() > 0)//1
{ 

//#if 1806536232 
initActions();
//#endif 


//#if -1748539999 
LOG.info("Showing popup at " + e.getX() + "," + e.getY());
//#endif 


//#if -357026081 
getPopupMenu().show(this, e.getX(), e.getY());
//#endif 

} 

//#endif 


//#if 1421365841 
e.consume();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 670267790 
public void setNewAction(AbstractActionNewModelElement action)
    { 

//#if -1333498525 
if(action != null)//1
{ 

//#if 75891962 
newPossible = true;
//#endif 

} 

//#endif 


//#if -458035243 
newAction = action;
//#endif 

} 

//#endif 


//#if -964496199 
public boolean isNew()
    { 

//#if -1690502935 
return newAction != null && newPossible;
//#endif 

} 

//#endif 


//#if -479541548 
public boolean isDelete()
    { 

//#if -1077050624 
return deleteAction != null & deletePossible;
//#endif 

} 

//#endif 


//#if 541483538 
public AbstractActionNewModelElement getNewAction()
    { 

//#if 2120324251 
return newAction;
//#endif 

} 

//#endif 


//#if -544563193 
public UMLMutableLinkedList(UMLModelElementListModel2 dataModel,
                                AbstractActionAddModelElement2 theAddAction)
    { 

//#if 1124838156 
this(dataModel, theAddAction, null, null, true);
//#endif 

} 

//#endif 


//#if 282752143 
public UMLMutableLinkedList(UMLModelElementListModel2 dataModel,
                                AbstractActionNewModelElement theNewAction)
    { 

//#if 1239168827 
this(dataModel, null, theNewAction, null, true);
//#endif 

} 

//#endif 


//#if 1733411830 
public void setDeleteAction(AbstractActionRemoveElement action)
    { 

//#if 1201797848 
deleteAction = action;
//#endif 

} 

//#endif 


//#if -655405880 
public void setAddAction(AbstractActionAddModelElement2 action)
    { 

//#if -1826041411 
if(action != null)//1
{ 

//#if 206077410 
addPossible = true;
//#endif 

} 

//#endif 


//#if 1551735792 
addAction = action;
//#endif 

} 

//#endif 


//#if 74048189 
public void mouseExited(MouseEvent e)
    { 

//#if -819603066 
setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
//#endif 

} 

//#endif 


//#if -1522173785 
@Override
    public void mouseEntered(MouseEvent e)
    { 

//#if 1460484485 
setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
//#endif 

} 

//#endif 


//#if 1405683777 
public JPopupMenu getPopupMenu()
    { 

//#if -988596309 
if(popupMenu == null)//1
{ 

//#if 464963528 
popupMenu =  new PopupMenu();
//#endif 

} 

//#endif 


//#if -1890415044 
return popupMenu;
//#endif 

} 

//#endif 


//#if -637176252 
public UMLMutableLinkedList(UMLModelElementListModel2 dataModel,
                                JPopupMenu popup)
    { 

//#if -331388110 
this(dataModel, popup, false);
//#endif 

} 

//#endif 


//#if -1147533425 
public UMLMutableLinkedList(UMLModelElementListModel2 dataModel,
                                AbstractActionAddModelElement2 theAddAction,
                                AbstractActionNewModelElement theNewAction,
                                AbstractActionRemoveElement theDeleteAction, boolean showIcon)
    { 

//#if -375921015 
super(dataModel, showIcon);
//#endif 


//#if -876281116 
setAddAction(theAddAction);
//#endif 


//#if 1660057924 
setNewAction(theNewAction);
//#endif 


//#if -1101609447 
if(theDeleteAction != null)//1
{ 

//#if -1345998717 
setDeleteAction(theDeleteAction);
//#endif 

} 

//#endif 


//#if -471008391 
addMouseListener(this);
//#endif 

} 

//#endif 


//#if -1698499354 
protected UMLMutableLinkedList(UMLModelElementListModel2 dataModel)
    { 

//#if 225210468 
this(dataModel, null, null, null, true);
//#endif 


//#if -1414798204 
setDelete(false);
//#endif 


//#if -1143789996 
setDeleteAction(null);
//#endif 

} 

//#endif 


//#if -976550022 
public boolean isAdd()
    { 

//#if -1756757995 
return addAction != null && addPossible;
//#endif 

} 

//#endif 


//#if 332207778 
public AbstractActionRemoveElement getDeleteAction()
    { 

//#if 1150784516 
return deleteAction;
//#endif 

} 

//#endif 


//#if -1300388110 
public UMLMutableLinkedList(UMLModelElementListModel2 dataModel,
                                JPopupMenu popup, boolean showIcon)
    { 

//#if -1824584203 
super(dataModel, showIcon);
//#endif 


//#if -1253602222 
setPopupMenu(popup);
//#endif 

} 

//#endif 


//#if 350420584 
public void setPopupMenu(JPopupMenu menu)
    { 

//#if 582962631 
popupMenu = menu;
//#endif 

} 

//#endif 


//#if 1912927829 
private class PopupMenu extends 
//#if -1825176181 
JPopupMenu
//#endif 

  { 

//#if 1521219193 
public PopupMenu()
        { 

//#if -312919279 
super();
//#endif 


//#if -702282777 
if(isAdd())//1
{ 

//#if 358022792 
addAction.setTarget(getTarget());
//#endif 


//#if 127443004 
add(addAction);
//#endif 


//#if -710317328 
if(isNew() || isDelete())//1
{ 

//#if 1995440393 
addSeparator();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1298843226 
if(isNew())//1
{ 

//#if 1593680707 
newAction.setTarget(getTarget());
//#endif 


//#if -2120047305 
add(newAction);
//#endif 


//#if 1221183295 
if(isDelete())//1
{ 

//#if 421226750 
addSeparator();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 878338135 
if(isDelete())//1
{ 

//#if -904923369 
deleteAction.setObjectToRemove(getSelectedValue());
//#endif 


//#if 1979534665 
deleteAction.setTarget(getTarget());
//#endif 


//#if -164583509 
add(deleteAction);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

