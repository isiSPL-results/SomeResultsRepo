package org.argouml.uml.diagram.static_structure.ui;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import org.argouml.model.Model;
import org.argouml.notation.NotationProvider;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.CompartmentFigText;
import org.tigris.gef.base.Selection;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.Handle;
public abstract class FigFeature extends CompartmentFigText
  { 
private static final String EVENT_NAME = "ownerScope";
public FigFeature(Object owner, Rectangle bounds,
                      DiagramSettings settings)
    { 
super(owner, bounds, settings);
updateOwnerScope(Model.getFacade().isStatic(owner));
Model.getPump().addModelEventListener(this, owner, EVENT_NAME);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigFeature(int x, int y, int w, int h, Fig aFig,
                      NotationProvider np)
    { 
super(x, y, w, h, aFig, np);
} 
@Override
    public void removeFromDiagram()
    { 
Model.getPump().removeModelEventListener(this, getOwner(),
                EVENT_NAME);
super.removeFromDiagram();
} 
@Deprecated
    public FigFeature(Object owner, Rectangle bounds, DiagramSettings settings,
                      NotationProvider np)
    { 
super(owner, bounds, settings, np);
updateOwnerScope(Model.getFacade().isStatic(owner));
Model.getPump().addModelEventListener(this, owner, EVENT_NAME);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    @Override
    public void setOwner(Object owner)
    { 
super.setOwner(owner);
if(owner != null)//1
{ 
updateOwnerScope(Model.getFacade().isStatic(owner));
Model.getPump().addModelEventListener(this, owner, EVENT_NAME);
} 
} 
@Override
    public void setFilled(boolean filled)
    { 
super.setFilled(false);
} 
@Override
    public void propertyChange(PropertyChangeEvent pce)
    { 
super.propertyChange(pce);
if(EVENT_NAME.equals(pce.getPropertyName()))//1
{ 
updateOwnerScope(Model.getScopeKind().getClassifier().equals(
                                 pce.getNewValue()));
} 
} 
protected void updateOwnerScope(boolean isClassifier)
    { 
setUnderline(isClassifier);
} 
@Override
    public void setTextFilled(boolean filled)
    { 
super.setTextFilled(false);
} 
@Override
    public Selection makeSelection()
    { 
return new SelectionFeature(this);
} 
private static class SelectionFeature extends Selection
  { 
private static final long serialVersionUID = 7437255966804296937L;
public void hitHandle(Rectangle r, Handle h)
        { 
} 
public void dragHandle(int mx, int my, int anX, int anY, Handle h)
        { 
} 
public SelectionFeature(Fig f)
        { 
super(f);
} 

 } 

 } 
