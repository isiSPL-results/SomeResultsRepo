package org.argouml.profile.internal;
import java.util.Iterator;
import org.argouml.model.Model;
import org.argouml.profile.FormatingStrategy;
public class JavaFormatingStrategy implements FormatingStrategy
  { 
protected String getPathSeparator()
    { 
return ".";
} 
protected String defaultAssocEndName(Object assocEnd,
                                         Object namespace)
    { 
String name = null;
Object type = Model.getFacade().getType(assocEnd);
if(type != null)//1
{ 
name = formatElement(type, namespace);
} 
else
{ 
name = "unknown type";
} 
Object mult = Model.getFacade().getMultiplicity(assocEnd);
if(mult != null)//1
{ 
StringBuffer buf = new StringBuffer(name);
buf.append("[");
buf.append(Integer.toString(Model.getFacade().getLower(mult)));
buf.append("..");
int upper = Model.getFacade().getUpper(mult);
if(upper >= 0)//1
{ 
buf.append(Integer.toString(upper));
} 
else
{ 
buf.append("*");
} 
buf.append("]");
name = buf.toString();
} 
return name;
} 
protected String defaultAssocName(Object assoc, Object ns)
    { 
StringBuffer buf = new StringBuffer();
Iterator iter = Model.getFacade().getConnections(assoc).iterator();
for (int i = 0; iter.hasNext(); i++) //1
{ 
if(i != 0)//1
{ 
buf.append("-");
} 
buf.append(defaultAssocEndName(iter.next(), ns));
} 
return buf.toString();
} 
public String formatElement(Object element, Object namespace)
    { 
String value = null;
if(element == null)//1
{ 
value = "";
} 
else
{ 
Object elementNs = Model.getFacade().getNamespace(element);
if(Model.getFacade().isAAssociationEnd(element))//1
{ 
Object assoc = Model.getFacade().getAssociation(element);
if(assoc != null)//1
{ 
elementNs = Model.getFacade().getNamespace(assoc);
} 
} 
if(elementNs == namespace)//1
{ 
value = Model.getFacade().getName(element);
if(value == null || value.length() == 0)//1
{ 
value = defaultName(element, namespace);
} 
} 
else
{ 
StringBuffer buffer = new StringBuffer();
String pathSep = getPathSeparator();
buildPath(buffer, element, pathSep);
value = buffer.toString();
} 
} 
return value;
} 
protected String defaultName(Object element, Object namespace)
    { 
String name = null;
if(Model.getFacade().isAAssociationEnd(element))//1
{ 
name = defaultAssocEndName(element, namespace);
} 
else
{ 
if(Model.getFacade().isAAssociation(element))//1
{ 
name = defaultAssocName(element, namespace);
} 
if(Model.getFacade().isAGeneralization(element))//1
{ 
name = defaultGeneralizationName(element, namespace);
} 
} 
if(name == null)//1
{ 
name = "anon";
} 
return name;
} 
protected String getElementSeparator()
    { 
return ", ";
} 
protected String defaultGeneralizationName(Object gen, Object namespace)
    { 
Object child = Model.getFacade().getSpecific(gen);
Object parent = Model.getFacade().getGeneral(gen);
StringBuffer buf = new StringBuffer();
buf.append(formatElement(child, namespace));
buf.append(" extends ");
buf.append(formatElement(parent, namespace));
return buf.toString();
} 
protected String getEmptyCollection()
    { 
return "[empty]";
} 
private void buildPath(StringBuffer buffer, Object element,
                           String pathSep)
    { 
if(element != null)//1
{ 
Object parent = Model.getFacade().getNamespace(element);
if(parent != null && parent != element)//1
{ 
buildPath(buffer, parent, pathSep);
buffer.append(pathSep);
} 
String name = Model.getFacade().getName(element);
if(name == null || name.length() == 0)//1
{ 
name = defaultName(element, null);
} 
buffer.append(name);
} 
} 
public String formatCollection(Iterator iter, Object namespace)
    { 
String value = null;
if(iter.hasNext())//1
{ 
StringBuffer buffer = new StringBuffer();
String elementSep = getElementSeparator();
Object obj = null;
for (int i = 0; iter.hasNext(); i++) //1
{ 
if(i > 0)//1
{ 
buffer.append(elementSep);
} 
obj = iter.next();
if(Model.getFacade().isAModelElement(obj))//1
{ 
buffer.append(formatElement(obj, namespace));
} 
else
{ 
buffer.append(obj.toString());
} 
} 
value = buffer.toString();
} 
else
{ 
value = getEmptyCollection();
} 
return value;
} 

 } 
