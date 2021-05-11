
//#if -299678102 
// Compilation Unit of /WizCueCards.java 
 

//#if -481073044 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -821859606 
import java.util.ArrayList;
//#endif 


//#if 249110839 
import java.util.List;
//#endif 


//#if -226288141 
import javax.swing.JPanel;
//#endif 


//#if 1500907417 
import org.argouml.cognitive.ui.WizStepCue;
//#endif 


//#if -1598389558 
public class WizCueCards extends 
//#if 584647979 
UMLWizard
//#endif 

  { 

//#if -94274285 
private List cues = new ArrayList();
//#endif 


//#if -1602974097 
public void doAction(int oldStep) { 
} 

//#endif 


//#if -74043158 
@Override
    public int getNumSteps()
    { 

//#if -1690011541 
return cues.size();
//#endif 

} 

//#endif 


//#if -664380451 
@Override
    public boolean canFinish()
    { 

//#if -132956550 
return getStep() == getNumSteps();
//#endif 

} 

//#endif 


//#if -1782241540 
public WizCueCards() { 
} 

//#endif 


//#if -674566804 
public void addCue(String s)
    { 

//#if -1301952083 
cues.add(s);
//#endif 

} 

//#endif 


//#if 390531811 
public JPanel makePanel(int newStep)
    { 

//#if 483557511 
if(newStep <= getNumSteps())//1
{ 

//#if -1150706737 
String c = (String) cues.get(newStep - 1);
//#endif 


//#if 1747673970 
return new WizStepCue(this, c);
//#endif 

} 

//#endif 


//#if -259462611 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

