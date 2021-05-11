
//#if -971131625 
// Compilation Unit of /GoClassifierToStateMachine.java 
 

//#if -2070750580 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -664103480 
import java.util.Collection;
//#endif 


//#if 887630395 
import java.util.Collections;
//#endif 


//#if -938529348 
import java.util.HashSet;
//#endif 


//#if 906768910 
import java.util.Set;
//#endif 


//#if -77129501 
import org.argouml.i18n.Translator;
//#endif 


//#if -1371157207 
import org.argouml.model.Model;
//#endif 


//#if -57182503 
public class GoClassifierToStateMachine extends 
//#if 1224681658 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1964263864 
public String getRuleName()
    { 

//#if -1008372397 
return Translator.localize("misc.classifier.statemachine");
//#endif 

} 

//#endif 


//#if 1586317722 
public Set getDependencies(Object parent)
    { 

//#if -943712317 
if(Model.getFacade().isAClassifier(parent))//1
{ 

//#if -1024987205 
Set set = new HashSet();
//#endif 


//#if -162576671 
set.add(parent);
//#endif 


//#if -2085874789 
return set;
//#endif 

} 

//#endif 


//#if 100754861 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1833528054 
public Collection getChildren(Object parent)
    { 

//#if 1010209407 
if(Model.getFacade().isAClassifier(parent))//1
{ 

//#if 1179200122 
return Model.getFacade().getBehaviors(parent);
//#endif 

} 

//#endif 


//#if -1085122711 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

