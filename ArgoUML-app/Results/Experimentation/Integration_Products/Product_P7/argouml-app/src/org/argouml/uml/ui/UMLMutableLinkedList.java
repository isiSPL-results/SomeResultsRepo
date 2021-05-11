package org.argouml.uml.ui;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPopupMenu;
import org.apache.log4j.Logger;
import org.argouml.model.Model;
public class UMLMutableLinkedList extends UMLLinkedList
 implements MouseListener
  { 
private static final Logger LOG =
        Logger.getLogger(UMLMutableLinkedList.class);
private boolean deletePossible = true;
private boolean addPossible = false;
private boolean newPossible = false;
private JPopupMenu popupMenu;
private AbstractActionAddModelElement2 addAction = null;
private AbstractActionNewModelElement newAction = null;
private AbstractActionRemoveElement deleteAction = null;
@Override
    public void mouseReleased(MouseEvent e)
    { 
if(e.isPopupTrigger()
                && !Model.getModelManagementHelper().isReadOnly(getTarget()))//1
{ 
Point point = e.getPoint();
int index = locationToIndex(point);
JPopupMenu popup = getPopupMenu();
Object model = getModel();
if(model instanceof UMLModelElementListModel2)//1
{ 
((UMLModelElementListModel2) model).buildPopup(popup, index);
} 
if(popup.getComponentCount() > 0)//1
{ 
initActions();
LOG.info("Showing popup at " + e.getX() + "," + e.getY());
popup.show(this, e.getX(), e.getY());
} 
e.consume();
} 
} 
protected void initActions()
    { 
if(isAdd())//1
{ 
addAction.setTarget(getTarget());
} 
if(isNew())//1
{ 
newAction.setTarget(getTarget());
} 
if(isDelete())//1
{ 
deleteAction.setObjectToRemove(getSelectedValue());
deleteAction.setTarget(getTarget());
} 
} 
public void setDelete(boolean delete)
    { 
deletePossible = delete;
} 
@Override
    public void mousePressed(MouseEvent e)
    { 
if(e.isPopupTrigger()
                && !Model.getModelManagementHelper().isReadOnly(getTarget()))//1
{ 
JPopupMenu popup = getPopupMenu();
if(popup.getComponentCount() > 0)//1
{ 
initActions();
LOG.debug("Showing popup at " + e.getX() + "," + e.getY());
getPopupMenu().show(this, e.getX(), e.getY());
} 
e.consume();
} 
} 
public AbstractActionAddModelElement2 getAddAction()
    { 
return addAction;
} 
public UMLMutableLinkedList(UMLModelElementListModel2 dataModel,
                                AbstractActionAddModelElement2 theAddAction,
                                AbstractActionNewModelElement theNewAction)
    { 
this(dataModel, theAddAction, theNewAction, null, true);
} 
@Override
    public void mouseClicked(MouseEvent e)
    { 
if(e.isPopupTrigger()
                && !Model.getModelManagementHelper().isReadOnly(getTarget()))//1
{ 
JPopupMenu popup = getPopupMenu();
if(popup.getComponentCount() > 0)//1
{ 
initActions();
LOG.info("Showing popup at " + e.getX() + "," + e.getY());
getPopupMenu().show(this, e.getX(), e.getY());
} 
e.consume();
} 
} 
public void setNewAction(AbstractActionNewModelElement action)
    { 
if(action != null)//1
{ 
newPossible = true;
} 
newAction = action;
} 
public boolean isNew()
    { 
return newAction != null && newPossible;
} 
public boolean isDelete()
    { 
return deleteAction != null & deletePossible;
} 
public AbstractActionNewModelElement getNewAction()
    { 
return newAction;
} 
public UMLMutableLinkedList(UMLModelElementListModel2 dataModel,
                                AbstractActionAddModelElement2 theAddAction)
    { 
this(dataModel, theAddAction, null, null, true);
} 
public UMLMutableLinkedList(UMLModelElementListModel2 dataModel,
                                AbstractActionNewModelElement theNewAction)
    { 
this(dataModel, null, theNewAction, null, true);
} 
public void setDeleteAction(AbstractActionRemoveElement action)
    { 
deleteAction = action;
} 
public void setAddAction(AbstractActionAddModelElement2 action)
    { 
if(action != null)//1
{ 
addPossible = true;
} 
addAction = action;
} 
public void mouseExited(MouseEvent e)
    { 
setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
} 
@Override
    public void mouseEntered(MouseEvent e)
    { 
setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
} 
public JPopupMenu getPopupMenu()
    { 
if(popupMenu == null)//1
{ 
popupMenu =  new PopupMenu();
} 
return popupMenu;
} 
public UMLMutableLinkedList(UMLModelElementListModel2 dataModel,
                                JPopupMenu popup)
    { 
this(dataModel, popup, false);
} 
public UMLMutableLinkedList(UMLModelElementListModel2 dataModel,
                                AbstractActionAddModelElement2 theAddAction,
                                AbstractActionNewModelElement theNewAction,
                                AbstractActionRemoveElement theDeleteAction, boolean showIcon)
    { 
super(dataModel, showIcon);
setAddAction(theAddAction);
setNewAction(theNewAction);
if(theDeleteAction != null)//1
{ 
setDeleteAction(theDeleteAction);
} 
addMouseListener(this);
} 
protected UMLMutableLinkedList(UMLModelElementListModel2 dataModel)
    { 
this(dataModel, null, null, null, true);
setDelete(false);
setDeleteAction(null);
} 
public boolean isAdd()
    { 
return addAction != null && addPossible;
} 
public AbstractActionRemoveElement getDeleteAction()
    { 
return deleteAction;
} 
public UMLMutableLinkedList(UMLModelElementListModel2 dataModel,
                                JPopupMenu popup, boolean showIcon)
    { 
super(dataModel, showIcon);
setPopupMenu(popup);
} 
public void setPopupMenu(JPopupMenu menu)
    { 
popupMenu = menu;
} 
private class PopupMenu extends JPopupMenu
  { 
public PopupMenu()
        { 
super();
if(isAdd())//1
{ 
addAction.setTarget(getTarget());
add(addAction);
if(isNew() || isDelete())//1
{ 
addSeparator();
} 
} 
if(isNew())//1
{ 
newAction.setTarget(getTarget());
add(newAction);
if(isDelete())//1
{ 
addSeparator();
} 
} 
if(isDelete())//1
{ 
deleteAction.setObjectToRemove(getSelectedValue());
deleteAction.setTarget(getTarget());
add(deleteAction);
} 
} 

 } 

 } 
