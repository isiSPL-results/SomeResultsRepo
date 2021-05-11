
//#if 1919519053 
// Compilation Unit of /ArgoModeCreateFigRRect.java 
 

//#if -392622464 
package org.argouml.gefext;
//#endif 


//#if -1534363396 
import java.awt.event.MouseEvent;
//#endif 


//#if 769836596 
import org.argouml.i18n.Translator;
//#endif 


//#if -343442521 
import org.tigris.gef.base.ModeCreateFigRRect;
//#endif 


//#if -448828687 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -2028189960 
public class ArgoModeCreateFigRRect extends 
//#if 1729172355 
ModeCreateFigRRect
//#endif 

  { 

//#if 1160623593 
@Override
    public Fig createNewItem(MouseEvent me, int snapX, int snapY)
    { 

//#if -2139061351 
return new ArgoFigRRect(snapX, snapY, 0, 0);
//#endif 

} 

//#endif 


//#if 548071738 
@Override
    public String instructions()
    { 

//#if 1169151388 
return Translator.localize("statusmsg.help.create.rrect");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

