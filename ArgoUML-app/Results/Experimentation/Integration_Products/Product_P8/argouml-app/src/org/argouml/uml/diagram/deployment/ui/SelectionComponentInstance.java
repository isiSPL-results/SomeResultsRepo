package org.argouml.uml.diagram.deployment.ui;
import javax.swing.Icon;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
import org.tigris.gef.presentation.Fig;
public class SelectionComponentInstance extends SelectionNodeClarifiers2
  { 
private static Icon dep =
        ResourceLoaderWrapper.lookupIconResource("Dependency");
private static Icon depRight =
        ResourceLoaderWrapper.lookupIconResource("DependencyRight");
private static Icon icons[] = {
        dep,
        dep,
        depRight,
        depRight,
        null,
    };
private static String instructions[] = {
        "Add a component-instance",
        "Add a component-instance",
        "Add a component-instance",
        "Add a component-instance",
        null,
        "Move object(s)",
    };
@Override
    protected Object getNewNodeType(int index)
    { 
return Model.getMetaTypes().getComponentInstance();
} 
@Override
    protected Object getNewEdgeType(int index)
    { 
return Model.getMetaTypes().getDependency();
} 
@Override
    protected String getInstructions(int index)
    { 
return instructions[index - BASE];
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
    protected Icon[] getIcons()
    { 
if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 
return new Icon[] {null, dep, depRight, null, null };
} 
return icons;
} 
public SelectionComponentInstance(Fig f)
    { 
super(f);
} 
@Override
    protected Object getNewNode(int index)
    { 
return Model.getCommonBehaviorFactory().createComponentInstance();
} 

 } 
