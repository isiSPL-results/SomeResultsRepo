// Compilation Unit of /UMLSequenceDiagram.java 
 
package org.argouml.uml.diagram.sequence.ui;
import java.beans.PropertyVetoException;
import java.util.Collection;
import java.util.Hashtable;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.diagram.sequence.SequenceDiagramGraphModel;
import org.argouml.uml.diagram.ui.ActionSetAddMessageMode;
import org.argouml.uml.diagram.ui.ActionSetMode;
import org.argouml.uml.diagram.ui.RadioAction;
import org.argouml.uml.diagram.ui.UMLDiagram;
import org.tigris.gef.presentation.FigNode;
public class UMLSequenceDiagram extends UMLDiagram
  { 
private static final long serialVersionUID = 4143700589122465301L;
private Object[] actions;
static final String SEQUENCE_CONTRACT_BUTTON = "button.sequence-contract";
static final String SEQUENCE_EXPAND_BUTTON = "button.sequence-expand";
public UMLSequenceDiagram(Object collaboration)
    { 
this();
try //1
{ 
setName(getNewDiagramName());
} 
catch (PropertyVetoException pve) //1
{ 
} 


((SequenceDiagramGraphModel) getGraphModel())
        .setCollaboration(collaboration);
setNamespace(collaboration);
} 

@Override
    public boolean relocate(Object base)
    { 
((SequenceDiagramGraphModel) getGraphModel())
        .setCollaboration(base);
setNamespace(base);
damage();
return true;
} 

@Override
    public boolean isRelocationAllowed(Object base)
    { 
return Model.getFacade().isACollaboration(base);
} 

@Override
    public String getLabelName()
    { 
return Translator.localize("label.sequence-diagram");
} 

@Override
    public Object getNamespace()
    { 
return ((SequenceDiagramGraphModel) getGraphModel()).getCollaboration();
} 

public UMLSequenceDiagram()
    { 
super();
SequenceDiagramGraphModel gm =
            new SequenceDiagramGraphModel();
setGraphModel(gm);
SequenceDiagramLayer lay =
            new SequenceDiagramLayer(this.getName(), gm);
SequenceDiagramRenderer rend = new SequenceDiagramRenderer();
lay.setGraphEdgeRenderer(rend);
lay.setGraphNodeRenderer(rend);
setLayer(lay);
} 

public void encloserChanged(FigNode enclosed,
                                FigNode oldEncloser, FigNode newEncloser)
    { 
} 

@SuppressWarnings("unchecked")

    public Collection getRelocationCandidates(Object root)
    { 
return
            Model.getModelManagementHelper().getAllModelElementsOfKindWithModel(
                root, Model.getMetaTypes().getCollaboration());
} 

@Override
    public void setNamespace(Object ns)
    { 
((SequenceDiagramGraphModel) getGraphModel()).setCollaboration(ns);
super.setNamespace(ns);
} 

@Override
    public Object getOwner()
    { 
return getNamespace();
} 

public void cleanUp()
    { 
} 

protected Object[] getUmlActions()
    { 
if(actions == null)//1
{ 
actions = new Object[7];
actions[0] = new RadioAction(new ActionAddClassifierRole());
actions[1] = new RadioAction(new ActionSetAddMessageMode(
                                             Model.getMetaTypes().getCallAction(),
                                             "button.new-callaction"));
actions[2] = new RadioAction(new ActionSetAddMessageMode(
                                             Model.getMetaTypes().getReturnAction(),
                                             "button.new-returnaction"));
actions[3] = new RadioAction(new ActionSetAddMessageMode(
                                             Model.getMetaTypes().getCreateAction(),
                                             "button.new-createaction"));
actions[4] = new RadioAction(new ActionSetAddMessageMode(
                                             Model.getMetaTypes().getDestroyAction(),
                                             "button.new-destroyaction"));
Hashtable<String, Object> args = new Hashtable<String, Object>();
args.put("name", SEQUENCE_EXPAND_BUTTON);
actions[5] =
                new RadioAction(new ActionSetMode(ModeExpand.class,
                                                  args,
                                                  SEQUENCE_EXPAND_BUTTON));
args.clear();
args.put("name", SEQUENCE_CONTRACT_BUTTON);
actions[6] =
                new RadioAction(new ActionSetMode(ModeContract.class,
                                                  args,
                                                  SEQUENCE_CONTRACT_BUTTON));
} 

return actions;
} 

 } 


