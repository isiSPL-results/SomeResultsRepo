package org.argouml.uml.cognitive.critics;
import org.argouml.cognitive.Translator;
public class CrProfile extends CrUML
  { 
private String localizationPrefix;
private static final long serialVersionUID = 1785043010468681602L;
@Override
    protected String getLocalizedString(String key, String suffix)
    { 
return Translator.localize(localizationPrefix + "." + key + suffix);
} 
public CrProfile(final String prefix)
    { 
super();
if(prefix == null || "".equals(prefix))//1
{ 
this.localizationPrefix = "critics";
} 
else
{ 
this.localizationPrefix = prefix;
} 
setupHeadAndDesc();
} 

 } 
