
//#if -1265743700 
// Compilation Unit of /FigEnumerationLiteral.java 
 

//#if -138880923 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if 214914741 
import java.awt.Rectangle;
//#endif 


//#if -50649492 
import org.argouml.notation.NotationProvider;
//#endif 


//#if -2082233884 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if -1133478006 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -2064152121 
import org.argouml.uml.diagram.ui.CompartmentFigText;
//#endif 


//#if -1578000738 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1382783595 
public class FigEnumerationLiteral extends 
//#if 2004732154 
CompartmentFigText
//#endif 

  { 

//#if 967862212 

//#if 1665620878 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigEnumerationLiteral(int x, int y, int w, int h, Fig aFig,
                                 NotationProvider np)
    { 

//#if 1459688709 
super(x, y, w, h, aFig, np);
//#endif 

} 

//#endif 


//#if 1508980964 

//#if -153974201 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigEnumerationLiteral(Object owner, Rectangle bounds,
                                 DiagramSettings settings, NotationProvider np)
    { 

//#if 837596741 
super(owner, bounds, settings, np);
//#endif 

} 

//#endif 


//#if -903497902 
@Override
    protected int getNotationProviderType()
    { 

//#if -469683514 
return NotationProviderFactory2.TYPE_ENUMERATION_LITERAL;
//#endif 

} 

//#endif 


//#if 470231920 
public FigEnumerationLiteral(Object owner, Rectangle bounds,
                                 DiagramSettings settings)
    { 

//#if -1672112564 
super(owner, bounds, settings);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

