package org.argouml.uml.diagram.deployment.ui;
import javax.swing.Icon;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
import org.tigris.gef.presentation.Fig;
public class SelectionNodeInstance extends SelectionNodeClarifiers2
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
        "Add a component",
        "Add a component",
        "Add a component",
        "Add a component",
        null,
        "Move object(s)",
    };
@Override
    protected String getInstructions(int index)
    { 
return instructions[index - BASE];
} 
public SelectionNodeInstance(Fig f)
    { 
super(f);
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
@Override
    protected Object getNewNodeType(int index)
    { 
return Model.getMetaTypes().getNodeInstance();
} 
@Override
    protected Object getNewNode(int index)
    { 
return Model.getCommonBehaviorFactory().createNodeInstance();
} 
@Override
    protected Object getNewEdgeType(int index)
    { 
return Model.getMetaTypes().getLink();
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

 } 
