// Compilation Unit of /ProfilePropPanelFactory.java 
 

//#if COGNITIVE 
package org.argouml.profile.internal.ui;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrUML;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.ui.PropPanel;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.ui.PropPanelFactory;
//#endif 


//#if COGNITIVE 
public class ProfilePropPanelFactory implements PropPanelFactory
  { 
public PropPanel createPropPanel(Object object)
    { 
if(object instanceof CrUML)//1
{ 
return new PropPanelCritic();
} 
else
{ 
return null;
} 

} 

 } 

//#endif 


