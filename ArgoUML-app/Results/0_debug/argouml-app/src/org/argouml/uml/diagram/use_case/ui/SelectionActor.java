
//#if -236942937 
// Compilation Unit of /SelectionActor.java 
 

//#if 544107627 
package org.argouml.uml.diagram.use_case.ui;
//#endif 


//#if 370176615 
import javax.swing.Icon;
//#endif 


//#if -1422064416 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 2109146279 
import org.argouml.model.Model;
//#endif 


//#if -363758346 
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
//#endif 


//#if 1508222878 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 10860746 
public class SelectionActor extends 
//#if -217739754 
SelectionNodeClarifiers2
//#endif 

  { 

//#if 1824474961 
private static Icon associationIcon =
        ResourceLoaderWrapper.lookupIconResource("Association");
//#endif 


//#if -1192056643 
private static Icon generalizationIcon =
        ResourceLoaderWrapper.lookupIconResource("Generalization");
//#endif 


//#if -1782879191 
private static Icon icons[] = {
        generalizationIcon,
        generalizationIcon,
        associationIcon,
        associationIcon,
        null,
    };
//#endif 


//#if -1299599783 
private static String instructions[] = {
        "Add a more general Actor",
        "Add a more specialized Actor",
        "Add an associated use case",
        "Add an associated use case",
        null,
        "Move object(s)",
    };
//#endif 


//#if 1626229046 
private static Object edgeType[] = {
        Model.getMetaTypes().getGeneralization(),
        Model.getMetaTypes().getGeneralization(),
        Model.getMetaTypes().getAssociation(),
        Model.getMetaTypes().getAssociation(),
        null,
    };
//#endif 


//#if -912793536 
@Override
    protected String getInstructions(int index)
    { 

//#if -1547924495 
return instructions[index - BASE];
//#endif 

} 

//#endif 


//#if 1665956017 
@Override
    protected Object getNewNode(int index)
    { 

//#if -1961224322 
if(index == 0)//1
{ 

//#if 51246781 
index = getButton();
//#endif 

} 

//#endif 


//#if -838310966 
if(index == TOP || index == BOTTOM)//1
{ 

//#if 851563351 
return Model.getUseCasesFactory().createActor();
//#endif 

} 
else
{ 

//#if -1616069937 
return Model.getUseCasesFactory().createUseCase();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -44913018 
@Override
    protected Object getNewEdgeType(int index)
    { 

//#if -400814904 
return edgeType[index - BASE];
//#endif 

} 

//#endif 


//#if -1441684856 
@Override
    protected Icon[] getIcons()
    { 

//#if 1472817404 
if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 

//#if 198538043 
return new Icon[] {null, generalizationIcon, null, null, null };
//#endif 

} 

//#endif 


//#if -1468233343 
return icons;
//#endif 

} 

//#endif 


//#if 67123987 
@Override
    protected boolean isReverseEdge(int index)
    { 

//#if -1602017761 
if(index == BOTTOM || index == LEFT)//1
{ 

//#if -1977882223 
return true;
//#endif 

} 

//#endif 


//#if 1828002680 
return false;
//#endif 

} 

//#endif 


//#if 823794551 
public SelectionActor(Fig f)
    { 

//#if 1906772558 
super(f);
//#endif 

} 

//#endif 


//#if -1190489589 
@Override
    protected Object getNewNodeType(int index)
    { 

//#if 2058960635 
if(index == TOP || index == BOTTOM)//1
{ 

//#if -580520913 
return Model.getMetaTypes().getActor();
//#endif 

} 
else
{ 

//#if 1335580742 
return Model.getMetaTypes().getUseCase();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

