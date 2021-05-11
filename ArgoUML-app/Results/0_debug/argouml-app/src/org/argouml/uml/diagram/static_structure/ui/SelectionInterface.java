
//#if 279263312 
// Compilation Unit of /SelectionInterface.java 
 

//#if 1135349370 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if 1192301308 
import javax.swing.Icon;
//#endif 


//#if 1630899563 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1590788722 
import org.argouml.model.Model;
//#endif 


//#if 1163439169 
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
//#endif 


//#if 2104961641 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 2048992867 
public class SelectionInterface extends 
//#if -621377063 
SelectionNodeClarifiers2
//#endif 

  { 

//#if 995960850 
private static Icon realiz =
        ResourceLoaderWrapper.lookupIconResource("Realization");
//#endif 


//#if 886172574 
private static Icon inherit =
        ResourceLoaderWrapper.lookupIconResource("Generalization");
//#endif 


//#if -2082926480 
private static Icon icons[] = {
        inherit,
        realiz,
        null,
        null,
        null,
    };
//#endif 


//#if -1509126542 
private static String instructions[] = {
        "Add an interface",
        "Add a realization",
        null,
        null,
        null,
        "Move object(s)",
    };
//#endif 


//#if 562909513 
@Override
    protected Object getNewEdgeType(int index)
    { 

//#if -1121995124 
if(index == TOP)//1
{ 

//#if 807260026 
return Model.getMetaTypes().getGeneralization();
//#endif 

} 
else

//#if 2100813156 
if(index == BOTTOM)//1
{ 

//#if -1813828078 
return Model.getMetaTypes().getAbstraction();
//#endif 

} 

//#endif 


//#endif 


//#if -1174153222 
return null;
//#endif 

} 

//#endif 


//#if -1796800578 
public SelectionInterface(Fig f)
    { 

//#if 1403715397 
super(f);
//#endif 

} 

//#endif 


//#if 674946518 
@Override
    protected boolean isReverseEdge(int index)
    { 

//#if -1287754537 
if(index == 11)//1
{ 

//#if -870977932 
return true;
//#endif 

} 

//#endif 


//#if 1812326448 
return false;
//#endif 

} 

//#endif 


//#if -582667058 
@Override
    protected Object getNewNodeType(int index)
    { 

//#if -446438027 
if(index == TOP)//1
{ 

//#if -945368186 
return Model.getMetaTypes().getInterface();
//#endif 

} 
else

//#if -151088705 
if(index == BOTTOM)//1
{ 

//#if -329380739 
return Model.getMetaTypes().getUMLClass();
//#endif 

} 

//#endif 


//#endif 


//#if 959162787 
return null;
//#endif 

} 

//#endif 


//#if 192480907 
@Override
    protected Icon[] getIcons()
    { 

//#if 943537696 
if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 

//#if -1110007870 
return new Icon[] {null, realiz, null, null, null };
//#endif 

} 

//#endif 


//#if -89376547 
return icons;
//#endif 

} 

//#endif 


//#if 749835741 
@Override
    protected String getInstructions(int index)
    { 

//#if 523235473 
return instructions[index - BASE];
//#endif 

} 

//#endif 


//#if -2072709900 
@Override
    protected Object getNewNode(int index)
    { 

//#if -1548894504 
if(index == 0)//1
{ 

//#if 2030304801 
index = getButton();
//#endif 

} 

//#endif 


//#if 574632285 
if(index == TOP)//1
{ 

//#if 1139576853 
return Model.getCoreFactory().buildInterface();
//#endif 

} 
else
{ 

//#if 1475890937 
return Model.getCoreFactory().buildClass();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

