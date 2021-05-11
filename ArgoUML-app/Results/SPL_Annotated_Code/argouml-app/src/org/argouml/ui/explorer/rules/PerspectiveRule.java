// Compilation Unit of /PerspectiveRule.java 
 
package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Set;
public interface PerspectiveRule  { 
Set getDependencies(Object parent);
Collection getChildren(Object parent);
String getRuleName();
 } 


