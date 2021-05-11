
//#if 1686017090 
// Compilation Unit of /AbstractActionNavigate.java 
 

//#if 1172688702 
package org.argouml.uml.ui;
//#endif 


//#if -1738415922 
import java.awt.event.ActionEvent;
//#endif 


//#if 366976068 
import javax.swing.Action;
//#endif 


//#if -1820165599 
import javax.swing.Icon;
//#endif 


//#if 89729382 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 842670439 
import org.argouml.i18n.Translator;
//#endif 


//#if -36063315 
import org.argouml.model.Model;
//#endif 


//#if 66173192 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -1273711488 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if -986885995 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1258325660 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 2014400866 
public abstract class AbstractActionNavigate extends 
//#if -1701498151 
UndoableAction
//#endif 

 implements 
//#if -867857366 
TargetListener
//#endif 

  { 

//#if 283653982 
public boolean isEnabled()
    { 

//#if 1594544709 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 71051593 
return ((target != null) && (navigateTo(target) != null));
//#endif 

} 

//#endif 


//#if -1970522190 
public void targetAdded(TargetEvent e)
    { 

//#if -78667111 
setEnabled(isEnabled());
//#endif 

} 

//#endif 


//#if 460333416 
public void actionPerformed(ActionEvent e)
    { 

//#if -1758110068 
super.actionPerformed(e);
//#endif 


//#if -1899725361 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 48486052 
if(Model.getFacade().isAUMLElement(target))//1
{ 

//#if 1055659952 
Object elem = target;
//#endif 


//#if 1582481135 
Object nav = navigateTo(elem);
//#endif 


//#if -842699272 
if(nav != null)//1
{ 

//#if -1179830380 
TargetManager.getInstance().setTarget(nav);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1390794798 
public void targetRemoved(TargetEvent e)
    { 

//#if 915135415 
setEnabled(isEnabled());
//#endif 

} 

//#endif 


//#if 1492777336 
public AbstractActionNavigate()
    { 

//#if 1786329823 
this("button.go-up", true);
//#endif 

} 

//#endif 


//#if -1888191235 
protected abstract Object navigateTo(Object source);
//#endif 


//#if 1110847188 
public void targetSet(TargetEvent e)
    { 

//#if -1312481256 
setEnabled(isEnabled());
//#endif 

} 

//#endif 


//#if 1435778991 
public AbstractActionNavigate(String key, boolean hasIcon)
    { 

//#if -1417504251 
super(Translator.localize(key),
              hasIcon ? ResourceLoaderWrapper.lookupIcon(key) : null);
//#endif 


//#if 1428038381 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(key));
//#endif 


//#if -698455196 
putValue(Action.SMALL_ICON,
                 ResourceLoaderWrapper.lookupIconResource("NavigateUp"));
//#endif 

} 

//#endif 


//#if -334212755 
public AbstractActionNavigate setIcon(Icon newIcon)
    { 

//#if -1501458272 
putValue(Action.SMALL_ICON, newIcon);
//#endif 


//#if 476530159 
return this;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

