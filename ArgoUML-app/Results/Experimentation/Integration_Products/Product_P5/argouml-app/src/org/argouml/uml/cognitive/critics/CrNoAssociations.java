package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrNoAssociations extends CrUML
  { 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getUMLClass());
ret.add(Model.getMetaTypes().getActor());
ret.add(Model.getMetaTypes().getUseCase());
return ret;
} 
private boolean findAssociation(Object dm, int depth)
    { 
if(Model.getFacade().getAssociationEnds(dm).iterator().hasNext())//1
{ 
return true;
} 
if(depth > 50)//1
{ 
return false;
} 
Iterator iter = Model.getFacade().getGeneralizations(dm).iterator();
while (iter.hasNext()) //1
{ 
Object parent = Model.getFacade().getGeneral(iter.next());
if(parent == dm)//1
{ 
continue;
} 
if(Model.getFacade().isAClassifier(parent))//1
if(findAssociation(parent, depth + 1))//1
{ 
return true;
} 
} 
if(Model.getFacade().isAUseCase(dm))//1
{ 
Iterator iter2 = Model.getFacade().getExtends(dm).iterator();
while (iter2.hasNext()) //1
{ 
Object parent = Model.getFacade().getExtension(iter2.next());
if(parent == dm)//1
{ 
continue;
} 
if(Model.getFacade().isAClassifier(parent))//1
if(findAssociation(parent, depth + 1))//1
{ 
return true;
} 
} 
Iterator iter3 = Model.getFacade().getIncludes(dm).iterator();
while (iter3.hasNext()) //1
{ 
Object parent = Model.getFacade().getBase(iter3.next());
if(parent == dm)//1
{ 
continue;
} 
if(Model.getFacade().isAClassifier(parent))//1
if(findAssociation(parent, depth + 1))//1
{ 
return true;
} 
} 
} 
return false;
} 
public CrNoAssociations()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.RELATIONSHIPS);
setKnowledgeTypes(Critic.KT_COMPLETENESS);
addTrigger("associationEnd");
} 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 
return NO_PROBLEM;
} 
if(!(Model.getFacade().isPrimaryObject(dm)))//1
{ 
return NO_PROBLEM;
} 
if((Model.getFacade().getName(dm) == null)
                || ("".equals(Model.getFacade().getName(dm))))//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().isAGeneralizableElement(dm)
                && Model.getFacade().isAbstract(dm))//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().isType(dm))//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().isUtility(dm))//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().getClientDependencies(dm).size() > 0)//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().getSupplierDependencies(dm).size() > 0)//1
{ 
return NO_PROBLEM;
} 
if(Model.getFacade().isAUseCase(dm))//1
{ 
Object usecase = dm;
Collection includes = Model.getFacade().getIncludes(usecase);
if(includes != null && includes.size() >= 1)//1
{ 
return NO_PROBLEM;
} 
Collection extend = Model.getFacade().getExtends(usecase);
if(extend != null && extend.size() >= 1)//1
{ 
return NO_PROBLEM;
} 
} 
if(findAssociation(dm, 0))//1
{ 
return NO_PROBLEM;
} 
return PROBLEM_FOUND;
} 

 } 
