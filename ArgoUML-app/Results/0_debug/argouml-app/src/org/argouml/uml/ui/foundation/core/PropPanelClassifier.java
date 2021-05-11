
//#if -1466440690 
// Compilation Unit of /PropPanelClassifier.java 
 

//#if 2029143691 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 582973441 
import javax.swing.ImageIcon;
//#endif 


//#if -1559234489 
import javax.swing.JPanel;
//#endif 


//#if -123460746 
import javax.swing.JScrollPane;
//#endif 


//#if 190210112 
import org.argouml.i18n.Translator;
//#endif 


//#if 1757529983 
import org.argouml.uml.ui.ScrollList;
//#endif 


//#if -345019330 
import org.argouml.uml.ui.UMLDerivedCheckBox;
//#endif 


//#if -688244797 
import org.argouml.uml.ui.behavior.common_behavior.ActionNewReception;
//#endif 


//#if -1854314622 
public abstract class PropPanelClassifier extends 
//#if 918814061 
PropPanelNamespace
//#endif 

  { 

//#if 94880041 
private JPanel modifiersPanel;
//#endif 


//#if 1511887320 
private ActionNewReception actionNewReception = new ActionNewReception();
//#endif 


//#if 1032967843 
private JScrollPane generalizationScroll;
//#endif 


//#if 781683892 
private JScrollPane specializationScroll;
//#endif 


//#if 1169280679 
private JScrollPane featureScroll;
//#endif 


//#if -1230882227 
private JScrollPane createActionScroll;
//#endif 


//#if -1437689791 
private JScrollPane powerTypeRangeScroll;
//#endif 


//#if -1814763835 
private JScrollPane associationEndScroll;
//#endif 


//#if 1836234881 
private JScrollPane attributeScroll;
//#endif 


//#if -1465195690 
private JScrollPane operationScroll;
//#endif 


//#if -1605366906 
private static UMLGeneralizableElementGeneralizationListModel
    generalizationListModel =
        new UMLGeneralizableElementGeneralizationListModel();
//#endif 


//#if -1591361739 
private static UMLGeneralizableElementSpecializationListModel
    specializationListModel =
        new UMLGeneralizableElementSpecializationListModel();
//#endif 


//#if 1647459316 
private static UMLClassifierFeatureListModel featureListModel =
        new UMLClassifierFeatureListModel();
//#endif 


//#if -1399307492 
private static UMLClassifierCreateActionListModel createActionListModel =
        new UMLClassifierCreateActionListModel();
//#endif 


//#if -1758055800 
private static UMLClassifierPowertypeRangeListModel
    powertypeRangeListModel =
        new UMLClassifierPowertypeRangeListModel();
//#endif 


//#if -2142990620 
private static UMLClassifierAssociationEndListModel
    associationEndListModel =
        new UMLClassifierAssociationEndListModel();
//#endif 


//#if 1516484612 
private static UMLClassAttributeListModel attributeListModel =
        new UMLClassAttributeListModel();
//#endif 


//#if 1581119397 
private static UMLClassOperationListModel operationListModel =
        new UMLClassOperationListModel();
//#endif 


//#if 555558065 
public JScrollPane getFeatureScroll()
    { 

//#if 2110854860 
if(featureScroll == null)//1
{ 

//#if 1632177736 
featureScroll = new ScrollList(featureListModel, true, false);
//#endif 

} 

//#endif 


//#if 767931693 
return featureScroll;
//#endif 

} 

//#endif 


//#if -1971779108 
protected ActionNewReception getActionNewReception()
    { 

//#if 119909287 
return actionNewReception;
//#endif 

} 

//#endif 


//#if 548650775 
public JScrollPane getAttributeScroll()
    { 

//#if 1926165498 
if(attributeScroll == null)//1
{ 

//#if -12245348 
attributeScroll = new ScrollList(attributeListModel, true, false);
//#endif 

} 

//#endif 


//#if 2000817039 
return attributeScroll;
//#endif 

} 

//#endif 


//#if 1283518178 
public JScrollPane getOperationScroll()
    { 

//#if -1288258166 
if(operationScroll == null)//1
{ 

//#if 1690154674 
operationScroll = new ScrollList(operationListModel, true, false);
//#endif 

} 

//#endif 


//#if -1151597847 
return operationScroll;
//#endif 

} 

//#endif 


//#if 1430729597 
public JScrollPane getGeneralizationScroll()
    { 

//#if -1234266691 
if(generalizationScroll == null)//1
{ 

//#if 529090205 
generalizationScroll = new ScrollList(generalizationListModel);
//#endif 

} 

//#endif 


//#if 864065852 
return generalizationScroll;
//#endif 

} 

//#endif 


//#if 1100746805 
private void initialize()
    { 

//#if -1084448959 
modifiersPanel =
            createBorderPanel(Translator.localize("label.modifiers"));
//#endif 


//#if -1021691234 
modifiersPanel.add(new UMLGeneralizableElementAbstractCheckBox());
//#endif 


//#if 844202714 
modifiersPanel.add(new UMLGeneralizableElementLeafCheckBox());
//#endif 


//#if 1671052894 
modifiersPanel.add(new UMLGeneralizableElementRootCheckBox());
//#endif 


//#if -1937158762 
modifiersPanel.add(new UMLDerivedCheckBox());
//#endif 

} 

//#endif 


//#if 1288274762 
public PropPanelClassifier(String name, ImageIcon icon)
    { 

//#if -223208064 
super(name, icon);
//#endif 


//#if 2105404491 
initialize();
//#endif 

} 

//#endif 


//#if 662171155 
public JScrollPane getCreateActionScroll()
    { 

//#if 473708050 
if(createActionScroll == null)//1
{ 

//#if 1351287466 
createActionScroll = new ScrollList(createActionListModel);
//#endif 

} 

//#endif 


//#if 2119297445 
return createActionScroll;
//#endif 

} 

//#endif 


//#if -949606501 
public JScrollPane getAssociationEndScroll()
    { 

//#if 137982274 
if(associationEndScroll == null)//1
{ 

//#if 255015236 
associationEndScroll = new ScrollList(associationEndListModel);
//#endif 

} 

//#endif 


//#if 1869899781 
return associationEndScroll;
//#endif 

} 

//#endif 


//#if -2145213025 
public JScrollPane getPowerTypeRangeScroll()
    { 

//#if -1031788743 
if(powerTypeRangeScroll == null)//1
{ 

//#if -302504618 
powerTypeRangeScroll = new ScrollList(powertypeRangeListModel);
//#endif 

} 

//#endif 


//#if 1434535860 
return powerTypeRangeScroll;
//#endif 

} 

//#endif 


//#if -151162710 
protected JPanel getModifiersPanel()
    { 

//#if -491519660 
return modifiersPanel;
//#endif 

} 

//#endif 


//#if -2064105588 
public JScrollPane getSpecializationScroll()
    { 

//#if -1652573735 
if(specializationScroll == null)//1
{ 

//#if 296813145 
specializationScroll = new ScrollList(specializationListModel);
//#endif 

} 

//#endif 


//#if 1614640154 
return specializationScroll;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

