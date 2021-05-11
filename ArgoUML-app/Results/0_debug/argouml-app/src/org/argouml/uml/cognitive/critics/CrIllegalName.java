
//#if -1888280459 
// Compilation Unit of /CrIllegalName.java 
 

//#if 1989305675 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -277604498 
import java.util.HashSet;
//#endif 


//#if 180208832 
import java.util.Set;
//#endif 


//#if -1918668749 
import javax.swing.Icon;
//#endif 


//#if -797098536 
import org.argouml.cognitive.Designer;
//#endif 


//#if 246229339 
import org.argouml.model.Model;
//#endif 


//#if -1699801699 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 702866885 
public class CrIllegalName extends 
//#if -908912497 
CrUML
//#endif 

  { 

//#if -1210388268 
public CrIllegalName()
    { 

//#if 726623705 
setupHeadAndDesc();
//#endif 


//#if -1766132191 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if 1503851234 
addTrigger("name");
//#endif 

} 

//#endif 


//#if 552407682 
public Icon getClarifier()
    { 

//#if -1952903776 
return ClClassName.getTheInstance();
//#endif 

} 

//#endif 


//#if 134334267 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1683601441 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -1537149292 
ret.add(Model.getMetaTypes().getUMLClass());
//#endif 


//#if 500874415 
ret.add(Model.getMetaTypes().getInterface());
//#endif 


//#if -1211842425 
ret.add(Model.getMetaTypes().getAssociationClass());
//#endif 


//#if 76832221 
ret.add(Model.getMetaTypes().getOperation());
//#endif 


//#if -394573025 
ret.add(Model.getMetaTypes().getParameter());
//#endif 


//#if 1933975943 
ret.add(Model.getMetaTypes().getState());
//#endif 


//#if 1070543015 
return ret;
//#endif 

} 

//#endif 


//#if 2141875236 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1779545993 
if(!(Model.getFacade().isAModelElement(dm)))//1
{ 

//#if -222272171 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1464240582 
Object me = dm;
//#endif 


//#if 1815276930 
String meName = Model.getFacade().getName(me);
//#endif 


//#if 1502802232 
if(meName == null || meName.equals(""))//1
{ 

//#if 940419061 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1982416010 
String nameStr = meName;
//#endif 


//#if -1309321297 
int len = nameStr.length();
//#endif 


//#if 842690339 
for (int i = 0; i < len; i++) //1
{ 

//#if -1308877938 
char c = nameStr.charAt(i);
//#endif 


//#if 1867313673 
if(!(Character.isLetterOrDigit(c) || c == '_'
                    || (c == ' ' && Model.getFacade().isAStateVertex(me))))//1
{ 

//#if -1304129007 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1790702896 
return NO_PROBLEM;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

