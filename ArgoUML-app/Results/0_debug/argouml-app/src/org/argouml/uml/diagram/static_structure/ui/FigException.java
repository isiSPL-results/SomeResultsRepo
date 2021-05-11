
//#if -310228783 
// Compilation Unit of /FigException.java 
 

//#if -193838572 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if 1443233060 
import java.awt.Rectangle;
//#endif 


//#if 2079949947 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -1099292176 
import org.tigris.gef.base.Selection;
//#endif 


//#if 2018124228 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1381061349 
public class FigException extends 
//#if 1656000471 
FigSignal
//#endif 

  { 

//#if 1021615955 
@Override
    public Selection makeSelection()
    { 

//#if -443745333 
return new SelectionException(this);
//#endif 

} 

//#endif 


//#if 1415495859 

//#if -1445826360 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigException(GraphModel gm, Object node)
    { 

//#if -2112663453 
super(gm, node);
//#endif 

} 

//#endif 


//#if 388735215 
public FigException(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 

//#if -1712319327 
super(owner, bounds, settings);
//#endif 

} 

//#endif 


//#if 545146419 

//#if 797668596 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigException()
    { 

//#if -939064789 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

