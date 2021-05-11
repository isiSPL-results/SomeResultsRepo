
//#if -1831653285 
// Compilation Unit of /ActionList.java 
 

//#if 1733421916 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 555175339 
import java.util.List;
//#endif 


//#if 1103418918 
import java.util.Vector;
//#endif 


//#if 1837862251 
import javax.swing.Action;
//#endif 


//#if -950737140 
import javax.swing.JMenu;
//#endif 


//#if -1238495815 
import javax.swing.JMenuItem;
//#endif 


//#if -1229916336 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if 2095001942 
class ActionList<E> extends 
//#if 1089407634 
Vector<E>
//#endif 

  { 

//#if -1960038940 
private final boolean readonly;
//#endif 


//#if -660961518 
private boolean isUmlMutator(Object a)
    { 

//#if -919155950 
return a instanceof UmlModelMutator
               || a.getClass().isAnnotationPresent(UmlModelMutator.class);
//#endif 

} 

//#endif 


//#if 704280671 
@Override
    public void insertElementAt(E o, int index)
    { 

//#if 1533688222 
if(readonly)//1
{ 

//#if -917490170 
if(isUmlMutator(o))//1
{ 

//#if 1840043063 
return;
//#endif 

} 
else

//#if 208163184 
if(o instanceof JMenu)//1
{ 

//#if 1988942707 
o = (E) trimMenu((JMenu) o);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1917464538 
if(o != null)//1
{ 

//#if -475886069 
super.insertElementAt(o, index);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1488290555 
@Override
    public void addElement(E o)
    { 

//#if 514915641 
if(readonly)//1
{ 

//#if 193793145 
if(isUmlMutator(o))//1
{ 

//#if 1333176036 
return;
//#endif 

} 
else

//#if -672686859 
if(o instanceof JMenu)//1
{ 

//#if 1094170125 
o = (E) trimMenu((JMenu) o);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1257591509 
if(o != null)//1
{ 

//#if -1801222763 
super.addElement(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 649223237 
@Override
    public boolean add(E o)
    { 

//#if -348875692 
if(readonly)//1
{ 

//#if -382427801 
if(isUmlMutator(o))//1
{ 

//#if 389237324 
return false;
//#endif 

} 
else

//#if -781849279 
if(o instanceof JMenu)//1
{ 

//#if 1090907618 
o = (E) trimMenu((JMenu) o);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 377112240 
if(o != null)//1
{ 

//#if -1244395015 
return super.add(o);
//#endif 

} 
else
{ 

//#if -1963549669 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1045987458 
private JMenu trimMenu(JMenu menu)
    { 

//#if 840498416 
for (int i = menu.getItemCount() - 1; i >= 0; --i) //1
{ 

//#if -724471500 
JMenuItem menuItem = menu.getItem(i);
//#endif 


//#if 2140010385 
Action action = menuItem.getAction();
//#endif 


//#if -1027311512 
if(action == null
                    && menuItem.getActionListeners().length > 0
                    && menuItem.getActionListeners()[0] instanceof Action)//1
{ 

//#if 79363447 
action = (Action) menuItem.getActionListeners()[0];
//#endif 

} 

//#endif 


//#if -177537506 
if(isUmlMutator(action))//1
{ 

//#if -424337061 
menu.remove(i);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1058198374 
if(menu.getItemCount() == 0)//1
{ 

//#if 919744012 
return null;
//#endif 

} 

//#endif 


//#if 1915463705 
return menu;
//#endif 

} 

//#endif 


//#if 1022802566 
@Override
    public void add(int index, E o)
    { 

//#if -518664790 
if(readonly)//1
{ 

//#if -1848913061 
if(isUmlMutator(o))//1
{ 

//#if 233019890 
return;
//#endif 

} 
else

//#if -477766663 
if(o instanceof JMenu)//1
{ 

//#if 12957203 
o = (E) trimMenu((JMenu) o);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -2122216806 
if(o != null)//1
{ 

//#if 1233455481 
super.add(index, o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1547045126 
ActionList(List<? extends E> initialList, boolean readOnly)
    { 

//#if -1472632408 
super(initialList);
//#endif 


//#if 157761775 
this.readonly = readOnly;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

