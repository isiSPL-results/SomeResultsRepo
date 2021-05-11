// Compilation Unit of /FigNameWithAbstract.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.Font;
import java.awt.Rectangle;
import org.argouml.model.Model;
import org.argouml.uml.diagram.DiagramSettings;
class FigNameWithAbstract extends FigSingleLineText
  { 
@Override
    protected int getFigFontStyle()
    { 
int style = 0;
if(getOwner() != null)//1
{ 
style = Model.getFacade().isAbstract(getOwner())
                    ? Font.ITALIC : Font.PLAIN;
} 

return super.getFigFontStyle() | style;
} 

public void setLineWidth(int w)
    { 
super.setLineWidth(w);
} 

public FigNameWithAbstract(Object owner, Rectangle bounds,
                               DiagramSettings settings, boolean expandOnly)
    { 
super(owner, bounds, settings, expandOnly);
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigNameWithAbstract(int x, int y, int w, int h, boolean expandOnly)
    { 
super(x, y, w, h, expandOnly);
} 

 } 


