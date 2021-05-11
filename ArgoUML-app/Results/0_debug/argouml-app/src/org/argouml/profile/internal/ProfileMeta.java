
//#if -1720602419 
// Compilation Unit of /ProfileMeta.java 
 

//#if -1839775957 
package org.argouml.profile.internal;
//#endif 


//#if -600344861 
import java.net.MalformedURLException;
//#endif 


//#if 1708583582 
import java.util.ArrayList;
//#endif 


//#if -1528885629 
import java.util.Collection;
//#endif 


//#if 732227297 
import java.util.HashSet;
//#endif 


//#if 902710707 
import java.util.Set;
//#endif 


//#if 1412650638 
import org.argouml.model.Model;
//#endif 


//#if 128222046 
import org.argouml.profile.CoreProfileReference;
//#endif 


//#if -279705394 
import org.argouml.profile.Profile;
//#endif 


//#if -916651335 
import org.argouml.profile.ProfileException;
//#endif 


//#if 32080076 
import org.argouml.profile.ProfileModelLoader;
//#endif 


//#if 1782543165 
import org.argouml.profile.ProfileReference;
//#endif 


//#if -31242903 
import org.argouml.profile.ResourceModelLoader;
//#endif 


//#if -112789480 
import org.argouml.profile.internal.ocl.InvalidOclException;
//#endif 


//#if 1382732316 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1415396695 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -481221059 
import org.argouml.profile.internal.ocl.CrOCL;
//#endif 


//#if -1338806572 
public class ProfileMeta extends 
//#if 1280443203 
Profile
//#endif 

  { 

//#if -224979824 
private static final String PROFILE_FILE = "metaprofile.xmi";
//#endif 


//#if 993745837 
private Collection model;
//#endif 


//#if -1265717576 
@Override
    public String getDisplayName()
    { 

//#if 595296993 
return "MetaProfile";
//#endif 

} 

//#endif 


//#if 34757625 
private void loadWellFormednessRules()
    { 

//#if 1670180255 
Set<Critic> critics = new HashSet<Critic>();
//#endif 


//#if -671314901 
try //1
{ 

//#if -1911599507 
critics.add(new CrOCL("context ModelElement inv: "
                                  + "self.taggedValue->"
                                  + "exists(x|x.type.name='Dependency') implies "
                                  + "self.stereotype->exists(x|x.name = 'Profile')",
                                  "The 'Dependency' tag definition should be applied"
                                  + " only to profiles.", null,
                                  ToDoItem.MED_PRIORITY, null, null,
                                  "http://argouml.tigris.org/"));
//#endif 

} 

//#if -98289453 
catch (InvalidOclException e) //1
{ 

//#if -1996648564 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if -1774409050 
try //2
{ 

//#if -1769130905 
critics.add(new CrOCL("context ModelElement inv: "
                                  + "self.taggedValue->"
                                  + "exists(x|x.type.name='Figure') or "
                                  + "exists(x|x.type.name='Description') or "
                                  + "exists(x|x.type.name='i18n') or "
                                  + "exists(x|x.type.name='KnowledgeType') or "
                                  + "exists(x|x.type.name='MoreInfoURL') or "
                                  + "exists(x|x.type.name='Priority') or "
                                  + "exists(x|x.type.name='Description') or "
                                  + "exists(x|x.type.name='SupportedDecision') or "
                                  + "exists(x|x.type.name='Headline') "
                                  + "implies "
                                  + "self.stereotype->exists(x|x.name = 'Critic')",

                                  "Misuse of Metaprofile TaggedValues",
                                  "The 'Figure', 'i18n', 'KnowledgeType', 'MoreInfoURL', "
                                  + "'Priority', 'SupportedDecision', 'Description' "
                                  + "and 'Headline' tag definitions "
                                  + "should be applied only to OCL critics.",

                                  ToDoItem.MED_PRIORITY, null, null,
                                  "http://argouml.tigris.org/"));
//#endif 

} 

//#if 2033460618 
catch (InvalidOclException e) //1
{ 

//#if 482076760 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if -1774379258 
try //3
{ 

//#if -760952321 
critics.add(new CrOCL("context Stereotype inv: "
                                  + "self.namespace.stereotype->exists(x|x.name = 'Profile')",
                                  "Stereotypes should be declared inside a Profile. ",
                                  "Please add the <<Profile>> stereotype to "
                                  + "the containing Namespace",
                                  ToDoItem.MED_PRIORITY, null, null,
                                  "http://argouml.tigris.org/"));
//#endif 

} 

//#if 2010637692 
catch (InvalidOclException e) //1
{ 

//#if -2124688922 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if 1585152251 
setCritics(critics);
//#endif 

} 

//#endif 


//#if -680174623 
@Override
    public Collection getProfilePackages() throws ProfileException
    { 

//#if 1621609297 
return model;
//#endif 

} 

//#endif 


//#if 1714030771 

//#if 868772444 
@SuppressWarnings("unchecked")
//#endif 


    public ProfileMeta() throws ProfileException
    { 

//#if 1430073012 
ProfileModelLoader profileModelLoader = new ResourceModelLoader();
//#endif 


//#if -1928743878 
ProfileReference profileReference = null;
//#endif 


//#if 660541717 
try //1
{ 

//#if 1013467136 
profileReference = new CoreProfileReference(PROFILE_FILE);
//#endif 

} 

//#if 377656154 
catch (MalformedURLException e) //1
{ 

//#if -972498384 
throw new ProfileException(
                "Exception while creating profile reference.", e);
//#endif 

} 

//#endif 


//#endif 


//#if -1723986015 
model = profileModelLoader.loadModel(profileReference);
//#endif 


//#if 1812351212 
if(model == null)//1
{ 

//#if 1108156557 
model = new ArrayList();
//#endif 


//#if -1020056684 
model.add(Model.getModelManagementFactory().createModel());
//#endif 

} 

//#endif 


//#if 1877653808 
loadWellFormednessRules();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

