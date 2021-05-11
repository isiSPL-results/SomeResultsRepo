// Compilation Unit of /FigLink.java 
 
package org.argouml.uml.diagram.static_structure.ui;
import org.argouml.model.Model;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
import org.argouml.uml.diagram.ui.FigTextGroup;
import org.argouml.uml.diagram.ui.PathItemPlacement;
import org.tigris.gef.presentation.Fig;
public class FigLink extends FigEdgeModelElement
  { 
private FigTextGroup middleGroup;
@SuppressWarnings("deprecation")

    @Deprecated
    public FigLink()
    { 
middleGroup = new FigTextGroup();
initialize();
} 

protected Object getDestination()
    { 
if(getOwner() != null)//1
{ 
return Model.getCommonBehaviorHelper().getDestination(getOwner());
} 

return null;
} 

private void initialize()
    { 
middleGroup.addFig(getNameFig());
addPathItem(middleGroup,
                    new PathItemPlacement(this, middleGroup, 50, 25));
getNameFig().setUnderline(true);
getFig().setLineColor(LINE_COLOR);
setBetweenNearestPoints(true);
} 

protected Object getSource()
    { 
if(getOwner() != null)//1
{ 
return Model.getCommonBehaviorHelper().getSource(getOwner());
} 

return null;
} 

protected void updateNameText()
    { 
if(getOwner() == null)//1
{ 
return;
} 

String nameString = "";
Object association = Model.getFacade().getAssociation(getOwner());
if(association != null)//1
{ 
nameString = Model.getFacade().getName(association);
if(nameString == null)//1
{ 
nameString = "";
} 

} 

getNameFig().setText(nameString);
calcBounds();
setBounds(getBounds());
} 

@Deprecated
    public FigLink(Object edge)
    { 
this();
setOwner(edge);
} 

protected boolean canEdit(Fig f)
    { 
return false;
} 

protected void updateListeners(Object oldOwner, Object newOwner)
    { 
if(oldOwner != null)//1
{ 
removeElementListener(oldOwner);
Object oldAssociation = Model.getFacade().getAssociation(oldOwner);
if(oldAssociation != null)//1
{ 
removeElementListener(oldAssociation);
} 

} 

if(newOwner != null)//1
{ 
addElementListener(newOwner,
                               new String[] {"remove", "name", "association"});
Object newAssociation = Model.getFacade().getAssociation(newOwner);
if(newAssociation != null)//1
{ 
addElementListener(newAssociation, "name");
} 

} 

} 

public FigLink(Object element, DiagramSettings settings)
    { 
super(element, settings);
middleGroup = new FigTextGroup(element, settings);
initialize();
} 

 } 


