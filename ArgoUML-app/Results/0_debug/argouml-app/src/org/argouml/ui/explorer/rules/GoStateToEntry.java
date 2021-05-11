
//#if -272223810 
// Compilation Unit of /GoStateToEntry.java 
 

//#if 720687000 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -158359251 
import java.util.ArrayList;
//#endif 


//#if 725428692 
import java.util.Collection;
//#endif 


//#if 1013454767 
import java.util.Collections;
//#endif 


//#if 15201584 
import java.util.HashSet;
//#endif 


//#if -1833249918 
import java.util.Set;
//#endif 


//#if 1154752343 
import org.argouml.i18n.Translator;
//#endif 


//#if -713020003 
import org.argouml.model.Model;
//#endif 


//#if -1781477319 
public class GoStateToEntry extends 
//#if -1129616893 
AbstractPerspectiveRule
//#endif 

  { 

//#if -997406383 
public String getRuleName()
    { 

//#if -1610728159 
return Translator.localize("misc.state.entry");
//#endif 

} 

//#endif 


//#if -112251599 
public Set getDependencies(Object parent)
    { 

//#if -286630536 
if(Model.getFacade().isAState(parent))//1
{ 

//#if -1056045037 
Set set = new HashSet();
//#endif 


//#if -1354806471 
set.add(parent);
//#endif 


//#if -1599325709 
return set;
//#endif 

} 

//#endif 


//#if 1646415778 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -607488493 
public Collection getChildren(Object parent)
    { 

//#if -1443107339 
if(Model.getFacade().isAState(parent)
                && Model.getFacade().getEntry(parent) != null)//1
{ 

//#if 912657371 
Collection children = new ArrayList();
//#endif 


//#if 1805120805 
children.add(Model.getFacade().getEntry(parent));
//#endif 


//#if -2022954988 
return children;
//#endif 

} 

//#endif 


//#if -676618147 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

