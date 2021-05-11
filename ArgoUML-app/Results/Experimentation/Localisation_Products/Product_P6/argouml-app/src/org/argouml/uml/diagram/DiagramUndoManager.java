package org.argouml.uml.diagram;
import java.beans.PropertyChangeListener;
import org.apache.log4j.Logger;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.tigris.gef.undo.Memento;
import org.tigris.gef.undo.UndoManager;
public class DiagramUndoManager extends UndoManager
  { 
private static final Logger LOG = Logger.getLogger(UndoManager.class);
private boolean startChain;
@Override
    public boolean isGenerateMementos()
    { 
Project p = ProjectManager.getManager().getCurrentProject();
return super.isGenerateMementos() && p != null
               && p.getUndoManager() != null;
} 
public void addPropertyChangeListener(PropertyChangeListener listener)
    { 
LOG.info("Adding property listener " + listener);
super.addPropertyChangeListener(listener);
} 
@Override
    public void startChain()
    { 
startChain = true;
} 
@Override
    public void addMemento(final Memento memento)
    { 
Project p = ProjectManager.getManager().getCurrentProject();
if(p != null)//1
{ 
org.argouml.kernel.UndoManager undo = p.getUndoManager();
if(undo != null)//1
{ 
if(startChain)//1
{ 
undo.startInteraction("Diagram Interaction");
} 
undo.addCommand(new DiagramCommand(memento));
startChain = false;
} 
} 
} 
private class DiagramCommand extends org.argouml.kernel.AbstractCommand
  { 
private final Memento memento;
DiagramCommand(final Memento theMemento)
        { 
this.memento = theMemento;
} 
@Override
        public Object execute()
        { 
memento.redo();
return null;
} 
@Override
        public String toString()
        { 
return memento.toString();
} 
@Override
        public void undo()
        { 
memento.undo();
} 

 } 

 } 
