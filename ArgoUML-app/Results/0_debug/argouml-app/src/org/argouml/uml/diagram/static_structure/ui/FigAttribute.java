
//#if -253106234 
// Compilation Unit of /FigAttribute.java 
 

//#if 1183661972 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if 1864555172 
import java.awt.Rectangle;
//#endif 


//#if -325982691 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 261890197 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if 559290107 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 985282319 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 64799976 
public class FigAttribute extends 
//#if 1460226001 
FigFeature
//#endif 

  { 

//#if 515939822 

//#if -445055993 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigAttribute(int x, int y, int w, int h, Fig aFig,
                        NotationProvider np)
    { 

//#if 2024274152 
super(x, y, w, h, aFig, np);
//#endif 

} 

//#endif 


//#if -282324722 

//#if -1954207498 
@SuppressWarnings("deprecation")
//#endif 

@Deprecated
    
    public FigAttribute(Object owner, Rectangle bounds,
                        DiagramSettings settings, NotationProvider np)
    { 

//#if 1403388401 
super(owner, bounds, settings, np);
//#endif 

} 

//#endif 


//#if 650219894 
@Override
    protected int getNotationProviderType()
    { 

//#if -733113099 
return NotationProviderFactory2.TYPE_ATTRIBUTE;
//#endif 

} 

//#endif 


//#if 1044292824 
public FigAttribute(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 

//#if 945566469 
super(owner, bounds, settings);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

