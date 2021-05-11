
//#if -1276712608 
// Compilation Unit of /PriorityNode.java 
 

//#if 542586627 
package org.argouml.cognitive.ui;
//#endif 


//#if 1306468732 
import java.util.ArrayList;
//#endif 


//#if 1445336933 
import java.util.List;
//#endif 


//#if -1136349255 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1635912552 
import org.argouml.cognitive.Translator;
//#endif 


//#if 1482959074 
public class PriorityNode  { 

//#if -1487921339 
private static final String HIGH =
        Translator.localize("misc.level.high");
//#endif 


//#if -108703451 
private static final String MEDIUM =
        Translator.localize("misc.level.medium");
//#endif 


//#if -1027078879 
private static final String LOW =
        Translator.localize("misc.level.low");
//#endif 


//#if 35819447 
private static List<PriorityNode> priorities = null;
//#endif 


//#if -536744247 
private String name;
//#endif 


//#if 1317657598 
private int priority;
//#endif 


//#if -318433630 
public int getPriority()
    { 

//#if 277423096 
return priority;
//#endif 

} 

//#endif 


//#if -359438501 
public String getName()
    { 

//#if -34007364 
return name;
//#endif 

} 

//#endif 


//#if -820375850 
public PriorityNode(String n, int pri)
    { 

//#if 514073446 
name = n;
//#endif 


//#if -55962860 
priority = pri;
//#endif 

} 

//#endif 


//#if -1683049114 
@Override
    public String toString()
    { 

//#if -1353017217 
return getName();
//#endif 

} 

//#endif 


//#if -1114890373 
public static List<PriorityNode> getPriorityList()
    { 

//#if 110398031 
if(priorities == null)//1
{ 

//#if -1653213655 
priorities = new ArrayList<PriorityNode>();
//#endif 


//#if -1945123715 
priorities.add(new PriorityNode(HIGH,
                                            ToDoItem.HIGH_PRIORITY));
//#endif 


//#if -489532562 
priorities.add(new PriorityNode(MEDIUM,
                                            ToDoItem.MED_PRIORITY));
//#endif 


//#if -1088595897 
priorities.add(new PriorityNode(LOW,
                                            ToDoItem.LOW_PRIORITY));
//#endif 

} 

//#endif 


//#if 1451901820 
return priorities;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

