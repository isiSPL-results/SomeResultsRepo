
//#if -1113222914 
// Compilation Unit of /StateDiagramPropPanelFactory.java 
 

//#if -1141882741 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if -2128896001 
import org.argouml.uml.ui.PropPanel;
//#endif 


//#if -1608568755 
import org.argouml.uml.ui.PropPanelFactory;
//#endif 


//#if 1158551329 
public class StateDiagramPropPanelFactory implements 
//#if 893305493 
PropPanelFactory
//#endif 

  { 

//#if 1623634300 
public PropPanel createPropPanel(Object object)
    { 

//#if -1381672711 
if(object instanceof UMLStateDiagram)//1
{ 

//#if -1698740202 
return new PropPanelUMLStateDiagram();
//#endif 

} 

//#endif 


//#if 1095214163 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

