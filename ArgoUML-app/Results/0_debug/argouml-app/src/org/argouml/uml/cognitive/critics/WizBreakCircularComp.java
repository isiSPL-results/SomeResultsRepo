
//#if -107538504 
// Compilation Unit of /WizBreakCircularComp.java 
 

//#if 1096927107 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -2106875725 
import java.util.ArrayList;
//#endif 


//#if 450960142 
import java.util.Collection;
//#endif 


//#if -1747340418 
import java.util.Iterator;
//#endif 


//#if 1964421582 
import java.util.List;
//#endif 


//#if -406287606 
import javax.swing.JPanel;
//#endif 


//#if -1635397968 
import org.apache.log4j.Logger;
//#endif 


//#if 406082679 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 1080907810 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 2076013952 
import org.argouml.cognitive.ui.WizStepChoice;
//#endif 


//#if 1818274677 
import org.argouml.cognitive.ui.WizStepConfirm;
//#endif 


//#if -1944897315 
import org.argouml.i18n.Translator;
//#endif 


//#if 212138531 
import org.argouml.model.Model;
//#endif 


//#if -1089128406 
public class WizBreakCircularComp extends 
//#if 381616207 
UMLWizard
//#endif 

  { 

//#if -816780925 
private static final Logger LOG =
        Logger.getLogger(WizBreakCircularComp.class);
//#endif 


//#if -1371068358 
private String instructions1 =
        Translator.localize("critics.WizBreakCircularComp-ins1");
//#endif 


//#if -1090688678 
private String instructions2 =
        Translator.localize("critics.WizBreakCircularComp-ins2");
//#endif 


//#if -810308998 
private String instructions3 =
        Translator.localize("critics.WizBreakCircularComp-ins3");
//#endif 


//#if 265712026 
private WizStepChoice step1 = null;
//#endif 


//#if 1153215707 
private WizStepChoice step2 = null;
//#endif 


//#if -233780481 
private WizStepConfirm step3 = null;
//#endif 


//#if 1867345236 
private Object selectedCls = null;
//#endif 


//#if -813099685 
private Object selectedAsc = null;
//#endif 


//#if -434942594 
protected List<String> getOptions2()
    { 

//#if -53978062 
List<String> result = new ArrayList<String>();
//#endif 


//#if 565101312 
if(selectedCls != null)//1
{ 

//#if 1560495890 
Collection aes = Model.getFacade().getAssociationEnds(selectedCls);
//#endif 


//#if 346252734 
Object fromType = selectedCls;
//#endif 


//#if 992366766 
String fromName = Model.getFacade().getName(fromType);
//#endif 


//#if -1805367634 
for (Iterator iter = aes.iterator(); iter.hasNext();) //1
{ 

//#if 1371808131 
Object fromEnd = iter.next();
//#endif 


//#if 729912154 
Object asc = Model.getFacade().getAssociation(fromEnd);
//#endif 


//#if -843456486 
Object toEnd =
                    new ArrayList(Model.getFacade().getConnections(asc)).get(0);
//#endif 


//#if 967390717 
if(toEnd == fromEnd)//1
{ 

//#if 1511247896 
toEnd = new ArrayList(
                        Model.getFacade().getConnections(asc)).get(1);
//#endif 

} 

//#endif 


//#if -1294361066 
Object toType = Model.getFacade().getType(toEnd);
//#endif 


//#if -1923721247 
String ascName = Model.getFacade().getName(asc);
//#endif 


//#if -568013169 
String toName = Model.getFacade().getName(toType);
//#endif 


//#if 1228822206 
String s = ascName
                           + " "
                           + Translator.localize("critics.WizBreakCircularComp-from")
                           + fromName
                           + " "
                           + Translator.localize("critics.WizBreakCircularComp-to")
                           + " "
                           + toName;
//#endif 


//#if -2005293324 
result.add(s);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -414605827 
return result;
//#endif 

} 

//#endif 


//#if -2038976053 
public void doAction(int oldStep)
    { 

//#if 1357571881 
LOG.debug("doAction " + oldStep);
//#endif 


//#if -346160967 
int choice = -1;
//#endif 


//#if 7769971 
ToDoItem item = (ToDoItem) getToDoItem();
//#endif 


//#if -642851871 
ListSet offs = item.getOffenders();
//#endif 


//#if 1615352804 
switch (oldStep) //1
{ 
case 1://1


//#if 1259780790 
if(step1 != null)//1
{ 

//#if -915652643 
choice = step1.getSelectedIndex();
//#endif 

} 

//#endif 


//#if 276664935 
if(choice == -1)//1
{ 

//#if -1477412121 
throw new Error("nothing selected, should not get here");
//#endif 

} 

//#endif 


//#if -78616528 
selectedCls = offs.get(choice);
//#endif 


//#if -1936420627 
break;

//#endif 


case 2://1


//#if 2142974660 
if(step2 != null)//1
{ 

//#if -1700483056 
choice = step2.getSelectedIndex();
//#endif 

} 

//#endif 


//#if 1748594554 
if(choice == -1)//1
{ 

//#if -1232051558 
throw new Error("nothing selected, should not get here");
//#endif 

} 

//#endif 


//#if -954103912 
Object ae = null;
//#endif 


//#if -495083710 
Iterator iter =
                Model.getFacade().getAssociationEnds(selectedCls).iterator();
//#endif 


//#if 1112151423 
for (int n = 0; n <= choice; n++) //1
{ 

//#if 1793629325 
ae = iter.next();
//#endif 

} 

//#endif 


//#if 531060268 
selectedAsc = Model.getFacade().getAssociation(ae);
//#endif 


//#if -1572855366 
break;

//#endif 


case 3://1


//#if -872493954 
if(selectedAsc != null)//1
{ 

//#if 1811897105 
List conns = new ArrayList(
                    Model.getFacade().getConnections(selectedAsc));
//#endif 


//#if -864294089 
Object ae0 = conns.get(0);
//#endif 


//#if 643258681 
Object ae1 = conns.get(1);
//#endif 


//#if -433815272 
try //1
{ 

//#if 1433867371 
Model.getCoreHelper().setAggregation(
                        ae0,
                        Model.getAggregationKind().getNone());
//#endif 


//#if -1399519926 
Model.getCoreHelper().setAggregation(
                        ae1,
                        Model.getAggregationKind().getNone());
//#endif 

} 

//#if 230207645 
catch (Exception pve) //1
{ 

//#if 2030939555 
LOG.error("could not set aggregation", pve);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1370848580 
break;

//#endif 


} 

//#endif 

} 

//#endif 


//#if 235650153 
@Override
    public boolean canGoNext()
    { 

//#if 1270965455 
return canFinish();
//#endif 

} 

//#endif 


//#if -562636281 
public JPanel makePanel(int newStep)
    { 

//#if -1136083982 
switch (newStep) //1
{ 
case 1://1


//#if -410943625 
if(step1 == null)//1
{ 

//#if 1526504292 
step1 = new WizStepChoice(this, instructions1, getOptions1());
//#endif 


//#if 863654623 
step1.setTarget(getToDoItem());
//#endif 

} 

//#endif 


//#if -1492944044 
return step1;
//#endif 


case 2://1


//#if -498324991 
if(step2 == null)//1
{ 

//#if 37513521 
step2 = new WizStepChoice(this, instructions2, getOptions2());
//#endif 


//#if 2054058730 
step2.setTarget(getToDoItem());
//#endif 

} 

//#endif 


//#if -1886568964 
return step2;
//#endif 


case 3://1


//#if 551405816 
if(step3 == null)//1
{ 

//#if -208737689 
step3 = new WizStepConfirm(this, instructions3);
//#endif 

} 

//#endif 


//#if -2020275503 
return step3;
//#endif 


} 

//#endif 


//#if -1649767825 
return null;
//#endif 

} 

//#endif 


//#if -1617548543 
@Override
    public boolean canFinish()
    { 

//#if -478662447 
if(!super.canFinish())//1
{ 

//#if 474782579 
return false;
//#endif 

} 

//#endif 


//#if -433637842 
if(getStep() == 0)//1
{ 

//#if -2137087015 
return true;
//#endif 

} 

//#endif 


//#if 708711796 
if(getStep() == 1 && step1 != null && step1.getSelectedIndex() != -1)//1
{ 

//#if -1152489008 
return true;
//#endif 

} 

//#endif 


//#if -512104013 
if(getStep() == 2 && step2 != null && step2.getSelectedIndex() != -1)//1
{ 

//#if 1655322374 
return true;
//#endif 

} 

//#endif 


//#if 1353765850 
return false;
//#endif 

} 

//#endif 


//#if -434943555 
protected List<String> getOptions1()
    { 

//#if -948088475 
List<String> result = new ArrayList<String>();
//#endif 


//#if -1012376012 
if(getToDoItem() != null)//1
{ 

//#if -194816016 
ToDoItem item = (ToDoItem) getToDoItem();
//#endif 


//#if 1381640568 
for (Object me : item.getOffenders()) //1
{ 

//#if -1966080333 
String s = Model.getFacade().getName(me);
//#endif 


//#if 1416973266 
result.add(s);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -565793814 
return result;
//#endif 

} 

//#endif 


//#if 1831529567 
public WizBreakCircularComp() { 
} 

//#endif 


//#if -705201906 
@Override
    public int getNumSteps()
    { 

//#if -1484091701 
return 3;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

