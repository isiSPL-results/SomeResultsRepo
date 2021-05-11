
//#if -201872203 
// Compilation Unit of /GoNamespaceToClassifierAndPackage.java 
 

//#if 1976091956 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 689771793 
import java.util.ArrayList;
//#endif 


//#if 1247687280 
import java.util.Collection;
//#endif 


//#if 23601811 
import java.util.Collections;
//#endif 


//#if 1195971092 
import java.util.HashSet;
//#endif 


//#if 421084000 
import java.util.Iterator;
//#endif 


//#if -259425616 
import java.util.List;
//#endif 


//#if 1238762086 
import java.util.Set;
//#endif 


//#if 1697738555 
import org.argouml.i18n.Translator;
//#endif 


//#if 1521028993 
import org.argouml.model.Model;
//#endif 


//#if -1291876745 
public class GoNamespaceToClassifierAndPackage extends 
//#if 948005935 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1561661315 
public String getRuleName()
    { 

//#if -152881296 
return Translator.localize("misc.namespace.classifer-or-package");
//#endif 

} 

//#endif 


//#if -64174785 
public Collection getChildren(Object parent)
    { 

//#if 358078188 
if(!Model.getFacade().isANamespace(parent))//1
{ 

//#if 2033967959 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1885651548 
Iterator elements =
            Model.getFacade().getOwnedElements(parent).iterator();
//#endif 


//#if 1933894354 
List result = new ArrayList();
//#endif 


//#if 589509895 
while (elements.hasNext()) //1
{ 

//#if -1668754394 
Object element = elements.next();
//#endif 


//#if -1722641290 
if(Model.getFacade().isAPackage(element)
                    || Model.getFacade().isAClassifier(element))//1
{ 

//#if -1375088106 
result.add(element);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 398214077 
return result;
//#endif 

} 

//#endif 


//#if 2139557253 
public Set getDependencies(Object parent)
    { 

//#if -191791084 
if(Model.getFacade().isANamespace(parent))//1
{ 

//#if -1832822130 
Set set = new HashSet();
//#endif 


//#if -715320524 
set.add(parent);
//#endif 


//#if -2100143570 
return set;
//#endif 

} 

//#endif 


//#if 713815184 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

