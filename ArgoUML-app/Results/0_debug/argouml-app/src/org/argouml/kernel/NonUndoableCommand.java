
//#if 195203443 
// Compilation Unit of /NonUndoableCommand.java 
 

//#if 981944934 
package org.argouml.kernel;
//#endif 


//#if -622792190 
public abstract class NonUndoableCommand implements 
//#if 1368282538 
Command
//#endif 

  { 

//#if -1582723481 
public boolean isUndoable()
    { 

//#if 705902889 
return false;
//#endif 

} 

//#endif 


//#if -1442673917 
public void undo()
    { 
} 

//#endif 


//#if -1905961983 
public boolean isRedoable()
    { 

//#if -1669727581 
return false;
//#endif 

} 

//#endif 


//#if -970271989 
public abstract Object execute();
//#endif 

 } 

//#endif 


//#endif 

