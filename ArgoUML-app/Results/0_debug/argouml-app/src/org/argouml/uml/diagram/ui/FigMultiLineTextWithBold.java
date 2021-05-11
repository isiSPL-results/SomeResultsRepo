
//#if -1003103755 
// Compilation Unit of /FigMultiLineTextWithBold.java 
 

//#if -1522132031 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 398260551 
import java.awt.Font;
//#endif 


//#if 919435793 
import java.awt.Rectangle;
//#endif 


//#if -37401170 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 896661918 
public class FigMultiLineTextWithBold extends 
//#if 1662424250 
FigMultiLineText
//#endif 

  { 

//#if -1346504168 

//#if 1670727200 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigMultiLineTextWithBold(int x, int y, int w, int h,
                                    boolean expandOnly)
    { 

//#if 1790972544 
super(x, y, w, h, expandOnly);
//#endif 

} 

//#endif 


//#if 1920875788 
@Override
    protected int getFigFontStyle()
    { 

//#if 286101603 
boolean showBoldName = getSettings().isShowBoldNames();
//#endif 


//#if 261846751 
int boldStyle =  showBoldName ? Font.BOLD : Font.PLAIN;
//#endif 


//#if -33431678 
return super.getFigFontStyle() | boldStyle;
//#endif 

} 

//#endif 


//#if -897814168 
public FigMultiLineTextWithBold(Object owner, Rectangle bounds,
                                    DiagramSettings settings, boolean expandOnly)
    { 

//#if -324102359 
super(owner, bounds, settings, expandOnly);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

