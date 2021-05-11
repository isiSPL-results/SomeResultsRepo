package org.argouml.uml.diagram.ui;
import java.util.List;
import java.util.Vector;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import org.argouml.kernel.UmlModelMutator;
class ActionList<E> extends Vector<E>
  { 
private final boolean readonly;
private boolean isUmlMutator(Object a)
    { 
return a instanceof UmlModelMutator
               || a.getClass().isAnnotationPresent(UmlModelMutator.class);
} 
@Override
    public void insertElementAt(E o, int index)
    { 
if(readonly)//1
{ 
if(isUmlMutator(o))//1
{ 
return;
} 
else
if(o instanceof JMenu)//1
{ 
o = (E) trimMenu((JMenu) o);
} 
} 
if(o != null)//1
{ 
super.insertElementAt(o, index);
} 
} 
@Override
    public void addElement(E o)
    { 
if(readonly)//1
{ 
if(isUmlMutator(o))//1
{ 
return;
} 
else
if(o instanceof JMenu)//1
{ 
o = (E) trimMenu((JMenu) o);
} 
} 
if(o != null)//1
{ 
super.addElement(o);
} 
} 
@Override
    public boolean add(E o)
    { 
if(readonly)//1
{ 
if(isUmlMutator(o))//1
{ 
return false;
} 
else
if(o instanceof JMenu)//1
{ 
o = (E) trimMenu((JMenu) o);
} 
} 
if(o != null)//1
{ 
return super.add(o);
} 
else
{ 
return false;
} 
} 
private JMenu trimMenu(JMenu menu)
    { 
for (int i = menu.getItemCount() - 1; i >= 0; --i) //1
{ 
JMenuItem menuItem = menu.getItem(i);
Action action = menuItem.getAction();
if(action == null
                    && menuItem.getActionListeners().length > 0
                    && menuItem.getActionListeners()[0] instanceof Action)//1
{ 
action = (Action) menuItem.getActionListeners()[0];
} 
if(isUmlMutator(action))//1
{ 
menu.remove(i);
} 
} 
if(menu.getItemCount() == 0)//1
{ 
return null;
} 
return menu;
} 
@Override
    public void add(int index, E o)
    { 
if(readonly)//1
{ 
if(isUmlMutator(o))//1
{ 
return;
} 
else
if(o instanceof JMenu)//1
{ 
o = (E) trimMenu((JMenu) o);
} 
} 
if(o != null)//1
{ 
super.add(index, o);
} 
} 
ActionList(List<? extends E> initialList, boolean readOnly)
    { 
super(initialList);
this.readonly = readOnly;
} 

 } 
