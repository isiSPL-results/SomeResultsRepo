
//#if 1886165127 
// Compilation Unit of /KnowledgeTypeNode.java 
 

//#if -403251621 
package org.argouml.cognitive.ui;
//#endif 


//#if -1832572204 
import java.util.ArrayList;
//#endif 


//#if -221931763 
import java.util.List;
//#endif 


//#if -1258131802 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1494489270 
public class KnowledgeTypeNode  { 

//#if 283318859 
private static List<KnowledgeTypeNode> types = null;
//#endif 


//#if -1085193904 
private String name;
//#endif 


//#if 6073752 
public static List<KnowledgeTypeNode> getTypeList()
    { 

//#if 433541975 
if(types == null)//1
{ 

//#if 1508754173 
types = new ArrayList<KnowledgeTypeNode>();
//#endif 


//#if 1841018425 
types.add(new KnowledgeTypeNode(Critic.KT_DESIGNERS));
//#endif 


//#if 1993609024 
types.add(new KnowledgeTypeNode(Critic.KT_CORRECTNESS));
//#endif 


//#if -1007947419 
types.add(new KnowledgeTypeNode(Critic.KT_COMPLETENESS));
//#endif 


//#if 885238665 
types.add(new KnowledgeTypeNode(Critic.KT_CONSISTENCY));
//#endif 


//#if -1379195086 
types.add(new KnowledgeTypeNode(Critic.KT_SYNTAX));
//#endif 


//#if -1613371500 
types.add(new KnowledgeTypeNode(Critic.KT_SEMANTICS));
//#endif 


//#if -1343562264 
types.add(new KnowledgeTypeNode(Critic.KT_OPTIMIZATION));
//#endif 


//#if -982256357 
types.add(new KnowledgeTypeNode(Critic.KT_PRESENTATION));
//#endif 


//#if 1956704919 
types.add(new KnowledgeTypeNode(Critic.KT_ORGANIZATIONAL));
//#endif 


//#if -458367556 
types.add(new KnowledgeTypeNode(Critic.KT_EXPERIENCIAL));
//#endif 


//#if -1374979107 
types.add(new KnowledgeTypeNode(Critic.KT_TOOL));
//#endif 

} 

//#endif 


//#if -1554888564 
return types;
//#endif 

} 

//#endif 


//#if 1476025083 
public String toString()
    { 

//#if -236562320 
return getName();
//#endif 

} 

//#endif 


//#if -24307881 
public KnowledgeTypeNode(String n)
    { 

//#if -1551017266 
name = n;
//#endif 

} 

//#endif 


//#if -1167576204 
public String getName()
    { 

//#if 180680239 
return name;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

