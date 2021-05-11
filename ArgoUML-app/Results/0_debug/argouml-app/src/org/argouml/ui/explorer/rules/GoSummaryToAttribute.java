
//#if -368708345 
// Compilation Unit of /GoSummaryToAttribute.java 
 

//#if -1812076033 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -1586902789 
import java.util.Collection;
//#endif 


//#if -1949344408 
import java.util.Collections;
//#endif 


//#if 1421934441 
import java.util.HashSet;
//#endif 


//#if 1872486971 
import java.util.Set;
//#endif 


//#if 1934915152 
import org.argouml.i18n.Translator;
//#endif 


//#if -399709930 
import org.argouml.model.Model;
//#endif 


//#if -280588395 
public class GoSummaryToAttribute extends 
//#if -502841665 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1569123377 
public Collection getChildren(Object parent)
    { 

//#if -113971510 
if(parent instanceof AttributesNode)//1
{ 

//#if -935728522 
return Model.getFacade().getAttributes(((AttributesNode) parent)
                                                   .getParent());
//#endif 

} 

//#endif 


//#if -650085268 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -2056271627 
public Set getDependencies(Object parent)
    { 

//#if -873839874 
if(parent instanceof AttributesNode)//1
{ 

//#if -1784208228 
Set set = new HashSet();
//#endif 


//#if -1212506918 
set.add(((AttributesNode) parent).getParent());
//#endif 


//#if 977059260 
return set;
//#endif 

} 

//#endif 


//#if -136979016 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 38166285 
public String getRuleName()
    { 

//#if -1140153540 
return Translator.localize("misc.summary.attribute");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

