
//#if 1132193089 
// Compilation Unit of /FigAssociation.java 
 

//#if 1701273364 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1688763670 
import java.awt.Color;
//#endif 


//#if -1864717282 
import java.awt.Graphics;
//#endif 


//#if -1316674979 
import java.awt.Point;
//#endif 


//#if 433757534 
import java.awt.Rectangle;
//#endif 


//#if 2007354272 
import java.awt.event.MouseEvent;
//#endif 


//#if 473936435 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 953641075 
import java.util.Collection;
//#endif 


//#if 1600934641 
import java.util.HashSet;
//#endif 


//#if 90052131 
import java.util.Iterator;
//#endif 


//#if 298727875 
import java.util.Set;
//#endif 


//#if -1416460946 
import java.util.Vector;
//#endif 


//#if 1476283179 
import org.apache.log4j.Logger;
//#endif 


//#if 849568141 
import org.argouml.model.AddAssociationEvent;
//#endif 


//#if -1328783487 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if -971147618 
import org.argouml.model.Model;
//#endif 


//#if -906331749 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if -505926306 
import org.argouml.ui.ArgoJMenu;
//#endif 


//#if 1149215236 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 865414273 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -2098476591 
import org.tigris.gef.base.Layer;
//#endif 


//#if 285574960 
import org.tigris.gef.presentation.ArrowHead;
//#endif 


//#if -594987169 
import org.tigris.gef.presentation.ArrowHeadComposite;
//#endif 


//#if -313517838 
import org.tigris.gef.presentation.ArrowHeadDiamond;
//#endif 


//#if 121119500 
import org.tigris.gef.presentation.ArrowHeadGreater;
//#endif 


//#if 2026785880 
import org.tigris.gef.presentation.ArrowHeadNone;
//#endif 


//#if -262367309 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -257104408 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 719428615 
class FigRole extends 
//#if 1732909590 
FigSingleLineTextWithNotation
//#endif 

  { 

//#if -676516572 
protected int getNotationProviderType()
    { 

//#if 1718844148 
return NotationProviderFactory2.TYPE_ASSOCIATION_END_NAME;
//#endif 

} 

//#endif 


//#if -1212235449 

//#if 1895349129 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    FigRole()
    { 

//#if 1972908378 
super(X0, Y0, 90, 20, false, (String[]) null
              // no need to listen to these property changes - the
              // notationProvider takes care of registering these.
              /*, new String[] {"name", "visibility", "stereotype"}*/
             );
//#endif 


//#if 77703771 
setTextFilled(false);
//#endif 


//#if 1226327624 
setJustification(FigText.JUSTIFY_CENTER);
//#endif 

} 

//#endif 


//#if 2034865429 
FigRole(Object owner, DiagramSettings settings)
    { 

//#if 460018061 
super(owner, new Rectangle(X0, Y0, 90, 20), settings, false,
              (String[]) null
              // no need to listen to these property changes - the
              // notationProvider takes care of this.
              /*, new String[] {"name", "visibility", "stereotype"}*/
             );
//#endif 


//#if -803653138 
setTextFilled(false);
//#endif 


//#if 1611091547 
setJustification(FigText.JUSTIFY_CENTER);
//#endif 


//#if -1209825605 
setText();
//#endif 

} 

//#endif 


//#if -2060513101 
@Override
    public void propertyChange(PropertyChangeEvent pce)
    { 

//#if 755477813 
super.propertyChange(pce);
//#endif 


//#if -1369349157 
this.getGroup().calcBounds();
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 10620944 
class FigMultiplicity extends 
//#if 501449937 
FigSingleLineTextWithNotation
//#endif 

  { 

//#if -741496431 
FigMultiplicity(Object owner, DiagramSettings settings)
    { 

//#if 1138746567 
super(owner, new Rectangle(X0, Y0, 90, 20), settings, false,
              "multiplicity");
//#endif 


//#if -1729689694 
setTextFilled(false);
//#endif 


//#if 410597903 
setJustification(FigText.JUSTIFY_CENTER);
//#endif 

} 

//#endif 


//#if 1364975227 
@Override
    protected int getNotationProviderType()
    { 

//#if -1159835053 
return NotationProviderFactory2.TYPE_MULTIPLICITY;
//#endif 

} 

//#endif 


//#if -1962362379 

//#if -1929209972 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    FigMultiplicity()
    { 

//#if -1625619621 
super(X0, Y0, 90, 20, false, new String[] {"multiplicity"});
//#endif 


//#if 1098969667 
setTextFilled(false);
//#endif 


//#if 925665840 
setJustification(FigText.JUSTIFY_CENTER);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1028386587 
class FigOrdering extends 
//#if 2055835288 
FigSingleLineText
//#endif 

  { 

//#if 1399078694 
private static final long serialVersionUID = 5385230942216677015L;
//#endif 


//#if -74581051 
@Override
    protected void setText()
    { 

//#if 1089553494 
assert getOwner() != null;
//#endif 


//#if -1119064682 
if(getSettings().getNotationSettings().isShowProperties())//1
{ 

//#if -687094490 
setText(getOrderingName(Model.getFacade().getOrdering(getOwner())));
//#endif 

} 
else
{ 

//#if -616134876 
setText("");
//#endif 

} 

//#endif 


//#if 1203760013 
damage();
//#endif 

} 

//#endif 


//#if 839984304 
private String getOrderingName(Object orderingKind)
    { 

//#if -951896047 
if(orderingKind == null)//1
{ 

//#if -2056288255 
return "";
//#endif 

} 

//#endif 


//#if -1539430899 
if(Model.getFacade().getName(orderingKind) == null)//1
{ 

//#if -1885389525 
return "";
//#endif 

} 

//#endif 


//#if -152955090 
if("".equals(Model.getFacade().getName(orderingKind)))//1
{ 

//#if -1466623209 
return "";
//#endif 

} 

//#endif 


//#if 5186058 
if("unordered".equals(Model.getFacade().getName(orderingKind)))//1
{ 

//#if -2104115794 
return "";
//#endif 

} 

//#endif 


//#if -229743702 
return "{" + Model.getFacade().getName(orderingKind) + "}";
//#endif 

} 

//#endif 


//#if 1258954029 
FigOrdering(Object owner, DiagramSettings settings)
    { 

//#if -1385434729 
super(owner, new Rectangle(X0, Y0, 90, 20), settings, false,
              "ordering");
//#endif 


//#if -492070041 
setTextFilled(false);
//#endif 


//#if 1592473940 
setJustification(FigText.JUSTIFY_CENTER);
//#endif 


//#if -560889188 
setEditable(false);
//#endif 

} 

//#endif 


//#if 711418203 

//#if -217236538 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    FigOrdering()
    { 

//#if 1149792845 
super(X0, Y0, 90, 20, false, "ordering");
//#endif 


//#if 561395167 
setTextFilled(false);
//#endif 


//#if 1075308492 
setJustification(FigText.JUSTIFY_CENTER);
//#endif 


//#if 1773165332 
setEditable(false);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1888505978 
class FigAssociationEndAnnotation extends 
//#if 307862293 
FigTextGroup
//#endif 

  { 

//#if -1407421879 
private static final long serialVersionUID = 1871796732318164649L;
//#endif 


//#if 960295081 
private static final ArrowHead NAV_AGGR =
        new ArrowHeadComposite(ArrowHeadDiamond.WhiteDiamond,
                               new ArrowHeadGreater());
//#endif 


//#if -1042744175 
private static final ArrowHead NAV_COMP =
        new ArrowHeadComposite(ArrowHeadDiamond.BlackDiamond,
                               new ArrowHeadGreater());
//#endif 


//#if 489421165 
private static final int NONE = 0;
//#endif 


//#if -479576405 
private static final int AGGREGATE = 1;
//#endif 


//#if -1033882366 
private static final int COMPOSITE = 2;
//#endif 


//#if -689863666 
private static final int NAV_NONE = 3;
//#endif 


//#if -475758780 
private static final int NAV_AGGREGATE = 4;
//#endif 


//#if -1030064741 
private static final int NAV_COMPOSITE = 5;
//#endif 


//#if -1329515339 
public static final ArrowHead[] ARROW_HEADS = new ArrowHead[6];
//#endif 


//#if -384702937 
private FigRole role;
//#endif 


//#if -550181909 
private FigOrdering ordering;
//#endif 


//#if -1453241512 
private int arrowType = 0;
//#endif 


//#if -1623334638 
private FigEdgeModelElement figEdge;
//#endif 


//#if 485127514 
static
    {
        ARROW_HEADS[NONE] = ArrowHeadNone.TheInstance;
        ARROW_HEADS[AGGREGATE] = ArrowHeadDiamond.WhiteDiamond;
        ARROW_HEADS[COMPOSITE] = ArrowHeadDiamond.BlackDiamond;
        ARROW_HEADS[NAV_NONE] = new ArrowHeadGreater();
        ARROW_HEADS[NAV_AGGREGATE] = NAV_AGGR;
        ARROW_HEADS[NAV_COMPOSITE] = NAV_COMP;
    }
//#endif 


//#if -2000847643 
FigAssociationEndAnnotation(FigEdgeModelElement edge, Object owner,
                                DiagramSettings settings)
    { 

//#if 1626021606 
super(owner, settings);
//#endif 


//#if 278511383 
figEdge = edge;
//#endif 


//#if 894966464 
role = new FigRole(owner, settings);
//#endif 


//#if 480846146 
addFig(role);
//#endif 


//#if -580514560 
ordering = new FigOrdering(owner, settings);
//#endif 


//#if -1794651616 
addFig(ordering);
//#endif 


//#if 617060377 
determineArrowHead();
//#endif 


//#if -2029825073 
Model.getPump().addModelEventListener(this, owner,
                                              new String[] {"isNavigable", "aggregation", "participant"});
//#endif 

} 

//#endif 


//#if -60160851 
public int getArrowType()
    { 

//#if 874575217 
return arrowType;
//#endif 

} 

//#endif 


//#if 233105375 

//#if -298617054 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    FigAssociationEndAnnotation(FigEdgeModelElement edge)
    { 

//#if 721571797 
figEdge = edge;
//#endif 


//#if -109367226 
role = new FigRole();
//#endif 


//#if 923906560 
addFig(role);
//#endif 


//#if -1890258810 
ordering = new FigOrdering();
//#endif 


//#if 857590750 
addFig(ordering);
//#endif 

} 

//#endif 


//#if -81194118 
FigRole getRole()
    { 

//#if -184838553 
return role;
//#endif 

} 

//#endif 


//#if 194890543 

//#if 1691828678 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    public void setOwner(Object owner)
    { 

//#if 1571458325 
if(owner != null)//1
{ 

//#if -1393567443 
if(!Model.getFacade().isAAssociationEnd(owner))//1
{ 

//#if -2047710096 
throw new IllegalArgumentException(
                    "An AssociationEnd was expected");
//#endif 

} 

//#endif 


//#if -1097838911 
super.setOwner(owner);
//#endif 


//#if -898302712 
ordering.setOwner(owner);
//#endif 


//#if -1270883674 
role.setOwner(owner);
//#endif 


//#if 1777159299 
role.setText();
//#endif 


//#if 1662358756 
determineArrowHead();
//#endif 


//#if 1226188058 
Model.getPump().addModelEventListener(this, owner,
                                                  new String[] {"isNavigable", "aggregation", "participant"});
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1510589547 
@Override
    public void propertyChange(PropertyChangeEvent pce)
    { 

//#if 125846535 
if(pce instanceof AttributeChangeEvent
                && (pce.getPropertyName().equals("isNavigable")
                    || pce.getPropertyName().equals("aggregation")))//1
{ 

//#if -1954263344 
determineArrowHead();
//#endif 


//#if 1866889744 
((FigAssociation) figEdge).applyArrowHeads();
//#endif 


//#if 1305604407 
damage();
//#endif 

} 

//#endif 


//#if 631082141 
if(pce instanceof AddAssociationEvent
                && pce.getPropertyName().equals("participant"))//1
{ 

//#if -348830382 
figEdge.determineFigNodes();
//#endif 

} 

//#endif 


//#if 279620097 
String pName = pce.getPropertyName();
//#endif 


//#if 1697178087 
if(pName.equals("editing")
                && Boolean.FALSE.equals(pce.getNewValue()))//1
{ 

//#if 1725909174 
role.textEdited();
//#endif 


//#if -33422554 
calcBounds();
//#endif 


//#if 178647203 
endTrans();
//#endif 

} 
else

//#if 131782844 
if(pName.equals("editing")
                   && Boolean.TRUE.equals(pce.getNewValue()))//1
{ 

//#if -761962651 
role.textEditStarted();
//#endif 

} 
else
{ 

//#if -216144941 
super.propertyChange(pce);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1646426716 
@Override
    public void removeFromDiagram()
    { 

//#if -577095429 
Model.getPump().removeModelEventListener(this,
                getOwner(),
                new String[] {"isNavigable", "aggregation", "participant"});
//#endif 


//#if -1358692447 
super.removeFromDiagram();
//#endif 

} 

//#endif 


//#if 2108211559 
private void determineArrowHead()
    { 

//#if -18879980 
assert getOwner() != null;
//#endif 


//#if -93415594 
Object ak =  Model.getFacade().getAggregation(getOwner());
//#endif 


//#if -671412277 
boolean nav = Model.getFacade().isNavigable(getOwner());
//#endif 


//#if -2055818272 
if(nav)//1
{ 

//#if -1739025402 
if(Model.getAggregationKind().getNone().equals(ak)
                    || (ak == null))//1
{ 

//#if 357448348 
arrowType = NAV_NONE;
//#endif 

} 
else

//#if 1267901961 
if(Model.getAggregationKind().getAggregate()
                       .equals(ak))//1
{ 

//#if -1607670682 
arrowType = NAV_AGGREGATE;
//#endif 

} 
else

//#if -1176430463 
if(Model.getAggregationKind().getComposite()
                       .equals(ak))//1
{ 

//#if -691151128 
arrowType = NAV_COMPOSITE;
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 
else
{ 

//#if 1517344064 
if(Model.getAggregationKind().getNone().equals(ak)
                    || (ak == null))//1
{ 

//#if -1988177635 
arrowType = NONE;
//#endif 

} 
else

//#if -1817956256 
if(Model.getAggregationKind().getAggregate()
                       .equals(ak))//1
{ 

//#if 1843844549 
arrowType = AGGREGATE;
//#endif 

} 
else

//#if -1464236150 
if(Model.getAggregationKind().getComposite()
                       .equals(ak))//1
{ 

//#if -1143807136 
arrowType = COMPOSITE;
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if 934827655 
public class FigAssociation extends 
//#if 1020905089 
FigEdgeModelElement
//#endif 

  { 

//#if -559059848 
private static final Logger LOG = Logger.getLogger(FigAssociation.class);
//#endif 


//#if 1438057827 
private FigAssociationEndAnnotation srcGroup;
//#endif 


//#if 179625595 
private FigAssociationEndAnnotation destGroup;
//#endif 


//#if 1082488303 
private FigTextGroup middleGroup;
//#endif 


//#if 416848506 
private FigMultiplicity srcMult;
//#endif 


//#if -1702234890 
private FigMultiplicity destMult;
//#endif 


//#if 291588856 
protected void updateMultiplicity()
    { 

//#if -1386865942 
if(getOwner() != null
                && srcMult.getOwner() != null
                && destMult.getOwner() != null)//1
{ 

//#if 796759526 
srcMult.setText();
//#endif 


//#if -1882317754 
destMult.setText();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1774102806 
@Override
    protected int getNotationProviderType()
    { 

//#if 111294619 
return NotationProviderFactory2.TYPE_ASSOCIATION_NAME;
//#endif 

} 

//#endif 


//#if 806670425 
@Override
    public void paintClarifiers(Graphics g)
    { 

//#if -2050771670 
indicateBounds(getNameFig(), g);
//#endif 


//#if -2139492792 
indicateBounds(srcMult, g);
//#endif 


//#if 1132410272 
indicateBounds(srcGroup.getRole(), g);
//#endif 


//#if -35581928 
indicateBounds(destMult, g);
//#endif 


//#if 1449120208 
indicateBounds(destGroup.getRole(), g);
//#endif 


//#if 125809967 
super.paintClarifiers(g);
//#endif 

} 

//#endif 


//#if -43204941 
@Override
    protected void textEdited(FigText ft)
    { 

//#if -907618894 
if(getOwner() == null)//1
{ 

//#if 267688041 
return;
//#endif 

} 

//#endif 


//#if -1245660967 
super.textEdited(ft);
//#endif 


//#if 2005492618 
Collection conn = Model.getFacade().getConnections(getOwner());
//#endif 


//#if -863157716 
if(conn == null || conn.size() == 0)//1
{ 

//#if 104049784 
return;
//#endif 

} 

//#endif 


//#if -1071156171 
if(ft == srcGroup.getRole())//1
{ 

//#if 632560274 
srcGroup.getRole().textEdited();
//#endif 

} 
else

//#if 1332278698 
if(ft == destGroup.getRole())//1
{ 

//#if -1839947543 
destGroup.getRole().textEdited();
//#endif 

} 
else

//#if -2129658906 
if(ft == srcMult)//1
{ 

//#if 1107743296 
srcMult.textEdited();
//#endif 

} 
else

//#if -1247716550 
if(ft == destMult)//1
{ 

//#if 1534899839 
destMult.textEdited();
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 1463474115 
@Override
    protected void initNotationProviders(Object own)
    { 

//#if -1542053337 
initializeNotationProvidersInternal(own);
//#endif 

} 

//#endif 


//#if -114805944 
@Deprecated
    public FigAssociation(Object edge, Layer lay)
    { 

//#if 1102965636 
this();
//#endif 


//#if -83855154 
setOwner(edge);
//#endif 


//#if -1712774923 
setLayer(lay);
//#endif 

} 

//#endif 


//#if -1680709390 
protected void createNameLabel(Object owner, DiagramSettings settings)
    { 

//#if -2023379067 
middleGroup = new FigTextGroup(owner, settings);
//#endif 


//#if 437976240 
if(getNameFig() != null)//1
{ 

//#if 1470397421 
middleGroup.addFig(getNameFig());
//#endif 

} 

//#endif 


//#if 351570822 
middleGroup.addFig(getStereotypeFig());
//#endif 


//#if -1916355849 
addPathItem(middleGroup,
                    new PathItemPlacement(this, middleGroup, 50, 25));
//#endif 


//#if 163608331 
ArgoFigUtil.markPosition(this, 50, 0, 90, 25, Color.yellow);
//#endif 

} 

//#endif 


//#if 407553150 
protected FigTextGroup getMiddleGroup()
    { 

//#if 2019530243 
return middleGroup;
//#endif 

} 

//#endif 


//#if 1556845462 
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 

//#if -1712456849 
Vector popUpActions = super.getPopUpActions(me);
//#endif 


//#if 226090432 
boolean ms = TargetManager.getInstance().getTargets().size() > 1;
//#endif 


//#if 1228557089 
if(ms)//1
{ 

//#if 516979683 
return popUpActions;
//#endif 

} 

//#endif 


//#if -1890094385 
Point firstPoint = this.getFirstPoint();
//#endif 


//#if -278870271 
Point lastPoint = this.getLastPoint();
//#endif 


//#if -753432243 
int length = getPerimeterLength();
//#endif 


//#if -972113242 
int rSquared = (int) (.3 * length);
//#endif 


//#if -588816061 
if(rSquared > 100)//1
{ 

//#if -1461274770 
rSquared = 10000;
//#endif 

} 
else
{ 

//#if 831173942 
rSquared *= rSquared;
//#endif 

} 

//#endif 


//#if 287640708 
int srcDeterminingFactor =
            getSquaredDistance(me.getPoint(), firstPoint);
//#endif 


//#if 1779159814 
int destDeterminingFactor =
            getSquaredDistance(me.getPoint(), lastPoint);
//#endif 


//#if -1064334105 
if(srcDeterminingFactor < rSquared
                && srcDeterminingFactor < destDeterminingFactor)//1
{ 

//#if -1107338456 
ArgoJMenu multMenu =
                new ArgoJMenu("menu.popup.multiplicity");
//#endif 


//#if -69677492 
multMenu.add(ActionMultiplicity.getSrcMultOne());
//#endif 


//#if 782402377 
multMenu.add(ActionMultiplicity.getSrcMultZeroToOne());
//#endif 


//#if 1904069158 
multMenu.add(ActionMultiplicity.getSrcMultOneToMany());
//#endif 


//#if 973807842 
multMenu.add(ActionMultiplicity.getSrcMultZeroToMany());
//#endif 


//#if 1147273700 
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                             multMenu);
//#endif 


//#if 596508936 
ArgoJMenu aggMenu = new ArgoJMenu("menu.popup.aggregation");
//#endif 


//#if 13329163 
aggMenu.add(ActionAggregation.getSrcAggNone());
//#endif 


//#if -1414755405 
aggMenu.add(ActionAggregation.getSrcAgg());
//#endif 


//#if 969445146 
aggMenu.add(ActionAggregation.getSrcAggComposite());
//#endif 


//#if 246886671 
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                             aggMenu);
//#endif 

} 
else

//#if 1270314939 
if(destDeterminingFactor < rSquared)//1
{ 

//#if 1467209959 
ArgoJMenu multMenu =
                new ArgoJMenu("menu.popup.multiplicity");
//#endif 


//#if -1756664097 
multMenu.add(ActionMultiplicity.getDestMultOne());
//#endif 


//#if 835791260 
multMenu.add(ActionMultiplicity.getDestMultZeroToOne());
//#endif 


//#if 1957458041 
multMenu.add(ActionMultiplicity.getDestMultOneToMany());
//#endif 


//#if -1666104081 
multMenu.add(ActionMultiplicity.getDestMultZeroToMany());
//#endif 


//#if 745900805 
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                             multMenu);
//#endif 


//#if 188015239 
ArgoJMenu aggMenu = new ArgoJMenu("menu.popup.aggregation");
//#endif 


//#if 65876966 
aggMenu.add(ActionAggregation.getDestAggNone());
//#endif 


//#if 1610023438 
aggMenu.add(ActionAggregation.getDestAgg());
//#endif 


//#if 1761480479 
aggMenu.add(ActionAggregation.getDestAggComposite());
//#endif 


//#if -43155506 
popUpActions
            .add(popUpActions.size() - getPopupAddOffset(), aggMenu);
//#endif 

} 

//#endif 


//#endif 


//#if -36827606 
Object association = getOwner();
//#endif 


//#if 1325903801 
if(association != null)//1
{ 

//#if 411529947 
Collection ascEnds = Model.getFacade().getConnections(association);
//#endif 


//#if 267378861 
Iterator iter = ascEnds.iterator();
//#endif 


//#if 2131513057 
Object ascStart = iter.next();
//#endif 


//#if -1623164856 
Object ascEnd = iter.next();
//#endif 


//#if -1605447063 
if(Model.getFacade().isAClassifier(
                        Model.getFacade().getType(ascStart))
                    && Model.getFacade().isAClassifier(
                        Model.getFacade().getType(ascEnd)))//1
{ 

//#if 769960878 
ArgoJMenu navMenu =
                    new ArgoJMenu("menu.popup.navigability");
//#endif 


//#if -1799110372 
navMenu.add(ActionNavigability.newActionNavigability(
                                ascStart,
                                ascEnd,
                                ActionNavigability.BIDIRECTIONAL));
//#endif 


//#if 1163193721 
navMenu.add(ActionNavigability.newActionNavigability(
                                ascStart,
                                ascEnd,
                                ActionNavigability.STARTTOEND));
//#endif 


//#if 1744158347 
navMenu.add(ActionNavigability.newActionNavigability(
                                ascStart,
                                ascEnd,
                                ActionNavigability.ENDTOSTART));
//#endif 


//#if -600488554 
popUpActions.add(popUpActions.size() - getPopupAddOffset(),
                                 navMenu);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1918123810 
return popUpActions;
//#endif 

} 

//#endif 


//#if 1717888311 
public FigAssociation(Object owner, DiagramSettings settings)
    { 

//#if 1763620417 
super(owner, settings);
//#endif 


//#if 1044737775 
createNameLabel(owner, settings);
//#endif 


//#if 1606238070 
Object[] ends = // UML objects of AssociationEnd type
            Model.getFacade().getConnections(owner).toArray();
//#endif 


//#if 1034763175 
srcMult = new FigMultiplicity(ends[0], settings);
//#endif 


//#if -1299063414 
addPathItem(srcMult,
                    new PathItemPlacement(this, srcMult, 0, 5, 135, 5));
//#endif 


//#if 133283588 
ArgoFigUtil.markPosition(this, 0, 5, 135, 5, Color.green);
//#endif 


//#if 1110137920 
srcGroup = new FigAssociationEndAnnotation(this, ends[0], settings);
//#endif 


//#if 816484055 
addPathItem(srcGroup,
                    new PathItemPlacement(this, srcGroup, 0, 5, -135, 5));
//#endif 


//#if 2003193182 
ArgoFigUtil.markPosition(this, 0, 5, -135, 5, Color.blue);
//#endif 


//#if -549220302 
destMult = new FigMultiplicity(ends[1], settings);
//#endif 


//#if -1154670742 
addPathItem(destMult,
                    new PathItemPlacement(this, destMult, 100, -5, 45, 5));
//#endif 


//#if -2010617412 
ArgoFigUtil.markPosition(this, 100, -5, 45, 5, Color.red);
//#endif 


//#if 1467089483 
destGroup = new FigAssociationEndAnnotation(this, ends[1], settings);
//#endif 


//#if 663005031 
addPathItem(destGroup,
                    new PathItemPlacement(this, destGroup, 100, -5, -45, 5));
//#endif 


//#if -863131258 
ArgoFigUtil.markPosition(this, 100, -5, -45, 5, Color.orange);
//#endif 


//#if 1168862931 
setBetweenNearestPoints(true);
//#endif 


//#if 583375268 
initializeNotationProvidersInternal(owner);
//#endif 

} 

//#endif 


//#if 1317587329 
private void initializeNotationProvidersInternal(Object own)
    { 

//#if -878916371 
super.initNotationProviders(own);
//#endif 


//#if -1454143484 
srcMult.initNotationProviders();
//#endif 


//#if -189191546 
destMult.initNotationProviders();
//#endif 

} 

//#endif 


//#if -1386463517 

//#if 1280743436 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    public void setOwner(Object owner)
    { 

//#if 110710562 
super.setOwner(owner);
//#endif 


//#if 936828976 
Object[] ends =
            Model.getFacade().getConnections(owner).toArray();
//#endif 


//#if 1364767725 
Object source = ends[0];
//#endif 


//#if -879294201 
Object dest = ends[1];
//#endif 


//#if -543922606 
srcGroup.setOwner(source);
//#endif 


//#if 1874172905 
srcMult.setOwner(source);
//#endif 


//#if 1733929401 
destGroup.setOwner(dest);
//#endif 


//#if 51847760 
destMult.setOwner(dest);
//#endif 

} 

//#endif 


//#if -822316751 
@Override
    protected void textEditStarted(FigText ft)
    { 

//#if 126104180 
if(ft == srcGroup.getRole())//1
{ 

//#if 304894484 
srcGroup.getRole().textEditStarted();
//#endif 

} 
else

//#if 637371924 
if(ft == destGroup.getRole())//1
{ 

//#if 1997473280 
destGroup.getRole().textEditStarted();
//#endif 

} 
else

//#if -1845479573 
if(ft == srcMult)//1
{ 

//#if 1262516439 
srcMult.textEditStarted();
//#endif 

} 
else

//#if 1313596739 
if(ft == destMult)//1
{ 

//#if 632173372 
destMult.textEditStarted();
//#endif 

} 
else
{ 

//#if 1613661271 
super.textEditStarted(ft);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if -1480020674 
@Override
    public void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if 2137072464 
Set<Object[]> listeners = new HashSet<Object[]>();
//#endif 


//#if 186595677 
if(newOwner != null)//1
{ 

//#if 1644127943 
listeners.add(
                new Object[] {newOwner,
                              new String[] {"isAbstract", "remove"}
                             });
//#endif 

} 

//#endif 


//#if -1353270239 
updateElementListeners(listeners);
//#endif 

} 

//#endif 


//#if -1686512719 
@Override
    protected void layoutEdge()
    { 

//#if 1963166790 
FigNode sourceFigNode = getSourceFigNode();
//#endif 


//#if 1634097858 
Point[] points = getPoints();
//#endif 


//#if -1279933940 
if(points.length < 3
                && sourceFigNode != null
                && getDestFigNode() == sourceFigNode)//1
{ 

//#if 739810813 
Rectangle rect = new Rectangle(
                sourceFigNode.getX() + sourceFigNode.getWidth() - 20,
                sourceFigNode.getY() + sourceFigNode.getHeight() - 20,
                40,
                40);
//#endif 


//#if -2017525916 
points = new Point[5];
//#endif 


//#if -935234490 
points[0] = new Point(rect.x, rect.y + rect.height / 2);
//#endif 


//#if 926620324 
points[1] = new Point(rect.x, rect.y + rect.height);
//#endif 


//#if -331303558 
points[2] = new Point(rect.x + rect.width, rect.y + rect.height);
//#endif 


//#if -531948749 
points[3] = new Point(rect.x + rect.width, rect.y);
//#endif 


//#if 1359340559 
points[4] = new Point(rect.x + rect.width / 2, rect.y);
//#endif 


//#if -1546219434 
setPoints(points);
//#endif 

} 
else
{ 

//#if -608457964 
super.layoutEdge();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1299827311 
protected void updateNameText()
    { 

//#if -656094376 
super.updateNameText();
//#endif 


//#if -657702888 
if(middleGroup != null)//1
{ 

//#if 517206148 
middleGroup.calcBounds();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1426290745 

//#if 1933117912 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigAssociation()
    { 

//#if 872286121 
super();
//#endif 


//#if -1522699223 
middleGroup = new FigTextGroup();
//#endif 


//#if -2115114928 
if(getNameFig() != null)//1
{ 

//#if -821165050 
middleGroup.addFig(getNameFig());
//#endif 

} 

//#endif 


//#if -118317274 
middleGroup.addFig(getStereotypeFig());
//#endif 


//#if 1559114583 
addPathItem(middleGroup,
                    new PathItemPlacement(this, middleGroup, 50, 25));
//#endif 


//#if 929254059 
ArgoFigUtil.markPosition(this, 50, 0, 90, 25, Color.yellow);
//#endif 


//#if 1340311876 
srcMult = new FigMultiplicity();
//#endif 


//#if -1089317714 
addPathItem(srcMult,
                    new PathItemPlacement(this, srcMult, 0, 5, 135, 5));
//#endif 


//#if -2117436064 
ArgoFigUtil.markPosition(this, 0, 5, 135, 5, Color.green);
//#endif 


//#if 1986938579 
srcGroup = new FigAssociationEndAnnotation(this);
//#endif 


//#if 173217075 
addPathItem(srcGroup,
                    new PathItemPlacement(this, srcGroup, 0, 5, -135, 5));
//#endif 


//#if -247526470 
ArgoFigUtil.markPosition(this, 0, 5, -135, 5, Color.blue);
//#endif 


//#if -1877716458 
destMult = new FigMultiplicity();
//#endif 


//#if 378889358 
addPathItem(destMult,
                    new PathItemPlacement(this, destMult, 100, -5, 45, 5));
//#endif 


//#if 33630232 
ArgoFigUtil.markPosition(this, 100, -5, 45, 5, Color.red);
//#endif 


//#if -728630207 
destGroup = new FigAssociationEndAnnotation(this);
//#endif 


//#if 1384816579 
addPathItem(destGroup,
                    new PathItemPlacement(this, destGroup, 100, -5, -45, 5));
//#endif 


//#if 350738914 
ArgoFigUtil.markPosition(this, 100, -5, -45, 5, Color.orange);
//#endif 


//#if -335894537 
setBetweenNearestPoints(true);
//#endif 

} 

//#endif 


//#if 2048810189 
@Override
    public void paint(Graphics g)
    { 

//#if 667627508 
if(getOwner() == null)//1
{ 

//#if -28675367 
LOG.error("Trying to paint a FigAssociation without an owner. ");
//#endif 

} 
else

//#if 648140219 
if(getOwner() != null)//1
{ 

//#if 2105126114 
applyArrowHeads();
//#endif 

} 

//#endif 


//#endif 


//#if -1029203808 
if(getSourceArrowHead() != null && getDestArrowHead() != null)//1
{ 

//#if 779511172 
getSourceArrowHead().setLineColor(getLineColor());
//#endif 


//#if -1109151267 
getDestArrowHead().setLineColor(getLineColor());
//#endif 

} 

//#endif 


//#if -344783432 
super.paint(g);
//#endif 

} 

//#endif 


//#if -1718715073 
@Override
    public void renderingChanged()
    { 

//#if 1953586990 
super.renderingChanged();
//#endif 


//#if 323056295 
srcMult.renderingChanged();
//#endif 


//#if 487460391 
destMult.renderingChanged();
//#endif 


//#if -4693072 
srcGroup.renderingChanged();
//#endif 


//#if 796866608 
destGroup.renderingChanged();
//#endif 


//#if -651424547 
middleGroup.renderingChanged();
//#endif 

} 

//#endif 


//#if -223198102 
protected void applyArrowHeads()
    { 

//#if 1082527083 
if(srcGroup == null || destGroup == null)//1
{ 

//#if 980332907 
return;
//#endif 

} 

//#endif 


//#if 1787901586 
int sourceArrowType = srcGroup.getArrowType();
//#endif 


//#if 1880434685 
int destArrowType = destGroup.getArrowType();
//#endif 


//#if 1934056114 
if(!getSettings().isShowBidirectionalArrows()
                && sourceArrowType > 2
                && destArrowType > 2)//1
{ 

//#if 2113123192 
sourceArrowType -= 3;
//#endif 


//#if -17570223 
destArrowType -= 3;
//#endif 

} 

//#endif 


//#if 1077032150 
setSourceArrowHead(FigAssociationEndAnnotation
                           .ARROW_HEADS[sourceArrowType]);
//#endif 


//#if 987326180 
setDestArrowHead(FigAssociationEndAnnotation
                         .ARROW_HEADS[destArrowType]);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

