
//#if 1941645612 
// Compilation Unit of /CrOperNameConflict.java 
 

//#if 2025121416 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -835651506 
import java.util.ArrayList;
//#endif 


//#if 1204205267 
import java.util.Collection;
//#endif 


//#if -2054774639 
import java.util.HashSet;
//#endif 


//#if -1567785853 
import java.util.Iterator;
//#endif 


//#if 930109283 
import java.util.Set;
//#endif 


//#if 240760496 
import javax.swing.Icon;
//#endif 


//#if 1552755308 
import org.argouml.cognitive.Critic;
//#endif 


//#if -1176246891 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1066464194 
import org.argouml.model.Model;
//#endif 


//#if 135049024 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 1551659396 
public class CrOperNameConflict extends 
//#if -1478229809 
CrUML
//#endif 

  { 

//#if -567307420 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 284392334 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 

//#if 475502395 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 532860628 
Collection operSeen = new ArrayList();
//#endif 


//#if 1311289196 
for (Object op : Model.getFacade().getOperations(dm)) //1
{ 

//#if 1430146549 
for (Object o : operSeen) //1
{ 

//#if 1659664417 
if(signaturesMatch(op, o))//1
{ 

//#if 477498609 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 771828740 
operSeen.add(op);
//#endif 

} 

//#endif 


//#if -2105689245 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -2022577862 
public CrOperNameConflict()
    { 

//#if 1425855978 
setupHeadAndDesc();
//#endif 


//#if 1792490380 
addSupportedDecision(UMLDecision.METHODS);
//#endif 


//#if 822055794 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if 1932088865 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if -1481270351 
addTrigger("behavioralFeature");
//#endif 


//#if 1445397674 
addTrigger("feature_name");
//#endif 

} 

//#endif 


//#if -288596101 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1797834213 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 1431257389 
ret.add(Model.getMetaTypes().getClassifier());
//#endif 


//#if -289638941 
return ret;
//#endif 

} 

//#endif 


//#if 1385834539 
private boolean signaturesMatch(Object op1, Object op2)
    { 

//#if 830273451 
String name1 = Model.getFacade().getName(op1);
//#endif 


//#if -972762416 
if(name1 == null)//1
{ 

//#if -961043519 
return false;
//#endif 

} 

//#endif 


//#if -1353402515 
String name2 = Model.getFacade().getName(op2);
//#endif 


//#if 1525253521 
if(name2 == null)//1
{ 

//#if -1314519641 
return false;
//#endif 

} 

//#endif 


//#if -1110622289 
if(!name1.equals(name2))//1
{ 

//#if -262469665 
return false;
//#endif 

} 

//#endif 


//#if 19044647 
Iterator params1 = Model.getFacade().getParameters(op1).iterator();
//#endif 


//#if -727054107 
Iterator params2 = Model.getFacade().getParameters(op2).iterator();
//#endif 


//#if 520560230 
while (params1.hasNext()
                && params2.hasNext()) //1
{ 

//#if 196185856 
Object p1 = null;
//#endif 


//#if -684312693 
while (p1 == null && params1.hasNext()) //1
{ 

//#if 918124014 
p1 = params1.next();
//#endif 


//#if 1049772681 
if(Model.getFacade().isReturn(p1))//1
{ 

//#if -1004470727 
p1 = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1083689537 
Object p2 = null;
//#endif 


//#if -672996566 
while (p2 == null && params1.hasNext()) //1
{ 

//#if -1760257945 
p2 = params1.next();
//#endif 


//#if -1715219536 
if(Model.getFacade().isReturn(p2))//1
{ 

//#if 571926560 
p2 = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -763377669 
if(p1 == null && p2 == null)//1
{ 

//#if -1994577902 
return true;
//#endif 

} 

//#endif 


//#if -754601285 
if(p1 == null || p2 == null)//1
{ 

//#if 194790492 
return false;
//#endif 

} 

//#endif 


//#if 1508974279 
Object p1type = Model.getFacade().getType(p1);
//#endif 


//#if 1302915084 
if(p1type == null)//1
{ 

//#if 423547508 
continue;
//#endif 

} 

//#endif 


//#if -835691801 
Object p2type = Model.getFacade().getType(p2);
//#endif 


//#if -1484500403 
if(p2type == null)//1
{ 

//#if 2015330137 
continue;
//#endif 

} 

//#endif 


//#if 784790976 
if(!p1type.equals(p2type))//1
{ 

//#if -42545126 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1800310814 
if(!params1.hasNext() && !params2.hasNext())//1
{ 

//#if 1299100852 
return true;
//#endif 

} 

//#endif 


//#if -1587348658 
return false;
//#endif 

} 

//#endif 


//#if -37279294 
@Override
    public Icon getClarifier()
    { 

//#if 1133267095 
return ClOperationCompartment.getTheInstance();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

