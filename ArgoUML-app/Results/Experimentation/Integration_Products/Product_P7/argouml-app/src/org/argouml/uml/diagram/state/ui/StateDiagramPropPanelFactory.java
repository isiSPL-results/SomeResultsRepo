package org.argouml.uml.diagram.state.ui;
import org.argouml.uml.ui.PropPanel;
import org.argouml.uml.ui.PropPanelFactory;
public class StateDiagramPropPanelFactory implements PropPanelFactory
  { 
public PropPanel createPropPanel(Object object)
    { 
if(object instanceof UMLStateDiagram)//1
{ 
return new PropPanelUMLStateDiagram();
} 
return null;
} 

 } 
