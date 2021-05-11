
//#if 1128102161 
// Compilation Unit of /ArgoModeCreateFigLine.java 
 

//#if -566793762 
package org.argouml.gefext;
//#endif 


//#if -1354541606 
import java.awt.event.MouseEvent;
//#endif 


//#if 1779884946 
import org.argouml.i18n.Translator;
//#endif 


//#if 1265858932 
import org.argouml.uml.diagram.ui.ArgoFig;
//#endif 


//#if 1481175107 
import org.tigris.gef.base.ModeCreateFigLine;
//#endif 


//#if -2058770097 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1686875376 
public class ArgoModeCreateFigLine extends 
//#if 380126957 
ModeCreateFigLine
//#endif 

  { 

//#if -1042883057 
@Override
    public Fig createNewItem(MouseEvent me, int snapX, int snapY)
    { 

//#if 362042531 
Fig line = new ArgoFigLine(snapX, snapY, snapX, snapY);
//#endif 


//#if 1256780984 
return line;
//#endif 

} 

//#endif 


//#if 1254467168 
@Override
    public String instructions()
    { 

//#if 348545971 
return Translator.localize("statusmsg.help.create.line");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

