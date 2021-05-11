
//#if 1522866475 
// Compilation Unit of /FigDependency.java 
 

//#if 1556840909 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 414476177 
import java.awt.Color;
//#endif 


//#if 770650647 
import java.awt.Graphics;
//#endif 


//#if -125435462 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -1875163446 
import org.tigris.gef.base.Layer;
//#endif 


//#if 342644393 
import org.tigris.gef.presentation.ArrowHead;
//#endif 


//#if -1312249485 
import org.tigris.gef.presentation.ArrowHeadGreater;
//#endif 


//#if -1375448882 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 425297534 
public class FigDependency extends 
//#if -1797488105 
FigEdgeModelElement
//#endif 

  { 

//#if 1442132880 
private static final long serialVersionUID = -1779182458484724448L;
//#endif 


//#if 470646917 
private FigTextGroup middleGroup;
//#endif 


//#if 1087297773 
private void constructFigs()
    { 

//#if 210707896 
middleGroup.addFig(getNameFig());
//#endif 


//#if -849792463 
middleGroup.addFig(getStereotypeFig());
//#endif 


//#if 176684780 
addPathItem(middleGroup,
                    new PathItemPlacement(this, middleGroup, 50, 25));
//#endif 


//#if -253637407 
setDestArrowHead(createEndArrow());
//#endif 


//#if -1552978804 
setBetweenNearestPoints(true);
//#endif 


//#if -426341643 
getFig().setDashed(true);
//#endif 

} 

//#endif 


//#if 170744725 
@Override
    protected void updateNameText()
    { 

//#if -1515821781 
super.updateNameText();
//#endif 


//#if 816498385 
middleGroup.calcBounds();
//#endif 

} 

//#endif 


//#if 1248190925 
@Override
    public void setFig(Fig f)
    { 

//#if 258810844 
super.setFig(f);
//#endif 


//#if 1725036957 
getFig().setDashed(true);
//#endif 

} 

//#endif 


//#if -2055329661 
protected ArrowHead createEndArrow()
    { 

//#if 743186722 
return new ArrowHeadGreater();
//#endif 

} 

//#endif 


//#if 1647622800 
@Override
    protected boolean canEdit(Fig f)
    { 

//#if -262745285 
return false;
//#endif 

} 

//#endif 


//#if -288718265 
public FigDependency(Object owner, DiagramSettings settings)
    { 

//#if -348903748 
super(owner, settings);
//#endif 


//#if 1860601852 
middleGroup = new FigTextGroup(owner, settings);
//#endif 


//#if 2038184053 
constructFigs();
//#endif 

} 

//#endif 


//#if 807667687 

//#if 184710098 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigDependency(Object dependency)
    { 

//#if -1282290440 
this();
//#endif 


//#if 1532716560 
setOwner(dependency);
//#endif 

} 

//#endif 


//#if 1353537020 
@Override
    protected void updateStereotypeText()
    { 

//#if -79996767 
super.updateStereotypeText();
//#endif 


//#if 1964707342 
middleGroup.calcBounds();
//#endif 

} 

//#endif 


//#if -1564966648 
public void setLineColor(Color color)
    { 

//#if 1750977963 
ArrowHead arrow = getDestArrowHead();
//#endif 


//#if 1974651112 
if(arrow != null)//1
{ 

//#if 535136655 
arrow.setLineColor(getLineColor());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -556608879 

//#if 655523098 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigDependency()
    { 

//#if -687539799 
super();
//#endif 


//#if -2103253463 
middleGroup = new FigTextGroup();
//#endif 


//#if 593316318 
constructFigs();
//#endif 

} 

//#endif 


//#if 433895180 

//#if 1540627870 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigDependency(Object dependency, Layer lay)
    { 

//#if -233142963 
this();
//#endif 


//#if 370959781 
setOwner(dependency);
//#endif 


//#if 766157580 
setLayer(lay);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

