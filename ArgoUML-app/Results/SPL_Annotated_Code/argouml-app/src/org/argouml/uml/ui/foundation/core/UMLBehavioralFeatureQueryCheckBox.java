// Compilation Unit of /UMLBehavioralFeatureQueryCheckBox.java 
 
package org.argouml.uml.ui.foundation.core;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLCheckBox2;
public class UMLBehavioralFeatureQueryCheckBox extends UMLCheckBox2
  { 
public UMLBehavioralFeatureQueryCheckBox()
    { 
super(Translator.localize("checkbox.query-lc"),
              ActionSetBehavioralFeatureQuery.getInstance(), "isQuery");
} 

public void buildModel()
    { 
if(getTarget() != null)//1
{ 
setSelected(Model.getFacade().isQuery(getTarget()));
} 

} 

 } 


