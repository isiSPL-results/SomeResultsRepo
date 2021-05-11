package org.argouml.cognitive;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
