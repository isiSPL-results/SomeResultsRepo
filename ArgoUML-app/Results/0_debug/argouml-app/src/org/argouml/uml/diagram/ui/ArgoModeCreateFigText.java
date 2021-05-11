
//#if 559002112 
// Compilation Unit of /ArgoModeCreateFigText.java 
 

//#if -555789816 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 574343146 
import java.awt.Rectangle;
//#endif 


//#if 816180116 
import java.awt.event.MouseEvent;
//#endif 


//#if 489353932 
import org.argouml.i18n.Translator;
//#endif 


//#if -324049459 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if 1695928548 
import org.tigris.gef.base.ModeCreateFigText;
//#endif 


//#if 1693420425 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 484081155 
public class ArgoModeCreateFigText extends 
//#if -1591844934 
ModeCreateFigText
//#endif 

  { 

//#if -214045452 
@Override
    public String instructions()
    { 

//#if -2139661161 
return Translator.localize("statusmsg.help.create.text");
//#endif 

} 

//#endif 


//#if 536969648 
@Override
    public Fig createNewItem(MouseEvent e, int snapX, int snapY)
    { 

//#if -857222736 
return new ArgoFigText(null, new Rectangle(snapX, snapY, 0, 0),
                               DiagramUtils.getActiveDiagram().getDiagramSettings(), true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

