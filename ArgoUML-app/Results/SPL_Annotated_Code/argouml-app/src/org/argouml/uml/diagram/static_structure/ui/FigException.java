// Compilation Unit of /FigException.java 
 
package org.argouml.uml.diagram.static_structure.ui;
import java.awt.Rectangle;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
public class FigException extends FigSignal
  { 
@Override
    public Selection makeSelection()
    { 
return new SelectionException(this);
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigException(GraphModel gm, Object node)
    { 
super(gm, node);
} 

public FigException(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 
super(owner, bounds, settings);
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigException()
    { 
super();
} 

 } 


