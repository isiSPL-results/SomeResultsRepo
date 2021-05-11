
//#if -160987076 
// Compilation Unit of /CrDisambigStateName.java 
 

//#if 161805240 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1659934723 
import java.util.Collection;
//#endif 


//#if -358888095 
import java.util.HashSet;
//#endif 


//#if -534910541 
import java.util.Iterator;
//#endif 


//#if 1027370035 
import java.util.Set;
//#endif 


//#if -1367101472 
import javax.swing.Icon;
//#endif 


//#if 823843740 
import org.argouml.cognitive.Critic;
//#endif 


//#if -1580594491 
import org.argouml.cognitive.Designer;
//#endif 


//#if -821863154 
import org.argouml.model.Model;
//#endif 


//#if -1759816688 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1147004115 
public class CrDisambigStateName extends 
//#if 1710036660 
CrUML
//#endif 

  { 

//#if -1575562717 
private static final long serialVersionUID = 5027208502429769593L;
//#endif 


//#if 268884895 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 24471265 
if(!(Model.getFacade().isAState(dm)))//1
{ 

//#if -187885841 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1174710621 
String myName = Model.getFacade().getName(dm);
//#endif 


//#if 490681740 
if(myName == null || myName.equals(""))//1
{ 

//#if -615057526 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -333356938 
String myNameString = myName;
//#endif 


//#if 220840832 
if(myNameString.length() == 0)//1
{ 

//#if 1519843737 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 474705109 
Collection pkgs = Model.getFacade().getElementImports2(dm);
//#endif 


//#if -148354645 
if(pkgs == null)//1
{ 

//#if -1285029268 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1257065988 
for (Iterator iter = pkgs.iterator(); iter.hasNext();) //1
{ 

//#if 71075444 
Object imp = iter.next();
//#endif 


//#if -845526930 
Object ns = Model.getFacade().getPackage(imp);
//#endif 


//#if -1630710196 
if(ns == null)//1
{ 

//#if 1715498794 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -148206842 
Collection oes = Model.getFacade().getOwnedElements(ns);
//#endif 


//#if -848614476 
if(oes == null)//1
{ 

//#if 175701674 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 195578081 
Iterator elems = oes.iterator();
//#endif 


//#if -1048644606 
while (elems.hasNext()) //1
{ 

//#if 1026391026 
Object eo = elems.next();
//#endif 


//#if 1321454074 
Object me = Model.getFacade().getModelElement(eo);
//#endif 


//#if -861583269 
if(!(Model.getFacade().isAClassifier(me)))//1
{ 

//#if -914766395 
continue;
//#endif 

} 

//#endif 


//#if -11415701 
if(me == dm)//1
{ 

//#if 793660418 
continue;
//#endif 

} 

//#endif 


//#if 1572533971 
String meName = Model.getFacade().getName(me);
//#endif 


//#if -278095545 
if(meName == null || meName.equals(""))//1
{ 

//#if 1419698652 
continue;
//#endif 

} 

//#endif 


//#if 357771177 
if(meName.equals(myNameString))//1
{ 

//#if -814476722 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 2064761556 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 21647421 
public Icon getClarifier()
    { 

//#if 635203112 
return ClClassName.getTheInstance();
//#endif 

} 

//#endif 


//#if 1663748910 
public CrDisambigStateName()
    { 

//#if 968067435 
setupHeadAndDesc();
//#endif 


//#if 442253363 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if -539888448 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if 1745294964 
addTrigger("name");
//#endif 


//#if -1208743627 
addTrigger("parent");
//#endif 

} 

//#endif 


//#if -2093791456 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -922667898 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 1658324288 
ret.add(Model.getMetaTypes().getState());
//#endif 


//#if -601284594 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

