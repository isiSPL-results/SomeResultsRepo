
//#if 1488953008 
// Compilation Unit of /Profile.java 
 

//#if 1581870865 
package org.argouml.profile;
//#endif 


//#if 1286643917 
import java.util.ArrayList;
//#endif 


//#if -1724113356 
import java.util.Collection;
//#endif 


//#if -863740720 
import java.util.HashSet;
//#endif 


//#if 1459358498 
import java.util.Set;
//#endif 


//#if 530161869 
import org.argouml.cognitive.Critic;
//#endif 


//#if -2094589568 
public abstract class Profile  { 

//#if -1025427144 
private Set<String> dependencies = new HashSet<String>();
//#endif 


//#if 147520006 
private Set<Critic> critics = new HashSet<Critic>();
//#endif 


//#if 1520112567 
public FormatingStrategy getFormatingStrategy()
    { 

//#if 246323302 
return null;
//#endif 

} 

//#endif 


//#if 992270873 
protected final void addProfileDependency(Profile p)
    throws IllegalArgumentException
    { 

//#if -260741675 
addProfileDependency(p.getProfileIdentifier());
//#endif 

} 

//#endif 


//#if 1003445975 
public DefaultTypeStrategy getDefaultTypeStrategy()
    { 

//#if 346174216 
return null;
//#endif 

} 

//#endif 


//#if -2031216884 
@Override
    public String toString()
    { 

//#if 876764699 
return getDisplayName();
//#endif 

} 

//#endif 


//#if -1111684414 
protected void addProfileDependency(String profileIdentifier)
    { 

//#if 1351188484 
dependencies.add(profileIdentifier);
//#endif 

} 

//#endif 


//#if 1166464066 
public Collection getProfilePackages() throws ProfileException
    { 

//#if -772393586 
return new ArrayList();
//#endif 

} 

//#endif 


//#if -1662738550 
public Set<Critic> getCritics()
    { 

//#if 297988356 
return critics;
//#endif 

} 

//#endif 


//#if 1819263750 
protected void setCritics(Set<Critic> criticsSet)
    { 

//#if 1978645408 
this.critics = criticsSet;
//#endif 

} 

//#endif 


//#if 829701419 
public final Set<Profile> getDependencies()
    { 

//#if 1361964727 
if(ProfileFacade.isInitiated())//1
{ 

//#if 743773120 
Set<Profile> ret = new HashSet<Profile>();
//#endif 


//#if 789619464 
for (String pid : dependencies) //1
{ 

//#if -1264330502 
Profile p = ProfileFacade.getManager()
                            .lookForRegisteredProfile(pid);
//#endif 


//#if -2139121117 
if(p != null)//1
{ 

//#if -1741152955 
ret.add(p);
//#endif 


//#if 1864646466 
ret.addAll(p.getDependencies());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1733066306 
return ret;
//#endif 

} 
else
{ 

//#if -875034847 
return new HashSet<Profile>();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 890888366 
public final Set<String> getDependenciesID()
    { 

//#if -1654672305 
return dependencies;
//#endif 

} 

//#endif 


//#if 2130276731 
public abstract String getDisplayName();
//#endif 


//#if -98244827 
public FigNodeStrategy getFigureStrategy()
    { 

//#if 670491703 
return null;
//#endif 

} 

//#endif 


//#if -1002419682 
public String getProfileIdentifier()
    { 

//#if 435182118 
return getDisplayName();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

