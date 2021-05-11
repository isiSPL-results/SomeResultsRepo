package org.argouml.persistence;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;
class XMLElement  { 
private String        name       = null;
private StringBuffer  text       = new StringBuffer(100);
private Attributes    attributes = null;
public int length()
    { 
return text.length();
} 
public void   setText(String t)
    { 
text = new StringBuffer(t);
} 
public XMLElement(String n, Attributes a)
    { 
name = n;
attributes = new AttributesImpl(a);
} 
public String getName()
    { 
return name;
} 
public String getAttribute(String attribute)
    { 
return attributes.getValue(attribute);
} 
public void   resetText()
    { 
text.setLength(0);
} 
public String getText()
    { 
return text.toString();
} 
public void   addText(String t)
    { 
text = text.append(t);
} 
public String getAttributeName(int i)
    { 
return attributes.getLocalName(i);
} 
public void addText(char[] c, int offset, int len)
    { 
text = text.append(c, offset, len);
} 
public String getAttributeValue(int i)
    { 
return attributes.getValue(i);
} 
public void   setName(String n)
    { 
name = n;
} 
public void   setAttributes(Attributes a)
    { 
attributes = new AttributesImpl(a);
} 
public int    getNumAttributes()
    { 
return attributes.getLength();
} 

 } 
