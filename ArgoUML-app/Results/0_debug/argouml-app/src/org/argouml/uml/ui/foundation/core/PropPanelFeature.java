
//#if 784983768 
// Compilation Unit of /PropPanelFeature.java 
 

//#if 758669270 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1585913716 
import javax.swing.ImageIcon;
//#endif 


//#if 1643860892 
import javax.swing.JPanel;
//#endif 


//#if 476312715 
import org.argouml.i18n.Translator;
//#endif 


//#if 1557399114 
public abstract class PropPanelFeature extends 
//#if 1532892909 
PropPanelModelElement
//#endif 

  { 

//#if -694090219 
private UMLFeatureOwnerScopeCheckBox ownerScopeCheckbox;
//#endif 


//#if -343944079 
private JPanel ownerScroll;
//#endif 


//#if 1076313567 
private static UMLFeatureOwnerListModel ownerListModel;
//#endif 


//#if 1684066559 
private JPanel visibilityPanel;
//#endif 


//#if 1629946245 
public UMLFeatureOwnerScopeCheckBox getOwnerScopeCheckbox()
    { 

//#if -1764769937 
if(ownerScopeCheckbox == null)//1
{ 

//#if 2134687035 
ownerScopeCheckbox = new UMLFeatureOwnerScopeCheckBox();
//#endif 

} 

//#endif 


//#if 617786072 
return ownerScopeCheckbox;
//#endif 

} 

//#endif 


//#if -525991010 
protected JPanel getVisibilityPanel()
    { 

//#if 1384579257 
if(visibilityPanel == null)//1
{ 

//#if -1631687684 
visibilityPanel =
                new UMLModelElementVisibilityRadioButtonPanel(
                Translator.localize("label.visibility"), true);
//#endif 

} 

//#endif 


//#if -453116388 
return visibilityPanel;
//#endif 

} 

//#endif 


//#if -1103667872 
protected PropPanelFeature(String name, ImageIcon icon)
    { 

//#if 6649104 
super(name, icon);
//#endif 

} 

//#endif 


//#if -1868738667 
public JPanel getOwnerScroll()
    { 

//#if -610401742 
if(ownerScroll == null)//1
{ 

//#if -881846508 
if(ownerListModel == null)//1
{ 

//#if 1450516506 
ownerListModel = new UMLFeatureOwnerListModel();
//#endif 

} 

//#endif 


//#if 836458510 
ownerScroll = getSingleRowScroll(ownerListModel);
//#endif 

} 

//#endif 


//#if -1749442055 
return ownerScroll;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

