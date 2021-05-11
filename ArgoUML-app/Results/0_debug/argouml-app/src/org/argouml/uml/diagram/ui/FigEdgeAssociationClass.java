
//#if -1050230832 
// Compilation Unit of /FigEdgeAssociationClass.java 
 

//#if -1457010530 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -702877404 
import java.awt.event.KeyListener;
//#endif 


//#if 1889616542 
import java.awt.event.MouseListener;
//#endif 


//#if 1887003753 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1947550079 
import java.beans.PropertyChangeListener;
//#endif 


//#if 257123760 
import java.beans.VetoableChangeListener;
//#endif 


//#if -374011467 
import org.apache.log4j.Logger;
//#endif 


//#if 2113299907 
import org.argouml.kernel.DelayedVChangeListener;
//#endif 


//#if 664901387 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1380894495 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1912868578 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 1921505085 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 1923360435 
import org.tigris.gef.presentation.FigPoly;
//#endif 


//#if 446296984 
public class FigEdgeAssociationClass extends 
//#if 406459256 
FigEdgeModelElement
//#endif 

 implements 
//#if 846893956 
VetoableChangeListener
//#endif 

, 
//#if 1341394164 
DelayedVChangeListener
//#endif 

, 
//#if 612826333 
MouseListener
//#endif 

, 
//#if -1464087145 
KeyListener
//#endif 

, 
//#if 624329173 
PropertyChangeListener
//#endif 

  { 

//#if -1771317471 
private static final long serialVersionUID = 4627163341288968877L;
//#endif 


//#if 1479540510 
private static final Logger LOG =
        Logger.getLogger(FigEdgeAssociationClass.class);
//#endif 


//#if -1599610739 
@Override
    public void setSourceFigNode(FigNode fn)
    { 

//#if -764442821 
if(!(fn instanceof FigEdgePort || fn instanceof FigNodeAssociation))//1
{ 

//#if -1091593958 
throw new IllegalArgumentException(
                "The source of an association class dashed link can "
                + "only be a FigEdgePort");
//#endif 

} 

//#endif 


//#if -952126885 
super.setSourceFigNode(fn);
//#endif 

} 

//#endif 


//#if -1674718878 
FigEdgeAssociationClass(FigClassAssociationClass classBoxFig,
                            FigAssociationClass ownerFig, DiagramSettings settings)
    { 

//#if 2041784026 
super(ownerFig.getOwner(), settings);
//#endif 


//#if 1109326631 
constructFigs(classBoxFig, ownerFig);
//#endif 

} 

//#endif 


//#if -351662956 
@Override
    public void setDestFigNode(FigNode fn)
    { 

//#if 1556499932 
if(!(fn instanceof FigClassAssociationClass))//1
{ 

//#if 1359783937 
throw new IllegalArgumentException(
                "The dest of an association class dashed link can "
                + "only be a FigClassAssociationClass");
//#endif 

} 

//#endif 


//#if 505150705 
super.setDestFigNode(fn);
//#endif 

} 

//#endif 


//#if -1890341901 
@Deprecated
    public FigEdgeAssociationClass(FigClassAssociationClass classBoxFig,
                                   FigAssociationClass ownerFig)
    { 

//#if 1345124197 
this();
//#endif 


//#if 1334319927 
constructFigs(classBoxFig, ownerFig);
//#endif 

} 

//#endif 


//#if 1316340623 
@Override
    protected boolean canEdit(Fig f)
    { 

//#if -463010308 
return false;
//#endif 

} 

//#endif 


//#if 203297198 
@Override
    protected void modelChanged(PropertyChangeEvent e)
    { 
} 

//#endif 


//#if 39389397 
public FigEdgeAssociationClass(FigClassAssociationClass classBoxFig,
                                   FigNodeAssociation ownerFig, DiagramSettings settings)
    { 

//#if 1269463631 
super(ownerFig.getOwner(), settings);
//#endif 


//#if 337006236 
constructFigs(classBoxFig, ownerFig);
//#endif 

} 

//#endif 


//#if -654281094 
@Override
    protected Fig getRemoveDelegate()
    { 

//#if -194783395 
FigNode node = getDestFigNode();
//#endif 


//#if 2020054252 
if(!(node instanceof FigEdgePort || node instanceof FigNodeAssociation))//1
{ 

//#if 425336786 
node = getSourceFigNode();
//#endif 

} 

//#endif 


//#if -1645453755 
if(!(node instanceof FigEdgePort || node instanceof FigNodeAssociation))//2
{ 

//#if -670836894 
LOG.warn("The is no FigEdgePort attached"
                     + " to the association class link");
//#endif 


//#if 1812243924 
return null;
//#endif 

} 

//#endif 


//#if 230819758 
final Fig delegate;
//#endif 


//#if 1381686059 
if(node instanceof FigEdgePort)//1
{ 

//#if -1453801117 
delegate = node.getGroup();
//#endif 

} 
else
{ 

//#if 2131535061 
delegate = node;
//#endif 

} 

//#endif 


//#if -776453865 
if(LOG.isInfoEnabled())//1
{ 

//#if -1295757326 
LOG.info("Delegating remove to " + delegate.getClass().getName());
//#endif 

} 

//#endif 


//#if 677604588 
return delegate;
//#endif 

} 

//#endif 


//#if 1958850679 
private void constructFigs(FigClassAssociationClass classBoxFig,
                               Fig ownerFig)
    { 

//#if 1533175740 
LOG.info("FigEdgeAssociationClass constructor");
//#endif 


//#if -2114258759 
if(classBoxFig == null)//1
{ 

//#if 250162243 
throw new IllegalArgumentException("No class box found while "
                                               + "creating FigEdgeAssociationClass");
//#endif 

} 

//#endif 


//#if 1391230951 
if(ownerFig == null)//1
{ 

//#if 245298045 
throw new IllegalArgumentException("No association edge found "
                                               + "while creating FigEdgeAssociationClass");
//#endif 

} 

//#endif 


//#if 904483393 
setDestFigNode(classBoxFig);
//#endif 


//#if 1443057438 
setDestPortFig(classBoxFig);
//#endif 


//#if -1302869562 
final FigNode port;
//#endif 


//#if 1098621720 
if(ownerFig instanceof FigEdgeModelElement)//1
{ 

//#if -2030635564 
((FigEdgeModelElement) ownerFig).makeEdgePort();
//#endif 


//#if 1524684606 
port = ((FigEdgeModelElement) ownerFig).getEdgePort();
//#endif 

} 
else
{ 

//#if 444971634 
port = (FigNode) ownerFig;
//#endif 

} 

//#endif 


//#if 170273713 
setSourcePortFig(port);
//#endif 


//#if -1669326354 
setSourceFigNode(port);
//#endif 


//#if -1849557372 
computeRoute();
//#endif 

} 

//#endif 


//#if -1503040103 

//#if 2020281233 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigEdgeAssociationClass()
    { 

//#if 1481499257 
setBetweenNearestPoints(true);
//#endif 


//#if 267141582 
((FigPoly) getFig()).setRectilinear(false);
//#endif 


//#if -459839231 
setDashed(true);
//#endif 

} 

//#endif 


//#if 1083664814 
@Override
    public void setFig(Fig f)
    { 

//#if 1877727990 
super.setFig(f);
//#endif 


//#if 57057219 
getFig().setDashed(true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

