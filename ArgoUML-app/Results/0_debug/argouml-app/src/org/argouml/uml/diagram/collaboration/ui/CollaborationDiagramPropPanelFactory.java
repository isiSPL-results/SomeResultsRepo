
//#if 916353309 
// Compilation Unit of /CollaborationDiagramPropPanelFactory.java 
 

//#if 1660903183 
package org.argouml.uml.diagram.collaboration.ui;
//#endif 


//#if -1065027025 
import org.argouml.uml.ui.PropPanel;
//#endif 


//#if -1936392163 
import org.argouml.uml.ui.PropPanelFactory;
//#endif 


//#if 343167773 
public class CollaborationDiagramPropPanelFactory implements 
//#if -35539620 
PropPanelFactory
//#endif 

  { 

//#if 1703232451 
public PropPanel createPropPanel(Object object)
    { 

//#if 552558720 
if(object instanceof UMLCollaborationDiagram)//1
{ 

//#if 1626897466 
return new PropPanelUMLCollaborationDiagram();
//#endif 

} 

//#endif 


//#if 36058488 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

