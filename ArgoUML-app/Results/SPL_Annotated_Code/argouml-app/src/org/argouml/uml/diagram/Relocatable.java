// Compilation Unit of /Relocatable.java 
 
package org.argouml.uml.diagram;
import java.util.Collection;
public interface Relocatable  { 
boolean relocate(Object base);
@SuppressWarnings("unchecked")

    Collection getRelocationCandidates(Object root);
boolean isRelocationAllowed(Object base);
 } 


