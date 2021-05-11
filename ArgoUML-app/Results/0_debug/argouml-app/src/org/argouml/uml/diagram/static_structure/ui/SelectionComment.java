
//#if -846668262 
// Compilation Unit of /SelectionComment.java 
 

//#if 1653023984 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -1387571598 
import javax.swing.Icon;
//#endif 


//#if -1303553099 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 870354492 
import org.argouml.model.Model;
//#endif 


//#if -2022296322 
import org.argouml.uml.CommentEdge;
//#endif 


//#if 96699659 
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
//#endif 


//#if -1035285453 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -473857409 
public class SelectionComment extends 
//#if -152516842 
SelectionNodeClarifiers2
//#endif 

  { 

//#if -1145051976 
private static Icon linkIcon =
        ResourceLoaderWrapper.lookupIconResource("CommentLink");
//#endif 


//#if 539222573 
private static Icon icons[] = {
        linkIcon,
        linkIcon,
        linkIcon,
        linkIcon,
        null,
    };
//#endif 


//#if 363957596 
private static String instructions[] = {
        "Link this comment",
        "Link this comment",
        "Link this comment",
        "Link this comment",
        null,
        "Move object(s)",
    };
//#endif 


//#if -988624117 
@Override
    protected Object getNewNodeType(int index)
    { 

//#if 643540669 
return Model.getMetaTypes().getComment();
//#endif 

} 

//#endif 


//#if 1050068800 
@Override
    protected String getInstructions(int index)
    { 

//#if -662765880 
return instructions[index - BASE];
//#endif 

} 

//#endif 


//#if -1504104015 
@Override
    protected Object getNewNode(int index)
    { 

//#if -1094453425 
return Model.getCoreFactory().createComment();
//#endif 

} 

//#endif 


//#if -1872735 
public SelectionComment(Fig f)
    { 

//#if 1860076931 
super(f);
//#endif 

} 

//#endif 


//#if 1510054792 
@Override
    protected Icon[] getIcons()
    { 

//#if 468257973 
if(Model.getModelManagementHelper().isReadOnly(
                    getContent().getOwner()))//1
{ 

//#if -164702434 
return null;
//#endif 

} 

//#endif 


//#if -1038084888 
return icons;
//#endif 

} 

//#endif 


//#if 156952454 
@Override
    protected Object getNewEdgeType(int index)
    { 

//#if 439403841 
return CommentEdge.class;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

