
//#if 1161439401 
// Compilation Unit of /SelectionEdgeClarifiers.java 
 

//#if -65399995 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 2022095247 
import java.awt.Graphics;
//#endif 


//#if 990922819 
import org.tigris.gef.base.Globals;
//#endif 


//#if 364277235 
import org.tigris.gef.base.PathItemPlacementStrategy;
//#endif 


//#if -1878321631 
import org.tigris.gef.base.SelectionReshape;
//#endif 


//#if -130193850 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 867222153 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if -1903520028 
public class SelectionEdgeClarifiers extends 
//#if 1776559741 
SelectionReshape
//#endif 

  { 

//#if 2072835224 
public SelectionEdgeClarifiers(Fig f)
    { 

//#if -443611167 
super(f);
//#endif 

} 

//#endif 


//#if -1431487963 
@Override
    public void paint(Graphics g)
    { 

//#if -130521062 
super.paint(g);
//#endif 


//#if 1830461096 
int selectionCount =
            Globals.curEditor().getSelectionManager().getSelections().size();
//#endif 


//#if -689213811 
if(selectionCount == 1)//1
{ 

//#if 23451954 
FigEdge edge = (FigEdge) getContent();
//#endif 


//#if 522844780 
if(edge instanceof Clarifiable)//1
{ 

//#if 1231552591 
((Clarifiable) edge).paintClarifiers(g);
//#endif 

} 

//#endif 


//#if -543882551 
for (PathItemPlacementStrategy strategy
                    : edge.getPathItemStrategies()) //1
{ 

//#if -336612557 
strategy.paint(g);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

