// Compilation Unit of /NonUndoableCommand.java 
 
package org.argouml.kernel;
public abstract class NonUndoableCommand implements Command
  { 
public boolean isUndoable()
    { 
return false;
} 

public void undo()
    { 
} 

public boolean isRedoable()
    { 
return false;
} 

public abstract Object execute();
 } 


