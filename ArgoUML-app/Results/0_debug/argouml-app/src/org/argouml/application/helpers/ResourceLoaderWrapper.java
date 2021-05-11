
//#if 142215024 
// Compilation Unit of /ResourceLoaderWrapper.java 
 

//#if 1688710284 
package org.argouml.application.helpers;
//#endif 


//#if -1932099751 
import java.net.URL;
//#endif 


//#if 743137725 
import java.util.HashMap;
//#endif 


//#if -1988014613 
import java.util.Hashtable;
//#endif 


//#if 1405778831 
import java.util.Map;
//#endif 


//#if -1331546358 
import javax.swing.Icon;
//#endif 


//#if 1177014047 
import javax.swing.ImageIcon;
//#endif 


//#if -1783883366 
import javax.swing.UIManager;
//#endif 


//#if 1910270174 
import org.argouml.i18n.Translator;
//#endif 


//#if -881266096 
import org.argouml.model.DataTypesHelper;
//#endif 


//#if -1844333405 
import org.argouml.model.InvalidElementException;
//#endif 


//#if -1732226396 
import org.argouml.model.Model;
//#endif 


//#if 715204401 
import org.apache.log4j.Logger;
//#endif 


//#if 193829436 
public final class ResourceLoaderWrapper  { 

//#if 36479727 
private static ImageIcon initialStateIcon;
//#endif 


//#if 1129764624 
private static ImageIcon deepIcon;
//#endif 


//#if 550599988 
private static ImageIcon shallowIcon;
//#endif 


//#if 567557370 
private static ImageIcon forkIcon;
//#endif 


//#if -1679004270 
private static ImageIcon joinIcon;
//#endif 


//#if 1273571738 
private static ImageIcon branchIcon;
//#endif 


//#if -1121288024 
private static ImageIcon junctionIcon;
//#endif 


//#if 1241221522 
private static ImageIcon realizeIcon;
//#endif 


//#if -1356491692 
private static ImageIcon signalIcon;
//#endif 


//#if -1332039079 
private static ImageIcon exceptionIcon;
//#endif 


//#if -1367291959 
private static ImageIcon commentIcon;
//#endif 


//#if 1524121884 
private Hashtable<Class, Icon> iconCache = new Hashtable<Class, Icon>();
//#endif 


//#if -1354521564 
private static ResourceLoaderWrapper instance = new ResourceLoaderWrapper();
//#endif 


//#if 1949736799 
private static Map<String, String> images = new HashMap<String, String>();
//#endif 


//#if -2128011905 
private static final Logger LOG =
        Logger.getLogger(ResourceLoaderWrapper.class);
//#endif 


//#if -732741229 
static
    {
        images.put("action.about-argouml", "AboutArgoUML");
        images.put("action.activity-diagram", "Activity Diagram");
        images.put("action.class-diagram", "Class Diagram");
        images.put("action.collaboration-diagram", "Collaboration Diagram");
        images.put("action.deployment-diagram", "Deployment Diagram");
        images.put("action.sequence-diagram", "Sequence Diagram");
        images.put("action.state-diagram", "State Diagram");
        images.put("action.usecase-diagram", "Use Case Diagram");
    }
//#endif 


//#if 584853381 
static
    {
        images.put("action.add-concurrent-region", "Add Concurrent Region");
        images.put("action.add-message", "Add Message");
        images.put("action.configure-perspectives", "ConfigurePerspectives");
        images.put("action.copy", "Copy");
        images.put("action.cut", "Cut");
        images.put("action.delete-concurrent-region", "DeleteConcurrentRegion");
        images.put("action.delete-from-model", "DeleteFromModel");
        images.put("action.find", "Find...");
        images.put("action.import-sources", "Import Sources...");
        images.put("action.more-info", "More Info...");
        images.put("action.navigate-back", "Navigate Back");
        images.put("action.navigate-forward", "Navigate Forward");
        images.put("action.new", "New");
        images.put("action.new-todo-item", "New To Do Item...");
        images.put("action.open-project", "Open Project...");
        images.put("action.page-setup", "Page Setup...");
        images.put("action.paste", "Paste");
        images.put("action.print", "Print...");
        images.put("action.properties", "Properties");
        images.put("action.remove-from-diagram", "Remove From Diagram");
        images.put("action.resolve-item", "Resolve Item...");
        images.put("action.save-project", "Save Project");
        images.put("action.save-project-as", "Save Project As...");
        images.put("action.settings", "Settings...");
        images.put("action.snooze-critic", "Snooze Critic");
        images.put("action.system-information", "System Information");
    }
//#endif 


//#if 526945755 
static
    {
        images.put("button.broom", "Broom");
        images.put("button.new-actionstate", "ActionState");
        images.put("button.new-actor", "Actor");
        images.put("button.new-aggregation", "Aggregation");
        images.put("button.new-association", "Association");
        images.put("button.new-associationclass", "AssociationClass");
        images.put("button.new-association-end", "AssociationEnd");
        images.put("button.new-associationrole", "AssociationRole");
        images.put("button.new-attribute", "New Attribute");
        images.put("button.new-callaction", "CallAction");
        images.put("button.new-callstate", "CallState");
        images.put("button.new-choice", "Choice");
        images.put("button.new-class", "Class");
        images.put("button.new-classifierrole", "ClassifierRole");
        images.put("button.new-commentlink", "CommentLink");
        images.put("button.new-component", "Component");
        images.put("button.new-componentinstance", "ComponentInstance");
        images.put("button.new-compositestate", "CompositeState");
        images.put("button.new-composition", "Composition");
        images.put("button.new-createaction", "CreateAction");
        images.put("button.new-datatype", "DataType");
        images.put("button.new-deephistory", "DeepHistory");
        images.put("button.new-dependency", "Dependency");
        images.put("button.new-destroyaction", "DestroyAction");
        images.put("button.new-enumeration", "Enumeration");
        images.put("button.new-enumeration-literal", "EnumerationLiteral");
        images.put("button.new-extension-point", "New Extension Point");
        images.put("button.new-extend", "Extend");
        images.put("button.new-exception", "Exception");
    }
//#endif 


//#if 769776429 
static
    {
        images.put("button.new-finalstate", "FinalState");
        images.put("button.new-fork", "Fork");
        images.put("button.new-generalization", "Generalization");
        images.put("button.new-include", "Include");
        images.put("button.new-initial", "Initial");
    }
//#endif 


//#if 989892516 
static
    {
        images.put("button.new-inner-class", "Inner Class");
        images.put("button.new-interface", "Interface");
        images.put("button.new-join", "Join");
        images.put("button.new-junction", "Junction");
        images.put("button.new-link", "Link");
        images.put("button.new-node", "Node");
        images.put("button.new-nodeinstance", "NodeInstance");
        images.put("button.new-object", "Object");
        images.put("button.new-objectflowstate", "ObjectFlowState");
    }
//#endif 


//#if 715267684 
static
    {
        images.put("button.new-operation", "New Operation");
        images.put("button.new-package", "Package");
        images.put("button.new-parameter", "New Parameter");
        images.put("button.new-partition", "Partition");
        images.put("button.new-permission", "Permission");
        images.put("button.new-raised-signal", "New Raised Signal");
        images.put("button.new-reception", "New Reception");
        images.put("button.new-realization", "Realization");
        images.put("button.new-returnaction", "ReturnAction");
        images.put("button.new-sendaction", "SendAction");
        images.put("button.new-shallowhistory", "ShallowHistory");
        images.put("button.new-signal", "Signal");
        images.put("button.new-simplestate", "SimpleState");
        images.put("button.new-stereotype", "Stereotype");
        images.put("button.new-stubstate", "StubState");
        images.put("button.new-subactivitystate", "SubactivityState");
        images.put("button.new-submachinestate", "SubmachineState");
        images.put("button.new-synchstate", "SynchState");
        images.put("button.new-tagdefinition", "TagDefinition");
        images.put("button.new-transition", "Transition");
        images.put("button.new-uniaggregation", "UniAggregation");
        images.put("button.new-uniassociation", "UniAssociation");
        images.put("button.new-unicomposition", "UniComposition");
        images.put("button.new-usage", "Usage");
        images.put("button.new-usecase", "UseCase");
    }
//#endif 


//#if 1491400422 
static
    {
        images.put("button.select", "Select");
        images.put("button.sequence-expand", "SequenceExpand");
        images.put("button.sequence-contract", "SequenceContract");
    }
//#endif 


//#if 526282001 
public static void addResourceLocation(String location)
    { 

//#if 562102825 
ResourceLoader.addResourceLocation(location);
//#endif 

} 

//#endif 


//#if 580600583 
public Icon lookupIcon(Object value)
    { 

//#if -1617413536 
if(value == null)//1
{ 

//#if 1857641797 
throw new IllegalArgumentException(
                "Attempted to get an icon given a null key");
//#endif 

} 

//#endif 


//#if -1299597994 
if(value instanceof String)//1
{ 

//#if 1806559021 
return null;
//#endif 

} 

//#endif 


//#if 978571945 
Icon icon = iconCache.get(value.getClass());
//#endif 


//#if 1813973057 
try //1
{ 

//#if 1922331810 
if(Model.getFacade().isAPseudostate(value))//1
{ 

//#if -1679009928 
Object kind = Model.getFacade().getKind(value);
//#endif 


//#if -364193667 
DataTypesHelper helper = Model.getDataTypesHelper();
//#endif 


//#if -339360998 
if(helper.equalsINITIALKind(kind))//1
{ 

//#if 1698277814 
icon = initialStateIcon;
//#endif 

} 

//#endif 


//#if -1989521314 
if(helper.equalsDeepHistoryKind(kind))//1
{ 

//#if 1708254403 
icon = deepIcon;
//#endif 

} 

//#endif 


//#if 688294844 
if(helper.equalsShallowHistoryKind(kind))//1
{ 

//#if -2094276554 
icon = shallowIcon;
//#endif 

} 

//#endif 


//#if 110475454 
if(helper.equalsFORKKind(kind))//1
{ 

//#if 356705519 
icon = forkIcon;
//#endif 

} 

//#endif 


//#if 944681766 
if(helper.equalsJOINKind(kind))//1
{ 

//#if -1372198594 
icon = joinIcon;
//#endif 

} 

//#endif 


//#if 2096065181 
if(helper.equalsCHOICEKind(kind))//1
{ 

//#if 78382746 
icon = branchIcon;
//#endif 

} 

//#endif 


//#if -1393769904 
if(helper.equalsJUNCTIONKind(kind))//1
{ 

//#if -1247895897 
icon = junctionIcon;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2131368017 
if(Model.getFacade().isAAbstraction(value))//1
{ 

//#if 1740355769 
icon = realizeIcon;
//#endif 

} 

//#endif 


//#if 1259863974 
if(Model.getFacade().isAException(value))//1
{ 

//#if 1924312320 
icon = exceptionIcon;
//#endif 

} 
else
{ 

//#if -391329146 
if(Model.getFacade().isASignal(value))//1
{ 

//#if 726144834 
icon = signalIcon;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 119326422 
if(Model.getFacade().isAComment(value))//1
{ 

//#if -1029335285 
icon = commentIcon;
//#endif 

} 

//#endif 


//#if -29923120 
if(icon == null)//1
{ 

//#if 699221949 
String cName = Model.getMetaTypes().getName(value);
//#endif 


//#if 1929907474 
icon = lookupIconResource(cName);
//#endif 


//#if -1137063676 
if(icon != null)//1
{ 

//#if -69636862 
synchronized (iconCache) //1
{ 

//#if -2089957911 
iconCache.put(value.getClass(), icon);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1950492776 
if(icon == null)//1
{ 

//#if 1874583861 
LOG.debug("Can't find icon for " + cName);
//#endif 

} 
else
{ 

//#if 784359602 
synchronized (iconCache) //1
{ 

//#if -1830521410 
iconCache.put(value.getClass(), icon);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#if 1119702134 
catch (InvalidElementException e) //1
{ 

//#if -64066419 
LOG.debug("Attempted to get icon for deleted element");
//#endif 


//#if 1510460926 
return null;
//#endif 

} 

//#endif 


//#endif 


//#if -1678221049 
return icon;
//#endif 

} 

//#endif 


//#if -503392170 
public static ImageIcon lookupIcon(String key)
    { 

//#if 1652996858 
return lookupIconResource(getImageBinding(key),
                                  Translator.localize(key));
//#endif 

} 

//#endif 


//#if 239504861 
public static ImageIcon lookupIconResource(String resource)
    { 

//#if -942360302 
return ResourceLoader.lookupIconResource(resource);
//#endif 

} 

//#endif 


//#if -120342348 
public static ResourceLoaderWrapper getInstance()
    { 

//#if -1129948081 
return instance;
//#endif 

} 

//#endif 


//#if -755451053 
private ResourceLoaderWrapper()
    { 

//#if 1430593313 
initResourceLoader();
//#endif 

} 

//#endif 


//#if -530875718 
public static String getImageBinding(String name)
    { 

//#if -1141978542 
String found = images.get(name);
//#endif 


//#if 1363654349 
if(found == null)//1
{ 

//#if -78107834 
return name;
//#endif 

} 

//#endif 


//#if -1125381104 
return found;
//#endif 

} 

//#endif 


//#if 1498357852 
private static String lookAndFeelPath(String classname, String element)
    { 

//#if 1351279925 
return "/org/argouml/Images/plaf/"
               + classname.replace('.', '/')
               + "/toolbarButtonGraphics/"
               + element;
//#endif 

} 

//#endif 


//#if 119768135 
public static ImageIcon lookupIconResource(String resource, String desc)
    { 

//#if 1637277861 
return ResourceLoader.lookupIconResource(resource, desc);
//#endif 

} 

//#endif 


//#if 915640404 
private static void initResourceLoader()
    { 

//#if 1370315645 
String lookAndFeelClassName;
//#endif 


//#if -11580802 
if("true".equals(System.getProperty("force.nativelaf", "false")))//1
{ 

//#if -1169430868 
lookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
//#endif 

} 
else
{ 

//#if 1955840669 
lookAndFeelClassName = "javax.swing.plaf.metal.MetalLookAndFeel";
//#endif 

} 

//#endif 


//#if 649615852 
String lookAndFeelGeneralImagePath =
            lookAndFeelPath(lookAndFeelClassName, "general");
//#endif 


//#if 674972138 
String lookAndFeelNavigationImagePath =
            lookAndFeelPath(lookAndFeelClassName, "navigation");
//#endif 


//#if 1816902997 
String lookAndFeelDiagramImagePath =
            lookAndFeelPath(lookAndFeelClassName, "argouml/diagrams");
//#endif 


//#if 1976380469 
String lookAndFeelElementImagePath =
            lookAndFeelPath(lookAndFeelClassName, "argouml/elements");
//#endif 


//#if 384142124 
String lookAndFeelArgoUmlImagePath =
            lookAndFeelPath(lookAndFeelClassName, "argouml");
//#endif 


//#if 561406367 
ResourceLoader.addResourceExtension("gif");
//#endif 


//#if 823716122 
ResourceLoader.addResourceExtension("png");
//#endif 


//#if -1993030753 
ResourceLoader.addResourceLocation(lookAndFeelGeneralImagePath);
//#endif 


//#if 417192489 
ResourceLoader.addResourceLocation(lookAndFeelNavigationImagePath);
//#endif 


//#if -987313452 
ResourceLoader.addResourceLocation(lookAndFeelDiagramImagePath);
//#endif 


//#if -144582389 
ResourceLoader.addResourceLocation(lookAndFeelElementImagePath);
//#endif 


//#if -167556756 
ResourceLoader.addResourceLocation(lookAndFeelArgoUmlImagePath);
//#endif 


//#if -2032697497 
ResourceLoader.addResourceLocation("/org/argouml/Images");
//#endif 


//#if 698594033 
ResourceLoader.addResourceLocation("/org/tigris/gef/Images");
//#endif 


//#if 1671480243 
org.tigris.gef.util.ResourceLoader.addResourceExtension("gif");
//#endif 


//#if 1933789998 
org.tigris.gef.util.ResourceLoader.addResourceExtension("png");
//#endif 


//#if -651282933 
org.tigris.gef.util.ResourceLoader
        .addResourceLocation(lookAndFeelGeneralImagePath);
//#endif 


//#if -834125763 
org.tigris.gef.util.ResourceLoader
        .addResourceLocation(lookAndFeelNavigationImagePath);
//#endif 


//#if 354434368 
org.tigris.gef.util.ResourceLoader
        .addResourceLocation(lookAndFeelDiagramImagePath);
//#endif 


//#if 1197165431 
org.tigris.gef.util.ResourceLoader
        .addResourceLocation(lookAndFeelElementImagePath);
//#endif 


//#if 1174191064 
org.tigris.gef.util.ResourceLoader
        .addResourceLocation(lookAndFeelArgoUmlImagePath);
//#endif 


//#if -507366701 
org.tigris.gef.util.ResourceLoader
        .addResourceLocation("/org/argouml/Images");
//#endif 


//#if 1074345989 
org.tigris.gef.util.ResourceLoader
        .addResourceLocation("/org/tigris/gef/Images");
//#endif 


//#if 932004297 
initialStateIcon = ResourceLoader.lookupIconResource("Initial");
//#endif 


//#if -389650428 
deepIcon = ResourceLoader.lookupIconResource("DeepHistory");
//#endif 


//#if -946760284 
shallowIcon = ResourceLoader.lookupIconResource("ShallowHistory");
//#endif 


//#if 1118714628 
forkIcon = ResourceLoader.lookupIconResource("Fork");
//#endif 


//#if -713055180 
joinIcon = ResourceLoader.lookupIconResource("Join");
//#endif 


//#if 706824805 
branchIcon = ResourceLoader.lookupIconResource("Choice");
//#endif 


//#if -1420490144 
junctionIcon = ResourceLoader.lookupIconResource("Junction");
//#endif 


//#if 2017016512 
realizeIcon = ResourceLoader.lookupIconResource("Realization");
//#endif 


//#if 48457718 
signalIcon = ResourceLoader.lookupIconResource("SignalSending");
//#endif 


//#if -804990928 
exceptionIcon = ResourceLoader.lookupIconResource("Exception");
//#endif 


//#if 404450471 
commentIcon = ResourceLoader.lookupIconResource("Note");
//#endif 

} 

//#endif 


//#if 380108108 
public static URL lookupIconUrl(String name)
    { 

//#if 751540094 
return lookupIconUrl(name, null);
//#endif 

} 

//#endif 


//#if -855555046 
public static URL lookupIconUrl(String name, ClassLoader loader)
    { 

//#if -34337173 
return ResourceLoader.lookupIconUrl(name, loader);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

