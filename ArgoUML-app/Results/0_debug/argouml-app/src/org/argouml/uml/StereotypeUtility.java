
//#if 1435994971 
// Compilation Unit of /StereotypeUtility.java 
 

//#if -1717927450 
package org.argouml.uml;
//#endif 


//#if 1848191917 
import java.util.ArrayList;
//#endif 


//#if -1495994540 
import java.util.Collection;
//#endif 


//#if -295559248 
import java.util.HashSet;
//#endif 


//#if 1428283716 
import java.util.Iterator;
//#endif 


//#if -1468484972 
import java.util.List;
//#endif 


//#if -185713150 
import java.util.Set;
//#endif 


//#if 942410304 
import java.util.TreeSet;
//#endif 


//#if -361867820 
import javax.swing.Action;
//#endif 


//#if 1793912269 
import org.argouml.kernel.Project;
//#endif 


//#if 1941787772 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 2018539549 
import org.argouml.model.Model;
//#endif 


//#if -2010882572 
import org.argouml.uml.util.PathComparator;
//#endif 


//#if -1014748746 
import org.argouml.util.MyTokenizer;
//#endif 


//#if -323193297 
public class StereotypeUtility  { 

//#if 427456972 
private static Object findStereotype(
        final Object obj, final Object namespace, final String name)
    { 

//#if 1059598536 
Object ns = namespace;
//#endif 


//#if 1152175822 
if(ns == null)//1
{ 

//#if -1813024803 
ns = Model.getFacade().getNamespace(obj);
//#endif 


//#if -486394756 
if(ns == null)//1
{ 

//#if -1797257259 
return null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -602508505 
Collection ownedElements =
            Model.getFacade().getOwnedElements(ns);
//#endif 


//#if -2099156265 
for (Object element : ownedElements) //1
{ 

//#if 1904356529 
if(Model.getFacade().isAStereotype(element)
                    && name.equals(Model.getFacade().getName(element)))//1
{ 

//#if -1341858655 
return element;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1040531151 
ns = Model.getFacade().getNamespace(ns);
//#endif 


//#if -602066420 
if(namespace != null)//1
{ 

//#if -715470551 
return findStereotype(obj, ns, name);
//#endif 

} 

//#endif 


//#if -1909860909 
return null;
//#endif 

} 

//#endif 


//#if -58234061 
public static void dealWithStereotypes(Object umlobject, String stereotype,
                                           boolean full)
    { 

//#if -33907569 
String token;
//#endif 


//#if -509861284 
MyTokenizer mst;
//#endif 


//#if 53765099 
Collection<String> stereotypes = new ArrayList<String>();
//#endif 


//#if -859155860 
if(stereotype != null)//1
{ 

//#if 635848636 
mst = new MyTokenizer(stereotype, " ,\\,");
//#endif 


//#if -239061059 
while (mst.hasMoreTokens()) //1
{ 

//#if 881339143 
token = mst.nextToken();
//#endif 


//#if -1039813962 
if(!",".equals(token) && !" ".equals(token))//1
{ 

//#if -1306729629 
stereotypes.add(token);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1934654726 
if(full)//1
{ 

//#if 211348667 
Collection<Object> toBeRemoved = new ArrayList<Object>();
//#endif 


//#if 1565585694 
for (Object stereo : Model.getFacade().getStereotypes(umlobject)) //1
{ 

//#if -20019532 
String stereotypename = Model.getFacade().getName(stereo);
//#endif 


//#if -746116100 
if(stereotypename != null
                        && !stereotypes.contains(stereotypename))//1
{ 

//#if 793810302 
toBeRemoved.add(getStereotype(umlobject, stereotypename));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1239108584 
for (Object o : toBeRemoved) //1
{ 

//#if -438930147 
Model.getCoreHelper().removeStereotype(umlobject, o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 963194616 
for (String stereotypename : stereotypes) //1
{ 

//#if -287936624 
if(!Model.getExtensionMechanismsHelper()
                    .hasStereotype(umlobject, stereotypename))//1
{ 

//#if -1916126268 
Object umlstereo = getStereotype(umlobject, stereotypename);
//#endif 


//#if 980321304 
if(umlstereo != null)//1
{ 

//#if 699282242 
Model.getCoreHelper().addStereotype(umlobject, umlstereo);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -609644126 
private static Collection<Object> getAllProfilePackages(Object model)
    { 

//#if -1663429264 
Collection col = Model.getModelManagementHelper()
                         .getAllModelElementsOfKind(model,
                                 Model.getMetaTypes().getPackage());
//#endif 


//#if -2121543284 
Collection<Object> ret = new ArrayList<Object>();
//#endif 


//#if 931305365 
for (Object element : col) //1
{ 

//#if -869140480 
if(Model.getFacade().isAPackage(element)
                    && Model.getExtensionMechanismsHelper().hasStereotype(
                        element, "profile"))//1
{ 

//#if -838128 
ret.add(element);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 7912609 
return ret;
//#endif 

} 

//#endif 


//#if -1767441363 
public static void dealWithStereotypes(Object element,
                                           StringBuilder stereotype, boolean removeCurrent)
    { 

//#if 758531597 
if(stereotype == null)//1
{ 

//#if 1105589212 
dealWithStereotypes(element, (String) null, removeCurrent);
//#endif 

} 
else
{ 

//#if 680980137 
dealWithStereotypes(element, stereotype.toString(), removeCurrent);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1627457177 
public static Action[] getApplyStereotypeActions(Object modelElement)
    { 

//#if 882026665 
Set availableStereotypes = getAvailableStereotypes(modelElement);
//#endif 


//#if 2080924307 
if(!availableStereotypes.isEmpty())//1
{ 

//#if 1422213744 
Action[] menuActions = new Action[availableStereotypes.size()];
//#endif 


//#if -1469816240 
Iterator it = availableStereotypes.iterator();
//#endif 


//#if -1488817306 
for (int i = 0; it.hasNext(); ++i) //1
{ 

//#if 521847632 
menuActions[i] = new ActionAddStereotype(modelElement,
                        it.next());
//#endif 

} 

//#endif 


//#if -609497897 
return menuActions;
//#endif 

} 

//#endif 


//#if 766096626 
return new Action[0];
//#endif 

} 

//#endif 


//#if -1914656163 
private static void getApplicableStereotypesInNamespace(
        Object modelElement, Set<List> paths,
        Set<Object> availableStereotypes, Object namespace)
    { 

//#if -1041221546 
Collection allProfiles = getAllProfilePackages(Model.getFacade()
                                 .getModel(modelElement));
//#endif 


//#if -1142816450 
Collection<Object> allAppliedProfiles = new ArrayList<Object>();
//#endif 


//#if 749903208 
for (Object profilePackage : allProfiles) //1
{ 

//#if 159703656 
Collection allDependencies = Model.getCoreHelper().getDependencies(
                                             profilePackage, namespace);
//#endif 


//#if 31485250 
for (Object dependency : allDependencies) //1
{ 

//#if 767460551 
if(Model.getExtensionMechanismsHelper().hasStereotype(
                            dependency, "appliedProfile"))//1
{ 

//#if 631547671 
allAppliedProfiles.add(profilePackage);
//#endif 


//#if 344462371 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -583533367 
addAllUniqueModelElementsFrom(availableStereotypes, paths,
                                      getApplicableStereotypes(modelElement, allAppliedProfiles));
//#endif 

} 

//#endif 


//#if -974510839 
private static Collection<Object> getTopLevelStereotypes(
        Collection<Object> topLevelModels)
    { 

//#if 233692338 
Collection<Object> ret = new ArrayList<Object>();
//#endif 


//#if -752434847 
for (Object model : topLevelModels) //1
{ 

//#if -1747046182 
for (Object stereotype : Model.getExtensionMechanismsHelper()
                    .getStereotypes(model)) //1
{ 

//#if 1975248860 
Object namespace = Model.getFacade().getNamespace(stereotype);
//#endif 


//#if -1679911781 
if(Model.getFacade().getNamespace(namespace) == null)//1
{ 

//#if -955458567 
ret.add(stereotype);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 2132400955 
return ret;
//#endif 

} 

//#endif 


//#if 2035289060 
private StereotypeUtility()
    { 

//#if -424662335 
super();
//#endif 

} 

//#endif 


//#if -1283913035 
private static Object getStereotype(Object obj, String name)
    { 

//#if 1415379860 
Object root = Model.getFacade().getModel(obj);
//#endif 


//#if -1128457978 
Object stereo;
//#endif 


//#if 968202475 
stereo = findStereotypeContained(obj, root, name);
//#endif 


//#if -1154392336 
if(stereo != null)//1
{ 

//#if -1716684762 
return stereo;
//#endif 

} 

//#endif 


//#if -949452417 
Project project = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -639158823 
stereo = project.getProfileConfiguration().findStereotypeForObject(
                     name, obj);
//#endif 


//#if -698866239 
if(stereo != null)//2
{ 

//#if 358828723 
return stereo;
//#endif 

} 

//#endif 


//#if -67628142 
if(root != null && name.length() > 0)//1
{ 

//#if 2021443751 
stereo =
                Model.getExtensionMechanismsFactory().buildStereotype(
                    obj, name, root);
//#endif 

} 

//#endif 


//#if -973246955 
return stereo;
//#endif 

} 

//#endif 


//#if 1672479393 
private static void addAllUniqueModelElementsFrom(Set<Object> elements,
            Set<List> paths, Collection<Object> source)
    { 

//#if -1058137811 
for (Object obj : source) //1
{ 

//#if 1614026200 
List path = Model.getModelManagementHelper().getPathList(obj);
//#endif 


//#if 185746033 
if(!paths.contains(path))//1
{ 

//#if 1450752037 
paths.add(path);
//#endif 


//#if 1993795538 
elements.add(obj);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1571476986 
private static Object findStereotypeContained(
        Object obj, Object root, String name)
    { 

//#if 2128469 
Object stereo;
//#endif 


//#if 1406768077 
if(root == null)//1
{ 

//#if -1579783477 
return null;
//#endif 

} 

//#endif 


//#if 1794772163 
if(Model.getFacade().isAStereotype(root)
                && name.equals(Model.getFacade().getName(root)))//1
{ 

//#if -1050164460 
if(Model.getExtensionMechanismsHelper().isValidStereotype(obj,
                    root))//1
{ 

//#if 1566294917 
return root;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -787635566 
if(!Model.getFacade().isANamespace(root))//1
{ 

//#if -2115665794 
return null;
//#endif 

} 

//#endif 


//#if -1831216218 
Collection ownedElements = Model.getFacade().getOwnedElements(root);
//#endif 


//#if 549110862 
for (Object ownedElement : ownedElements) //1
{ 

//#if 2137843116 
stereo = findStereotypeContained(obj, ownedElement, name);
//#endif 


//#if -563959654 
if(stereo != null)//1
{ 

//#if 1468782651 
return stereo;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1756370955 
return null;
//#endif 

} 

//#endif 


//#if -198472898 
private static Collection<Object> getApplicableStereotypes(
        Object modelElement, Collection<Object> allAppliedProfiles)
    { 

//#if 298963738 
Collection<Object> ret = new ArrayList<Object>();
//#endif 


//#if 279186022 
for (Object profile : allAppliedProfiles) //1
{ 

//#if -861298686 
for (Object stereotype : Model.getExtensionMechanismsHelper()
                    .getStereotypes(profile)) //1
{ 

//#if 1770051237 
if(Model.getExtensionMechanismsHelper().isValidStereotype(
                            modelElement, stereotype))//1
{ 

//#if 877917748 
ret.add(stereotype);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1501028909 
return ret;
//#endif 

} 

//#endif 


//#if -523014213 
public static Set<Object> getAvailableStereotypes(Object modelElement)
    { 

//#if -1944894929 
Set<List> paths = new HashSet<List>();
//#endif 


//#if -1203802001 
Set<Object> availableStereotypes =
            new TreeSet<Object>(new PathComparator());
//#endif 


//#if 1848640768 
Collection models =
            ProjectManager.getManager().getCurrentProject().getModels();
//#endif 


//#if -1165898927 
Collection topLevelModels =
            ProjectManager.getManager().getCurrentProject().getModels();
//#endif 


//#if 55793324 
Collection topLevelStereotypes = getTopLevelStereotypes(topLevelModels);
//#endif 


//#if 1936791868 
Collection validTopLevelStereotypes = new ArrayList();
//#endif 


//#if -2064404705 
addAllUniqueModelElementsFrom(availableStereotypes, paths, Model
                                      .getExtensionMechanismsHelper().getAllPossibleStereotypes(
                                          models, modelElement));
//#endif 


//#if 1712635826 
for (Object stereotype : topLevelStereotypes) //1
{ 

//#if -712943393 
if(Model.getExtensionMechanismsHelper().isValidStereotype(
                        modelElement, stereotype))//1
{ 

//#if 1129853985 
validTopLevelStereotypes.add(stereotype);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -678740279 
addAllUniqueModelElementsFrom(availableStereotypes, paths,
                                      validTopLevelStereotypes);
//#endif 


//#if -1514585949 
Object namespace = Model.getFacade().getNamespace(modelElement);
//#endif 


//#if 1970232797 
if(namespace != null)//1
{ 

//#if 22091774 
while (true) //1
{ 

//#if -814701633 
getApplicableStereotypesInNamespace(modelElement, paths,
                                                    availableStereotypes, namespace);
//#endif 


//#if -1854667780 
Object newNamespace = Model.getFacade().getNamespace(namespace);
//#endif 


//#if 1165811810 
if(newNamespace == null)//1
{ 

//#if -1287372198 
break;

//#endif 

} 

//#endif 


//#if 1311995691 
namespace = newNamespace;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2003046853 
addAllUniqueModelElementsFrom(availableStereotypes, paths,
                                      ProjectManager.getManager().getCurrentProject()
                                      .getProfileConfiguration()
                                      .findAllStereotypesForModelElement(modelElement));
//#endif 


//#if 81627473 
return availableStereotypes;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

