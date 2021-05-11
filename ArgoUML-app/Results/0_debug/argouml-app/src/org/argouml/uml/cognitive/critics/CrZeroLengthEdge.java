
//#if 1082885200 
// Compilation Unit of /CrZeroLengthEdge.java 
 

//#if 46407127 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 317704443 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1645812836 
import org.argouml.cognitive.Designer;
//#endif 


//#if 683803025 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 86943625 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 1292926707 
public class CrZeroLengthEdge extends 
//#if -1372696054 
CrUML
//#endif 

  { 

//#if -1914158628 
private static final int THRESHOLD = 20;
//#endif 


//#if 365019455 
public CrZeroLengthEdge()
    { 

//#if 1417723117 
setupHeadAndDesc();
//#endif 


//#if -1682344782 
addSupportedDecision(UMLDecision.RELATIONSHIPS);
//#endif 


//#if 470047169 
addSupportedDecision(UMLDecision.INHERITANCE);
//#endif 


//#if 1779528519 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if -1209300939 
setKnowledgeTypes(Critic.KT_PRESENTATION);
//#endif 

} 

//#endif 


//#if 337893641 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1293532736 
if(!(dm instanceof FigEdge))//1
{ 

//#if -778870578 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -128748522 
FigEdge fe = (FigEdge) dm;
//#endif 


//#if -611850403 
int length = fe.getPerimeterLength();
//#endif 


//#if -1013641777 
if(length > THRESHOLD)//1
{ 

//#if 998601018 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 263635776 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

