
//#if -637175102 
// Compilation Unit of /DefaultUndoManager.java 
 

//#if -875395444 
package org.argouml.kernel;
//#endif 


//#if 613729895 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1297762623 
import java.beans.PropertyChangeListener;
//#endif 


//#if 1426134778 
import java.util.ArrayList;
//#endif 


//#if -1356277673 
import java.util.Iterator;
//#endif 


//#if -1931203801 
import java.util.List;
//#endif 


//#if 1386718297 
import java.util.ListIterator;
//#endif 


//#if 472236073 
import java.util.Stack;
//#endif 


//#if -1546815452 
import org.argouml.i18n.Translator;
//#endif 


//#if -1588016777 
import org.apache.log4j.Logger;
//#endif 


//#if -296410929 
class DefaultUndoManager implements 
//#if -1490460006 
UndoManager
//#endif 

  { 

//#if 1961468995 
private int undoMax = 0;
//#endif 


//#if 509384816 
private ArrayList<PropertyChangeListener> listeners =
        new ArrayList<PropertyChangeListener>();
//#endif 


//#if 1101864502 
private boolean newInteraction = true;
//#endif 


//#if 1985303038 
private String newInteractionLabel;
//#endif 


//#if 126588653 
private UndoStack undoStack = new UndoStack();
//#endif 


//#if 668502215 
private RedoStack redoStack = new RedoStack();
//#endif 


//#if -1150384251 
private static final UndoManager INSTANCE = new DefaultUndoManager();
//#endif 


//#if 1593388615 
private static final Logger LOG =
        Logger.getLogger(DefaultUndoManager.class);
//#endif 


//#if -1764312461 
private void fire(final String property, final Object value)
    { 

//#if 1025070031 
for (PropertyChangeListener listener : listeners) //1
{ 

//#if 1089099903 
listener.propertyChange(
                new PropertyChangeEvent(this, property, "", value));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1055850635 
public synchronized void addCommand(Command command)
    { 

//#if -26389931 
ProjectManager.getManager().setSaveEnabled(true);
//#endif 


//#if 1238156558 
if(undoMax == 0)//1
{ 

//#if 1436134315 
return;
//#endif 

} 

//#endif 


//#if 2124801631 
if(!command.isUndoable())//1
{ 

//#if -1373252176 
undoStack.clear();
//#endif 


//#if 2140756987 
newInteraction = true;
//#endif 

} 

//#endif 


//#if 1615939051 
final Interaction macroCommand;
//#endif 


//#if 1520594426 
if(newInteraction || undoStack.isEmpty())//1
{ 

//#if -295709137 
redoStack.clear();
//#endif 


//#if -1024064859 
newInteraction = false;
//#endif 


//#if -1636280509 
if(undoStack.size() > undoMax)//1
{ 

//#if -77829541 
undoStack.remove(0);
//#endif 

} 

//#endif 


//#if 1856368542 
macroCommand = new Interaction(newInteractionLabel);
//#endif 


//#if 470203767 
undoStack.push(macroCommand);
//#endif 

} 
else
{ 

//#if 891240841 
macroCommand = undoStack.peek();
//#endif 

} 

//#endif 


//#if 1957744025 
macroCommand.addCommand(command);
//#endif 

} 

//#endif 


//#if -1264526986 
public void setUndoMax(int max)
    { 

//#if -1141034282 
undoMax = max;
//#endif 

} 

//#endif 


//#if -1125781307 
public synchronized void undo()
    { 

//#if -932948909 
final Interaction command = undoStack.pop();
//#endif 


//#if -600530591 
command.undo();
//#endif 


//#if -1910522122 
if(!command.isRedoable())//1
{ 

//#if 1201377608 
redoStack.clear();
//#endif 

} 

//#endif 


//#if 2029626149 
redoStack.push(command);
//#endif 

} 

//#endif 


//#if -683970274 
public synchronized void startInteraction(String label)
    { 

//#if -2045810847 
LOG.debug("Starting interaction " + label);
//#endif 


//#if -2137615003 
this.newInteractionLabel = label;
//#endif 


//#if 1591584047 
newInteraction = true;
//#endif 

} 

//#endif 


//#if -447090773 
public synchronized Object execute(Command command)
    { 

//#if 561478453 
addCommand(command);
//#endif 


//#if -1406836178 
return command.execute();
//#endif 

} 

//#endif 


//#if 1165395614 
@Deprecated
    public static UndoManager getInstance()
    { 

//#if -1172183577 
return INSTANCE;
//#endif 

} 

//#endif 


//#if 296770877 
public void removePropertyChangeListener(PropertyChangeListener listener)
    { 

//#if 185984645 
listeners.remove(listener);
//#endif 

} 

//#endif 


//#if 2118409437 
private DefaultUndoManager()
    { 

//#if -1128619916 
super();
//#endif 

} 

//#endif 


//#if -1219980449 
public synchronized void redo()
    { 

//#if -1365151858 
final Interaction command = redoStack.pop();
//#endif 


//#if 1297628763 
command.execute();
//#endif 


//#if 109479468 
undoStack.push(command);
//#endif 

} 

//#endif 


//#if -9710718 
public void addPropertyChangeListener(PropertyChangeListener listener)
    { 

//#if -1791942256 
listeners.add(listener);
//#endif 

} 

//#endif 


//#if 1534848905 
class Interaction extends 
//#if -1027571646 
AbstractCommand
//#endif 

  { 

//#if 2105192418 
private List<Command> commands = new ArrayList<Command>();
//#endif 


//#if 1920914260 
private String label;
//#endif 


//#if 272029595 
public boolean isRedoable()
        { 

//#if -414101241 
final Iterator<Command> it = commands.iterator();
//#endif 


//#if -659061648 
while (it.hasNext()) //1
{ 

//#if -1452708667 
final Command command = it.next();
//#endif 


//#if 1376270654 
if(!command.isRedoable())//1
{ 

//#if -1941650594 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1282674455 
return true;
//#endif 

} 

//#endif 


//#if 595268097 
public boolean isUndoable()
        { 

//#if -950099000 
final Iterator<Command> it = commands.iterator();
//#endif 


//#if -1138886961 
while (it.hasNext()) //1
{ 

//#if -1208232757 
final Command command = it.next();
//#endif 


//#if 70615594 
if(!command.isUndoable())//1
{ 

//#if -316933881 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 297624088 
return true;
//#endif 

} 

//#endif 


//#if -1057412408 
private String getUndoLabel()
        { 

//#if 840686416 
if(isUndoable())//1
{ 

//#if 2070451089 
return "Undo " + label;
//#endif 

} 
else
{ 

//#if -1601563263 
return "Can't Undo " + label;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1972129239 
public void undo()
        { 

//#if 938552120 
final ListIterator<Command> it =
                commands.listIterator(commands.size());
//#endif 


//#if -527681657 
while (it.hasPrevious()) //1
{ 

//#if -1698030435 
it.previous().undo();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -948029861 
private void addCommand(Command command)
        { 

//#if 557381318 
commands.add(command);
//#endif 

} 

//#endif 


//#if 1453208609 
Interaction(String lbl)
        { 

//#if 880578685 
label = lbl;
//#endif 

} 

//#endif 


//#if 883586101 
List<Command> getCommands()
        { 

//#if 357453445 
return new ArrayList<Command> (commands);
//#endif 

} 

//#endif 


//#if 1807095918 
private String getRedoLabel()
        { 

//#if -2076570023 
if(isRedoable())//1
{ 

//#if -539842914 
return "Redo " + label;
//#endif 

} 
else
{ 

//#if 1229314939 
return "Can't Redo " + label;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1490403847 
public Object execute()
        { 

//#if -1805772191 
final Iterator<Command> it = commands.iterator();
//#endif 


//#if -628639658 
while (it.hasNext()) //1
{ 

//#if 916938370 
it.next().execute();
//#endif 

} 

//#endif 


//#if 799669784 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 800801848 
private abstract class InteractionStack extends 
//#if 1751657659 
Stack<Interaction>
//#endif 

  { 

//#if 2005338091 
private String labelProperty;
//#endif 


//#if -73387169 
private String addedProperty;
//#endif 


//#if 2018135487 
private String removedProperty;
//#endif 


//#if -871546004 
private String sizeProperty;
//#endif 


//#if -1697809756 
public Interaction pop()
        { 

//#if -685216044 
Interaction item = super.pop();
//#endif 


//#if -1298348804 
fireLabel();
//#endif 


//#if 1179054382 
fire(removedProperty, item);
//#endif 


//#if 1364875448 
fire(sizeProperty, size());
//#endif 


//#if -684025960 
return item;
//#endif 

} 

//#endif 


//#if -651960156 
public Interaction push(Interaction item)
        { 

//#if 122382432 
super.push(item);
//#endif 


//#if 1919423292 
fireLabel();
//#endif 


//#if 2007081678 
fire(addedProperty, item);
//#endif 


//#if 1663022840 
fire(sizeProperty, size());
//#endif 


//#if -441679528 
return item;
//#endif 

} 

//#endif 


//#if -246464573 
private void fireLabel()
        { 

//#if -121127263 
fire(labelProperty, getLabel());
//#endif 

} 

//#endif 


//#if 851147461 
protected abstract String getLabel();
//#endif 


//#if -328976948 
public InteractionStack(
            String labelProp,
            String addedProp,
            String removedProp,
            String sizeProp)
        { 

//#if -1433354015 
labelProperty = labelProp;
//#endif 


//#if -2066599735 
addedProperty = addedProp;
//#endif 


//#if -634760311 
removedProperty = removedProp;
//#endif 


//#if 227563673 
sizeProperty = sizeProp;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1687198758 
private class RedoStack extends 
//#if 968310948 
InteractionStack
//#endif 

  { 

//#if -1120761033 
public Interaction push(Interaction item)
        { 

//#if -405416667 
super.push(item);
//#endif 


//#if -1199562122 
if(item.isRedoable())//1
{ 

//#if -451551225 
fire("redoable", true);
//#endif 

} 

//#endif 


//#if 1722099165 
return item;
//#endif 

} 

//#endif 


//#if 1040733232 
protected String getLabel()
        { 

//#if -917893424 
if(empty())//1
{ 

//#if 1889267675 
return Translator.localize("action.redo");
//#endif 

} 
else
{ 

//#if 1770273981 
return peek().getRedoLabel();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1682855113 
public Interaction pop()
        { 

//#if 435275323 
Interaction item = super.pop();
//#endif 


//#if -100026778 
if(size() == 0 || !peek().isRedoable())//1
{ 

//#if 1672672156 
fire("redoable", false);
//#endif 

} 

//#endif 


//#if -1920612015 
return item;
//#endif 

} 

//#endif 


//#if -2069687212 
public RedoStack()
        { 

//#if -1804360541 
super(
                "redoLabel",
                "redoAdded",
                "redoRemoved",
                "redoSize");
//#endif 

} 

//#endif 


//#if -1354211645 
public void clear()
        { 

//#if -1924907577 
super.clear();
//#endif 


//#if -1125757996 
fire("redoSize", size());
//#endif 


//#if -1367564772 
fire("redoable", false);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -934773504 
private class UndoStack extends 
//#if -952638519 
InteractionStack
//#endif 

  { 

//#if -59119575 
public UndoStack()
        { 

//#if -169910719 
super(
                "undoLabel",
                "undoAdded",
                "undoRemoved",
                "undoSize");
//#endif 

} 

//#endif 


//#if 1177722524 
public Interaction pop()
        { 

//#if 1138628428 
Interaction item = super.pop();
//#endif 


//#if -186040931 
if(size() == 0 || !peek().isUndoable())//1
{ 

//#if -1198015822 
fire("undoable", false);
//#endif 

} 

//#endif 


//#if 690229280 
return item;
//#endif 

} 

//#endif 


//#if -774102978 
public void clear()
        { 

//#if -1517596343 
super.clear();
//#endif 


//#if 562223420 
fire("undoSize", size());
//#endif 


//#if 1457832884 
fire("undoable", false);
//#endif 

} 

//#endif 


//#if -231970133 
protected String getLabel()
        { 

//#if -434032159 
if(empty())//1
{ 

//#if -49214370 
return Translator.localize("action.undo");
//#endif 

} 
else
{ 

//#if 2101645166 
return peek().getUndoLabel();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2020742300 
public Interaction push(Interaction item)
        { 

//#if 27013974 
super.push(item);
//#endif 


//#if -859688309 
if(item.isUndoable())//1
{ 

//#if -1363571390 
fire("undoable", true);
//#endif 

} 

//#endif 


//#if -212452146 
return item;
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

