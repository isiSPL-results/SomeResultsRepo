package org.argouml.uml.util.namespace;
import java.util.Iterator;
import java.util.Stack;
import org.apache.log4j.Logger;
public class StringNamespace implements Namespace
,Cloneable
  { 
private static final Logger LOG = Logger.getLogger(StringNamespace.class);
private Stack ns = new Stack();
private String token = JAVA_NS_TOKEN;
public int hashCode()
    { 
return toString(JAVA_NS_TOKEN).hashCode();
} 
public boolean equals(Object namespace)
    { 
if(namespace instanceof Namespace)//1
{ 
String ns1 = this.toString(JAVA_NS_TOKEN);
String ns2 = ((Namespace) namespace).toString(JAVA_NS_TOKEN);
return ns1.equals(ns2);
} 
return false;
} 
public String toString(String theToken)
    { 
StringBuffer result = new StringBuffer();
Iterator i = ns.iterator();
while (i.hasNext()) //1
{ 
result.append(i.next());
if(i.hasNext())//1
{ 
result.append(theToken);
} 
} 
return result.toString();
} 
public StringNamespace(NamespaceElement[] elements)
    { 
this(elements, JAVA_NS_TOKEN);
} 
public static Namespace parse(Class c)
    { 
return parse(c.getName(), JAVA_NS_TOKEN);
} 
public StringNamespace()
    { 
} 
public Namespace getCommonNamespace(Namespace namespace)
    { 
Iterator i = iterator();
Iterator j = namespace.iterator();
StringNamespace result = new StringNamespace(token);
for (; i.hasNext() && j.hasNext();) //1
{ 
NamespaceElement elem1 = (NamespaceElement) i.next();
NamespaceElement elem2 = (NamespaceElement) j.next();
if(elem1.toString().equals(elem2.toString()))//1
{ 
result.pushNamespaceElement(elem1);
} 
} 
return result;
} 
public void setDefaultScopeToken(String theToken)
    { 
this.token = theToken;
} 
public static Namespace parse(String fqn, String token)
    { 
String myFqn = fqn;
StringNamespace sns = new StringNamespace(token);
int i = myFqn.indexOf(token);
while (i > -1) //1
{ 
sns.pushNamespaceElement(myFqn.substring(0, i));
myFqn = myFqn.substring(i + token.length());
i = myFqn.indexOf(token);
} 
if(myFqn.length() > 0)//1
{ 
sns.pushNamespaceElement(myFqn);
} 
return sns;
} 
public void pushNamespaceElement(NamespaceElement element)
    { 
ns.push(element);
} 
public StringNamespace(String theToken)
    { 
this();
this.token = theToken;
} 
public NamespaceElement popNamespaceElement()
    { 
return (NamespaceElement) ns.pop();
} 
public String toString()
    { 
return toString(token);
} 
public StringNamespace(String[] elements)
    { 
this(elements, JAVA_NS_TOKEN);
} 
public StringNamespace(NamespaceElement[] elements, String theToken)
    { 
this(theToken);
for (int i = 0; i < elements.length; i++) //1
{ 
pushNamespaceElement(new StringNamespaceElement(elements[i]
                                 .toString()));
} 
} 
public NamespaceElement peekNamespaceElement()
    { 
return (NamespaceElement) ns.peek();
} 
public Namespace getBaseNamespace()
    { 
StringNamespace result = null;
try//1
{ 
result = (StringNamespace) this.clone();
} 
catch (CloneNotSupportedException e) //1
{ 
LOG.debug(e);
return null;
} 
result.popNamespaceElement();
return result;
} 
public StringNamespace(String[] elements, String theToken)
    { 
this(theToken);
for (int i = 0; i < elements.length; i++) //1
{ 
pushNamespaceElement(new StringNamespaceElement(elements[i]));
} 
} 
public boolean isEmpty()
    { 
return ns.isEmpty();
} 
public Iterator iterator()
    { 
return ns.iterator();
} 
public void pushNamespaceElement(String element)
    { 
ns.push(new StringNamespaceElement(element));
} 

 } 
