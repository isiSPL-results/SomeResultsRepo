// Compilation Unit of /AbstractCrTooMany.java 
 

//#if COGNITIVE 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
public abstract class AbstractCrTooMany extends CrUML
  { 
private int criticThreshold;
public void setThreshold(int threshold)
    { 
criticThreshold = threshold;
} 

public int getThreshold()
    { 
return criticThreshold;
} 

public Class getWizardClass(ToDoItem item)
    { 
return WizTooMany.class;
} 

 } 

//#endif 


