// Compilation Unit of /PropPanelFeature.java 
 
package org.argouml.uml.ui.foundation.core;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.argouml.i18n.Translator;
public abstract class PropPanelFeature extends PropPanelModelElement
  { 
private UMLFeatureOwnerScopeCheckBox ownerScopeCheckbox;
private JPanel ownerScroll;
private static UMLFeatureOwnerListModel ownerListModel;
private JPanel visibilityPanel;
public UMLFeatureOwnerScopeCheckBox getOwnerScopeCheckbox()
    { 
if(ownerScopeCheckbox == null)//1
{ 
ownerScopeCheckbox = new UMLFeatureOwnerScopeCheckBox();
} 

return ownerScopeCheckbox;
} 

protected JPanel getVisibilityPanel()
    { 
if(visibilityPanel == null)//1
{ 
visibilityPanel =
                new UMLModelElementVisibilityRadioButtonPanel(
                Translator.localize("label.visibility"), true);
} 

return visibilityPanel;
} 

protected PropPanelFeature(String name, ImageIcon icon)
    { 
super(name, icon);
} 

public JPanel getOwnerScroll()
    { 
if(ownerScroll == null)//1
{ 
if(ownerListModel == null)//1
{ 
ownerListModel = new UMLFeatureOwnerListModel();
} 

ownerScroll = getSingleRowScroll(ownerListModel);
} 

return ownerScroll;
} 

 } 


