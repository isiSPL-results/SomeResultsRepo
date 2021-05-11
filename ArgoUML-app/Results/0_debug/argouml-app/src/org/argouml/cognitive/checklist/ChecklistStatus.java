
//#if -150622775 
// Compilation Unit of /ChecklistStatus.java 
 

//#if 1065982926 
package org.argouml.cognitive.checklist;
//#endif 


//#if -464108633 
public class ChecklistStatus extends 
//#if 640846948 
Checklist
//#endif 

  { 

//#if -149563945 
private static int numChecks = 0;
//#endif 


//#if -2099602642 
public ChecklistStatus()
    { 

//#if 2146413123 
super();
//#endif 

} 

//#endif 


//#if 848549687 
@Override
    public boolean add(CheckItem item)
    { 

//#if 1685896483 
super.add(item);
//#endif 


//#if -841475442 
numChecks++;
//#endif 


//#if -2038165543 
return true;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

