// Compilation Unit of /GoProfileToCritics.java 
 

//#if COGNITIVE 
package org.argouml.ui.explorer.rules;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.Collection;
//#endif 


//#if COGNITIVE 
import java.util.Collections;
//#endif 


//#if COGNITIVE 
import java.util.Set;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Critic;
//#endif 


//#if COGNITIVE 
import org.argouml.i18n.Translator;
//#endif 


//#if COGNITIVE 
import org.argouml.profile.Profile;
//#endif 


//#if COGNITIVE 
public class GoProfileToCritics extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.profile.critics");
} 

public Collection getChildren(final Object parent)
    { 
if(parent instanceof Profile)//1
{ 
Object critics = new ArrayList<Critic>() {
                {
                    addAll(((Profile) parent).getCritics());
                }

                @Override
                public String toString() {
                    return Translator.localize("misc.profile.explorer.critic");
                }
            };
Collection ret = new ArrayList<Object>();
ret.add(critics);
return ret;
} 

return Collections.emptySet();
} 

public Set getDependencies(Object parent)
    { 
return Collections.emptySet();
} 

 } 

//#endif 


