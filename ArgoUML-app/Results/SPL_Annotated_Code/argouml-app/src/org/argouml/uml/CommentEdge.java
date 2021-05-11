// Compilation Unit of /CommentEdge.java 
 
package org.argouml.uml;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.model.UUIDManager;
public class CommentEdge extends NotificationBroadcasterSupport
  { 
private Object source;
private Object dest;
private Object uuid;
private Object comment;
private Object annotatedElement;
public CommentEdge()
    { 
uuid = UUIDManager.getInstance().getNewUUID();
} 

public String toString()
    { 
return Translator.localize("misc.tooltip.commentlink");
} 

public void setAnnotatedElement(Object theAnnotatedElement)
    { 
if(theAnnotatedElement == null)//1
{ 
throw new IllegalArgumentException(
                "An annotated element must be supplied");
} 

if(Model.getFacade().isAComment(theAnnotatedElement))//1
{ 
throw new IllegalArgumentException(
                "An annotated element cannot be a comment");
} 

this.annotatedElement = theAnnotatedElement;
} 

public CommentEdge(Object theSource, Object theDest)
    { 
if(!(Model.getFacade().isAModelElement(theSource)))//1
{ 
throw new IllegalArgumentException(
                "The source of the CommentEdge must be a model element");
} 

if(!(Model.getFacade().isAModelElement(theDest)))//1
{ 
throw new IllegalArgumentException(
                "The destination of the CommentEdge "
                + "must be a model element");
} 

if(Model.getFacade().isAComment(theSource))//1
{ 
comment = theSource;
annotatedElement = theDest;
} 
else
{ 
comment = theDest;
annotatedElement = theSource;
} 

this.source = theSource;
this.dest = theDest;
uuid = UUIDManager.getInstance().getNewUUID();
} 

public Object getDestination()
    { 
return dest;
} 

public void setComment(Object theComment)
    { 
if(theComment == null)//1
{ 
throw new IllegalArgumentException("A comment must be supplied");
} 

if(!Model.getFacade().isAComment(theComment))//1
{ 
throw new IllegalArgumentException("A comment cannot be a "
                                               + theComment.getClass().getName());
} 

this.comment = theComment;
} 

public void delete()
    { 
if(Model.getFacade().isAComment(source))//1
{ 
Model.getCoreHelper().removeAnnotatedElement(source, dest);
} 
else
{ 
if(Model.getFacade().isAComment(dest))//1
{ 
Model.getCoreHelper().removeAnnotatedElement(dest, source);
} 

} 

this.sendNotification(new Notification("remove", this, 0));
} 

public Object getSource()
    { 
return source;
} 

public void setDestination(Object destination)
    { 
if(destination == null)//1
{ 
throw new IllegalArgumentException(
                "The destination of a comment edge cannot be null");
} 

if(!(Model.getFacade().isAModelElement(destination)))//1
{ 
throw new IllegalArgumentException(
                "The destination of the CommentEdge cannot be a "
                + destination.getClass().getName());
} 

dest = destination;
} 

public Object getAnnotatedElement()
    { 
return annotatedElement;
} 

public void setSource(Object theSource)
    { 
if(theSource == null)//1
{ 
throw new IllegalArgumentException(
                "The source of a comment edge cannot be null");
} 

if(!(Model.getFacade().isAModelElement(theSource)))//1
{ 
throw new IllegalArgumentException(
                "The source of the CommentEdge cannot be a "
                + theSource.getClass().getName());
} 

this.source = theSource;
} 

public Object getUUID()
    { 
return uuid;
} 

public Object getComment()
    { 
return comment;
} 

 } 


