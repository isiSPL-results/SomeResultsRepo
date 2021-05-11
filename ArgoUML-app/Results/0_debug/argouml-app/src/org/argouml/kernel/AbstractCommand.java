
//#if -573834176 
// Compilation Unit of /AbstractCommand.java 
 

//#if 1108824150 
package org.argouml.kernel;
//#endif 


//#if 1114545815 
public abstract class AbstractCommand implements 
//#if 1689317858 
Command
//#endif 

  { 

//#if 126052717 
public abstract void undo();
//#endif 


//#if -1377938887 
public boolean isRedoable()
    { 

//#if 21197088 
return true;
//#endif 

} 

//#endif 


//#if 1745483075 
public abstract Object execute();
//#endif 


//#if -1054700385 
public boolean isUndoable()
    { 

//#if -1961862997 
return true;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

