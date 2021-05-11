
//#if -934774587 
// Compilation Unit of /Translator.java 
 

//#if 1057199959 
package org.argouml.cognitive;
//#endif 


//#if 18158300 
public class Translator  { 

//#if 1165137562 
private static AbstractCognitiveTranslator translator;
//#endif 


//#if -1784670506 
public static void setTranslator(AbstractCognitiveTranslator trans)
    { 

//#if 2118004190 
translator = trans;
//#endif 

} 

//#endif 


//#if 1329354133 
public static String messageFormat(String key, Object[] args)
    { 

//#if 827993800 
return (translator != null)
               ? translator.i18nmessageFormat(key, args)
               : key;
//#endif 

} 

//#endif 


//#if -1246644148 
public static String localize(String key)
    { 

//#if 1725636471 
return (translator != null) ? translator.i18nlocalize(key) : key;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

