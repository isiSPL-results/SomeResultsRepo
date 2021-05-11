// Compilation Unit of /FigEdgeAssociationClass.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import org.apache.log4j.Logger;
import org.argouml.kernel.DelayedVChangeListener;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigEdge;
import org.tigris.gef.presentation.FigNode;
import org.tigris.gef.presentation.FigPoly;
public class FigEdgeAssociationClass extends FigEdgeModelElement
 implements VetoableChangeListener
, DelayedVChangeListener
, MouseListener
, KeyListener
, PropertyChangeListener
  { 
private static final long serialVersionUID = 4627163341288968877L;
private static final Logger LOG =
        Logger.getLogger(FigEdgeAssociationClass.class);
@Override
    public void setSourceFigNode(FigNode fn)
    { 
if(!(fn instanceof FigEdgePort || fn instanceof FigNodeAssociation))//1
{ 
throw new IllegalArgumentException(
                "The source of an association class dashed link can "
                + "only be a FigEdgePort");
} 

super.setSourceFigNode(fn);
} 

FigEdgeAssociationClass(FigClassAssociationClass classBoxFig,
                            FigAssociationClass ownerFig, DiagramSettings settings)
    { 
super(ownerFig.getOwner(), settings);
constructFigs(classBoxFig, ownerFig);
} 

@Override
    public void setDestFigNode(FigNode fn)
    { 
if(!(fn instanceof FigClassAssociationClass))//1
{ 
throw new IllegalArgumentException(
                "The dest of an association class dashed link can "
                + "only be a FigClassAssociationClass");
} 

super.setDestFigNode(fn);
} 

@Deprecated
    public FigEdgeAssociationClass(FigClassAssociationClass classBoxFig,
                                   FigAssociationClass ownerFig)
    { 
this();
constructFigs(classBoxFig, ownerFig);
} 

@Override
    protected boolean canEdit(Fig f)
    { 
return false;
} 

@Override
    protected void modelChanged(PropertyChangeEvent e)
    { 
} 

public FigEdgeAssociationClass(FigClassAssociationClass classBoxFig,
                                   FigNodeAssociation ownerFig, DiagramSettings settings)
    { 
super(ownerFig.getOwner(), settings);
constructFigs(classBoxFig, ownerFig);
} 

@Override
    protected Fig getRemoveDelegate()
    { 
FigNode node = getDestFigNode();
if(!(node instanceof FigEdgePort || node instanceof FigNodeAssociation))//1
{ 
node = getSourceFigNode();
} 

if(!(node instanceof FigEdgePort || node instanceof FigNodeAssociation))//2
{ 
LOG.warn("The is no FigEdgePort attached"
                     + " to the association class link");
return null;
} 

final Fig delegate;
if(node instanceof FigEdgePort)//1
{ 
delegate = node.getGroup();
} 
else
{ 
delegate = node;
} 

if(LOG.isInfoEnabled())//1
{ 
LOG.info("Delegating remove to " + delegate.getClass().getName());
} 

return delegate;
} 

private void constructFigs(FigClassAssociationClass classBoxFig,
                               Fig ownerFig)
    { 
LOG.info("FigEdgeAssociationClass constructor");
if(classBoxFig == null)//1
{ 
throw new IllegalArgumentException("No class box found while "
                                               + "creating FigEdgeAssociationClass");
} 

if(ownerFig == null)//1
{ 
throw new IllegalArgumentException("No association edge found "
                                               + "while creating FigEdgeAssociationClass");
} 

setDestFigNode(classBoxFig);
setDestPortFig(classBoxFig);
final FigNode port;
if(ownerFig instanceof FigEdgeModelElement)//1
{ 
((FigEdgeModelElement) ownerFig).makeEdgePort();
port = ((FigEdgeModelElement) ownerFig).getEdgePort();
} 
else
{ 
port = (FigNode) ownerFig;
} 

setSourcePortFig(port);
setSourceFigNode(port);
computeRoute();
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigEdgeAssociationClass()
    { 
setBetweenNearestPoints(true);
((FigPoly) getFig()).setRectilinear(false);
setDashed(true);
} 

@Override
    public void setFig(Fig f)
    { 
super.setFig(f);
getFig().setDashed(true);
} 

 } 


