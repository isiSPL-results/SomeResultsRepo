
//#if 1189616121 
// Compilation Unit of /ArgoModeCreateFigRect.java 
 

//#if -938059979 
package org.argouml.gefext;
//#endif 


//#if 1505404401 
import java.awt.event.MouseEvent;
//#endif 


//#if 1408928233 
import org.argouml.i18n.Translator;
//#endif 


//#if 1751149034 
import org.tigris.gef.base.ModeCreateFigRect;
//#endif 


//#if -306951130 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1173245207 
public class ArgoModeCreateFigRect extends 
//#if 755344391 
ModeCreateFigRect
//#endif 

  { 

//#if 2038077369 
@Override
    public Fig createNewItem(MouseEvent me, int snapX, int snapY)
    { 

//#if -1676925012 
return new ArgoFigRect(snapX, snapY, 0, 0);
//#endif 

} 

//#endif 


//#if 518890250 
@Override
    public String instructions()
    { 

//#if -755296358 
return Translator.localize("statusmsg.help.create.rect");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

