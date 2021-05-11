
//#if -1487879137 
// Compilation Unit of /SelectionNode.java 
 

//#if -1351275444 
package org.argouml.uml.diagram.deployment.ui;
//#endif 


//#if 1898839659 
import javax.swing.Icon;
//#endif 


//#if -1590596772 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1677153245 
import org.argouml.model.Model;
//#endif 


//#if 1977963122 
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
//#endif 


//#if 214307610 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1253041417 
public class SelectionNode extends 
//#if 87370556 
SelectionNodeClarifiers2
//#endif 

  { 

//#if -2114355477 
private static Icon associationIcon =
        ResourceLoaderWrapper.lookupIconResource("Association");
//#endif 


//#if -724782657 
private static Icon icons[] = {
        associationIcon,
        associationIcon,
        associationIcon,
        associationIcon,
        null,
    };
//#endif 


//#if 911425342 
private static String instructions[] = {
        "Add a node",
        "Add a node",
        "Add a node",
        "Add a node",
        null,
        "Move object(s)",
    };
//#endif 


//#if 2006206009 
@Override
    protected boolean isReverseEdge(int index)
    { 

//#if -1521349704 
if(index == BOTTOM || index == LEFT)//1
{ 

//#if 401424555 
return true;
//#endif 

} 

//#endif 


//#if -662845377 
return false;
//#endif 

} 

//#endif 


//#if 893388503 
@Override
    protected Object getNewNode(int index)
    { 

//#if -629978015 
return Model.getCoreFactory().createNode();
//#endif 

} 

//#endif 


//#if 1894169004 
@Override
    protected Object getNewEdgeType(int index)
    { 

//#if -348544405 
return Model.getMetaTypes().getAssociation();
//#endif 

} 

//#endif 


//#if -930792998 
@Override
    protected String getInstructions(int index)
    { 

//#if 665213508 
return instructions[index - BASE];
//#endif 

} 

//#endif 


//#if -406773000 
public SelectionNode(Fig f)
    { 

//#if -456333200 
super(f);
//#endif 

} 

//#endif 


//#if 748592433 
@Override
    protected Object getNewNodeType(int index)
    { 

//#if 1067281535 
return Model.getMetaTypes().getNode();
//#endif 

} 

//#endif 


//#if 1762887726 
@Override
    protected Icon[] getIcons()
    { 

//#if 2025894856 
return icons;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

