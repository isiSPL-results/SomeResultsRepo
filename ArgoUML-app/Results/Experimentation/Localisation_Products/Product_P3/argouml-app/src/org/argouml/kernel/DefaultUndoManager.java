package org.argouml.kernel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import org.argouml.i18n.Translator;
class DefaultUndoManager implements UndoManager
  { 
private int undoMax = 0;
private ArrayList<PropertyChangeListener> listeners =
        new ArrayList<PropertyChangeListener>();
private boolean newInteraction = true;
private String newInteractionLabel;
private UndoStack undoStack = new UndoStack();
private RedoStack redoStack = new RedoStack();
private static final UndoManager INSTANCE = new DefaultUndoManager();
private void fire(final String property, final Object value)
    { 
for (PropertyChangeListener listener : listeners) //1
{ 
listener.propertyChange(
                new PropertyChangeEvent(this, property, "", value));
} 
} 
public synchronized void addCommand(Command command)
    { 
ProjectManager.getManager().setSaveEnabled(true);
if(undoMax == 0)//1
{ 
return;
} 
if(!command.isUndoable())//1
{ 
undoStack.clear();
newInteraction = true;
} 
final Interaction macroCommand;
if(newInteraction || undoStack.isEmpty())//1
{ 
redoStack.clear();
newInteraction = false;
if(undoStack.size() > undoMax)//1
{ 
undoStack.remove(0);
} 
macroCommand = new Interaction(newInteractionLabel);
undoStack.push(macroCommand);
} 
else
{ 
macroCommand = undoStack.peek();
} 
macroCommand.addCommand(command);
} 
public void setUndoMax(int max)
    { 
undoMax = max;
} 
public synchronized void undo()
    { 
final Interaction command = undoStack.pop();
command.undo();
if(!command.isRedoable())//1
{ 
redoStack.clear();
} 
redoStack.push(command);
} 
public synchronized void startInteraction(String label)
    { 
this.newInteractionLabel = label;
newInteraction = true;
} 
public synchronized Object execute(Command command)
    { 
addCommand(command);
return command.execute();
} 
@Deprecated
    public static UndoManager getInstance()
    { 
return INSTANCE;
} 
public void removePropertyChangeListener(PropertyChangeListener listener)
    { 
listeners.remove(listener);
} 
private DefaultUndoManager()
    { 
super();
} 
public synchronized void redo()
    { 
final Interaction command = redoStack.pop();
command.execute();
undoStack.push(command);
} 
public void addPropertyChangeListener(PropertyChangeListener listener)
    { 
listeners.add(listener);
} 
class Interaction extends AbstractCommand
  { 
private List<Command> commands = new ArrayList<Command>();
private String label;
public boolean isRedoable()
        { 
final Iterator<Command> it = commands.iterator();
while (it.hasNext()) //1
{ 
final Command command = it.next();
if(!command.isRedoable())//1
{ 
return false;
} 
} 
return true;
} 
public boolean isUndoable()
        { 
final Iterator<Command> it = commands.iterator();
while (it.hasNext()) //1
{ 
final Command command = it.next();
if(!command.isUndoable())//1
{ 
return false;
} 
} 
return true;
} 
private String getUndoLabel()
        { 
if(isUndoable())//1
{ 
return "Undo " + label;
} 
else
{ 
return "Can't Undo " + label;
} 
} 
public void undo()
        { 
final ListIterator<Command> it =
                commands.listIterator(commands.size());
while (it.hasPrevious()) //1
{ 
it.previous().undo();
} 
} 
private void addCommand(Command command)
        { 
commands.add(command);
} 
Interaction(String lbl)
        { 
label = lbl;
} 
List<Command> getCommands()
        { 
return new ArrayList<Command> (commands);
} 
private String getRedoLabel()
        { 
if(isRedoable())//1
{ 
return "Redo " + label;
} 
else
{ 
return "Can't Redo " + label;
} 
} 
public Object execute()
        { 
final Iterator<Command> it = commands.iterator();
while (it.hasNext()) //1
{ 
it.next().execute();
} 
return null;
} 

 } 
private abstract class InteractionStack extends Stack<Interaction>
  { 
private String labelProperty;
private String addedProperty;
private String removedProperty;
private String sizeProperty;
public Interaction pop()
        { 
Interaction item = super.pop();
fireLabel();
fire(removedProperty, item);
fire(sizeProperty, size());
return item;
} 
public Interaction push(Interaction item)
        { 
super.push(item);
fireLabel();
fire(addedProperty, item);
fire(sizeProperty, size());
return item;
} 
private void fireLabel()
        { 
fire(labelProperty, getLabel());
} 
protected abstract String getLabel();public InteractionStack(
            String labelProp,
            String addedProp,
            String removedProp,
            String sizeProp)
        { 
labelProperty = labelProp;
addedProperty = addedProp;
removedProperty = removedProp;
sizeProperty = sizeProp;
} 

 } 
private class RedoStack extends InteractionStack
  { 
public Interaction push(Interaction item)
        { 
super.push(item);
if(item.isRedoable())//1
{ 
fire("redoable", true);
} 
return item;
} 
protected String getLabel()
        { 
if(empty())//1
{ 
return Translator.localize("action.redo");
} 
else
{ 
return peek().getRedoLabel();
} 
} 
public Interaction pop()
        { 
Interaction item = super.pop();
if(size() == 0 || !peek().isRedoable())//1
{ 
fire("redoable", false);
} 
return item;
} 
public RedoStack()
        { 
super(
                "redoLabel",
                "redoAdded",
                "redoRemoved",
                "redoSize");
} 
public void clear()
        { 
super.clear();
fire("redoSize", size());
fire("redoable", false);
} 

 } 
private class UndoStack extends InteractionStack
  { 
public UndoStack()
        { 
super(
                "undoLabel",
                "undoAdded",
                "undoRemoved",
                "undoSize");
} 
public Interaction pop()
        { 
Interaction item = super.pop();
if(size() == 0 || !peek().isUndoable())//1
{ 
fire("undoable", false);
} 
return item;
} 
public void clear()
        { 
super.clear();
fire("undoSize", size());
fire("undoable", false);
} 
protected String getLabel()
        { 
if(empty())//1
{ 
return Translator.localize("action.undo");
} 
else
{ 
return peek().getUndoLabel();
} 
} 
public Interaction push(Interaction item)
        { 
super.push(item);
if(item.isUndoable())//1
{ 
fire("undoable", true);
} 
return item;
} 

 } 

 } 
