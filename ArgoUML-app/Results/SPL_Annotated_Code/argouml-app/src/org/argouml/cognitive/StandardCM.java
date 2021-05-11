// Compilation Unit of /StandardCM.java 
 

//#if COGNITIVE 
package org.argouml.cognitive;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if COGNITIVE 
class DesignGoalsCM implements ControlMech
  { 
public boolean isRelevant(Critic c, Designer d)
    { 
return c.isRelevantToGoals(d);
} 

 } 

//#endif 


//#if COGNITIVE 
class AndCM extends CompositeCM
  { 
public boolean isRelevant(Critic c, Designer d)
    { 
for (ControlMech cm : getMechList()) //1
{ 
if(!cm.isRelevant(c, d))//1
{ 
return false;
} 

} 

return true;
} 

 } 

//#endif 


//#if COGNITIVE 
class OrCM extends CompositeCM
  { 
public boolean isRelevant(Critic c, Designer d)
    { 
for (ControlMech cm : getMechList()) //1
{ 
if(cm.isRelevant(c, d))//1
{ 
return true;
} 

} 

return false;
} 

 } 

//#endif 


//#if COGNITIVE 
class EnabledCM implements ControlMech
  { 
public boolean isRelevant(Critic c, Designer d)
    { 
return c.isEnabled();
} 

 } 

//#endif 


//#if COGNITIVE 
public class StandardCM extends AndCM
  { 
public StandardCM()
    { 
addMech(new EnabledCM());
addMech(new NotSnoozedCM());
addMech(new DesignGoalsCM());
addMech(new CurDecisionCM());
} 

 } 

//#endif 


//#if COGNITIVE 
class CurDecisionCM implements ControlMech
  { 
public boolean isRelevant(Critic c, Designer d)
    { 
return c.isRelevantToDecisions(d);
} 

 } 

//#endif 


//#if COGNITIVE 
abstract class CompositeCM implements ControlMech
  { 
private List<ControlMech> mechs = new ArrayList<ControlMech>();
public void addMech(ControlMech cm)
    { 
mechs.add(cm);
} 

protected List<ControlMech> getMechList()
    { 
return mechs;
} 

 } 

//#endif 


//#if COGNITIVE 
class NotSnoozedCM implements ControlMech
  { 
public boolean isRelevant(Critic c, Designer d)
    { 
return !c.snoozeOrder().getSnoozed();
} 

 } 

//#endif 


