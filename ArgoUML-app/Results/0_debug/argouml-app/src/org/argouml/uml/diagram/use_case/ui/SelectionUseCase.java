
//#if 2105906971 
// Compilation Unit of /SelectionUseCase.java 
 

//#if -1071190655 
package org.argouml.uml.diagram.use_case.ui;
//#endif 


//#if 241687165 
import javax.swing.Icon;
//#endif 


//#if -637529462 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 756316113 
import org.argouml.model.Model;
//#endif 


//#if -957354720 
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
//#endif 


//#if 1834635464 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1511437314 
public class SelectionUseCase extends 
//#if -326054478 
SelectionNodeClarifiers2
//#endif 

  { 

//#if 706919415 
private static Icon inherit =
        ResourceLoaderWrapper.lookupIconResource("Generalization");
//#endif 


//#if -718853606 
private static Icon assoc =
        ResourceLoaderWrapper.lookupIconResource("Association");
//#endif 


//#if 1913916417 
private static Icon icons[] = {
        inherit,
        inherit,
        assoc,
        assoc,
        null,
    };
//#endif 


//#if -1518021643 
private static String instructions[] = {
        "Add a more general use case",
        "Add a more specialized use case",
        "Add an associated actor",
        "Add an associated actor",
        null,
        "Move object(s)",
    };
//#endif 


//#if -1898459438 
private static Object edgeType[] = {
        Model.getMetaTypes().getGeneralization(),
        Model.getMetaTypes().getGeneralization(),
        Model.getMetaTypes().getAssociation(),
        Model.getMetaTypes().getAssociation(),
        null,
    };
//#endif 


//#if 1966542628 
@Override
    protected Icon[] getIcons()
    { 

//#if 1254481041 
if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 

//#if 396012843 
return new Icon[] {null, inherit, null, null, null };
//#endif 

} 

//#endif 


//#if -401842036 
return icons;
//#endif 

} 

//#endif 


//#if -235422297 
@Override
    protected Object getNewNodeType(int index)
    { 

//#if -713829853 
if(index == TOP || index == BOTTOM)//1
{ 

//#if -1274016720 
return Model.getMetaTypes().getUseCase();
//#endif 

} 

//#endif 


//#if -361685139 
return Model.getMetaTypes().getActor();
//#endif 

} 

//#endif 


//#if -1370478556 
@Override
    protected String getInstructions(int index)
    { 

//#if 504425467 
return instructions[index - BASE];
//#endif 

} 

//#endif 


//#if 910154274 
@Override
    protected Object getNewEdgeType(int index)
    { 

//#if -1374503599 
return edgeType[index - BASE];
//#endif 

} 

//#endif 


//#if 72373813 
public SelectionUseCase(Fig f)
    { 

//#if 2130138335 
super(f);
//#endif 

} 

//#endif 


//#if 2063061581 
@Override
    protected Object getNewNode(int index)
    { 

//#if 1058068469 
if(index == 0)//1
{ 

//#if -1107319964 
index = getButton();
//#endif 

} 

//#endif 


//#if -1908817869 
if(index == TOP || index == BOTTOM)//1
{ 

//#if -1624570782 
return Model.getUseCasesFactory().createUseCase();
//#endif 

} 

//#endif 


//#if -419072539 
return Model.getUseCasesFactory().createActor();
//#endif 

} 

//#endif 


//#if 1022191279 
@Override
    protected boolean isReverseEdge(int index)
    { 

//#if 1164256931 
if(index == BOTTOM)//1
{ 

//#if 942404115 
return true;
//#endif 

} 

//#endif 


//#if 1824298993 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

