package org.argouml.profile.internal;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.argouml.model.Model;
import org.argouml.profile.CoreProfileReference;
import org.argouml.profile.Profile;
import org.argouml.profile.ProfileException;
import org.argouml.profile.ProfileModelLoader;
import org.argouml.profile.ProfileReference;
import org.argouml.profile.ResourceModelLoader;
import org.argouml.profile.internal.ocl.InvalidOclException;
public class ProfileMeta extends Profile
  { 
private static final String PROFILE_FILE = "metaprofile.xmi";
private Collection model;
@Override
    public String getDisplayName()
    { 
return "MetaProfile";
} 
@Override
    public Collection getProfilePackages() throws ProfileException
    { 
return model;
} 
@SuppressWarnings("unchecked")

    public ProfileMeta() throws ProfileException
    { 
ProfileModelLoader profileModelLoader = new ResourceModelLoader();
ProfileReference profileReference = null;
try//1
{ 
profileReference = new CoreProfileReference(PROFILE_FILE);
} 
catch (MalformedURLException e) //1
{ 
throw new ProfileException(
                "Exception while creating profile reference.", e);
} 
model = profileModelLoader.loadModel(profileReference);
if(model == null)//1
{ 
model = new ArrayList();
model.add(Model.getModelManagementFactory().createModel());
} 
} 

 } 
