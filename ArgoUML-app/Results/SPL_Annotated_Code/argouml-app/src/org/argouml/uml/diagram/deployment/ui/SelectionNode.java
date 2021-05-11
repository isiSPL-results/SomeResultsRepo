// Compilation Unit of /SelectionNode.java 
 
package org.argouml.uml.diagram.deployment.ui;
import javax.swing.Icon;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
import org.tigris.gef.presentation.Fig;
public class SelectionNode extends SelectionNodeClarifiers2
  { 
private static Icon associationIcon =
        ResourceLoaderWrapper.lookupIconResource("Association");
private static Icon icons[] = {
        associationIcon,
        associationIcon,
        associationIcon,
        associationIcon,
        null,
    };
private static String instructions[] = {
        "Add a node",
        "Add a node",
        "Add a node",
        "Add a node",
        null,
        "Move object(s)",
    };
@Override
    protected boolean isReverseEdge(int index)
    { 
if(index == BOTTOM || index == LEFT)//1
{ 
return true;
} 

return false;
} 

@Override
    protected Object getNewNode(int index)
    { 
return Model.getCoreFactory().createNode();
} 

@Override
    protected Object getNewEdgeType(int index)
    { 
return Model.getMetaTypes().getAssociation();
} 

@Override
    protected String getInstructions(int index)
    { 
return instructions[index - BASE];
} 

public SelectionNode(Fig f)
    { 
super(f);
} 

@Override
    protected Object getNewNodeType(int index)
    { 
return Model.getMetaTypes().getNode();
} 

@Override
    protected Icon[] getIcons()
    { 
return icons;
} 

 } 


