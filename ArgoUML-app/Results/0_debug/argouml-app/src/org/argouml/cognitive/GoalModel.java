
//#if 1225914210 
// Compilation Unit of /GoalModel.java 
 

//#if 1235782891 
package org.argouml.cognitive;
//#endif 


//#if 1506897666 
import java.io.Serializable;
//#endif 


//#if -1129633406 
import java.util.ArrayList;
//#endif 


//#if 1196073887 
import java.util.List;
//#endif 


//#if -1051379174 
import java.util.Observable;
//#endif 


//#if -273302848 
public class GoalModel extends 
//#if -599718645 
Observable
//#endif 

 implements 
//#if 575837895 
Serializable
//#endif 

  { 

//#if 1381242863 
private List<Goal> goals = new ArrayList<Goal>();
//#endif 


//#if 1413960555 
public synchronized void setGoalPriority(String goalName, int priority)
    { 

//#if 63877355 
Goal g = new Goal(goalName, priority);
//#endif 


//#if 207258622 
goals.remove(g);
//#endif 


//#if 329112745 
goals.add(g);
//#endif 

} 

//#endif 


//#if -1524470218 
public void startDesiring(String goalName)
    { 

//#if 808536549 
addGoal(new Goal(goalName, 1));
//#endif 

} 

//#endif 


//#if -1230253946 
public GoalModel()
    { 

//#if -606602956 
addGoal(Goal.getUnspecifiedGoal());
//#endif 

} 

//#endif 


//#if -237634200 
public boolean hasGoal(String goalName)
    { 

//#if 174166769 
for (Goal g : goals) //1
{ 

//#if 106422780 
if(g.getName().equals(goalName))//1
{ 

//#if 132086638 
return g.getPriority() > 0;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1123033082 
return false;
//#endif 

} 

//#endif 


//#if 1178969098 
public List<Goal> getGoalList()
    { 

//#if 1557105596 
return goals;
//#endif 

} 

//#endif 


//#if -1137614720 
public void stopDesiring(String goalName)
    { 

//#if 1548410570 
removeGoal(new Goal(goalName, 0));
//#endif 

} 

//#endif 


//#if -233022002 
public void addGoal(Goal g)
    { 

//#if 492309836 
goals.add(g);
//#endif 

} 

//#endif 


//#if 341925665 
public void removeGoal(Goal g)
    { 

//#if 344210079 
goals.remove(g);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

