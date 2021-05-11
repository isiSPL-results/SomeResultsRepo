
//#if 72670046 
// Compilation Unit of /CrOCL.java 
 

//#if -1665355478 
package org.argouml.profile.internal.ocl;
//#endif 


//#if 2100741306 
import java.util.List;
//#endif 


//#if -1733144804 
import java.util.Set;
//#endif 


//#if 1671330859 
import org.argouml.cognitive.Decision;
//#endif 


//#if -1319422212 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1455559438 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 1958386604 
import org.argouml.profile.internal.ocl.uml14.Uml14ModelInterpreter;
//#endif 


//#if 394349561 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 916128851 
import org.argouml.uml.cognitive.critics.CrUML;
//#endif 


//#if 664024088 
public class CrOCL extends 
//#if -1280595181 
CrUML
//#endif 

  { 

//#if -1130376994 
private OclInterpreter interpreter = null;
//#endif 


//#if 1818771469 
private String ocl = null;
//#endif 


//#if 1883400513 
private Set<Object> designMaterials;
//#endif 


//#if 1558827311 
public String getOCL()
    { 

//#if -622567718 
return ocl;
//#endif 

} 

//#endif 


//#if -1662212952 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -265681562 
if(!interpreter.applicable(dm))//1
{ 

//#if 1517977510 
return NO_PROBLEM;
//#endif 

} 
else
{ 

//#if 1394907407 
if(interpreter.check(dm))//1
{ 

//#if -1055203185 
return NO_PROBLEM;
//#endif 

} 
else
{ 

//#if 245656809 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1828282569 
@Override
    public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1775910633 
return designMaterials;
//#endif 

} 

//#endif 


//#if -25274336 
public CrOCL(String oclConstraint, String headline, String description,
                 Integer priority, List<Decision> supportedDecisions,
                 List<String> knowledgeTypes, String moreInfoURL)
    throws InvalidOclException
    { 

//#if -818725468 
interpreter =
            new OclInterpreter(oclConstraint, new Uml14ModelInterpreter());
//#endif 


//#if -1092244430 
this.ocl = oclConstraint;
//#endif 


//#if -716911563 
addSupportedDecision(UMLDecision.PLANNED_EXTENSIONS);
//#endif 


//#if 1794883017 
setPriority(ToDoItem.HIGH_PRIORITY);
//#endif 


//#if 41494279 
List<String> triggers = interpreter.getTriggers();
//#endif 


//#if -623488614 
designMaterials = interpreter.getCriticizedDesignMaterials();
//#endif 


//#if 48558483 
for (String string : triggers) //1
{ 

//#if -865231547 
addTrigger(string);
//#endif 

} 

//#endif 


//#if 879274853 
if(headline == null)//1
{ 

//#if 981760188 
super.setHeadline("OCL Expression");
//#endif 

} 
else
{ 

//#if 908735455 
super.setHeadline(headline);
//#endif 

} 

//#endif 


//#if -111549047 
if(description == null)//1
{ 

//#if -232277154 
super.setDescription("");
//#endif 

} 
else
{ 

//#if 1342135080 
super.setDescription(description);
//#endif 

} 

//#endif 


//#if 1976505141 
if(priority == null)//1
{ 

//#if -237217502 
setPriority(ToDoItem.HIGH_PRIORITY);
//#endif 

} 
else
{ 

//#if 1658668426 
setPriority(priority);
//#endif 

} 

//#endif 


//#if 729131126 
if(supportedDecisions != null)//1
{ 

//#if -178882738 
for (Decision d : supportedDecisions) //1
{ 

//#if 1462015732 
addSupportedDecision(d);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1788166520 
if(knowledgeTypes != null)//1
{ 

//#if -633161526 
for (String k : knowledgeTypes) //1
{ 

//#if -1451614063 
addKnowledgeType(k);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1015046411 
if(moreInfoURL != null)//1
{ 

//#if 712543316 
setMoreInfoURL(moreInfoURL);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

