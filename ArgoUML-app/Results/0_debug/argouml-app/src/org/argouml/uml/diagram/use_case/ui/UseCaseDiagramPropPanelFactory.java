
//#if -1178134331 
// Compilation Unit of /UseCaseDiagramPropPanelFactory.java 
 

//#if 2052763116 
package org.argouml.uml.diagram.use_case.ui;
//#endif 


//#if -457160533 
import org.argouml.uml.ui.PropPanel;
//#endif 


//#if 750235169 
import org.argouml.uml.ui.PropPanelFactory;
//#endif 


//#if 1353412039 
public class UseCaseDiagramPropPanelFactory implements 
//#if 1425170666 
PropPanelFactory
//#endif 

  { 

//#if -863490479 
public PropPanel createPropPanel(Object object)
    { 

//#if 887693100 
if(object instanceof UMLUseCaseDiagram)//1
{ 

//#if -1450629959 
return new PropPanelUMLUseCaseDiagram();
//#endif 

} 

//#endif 


//#if -1697976518 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

