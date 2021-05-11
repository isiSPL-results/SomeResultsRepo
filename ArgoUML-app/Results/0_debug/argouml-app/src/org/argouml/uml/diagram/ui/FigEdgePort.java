
//#if 1702070983 
// Compilation Unit of /FigEdgePort.java 
 

//#if -377842686 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -383679312 
import java.awt.Rectangle;
//#endif 


//#if -1907725201 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1271218307 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1518772333 
import org.tigris.gef.presentation.FigCircle;
//#endif 


//#if 1863792198 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 139145606 
public class FigEdgePort extends 
//#if 1400375032 
FigNodeModelElement
//#endif 

  { 

//#if -1050149748 
private FigCircle bigPort;
//#endif 


//#if -1579427315 
private static final long serialVersionUID = 3091219503512470458L;
//#endif 


//#if -945857612 
@Override
    @Deprecated
    public void setOwner(Object own)
    { 

//#if -1205338792 
bigPort.setOwner(own);
//#endif 


//#if 1078692542 
super.setOwner(own);
//#endif 

} 

//#endif 


//#if 999822197 
@Override
    public boolean isSelectable()
    { 

//#if 296285668 
return false;
//#endif 

} 

//#endif 


//#if -122567503 
@Override
    public Object getOwner()
    { 

//#if -87718549 
if(super.getOwner() != null)//1
{ 

//#if -183313460 
return super.getOwner();
//#endif 

} 

//#endif 


//#if -788026441 
Fig group = this;
//#endif 


//#if -1109959451 
while (group != null && !(group instanceof FigEdge)) //1
{ 

//#if -1835271520 
group = group.getGroup();
//#endif 

} 

//#endif 


//#if -628255105 
if(group == null)//1
{ 

//#if 1457397993 
return null;
//#endif 

} 
else
{ 

//#if -1410373473 
return group.getOwner();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -378394979 
@Override
    public boolean hit(Rectangle r)
    { 

//#if -1658367593 
return false;
//#endif 

} 

//#endif 


//#if 491708239 
@Override
    public String classNameAndBounds()
    { 

//#if 1238308722 
return getClass().getName()
               + "[" + getX() + ", " + getY() + ", "
               + getWidth() + ", " + getHeight() + "]";
//#endif 

} 

//#endif 


//#if -528818424 
public Fig getPortFig(Object port)
    { 

//#if 33381655 
return bigPort;
//#endif 

} 

//#endif 


//#if 1100643299 
@Override
    public Object hitPort(int x, int y)
    { 

//#if -788136425 
return null;
//#endif 

} 

//#endif 


//#if 119540232 

//#if 590075982 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigEdgePort()
    { 

//#if 853006055 
super();
//#endif 


//#if -2109631006 
initialize();
//#endif 

} 

//#endif 


//#if 1811221600 
public FigEdgePort(Object owner, Rectangle bounds,
                       DiagramSettings settings)
    { 

//#if -708085019 
super(owner, bounds, settings);
//#endif 


//#if -1254563799 
initialize();
//#endif 

} 

//#endif 


//#if -1770146209 
@Override
    public Fig hitFig(Rectangle r)
    { 

//#if 1801332049 
return null;
//#endif 

} 

//#endif 


//#if 767665255 
private void initialize()
    { 

//#if 1316271627 
invisibleAllowed = true;
//#endif 


//#if -1480763577 
bigPort = new FigCircle(0, 0, 1, 1, LINE_COLOR, FILL_COLOR);
//#endif 


//#if -38386 
addFig(bigPort);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

