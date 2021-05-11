
//#if 1970559349 
// Compilation Unit of /UMLModelElementOrderedListModel2.java 
 

//#if 333691242 
package org.argouml.uml.ui;
//#endif 


//#if 830237986 
import java.awt.event.ActionEvent;
//#endif 


//#if -1975127188 
import javax.swing.JMenuItem;
//#endif 


//#if 1982526413 
import javax.swing.JPopupMenu;
//#endif 


//#if -1133437037 
import org.argouml.i18n.Translator;
//#endif 


//#if -1488817736 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 838718401 
class MoveDownAction extends 
//#if 1325832168 
UndoableAction
//#endif 

  { 

//#if 870694542 
private UMLModelElementOrderedListModel2 model;
//#endif 


//#if -1762031895 
private int index;
//#endif 


//#if -1039321250 
public MoveDownAction(UMLModelElementOrderedListModel2 theModel,
                          int theIndex)
    { 

//#if 1002201898 
super(Translator.localize("menu.popup.movedown"));
//#endif 


//#if 1102391640 
model = theModel;
//#endif 


//#if -331309256 
index = theIndex;
//#endif 

} 

//#endif 


//#if 767026929 
@Override
    public boolean isEnabled()
    { 

//#if -1396880125 
return model.getSize() > index + 1;
//#endif 

} 

//#endif 


//#if 607058293 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if 2114420150 
super.actionPerformed(e);
//#endif 


//#if -739722428 
model.moveDown(index);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 2090897370 
public abstract class UMLModelElementOrderedListModel2 extends 
//#if 1870359875 
UMLModelElementListModel2
//#endif 

  { 

//#if -1641591482 
public UMLModelElementOrderedListModel2(String name)
    { 

//#if -1359068478 
super(name);
//#endif 

} 

//#endif 


//#if 1870252494 
protected abstract void moveToTop(int index);
//#endif 


//#if -1970624941 
protected abstract void buildModelList();
//#endif 


//#if -1459976057 
protected abstract boolean isValidElement(Object element);
//#endif 


//#if 1878840846 
protected abstract void moveToBottom(int index);
//#endif 


//#if -846761841 
public boolean buildPopup(JPopupMenu popup, int index)
    { 

//#if 1447556858 
JMenuItem moveToTop = new JMenuItem(new MoveToTopAction(this, index));
//#endif 


//#if 1682665514 
JMenuItem moveUp = new JMenuItem(new MoveUpAction(this, index));
//#endif 


//#if -889360694 
JMenuItem moveDown = new JMenuItem(new MoveDownAction(this, index));
//#endif 


//#if -1710361014 
JMenuItem moveToBottom = new JMenuItem(new MoveToBottomAction(this,
                                               index));
//#endif 


//#if 337068034 
popup.add(moveToTop);
//#endif 


//#if -1277593513 
popup.add(moveUp);
//#endif 


//#if 108035614 
popup.add(moveDown);
//#endif 


//#if -1160116222 
popup.add(moveToBottom);
//#endif 


//#if -1939953139 
return true;
//#endif 

} 

//#endif 


//#if 780959786 
protected abstract void moveDown(int index);
//#endif 

 } 

//#endif 


//#if -102545785 
class MoveToTopAction extends 
//#if 1724553112 
UndoableAction
//#endif 

  { 

//#if -1802647330 
private UMLModelElementOrderedListModel2 model;
//#endif 


//#if -843294055 
private int index;
//#endif 


//#if 1960896833 
@Override
    public boolean isEnabled()
    { 

//#if 17382935 
return model.getSize() > 1 && index > 0;
//#endif 

} 

//#endif 


//#if 657919269 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if 1404166123 
super.actionPerformed(e);
//#endif 


//#if 1942621989 
model.moveToTop(index);
//#endif 

} 

//#endif 


//#if 1248929866 
public MoveToTopAction(UMLModelElementOrderedListModel2 theModel,
                           int theIndex)
    { 

//#if -265850402 
super(Translator.localize("menu.popup.movetotop"));
//#endif 


//#if -2055303566 
model = theModel;
//#endif 


//#if 805962834 
index = theIndex;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -817193670 
class MoveUpAction extends 
//#if 483150441 
UndoableAction
//#endif 

  { 

//#if 440007661 
private UMLModelElementOrderedListModel2 model;
//#endif 


//#if 169647402 
private int index;
//#endif 


//#if -918500426 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if -752422831 
super.actionPerformed(e);
//#endif 


//#if 752023917 
model.moveDown(index - 1);
//#endif 

} 

//#endif 


//#if 1669542040 
public MoveUpAction(UMLModelElementOrderedListModel2 theModel,
                        int theIndex)
    { 

//#if 422967772 
super(Translator.localize("menu.popup.moveup"));
//#endif 


//#if -1151645505 
model = theModel;
//#endif 


//#if 1709620895 
index = theIndex;
//#endif 

} 

//#endif 


//#if 2003696336 
@Override
    public boolean isEnabled()
    { 

//#if 1787173971 
return index > 0;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1359842267 
class MoveToBottomAction extends 
//#if -420574748 
UndoableAction
//#endif 

  { 

//#if -625046254 
private UMLModelElementOrderedListModel2 model;
//#endif 


//#if -726865435 
private int index;
//#endif 


//#if 1215929406 
public MoveToBottomAction(UMLModelElementOrderedListModel2 theModel,
                              int theIndex)
    { 

//#if 1699199929 
super(Translator.localize("menu.popup.movetobottom"));
//#endif 


//#if 1550617965 
model = theModel;
//#endif 


//#if 116917069 
index = theIndex;
//#endif 

} 

//#endif 


//#if 1278700657 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if -424456445 
super.actionPerformed(e);
//#endif 


//#if 1470284923 
model.moveToBottom(index);
//#endif 

} 

//#endif 


//#if 76503925 
@Override
    public boolean isEnabled()
    { 

//#if 681905680 
return model.getSize() > 1 && index < model.getSize() - 1;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

