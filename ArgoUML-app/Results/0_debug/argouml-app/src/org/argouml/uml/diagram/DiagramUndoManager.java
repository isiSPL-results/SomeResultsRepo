
//#if -2129478498 
// Compilation Unit of /DiagramUndoManager.java 
 

//#if -542098444 
package org.argouml.uml.diagram;
//#endif 


//#if -1323046335 
import java.beans.PropertyChangeListener;
//#endif 


//#if -1160160009 
import org.apache.log4j.Logger;
//#endif 


//#if 548265568 
import org.argouml.kernel.Project;
//#endif 


//#if -2040846199 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -8667838 
import org.tigris.gef.undo.Memento;
//#endif 


//#if -1843663534 
import org.tigris.gef.undo.UndoManager;
//#endif 


//#if 970765236 
public class DiagramUndoManager extends 
//#if 1416666360 
UndoManager
//#endif 

  { 

//#if -352851132 
private static final Logger LOG = Logger.getLogger(UndoManager.class);
//#endif 


//#if -1020913946 
private boolean startChain;
//#endif 


//#if 1892962462 
@Override
    public boolean isGenerateMementos()
    { 

//#if 2146782626 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1208536076 
return super.isGenerateMementos() && p != null
               && p.getUndoManager() != null;
//#endif 

} 

//#endif 


//#if -2112332832 
public void addPropertyChangeListener(PropertyChangeListener listener)
    { 

//#if -2073327310 
LOG.info("Adding property listener " + listener);
//#endif 


//#if -878221650 
super.addPropertyChangeListener(listener);
//#endif 

} 

//#endif 


//#if 502398296 
@Override
    public void startChain()
    { 

//#if 6412444 
startChain = true;
//#endif 

} 

//#endif 


//#if 2074622251 
@Override
    public void addMemento(final Memento memento)
    { 

//#if 1515430849 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -876148203 
if(p != null)//1
{ 

//#if 534895883 
org.argouml.kernel.UndoManager undo = p.getUndoManager();
//#endif 


//#if 496978164 
if(undo != null)//1
{ 

//#if 806568442 
if(startChain)//1
{ 

//#if -1600854907 
undo.startInteraction("Diagram Interaction");
//#endif 

} 

//#endif 


//#if 1657650846 
undo.addCommand(new DiagramCommand(memento));
//#endif 


//#if -288219490 
startChain = false;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 172239198 
private class DiagramCommand extends 
//#if -1302758919 
org.argouml.kernel.AbstractCommand
//#endif 

  { 

//#if 1468647876 
private final Memento memento;
//#endif 


//#if -2118501486 
DiagramCommand(final Memento theMemento)
        { 

//#if -829485996 
this.memento = theMemento;
//#endif 

} 

//#endif 


//#if 14503238 
@Override
        public Object execute()
        { 

//#if -1900925624 
memento.redo();
//#endif 


//#if -1791735227 
return null;
//#endif 

} 

//#endif 


//#if -903433553 
@Override
        public String toString()
        { 

//#if 575684730 
return memento.toString();
//#endif 

} 

//#endif 


//#if 1554242442 
@Override
        public void undo()
        { 

//#if -296248075 
memento.undo();
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

