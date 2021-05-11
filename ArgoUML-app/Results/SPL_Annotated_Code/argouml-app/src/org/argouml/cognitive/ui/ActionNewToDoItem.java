// Compilation Unit of /ActionNewToDoItem.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.awt.event.ActionEvent;
//#endif 


//#if COGNITIVE 
import javax.swing.Action;
//#endif 


//#if COGNITIVE 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if COGNITIVE 
import org.argouml.i18n.Translator;
//#endif 


//#if COGNITIVE 
import org.argouml.ui.UndoableAction;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.ui.UMLListCellRenderer2;
//#endif 


//#if COGNITIVE 
public class ActionNewToDoItem extends UndoableAction
  { 
@Override
    public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
AddToDoItemDialog dialog = new AddToDoItemDialog(
            new UMLListCellRenderer2(true));
dialog.setVisible(true);
} 

public ActionNewToDoItem()
    { 
super(Translator.localize("action.new-todo-item"),
              ResourceLoaderWrapper.lookupIcon("action.new-todo-item"));
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.new-todo-item"));
} 

 } 

//#endif 


