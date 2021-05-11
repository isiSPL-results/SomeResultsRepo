// Compilation Unit of /SelectionClass.java 
 
package org.argouml.uml.diagram.static_structure.ui;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.model.Model;
import org.argouml.uml.diagram.deployment.DeploymentDiagramGraphModel;
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
import org.tigris.gef.base.Globals;
import org.tigris.gef.presentation.Fig;
public class SelectionClass extends SelectionNodeClarifiers2
  { 
private static Icon inherit =
        ResourceLoaderWrapper.lookupIconResource("Generalization");
private static Icon assoc =
        ResourceLoaderWrapper.lookupIconResource("Association");
private static Icon compos =
        ResourceLoaderWrapper.lookupIconResource("CompositeAggregation");
private static Icon selfassoc =
        ResourceLoaderWrapper.lookupIconResource("SelfAssociation");
private boolean useComposite;
private static Icon icons[] = {
        inherit,
        inherit,
        assoc,
        assoc,
        selfassoc,
    };
private static String instructions[] = {
        "Add a superclass",
        "Add a subclass",
        "Add an associated class",
        "Add an associated class",
        "Add a self association",
        "Move object(s)",
    };
private static Object edgeType[] = {
        Model.getMetaTypes().getGeneralization(),
        Model.getMetaTypes().getGeneralization(),
        Model.getMetaTypes().getAssociation(),
        Model.getMetaTypes().getAssociation(),
        Model.getMetaTypes().getAssociation(),
    };
@Override
    protected boolean isEdgePostProcessRequested()
    { 
return useComposite;
} 

@Override
    protected boolean isReverseEdge(int i)
    { 
if(i == BOTTOM || i == LEFT)//1
{ 
return true;
} 

return false;
} 

@Override
    protected boolean isDraggableHandle(int index)
    { 
if(index == LOWER_LEFT)//1
{ 
return false;
} 

return true;
} 

@Override
    protected Object getNewNodeType(int i)
    { 
return Model.getMetaTypes().getUMLClass();
} 

@Override
    protected String getInstructions(int index)
    { 
return instructions[index - BASE];
} 

@Override
    protected Object getNewNode(int index)
    { 
return Model.getCoreFactory().buildClass();
} 

@Override
    protected Object getNewEdgeType(int i)
    { 
if(i == 0)//1
{ 
i = getButton();
} 

return edgeType[i - 10];
} 

public SelectionClass(Fig f)
    { 
super(f);
} 

@Override
    public void mouseEntered(MouseEvent me)
    { 
super.mouseEntered(me);
useComposite = me.isShiftDown();
} 

@Override
    protected Icon[] getIcons()
    { 
Icon workingIcons[] = new Icon[icons.length];
System.arraycopy(icons, 0, workingIcons, 0, icons.length);
if(Globals.curEditor().getGraphModel()
                instanceof DeploymentDiagramGraphModel)//1
{ 
workingIcons[TOP - BASE] = null;
workingIcons[BOTTOM - BASE] = null;
} 

if(useComposite)//1
{ 
workingIcons[LEFT - BASE] = compos;
workingIcons[RIGHT - BASE] = compos;
} 

if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 
return new Icon[] {null, inherit, null, null, null };
} 

return workingIcons;
} 

 } 


