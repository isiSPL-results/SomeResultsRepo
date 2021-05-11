
//#if -523397915 
// Compilation Unit of /ActionStereotypeView.java 
 

//#if -1891261276 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -2087378299 
public abstract class ActionStereotypeView extends 
//#if 223231757 
AbstractActionRadioMenuItem
//#endif 

  { 

//#if 1419771498 
private FigNodeModelElement targetNode;
//#endif 


//#if -2013528555 
private int selectedStereotypeView;
//#endif 


//#if 1988687900 
public ActionStereotypeView(FigNodeModelElement node, String key,
                                int stereotypeView)
    { 

//#if -439414500 
super(key, false);
//#endif 


//#if 18932256 
this.targetNode = node;
//#endif 


//#if -932525366 
this.selectedStereotypeView = stereotypeView;
//#endif 


//#if -74444330 
updateSelection();
//#endif 

} 

//#endif 


//#if -404787659 
private void updateSelection()
    { 

//#if 572247137 
putValue("SELECTED", Boolean
                 .valueOf(targetNode.getStereotypeView()
                          == selectedStereotypeView));
//#endif 

} 

//#endif 


//#if -579968205 
void toggleValueOfTarget(Object t)
    { 

//#if 1903239127 
targetNode.setStereotypeView(selectedStereotypeView);
//#endif 


//#if 945840526 
updateSelection();
//#endif 

} 

//#endif 


//#if 283470154 
Object valueOfTarget(Object t)
    { 

//#if 262973133 
if(t instanceof FigNodeModelElement)//1
{ 

//#if 1218135296 
return Integer.valueOf(((FigNodeModelElement) t).getStereotypeView());
//#endif 

} 
else
{ 

//#if 962500890 
return t;
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

