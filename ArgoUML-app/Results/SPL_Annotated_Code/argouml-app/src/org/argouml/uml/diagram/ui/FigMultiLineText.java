// Compilation Unit of /FigMultiLineText.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.Rectangle;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.presentation.FigText;
public class FigMultiLineText extends ArgoFigText
  { 
public FigMultiLineText(Object owner, Rectangle bounds,
                            DiagramSettings settings, boolean expandOnly)
    { 
super(owner, bounds, settings, expandOnly);
initFigs();
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigMultiLineText(int x, int y, int w, int h, boolean expandOnly)
    { 
super(x, y, w, h, expandOnly);
initFigs();
} 

private void initFigs()
    { 
setTextColor(TEXT_COLOR);
setReturnAction(FigText.INSERT);
setLineSeparator("\n");
setTabAction(FigText.END_EDITING);
setJustification(FigText.JUSTIFY_LEFT);
setFilled(false);
setLineWidth(0);
} 

 } 


