
//#if 473606708 
// Compilation Unit of /SequenceDiagramPropPanelFactory.java 
 

//#if -1278356321 
package org.argouml.uml.diagram.sequence.ui;
//#endif 


//#if -1718038267 
import org.argouml.uml.ui.PropPanel;
//#endif 


//#if -102765433 
import org.argouml.uml.ui.PropPanelFactory;
//#endif 


//#if -955054785 
public class SequenceDiagramPropPanelFactory implements 
//#if 377310234 
PropPanelFactory
//#endif 

  { 

//#if 1355772289 
public PropPanel createPropPanel(Object object)
    { 

//#if -1654701442 
if(object instanceof UMLSequenceDiagram)//1
{ 

//#if -1404453694 
return new PropPanelUMLSequenceDiagram();
//#endif 

} 

//#endif 


//#if -596187258 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

