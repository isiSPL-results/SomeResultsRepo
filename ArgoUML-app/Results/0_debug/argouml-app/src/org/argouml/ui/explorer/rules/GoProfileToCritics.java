
//#if -1255198658 
// Compilation Unit of /GoProfileToCritics.java 
 

//#if -889171899 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -2079470944 
import java.util.ArrayList;
//#endif 


//#if 1300508353 
import java.util.Collection;
//#endif 


//#if 1661055074 
import java.util.Collections;
//#endif 


//#if 2124795701 
import java.util.Set;
//#endif 


//#if -58534822 
import org.argouml.cognitive.Critic;
//#endif 


//#if 81208778 
import org.argouml.i18n.Translator;
//#endif 


//#if -2127313200 
import org.argouml.profile.Profile;
//#endif 


//#if -944774309 
public class GoProfileToCritics extends 
//#if 289837154 
AbstractPerspectiveRule
//#endif 

  { 

//#if 1593299952 
public String getRuleName()
    { 

//#if 1354022476 
return Translator.localize("misc.profile.critics");
//#endif 

} 

//#endif 


//#if -1849490472 
public Collection getChildren(final Object parent)
    { 

//#if -1827345726 
if(parent instanceof Profile)//1
{ 

//#if 360203914 
Object critics = new ArrayList<Critic>() {
                {
                    addAll(((Profile) parent).getCritics());
                }

                @Override
                public String toString() {
                    return Translator.localize("misc.profile.explorer.critic");
                }
            };
//#endif 


//#if -1419697701 
Collection ret = new ArrayList<Object>();
//#endif 


//#if -128696718 
ret.add(critics);
//#endif 


//#if -1969723979 
return ret;
//#endif 

} 

//#endif 


//#if 120885802 
return Collections.emptySet();
//#endif 

} 

//#endif 


//#if -681272078 
public Set getDependencies(Object parent)
    { 

//#if -1390973803 
return Collections.emptySet();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

