
//#if 1428219596 
// Compilation Unit of /CommentEdge.java 
 

//#if -359092823 
package org.argouml.uml;
//#endif 


//#if 165614019 
import javax.management.Notification;
//#endif 


//#if 1252663554 
import javax.management.NotificationBroadcasterSupport;
//#endif 


//#if -1865083340 
import org.argouml.i18n.Translator;
//#endif 


//#if -1600054534 
import org.argouml.model.Model;
//#endif 


//#if 866251185 
import org.argouml.model.UUIDManager;
//#endif 


//#if 410570926 
public class CommentEdge extends 
//#if 496426606 
NotificationBroadcasterSupport
//#endif 

  { 

//#if 1117771872 
private Object source;
//#endif 


//#if 809355961 
private Object dest;
//#endif 


//#if 825522368 
private Object uuid;
//#endif 


//#if -2057552676 
private Object comment;
//#endif 


//#if 440461911 
private Object annotatedElement;
//#endif 


//#if -1121247022 
public CommentEdge()
    { 

//#if 1513670130 
uuid = UUIDManager.getInstance().getNewUUID();
//#endif 

} 

//#endif 


//#if -1318509303 
public String toString()
    { 

//#if 166975936 
return Translator.localize("misc.tooltip.commentlink");
//#endif 

} 

//#endif 


//#if 551242484 
public void setAnnotatedElement(Object theAnnotatedElement)
    { 

//#if 1394193286 
if(theAnnotatedElement == null)//1
{ 

//#if -1720811654 
throw new IllegalArgumentException(
                "An annotated element must be supplied");
//#endif 

} 

//#endif 


//#if 713045660 
if(Model.getFacade().isAComment(theAnnotatedElement))//1
{ 

//#if 1204994250 
throw new IllegalArgumentException(
                "An annotated element cannot be a comment");
//#endif 

} 

//#endif 


//#if -941588484 
this.annotatedElement = theAnnotatedElement;
//#endif 

} 

//#endif 


//#if 558433355 
public CommentEdge(Object theSource, Object theDest)
    { 

//#if -246819271 
if(!(Model.getFacade().isAModelElement(theSource)))//1
{ 

//#if -1138789568 
throw new IllegalArgumentException(
                "The source of the CommentEdge must be a model element");
//#endif 

} 

//#endif 


//#if -500588288 
if(!(Model.getFacade().isAModelElement(theDest)))//1
{ 

//#if -924275243 
throw new IllegalArgumentException(
                "The destination of the CommentEdge "
                + "must be a model element");
//#endif 

} 

//#endif 


//#if 1168605167 
if(Model.getFacade().isAComment(theSource))//1
{ 

//#if 1431613454 
comment = theSource;
//#endif 


//#if 1798424384 
annotatedElement = theDest;
//#endif 

} 
else
{ 

//#if 1729438356 
comment = theDest;
//#endif 


//#if 29598810 
annotatedElement = theSource;
//#endif 

} 

//#endif 


//#if 1731534424 
this.source = theSource;
//#endif 


//#if -1196775990 
this.dest = theDest;
//#endif 


//#if -1470548244 
uuid = UUIDManager.getInstance().getNewUUID();
//#endif 

} 

//#endif 


//#if 439366819 
public Object getDestination()
    { 

//#if -1575984051 
return dest;
//#endif 

} 

//#endif 


//#if -1501832464 
public void setComment(Object theComment)
    { 

//#if 1246085238 
if(theComment == null)//1
{ 

//#if 470395730 
throw new IllegalArgumentException("A comment must be supplied");
//#endif 

} 

//#endif 


//#if 1521693389 
if(!Model.getFacade().isAComment(theComment))//1
{ 

//#if 714835329 
throw new IllegalArgumentException("A comment cannot be a "
                                               + theComment.getClass().getName());
//#endif 

} 

//#endif 


//#if -818984879 
this.comment = theComment;
//#endif 

} 

//#endif 


//#if -183890773 
public void delete()
    { 

//#if -862418733 
if(Model.getFacade().isAComment(source))//1
{ 

//#if 1502209380 
Model.getCoreHelper().removeAnnotatedElement(source, dest);
//#endif 

} 
else
{ 

//#if 1683943913 
if(Model.getFacade().isAComment(dest))//1
{ 

//#if 1540802871 
Model.getCoreHelper().removeAnnotatedElement(dest, source);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1245300987 
this.sendNotification(new Notification("remove", this, 0));
//#endif 

} 

//#endif 


//#if 1060306632 
public Object getSource()
    { 

//#if -1934850218 
return source;
//#endif 

} 

//#endif 


//#if 878946103 
public void setDestination(Object destination)
    { 

//#if 731728360 
if(destination == null)//1
{ 

//#if 755956175 
throw new IllegalArgumentException(
                "The destination of a comment edge cannot be null");
//#endif 

} 

//#endif 


//#if -75181958 
if(!(Model.getFacade().isAModelElement(destination)))//1
{ 

//#if 102059276 
throw new IllegalArgumentException(
                "The destination of the CommentEdge cannot be a "
                + destination.getClass().getName());
//#endif 

} 

//#endif 


//#if 686017042 
dest = destination;
//#endif 

} 

//#endif 


//#if -1845691215 
public Object getAnnotatedElement()
    { 

//#if 675896995 
return annotatedElement;
//#endif 

} 

//#endif 


//#if 1831142406 
public void setSource(Object theSource)
    { 

//#if 1854509744 
if(theSource == null)//1
{ 

//#if 1534217130 
throw new IllegalArgumentException(
                "The source of a comment edge cannot be null");
//#endif 

} 

//#endif 


//#if 729678466 
if(!(Model.getFacade().isAModelElement(theSource)))//1
{ 

//#if 1329653749 
throw new IllegalArgumentException(
                "The source of the CommentEdge cannot be a "
                + theSource.getClass().getName());
//#endif 

} 

//#endif 


//#if -517689695 
this.source = theSource;
//#endif 

} 

//#endif 


//#if 122378568 
public Object getUUID()
    { 

//#if -2093067271 
return uuid;
//#endif 

} 

//#endif 


//#if -1286784844 
public Object getComment()
    { 

//#if -546086706 
return comment;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

