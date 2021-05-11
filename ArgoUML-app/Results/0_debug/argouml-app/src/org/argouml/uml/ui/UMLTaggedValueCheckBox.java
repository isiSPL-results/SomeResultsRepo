
//#if -380244557 
// Compilation Unit of /UMLTaggedValueCheckBox.java 
 

//#if 921168493 
package org.argouml.uml.ui;
//#endif 


//#if 1904319894 
import org.argouml.i18n.Translator;
//#endif 


//#if 485270364 
import org.argouml.model.Model;
//#endif 


//#if 237848032 
public class UMLTaggedValueCheckBox extends 
//#if 1588940548 
UMLCheckBox2
//#endif 

  { 

//#if 1395978433 
private String tagName;
//#endif 


//#if -420416318 
public void buildModel()
    { 

//#if 780376823 
Object tv = Model.getFacade().getTaggedValue(getTarget(), tagName);
//#endif 


//#if 655859735 
if(tv != null)//1
{ 

//#if 1753854364 
String tag = Model.getFacade().getValueOfTag(tv);
//#endif 


//#if 418578141 
if("true".equals(tag))//1
{ 

//#if 555609253 
setSelected(true);
//#endif 


//#if -657651119 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1137947433 
setSelected(false);
//#endif 

} 

//#endif 


//#if -1204377557 
public UMLTaggedValueCheckBox(String name)
    { 

//#if -46113534 
super(Translator.localize("checkbox." + name + "-lc"),
              new ActionBooleanTaggedValue(name),
              name);
//#endif 


//#if 300776867 
tagName = name;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

