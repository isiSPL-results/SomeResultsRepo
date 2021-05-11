// Compilation Unit of /DisplayTextTree.java 
 
package org.argouml.ui;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTree;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.InvalidElementException;
import org.argouml.model.Model;
import org.argouml.notation.Notation;
import org.argouml.notation.NotationProvider;
import org.argouml.notation.NotationProviderFactory2;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.uml.NotationUtilityUml;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.ui.UMLTreeCellRenderer;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoList;
//#endif 

public class DisplayTextTree extends JTree
  { 
private Hashtable<TreeModel, List<TreePath>> expandedPathsInModel;
private boolean reexpanding;
private boolean showStereotype;
private static final long serialVersionUID = 949560309817566838L;

//#if LOGGING 
private static final Logger LOG = Logger.getLogger(DisplayTextTree.class);
//#endif 

protected List<TreePath> getExpandedPaths()
    { 

//#if LOGGING 
LOG.debug("getExpandedPaths");
//#endif 

TreeModel tm = getModel();
List<TreePath> res = expandedPathsInModel.get(tm);
if(res == null)//1
{ 
res = new ArrayList<TreePath>();
expandedPathsInModel.put(tm, res);
} 

return res;
} 

protected void setShowStereotype(boolean show)
    { 
this.showStereotype = show;
} 

private String formatTaggedValueLabel(Object value)
    { 
String name;
String tagName = Model.getFacade().getTag(value);
if(tagName == null || tagName.equals(""))//1
{ 
name = MessageFormat.format(
                       Translator.localize("misc.unnamed"),
                       new Object[] {
                           Model.getFacade().getUMLClassName(value)
                       });
} 

Collection referenceValues =
            Model.getFacade().getReferenceValue(value);
Collection dataValues =
            Model.getFacade().getDataValue(value);
Iterator i;
if(referenceValues.size() > 0)//1
{ 
i = referenceValues.iterator();
} 
else
{ 
i = dataValues.iterator();
} 

String theValue = "";
if(i.hasNext())//1
{ 
theValue = i.next().toString();
} 

if(i.hasNext())//2
{ 
theValue += " , ...";
} 

name = (tagName + " = " + theValue);
return name;
} 

private String formatTransitionLabel(Object value)
    { 
String name;
name = Model.getFacade().getName(value);
NotationProvider notationProvider =
            NotationProviderFactory2.getInstance()
            .getNotationProvider(
                NotationProviderFactory2.TYPE_TRANSITION,
                value);
String signature = notationProvider.toString(value,
                           NotationSettings.getDefaultSettings());
if(name != null && name.length() > 0)//1
{ 
name += ": " + signature;
} 
else
{ 
name = signature;
} 

return name;
} 

public void fireTreeCollapsed(TreePath path)
    { 
super.fireTreeCollapsed(path);

//#if LOGGING 
LOG.debug("fireTreeCollapsed");
//#endif 

if(path == null || expandedPathsInModel == null)//1
{ 
return;
} 

List<TreePath> expanded = getExpandedPaths();
expanded.remove(path);
} 

public static final String getModelElementDisplayName(Object modelElement)
    { 
String name = Model.getFacade().getName(modelElement);
if(name == null || name.equals(""))//1
{ 
name = MessageFormat.format(
                       Translator.localize("misc.unnamed"),
                       new Object[] {
                           Model.getFacade().getUMLClassName(modelElement)
                       }
                   );
} 

return name;
} 

public void setModel(TreeModel newModel)
    { 

//#if LOGGING 
LOG.debug("setModel");
//#endif 

Object r = newModel.getRoot();
if(r != null)//1
{ 
super.setModel(newModel);
} 

reexpand();
} 

private static NotationSettings getNotationSettings()
    { 
Project p = ProjectManager.getManager().getCurrentProject();
NotationSettings settings;
if(p != null)//1
{ 
settings = p.getProjectSettings().getNotationSettings();
} 
else
{ 
settings = NotationSettings.getDefaultSettings();
} 

return settings;
} 

public static String generateStereotype(Collection<Object> st)
    { 
return NotationUtilityUml.generateStereotype(st,
                getNotationSettings().isUseGuillemets());
} 

private void reexpand()
    { 

//#if LOGGING 
LOG.debug("reexpand");
//#endif 

if(expandedPathsInModel == null)//1
{ 
return;
} 

reexpanding = true;
for (TreePath path : getExpandedPaths()) //1
{ 
expandPath(path);
} 

reexpanding = false;
} 

public String convertValueToText(Object value, boolean selected,
                                     boolean expanded, boolean leaf, int row, boolean hasFocus)
    { 

//#if COGNITIVE 
if(value instanceof ToDoItem)//1
{ 
return ((ToDoItem) value).getHeadline();
} 

//#endif 


//#if COGNITIVE 
if(value instanceof ToDoList)//1
{ 
return "ToDoList";
} 

//#endif 

if(Model.getFacade().isAModelElement(value))//1
{ 
String name = null;
try //1
{ 
if(Model.getFacade().isATransition(value))//1
{ 
name = formatTransitionLabel(value);
} 
else
if(Model.getFacade().isAExtensionPoint(value))//1
{ 
name = formatExtensionPoint(value);
} 
else
if(Model.getFacade().isAComment(value))//1
{ 
name = (String) Model.getFacade().getBody(value);
} 
else
if(Model.getFacade().isATaggedValue(value))//1
{ 
name = formatTaggedValueLabel(value);
} 
else
{ 
name = getModelElementDisplayName(value);
} 




if(name != null
                        && name.indexOf("\n") < 80
                        && name.indexOf("\n") > -1)//1
{ 
name = name.substring(0, name.indexOf("\n")) + "...";
} 
else
if(name != null && name.length() > 80)//1
{ 
name = name.substring(0, 80) + "...";
} 


if(showStereotype)//1
{ 
Collection<Object> stereos =
                        Model.getFacade().getStereotypes(value);
name += " " + generateStereotype(stereos);
if(name != null && name.length() > 80)//1
{ 
name = name.substring(0, 80) + "...";
} 

} 

} 
catch (InvalidElementException e) //1
{ 
name = Translator.localize("misc.name.deleted");
} 


return name;
} 

if(Model.getFacade().isAElementImport(value))//1
{ 
try //1
{ 
Object me = Model.getFacade().getImportedElement(value);
String typeName = Model.getFacade().getUMLClassName(me);
String elemName = convertValueToText(me, selected,
                                                     expanded, leaf, row,
                                                     hasFocus);
String alias = Model.getFacade().getAlias(value);
if(alias != null && alias.length() > 0)//1
{ 
Object[] args = {typeName, elemName, alias};
return Translator.localize(
                               "misc.name.element-import.alias", args);
} 
else
{ 
Object[] args = {typeName, elemName};
return Translator.localize(
                               "misc.name.element-import", args);
} 

} 
catch (InvalidElementException e) //1
{ 
return Translator.localize("misc.name.deleted");
} 


} 

if(Model.getFacade().isAUMLElement(value))//1
{ 
try //1
{ 
return Model.getFacade().toString(value);
} 
catch (InvalidElementException e) //1
{ 
return Translator.localize("misc.name.deleted");
} 


} 

if(value instanceof ArgoDiagram)//1
{ 
return ((ArgoDiagram) value).getName();
} 

if(value != null)//1
{ 
return value.toString();
} 

return "-";
} 

public void fireTreeExpanded(TreePath path)
    { 
super.fireTreeExpanded(path);

//#if LOGGING 
LOG.debug("fireTreeExpanded");
//#endif 

if(reexpanding || path == null)//1
{ 
return;
} 

List<TreePath> expanded = getExpandedPaths();
expanded.remove(path);
expanded.add(path);
} 

public DisplayTextTree()
    { 
super();
setCellRenderer(new UMLTreeCellRenderer());
setRootVisible(false);
setShowsRootHandles(true);
setToolTipText("Tree");
setRowHeight(18);
expandedPathsInModel = new Hashtable<TreeModel, List<TreePath>>();
reexpanding = false;
} 

private String formatExtensionPoint(Object value)
    { 
NotationSettings settings = getNotationSettings();
NotationProvider notationProvider = NotationProviderFactory2
                                            .getInstance().getNotationProvider(
                                                NotationProviderFactory2.TYPE_EXTENSION_POINT, value,
                                                Notation.findNotation(settings.getNotationLanguage()));
String name = notationProvider.toString(value, settings);
return name;
} 

 } 


