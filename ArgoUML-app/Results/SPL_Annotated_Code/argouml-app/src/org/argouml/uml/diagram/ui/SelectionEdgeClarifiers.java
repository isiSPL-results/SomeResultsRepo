// Compilation Unit of /SelectionEdgeClarifiers.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.Graphics;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.PathItemPlacementStrategy;
import org.tigris.gef.base.SelectionReshape;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigEdge;
public class SelectionEdgeClarifiers extends SelectionReshape
  { 
public SelectionEdgeClarifiers(Fig f)
    { 
super(f);
} 

@Override
    public void paint(Graphics g)
    { 
super.paint(g);
int selectionCount =
            Globals.curEditor().getSelectionManager().getSelections().size();
if(selectionCount == 1)//1
{ 
FigEdge edge = (FigEdge) getContent();
if(edge instanceof Clarifiable)//1
{ 
((Clarifiable) edge).paintClarifiers(g);
} 

for (PathItemPlacementStrategy strategy
                    : edge.getPathItemStrategies()) //1
{ 
strategy.paint(g);
} 

} 

} 

 } 


