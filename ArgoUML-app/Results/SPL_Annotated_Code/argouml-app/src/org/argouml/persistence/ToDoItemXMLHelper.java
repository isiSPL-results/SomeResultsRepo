// Compilation Unit of /ToDoItemXMLHelper.java 
 

//#if COGNITIVE 
package org.argouml.persistence;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
public class ToDoItemXMLHelper  { 
private final ToDoItem item;
public String getMoreInfoURL()
    { 
return TodoParser.encode(item.getMoreInfoURL());
} 

public String getHeadline()
    { 
return TodoParser.encode(item.getHeadline());
} 

public ToDoItemXMLHelper(ToDoItem todoItem)
    { 
if(todoItem == null)//1
{ 
throw new NullPointerException();
} 

item = todoItem;
} 

public String getPriority()
    { 
String s = TodoTokenTable.STRING_PRIO_HIGH;
switch (item.getPriority()) //1
{ 
case ToDoItem.HIGH_PRIORITY://1


//#if COGNITIVE 
s = TodoTokenTable.STRING_PRIO_HIGH;
//#endif 


//#if COGNITIVE 
break;

//#endif 


case ToDoItem.MED_PRIORITY://1


//#if COGNITIVE 
s = TodoTokenTable.STRING_PRIO_MED;
//#endif 


//#if COGNITIVE 
break;

//#endif 


case ToDoItem.LOW_PRIORITY://1


//#if COGNITIVE 
s = TodoTokenTable.STRING_PRIO_LOW;
//#endif 


//#if COGNITIVE 
break;

//#endif 


} 

return TodoParser.encode(s);
} 

public String getDescription()
    { 
return TodoParser.encode(item.getDescription());
} 

 } 

//#endif 


