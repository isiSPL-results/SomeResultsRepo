// Compilation Unit of /Command.java 
 
package org.argouml.kernel;
public interface Command  { 
abstract boolean isUndoable();
abstract void undo();
public abstract Object execute();
abstract boolean isRedoable();
 } 


