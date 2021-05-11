// Compilation Unit of /FigMessage.java 
 
package org.argouml.uml.diagram.sequence.ui;
import java.awt.Point;
import org.argouml.model.Model;
import org.argouml.uml.diagram.sequence.MessageNode;
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
import org.argouml.uml.diagram.ui.FigTextGroup;
import org.argouml.uml.diagram.ui.PathItemPlacement;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Selection;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.Handle;
public abstract class FigMessage extends FigEdgeModelElement
  { 
private FigTextGroup textGroup;
public FigMessage(Object owner)
    { 
super();
textGroup = new FigTextGroup();
textGroup.addFig(getNameFig());
textGroup.addFig(getStereotypeFig());
addPathItem(textGroup, new PathItemPlacement(this, textGroup, 50, 10));
setOwner(owner);
} 

@Override
    protected Object getSource()
    { 
Object owner = getOwner();
if(owner == null)//1
{ 
return null;
} 

return Model.getFacade().getSender(owner);
} 

public Object getMessage()
    { 
return getOwner();
} 

public Fig getDestPortFig()
    { 
Fig result = super.getDestPortFig();
if(result instanceof FigClassifierRole.TempFig
                && getOwner() != null)//1
{ 
result =
                getDestFigClassifierRole().createFigMessagePort(
                    getOwner(), (FigClassifierRole.TempFig) result);
setDestPortFig(result);
} 

return result;
} 

public FigClassifierRole getSourceFigClassifierRole()
    { 
return (FigClassifierRole) getSourceFigNode();
} 

public MessageNode getSourceMessageNode()
    { 
return ((FigMessagePort) getSourcePortFig()).getNode();
} 

@Override
    protected boolean determineFigNodes()
    { 
return true;
} 

public void computeRouteImpl()
    { 
Fig sourceFig = getSourcePortFig();
Fig destFig = getDestPortFig();
if(sourceFig instanceof FigMessagePort
                && destFig instanceof FigMessagePort)//1
{ 
FigMessagePort srcMP = (FigMessagePort) sourceFig;
FigMessagePort destMP = (FigMessagePort) destFig;
Point startPoint = sourceFig.connectionPoint(destMP.getCenter());
Point endPoint = destFig.connectionPoint(srcMP.getCenter());
if(isSelfMessage())//1
{ 
if(startPoint.x < sourceFig.getCenter().x)//1
{ 
startPoint.x += sourceFig.getWidth();
} 

endPoint.x = startPoint.x;
setEndPoints(startPoint, endPoint);
if(getNumPoints() <= 2)//1
{ 
insertPoint(0, startPoint.x
                                + SequenceDiagramLayer.OBJECT_DISTANCE / 3,
                                (startPoint.y + endPoint.y) / 2);
} 
else
{ 
int middleX =
                        startPoint.x
                        + SequenceDiagramLayer.OBJECT_DISTANCE / 3;
int middleY = (startPoint.y + endPoint.y) / 2;
Point p = getPoint(1);
if(p.x != middleX || p.y != middleY)//1
{ 
setPoint(new Handle(1), middleX, middleY);
} 

} 

} 
else
{ 
setEndPoints(startPoint, endPoint);
} 

calcBounds();
layoutEdge();
} 

} 

public Object getAction()
    { 
Object owner = getOwner();
if(owner != null && Model.getFacade().isAMessage(owner))//1
{ 
return Model.getFacade().getAction(owner);
} 

return null;
} 

public FigMessage()
    { 
this(null);
} 

@Override
    public Selection makeSelection()
    { 
return new SelectionMessage(this);
} 

private boolean isSelfMessage()
    { 
FigMessagePort srcMP = (FigMessagePort) getSourcePortFig();
FigMessagePort destMP = (FigMessagePort) getDestPortFig();
return (srcMP.getNode().getFigClassifierRole()
                == destMP.getNode().getFigClassifierRole());
} 

public FigClassifierRole getDestFigClassifierRole()
    { 
return (FigClassifierRole) getDestFigNode();
} 

public Fig getSourcePortFig()
    { 
Fig result = super.getSourcePortFig();
if(result instanceof FigClassifierRole.TempFig
                && getOwner() != null)//1
{ 
result =
                getSourceFigClassifierRole().createFigMessagePort(
                    getOwner(), (FigClassifierRole.TempFig) result);
setSourcePortFig(result);
} 

return result;
} 

@Override
    protected void updateNameText()
    { 
super.updateNameText();
textGroup.calcBounds();
} 

@Override
    protected void updateStereotypeText()
    { 
super.updateStereotypeText();
textGroup.calcBounds();
} 

public MessageNode getDestMessageNode()
    { 
return ((FigMessagePort) getDestPortFig()).getNode();
} 

protected void layoutEdge()
    { 
if(getSourcePortFig() instanceof FigMessagePort
                && getDestPortFig() instanceof FigMessagePort
                && ((FigMessagePort) getSourcePortFig()).getNode() != null
                && ((FigMessagePort) getDestPortFig()).getNode() != null)//1
{ 
((SequenceDiagramLayer) getLayer()).updateActivations();
Editor editor = Globals.curEditor();
if(editor != null)//1
{ 
Globals.curEditor().damageAll();
} 

} 

} 

@Override
    protected Object getDestination()
    { 
Object owner = getOwner();
if(owner == null)//1
{ 
return null;
} 

return Model.getFacade().getReceiver(owner);
} 

 } 


