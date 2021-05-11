// Compilation Unit of /CrOCL.java 
 

//#if COGNITIVE 
package org.argouml.profile.internal.ocl;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if COGNITIVE 
import java.util.Set;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Decision;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Designer;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.profile.internal.ocl.uml14.Uml14ModelInterpreter;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrUML;
//#endif 


//#if COGNITIVE 
public class CrOCL extends CrUML
  { 
private OclInterpreter interpreter = null;
private String ocl = null;
private Set<Object> designMaterials;
public String getOCL()
    { 
return ocl;
} 

@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!interpreter.applicable(dm))//1
{ 
return NO_PROBLEM;
} 
else
{ 
if(interpreter.check(dm))//1
{ 
return NO_PROBLEM;
} 
else
{ 
return PROBLEM_FOUND;
} 

} 

} 

@Override
    public Set<Object> getCriticizedDesignMaterials()
    { 
return designMaterials;
} 

public CrOCL(String oclConstraint, String headline, String description,
                 Integer priority, List<Decision> supportedDecisions,
                 List<String> knowledgeTypes, String moreInfoURL)
    throws InvalidOclException
    { 
interpreter =
            new OclInterpreter(oclConstraint, new Uml14ModelInterpreter());
this.ocl = oclConstraint;
addSupportedDecision(UMLDecision.PLANNED_EXTENSIONS);
setPriority(ToDoItem.HIGH_PRIORITY);
List<String> triggers = interpreter.getTriggers();
designMaterials = interpreter.getCriticizedDesignMaterials();
for (String string : triggers) //1
{ 
addTrigger(string);
} 

if(headline == null)//1
{ 
super.setHeadline("OCL Expression");
} 
else
{ 
super.setHeadline(headline);
} 

if(description == null)//1
{ 
super.setDescription("");
} 
else
{ 
super.setDescription(description);
} 

if(priority == null)//1
{ 
setPriority(ToDoItem.HIGH_PRIORITY);
} 
else
{ 
setPriority(priority);
} 

if(supportedDecisions != null)//1
{ 
for (Decision d : supportedDecisions) //1
{ 
addSupportedDecision(d);
} 

} 

if(knowledgeTypes != null)//1
{ 
for (String k : knowledgeTypes) //1
{ 
addKnowledgeType(k);
} 

} 

if(moreInfoURL != null)//1
{ 
setMoreInfoURL(moreInfoURL);
} 

} 

 } 

//#endif 


