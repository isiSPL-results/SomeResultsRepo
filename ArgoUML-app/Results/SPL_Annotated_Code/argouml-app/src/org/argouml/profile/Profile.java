// Compilation Unit of /Profile.java 
 
package org.argouml.profile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

//#if COGNITIVE 
import org.argouml.cognitive.Critic;
//#endif 

public abstract class Profile  { 
private Set<String> dependencies = new HashSet<String>();

//#if COGNITIVE 
private Set<Critic> critics = new HashSet<Critic>();
//#endif 

public FormatingStrategy getFormatingStrategy()
    { 
return null;
} 

protected final void addProfileDependency(Profile p)
    throws IllegalArgumentException
    { 
addProfileDependency(p.getProfileIdentifier());
} 

public DefaultTypeStrategy getDefaultTypeStrategy()
    { 
return null;
} 

@Override
    public String toString()
    { 
return getDisplayName();
} 

protected void addProfileDependency(String profileIdentifier)
    { 
dependencies.add(profileIdentifier);
} 

public Collection getProfilePackages() throws ProfileException
    { 
return new ArrayList();
} 


//#if COGNITIVE 
public Set<Critic> getCritics()
    { 
return critics;
} 

//#endif 


//#if COGNITIVE 
protected void setCritics(Set<Critic> criticsSet)
    { 
this.critics = criticsSet;
} 

//#endif 

public final Set<Profile> getDependencies()
    { 
if(ProfileFacade.isInitiated())//1
{ 
Set<Profile> ret = new HashSet<Profile>();
for (String pid : dependencies) //1
{ 
Profile p = ProfileFacade.getManager()
                            .lookForRegisteredProfile(pid);
if(p != null)//1
{ 
ret.add(p);
ret.addAll(p.getDependencies());
} 

} 

return ret;
} 
else
{ 
return new HashSet<Profile>();
} 

} 

public final Set<String> getDependenciesID()
    { 
return dependencies;
} 

public abstract String getDisplayName();
public FigNodeStrategy getFigureStrategy()
    { 
return null;
} 

public String getProfileIdentifier()
    { 
return getDisplayName();
} 

 } 


