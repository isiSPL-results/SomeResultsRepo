package org.argouml.pattern.cognitive.critics;
import org.argouml.cognitive.Designer;
import org.argouml.uml.cognitive.UMLDecision;
import org.argouml.uml.cognitive.critics.CrUML;
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
