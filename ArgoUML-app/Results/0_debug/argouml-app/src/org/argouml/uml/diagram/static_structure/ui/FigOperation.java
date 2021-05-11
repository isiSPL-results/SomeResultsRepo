
//#if 50835878 
// Compilation Unit of /FigOperation.java 
 

//#if 380114073 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -1585889169 
import java.awt.Font;
//#endif 


//#if -823694359 
import java.awt.Rectangle;
//#endif 


//#if -1884551106 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -871168269 
import org.argouml.model.Model;
//#endif 


//#if 1733852344 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 1121709104 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if 80835286 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 426810858 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1912737336 
public class FigOperation extends 
//#if 1796022294 
FigFeature
//#endif 

  { 

//#if -1103208248 
public FigOperation(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 

//#if -1833991011 
super(owner, bounds, settings);
//#endif 


//#if -1642851794 
Model.getPump().addModelEventListener(this, owner, "isAbstract");
//#endif 

} 

//#endif 


//#if 1803227841 
@Override
    public void removeFromDiagram()
    { 

//#if 2024418343 
Model.getPump().removeModelEventListener(this, getOwner(),
                "isAbstract");
//#endif 


//#if 154332626 
super.removeFromDiagram();
//#endif 

} 

//#endif 


//#if -1018350286 

//#if -26560566 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    public void setOwner(Object owner)
    { 

//#if 403302242 
super.setOwner(owner);
//#endif 


//#if 1768755732 
if(owner != null)//1
{ 

//#if 1510433875 
diagramFontChanged(null);
//#endif 


//#if -30072613 
Model.getPump().addModelEventListener(this, owner, "isAbstract");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1678415045 
@Override
    protected int getNotationProviderType()
    { 

//#if -865069745 
return NotationProviderFactory2.TYPE_OPERATION;
//#endif 

} 

//#endif 


//#if 1766798708 

//#if 917490692 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigOperation(Object owner, Rectangle bounds,
                        DiagramSettings settings, NotationProvider np)
    { 

//#if -1456225264 
super(owner, bounds, settings, np);
//#endif 


//#if -483250157 
Model.getPump().addModelEventListener(this, owner, "isAbstract");
//#endif 

} 

//#endif 


//#if -779995892 
@Override
    protected int getFigFontStyle()
    { 

//#if 860319389 
return Model.getFacade().isAbstract(getOwner())
               ? Font.ITALIC : Font.PLAIN;
//#endif 

} 

//#endif 


//#if 1169449006 
@Override
    public void propertyChange(PropertyChangeEvent pce)
    { 

//#if 522259503 
super.propertyChange(pce);
//#endif 


//#if -762101099 
if("isAbstract".equals(pce.getPropertyName()))//1
{ 

//#if 965134630 
renderingChanged();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -64547756 

//#if 1490079232 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigOperation(int x, int y, int w, int h, Fig aFig,
                        NotationProvider np)
    { 

//#if 1385698514 
super(x, y, w, h, aFig, np);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

