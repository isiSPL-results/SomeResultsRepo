
//#if 1524547423 
// Compilation Unit of /GoProjectToDiagram.java 
 

//#if 797541337 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 624495445 
import java.util.Collection;
//#endif 


//#if -2115475890 
import java.util.Collections;
//#endif 


//#if 1365717281 
import java.util.Set;
//#endif 


//#if 1801501366 
import org.argouml.i18n.Translator;
//#endif 


//#if -239975154 
import org.argouml.kernel.Project;
//#endif 


//#if 1513939411 
public class GoProjectToDiagram extends 
//#if -60054277 
AbstractPerspectiveRule
//#endif 

  { 

//#if -2101419253 
public Collection getChildren(Object parent)
    { 

//#if -1451481924 
if(parent instanceof Project)//1
{ 

//#if 1592175326 
return ((Project) parent).getDiagramList();
//#endif 

} 

//#endif 


//#if -1546624080 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 355083849 
public String getRuleName()
    { 

//#if 1333365175 
return Translator.localize("misc.project.diagram");
//#endif 

} 

//#endif 


//#if -752704711 
public Set getDependencies(Object parent)
    { 

//#if -1153403561 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

