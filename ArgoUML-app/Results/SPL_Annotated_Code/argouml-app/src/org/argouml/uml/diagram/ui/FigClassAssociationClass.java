// Compilation Unit of /FigClassAssociationClass.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.Rectangle;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.static_structure.ui.FigClass;
import org.tigris.gef.presentation.Fig;
public class FigClassAssociationClass extends FigClass
  { 
private static final long serialVersionUID = -4101337246957593739L;
protected Fig getRemoveDelegate()
    { 
for (Object fig : getFigEdges()) //1
{ 
if(fig instanceof FigEdgeAssociationClass)//1
{ 
FigEdgeAssociationClass dashedEdge =
                    (FigEdgeAssociationClass) fig;
return dashedEdge.getRemoveDelegate();
} 

} 

return null;
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigClassAssociationClass(Object owner, int x, int y, int w, int h)
    { 
super(owner, x, y, w, h);
enableSizeChecking(true);
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigClassAssociationClass(Object owner)
    { 
super(null, owner);
} 

public FigClassAssociationClass(Object owner, Rectangle bounds,
                                    DiagramSettings settings)
    { 
super(owner, bounds, settings);
enableSizeChecking(true);
} 

 } 


