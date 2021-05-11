// Compilation Unit of /GeneratorManager.java 
 
package org.argouml.uml.generator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoGeneratorEvent;
import org.argouml.model.Model;
import org.argouml.uml.reveng.ImportInterface;
public final class GeneratorManager  { 
private static final Logger LOG =
        Logger.getLogger(GeneratorManager.class);
private static final GeneratorManager INSTANCE =
        new GeneratorManager();
private Map<Language, CodeGenerator> generators =
        new HashMap<Language, CodeGenerator>();
private Language currLanguage = null;
public CodeGenerator removeGenerator(Language lang)
    { 
CodeGenerator old = generators.remove(lang);
if(lang.equals(currLanguage))//1
{ 
Iterator it = generators.keySet().iterator();
if(it.hasNext())//1
{ 
currLanguage = (Language) it.next();
} 
else
{ 
currLanguage = null;
} 

} 

if(old != null)//1
{ 
ArgoEventPump.fireEvent(
                new ArgoGeneratorEvent(
                    ArgoEventTypes.GENERATOR_REMOVED, old));
} 

LOG.debug("Removed generator " + old + " for " + lang);
return old;
} 

public CodeGenerator getGenerator(Language lang)
    { 
if(lang == null)//1
{ 
return null;
} 

return generators.get(lang);
} 

public CodeGenerator getGenerator(String name)
    { 
Language lang = findLanguage(name);
return getGenerator(lang);
} 

public CodeGenerator removeGenerator(String name)
    { 
Language lang = findLanguage(name);
if(lang != null)//1
{ 
return removeGenerator(lang);
} 

return null;
} 

public Set<Language> getLanguages()
    { 
return generators.keySet();
} 

public Language findLanguage(String name)
    { 
for (Language lang : getLanguages()) //1
{ 
if(lang.getName().equals(name))//1
{ 
return lang;
} 

} 

return null;
} 

public void addGenerator(Language lang, CodeGenerator gen)
    { 
if(currLanguage == null)//1
{ 
currLanguage = lang;
} 

generators.put(lang, gen);
ArgoEventPump.fireEvent(
            new ArgoGeneratorEvent(ArgoEventTypes.GENERATOR_ADDED, gen));
LOG.debug("Added generator " + gen + " for " + lang);
} 

public Language getCurrLanguage()
    { 
return currLanguage;
} 

public Map<Language, CodeGenerator> getGenerators()
    { 
Object  clone = ((HashMap<Language, CodeGenerator>) generators).clone();
return (Map<Language, CodeGenerator>) clone;
} 

public CodeGenerator getCurrGenerator()
    { 
return currLanguage == null ? null : getGenerator(currLanguage);
} 

public static GeneratorManager getInstance()
    { 
return INSTANCE;
} 

public static String getCodePath(Object me)
    { 
if(me == null)//1
{ 
return null;
} 

Object taggedValue = Model.getFacade().getTaggedValue(me,
                             ImportInterface.SOURCE_PATH_TAG);
String s;
if(taggedValue == null)//1
{ 
return null;
} 

s =  Model.getFacade().getValueOfTag(taggedValue);
if(s != null)//1
{ 
return s.trim();
} 

return null;
} 

private GeneratorManager()
    { 
} 

 } 


