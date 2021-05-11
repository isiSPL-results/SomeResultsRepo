
//#if 43052874 
// Compilation Unit of /ProjectManager.java 
 

//#if 1715388578 
package org.argouml.kernel;
//#endif 


//#if -144407919 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 251630167 
import java.beans.PropertyChangeListener;
//#endif 


//#if -278048496 
import java.util.ArrayList;
//#endif 


//#if 1310029393 
import java.util.Collection;
//#endif 


//#if -1869609544 
import java.util.LinkedList;
//#endif 


//#if 1349876561 
import java.util.List;
//#endif 


//#if 1093564433 
import javax.swing.Action;
//#endif 


//#if 2088174743 
import javax.swing.event.EventListenerList;
//#endif 


//#if 1363229754 
import org.argouml.i18n.Translator;
//#endif 


//#if -965921792 
import org.argouml.model.Model;
//#endif 


//#if 1092313867 
import org.argouml.model.ModelCommand;
//#endif 


//#if -1851193674 
import org.argouml.model.ModelCommandCreationObserver;
//#endif 


//#if 1897485759 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -369165914 
import org.argouml.uml.diagram.DiagramFactory;
//#endif 


//#if 1481509005 
import org.apache.log4j.Logger;
//#endif 


//#if -1600135277 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1033089595 
import org.argouml.uml.cognitive.ProjectMemberTodoList;
//#endif 


//#if 763077702 
public final class ProjectManager implements 
//#if -1700022508 
ModelCommandCreationObserver
//#endif 

  { 

//#if 2048891309 
@Deprecated
    public static final String CURRENT_PROJECT_PROPERTY_NAME = "currentProject";
//#endif 


//#if 386624634 
public static final String OPEN_PROJECTS_PROPERTY = "openProjects";
//#endif 


//#if -1074597018 
private static ProjectManager instance = new ProjectManager();
//#endif 


//#if -1273434890 
private static Project currentProject;
//#endif 


//#if 1961645773 
private static LinkedList<Project> openProjects = new LinkedList<Project>();
//#endif 


//#if 1530095232 
private boolean creatingCurrentProject;
//#endif 


//#if -1641753620 
private Action saveAction;
//#endif 


//#if -600651127 
private EventListenerList listenerList = new EventListenerList();
//#endif 


//#if -2017766864 
private PropertyChangeEvent event;
//#endif 


//#if -1216778075 
private static final Logger LOG = Logger.getLogger(ProjectManager.class);
//#endif 


//#if 106769156 
public Project getCurrentProject()
    { 

//#if -770444087 
if(currentProject == null && !creatingCurrentProject)//1
{ 

//#if -2126593500 
makeEmptyProject();
//#endif 

} 

//#endif 


//#if 1845401906 
return currentProject;
//#endif 

} 

//#endif 


//#if 1980406495 
private void createDefaultModel(Project project)
    { 

//#if 2123160362 
Object model = Model.getModelManagementFactory().createModel();
//#endif 


//#if 411772030 
Model.getCoreHelper().setName(model,
                                      Translator.localize("misc.untitled-model"));
//#endif 


//#if -323065235 
Collection roots = new ArrayList();
//#endif 


//#if 241014859 
roots.add(model);
//#endif 


//#if -1897822581 
project.setRoots(roots);
//#endif 


//#if -1478796970 
project.setCurrentNamespace(model);
//#endif 


//#if -299648179 
project.addMember(model);
//#endif 

} 

//#endif 


//#if 565955019 
public void removeProject(Project oldProject)
    { 

//#if -287561770 
openProjects.remove(oldProject);
//#endif 


//#if -536363827 
if(currentProject == oldProject)//1
{ 

//#if -1895762661 
if(openProjects.size() > 0)//1
{ 

//#if 1231293539 
currentProject = openProjects.getLast();
//#endif 

} 
else
{ 

//#if 21314883 
currentProject = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1223493234 
oldProject.remove();
//#endif 

} 

//#endif 


//#if -1543934583 
public void setSaveAction(Action save)
    { 

//#if -583013531 
this.saveAction = save;
//#endif 


//#if -1838851098 
Designer.setSaveAction(save);
//#endif 

} 

//#endif 


//#if 1022178113 
void firePropertyChanged(String propertyName,
                             Object oldValue, Object newValue)
    { 

//#if 713491054 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if 1627547638 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if -228157870 
if(listeners[i] == PropertyChangeListener.class)//1
{ 

//#if -1130009831 
if(event == null)//1
{ 

//#if 183582195 
event =
                        new PropertyChangeEvent(
                        this,
                        propertyName,
                        oldValue,
                        newValue);
//#endif 

} 

//#endif 


//#if 505155981 
((PropertyChangeListener) listeners[i + 1]).propertyChange(
                    event);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1155670704 
event = null;
//#endif 

} 

//#endif 


//#if 36990027 
public void removePropertyChangeListener(PropertyChangeListener listener)
    { 

//#if -1920660866 
listenerList.remove(PropertyChangeListener.class, listener);
//#endif 

} 

//#endif 


//#if 1235237472 
public static ProjectManager getManager()
    { 

//#if -245422380 
return instance;
//#endif 

} 

//#endif 


//#if -1789387202 
public Object execute(final ModelCommand command)
    { 

//#if 1161513082 
setSaveEnabled(true);
//#endif 


//#if -159003607 
AbstractCommand wrappedCommand = new AbstractCommand() {
            private ModelCommand modelCommand = command;
            public void undo() {
                modelCommand.undo();
            }
            public boolean isUndoable() {
                return modelCommand.isUndoable();
            }
            public boolean isRedoable() {
                return modelCommand.isRedoable();
            }
            public Object execute() {
                return modelCommand.execute();
            }
            public String toString() {
                return modelCommand.toString();
            }
        };
//#endif 


//#if -648504994 
Project p = getCurrentProject();
//#endif 


//#if -1072122724 
if(p != null)//1
{ 

//#if -162915191 
return getCurrentProject().getUndoManager().execute(wrappedCommand);
//#endif 

} 
else
{ 

//#if -301086756 
return wrappedCommand.execute();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1829814355 
private void addProject(Project newProject)
    { 

//#if -538339301 
openProjects.addLast(newProject);
//#endif 

} 

//#endif 


//#if -876080178 
public Project makeEmptyProject()
    { 

//#if -1811302289 
return makeEmptyProject(true);
//#endif 

} 

//#endif 


//#if -46693445 
private ProjectManager()
    { 

//#if 1667688983 
super();
//#endif 


//#if 1548310172 
Model.setModelCommandCreationObserver(this);
//#endif 

} 

//#endif 


//#if 49295996 
public void setSaveEnabled(boolean newValue)
    { 

//#if 2102042418 
if(saveAction != null)//1
{ 

//#if 1149459075 
saveAction.setEnabled(newValue);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1650563628 
private void createDefaultDiagrams(Project project)
    { 

//#if -1737187656 
Object model = project.getRoots().iterator().next();
//#endif 


//#if 193899516 
DiagramFactory df = DiagramFactory.getInstance();
//#endif 


//#if 344678370 
ArgoDiagram d = df.create(DiagramFactory.DiagramType.Class,
                                  model,
                                  project.getProjectSettings().getDefaultDiagramSettings());
//#endif 


//#if 275398490 
project.addMember(d);
//#endif 


//#if 516629101 
project.addMember(df.create(
                              DiagramFactory.DiagramType.UseCase, model,
                              project.getProjectSettings().getDefaultDiagramSettings()));
//#endif 


//#if -1403110887 
project.addMember(new ProjectMemberTodoList("",
                          project));
//#endif 


//#if -275287128 
project.setActiveDiagram(d);
//#endif 

} 

//#endif 


//#if -946680012 
public void addPropertyChangeListener(PropertyChangeListener listener)
    { 

//#if 1627995274 
listenerList.add(PropertyChangeListener.class, listener);
//#endif 

} 

//#endif 


//#if -1833856061 
public boolean isSaveActionEnabled()
    { 

//#if -114552026 
return this.saveAction.isEnabled();
//#endif 

} 

//#endif 


//#if 1951097783 
public void setCurrentProject(Project newProject)
    { 

//#if -1039207127 
Project oldProject = currentProject;
//#endif 


//#if 310097797 
currentProject = newProject;
//#endif 


//#if -119470661 
addProject(newProject);
//#endif 


//#if -1529863769 
if(currentProject != null
                && currentProject.getActiveDiagram() == null)//1
{ 

//#if -878913020 
List<ArgoDiagram> diagrams = currentProject.getDiagramList();
//#endif 


//#if 135033833 
if(diagrams != null && !diagrams.isEmpty())//1
{ 

//#if 1506108283 
ArgoDiagram activeDiagram = diagrams.get(0);
//#endif 


//#if -182351169 
currentProject.setActiveDiagram(activeDiagram);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2084503999 
notifyProjectAdded(newProject, oldProject);
//#endif 

} 

//#endif 


//#if -1711058338 
public List<Project> getOpenProjects()
    { 

//#if 1633674716 
List<Project> result = new ArrayList<Project>();
//#endif 


//#if -1195564473 
if(currentProject != null)//1
{ 

//#if -96227905 
result.add(currentProject);
//#endif 

} 

//#endif 


//#if 942325695 
return result;
//#endif 

} 

//#endif 


//#if 367695734 
private void notifyProjectAdded(Project newProject, Project oldProject)
    { 

//#if 91425073 
firePropertyChanged(CURRENT_PROJECT_PROPERTY_NAME,
                            oldProject, newProject);
//#endif 


//#if 171743713 
firePropertyChanged(OPEN_PROJECTS_PROPERTY,
                            new Project[] {oldProject}, new Project[] {newProject});
//#endif 

} 

//#endif 


//#if 975398236 
public Project makeEmptyProject(final boolean addDefaultDiagrams)
    { 

//#if -1897263728 
final Command cmd = new NonUndoableCommand() {

            @Override
            public Object execute() {
                Model.getPump().stopPumpingEvents();

                creatingCurrentProject = true;




                Project newProject = new ProjectImpl();
                createDefaultModel(newProject);
                if (addDefaultDiagrams) {
                    createDefaultDiagrams(newProject);
                }
                creatingCurrentProject = false;
                setCurrentProject(newProject);
                Model.getPump().startPumpingEvents();
                return null;
            }
        };
//#endif 


//#if 1194534831 
final Command cmd = new NonUndoableCommand() {

            @Override
            public Object execute() {
                Model.getPump().stopPumpingEvents();

                creatingCurrentProject = true;


                LOG.info("making empty project");

                Project newProject = new ProjectImpl();
                createDefaultModel(newProject);
                if (addDefaultDiagrams) {
                    createDefaultDiagrams(newProject);
                }
                creatingCurrentProject = false;
                setCurrentProject(newProject);
                Model.getPump().startPumpingEvents();
                return null;
            }
        };
//#endif 


//#if 1599432192 
cmd.execute();
//#endif 


//#if 1280009825 
currentProject.getUndoManager().addCommand(cmd);
//#endif 


//#if 171208118 
setSaveEnabled(false);
//#endif 


//#if -312374588 
return currentProject;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

