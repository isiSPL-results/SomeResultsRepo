package org.argouml.uml.diagram.ui;
import java.awt.Rectangle;
import java.util.Collection;
import org.argouml.kernel.Project;
import org.argouml.model.Model;
import org.argouml.notation.NotationProvider;
import org.argouml.notation.NotationProviderFactory2;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.static_structure.ui.FigAttribute;
public class FigAttributesCompartment extends FigEditableCompartment
  { 
private static final long serialVersionUID = -2159995531015799681L;
@Override
    protected FigSingleLineTextWithNotation createFigText(Object owner,
            Rectangle bounds, DiagramSettings settings)
    { 
return new FigAttribute(owner, bounds, settings);
} 
public FigAttributesCompartment(Object owner, Rectangle bounds,
                                    DiagramSettings settings)
    { 
super(owner, bounds, settings);
super.populate();
} 
@SuppressWarnings("deprecation")

    @Deprecated
    @Override
    protected FigSingleLineTextWithNotation createFigText(Object owner,
            Rectangle bounds, DiagramSettings settings, NotationProvider np)
    { 
return new FigAttribute(owner, bounds, settings, np);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigAttributesCompartment(int x, int y, int w, int h)
    { 
super(x, y, w, h);
} 
protected int getNotationType()
    { 
return NotationProviderFactory2.TYPE_ATTRIBUTE;
} 
protected Collection getUmlCollection()
    { 
Object cls = getOwner();
return Model.getFacade().getStructuralFeatures(cls);
} 
protected void createModelElement()
    { 
Object classifier = getGroup().getOwner();
Project project = getProject();
Object attrType = project.getDefaultAttributeType();
Object attr = Model.getCoreFactory().buildAttribute2(
                          classifier,
                          attrType);
TargetManager.getInstance().setTarget(attr);
} 

 } 
