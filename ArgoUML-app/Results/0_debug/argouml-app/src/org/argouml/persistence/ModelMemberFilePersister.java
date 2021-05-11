
//#if 319203207 
// Compilation Unit of /ModelMemberFilePersister.java 
 

//#if 1439441184 
package org.argouml.persistence;
//#endif 


//#if -158780622 
import java.io.IOException;
//#endif 


//#if 2117896529 
import java.io.InputStream;
//#endif 


//#if -819592006 
import java.io.OutputStream;
//#endif 


//#if -372183643 
import java.net.URL;
//#endif 


//#if 1864926696 
import java.util.ArrayList;
//#endif 


//#if -977216391 
import java.util.Collection;
//#endif 


//#if 307626737 
import java.util.HashMap;
//#endif 


//#if -1342123095 
import java.util.Iterator;
//#endif 


//#if 764583801 
import java.util.List;
//#endif 


//#if -1203903633 
import org.argouml.application.api.Argo;
//#endif 


//#if 312188523 
import org.argouml.application.helpers.ApplicationVersion;
//#endif 


//#if -211462082 
import org.argouml.configuration.Configuration;
//#endif 


//#if 934914866 
import org.argouml.kernel.Project;
//#endif 


//#if 1379710584 
import org.argouml.kernel.ProjectMember;
//#endif 


//#if -961157893 
import org.argouml.model.Facade;
//#endif 


//#if -648921896 
import org.argouml.model.Model;
//#endif 


//#if 680061018 
import org.argouml.model.UmlException;
//#endif 


//#if 895738778 
import org.argouml.model.XmiException;
//#endif 


//#if -1594156854 
import org.argouml.model.XmiReader;
//#endif 


//#if -1071561958 
import org.argouml.model.XmiWriter;
//#endif 


//#if -1193243606 
import org.argouml.uml.ProjectMemberModel;
//#endif 


//#if -1421878633 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -226744882 
import org.argouml.uml.diagram.DiagramFactory;
//#endif 


//#if 971596687 
import org.argouml.uml.diagram.DiagramFactory.DiagramType;
//#endif 


//#if -910080161 
import org.xml.sax.InputSource;
//#endif 


//#if 1798508901 
import org.apache.log4j.Logger;
//#endif 


//#if 1702452667 
class ModelMemberFilePersister extends 
//#if 1884699997 
MemberFilePersister
//#endif 

 implements 
//#if -1742558760 
XmiExtensionParser
//#endif 

  { 

//#if 1471072350 
private Object curModel;
//#endif 


//#if -1320202439 
private HashMap<String, Object> uUIDRefs;
//#endif 


//#if 2024758779 
private Collection elementsRead;
//#endif 


//#if -212092510 
private static final Logger LOG =
        Logger.getLogger(ModelMemberFilePersister.class);
//#endif 


//#if -503056503 
public HashMap<String, Object> getUUIDRefs()
    { 

//#if -383343322 
return uUIDRefs;
//#endif 

} 

//#endif 


//#if 415951812 
public void load(Project project, InputStream inputStream)
    throws OpenException
    { 

//#if -1781436416 
load(project, new InputSource(inputStream));
//#endif 

} 

//#endif 


//#if 1313587567 
public void registerDiagrams(Project project)
    { 

//#if -1127095720 
registerDiagramsInternal(project, elementsRead, true);
//#endif 

} 

//#endif 


//#if -917427158 
public void save(ProjectMember member, OutputStream outStream)
    throws SaveException
    { 

//#if -331227859 
ProjectMemberModel pmm = (ProjectMemberModel) member;
//#endif 


//#if 1696014960 
Object model = pmm.getModel();
//#endif 


//#if 899708796 
try //1
{ 

//#if 566468924 
XmiWriter xmiWriter =
                Model.getXmiWriter(model, outStream,
                                   ApplicationVersion.getVersion() + "("
                                   + UmlFilePersister.PERSISTENCE_VERSION + ")");
//#endif 


//#if 1252185338 
xmiWriter.write();
//#endif 


//#if -1146626866 
outStream.flush();
//#endif 

} 

//#if -615403912 
catch (UmlException e) //1
{ 

//#if 634572841 
throw new SaveException(e);
//#endif 

} 

//#endif 


//#if -2016825762 
catch (IOException e) //1
{ 

//#if -227992155 
throw new SaveException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -995207772 
public void load(Project project, URL url)
    throws OpenException
    { 

//#if -892517067 
load(project, new InputSource(url.toExternalForm()));
//#endif 

} 

//#endif 


//#if -176318838 
public Object getCurModel()
    { 

//#if -400852899 
return curModel;
//#endif 

} 

//#endif 


//#if -1372829157 
private void registerDiagramsInternal(Project project, Collection elements,
                                          boolean atLeastOne)
    { 

//#if -1195337922 
Facade facade = Model.getFacade();
//#endif 


//#if 1593497130 
Collection diagramsElement = new ArrayList();
//#endif 


//#if 332913375 
Iterator it = elements.iterator();
//#endif 


//#if -933504572 
while (it.hasNext()) //1
{ 

//#if -1534800032 
Object element = it.next();
//#endif 


//#if 1254256102 
if(facade.isAModel(element))//1
{ 

//#if 630329609 
diagramsElement.addAll(Model.getModelManagementHelper()
                                       .getAllModelElementsOfKind(element,
                                               Model.getMetaTypes().getStateMachine()));
//#endif 

} 
else

//#if 1788924441 
if(facade.isAStateMachine(element))//1
{ 

//#if -844374888 
diagramsElement.add(element);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 209081169 
DiagramFactory diagramFactory = DiagramFactory.getInstance();
//#endif 


//#if 1855241122 
it = diagramsElement.iterator();
//#endif 


//#if -121386387 
while (it.hasNext()) //2
{ 

//#if -2070610818 
Object statemachine = it.next();
//#endif 


//#if 1301549158 
Object namespace = facade.getNamespace(statemachine);
//#endif 


//#if 735139117 
if(namespace == null)//1
{ 

//#if 1937333101 
namespace = facade.getContext(statemachine);
//#endif 


//#if -1490237681 
Model.getCoreHelper().setNamespace(statemachine, namespace);
//#endif 

} 

//#endif 


//#if -750109666 
ArgoDiagram diagram = null;
//#endif 


//#if -339901198 
LOG.info("Creating state diagram for "
                     + facade.getUMLClassName(statemachine)
                     + "<<" + facade.getName(statemachine) + ">>");
//#endif 


//#if 1086473669 
diagram = diagramFactory.createDiagram(
                          DiagramType.State,
                          namespace,
                          statemachine);
//#endif 


//#if 387658642 
if(facade.isAActivityGraph(statemachine))//1
{ 

//#if 208378112 
LOG.info("Creating activity diagram for "
                         + facade.getUMLClassName(statemachine)
                         + "<<" + facade.getName(statemachine) + ">>");
//#endif 


//#if 164528423 
diagram = diagramFactory.createDiagram(
                              DiagramType.Activity,
                              namespace,
                              statemachine);
//#endif 

} 
else
{ 

//#if -379802756 
LOG.info("Creating state diagram for "
                         + facade.getUMLClassName(statemachine)
                         + "<<" + facade.getName(statemachine) + ">>");
//#endif 


//#if -232948229 
diagram = diagramFactory.createDiagram(
                              DiagramType.State,
                              namespace,
                              statemachine);
//#endif 

} 

//#endif 


//#if 1893488641 
if(diagram != null)//1
{ 

//#if 734523189 
project.addMember(diagram);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1085149626 
if(atLeastOne && project.getDiagramCount() < 1)//1
{ 

//#if 525092374 
ArgoDiagram d = diagramFactory.createDiagram(
                                DiagramType.Class, curModel, null);
//#endif 


//#if -1348571912 
project.addMember(d);
//#endif 

} 

//#endif 


//#if 2020747713 
if(project.getDiagramCount() >= 1
                && project.getActiveDiagram() == null)//1
{ 

//#if 394526452 
project.setActiveDiagram(
                project.getDiagramList().get(0));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 910522758 
public synchronized void readModels(InputSource source)
    throws OpenException
    { 

//#if -749691744 
XmiReader reader = null;
//#endif 


//#if -1284541113 
try //1
{ 

//#if -1613599957 
reader = Model.getXmiReader();
//#endif 


//#if -865954729 
if(Configuration.getBoolean(Argo.KEY_XMI_STRIP_DIAGRAMS, false))//1
{ 

//#if 910629397 
reader.setIgnoredElements(new String[] {"UML:Diagram"});
//#endif 

} 
else
{ 

//#if 1749901422 
reader.setIgnoredElements(null);
//#endif 

} 

//#endif 


//#if -1880471342 
List<String> searchPath = reader.getSearchPath();
//#endif 


//#if -1276266480 
String pathList =
                System.getProperty("org.argouml.model.modules_search_path");
//#endif 


//#if 1694546504 
if(pathList != null)//1
{ 

//#if 1958135406 
String[] paths = pathList.split(",");
//#endif 


//#if -1801649876 
for (String path : paths) //1
{ 

//#if -1364341610 
if(!searchPath.contains(path))//1
{ 

//#if 61492464 
reader.addSearchPath(path);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 192752436 
reader.addSearchPath(source.getSystemId());
//#endif 


//#if -1779007375 
curModel = null;
//#endif 


//#if 535196005 
elementsRead = reader.parse(source, false);
//#endif 


//#if -472794014 
if(elementsRead != null && !elementsRead.isEmpty())//1
{ 

//#if -479544828 
Facade facade = Model.getFacade();
//#endif 


//#if 599942133 
Object current;
//#endif 


//#if 1579397647 
Iterator elements = elementsRead.iterator();
//#endif 


//#if 1757280970 
while (elements.hasNext()) //1
{ 

//#if 151623380 
current = elements.next();
//#endif 


//#if 1319763493 
if(facade.isAModel(current))//1
{ 

//#if 1654516875 
LOG.info("Loaded model '" + facade.getName(current)
                                 + "'");
//#endif 


//#if -392569507 
if(curModel == null)//1
{ 

//#if 770986253 
curModel = current;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 584558776 
uUIDRefs =
                new HashMap<String, Object>(reader.getXMIUUIDToObjectMap());
//#endif 

} 

//#if 982221870 
catch (XmiException ex) //1
{ 

//#if -945004102 
throw new XmiFormatException(ex);
//#endif 

} 

//#endif 


//#if -1853130898 
catch (UmlException ex) //1
{ 

//#if -1080654848 
throw new XmiFormatException(ex);
//#endif 

} 

//#endif 


//#endif 


//#if 1011267290 
LOG.info("=======================================");
//#endif 

} 

//#endif 


//#if -1253517284 
private void load(Project project, InputSource source)
    throws OpenException
    { 

//#if -1145935337 
Object mmodel = null;
//#endif 


//#if 231148571 
try //1
{ 

//#if 693831334 
source.setEncoding(Argo.getEncoding());
//#endif 


//#if 1298649102 
readModels(source);
//#endif 


//#if -769018219 
mmodel = getCurModel();
//#endif 

} 

//#if 1803449439 
catch (OpenException e) //1
{ 

//#if -17530602 
LOG.error("UmlException caught", e);
//#endif 


//#if 200349828 
throw e;
//#endif 

} 

//#endif 


//#endif 


//#if 1517314493 
Model.getUmlHelper().addListenersToModel(mmodel);
//#endif 


//#if -780845355 
project.addMember(mmodel);
//#endif 


//#if 115374436 
project.setUUIDRefs(new HashMap<String, Object>(getUUIDRefs()));
//#endif 

} 

//#endif 


//#if 726616595 
public void parse(String label, String xmiExtensionString)
    { 

//#if -482775096 
LOG.info("Parsing an extension for " + label);
//#endif 

} 

//#endif 


//#if 732734758 
public synchronized void readModels(URL url,
                                        XmiExtensionParser xmiExtensionParser) throws OpenException
    { 

//#if 1232941814 
LOG.info("=======================================");
//#endif 


//#if 1426373084 
LOG.info("== READING MODEL " + url);
//#endif 


//#if -1290239389 
try //1
{ 

//#if -1783380351 
InputSource source =
                new InputSource(new XmiInputStream(
                                    url.openStream(), xmiExtensionParser, 100000, null));
//#endif 


//#if 1738543407 
source.setSystemId(url.toString());
//#endif 


//#if -535123113 
readModels(source);
//#endif 

} 

//#if -1189915338 
catch (IOException ex) //1
{ 

//#if 1578492462 
throw new OpenException(ex);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 52068020 
public String getMainTag()
    { 

//#if -179527239 
try //1
{ 

//#if 2043484885 
return Model.getXmiReader().getTagName();
//#endif 

} 

//#if 1047518977 
catch (UmlException e) //1
{ 

//#if -424598135 
throw new RuntimeException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 607043216 
public void setElementsRead(Collection elements)
    { 

//#if 308986815 
this.elementsRead = elements;
//#endif 

} 

//#endif 


//#if -881608209 
public Collection getElementsRead()
    { 

//#if -119525305 
return elementsRead;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

