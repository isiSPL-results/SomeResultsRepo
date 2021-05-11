
//#if 948814795 
// Compilation Unit of /FigMNode.java 
 

//#if 205473249 
package org.argouml.uml.diagram.deployment.ui;
//#endif 


//#if -2143273266 
import java.awt.Rectangle;
//#endif 


//#if 358394928 
import java.awt.event.MouseEvent;
//#endif 


//#if 1691468510 
import java.util.Vector;
//#endif 


//#if 590336273 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -1983290278 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 1072714360 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -1468428283 
public class FigMNode extends 
//#if 121107359 
AbstractFigNode
//#endif 

  { 

//#if 1163047519 
public FigMNode(Object owner, Rectangle bounds,
                    DiagramSettings settings)
    { 

//#if 199238722 
super(owner, bounds, settings);
//#endif 

} 

//#endif 


//#if 847963107 
@Override
    protected void textEditStarted(FigText ft)
    { 

//#if -642713764 
if(ft == getNameFig())//1
{ 

//#if 437876760 
showHelp("parsing.help.fig-node");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 378020296 
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 

//#if -2118904545 
Vector popUpActions = super.getPopUpActions(me);
//#endif 


//#if 2146526891 
popUpActions.add(
            popUpActions.size() - getPopupAddOffset(),
            buildModifierPopUp(ABSTRACT | LEAF | ROOT));
//#endif 


//#if -1410394926 
return popUpActions;
//#endif 

} 

//#endif 


//#if 407743907 

//#if -1928070598 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigMNode()
    { 

//#if -2113176050 
super();
//#endif 

} 

//#endif 


//#if -455476413 

//#if -1296795233 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigMNode(GraphModel gm, Object node)
    { 

//#if 275848396 
super(gm, node);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

