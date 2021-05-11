// Compilation Unit of /CompoundCritic.java 
 

//#if COGNITIVE 
package org.argouml.cognitive;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.HashSet;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if COGNITIVE 
import java.util.Set;
//#endif 


//#if COGNITIVE 
import javax.swing.Icon;
//#endif 


//#if COGNITIVE 
public class CompoundCritic extends Critic
  { 
private List<Critic> critics = new ArrayList<Critic>();
private Set<Object> extraDesignMaterials = new HashSet<Object>();
@Override
    public void addKnowledgeType(String type)
    { 
throw new UnsupportedOperationException();
} 

public void setCritics(List<Critic> c)
    { 
critics = c;
} 

public void addExtraCriticizedDesignMaterial(Object dm)
    { 
this.extraDesignMaterials.add(dm);
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
for (Critic cr : this.critics) //1
{ 
ret.addAll(cr.getCriticizedDesignMaterials());
} 

ret.addAll(extraDesignMaterials);
return ret;
} 

public void addCritic(Critic c)
    { 
critics.add(c);
} 

public CompoundCritic(Critic c1, Critic c2, Critic c3)
    { 
this(c1, c2);
critics.add(c3);
} 

@Override
    public List<Goal> getSupportedGoals()
    { 
throw new UnsupportedOperationException();
} 

public void removeCritic(Critic c)
    { 
critics.remove(c);
} 

@Override
    public boolean supports(Goal g)
    { 
for (Critic c : critics) //1
{ 
if(c.supports(g))//1
{ 
return true;
} 

} 

return false;
} 

@Override
    public boolean containsKnowledgeType(String type)
    { 
for (Critic c : critics) //1
{ 
if(c.containsKnowledgeType(type))//1
{ 
return true;
} 

} 

return false;
} 

@Override
    public void addSupportedGoal(Goal g)
    { 
throw new UnsupportedOperationException();
} 

@Override
    public void addSupportedDecision(Decision d)
    { 
throw new UnsupportedOperationException();
} 

@Override
    public Icon getClarifier()
    { 
throw new UnsupportedOperationException();
} 

@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 
throw new UnsupportedOperationException();
} 

@Override
    public List<Decision> getSupportedDecisions()
    { 
throw new UnsupportedOperationException();
} 

@Override
    public boolean isEnabled()
    { 
return true;
} 

public CompoundCritic()
    { 
} 

@Override
    public boolean supports(Decision d)
    { 
for (Critic c : critics) //1
{ 
if(c.supports(d))//1
{ 
return true;
} 

} 

return false;
} 

public CompoundCritic(Critic c1, Critic c2)
    { 
this();
critics.add(c1);
critics.add(c2);
} 

@Override
    public boolean isActive()
    { 
for (Critic c : critics) //1
{ 
if(c.isActive())//1
{ 
return true;
} 

} 

return false;
} 

public List<Critic> getCriticList()
    { 
return critics;
} 

public String toString()
    { 
return critics.toString();
} 

@Override
    public String expand(String desc, ListSet offs)
    { 
throw new UnsupportedOperationException();
} 

public CompoundCritic(Critic c1, Critic c2, Critic c3, Critic c4)
    { 
this(c1, c2, c3);
critics.add(c4);
} 

@Override
    public void critique(Object dm, Designer dsgr)
    { 
for (Critic c : critics) //1
{ 
if(c.isActive() && c.predicate(dm, dsgr))//1
{ 
ToDoItem item = c.toDoItem(dm, dsgr);
postItem(item, dm, dsgr);
return;
} 

} 

} 

 } 

//#endif 


