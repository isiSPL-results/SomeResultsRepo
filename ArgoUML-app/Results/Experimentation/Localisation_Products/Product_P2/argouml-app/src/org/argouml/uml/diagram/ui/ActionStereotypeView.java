package org.argouml.uml.diagram.ui;
public abstract class ActionStereotypeView extends AbstractActionRadioMenuItem
  { 
private FigNodeModelElement targetNode;
private int selectedStereotypeView;
public ActionStereotypeView(FigNodeModelElement node, String key,
                                int stereotypeView)
    { 
super(key, false);
this.targetNode = node;
this.selectedStereotypeView = stereotypeView;
updateSelection();
} 
private void updateSelection()
    { 
putValue("SELECTED", Boolean
                 .valueOf(targetNode.getStereotypeView()
                          == selectedStereotypeView));
} 
void toggleValueOfTarget(Object t)
    { 
targetNode.setStereotypeView(selectedStereotypeView);
updateSelection();
} 
Object valueOfTarget(Object t)
    { 
if(t instanceof FigNodeModelElement)//1
{ 
return Integer.valueOf(((FigNodeModelElement) t).getStereotypeView());
} 
else
{ 
return t;
} 
} 

 } 
