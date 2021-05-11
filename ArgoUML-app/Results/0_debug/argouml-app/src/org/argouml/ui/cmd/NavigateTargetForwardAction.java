
//#if 1508725250 
// Compilation Unit of /NavigateTargetForwardAction.java 
 

//#if 1138108279 
package org.argouml.ui.cmd;
//#endif 


//#if -530817149 
import java.awt.event.ActionEvent;
//#endif 


//#if 1519569271 
import javax.swing.AbstractAction;
//#endif 


//#if 925540345 
import javax.swing.Action;
//#endif 


//#if -1232461423 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -376473262 
import org.argouml.i18n.Translator;
//#endif 


//#if 2089141578 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1078378240 
class NavigateTargetForwardAction extends 
//#if -1308398542 
AbstractAction
//#endif 

  { 

//#if -800642136 
private static final long serialVersionUID = -3426889296160732468L;
//#endif 


//#if -1965225581 
public boolean isEnabled()
    { 

//#if -413425389 
return TargetManager.getInstance().navigateForwardPossible();
//#endif 

} 

//#endif 


//#if 1445985939 
public void actionPerformed(ActionEvent e)
    { 

//#if -566885797 
TargetManager.getInstance().navigateForward();
//#endif 

} 

//#endif 


//#if -263742441 
public NavigateTargetForwardAction()
    { 

//#if -1983574522 
super(Translator.localize("action.navigate-forward"),
              ResourceLoaderWrapper.lookupIcon("action.navigate-forward"));
//#endif 


//#if 215091659 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.navigate-forward"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

