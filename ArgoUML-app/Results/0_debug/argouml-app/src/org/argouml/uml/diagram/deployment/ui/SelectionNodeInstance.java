
//#if 166145412 
// Compilation Unit of /SelectionNodeInstance.java 
 

//#if 1883798210 
package org.argouml.uml.diagram.deployment.ui;
//#endif 


//#if 293308769 
import javax.swing.Icon;
//#endif 


//#if 718578214 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1347616659 
import org.argouml.model.Model;
//#endif 


//#if -1818512452 
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
//#endif 


//#if -1935770268 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 2050240136 
public class SelectionNodeInstance extends 
//#if -335374993 
SelectionNodeClarifiers2
//#endif 

  { 

//#if -1712914236 
private static Icon linkIcon =
        ResourceLoaderWrapper.lookupIconResource("Link");
//#endif 


//#if -835645324 
private static Icon icons[] = {
        linkIcon,
        linkIcon,
        linkIcon,
        linkIcon,
        null,
    };
//#endif 


//#if -607699555 
private static String instructions[] = {
        "Add a component",
        "Add a component",
        "Add a component",
        "Add a component",
        null,
        "Move object(s)",
    };
//#endif 


//#if -1928421625 
@Override
    protected String getInstructions(int index)
    { 

//#if 1442778065 
return instructions[index - BASE];
//#endif 

} 

//#endif 


//#if -1779591654 
public SelectionNodeInstance(Fig f)
    { 

//#if 28735144 
super(f);
//#endif 

} 

//#endif 


//#if 1558382444 
@Override
    protected boolean isReverseEdge(int index)
    { 

//#if -1383371541 
if(index == BOTTOM || index == LEFT)//1
{ 

//#if 2047295778 
return true;
//#endif 

} 

//#endif 


//#if 2122886444 
return false;
//#endif 

} 

//#endif 


//#if 300768868 
@Override
    protected Object getNewNodeType(int index)
    { 

//#if -75854650 
return Model.getMetaTypes().getNodeInstance();
//#endif 

} 

//#endif 


//#if -1951573622 
@Override
    protected Object getNewNode(int index)
    { 

//#if -1330032496 
return Model.getCommonBehaviorFactory().createNodeInstance();
//#endif 

} 

//#endif 


//#if 1446345439 
@Override
    protected Object getNewEdgeType(int index)
    { 

//#if 674301965 
return Model.getMetaTypes().getLink();
//#endif 

} 

//#endif 


//#if 1328811681 
@Override
    protected Icon[] getIcons()
    { 

//#if -44108623 
if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 

//#if -981597099 
return new Icon[6];
//#endif 

} 

//#endif 


//#if 2112179308 
return icons;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

