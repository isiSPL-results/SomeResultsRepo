package org.argouml.uml.util.namespace;
import java.util.Iterator;
public interface Namespace  { 
public static final String JAVA_NS_TOKEN = ".";
public static final String UML_NS_TOKEN = "::";
public static final String CPP_NS_TOKEN = "::";
boolean isEmpty();NamespaceElement peekNamespaceElement();Namespace getCommonNamespace(Namespace namespace);Iterator iterator();NamespaceElement popNamespaceElement();void pushNamespaceElement(NamespaceElement element);String toString(String token);void setDefaultScopeToken(String token);Namespace getBaseNamespace();
 } 
