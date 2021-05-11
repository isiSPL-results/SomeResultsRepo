
//#if -194011556 
// Compilation Unit of /ArgoModeCreateFigPoly.java 
 

//#if 550088804 
package org.argouml.gefext;
//#endif 


//#if -519299104 
import java.awt.event.MouseEvent;
//#endif 


//#if 1289045016 
import org.argouml.i18n.Translator;
//#endif 


//#if 411038833 
import org.tigris.gef.base.ModeCreateFigPoly;
//#endif 


//#if 691558101 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1775047831 
import org.tigris.gef.presentation.FigPoly;
//#endif 


//#if -851507986 
public class ArgoModeCreateFigPoly extends 
//#if 808190415 
ModeCreateFigPoly
//#endif 

  { 

//#if 1698822146 
public String instructions()
    { 

//#if -1086499013 
return Translator.localize("statusmsg.help.create.poly");
//#endif 

} 

//#endif 


//#if -1511723111 
@Override
    public Fig createNewItem(MouseEvent me, int snapX, int snapY)
    { 

//#if -884845306 
FigPoly p = new ArgoFigPoly(snapX, snapY);
//#endif 


//#if 1359211377 
p.addPoint(snapX, snapY);
//#endif 


//#if 1777052318 
_lastX = snapX;
//#endif 


//#if -775104612 
_lastY = snapY;
//#endif 


//#if -1752497730 
_startX = snapX;
//#endif 


//#if -9687364 
_startY = snapY;
//#endif 


//#if -101489909 
_npoints = 2;
//#endif 


//#if 2133289924 
return p;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

