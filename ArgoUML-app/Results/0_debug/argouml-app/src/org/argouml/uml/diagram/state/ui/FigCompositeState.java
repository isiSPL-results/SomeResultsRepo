
//#if -219522898 
// Compilation Unit of /FigCompositeState.java 
 

//#if -1962181695 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if -2091680288 
import java.awt.Color;
//#endif 


//#if 1571187773 
import java.awt.Dimension;
//#endif 


//#if 1557409108 
import java.awt.Rectangle;
//#endif 


//#if 889092842 
import java.awt.event.MouseEvent;
//#endif 


//#if 1213703705 
import java.util.Iterator;
//#endif 


//#if 261368297 
import java.util.List;
//#endif 


//#if -311620335 
import java.util.TreeMap;
//#endif 


//#if -2072274204 
import java.util.Vector;
//#endif 


//#if 529363048 
import org.argouml.model.Model;
//#endif 


//#if -1590308568 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if -1281528273 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if 1843802106 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1375972789 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 156553977 
import org.argouml.uml.diagram.ui.ActionAddConcurrentRegion;
//#endif 


//#if 1604304788 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 666419807 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1071869643 
import org.tigris.gef.presentation.FigLine;
//#endif 


//#if -981513727 
import org.tigris.gef.presentation.FigRRect;
//#endif 


//#if 1077281499 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if 1079148722 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 162317006 
public class FigCompositeState extends 
//#if -1389187081 
FigState
//#endif 

  { 

//#if 1637949075 
private FigRect cover;
//#endif 


//#if -1659862591 
private FigLine divider;
//#endif 


//#if -1076854804 
public Object clone()
    { 

//#if -1913160021 
FigCompositeState figClone = (FigCompositeState) super.clone();
//#endif 


//#if -661953759 
Iterator it = figClone.getFigs().iterator();
//#endif 


//#if -17618380 
figClone.setBigPort((FigRRect) it.next());
//#endif 


//#if 1960415876 
figClone.cover = (FigRect) it.next();
//#endif 


//#if -1234592425 
figClone.setNameFig((FigText) it.next());
//#endif 


//#if -1083305578 
figClone.divider = (FigLine) it.next();
//#endif 


//#if -391062667 
figClone.setInternal((FigText) it.next());
//#endif 


//#if -2064427008 
return figClone;
//#endif 

} 

//#endif 


//#if 1240878512 
public void setLineWidth(int w)
    { 

//#if -3242129 
cover.setLineWidth(w);
//#endif 


//#if 1820195469 
divider.setLineWidth(w);
//#endif 

} 

//#endif 


//#if -1018627331 

//#if -718742306 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigCompositeState()
    { 

//#if -663673222 
super();
//#endif 


//#if 2074781312 
initFigs();
//#endif 

} 

//#endif 


//#if -904614496 
public void setFilled(boolean f)
    { 

//#if 1851550889 
cover.setFilled(f);
//#endif 


//#if -513848378 
getBigPort().setFilled(f);
//#endif 

} 

//#endif 


//#if 1103119557 
public Vector getPopUpActions(MouseEvent me)
    { 

//#if 1481452721 
Vector popUpActions = super.getPopUpActions(me);
//#endif 


//#if -129122242 
boolean ms = TargetManager.getInstance().getTargets().size() > 1;
//#endif 


//#if 1716919546 
if(!ms)//1
{ 

//#if 1337809723 
popUpActions.add(
                popUpActions.size() - getPopupAddOffset(),
                new ActionAddConcurrentRegion());
//#endif 

} 

//#endif 


//#if 1902477028 
return popUpActions;
//#endif 

} 

//#endif 


//#if 1248366145 
protected int getInitialHeight()
    { 

//#if 920508856 
return 150;
//#endif 

} 

//#endif 


//#if -1915644850 
protected int getInitialWidth()
    { 

//#if -1297913103 
return 180;
//#endif 

} 

//#endif 


//#if 2023915707 
public Color getFillColor()
    { 

//#if 1196549933 
return cover.getFillColor();
//#endif 

} 

//#endif 


//#if 982030744 
public boolean getUseTrapRect()
    { 

//#if 2103384374 
return true;
//#endif 

} 

//#endif 


//#if 1205982551 
protected void setStandardBounds(int x, int y, int w, int h)
    { 

//#if 404427331 
if(getNameFig() == null)//1
{ 

//#if -1349811029 
return;
//#endif 

} 

//#endif 


//#if 1264627396 
Rectangle oldBounds = getBounds();
//#endif 


//#if -573649438 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if 2021181209 
List regionsList = getEnclosedFigs();
//#endif 


//#if 106898329 
if(getOwner() != null)//1
{ 

//#if -428730585 
if(isConcurrent()
                    && !regionsList.isEmpty()
                    && regionsList.get(regionsList.size() - 1)
                    instanceof FigConcurrentRegion)//1
{ 

//#if -1278611332 
FigConcurrentRegion f =
                    ((FigConcurrentRegion) regionsList.get(
                         regionsList.size() - 1));
//#endif 


//#if -1706684649 
Rectangle regionBounds = f.getBounds();
//#endif 


//#if 1905167219 
if((h - oldBounds.height + regionBounds.height)
                        <= (f.getMinimumSize().height))//1
{ 

//#if -608189548 
h = oldBounds.height;
//#endif 


//#if -748880175 
y = oldBounds.y;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1696328051 
getNameFig().setBounds(x + MARGIN,
                               y + SPACE_TOP,
                               w - 2 * MARGIN,
                               nameDim.height);
//#endif 


//#if -1041279627 
divider.setShape(x,
                         y + DIVIDER_Y + nameDim.height,
                         x + w - 1,
                         y + DIVIDER_Y + nameDim.height);
//#endif 


//#if 1422052337 
getInternal().setBounds(
            x + MARGIN,
            y + nameDim.height + SPACE_TOP + SPACE_MIDDLE,
            w - 2 * MARGIN,
            h - nameDim.height - SPACE_TOP - SPACE_MIDDLE - SPACE_BOTTOM);
//#endif 


//#if -1777532026 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if -121204741 
cover.setBounds(x, y, w, h);
//#endif 


//#if -1742949547 
calcBounds();
//#endif 


//#if 1146687528 
updateEdges();
//#endif 


//#if -1432271599 
firePropChange("bounds", oldBounds, getBounds());
//#endif 


//#if 2037429368 
if(getOwner() != null)//2
{ 

//#if 717918394 
if(isConcurrent()
                    && !regionsList.isEmpty()
                    && regionsList.get(regionsList.size() - 1)
                    instanceof FigConcurrentRegion)//1
{ 

//#if 2120080094 
FigConcurrentRegion f = ((FigConcurrentRegion) regionsList
                                         .get(regionsList.size() - 1));
//#endif 


//#if -194569198 
for (int i = 0; i < regionsList.size() - 1; i++) //1
{ 

//#if -359765326 
((FigConcurrentRegion) regionsList.get(i))
                    .setBounds(x - oldBounds.x, y - oldBounds.y,
                               w - 2 * FigConcurrentRegion.INSET_HORZ, true);
//#endif 

} 

//#endif 


//#if 671523338 
f.setBounds(x - oldBounds.x,
                            y - oldBounds.y,
                            w - 2 * FigConcurrentRegion.INSET_HORZ,
                            h - oldBounds.height, true);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 933576055 
public boolean isConcurrent()
    { 

//#if 1796266981 
Object owner = getOwner();
//#endif 


//#if 1311413030 
if(owner == null)//1
{ 

//#if 478477575 
return false;
//#endif 

} 

//#endif 


//#if -1256588673 
return Model.getFacade().isConcurrent(owner);
//#endif 

} 

//#endif 


//#if 364511562 
@Override
    public boolean isFilled()
    { 

//#if 1900098149 
return cover.isFilled();
//#endif 

} 

//#endif 


//#if 1525218804 

//#if -476782625 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigCompositeState(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 

//#if 907690152 
this();
//#endif 


//#if 1976347895 
setOwner(node);
//#endif 

} 

//#endif 


//#if 1595109817 
public int getLineWidth()
    { 

//#if 823772323 
return cover.getLineWidth();
//#endif 

} 

//#endif 


//#if -459923968 
protected int getInitialX()
    { 

//#if 1914682906 
return 0;
//#endif 

} 

//#endif 


//#if -1083650760 
public void setLineColor(Color col)
    { 

//#if -319300877 
cover.setLineColor(col);
//#endif 


//#if 672653073 
divider.setLineColor(col);
//#endif 

} 

//#endif 


//#if 765440660 
public void setCompositeStateHeight(int h)
    { 

//#if 855826464 
if(getNameFig() == null)//1
{ 

//#if 495447421 
return;
//#endif 

} 

//#endif 


//#if 1698423521 
Rectangle oldBounds = getBounds();
//#endif 


//#if -2046810113 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if 1568212267 
int x = oldBounds.x;
//#endif 


//#if 1062653673 
int y = oldBounds.y;
//#endif 


//#if 2117938046 
int w = oldBounds.width;
//#endif 


//#if 36596049 
getInternal().setBounds(
            x + MARGIN,
            y + nameDim.height + 4,
            w - 2 * MARGIN,
            h - nameDim.height - 6);
//#endif 


//#if -1214754039 
getBigPort().setBounds(x, y, w, h);
//#endif 


//#if 330194392 
cover.setBounds(x, y, w, h);
//#endif 


//#if 1120707762 
calcBounds();
//#endif 


//#if -274249109 
updateEdges();
//#endif 


//#if 1389535022 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if -459923007 
protected int getInitialY()
    { 

//#if 193102400 
return 0;
//#endif 

} 

//#endif 


//#if 1704639885 
public Dimension getMinimumSize()
    { 

//#if 1157760338 
Dimension nameDim = getNameFig().getMinimumSize();
//#endif 


//#if -1526265158 
Dimension internalDim = getInternal().getMinimumSize();
//#endif 


//#if 1538788136 
int h =
            SPACE_TOP + nameDim.height
            + SPACE_MIDDLE + internalDim.height
            + SPACE_BOTTOM;
//#endif 


//#if -416858000 
int w =
            Math.max(nameDim.width + 2 * MARGIN,
                     internalDim.width + 2 * MARGIN);
//#endif 


//#if 1383518686 
return new Dimension(w, h);
//#endif 

} 

//#endif 


//#if 2075290490 
@Override
    protected void updateLayout(UmlChangeEvent event)
    { 

//#if 1827593879 
if(!(event instanceof RemoveAssociationEvent) ||
                !"subvertex".equals(event.getPropertyName()))//1
{ 

//#if -1109497403 
return;
//#endif 

} 

//#endif 


//#if 1655684803 
final Object removedRegion = event.getOldValue();
//#endif 


//#if 1767099947 
List<FigConcurrentRegion> regionFigs =
            ((List<FigConcurrentRegion>) getEnclosedFigs().clone());
//#endif 


//#if 1527669826 
int totHeight = getInitialHeight();
//#endif 


//#if -2146060640 
if(!regionFigs.isEmpty())//1
{ 

//#if -536125431 
Fig removedFig = null;
//#endif 


//#if -1144035961 
for (FigConcurrentRegion figRegion : regionFigs) //1
{ 

//#if -881331027 
if(figRegion.getOwner() == removedRegion)//1
{ 

//#if 1793188490 
removedFig = figRegion;
//#endif 


//#if -2053199269 
removeEnclosedFig(figRegion);
//#endif 


//#if -859878546 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1845452124 
if(removedFig != null)//1
{ 

//#if -1044199493 
regionFigs.remove(removedFig);
//#endif 


//#if 442658691 
if(!regionFigs.isEmpty())//1
{ 

//#if -1443641961 
for (FigConcurrentRegion figRegion : regionFigs) //1
{ 

//#if -1808234751 
if(figRegion.getY() > removedFig.getY())//1
{ 

//#if 418499247 
figRegion.displace(0, -removedFig.getHeight());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1500715413 
totHeight = getHeight() - removedFig.getHeight();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 393935088 
setBounds(getX(), getY(), getWidth(), totHeight);
//#endif 


//#if 1664681289 
renderingChanged();
//#endif 

} 

//#endif 


//#if -804431811 
public FigCompositeState(Object owner, Rectangle bounds,
                             DiagramSettings settings)
    { 

//#if -1967921876 
super(owner, bounds, settings);
//#endif 


//#if -1760694015 
initFigs();
//#endif 


//#if -2072396513 
updateNameText();
//#endif 

} 

//#endif 


//#if 1997789129 
public void setFillColor(Color col)
    { 

//#if -353419655 
cover.setFillColor(col);
//#endif 

} 

//#endif 


//#if 1197430058 
public Color getLineColor()
    { 

//#if -1351306130 
return cover.getLineColor();
//#endif 

} 

//#endif 


//#if 1084823437 
private void initFigs()
    { 

//#if 384384297 
cover =
            new FigRRect(getInitialX(), getInitialY(),
                         getInitialWidth(), getInitialHeight(),
                         LINE_COLOR, FILL_COLOR);
//#endif 


//#if -1671165398 
getBigPort().setLineWidth(0);
//#endif 


//#if 1364640858 
divider =
            new FigLine(getInitialX(),
                        getInitialY() + 2 + getNameFig().getBounds().height + 1,
                        getInitialWidth() - 1,
                        getInitialY() + 2 + getNameFig().getBounds().height + 1,
                        LINE_COLOR);
//#endif 


//#if -1305385983 
addFig(getBigPort());
//#endif 


//#if -792815002 
addFig(cover);
//#endif 


//#if -2134951975 
addFig(getNameFig());
//#endif 


//#if -961991160 
addFig(divider);
//#endif 


//#if -1962785053 
addFig(getInternal());
//#endif 


//#if -1631199509 
setBounds(getBounds());
//#endif 

} 

//#endif 


//#if -1241420711 
@Deprecated
    public void setBounds(int h)
    { 

//#if 415412072 
setCompositeStateHeight(h);
//#endif 

} 

//#endif 


//#if 903734931 
@Override
    public Vector<Fig> getEnclosedFigs()
    { 

//#if -1053864612 
Vector<Fig> enclosedFigs = super.getEnclosedFigs();
//#endif 


//#if -911116174 
if(isConcurrent())//1
{ 

//#if -240363782 
TreeMap<Integer, Fig> figsByY = new TreeMap<Integer, Fig>();
//#endif 


//#if 2076561553 
for (Fig fig : enclosedFigs) //1
{ 

//#if -487532283 
if(fig instanceof FigConcurrentRegion)//1
{ 

//#if 1651423028 
figsByY.put(fig.getY(), fig);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1633684865 
return new Vector<Fig>(figsByY.values());
//#endif 

} 

//#endif 


//#if 998807972 
return enclosedFigs;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

