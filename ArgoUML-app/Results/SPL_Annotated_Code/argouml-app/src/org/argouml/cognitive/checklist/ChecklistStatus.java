// Compilation Unit of /ChecklistStatus.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.checklist;
//#endif 


//#if COGNITIVE 
public class ChecklistStatus extends Checklist
  { 
private static int numChecks = 0;
public ChecklistStatus()
    { 
super();
} 

@Override
    public boolean add(CheckItem item)
    { 
super.add(item);
numChecks++;
return true;
} 

 } 

//#endif 


