
//#if -1368772605 
// Compilation Unit of /InitNotationJava.java 
 

//#if 816661674 
package org.argouml.notation.providers.java;
//#endif 


//#if -502164123 
import java.util.Collections;
//#endif 


//#if -2035568610 
import java.util.List;
//#endif 


//#if -2142085640 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 1207716391 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -1584689974 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if 68534540 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 504584585 
import org.argouml.notation.Notation;
//#endif 


//#if -880613058 
import org.argouml.notation.NotationName;
//#endif 


//#if 2027000592 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if -2040609399 
public class InitNotationJava implements 
//#if 469461476 
InitSubsystem
//#endif 

  { 

//#if 1588915995 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if -522914376 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -922469254 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if 380043345 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -1846386078 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if -471562712 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -883196695 
public void init()
    { 

//#if 1716245731 
NotationProviderFactory2 npf = NotationProviderFactory2.getInstance();
//#endif 


//#if -1367258878 
NotationName name = /*Notation.findNotation("Java");*/
            Notation.makeNotation(
                "Java",
                null,
                ResourceLoaderWrapper.lookupIconResource("JavaNotation"));
//#endif 


//#if -1541640615 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_NAME,
            name, ModelElementNameNotationJava.class);
//#endif 


//#if -609365786 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_ATTRIBUTE,
            name, AttributeNotationJava.class);
//#endif 


//#if 507572614 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_OPERATION,
            name, OperationNotationJava.class);
//#endif 


//#if 1196927426 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_ASSOCIATION_END_NAME,
            name, AssociationEndNameNotationJava.class);
//#endif 


//#if 1302534675 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_ASSOCIATION_NAME,
            name, AssociationNameNotationJava.class);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

