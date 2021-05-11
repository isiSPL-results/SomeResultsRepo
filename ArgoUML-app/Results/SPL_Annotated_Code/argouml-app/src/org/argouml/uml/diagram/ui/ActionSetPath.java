// Compilation Unit of /ActionSetPath.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.Action;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.UndoableAction;
import org.argouml.uml.diagram.PathContainer;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Selection;
import org.tigris.gef.presentation.Fig;
class ActionSetPath extends UndoableAction
  { 
private static final UndoableAction SHOW_PATH =
        new ActionSetPath(false);
private static final UndoableAction HIDE_PATH =
        new ActionSetPath(true);
private boolean isPathVisible;
public ActionSetPath(boolean isVisible)
    { 
super();
isPathVisible = isVisible;
String name;
if(isVisible)//1
{ 
name = Translator.localize("menu.popup.hide.path");
} 
else
{ 
name = Translator.localize("menu.popup.show.path");
} 

putValue(Action.NAME, name);
} 

public static Collection<UndoableAction> getActions()
    { 
Collection<UndoableAction> actions = new ArrayList<UndoableAction>();
Editor ce = Globals.curEditor();
List<Fig> figs = ce.getSelectionManager().getFigs();
for (Fig f : figs) //1
{ 
if(f instanceof PathContainer)//1
{ 
Object owner = f.getOwner();
if(Model.getFacade().isAModelElement(owner))//1
{ 
Object ns = Model.getFacade().getNamespace(owner);
if(ns != null)//1
{ 
if(((PathContainer) f).isPathVisible())//1
{ 
actions.add(HIDE_PATH);
break;

} 

} 

} 

} 

} 

for (Fig f : figs) //2
{ 
if(f instanceof PathContainer)//1
{ 
Object owner = f.getOwner();
if(Model.getFacade().isAModelElement(owner))//1
{ 
Object ns = Model.getFacade().getNamespace(owner);
if(ns != null)//1
{ 
if(!((PathContainer) f).isPathVisible())//1
{ 
actions.add(SHOW_PATH);
break;

} 

} 

} 

} 

} 

return actions;
} 

@Override
    public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Iterator< ? > i =
            Globals.curEditor().getSelectionManager().selections().iterator();
while (i.hasNext()) //1
{ 
Selection sel = (Selection) i.next();
Fig f = sel.getContent();
if(f instanceof PathContainer)//1
{ 
((PathContainer) f).setPathVisible(!isPathVisible);
} 

} 

} 

 } 


