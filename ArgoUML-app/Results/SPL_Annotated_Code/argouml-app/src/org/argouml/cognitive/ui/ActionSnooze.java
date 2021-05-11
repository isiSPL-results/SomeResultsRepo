// Compilation Unit of /ActionSnooze.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.awt.event.ActionEvent;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Poster;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
public class ActionSnooze extends ToDoItemAction
  { 
public ActionSnooze()
    { 
super("action.snooze-critic", true);
} 

@Override
    public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
if(!(getRememberedTarget() instanceof ToDoItem))//1
{ 
return;
} 

ToDoItem item = (ToDoItem) getRememberedTarget();
Poster p = item.getPoster();
p.snooze();
TabToDo.incrementNumHushes();
} 

 } 

//#endif 


