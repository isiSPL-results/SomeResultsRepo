
//#if -766531721 
// Compilation Unit of /GoStateToInternalTrans.java 
 

//#if -1401273073 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -277235701 
import java.util.Collection;
//#endif 


//#if -4370344 
import java.util.Collections;
//#endif 


//#if -671225255 
import java.util.HashSet;
//#endif 


//#if 811844907 
import java.util.Set;
//#endif 


//#if -1118014144 
import org.argouml.i18n.Translator;
//#endif 


//#if 409591814 
import org.argouml.model.Model;
//#endif 


//#if -866204759 
public class GoStateToInternalTrans extends 
//#if -330212442 
AbstractPerspectiveRule
//#endif 

  { 

//#if -590782162 
public Set getDependencies(Object parent)
    { 

//#if -268872732 
if(Model.getFacade().isAState(parent))//1
{ 

//#if 878613680 
Set set = new HashSet();
//#endif 


//#if 643870294 
set.add(parent);
//#endif 


//#if 1491695312 
return set;
//#endif 

} 

//#endif 


//#if -932750922 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1568874956 
public String getRuleName()
    { 

//#if 1948254426 
return Translator.localize("misc.state.internal-transitions");
//#endif 

} 

//#endif 


//#if -1515035402 
public Collection getChildren(Object parent)
    { 

//#if -1601647686 
if(Model.getFacade().isAState(parent))//1
{ 

//#if 1892031912 
return Model.getFacade().getInternalTransitions(parent);
//#endif 

} 

//#endif 


//#if 1260641824 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

