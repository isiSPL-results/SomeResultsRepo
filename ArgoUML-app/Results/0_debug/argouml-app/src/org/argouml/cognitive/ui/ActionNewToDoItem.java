
//#if 2042833408 
// Compilation Unit of /ActionNewToDoItem.java 
 

//#if -942806256 
package org.argouml.cognitive.ui;
//#endif 


//#if -1699378366 
import java.awt.event.ActionEvent;
//#endif 


//#if -949028168 
import javax.swing.Action;
//#endif 


//#if 348296818 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 2052834675 
import org.argouml.i18n.Translator;
//#endif 


//#if -823261521 
import org.argouml.ui.UndoableAction;
//#endif 


//#if -1869100446 
import org.argouml.uml.ui.UMLListCellRenderer2;
//#endif 


//#if 914702132 
public class ActionNewToDoItem extends 
//#if -45702841 
UndoableAction
//#endif 

  { 

//#if 1742827477 
@Override
    public void actionPerformed(ActionEvent ae)
    { 

//#if 1328046753 
super.actionPerformed(ae);
//#endif 


//#if 1637670119 
AddToDoItemDialog dialog = new AddToDoItemDialog(
            new UMLListCellRenderer2(true));
//#endif 


//#if -1013465460 
dialog.setVisible(true);
//#endif 

} 

//#endif 


//#if -1927471512 
public ActionNewToDoItem()
    { 

//#if -421523527 
super(Translator.localize("action.new-todo-item"),
              ResourceLoaderWrapper.lookupIcon("action.new-todo-item"));
//#endif 


//#if -1559808348 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.new-todo-item"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

