
//#if -2017283091 
// Compilation Unit of /GoCriticsToCritic.java 
 

//#if 2007660048 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -266205620 
import java.util.Collection;
//#endif 


//#if 337562167 
import java.util.Collections;
//#endif 


//#if 1919979018 
import java.util.Set;
//#endif 


//#if 369096647 
import java.util.Vector;
//#endif 


//#if -1017439558 
import org.argouml.cognitive.CompoundCritic;
//#endif 


//#if -1400770331 
import org.argouml.cognitive.Critic;
//#endif 


//#if 730647519 
import org.argouml.i18n.Translator;
//#endif 


//#if -1477874459 
import org.argouml.profile.Profile;
//#endif 


//#if 228249795 
public class GoCriticsToCritic implements 
//#if -1601545020 
PerspectiveRule
//#endif 

  { 

//#if -406373424 
public String getRuleName()
    { 

//#if -2082825519 
return Translator.localize("misc.profile.critic");
//#endif 

} 

//#endif 


//#if 891617554 
public Set getDependencies(Object parent)
    { 

//#if -1425851594 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1936541688 
public Collection getChildren(final Object parent)
    { 

//#if 544128204 
if(parent instanceof Collection)//1
{ 

//#if 1787522426 
Collection v = (Collection) parent;
//#endif 


//#if 788988527 
if(!v.isEmpty())//1
{ 

//#if 389235876 
if(v.iterator().next() instanceof Critic)//1
{ 

//#if 1999906275 
Vector<Object> ret = new Vector<Object>();
//#endif 


//#if -407748541 
for (Object critic : v) //1
{ 

//#if -729254977 
final Critic fc = (Critic) critic;
//#endif 


//#if -2007626547 
if(critic instanceof CompoundCritic)//1
{ 

//#if -1436070709 
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
//#endif 


//#if 1864304250 
ret.add(compound);
//#endif 

} 
else
{ 

//#if 1645589298 
ret.add(critic);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1896285335 
return ret;
//#endif 

} 
else
{ 

//#if 28276430 
return (Collection) parent;
//#endif 

} 

//#endif 

} 
else
{ 

//#if 1524734810 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1507729169 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

