
//#if 323570606 
// Compilation Unit of /FigClassAssociationClass.java 
 

//#if -1412564687 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1709064543 
import java.awt.Rectangle;
//#endif 


//#if -407076066 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -415166464 
import org.argouml.uml.diagram.static_structure.ui.FigClass;
//#endif 


//#if 1047819826 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -937142504 
public class FigClassAssociationClass extends 
//#if 2098766638 
FigClass
//#endif 

  { 

//#if -748125082 
private static final long serialVersionUID = -4101337246957593739L;
//#endif 


//#if -324232528 
protected Fig getRemoveDelegate()
    { 

//#if -805265370 
for (Object fig : getFigEdges()) //1
{ 

//#if 652733355 
if(fig instanceof FigEdgeAssociationClass)//1
{ 

//#if -2010045620 
FigEdgeAssociationClass dashedEdge =
                    (FigEdgeAssociationClass) fig;
//#endif 


//#if 10542494 
return dashedEdge.getRemoveDelegate();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -823203667 
return null;
//#endif 

} 

//#endif 


//#if 1722057182 

//#if -689006796 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigClassAssociationClass(Object owner, int x, int y, int w, int h)
    { 

//#if 163222409 
super(owner, x, y, w, h);
//#endif 


//#if -1724328133 
enableSizeChecking(true);
//#endif 

} 

//#endif 


//#if -1953137296 

//#if -530278270 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigClassAssociationClass(Object owner)
    { 

//#if 1405646826 
super(null, owner);
//#endif 

} 

//#endif 


//#if -1804580022 
public FigClassAssociationClass(Object owner, Rectangle bounds,
                                    DiagramSettings settings)
    { 

//#if -583370909 
super(owner, bounds, settings);
//#endif 


//#if -506090265 
enableSizeChecking(true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

