
//#if 1292425961 
// Compilation Unit of /WizAssocComposite.java 
 

//#if 1917831318 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1782316032 
import java.util.ArrayList;
//#endif 


//#if -1206240623 
import java.util.Iterator;
//#endif 


//#if -620512671 
import java.util.List;
//#endif 


//#if 134812189 
import javax.swing.JPanel;
//#endif 


//#if 619559805 
import org.apache.log4j.Logger;
//#endif 


//#if -1798392557 
import org.argouml.cognitive.ui.WizStepChoice;
//#endif 


//#if -1880230102 
import org.argouml.i18n.Translator;
//#endif 


//#if -1827870992 
import org.argouml.model.Model;
//#endif 


//#if 357788642 
public class WizAssocComposite extends 
//#if -1838451507 
UMLWizard
//#endif 

  { 

//#if 444619350 
private static final Logger LOG = Logger.getLogger(WizAssocComposite.class);
//#endif 


//#if 708955721 
private String instructions = Translator
                                  .localize("critics.WizAssocComposite-ins");
//#endif 


//#if -2080003111 
private WizStepChoice step1Choice = null;
//#endif 


//#if -50338928 
private Object triggerAssociation = null;
//#endif 


//#if -2062993696 
public WizAssocComposite()
    { 
} 

//#endif 


//#if -907246209 
@Override
    public boolean canFinish()
    { 

//#if 2072704729 
if(!super.canFinish())//1
{ 

//#if 1175536010 
return false;
//#endif 

} 

//#endif 


//#if -1658248650 
if(getStep() == 0)//1
{ 

//#if -1168297317 
return true;
//#endif 

} 

//#endif 


//#if 854036179 
if((getStep() == 1) && (step1Choice != null)
                && (step1Choice.getSelectedIndex() != -1))//1
{ 

//#if 510730282 
return true;
//#endif 

} 

//#endif 


//#if 510451922 
return false;
//#endif 

} 

//#endif 


//#if 147666053 
public JPanel makePanel(int newStep)
    { 

//#if 1408296858 
switch (newStep) //1
{ 
case 1://1


//#if 1627613343 
if(step1Choice == null)//1
{ 

//#if 626159055 
List<String> opts = buildOptions();
//#endif 


//#if -267552541 
if(opts != null)//1
{ 

//#if -659872519 
step1Choice = new WizStepChoice(this, instructions, opts);
//#endif 


//#if 1831027959 
step1Choice.setTarget(getToDoItem());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -711905574 
return step1Choice;
//#endif 


default://1

} 

//#endif 


//#if 1348903374 
return null;
//#endif 

} 

//#endif 


//#if -1211656303 
private List<String> buildOptions()
    { 

//#if -2093580156 
Object asc = getTriggerAssociation();
//#endif 


//#if -1333100685 
if(asc == null)//1
{ 

//#if 1926494358 
return null;
//#endif 

} 

//#endif 


//#if -1283012193 
List<String> result = new ArrayList<String>();
//#endif 


//#if -1302356956 
Iterator iter = Model.getFacade().getConnections(asc).iterator();
//#endif 


//#if 674234655 
Object ae0 = iter.next();
//#endif 


//#if 168676030 
Object ae1 = iter.next();
//#endif 


//#if -253871958 
Object cls0 = Model.getFacade().getType(ae0);
//#endif 


//#if 1857419372 
Object cls1 = Model.getFacade().getType(ae1);
//#endif 


//#if 1908867770 
String start = Translator.localize("misc.name.anon");
//#endif 


//#if 630198241 
String end = Translator.localize("misc.name.anon");
//#endif 


//#if 1779461276 
if((cls0 != null) && (Model.getFacade().getName(cls0) != null)
                && (!(Model.getFacade().getName(cls0).equals(""))))//1
{ 

//#if -719113844 
start = Model.getFacade().getName(cls0);
//#endif 

} 

//#endif 


//#if -1806212453 
if((cls1 != null) && (Model.getFacade().getName(cls1) != null)
                && (!(Model.getFacade().getName(cls1).equals(""))))//1
{ 

//#if 712016603 
end = Model.getFacade().getName(cls1);
//#endif 

} 

//#endif 


//#if -18503121 
result.add(start
                   + Translator.localize("critics.WizAssocComposite-option1")
                   + end);
//#endif 


//#if -1825957584 
result.add(start
                   + Translator.localize("critics.WizAssocComposite-option2")
                   + end);
//#endif 


//#if -321984355 
result.add(end
                   + Translator.localize("critics.WizAssocComposite-option1")
                   + start);
//#endif 


//#if -2118935714 
result.add(end
                   + Translator.localize("critics.WizAssocComposite-option2")
                   + start);
//#endif 


//#if 248975256 
result.add(Translator.localize("critics.WizAssocComposite-option3"));
//#endif 


//#if -561239696 
return result;
//#endif 

} 

//#endif 


//#if 1339813808 
private Object getTriggerAssociation()
    { 

//#if 1445858232 
if((triggerAssociation == null) && (getToDoItem() != null))//1
{ 

//#if 1403992160 
triggerAssociation = getModelElement();
//#endif 

} 

//#endif 


//#if 733477012 
return triggerAssociation;
//#endif 

} 

//#endif 


//#if -1929904745 
public void setInstructions(String s)
    { 

//#if 694674123 
instructions = s;
//#endif 

} 

//#endif 


//#if 481138701 
public void doAction(int oldStep)
    { 

//#if 422928584 
switch (oldStep) //1
{ 
case 1://1


//#if 130863860 
int choice = -1;
//#endif 


//#if 1176171068 
if(step1Choice != null)//1
{ 

//#if 1821201056 
choice = step1Choice.getSelectedIndex();
//#endif 

} 

//#endif 


//#if 1810267842 
if(choice == -1)//1
{ 

//#if -260158835 
LOG.warn("WizAssocComposite: nothing selected, "
                         + "should not get here");
//#endif 


//#if 396086433 
return;
//#endif 

} 

//#endif 


//#if 1977835276 
try //1
{ 

//#if 603063513 
Iterator iter = Model.getFacade().getConnections(
                                    getTriggerAssociation()).iterator();
//#endif 


//#if -465626397 
Object ae0 = iter.next();
//#endif 


//#if -971185022 
Object ae1 = iter.next();
//#endif 


//#if 1623036242 
switch (choice) //1
{ 
case 0://1


//#if 1943617536 
Model.getCoreHelper().setAggregation(ae0,
                                                         Model.getAggregationKind().getComposite());
//#endif 


//#if 2080058180 
Model.getCoreHelper().setAggregation(ae1,
                                                         Model.getAggregationKind().getNone());
//#endif 


//#if 1823124137 
break;

//#endif 


case 1://1


//#if -1417917223 
Model.getCoreHelper().setAggregation(ae0,
                                                         Model.getAggregationKind().getAggregate());
//#endif 


//#if 374443267 
Model.getCoreHelper().setAggregation(ae1,
                                                         Model.getAggregationKind().getNone());
//#endif 


//#if -1269166582 
break;

//#endif 


case 2://1


//#if 900114099 
Model.getCoreHelper().setAggregation(ae0,
                                                         Model.getAggregationKind().getNone());
//#endif 


//#if -473032973 
Model.getCoreHelper().setAggregation(ae1,
                                                         Model.getAggregationKind().getComposite());
//#endif 


//#if 1458970267 
break;

//#endif 


case 3://1


//#if -1864743209 
Model.getCoreHelper().setAggregation(ae0,
                                                         Model.getAggregationKind().getNone());
//#endif 


//#if -712762233 
Model.getCoreHelper().setAggregation(ae1,
                                                         Model.getAggregationKind().getAggregate());
//#endif 


//#if -928782857 
break;

//#endif 


case 4://1


//#if 1325509982 
Model.getCoreHelper().setAggregation(ae0,
                                                         Model.getAggregationKind().getNone());
//#endif 


//#if -1507877315 
Model.getCoreHelper().setAggregation(ae1,
                                                         Model.getAggregationKind().getNone());
//#endif 


//#if -721812592 
break;

//#endif 


default://1

} 

//#endif 

} 

//#if -631218076 
catch (Exception pve) //1
{ 

//#if -2021192910 
LOG.error("WizAssocComposite: could not set " + "aggregation.",
                          pve);
//#endif 

} 

//#endif 


//#endif 


default://1

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

