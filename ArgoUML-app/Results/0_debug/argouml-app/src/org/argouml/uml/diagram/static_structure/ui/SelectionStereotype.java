
//#if -833392669 
// Compilation Unit of /SelectionStereotype.java 
 

//#if -279895045 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if 950932115 
import java.awt.event.MouseEvent;
//#endif 


//#if -2140552195 
import javax.swing.Icon;
//#endif 


//#if 511318282 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1973363119 
import org.argouml.model.Model;
//#endif 


//#if -938017227 
import org.argouml.uml.StereotypeUtility;
//#endif 


//#if -515401076 
import org.argouml.uml.diagram.deployment.DeploymentDiagramGraphModel;
//#endif 


//#if -147221600 
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
//#endif 


//#if 1148185157 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1359306781 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if 622344008 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 2112107303 
public class SelectionStereotype extends 
//#if 1127946638 
SelectionNodeClarifiers2
//#endif 

  { 

//#if 1650733932 
private static Icon inheritIcon =
        ResourceLoaderWrapper.lookupIconResource("Generalization");
//#endif 


//#if 1022068102 
private static Icon dependIcon =
        ResourceLoaderWrapper.lookupIconResource("Dependency");
//#endif 


//#if -997722504 
private boolean useComposite;
//#endif 


//#if -842325902 
private static Icon icons[] = {
        dependIcon,
        inheritIcon,
        null,
        null,
        null,
    };
//#endif 


//#if 1272827143 
private static String instructions[] = {
        "Add a baseClass",
        "Add a subStereotype",
        null,
        null,
        null,
        "Move object(s)",
    };
//#endif 


//#if -1929139256 
@Override
    protected String getInstructions(int index)
    { 

//#if -317367451 
return instructions[index - BASE];
//#endif 

} 

//#endif 


//#if 716387715 
@Override
    protected Object getNewNodeType(int index)
    { 

//#if 1922217687 
switch (index) //1
{ 
case 10://1


//#if 1168047133 
return Model.getMetaTypes().getClass();
//#endif 


case 11://1


//#if 1619777840 
return Model.getMetaTypes().getStereotype();
//#endif 


} 

//#endif 


//#if 1862290135 
return null;
//#endif 

} 

//#endif 


//#if 2080479273 
@Override
    protected Object getNewNode(int index)
    { 

//#if -1975714076 
if(index == 0)//1
{ 

//#if -2138842379 
index = getButton();
//#endif 

} 

//#endif 


//#if -536778459 
Object ns = Model.getFacade().getNamespace(getContent().getOwner());
//#endif 


//#if -1502547539 
switch (index) //1
{ 
case 10://1


//#if 1921948659 
Object clazz = Model.getCoreFactory().buildClass(ns);
//#endif 


//#if -843576884 
StereotypeUtility.dealWithStereotypes(clazz, "metaclass", false);
//#endif 


//#if 1464513024 
return clazz;
//#endif 


case 11://1


//#if -1326470284 
Object st =
                Model.getExtensionMechanismsFactory().createStereotype();
//#endif 


//#if -1855463662 
Model.getCoreHelper().setNamespace(st, ns);
//#endif 


//#if -200605734 
return st;
//#endif 


} 

//#endif 


//#if -1619908201 
return null;
//#endif 

} 

//#endif 


//#if -196528128 
@Override
    protected Icon[] getIcons()
    { 

//#if -1307240899 
if(Globals.curEditor().getGraphModel()
                instanceof DeploymentDiagramGraphModel)//1
{ 

//#if -850010697 
return null;
//#endif 

} 

//#endif 


//#if -1630566835 
if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 

//#if 623481099 
return new Icon[] {null, inheritIcon, null, null, null };
//#endif 

} 

//#endif 


//#if -2105012656 
return icons;
//#endif 

} 

//#endif 


//#if -238243793 
@Override
    protected boolean isEdgePostProcessRequested()
    { 

//#if -1577319600 
return useComposite;
//#endif 

} 

//#endif 


//#if 2116637137 
@Override
    public void mouseEntered(MouseEvent me)
    { 

//#if 987444193 
super.mouseEntered(me);
//#endif 


//#if 1179183397 
useComposite = me.isShiftDown();
//#endif 

} 

//#endif 


//#if 1974001291 
@Override
    protected boolean isReverseEdge(int index)
    { 

//#if 2067703860 
if(index == BOTTOM)//1
{ 

//#if 1395376035 
return true;
//#endif 

} 

//#endif 


//#if -1315620222 
return false;
//#endif 

} 

//#endif 


//#if 616507478 
public SelectionStereotype(Fig f)
    { 

//#if -1165830829 
super(f);
//#endif 

} 

//#endif 


//#if 1093416029 
@Override
    protected Object createEdgeAbove(MutableGraphModel mgm, Object newNode)
    { 

//#if -1996431180 
Object dep = super.createEdgeAbove(mgm, newNode);
//#endif 


//#if -880602108 
StereotypeUtility.dealWithStereotypes(dep, "stereotype", false);
//#endif 


//#if 473199519 
return dep;
//#endif 

} 

//#endif 


//#if 1861964286 
@Override
    protected Object getNewEdgeType(int index)
    { 

//#if 258078129 
if(index == TOP)//1
{ 

//#if 551411104 
return Model.getMetaTypes().getDependency();
//#endif 

} 
else

//#if 1446457974 
if(index == BOTTOM)//1
{ 

//#if -649972447 
return Model.getMetaTypes().getGeneralization();
//#endif 

} 

//#endif 


//#endif 


//#if -31877409 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

