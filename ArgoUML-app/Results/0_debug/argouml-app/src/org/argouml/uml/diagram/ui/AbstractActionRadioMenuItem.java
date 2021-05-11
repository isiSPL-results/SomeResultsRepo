
//#if -683444708 
// Compilation Unit of /AbstractActionRadioMenuItem.java 
 

//#if -2147288898 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -2078246573 
import java.awt.event.ActionEvent;
//#endif 


//#if -956230343 
import java.util.Iterator;
//#endif 


//#if 1548585417 
import javax.swing.Action;
//#endif 


//#if -338401855 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1102145150 
import org.argouml.i18n.Translator;
//#endif 


//#if 956055322 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1405895447 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -899260850 
abstract class AbstractActionRadioMenuItem extends 
//#if 2034832742 
UndoableAction
//#endif 

  { 

//#if 766320946 
public AbstractActionRadioMenuItem(String key, boolean hasIcon)
    { 

//#if 696663877 
super(Translator.localize(key),
              hasIcon ? ResourceLoaderWrapper.lookupIcon(key) : null);
//#endif 


//#if 108750253 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(key));
//#endif 

} 

//#endif 


//#if -964297637 
public final void actionPerformed(ActionEvent e)
    { 

//#if 1576092541 
super.actionPerformed(e);
//#endif 


//#if 1966994602 
Iterator i = TargetManager.getInstance().getTargets().iterator();
//#endif 


//#if 1424985553 
while (i.hasNext()) //1
{ 

//#if 47806487 
Object t = i.next();
//#endif 


//#if -1395568352 
toggleValueOfTarget(t);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1830367713 
abstract void toggleValueOfTarget(Object t);
//#endif 


//#if -1530910154 
abstract Object valueOfTarget(Object t);
//#endif 


//#if 1402998187 
public boolean isEnabled()
    { 

//#if 302067525 
boolean result = true;
//#endif 


//#if -1583802322 
Object commonValue = null;
//#endif 


//#if 1270603624 
boolean first = true;
//#endif 


//#if 1896548337 
Iterator i = TargetManager.getInstance().getTargets().iterator();
//#endif 


//#if -1303361785 
while (i.hasNext() && result) //1
{ 

//#if -1738508983 
Object t = i.next();
//#endif 


//#if 494357223 
try //1
{ 

//#if 1097008602 
Object value = valueOfTarget(t);
//#endif 


//#if -310730113 
if(first)//1
{ 

//#if -1298924151 
commonValue = value;
//#endif 


//#if -1223451027 
first = false;
//#endif 

} 

//#endif 


//#if 1492688488 
result &= commonValue.equals(value);
//#endif 

} 

//#if -1128765449 
catch (IllegalArgumentException e) //1
{ 

//#if 1650911483 
result = false;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1564294402 
return result;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

