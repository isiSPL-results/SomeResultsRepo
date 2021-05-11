
//#if 1460708365 
// Compilation Unit of /ProfileConfiguration.java 
 

//#if 1507475627 
package org.argouml.kernel;
//#endif 


//#if 1669690023 
import java.awt.Image;
//#endif 


//#if 1557648104 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -485961447 
import java.util.ArrayList;
//#endif 


//#if -840304792 
import java.util.Collection;
//#endif 


//#if 595865628 
import java.util.HashSet;
//#endif 


//#if -1002316200 
import java.util.Iterator;
//#endif 


//#if -441820760 
import java.util.List;
//#endif 


//#if -568236946 
import java.util.Set;
//#endif 


//#if 210427383 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -1948394434 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 1326339468 
import org.argouml.application.events.ArgoProfileEvent;
//#endif 


//#if -260497169 
import org.argouml.configuration.Configuration;
//#endif 


//#if 535319720 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if -2134407287 
import org.argouml.model.Model;
//#endif 


//#if -494954908 
import org.argouml.profile.DefaultTypeStrategy;
//#endif 


//#if 2123774777 
import org.argouml.profile.FigNodeStrategy;
//#endif 


//#if -209987916 
import org.argouml.profile.FormatingStrategy;
//#endif 


//#if 1679901769 
import org.argouml.profile.Profile;
//#endif 


//#if -1215594082 
import org.argouml.profile.ProfileException;
//#endif 


//#if 902855759 
import org.argouml.profile.ProfileFacade;
//#endif 


//#if 313023510 
import org.apache.log4j.Logger;
//#endif 


//#if -278232212 
public class ProfileConfiguration extends 
//#if 417570313 
AbstractProjectMember
//#endif 

  { 

//#if 568948448 
private FormatingStrategy formatingStrategy;
//#endif 


//#if -1653410080 
private DefaultTypeStrategy defaultTypeStrategy;
//#endif 


//#if 1539728292 
private List figNodeStrategies = new ArrayList();
//#endif 


//#if 1200990779 
private List<Profile> profiles = new ArrayList<Profile>();
//#endif 


//#if -1151597446 
private List<Object> profileModels = new ArrayList<Object>();
//#endif 


//#if 1260473638 
public static final String EXTENSION = "profile";
//#endif 


//#if -652375399 
public static final ConfigurationKey KEY_DEFAULT_STEREOTYPE_VIEW =
        Configuration.makeKey("profiles", "stereotypeView");
//#endif 


//#if 247680912 
private FigNodeStrategy compositeFigNodeStrategy = new FigNodeStrategy()
    {

        public Image getIconForStereotype(Object element) {
            Iterator it = figNodeStrategies.iterator();

            while (it.hasNext()) {
                FigNodeStrategy strat = (FigNodeStrategy) it.next();
                Image extra = strat.getIconForStereotype(element);

                if (extra != null) {
                    return extra;
                }
            }
            return null;
        }

    };
//#endif 


//#if 5435507 
private static final Logger LOG = Logger
                                      .getLogger(ProfileConfiguration.class);
//#endif 


//#if -61940161 
public List<Profile> getProfiles()
    { 

//#if -2050225031 
return profiles;
//#endif 

} 

//#endif 


//#if 1152775486 
public static Object findTypeInModel(String s, Object model)
    { 

//#if 1443070066 
if(!Model.getFacade().isANamespace(model))//1
{ 

//#if 5054186 
throw new IllegalArgumentException(
                "Looking for the classifier " + s
                + " in a non-namespace object of " + model
                + ". A namespace was expected.");
//#endif 

} 

//#endif 


//#if 227174883 
Collection allClassifiers =
            Model.getModelManagementHelper()
            .getAllModelElementsOfKind(model,
                                       Model.getMetaTypes().getClassifier());
//#endif 


//#if 1429913259 
Object[] classifiers = allClassifiers.toArray();
//#endif 


//#if -1470633671 
Object classifier = null;
//#endif 


//#if -1622691112 
for (int i = 0; i < classifiers.length; i++) //1
{ 

//#if 669226145 
classifier = classifiers[i];
//#endif 


//#if -739102078 
if(Model.getFacade().getName(classifier) != null
                    && Model.getFacade().getName(classifier).equals(s))//1
{ 

//#if -109860300 
return classifier;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 271763618 
return null;
//#endif 

} 

//#endif 


//#if 1856963851 
@Override
    public String toString()
    { 

//#if 1048302313 
return "Profile Configuration";
//#endif 

} 

//#endif 


//#if -16725944 
public Object findType(String name)
    { 

//#if 763731182 
for (Object model : getProfileModels()) //1
{ 

//#if -1748346447 
Object result = findTypeInModel(name, model);
//#endif 


//#if 1097783410 
if(result != null)//1
{ 

//#if 1446527611 
return result;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -964108245 
return null;
//#endif 

} 

//#endif 


//#if 901122951 

//#if -273014739 
@SuppressWarnings("unchecked")
//#endif 


    public void addProfile(Profile p)
    { 

//#if -1602560717 
if(!profiles.contains(p))//1
{ 

//#if -1482830256 
profiles.add(p);
//#endif 


//#if -1800241745 
try //1
{ 

//#if 1387079960 
profileModels.addAll(p.getProfilePackages());
//#endif 

} 

//#if 416556061 
catch (ProfileException e) //1
{ 

//#if 1610572061 
LOG.warn("Error retrieving profile's " + p + " packages.", e);
//#endif 

} 

//#endif 


//#endif 


//#if -1773097539 
FigNodeStrategy fns = p.getFigureStrategy();
//#endif 


//#if -654616156 
if(fns != null)//1
{ 

//#if -1699570404 
figNodeStrategies.add(fns);
//#endif 

} 

//#endif 


//#if -307750708 
for (Profile dependency : p.getDependencies()) //1
{ 

//#if 209103643 
addProfile(dependency);
//#endif 

} 

//#endif 


//#if 2012489159 
updateStrategies();
//#endif 


//#if -1287241375 
ArgoEventPump.fireEvent(new ArgoProfileEvent(
                                        ArgoEventTypes.PROFILE_ADDED, new PropertyChangeEvent(this,
                                                "profile", null, p)));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1247824641 

//#if -1091928436 
@SuppressWarnings("unchecked")
//#endif 


    public Collection findByMetaType(Object metaType)
    { 

//#if 1867117392 
Set elements = new HashSet();
//#endif 


//#if 934645934 
Iterator it = getProfileModels().iterator();
//#endif 


//#if 351091836 
while (it.hasNext()) //1
{ 

//#if 40268993 
Object model = it.next();
//#endif 


//#if 369956744 
elements.addAll(Model.getModelManagementHelper()
                            .getAllModelElementsOfKind(model, metaType));
//#endif 

} 

//#endif 


//#if -564016830 
return elements;
//#endif 

} 

//#endif 


//#if 1969593370 
public void removeProfile(Profile p)
    { 

//#if -918774758 
profiles.remove(p);
//#endif 


//#if -906670306 
try //1
{ 

//#if 47118808 
profileModels.removeAll(p.getProfilePackages());
//#endif 

} 

//#if 1435684222 
catch (ProfileException e) //1
{ 

//#if 598859939 
LOG.error("Exception", e);
//#endif 

} 

//#endif 


//#endif 


//#if -834818578 
FigNodeStrategy fns = p.getFigureStrategy();
//#endif 


//#if 685141075 
if(fns != null)//1
{ 

//#if 215721621 
figNodeStrategies.remove(fns);
//#endif 

} 

//#endif 


//#if -145667254 
if(formatingStrategy == p.getFormatingStrategy())//1
{ 

//#if 1917919047 
formatingStrategy = null;
//#endif 

} 

//#endif 


//#if -1170409566 
List<Profile> markForRemoval = new ArrayList<Profile>();
//#endif 


//#if 864720485 
for (Profile profile : profiles) //1
{ 

//#if 1508556473 
if(profile.getDependencies().contains(p))//1
{ 

//#if -618212903 
markForRemoval.add(profile);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1828222261 
for (Profile profile : markForRemoval) //1
{ 

//#if -1527745470 
removeProfile(profile);
//#endif 

} 

//#endif 


//#if 1589076152 
updateStrategies();
//#endif 


//#if 447017130 
ArgoEventPump.fireEvent(new ArgoProfileEvent(
                                    ArgoEventTypes.PROFILE_REMOVED, new PropertyChangeEvent(this,
                                            "profile", p, null)));
//#endif 

} 

//#endif 


//#if -410293737 
private List getProfileModels()
    { 

//#if -246924708 
return profileModels;
//#endif 

} 

//#endif 


//#if -731668033 
public ProfileConfiguration(Project project)
    { 

//#if -1032868290 
super(EXTENSION, project);
//#endif 


//#if 1514642024 
for (Profile p : ProfileFacade.getManager().getDefaultProfiles()) //1
{ 

//#if -711623325 
addProfile(p);
//#endif 

} 

//#endif 


//#if -397324147 
updateStrategies();
//#endif 

} 

//#endif 


//#if 1208477712 
public String repair()
    { 

//#if -2044346438 
return "";
//#endif 

} 

//#endif 


//#if -783162623 
public Object findStereotypeForObject(String name, Object element)
    { 

//#if 852532017 
Iterator iter = null;
//#endif 


//#if -91234056 
for (Object model : profileModels) //1
{ 

//#if 104869711 
iter = Model.getFacade().getOwnedElements(model).iterator();
//#endif 


//#if 1190102221 
while (iter.hasNext()) //1
{ 

//#if -1610349637 
Object stereo = iter.next();
//#endif 


//#if 222685266 
if(!Model.getFacade().isAStereotype(stereo)
                        || !name.equals(Model.getFacade().getName(stereo)))//1
{ 

//#if 1382233064 
continue;
//#endif 

} 

//#endif 


//#if -1628552739 
if(Model.getExtensionMechanismsHelper().isValidStereotype(
                            element, stereo))//1
{ 

//#if 1564752776 
return stereo;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -120908464 
return null;
//#endif 

} 

//#endif 


//#if 1227329335 
public void activateDefaultTypeStrategy(Profile profile)
    { 

//#if -1738555019 
if(profile != null && profile.getDefaultTypeStrategy() != null
                && getProfiles().contains(profile))//1
{ 

//#if -355667992 
this.defaultTypeStrategy = profile.getDefaultTypeStrategy();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 602405031 
public void activateFormatingStrategy(Profile profile)
    { 

//#if 658438552 
if(profile != null && profile.getFormatingStrategy() != null
                && getProfiles().contains(profile))//1
{ 

//#if -563150784 
this.formatingStrategy = profile.getFormatingStrategy();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1430787958 
public FormatingStrategy getFormatingStrategy()
    { 

//#if 864498237 
return formatingStrategy;
//#endif 

} 

//#endif 


//#if 407877167 
public String getType()
    { 

//#if 720308467 
return EXTENSION;
//#endif 

} 

//#endif 


//#if -362788502 
private void updateStrategies()
    { 

//#if -46967871 
for (Profile profile : profiles) //1
{ 

//#if -633874597 
activateFormatingStrategy(profile);
//#endif 


//#if -1132875413 
activateDefaultTypeStrategy(profile);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -324920733 
public Collection findAllStereotypesForModelElement(Object modelElement)
    { 

//#if -1289592282 
return Model.getExtensionMechanismsHelper().getAllPossibleStereotypes(
                   getProfileModels(), modelElement);
//#endif 

} 

//#endif 


//#if 1288071958 
public DefaultTypeStrategy getDefaultTypeStrategy()
    { 

//#if -2140241724 
return defaultTypeStrategy;
//#endif 

} 

//#endif 


//#if -297883856 
public ProfileConfiguration(Project project,
                                Collection<Profile> configuredProfiles)
    { 

//#if 584159632 
super(EXTENSION, project);
//#endif 


//#if -234941078 
for (Profile profile : configuredProfiles) //1
{ 

//#if 619918316 
addProfile(profile);
//#endif 

} 

//#endif 


//#if 594319711 
updateStrategies();
//#endif 

} 

//#endif 


//#if -2064172052 
public FigNodeStrategy getFigNodeStrategy()
    { 

//#if -490123598 
return compositeFigNodeStrategy;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

