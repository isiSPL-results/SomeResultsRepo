
//#if -1699696539 
// Compilation Unit of /FigAttributesCompartment.java 
 

//#if 122271529 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -521016919 
import java.awt.Rectangle;
//#endif 


//#if -1756574210 
import java.util.Collection;
//#endif 


//#if -1368808201 
import org.argouml.kernel.Project;
//#endif 


//#if 95494451 
import org.argouml.model.Model;
//#endif 


//#if 874227448 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -403646864 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if 127499599 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1384968938 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -2008714780 
import org.argouml.uml.diagram.static_structure.ui.FigAttribute;
//#endif 


//#if 1544953740 
public class FigAttributesCompartment extends 
//#if 1737226858 
FigEditableCompartment
//#endif 

  { 

//#if 1725428029 
private static final long serialVersionUID = -2159995531015799681L;
//#endif 


//#if 1850160054 
@Override
    protected FigSingleLineTextWithNotation createFigText(Object owner,
            Rectangle bounds, DiagramSettings settings)
    { 

//#if -1376857330 
return new FigAttribute(owner, bounds, settings);
//#endif 

} 

//#endif 


//#if 589598008 
public FigAttributesCompartment(Object owner, Rectangle bounds,
                                    DiagramSettings settings)
    { 

//#if -517270316 
super(owner, bounds, settings);
//#endif 


//#if -1449569397 
super.populate();
//#endif 

} 

//#endif 


//#if 258431630 

//#if -499441973 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    protected FigSingleLineTextWithNotation createFigText(Object owner,
            Rectangle bounds, DiagramSettings settings, NotationProvider np)
    { 

//#if 1388329129 
return new FigAttribute(owner, bounds, settings, np);
//#endif 

} 

//#endif 


//#if -869318560 

//#if -1870384392 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigAttributesCompartment(int x, int y, int w, int h)
    { 

//#if -711225601 
super(x, y, w, h);
//#endif 

} 

//#endif 


//#if 1392960594 
protected int getNotationType()
    { 

//#if 1910452281 
return NotationProviderFactory2.TYPE_ATTRIBUTE;
//#endif 

} 

//#endif 


//#if -1023360727 
protected Collection getUmlCollection()
    { 

//#if -596190300 
Object cls = getOwner();
//#endif 


//#if -1808923125 
return Model.getFacade().getStructuralFeatures(cls);
//#endif 

} 

//#endif 


//#if -1758606446 
protected void createModelElement()
    { 

//#if 1360553933 
Object classifier = getGroup().getOwner();
//#endif 


//#if -1477242461 
Project project = getProject();
//#endif 


//#if 1843110862 
Object attrType = project.getDefaultAttributeType();
//#endif 


//#if -1373360299 
Object attr = Model.getCoreFactory().buildAttribute2(
                          classifier,
                          attrType);
//#endif 


//#if -1989812459 
TargetManager.getInstance().setTarget(attr);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

