package org.argouml.uml.diagram.collaboration.ui;
import org.argouml.uml.ui.PropPanel;
import org.argouml.uml.ui.PropPanelFactory;
public class CollaborationDiagramPropPanelFactory implements PropPanelFactory
  { 
public PropPanel createPropPanel(Object object)
    { 
if(object instanceof UMLCollaborationDiagram)//1
{ 
return new PropPanelUMLCollaborationDiagram();
} 
return null;
} 

 } 
