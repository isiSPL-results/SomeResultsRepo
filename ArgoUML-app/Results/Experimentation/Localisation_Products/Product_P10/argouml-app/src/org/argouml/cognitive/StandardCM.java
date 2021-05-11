package org.argouml.cognitive;
import java.util.ArrayList;
import java.util.List;
class DesignGoalsCM implements ControlMech
  { 
public boolean isRelevant(Critic c, Designer d)
    { 
return c.isRelevantToGoals(d);
} 

 } 
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
class EnabledCM implements ControlMech
  { 
public boolean isRelevant(Critic c, Designer d)
    { 
return c.isEnabled();
} 

 } 
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
class CurDecisionCM implements ControlMech
  { 
public boolean isRelevant(Critic c, Designer d)
    { 
return c.isRelevantToDecisions(d);
} 

 } 
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
class NotSnoozedCM implements ControlMech
  { 
public boolean isRelevant(Critic c, Designer d)
    { 
return !c.snoozeOrder().getSnoozed();
} 

 } 
