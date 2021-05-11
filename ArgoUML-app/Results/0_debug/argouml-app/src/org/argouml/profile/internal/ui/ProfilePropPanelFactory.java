
//#if 1191598955 
// Compilation Unit of /ProfilePropPanelFactory.java 
 

//#if -1955405951 
package org.argouml.profile.internal.ui;
//#endif 


//#if -1462553102 
import org.argouml.uml.cognitive.critics.CrUML;
//#endif 


//#if -2098253861 
import org.argouml.uml.ui.PropPanel;
//#endif 


//#if -2004922127 
import org.argouml.uml.ui.PropPanelFactory;
//#endif 


//#if -1671164544 
public class ProfilePropPanelFactory implements 
//#if 145154651 
PropPanelFactory
//#endif 

  { 

//#if 681905218 
public PropPanel createPropPanel(Object object)
    { 

//#if 1025400038 
if(object instanceof CrUML)//1
{ 

//#if 1908736774 
return new PropPanelCritic();
//#endif 

} 
else
{ 

//#if -1131728262 
return null;
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

