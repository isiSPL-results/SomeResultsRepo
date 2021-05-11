// Compilation Unit of /FigAssociation.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import org.apache.log4j.Logger;
import org.argouml.model.AddAssociationEvent;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.Model;
import org.argouml.notation.NotationProviderFactory2;
import org.argouml.ui.ArgoJMenu;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.base.Layer;
import org.tigris.gef.presentation.ArrowHead;
import org.tigris.gef.presentation.ArrowHeadComposite;
import org.tigris.gef.presentation.ArrowHeadDiamond;
import org.tigris.gef.presentation.ArrowHeadGreater;
import org.tigris.gef.presentation.ArrowHeadNone;
import org.tigris.gef.presentation.FigNode;
import org.tigris.gef.presentation.FigText;
class FigRole extends FigSingleLineTextWithNotation
  { 
protected int getNotationProviderType()
    { 
return NotationProviderFactory2.TYPE_ASSOCIATION_END_NAME;
} 

@SuppressWarnings("deprecation")

    @Deprecated
    FigRole()
    { 
super(X0, Y0, 90, 20, false, (String[]) null
              // no need to listen to these property changes - the
              // notationProvider takes care of registering these.
              /*, new String[] {"name", "visibility", "stereotype"}*/
             );
setTextFilled(false);
setJustification(FigText.JUSTIFY_CENTER);
} 

FigRole(Object owner, DiagramSettings settings)
    { 
super(owner, new Rectangle(X0, Y0, 90, 20), settings, false,
              (String[]) null
              // no need to listen to these property changes - the
              // notationProvider takes care of this.
              /*, new String[] {"name", "visibility", "stereotype"}*/
             );
setTextFilled(false);
setJustification(FigText.JUSTIFY_CENTER);
setText();
} 

@Override
    public void propertyChange(PropertyChangeEvent pce)
    { 
super.propertyChange(pce);
this.getGroup().calcBounds();
} 

 } 

class FigMultiplicity extends FigSingleLineTextWithNotation
  { 
FigMultiplicity(Object owner, DiagramSettings settings)
    { 
super(owner, new Rectangle(X0, Y0, 90, 20), settings, false,
              "multiplicity");
setTextFilled(false);
setJustification(FigText.JUSTIFY_CENTER);
} 

@Override
    protected int getNotationProviderType()
    { 
return NotationProviderFactory2.TYPE_MULTIPLICITY;
} 

@SuppressWarnings("deprecation")

    @Deprecated
    FigMultiplicity()
    { 
super(X0, Y0, 90, 20, false, new String[] {"multiplicity"});
setTextFilled(false);
setJustification(FigText.JUSTIFY_CENTER);
} 

 } 

class FigOrdering extends FigSingleLineText
  { 
private static final long serialVersionUID = 5385230942216677015L;
@Override
    protected void setText()
    { 
assert getOwner() != null;
if(getSettings().getNotationSettings().isShowProperties())//1
{ 
setText(getOrderingName(Model.getFacade().getOrdering(getOwner())));
} 
else
{ 
setText("");
} 

damage();
} 

private String getOrderingName(Object orderingKind)
    { 
if(orderingKind == null)//1
{ 
return "";
} 

if(Model.getFacade().getName(orderingKind) == null)//1
{ 
return "";
} 

if("".equals(Model.getFacade().getName(orderingKind)))//1
{ 
return "";
} 

if("unordered".equals(Model.getFacade().getName(orderingKind)))//1
{ 
return "";
} 

return "{" + Model.getFacade().getName(orderingKind) + "}";
} 

FigOrdering(Object owner, DiagramSettings settings)
    { 
super(owner, new Rectangle(X0, Y0, 90, 20), settings, false,
              "ordering");
setTextFilled(false);
setJustification(FigText.JUSTIFY_CENTER);
setEditable(false);
} 

@SuppressWarnings("deprecation")

    @Deprecated
    FigOrdering()
    { 
super(X0, Y0, 90, 20, false, "ordering");
setTextFilled(false);
setJustification(FigText.JUSTIFY_CENTER);
setEditable(false);
} 

 } 

class FigAssociationEndAnnotation extends FigTextGroup
  { 
private static final long serialVersionUID = 1871796732318164649L;
private static final ArrowHead NAV_AGGR =
        new ArrowHeadComposite(ArrowHeadDiamond.WhiteDiamond,
                               new ArrowHeadGreater());
private static final ArrowHead NAV_COMP =
        new ArrowHeadComposite(ArrowHeadDiamond.BlackDiamond,
                               new ArrowHeadGreater());
private static final int NONE = 0;
private static final int AGGREGATE = 1;
private static final int COMPOSITE = 2;
private static final int NAV_NONE = 3;
private static final int NAV_AGGREGATE = 4;
private static final int NAV_COMPOSITE = 5;
public static final ArrowHead[] ARROW_HEADS = new ArrowHead[6];
private FigRole role;
private FigOrdering ordering;
private int arrowType = 0;
private FigEdgeModelElement figEdge;
static
    {
        ARROW_HEADS[NONE] = ArrowHeadNone.TheInstance;
        ARROW_HEADS[AGGREGATE] = ArrowHeadDiamond.WhiteDiamond;
        ARROW_HEADS[COMPOSITE] = ArrowHeadDiamond.BlackDiamond;
        ARROW_HEADS[NAV_NONE] = new ArrowHeadGreater();
        ARROW_HEADS[NAV_AGGREGATE] = NAV_AGGR;
        ARROW_HEADS[NAV_COMPOSITE] = NAV_COMP;
    }
FigAssociationEndAnnotation(FigEdgeModelElement edge, Object owner,
                                DiagramSettings settings)
    { 
super(owner, settings);
figEdge = edge;
role = new FigRole(owner, settings);
addFig(role);
ordering = new FigOrdering(owner, settings);
addFig(ordering);
determineArrowHead();
Model.getPump().addModelEventListener(this, owner,
                                              new String[] {"isNavigable", "aggregation", "participant"});
} 

public int getArrowType()
    { 
return arrowType;
} 

@SuppressWarnings("deprecation")

    @Deprecated
    FigAssociationEndAnnotation(FigEdgeModelElement edge)
    { 
figEdge = edge;
role = new FigRole();
addFig(role);
ordering = new FigOrdering();
addFig(ordering);
} 

FigRole getRole()
    { 
return role;
} 

@SuppressWarnings("deprecation")

    @Deprecated
    @Override
    public void setOwner(Object owner)
    { 
if(owner != null)//1
{ 
if(!Model.getFacade().isAAssociationEnd(owner))//1
{ 
throw new IllegalArgumentException(
                    "An AssociationEnd was expected");
} 

super.setOwner(owner);
ordering.setOwner(owner);
role.setOwner(owner);
role.setText();
determineArrowHead();
Model.getPump().addModelEventListener(this, owner,
                                                  new String[] {"isNavigable", "aggregation", "participant"});
} 

} 

@Override
    public void propertyChange(PropertyChangeEvent pce)
    { 
if(pce instanceof AttributeChangeEvent
                && (pce.getPropertyName().equals("isNavigable")
                    || pce.getPropertyName().equals("aggregation")))//1
{ 
determineArrowHead();
((FigAssociation) figEdge).applyArrowHeads();
damage();
} 

if(pce instanceof AddAssociationEvent
                && pce.getPropertyName().equals("participant"))//1
{ 
figEdge.determineFigNodes();
} 

String pName = pce.getPropertyName();
if(pName.equals("editing")
                && Boolean.FALSE.equals(pce.getNewValue()))//1
{ 
role.textEdited();
calcBounds();
endTrans();
} 
else
if(pName.equals("editing")
                   && Boolean.TRUE.equals(pce.getNewValue()))//1
{ 
role.textEditStarted();
} 
else
{ 
super.propertyChange(pce);
} 


} 

@Override
    public void removeFromDiagram()
    { 
Model.getPump().removeModelEventListener(this,
                getOwner(),
                new String[] {"isNavigable", "aggregation", "participant"});
super.removeFromDiagram();
} 

private void determineArrowHead()
    { 
assert getOwner() != null;
Object ak =  Model.getFacade().getAggregation(getOwner());
boolean nav = Model.getFacade().isNavigable(getOwner());
if(nav)//1
{ 
if(Model.getAggregationKind().getNone().equals(ak)
                    || (ak == null))//1
{ 
arrowType = NAV_NONE;
} 
else
if(Model.getAggregationKind().getAggregate()
                       .equals(ak))//1
{ 
arrowType = NAV_AGGREGATE;
} 
else
if(Model.getAggregationKind().getComposite()
                       .equals(ak))//1
{ 
arrowType = NAV_COMPOSITE;
} 



} 
else
{ 
if(Model.getAggregationKind().getNone().equals(ak)
                    || (ak == null))//1
{ 
arrowType = NONE;
} 
else
if(Model.getAggregationKind().getAggregate()
                       .equals(ak))//1
{ 
arrowType = AGGREGATE;
} 
else
if(Model.getAggregationKind().getComposite()
                       .equals(ak))//1
{ 
arrowType = COMPOSITE;
} 



} 

} 

 } 

public class FigAssociation extends FigEdgeModelElement
  { 
private static final Logger LOG = Logger.getLogger(FigAssociation.class);
private FigAssociationEndAnnotation srcGroup;
private FigAssociationEndAnnotation destGroup;
private FigTextGroup middleGroup;
private FigMultiplicity srcMult;
private FigMultiplicity destMult;
protected void updateMultiplicity()
    { 
if(getOwner() != null
                && srcMult.getOwner() != null
                && destMult.getOwner() != null)//1
{ 
srcMult.setText();
destMult.setText();
} 

} 

@Override
    protected int getNotationProviderType()
    { 
return NotationProviderFactory2.TYPE_ASSOCIATION_NAME;
} 

@Override
    public void paintClarifiers(Graphics g)
    { 
indicateBounds(getNameFig(), g);
indicateBounds(srcMult, g);
indicateBounds(srcGroup.getRole(), g);
indicateBounds(destMult, g);
indicateBounds(destGroup.getRole(), g);
super.paintClarifiers(g);
} 

@Override
    protected void textEdited(FigText ft)
    { 
if(getOwner() == null)//1
{ 
return;
} 

super.textEdited(ft);
Collection conn = Model.getFacade().getConnections(getOwner());
if(conn == null || conn.size() == 0)//1
{ 
return;
} 

if(ft == srcGroup.getRole())//1
{ 
srcGroup.getRole().textEdited();
} 
else
if(ft == destGroup.getRole())//1
{ 
destGroup.getRole().textEdited();
} 
else
if(ft == srcMult)//1
{ 
srcMult.textEdited();
} 
else
if(ft == destMult)//1
{ 
destMult.textEdited();
} 




} 

@Override
    protected void initNotationProviders(Object own)
    { 
initializeNotationProvidersInternal(own);
} 

@Deprecated
    public FigAssociation(Object edge, Layer lay)
    { 
this();
setOwner(edge);
setLayer(lay);
} 

protected void createNameLabel(Object owner, DiagramSettings settings)
    { 
middleGroup = new FigTextGroup(owner, settings);
if(getNameFig() != null)//1
{ 
middleGroup.addFig(getNameFig());
} 

middleGroup.addFig(getStereotypeFig());
addPathItem(middleGroup,
                    new PathItemPlacement(this, middleGroup, 50, 25));
ArgoFigUtil.markPosition(this, 50, 0, 90, 25, Color.yellow);
} 

protected FigTextGroup getMiddleGroup()
    { 
return middleGroup;
} 

@Override
    public Vector getPopUpActions(MouseEvent me)
    { 
Vector popUpActions = super.getPopUpActions(me);
boolean ms = TargetManager.getInstance().getTargets().size() > 1;
if(ms)//1
{ 
return popUpActions;
} 

Point firstPoint = this.getFirstPoint();
Point lastPoint = this.getLastPoint();
int length = getPerimeterLength();
int rSquared = (int) (.3 * length);
if(rSquared > 100)//1
{ 
rSquared = 10000;
} 
else
{ 
rSquared *= rSquared;
} 

int srcDeterminingFactor =
            getSquaredDistance(me.getPoint(), firstPoint);
int destDeterminingFactor =
            getSquaredDistance(me.getPoint(), lastPoint);
if(srcDeterminingFactor < rSquared
                && srcDeterminingFactor < destDeterminingFactor)//1
{ 
ArgoJMenu multMenu =
                new ArgoJMenu("menu.popup.multiplicity");
multMenu.add(ActionMultiplicity.getSrcMultOne());
multMenu.add(ActionMultiplicity.getSrcMultZeroToOne());
multMenu.add(ActionMultiplicity.getSrcMultOneToMany());
multMenu.add(ActionMultiplicity.getSrcMultZeroToMany());
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                             multMenu);
ArgoJMenu aggMenu = new ArgoJMenu("menu.popup.aggregation");
aggMenu.add(ActionAggregation.getSrcAggNone());
aggMenu.add(ActionAggregation.getSrcAgg());
aggMenu.add(ActionAggregation.getSrcAggComposite());
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                             aggMenu);
} 
else
if(destDeterminingFactor < rSquared)//1
{ 
ArgoJMenu multMenu =
                new ArgoJMenu("menu.popup.multiplicity");
multMenu.add(ActionMultiplicity.getDestMultOne());
multMenu.add(ActionMultiplicity.getDestMultZeroToOne());
multMenu.add(ActionMultiplicity.getDestMultOneToMany());
multMenu.add(ActionMultiplicity.getDestMultZeroToMany());
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                             multMenu);
ArgoJMenu aggMenu = new ArgoJMenu("menu.popup.aggregation");
aggMenu.add(ActionAggregation.getDestAggNone());
aggMenu.add(ActionAggregation.getDestAgg());
aggMenu.add(ActionAggregation.getDestAggComposite());
popUpActions
            .add(popUpActions.size() - getPopupAddOffset(), aggMenu);
} 


Object association = getOwner();
if(association != null)//1
{ 
Collection ascEnds = Model.getFacade().getConnections(association);
Iterator iter = ascEnds.iterator();
Object ascStart = iter.next();
Object ascEnd = iter.next();
if(Model.getFacade().isAClassifier(
                        Model.getFacade().getType(ascStart))
                    && Model.getFacade().isAClassifier(
                        Model.getFacade().getType(ascEnd)))//1
{ 
ArgoJMenu navMenu =
                    new ArgoJMenu("menu.popup.navigability");
navMenu.add(ActionNavigability.newActionNavigability(
                                ascStart,
                                ascEnd,
                                ActionNavigability.BIDIRECTIONAL));
navMenu.add(ActionNavigability.newActionNavigability(
                                ascStart,
                                ascEnd,
                                ActionNavigability.STARTTOEND));
navMenu.add(ActionNavigability.newActionNavigability(
                                ascStart,
                                ascEnd,
                                ActionNavigability.ENDTOSTART));
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                                 navMenu);
} 

} 

return popUpActions;
} 

public FigAssociation(Object owner, DiagramSettings settings)
    { 
super(owner, settings);
createNameLabel(owner, settings);
Object[] ends = // UML objects of AssociationEnd type
            Model.getFacade().getConnections(owner).toArray();
srcMult = new FigMultiplicity(ends[0], settings);
addPathItem(srcMult,
                    new PathItemPlacement(this, srcMult, 0, 5, 135, 5));
ArgoFigUtil.markPosition(this, 0, 5, 135, 5, Color.green);
srcGroup = new FigAssociationEndAnnotation(this, ends[0], settings);
addPathItem(srcGroup,
                    new PathItemPlacement(this, srcGroup, 0, 5, -135, 5));
ArgoFigUtil.markPosition(this, 0, 5, -135, 5, Color.blue);
destMult = new FigMultiplicity(ends[1], settings);
addPathItem(destMult,
                    new PathItemPlacement(this, destMult, 100, -5, 45, 5));
ArgoFigUtil.markPosition(this, 100, -5, 45, 5, Color.red);
destGroup = new FigAssociationEndAnnotation(this, ends[1], settings);
addPathItem(destGroup,
                    new PathItemPlacement(this, destGroup, 100, -5, -45, 5));
ArgoFigUtil.markPosition(this, 100, -5, -45, 5, Color.orange);
setBetweenNearestPoints(true);
initializeNotationProvidersInternal(owner);
} 

private void initializeNotationProvidersInternal(Object own)
    { 
super.initNotationProviders(own);
srcMult.initNotationProviders();
destMult.initNotationProviders();
} 

@SuppressWarnings("deprecation")

    @Deprecated
    @Override
    public void setOwner(Object owner)
    { 
super.setOwner(owner);
Object[] ends =
            Model.getFacade().getConnections(owner).toArray();
Object source = ends[0];
Object dest = ends[1];
srcGroup.setOwner(source);
srcMult.setOwner(source);
destGroup.setOwner(dest);
destMult.setOwner(dest);
} 

@Override
    protected void textEditStarted(FigText ft)
    { 
if(ft == srcGroup.getRole())//1
{ 
srcGroup.getRole().textEditStarted();
} 
else
if(ft == destGroup.getRole())//1
{ 
destGroup.getRole().textEditStarted();
} 
else
if(ft == srcMult)//1
{ 
srcMult.textEditStarted();
} 
else
if(ft == destMult)//1
{ 
destMult.textEditStarted();
} 
else
{ 
super.textEditStarted(ft);
} 




} 

@Override
    public void updateListeners(Object oldOwner, Object newOwner)
    { 
Set<Object[]> listeners = new HashSet<Object[]>();
if(newOwner != null)//1
{ 
listeners.add(
                new Object[] {newOwner,
                              new String[] {"isAbstract", "remove"}
                             });
} 

updateElementListeners(listeners);
} 

@Override
    protected void layoutEdge()
    { 
FigNode sourceFigNode = getSourceFigNode();
Point[] points = getPoints();
if(points.length < 3
                && sourceFigNode != null
                && getDestFigNode() == sourceFigNode)//1
{ 
Rectangle rect = new Rectangle(
                sourceFigNode.getX() + sourceFigNode.getWidth() - 20,
                sourceFigNode.getY() + sourceFigNode.getHeight() - 20,
                40,
                40);
points = new Point[5];
points[0] = new Point(rect.x, rect.y + rect.height / 2);
points[1] = new Point(rect.x, rect.y + rect.height);
points[2] = new Point(rect.x + rect.width, rect.y + rect.height);
points[3] = new Point(rect.x + rect.width, rect.y);
points[4] = new Point(rect.x + rect.width / 2, rect.y);
setPoints(points);
} 
else
{ 
super.layoutEdge();
} 

} 

protected void updateNameText()
    { 
super.updateNameText();
if(middleGroup != null)//1
{ 
middleGroup.calcBounds();
} 

} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigAssociation()
    { 
super();
middleGroup = new FigTextGroup();
if(getNameFig() != null)//1
{ 
middleGroup.addFig(getNameFig());
} 

middleGroup.addFig(getStereotypeFig());
addPathItem(middleGroup,
                    new PathItemPlacement(this, middleGroup, 50, 25));
ArgoFigUtil.markPosition(this, 50, 0, 90, 25, Color.yellow);
srcMult = new FigMultiplicity();
addPathItem(srcMult,
                    new PathItemPlacement(this, srcMult, 0, 5, 135, 5));
ArgoFigUtil.markPosition(this, 0, 5, 135, 5, Color.green);
srcGroup = new FigAssociationEndAnnotation(this);
addPathItem(srcGroup,
                    new PathItemPlacement(this, srcGroup, 0, 5, -135, 5));
ArgoFigUtil.markPosition(this, 0, 5, -135, 5, Color.blue);
destMult = new FigMultiplicity();
addPathItem(destMult,
                    new PathItemPlacement(this, destMult, 100, -5, 45, 5));
ArgoFigUtil.markPosition(this, 100, -5, 45, 5, Color.red);
destGroup = new FigAssociationEndAnnotation(this);
addPathItem(destGroup,
                    new PathItemPlacement(this, destGroup, 100, -5, -45, 5));
ArgoFigUtil.markPosition(this, 100, -5, -45, 5, Color.orange);
setBetweenNearestPoints(true);
} 

@Override
    public void paint(Graphics g)
    { 
if(getOwner() == null)//1
{ 
LOG.error("Trying to paint a FigAssociation without an owner. ");
} 
else
if(getOwner() != null)//1
{ 
applyArrowHeads();
} 


if(getSourceArrowHead() != null && getDestArrowHead() != null)//1
{ 
getSourceArrowHead().setLineColor(getLineColor());
getDestArrowHead().setLineColor(getLineColor());
} 

super.paint(g);
} 

@Override
    public void renderingChanged()
    { 
super.renderingChanged();
srcMult.renderingChanged();
destMult.renderingChanged();
srcGroup.renderingChanged();
destGroup.renderingChanged();
middleGroup.renderingChanged();
} 

protected void applyArrowHeads()
    { 
if(srcGroup == null || destGroup == null)//1
{ 
return;
} 

int sourceArrowType = srcGroup.getArrowType();
int destArrowType = destGroup.getArrowType();
if(!getSettings().isShowBidirectionalArrows()
                && sourceArrowType > 2
                && destArrowType > 2)//1
{ 
sourceArrowType -= 3;
destArrowType -= 3;
} 

setSourceArrowHead(FigAssociationEndAnnotation
                           .ARROW_HEADS[sourceArrowType]);
setDestArrowHead(FigAssociationEndAnnotation
                         .ARROW_HEADS[destArrowType]);
} 

 } 


