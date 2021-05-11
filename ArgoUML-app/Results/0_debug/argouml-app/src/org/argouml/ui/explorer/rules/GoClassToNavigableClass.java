
//#if 235766772 
// Compilation Unit of /GoClassToNavigableClass.java 
 

//#if -1039672467 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -112351112 
import java.util.ArrayList;
//#endif 


//#if -2143286295 
import java.util.Collection;
//#endif 


//#if -2017363910 
import java.util.Collections;
//#endif 


//#if -1249553605 
import java.util.HashSet;
//#endif 


//#if 1919229721 
import java.util.Iterator;
//#endif 


//#if -985259287 
import java.util.List;
//#endif 


//#if 1630990093 
import java.util.Set;
//#endif 


//#if -123229278 
import org.argouml.i18n.Translator;
//#endif 


//#if -1341941912 
import org.argouml.model.Model;
//#endif 


//#if -1003266264 
public class GoClassToNavigableClass extends 
//#if -2017770871 
AbstractPerspectiveRule
//#endif 

  { 

//#if 180582681 
public Collection getChildren(Object parent)
    { 

//#if -1786979068 
if(!Model.getFacade().isAClass(parent))//1
{ 

//#if -1296444220 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -573984998 
List childClasses = new ArrayList();
//#endif 


//#if 1782296580 
Collection ends = Model.getFacade().getAssociationEnds(parent);
//#endif 


//#if -2097087898 
if(ends == null)//1
{ 

//#if 78919148 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 596469038 
Iterator it = ends.iterator();
//#endif 


//#if -782826442 
while (it.hasNext()) //1
{ 

//#if -1456614682 
Object ae = /*(MAssociationEnd)*/ it.next();
//#endif 


//#if 1055213598 
Object asc = Model.getFacade().getAssociation(ae);
//#endif 


//#if -1766751930 
Collection allEnds = Model.getFacade().getConnections(asc);
//#endif 


//#if 1936290889 
Object otherEnd = null;
//#endif 


//#if 1079473386 
Iterator endIt = allEnds.iterator();
//#endif 


//#if -555771861 
if(endIt.hasNext())//1
{ 

//#if -802620624 
otherEnd = /*(MAssociationEnd)*/ endIt.next();
//#endif 


//#if -1053143195 
if(ae != otherEnd && endIt.hasNext())//1
{ 

//#if -409839059 
otherEnd = /*(MAssociationEnd)*/ endIt.next();
//#endif 


//#if 641597166 
if(ae != otherEnd)//1
{ 

//#if 621763921 
otherEnd = null;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 676188605 
if(otherEnd == null)//1
{ 

//#if -991222668 
continue;
//#endif 

} 

//#endif 


//#if 739690927 
if(!Model.getFacade().isNavigable(otherEnd))//1
{ 

//#if -2041538605 
continue;
//#endif 

} 

//#endif 


//#if -1302115051 
if(childClasses.contains(Model.getFacade().getType(otherEnd)))//1
{ 

//#if -2054534039 
continue;
//#endif 

} 

//#endif 


//#if 642792915 
childClasses.add(Model.getFacade().getType(otherEnd));
//#endif 

} 

//#endif 


//#if 2079250613 
return childClasses;
//#endif 

} 

//#endif 


//#if 185112663 
public String getRuleName()
    { 

//#if 639628447 
return Translator.localize("misc.class.navigable-class");
//#endif 

} 

//#endif 


//#if -202475541 
public Set getDependencies(Object parent)
    { 

//#if -1611702450 
if(Model.getFacade().isAClass(parent))//1
{ 

//#if 2044723108 
Set set = new HashSet();
//#endif 


//#if 1217770314 
set.add(parent);
//#endif 


//#if 1957839556 
return set;
//#endif 

} 

//#endif 


//#if -14702637 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

