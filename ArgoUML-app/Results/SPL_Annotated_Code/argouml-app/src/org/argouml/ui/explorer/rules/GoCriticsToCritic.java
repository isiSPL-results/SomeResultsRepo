// Compilation Unit of /GoCriticsToCritic.java 
 

//#if COGNITIVE 
package org.argouml.ui.explorer.rules;
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
import java.util.Vector;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.CompoundCritic;
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
public class GoCriticsToCritic implements PerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.profile.critic");
} 

public Set getDependencies(Object parent)
    { 
return Collections.EMPTY_SET;
} 

public Collection getChildren(final Object parent)
    { 
if(parent instanceof Collection)//1
{ 
Collection v = (Collection) parent;
if(!v.isEmpty())//1
{ 
if(v.iterator().next() instanceof Critic)//1
{ 
Vector<Object> ret = new Vector<Object>();
for (Object critic : v) //1
{ 
final Critic fc = (Critic) critic;
if(critic instanceof CompoundCritic)//1
{ 
Object compound = new Vector<Critic>() {
                                {
                                    addAll(((CompoundCritic) fc)
                                           .getCriticList());
                                }

                                /*
                                 * @see java.util.Vector#toString()
                                 */
                                public String toString() {
                                    return Translator
                                           .localize("misc.profile.explorer.compound");
                                }
                            };
ret.add(compound);
} 
else
{ 
ret.add(critic);
} 

} 

return ret;
} 
else
{ 
return (Collection) parent;
} 

} 
else
{ 
return Collections.EMPTY_SET;
} 

} 

return Collections.EMPTY_SET;
} 

 } 

//#endif 


