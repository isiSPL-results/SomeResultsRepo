
//#if -804432994 
// Compilation Unit of /FigNameWithAbstract.java 
 

//#if -1300509921 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 602653989 
import java.awt.Font;
//#endif 


//#if 2046388467 
import java.awt.Rectangle;
//#endif 


//#if 784834601 
import org.argouml.model.Model;
//#endif 


//#if 151576588 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1336372495 
class FigNameWithAbstract extends 
//#if 1535091206 
FigSingleLineText
//#endif 

  { 

//#if 549738927 
@Override
    protected int getFigFontStyle()
    { 

//#if 170771282 
int style = 0;
//#endif 


//#if 186573024 
if(getOwner() != null)//1
{ 

//#if 726418243 
style = Model.getFacade().isAbstract(getOwner())
                    ? Font.ITALIC : Font.PLAIN;
//#endif 

} 

//#endif 


//#if -1815198680 
return super.getFigFontStyle() | style;
//#endif 

} 

//#endif 


//#if -885148979 
public void setLineWidth(int w)
    { 

//#if -15917779 
super.setLineWidth(w);
//#endif 

} 

//#endif 


//#if 737469039 
public FigNameWithAbstract(Object owner, Rectangle bounds,
                               DiagramSettings settings, boolean expandOnly)
    { 

//#if 326027582 
super(owner, bounds, settings, expandOnly);
//#endif 

} 

//#endif 


//#if 62571311 

//#if -1962230507 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigNameWithAbstract(int x, int y, int w, int h, boolean expandOnly)
    { 

//#if -700629055 
super(x, y, w, h, expandOnly);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

