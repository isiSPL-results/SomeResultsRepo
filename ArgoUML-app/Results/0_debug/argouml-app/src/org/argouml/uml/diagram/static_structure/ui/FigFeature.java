
//#if 1175603339 
// Compilation Unit of /FigFeature.java 
 

//#if -1528599115 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -1071517691 
import java.awt.Rectangle;
//#endif 


//#if 529875546 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -23940009 
import org.argouml.model.Model;
//#endif 


//#if 807070492 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -1498294214 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 2099224183 
import org.argouml.uml.diagram.ui.CompartmentFigText;
//#endif 


//#if 922044527 
import org.tigris.gef.base.Selection;
//#endif 


//#if -2035374258 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 2067532060 
import org.tigris.gef.presentation.Handle;
//#endif 


//#if -1677400895 
public abstract class FigFeature extends 
//#if 1178373585 
CompartmentFigText
//#endif 

  { 

//#if -468749033 
private static final String EVENT_NAME = "ownerScope";
//#endif 


//#if -943178709 
public FigFeature(Object owner, Rectangle bounds,
                      DiagramSettings settings)
    { 

//#if -1070123226 
super(owner, bounds, settings);
//#endif 


//#if 563202168 
updateOwnerScope(Model.getFacade().isStatic(owner));
//#endif 


//#if 1171571731 
Model.getPump().addModelEventListener(this, owner, EVENT_NAME);
//#endif 

} 

//#endif 


//#if 1370725173 

//#if -1937373693 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigFeature(int x, int y, int w, int h, Fig aFig,
                      NotationProvider np)
    { 

//#if 1937123619 
super(x, y, w, h, aFig, np);
//#endif 

} 

//#endif 


//#if 682842415 
@Override
    public void removeFromDiagram()
    { 

//#if -1880672592 
Model.getPump().removeModelEventListener(this, getOwner(),
                EVENT_NAME);
//#endif 


//#if -914764027 
super.removeFromDiagram();
//#endif 

} 

//#endif 


//#if 1369270613 
@Deprecated
    public FigFeature(Object owner, Rectangle bounds, DiagramSettings settings,
                      NotationProvider np)
    { 

//#if -1587013285 
super(owner, bounds, settings, np);
//#endif 


//#if 272475687 
updateOwnerScope(Model.getFacade().isStatic(owner));
//#endif 


//#if 208001860 
Model.getPump().addModelEventListener(this, owner, EVENT_NAME);
//#endif 

} 

//#endif 


//#if -209497724 

//#if -1796019446 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    public void setOwner(Object owner)
    { 

//#if -2088983536 
super.setOwner(owner);
//#endif 


//#if -1222289982 
if(owner != null)//1
{ 

//#if 1739517184 
updateOwnerScope(Model.getFacade().isStatic(owner));
//#endif 


//#if -1421592437 
Model.getPump().addModelEventListener(this, owner, EVENT_NAME);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -764668422 
@Override
    public void setFilled(boolean filled)
    { 

//#if 123838068 
super.setFilled(false);
//#endif 

} 

//#endif 


//#if 363099904 
@Override
    public void propertyChange(PropertyChangeEvent pce)
    { 

//#if -164760510 
super.propertyChange(pce);
//#endif 


//#if -1450657346 
if(EVENT_NAME.equals(pce.getPropertyName()))//1
{ 

//#if -1057194940 
updateOwnerScope(Model.getScopeKind().getClassifier().equals(
                                 pce.getNewValue()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1778634012 
protected void updateOwnerScope(boolean isClassifier)
    { 

//#if -824844586 
setUnderline(isClassifier);
//#endif 

} 

//#endif 


//#if 1329609805 
@Override
    public void setTextFilled(boolean filled)
    { 

//#if -111744101 
super.setTextFilled(false);
//#endif 

} 

//#endif 


//#if 1223815318 
@Override
    public Selection makeSelection()
    { 

//#if -1250491547 
return new SelectionFeature(this);
//#endif 

} 

//#endif 


//#if 380319587 
private static class SelectionFeature extends 
//#if 229155144 
Selection
//#endif 

  { 

//#if -1398777211 
private static final long serialVersionUID = 7437255966804296937L;
//#endif 


//#if 1467540228 
public void hitHandle(Rectangle r, Handle h)
        { 
} 

//#endif 


//#if 2129298518 
public void dragHandle(int mx, int my, int anX, int anY, Handle h)
        { 
} 

//#endif 


//#if -1146314506 
public SelectionFeature(Fig f)
        { 

//#if -2088777448 
super(f);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

