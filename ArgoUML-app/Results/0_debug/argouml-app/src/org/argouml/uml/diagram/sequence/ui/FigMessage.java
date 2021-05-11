
//#if -927561578 
// Compilation Unit of /FigMessage.java 
 

//#if -1198344165 
package org.argouml.uml.diagram.sequence.ui;
//#endif 


//#if -525024053 
import java.awt.Point;
//#endif 


//#if -1393381392 
import org.argouml.model.Model;
//#endif 


//#if 1715617745 
import org.argouml.uml.diagram.sequence.MessageNode;
//#endif 


//#if 311417683 
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
//#endif 


//#if 457627425 
import org.argouml.uml.diagram.ui.FigTextGroup;
//#endif 


//#if 1189602970 
import org.argouml.uml.diagram.ui.PathItemPlacement;
//#endif 


//#if -1281417739 
import org.tigris.gef.base.Editor;
//#endif 


//#if 1081201764 
import org.tigris.gef.base.Globals;
//#endif 


//#if -1144623800 
import org.tigris.gef.base.Selection;
//#endif 


//#if 466221543 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 835519459 
import org.tigris.gef.presentation.Handle;
//#endif 


//#if -341633255 
public abstract class FigMessage extends 
//#if -1081638475 
FigEdgeModelElement
//#endif 

  { 

//#if 1414469947 
private FigTextGroup textGroup;
//#endif 


//#if 1348740978 
public FigMessage(Object owner)
    { 

//#if -1126484811 
super();
//#endif 


//#if 1738361165 
textGroup = new FigTextGroup();
//#endif 


//#if -1656023351 
textGroup.addFig(getNameFig());
//#endif 


//#if -421113214 
textGroup.addFig(getStereotypeFig());
//#endif 


//#if -1353455369 
addPathItem(textGroup, new PathItemPlacement(this, textGroup, 50, 10));
//#endif 


//#if -863750876 
setOwner(owner);
//#endif 

} 

//#endif 


//#if 1363377170 
@Override
    protected Object getSource()
    { 

//#if 536385923 
Object owner = getOwner();
//#endif 


//#if -1502721336 
if(owner == null)//1
{ 

//#if -1812568236 
return null;
//#endif 

} 

//#endif 


//#if 1192101605 
return Model.getFacade().getSender(owner);
//#endif 

} 

//#endif 


//#if -1026544519 
public Object getMessage()
    { 

//#if -1923077962 
return getOwner();
//#endif 

} 

//#endif 


//#if 1745452456 
public Fig getDestPortFig()
    { 

//#if -327353058 
Fig result = super.getDestPortFig();
//#endif 


//#if 764585876 
if(result instanceof FigClassifierRole.TempFig
                && getOwner() != null)//1
{ 

//#if -2111724094 
result =
                getDestFigClassifierRole().createFigMessagePort(
                    getOwner(), (FigClassifierRole.TempFig) result);
//#endif 


//#if -1757478393 
setDestPortFig(result);
//#endif 

} 

//#endif 


//#if -1943959220 
return result;
//#endif 

} 

//#endif 


//#if -1134427266 
public FigClassifierRole getSourceFigClassifierRole()
    { 

//#if 1284726575 
return (FigClassifierRole) getSourceFigNode();
//#endif 

} 

//#endif 


//#if 1163660186 
public MessageNode getSourceMessageNode()
    { 

//#if -1024551380 
return ((FigMessagePort) getSourcePortFig()).getNode();
//#endif 

} 

//#endif 


//#if -1219887046 
@Override
    protected boolean determineFigNodes()
    { 

//#if 1248538368 
return true;
//#endif 

} 

//#endif 


//#if -1709179473 
public void computeRouteImpl()
    { 

//#if 758436062 
Fig sourceFig = getSourcePortFig();
//#endif 


//#if -498836482 
Fig destFig = getDestPortFig();
//#endif 


//#if 1748598558 
if(sourceFig instanceof FigMessagePort
                && destFig instanceof FigMessagePort)//1
{ 

//#if 1457039662 
FigMessagePort srcMP = (FigMessagePort) sourceFig;
//#endif 


//#if 1382831173 
FigMessagePort destMP = (FigMessagePort) destFig;
//#endif 


//#if -1720143948 
Point startPoint = sourceFig.connectionPoint(destMP.getCenter());
//#endif 


//#if -770808744 
Point endPoint = destFig.connectionPoint(srcMP.getCenter());
//#endif 


//#if -1817546060 
if(isSelfMessage())//1
{ 

//#if 1465369142 
if(startPoint.x < sourceFig.getCenter().x)//1
{ 

//#if -1522351775 
startPoint.x += sourceFig.getWidth();
//#endif 

} 

//#endif 


//#if -1854066705 
endPoint.x = startPoint.x;
//#endif 


//#if -357937949 
setEndPoints(startPoint, endPoint);
//#endif 


//#if -1162747228 
if(getNumPoints() <= 2)//1
{ 

//#if 1548868790 
insertPoint(0, startPoint.x
                                + SequenceDiagramLayer.OBJECT_DISTANCE / 3,
                                (startPoint.y + endPoint.y) / 2);
//#endif 

} 
else
{ 

//#if 2040673417 
int middleX =
                        startPoint.x
                        + SequenceDiagramLayer.OBJECT_DISTANCE / 3;
//#endif 


//#if -1367616637 
int middleY = (startPoint.y + endPoint.y) / 2;
//#endif 


//#if 1907378388 
Point p = getPoint(1);
//#endif 


//#if 465261423 
if(p.x != middleX || p.y != middleY)//1
{ 

//#if 1177357386 
setPoint(new Handle(1), middleX, middleY);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if 1618299273 
setEndPoints(startPoint, endPoint);
//#endif 

} 

//#endif 


//#if 1084486059 
calcBounds();
//#endif 


//#if 993911278 
layoutEdge();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -534456730 
public Object getAction()
    { 

//#if -754336357 
Object owner = getOwner();
//#endif 


//#if -63225200 
if(owner != null && Model.getFacade().isAMessage(owner))//1
{ 

//#if 747940388 
return Model.getFacade().getAction(owner);
//#endif 

} 

//#endif 


//#if -284518677 
return null;
//#endif 

} 

//#endif 


//#if -1059826484 
public FigMessage()
    { 

//#if 2019598550 
this(null);
//#endif 

} 

//#endif 


//#if 944295337 
@Override
    public Selection makeSelection()
    { 

//#if -2102119629 
return new SelectionMessage(this);
//#endif 

} 

//#endif 


//#if 1542825710 
private boolean isSelfMessage()
    { 

//#if 555851362 
FigMessagePort srcMP = (FigMessagePort) getSourcePortFig();
//#endif 


//#if 558802157 
FigMessagePort destMP = (FigMessagePort) getDestPortFig();
//#endif 


//#if -1005530677 
return (srcMP.getNode().getFigClassifierRole()
                == destMP.getNode().getFigClassifierRole());
//#endif 

} 

//#endif 


//#if -1117842217 
public FigClassifierRole getDestFigClassifierRole()
    { 

//#if 2013569705 
return (FigClassifierRole) getDestFigNode();
//#endif 

} 

//#endif 


//#if 1644935887 
public Fig getSourcePortFig()
    { 

//#if 318867767 
Fig result = super.getSourcePortFig();
//#endif 


//#if 607447156 
if(result instanceof FigClassifierRole.TempFig
                && getOwner() != null)//1
{ 

//#if -1528838459 
result =
                getSourceFigClassifierRole().createFigMessagePort(
                    getOwner(), (FigClassifierRole.TempFig) result);
//#endif 


//#if -2039834852 
setSourcePortFig(result);
//#endif 

} 

//#endif 


//#if -567214996 
return result;
//#endif 

} 

//#endif 


//#if 632179511 
@Override
    protected void updateNameText()
    { 

//#if 1564182154 
super.updateNameText();
//#endif 


//#if 160443096 
textGroup.calcBounds();
//#endif 

} 

//#endif 


//#if 925926430 
@Override
    protected void updateStereotypeText()
    { 

//#if -1509264841 
super.updateStereotypeText();
//#endif 


//#if -1215463924 
textGroup.calcBounds();
//#endif 

} 

//#endif 


//#if -789991629 
public MessageNode getDestMessageNode()
    { 

//#if 902852979 
return ((FigMessagePort) getDestPortFig()).getNode();
//#endif 

} 

//#endif 


//#if 44596619 
protected void layoutEdge()
    { 

//#if -354792207 
if(getSourcePortFig() instanceof FigMessagePort
                && getDestPortFig() instanceof FigMessagePort
                && ((FigMessagePort) getSourcePortFig()).getNode() != null
                && ((FigMessagePort) getDestPortFig()).getNode() != null)//1
{ 

//#if 2015282912 
((SequenceDiagramLayer) getLayer()).updateActivations();
//#endif 


//#if 483497053 
Editor editor = Globals.curEditor();
//#endif 


//#if 1212593394 
if(editor != null)//1
{ 

//#if -1342681910 
Globals.curEditor().damageAll();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1641253479 
@Override
    protected Object getDestination()
    { 

//#if 1387659013 
Object owner = getOwner();
//#endif 


//#if -664536058 
if(owner == null)//1
{ 

//#if 1504734860 
return null;
//#endif 

} 

//#endif 


//#if -293475231 
return Model.getFacade().getReceiver(owner);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

