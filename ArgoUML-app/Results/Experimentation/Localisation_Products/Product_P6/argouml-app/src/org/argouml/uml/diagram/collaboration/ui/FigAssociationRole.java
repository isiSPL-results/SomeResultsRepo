package org.argouml.uml.diagram.collaboration.ui;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.argouml.notation.NotationProviderFactory2;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.ArgoFig;
import org.argouml.uml.diagram.ui.ArgoFigGroup;
import org.argouml.uml.diagram.ui.FigAssociation;
import org.argouml.uml.diagram.ui.FigMessage;
import org.argouml.uml.diagram.ui.PathItemPlacement;
import org.tigris.gef.base.Layer;
import org.tigris.gef.presentation.Fig;
class FigMessageGroup extends ArgoFigGroup
  { 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigMessageGroup(List<ArgoFig> figs)
    { 
super(figs);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigMessageGroup()
    { 
super();
} 
private void updateFigPositions()
    { 
Collection figs = getFigs();
Iterator it = figs.iterator();
if(!figs.isEmpty())//1
{ 
FigMessage previousFig = null;
for (int i = 0; it.hasNext(); i++) //1
{ 
FigMessage figMessage = (FigMessage) it.next();
int y;
if(i != 0)//1
{ 
y = previousFig.getY() + previousFig.getHeight() + 5;
} 
else
{ 
y = getY();
} 
figMessage.setLocation(getX(), y);
figMessage.endTrans();
previousFig = figMessage;
} 
} 
} 
public void calcBounds()
    { 
super.calcBounds();
Collection figs = getFigs();
if(!figs.isEmpty())//1
{ 
Fig last = null;
Fig first = null;
_w = 0;
Iterator it = figs.iterator();
int size = figs.size();
for (int i = 0; i < size; i++) //1
{ 
Fig fig = (Fig) it.next();
if(i == 0)//1
{ 
first = fig;
} 
if(i == size - 1)//1
{ 
last = fig;
} 
if(fig.getWidth() > _w)//1
{ 
_w = fig.getWidth();
} 
} 
_h = last.getY() + last.getHeight() - first.getY();
} 
else
{ 
_w = 0;
_h = 0;
} 
} 
void updateArrows()
    { 
for (FigMessage fm : (List<FigMessage>) getFigs()) //1
{ 
fm.updateArrow();
} 
} 
@Override
    public void addFig(Fig f)
    { 
super.addFig(f);
updateFigPositions();
updateArrows();
calcBounds();
} 
public FigMessageGroup(Object owner, DiagramSettings settings)
    { 
super(owner, settings);
} 

 } 
public class FigAssociationRole extends FigAssociation
  { 
private FigMessageGroup messages;
protected int getNotationProviderType()
    { 
return NotationProviderFactory2.TYPE_ASSOCIATION_ROLE;
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigAssociationRole()
    { 
super();
messages = new FigMessageGroup();
addPathItem(messages, new PathItemPlacement(this, messages, 50, 10));
} 
public void addMessage(FigMessage message)
    { 
messages.addFig(message);
updatePathItemLocations();
messages.damage();
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigAssociationRole(Object edge, Layer lay)
    { 
this();
setLayer(lay);
setOwner(edge);
} 
public FigAssociationRole(Object owner, DiagramSettings settings)
    { 
super(owner, settings);
messages = new FigMessageGroup(owner, settings);
addPathItem(messages, new PathItemPlacement(this, messages, 50, 10));
} 
@Override
    public void computeRouteImpl()
    { 
super.computeRouteImpl();
messages.updateArrows();
} 

 } 
