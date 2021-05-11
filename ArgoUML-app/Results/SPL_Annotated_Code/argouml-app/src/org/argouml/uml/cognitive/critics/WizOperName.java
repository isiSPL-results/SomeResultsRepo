// Compilation Unit of /WizOperName.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;
import org.apache.log4j.Logger;
import org.argouml.cognitive.ui.WizStepChoice;
import org.argouml.cognitive.ui.WizStepCue;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class WizOperName extends WizMEName
  { 
private static final Logger LOG = Logger.getLogger(WizOperName.class);
private boolean possibleConstructor;
private boolean stereotypePathChosen;
private String option0 =
        Translator.localize("critics.WizOperName-options1");
private String option1 =
        Translator.localize("critics.WizOperName-options2");
private WizStepChoice step1;
private WizStepCue step2;
private Object createStereotype;
private boolean addedCreateStereotype;
private static final long serialVersionUID = -4013730212763172160L;
public void setPossibleConstructor(boolean b)
    { 
possibleConstructor = b;
} 

@Override
    public void doAction(int oldStep)
    { 
if(!possibleConstructor)//1
{ 
super.doAction(oldStep);
return;
} 

switch (oldStep) //1
{ 
case 1://1

int choice = -1;
if(step1 != null)//1
{ 
choice = step1.getSelectedIndex();
} 

switch (choice) //1
{ 
case -1://1

throw new IllegalArgumentException(
                    "nothing selected, should not get here");

case 0://1

stereotypePathChosen = true;
Object oper = getModelElement();
Object m = Model.getFacade().getModel(oper);
Object theStereotype = null;
for (Iterator iter =
                            Model.getFacade().getOwnedElements(m).iterator();
                        iter.hasNext();) //1
{ 
Object candidate = iter.next();
if(!(Model.getFacade().isAStereotype(candidate)))//1
{ 
continue;
} 

if(!("create".equals(
                                Model.getFacade().getName(candidate))))//1
{ 
continue;
} 

Collection baseClasses =
                        Model.getFacade().getBaseClasses(candidate);
Iterator iter2 =
                        baseClasses != null ? baseClasses.iterator() : null;
if(iter2 == null || !("BehavioralFeature".equals(
                                               iter2.next())))//1
{ 
continue;
} 

theStereotype = candidate;
break;

} 

if(theStereotype == null)//1
{ 
theStereotype =
                        Model.getExtensionMechanismsFactory()
                        .buildStereotype("create", m);
Model.getCoreHelper().setName(theStereotype, "create");
Model.getExtensionMechanismsHelper()
                    .addBaseClass(theStereotype, "BehavioralFeature");
Object targetNS =
                        findNamespace(Model.getFacade().getNamespace(oper),
                                      Model.getFacade().getModel(oper));
Model.getCoreHelper()
                    .addOwnedElement(targetNS, theStereotype);
} 

try //1
{ 
createStereotype = theStereotype;
Model.getCoreHelper().addStereotype(oper, theStereotype);
addedCreateStereotype = true;
} 
catch (Exception pve) //1
{ 
LOG.error("could not set stereotype", pve);
} 


return;

case 1://1

stereotypePathChosen = false;
return;

default://1

} 

return;

case 2://1

if(!stereotypePathChosen)//1
{ 
super.doAction(1);
} 

return;

default://1

} 

} 

@Override
    public JPanel makePanel(int newStep)
    { 
if(!possibleConstructor)//1
{ 
return super.makePanel(newStep);
} 

switch (newStep) //1
{ 
case 0://1

return super.makePanel(newStep);

case 1://1

if(step1 == null)//1
{ 
step1 =
                    new WizStepChoice(this, getInstructions(), getOptions());
step1.setTarget(getToDoItem());
} 

return step1;

case 2://1

if(stereotypePathChosen)//1
{ 
if(step2 == null)//1
{ 
step2 =
                        new WizStepCue(this, Translator.localize(
                                           "critics.WizOperName-stereotype"));
step2.setTarget(getToDoItem());
} 

return step2;
} 

return super.makePanel(1);

default://1

} 

return null;
} 

private List<String> getOptions()
    { 
List<String> res = new ArrayList<String>();
res.add(option0);
res.add(option1);
return res;
} 

private static Object findNamespace(Object phantomNS, Object targetModel)
    { 
Object ns = null;
Object targetParentNS = null;
if(phantomNS == null)//1
{ 
return targetModel;
} 

Object parentNS = Model.getFacade().getNamespace(phantomNS);
if(parentNS == null)//1
{ 
return targetModel;
} 

targetParentNS = findNamespace(parentNS, targetModel);
Collection ownedElements =
            Model.getFacade().getOwnedElements(targetParentNS);
String phantomName = Model.getFacade().getName(phantomNS);
String targetName;
if(ownedElements != null)//1
{ 
Object ownedElement;
Iterator iter = ownedElements.iterator();
while (iter.hasNext()) //1
{ 
ownedElement = iter.next();
targetName = Model.getFacade().getName(ownedElement);
if(targetName != null && phantomName.equals(targetName))//1
{ 
if(Model.getFacade().isAPackage(ownedElement))//1
{ 
ns = ownedElement;
break;

} 

} 

} 

} 

if(ns == null)//1
{ 
ns = Model.getModelManagementFactory().createPackage();
Model.getCoreHelper().setName(ns, phantomName);
Model.getCoreHelper().addOwnedElement(targetParentNS, ns);
} 

return ns;
} 

@Override
    public void undoAction(int origStep)
    { 
super.undoAction(origStep);
if(getStep() >= 1)//1
{ 
removePanel(origStep);
} 

if(origStep == 1)//1
{ 
Object oper = getModelElement();
if(addedCreateStereotype)//1
{ 
Model.getCoreHelper().removeStereotype(oper, createStereotype);
} 

} 

} 

@Override
    public int getNumSteps()
    { 
if(possibleConstructor)//1
{ 
return 2;
} 

return 1;
} 

 } 


