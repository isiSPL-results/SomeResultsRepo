package org.argouml.ui.explorer;
import java.util.List;
import java.util.ArrayList;
import org.argouml.ui.explorer.rules.PerspectiveRule;
import org.argouml.i18n.Translator;
public class ExplorerPerspective  { 
private List<PerspectiveRule> rules;
private String name;
public void removeRule(PerspectiveRule rule)
    { 
rules.remove(rule);
} 
public ExplorerPerspective(String newName)
    { 
name = Translator.localize(newName);
rules = new ArrayList<PerspectiveRule>();
} 
protected void setName(String theNewName)
    { 
this.name = theNewName;
} 
@Override
    public String toString()
    { 
return name;
} 
public void addRule(PerspectiveRule rule)
    { 
rules.add(rule);
} 
public ExplorerPerspective makeNamedClone(String newName)
    { 
ExplorerPerspective ep = new ExplorerPerspective(newName);
ep.rules.addAll(rules);
return ep;
} 
public List<PerspectiveRule> getList()
    { 
return rules;
} 
public Object[] getRulesArray()
    { 
return rules.toArray();
} 

 } 
