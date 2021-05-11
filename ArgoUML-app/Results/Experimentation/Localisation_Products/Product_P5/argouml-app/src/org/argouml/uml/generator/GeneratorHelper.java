package org.argouml.uml.generator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.Icon;
public final class GeneratorHelper  { 
public static Collection generate(
        Language lang, Object elem, boolean deps)
    { 
List list = new ArrayList();
list.add(elem);
return generate(lang, list, deps);
} 
private GeneratorHelper()
    { 
} 
public static Collection generate(
        Language lang, Collection elements, boolean deps)
    { 
CodeGenerator gen =
            GeneratorManager.getInstance().getGenerator(lang);
if(gen != null)//1
{ 
return gen.generate(elements, deps);
} 
return new ArrayList();
} 
public static Language makeLanguage(String theName)
    { 
return makeLanguage(theName, theName, null);
} 
public static Language makeLanguage(String theName, String theTitle,
                                        Icon theIcon)
    { 
Language lang;
lang = GeneratorManager.getInstance().findLanguage(theName);
if(lang == null)//1
{ 
lang = new Language(theName, theTitle, theIcon);
} 
return lang;
} 
public static Language makeLanguage(String theName, String theTitle)
    { 
return makeLanguage(theName, theTitle, null);
} 
public static Language makeLanguage(String theName, Icon theIcon)
    { 
return makeLanguage(theName, theName, theIcon);
} 

 } 
