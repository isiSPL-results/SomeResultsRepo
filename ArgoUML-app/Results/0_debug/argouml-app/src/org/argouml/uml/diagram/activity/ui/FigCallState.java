
//#if -1351080870 
// Compilation Unit of /FigCallState.java 
 

//#if -666487796 
package org.argouml.uml.diagram.activity.ui;
//#endif 


//#if 566518575 
import java.awt.Rectangle;
//#endif 


//#if -1916495574 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if 588637008 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -327018747 
import org.tigris.gef.base.Selection;
//#endif 


//#if 1143547289 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 839020138 
public class FigCallState extends 
//#if -1021656515 
FigActionState
//#endif 

  { 

//#if -22464080 
@Override
    public Object clone()
    { 

//#if -1175318078 
FigCallState figClone = (FigCallState) super.clone();
//#endif 


//#if 1851507517 
return figClone;
//#endif 

} 

//#endif 


//#if -810898950 
public FigCallState(Object owner, Rectangle bounds,
                        DiagramSettings settings)
    { 

//#if -1310308091 
super(owner, bounds, settings);
//#endif 

} 

//#endif 


//#if 332613725 
@Override
    protected int getNotationProviderType()
    { 

//#if 2136987775 
return NotationProviderFactory2.TYPE_CALLSTATE;
//#endif 

} 

//#endif 


//#if -188835898 

//#if 691300630 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigCallState()
    { 

//#if -137603911 
super();
//#endif 

} 

//#endif 


//#if -1283852675 

//#if 1006554717 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigCallState(@SuppressWarnings("unused") GraphModel gm,
                        Object node)
    { 

//#if 99817323 
this();
//#endif 


//#if 311431354 
setOwner(node);
//#endif 

} 

//#endif 


//#if -1769001374 
@Override
    public Selection makeSelection()
    { 

//#if -230251980 
return new SelectionCallState(this);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

