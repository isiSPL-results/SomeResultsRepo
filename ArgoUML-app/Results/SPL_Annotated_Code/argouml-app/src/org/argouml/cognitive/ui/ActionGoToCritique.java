// Compilation Unit of /ActionGoToCritique.java 
 

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
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.i18n.Translator;
//#endif 


//#if COGNITIVE 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if COGNITIVE 
import org.argouml.ui.UndoableAction;
//#endif 


//#if COGNITIVE 
public class ActionGoToCritique extends UndoableAction
  { 
private ToDoItem item = null;
public ActionGoToCritique(ToDoItem theItem)
    { 
super(Translator.localize(theItem.getHeadline()),
              null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(theItem.getHeadline()));
item = theItem;
} 

public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
((ToDoPane) ProjectBrowser.getInstance().getTodoPane())
        .selectItem(item);
} 

 } 

//#endif 


