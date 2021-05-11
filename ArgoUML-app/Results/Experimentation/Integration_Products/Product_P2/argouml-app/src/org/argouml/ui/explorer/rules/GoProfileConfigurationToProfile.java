package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.kernel.ProfileConfiguration;
public class GoProfileConfigurationToProfile extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(parent instanceof ProfileConfiguration)//1
{ 
return ((ProfileConfiguration) parent).getProfiles();
} 
return Collections.EMPTY_SET;
} 
public String getRuleName()
    { 
return Translator.localize("misc.profileconfiguration.profile");
} 
public Set getDependencies(Object parent)
    { 
return Collections.EMPTY_SET;
} 

 } 
