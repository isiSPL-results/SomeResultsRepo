
//#if 2035533401 
// Compilation Unit of /WizMEName.java 
 

//#if 1312254765 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1360970420 
import javax.swing.JPanel;
//#endif 


//#if -1752051386 
import org.apache.log4j.Logger;
//#endif 


//#if 551831198 
import org.argouml.cognitive.ui.WizStepTextField;
//#endif 


//#if 1133510771 
import org.argouml.i18n.Translator;
//#endif 


//#if 95485113 
import org.argouml.model.Model;
//#endif 


//#if 2014935836 
public class WizMEName extends 
//#if 1394409950 
UMLWizard
//#endif 

  { 

//#if 1449053974 
private static final Logger LOG = Logger.getLogger(WizMEName.class);
//#endif 


//#if -52228023 
private String instructions = Translator.localize("critics.WizMEName-ins");
//#endif 


//#if 94720756 
private String label = Translator.localize("label.name");
//#endif 


//#if 1702399004 
private boolean mustEdit = false;
//#endif 


//#if 1602865761 
private WizStepTextField step1 = null;
//#endif 


//#if 650934443 
private String origSuggest;
//#endif 


//#if -436385538 
public void setMustEdit(boolean b)
    { 

//#if 962642727 
mustEdit = b;
//#endif 

} 

//#endif 


//#if 396203430 
public void setInstructions(String s)
    { 

//#if -1536462962 
instructions = s;
//#endif 

} 

//#endif 


//#if 770542942 
protected String getInstructions()
    { 

//#if -1958940969 
return instructions;
//#endif 

} 

//#endif 


//#if 1107215022 
public boolean canGoNext()
    { 

//#if -16328345 
if(!super.canGoNext())//1
{ 

//#if 460505174 
return false;
//#endif 

} 

//#endif 


//#if -1712344919 
if(step1 != null)//1
{ 

//#if -709281416 
boolean changed = origSuggest.equals(step1.getText());
//#endif 


//#if 1763443185 
if(mustEdit && !changed)//1
{ 

//#if -1693619495 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1186919289 
return true;
//#endif 

} 

//#endif 


//#if -758408409 
public void setSuggestion(String s)
    { 

//#if -1950552290 
origSuggest = s;
//#endif 


//#if 1008427956 
super.setSuggestion(s);
//#endif 

} 

//#endif 


//#if 1870277090 
public WizMEName() { 
} 

//#endif 


//#if -79196260 
public void doAction(int oldStep)
    { 

//#if -678553190 
LOG.debug("doAction " + oldStep);
//#endif 


//#if -2128914552 
switch (oldStep) //1
{ 
case 1://1


//#if -1380067725 
String newName = getSuggestion();
//#endif 


//#if 1569073973 
if(step1 != null)//1
{ 

//#if 1372066269 
newName = step1.getText();
//#endif 

} 

//#endif 


//#if 1661015942 
try //1
{ 

//#if -294733700 
Object me = getModelElement();
//#endif 


//#if -981942290 
Model.getCoreHelper().setName(me, newName);
//#endif 

} 

//#if 712420840 
catch (Exception pve) //1
{ 

//#if -1534039977 
LOG.error("could not set name", pve);
//#endif 

} 

//#endif 


//#endif 


//#if 1145145324 
break;

//#endif 


} 

//#endif 

} 

//#endif 


//#if 1746722454 
public JPanel makePanel(int newStep)
    { 

//#if 1330001403 
switch (newStep) //1
{ 
case 1://1


//#if -1377022695 
if(step1 == null)//1
{ 

//#if -1964328516 
step1 = new WizStepTextField(this, instructions,
                                             label, offerSuggestion());
//#endif 

} 

//#endif 


//#if 309963382 
return step1;
//#endif 


} 

//#endif 


//#if -1811090604 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

