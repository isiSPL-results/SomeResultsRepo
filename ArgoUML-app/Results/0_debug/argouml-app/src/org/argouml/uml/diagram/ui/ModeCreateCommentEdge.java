
//#if -1290671415 
// Compilation Unit of /ModeCreateCommentEdge.java 
 

//#if 1887057980 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1335567302 
import org.argouml.model.Model;
//#endif 


//#if 1903621512 
import org.argouml.uml.CommentEdge;
//#endif 


//#if 1166292925 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1746134533 
public final class ModeCreateCommentEdge extends 
//#if -2110494335 
ModeCreateGraphEdge
//#endif 

  { 

//#if -1796465405 
@Override
    protected final boolean isConnectionValid(Fig source, Fig dest)
    { 

//#if 1416712244 
if(dest instanceof FigNodeModelElement)//1
{ 

//#if 1431753337 
Object srcOwner = source.getOwner();
//#endif 


//#if 361850721 
Object dstOwner = dest.getOwner();
//#endif 


//#if 933578150 
if(!Model.getFacade().isAModelElement(srcOwner)
                    || !Model.getFacade().isAModelElement(dstOwner))//1
{ 

//#if 1385867605 
return false;
//#endif 

} 

//#endif 


//#if 1539184884 
if(Model.getModelManagementHelper().isReadOnly(srcOwner)
                    || Model.getModelManagementHelper().isReadOnly(dstOwner))//1
{ 

//#if 1040468028 
return false;
//#endif 

} 

//#endif 


//#if -484374286 
return Model.getFacade().isAComment(srcOwner)
                   || Model.getFacade().isAComment(dstOwner);
//#endif 

} 
else
{ 

//#if 781050038 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1367374340 
protected final Object getMetaType()
    { 

//#if 183282458 
return CommentEdge.class;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

