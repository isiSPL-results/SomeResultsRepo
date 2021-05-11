// Compilation Unit of /UMLTaggedValueCheckBox.java 
 
package org.argouml.uml.ui;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class UMLTaggedValueCheckBox extends UMLCheckBox2
  { 
private String tagName;
public void buildModel()
    { 
Object tv = Model.getFacade().getTaggedValue(getTarget(), tagName);
if(tv != null)//1
{ 
String tag = Model.getFacade().getValueOfTag(tv);
if("true".equals(tag))//1
{ 
setSelected(true);
return;
} 

} 

setSelected(false);
} 

public UMLTaggedValueCheckBox(String name)
    { 
super(Translator.localize("checkbox." + name + "-lc"),
              new ActionBooleanTaggedValue(name),
              name);
tagName = name;
} 

 } 


