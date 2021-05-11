
//#if 566155677 
// Compilation Unit of /CrAttrNameConflict.java 
 

//#if -686986765 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 295529539 
import java.util.ArrayList;
//#endif 


//#if 1911079294 
import java.util.Collection;
//#endif 


//#if 435785158 
import java.util.HashSet;
//#endif 


//#if -1669843474 
import java.util.Iterator;
//#endif 


//#if 1382819608 
import java.util.Set;
//#endif 


//#if 736743131 
import javax.swing.Icon;
//#endif 


//#if -88385001 
import org.argouml.cognitive.Critic;
//#endif 


//#if -2059086208 
import org.argouml.cognitive.Designer;
//#endif 


//#if -806978125 
import org.argouml.model.Model;
//#endif 


//#if 645001205 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -742861678 
public class CrAttrNameConflict extends 
//#if 1787865561 
CrUML
//#endif 

  { 

//#if -1745934866 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 146857604 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 

//#if 2023401490 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1504667336 
Collection<String> namesSeen = new ArrayList<String>();
//#endif 


//#if 721189255 
Iterator attrs = Model.getFacade().getAttributes(dm).iterator();
//#endif 


//#if -2038362782 
while (attrs.hasNext()) //1
{ 

//#if -1005063859 
String name = Model.getFacade().getName(attrs.next());
//#endif 


//#if 1759407132 
if(name == null || name.length() == 0)//1
{ 

//#if -847140619 
continue;
//#endif 

} 

//#endif 


//#if 296682468 
if(namesSeen.contains(name))//1
{ 

//#if -1381122812 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 83437790 
namesSeen.add(name);
//#endif 

} 

//#endif 


//#if -838726823 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1586806836 
@Override
    public Icon getClarifier()
    { 

//#if -1926148078 
return ClAttributeCompartment.getTheInstance();
//#endif 

} 

//#endif 


//#if -1054598139 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1332362419 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 1699866053 
ret.add(Model.getMetaTypes().getClassifier());
//#endif 


//#if 73500283 
return ret;
//#endif 

} 

//#endif 


//#if -1410644781 
public CrAttrNameConflict()
    { 

//#if 31037625 
setupHeadAndDesc();
//#endif 


//#if -1886617995 
addSupportedDecision(UMLDecision.INHERITANCE);
//#endif 


//#if -1852037018 
addSupportedDecision(UMLDecision.STORAGE);
//#endif 


//#if 622444801 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if 421440306 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if 1224349730 
addTrigger("structuralFeature");
//#endif 


//#if 645367929 
addTrigger("feature_name");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

