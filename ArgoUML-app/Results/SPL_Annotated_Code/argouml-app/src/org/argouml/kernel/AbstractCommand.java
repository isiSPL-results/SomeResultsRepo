// Compilation Unit of /AbstractCommand.java 
 
package org.argouml.kernel;
public abstract class AbstractCommand implements Command
  { 
public abstract void undo();
public boolean isRedoable()
    { 
return true;
} 

public abstract Object execute();
public boolean isUndoable()
    { 
return true;
} 

 } 


