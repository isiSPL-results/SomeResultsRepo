
//#if -747865589 
// Compilation Unit of /GoDiagramToEdge.java 
 

//#if 1157140432 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1102139404 
import java.util.Collection;
//#endif 


//#if -193415049 
import java.util.Collections;
//#endif 


//#if 29146186 
import java.util.Set;
//#endif 


//#if -372569569 
import org.argouml.i18n.Translator;
//#endif 


//#if -58092778 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 1337907040 
public class GoDiagramToEdge extends 
//#if 1554266180 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1062300140 
public Collection getChildren(Object parent)
    { 

//#if -165274754 
if(parent instanceof Diagram)//1
{ 

//#if 1917764510 
return ((Diagram) parent).getEdges();
//#endif 

} 

//#endif 


//#if 936149944 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 283768016 
public Set getDependencies(Object parent)
    { 

//#if -1218440282 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1233849170 
public String getRuleName()
    { 

//#if 158733244 
return Translator.localize("misc.diagram.edge");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

