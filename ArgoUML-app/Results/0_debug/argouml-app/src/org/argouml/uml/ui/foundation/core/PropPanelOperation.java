
//#if -1786705188 
// Compilation Unit of /PropPanelOperation.java 
 

//#if -5292828 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -803294116 
import java.awt.event.ActionEvent;
//#endif 


//#if 1930553746 
import java.util.List;
//#endif 


//#if -948445742 
import javax.swing.Action;
//#endif 


//#if -172374225 
import javax.swing.Icon;
//#endif 


//#if -2112208690 
import javax.swing.JPanel;
//#endif 


//#if -1289414833 
import javax.swing.JScrollPane;
//#endif 


//#if -1256026856 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -233324647 
import org.argouml.i18n.Translator;
//#endif 


//#if 1754414815 
import org.argouml.model.Model;
//#endif 


//#if -987936733 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -128097960 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 630196615 
import org.argouml.uml.ui.ActionNavigateOwner;
//#endif 


//#if -2872820 
import org.argouml.uml.ui.ActionNavigateUpNextDown;
//#endif 


//#if 1884305800 
import org.argouml.uml.ui.ActionNavigateUpPreviousDown;
//#endif 


//#if 1105740360 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if 1135637791 
import org.argouml.uml.ui.UMLTextArea2;
//#endif 


//#if -1146973168 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 2102052175 
public class PropPanelOperation extends 
//#if -729784808 
PropPanelFeature
//#endif 

  { 

//#if -677877882 
private static final long serialVersionUID = -8231585002039922761L;
//#endif 


//#if -1524412830 
public void addRaisedSignal()
    { 

//#if -1251134251 
Object target = getTarget();
//#endif 


//#if -886386390 
if(Model.getFacade().isAOperation(target))//1
{ 

//#if -1935053194 
Object oper = target;
//#endif 


//#if 1239724661 
Object newSignal = Model.getCommonBehaviorFactory()
                               .createSignal();
//#endif 


//#if 243418783 
Model.getCoreHelper().addOwnedElement(
                Model.getFacade().getNamespace(
                    Model.getFacade().getOwner(oper)),
                newSignal);
//#endif 


//#if 1845055342 
Model.getCoreHelper().addRaisedSignal(oper, newSignal);
//#endif 


//#if -73341099 
TargetManager.getInstance().setTarget(newSignal);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -748725133 
public PropPanelOperation()
    { 

//#if -829630041 
super("label.operation", lookupIcon("Operation"));
//#endif 


//#if -1960138579 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if 1373044667 
addField(Translator.localize("label.owner"),
                 getOwnerScroll());
//#endif 


//#if 1438068040 
addField(Translator.localize("label.parameters"),
                 new JScrollPane(new UMLLinkedList(
                                     new UMLClassifierParameterListModel(), true, false)));
//#endif 


//#if 1946981388 
addSeparator();
//#endif 


//#if -1131883520 
add(getVisibilityPanel());
//#endif 


//#if -294336159 
JPanel modifiersPanel = createBorderPanel(Translator.localize(
                                    "label.modifiers"));
//#endif 


//#if 1452507608 
modifiersPanel.add(new UMLGeneralizableElementAbstractCheckBox());
//#endif 


//#if 1823700756 
modifiersPanel.add(new UMLGeneralizableElementLeafCheckBox());
//#endif 


//#if -1644416360 
modifiersPanel.add(new UMLGeneralizableElementRootCheckBox());
//#endif 


//#if -869554852 
modifiersPanel.add(new UMLBehavioralFeatureQueryCheckBox());
//#endif 


//#if 273715382 
modifiersPanel.add(new UMLFeatureOwnerScopeCheckBox());
//#endif 


//#if 960135947 
add(modifiersPanel);
//#endif 


//#if 1700921066 
add(new UMLOperationConcurrencyRadioButtonPanel(
                Translator.localize("label.concurrency"), true));
//#endif 


//#if -1010755898 
addSeparator();
//#endif 


//#if 2069880172 
addField(Translator.localize("label.raisedsignals"),
                 new JScrollPane(new UMLLinkedList(
                                     new UMLOperationRaisedSignalsListModel())));
//#endif 


//#if -1062581204 
addField(Translator.localize("label.methods"),
                 new JScrollPane(new UMLLinkedList(
                                     new UMLOperationMethodsListModel())));
//#endif 


//#if 871228608 
UMLTextArea2 osta = new UMLTextArea2(
            new UMLOperationSpecificationDocument());
//#endif 


//#if -795301755 
osta.setRows(3);
//#endif 


//#if 1298372975 
addField(Translator.localize("label.specification"),
                 new JScrollPane(osta));
//#endif 


//#if 1088216122 
addAction(new ActionNavigateOwner());
//#endif 


//#if 242155335 
addAction(new ActionNavigateUpPreviousDown() {
            public List getFamily(Object parent) {
                return Model.getFacade().getOperations(parent);
            }

            public Object getParent(Object child) {
                return Model.getFacade().getOwner(child);
            }
        });
//#endif 


//#if 2021953611 
addAction(new ActionNavigateUpNextDown() {
            public List getFamily(Object parent) {
                return Model.getFacade().getOperations(parent);
            }

            public Object getParent(Object child) {
                return Model.getFacade().getOwner(child);
            }
        });
//#endif 


//#if 1117688980 
addAction(new ActionAddOperation());
//#endif 


//#if -1203820745 
addAction(new ActionNewParameter());
//#endif 


//#if -110516040 
addAction(new ActionNewRaisedSignal());
//#endif 


//#if 842748441 
addAction(new ActionNewMethod());
//#endif 


//#if -1534083587 
addAction(new ActionAddDataType());
//#endif 


//#if -714272012 
addAction(new ActionAddEnumeration());
//#endif 


//#if 1920069994 
addAction(new ActionNewStereotype());
//#endif 


//#if 2013473839 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if 742723843 
public void addMethod()
    { 

//#if -1074512537 
Object target = getTarget();
//#endif 


//#if 1125768380 
if(Model.getFacade().isAOperation(target))//1
{ 

//#if -374137092 
Object oper = target;
//#endif 


//#if 878717160 
String name = Model.getFacade().getName(oper);
//#endif 


//#if -2145412404 
Object newMethod = Model.getCoreFactory().buildMethod(name);
//#endif 


//#if 2074727660 
Model.getCoreHelper().addMethod(oper, newMethod);
//#endif 


//#if -1183410629 
Model.getCoreHelper().addFeature(Model.getFacade().getOwner(oper),
                                             newMethod);
//#endif 


//#if -2052891128 
TargetManager.getInstance().setTarget(newMethod);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 733608812 
@Override
    protected Object getDisplayNamespace()
    { 

//#if 137036867 
Object namespace = null;
//#endif 


//#if 396126576 
Object target = getTarget();
//#endif 


//#if -745908230 
if(Model.getFacade().isAAttribute(target))//1
{ 

//#if -1092575961 
if(Model.getFacade().getOwner(target) != null)//1
{ 

//#if -1852262228 
namespace =
                    Model.getFacade().getNamespace(
                        Model.getFacade().getOwner(target));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 72700544 
return namespace;
//#endif 

} 

//#endif 


//#if -192705549 
private class ActionNewMethod extends 
//#if -98728576 
AbstractActionNewModelElement
//#endif 

  { 

//#if 2015322905 
private static final long serialVersionUID = 1605755146025527381L;
//#endif 


//#if -472413942 
@Override
        public boolean isEnabled()
        { 

//#if 1472820578 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1479816776 
boolean result = true;
//#endif 


//#if -2132001016 
if(Model.getFacade().isAOperation(target))//1
{ 

//#if -71073377 
Object owner = Model.getFacade().getOwner(target);
//#endif 


//#if -1268313553 
if(owner == null || Model.getFacade().isAInterface(owner))//1
{ 

//#if -630765806 
result = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1019891914 
return super.isEnabled() && result;
//#endif 

} 

//#endif 


//#if 1894605832 
public ActionNewMethod()
        { 

//#if 1820646237 
super("button.new-method");
//#endif 


//#if -1755855111 
putValue(Action.NAME,
                     Translator.localize("button.new-method"));
//#endif 


//#if 1698569089 
Icon icon = ResourceLoaderWrapper.lookupIcon("Method");
//#endif 


//#if -941538606 
putValue(Action.SMALL_ICON, icon);
//#endif 

} 

//#endif 


//#if -506084804 
@Override
        public void actionPerformed(ActionEvent e)
        { 

//#if -555303051 
super.actionPerformed(e);
//#endif 


//#if 1286118918 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1994644452 
if(Model.getFacade().isAOperation(target))//1
{ 

//#if 211409472 
addMethod();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1233748910 
private class ActionNewRaisedSignal extends 
//#if 402816080 
AbstractActionNewModelElement
//#endif 

  { 

//#if -1791481665 
private static final long serialVersionUID = -2380798799656866520L;
//#endif 


//#if 1223637356 
@Override
        public void actionPerformed(ActionEvent e)
        { 

//#if 8269841 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1750258681 
if(Model.getFacade().isAOperation(target))//1
{ 

//#if 341292415 
addRaisedSignal();
//#endif 


//#if -139524384 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1754955657 
public ActionNewRaisedSignal()
        { 

//#if -2059172462 
super("button.new-raised-signal");
//#endif 


//#if 288252764 
putValue(Action.NAME,
                     Translator.localize("button.new-raised-signal"));
//#endif 


//#if -640075665 
Icon icon = ResourceLoaderWrapper.lookupIcon("SignalSending");
//#endif 


//#if -992282131 
putValue(Action.SMALL_ICON, icon);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

