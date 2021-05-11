
//#if -2017308330 
// Compilation Unit of /FigSignal.java 
 

//#if -550345363 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -176480835 
import java.awt.Rectangle;
//#endif 


//#if 1795486305 
import java.awt.event.MouseEvent;
//#endif 


//#if -1916822510 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -943353459 
import java.util.Vector;
//#endif 


//#if 1511918597 
import org.argouml.model.AssociationChangeEvent;
//#endif 


//#if -1544553888 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if -1528500862 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 566024119 
import org.tigris.gef.base.Selection;
//#endif 


//#if 364282315 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1791899357 
public class FigSignal extends 
//#if -657925205 
FigClassifierBoxWithAttributes
//#endif 

  { 

//#if 932752592 

//#if 427205831 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigSignal(@SuppressWarnings("unused") GraphModel gm, Object node)
    { 

//#if 1140312907 
this();
//#endif 


//#if -1575820134 
setOwner(node);
//#endif 

} 

//#endif 


//#if 1273154392 
private void constructFigs()
    { 

//#if -587037184 
getStereotypeFig().setKeyword("signal");
//#endif 


//#if 839511101 
addFig(getBigPort());
//#endif 


//#if 1386861262 
addFig(getStereotypeFig());
//#endif 


//#if 9945109 
addFig(getNameFig());
//#endif 


//#if -1958969132 
addFig(getOperationsFig());
//#endif 


//#if 1601130761 
addFig(getAttributesFig());
//#endif 


//#if 1243030891 
addFig(borderFig);
//#endif 


//#if -1737466985 
setOperationsVisible(false);
//#endif 


//#if 1727932108 
setAttributesVisible(false);
//#endif 

} 

//#endif 


//#if 625904285 
public FigSignal(Object owner, Rectangle bounds, DiagramSettings settings)
    { 

//#if -2063076830 
super(owner, bounds, settings);
//#endif 


//#if -863744232 
constructFigs();
//#endif 

} 

//#endif 


//#if 1863508402 
@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if -2071512422 
super.modelChanged(mee);
//#endif 


//#if -1398838797 
if(mee instanceof AssociationChangeEvent
                || mee instanceof AttributeChangeEvent)//1
{ 

//#if -95706721 
renderingChanged();
//#endif 


//#if 179476025 
updateListeners(getOwner(), getOwner());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1432115417 

//#if -1337756836 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigSignal()
    { 

//#if 1564913532 
super();
//#endif 


//#if 1870757041 
constructFigs();
//#endif 

} 

//#endif 


//#if -1077650304 
@Override
    public Selection makeSelection()
    { 

//#if 432941856 
return new SelectionSignal(this);
//#endif 

} 

//#endif 


//#if 981796523 
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 

//#if 56767486 
Vector popUpActions = super.getPopUpActions(me);
//#endif 


//#if 1027247217 
return popUpActions;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

