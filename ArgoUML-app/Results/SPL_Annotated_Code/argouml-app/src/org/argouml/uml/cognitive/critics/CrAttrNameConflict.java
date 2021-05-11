// Compilation Unit of /CrAttrNameConflict.java 
 

//#if COGNITIVE 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.Collection;
//#endif 


//#if COGNITIVE 
import java.util.HashSet;
//#endif 


//#if COGNITIVE 
import java.util.Iterator;
//#endif 


//#if COGNITIVE 
import java.util.Set;
//#endif 


//#if COGNITIVE 
import javax.swing.Icon;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Critic;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Designer;
//#endif 


//#if COGNITIVE 
import org.argouml.model.Model;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if COGNITIVE 
public class CrAttrNameConflict extends CrUML
  { 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 
return NO_PROBLEM;
} 

Collection<String> namesSeen = new ArrayList<String>();
Iterator attrs = Model.getFacade().getAttributes(dm).iterator();
while (attrs.hasNext()) //1
{ 
String name = Model.getFacade().getName(attrs.next());
if(name == null || name.length() == 0)//1
{ 
continue;
} 

if(namesSeen.contains(name))//1
{ 
return PROBLEM_FOUND;
} 

namesSeen.add(name);
} 

return NO_PROBLEM;
} 

@Override
    public Icon getClarifier()
    { 
return ClAttributeCompartment.getTheInstance();
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getClassifier());
return ret;
} 

public CrAttrNameConflict()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.INHERITANCE);
addSupportedDecision(UMLDecision.STORAGE);
addSupportedDecision(UMLDecision.NAMING);
setKnowledgeTypes(Critic.KT_SYNTAX);
addTrigger("structuralFeature");
addTrigger("feature_name");
} 

 } 

//#endif 


