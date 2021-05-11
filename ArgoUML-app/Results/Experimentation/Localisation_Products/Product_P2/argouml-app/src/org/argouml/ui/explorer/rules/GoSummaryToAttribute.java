package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoSummaryToAttribute extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(parent instanceof AttributesNode)//1
{ 
return Model.getFacade().getAttributes(((AttributesNode) parent)
                                                   .getParent());
} 
return Collections.EMPTY_SET;
} 
public Set getDependencies(Object parent)
    { 
if(parent instanceof AttributesNode)//1
{ 
Set set = new HashSet();
set.add(((AttributesNode) parent).getParent());
return set;
} 
return Collections.EMPTY_SET;
} 
public String getRuleName()
    { 
return Translator.localize("misc.summary.attribute");
} 

 } 
