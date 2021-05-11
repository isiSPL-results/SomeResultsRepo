// Compilation Unit of /ToDoListEvent.java 
 

//#if COGNITIVE 
package org.argouml.cognitive;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.Collections;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if COGNITIVE 
public class ToDoListEvent  { 
private final List<ToDoItem> items;
public ToDoListEvent(final List<ToDoItem> toDoItems)
    { 
items =
            Collections.unmodifiableList(new ArrayList<ToDoItem>(toDoItems));
} 

public List<ToDoItem> getToDoItemList()
    { 
return items;
} 

public ToDoListEvent()
    { 
items = null;
} 

 } 

//#endif 


