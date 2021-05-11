package org.argouml.uml.diagram.deployment.ui;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Vector;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigText;
public class FigMNode extends AbstractFigNode
  { 
public FigMNode(Object owner, Rectangle bounds,
                    DiagramSettings settings)
    { 
super(owner, bounds, settings);
} 
@Override
    protected void textEditStarted(FigText ft)
    { 
if(ft == getNameFig())//1
{ 
showHelp("parsing.help.fig-node");
} 
} 
@Override
    public Vector getPopUpActions(MouseEvent me)
    { 
Vector popUpActions = super.getPopUpActions(me);
popUpActions.add(
            popUpActions.size() - getPopupAddOffset(),
            buildModifierPopUp(ABSTRACT | LEAF | ROOT));
return popUpActions;
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigMNode()
    { 
super();
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigMNode(GraphModel gm, Object node)
    { 
super(gm, node);
} 

 } 
