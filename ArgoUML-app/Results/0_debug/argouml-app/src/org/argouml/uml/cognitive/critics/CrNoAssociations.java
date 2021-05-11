
//#if -144861617 
// Compilation Unit of /CrNoAssociations.java 
 

//#if -1560966272 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 2064575947 
import java.util.Collection;
//#endif 


//#if 111840409 
import java.util.HashSet;
//#endif 


//#if 1172771195 
import java.util.Iterator;
//#endif 


//#if -247756949 
import java.util.Set;
//#endif 


//#if -645207708 
import org.argouml.cognitive.Critic;
//#endif 


//#if -294795635 
import org.argouml.cognitive.Designer;
//#endif 


//#if -2128358842 
import org.argouml.model.Model;
//#endif 


//#if 13256520 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 433566276 
public class CrNoAssociations extends 
//#if -1773278091 
CrUML
//#endif 

  { 

//#if -2096211039 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 137676721 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 908297318 
ret.add(Model.getMetaTypes().getUMLClass());
//#endif 


//#if 1607092313 
ret.add(Model.getMetaTypes().getActor());
//#endif 


//#if -233390469 
ret.add(Model.getMetaTypes().getUseCase());
//#endif 


//#if -2045979911 
return ret;
//#endif 

} 

//#endif 


//#if 2000540006 
private boolean findAssociation(Object dm, int depth)
    { 

//#if -1653324151 
if(Model.getFacade().getAssociationEnds(dm).iterator().hasNext())//1
{ 

//#if -659132737 
return true;
//#endif 

} 

//#endif 


//#if -90609379 
if(depth > 50)//1
{ 

//#if -843746475 
return false;
//#endif 

} 

//#endif 


//#if -608498524 
Iterator iter = Model.getFacade().getGeneralizations(dm).iterator();
//#endif 


//#if -227005501 
while (iter.hasNext()) //1
{ 

//#if 1933071911 
Object parent = Model.getFacade().getGeneral(iter.next());
//#endif 


//#if -1978973167 
if(parent == dm)//1
{ 

//#if 78602106 
continue;
//#endif 

} 

//#endif 


//#if 1478576319 
if(Model.getFacade().isAClassifier(parent))//1

//#if 644470474 
if(findAssociation(parent, depth + 1))//1
{ 

//#if 882257165 
return true;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -448145919 
if(Model.getFacade().isAUseCase(dm))//1
{ 

//#if -365027526 
Iterator iter2 = Model.getFacade().getExtends(dm).iterator();
//#endif 


//#if 1552163805 
while (iter2.hasNext()) //1
{ 

//#if 1021395575 
Object parent = Model.getFacade().getExtension(iter2.next());
//#endif 


//#if 2085657778 
if(parent == dm)//1
{ 

//#if 963885162 
continue;
//#endif 

} 

//#endif 


//#if -1349328962 
if(Model.getFacade().isAClassifier(parent))//1

//#if -1722532433 
if(findAssociation(parent, depth + 1))//1
{ 

//#if 639713078 
return true;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1803162487 
Iterator iter3 = Model.getFacade().getIncludes(dm).iterator();
//#endif 


//#if -1235251682 
while (iter3.hasNext()) //1
{ 

//#if 404521627 
Object parent = Model.getFacade().getBase(iter3.next());
//#endif 


//#if 827652081 
if(parent == dm)//1
{ 

//#if 814562995 
continue;
//#endif 

} 

//#endif 


//#if 1418633439 
if(Model.getFacade().isAClassifier(parent))//1

//#if 539992269 
if(findAssociation(parent, depth + 1))//1
{ 

//#if -1545967968 
return true;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -112566668 
return false;
//#endif 

} 

//#endif 


//#if 1722958044 
public CrNoAssociations()
    { 

//#if -1901550679 
setupHeadAndDesc();
//#endif 


//#if 1743869814 
addSupportedDecision(UMLDecision.RELATIONSHIPS);
//#endif 


//#if -180871057 
setKnowledgeTypes(Critic.KT_COMPLETENESS);
//#endif 


//#if 611835139 
addTrigger("associationEnd");
//#endif 

} 

//#endif 


//#if 14551434 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1308192507 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 

//#if -2008527620 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1809881692 
if(!(Model.getFacade().isPrimaryObject(dm)))//1
{ 

//#if 1852466791 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1086443586 
if((Model.getFacade().getName(dm) == null)
                || ("".equals(Model.getFacade().getName(dm))))//1
{ 

//#if 1798494661 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1826136627 
if(Model.getFacade().isAGeneralizableElement(dm)
                && Model.getFacade().isAbstract(dm))//1
{ 

//#if -1392095030 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 358444023 
if(Model.getFacade().isType(dm))//1
{ 

//#if 1295724855 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 467988431 
if(Model.getFacade().isUtility(dm))//1
{ 

//#if 694501100 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1138252005 
if(Model.getFacade().getClientDependencies(dm).size() > 0)//1
{ 

//#if 955464085 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1343440518 
if(Model.getFacade().getSupplierDependencies(dm).size() > 0)//1
{ 

//#if 643987576 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -717440013 
if(Model.getFacade().isAUseCase(dm))//1
{ 

//#if 1485119630 
Object usecase = dm;
//#endif 


//#if -1203943957 
Collection includes = Model.getFacade().getIncludes(usecase);
//#endif 


//#if -353205105 
if(includes != null && includes.size() >= 1)//1
{ 

//#if -1230479861 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1691826476 
Collection extend = Model.getFacade().getExtends(usecase);
//#endif 


//#if 1828610029 
if(extend != null && extend.size() >= 1)//1
{ 

//#if -1362219715 
return NO_PROBLEM;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 652084275 
if(findAssociation(dm, 0))//1
{ 

//#if 1032377179 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -393371357 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

