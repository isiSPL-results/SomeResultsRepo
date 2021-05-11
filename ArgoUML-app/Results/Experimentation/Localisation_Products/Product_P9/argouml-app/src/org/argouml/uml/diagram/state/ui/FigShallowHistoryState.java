package org.argouml.uml.diagram.state.ui;
import java.awt.Rectangle;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.graph.GraphModel;
public class FigShallowHistoryState extends FigHistoryState
  { 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigShallowHistoryState()
    { 
super();
} 
public String getH()
    { 
return "H";
} 
public FigShallowHistoryState(Object owner, Rectangle bounds,
                                  DiagramSettings settings)
    { 
super(owner, bounds, settings);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public FigShallowHistoryState(GraphModel gm, Object node)
    { 
super(gm, node);
} 

 } 
