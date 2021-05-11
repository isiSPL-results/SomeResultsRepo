
//#if -734791240 
// Compilation Unit of /AbstractActionCheckBoxMenuItem.java 
 

//#if -750707751 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1756100904 
import java.awt.event.ActionEvent;
//#endif 


//#if -5703746 
import java.util.Iterator;
//#endif 


//#if -1795855282 
import javax.swing.Action;
//#endif 


//#if 294435997 
import org.argouml.i18n.Translator;
//#endif 


//#if -38395233 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1793591954 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1657419431 
abstract class AbstractActionCheckBoxMenuItem extends 
//#if -431898722 
UndoableAction
//#endif 

  { 

//#if 1499788435 
public final void actionPerformed(ActionEvent e)
    { 

//#if 1819382874 
super.actionPerformed(e);
//#endif 


//#if 1275124205 
Iterator i = TargetManager.getInstance().getTargets().iterator();
//#endif 


//#if 1816974638 
while (i.hasNext()) //1
{ 

//#if 613170714 
Object t = i.next();
//#endif 


//#if -242595613 
toggleValueOfTarget(t);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -578454557 
public AbstractActionCheckBoxMenuItem(String key)
    { 

//#if 30114833 
super(Translator.localize(key), null);
//#endif 


//#if -1353638882 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(key));
//#endif 

} 

//#endif 


//#if 1532187107 
public boolean isEnabled()
    { 

//#if 464616290 
boolean result = true;
//#endif 


//#if -1735211391 
boolean commonValue = true;
//#endif 


//#if -386720853 
boolean first = true;
//#endif 


//#if 2104175540 
Iterator i = TargetManager.getInstance().getTargets().iterator();
//#endif 


//#if 586797796 
while (i.hasNext() && result) //1
{ 

//#if 2056010931 
Object t = i.next();
//#endif 


//#if 27132349 
try //1
{ 

//#if -786968625 
boolean value = valueOfTarget(t);
//#endif 


//#if 1342944121 
if(first)//1
{ 

//#if 1223986362 
commonValue = value;
//#endif 


//#if 135767646 
first = false;
//#endif 

} 

//#endif 


//#if 1460862501 
result &= (commonValue == value);
//#endif 

} 

//#if -2085281129 
catch (IllegalArgumentException e) //1
{ 

//#if -2047806286 
result = false;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 422684891 
return result;
//#endif 

} 

//#endif 


//#if -1732599209 
abstract void toggleValueOfTarget(Object t);
//#endif 


//#if 1761905119 
abstract boolean valueOfTarget(Object t);
//#endif 

 } 

//#endif 


//#endif 

