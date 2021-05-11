
//#if -1635529243 
// Compilation Unit of /GoComponentToResidentModelElement.java 
 

//#if 1567140371 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 2140898706 
import java.util.ArrayList;
//#endif 


//#if -1012018673 
import java.util.Collection;
//#endif 


//#if -1307805996 
import java.util.Collections;
//#endif 


//#if 1991915199 
import java.util.Iterator;
//#endif 


//#if -1173411929 
import java.util.Set;
//#endif 


//#if 79417020 
import org.argouml.i18n.Translator;
//#endif 


//#if 1938380674 
import org.argouml.model.Model;
//#endif 


//#if -1222046611 
public class GoComponentToResidentModelElement extends 
//#if 191753796 
AbstractPerspectiveRule
//#endif 

  { 

//#if -793326572 
public Collection getChildren(Object parent)
    { 

//#if -1498604646 
if(Model.getFacade().isAComponent(parent))//1
{ 

//#if 1999128885 
Iterator eri =
                Model.getFacade().getResidentElements(parent).iterator();
//#endif 


//#if -1874696243 
Collection result = new ArrayList();
//#endif 


//#if 1073075201 
while (eri.hasNext()) //1
{ 

//#if 1390726397 
result.add(Model.getFacade().getResident(eri.next()));
//#endif 

} 

//#endif 


//#if 1559738338 
return result;
//#endif 

} 

//#endif 


//#if 878971180 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1824473426 
public String getRuleName()
    { 

//#if -1496781060 
return Translator.localize("misc.component.resident.modelelement");
//#endif 

} 

//#endif 


//#if -1967292720 
public Set getDependencies(Object parent)
    { 

//#if -1621066505 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

