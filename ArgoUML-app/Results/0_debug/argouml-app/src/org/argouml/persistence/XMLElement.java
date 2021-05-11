
//#if 543857971 
// Compilation Unit of /XMLElement.java 
 

//#if 1498172530 
package org.argouml.persistence;
//#endif 


//#if -1190694547 
import org.xml.sax.Attributes;
//#endif 


//#if -1628816444 
import org.xml.sax.helpers.AttributesImpl;
//#endif 


//#if 1608842928 
class XMLElement  { 

//#if -1472852864 
private String        name       = null;
//#endif 


//#if 1395619930 
private StringBuffer  text       = new StringBuffer(100);
//#endif 


//#if 451873426 
private Attributes    attributes = null;
//#endif 


//#if -1834790121 
public int length()
    { 

//#if -1638264901 
return text.length();
//#endif 

} 

//#endif 


//#if -2132270734 
public void   setText(String t)
    { 

//#if 9554555 
text = new StringBuffer(t);
//#endif 

} 

//#endif 


//#if 1251677714 
public XMLElement(String n, Attributes a)
    { 

//#if 1160215919 
name = n;
//#endif 


//#if 1858728236 
attributes = new AttributesImpl(a);
//#endif 

} 

//#endif 


//#if -251381262 
public String getName()
    { 

//#if -1723676139 
return name;
//#endif 

} 

//#endif 


//#if 1533566768 
public String getAttribute(String attribute)
    { 

//#if 797309945 
return attributes.getValue(attribute);
//#endif 

} 

//#endif 


//#if -1337253302 
public void   resetText()
    { 

//#if 911121464 
text.setLength(0);
//#endif 

} 

//#endif 


//#if -75570156 
public String getText()
    { 

//#if -293010124 
return text.toString();
//#endif 

} 

//#endif 


//#if 753828755 
public void   addText(String t)
    { 

//#if 481829256 
text = text.append(t);
//#endif 

} 

//#endif 


//#if -516443000 
public String getAttributeName(int i)
    { 

//#if -1604057982 
return attributes.getLocalName(i);
//#endif 

} 

//#endif 


//#if -2123313237 
public void addText(char[] c, int offset, int len)
    { 

//#if 1038166850 
text = text.append(c, offset, len);
//#endif 

} 

//#endif 


//#if 39514370 
public String getAttributeValue(int i)
    { 

//#if 1749312828 
return attributes.getValue(i);
//#endif 

} 

//#endif 


//#if 351147290 
public void   setName(String n)
    { 

//#if -790447146 
name = n;
//#endif 

} 

//#endif 


//#if 1050959937 
public void   setAttributes(Attributes a)
    { 

//#if -1097348937 
attributes = new AttributesImpl(a);
//#endif 

} 

//#endif 


//#if 1623623096 
public int    getNumAttributes()
    { 

//#if 2063497944 
return attributes.getLength();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

