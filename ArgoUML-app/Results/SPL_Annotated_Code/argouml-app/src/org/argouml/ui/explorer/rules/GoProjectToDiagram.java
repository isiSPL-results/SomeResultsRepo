// Compilation Unit of /GoProjectToDiagram.java 
 
package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
public class GoProjectToDiagram extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(parent instanceof Project)//1
{ 
return ((Project) parent).getDiagramList();
} 

return Collections.EMPTY_SET;
} 

public String getRuleName()
    { 
return Translator.localize("misc.project.diagram");
} 

public Set getDependencies(Object parent)
    { 
return Collections.EMPTY_SET;
} 

 } 


