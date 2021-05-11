
//#if 845079019 
// Compilation Unit of /ToDoListEvent.java 
 

//#if 2076220421 
package org.argouml.cognitive;
//#endif 


//#if -935264088 
import java.util.ArrayList;
//#endif 


//#if 1732215914 
import java.util.Collections;
//#endif 


//#if -62362439 
import java.util.List;
//#endif 


//#if -950046362 
public class ToDoListEvent  { 

//#if -943898375 
private final List<ToDoItem> items;
//#endif 


//#if -1525076595 
public ToDoListEvent(final List<ToDoItem> toDoItems)
    { 

//#if -1335101542 
items =
            Collections.unmodifiableList(new ArrayList<ToDoItem>(toDoItems));
//#endif 

} 

//#endif 


//#if 101972858 
public List<ToDoItem> getToDoItemList()
    { 

//#if -912492500 
return items;
//#endif 

} 

//#endif 


//#if 1144446186 
public ToDoListEvent()
    { 

//#if -2009603741 
items = null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

