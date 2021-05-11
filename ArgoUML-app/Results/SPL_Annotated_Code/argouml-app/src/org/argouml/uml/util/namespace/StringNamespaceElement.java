// Compilation Unit of /StringNamespaceElement.java 
 
package org.argouml.uml.util.namespace;
public class StringNamespaceElement implements NamespaceElement
  { 
private final String element;
public String toString()
    { 
return element;
} 

public Object getNamespaceElement()
    { 
return element;
} 

public StringNamespaceElement(String strelement)
    { 
this.element = strelement;
} 

 } 


