// Compilation Unit of /UserDefinedProfile.java 
 
package org.argouml.profile;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import org.argouml.model.Model;
import org.argouml.profile.internal.ocl.InvalidOclException;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Critic;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Decision;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Translator;
//#endif 


//#if COGNITIVE 
import org.argouml.profile.internal.ocl.CrOCL;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 

public class UserDefinedProfile extends Profile
  { 
private String displayName;
private File modelFile;
private Collection profilePackages;
private UserDefinedFigNodeStrategy figNodeStrategy
        = new UserDefinedFigNodeStrategy();

//#if LOGGING 
private static final Logger LOG = Logger
                                      .getLogger(UserDefinedProfile.class);
//#endif 


//#if COGNITIVE 
public UserDefinedProfile(String dn, URL url,


                              Set<Critic> critics,

                              Set<String> dependencies) throws ProfileException
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.info("load " + url);
//#endif 

this.displayName = dn;
if(url != null)//1
{ 
ProfileReference reference = null;
reference = new UserProfileReference(url.getPath(), url);
profilePackages = new URLModelLoader().loadModel(reference);
} 
else
{ 
profilePackages = new ArrayList(0);
} 

this.setCritics(critics);
for (String profileID : dependencies) //1
{ 
addProfileDependency(profileID);
} 

finishLoading();
} 

//#endif 


//#if COGNITIVE 
private CrOCL generateCriticFromComment(Object critique)
    { 
String ocl = "" + Model.getFacade().getBody(critique);
String headline = null;
String description = null;
int priority = ToDoItem.HIGH_PRIORITY;
List<Decision> supportedDecisions = new ArrayList<Decision>();
List<String> knowledgeTypes = new ArrayList<String>();
String moreInfoURL = null;
Collection tags = Model.getFacade().getTaggedValuesCollection(critique);
boolean i18nFound = false;
for (Object tag : tags) //1
{ 
if(Model.getFacade().getTag(tag).toLowerCase().equals("i18n"))//1
{ 
i18nFound = true;
String i18nSource = Model.getFacade().getValueOfTag(tag);
headline = Translator.localize(i18nSource + "-head");
description = Translator.localize(i18nSource + "-desc");
moreInfoURL = Translator.localize(i18nSource + "-moreInfoURL");
} 
else

//#if COGNITIVE 
if(!i18nFound
                       && Model.getFacade().getTag(tag).toLowerCase().equals(
                           "headline"))//1
{ 
headline = Model.getFacade().getValueOfTag(tag);
} 
else

//#if COGNITIVE 
if(!i18nFound
                       && Model.getFacade().getTag(tag).toLowerCase().equals(
                           "description"))//1
{ 
description = Model.getFacade().getValueOfTag(tag);
} 
else

//#if COGNITIVE 
if(Model.getFacade().getTag(tag).toLowerCase().equals(
                           "priority"))//1
{ 
priority = str2Priority(Model.getFacade().getValueOfTag(tag));
} 
else

//#if COGNITIVE 
if(Model.getFacade().getTag(tag).toLowerCase().equals(
                           "supporteddecision"))//1
{ 
String decStr = Model.getFacade().getValueOfTag(tag);
StringTokenizer st = new StringTokenizer(decStr, ",;:");
while (st.hasMoreTokens()) //1
{ 
Decision decision = str2Decision(st.nextToken().trim()
                                                     .toLowerCase());
if(decision != null)//1
{ 
supportedDecisions.add(decision);
} 

} 

} 
else

//#if COGNITIVE 
if(Model.getFacade().getTag(tag).toLowerCase().equals(
                           "knowledgetype"))//1
{ 
String ktStr = Model.getFacade().getValueOfTag(tag);
StringTokenizer st = new StringTokenizer(ktStr, ",;:");
while (st.hasMoreTokens()) //1
{ 
String knowledge = str2KnowledgeType(st.nextToken().trim()
                                                         .toLowerCase());
if(knowledge != null)//1
{ 
knowledgeTypes.add(knowledge);
} 

} 

} 
else

//#if COGNITIVE 
if(!i18nFound
                       && Model.getFacade().getTag(tag).toLowerCase().equals(
                           "moreinfourl"))//1
{ 
moreInfoURL = Model.getFacade().getValueOfTag(tag);
} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


} 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("OCL-Critic: " + ocl);
//#endif 

try //1
{ 
return new CrOCL(ocl, headline, description, priority,
                             supportedDecisions, knowledgeTypes, moreInfoURL);
} 

//#if COGNITIVE 
catch (InvalidOclException e) //1
{ 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.error("Invalid OCL in XMI!", e);
//#endif 

return null;
} 

//#endif 


} 

//#endif 

@SuppressWarnings("unchecked")

    private Collection<Object> getAllCommentsInModel(Collection objs)
    { 
Collection<Object> col = new ArrayList<Object>();
for (Object obj : objs) //1
{ 
if(Model.getFacade().isAComment(obj))//1
{ 
col.add(obj);
} 
else
if(Model.getFacade().isANamespace(obj))//1
{ 
Collection contents = Model
                                      .getModelManagementHelper().getAllContents(obj);
if(contents != null)//1
{ 
col.addAll(contents);
} 

} 


} 

return col;
} 


//#if COGNITIVE 
private Decision str2Decision(String token)
    { 
Decision decision = null;
if(token.equals("behavior"))//1
{ 
decision = UMLDecision.BEHAVIOR;
} 

if(token.equals("containment"))//1
{ 
decision = UMLDecision.CONTAINMENT;
} 

if(token.equals("classselection"))//1
{ 
decision = UMLDecision.CLASS_SELECTION;
} 

if(token.equals("codegen"))//1
{ 
decision = UMLDecision.CODE_GEN;
} 

if(token.equals("expectedusage"))//1
{ 
decision = UMLDecision.EXPECTED_USAGE;
} 

if(token.equals("inheritance"))//1
{ 
decision = UMLDecision.INHERITANCE;
} 

if(token.equals("instantiation"))//1
{ 
decision = UMLDecision.INSTANCIATION;
} 

if(token.equals("methods"))//1
{ 
decision = UMLDecision.METHODS;
} 

if(token.equals("modularity"))//1
{ 
decision = UMLDecision.MODULARITY;
} 

if(token.equals("naming"))//1
{ 
decision = UMLDecision.NAMING;
} 

if(token.equals("patterns"))//1
{ 
decision = UMLDecision.PATTERNS;
} 

if(token.equals("plannedextensions"))//1
{ 
decision = UMLDecision.PLANNED_EXTENSIONS;
} 

if(token.equals("relationships"))//1
{ 
decision = UMLDecision.RELATIONSHIPS;
} 

if(token.equals("statemachines"))//1
{ 
decision = UMLDecision.STATE_MACHINES;
} 

if(token.equals("stereotypes"))//1
{ 
decision = UMLDecision.STEREOTYPES;
} 

if(token.equals("storage"))//1
{ 
decision = UMLDecision.STORAGE;
} 

return decision;
} 

//#endif 


//#if COGNITIVE 
private String str2KnowledgeType(String token)
    { 
String knowledge = null;
if(token.equals("completeness"))//1
{ 
knowledge = Critic.KT_COMPLETENESS;
} 

if(token.equals("consistency"))//1
{ 
knowledge = Critic.KT_CONSISTENCY;
} 

if(token.equals("correctness"))//1
{ 
knowledge = Critic.KT_CORRECTNESS;
} 

if(token.equals("designers"))//1
{ 
knowledge = Critic.KT_DESIGNERS;
} 

if(token.equals("experiencial"))//1
{ 
knowledge = Critic.KT_EXPERIENCIAL;
} 

if(token.equals("optimization"))//1
{ 
knowledge = Critic.KT_OPTIMIZATION;
} 

if(token.equals("organizational"))//1
{ 
knowledge = Critic.KT_ORGANIZATIONAL;
} 

if(token.equals("presentation"))//1
{ 
knowledge = Critic.KT_PRESENTATION;
} 

if(token.equals("semantics"))//1
{ 
knowledge = Critic.KT_SEMANTICS;
} 

if(token.equals("syntax"))//1
{ 
knowledge = Critic.KT_SYNTAX;
} 

if(token.equals("tool"))//1
{ 
knowledge = Critic.KT_TOOL;
} 

return knowledge;
} 

//#endif 

public File getModelFile()
    { 
return modelFile;
} 

@Override
    public Collection getProfilePackages()
    { 
return profilePackages;
} 

@Override
    public String toString()
    { 
File str = getModelFile();
return super.toString() + (str != null ? " [" + str + "]" : "");
} 

public UserDefinedProfile(URL url) throws ProfileException
    { 

//#if LOGGING 
LOG.info("load " + url);
//#endif 

ProfileReference reference = null;
reference = new UserProfileReference(url.getPath(), url);
profilePackages = new URLModelLoader().loadModel(reference);
finishLoading();
} 


//#if COGNITIVE 
private List<CrOCL> getAllCritiquesInModel()
    { 
List<CrOCL> ret = new ArrayList<CrOCL>();
Collection<Object> comments = getAllCommentsInModel(profilePackages);
for (Object comment : comments) //1
{ 
if(Model.getExtensionMechanismsHelper().hasStereotype(comment,
                    "Critic"))//1
{ 
CrOCL cr = generateCriticFromComment(comment);
if(cr != null)//1
{ 
ret.add(cr);
} 

} 

} 

return ret;
} 

//#endif 

private FigNodeDescriptor loadImage(String stereotype, File f)
    throws IOException
    { 
FigNodeDescriptor descriptor = new FigNodeDescriptor();
descriptor.length = (int) f.length();
descriptor.src = f.getPath();
descriptor.stereotype = stereotype;
BufferedInputStream bis = new BufferedInputStream(
            new FileInputStream(f));
byte[] buf = new byte[descriptor.length];
try //1
{ 
bis.read(buf);
} 
catch (IOException e) //1
{ 
e.printStackTrace();
} 


descriptor.img = new ImageIcon(buf).getImage();
return descriptor;
} 


//#if COGNITIVE 
private int str2Priority(String prioStr)
    { 
int prio = ToDoItem.MED_PRIORITY;
if(prioStr.toLowerCase().equals("high"))//1
{ 
prio = ToDoItem.HIGH_PRIORITY;
} 
else

//#if COGNITIVE 
if(prioStr.toLowerCase().equals("med"))//1
{ 
prio = ToDoItem.MED_PRIORITY;
} 
else

//#if COGNITIVE 
if(prioStr.toLowerCase().equals("low"))//1
{ 
prio = ToDoItem.LOW_PRIORITY;
} 
else

//#if COGNITIVE 
if(prioStr.toLowerCase().equals("interruptive"))//1
{ 
prio = ToDoItem.INTERRUPTIVE_PRIORITY;
} 

//#endif 


//#endif 


//#endif 


return prio;
} 

//#endif 


//#if (CLASS || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  ACTIVITY )) && ! COGNITIVE  
public UserDefinedProfile(String dn, URL url,




                              Set<String> dependencies) throws ProfileException
    { 

//#if ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  ACTIVITY ) && ! COGNITIVE  
LOG.info("load " + url);
//#endif 

this.displayName = dn;
if(url != null)//1
{ 
ProfileReference reference = null;
reference = new UserProfileReference(url.getPath(), url);
profilePackages = new URLModelLoader().loadModel(reference);
} 
else
{ 
profilePackages = new ArrayList(0);
} 

for (String profileID : dependencies) //1
{ 
addProfileDependency(profileID);
} 

finishLoading();
} 

//#endif 

public UserDefinedProfile(File file) throws ProfileException
    { 

//#if LOGGING 
LOG.info("load " + file);
//#endif 

displayName = file.getName();
modelFile = file;
ProfileReference reference = null;
try //1
{ 
reference = new UserProfileReference(file.getPath());
} 
catch (MalformedURLException e) //1
{ 
throw new ProfileException(
                "Failed to create the ProfileReference.", e);
} 


profilePackages = new FileModelLoader().loadModel(reference);
finishLoading();
} 

@Override
    public FormatingStrategy getFormatingStrategy()
    { 
return null;
} 

@Override
    public FigNodeStrategy getFigureStrategy()
    { 
return figNodeStrategy;
} 

private Collection filterPackages()
    { 
Collection ret = new ArrayList();
for (Object object : profilePackages) //1
{ 
if(Model.getFacade().isAPackage(object))//1
{ 
ret.add(object);
} 

} 

return ret;
} 

public String getDisplayName()
    { 
return displayName;
} 

private void finishLoading()
    { 
Collection packagesInProfile = filterPackages();
for (Object obj : packagesInProfile) //1
{ 
if(Model.getFacade().isAModelElement(obj)
                    && (Model.getExtensionMechanismsHelper().hasStereotype(obj,
                            "profile") || (packagesInProfile.size() == 1)))//1
{ 
String name = Model.getFacade().getName(obj);
if(name != null)//1
{ 
displayName = name;
} 
else
{ 
if(displayName == null)//1
{ 
displayName = Translator
                                      .localize("misc.profile.unnamed");
} 

} 


//#if LOGGING 
LOG.info("profile " + displayName);
//#endif 

String dependencyListStr = Model.getFacade()
                                           .getTaggedValueValue(obj, "Dependency");
StringTokenizer st = new StringTokenizer(dependencyListStr,
                        " ,;:");
String profile = null;
while (st.hasMoreTokens()) //1
{ 
profile = st.nextToken();
if(profile != null)//1
{ 

//#if LOGGING 
LOG.debug("AddingDependency " + profile);
//#endif 

this.addProfileDependency(ProfileFacade.getManager()
                                                  .lookForRegisteredProfile(profile));
} 

} 

} 

} 

Collection allStereotypes = Model.getExtensionMechanismsHelper()
                                    .getStereotypes(packagesInProfile);
for (Object stereotype : allStereotypes) //1
{ 
Collection tags = Model.getFacade().getTaggedValuesCollection(
                                  stereotype);
for (Object tag : tags) //1
{ 
String tagName = Model.getFacade().getTag(tag);
if(tagName == null)//1
{ 

//#if LOGGING 
LOG.debug("profile package with stereotype "
                              + Model.getFacade().getName(stereotype)
                              + " contains a null tag definition");
//#endif 

} 
else
if(tagName.toLowerCase().equals("figure"))//1
{ 

//#if LOGGING 
LOG.debug("AddFigNode "
                              + Model.getFacade().getName(stereotype));
//#endif 

String value = Model.getFacade().getValueOfTag(tag);
File f = new File(value);
FigNodeDescriptor fnd = null;
try //1
{ 
fnd = loadImage(Model.getFacade().getName(stereotype)
                                        .toString(), f);
figNodeStrategy.addDesrciptor(fnd);
} 
catch (IOException e) //1
{ 

//#if LOGGING 
LOG.error("Error loading FigNode", e);
//#endif 

} 


} 


} 

} 


//#if COGNITIVE 
Set<Critic> myCritics = this.getCritics();
//#endif 


//#if COGNITIVE 
myCritics.addAll(getAllCritiquesInModel());
//#endif 


//#if COGNITIVE 
this.setCritics(myCritics);
//#endif 

} 

private class FigNodeDescriptor  { 
private String stereotype;
private Image img;
private String src;
private int length;
public boolean isValid()
        { 
return stereotype != null && src != null && length > 0;
} 

 } 

private class UserDefinedFigNodeStrategy implements FigNodeStrategy
  { 
private Map<String, Image> images = new HashMap<String, Image>();
public Image getIconForStereotype(Object stereotype)
        { 
return images.get(Model.getFacade().getName(stereotype));
} 

public void addDesrciptor(FigNodeDescriptor fnd)
        { 
images.put(fnd.stereotype, fnd.img);
} 

 } 

 } 


