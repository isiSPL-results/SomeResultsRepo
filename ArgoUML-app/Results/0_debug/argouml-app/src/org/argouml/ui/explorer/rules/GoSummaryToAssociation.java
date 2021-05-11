
//#if -972659521 
// Compilation Unit of /GoSummaryToAssociation.java 
 

//#if 1495911579 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 2121727639 
import java.util.Collection;
//#endif 


//#if 1349049164 
import java.util.Collections;
//#endif 


//#if 1869418317 
import java.util.HashSet;
//#endif 


//#if -462191585 
import java.util.Set;
//#endif 


//#if 690551092 
import org.argouml.i18n.Translator;
//#endif 


//#if -329351686 
import org.argouml.model.Model;
//#endif 


//#if 1258289110 
public class GoSummaryToAssociation extends 
//#if 1278590357 
AbstractPerspectiveRule
//#endif 

  { 

//#if -441333467 
public Collection getChildren(Object parent)
    { 

//#if -1723143173 
if(parent instanceof AssociationsNode)//1
{ 

//#if 95465155 
return Model.getCoreHelper()
                   .getAssociations(((AssociationsNode) parent).getParent());
//#endif 

} 

//#endif 


//#if -772569482 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1697611677 
public String getRuleName()
    { 

//#if 1584325635 
return Translator.localize("misc.summary.association");
//#endif 

} 

//#endif 


//#if 346358623 
public Set getDependencies(Object parent)
    { 

//#if 1201445202 
if(parent instanceof AssociationsNode)//1
{ 

//#if -2111468470 
Set set = new HashSet();
//#endif 


//#if -1272131325 
set.add(((AssociationsNode) parent).getParent());
//#endif 


//#if 440026858 
return set;
//#endif 

} 

//#endif 


//#if -1207383681 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

