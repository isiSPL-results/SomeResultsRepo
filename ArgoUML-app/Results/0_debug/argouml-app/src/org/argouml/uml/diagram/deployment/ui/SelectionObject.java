
//#if 53265879 
// Compilation Unit of /SelectionObject.java 
 

//#if 996897807 
package org.argouml.uml.diagram.deployment.ui;
//#endif 


//#if -120292754 
import javax.swing.Icon;
//#endif 


//#if 824198457 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1761462592 
import org.argouml.model.Model;
//#endif 


//#if 411762575 
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
//#endif 


//#if -796020553 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 642028963 
public class SelectionObject extends 
//#if 110146340 
SelectionNodeClarifiers2
//#endif 

  { 

//#if -734336785 
private static Icon linkIcon =
        ResourceLoaderWrapper.lookupIconResource("Link");
//#endif 


//#if 787821791 
private static Icon icons[] = {
        linkIcon,
        linkIcon,
        linkIcon,
        linkIcon,
        null,
    };
//#endif 


//#if 1212593362 
private static String instructions[] = {
        "Add an object",
        "Add an object",
        "Add an object",
        "Add an object",
        null,
        "Move object(s)",
    };
//#endif 


//#if 363006356 
@Override
    protected Object getNewEdgeType(int index)
    { 

//#if 139137068 
return Model.getMetaTypes().getLink();
//#endif 

} 

//#endif 


//#if -1152194830 
@Override
    protected String getInstructions(int index)
    { 

//#if 1898643414 
return instructions[index - BASE];
//#endif 

} 

//#endif 


//#if 1043615254 
@Override
    protected Icon[] getIcons()
    { 

//#if -1560880696 
if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 

//#if 170185659 
return new Icon[6];
//#endif 

} 

//#endif 


//#if 1050464821 
return icons;
//#endif 

} 

//#endif 


//#if 254839487 
@Override
    protected Object getNewNode(int index)
    { 

//#if -548466623 
return Model.getCommonBehaviorFactory().createObject();
//#endif 

} 

//#endif 


//#if -782570215 
@Override
    protected Object getNewNodeType(int index)
    { 

//#if -1129372811 
return Model.getMetaTypes().getObject();
//#endif 

} 

//#endif 


//#if 475043361 
@Override
    protected boolean isReverseEdge(int index)
    { 

//#if -1625235866 
if(index == BOTTOM || index == LEFT)//1
{ 

//#if 2037030345 
return true;
//#endif 

} 

//#endif 


//#if -1531124527 
return false;
//#endif 

} 

//#endif 


//#if 703091661 
public SelectionObject(Fig f)
    { 

//#if 267368709 
super(f);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

