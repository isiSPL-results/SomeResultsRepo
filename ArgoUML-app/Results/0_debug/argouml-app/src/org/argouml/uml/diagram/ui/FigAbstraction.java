
//#if -1928506524 
// Compilation Unit of /FigAbstraction.java 
 

//#if 403163974 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -762651213 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -1950753566 
import org.tigris.gef.presentation.ArrowHead;
//#endif 


//#if -1850762054 
import org.tigris.gef.presentation.ArrowHeadTriangle;
//#endif 


//#if 973490746 
public class FigAbstraction extends 
//#if -1854418100 
FigDependency
//#endif 

  { 

//#if 2042166825 
protected ArrowHead createEndArrow()
    { 

//#if -2034511666 
final ArrowHead arrow = new ArrowHeadTriangle();
//#endif 


//#if -647613302 
arrow.setFillColor(FILL_COLOR);
//#endif 


//#if 98722902 
return arrow;
//#endif 

} 

//#endif 


//#if 911722368 

//#if -717230740 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigAbstraction(Object edge)
    { 

//#if -127438067 
this();
//#endif 


//#if 1741842263 
setOwner(edge);
//#endif 

} 

//#endif 


//#if 1344066274 
public FigAbstraction(Object owner, DiagramSettings settings)
    { 

//#if -126606974 
super(owner, settings);
//#endif 

} 

//#endif 


//#if -369758884 

//#if 1266013176 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigAbstraction()
    { 

//#if -984218124 
super();
//#endif 


//#if -292526293 
setDestArrowHead(createEndArrow());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

