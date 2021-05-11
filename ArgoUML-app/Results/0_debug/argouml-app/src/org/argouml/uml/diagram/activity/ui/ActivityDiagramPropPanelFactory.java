
//#if -1227593973 
// Compilation Unit of /ActivityDiagramPropPanelFactory.java 
 

//#if 602670471 
package org.argouml.uml.diagram.activity.ui;
//#endif 


//#if 423696287 
import org.argouml.uml.ui.PropPanel;
//#endif 


//#if 485614765 
import org.argouml.uml.ui.PropPanelFactory;
//#endif 


//#if -553080233 
public class ActivityDiagramPropPanelFactory implements 
//#if 2082168121 
PropPanelFactory
//#endif 

  { 

//#if -1941524960 
public PropPanel createPropPanel(Object object)
    { 

//#if 1132595124 
if(object instanceof UMLActivityDiagram)//1
{ 

//#if -1109546616 
return new PropPanelUMLActivityDiagram();
//#endif 

} 

//#endif 


//#if -865635382 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

