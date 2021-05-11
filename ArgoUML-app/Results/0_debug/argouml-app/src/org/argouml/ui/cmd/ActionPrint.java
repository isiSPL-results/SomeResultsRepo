
//#if -1373276356 
// Compilation Unit of /ActionPrint.java 
 

//#if 1657414918 
package org.argouml.ui.cmd;
//#endif 


//#if 707384084 
import java.awt.event.ActionEvent;
//#endif 


//#if -1537196792 
import javax.swing.AbstractAction;
//#endif 


//#if -1274465142 
import javax.swing.Action;
//#endif 


//#if 22149984 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -646940703 
import org.argouml.i18n.Translator;
//#endif 


//#if -1854489802 
public class ActionPrint extends 
//#if -1947787408 
AbstractAction
//#endif 

  { 

//#if -131097065 
public ActionPrint()
    { 

//#if -1691967599 
super(Translator.localize("action.print"),
              ResourceLoaderWrapper.lookupIcon("action.print"));
//#endif 


//#if 1430254892 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.print"));
//#endif 

} 

//#endif 


//#if 1951124980 
public void actionPerformed(ActionEvent ae)
    { 

//#if 32847450 
PrintManager.getInstance().print();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

