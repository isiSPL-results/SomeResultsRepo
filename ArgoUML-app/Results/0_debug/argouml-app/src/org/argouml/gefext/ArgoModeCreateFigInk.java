
//#if -173284733 
// Compilation Unit of /ArgoModeCreateFigInk.java 
 

//#if -1837043576 
package org.argouml.gefext;
//#endif 


//#if -323767036 
import java.awt.event.MouseEvent;
//#endif 


//#if 216801340 
import org.argouml.i18n.Translator;
//#endif 


//#if 510068399 
import org.tigris.gef.base.ModeCreateFigInk;
//#endif 


//#if 209486073 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 212645815 
import org.tigris.gef.presentation.FigInk;
//#endif 


//#if 394474720 
public class ArgoModeCreateFigInk extends 
//#if -1094615085 
ModeCreateFigInk
//#endif 

  { 

//#if -76338431 
public Fig createNewItem(MouseEvent me, int snapX, int snapY)
    { 

//#if 1721706581 
FigInk p = new ArgoFigInk(snapX, snapY);
//#endif 


//#if 498730101 
_lastX = snapX;
//#endif 


//#if -2053426829 
_lastY = snapY;
//#endif 


//#if -1199569011 
return p;
//#endif 

} 

//#endif 


//#if 447378002 
public String instructions()
    { 

//#if -1431653878 
return Translator.localize("statusmsg.help.create.ink");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

