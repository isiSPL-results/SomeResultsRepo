
//#if -997919763 
// Compilation Unit of /PredicateSearch.java 
 

//#if -769122995 
package org.argouml.uml;
//#endif 


//#if 417827542 
import org.argouml.model.Model;
//#endif 


//#if 1112152981 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 122552433 
import org.argouml.util.Predicate;
//#endif 


//#if -1206107773 
import org.argouml.util.PredicateTrue;
//#endif 


//#if -84061427 
public class PredicateSearch implements 
//#if 1896852384 
Predicate
//#endif 

  { 

//#if -1990539713 
private Predicate elementName;
//#endif 


//#if 1000632117 
private Predicate packageName;
//#endif 


//#if 50791112 
private Predicate diagramName;
//#endif 


//#if 1205691547 
private Predicate theType;
//#endif 


//#if -33224936 
private Predicate specific = PredicateTrue.getInstance();
//#endif 


//#if 321137755 
public boolean matchPackage(Object pkg)
    { 

//#if 122196969 
boolean res = packageName.evaluate(Model.getFacade().getName(pkg));
//#endif 


//#if -868021617 
return res;
//#endif 

} 

//#endif 


//#if -384487766 
public PredicateSearch(Predicate elementNamePredicate,
                           Predicate packageNamePredicate, Predicate diagramNamePredicate,
                           Predicate typePredicate)
    { 

//#if -285798616 
elementName = elementNamePredicate;
//#endif 


//#if 2079180732 
packageName = packageNamePredicate;
//#endif 


//#if 1740505046 
diagramName = diagramNamePredicate;
//#endif 


//#if -137668995 
theType = typePredicate;
//#endif 

} 

//#endif 


//#if -1127609925 
public boolean matchDiagram(String name)
    { 

//#if 934054063 
return diagramName.evaluate(name);
//#endif 

} 

//#endif 


//#if -1043110573 
public boolean evaluate(Object element)
    { 

//#if -1218686824 
if(!(Model.getFacade().isAUMLElement(element)))//1
{ 

//#if 885026409 
return false;
//#endif 

} 

//#endif 


//#if 323620820 
Object me = element;
//#endif 


//#if 1120911370 
return theType.evaluate(me) && specific.evaluate(me)
               && elementName.evaluate(Model.getFacade().getName(me));
//#endif 

} 

//#endif 


//#if 1580643230 
public boolean matchDiagram(ArgoDiagram diagram)
    { 

//#if -1347083132 
return matchDiagram(diagram.getName());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

