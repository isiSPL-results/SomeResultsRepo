// Compilation Unit of /CrDisambigStateName.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.Icon;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrDisambigStateName extends CrUML
  { 
private static final long serialVersionUID = 5027208502429769593L;
public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAState(dm)))//1
{ 
return NO_PROBLEM;
} 

String myName = Model.getFacade().getName(dm);
if(myName == null || myName.equals(""))//1
{ 
return NO_PROBLEM;
} 

String myNameString = myName;
if(myNameString.length() == 0)//1
{ 
return NO_PROBLEM;
} 

Collection pkgs = Model.getFacade().getElementImports2(dm);
if(pkgs == null)//1
{ 
return NO_PROBLEM;
} 

for (Iterator iter = pkgs.iterator(); iter.hasNext();) //1
{ 
Object imp = iter.next();
Object ns = Model.getFacade().getPackage(imp);
if(ns == null)//1
{ 
return NO_PROBLEM;
} 

Collection oes = Model.getFacade().getOwnedElements(ns);
if(oes == null)//1
{ 
return NO_PROBLEM;
} 

Iterator elems = oes.iterator();
while (elems.hasNext()) //1
{ 
Object eo = elems.next();
Object me = Model.getFacade().getModelElement(eo);
if(!(Model.getFacade().isAClassifier(me)))//1
{ 
continue;
} 

if(me == dm)//1
{ 
continue;
} 

String meName = Model.getFacade().getName(me);
if(meName == null || meName.equals(""))//1
{ 
continue;
} 

if(meName.equals(myNameString))//1
{ 
return PROBLEM_FOUND;
} 

} 

} 

return NO_PROBLEM;
} 

public Icon getClarifier()
    { 
return ClClassName.getTheInstance();
} 

public CrDisambigStateName()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.NAMING);
setKnowledgeTypes(Critic.KT_SYNTAX);
addTrigger("name");
addTrigger("parent");
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getState());
return ret;
} 

 } 


