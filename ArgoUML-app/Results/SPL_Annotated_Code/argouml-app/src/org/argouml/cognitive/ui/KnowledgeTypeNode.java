// Compilation Unit of /KnowledgeTypeNode.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Critic;
//#endif 


//#if COGNITIVE 
public class KnowledgeTypeNode  { 
private static List<KnowledgeTypeNode> types = null;
private String name;
public static List<KnowledgeTypeNode> getTypeList()
    { 
if(types == null)//1
{ 
types = new ArrayList<KnowledgeTypeNode>();
types.add(new KnowledgeTypeNode(Critic.KT_DESIGNERS));
types.add(new KnowledgeTypeNode(Critic.KT_CORRECTNESS));
types.add(new KnowledgeTypeNode(Critic.KT_COMPLETENESS));
types.add(new KnowledgeTypeNode(Critic.KT_CONSISTENCY));
types.add(new KnowledgeTypeNode(Critic.KT_SYNTAX));
types.add(new KnowledgeTypeNode(Critic.KT_SEMANTICS));
types.add(new KnowledgeTypeNode(Critic.KT_OPTIMIZATION));
types.add(new KnowledgeTypeNode(Critic.KT_PRESENTATION));
types.add(new KnowledgeTypeNode(Critic.KT_ORGANIZATIONAL));
types.add(new KnowledgeTypeNode(Critic.KT_EXPERIENCIAL));
types.add(new KnowledgeTypeNode(Critic.KT_TOOL));
} 

return types;
} 

public String toString()
    { 
return getName();
} 

public KnowledgeTypeNode(String n)
    { 
name = n;
} 

public String getName()
    { 
return name;
} 

 } 

//#endif 


