
//#if 1639519601 
// Compilation Unit of /GoStateToDoActivity.java 
 

//#if -1360702601 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1558893230 
import java.util.ArrayList;
//#endif 


//#if -1874319245 
import java.util.Collection;
//#endif 


//#if 2025647344 
import java.util.Collections;
//#endif 


//#if -340552975 
import java.util.HashSet;
//#endif 


//#if 1672837571 
import java.util.Set;
//#endif 


//#if -269860904 
import org.argouml.i18n.Translator;
//#endif 


//#if 1341437598 
import org.argouml.model.Model;
//#endif 


//#if 704786004 
public class GoStateToDoActivity extends 
//#if 3557532 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1133625236 
public Collection getChildren(Object parent)
    { 

//#if 1982926020 
if(Model.getFacade().isAState(parent)
                && Model.getFacade().getDoActivity(parent) != null)//1
{ 

//#if -1093709775 
Collection children = new ArrayList();
//#endif 


//#if 2145161903 
children.add(Model.getFacade().getDoActivity(parent));
//#endif 


//#if -1130674306 
return children;
//#endif 

} 

//#endif 


//#if -1412751738 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1356490154 
public String getRuleName()
    { 

//#if -1482751990 
return Translator.localize("misc.state.do-activity");
//#endif 

} 

//#endif 


//#if 1058679160 
public Set getDependencies(Object parent)
    { 

//#if -1065781547 
if(Model.getFacade().isAState(parent))//1
{ 

//#if 2031367800 
Set set = new HashSet();
//#endif 


//#if -562138082 
set.add(parent);
//#endif 


//#if -719244648 
return set;
//#endif 

} 

//#endif 


//#if 2064925477 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

