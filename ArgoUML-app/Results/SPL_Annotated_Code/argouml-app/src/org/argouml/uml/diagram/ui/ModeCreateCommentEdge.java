// Compilation Unit of /ModeCreateCommentEdge.java 
 
package org.argouml.uml.diagram.ui;
import org.argouml.model.Model;
import org.argouml.uml.CommentEdge;
import org.tigris.gef.presentation.Fig;
public final class ModeCreateCommentEdge extends ModeCreateGraphEdge
  { 
@Override
    protected final boolean isConnectionValid(Fig source, Fig dest)
    { 
if(dest instanceof FigNodeModelElement)//1
{ 
Object srcOwner = source.getOwner();
Object dstOwner = dest.getOwner();
if(!Model.getFacade().isAModelElement(srcOwner)
                    || !Model.getFacade().isAModelElement(dstOwner))//1
{ 
return false;
} 

if(Model.getModelManagementHelper().isReadOnly(srcOwner)
                    || Model.getModelManagementHelper().isReadOnly(dstOwner))//1
{ 
return false;
} 

return Model.getFacade().isAComment(srcOwner)
                   || Model.getFacade().isAComment(dstOwner);
} 
else
{ 
return true;
} 

} 

protected final Object getMetaType()
    { 
return CommentEdge.class;
} 

 } 


