package org.argouml.uml.cognitive.critics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;
import org.apache.log4j.Logger;
import org.argouml.cognitive.ListSet;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.ui.WizStepChoice;
import org.argouml.cognitive.ui.WizStepConfirm;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class WizBreakCircularComp extends UMLWizard
  { 
private static final Logger LOG =
        Logger.getLogger(WizBreakCircularComp.class);
private String instructions1 =
        Translator.localize("critics.WizBreakCircularComp-ins1");
private String instructions2 =
        Translator.localize("critics.WizBreakCircularComp-ins2");
private String instructions3 =
        Translator.localize("critics.WizBreakCircularComp-ins3");
private WizStepChoice step1 = null;
private WizStepChoice step2 = null;
private WizStepConfirm step3 = null;
private Object selectedCls = null;
private Object selectedAsc = null;
protected List<String> getOptions2()
    { 
List<String> result = new ArrayList<String>();
if(selectedCls != null)//1
{ 
Collection aes = Model.getFacade().getAssociationEnds(selectedCls);
Object fromType = selectedCls;
String fromName = Model.getFacade().getName(fromType);
for (Iterator iter = aes.iterator(); iter.hasNext();) //1
{ 
Object fromEnd = iter.next();
Object asc = Model.getFacade().getAssociation(fromEnd);
Object toEnd =
                    new ArrayList(Model.getFacade().getConnections(asc)).get(0);
if(toEnd == fromEnd)//1
{ 
toEnd = new ArrayList(
                        Model.getFacade().getConnections(asc)).get(1);
} 
Object toType = Model.getFacade().getType(toEnd);
String ascName = Model.getFacade().getName(asc);
String toName = Model.getFacade().getName(toType);
String s = ascName
                           + " "
                           + Translator.localize("critics.WizBreakCircularComp-from")
                           + fromName
                           + " "
                           + Translator.localize("critics.WizBreakCircularComp-to")
                           + " "
                           + toName;
result.add(s);
} 
} 
return result;
} 
public void doAction(int oldStep)
    { 
LOG.debug("doAction " + oldStep);
int choice = -1;
ToDoItem item = (ToDoItem) getToDoItem();
ListSet offs = item.getOffenders();
switch (oldStep) //1
{ 
case 1://1

if(step1 != null)//1
{ 
choice = step1.getSelectedIndex();
} 
if(choice == -1)//1
{ 
throw new Error("nothing selected, should not get here");
} 
selectedCls = offs.get(choice);
break;


case 2://1

if(step2 != null)//1
{ 
choice = step2.getSelectedIndex();
} 
if(choice == -1)//1
{ 
throw new Error("nothing selected, should not get here");
} 
Object ae = null;
Iterator iter =
                Model.getFacade().getAssociationEnds(selectedCls).iterator();
for (int n = 0; n <= choice; n++) //1
{ 
ae = iter.next();
} 
selectedAsc = Model.getFacade().getAssociation(ae);
break;


case 3://1

if(selectedAsc != null)//1
{ 
List conns = new ArrayList(
                    Model.getFacade().getConnections(selectedAsc));
Object ae0 = conns.get(0);
Object ae1 = conns.get(1);
try//1
{ 
Model.getCoreHelper().setAggregation(
                        ae0,
                        Model.getAggregationKind().getNone());
Model.getCoreHelper().setAggregation(
                        ae1,
                        Model.getAggregationKind().getNone());
} 
catch (Exception pve) //1
{ 
LOG.error("could not set aggregation", pve);
} 
} 
break;


} 
} 
@Override
    public boolean canGoNext()
    { 
return canFinish();
} 
public JPanel makePanel(int newStep)
    { 
switch (newStep) //1
{ 
case 1://1

if(step1 == null)//1
{ 
step1 = new WizStepChoice(this, instructions1, getOptions1());
step1.setTarget(getToDoItem());
} 
return step1;

case 2://1

if(step2 == null)//1
{ 
step2 = new WizStepChoice(this, instructions2, getOptions2());
step2.setTarget(getToDoItem());
} 
return step2;

case 3://1

if(step3 == null)//1
{ 
step3 = new WizStepConfirm(this, instructions3);
} 
return step3;

} 
return null;
} 
@Override
    public boolean canFinish()
    { 
if(!super.canFinish())//1
{ 
return false;
} 
if(getStep() == 0)//1
{ 
return true;
} 
if(getStep() == 1 && step1 != null && step1.getSelectedIndex() != -1)//1
{ 
return true;
} 
if(getStep() == 2 && step2 != null && step2.getSelectedIndex() != -1)//1
{ 
return true;
} 
return false;
} 
protected List<String> getOptions1()
    { 
List<String> result = new ArrayList<String>();
if(getToDoItem() != null)//1
{ 
ToDoItem item = (ToDoItem) getToDoItem();
for (Object me : item.getOffenders()) //1
{ 
String s = Model.getFacade().getName(me);
result.add(s);
} 
} 
return result;
} 
public WizBreakCircularComp() { 
} 
@Override
    public int getNumSteps()
    { 
return 3;
} 

 } 
