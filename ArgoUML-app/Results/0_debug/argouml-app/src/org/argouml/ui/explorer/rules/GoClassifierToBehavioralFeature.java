
//#if -1670536517 
// Compilation Unit of /GoClassifierToBehavioralFeature.java 
 

//#if -1972127570 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -1069394326 
import java.util.Collection;
//#endif 


//#if 1208516057 
import java.util.Collections;
//#endif 


//#if -969539494 
import java.util.HashSet;
//#endif 


//#if 1817248684 
import java.util.Set;
//#endif 


//#if -2116698623 
import org.argouml.i18n.Translator;
//#endif 


//#if 2057285959 
import org.argouml.model.Model;
//#endif 


//#if -118730028 
public class GoClassifierToBehavioralFeature extends 
//#if -234383255 
AbstractPerspectiveRule
//#endif 

  { 

//#if -160455157 
public Set getDependencies(Object parent)
    { 

//#if -1757173946 
if(Model.getFacade().isAClassifier(parent))//1
{ 

//#if 1779659923 
Set set = new HashSet();
//#endif 


//#if 1223620537 
set.add(parent);
//#endif 


//#if 1891059315 
return set;
//#endif 

} 

//#endif 


//#if -1730682896 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -2120608007 
public Collection getChildren(Object parent)
    { 

//#if 453738625 
if(Model.getFacade().isAClassifier(parent))//1
{ 

//#if -303461068 
return Model.getCoreHelper().getBehavioralFeatures(parent);
//#endif 

} 

//#endif 


//#if -1648352789 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 328660535 
public String getRuleName()
    { 

//#if 1733112345 
return Translator.localize("misc.classifier.behavioralfeature");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

