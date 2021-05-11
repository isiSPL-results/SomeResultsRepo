
//#if 683369558 
// Compilation Unit of /ActionPageSetup.java 
 

//#if 1516869003 
package org.argouml.ui.cmd;
//#endif 


//#if -1387744529 
import java.awt.event.ActionEvent;
//#endif 


//#if 662641891 
import javax.swing.AbstractAction;
//#endif 


//#if -1817113947 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1171418266 
import org.argouml.i18n.Translator;
//#endif 


//#if 510405651 
class ActionPageSetup extends 
//#if -719500827 
AbstractAction
//#endif 

  { 

//#if -2066866135 
public void actionPerformed(ActionEvent ae)
    { 

//#if -78009489 
PrintManager.getInstance().showPageSetupDialog();
//#endif 

} 

//#endif 


//#if -192133885 
public ActionPageSetup()
    { 

//#if -621904645 
super(Translator.localize("action.page-setup"),
              ResourceLoaderWrapper.lookupIcon("action.page-setup"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

