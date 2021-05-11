package org.argouml.kernel;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoProfileEvent;
import org.argouml.configuration.Configuration;
import org.argouml.configuration.ConfigurationKey;
import org.argouml.model.Model;
import org.argouml.profile.DefaultTypeStrategy;
import org.argouml.profile.FigNodeStrategy;
import org.argouml.profile.FormatingStrategy;
import org.argouml.profile.Profile;
import org.argouml.profile.ProfileException;
import org.argouml.profile.ProfileFacade;
import org.apache.log4j.Logger;
public class ProfileConfiguration extends AbstractProjectMember
  { 
private FormatingStrategy formatingStrategy;
private DefaultTypeStrategy defaultTypeStrategy;
private List figNodeStrategies = new ArrayList();
private List<Profile> profiles = new ArrayList<Profile>();
private List<Object> profileModels = new ArrayList<Object>();
public static final String EXTENSION = "profile";
public static final ConfigurationKey KEY_DEFAULT_STEREOTYPE_VIEW =
        Configuration.makeKey("profiles", "stereotypeView");
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
private static final Logger LOG = Logger
                                      .getLogger(ProfileConfiguration.class);
public List<Profile> getProfiles()
    { 
return profiles;
} 
public static Object findTypeInModel(String s, Object model)
    { 
if(!Model.getFacade().isANamespace(model))//1
{ 
throw new IllegalArgumentException(
                "Looking for the classifier " + s
                + " in a non-namespace object of " + model
                + ". A namespace was expected.");
} 
Collection allClassifiers =
            Model.getModelManagementHelper()
            .getAllModelElementsOfKind(model,
                                       Model.getMetaTypes().getClassifier());
Object[] classifiers = allClassifiers.toArray();
Object classifier = null;
for (int i = 0; i < classifiers.length; i++) //1
{ 
classifier = classifiers[i];
if(Model.getFacade().getName(classifier) != null
                    && Model.getFacade().getName(classifier).equals(s))//1
{ 
return classifier;
} 
} 
return null;
} 
@Override
    public String toString()
    { 
return "Profile Configuration";
} 
public Object findType(String name)
    { 
for (Object model : getProfileModels()) //1
{ 
Object result = findTypeInModel(name, model);
if(result != null)//1
{ 
return result;
} 
} 
return null;
} 
@SuppressWarnings("unchecked")

    public void addProfile(Profile p)
    { 
if(!profiles.contains(p))//1
{ 
profiles.add(p);
try//1
{ 
profileModels.addAll(p.getProfilePackages());
} 
catch (ProfileException e) //1
{ 
LOG.warn("Error retrieving profile's " + p + " packages.", e);
} 
FigNodeStrategy fns = p.getFigureStrategy();
if(fns != null)//1
{ 
figNodeStrategies.add(fns);
} 
for (Profile dependency : p.getDependencies()) //1
{ 
addProfile(dependency);
} 
updateStrategies();
ArgoEventPump.fireEvent(new ArgoProfileEvent(
                                        ArgoEventTypes.PROFILE_ADDED, new PropertyChangeEvent(this,
                                                "profile", null, p)));
} 
} 
@SuppressWarnings("unchecked")

    public Collection findByMetaType(Object metaType)
    { 
Set elements = new HashSet();
Iterator it = getProfileModels().iterator();
while (it.hasNext()) //1
{ 
Object model = it.next();
elements.addAll(Model.getModelManagementHelper()
                            .getAllModelElementsOfKind(model, metaType));
} 
return elements;
} 
public void removeProfile(Profile p)
    { 
profiles.remove(p);
try//1
{ 
profileModels.removeAll(p.getProfilePackages());
} 
catch (ProfileException e) //1
{ 
LOG.error("Exception", e);
} 
FigNodeStrategy fns = p.getFigureStrategy();
if(fns != null)//1
{ 
figNodeStrategies.remove(fns);
} 
if(formatingStrategy == p.getFormatingStrategy())//1
{ 
formatingStrategy = null;
} 
List<Profile> markForRemoval = new ArrayList<Profile>();
for (Profile profile : profiles) //1
{ 
if(profile.getDependencies().contains(p))//1
{ 
markForRemoval.add(profile);
} 
} 
for (Profile profile : markForRemoval) //1
{ 
removeProfile(profile);
} 
updateStrategies();
ArgoEventPump.fireEvent(new ArgoProfileEvent(
                                    ArgoEventTypes.PROFILE_REMOVED, new PropertyChangeEvent(this,
                                            "profile", p, null)));
} 
private List getProfileModels()
    { 
return profileModels;
} 
public ProfileConfiguration(Project project)
    { 
super(EXTENSION, project);
for (Profile p : ProfileFacade.getManager().getDefaultProfiles()) //1
{ 
addProfile(p);
} 
updateStrategies();
} 
public String repair()
    { 
return "";
} 
public Object findStereotypeForObject(String name, Object element)
    { 
Iterator iter = null;
for (Object model : profileModels) //1
{ 
iter = Model.getFacade().getOwnedElements(model).iterator();
while (iter.hasNext()) //1
{ 
Object stereo = iter.next();
if(!Model.getFacade().isAStereotype(stereo)
                        || !name.equals(Model.getFacade().getName(stereo)))//1
{ 
continue;
} 
if(Model.getExtensionMechanismsHelper().isValidStereotype(
                            element, stereo))//1
{ 
return stereo;
} 
} 
} 
return null;
} 
public void activateDefaultTypeStrategy(Profile profile)
    { 
if(profile != null && profile.getDefaultTypeStrategy() != null
                && getProfiles().contains(profile))//1
{ 
this.defaultTypeStrategy = profile.getDefaultTypeStrategy();
} 
} 
public void activateFormatingStrategy(Profile profile)
    { 
if(profile != null && profile.getFormatingStrategy() != null
                && getProfiles().contains(profile))//1
{ 
this.formatingStrategy = profile.getFormatingStrategy();
} 
} 
public FormatingStrategy getFormatingStrategy()
    { 
return formatingStrategy;
} 
public String getType()
    { 
return EXTENSION;
} 
private void updateStrategies()
    { 
for (Profile profile : profiles) //1
{ 
activateFormatingStrategy(profile);
activateDefaultTypeStrategy(profile);
} 
} 
public Collection findAllStereotypesForModelElement(Object modelElement)
    { 
return Model.getExtensionMechanismsHelper().getAllPossibleStereotypes(
                   getProfileModels(), modelElement);
} 
public DefaultTypeStrategy getDefaultTypeStrategy()
    { 
return defaultTypeStrategy;
} 
public ProfileConfiguration(Project project,
                                Collection<Profile> configuredProfiles)
    { 
super(EXTENSION, project);
for (Profile profile : configuredProfiles) //1
{ 
addProfile(profile);
} 
updateStrategies();
} 
public FigNodeStrategy getFigNodeStrategy()
    { 
return compositeFigNodeStrategy;
} 

 } 
