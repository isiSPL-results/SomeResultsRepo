
//#if 686701713 
// Compilation Unit of /ArgoModeCreateFigSpline.java 
 

//#if -95835532 
package org.argouml.gefext;
//#endif 


//#if -2087957008 
import java.awt.event.MouseEvent;
//#endif 


//#if 1342320168 
import org.argouml.i18n.Translator;
//#endif 


//#if -435945828 
import org.tigris.gef.base.ModeCreateFigSpline;
//#endif 


//#if -1732134683 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -882746476 
import org.tigris.gef.presentation.FigSpline;
//#endif 


//#if -2115314045 
public class ArgoModeCreateFigSpline extends 
//#if -1811570293 
ModeCreateFigSpline
//#endif 

  { 

//#if -468783189 
public String instructions()
    { 

//#if 396467493 
return Translator.localize("statusmsg.help.create.spline");
//#endif 

} 

//#endif 


//#if -433022758 
public Fig createNewItem(MouseEvent me, int snapX, int snapY)
    { 

//#if -1171297429 
FigSpline p = new ArgoFigSpline(snapX, snapY);
//#endif 


//#if 1255039094 
p.addPoint(snapX, snapY);
//#endif 


//#if -695334653 
_startX = snapX;
//#endif 


//#if 1047475713 
_startY = snapY;
//#endif 


//#if 2088249017 
_lastX = snapX;
//#endif 


//#if -463907913 
_lastY = snapY;
//#endif 


//#if -1978258970 
_npoints = 2;
//#endif 


//#if 1639877321 
return p;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

