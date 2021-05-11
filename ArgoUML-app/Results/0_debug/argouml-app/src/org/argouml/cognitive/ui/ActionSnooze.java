
//#if -482584586 
// Compilation Unit of /ActionSnooze.java 
 

//#if 948059571 
package org.argouml.cognitive.ui;
//#endif 


//#if 1082887423 
import java.awt.event.ActionEvent;
//#endif 


//#if 1796081301 
import org.argouml.cognitive.Poster;
//#endif 


//#if 1885493001 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 321104424 
public class ActionSnooze extends 
//#if -323316062 
ToDoItemAction
//#endif 

  { 

//#if 1267764377 
public ActionSnooze()
    { 

//#if -240965275 
super("action.snooze-critic", true);
//#endif 

} 

//#endif 


//#if -2012129643 
@Override
    public void actionPerformed(ActionEvent ae)
    { 

//#if 1884360095 
super.actionPerformed(ae);
//#endif 


//#if 1000150322 
if(!(getRememberedTarget() instanceof ToDoItem))//1
{ 

//#if -1514680028 
return;
//#endif 

} 

//#endif 


//#if -2044003640 
ToDoItem item = (ToDoItem) getRememberedTarget();
//#endif 


//#if -739981568 
Poster p = item.getPoster();
//#endif 


//#if -127599042 
p.snooze();
//#endif 


//#if -568537720 
TabToDo.incrementNumHushes();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

