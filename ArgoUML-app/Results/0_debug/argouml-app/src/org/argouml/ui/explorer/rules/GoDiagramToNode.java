
//#if -711475704 
// Compilation Unit of /GoDiagramToNode.java 
 

//#if -712875319 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 838784581 
import java.util.Collection;
//#endif 


//#if 232520030 
import java.util.Collections;
//#endif 


//#if 1969673265 
import java.util.Set;
//#endif 


//#if 2004730310 
import org.argouml.i18n.Translator;
//#endif 


//#if -1975760195 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 1191142988 
public class GoDiagramToNode extends 
//#if 558735636 
AbstractPerspectiveRule
//#endif 

  { 

//#if 1597860580 
public Collection getChildren(Object parent)
    { 

//#if 1557541745 
if(parent instanceof Diagram)//1
{ 

//#if 1860091427 
return ((Diagram) parent).getNodes();
//#endif 

} 

//#endif 


//#if -612893589 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1988263902 
public String getRuleName()
    { 

//#if 1523157068 
return Translator.localize("misc.diagram.node");
//#endif 

} 

//#endif 


//#if -842542592 
public Set getDependencies(Object parent)
    { 

//#if 1641539270 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

