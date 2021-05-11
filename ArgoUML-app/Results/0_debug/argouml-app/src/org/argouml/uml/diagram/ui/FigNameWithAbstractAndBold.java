
//#if 1066928086 
// Compilation Unit of /FigNameWithAbstractAndBold.java 
 

//#if -1261318211 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1470961219 
import java.awt.Font;
//#endif 


//#if -493610347 
import java.awt.Rectangle;
//#endif 


//#if 2069292970 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -229375729 
class FigNameWithAbstractAndBold extends 
//#if 282341918 
FigNameWithAbstract
//#endif 

  { 

//#if 467595529 

//#if -93062731 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigNameWithAbstractAndBold(int x, int y, int w, int h,
                                      boolean expandOnly)
    { 

//#if -831815481 
super(x, y, w, h, expandOnly);
//#endif 

} 

//#endif 


//#if -907354225 
public FigNameWithAbstractAndBold(Object owner, Rectangle bounds,
                                      DiagramSettings settings, boolean expandOnly)
    { 

//#if -787393515 
super(owner, bounds, settings, expandOnly);
//#endif 

} 

//#endif 


//#if 1489816865 
@Override
    protected int getFigFontStyle()
    { 

//#if 304318524 
boolean showBoldName = getSettings().isShowBoldNames();
//#endif 


//#if 1476279142 
int boldStyle =  showBoldName ? Font.BOLD : Font.PLAIN;
//#endif 


//#if 993137883 
return super.getFigFontStyle() | boldStyle;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

