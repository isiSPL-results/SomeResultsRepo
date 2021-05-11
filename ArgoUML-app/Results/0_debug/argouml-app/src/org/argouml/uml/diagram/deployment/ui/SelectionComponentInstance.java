
//#if -1260600735 
// Compilation Unit of /SelectionComponentInstance.java 
 

//#if -383970549 
package org.argouml.uml.diagram.deployment.ui;
//#endif 


//#if 1495760490 
import javax.swing.Icon;
//#endif 


//#if 1574260413 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1468137660 
import org.argouml.model.Model;
//#endif 


//#if 725391891 
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
//#endif 


//#if 554349883 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1540781366 
public class SelectionComponentInstance extends 
//#if -1046413120 
SelectionNodeClarifiers2
//#endif 

  { 

//#if 1367817066 
private static Icon dep =
        ResourceLoaderWrapper.lookupIconResource("Dependency");
//#endif 


//#if 1130219344 
private static Icon depRight =
        ResourceLoaderWrapper.lookupIconResource("DependencyRight");
//#endif 


//#if 208882153 
private static Icon icons[] = {
        dep,
        dep,
        depRight,
        depRight,
        null,
    };
//#endif 


//#if -1919433982 
private static String instructions[] = {
        "Add a component-instance",
        "Add a component-instance",
        "Add a component-instance",
        "Add a component-instance",
        null,
        "Move object(s)",
    };
//#endif 


//#if 1896031925 
@Override
    protected Object getNewNodeType(int index)
    { 

//#if -1049773929 
return Model.getMetaTypes().getComponentInstance();
//#endif 

} 

//#endif 


//#if -1253358800 
@Override
    protected Object getNewEdgeType(int index)
    { 

//#if -1053697140 
return Model.getMetaTypes().getDependency();
//#endif 

} 

//#endif 


//#if 280092886 
@Override
    protected String getInstructions(int index)
    { 

//#if 426035710 
return instructions[index - BASE];
//#endif 

} 

//#endif 


//#if -1141321795 
@Override
    protected boolean isReverseEdge(int index)
    { 

//#if -1658719231 
if(index == BOTTOM || index == LEFT)//1
{ 

//#if -1183642346 
return true;
//#endif 

} 

//#endif 


//#if 1726162006 
return false;
//#endif 

} 

//#endif 


//#if -362461006 
@Override
    protected Icon[] getIcons()
    { 

//#if -1443040358 
if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 

//#if 302423868 
return new Icon[] {null, dep, depRight, null, null };
//#endif 

} 

//#endif 


//#if 882139811 
return icons;
//#endif 

} 

//#endif 


//#if -860648162 
public SelectionComponentInstance(Fig f)
    { 

//#if -1615005756 
super(f);
//#endif 

} 

//#endif 


//#if 1364062811 
@Override
    protected Object getNewNode(int index)
    { 

//#if 170232480 
return Model.getCommonBehaviorFactory().createComponentInstance();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

