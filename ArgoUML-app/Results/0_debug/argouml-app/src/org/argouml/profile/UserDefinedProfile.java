
//#if -1298830446 
// Compilation Unit of /UserDefinedProfile.java 
 

//#if -242818233 
package org.argouml.profile;
//#endif 


//#if 1620965161 
import java.awt.Image;
//#endif 


//#if -1671741249 
import java.io.BufferedInputStream;
//#endif 


//#if -499906192 
import java.io.File;
//#endif 


//#if 542003548 
import java.io.FileInputStream;
//#endif 


//#if -103187679 
import java.io.IOException;
//#endif 


//#if -1926789622 
import java.net.MalformedURLException;
//#endif 


//#if 1320363158 
import java.net.URL;
//#endif 


//#if 1920519639 
import java.util.ArrayList;
//#endif 


//#if 746164842 
import java.util.Collection;
//#endif 


//#if 732265120 
import java.util.HashMap;
//#endif 


//#if -490545622 
import java.util.List;
//#endif 


//#if -847086094 
import java.util.Map;
//#endif 


//#if -846903380 
import java.util.Set;
//#endif 


//#if 1414334984 
import java.util.StringTokenizer;
//#endif 


//#if 1731509890 
import javax.swing.ImageIcon;
//#endif 


//#if -1437665977 
import org.argouml.model.Model;
//#endif 


//#if -1950343169 
import org.argouml.profile.internal.ocl.InvalidOclException;
//#endif 


//#if 1009764820 
import org.apache.log4j.Logger;
//#endif 


//#if 1855094531 
import org.argouml.cognitive.Critic;
//#endif 


//#if 304723355 
import org.argouml.cognitive.Decision;
//#endif 


//#if 88951934 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -942509027 
import org.argouml.cognitive.Translator;
//#endif 


//#if 1026498148 
import org.argouml.profile.internal.ocl.CrOCL;
//#endif 


//#if -1676176247 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 912243692 
public class UserDefinedProfile extends 
//#if 2122584049 
Profile
//#endif 

  { 

//#if 28479818 
private String displayName;
//#endif 


//#if -613559331 
private File modelFile;
//#endif 


//#if 1392488494 
private Collection profilePackages;
//#endif 


//#if 121868713 
private UserDefinedFigNodeStrategy figNodeStrategy
        = new UserDefinedFigNodeStrategy();
//#endif 


//#if -72161407 
private static final Logger LOG = Logger
                                      .getLogger(UserDefinedProfile.class);
//#endif 


//#if 591409926 
public UserDefinedProfile(String dn, URL url,


                              Set<Critic> critics,

                              Set<String> dependencies) throws ProfileException
    { 

//#if -1099825610 
LOG.info("load " + url);
//#endif 


//#if -982208421 
this.displayName = dn;
//#endif 


//#if 974124761 
if(url != null)//1
{ 

//#if -1835833257 
ProfileReference reference = null;
//#endif 


//#if -1809792452 
reference = new UserProfileReference(url.getPath(), url);
//#endif 


//#if 2118378216 
profilePackages = new URLModelLoader().loadModel(reference);
//#endif 

} 
else
{ 

//#if -1138434920 
profilePackages = new ArrayList(0);
//#endif 

} 

//#endif 


//#if -1560192084 
this.setCritics(critics);
//#endif 


//#if 722786305 
for (String profileID : dependencies) //1
{ 

//#if -13452178 
addProfileDependency(profileID);
//#endif 

} 

//#endif 


//#if 446724795 
finishLoading();
//#endif 

} 

//#endif 


//#if -1821555650 
private CrOCL generateCriticFromComment(Object critique)
    { 

//#if -720864930 
String ocl = "" + Model.getFacade().getBody(critique);
//#endif 


//#if -222382935 
String headline = null;
//#endif 


//#if -569372843 
String description = null;
//#endif 


//#if 1099425208 
int priority = ToDoItem.HIGH_PRIORITY;
//#endif 


//#if 263006138 
List<Decision> supportedDecisions = new ArrayList<Decision>();
//#endif 


//#if 1437159916 
List<String> knowledgeTypes = new ArrayList<String>();
//#endif 


//#if -364179419 
String moreInfoURL = null;
//#endif 


//#if 2080907845 
Collection tags = Model.getFacade().getTaggedValuesCollection(critique);
//#endif 


//#if 252157068 
boolean i18nFound = false;
//#endif 


//#if 1536955212 
for (Object tag : tags) //1
{ 

//#if -2034677625 
if(Model.getFacade().getTag(tag).toLowerCase().equals("i18n"))//1
{ 

//#if 2129364466 
i18nFound = true;
//#endif 


//#if -144087687 
String i18nSource = Model.getFacade().getValueOfTag(tag);
//#endif 


//#if 1064345897 
headline = Translator.localize(i18nSource + "-head");
//#endif 


//#if -70339916 
description = Translator.localize(i18nSource + "-desc");
//#endif 


//#if -1113942489 
moreInfoURL = Translator.localize(i18nSource + "-moreInfoURL");
//#endif 

} 
else

//#if 133297839 
if(!i18nFound
                       && Model.getFacade().getTag(tag).toLowerCase().equals(
                           "headline"))//1
{ 

//#if 1065435250 
headline = Model.getFacade().getValueOfTag(tag);
//#endif 

} 
else

//#if -217942993 
if(!i18nFound
                       && Model.getFacade().getTag(tag).toLowerCase().equals(
                           "description"))//1
{ 

//#if -1689645728 
description = Model.getFacade().getValueOfTag(tag);
//#endif 

} 
else

//#if 1567586596 
if(Model.getFacade().getTag(tag).toLowerCase().equals(
                           "priority"))//1
{ 

//#if -1358741926 
priority = str2Priority(Model.getFacade().getValueOfTag(tag));
//#endif 

} 
else

//#if 681134437 
if(Model.getFacade().getTag(tag).toLowerCase().equals(
                           "supporteddecision"))//1
{ 

//#if -2116087591 
String decStr = Model.getFacade().getValueOfTag(tag);
//#endif 


//#if -1998127058 
StringTokenizer st = new StringTokenizer(decStr, ",;:");
//#endif 


//#if 587802792 
while (st.hasMoreTokens()) //1
{ 

//#if -1384619666 
Decision decision = str2Decision(st.nextToken().trim()
                                                     .toLowerCase());
//#endif 


//#if 2000907700 
if(decision != null)//1
{ 

//#if 955357958 
supportedDecisions.add(decision);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if -267127068 
if(Model.getFacade().getTag(tag).toLowerCase().equals(
                           "knowledgetype"))//1
{ 

//#if 914665675 
String ktStr = Model.getFacade().getValueOfTag(tag);
//#endif 


//#if 90282548 
StringTokenizer st = new StringTokenizer(ktStr, ",;:");
//#endif 


//#if -1940453323 
while (st.hasMoreTokens()) //1
{ 

//#if -1824112245 
String knowledge = str2KnowledgeType(st.nextToken().trim()
                                                         .toLowerCase());
//#endif 


//#if -1604091324 
if(knowledge != null)//1
{ 

//#if 43039024 
knowledgeTypes.add(knowledge);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if 2135096322 
if(!i18nFound
                       && Model.getFacade().getTag(tag).toLowerCase().equals(
                           "moreinfourl"))//1
{ 

//#if 134180256 
moreInfoURL = Model.getFacade().getValueOfTag(tag);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 210108902 
LOG.debug("OCL-Critic: " + ocl);
//#endif 


//#if 174273379 
try //1
{ 

//#if 605748322 
return new CrOCL(ocl, headline, description, priority,
                             supportedDecisions, knowledgeTypes, moreInfoURL);
//#endif 

} 

//#if 487760641 
catch (InvalidOclException e) //1
{ 

//#if 1381597782 
LOG.error("Invalid OCL in XMI!", e);
//#endif 


//#if -960869456 
return null;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1940180160 

//#if 966653666 
@SuppressWarnings("unchecked")
//#endif 


    private Collection<Object> getAllCommentsInModel(Collection objs)
    { 

//#if -2137922993 
Collection<Object> col = new ArrayList<Object>();
//#endif 


//#if -829702792 
for (Object obj : objs) //1
{ 

//#if -1765060007 
if(Model.getFacade().isAComment(obj))//1
{ 

//#if -834864461 
col.add(obj);
//#endif 

} 
else

//#if -2139633648 
if(Model.getFacade().isANamespace(obj))//1
{ 

//#if 1550619945 
Collection contents = Model
                                      .getModelManagementHelper().getAllContents(obj);
//#endif 


//#if 573000588 
if(contents != null)//1
{ 

//#if 741067027 
col.addAll(contents);
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 86447422 
return col;
//#endif 

} 

//#endif 


//#if -900796955 
private Decision str2Decision(String token)
    { 

//#if -1810704270 
Decision decision = null;
//#endif 


//#if 904717911 
if(token.equals("behavior"))//1
{ 

//#if 75624308 
decision = UMLDecision.BEHAVIOR;
//#endif 

} 

//#endif 


//#if -1514964469 
if(token.equals("containment"))//1
{ 

//#if 4469066 
decision = UMLDecision.CONTAINMENT;
//#endif 

} 

//#endif 


//#if -409253607 
if(token.equals("classselection"))//1
{ 

//#if -695611183 
decision = UMLDecision.CLASS_SELECTION;
//#endif 

} 

//#endif 


//#if 1675807836 
if(token.equals("codegen"))//1
{ 

//#if -447558685 
decision = UMLDecision.CODE_GEN;
//#endif 

} 

//#endif 


//#if 560133122 
if(token.equals("expectedusage"))//1
{ 

//#if -2118220220 
decision = UMLDecision.EXPECTED_USAGE;
//#endif 

} 

//#endif 


//#if -673885021 
if(token.equals("inheritance"))//1
{ 

//#if 643975060 
decision = UMLDecision.INHERITANCE;
//#endif 

} 

//#endif 


//#if 80723046 
if(token.equals("instantiation"))//1
{ 

//#if -1906247147 
decision = UMLDecision.INSTANCIATION;
//#endif 

} 

//#endif 


//#if -705066357 
if(token.equals("methods"))//1
{ 

//#if -908950683 
decision = UMLDecision.METHODS;
//#endif 

} 

//#endif 


//#if 823182953 
if(token.equals("modularity"))//1
{ 

//#if 914393302 
decision = UMLDecision.MODULARITY;
//#endif 

} 

//#endif 


//#if 758884749 
if(token.equals("naming"))//1
{ 

//#if -1887836150 
decision = UMLDecision.NAMING;
//#endif 

} 

//#endif 


//#if 165366312 
if(token.equals("patterns"))//1
{ 

//#if -253979746 
decision = UMLDecision.PATTERNS;
//#endif 

} 

//#endif 


//#if -2140885327 
if(token.equals("plannedextensions"))//1
{ 

//#if -1730266815 
decision = UMLDecision.PLANNED_EXTENSIONS;
//#endif 

} 

//#endif 


//#if -1726720556 
if(token.equals("relationships"))//1
{ 

//#if -120568456 
decision = UMLDecision.RELATIONSHIPS;
//#endif 

} 

//#endif 


//#if 314596278 
if(token.equals("statemachines"))//1
{ 

//#if -1160114610 
decision = UMLDecision.STATE_MACHINES;
//#endif 

} 

//#endif 


//#if -2015637990 
if(token.equals("stereotypes"))//1
{ 

//#if -719029790 
decision = UMLDecision.STEREOTYPES;
//#endif 

} 

//#endif 


//#if -1171683692 
if(token.equals("storage"))//1
{ 

//#if -1221371425 
decision = UMLDecision.STORAGE;
//#endif 

} 

//#endif 


//#if 1236503788 
return decision;
//#endif 

} 

//#endif 


//#if -1632438546 
private String str2KnowledgeType(String token)
    { 

//#if -32732145 
String knowledge = null;
//#endif 


//#if 927121283 
if(token.equals("completeness"))//1
{ 

//#if -1439614405 
knowledge = Critic.KT_COMPLETENESS;
//#endif 

} 

//#endif 


//#if -535885885 
if(token.equals("consistency"))//1
{ 

//#if 1349956398 
knowledge = Critic.KT_CONSISTENCY;
//#endif 

} 

//#endif 


//#if -783092564 
if(token.equals("correctness"))//1
{ 

//#if -1379119216 
knowledge = Critic.KT_CORRECTNESS;
//#endif 

} 

//#endif 


//#if -1658029165 
if(token.equals("designers"))//1
{ 

//#if 452322041 
knowledge = Critic.KT_DESIGNERS;
//#endif 

} 

//#endif 


//#if 1045487564 
if(token.equals("experiencial"))//1
{ 

//#if 1569588515 
knowledge = Critic.KT_EXPERIENCIAL;
//#endif 

} 

//#endif 


//#if 1309138976 
if(token.equals("optimization"))//1
{ 

//#if -258926849 
knowledge = Critic.KT_OPTIMIZATION;
//#endif 

} 

//#endif 


//#if 1143072145 
if(token.equals("organizational"))//1
{ 

//#if -1999392489 
knowledge = Critic.KT_ORGANIZATIONAL;
//#endif 

} 

//#endif 


//#if 1785370637 
if(token.equals("presentation"))//1
{ 

//#if 801749576 
knowledge = Critic.KT_PRESENTATION;
//#endif 

} 

//#endif 


//#if 323094616 
if(token.equals("semantics"))//1
{ 

//#if 616382258 
knowledge = Critic.KT_SEMANTICS;
//#endif 

} 

//#endif 


//#if -1782139626 
if(token.equals("syntax"))//1
{ 

//#if 1607536824 
knowledge = Critic.KT_SYNTAX;
//#endif 

} 

//#endif 


//#if 1623592971 
if(token.equals("tool"))//1
{ 

//#if -87405619 
knowledge = Critic.KT_TOOL;
//#endif 

} 

//#endif 


//#if 1795472610 
return knowledge;
//#endif 

} 

//#endif 


//#if -747546579 
public File getModelFile()
    { 

//#if -665340702 
return modelFile;
//#endif 

} 

//#endif 


//#if 1146425212 
@Override
    public Collection getProfilePackages()
    { 

//#if 1724201149 
return profilePackages;
//#endif 

} 

//#endif 


//#if -658997925 
@Override
    public String toString()
    { 

//#if -1561766762 
File str = getModelFile();
//#endif 


//#if -1516336538 
return super.toString() + (str != null ? " [" + str + "]" : "");
//#endif 

} 

//#endif 


//#if 776876928 
public UserDefinedProfile(URL url) throws ProfileException
    { 

//#if 1158275117 
LOG.info("load " + url);
//#endif 


//#if -1880747187 
ProfileReference reference = null;
//#endif 


//#if 593572018 
reference = new UserProfileReference(url.getPath(), url);
//#endif 


//#if -2112084386 
profilePackages = new URLModelLoader().loadModel(reference);
//#endif 


//#if -1390216604 
finishLoading();
//#endif 

} 

//#endif 


//#if -1751794953 
private List<CrOCL> getAllCritiquesInModel()
    { 

//#if 1516671892 
List<CrOCL> ret = new ArrayList<CrOCL>();
//#endif 


//#if 483697464 
Collection<Object> comments = getAllCommentsInModel(profilePackages);
//#endif 


//#if 2127896752 
for (Object comment : comments) //1
{ 

//#if 633333294 
if(Model.getExtensionMechanismsHelper().hasStereotype(comment,
                    "Critic"))//1
{ 

//#if 1211189295 
CrOCL cr = generateCriticFromComment(comment);
//#endif 


//#if -1299020156 
if(cr != null)//1
{ 

//#if 861169522 
ret.add(cr);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 669998277 
return ret;
//#endif 

} 

//#endif 


//#if 1768524881 
private FigNodeDescriptor loadImage(String stereotype, File f)
    throws IOException
    { 

//#if -1080473493 
FigNodeDescriptor descriptor = new FigNodeDescriptor();
//#endif 


//#if -949258973 
descriptor.length = (int) f.length();
//#endif 


//#if -510730850 
descriptor.src = f.getPath();
//#endif 


//#if 1263438204 
descriptor.stereotype = stereotype;
//#endif 


//#if 1233337741 
BufferedInputStream bis = new BufferedInputStream(
            new FileInputStream(f));
//#endif 


//#if 1292901979 
byte[] buf = new byte[descriptor.length];
//#endif 


//#if 1114617111 
try //1
{ 

//#if 49234538 
bis.read(buf);
//#endif 

} 

//#if 221515209 
catch (IOException e) //1
{ 

//#if -1066192006 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if 880688121 
descriptor.img = new ImageIcon(buf).getImage();
//#endif 


//#if 1132972667 
return descriptor;
//#endif 

} 

//#endif 


//#if -683866608 
private int str2Priority(String prioStr)
    { 

//#if 1599684858 
int prio = ToDoItem.MED_PRIORITY;
//#endif 


//#if -138259604 
if(prioStr.toLowerCase().equals("high"))//1
{ 

//#if -825289892 
prio = ToDoItem.HIGH_PRIORITY;
//#endif 

} 
else

//#if 370365256 
if(prioStr.toLowerCase().equals("med"))//1
{ 

//#if -1462582459 
prio = ToDoItem.MED_PRIORITY;
//#endif 

} 
else

//#if -1206755312 
if(prioStr.toLowerCase().equals("low"))//1
{ 

//#if 1358326370 
prio = ToDoItem.LOW_PRIORITY;
//#endif 

} 
else

//#if -1308358317 
if(prioStr.toLowerCase().equals("interruptive"))//1
{ 

//#if -1159580660 
prio = ToDoItem.INTERRUPTIVE_PRIORITY;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if 336617950 
return prio;
//#endif 

} 

//#endif 


//#if -931584425 
public UserDefinedProfile(String dn, URL url,




                              Set<String> dependencies) throws ProfileException
    { 

//#if -1163504685 
LOG.info("load " + url);
//#endif 


//#if 1925231390 
this.displayName = dn;
//#endif 


//#if -470166756 
if(url != null)//1
{ 

//#if -2091647248 
ProfileReference reference = null;
//#endif 


//#if -598642667 
reference = new UserProfileReference(url.getPath(), url);
//#endif 


//#if -1069024191 
profilePackages = new URLModelLoader().loadModel(reference);
//#endif 

} 
else
{ 

//#if 961392674 
profilePackages = new ArrayList(0);
//#endif 

} 

//#endif 


//#if -2055146300 
for (String profileID : dependencies) //1
{ 

//#if 1367936052 
addProfileDependency(profileID);
//#endif 

} 

//#endif 


//#if -997566722 
finishLoading();
//#endif 

} 

//#endif 


//#if -1325505496 
public UserDefinedProfile(File file) throws ProfileException
    { 

//#if -1533194516 
LOG.info("load " + file);
//#endif 


//#if 858846078 
displayName = file.getName();
//#endif 


//#if -1867928150 
modelFile = file;
//#endif 


//#if 1541115779 
ProfileReference reference = null;
//#endif 


//#if -1366990253 
try //1
{ 

//#if 1985534827 
reference = new UserProfileReference(file.getPath());
//#endif 

} 

//#if 1270758926 
catch (MalformedURLException e) //1
{ 

//#if 1287765549 
throw new ProfileException(
                "Failed to create the ProfileReference.", e);
//#endif 

} 

//#endif 


//#endif 


//#if -36279249 
profilePackages = new FileModelLoader().loadModel(reference);
//#endif 


//#if 1288132846 
finishLoading();
//#endif 

} 

//#endif 


//#if 1527517002 
@Override
    public FormatingStrategy getFormatingStrategy()
    { 

//#if -1137587106 
return null;
//#endif 

} 

//#endif 


//#if 779336626 
@Override
    public FigNodeStrategy getFigureStrategy()
    { 

//#if -1408773592 
return figNodeStrategy;
//#endif 

} 

//#endif 


//#if 1400473391 
private Collection filterPackages()
    { 

//#if -64145610 
Collection ret = new ArrayList();
//#endif 


//#if 283957044 
for (Object object : profilePackages) //1
{ 

//#if -655187292 
if(Model.getFacade().isAPackage(object))//1
{ 

//#if -1496909856 
ret.add(object);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2057577667 
return ret;
//#endif 

} 

//#endif 


//#if 353446634 
public String getDisplayName()
    { 

//#if -2056280365 
return displayName;
//#endif 

} 

//#endif 


//#if 941308427 
private void finishLoading()
    { 

//#if 752205911 
Collection packagesInProfile = filterPackages();
//#endif 


//#if -2121260572 
for (Object obj : packagesInProfile) //1
{ 

//#if -1407308177 
if(Model.getFacade().isAModelElement(obj)
                    && (Model.getExtensionMechanismsHelper().hasStereotype(obj,
                            "profile") || (packagesInProfile.size() == 1)))//1
{ 

//#if 1247548418 
String name = Model.getFacade().getName(obj);
//#endif 


//#if 224183102 
if(name != null)//1
{ 

//#if -111727878 
displayName = name;
//#endif 

} 
else
{ 

//#if -285469949 
if(displayName == null)//1
{ 

//#if -414436645 
displayName = Translator
                                      .localize("misc.profile.unnamed");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -181669950 
LOG.info("profile " + displayName);
//#endif 


//#if -552283443 
String dependencyListStr = Model.getFacade()
                                           .getTaggedValueValue(obj, "Dependency");
//#endif 


//#if -654008546 
StringTokenizer st = new StringTokenizer(dependencyListStr,
                        " ,;:");
//#endif 


//#if 1278214092 
String profile = null;
//#endif 


//#if -465363905 
while (st.hasMoreTokens()) //1
{ 

//#if 1563727336 
profile = st.nextToken();
//#endif 


//#if -2106535442 
if(profile != null)//1
{ 

//#if -1224193522 
LOG.debug("AddingDependency " + profile);
//#endif 


//#if -3898718 
this.addProfileDependency(ProfileFacade.getManager()
                                                  .lookForRegisteredProfile(profile));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 2042807262 
Collection allStereotypes = Model.getExtensionMechanismsHelper()
                                    .getStereotypes(packagesInProfile);
//#endif 


//#if -2062619208 
for (Object stereotype : allStereotypes) //1
{ 

//#if 1793016488 
Collection tags = Model.getFacade().getTaggedValuesCollection(
                                  stereotype);
//#endif 


//#if -1726526231 
for (Object tag : tags) //1
{ 

//#if 275405949 
String tagName = Model.getFacade().getTag(tag);
//#endif 


//#if -1134901677 
if(tagName == null)//1
{ 

//#if 1120264944 
LOG.debug("profile package with stereotype "
                              + Model.getFacade().getName(stereotype)
                              + " contains a null tag definition");
//#endif 

} 
else

//#if -1425446515 
if(tagName.toLowerCase().equals("figure"))//1
{ 

//#if -129636267 
LOG.debug("AddFigNode "
                              + Model.getFacade().getName(stereotype));
//#endif 


//#if 1426129927 
String value = Model.getFacade().getValueOfTag(tag);
//#endif 


//#if -2014033538 
File f = new File(value);
//#endif 


//#if -346875836 
FigNodeDescriptor fnd = null;
//#endif 


//#if -948123300 
try //1
{ 

//#if -920889525 
fnd = loadImage(Model.getFacade().getName(stereotype)
                                        .toString(), f);
//#endif 


//#if 1293461345 
figNodeStrategy.addDesrciptor(fnd);
//#endif 

} 

//#if 2063791746 
catch (IOException e) //1
{ 

//#if -553588915 
LOG.error("Error loading FigNode", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 1597451873 
Set<Critic> myCritics = this.getCritics();
//#endif 


//#if -350400844 
myCritics.addAll(getAllCritiquesInModel());
//#endif 


//#if 331928752 
this.setCritics(myCritics);
//#endif 

} 

//#endif 


//#if 1053850440 
private class FigNodeDescriptor  { 

//#if -1425546097 
private String stereotype;
//#endif 


//#if -1322772054 
private Image img;
//#endif 


//#if 1805342801 
private String src;
//#endif 


//#if 1338449167 
private int length;
//#endif 


//#if 1173500526 
public boolean isValid()
        { 

//#if -61430286 
return stereotype != null && src != null && length > 0;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 894034024 
private class UserDefinedFigNodeStrategy implements 
//#if 491715013 
FigNodeStrategy
//#endif 

  { 

//#if -2093381388 
private Map<String, Image> images = new HashMap<String, Image>();
//#endif 


//#if -90315622 
public Image getIconForStereotype(Object stereotype)
        { 

//#if -611332434 
return images.get(Model.getFacade().getName(stereotype));
//#endif 

} 

//#endif 


//#if 1212937207 
public void addDesrciptor(FigNodeDescriptor fnd)
        { 

//#if -1647934366 
images.put(fnd.stereotype, fnd.img);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

