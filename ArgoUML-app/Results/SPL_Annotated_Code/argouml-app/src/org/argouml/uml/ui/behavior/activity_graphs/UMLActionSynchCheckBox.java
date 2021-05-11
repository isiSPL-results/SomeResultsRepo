// Compilation Unit of /UMLActionSynchCheckBox.java 
 
package org.argouml.uml.ui.behavior.activity_graphs;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLCheckBox2;
public class UMLActionSynchCheckBox extends UMLCheckBox2
  { 
public void buildModel()
    { 
if(getTarget() != null)//1
{ 
setSelected(Model.getFacade().isSynch(getTarget()));
} 

} 

public UMLActionSynchCheckBox()
    { 
super(Translator.localize("checkbox.synch-lc"),
              ActionSetSynch.getInstance(), "isSynch");
} 

 } 


