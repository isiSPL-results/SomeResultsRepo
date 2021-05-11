// Compilation Unit of /PriorityNode.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Translator;
//#endif 


//#if COGNITIVE 
public class PriorityNode  { 
private static final String HIGH =
        Translator.localize("misc.level.high");
private static final String MEDIUM =
        Translator.localize("misc.level.medium");
private static final String LOW =
        Translator.localize("misc.level.low");
private static List<PriorityNode> priorities = null;
private String name;
private int priority;
public int getPriority()
    { 
return priority;
} 

public String getName()
    { 
return name;
} 

public PriorityNode(String n, int pri)
    { 
name = n;
priority = pri;
} 

@Override
    public String toString()
    { 
return getName();
} 

public static List<PriorityNode> getPriorityList()
    { 
if(priorities == null)//1
{ 
priorities = new ArrayList<PriorityNode>();
priorities.add(new PriorityNode(HIGH,
                                            ToDoItem.HIGH_PRIORITY));
priorities.add(new PriorityNode(MEDIUM,
                                            ToDoItem.MED_PRIORITY));
priorities.add(new PriorityNode(LOW,
                                            ToDoItem.LOW_PRIORITY));
} 

return priorities;
} 

 } 

//#endif 


