
//#if -1135781917 
// Compilation Unit of /ClassDiagramPropPanelFactory.java 
 

//#if 1948397333 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -1208347174 
import org.argouml.uml.ui.PropPanel;
//#endif 


//#if 1520729618 
import org.argouml.uml.ui.PropPanelFactory;
//#endif 


//#if -972771659 
public class ClassDiagramPropPanelFactory implements 
//#if 1730646073 
PropPanelFactory
//#endif 

  { 

//#if -1747427040 
public PropPanel createPropPanel(Object object)
    { 

//#if -851982299 
if(object instanceof UMLClassDiagram)//1
{ 

//#if 169703620 
return new PropPanelUMLClassDiagram();
//#endif 

} 

//#endif 


//#if 753307072 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

