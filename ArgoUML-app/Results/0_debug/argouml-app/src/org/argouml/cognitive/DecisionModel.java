
//#if 1498442670 
// Compilation Unit of /DecisionModel.java 
 

//#if 1246494309 
package org.argouml.cognitive;
//#endif 


//#if -1112082692 
import java.io.Serializable;
//#endif 


//#if -1906853304 
import java.util.ArrayList;
//#endif 


//#if -938725607 
import java.util.List;
//#endif 


//#if 624607764 
import java.util.Observable;
//#endif 


//#if -353065763 
public class DecisionModel extends 
//#if 1966647756 
Observable
//#endif 

 implements 
//#if 1542721352 
Serializable
//#endif 

  { 

//#if -1567396967 
private List<Decision> decisions = new ArrayList<Decision>();
//#endif 


//#if 2112051100 
public void startConsidering(Decision d)
    { 

//#if -249293922 
decisions.remove(d);
//#endif 


//#if 58055011 
decisions.add(d);
//#endif 

} 

//#endif 


//#if -1948897464 
public void stopConsidering(Decision d)
    { 

//#if 1118754589 
decisions.remove(d);
//#endif 

} 

//#endif 


//#if 300128955 
public List<Decision> getDecisionList()
    { 

//#if 901134041 
return decisions;
//#endif 

} 

//#endif 


//#if 1669386997 
public synchronized void setDecisionPriority(String decision,
            int priority)
    { 

//#if 2050317386 
Decision d = findDecision(decision);
//#endif 


//#if -760924868 
if(null == d)//1
{ 

//#if -1707746275 
d = new Decision(decision, priority);
//#endif 


//#if -1806809036 
decisions.add(d);
//#endif 


//#if -552346745 
return;
//#endif 

} 

//#endif 


//#if -1692009916 
d.setPriority(priority);
//#endif 


//#if -1389673978 
setChanged();
//#endif 


//#if -608125564 
notifyObservers(decision);
//#endif 

} 

//#endif 


//#if -684564054 
public void defineDecision(String decision, int priority)
    { 

//#if 1247153612 
Decision d = findDecision(decision);
//#endif 


//#if -1509509976 
if(d == null)//1
{ 

//#if -2071499872 
setDecisionPriority(decision, priority);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1328403873 
protected Decision findDecision(String decName)
    { 

//#if -308083475 
for (Decision d : decisions) //1
{ 

//#if 437507362 
if(decName.equals(d.getName()))//1
{ 

//#if -1573555960 
return d;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -283470685 
return null;
//#endif 

} 

//#endif 


//#if -710167364 
public DecisionModel()
    { 

//#if 571133033 
decisions.add(Decision.UNSPEC);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

