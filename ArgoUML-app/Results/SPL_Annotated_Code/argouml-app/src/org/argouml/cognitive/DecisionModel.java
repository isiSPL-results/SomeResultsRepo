// Compilation Unit of /DecisionModel.java 
 

//#if COGNITIVE 
package org.argouml.cognitive;
//#endif 


//#if COGNITIVE 
import java.io.Serializable;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if COGNITIVE 
import java.util.Observable;
//#endif 


//#if COGNITIVE 
public class DecisionModel extends Observable
 implements Serializable
  { 
private List<Decision> decisions = new ArrayList<Decision>();
public void startConsidering(Decision d)
    { 
decisions.remove(d);
decisions.add(d);
} 

public void stopConsidering(Decision d)
    { 
decisions.remove(d);
} 

public List<Decision> getDecisionList()
    { 
return decisions;
} 

public synchronized void setDecisionPriority(String decision,
            int priority)
    { 
Decision d = findDecision(decision);
if(null == d)//1
{ 
d = new Decision(decision, priority);
decisions.add(d);
return;
} 

d.setPriority(priority);
setChanged();
notifyObservers(decision);
} 

public void defineDecision(String decision, int priority)
    { 
Decision d = findDecision(decision);
if(d == null)//1
{ 
setDecisionPriority(decision, priority);
} 

} 

protected Decision findDecision(String decName)
    { 
for (Decision d : decisions) //1
{ 
if(decName.equals(d.getName()))//1
{ 
return d;
} 

} 

return null;
} 

public DecisionModel()
    { 
decisions.add(Decision.UNSPEC);
} 

 } 

//#endif 


