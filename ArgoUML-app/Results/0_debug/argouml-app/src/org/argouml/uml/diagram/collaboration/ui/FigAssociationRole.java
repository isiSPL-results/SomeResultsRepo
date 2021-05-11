
//#if 836255293 
// Compilation Unit of /FigAssociationRole.java 
 

//#if -1080045765 
package org.argouml.uml.diagram.collaboration.ui;
//#endif 


//#if -1533221789 
import java.util.Collection;
//#endif 


//#if -1758343661 
import java.util.Iterator;
//#endif 


//#if 1147494115 
import java.util.List;
//#endif 


//#if -595375189 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if -915879279 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -342361506 
import org.argouml.uml.diagram.ui.ArgoFig;
//#endif 


//#if 296790393 
import org.argouml.uml.diagram.ui.ArgoFigGroup;
//#endif 


//#if -1735964400 
import org.argouml.uml.diagram.ui.FigAssociation;
//#endif 


//#if 1249943882 
import org.argouml.uml.diagram.ui.FigMessage;
//#endif 


//#if 407266460 
import org.argouml.uml.diagram.ui.PathItemPlacement;
//#endif 


//#if 669402081 
import org.tigris.gef.base.Layer;
//#endif 


//#if -1486036827 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1090387801 
class FigMessageGroup extends 
//#if -813211919 
ArgoFigGroup
//#endif 

  { 

//#if 941183924 

//#if -99696710 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigMessageGroup(List<ArgoFig> figs)
    { 

//#if -581743050 
super(figs);
//#endif 

} 

//#endif 


//#if 1738880574 

//#if 1440144226 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigMessageGroup()
    { 

//#if -913579520 
super();
//#endif 

} 

//#endif 


//#if 636938346 
private void updateFigPositions()
    { 

//#if 1642357090 
Collection figs = getFigs();
//#endif 


//#if 2030440430 
Iterator it = figs.iterator();
//#endif 


//#if 972305766 
if(!figs.isEmpty())//1
{ 

//#if -426909212 
FigMessage previousFig = null;
//#endif 


//#if 1815800371 
for (int i = 0; it.hasNext(); i++) //1
{ 

//#if -788179884 
FigMessage figMessage = (FigMessage) it.next();
//#endif 


//#if 1463171308 
int y;
//#endif 


//#if -1633097799 
if(i != 0)//1
{ 

//#if -2134012796 
y = previousFig.getY() + previousFig.getHeight() + 5;
//#endif 

} 
else
{ 

//#if 41857629 
y = getY();
//#endif 

} 

//#endif 


//#if -1698736039 
figMessage.setLocation(getX(), y);
//#endif 


//#if -1780063449 
figMessage.endTrans();
//#endif 


//#if 987872259 
previousFig = figMessage;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 362281381 
public void calcBounds()
    { 

//#if 2003702047 
super.calcBounds();
//#endif 


//#if 105703463 
Collection figs = getFigs();
//#endif 


//#if -718426943 
if(!figs.isEmpty())//1
{ 

//#if -311594074 
Fig last = null;
//#endif 


//#if -226133202 
Fig first = null;
//#endif 


//#if -373466555 
_w = 0;
//#endif 


//#if 578132806 
Iterator it = figs.iterator();
//#endif 


//#if 2104115506 
int size = figs.size();
//#endif 


//#if 2047159278 
for (int i = 0; i < size; i++) //1
{ 

//#if 1650689961 
Fig fig = (Fig) it.next();
//#endif 


//#if 1131669221 
if(i == 0)//1
{ 

//#if 2039399266 
first = fig;
//#endif 

} 

//#endif 


//#if -2120149152 
if(i == size - 1)//1
{ 

//#if -844223995 
last = fig;
//#endif 

} 

//#endif 


//#if 178214925 
if(fig.getWidth() > _w)//1
{ 

//#if 835212609 
_w = fig.getWidth();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1659741994 
_h = last.getY() + last.getHeight() - first.getY();
//#endif 

} 
else
{ 

//#if -1988267349 
_w = 0;
//#endif 


//#if -1988714214 
_h = 0;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 133679813 
void updateArrows()
    { 

//#if 1066909934 
for (FigMessage fm : (List<FigMessage>) getFigs()) //1
{ 

//#if -1017965390 
fm.updateArrow();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1370921902 
@Override
    public void addFig(Fig f)
    { 

//#if -504191628 
super.addFig(f);
//#endif 


//#if -1274816131 
updateFigPositions();
//#endif 


//#if -1323680519 
updateArrows();
//#endif 


//#if -877207454 
calcBounds();
//#endif 

} 

//#endif 


//#if 2069396282 
public FigMessageGroup(Object owner, DiagramSettings settings)
    { 

//#if -262237297 
super(owner, settings);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -276238451 
public class FigAssociationRole extends 
//#if -449973286 
FigAssociation
//#endif 

  { 

//#if 1991499641 
private FigMessageGroup messages;
//#endif 


//#if 1664046534 
protected int getNotationProviderType()
    { 

//#if 503514427 
return NotationProviderFactory2.TYPE_ASSOCIATION_ROLE;
//#endif 

} 

//#endif 


//#if 395576851 

//#if 726069188 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigAssociationRole()
    { 

//#if 593393714 
super();
//#endif 


//#if 338718944 
messages = new FigMessageGroup();
//#endif 


//#if -1457323654 
addPathItem(messages, new PathItemPlacement(this, messages, 50, 10));
//#endif 

} 

//#endif 


//#if 348977197 
public void addMessage(FigMessage message)
    { 

//#if -605049905 
messages.addFig(message);
//#endif 


//#if -1166123388 
updatePathItemLocations();
//#endif 


//#if 2100734544 
messages.damage();
//#endif 

} 

//#endif 


//#if -356542084 

//#if -758734763 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigAssociationRole(Object edge, Layer lay)
    { 

//#if 1448875373 
this();
//#endif 


//#if 1403825900 
setLayer(lay);
//#endif 


//#if 2041489847 
setOwner(edge);
//#endif 

} 

//#endif 


//#if 645485335 
public FigAssociationRole(Object owner, DiagramSettings settings)
    { 

//#if -1989916818 
super(owner, settings);
//#endif 


//#if -102398052 
messages = new FigMessageGroup(owner, settings);
//#endif 


//#if -1004627782 
addPathItem(messages, new PathItemPlacement(this, messages, 50, 10));
//#endif 

} 

//#endif 


//#if -1274982401 
@Override
    public void computeRouteImpl()
    { 

//#if 727013756 
super.computeRouteImpl();
//#endif 


//#if 213375326 
messages.updateArrows();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

