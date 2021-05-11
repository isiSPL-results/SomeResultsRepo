package org.argouml.cognitive;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
public class GoalModel extends Observable
 implements Serializable
  { 
private List<Goal> goals = new ArrayList<Goal>();
public synchronized void setGoalPriority(String goalName, int priority)
    { 
Goal g = new Goal(goalName, priority);
goals.remove(g);
goals.add(g);
} 
public void startDesiring(String goalName)
    { 
addGoal(new Goal(goalName, 1));
} 
public GoalModel()
    { 
addGoal(Goal.getUnspecifiedGoal());
} 
public boolean hasGoal(String goalName)
    { 
for (Goal g : goals) //1
{ 
if(g.getName().equals(goalName))//1
{ 
return g.getPriority() > 0;
} 
} 
return false;
} 
public List<Goal> getGoalList()
    { 
return goals;
} 
public void stopDesiring(String goalName)
    { 
removeGoal(new Goal(goalName, 0));
} 
public void addGoal(Goal g)
    { 
goals.add(g);
} 
public void removeGoal(Goal g)
    { 
goals.remove(g);
} 

 } 
