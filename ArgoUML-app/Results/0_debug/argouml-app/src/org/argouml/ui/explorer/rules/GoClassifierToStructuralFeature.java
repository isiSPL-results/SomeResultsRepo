
//#if -1771300692 
// Compilation Unit of /GoClassifierToStructuralFeature.java 
 

//#if -1829974893 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -150793073 
import java.util.Collection;
//#endif 


//#if -379616172 
import java.util.Collections;
//#endif 


//#if -370049963 
import java.util.HashSet;
//#endif 


//#if -1777879769 
import java.util.Set;
//#endif 


//#if 1441709116 
import org.argouml.i18n.Translator;
//#endif 


//#if 575603970 
import org.argouml.model.Model;
//#endif 


//#if 535517999 
public class GoClassifierToStructuralFeature extends 
//#if 580209889 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1115644559 
public Collection getChildren(Object parent)
    { 

//#if -1496222966 
if(Model.getFacade().isAClassifier(parent))//1
{ 

//#if -952463774 
return Model.getFacade().getStructuralFeatures(parent);
//#endif 

} 

//#endif 


//#if 981980340 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1185116819 
public Set getDependencies(Object parent)
    { 

//#if -542573991 
if(Model.getFacade().isAClassifier(parent))//1
{ 

//#if 1410934745 
Set set = new HashSet();
//#endif 


//#if -475185665 
set.add(parent);
//#endif 


//#if 1881225529 
return set;
//#endif 

} 

//#endif 


//#if -1632837181 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1468624047 
public String getRuleName()
    { 

//#if 1032037077 
return Translator.localize("misc.class.attribute");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

