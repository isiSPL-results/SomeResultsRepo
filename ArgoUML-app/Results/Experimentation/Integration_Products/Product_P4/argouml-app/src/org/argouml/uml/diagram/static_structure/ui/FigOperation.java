package org.argouml.uml.diagram.static_structure.ui;
import java.awt.Font;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import org.argouml.model.Model;
import org.argouml.notation.NotationProvider;
import org.argouml.notation.NotationProviderFactory2;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.presentation.Fig;
public class FigOperation extends FigFeature
  { 
public FigOperation(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 
super(owner, bounds, settings);
Model.getPump().addModelEventListener(this, owner, "isAbstract");
} 
@Override
    public void removeFromDiagram()
    { 
Model.getPump().removeModelEventListener(this, getOwner(),
                "isAbstract");
super.removeFromDiagram();
} 
@SuppressWarnings("deprecation")

    @Deprecated
    @Override
    public void setOwner(Object owner)
    { 
super.setOwner(owner);
if(owner != null)//1
{ 
diagramFontChanged(null);
Model.getPump().addModelEventListener(this, owner, "isAbstract");
} 
} 
@Override
    protected int getNotationProviderType()
    { 
return NotationProviderFactory2.TYPE_OPERATION;
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigOperation(Object owner, Rectangle bounds,
                        DiagramSettings settings, NotationProvider np)
    { 
super(owner, bounds, settings, np);
Model.getPump().addModelEventListener(this, owner, "isAbstract");
} 
@Override
    protected int getFigFontStyle()
    { 
return Model.getFacade().isAbstract(getOwner())
               ? Font.ITALIC : Font.PLAIN;
} 
@Override
    public void propertyChange(PropertyChangeEvent pce)
    { 
super.propertyChange(pce);
if("isAbstract".equals(pce.getPropertyName()))//1
{ 
renderingChanged();
} 
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigOperation(int x, int y, int w, int h, Fig aFig,
                        NotationProvider np)
    { 
super(x, y, w, h, aFig, np);
} 

 } 
