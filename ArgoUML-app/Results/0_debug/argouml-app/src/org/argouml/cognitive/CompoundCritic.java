
//#if 954084951 
// Compilation Unit of /CompoundCritic.java 
 

//#if 1549070019 
package org.argouml.cognitive;
//#endif 


//#if 1819661994 
import java.util.ArrayList;
//#endif 


//#if 2028430829 
import java.util.HashSet;
//#endif 


//#if 1929534839 
import java.util.List;
//#endif 


//#if -1461572929 
import java.util.Set;
//#endif 


//#if -1151543852 
import javax.swing.Icon;
//#endif 


//#if -1480992979 
public class CompoundCritic extends 
//#if -454209947 
Critic
//#endif 

  { 

//#if -322612775 
private List<Critic> critics = new ArrayList<Critic>();
//#endif 


//#if -884056585 
private Set<Object> extraDesignMaterials = new HashSet<Object>();
//#endif 


//#if -620703963 
@Override
    public void addKnowledgeType(String type)
    { 

//#if 1024264161 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 1725494799 
public void setCritics(List<Critic> c)
    { 

//#if -538518797 
critics = c;
//#endif 

} 

//#endif 


//#if -1730597793 
public void addExtraCriticizedDesignMaterial(Object dm)
    { 

//#if -1275118986 
this.extraDesignMaterials.add(dm);
//#endif 

} 

//#endif 


//#if -206577088 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -303621516 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 841128029 
for (Critic cr : this.critics) //1
{ 

//#if -1390863814 
ret.addAll(cr.getCriticizedDesignMaterials());
//#endif 

} 

//#endif 


//#if 1397536025 
ret.addAll(extraDesignMaterials);
//#endif 


//#if -835480708 
return ret;
//#endif 

} 

//#endif 


//#if 2058891355 
public void addCritic(Critic c)
    { 

//#if -1346754972 
critics.add(c);
//#endif 

} 

//#endif 


//#if 1118907543 
public CompoundCritic(Critic c1, Critic c2, Critic c3)
    { 

//#if -1211134650 
this(c1, c2);
//#endif 


//#if 1981357321 
critics.add(c3);
//#endif 

} 

//#endif 


//#if -1277154504 
@Override
    public List<Goal> getSupportedGoals()
    { 

//#if -973273814 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 1168642236 
public void removeCritic(Critic c)
    { 

//#if 85725779 
critics.remove(c);
//#endif 

} 

//#endif 


//#if -959424267 
@Override
    public boolean supports(Goal g)
    { 

//#if 1756975076 
for (Critic c : critics) //1
{ 

//#if -31765315 
if(c.supports(g))//1
{ 

//#if 1832933033 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1717588959 
return false;
//#endif 

} 

//#endif 


//#if -37223253 
@Override
    public boolean containsKnowledgeType(String type)
    { 

//#if 377044032 
for (Critic c : critics) //1
{ 

//#if 1733033743 
if(c.containsKnowledgeType(type))//1
{ 

//#if -101673333 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1830281541 
return false;
//#endif 

} 

//#endif 


//#if 952273413 
@Override
    public void addSupportedGoal(Goal g)
    { 

//#if -196461526 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 848885320 
@Override
    public void addSupportedDecision(Decision d)
    { 

//#if -647727753 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if -2104313529 
@Override
    public Icon getClarifier()
    { 

//#if 1289245572 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if -1855747790 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 726565981 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if -1965203688 
@Override
    public List<Decision> getSupportedDecisions()
    { 

//#if 1217730947 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 1614312116 
@Override
    public boolean isEnabled()
    { 

//#if -1560763529 
return true;
//#endif 

} 

//#endif 


//#if 1228976026 
public CompoundCritic()
    { 
} 

//#endif 


//#if 1713109793 
@Override
    public boolean supports(Decision d)
    { 

//#if -299676550 
for (Critic c : critics) //1
{ 

//#if -1471946021 
if(c.supports(d))//1
{ 

//#if -1954043611 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1311395509 
return false;
//#endif 

} 

//#endif 


//#if 1544331275 
public CompoundCritic(Critic c1, Critic c2)
    { 

//#if -494775130 
this();
//#endif 


//#if 1047548716 
critics.add(c1);
//#endif 


//#if 1047549677 
critics.add(c2);
//#endif 

} 

//#endif 


//#if -1167880811 
@Override
    public boolean isActive()
    { 

//#if -295088639 
for (Critic c : critics) //1
{ 

//#if -634903739 
if(c.isActive())//1
{ 

//#if -1286632026 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2103533092 
return false;
//#endif 

} 

//#endif 


//#if 366800643 
public List<Critic> getCriticList()
    { 

//#if -185224804 
return critics;
//#endif 

} 

//#endif 


//#if -360736872 
public String toString()
    { 

//#if 288573114 
return critics.toString();
//#endif 

} 

//#endif 


//#if -1077691534 
@Override
    public String expand(String desc, ListSet offs)
    { 

//#if 1852022672 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 1452539306 
public CompoundCritic(Critic c1, Critic c2, Critic c3, Critic c4)
    { 

//#if -496944258 
this(c1, c2, c3);
//#endif 


//#if -648424250 
critics.add(c4);
//#endif 

} 

//#endif 


//#if 350583006 
@Override
    public void critique(Object dm, Designer dsgr)
    { 

//#if 783692786 
for (Critic c : critics) //1
{ 

//#if 679995058 
if(c.isActive() && c.predicate(dm, dsgr))//1
{ 

//#if 1326673099 
ToDoItem item = c.toDoItem(dm, dsgr);
//#endif 


//#if -729046886 
postItem(item, dm, dsgr);
//#endif 


//#if -184295910 
return;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

