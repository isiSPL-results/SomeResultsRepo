
//#if -147838984 
// Compilation Unit of /UMLModelElementStereotypeListModel.java 
 

//#if 524027197 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -250866599 
import javax.swing.Action;
//#endif 


//#if -2111310986 
import javax.swing.Icon;
//#endif 


//#if -1753081432 
import javax.swing.JCheckBoxMenuItem;
//#endif 


//#if -131235058 
import javax.swing.JPopupMenu;
//#endif 


//#if -2026863106 
import javax.swing.SwingConstants;
//#endif 


//#if 663618744 
import org.argouml.model.Model;
//#endif 


//#if 1804636124 
import org.argouml.uml.StereotypeUtility;
//#endif 


//#if -1117218196 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -2014882206 
public class UMLModelElementStereotypeListModel extends 
//#if -898709158 
UMLModelElementListModel2
//#endif 

  { 

//#if -1096710456 
protected void buildModelList()
    { 

//#if -1725514701 
removeAllElements();
//#endif 


//#if 1999013479 
if(Model.getFacade().isAModelElement(getTarget()))//1
{ 

//#if -268097181 
addAll(Model.getFacade().getStereotypes(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 225823039 
private static JCheckBoxMenuItem getCheckItem(Action a)
    { 

//#if 721767258 
String name = (String) a.getValue(Action.NAME);
//#endif 


//#if 149095586 
Icon icon = (Icon) a.getValue(Action.SMALL_ICON);
//#endif 


//#if -1876682572 
Boolean selected = (Boolean) a.getValue("SELECTED");
//#endif 


//#if -1252863813 
JCheckBoxMenuItem mi =
            new JCheckBoxMenuItem(name, icon,
                                  (selected == null
                                   || selected.booleanValue()));
//#endif 


//#if -455598813 
mi.setHorizontalTextPosition(SwingConstants.RIGHT);
//#endif 


//#if 1742743364 
mi.setVerticalTextPosition(SwingConstants.CENTER);
//#endif 


//#if 1088778778 
mi.setEnabled(a.isEnabled());
//#endif 


//#if -861848432 
mi.addActionListener(a);
//#endif 


//#if 1144397763 
return mi;
//#endif 

} 

//#endif 


//#if 887884016 
public UMLModelElementStereotypeListModel()
    { 

//#if 1030427982 
super("stereotype");
//#endif 

} 

//#endif 


//#if 2071836582 
public boolean buildPopup(JPopupMenu popup, int index)
    { 

//#if -1387267075 
Action[] stereoActions =
            StereotypeUtility.getApplyStereotypeActions(getTarget());
//#endif 


//#if -489570135 
if(stereoActions != null)//1
{ 

//#if 1148951797 
for (int i = 0; i < stereoActions.length; ++i) //1
{ 

//#if 1127157182 
popup.add(getCheckItem(stereoActions[i]));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1037162119 
return true;
//#endif 

} 

//#endif 


//#if 1895030524 
protected boolean isValidElement(Object element)
    { 

//#if 1023165838 
return Model.getFacade().isAStereotype(element);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

