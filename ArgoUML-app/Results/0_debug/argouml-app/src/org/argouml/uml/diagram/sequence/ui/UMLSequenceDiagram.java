
//#if 1080438896 
// Compilation Unit of /UMLSequenceDiagram.java 
 

//#if -1346625601 
package org.argouml.uml.diagram.sequence.ui;
//#endif 


//#if -1890123670 
import java.beans.PropertyVetoException;
//#endif 


//#if 1506291717 
import java.util.Collection;
//#endif 


//#if -358449901 
import java.util.Hashtable;
//#endif 


//#if -586158074 
import org.argouml.i18n.Translator;
//#endif 


//#if 434482636 
import org.argouml.model.Model;
//#endif 


//#if -1698516111 
import org.argouml.uml.diagram.sequence.SequenceDiagramGraphModel;
//#endif 


//#if -1150280746 
import org.argouml.uml.diagram.ui.ActionSetAddMessageMode;
//#endif 


//#if 1741154652 
import org.argouml.uml.diagram.ui.ActionSetMode;
//#endif 


//#if -1512742502 
import org.argouml.uml.diagram.ui.RadioAction;
//#endif 


//#if -1111368852 
import org.argouml.uml.diagram.ui.UMLDiagram;
//#endif 


//#if -636126751 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -2005645030 
public class UMLSequenceDiagram extends 
//#if -1464085915 
UMLDiagram
//#endif 

  { 

//#if 1256425628 
private static final long serialVersionUID = 4143700589122465301L;
//#endif 


//#if -615750340 
private Object[] actions;
//#endif 


//#if 928697044 
static final String SEQUENCE_CONTRACT_BUTTON = "button.sequence-contract";
//#endif 


//#if 92298580 
static final String SEQUENCE_EXPAND_BUTTON = "button.sequence-expand";
//#endif 


//#if 34047710 
public UMLSequenceDiagram(Object collaboration)
    { 

//#if -650330276 
this();
//#endif 


//#if 958499670 
try //1
{ 

//#if 163221285 
setName(getNewDiagramName());
//#endif 

} 

//#if -1000132357 
catch (PropertyVetoException pve) //1
{ 
} 

//#endif 


//#endif 


//#if 258672077 
((SequenceDiagramGraphModel) getGraphModel())
        .setCollaboration(collaboration);
//#endif 


//#if -989307192 
setNamespace(collaboration);
//#endif 

} 

//#endif 


//#if -1768208273 
@Override
    public boolean relocate(Object base)
    { 

//#if -1058270949 
((SequenceDiagramGraphModel) getGraphModel())
        .setCollaboration(base);
//#endif 


//#if -296424284 
setNamespace(base);
//#endif 


//#if -1944150019 
damage();
//#endif 


//#if 2040914735 
return true;
//#endif 

} 

//#endif 


//#if -1889971474 
@Override
    public boolean isRelocationAllowed(Object base)
    { 

//#if 488747046 
return Model.getFacade().isACollaboration(base);
//#endif 

} 

//#endif 


//#if 891323658 
@Override
    public String getLabelName()
    { 

//#if 464730867 
return Translator.localize("label.sequence-diagram");
//#endif 

} 

//#endif 


//#if -850550156 
@Override
    public Object getNamespace()
    { 

//#if 183046083 
return ((SequenceDiagramGraphModel) getGraphModel()).getCollaboration();
//#endif 

} 

//#endif 


//#if -614420274 
public UMLSequenceDiagram()
    { 

//#if 2131801497 
super();
//#endif 


//#if -85680695 
SequenceDiagramGraphModel gm =
            new SequenceDiagramGraphModel();
//#endif 


//#if -386483843 
setGraphModel(gm);
//#endif 


//#if -1333175785 
SequenceDiagramLayer lay =
            new SequenceDiagramLayer(this.getName(), gm);
//#endif 


//#if -2085374580 
SequenceDiagramRenderer rend = new SequenceDiagramRenderer();
//#endif 


//#if -1838293293 
lay.setGraphEdgeRenderer(rend);
//#endif 


//#if 1303538670 
lay.setGraphNodeRenderer(rend);
//#endif 


//#if -1238066793 
setLayer(lay);
//#endif 

} 

//#endif 


//#if -2039686033 
public void encloserChanged(FigNode enclosed,
                                FigNode oldEncloser, FigNode newEncloser)
    { 
} 

//#endif 


//#if 860505281 

//#if 1029065490 
@SuppressWarnings("unchecked")
//#endif 


    public Collection getRelocationCandidates(Object root)
    { 

//#if -585127078 
return
            Model.getModelManagementHelper().getAllModelElementsOfKindWithModel(
                root, Model.getMetaTypes().getCollaboration());
//#endif 

} 

//#endif 


//#if -2101346759 
@Override
    public void setNamespace(Object ns)
    { 

//#if 1768233150 
((SequenceDiagramGraphModel) getGraphModel()).setCollaboration(ns);
//#endif 


//#if 445446486 
super.setNamespace(ns);
//#endif 

} 

//#endif 


//#if -1052281396 
@Override
    public Object getOwner()
    { 

//#if 220904250 
return getNamespace();
//#endif 

} 

//#endif 


//#if -1719809598 
public void cleanUp()
    { 
} 

//#endif 


//#if 1270833815 
protected Object[] getUmlActions()
    { 

//#if -997448286 
if(actions == null)//1
{ 

//#if 584018820 
actions = new Object[7];
//#endif 


//#if -685228849 
actions[0] = new RadioAction(new ActionAddClassifierRole());
//#endif 


//#if -1151746619 
actions[1] = new RadioAction(new ActionSetAddMessageMode(
                                             Model.getMetaTypes().getCallAction(),
                                             "button.new-callaction"));
//#endif 


//#if 517550052 
actions[2] = new RadioAction(new ActionSetAddMessageMode(
                                             Model.getMetaTypes().getReturnAction(),
                                             "button.new-returnaction"));
//#endif 


//#if -2041923005 
actions[3] = new RadioAction(new ActionSetAddMessageMode(
                                             Model.getMetaTypes().getCreateAction(),
                                             "button.new-createaction"));
//#endif 


//#if -119183586 
actions[4] = new RadioAction(new ActionSetAddMessageMode(
                                             Model.getMetaTypes().getDestroyAction(),
                                             "button.new-destroyaction"));
//#endif 


//#if -360627867 
Hashtable<String, Object> args = new Hashtable<String, Object>();
//#endif 


//#if -2073953427 
args.put("name", SEQUENCE_EXPAND_BUTTON);
//#endif 


//#if -1960206092 
actions[5] =
                new RadioAction(new ActionSetMode(ModeExpand.class,
                                                  args,
                                                  SEQUENCE_EXPAND_BUTTON));
//#endif 


//#if -1688649719 
args.clear();
//#endif 


//#if -1243299083 
args.put("name", SEQUENCE_CONTRACT_BUTTON);
//#endif 


//#if -2039694253 
actions[6] =
                new RadioAction(new ActionSetMode(ModeContract.class,
                                                  args,
                                                  SEQUENCE_CONTRACT_BUTTON));
//#endif 

} 

//#endif 


//#if 1367838159 
return actions;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

