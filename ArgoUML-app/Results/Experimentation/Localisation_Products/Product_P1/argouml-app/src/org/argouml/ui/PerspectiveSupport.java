package org.argouml.ui;
import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.TreeModel;
import org.argouml.i18n.Translator;
public class PerspectiveSupport  { 
private List<TreeModel> goRules;
private String name;
private static List<TreeModel> rules = new ArrayList<TreeModel>();
public void removeSubTreeModel(TreeModel tm)
    { 
goRules.remove(tm);
} 
public String getName()
    { 
return name;
} 
public void setName(String s)
    { 
name = s;
} 
public static void registerRule(TreeModel rule)
    { 
rules.add(rule);
} 
public PerspectiveSupport(String n)
    { 
name = Translator.localize(n);
goRules = new ArrayList<TreeModel>();
} 
private PerspectiveSupport()
    { 
} 
protected List<TreeModel> getGoRuleList()
    { 
return goRules;
} 
public void addSubTreeModel(TreeModel tm)
    { 
if(goRules.contains(tm))//1
{ 
return;
} 
goRules.add(tm);
} 
public PerspectiveSupport(String n, List<TreeModel> subs)
    { 
this(n);
goRules = subs;
} 
public List<TreeModel> getSubTreeModelList()
    { 
return goRules;
} 
@Override
    public String toString()
    { 
if(getName() != null)//1
{ 
return getName();
} 
else
{ 
return super.toString();
} 
} 

 } 
