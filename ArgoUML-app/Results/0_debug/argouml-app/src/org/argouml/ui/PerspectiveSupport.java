
//#if 1081850296 
// Compilation Unit of /PerspectiveSupport.java 
 

//#if 1379151224 
package org.argouml.ui;
//#endif 


//#if 227026141 
import java.util.ArrayList;
//#endif 


//#if -1332823196 
import java.util.List;
//#endif 


//#if 1132395231 
import javax.swing.tree.TreeModel;
//#endif 


//#if -676990201 
import org.argouml.i18n.Translator;
//#endif 


//#if -2107731698 
public class PerspectiveSupport  { 

//#if 1940861485 
private List<TreeModel> goRules;
//#endif 


//#if 2130748975 
private String name;
//#endif 


//#if 427175227 
private static List<TreeModel> rules = new ArrayList<TreeModel>();
//#endif 


//#if -1193154962 
public void removeSubTreeModel(TreeModel tm)
    { 

//#if 546152335 
goRules.remove(tm);
//#endif 

} 

//#endif 


//#if 1446227509 
public String getName()
    { 

//#if -1346066675 
return name;
//#endif 

} 

//#endif 


//#if -107228334 
public void setName(String s)
    { 

//#if 259679196 
name = s;
//#endif 

} 

//#endif 


//#if 1753428941 
public static void registerRule(TreeModel rule)
    { 

//#if 1354986827 
rules.add(rule);
//#endif 

} 

//#endif 


//#if 2088514149 
public PerspectiveSupport(String n)
    { 

//#if -316101709 
name = Translator.localize(n);
//#endif 


//#if 964745664 
goRules = new ArrayList<TreeModel>();
//#endif 

} 

//#endif 


//#if -1712338012 
private PerspectiveSupport()
    { 
} 

//#endif 


//#if -2104227005 
protected List<TreeModel> getGoRuleList()
    { 

//#if 199779605 
return goRules;
//#endif 

} 

//#endif 


//#if -42380271 
public void addSubTreeModel(TreeModel tm)
    { 

//#if 1949205771 
if(goRules.contains(tm))//1
{ 

//#if 1583857842 
return;
//#endif 

} 

//#endif 


//#if -736084225 
goRules.add(tm);
//#endif 

} 

//#endif 


//#if -865542131 
public PerspectiveSupport(String n, List<TreeModel> subs)
    { 

//#if 1248190122 
this(n);
//#endif 


//#if 330085990 
goRules = subs;
//#endif 

} 

//#endif 


//#if 1610010123 
public List<TreeModel> getSubTreeModelList()
    { 

//#if 1857062173 
return goRules;
//#endif 

} 

//#endif 


//#if 1391440832 
@Override
    public String toString()
    { 

//#if 1198244439 
if(getName() != null)//1
{ 

//#if -1295425941 
return getName();
//#endif 

} 
else
{ 

//#if 692793134 
return super.toString();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

