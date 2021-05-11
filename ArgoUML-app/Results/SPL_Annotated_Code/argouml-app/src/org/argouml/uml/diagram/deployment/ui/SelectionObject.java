// Compilation Unit of /SelectionObject.java 
 
package org.argouml.uml.diagram.deployment.ui;
import javax.swing.Icon;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
import org.tigris.gef.presentation.Fig;
public class SelectionObject extends SelectionNodeClarifiers2
  { 
private static Icon linkIcon =
        ResourceLoaderWrapper.lookupIconResource("Link");
private static Icon icons[] = {
        linkIcon,
        linkIcon,
        linkIcon,
        linkIcon,
        null,
    };
private static String instructions[] = {
        "Add an object",
        "Add an object",
        "Add an object",
        "Add an object",
        null,
        "Move object(s)",
    };
@Override
    protected Object getNewEdgeType(int index)
    { 
return Model.getMetaTypes().getLink();
} 

@Override
    protected String getInstructions(int index)
    { 
return instructions[index - BASE];
} 

@Override
    protected Icon[] getIcons()
    { 
if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 
return new Icon[6];
} 

return icons;
} 

@Override
    protected Object getNewNode(int index)
    { 
return Model.getCommonBehaviorFactory().createObject();
} 

@Override
    protected Object getNewNodeType(int index)
    { 
return Model.getMetaTypes().getObject();
} 

@Override
    protected boolean isReverseEdge(int index)
    { 
if(index == BOTTOM || index == LEFT)//1
{ 
return true;
} 

return false;
} 

public SelectionObject(Fig f)
    { 
super(f);
} 

 } 


