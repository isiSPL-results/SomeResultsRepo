
//#if -2069884156 
// Compilation Unit of /GeneratorHelper.java 
 

//#if 208988441 
package org.argouml.uml.generator;
//#endif 


//#if -1080104971 
import java.util.ArrayList;
//#endif 


//#if -2078884852 
import java.util.Collection;
//#endif 


//#if -614438580 
import java.util.List;
//#endif 


//#if -2073608087 
import javax.swing.Icon;
//#endif 


//#if -1513859862 
public final class GeneratorHelper  { 

//#if -1674409176 
public static Collection generate(
        Language lang, Object elem, boolean deps)
    { 

//#if 1549610846 
List list = new ArrayList();
//#endif 


//#if -2092298372 
list.add(elem);
//#endif 


//#if -737385107 
return generate(lang, list, deps);
//#endif 

} 

//#endif 


//#if 1616957994 
private GeneratorHelper()
    { 
} 

//#endif 


//#if 555523905 
public static Collection generate(
        Language lang, Collection elements, boolean deps)
    { 

//#if 1114759456 
CodeGenerator gen =
            GeneratorManager.getInstance().getGenerator(lang);
//#endif 


//#if -310282344 
if(gen != null)//1
{ 

//#if -179288748 
return gen.generate(elements, deps);
//#endif 

} 

//#endif 


//#if 362687403 
return new ArrayList();
//#endif 

} 

//#endif 


//#if 1023261094 
public static Language makeLanguage(String theName)
    { 

//#if 787466069 
return makeLanguage(theName, theName, null);
//#endif 

} 

//#endif 


//#if -1506744637 
public static Language makeLanguage(String theName, String theTitle,
                                        Icon theIcon)
    { 

//#if 295132446 
Language lang;
//#endif 


//#if 2131131605 
lang = GeneratorManager.getInstance().findLanguage(theName);
//#endif 


//#if 310168593 
if(lang == null)//1
{ 

//#if -1168050452 
lang = new Language(theName, theTitle, theIcon);
//#endif 

} 

//#endif 


//#if 1407760550 
return lang;
//#endif 

} 

//#endif 


//#if -816482616 
public static Language makeLanguage(String theName, String theTitle)
    { 

//#if -1192031519 
return makeLanguage(theName, theTitle, null);
//#endif 

} 

//#endif 


//#if 1965411489 
public static Language makeLanguage(String theName, Icon theIcon)
    { 

//#if 130928125 
return makeLanguage(theName, theName, theIcon);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

