
//#if -1626896958 
// Compilation Unit of /UMLActionSynchCheckBox.java 
 

//#if 875398536 
package org.argouml.uml.ui.behavior.activity_graphs;
//#endif 


//#if -361675824 
import org.argouml.i18n.Translator;
//#endif 


//#if -53709162 
import org.argouml.model.Model;
//#endif 


//#if 1051168735 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -1426282600 
public class UMLActionSynchCheckBox extends 
//#if -2092845447 
UMLCheckBox2
//#endif 

  { 

//#if -588362249 
public void buildModel()
    { 

//#if -2069001600 
if(getTarget() != null)//1
{ 

//#if 1069966516 
setSelected(Model.getFacade().isSynch(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1996496050 
public UMLActionSynchCheckBox()
    { 

//#if 280753864 
super(Translator.localize("checkbox.synch-lc"),
              ActionSetSynch.getInstance(), "isSynch");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

