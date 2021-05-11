// Compilation Unit of /SelectionInterface.java 
 
package org.argouml.uml.diagram.static_structure.ui;
import javax.swing.Icon;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
import org.tigris.gef.presentation.Fig;
public class SelectionInterface extends SelectionNodeClarifiers2
  { 
private static Icon realiz =
        ResourceLoaderWrapper.lookupIconResource("Realization");
private static Icon inherit =
        ResourceLoaderWrapper.lookupIconResource("Generalization");
private static Icon icons[] = {
        inherit,
        realiz,
        null,
        null,
        null,
    };
private static String instructions[] = {
        "Add an interface",
        "Add a realization",
        null,
        null,
        null,
        "Move object(s)",
    };
@Override
    protected Object getNewEdgeType(int index)
    { 
if(index == TOP)//1
{ 
return Model.getMetaTypes().getGeneralization();
} 
else
if(index == BOTTOM)//1
{ 
return Model.getMetaTypes().getAbstraction();
} 


return null;
} 

public SelectionInterface(Fig f)
    { 
super(f);
} 

@Override
    protected boolean isReverseEdge(int index)
    { 
if(index == 11)//1
{ 
return true;
} 

return false;
} 

@Override
    protected Object getNewNodeType(int index)
    { 
if(index == TOP)//1
{ 
return Model.getMetaTypes().getInterface();
} 
else
if(index == BOTTOM)//1
{ 
return Model.getMetaTypes().getUMLClass();
} 


return null;
} 

@Override
    protected Icon[] getIcons()
    { 
if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 
return new Icon[] {null, realiz, null, null, null };
} 

return icons;
} 

@Override
    protected String getInstructions(int index)
    { 
return instructions[index - BASE];
} 

@Override
    protected Object getNewNode(int index)
    { 
if(index == 0)//1
{ 
index = getButton();
} 

if(index == TOP)//1
{ 
return Model.getCoreFactory().buildInterface();
} 
else
{ 
return Model.getCoreFactory().buildClass();
} 

} 

 } 


