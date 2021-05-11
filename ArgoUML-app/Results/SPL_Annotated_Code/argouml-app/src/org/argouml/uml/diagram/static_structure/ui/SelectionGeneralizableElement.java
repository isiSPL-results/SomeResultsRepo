// Compilation Unit of /SelectionGeneralizableElement.java 
 
package org.argouml.uml.diagram.static_structure.ui;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.model.Model;
import org.argouml.uml.diagram.deployment.DeploymentDiagramGraphModel;
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
public abstract class SelectionGeneralizableElement extends SelectionNodeClarifiers2
  { 
private static Icon inherit =
        ResourceLoaderWrapper.lookupIconResource("Generalization");
private static Icon[] icons = {
        inherit,
        inherit,
        null,
        null,
        null,
    };
private static String[] instructions = {
        "Add a supertype",
        "Add a subtype",
        null,
        null,
        null,
        "Move object(s)",
    };
private boolean useComposite;
@Override
    protected Icon[] getIcons()
    { 
Editor ce = Globals.curEditor();
GraphModel gm = ce.getGraphModel();
if(gm instanceof DeploymentDiagramGraphModel)//1
{ 
return null;
} 

if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 
return new Icon[] {null, inherit, null, null, null };
} 

return icons;
} 

public SelectionGeneralizableElement(Fig f)
    { 
super(f);
} 

@Override
    protected Object getNewEdgeType(int i)
    { 
if(i == TOP || i == BOTTOM)//1
{ 
return Model.getMetaTypes().getGeneralization();
} 

return null;
} 

@Override
    protected boolean isReverseEdge(int i)
    { 
if(i == BOTTOM)//1
{ 
return true;
} 

return false;
} 

@Override
    protected String getInstructions(int i)
    { 
return instructions[ i - BASE];
} 

@Override
    protected boolean isEdgePostProcessRequested()
    { 
return useComposite;
} 

@Override
    public void mouseEntered(MouseEvent me)
    { 
super.mouseEntered(me);
useComposite = me.isShiftDown();
} 

 } 


