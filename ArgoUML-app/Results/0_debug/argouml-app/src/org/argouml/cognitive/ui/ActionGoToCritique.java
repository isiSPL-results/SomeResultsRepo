
//#if 988683293 
// Compilation Unit of /ActionGoToCritique.java 
 

//#if -587186460 
package org.argouml.cognitive.ui;
//#endif 


//#if 734900718 
import java.awt.event.ActionEvent;
//#endif 


//#if -230781596 
import javax.swing.Action;
//#endif 


//#if -216372104 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 206074951 
import org.argouml.i18n.Translator;
//#endif 


//#if 1655844392 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if -1737863037 
import org.argouml.ui.UndoableAction;
//#endif 


//#if 1331213414 
public class ActionGoToCritique extends 
//#if 1380826615 
UndoableAction
//#endif 

  { 

//#if -1480729373 
private ToDoItem item = null;
//#endif 


//#if -1391711377 
public ActionGoToCritique(ToDoItem theItem)
    { 

//#if 889219426 
super(Translator.localize(theItem.getHeadline()),
              null);
//#endif 


//#if 1589714605 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(theItem.getHeadline()));
//#endif 


//#if 1645812350 
item = theItem;
//#endif 

} 

//#endif 


//#if 266651039 
public void actionPerformed(ActionEvent ae)
    { 

//#if 777528461 
super.actionPerformed(ae);
//#endif 


//#if 252073440 
((ToDoPane) ProjectBrowser.getInstance().getTodoPane())
        .selectItem(item);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

