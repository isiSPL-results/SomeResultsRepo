
//#if 1496528841 
// Compilation Unit of /DisplayTextTree.java 
 

//#if -1080441186 
package org.argouml.ui;
//#endif 


//#if 1790966673 
import java.text.MessageFormat;
//#endif 


//#if -1366246653 
import java.util.ArrayList;
//#endif 


//#if 1935624894 
import java.util.Collection;
//#endif 


//#if 1456514874 
import java.util.Hashtable;
//#endif 


//#if -2139091154 
import java.util.Iterator;
//#endif 


//#if -719428226 
import java.util.List;
//#endif 


//#if -852835334 
import javax.swing.JTree;
//#endif 


//#if 1160662521 
import javax.swing.tree.TreeModel;
//#endif 


//#if 1563830287 
import javax.swing.tree.TreePath;
//#endif 


//#if 199295789 
import org.argouml.i18n.Translator;
//#endif 


//#if -430206537 
import org.argouml.kernel.Project;
//#endif 


//#if 871650642 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 230070450 
import org.argouml.model.InvalidElementException;
//#endif 


//#if 286551155 
import org.argouml.model.Model;
//#endif 


//#if -1779222487 
import org.argouml.notation.Notation;
//#endif 


//#if -717602248 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 190853552 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if 1353863750 
import org.argouml.notation.NotationSettings;
//#endif 


//#if 1116626523 
import org.argouml.notation.providers.uml.NotationUtilityUml;
//#endif 


//#if -947357262 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 1510521864 
import org.argouml.uml.ui.UMLTreeCellRenderer;
//#endif 


//#if -1560985344 
import org.apache.log4j.Logger;
//#endif 


//#if -310924334 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -308467801 
import org.argouml.cognitive.ToDoList;
//#endif 


//#if 1428643384 
public class DisplayTextTree extends 
//#if -1971707163 
JTree
//#endif 

  { 

//#if -984815512 
private Hashtable<TreeModel, List<TreePath>> expandedPathsInModel;
//#endif 


//#if 2072476334 
private boolean reexpanding;
//#endif 


//#if 1847816452 
private boolean showStereotype;
//#endif 


//#if 64180343 
private static final long serialVersionUID = 949560309817566838L;
//#endif 


//#if -1473756294 
private static final Logger LOG = Logger.getLogger(DisplayTextTree.class);
//#endif 


//#if 350313256 
protected List<TreePath> getExpandedPaths()
    { 

//#if -657471270 
LOG.debug("getExpandedPaths");
//#endif 


//#if 1163026022 
TreeModel tm = getModel();
//#endif 


//#if 1117600890 
List<TreePath> res = expandedPathsInModel.get(tm);
//#endif 


//#if -589389812 
if(res == null)//1
{ 

//#if 1761566047 
res = new ArrayList<TreePath>();
//#endif 


//#if 1543869583 
expandedPathsInModel.put(tm, res);
//#endif 

} 

//#endif 


//#if 1217123283 
return res;
//#endif 

} 

//#endif 


//#if 609268538 
protected void setShowStereotype(boolean show)
    { 

//#if 927207066 
this.showStereotype = show;
//#endif 

} 

//#endif 


//#if 627923528 
private String formatTaggedValueLabel(Object value)
    { 

//#if -57355994 
String name;
//#endif 


//#if 737430627 
String tagName = Model.getFacade().getTag(value);
//#endif 


//#if -1835333525 
if(tagName == null || tagName.equals(""))//1
{ 

//#if 343355965 
name = MessageFormat.format(
                       Translator.localize("misc.unnamed"),
                       new Object[] {
                           Model.getFacade().getUMLClassName(value)
                       });
//#endif 

} 

//#endif 


//#if 195916974 
Collection referenceValues =
            Model.getFacade().getReferenceValue(value);
//#endif 


//#if -1904190680 
Collection dataValues =
            Model.getFacade().getDataValue(value);
//#endif 


//#if 96152953 
Iterator i;
//#endif 


//#if -807034417 
if(referenceValues.size() > 0)//1
{ 

//#if -1601475117 
i = referenceValues.iterator();
//#endif 

} 
else
{ 

//#if -1162513198 
i = dataValues.iterator();
//#endif 

} 

//#endif 


//#if 771202888 
String theValue = "";
//#endif 


//#if -220432225 
if(i.hasNext())//1
{ 

//#if 2144443853 
theValue = i.next().toString();
//#endif 

} 

//#endif 


//#if 108657074 
if(i.hasNext())//2
{ 

//#if 724450130 
theValue += " , ...";
//#endif 

} 

//#endif 


//#if 599884971 
name = (tagName + " = " + theValue);
//#endif 


//#if -1701140601 
return name;
//#endif 

} 

//#endif 


//#if -557961592 
private String formatTransitionLabel(Object value)
    { 

//#if 239554986 
String name;
//#endif 


//#if -1775023459 
name = Model.getFacade().getName(value);
//#endif 


//#if 51816528 
NotationProvider notationProvider =
            NotationProviderFactory2.getInstance()
            .getNotationProvider(
                NotationProviderFactory2.TYPE_TRANSITION,
                value);
//#endif 


//#if -935615837 
String signature = notationProvider.toString(value,
                           NotationSettings.getDefaultSettings());
//#endif 


//#if -410563456 
if(name != null && name.length() > 0)//1
{ 

//#if -1291146895 
name += ": " + signature;
//#endif 

} 
else
{ 

//#if 1056772711 
name = signature;
//#endif 

} 

//#endif 


//#if -1404229621 
return name;
//#endif 

} 

//#endif 


//#if 583739676 
public void fireTreeCollapsed(TreePath path)
    { 

//#if 123109465 
super.fireTreeCollapsed(path);
//#endif 


//#if 1518898570 
LOG.debug("fireTreeCollapsed");
//#endif 


//#if 649954955 
if(path == null || expandedPathsInModel == null)//1
{ 

//#if 1186708733 
return;
//#endif 

} 

//#endif 


//#if 1134686622 
List<TreePath> expanded = getExpandedPaths();
//#endif 


//#if -222064400 
expanded.remove(path);
//#endif 

} 

//#endif 


//#if -473956864 
public static final String getModelElementDisplayName(Object modelElement)
    { 

//#if -748369198 
String name = Model.getFacade().getName(modelElement);
//#endif 


//#if -1119997461 
if(name == null || name.equals(""))//1
{ 

//#if -1135170755 
name = MessageFormat.format(
                       Translator.localize("misc.unnamed"),
                       new Object[] {
                           Model.getFacade().getUMLClassName(modelElement)
                       }
                   );
//#endif 

} 

//#endif 


//#if 1118847267 
return name;
//#endif 

} 

//#endif 


//#if -1532853418 
public void setModel(TreeModel newModel)
    { 

//#if 1511230851 
LOG.debug("setModel");
//#endif 


//#if 772858564 
Object r = newModel.getRoot();
//#endif 


//#if -1248043317 
if(r != null)//1
{ 

//#if 1487786005 
super.setModel(newModel);
//#endif 

} 

//#endif 


//#if -213905484 
reexpand();
//#endif 

} 

//#endif 


//#if -293069079 
private static NotationSettings getNotationSettings()
    { 

//#if 1941803479 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -409057468 
NotationSettings settings;
//#endif 


//#if -1364314689 
if(p != null)//1
{ 

//#if 1135677197 
settings = p.getProjectSettings().getNotationSettings();
//#endif 

} 
else
{ 

//#if 960116332 
settings = NotationSettings.getDefaultSettings();
//#endif 

} 

//#endif 


//#if 1635397145 
return settings;
//#endif 

} 

//#endif 


//#if -1831282191 
public static String generateStereotype(Collection<Object> st)
    { 

//#if -1626451501 
return NotationUtilityUml.generateStereotype(st,
                getNotationSettings().isUseGuillemets());
//#endif 

} 

//#endif 


//#if -140045566 
private void reexpand()
    { 

//#if 805470013 
LOG.debug("reexpand");
//#endif 


//#if 2143086096 
if(expandedPathsInModel == null)//1
{ 

//#if 1931316762 
return;
//#endif 

} 

//#endif 


//#if 1558788972 
reexpanding = true;
//#endif 


//#if -31223454 
for (TreePath path : getExpandedPaths()) //1
{ 

//#if 1861118882 
expandPath(path);
//#endif 

} 

//#endif 


//#if 661056601 
reexpanding = false;
//#endif 

} 

//#endif 


//#if -883157077 
public String convertValueToText(Object value, boolean selected,
                                     boolean expanded, boolean leaf, int row, boolean hasFocus)
    { 

//#if 1985654471 
if(value instanceof ToDoItem)//1
{ 

//#if -1516904753 
return ((ToDoItem) value).getHeadline();
//#endif 

} 

//#endif 


//#if -2141182254 
if(value instanceof ToDoList)//1
{ 

//#if -1332518732 
return "ToDoList";
//#endif 

} 

//#endif 


//#if 1133887159 
if(Model.getFacade().isAModelElement(value))//1
{ 

//#if -633802726 
String name = null;
//#endif 


//#if -347318051 
try //1
{ 

//#if -1610938525 
if(Model.getFacade().isATransition(value))//1
{ 

//#if -1500011591 
name = formatTransitionLabel(value);
//#endif 

} 
else

//#if -623920382 
if(Model.getFacade().isAExtensionPoint(value))//1
{ 

//#if 1577371650 
name = formatExtensionPoint(value);
//#endif 

} 
else

//#if 1156603443 
if(Model.getFacade().isAComment(value))//1
{ 

//#if -784066096 
name = (String) Model.getFacade().getBody(value);
//#endif 

} 
else

//#if -518494584 
if(Model.getFacade().isATaggedValue(value))//1
{ 

//#if -155926799 
name = formatTaggedValueLabel(value);
//#endif 

} 
else
{ 

//#if 1472917662 
name = getModelElementDisplayName(value);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if 447159945 
if(name != null
                        && name.indexOf("\n") < 80
                        && name.indexOf("\n") > -1)//1
{ 

//#if 876554279 
name = name.substring(0, name.indexOf("\n")) + "...";
//#endif 

} 
else

//#if -1739183151 
if(name != null && name.length() > 80)//1
{ 

//#if -228335851 
name = name.substring(0, 80) + "...";
//#endif 

} 

//#endif 


//#endif 


//#if 1830708220 
if(showStereotype)//1
{ 

//#if 2075996012 
Collection<Object> stereos =
                        Model.getFacade().getStereotypes(value);
//#endif 


//#if -1543437447 
name += " " + generateStereotype(stereos);
//#endif 


//#if -1651264084 
if(name != null && name.length() > 80)//1
{ 

//#if -1830585077 
name = name.substring(0, 80) + "...";
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#if -1035736981 
catch (InvalidElementException e) //1
{ 

//#if 977077390 
name = Translator.localize("misc.name.deleted");
//#endif 

} 

//#endif 


//#endif 


//#if 521573913 
return name;
//#endif 

} 

//#endif 


//#if -840405819 
if(Model.getFacade().isAElementImport(value))//1
{ 

//#if 148395167 
try //1
{ 

//#if 567711672 
Object me = Model.getFacade().getImportedElement(value);
//#endif 


//#if -1966917239 
String typeName = Model.getFacade().getUMLClassName(me);
//#endif 


//#if -590044137 
String elemName = convertValueToText(me, selected,
                                                     expanded, leaf, row,
                                                     hasFocus);
//#endif 


//#if -11635934 
String alias = Model.getFacade().getAlias(value);
//#endif 


//#if -966333132 
if(alias != null && alias.length() > 0)//1
{ 

//#if 802177587 
Object[] args = {typeName, elemName, alias};
//#endif 


//#if 1193681637 
return Translator.localize(
                               "misc.name.element-import.alias", args);
//#endif 

} 
else
{ 

//#if -1147230752 
Object[] args = {typeName, elemName};
//#endif 


//#if -1535338028 
return Translator.localize(
                               "misc.name.element-import", args);
//#endif 

} 

//#endif 

} 

//#if 1440620232 
catch (InvalidElementException e) //1
{ 

//#if 1706530491 
return Translator.localize("misc.name.deleted");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 188354594 
if(Model.getFacade().isAUMLElement(value))//1
{ 

//#if -1819089982 
try //1
{ 

//#if -400737884 
return Model.getFacade().toString(value);
//#endif 

} 

//#if -921959378 
catch (InvalidElementException e) //1
{ 

//#if -2143647941 
return Translator.localize("misc.name.deleted");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -545572004 
if(value instanceof ArgoDiagram)//1
{ 

//#if -47806763 
return ((ArgoDiagram) value).getName();
//#endif 

} 

//#endif 


//#if 389765285 
if(value != null)//1
{ 

//#if 1323684986 
return value.toString();
//#endif 

} 

//#endif 


//#if 1631941064 
return "-";
//#endif 

} 

//#endif 


//#if 1390127398 
public void fireTreeExpanded(TreePath path)
    { 

//#if -834046332 
super.fireTreeExpanded(path);
//#endif 


//#if -985683521 
LOG.debug("fireTreeExpanded");
//#endif 


//#if 814896569 
if(reexpanding || path == null)//1
{ 

//#if -1350417469 
return;
//#endif 

} 

//#endif 


//#if -673298321 
List<TreePath> expanded = getExpandedPaths();
//#endif 


//#if -1077364159 
expanded.remove(path);
//#endif 


//#if 1930931000 
expanded.add(path);
//#endif 

} 

//#endif 


//#if 1290464834 
public DisplayTextTree()
    { 

//#if 837701376 
super();
//#endif 


//#if -129253012 
setCellRenderer(new UMLTreeCellRenderer());
//#endif 


//#if -1700611812 
setRootVisible(false);
//#endif 


//#if -970061580 
setShowsRootHandles(true);
//#endif 


//#if 775829709 
setToolTipText("Tree");
//#endif 


//#if -536139807 
setRowHeight(18);
//#endif 


//#if -1487529175 
expandedPathsInModel = new Hashtable<TreeModel, List<TreePath>>();
//#endif 


//#if 586385889 
reexpanding = false;
//#endif 

} 

//#endif 


//#if 709442950 
private String formatExtensionPoint(Object value)
    { 

//#if -1183052005 
NotationSettings settings = getNotationSettings();
//#endif 


//#if -1446261867 
NotationProvider notationProvider = NotationProviderFactory2
                                            .getInstance().getNotationProvider(
                                                NotationProviderFactory2.TYPE_EXTENSION_POINT, value,
                                                Notation.findNotation(settings.getNotationLanguage()));
//#endif 


//#if 1951659321 
String name = notationProvider.toString(value, settings);
//#endif 


//#if -1703236409 
return name;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

