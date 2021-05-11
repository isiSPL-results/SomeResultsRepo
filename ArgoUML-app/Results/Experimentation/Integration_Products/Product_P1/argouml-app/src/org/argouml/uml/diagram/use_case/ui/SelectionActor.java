package org.argouml.uml.diagram.use_case.ui;
import javax.swing.Icon;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
import org.tigris.gef.presentation.Fig;
public class SelectionActor extends SelectionNodeClarifiers2
  { 
private static Icon associationIcon =
        ResourceLoaderWrapper.lookupIconResource("Association");
private static Icon generalizationIcon =
        ResourceLoaderWrapper.lookupIconResource("Generalization");
private static Icon icons[] = {
        generalizationIcon,
        generalizationIcon,
        associationIcon,
        associationIcon,
        null,
    };
private static String instructions[] = {
        "Add a more general Actor",
        "Add a more specialized Actor",
        "Add an associated use case",
        "Add an associated use case",
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
if(index == TOP || index == BOTTOM)//1
{ 
return Model.getUseCasesFactory().createActor();
} 
else
{ 
return Model.getUseCasesFactory().createUseCase();
} 
} 
@Override
    protected Object getNewEdgeType(int index)
    { 
return edgeType[index - BASE];
} 
@Override
    protected Icon[] getIcons()
    { 
if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 
return new Icon[] {null, generalizationIcon, null, null, null };
} 
return icons;
} 
@Override
    protected boolean isReverseEdge(int index)
    { 
if(index == BOTTOM || index == LEFT)//1
{ 
return true;
} 
return false;
} 
public SelectionActor(Fig f)
    { 
super(f);
} 
@Override
    protected Object getNewNodeType(int index)
    { 
if(index == TOP || index == BOTTOM)//1
{ 
return Model.getMetaTypes().getActor();
} 
else
{ 
return Model.getMetaTypes().getUseCase();
} 
} 

 } 
