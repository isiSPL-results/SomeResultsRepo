
//#if 646414208 
// Compilation Unit of /PropPanelMethod.java 
 

//#if -308874919 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1589299129 
import java.awt.event.ActionEvent;
//#endif 


//#if 860519613 
import javax.swing.Action;
//#endif 


//#if -303243335 
import javax.swing.JPanel;
//#endif 


//#if 155718468 
import javax.swing.JScrollPane;
//#endif 


//#if 1352011617 
import org.apache.log4j.Logger;
//#endif 


//#if 1170323726 
import org.argouml.i18n.Translator;
//#endif 


//#if -637998965 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if -1095419180 
import org.argouml.model.Model;
//#endif 


//#if 848600387 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if -2100521458 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1817249010 
import org.argouml.uml.ui.ActionNavigateOwner;
//#endif 


//#if 83152215 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if 1278076100 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if 80991730 
import org.argouml.uml.ui.UMLComboBoxNavigator;
//#endif 


//#if 1244504876 
import org.argouml.uml.ui.UMLExpressionBodyField;
//#endif 


//#if 1740701666 
import org.argouml.uml.ui.UMLExpressionLanguageField;
//#endif 


//#if 2005965673 
import org.argouml.uml.ui.UMLExpressionModel2;
//#endif 


//#if -2135426345 
import org.argouml.uml.ui.UMLUserInterfaceContainer;
//#endif 


//#if -2131474467 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 2009513334 
class UMLMethodProcedureExpressionModel extends 
//#if 907827281 
UMLExpressionModel2
//#endif 

  { 

//#if -2035062239 
private static final Logger LOG =
        Logger.getLogger(UMLMethodProcedureExpressionModel.class);
//#endif 


//#if -1245469533 
public Object getExpression()
    { 

//#if -1799360859 
return Model.getFacade().getBody(
                   TargetManager.getInstance().getTarget());
//#endif 

} 

//#endif 


//#if 100864835 
public void setExpression(Object expression)
    { 

//#if 1903228450 
Object target = TargetManager.getInstance().getTarget();
//#endif 


//#if 22009337 
if(target == null)//1
{ 

//#if -1258861220 
throw new IllegalStateException("There is no target for "
                                            + getContainer());
//#endif 

} 

//#endif 


//#if -1207395488 
Model.getCoreHelper().setBody(target, expression);
//#endif 

} 

//#endif 


//#if -162750483 
public Object newExpression()
    { 

//#if 1195663634 
LOG.debug("new empty procedure expression");
//#endif 


//#if 97803725 
return Model.getDataTypesFactory().createProcedureExpression("", "");
//#endif 

} 

//#endif 


//#if 485354280 
public UMLMethodProcedureExpressionModel(
        UMLUserInterfaceContainer container,
        String propertyName)
    { 

//#if -828990258 
super(container, propertyName);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1164482450 
public class PropPanelMethod extends 
//#if -289448287 
PropPanelFeature
//#endif 

  { 

//#if -235186893 
private UMLComboBox2 specificationComboBox;
//#endif 


//#if -1715567559 
private static UMLMethodSpecificationComboBoxModel
    specificationComboBoxModel;
//#endif 


//#if -2072626687 
public UMLComboBox2 getSpecificationComboBox()
    { 

//#if -1342125785 
if(specificationComboBox == null)//1
{ 

//#if -1046077987 
if(specificationComboBoxModel == null)//1
{ 

//#if 913177224 
specificationComboBoxModel =
                    new UMLMethodSpecificationComboBoxModel();
//#endif 

} 

//#endif 


//#if 1429816080 
specificationComboBox =
                new UMLComboBox2(
                specificationComboBoxModel,
                new ActionSetMethodSpecification());
//#endif 

} 

//#endif 


//#if -172127570 
return specificationComboBox;
//#endif 

} 

//#endif 


//#if 1131999502 
public PropPanelMethod()
    { 

//#if 784638738 
super("label.method", lookupIcon("Method"));
//#endif 


//#if -1110937240 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if -1370508384 
addField(Translator.localize("label.owner"),
                 getOwnerScroll());
//#endif 


//#if -1453773160 
addField(Translator.localize("label.specification"),
                 new UMLComboBoxNavigator(
                     Translator
                     .localize("label.specification.navigate.tooltip"),
                     getSpecificationComboBox()));
//#endif 


//#if 1422136933 
add(getVisibilityPanel());
//#endif 


//#if -392709092 
JPanel modifiersPanel = createBorderPanel(Translator.localize(
                                    "label.modifiers"));
//#endif 


//#if -1251409001 
modifiersPanel.add(new UMLBehavioralFeatureQueryCheckBox());
//#endif 


//#if 930740635 
modifiersPanel.add(new UMLFeatureOwnerScopeCheckBox());
//#endif 


//#if -434326224 
add(modifiersPanel);
//#endif 


//#if -89989433 
addSeparator();
//#endif 


//#if 1780108076 
UMLExpressionModel2 procedureModel =
            new UMLMethodProcedureExpressionModel(
            this, "");
//#endif 


//#if 1587733152 
addField(Translator.localize("label.language"),
                 new UMLExpressionLanguageField(procedureModel,
                                                false));
//#endif 


//#if 748404857 
JScrollPane bodyPane = new JScrollPane(
            new UMLExpressionBodyField(
                procedureModel, true));
//#endif 


//#if 214719502 
addField(Translator.localize("label.body"), bodyPane);
//#endif 


//#if -1079499681 
addAction(new ActionNavigateOwner());
//#endif 


//#if -803826774 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if 959925225 
private static class ActionSetMethodSpecification extends 
//#if -1957516086 
UndoableAction
//#endif 

  { 

//#if -13367145 
public void actionPerformed(ActionEvent e)
        { 

//#if 1529333429 
super.actionPerformed(e);
//#endif 


//#if 771940644 
Object source = e.getSource();
//#endif 


//#if -2127214873 
Object oldOperation = null;
//#endif 


//#if 1171376718 
Object newOperation = null;
//#endif 


//#if 82885640 
Object method = null;
//#endif 


//#if 2107268074 
if(source instanceof UMLComboBox2)//1
{ 

//#if 1932378781 
UMLComboBox2 box = (UMLComboBox2) source;
//#endif 


//#if -1347074989 
Object o = box.getTarget();
//#endif 


//#if 1973534543 
if(Model.getFacade().isAMethod(o))//1
{ 

//#if 1798174309 
method = o;
//#endif 


//#if -1554750619 
oldOperation =
                        Model.getCoreHelper().getSpecification(method);
//#endif 

} 

//#endif 


//#if 1997100695 
o = box.getSelectedItem();
//#endif 


//#if -951456707 
if(Model.getFacade().isAOperation(o))//1
{ 

//#if 2146486088 
newOperation = o;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1809889353 
if(newOperation != oldOperation && method != null)//1
{ 

//#if 967947741 
Model.getCoreHelper().setSpecification(method, newOperation);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -516872529 
protected ActionSetMethodSpecification()
        { 

//#if 1727346527 
super(Translator.localize("Set"), null);
//#endif 


//#if -311809904 
putValue(Action.SHORT_DESCRIPTION,
                     Translator.localize("Set"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -122308949 
private static class UMLMethodSpecificationComboBoxModel extends 
//#if -95380077 
UMLComboBoxModel2
//#endif 

  { 

//#if 1819616297 
protected boolean isValidElement(Object element)
        { 

//#if 2000997900 
Object specification =
                Model.getCoreHelper().getSpecification(getTarget());
//#endif 


//#if 797166189 
return specification == element;
//#endif 

} 

//#endif 


//#if 761058159 
public UMLMethodSpecificationComboBoxModel()
        { 

//#if -1997007703 
super("specification", false);
//#endif 


//#if 2091294539 
Model.getPump().addClassModelEventListener(this,
                    Model.getMetaTypes().getOperation(), "method");
//#endif 

} 

//#endif 


//#if 1299132373 
public void modelChanged(UmlChangeEvent evt)
        { 

//#if 94637021 
if(evt instanceof AttributeChangeEvent)//1
{ 

//#if -1680235621 
if(evt.getPropertyName().equals("specification"))//1
{ 

//#if -1049056958 
if(evt.getSource() == getTarget()
                            && (getChangedElement(evt) != null))//1
{ 

//#if 804741187 
Object elem = getChangedElement(evt);
//#endif 


//#if -1608193472 
setSelectedItem(elem);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1268166561 
protected Object getSelectedModelElement()
        { 

//#if -208815458 
return Model.getCoreHelper().getSpecification(getTarget());
//#endif 

} 

//#endif 


//#if 614778357 
protected void buildModelList()
        { 

//#if -2627480 
if(getTarget() != null)//1
{ 

//#if 467940470 
removeAllElements();
//#endif 


//#if -433542306 
Object classifier = Model.getFacade().getOwner(getTarget());
//#endif 


//#if -35943654 
addAll(Model.getFacade().getOperations(classifier));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

