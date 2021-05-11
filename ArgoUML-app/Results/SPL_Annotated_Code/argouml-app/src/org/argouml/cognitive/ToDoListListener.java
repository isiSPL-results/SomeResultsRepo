// Compilation Unit of /ToDoListListener.java 
 

//#if COGNITIVE 
package org.argouml.cognitive;
//#endif 


//#if COGNITIVE 
public interface ToDoListListener extends java.util.EventListener
  { 
void toDoListChanged(ToDoListEvent tde);
void toDoItemsChanged(ToDoListEvent tde);
void toDoItemsRemoved(ToDoListEvent tde);
void toDoItemsAdded(ToDoListEvent tde);
 } 

//#endif 


