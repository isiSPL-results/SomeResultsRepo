
//#if 129430801 
// Compilation Unit of /ArgoModeCreateFigCircle.java 
 

//#if 1848651807 
package org.argouml.gefext;
//#endif 


//#if -444291237 
import java.awt.event.MouseEvent;
//#endif 


//#if 357161171 
import org.argouml.i18n.Translator;
//#endif 


//#if -224515160 
import org.tigris.gef.base.ModeCreateFigCircle;
//#endif 


//#if -946989552 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 730136109 
public class ArgoModeCreateFigCircle extends 
//#if -849613605 
ModeCreateFigCircle
//#endif 

  { 

//#if 389553761 
@Override
    public Fig createNewItem(MouseEvent me, int snapX, int snapY)
    { 

//#if -2110769343 
return new ArgoFigCircle(snapX, snapY, 0, 0);
//#endif 

} 

//#endif 


//#if -655608398 
@Override
    public String instructions()
    { 

//#if -1039584065 
return Translator.localize("statusmsg.help.create.circle");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

