
//#if -1813444075 
// Compilation Unit of /SelectionComponent.java 
 

//#if -868527290 
package org.argouml.uml.diagram.deployment.ui;
//#endif 


//#if 2105253093 
import javax.swing.Icon;
//#endif 


//#if -1894960862 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 169652329 
import org.argouml.model.Model;
//#endif 


//#if 1231278520 
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
//#endif 


//#if -1018400416 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1561948848 
public class SelectionComponent extends 
//#if -67204837 
SelectionNodeClarifiers2
//#endif 

  { 

//#if 1770904645 
private static Icon dep =
        ResourceLoaderWrapper.lookupIconResource("Dependency");
//#endif 


//#if -616476053 
private static Icon depRight =
        ResourceLoaderWrapper.lookupIconResource("DependencyRight");
//#endif 


//#if -178140242 
private static Icon icons[] = {
        dep,
        dep,
        depRight,
        depRight,
        null,
    };
//#endif 


//#if 1024190025 
private static String instructions[] = {
        "Add a component",
        "Add a component",
        "Add a component",
        "Add a component",
        null,
        "Move object(s)",
    };
//#endif 


//#if -1900270965 
@Override
    protected Object getNewEdgeType(int index)
    { 

//#if -409296566 
return Model.getMetaTypes().getDependency();
//#endif 

} 

//#endif 


//#if 2012659510 
@Override
    protected Object getNewNode(int index)
    { 

//#if -1317726648 
return Model.getCoreFactory().createComponent();
//#endif 

} 

//#endif 


//#if 12868429 
@Override
    protected Icon[] getIcons()
    { 

//#if 1873879846 
if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 

//#if 1907162152 
return new Icon[] {null, dep, depRight, null, null };
//#endif 

} 

//#endif 


//#if -697318249 
return icons;
//#endif 

} 

//#endif 


//#if 1249119760 
@Override
    protected Object getNewNodeType(int index)
    { 

//#if -778718557 
return Model.getMetaTypes().getComponent();
//#endif 

} 

//#endif 


//#if -407973308 
public SelectionComponent(Fig f)
    { 

//#if 1851935597 
super(f);
//#endif 

} 

//#endif 


//#if -1788233960 
@Override
    protected boolean isReverseEdge(int index)
    { 

//#if 1618392677 
if(index == LEFT || index == BOTTOM)//1
{ 

//#if 852510917 
return true;
//#endif 

} 

//#endif 


//#if 799475578 
return false;
//#endif 

} 

//#endif 


//#if 1700652251 
@Override
    protected String getInstructions(int index)
    { 

//#if 343694253 
return instructions[index - BASE];
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

