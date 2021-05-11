// Compilation Unit of /ProjectManager.java 
 
package org.argouml.kernel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Action;
import javax.swing.event.EventListenerList;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.model.ModelCommand;
import org.argouml.model.ModelCommandCreationObserver;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramFactory;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Designer;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.ProjectMemberTodoList;
//#endif 

public final class ProjectManager implements ModelCommandCreationObserver
  { 
@Deprecated
    public static final String CURRENT_PROJECT_PROPERTY_NAME = "currentProject";
public static final String OPEN_PROJECTS_PROPERTY = "openProjects";
private static ProjectManager instance = new ProjectManager();
private static Project currentProject;
private static LinkedList<Project> openProjects = new LinkedList<Project>();
private boolean creatingCurrentProject;
private Action saveAction;
private EventListenerList listenerList = new EventListenerList();
private PropertyChangeEvent event;

//#if LOGGING 
private static final Logger LOG = Logger.getLogger(ProjectManager.class);
//#endif 

public Project getCurrentProject()
    { 
if(currentProject == null && !creatingCurrentProject)//1
{ 
makeEmptyProject();
} 

return currentProject;
} 

private void createDefaultModel(Project project)
    { 
Object model = Model.getModelManagementFactory().createModel();
Model.getCoreHelper().setName(model,
                                      Translator.localize("misc.untitled-model"));
Collection roots = new ArrayList();
roots.add(model);
project.setRoots(roots);
project.setCurrentNamespace(model);
project.addMember(model);
} 

public void removeProject(Project oldProject)
    { 
openProjects.remove(oldProject);
if(currentProject == oldProject)//1
{ 
if(openProjects.size() > 0)//1
{ 
currentProject = openProjects.getLast();
} 
else
{ 
currentProject = null;
} 

} 

oldProject.remove();
} 

public void setSaveAction(Action save)
    { 
this.saveAction = save;

//#if COGNITIVE 
Designer.setSaveAction(save);
//#endif 

} 

void firePropertyChanged(String propertyName,
                             Object oldValue, Object newValue)
    { 
Object[] listeners = listenerList.getListenerList();
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
if(listeners[i] == PropertyChangeListener.class)//1
{ 
if(event == null)//1
{ 
event =
                        new PropertyChangeEvent(
                        this,
                        propertyName,
                        oldValue,
                        newValue);
} 

((PropertyChangeListener) listeners[i + 1]).propertyChange(
                    event);
} 

} 

event = null;
} 

public void removePropertyChangeListener(PropertyChangeListener listener)
    { 
listenerList.remove(PropertyChangeListener.class, listener);
} 

public static ProjectManager getManager()
    { 
return instance;
} 

public Object execute(final ModelCommand command)
    { 
setSaveEnabled(true);
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
Project p = getCurrentProject();
if(p != null)//1
{ 
return getCurrentProject().getUndoManager().execute(wrappedCommand);
} 
else
{ 
return wrappedCommand.execute();
} 

} 

private void addProject(Project newProject)
    { 
openProjects.addLast(newProject);
} 

public Project makeEmptyProject()
    { 
return makeEmptyProject(true);
} 

private ProjectManager()
    { 
super();
Model.setModelCommandCreationObserver(this);
} 

public void setSaveEnabled(boolean newValue)
    { 
if(saveAction != null)//1
{ 
saveAction.setEnabled(newValue);
} 

} 

private void createDefaultDiagrams(Project project)
    { 
Object model = project.getRoots().iterator().next();
DiagramFactory df = DiagramFactory.getInstance();
ArgoDiagram d = df.create(DiagramFactory.DiagramType.Class,
                                  model,
                                  project.getProjectSettings().getDefaultDiagramSettings());
project.addMember(d);

//#if USECASE 
project.addMember(df.create(
                              DiagramFactory.DiagramType.UseCase, model,
                              project.getProjectSettings().getDefaultDiagramSettings()));
//#endif 


//#if COGNITIVE 
project.addMember(new ProjectMemberTodoList("",
                          project));
//#endif 

project.setActiveDiagram(d);
} 

public void addPropertyChangeListener(PropertyChangeListener listener)
    { 
listenerList.add(PropertyChangeListener.class, listener);
} 

public boolean isSaveActionEnabled()
    { 
return this.saveAction.isEnabled();
} 

public void setCurrentProject(Project newProject)
    { 
Project oldProject = currentProject;
currentProject = newProject;
addProject(newProject);
if(currentProject != null
                && currentProject.getActiveDiagram() == null)//1
{ 
List<ArgoDiagram> diagrams = currentProject.getDiagramList();
if(diagrams != null && !diagrams.isEmpty())//1
{ 
ArgoDiagram activeDiagram = diagrams.get(0);
currentProject.setActiveDiagram(activeDiagram);
} 

} 

notifyProjectAdded(newProject, oldProject);
} 

public List<Project> getOpenProjects()
    { 
List<Project> result = new ArrayList<Project>();
if(currentProject != null)//1
{ 
result.add(currentProject);
} 

return result;
} 

private void notifyProjectAdded(Project newProject, Project oldProject)
    { 
firePropertyChanged(CURRENT_PROJECT_PROPERTY_NAME,
                            oldProject, newProject);
firePropertyChanged(OPEN_PROJECTS_PROPERTY,
                            new Project[] {oldProject}, new Project[] {newProject});
} 

public Project makeEmptyProject(final boolean addDefaultDiagrams)
    { 

//#if (CLASS || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) && ! LOGGING  
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


//#if LOGGING 
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

cmd.execute();
currentProject.getUndoManager().addCommand(cmd);
setSaveEnabled(false);
return currentProject;
} 

 } 


