
//#if 1698841647 
// Compilation Unit of /StandardCM.java 
 

//#if -260385988 
package org.argouml.cognitive;
//#endif 


//#if 987884753 
import java.util.ArrayList;
//#endif 


//#if -108213520 
import java.util.List;
//#endif 


//#if -466295460 
class DesignGoalsCM implements 
//#if 1354152627 
ControlMech
//#endif 

  { 

//#if 1701023926 
public boolean isRelevant(Critic c, Designer d)
    { 

//#if -123058025 
return c.isRelevantToGoals(d);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1084187311 
class AndCM extends 
//#if -817572218 
CompositeCM
//#endif 

  { 

//#if 98025370 
public boolean isRelevant(Critic c, Designer d)
    { 

//#if 1352143146 
for (ControlMech cm : getMechList()) //1
{ 

//#if 2088578594 
if(!cm.isRelevant(c, d))//1
{ 

//#if 725916015 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -763552254 
return true;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1420027203 
class OrCM extends 
//#if 779339363 
CompositeCM
//#endif 

  { 

//#if -567143395 
public boolean isRelevant(Critic c, Designer d)
    { 

//#if 1668458509 
for (ControlMech cm : getMechList()) //1
{ 

//#if 1886759825 
if(cm.isRelevant(c, d))//1
{ 

//#if 700307880 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1064700160 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1586949061 
class EnabledCM implements 
//#if 1611062558 
ControlMech
//#endif 

  { 

//#if -1061560085 
public boolean isRelevant(Critic c, Designer d)
    { 

//#if 538776947 
return c.isEnabled();
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1571277426 
public class StandardCM extends 
//#if -1921184784 
AndCM
//#endif 

  { 

//#if -848973566 
public StandardCM()
    { 

//#if -1954162836 
addMech(new EnabledCM());
//#endif 


//#if 161352634 
addMech(new NotSnoozedCM());
//#endif 


//#if -1124949747 
addMech(new DesignGoalsCM());
//#endif 


//#if -1113439449 
addMech(new CurDecisionCM());
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -68311946 
class CurDecisionCM implements 
//#if -458193917 
ControlMech
//#endif 

  { 

//#if 59022694 
public boolean isRelevant(Critic c, Designer d)
    { 

//#if 1972057890 
return c.isRelevantToDecisions(d);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -739257821 
abstract class CompositeCM implements 
//#if -287388217 
ControlMech
//#endif 

  { 

//#if 1045259050 
private List<ControlMech> mechs = new ArrayList<ControlMech>();
//#endif 


//#if -262120193 
public void addMech(ControlMech cm)
    { 

//#if -1847708091 
mechs.add(cm);
//#endif 

} 

//#endif 


//#if 2018871659 
protected List<ControlMech> getMechList()
    { 

//#if -996497323 
return mechs;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -984149051 
class NotSnoozedCM implements 
//#if 699586524 
ControlMech
//#endif 

  { 

//#if -1277292947 
public boolean isRelevant(Critic c, Designer d)
    { 

//#if 2144927592 
return !c.snoozeOrder().getSnoozed();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

