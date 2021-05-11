
//#if 473519152 
// Compilation Unit of /SelectionGeneralizableElement.java 
 

//#if 1702846322 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -1195748228 
import java.awt.event.MouseEvent;
//#endif 


//#if -2144008204 
import javax.swing.Icon;
//#endif 


//#if 927060851 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1765181050 
import org.argouml.model.Model;
//#endif 


//#if 1185973827 
import org.argouml.uml.diagram.deployment.DeploymentDiagramGraphModel;
//#endif 


//#if 5166153 
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
//#endif 


//#if 1308771115 
import org.tigris.gef.base.Editor;
//#endif 


//#if -227322386 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1050846118 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 112961137 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -483716407 
public abstract class SelectionGeneralizableElement extends 
//#if -537188367 
SelectionNodeClarifiers2
//#endif 

  { 

//#if 1340904886 
private static Icon inherit =
        ResourceLoaderWrapper.lookupIconResource("Generalization");
//#endif 


//#if -1801705804 
private static Icon[] icons = {
        inherit,
        inherit,
        null,
        null,
        null,
    };
//#endif 


//#if -281429580 
private static String[] instructions = {
        "Add a supertype",
        "Add a subtype",
        null,
        null,
        null,
        "Move object(s)",
    };
//#endif 


//#if -162387659 
private boolean useComposite;
//#endif 


//#if -1220483421 
@Override
    protected Icon[] getIcons()
    { 

//#if -948896764 
Editor ce = Globals.curEditor();
//#endif 


//#if 650327886 
GraphModel gm = ce.getGraphModel();
//#endif 


//#if 1518172233 
if(gm instanceof DeploymentDiagramGraphModel)//1
{ 

//#if 869369627 
return null;
//#endif 

} 

//#endif 


//#if -1350527305 
if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 

//#if -89484835 
return new Icon[] {null, inherit, null, null, null };
//#endif 

} 

//#endif 


//#if -179651802 
return icons;
//#endif 

} 

//#endif 


//#if 758922282 
public SelectionGeneralizableElement(Fig f)
    { 

//#if 979816539 
super(f);
//#endif 

} 

//#endif 


//#if -470042710 
@Override
    protected Object getNewEdgeType(int i)
    { 

//#if -1612514462 
if(i == TOP || i == BOTTOM)//1
{ 

//#if -366606716 
return Model.getMetaTypes().getGeneralization();
//#endif 

} 

//#endif 


//#if -2049547001 
return null;
//#endif 

} 

//#endif 


//#if 22516407 
@Override
    protected boolean isReverseEdge(int i)
    { 

//#if -1790035510 
if(i == BOTTOM)//1
{ 

//#if 2140693986 
return true;
//#endif 

} 

//#endif 


//#if -1574086911 
return false;
//#endif 

} 

//#endif 


//#if -673946354 
@Override
    protected String getInstructions(int i)
    { 

//#if -1957128016 
return instructions[ i - BASE];
//#endif 

} 

//#endif 


//#if 1094041772 
@Override
    protected boolean isEdgePostProcessRequested()
    { 

//#if -896810722 
return useComposite;
//#endif 

} 

//#endif 


//#if -1353371826 
@Override
    public void mouseEntered(MouseEvent me)
    { 

//#if 35539945 
super.mouseEntered(me);
//#endif 


//#if -1193002979 
useComposite = me.isShiftDown();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

