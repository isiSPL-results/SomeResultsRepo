package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.tigris.gef.base.Diagram;
public class GoDiagramToNode extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(parent instanceof Diagram)//1
{ 
return ((Diagram) parent).getNodes();
} 
return Collections.EMPTY_SET;
} 
public String getRuleName()
    { 
return Translator.localize("misc.diagram.node");
} 
public Set getDependencies(Object parent)
    { 
return Collections.EMPTY_SET;
} 

 } 
