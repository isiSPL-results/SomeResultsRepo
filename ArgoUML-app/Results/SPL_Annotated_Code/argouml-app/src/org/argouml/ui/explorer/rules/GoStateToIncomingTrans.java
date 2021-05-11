// Compilation Unit of /GoStateToIncomingTrans.java 
 

//#if STATE 
package org.argouml.ui.explorer.rules;
//#endif 


//#if STATE 
import java.util.Collection;
//#endif 


//#if STATE 
import java.util.Collections;
//#endif 


//#if STATE 
import java.util.HashSet;
//#endif 


//#if STATE 
import java.util.Set;
//#endif 


//#if STATE 
import org.argouml.i18n.Translator;
//#endif 


//#if STATE 
import org.argouml.model.Model;
//#endif 


//#if STATE 
public class GoStateToIncomingTrans extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAStateVertex(parent))//1
{ 
return Model.getFacade().getIncomings(parent);
} 

return Collections.EMPTY_SET;
} 

public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAStateVertex(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 

return Collections.EMPTY_SET;
} 

public String getRuleName()
    { 
return Translator.localize("misc.state.incoming-transitions");
} 

 } 

//#endif 


