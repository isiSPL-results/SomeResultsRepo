
//#if -987588049 
// Compilation Unit of /ActionFind.java 
 

//#if -1461345021 
package org.argouml.ui.cmd;
//#endif 


//#if 1048235127 
import java.awt.event.ActionEvent;
//#endif 


//#if 1118781677 
import javax.swing.Action;
//#endif 


//#if 437597450 
import javax.swing.Icon;
//#endif 


//#if 738409501 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1329507038 
import org.argouml.i18n.Translator;
//#endif 


//#if -556677075 
import org.argouml.ui.FindDialog;
//#endif 


//#if 1982508045 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -606149828 
class ActionFind extends 
//#if -1799912341 
UndoableAction
//#endif 

  { 

//#if 2086699219 
private String name;
//#endif 


//#if 1555997459 
public void actionPerformed(ActionEvent ae)
    { 

//#if 968173225 
FindDialog.getInstance().setVisible(true);
//#endif 

} 

//#endif 


//#if 849883152 
public ActionFind()
    { 

//#if 2131210855 
super(Translator.localize("action.find"));
//#endif 


//#if -1650110445 
name = "action.find";
//#endif 


//#if -1038294311 
putValue(Action.SHORT_DESCRIPTION, Translator.localize(name));
//#endif 


//#if 1962758834 
Icon icon = ResourceLoaderWrapper.lookupIcon(name);
//#endif 


//#if -1738297107 
putValue(Action.SMALL_ICON, icon);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

