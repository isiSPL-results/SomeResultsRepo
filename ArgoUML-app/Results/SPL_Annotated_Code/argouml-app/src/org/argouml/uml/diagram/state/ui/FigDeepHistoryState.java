// Compilation Unit of /FigDeepHistoryState.java 
 
package org.argouml.uml.diagram.state.ui;
import java.awt.Rectangle;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.graph.GraphModel;
public class FigDeepHistoryState extends FigHistoryState
  { 
public FigDeepHistoryState(Object owner, Rectangle bounds,
                               DiagramSettings settings)
    { 
super(owner, bounds, settings);
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigDeepHistoryState()
    { 
super();
} 

public String getH()
    { 
return "H*";
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigDeepHistoryState(GraphModel gm, Object node)
    { 
super(gm, node);
} 

 } 


