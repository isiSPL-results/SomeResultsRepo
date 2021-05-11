
//#if 1491367306 
// Compilation Unit of /GoNamespaceToOwnedElements.java 
 

//#if -422474020 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 145867881 
import java.util.ArrayList;
//#endif 


//#if 1566535192 
import java.util.Collection;
//#endif 


//#if 1317952491 
import java.util.Collections;
//#endif 


//#if 1316075372 
import java.util.HashSet;
//#endif 


//#if -150650616 
import java.util.Iterator;
//#endif 


//#if -451472450 
import java.util.Set;
//#endif 


//#if 808273555 
import org.argouml.i18n.Translator;
//#endif 


//#if -148483367 
import org.argouml.model.Model;
//#endif 


//#if -1754885315 
public class GoNamespaceToOwnedElements extends 
//#if -1285599102 
AbstractPerspectiveRule
//#endif 

  { 

//#if -572453872 
public String getRuleName()
    { 

//#if -1153908680 
return Translator.localize("misc.namespace.owned-element");
//#endif 

} 

//#endif 


//#if -954770734 
public Collection getChildren(Object parent)
    { 

//#if 1810630123 
if(!Model.getFacade().isANamespace(parent))//1
{ 

//#if -502002360 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if -797632339 
Collection ownedElements = Model.getFacade().getOwnedElements(parent);
//#endif 


//#if -133251834 
Iterator it = ownedElements.iterator();
//#endif 


//#if -974953287 
Collection ret = new ArrayList();
//#endif 


//#if 1499056186 
while (it.hasNext()) //1
{ 

//#if -702200097 
Object o = it.next();
//#endif 


//#if 1341195997 
if(Model.getFacade().isACollaboration(o))//1
{ 

//#if -928279996 
if((Model.getFacade().getRepresentedClassifier(o) != null)
                        || (Model.getFacade().getRepresentedOperation(o)
                            != null))//1
{ 

//#if 1916514376 
continue;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -83059711 
if(Model.getFacade().isAStateMachine(o)
                    && Model.getFacade().getContext(o) != parent)//1
{ 

//#if -369507424 
continue;
//#endif 

} 

//#endif 


//#if -618669181 
if(Model.getFacade().isAComment(o))//1
{ 

//#if 91967662 
if(Model.getFacade().getAnnotatedElements(o).size() != 0)//1
{ 

//#if -704969677 
continue;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1338374081 
ret.add(o);
//#endif 

} 

//#endif 


//#if -1862160742 
return ret;
//#endif 

} 

//#endif 


//#if 1525651666 
public Set getDependencies(Object parent)
    { 

//#if 605592626 
if(Model.getFacade().isANamespace(parent))//1
{ 

//#if -457937640 
Set set = new HashSet();
//#endif 


//#if -1023214914 
set.add(parent);
//#endif 


//#if 2125934904 
return set;
//#endif 

} 

//#endif 


//#if 1032478898 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

