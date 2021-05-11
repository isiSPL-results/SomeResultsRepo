
//#if 627313379 
// Compilation Unit of /WizOperName.java 
 

//#if -1707800302 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1276816636 
import java.util.ArrayList;
//#endif 


//#if 412988125 
import java.util.Collection;
//#endif 


//#if 1881666317 
import java.util.Iterator;
//#endif 


//#if -1025961763 
import java.util.List;
//#endif 


//#if -1072248167 
import javax.swing.JPanel;
//#endif 


//#if 1011609729 
import org.apache.log4j.Logger;
//#endif 


//#if -823699569 
import org.argouml.cognitive.ui.WizStepChoice;
//#endif 


//#if 2127068083 
import org.argouml.cognitive.ui.WizStepCue;
//#endif 


//#if -1285420498 
import org.argouml.i18n.Translator;
//#endif 


//#if -1435821068 
import org.argouml.model.Model;
//#endif 


//#if 1163192557 
public class WizOperName extends 
//#if -1493640223 
WizMEName
//#endif 

  { 

//#if 1591615509 
private static final Logger LOG = Logger.getLogger(WizOperName.class);
//#endif 


//#if -1460922559 
private boolean possibleConstructor;
//#endif 


//#if 1731749571 
private boolean stereotypePathChosen;
//#endif 


//#if -1556160005 
private String option0 =
        Translator.localize("critics.WizOperName-options1");
//#endif 


//#if -1118120711 
private String option1 =
        Translator.localize("critics.WizOperName-options2");
//#endif 


//#if 511344178 
private WizStepChoice step1;
//#endif 


//#if -145064819 
private WizStepCue step2;
//#endif 


//#if 318959157 
private Object createStereotype;
//#endif 


//#if 1865871228 
private boolean addedCreateStereotype;
//#endif 


//#if 1298188382 
private static final long serialVersionUID = -4013730212763172160L;
//#endif 


//#if 491234485 
public void setPossibleConstructor(boolean b)
    { 

//#if 366792275 
possibleConstructor = b;
//#endif 

} 

//#endif 


//#if -1343477923 
@Override
    public void doAction(int oldStep)
    { 

//#if -829563664 
if(!possibleConstructor)//1
{ 

//#if -1159372186 
super.doAction(oldStep);
//#endif 


//#if 1862710166 
return;
//#endif 

} 

//#endif 


//#if 487836689 
switch (oldStep) //1
{ 
case 1://1


//#if -629589011 
int choice = -1;
//#endif 


//#if 1988535394 
if(step1 != null)//1
{ 

//#if 1020847259 
choice = step1.getSelectedIndex();
//#endif 

} 

//#endif 


//#if 674886320 
switch (choice) //1
{ 
case -1://1


//#if 227252133 
throw new IllegalArgumentException(
                    "nothing selected, should not get here");
//#endif 


case 0://1


//#if 1686078761 
stereotypePathChosen = true;
//#endif 


//#if 1904434577 
Object oper = getModelElement();
//#endif 


//#if -885161324 
Object m = Model.getFacade().getModel(oper);
//#endif 


//#if 2117745963 
Object theStereotype = null;
//#endif 


//#if -512022247 
for (Iterator iter =
                            Model.getFacade().getOwnedElements(m).iterator();
                        iter.hasNext();) //1
{ 

//#if 1962222626 
Object candidate = iter.next();
//#endif 


//#if -515566256 
if(!(Model.getFacade().isAStereotype(candidate)))//1
{ 

//#if 709886743 
continue;
//#endif 

} 

//#endif 


//#if -498832336 
if(!("create".equals(
                                Model.getFacade().getName(candidate))))//1
{ 

//#if 1746422211 
continue;
//#endif 

} 

//#endif 


//#if 1525612524 
Collection baseClasses =
                        Model.getFacade().getBaseClasses(candidate);
//#endif 


//#if 1586404498 
Iterator iter2 =
                        baseClasses != null ? baseClasses.iterator() : null;
//#endif 


//#if 525367009 
if(iter2 == null || !("BehavioralFeature".equals(
                                               iter2.next())))//1
{ 

//#if -707071729 
continue;
//#endif 

} 

//#endif 


//#if -2138933270 
theStereotype = candidate;
//#endif 


//#if 139556948 
break;

//#endif 

} 

//#endif 


//#if -999638089 
if(theStereotype == null)//1
{ 

//#if -1996369612 
theStereotype =
                        Model.getExtensionMechanismsFactory()
                        .buildStereotype("create", m);
//#endif 


//#if -394070407 
Model.getCoreHelper().setName(theStereotype, "create");
//#endif 


//#if -427638567 
Model.getExtensionMechanismsHelper()
                    .addBaseClass(theStereotype, "BehavioralFeature");
//#endif 


//#if -901218962 
Object targetNS =
                        findNamespace(Model.getFacade().getNamespace(oper),
                                      Model.getFacade().getModel(oper));
//#endif 


//#if -1398590162 
Model.getCoreHelper()
                    .addOwnedElement(targetNS, theStereotype);
//#endif 

} 

//#endif 


//#if 1730162566 
try //1
{ 

//#if 284509988 
createStereotype = theStereotype;
//#endif 


//#if 1309596606 
Model.getCoreHelper().addStereotype(oper, theStereotype);
//#endif 


//#if 1775673179 
addedCreateStereotype = true;
//#endif 

} 

//#if 770457424 
catch (Exception pve) //1
{ 

//#if 1218038269 
LOG.error("could not set stereotype", pve);
//#endif 

} 

//#endif 


//#endif 


//#if -54220229 
return;
//#endif 


case 1://1


//#if 269192483 
stereotypePathChosen = false;
//#endif 


//#if 2019137186 
return;
//#endif 


default://1

} 

//#endif 


//#if 149963566 
return;
//#endif 


case 2://1


//#if 144148078 
if(!stereotypePathChosen)//1
{ 

//#if -1920221641 
super.doAction(1);
//#endif 

} 

//#endif 


//#if 1353511652 
return;
//#endif 


default://1

} 

//#endif 

} 

//#endif 


//#if 99918645 
@Override
    public JPanel makePanel(int newStep)
    { 

//#if 1392920378 
if(!possibleConstructor)//1
{ 

//#if 438874122 
return super.makePanel(newStep);
//#endif 

} 

//#endif 


//#if 1206627509 
switch (newStep) //1
{ 
case 0://1


//#if 1353446099 
return super.makePanel(newStep);
//#endif 


case 1://1


//#if -1482542304 
if(step1 == null)//1
{ 

//#if -1299704560 
step1 =
                    new WizStepChoice(this, getInstructions(), getOptions());
//#endif 


//#if -145295950 
step1.setTarget(getToDoItem());
//#endif 

} 

//#endif 


//#if -335912515 
return step1;
//#endif 


case 2://1


//#if 364322841 
if(stereotypePathChosen)//1
{ 

//#if -1931027611 
if(step2 == null)//1
{ 

//#if 622096908 
step2 =
                        new WizStepCue(this, Translator.localize(
                                           "critics.WizOperName-stereotype"));
//#endif 


//#if 1936697576 
step2.setTarget(getToDoItem());
//#endif 

} 

//#endif 


//#if 718391904 
return step2;
//#endif 

} 

//#endif 


//#if -2074640085 
return super.makePanel(1);
//#endif 


default://1

} 

//#endif 


//#if -1174839709 
return null;
//#endif 

} 

//#endif 


//#if -1192903183 
private List<String> getOptions()
    { 

//#if 14180119 
List<String> res = new ArrayList<String>();
//#endif 


//#if 1547875017 
res.add(option0);
//#endif 


//#if 1547875978 
res.add(option1);
//#endif 


//#if -728765606 
return res;
//#endif 

} 

//#endif 


//#if -1665920235 
private static Object findNamespace(Object phantomNS, Object targetModel)
    { 

//#if 1131959829 
Object ns = null;
//#endif 


//#if -801595600 
Object targetParentNS = null;
//#endif 


//#if -154446352 
if(phantomNS == null)//1
{ 

//#if 1482060479 
return targetModel;
//#endif 

} 

//#endif 


//#if 29851448 
Object parentNS = Model.getFacade().getNamespace(phantomNS);
//#endif 


//#if -119291185 
if(parentNS == null)//1
{ 

//#if -366241431 
return targetModel;
//#endif 

} 

//#endif 


//#if -433083466 
targetParentNS = findNamespace(parentNS, targetModel);
//#endif 


//#if -162190887 
Collection ownedElements =
            Model.getFacade().getOwnedElements(targetParentNS);
//#endif 


//#if 957883627 
String phantomName = Model.getFacade().getName(phantomNS);
//#endif 


//#if -899343692 
String targetName;
//#endif 


//#if 1917004726 
if(ownedElements != null)//1
{ 

//#if -515550509 
Object ownedElement;
//#endif 


//#if -311266443 
Iterator iter = ownedElements.iterator();
//#endif 


//#if 1584912233 
while (iter.hasNext()) //1
{ 

//#if -1383602587 
ownedElement = iter.next();
//#endif 


//#if -1408417855 
targetName = Model.getFacade().getName(ownedElement);
//#endif 


//#if 855156634 
if(targetName != null && phantomName.equals(targetName))//1
{ 

//#if 662230764 
if(Model.getFacade().isAPackage(ownedElement))//1
{ 

//#if 589503315 
ns = ownedElement;
//#endif 


//#if 1931528387 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1826400795 
if(ns == null)//1
{ 

//#if 303137999 
ns = Model.getModelManagementFactory().createPackage();
//#endif 


//#if 1739704676 
Model.getCoreHelper().setName(ns, phantomName);
//#endif 


//#if -1268094643 
Model.getCoreHelper().addOwnedElement(targetParentNS, ns);
//#endif 

} 

//#endif 


//#if -409109140 
return ns;
//#endif 

} 

//#endif 


//#if 1648277084 
@Override
    public void undoAction(int origStep)
    { 

//#if -1427691842 
super.undoAction(origStep);
//#endif 


//#if -1639253754 
if(getStep() >= 1)//1
{ 

//#if 2055120278 
removePanel(origStep);
//#endif 

} 

//#endif 


//#if 820501789 
if(origStep == 1)//1
{ 

//#if -1551400172 
Object oper = getModelElement();
//#endif 


//#if -704045160 
if(addedCreateStereotype)//1
{ 

//#if 766952186 
Model.getCoreHelper().removeStereotype(oper, createStereotype);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 92681556 
@Override
    public int getNumSteps()
    { 

//#if -1724522916 
if(possibleConstructor)//1
{ 

//#if -257529968 
return 2;
//#endif 

} 

//#endif 


//#if 588403568 
return 1;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

