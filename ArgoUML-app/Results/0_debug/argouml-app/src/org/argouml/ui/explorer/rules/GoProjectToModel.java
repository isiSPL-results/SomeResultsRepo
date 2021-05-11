
//#if 1880603695 
// Compilation Unit of /GoProjectToModel.java 
 

//#if 1964433988 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 69886848 
import java.util.Collection;
//#endif 


//#if -2128473213 
import java.util.Collections;
//#endif 


//#if -381164714 
import java.util.Set;
//#endif 


//#if -443618261 
import org.argouml.i18n.Translator;
//#endif 


//#if 518885625 
import org.argouml.kernel.Project;
//#endif 


//#if 644285524 
public class GoProjectToModel extends 
//#if -714613736 
AbstractPerspectiveRule
//#endif 

  { 

//#if 1188540028 
public Set getDependencies(Object parent)
    { 

//#if 927041859 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1611331034 
public String getRuleName()
    { 

//#if -948409151 
return Translator.localize("misc.project.model");
//#endif 

} 

//#endif 


//#if 2080926952 
public Collection getChildren(Object parent)
    { 

//#if 545226478 
if(parent instanceof Project)//1
{ 

//#if 1115771013 
return ((Project) parent).getUserDefinedModelList();
//#endif 

} 

//#endif 


//#if -1075273118 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

