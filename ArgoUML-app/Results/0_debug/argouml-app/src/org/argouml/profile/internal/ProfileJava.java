
//#if 184496246 
// Compilation Unit of /ProfileJava.java 
 

//#if -1995090010 
package org.argouml.profile.internal;
//#endif 


//#if -1120113208 
import java.net.MalformedURLException;
//#endif 


//#if 816271577 
import java.util.ArrayList;
//#endif 


//#if 874213288 
import java.util.Collection;
//#endif 


//#if -677370039 
import org.argouml.model.Model;
//#endif 


//#if 1744953347 
import org.argouml.profile.CoreProfileReference;
//#endif 


//#if -1985956316 
import org.argouml.profile.DefaultTypeStrategy;
//#endif 


//#if 1512309769 
import org.argouml.profile.Profile;
//#endif 


//#if 1715763678 
import org.argouml.profile.ProfileException;
//#endif 


//#if -1791726577 
import org.argouml.profile.ProfileFacade;
//#endif 


//#if 47170225 
import org.argouml.profile.ProfileModelLoader;
//#endif 


//#if 119990882 
import org.argouml.profile.ProfileReference;
//#endif 


//#if 436551716 
import org.argouml.profile.ResourceModelLoader;
//#endif 


//#if -494092628 
public class ProfileJava extends 
//#if -317512364 
Profile
//#endif 

  { 

//#if -1405847601 
private static final String PROFILE_FILE = "default-java.xmi";
//#endif 


//#if -1741481105 
static final String NAME = "Java";
//#endif 


//#if -114099033 
private ProfileModelLoader profileModelLoader;
//#endif 


//#if 616577982 
private Collection model;
//#endif 


//#if -371140953 
@Override
    public DefaultTypeStrategy getDefaultTypeStrategy()
    { 

//#if -152238657 
return new DefaultTypeStrategy() {
            public Object getDefaultAttributeType() {
                return ModelUtils.findTypeInModel("int", model.iterator()
                                                  .next());
            }

            public Object getDefaultParameterType() {
                return ModelUtils.findTypeInModel("int", model.iterator()
                                                  .next());
            }

            public Object getDefaultReturnType() {
                return ModelUtils.findTypeInModel("void", model.iterator()
                                                  .next());
            }

        };
//#endif 

} 

//#endif 


//#if -1490556182 
ProfileJava() throws ProfileException
    { 

//#if -17287344 
this(ProfileFacade.getManager().getProfileForClass(
                 ProfileUML.class.getName()));
//#endif 

} 

//#endif 


//#if -1545051801 
public String getDisplayName()
    { 

//#if 1330615652 
return NAME;
//#endif 

} 

//#endif 


//#if -1171382689 

//#if -843442880 
@SuppressWarnings("unchecked")
//#endif 


    ProfileJava(Profile uml) throws ProfileException
    { 

//#if 280892337 
profileModelLoader = new ResourceModelLoader();
//#endif 


//#if 1366476362 
ProfileReference profileReference = null;
//#endif 


//#if 135553829 
try //1
{ 

//#if 1110605353 
profileReference = new CoreProfileReference(PROFILE_FILE);
//#endif 

} 

//#if -623182306 
catch (MalformedURLException e) //1
{ 

//#if 296773643 
throw new ProfileException(
                "Exception while creating profile reference.", e);
//#endif 

} 

//#endif 


//#endif 


//#if -1335059567 
model = profileModelLoader.loadModel(profileReference);
//#endif 


//#if -981400836 
if(model == null)//1
{ 

//#if 492051076 
model = new ArrayList();
//#endif 


//#if -630852533 
model.add(Model.getModelManagementFactory().createModel());
//#endif 

} 

//#endif 


//#if -1401306688 
addProfileDependency(uml);
//#endif 


//#if -867968685 
addProfileDependency("CodeGeneration");
//#endif 

} 

//#endif 


//#if 525075103 
@Override
    public Collection getProfilePackages()
    { 

//#if 1868205196 
return model;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

