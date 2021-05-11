
//#if 1362790254 
// Compilation Unit of /ActionSetPath.java 
 

//#if -181671312 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1310296417 
import java.awt.event.ActionEvent;
//#endif 


//#if -617137654 
import java.util.ArrayList;
//#endif 


//#if -611799913 
import java.util.Collection;
//#endif 


//#if 656020295 
import java.util.Iterator;
//#endif 


//#if -385327593 
import java.util.List;
//#endif 


//#if -1134131241 
import javax.swing.Action;
//#endif 


//#if 863472436 
import org.argouml.i18n.Translator;
//#endif 


//#if 2026246138 
import org.argouml.model.Model;
//#endif 


//#if -1339072464 
import org.argouml.ui.UndoableAction;
//#endif 


//#if -762375977 
import org.argouml.uml.diagram.PathContainer;
//#endif 


//#if 513034667 
import org.tigris.gef.base.Editor;
//#endif 


//#if 874651502 
import org.tigris.gef.base.Globals;
//#endif 


//#if -2070929966 
import org.tigris.gef.base.Selection;
//#endif 


//#if -655773711 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 488136602 
class ActionSetPath extends 
//#if 1718744908 
UndoableAction
//#endif 

  { 

//#if 609218533 
private static final UndoableAction SHOW_PATH =
        new ActionSetPath(false);
//#endif 


//#if -1843644725 
private static final UndoableAction HIDE_PATH =
        new ActionSetPath(true);
//#endif 


//#if -209836747 
private boolean isPathVisible;
//#endif 


//#if 649029841 
public ActionSetPath(boolean isVisible)
    { 

//#if 2041596108 
super();
//#endif 


//#if -161363654 
isPathVisible = isVisible;
//#endif 


//#if -597893230 
String name;
//#endif 


//#if 857254514 
if(isVisible)//1
{ 

//#if 471778879 
name = Translator.localize("menu.popup.hide.path");
//#endif 

} 
else
{ 

//#if -13766602 
name = Translator.localize("menu.popup.show.path");
//#endif 

} 

//#endif 


//#if 2142837503 
putValue(Action.NAME, name);
//#endif 

} 

//#endif 


//#if -1555705981 
public static Collection<UndoableAction> getActions()
    { 

//#if -447907565 
Collection<UndoableAction> actions = new ArrayList<UndoableAction>();
//#endif 


//#if -1315547805 
Editor ce = Globals.curEditor();
//#endif 


//#if 1865773291 
List<Fig> figs = ce.getSelectionManager().getFigs();
//#endif 


//#if -284472390 
for (Fig f : figs) //1
{ 

//#if 1620391534 
if(f instanceof PathContainer)//1
{ 

//#if 1163099168 
Object owner = f.getOwner();
//#endif 


//#if 1602653117 
if(Model.getFacade().isAModelElement(owner))//1
{ 

//#if 1039815201 
Object ns = Model.getFacade().getNamespace(owner);
//#endif 


//#if 1767508959 
if(ns != null)//1
{ 

//#if 743948929 
if(((PathContainer) f).isPathVisible())//1
{ 

//#if -2067036925 
actions.add(HIDE_PATH);
//#endif 


//#if -1669339147 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -746419017 
for (Fig f : figs) //2
{ 

//#if 648840139 
if(f instanceof PathContainer)//1
{ 

//#if 1368508136 
Object owner = f.getOwner();
//#endif 


//#if -699330427 
if(Model.getFacade().isAModelElement(owner))//1
{ 

//#if -1678594809 
Object ns = Model.getFacade().getNamespace(owner);
//#endif 


//#if -1714979131 
if(ns != null)//1
{ 

//#if -1247861152 
if(!((PathContainer) f).isPathVisible())//1
{ 

//#if 845145584 
actions.add(SHOW_PATH);
//#endif 


//#if 1804836845 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1944790812 
return actions;
//#endif 

} 

//#endif 


//#if 1018003417 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if -659077155 
super.actionPerformed(e);
//#endif 


//#if 1541543762 
Iterator< ? > i =
            Globals.curEditor().getSelectionManager().selections().iterator();
//#endif 


//#if -517553615 
while (i.hasNext()) //1
{ 

//#if 1195522107 
Selection sel = (Selection) i.next();
//#endif 


//#if 198142457 
Fig f = sel.getContent();
//#endif 


//#if 1534395980 
if(f instanceof PathContainer)//1
{ 

//#if 422029746 
((PathContainer) f).setPathVisible(!isPathVisible);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

