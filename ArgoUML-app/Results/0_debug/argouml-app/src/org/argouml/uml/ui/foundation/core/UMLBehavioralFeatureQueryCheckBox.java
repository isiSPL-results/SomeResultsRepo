
//#if 234127744 
// Compilation Unit of /UMLBehavioralFeatureQueryCheckBox.java 
 

//#if 1593721010 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 261517671 
import org.argouml.i18n.Translator;
//#endif 


//#if 366872493 
import org.argouml.model.Model;
//#endif 


//#if -876733962 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -76705109 
public class UMLBehavioralFeatureQueryCheckBox extends 
//#if 2122170981 
UMLCheckBox2
//#endif 

  { 

//#if 1758515604 
public UMLBehavioralFeatureQueryCheckBox()
    { 

//#if -919883571 
super(Translator.localize("checkbox.query-lc"),
              ActionSetBehavioralFeatureQuery.getInstance(), "isQuery");
//#endif 

} 

//#endif 


//#if 330130147 
public void buildModel()
    { 

//#if 859810738 
if(getTarget() != null)//1
{ 

//#if 236488451 
setSelected(Model.getFacade().isQuery(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

