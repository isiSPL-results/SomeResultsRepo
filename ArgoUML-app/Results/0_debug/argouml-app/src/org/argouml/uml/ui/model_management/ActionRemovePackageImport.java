
//#if 507076025 
// Compilation Unit of /ActionRemovePackageImport.java 
 

//#if 676156293 
package org.argouml.uml.ui.model_management;
//#endif 


//#if 931954722 
import java.awt.event.ActionEvent;
//#endif 


//#if 2019781779 
import org.argouml.i18n.Translator;
//#endif 


//#if 1818196185 
import org.argouml.model.Model;
//#endif 


//#if -1935566279 
import org.argouml.uml.ui.AbstractActionRemoveElement;
//#endif 


//#if 1351996857 
class ActionRemovePackageImport extends 
//#if 752863390 
AbstractActionRemoveElement
//#endif 

  { 

//#if 1003079920 
ActionRemovePackageImport()
    { 

//#if -1100971478 
super(Translator.localize("menu.popup.remove"));
//#endif 

} 

//#endif 


//#if 2084715627 
public void actionPerformed(ActionEvent e)
    { 

//#if 440978152 
super.actionPerformed(e);
//#endif 


//#if -2079880439 
Model.getModelManagementHelper()
        .removeImportedElement(getTarget(), getObjectToRemove());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

