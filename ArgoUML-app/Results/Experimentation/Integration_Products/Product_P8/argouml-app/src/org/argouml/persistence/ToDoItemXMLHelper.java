package org.argouml.persistence;
import org.argouml.cognitive.ToDoItem;
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

s = TodoTokenTable.STRING_PRIO_HIGH;
break;


case ToDoItem.MED_PRIORITY://1

s = TodoTokenTable.STRING_PRIO_MED;
break;


case ToDoItem.LOW_PRIORITY://1

s = TodoTokenTable.STRING_PRIO_LOW;
break;


} 
return TodoParser.encode(s);
} 
public String getDescription()
    { 
return TodoParser.encode(item.getDescription());
} 

 } 
