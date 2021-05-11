
//#if -704461570 
// Compilation Unit of /ExplorerPerspective.java 
 

//#if 571240440 
package org.argouml.ui.explorer;
//#endif 


//#if -1025723061 
import java.util.List;
//#endif 


//#if -734182570 
import java.util.ArrayList;
//#endif 


//#if 398172318 
import org.argouml.ui.explorer.rules.PerspectiveRule;
//#endif 


//#if 850757760 
import org.argouml.i18n.Translator;
//#endif 


//#if 1606281915 
public class ExplorerPerspective  { 

//#if -1497582590 
private List<PerspectiveRule> rules;
//#endif 


//#if -331958503 
private String name;
//#endif 


//#if -1659581373 
public void removeRule(PerspectiveRule rule)
    { 

//#if -1156637083 
rules.remove(rule);
//#endif 

} 

//#endif 


//#if 986784768 
public ExplorerPerspective(String newName)
    { 

//#if 1724605866 
name = Translator.localize(newName);
//#endif 


//#if 1931789631 
rules = new ArrayList<PerspectiveRule>();
//#endif 

} 

//#endif 


//#if 1309026334 
protected void setName(String theNewName)
    { 

//#if -2033161090 
this.name = theNewName;
//#endif 

} 

//#endif 


//#if -556929258 
@Override
    public String toString()
    { 

//#if -806961854 
return name;
//#endif 

} 

//#endif 


//#if 581315066 
public void addRule(PerspectiveRule rule)
    { 

//#if 1717877343 
rules.add(rule);
//#endif 

} 

//#endif 


//#if 1074760654 
public ExplorerPerspective makeNamedClone(String newName)
    { 

//#if -1399726470 
ExplorerPerspective ep = new ExplorerPerspective(newName);
//#endif 


//#if 349122856 
ep.rules.addAll(rules);
//#endif 


//#if 1995963885 
return ep;
//#endif 

} 

//#endif 


//#if 1038467255 
public List<PerspectiveRule> getList()
    { 

//#if -1197736904 
return rules;
//#endif 

} 

//#endif 


//#if 1104948690 
public Object[] getRulesArray()
    { 

//#if -381908221 
return rules.toArray();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

