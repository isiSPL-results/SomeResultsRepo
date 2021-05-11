
//#if 257506263 
// Compilation Unit of /GoClassifierToCollaboration.java 
 

//#if 1794902004 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1602348336 
import java.util.Collection;
//#endif 


//#if -1866807341 
import java.util.Collections;
//#endif 


//#if 1514166100 
import java.util.HashSet;
//#endif 


//#if -1413355610 
import java.util.Set;
//#endif 


//#if 1287857275 
import org.argouml.i18n.Translator;
//#endif 


//#if 1609000129 
import org.argouml.model.Model;
//#endif 


//#if 1680642522 
public class GoClassifierToCollaboration extends 
//#if 2057858904 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1845317592 
public Collection getChildren(Object parent)
    { 

//#if 1698547864 
if(Model.getFacade().isAClassifier(parent))//1
{ 

//#if 1942747746 
return Model.getFacade().getCollaborations(parent);
//#endif 

} 

//#endif 


//#if -195554878 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1602866372 
public Set getDependencies(Object parent)
    { 

//#if -1545167654 
if(Model.getFacade().isAClassifier(parent))//1
{ 

//#if -1831518441 
Set set = new HashSet();
//#endif 


//#if -1004362691 
set.add(parent);
//#endif 


//#if -1791515145 
return set;
//#endif 

} 

//#endif 


//#if -1995255164 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -144847514 
public String getRuleName()
    { 

//#if 855820511 
return Translator.localize("misc.classifier.collaboration");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

