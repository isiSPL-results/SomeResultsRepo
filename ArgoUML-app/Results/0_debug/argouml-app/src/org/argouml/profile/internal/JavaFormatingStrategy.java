
//#if 1742556366 
// Compilation Unit of /JavaFormatingStrategy.java 
 

//#if 856832183 
package org.argouml.profile.internal;
//#endif 


//#if 421103143 
import java.util.Iterator;
//#endif 


//#if -186947302 
import org.argouml.model.Model;
//#endif 


//#if 133768837 
import org.argouml.profile.FormatingStrategy;
//#endif 


//#if 1963096750 
public class JavaFormatingStrategy implements 
//#if 946685044 
FormatingStrategy
//#endif 

  { 

//#if 1665500704 
protected String getPathSeparator()
    { 

//#if -366109298 
return ".";
//#endif 

} 

//#endif 


//#if 626858025 
protected String defaultAssocEndName(Object assocEnd,
                                         Object namespace)
    { 

//#if -1097782815 
String name = null;
//#endif 


//#if -82580984 
Object type = Model.getFacade().getType(assocEnd);
//#endif 


//#if 103962754 
if(type != null)//1
{ 

//#if 236922442 
name = formatElement(type, namespace);
//#endif 

} 
else
{ 

//#if 1575515790 
name = "unknown type";
//#endif 

} 

//#endif 


//#if -152507795 
Object mult = Model.getFacade().getMultiplicity(assocEnd);
//#endif 


//#if -1179279624 
if(mult != null)//1
{ 

//#if -681040378 
StringBuffer buf = new StringBuffer(name);
//#endif 


//#if 633533759 
buf.append("[");
//#endif 


//#if 146323597 
buf.append(Integer.toString(Model.getFacade().getLower(mult)));
//#endif 


//#if -1876498130 
buf.append("..");
//#endif 


//#if -1412118327 
int upper = Model.getFacade().getUpper(mult);
//#endif 


//#if 1316151883 
if(upper >= 0)//1
{ 

//#if -795199995 
buf.append(Integer.toString(upper));
//#endif 

} 
else
{ 

//#if 1508389052 
buf.append("*");
//#endif 

} 

//#endif 


//#if 633593341 
buf.append("]");
//#endif 


//#if -917694184 
name = buf.toString();
//#endif 

} 

//#endif 


//#if -1202381838 
return name;
//#endif 

} 

//#endif 


//#if -994206117 
protected String defaultAssocName(Object assoc, Object ns)
    { 

//#if -1980223561 
StringBuffer buf = new StringBuffer();
//#endif 


//#if -339910891 
Iterator iter = Model.getFacade().getConnections(assoc).iterator();
//#endif 


//#if -241126454 
for (int i = 0; iter.hasNext(); i++) //1
{ 

//#if 1134610320 
if(i != 0)//1
{ 

//#if -1466659564 
buf.append("-");
//#endif 

} 

//#endif 


//#if -1834811111 
buf.append(defaultAssocEndName(iter.next(), ns));
//#endif 

} 

//#endif 


//#if -1602650192 
return buf.toString();
//#endif 

} 

//#endif 


//#if -1317019389 
public String formatElement(Object element, Object namespace)
    { 

//#if -1803642610 
String value = null;
//#endif 


//#if -1384363831 
if(element == null)//1
{ 

//#if -1249619969 
value = "";
//#endif 

} 
else
{ 

//#if 1673064542 
Object elementNs = Model.getFacade().getNamespace(element);
//#endif 


//#if 688247747 
if(Model.getFacade().isAAssociationEnd(element))//1
{ 

//#if 112232825 
Object assoc = Model.getFacade().getAssociation(element);
//#endif 


//#if 307271764 
if(assoc != null)//1
{ 

//#if -317846418 
elementNs = Model.getFacade().getNamespace(assoc);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1990981417 
if(elementNs == namespace)//1
{ 

//#if -84732681 
value = Model.getFacade().getName(element);
//#endif 


//#if 1320026053 
if(value == null || value.length() == 0)//1
{ 

//#if -1255662010 
value = defaultName(element, namespace);
//#endif 

} 

//#endif 

} 
else
{ 

//#if 221858529 
StringBuffer buffer = new StringBuffer();
//#endif 


//#if 1986518119 
String pathSep = getPathSeparator();
//#endif 


//#if -1322887016 
buildPath(buffer, element, pathSep);
//#endif 


//#if -595710816 
value = buffer.toString();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1037089789 
return value;
//#endif 

} 

//#endif 


//#if 351376941 
protected String defaultName(Object element, Object namespace)
    { 

//#if -713892194 
String name = null;
//#endif 


//#if -1654026098 
if(Model.getFacade().isAAssociationEnd(element))//1
{ 

//#if -1352683337 
name = defaultAssocEndName(element, namespace);
//#endif 

} 
else
{ 

//#if 227791919 
if(Model.getFacade().isAAssociation(element))//1
{ 

//#if -902722990 
name = defaultAssocName(element, namespace);
//#endif 

} 

//#endif 


//#if 1447508686 
if(Model.getFacade().isAGeneralization(element))//1
{ 

//#if -1002022459 
name = defaultGeneralizationName(element, namespace);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -989899558 
if(name == null)//1
{ 

//#if -1380020156 
name = "anon";
//#endif 

} 

//#endif 


//#if 1278911765 
return name;
//#endif 

} 

//#endif 


//#if 1029872843 
protected String getElementSeparator()
    { 

//#if -128996820 
return ", ";
//#endif 

} 

//#endif 


//#if 692404029 
protected String defaultGeneralizationName(Object gen, Object namespace)
    { 

//#if -453496647 
Object child = Model.getFacade().getSpecific(gen);
//#endif 


//#if -1840676261 
Object parent = Model.getFacade().getGeneral(gen);
//#endif 


//#if 1151966379 
StringBuffer buf = new StringBuffer();
//#endif 


//#if 576480127 
buf.append(formatElement(child, namespace));
//#endif 


//#if 896819633 
buf.append(" extends ");
//#endif 


//#if -1366188429 
buf.append(formatElement(parent, namespace));
//#endif 


//#if -1598679492 
return buf.toString();
//#endif 

} 

//#endif 


//#if -379113685 
protected String getEmptyCollection()
    { 

//#if 129734056 
return "[empty]";
//#endif 

} 

//#endif 


//#if 1778073449 
private void buildPath(StringBuffer buffer, Object element,
                           String pathSep)
    { 

//#if 592087213 
if(element != null)//1
{ 

//#if 1947640035 
Object parent = Model.getFacade().getNamespace(element);
//#endif 


//#if -500197276 
if(parent != null && parent != element)//1
{ 

//#if 1666793555 
buildPath(buffer, parent, pathSep);
//#endif 


//#if -1648937858 
buffer.append(pathSep);
//#endif 

} 

//#endif 


//#if 241753538 
String name = Model.getFacade().getName(element);
//#endif 


//#if -924763155 
if(name == null || name.length() == 0)//1
{ 

//#if -305123312 
name = defaultName(element, null);
//#endif 

} 

//#endif 


//#if -1666456965 
buffer.append(name);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 775917252 
public String formatCollection(Iterator iter, Object namespace)
    { 

//#if -549761972 
String value = null;
//#endif 


//#if -350687488 
if(iter.hasNext())//1
{ 

//#if -214086786 
StringBuffer buffer = new StringBuffer();
//#endif 


//#if -972735090 
String elementSep = getElementSeparator();
//#endif 


//#if 1957058712 
Object obj = null;
//#endif 


//#if -1603448186 
for (int i = 0; iter.hasNext(); i++) //1
{ 

//#if 1104037674 
if(i > 0)//1
{ 

//#if 1979645748 
buffer.append(elementSep);
//#endif 

} 

//#endif 


//#if -1560036183 
obj = iter.next();
//#endif 


//#if -1468397485 
if(Model.getFacade().isAModelElement(obj))//1
{ 

//#if -716635791 
buffer.append(formatElement(obj, namespace));
//#endif 

} 
else
{ 

//#if -1095363136 
buffer.append(obj.toString());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 953446627 
value = buffer.toString();
//#endif 

} 
else
{ 

//#if 1904127910 
value = getEmptyCollection();
//#endif 

} 

//#endif 


//#if 260243973 
return value;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

