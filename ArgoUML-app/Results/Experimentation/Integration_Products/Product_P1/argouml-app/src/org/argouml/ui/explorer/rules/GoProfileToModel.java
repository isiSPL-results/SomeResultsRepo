package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.profile.Profile;
import org.argouml.profile.ProfileException;
public class GoProfileToModel extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.profile.model");
} 
public Set getDependencies(Object parent)
    { 
return Collections.EMPTY_SET;
} 
public Collection getChildren(Object parent)
    { 
if(parent instanceof Profile)//1
{ 
try//1
{ 
Collection col = ((Profile) parent).getProfilePackages();
return col;
} 
catch (ProfileException e) //1
{ 
return Collections.EMPTY_SET;
} 
} 
return Collections.EMPTY_SET;
} 

 } 
