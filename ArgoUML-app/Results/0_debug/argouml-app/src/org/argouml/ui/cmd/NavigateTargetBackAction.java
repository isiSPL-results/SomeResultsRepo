
//#if -1947926529 
// Compilation Unit of /NavigateTargetBackAction.java 
 

//#if -2000420305 
package org.argouml.ui.cmd;
//#endif 


//#if 282953163 
import java.awt.event.ActionEvent;
//#endif 


//#if -1961627713 
import javax.swing.AbstractAction;
//#endif 


//#if -1808101823 
import javax.swing.Action;
//#endif 


//#if -11841975 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -919397366 
import org.argouml.i18n.Translator;
//#endif 


//#if 1908497298 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -723144512 
class NavigateTargetBackAction extends 
//#if -1607242936 
AbstractAction
//#endif 

  { 

//#if 290787481 
private static final long serialVersionUID = 33340548502483040L;
//#endif 


//#if -1286905159 
public NavigateTargetBackAction()
    { 

//#if -1879201906 
super(Translator.localize("action.navigate-back"),
              ResourceLoaderWrapper.lookupIcon("action.navigate-back"));
//#endif 


//#if -1273389083 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.navigate-back"));
//#endif 

} 

//#endif 


//#if 1677829417 
public boolean isEnabled()
    { 

//#if -795179031 
return TargetManager.getInstance().navigateBackPossible();
//#endif 

} 

//#endif 


//#if 224003133 
public void actionPerformed(ActionEvent e)
    { 

//#if 656055019 
TargetManager.getInstance().navigateBackward();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

