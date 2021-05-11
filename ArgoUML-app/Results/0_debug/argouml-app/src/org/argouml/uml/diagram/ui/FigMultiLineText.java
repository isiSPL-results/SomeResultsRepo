
//#if 1635380311 
// Compilation Unit of /FigMultiLineText.java 
 

//#if 491327582 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1011846956 
import java.awt.Rectangle;
//#endif 


//#if -1420476725 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1679142194 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -114680298 
public class FigMultiLineText extends 
//#if 1832663534 
ArgoFigText
//#endif 

  { 

//#if 1552390605 
public FigMultiLineText(Object owner, Rectangle bounds,
                            DiagramSettings settings, boolean expandOnly)
    { 

//#if 1953774264 
super(owner, bounds, settings, expandOnly);
//#endif 


//#if 447082131 
initFigs();
//#endif 

} 

//#endif 


//#if -1809311159 

//#if 1446914164 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigMultiLineText(int x, int y, int w, int h, boolean expandOnly)
    { 

//#if 390241821 
super(x, y, w, h, expandOnly);
//#endif 


//#if 61094275 
initFigs();
//#endif 

} 

//#endif 


//#if -1123666291 
private void initFigs()
    { 

//#if -1401978577 
setTextColor(TEXT_COLOR);
//#endif 


//#if -48870640 
setReturnAction(FigText.INSERT);
//#endif 


//#if 199983153 
setLineSeparator("\n");
//#endif 


//#if -1845474478 
setTabAction(FigText.END_EDITING);
//#endif 


//#if 1576258261 
setJustification(FigText.JUSTIFY_LEFT);
//#endif 


//#if 2089193129 
setFilled(false);
//#endif 


//#if -889937070 
setLineWidth(0);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

