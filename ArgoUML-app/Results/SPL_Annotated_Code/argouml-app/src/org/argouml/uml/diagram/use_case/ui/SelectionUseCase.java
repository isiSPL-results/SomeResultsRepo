// Compilation Unit of /SelectionUseCase.java 
 
package org.argouml.uml.diagram.use_case.ui;
import javax.swing.Icon;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
import org.tigris.gef.presentation.Fig;
public class SelectionUseCase extends SelectionNodeClarifiers2
  { 
private static Icon inherit =
        ResourceLoaderWrapper.lookupIconResource("Generalization");
private static Icon assoc =
        ResourceLoaderWrapper.lookupIconResource("Association");
private static Icon icons[] = {
        inherit,
        inherit,
        assoc,
        assoc,
        null,
    };
private static String instructions[] = {
        "Add a more general use case",
        "Add a more specialized use case",
        "Add an associated actor",
        "Add an associated actor",
        null,
        "Move object(s)",
    };
private static Object edgeType[] = {
        Model.getMetaTypes().getGeneralization(),
        Model.getMetaTypes().getGeneralization(),
        Model.getMetaTypes().getAssociation(),
        Model.getMetaTypes().getAssociation(),
        null,
    };
@Override
    protected Icon[] getIcons()
    { 
if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 
return new Icon[] {null, inherit, null, null, null };
} 

return icons;
} 

@Override
    protected Object getNewNodeType(int index)
    { 
if(index == TOP || index == BOTTOM)//1
{ 
return Model.getMetaTypes().getUseCase();
} 

return Model.getMetaTypes().getActor();
} 

@Override
    protected String getInstructions(int index)
    { 
return instructions[index - BASE];
} 

@Override
    protected Object getNewEdgeType(int index)
    { 
return edgeType[index - BASE];
} 

public SelectionUseCase(Fig f)
    { 
super(f);
} 

@Override
    protected Object getNewNode(int index)
    { 
if(index == 0)//1
{ 
index = getButton();
} 

if(index == TOP || index == BOTTOM)//1
{ 
return Model.getUseCasesFactory().createUseCase();
} 

return Model.getUseCasesFactory().createActor();
} 

@Override
    protected boolean isReverseEdge(int index)
    { 
if(index == BOTTOM)//1
{ 
return true;
} 

return false;
} 

 } 


