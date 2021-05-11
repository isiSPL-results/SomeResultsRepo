
//#if -1980780198 
// Compilation Unit of /SelectionClass.java 
 

//#if -727059867 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if 1214666857 
import java.awt.event.MouseEvent;
//#endif 


//#if -298748569 
import javax.swing.Icon;
//#endif 


//#if -74325536 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 301769127 
import org.argouml.model.Model;
//#endif 


//#if 1674928758 
import org.argouml.uml.diagram.deployment.DeploymentDiagramGraphModel;
//#endif 


//#if 339319286 
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
//#endif 


//#if 1194201755 
import org.tigris.gef.base.Globals;
//#endif 


//#if -784448354 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1420950349 
public class SelectionClass extends 
//#if 1019605813 
SelectionNodeClarifiers2
//#endif 

  { 

//#if 523993850 
private static Icon inherit =
        ResourceLoaderWrapper.lookupIconResource("Generalization");
//#endif 


//#if 639159607 
private static Icon assoc =
        ResourceLoaderWrapper.lookupIconResource("Association");
//#endif 


//#if -1782417763 
private static Icon compos =
        ResourceLoaderWrapper.lookupIconResource("CompositeAggregation");
//#endif 


//#if 858350447 
private static Icon selfassoc =
        ResourceLoaderWrapper.lookupIconResource("SelfAssociation");
//#endif 


//#if 1236166513 
private boolean useComposite;
//#endif 


//#if 1858508230 
private static Icon icons[] = {
        inherit,
        inherit,
        assoc,
        assoc,
        selfassoc,
    };
//#endif 


//#if 491868430 
private static String instructions[] = {
        "Add a superclass",
        "Add a subclass",
        "Add an associated class",
        "Add an associated class",
        "Add a self association",
        "Move object(s)",
    };
//#endif 


//#if -1073403806 
private static Object edgeType[] = {
        Model.getMetaTypes().getGeneralization(),
        Model.getMetaTypes().getGeneralization(),
        Model.getMetaTypes().getAssociation(),
        Model.getMetaTypes().getAssociation(),
        Model.getMetaTypes().getAssociation(),
    };
//#endif 


//#if -358585368 
@Override
    protected boolean isEdgePostProcessRequested()
    { 

//#if -1850069604 
return useComposite;
//#endif 

} 

//#endif 


//#if -1200614405 
@Override
    protected boolean isReverseEdge(int i)
    { 

//#if -1933998855 
if(i == BOTTOM || i == LEFT)//1
{ 

//#if 1779928353 
return true;
//#endif 

} 

//#endif 


//#if 1918074494 
return false;
//#endif 

} 

//#endif 


//#if 1112093576 
@Override
    protected boolean isDraggableHandle(int index)
    { 

//#if -1843023923 
if(index == LOWER_LEFT)//1
{ 

//#if 1782001158 
return false;
//#endif 

} 

//#endif 


//#if -985668316 
return true;
//#endif 

} 

//#endif 


//#if -1267947789 
@Override
    protected Object getNewNodeType(int i)
    { 

//#if 804660211 
return Model.getMetaTypes().getUMLClass();
//#endif 

} 

//#endif 


//#if -285987839 
@Override
    protected String getInstructions(int index)
    { 

//#if -1677574225 
return instructions[index - BASE];
//#endif 

} 

//#endif 


//#if 745412688 
@Override
    protected Object getNewNode(int index)
    { 

//#if 1244127800 
return Model.getCoreFactory().buildClass();
//#endif 

} 

//#endif 


//#if -1693173522 
@Override
    protected Object getNewEdgeType(int i)
    { 

//#if -826919895 
if(i == 0)//1
{ 

//#if 667668017 
i = getButton();
//#endif 

} 

//#endif 


//#if 57323364 
return edgeType[i - 10];
//#endif 

} 

//#endif 


//#if -1609906663 
public SelectionClass(Fig f)
    { 

//#if 2003793974 
super(f);
//#endif 

} 

//#endif 


//#if -615721334 
@Override
    public void mouseEntered(MouseEvent me)
    { 

//#if 126016527 
super.mouseEntered(me);
//#endif 


//#if -1347792585 
useComposite = me.isShiftDown();
//#endif 

} 

//#endif 


//#if 101280999 
@Override
    protected Icon[] getIcons()
    { 

//#if 323130437 
Icon workingIcons[] = new Icon[icons.length];
//#endif 


//#if 1134204754 
System.arraycopy(icons, 0, workingIcons, 0, icons.length);
//#endif 


//#if 1270442894 
if(Globals.curEditor().getGraphModel()
                instanceof DeploymentDiagramGraphModel)//1
{ 

//#if 788588557 
workingIcons[TOP - BASE] = null;
//#endif 


//#if 528580543 
workingIcons[BOTTOM - BASE] = null;
//#endif 

} 

//#endif 


//#if -1370238427 
if(useComposite)//1
{ 

//#if 725185117 
workingIcons[LEFT - BASE] = compos;
//#endif 


//#if 1317315130 
workingIcons[RIGHT - BASE] = compos;
//#endif 

} 

//#endif 


//#if 508374046 
if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 

//#if 2070540677 
return new Icon[] {null, inherit, null, null, null };
//#endif 

} 

//#endif 


//#if 261804788 
return workingIcons;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

