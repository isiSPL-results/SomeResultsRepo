
//#if -92361654 
// Compilation Unit of /UndoManager.java 
 

//#if -1498770776 
package org.argouml.kernel;
//#endif 


//#if -797416995 
import java.beans.PropertyChangeListener;
//#endif 


//#if -2078793530 
public interface UndoManager  { 

//#if 32777090 
public abstract void addPropertyChangeListener(
        PropertyChangeListener listener);
//#endif 


//#if 280918193 
public abstract void undo();
//#endif 


//#if -964293315 
public abstract void removePropertyChangeListener(
        PropertyChangeListener listener);
//#endif 


//#if 1787988342 
public abstract void setUndoMax(int max);
//#endif 


//#if 2101369463 
public abstract void addCommand(Command command);
//#endif 


//#if 1941940287 
public abstract Object execute(Command command);
//#endif 


//#if -735395918 
public abstract void startInteraction(String label);
//#endif 


//#if 186719051 
public abstract void redo();
//#endif 

 } 

//#endif 


//#endif 

