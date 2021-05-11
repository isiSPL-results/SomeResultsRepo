
//#if 639232498 
// Compilation Unit of /CrNameConflictAC.java 
 

//#if -164484337 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 785744170 
import java.util.HashSet;
//#endif 


//#if -537826180 
import java.util.Set;
//#endif 


//#if -2141315021 
import org.argouml.cognitive.Critic;
//#endif 


//#if 760120732 
import org.argouml.cognitive.Designer;
//#endif 


//#if -928033257 
import org.argouml.model.Model;
//#endif 


//#if 1553353049 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1210902529 
public class CrNameConflictAC extends 
//#if 891683639 
CrUML
//#endif 

  { 

//#if -1364753466 
public CrNameConflictAC()
    { 

//#if 887811035 
setupHeadAndDesc();
//#endif 


//#if 884027043 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if -1310867376 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 

} 

//#endif 


//#if -711876996 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1998382064 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1862328291 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1154777178 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 790668034 
ret.add(Model.getMetaTypes().getAssociationClass());
//#endif 


//#if 1976143074 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

