// Compilation Unit of /CrConsiderFacade.java 
 

//#if COGNITIVE 
package org.argouml.pattern.cognitive.critics;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Designer;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.critics.CrUML;
//#endif 


//#if COGNITIVE 
public class CrConsiderFacade extends CrUML
  { 
private static final long serialVersionUID = -5513915374319458662L;
public boolean predicate2(Object dm, Designer dsgr)
    { 
return NO_PROBLEM;
} 

public CrConsiderFacade()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.PATTERNS);
addTrigger("ownedElement");
} 

 } 

//#endif 


