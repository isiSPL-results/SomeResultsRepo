package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoClassifierToBehavioralFeature extends AbstractPerspectiveRule
  { 
public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAClassifier(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 
return Collections.EMPTY_SET;
} 
public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAClassifier(parent))//1
{ 
return Model.getCoreHelper().getBehavioralFeatures(parent);
} 
return Collections.EMPTY_SET;
} 
public String getRuleName()
    { 
return Translator.localize("misc.classifier.behavioralfeature");
} 

 } 
