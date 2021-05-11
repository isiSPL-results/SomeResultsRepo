
//#if 333524361 
// Compilation Unit of /GoModelElementToContainedLostElements.java 
 

//#if 1837315826 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 800607763 
import java.util.ArrayList;
//#endif 


//#if 388635054 
import java.util.Collection;
//#endif 


//#if 369271702 
import java.util.HashSet;
//#endif 


//#if 563206686 
import java.util.Iterator;
//#endif 


//#if 1334355176 
import java.util.Set;
//#endif 


//#if 101484093 
import org.argouml.i18n.Translator;
//#endif 


//#if -1088686205 
import org.argouml.model.Model;
//#endif 


//#if -115813581 
public class GoModelElementToContainedLostElements extends 
//#if 569910042 
AbstractPerspectiveRule
//#endif 

  { 

//#if 2146714426 
public Set getDependencies(Object parent)
    { 

//#if -668271154 
Set set = new HashSet();
//#endif 


//#if 1769782155 
if(Model.getFacade().isANamespace(parent))//1
{ 

//#if 1508084807 
set.add(parent);
//#endif 

} 

//#endif 


//#if -1240265362 
return set;
//#endif 

} 

//#endif 


//#if 160405672 
public String getRuleName()
    { 

//#if -1790804961 
return Translator.localize(
                   "misc.model-element.contained-lost-elements");
//#endif 

} 

//#endif 


//#if -1593198742 
public Collection getChildren(Object parent)
    { 

//#if 977430776 
Collection ret = new ArrayList();
//#endif 


//#if -1782200225 
if(Model.getFacade().isANamespace(parent))//1
{ 

//#if -2031192200 
Collection col =
                Model.getModelManagementHelper().getAllModelElementsOfKind(
                    parent,
                    Model.getMetaTypes().getStateMachine());
//#endif 


//#if -1364343156 
Iterator it = col.iterator();
//#endif 


//#if -607810820 
while (it.hasNext()) //1
{ 

//#if -288451645 
Object machine = it.next();
//#endif 


//#if -545681932 
if(Model.getFacade().getNamespace(machine) == parent)//1
{ 

//#if 454627264 
Object context = Model.getFacade().getContext(machine);
//#endif 


//#if -1122032326 
if(context == null)//1
{ 

//#if -219441600 
ret.add(machine);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1108964165 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

