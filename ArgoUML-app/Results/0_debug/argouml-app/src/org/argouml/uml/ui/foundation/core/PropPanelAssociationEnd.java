
//#if 816658188 
// Compilation Unit of /PropPanelAssociationEnd.java 
 

//#if 1271846451 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1359416745 
import javax.swing.ImageIcon;
//#endif 


//#if 1574468368 
import javax.swing.JCheckBox;
//#endif 


//#if -625601386 
import javax.swing.JComboBox;
//#endif 


//#if -1709145185 
import javax.swing.JPanel;
//#endif 


//#if -1285755106 
import javax.swing.JScrollPane;
//#endif 


//#if -537847832 
import org.argouml.i18n.Translator;
//#endif 


//#if -852634166 
import org.argouml.uml.ui.ActionNavigateAssociation;
//#endif 


//#if 1868771678 
import org.argouml.uml.ui.ActionNavigateOppositeAssocEnd;
//#endif 


//#if 675622705 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -990592167 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if -848745247 
import org.argouml.uml.ui.UMLMultiplicityPanel;
//#endif 


//#if 720200073 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -1525391435 
import org.argouml.uml.ui.UMLSingleRowSelector;
//#endif 


//#if 1800847457 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 1335915009 
public class PropPanelAssociationEnd extends 
//#if -1199113100 
PropPanelModelElement
//#endif 

  { 

//#if 921742389 
private static final long serialVersionUID = 9119453587506578751L;
//#endif 


//#if 23753504 
private JComboBox typeCombobox;
//#endif 


//#if -203143382 
private JPanel associationScroll;
//#endif 


//#if -707472693 
private UMLMultiplicityPanel multiplicityComboBox;
//#endif 


//#if -1388874043 
private JCheckBox navigabilityCheckBox;
//#endif 


//#if 1952114906 
private JCheckBox orderingCheckBox;
//#endif 


//#if -641391137 
private JCheckBox targetScopeCheckBox;
//#endif 


//#if -773325601 
private JPanel aggregationRadioButtonpanel;
//#endif 


//#if 1234360327 
private JPanel changeabilityRadioButtonpanel;
//#endif 


//#if -185691147 
private JPanel visibilityRadioButtonPanel;
//#endif 


//#if -617127193 
private JScrollPane specificationScroll;
//#endif 


//#if -844815127 
private JScrollPane qualifiersScroll;
//#endif 


//#if -55976780 
private String associationLabel;
//#endif 


//#if -1428562637 
public PropPanelAssociationEnd()
    { 

//#if -13732056 
super("label.association-end", lookupIcon("AssociationEnd"));
//#endif 


//#if -695274920 
associationLabel = Translator.localize("label.association");
//#endif 


//#if -561169366 
createControls();
//#endif 


//#if -87442080 
positionStandardControls();
//#endif 


//#if -1322228387 
positionControls();
//#endif 

} 

//#endif 


//#if 1845061535 
protected void positionStandardControls()
    { 

//#if 812324901 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 

} 

//#endif 


//#if 16064059 
protected void setAssociationLabel(String label)
    { 

//#if 577658566 
associationLabel = label;
//#endif 

} 

//#endif 


//#if -2118375215 
protected PropPanelAssociationEnd(String name, ImageIcon icon)
    { 

//#if 1897326971 
super(name, icon);
//#endif 

} 

//#endif 


//#if 1717554923 
protected JPanel getMultiplicityComboBox()
    { 

//#if -2131615069 
if(multiplicityComboBox == null)//1
{ 

//#if 1511001123 
multiplicityComboBox = new UMLMultiplicityPanel();
//#endif 

} 

//#endif 


//#if -1338540196 
return multiplicityComboBox;
//#endif 

} 

//#endif 


//#if -99314539 
protected void createControls()
    { 

//#if -554106129 
typeCombobox = new UMLComboBox2(
            new UMLAssociationEndTypeComboBoxModel(),
            ActionSetAssociationEndType.getInstance(), true);
//#endif 


//#if 1576720440 
associationScroll = new UMLSingleRowSelector(
            new UMLAssociationEndAssociationListModel());
//#endif 


//#if -1808430552 
navigabilityCheckBox = new UMLAssociationEndNavigableCheckBox();
//#endif 


//#if 1082392322 
orderingCheckBox = new UMLAssociationEndOrderingCheckBox();
//#endif 


//#if -2057474452 
targetScopeCheckBox = new UMLAssociationEndTargetScopeCheckbox();
//#endif 


//#if -10984540 
aggregationRadioButtonpanel =
            new UMLAssociationEndAggregationRadioButtonPanel(
            "label.aggregation", true);
//#endif 


//#if 1144293132 
changeabilityRadioButtonpanel =
            new UMLAssociationEndChangeabilityRadioButtonPanel(
            "label.changeability", true);
//#endif 


//#if -2068796767 
visibilityRadioButtonPanel =
            new UMLModelElementVisibilityRadioButtonPanel(
            "label.visibility", true);
//#endif 


//#if -430438657 
specificationScroll = new JScrollPane(new UMLMutableLinkedList(
                new UMLAssociationEndSpecificationListModel(),
                ActionAddAssociationSpecification.getInstance(),
                null, null, true));
//#endif 


//#if 1304607566 
qualifiersScroll = new JScrollPane(new UMLLinkedList(
                                               new UMLAssociationEndQualifiersListModel()));
//#endif 

} 

//#endif 


//#if -224071678 
protected void positionControls()
    { 

//#if 264431936 
addField(associationLabel, associationScroll);
//#endif 


//#if 1520872304 
addField("label.type", typeCombobox);
//#endif 


//#if -2031294855 
addField("label.multiplicity",
                 getMultiplicityComboBox());
//#endif 


//#if 1718808896 
addSeparator();
//#endif 


//#if 460511391 
JPanel panel = createBorderPanel("label.modifiers");
//#endif 


//#if 835404197 
panel.add(navigabilityCheckBox);
//#endif 


//#if -1021413200 
panel.add(orderingCheckBox);
//#endif 


//#if 236586673 
panel.add(targetScopeCheckBox);
//#endif 


//#if 1275311608 
panel.setVisible(true);
//#endif 


//#if -2069182119 
add(panel);
//#endif 


//#if 557353368 
addField("label.specification",
                 specificationScroll);
//#endif 


//#if 819802270 
addField("label.qualifiers",
                 qualifiersScroll);
//#endif 


//#if 435764498 
addSeparator();
//#endif 


//#if 2012156910 
add(aggregationRadioButtonpanel);
//#endif 


//#if 496854470 
add(changeabilityRadioButtonpanel);
//#endif 


//#if -1177414184 
add(visibilityRadioButtonPanel);
//#endif 


//#if -1894772140 
addAction(new ActionNavigateAssociation());
//#endif 


//#if 731275168 
addAction(new ActionNavigateOppositeAssocEnd());
//#endif 


//#if -615153072 
addAction(new ActionAddAttribute(),
                  Translator.localize("button.new-qualifier"));
//#endif 


//#if 63020214 
addAction(new ActionNewStereotype());
//#endif 


//#if 907304547 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

