// Compilation Unit of /UMLUserInterfaceContainer.java 
 
package org.argouml.uml.ui;
import java.util.Iterator;
import org.argouml.kernel.ProfileConfiguration;
public interface UMLUserInterfaceContainer  { 
public Object getModelElement();
public String formatElement(Object element);
public Object getTarget();
public ProfileConfiguration getProfile();
public String formatNamespace(Object ns);
public String formatCollection(Iterator iter);
 } 


