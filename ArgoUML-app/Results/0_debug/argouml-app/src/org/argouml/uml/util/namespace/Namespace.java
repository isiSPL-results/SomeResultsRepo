
//#if -727495466 
// Compilation Unit of /Namespace.java 
 

//#if -1064741374 
package org.argouml.uml.util.namespace;
//#endif 


//#if -532457579 
import java.util.Iterator;
//#endif 


//#if -1348669154 
public interface Namespace  { 

//#if 180165740 
public static final String JAVA_NS_TOKEN = ".";
//#endif 


//#if -735239410 
public static final String UML_NS_TOKEN = "::";
//#endif 


//#if 2049986143 
public static final String CPP_NS_TOKEN = "::";
//#endif 


//#if 47559014 
boolean isEmpty();
//#endif 


//#if -740786264 
NamespaceElement peekNamespaceElement();
//#endif 


//#if -1523973460 
Namespace getCommonNamespace(Namespace namespace);
//#endif 


//#if 2023039111 
Iterator iterator();
//#endif 


//#if -883382360 
NamespaceElement popNamespaceElement();
//#endif 


//#if -586341571 
void pushNamespaceElement(NamespaceElement element);
//#endif 


//#if -726036958 
String toString(String token);
//#endif 


//#if -174181465 
void setDefaultScopeToken(String token);
//#endif 


//#if -59287034 
Namespace getBaseNamespace();
//#endif 

 } 

//#endif 


//#endif 

