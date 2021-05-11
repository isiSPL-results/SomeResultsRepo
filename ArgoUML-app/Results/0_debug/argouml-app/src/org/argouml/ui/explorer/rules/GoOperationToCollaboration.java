
//#if -1963492117 
// Compilation Unit of /GoOperationToCollaboration.java 
 

//#if 488913824 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -897941540 
import java.util.Collection;
//#endif 


//#if -2066382169 
import java.util.Collections;
//#endif 


//#if 1156684840 
import java.util.HashSet;
//#endif 


//#if -1579239814 
import java.util.Set;
//#endif 


//#if 1528000591 
import org.argouml.i18n.Translator;
//#endif 


//#if -1203848555 
import org.argouml.model.Model;
//#endif 


//#if 782466558 
public class GoOperationToCollaboration extends 
//#if -691547327 
AbstractPerspectiveRule
//#endif 

  { 

//#if -666743855 
public Collection getChildren(Object parent)
    { 

//#if -900419205 
if(Model.getFacade().isAOperation(parent))//1
{ 

//#if 2055056396 
return Model.getFacade().getCollaborations(parent);
//#endif 

} 

//#endif 


//#if 591553493 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -919348465 
public String getRuleName()
    { 

//#if -463999067 
return Translator.localize("misc.operation.collaboration");
//#endif 

} 

//#endif 


//#if 1493655603 
public Set getDependencies(Object parent)
    { 

//#if 1461300968 
if(Model.getFacade().isAOperation(parent))//1
{ 

//#if 1259393960 
Set set = new HashSet();
//#endif 


//#if 607725902 
set.add(parent);
//#endif 


//#if -1261612179 
if(Model.getFacade().getOwner(parent) != null)//1
{ 

//#if 817981598 
set.add(Model.getFacade().getOwner(parent));
//#endif 

} 

//#endif 


//#if -711488568 
return set;
//#endif 

} 

//#endif 


//#if -1263547704 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

