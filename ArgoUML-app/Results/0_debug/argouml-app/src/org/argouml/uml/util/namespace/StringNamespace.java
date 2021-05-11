
//#if -906692264 
// Compilation Unit of /StringNamespace.java 
 

//#if 1649718178 
package org.argouml.uml.util.namespace;
//#endif 


//#if -1624222219 
import java.util.Iterator;
//#endif 


//#if 1364350795 
import java.util.Stack;
//#endif 


//#if -116056423 
import org.apache.log4j.Logger;
//#endif 


//#if -1447354546 
public class StringNamespace implements 
//#if 395718339 
Namespace
//#endif 

, 
//#if -1481747041 
Cloneable
//#endif 

  { 

//#if 2346604 
private static final Logger LOG = Logger.getLogger(StringNamespace.class);
//#endif 


//#if 1009860855 
private Stack ns = new Stack();
//#endif 


//#if 1589860543 
private String token = JAVA_NS_TOKEN;
//#endif 


//#if -1988198582 
public int hashCode()
    { 

//#if 1247974120 
return toString(JAVA_NS_TOKEN).hashCode();
//#endif 

} 

//#endif 


//#if 1464438287 
public boolean equals(Object namespace)
    { 

//#if -2019894266 
if(namespace instanceof Namespace)//1
{ 

//#if 871741400 
String ns1 = this.toString(JAVA_NS_TOKEN);
//#endif 


//#if 381206715 
String ns2 = ((Namespace) namespace).toString(JAVA_NS_TOKEN);
//#endif 


//#if 1462436432 
return ns1.equals(ns2);
//#endif 

} 

//#endif 


//#if -1805157879 
return false;
//#endif 

} 

//#endif 


//#if 2066794662 
public String toString(String theToken)
    { 

//#if 2043839117 
StringBuffer result = new StringBuffer();
//#endif 


//#if 2020788400 
Iterator i = ns.iterator();
//#endif 


//#if -1566596241 
while (i.hasNext()) //1
{ 

//#if 720481643 
result.append(i.next());
//#endif 


//#if 1310961481 
if(i.hasNext())//1
{ 

//#if -1095643835 
result.append(theToken);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1585691384 
return result.toString();
//#endif 

} 

//#endif 


//#if -1089654640 
public StringNamespace(NamespaceElement[] elements)
    { 

//#if 1307903978 
this(elements, JAVA_NS_TOKEN);
//#endif 

} 

//#endif 


//#if 967233277 
public static Namespace parse(Class c)
    { 

//#if -1184414991 
return parse(c.getName(), JAVA_NS_TOKEN);
//#endif 

} 

//#endif 


//#if 150448874 
public StringNamespace()
    { 
} 

//#endif 


//#if 197689845 
public Namespace getCommonNamespace(Namespace namespace)
    { 

//#if -379477619 
Iterator i = iterator();
//#endif 


//#if 186225019 
Iterator j = namespace.iterator();
//#endif 


//#if 1962785440 
StringNamespace result = new StringNamespace(token);
//#endif 


//#if -1975229853 
for (; i.hasNext() && j.hasNext();) //1
{ 

//#if -799036357 
NamespaceElement elem1 = (NamespaceElement) i.next();
//#endif 


//#if -1913389123 
NamespaceElement elem2 = (NamespaceElement) j.next();
//#endif 


//#if 1543258309 
if(elem1.toString().equals(elem2.toString()))//1
{ 

//#if -1676680970 
result.pushNamespaceElement(elem1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 683551793 
return result;
//#endif 

} 

//#endif 


//#if 513976385 
public void setDefaultScopeToken(String theToken)
    { 

//#if -1677704264 
this.token = theToken;
//#endif 

} 

//#endif 


//#if 560280476 
public static Namespace parse(String fqn, String token)
    { 

//#if -905489861 
String myFqn = fqn;
//#endif 


//#if 1854227632 
StringNamespace sns = new StringNamespace(token);
//#endif 


//#if -375108642 
int i = myFqn.indexOf(token);
//#endif 


//#if 1190700228 
while (i > -1) //1
{ 

//#if -1250875018 
sns.pushNamespaceElement(myFqn.substring(0, i));
//#endif 


//#if 98521281 
myFqn = myFqn.substring(i + token.length());
//#endif 


//#if -1658619708 
i = myFqn.indexOf(token);
//#endif 

} 

//#endif 


//#if -1176867113 
if(myFqn.length() > 0)//1
{ 

//#if 1261894608 
sns.pushNamespaceElement(myFqn);
//#endif 

} 

//#endif 


//#if 997949247 
return sns;
//#endif 

} 

//#endif 


//#if 369685574 
public void pushNamespaceElement(NamespaceElement element)
    { 

//#if -1148382491 
ns.push(element);
//#endif 

} 

//#endif 


//#if -212698863 
public StringNamespace(String theToken)
    { 

//#if -2098043667 
this();
//#endif 


//#if 1371152302 
this.token = theToken;
//#endif 

} 

//#endif 


//#if 1896283697 
public NamespaceElement popNamespaceElement()
    { 

//#if -2025307087 
return (NamespaceElement) ns.pop();
//#endif 

} 

//#endif 


//#if -1624657089 
public String toString()
    { 

//#if -533162693 
return toString(token);
//#endif 

} 

//#endif 


//#if 245621984 
public StringNamespace(String[] elements)
    { 

//#if 1730819230 
this(elements, JAVA_NS_TOKEN);
//#endif 

} 

//#endif 


//#if 2035313437 
public StringNamespace(NamespaceElement[] elements, String theToken)
    { 

//#if 2006827925 
this(theToken);
//#endif 


//#if -1692341440 
for (int i = 0; i < elements.length; i++) //1
{ 

//#if -1426341121 
pushNamespaceElement(new StringNamespaceElement(elements[i]
                                 .toString()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -470484417 
public NamespaceElement peekNamespaceElement()
    { 

//#if 299021101 
return (NamespaceElement) ns.peek();
//#endif 

} 

//#endif 


//#if -880961585 
public Namespace getBaseNamespace()
    { 

//#if 533379423 
StringNamespace result = null;
//#endif 


//#if 1547594677 
try //1
{ 

//#if -407050696 
result = (StringNamespace) this.clone();
//#endif 

} 

//#if -287600292 
catch (CloneNotSupportedException e) //1
{ 

//#if 1159043902 
LOG.debug(e);
//#endif 


//#if 431288170 
return null;
//#endif 

} 

//#endif 


//#endif 


//#if -101442150 
result.popNamespaceElement();
//#endif 


//#if 75884207 
return result;
//#endif 

} 

//#endif 


//#if 1485868237 
public StringNamespace(String[] elements, String theToken)
    { 

//#if -322350859 
this(theToken);
//#endif 


//#if -1195017760 
for (int i = 0; i < elements.length; i++) //1
{ 

//#if -1828077589 
pushNamespaceElement(new StringNamespaceElement(elements[i]));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2094254275 
public boolean isEmpty()
    { 

//#if 1430560221 
return ns.isEmpty();
//#endif 

} 

//#endif 


//#if 1029803166 
public Iterator iterator()
    { 

//#if 255615731 
return ns.iterator();
//#endif 

} 

//#endif 


//#if 1762207030 
public void pushNamespaceElement(String element)
    { 

//#if -1706539271 
ns.push(new StringNamespaceElement(element));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

