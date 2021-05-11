
//#if -38064323 
// Compilation Unit of /UMLModelElementCommentDocument.java 
 

//#if 720338242 
package org.argouml.uml.ui;
//#endif 


//#if 2000317504 
import java.util.Collection;
//#endif 


//#if 1880302275 
import java.util.Collections;
//#endif 


//#if 341420336 
import java.util.Iterator;
//#endif 


//#if -896220239 
import org.argouml.model.Model;
//#endif 


//#if -1158915894 
public class UMLModelElementCommentDocument extends 
//#if -1805090428 
UMLPlainTextDocument
//#endif 

  { 

//#if -1422581795 
private boolean useBody;
//#endif 


//#if -896432109 
protected String getProperty()
    { 

//#if -1829101788 
StringBuffer sb = new StringBuffer();
//#endif 


//#if -192015703 
Collection comments = Collections.EMPTY_LIST;
//#endif 


//#if -62542990 
if(Model.getFacade().isAModelElement(getTarget()))//1
{ 

//#if -1922132411 
comments = Model.getFacade().getComments(getTarget());
//#endif 

} 

//#endif 


//#if 351661871 
for (Iterator i = comments.iterator(); i.hasNext();) //1
{ 

//#if -1941381895 
Object c = i.next();
//#endif 


//#if -126487959 
String s;
//#endif 


//#if -1386468970 
if(useBody)//1
{ 

//#if 1366825612 
s = (String) Model.getFacade().getBody(c);
//#endif 

} 
else
{ 

//#if -767405408 
s = Model.getFacade().getName(c);
//#endif 

} 

//#endif 


//#if -160678745 
if(s == null)//1
{ 

//#if -511708149 
s = "";
//#endif 

} 

//#endif 


//#if 250527878 
sb.append(s);
//#endif 


//#if 804076753 
sb.append(" // ");
//#endif 

} 

//#endif 


//#if 732143387 
if(sb.length() > 4)//1
{ 

//#if -1247662080 
return (sb.substring(0, sb.length() - 4)).toString();
//#endif 

} 
else
{ 

//#if 749220590 
return "";
//#endif 

} 

//#endif 

} 

//#endif 


//#if -134322498 
protected void setProperty(String text)
    { 
} 

//#endif 


//#if -589714462 
public UMLModelElementCommentDocument(boolean useBody)
    { 

//#if 1334938593 
super("comment");
//#endif 


//#if 8008525 
this.useBody = useBody;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

