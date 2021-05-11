// Compilation Unit of /StereotypeUtility.java 
 
package org.argouml.uml;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.Action;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.uml.util.PathComparator;
import org.argouml.util.MyTokenizer;
public class StereotypeUtility  { 
private static Object findStereotype(
        final Object obj, final Object namespace, final String name)
    { 
Object ns = namespace;
if(ns == null)//1
{ 
ns = Model.getFacade().getNamespace(obj);
if(ns == null)//1
{ 
return null;
} 

} 

Collection ownedElements =
            Model.getFacade().getOwnedElements(ns);
for (Object element : ownedElements) //1
{ 
if(Model.getFacade().isAStereotype(element)
                    && name.equals(Model.getFacade().getName(element)))//1
{ 
return element;
} 

} 

ns = Model.getFacade().getNamespace(ns);
if(namespace != null)//1
{ 
return findStereotype(obj, ns, name);
} 

return null;
} 

public static void dealWithStereotypes(Object umlobject, String stereotype,
                                           boolean full)
    { 
String token;
MyTokenizer mst;
Collection<String> stereotypes = new ArrayList<String>();
if(stereotype != null)//1
{ 
mst = new MyTokenizer(stereotype, " ,\\,");
while (mst.hasMoreTokens()) //1
{ 
token = mst.nextToken();
if(!",".equals(token) && !" ".equals(token))//1
{ 
stereotypes.add(token);
} 

} 

} 

if(full)//1
{ 
Collection<Object> toBeRemoved = new ArrayList<Object>();
for (Object stereo : Model.getFacade().getStereotypes(umlobject)) //1
{ 
String stereotypename = Model.getFacade().getName(stereo);
if(stereotypename != null
                        && !stereotypes.contains(stereotypename))//1
{ 
toBeRemoved.add(getStereotype(umlobject, stereotypename));
} 

} 

for (Object o : toBeRemoved) //1
{ 
Model.getCoreHelper().removeStereotype(umlobject, o);
} 

} 

for (String stereotypename : stereotypes) //1
{ 
if(!Model.getExtensionMechanismsHelper()
                    .hasStereotype(umlobject, stereotypename))//1
{ 
Object umlstereo = getStereotype(umlobject, stereotypename);
if(umlstereo != null)//1
{ 
Model.getCoreHelper().addStereotype(umlobject, umlstereo);
} 

} 

} 

} 

private static Collection<Object> getAllProfilePackages(Object model)
    { 
Collection col = Model.getModelManagementHelper()
                         .getAllModelElementsOfKind(model,
                                 Model.getMetaTypes().getPackage());
Collection<Object> ret = new ArrayList<Object>();
for (Object element : col) //1
{ 
if(Model.getFacade().isAPackage(element)
                    && Model.getExtensionMechanismsHelper().hasStereotype(
                        element, "profile"))//1
{ 
ret.add(element);
} 

} 

return ret;
} 

public static void dealWithStereotypes(Object element,
                                           StringBuilder stereotype, boolean removeCurrent)
    { 
if(stereotype == null)//1
{ 
dealWithStereotypes(element, (String) null, removeCurrent);
} 
else
{ 
dealWithStereotypes(element, stereotype.toString(), removeCurrent);
} 

} 

public static Action[] getApplyStereotypeActions(Object modelElement)
    { 
Set availableStereotypes = getAvailableStereotypes(modelElement);
if(!availableStereotypes.isEmpty())//1
{ 
Action[] menuActions = new Action[availableStereotypes.size()];
Iterator it = availableStereotypes.iterator();
for (int i = 0; it.hasNext(); ++i) //1
{ 
menuActions[i] = new ActionAddStereotype(modelElement,
                        it.next());
} 

return menuActions;
} 

return new Action[0];
} 

private static void getApplicableStereotypesInNamespace(
        Object modelElement, Set<List> paths,
        Set<Object> availableStereotypes, Object namespace)
    { 
Collection allProfiles = getAllProfilePackages(Model.getFacade()
                                 .getModel(modelElement));
Collection<Object> allAppliedProfiles = new ArrayList<Object>();
for (Object profilePackage : allProfiles) //1
{ 
Collection allDependencies = Model.getCoreHelper().getDependencies(
                                             profilePackage, namespace);
for (Object dependency : allDependencies) //1
{ 
if(Model.getExtensionMechanismsHelper().hasStereotype(
                            dependency, "appliedProfile"))//1
{ 
allAppliedProfiles.add(profilePackage);
break;

} 

} 

} 

addAllUniqueModelElementsFrom(availableStereotypes, paths,
                                      getApplicableStereotypes(modelElement, allAppliedProfiles));
} 

private static Collection<Object> getTopLevelStereotypes(
        Collection<Object> topLevelModels)
    { 
Collection<Object> ret = new ArrayList<Object>();
for (Object model : topLevelModels) //1
{ 
for (Object stereotype : Model.getExtensionMechanismsHelper()
                    .getStereotypes(model)) //1
{ 
Object namespace = Model.getFacade().getNamespace(stereotype);
if(Model.getFacade().getNamespace(namespace) == null)//1
{ 
ret.add(stereotype);
} 

} 

} 

return ret;
} 

private StereotypeUtility()
    { 
super();
} 

private static Object getStereotype(Object obj, String name)
    { 
Object root = Model.getFacade().getModel(obj);
Object stereo;
stereo = findStereotypeContained(obj, root, name);
if(stereo != null)//1
{ 
return stereo;
} 

Project project = ProjectManager.getManager().getCurrentProject();
stereo = project.getProfileConfiguration().findStereotypeForObject(
                     name, obj);
if(stereo != null)//2
{ 
return stereo;
} 

if(root != null && name.length() > 0)//1
{ 
stereo =
                Model.getExtensionMechanismsFactory().buildStereotype(
                    obj, name, root);
} 

return stereo;
} 

private static void addAllUniqueModelElementsFrom(Set<Object> elements,
            Set<List> paths, Collection<Object> source)
    { 
for (Object obj : source) //1
{ 
List path = Model.getModelManagementHelper().getPathList(obj);
if(!paths.contains(path))//1
{ 
paths.add(path);
elements.add(obj);
} 

} 

} 

private static Object findStereotypeContained(
        Object obj, Object root, String name)
    { 
Object stereo;
if(root == null)//1
{ 
return null;
} 

if(Model.getFacade().isAStereotype(root)
                && name.equals(Model.getFacade().getName(root)))//1
{ 
if(Model.getExtensionMechanismsHelper().isValidStereotype(obj,
                    root))//1
{ 
return root;
} 

} 

if(!Model.getFacade().isANamespace(root))//1
{ 
return null;
} 

Collection ownedElements = Model.getFacade().getOwnedElements(root);
for (Object ownedElement : ownedElements) //1
{ 
stereo = findStereotypeContained(obj, ownedElement, name);
if(stereo != null)//1
{ 
return stereo;
} 

} 

return null;
} 

private static Collection<Object> getApplicableStereotypes(
        Object modelElement, Collection<Object> allAppliedProfiles)
    { 
Collection<Object> ret = new ArrayList<Object>();
for (Object profile : allAppliedProfiles) //1
{ 
for (Object stereotype : Model.getExtensionMechanismsHelper()
                    .getStereotypes(profile)) //1
{ 
if(Model.getExtensionMechanismsHelper().isValidStereotype(
                            modelElement, stereotype))//1
{ 
ret.add(stereotype);
} 

} 

} 

return ret;
} 

public static Set<Object> getAvailableStereotypes(Object modelElement)
    { 
Set<List> paths = new HashSet<List>();
Set<Object> availableStereotypes =
            new TreeSet<Object>(new PathComparator());
Collection models =
            ProjectManager.getManager().getCurrentProject().getModels();
Collection topLevelModels =
            ProjectManager.getManager().getCurrentProject().getModels();
Collection topLevelStereotypes = getTopLevelStereotypes(topLevelModels);
Collection validTopLevelStereotypes = new ArrayList();
addAllUniqueModelElementsFrom(availableStereotypes, paths, Model
                                      .getExtensionMechanismsHelper().getAllPossibleStereotypes(
                                          models, modelElement));
for (Object stereotype : topLevelStereotypes) //1
{ 
if(Model.getExtensionMechanismsHelper().isValidStereotype(
                        modelElement, stereotype))//1
{ 
validTopLevelStereotypes.add(stereotype);
} 

} 

addAllUniqueModelElementsFrom(availableStereotypes, paths,
                                      validTopLevelStereotypes);
Object namespace = Model.getFacade().getNamespace(modelElement);
if(namespace != null)//1
{ 
while (true) //1
{ 
getApplicableStereotypesInNamespace(modelElement, paths,
                                                    availableStereotypes, namespace);
Object newNamespace = Model.getFacade().getNamespace(namespace);
if(newNamespace == null)//1
{ 
break;

} 

namespace = newNamespace;
} 

} 

addAllUniqueModelElementsFrom(availableStereotypes, paths,
                                      ProjectManager.getManager().getCurrentProject()
                                      .getProfileConfiguration()
                                      .findAllStereotypesForModelElement(modelElement));
return availableStereotypes;
} 

 } 


