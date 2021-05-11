
//#if 283437904 
// Compilation Unit of /ToDoItemXMLHelper.java 
 

//#if 1753428909 
package org.argouml.persistence;
//#endif 


//#if 123126938 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 1301279343 
public class ToDoItemXMLHelper  { 

//#if 29172315 
private final ToDoItem item;
//#endif 


//#if -1089893454 
public String getMoreInfoURL()
    { 

//#if -723705160 
return TodoParser.encode(item.getMoreInfoURL());
//#endif 

} 

//#endif 


//#if -188319984 
public String getHeadline()
    { 

//#if 1777004921 
return TodoParser.encode(item.getHeadline());
//#endif 

} 

//#endif 


//#if -404903983 
public ToDoItemXMLHelper(ToDoItem todoItem)
    { 

//#if 880997534 
if(todoItem == null)//1
{ 

//#if 1401176667 
throw new NullPointerException();
//#endif 

} 

//#endif 


//#if -1066498387 
item = todoItem;
//#endif 

} 

//#endif 


//#if -1380340000 
public String getPriority()
    { 

//#if -225242031 
String s = TodoTokenTable.STRING_PRIO_HIGH;
//#endif 


//#if -1277318026 
switch (item.getPriority()) //1
{ 
case ToDoItem.HIGH_PRIORITY://1


//#if 1528041176 
s = TodoTokenTable.STRING_PRIO_HIGH;
//#endif 


//#if -743010131 
break;

//#endif 


case ToDoItem.MED_PRIORITY://1


//#if 774747292 
s = TodoTokenTable.STRING_PRIO_MED;
//#endif 


//#if -224563263 
break;

//#endif 


case ToDoItem.LOW_PRIORITY://1


//#if 2008859458 
s = TodoTokenTable.STRING_PRIO_LOW;
//#endif 


//#if -2146916013 
break;

//#endif 


} 

//#endif 


//#if -654258989 
return TodoParser.encode(s);
//#endif 

} 

//#endif 


//#if -1911708958 
public String getDescription()
    { 

//#if -1584513840 
return TodoParser.encode(item.getDescription());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

