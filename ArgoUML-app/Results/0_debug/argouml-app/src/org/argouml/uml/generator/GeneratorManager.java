
//#if 1172968364 
// Compilation Unit of /GeneratorManager.java 
 

//#if 1072394996 
package org.argouml.uml.generator;
//#endif 


//#if -788240381 
import java.util.HashMap;
//#endif 


//#if -954265385 
import java.util.Iterator;
//#endif 


//#if -706898731 
import java.util.Map;
//#endif 


//#if -706716017 
import java.util.Set;
//#endif 


//#if 2096226551 
import org.apache.log4j.Logger;
//#endif 


//#if 1235541942 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -234614177 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 2040118359 
import org.argouml.application.events.ArgoGeneratorEvent;
//#endif 


//#if -351204246 
import org.argouml.model.Model;
//#endif 


//#if -421757747 
import org.argouml.uml.reveng.ImportInterface;
//#endif 


//#if 1065009334 
public final class GeneratorManager  { 

//#if 418502639 
private static final Logger LOG =
        Logger.getLogger(GeneratorManager.class);
//#endif 


//#if 569495568 
private static final GeneratorManager INSTANCE =
        new GeneratorManager();
//#endif 


//#if -1381106175 
private Map<Language, CodeGenerator> generators =
        new HashMap<Language, CodeGenerator>();
//#endif 


//#if -1755660701 
private Language currLanguage = null;
//#endif 


//#if 2010816518 
public CodeGenerator removeGenerator(Language lang)
    { 

//#if 1757236697 
CodeGenerator old = generators.remove(lang);
//#endif 


//#if 233136300 
if(lang.equals(currLanguage))//1
{ 

//#if 1828001727 
Iterator it = generators.keySet().iterator();
//#endif 


//#if 378701387 
if(it.hasNext())//1
{ 

//#if -658700794 
currLanguage = (Language) it.next();
//#endif 

} 
else
{ 

//#if 1561800866 
currLanguage = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1586063552 
if(old != null)//1
{ 

//#if -1557524749 
ArgoEventPump.fireEvent(
                new ArgoGeneratorEvent(
                    ArgoEventTypes.GENERATOR_REMOVED, old));
//#endif 

} 

//#endif 


//#if 825611098 
LOG.debug("Removed generator " + old + " for " + lang);
//#endif 


//#if 319413693 
return old;
//#endif 

} 

//#endif 


//#if -383150084 
public CodeGenerator getGenerator(Language lang)
    { 

//#if 1280227551 
if(lang == null)//1
{ 

//#if 989220485 
return null;
//#endif 

} 

//#endif 


//#if 157587015 
return generators.get(lang);
//#endif 

} 

//#endif 


//#if 1841513510 
public CodeGenerator getGenerator(String name)
    { 

//#if -56493323 
Language lang = findLanguage(name);
//#endif 


//#if -977611581 
return getGenerator(lang);
//#endif 

} 

//#endif 


//#if -2142583120 
public CodeGenerator removeGenerator(String name)
    { 

//#if 1667243569 
Language lang = findLanguage(name);
//#endif 


//#if -311512880 
if(lang != null)//1
{ 

//#if -1961964270 
return removeGenerator(lang);
//#endif 

} 

//#endif 


//#if -1333079408 
return null;
//#endif 

} 

//#endif 


//#if 640699504 
public Set<Language> getLanguages()
    { 

//#if -778632567 
return generators.keySet();
//#endif 

} 

//#endif 


//#if 1131152816 
public Language findLanguage(String name)
    { 

//#if 936140040 
for (Language lang : getLanguages()) //1
{ 

//#if -1490322530 
if(lang.getName().equals(name))//1
{ 

//#if -320395540 
return lang;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1291993737 
return null;
//#endif 

} 

//#endif 


//#if -2005234823 
public void addGenerator(Language lang, CodeGenerator gen)
    { 

//#if -1435363336 
if(currLanguage == null)//1
{ 

//#if 1629536961 
currLanguage = lang;
//#endif 

} 

//#endif 


//#if 893411295 
generators.put(lang, gen);
//#endif 


//#if -1633132452 
ArgoEventPump.fireEvent(
            new ArgoGeneratorEvent(ArgoEventTypes.GENERATOR_ADDED, gen));
//#endif 


//#if -194207394 
LOG.debug("Added generator " + gen + " for " + lang);
//#endif 

} 

//#endif 


//#if 771157415 
public Language getCurrLanguage()
    { 

//#if -1179871358 
return currLanguage;
//#endif 

} 

//#endif 


//#if 1866571469 
public Map<Language, CodeGenerator> getGenerators()
    { 

//#if 396249001 
Object  clone = ((HashMap<Language, CodeGenerator>) generators).clone();
//#endif 


//#if 1531712758 
return (Map<Language, CodeGenerator>) clone;
//#endif 

} 

//#endif 


//#if -623354480 
public CodeGenerator getCurrGenerator()
    { 

//#if 986676855 
return currLanguage == null ? null : getGenerator(currLanguage);
//#endif 

} 

//#endif 


//#if 525024994 
public static GeneratorManager getInstance()
    { 

//#if -1453284119 
return INSTANCE;
//#endif 

} 

//#endif 


//#if -1935475695 
public static String getCodePath(Object me)
    { 

//#if -690164817 
if(me == null)//1
{ 

//#if -133009993 
return null;
//#endif 

} 

//#endif 


//#if 1927341573 
Object taggedValue = Model.getFacade().getTaggedValue(me,
                             ImportInterface.SOURCE_PATH_TAG);
//#endif 


//#if -1639622148 
String s;
//#endif 


//#if 1213552748 
if(taggedValue == null)//1
{ 

//#if 1481546300 
return null;
//#endif 

} 

//#endif 


//#if 1779468424 
s =  Model.getFacade().getValueOfTag(taggedValue);
//#endif 


//#if 251529878 
if(s != null)//1
{ 

//#if 1991061573 
return s.trim();
//#endif 

} 

//#endif 


//#if -966920799 
return null;
//#endif 

} 

//#endif 


//#if 532032837 
private GeneratorManager()
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

