
//#if 1265836605 
// Compilation Unit of /GoAssocRoleToMessages.java 
 

//#if 724592380 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 231206456 
import java.util.Collection;
//#endif 


//#if -1422532661 
import java.util.Collections;
//#endif 


//#if -868865204 
import java.util.HashSet;
//#endif 


//#if -135235682 
import java.util.Set;
//#endif 


//#if 1297769075 
import org.argouml.i18n.Translator;
//#endif 


//#if -939761991 
import org.argouml.model.Model;
//#endif 


//#if -1526641445 
public class GoAssocRoleToMessages extends 
//#if -119545889 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1877496593 
public Collection getChildren(Object parent)
    { 

//#if 1347488841 
if(!Model.getFacade().isAAssociationRole(parent))//1
{ 

//#if 494074632 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -218062522 
return Model.getFacade().getMessages(parent);
//#endif 

} 

//#endif 


//#if -981780435 
public String getRuleName()
    { 

//#if 1802203104 
return Translator.localize("misc.association-role.messages");
//#endif 

} 

//#endif 


//#if -765672491 
public Set getDependencies(Object parent)
    { 

//#if -1936397657 
if(Model.getFacade().isAAssociationRole(parent))//1
{ 

//#if 1655129665 
Set set = new HashSet();
//#endif 


//#if -1583689625 
set.add(parent);
//#endif 


//#if 1252440481 
return set;
//#endif 

} 

//#endif 


//#if 60534169 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

