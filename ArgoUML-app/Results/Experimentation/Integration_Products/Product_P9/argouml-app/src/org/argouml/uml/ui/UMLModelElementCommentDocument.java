package org.argouml.uml.ui;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import org.argouml.model.Model;
public class UMLModelElementCommentDocument extends UMLPlainTextDocument
  { 
private boolean useBody;
protected String getProperty()
    { 
StringBuffer sb = new StringBuffer();
Collection comments = Collections.EMPTY_LIST;
if(Model.getFacade().isAModelElement(getTarget()))//1
{ 
comments = Model.getFacade().getComments(getTarget());
} 
for (Iterator i = comments.iterator(); i.hasNext();) //1
{ 
Object c = i.next();
String s;
if(useBody)//1
{ 
s = (String) Model.getFacade().getBody(c);
} 
else
{ 
s = Model.getFacade().getName(c);
} 
if(s == null)//1
{ 
s = "";
} 
sb.append(s);
sb.append(" // ");
} 
if(sb.length() > 4)//1
{ 
return (sb.substring(0, sb.length() - 4)).toString();
} 
else
{ 
return "";
} 
} 
protected void setProperty(String text)
    { 
} 
public UMLModelElementCommentDocument(boolean useBody)
    { 
super("comment");
this.useBody = useBody;
} 

 } 
