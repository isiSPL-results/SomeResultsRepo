
//#if -1940473848 
// Compilation Unit of /InitNotationUml.java 
 

//#if 803721849 
package org.argouml.notation.providers.uml;
//#endif 


//#if -1308558424 
import java.util.Collections;
//#endif 


//#if 1042775867 
import java.util.List;
//#endif 


//#if 1044543765 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 73505066 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if 1641296781 
import org.argouml.application.api.InitSubsystem;
//#endif 


//#if 1013144399 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1591358260 
import org.argouml.notation.Notation;
//#endif 


//#if -841743615 
import org.argouml.notation.NotationName;
//#endif 


//#if 51585107 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if 1470774160 
public class InitNotationUml implements 
//#if -1640388628 
InitSubsystem
//#endif 

  { 

//#if -1593581710 
public List<AbstractArgoJPanel> getDetailsTabs()
    { 

//#if 1126516523 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if -444080349 
public List<GUISettingsTabInterface> getProjectSettingsTabs()
    { 

//#if 1696787476 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if 523889498 
public List<GUISettingsTabInterface> getSettingsTabs()
    { 

//#if -119685507 
return Collections.emptyList();
//#endif 

} 

//#endif 


//#if 1418732001 
public void init()
    { 

//#if 1279336373 
NotationProviderFactory2 npf = NotationProviderFactory2.getInstance();
//#endif 


//#if 1294453477 
NotationName name =
            Notation.makeNotation(
                "UML",
                "1.4",
                ResourceLoaderWrapper.lookupIconResource("UmlNotation"));
//#endif 


//#if 1512280967 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_NAME,
            name, ModelElementNameNotationUml.class);
//#endif 


//#if -1217472890 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_TRANSITION,
            name, TransitionNotationUml.class);
//#endif 


//#if -684561254 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_STATEBODY,
            name, StateBodyNotationUml.class);
//#endif 


//#if 1152784986 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_ACTIONSTATE,
            name, ActionStateNotationUml.class);
//#endif 


//#if -2093536462 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_OBJECT,
            name, ObjectNotationUml.class);
//#endif 


//#if 1931701626 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_COMPONENTINSTANCE,
            name, ComponentInstanceNotationUml.class);
//#endif 


//#if -1230006046 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_NODEINSTANCE,
            name, NodeInstanceNotationUml.class);
//#endif 


//#if -1799899773 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_OBJECTFLOWSTATE_TYPE,
            name, ObjectFlowStateTypeNotationUml.class);
//#endif 


//#if 415524287 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_OBJECTFLOWSTATE_STATE,
            name, ObjectFlowStateStateNotationUml.class);
//#endif 


//#if 103555290 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_CALLSTATE,
            name, CallStateNotationUml.class);
//#endif 


//#if -57370270 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_CLASSIFIERROLE,
            name, ClassifierRoleNotationUml.class);
//#endif 


//#if 1610677690 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_MESSAGE,
            name, MessageNotationUml.class);
//#endif 


//#if -1987332134 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_ATTRIBUTE,
            name, AttributeNotationUml.class);
//#endif 


//#if -842923206 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_OPERATION,
            name, OperationNotationUml.class);
//#endif 


//#if -1911788319 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_EXTENSION_POINT,
            name, ExtensionPointNotationUml.class);
//#endif 


//#if 1349940862 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_ASSOCIATION_END_NAME,
            name, AssociationEndNameNotationUml.class);
//#endif 


//#if 184749769 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_ASSOCIATION_ROLE,
            name, AssociationRoleNotationUml.class);
//#endif 


//#if 94694313 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_ASSOCIATION_NAME,
            name, AssociationNameNotationUml.class);
//#endif 


//#if -645660878 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_MULTIPLICITY,
            name, MultiplicityNotationUml.class);
//#endif 


//#if 315481507 
npf.addNotationProvider(
            NotationProviderFactory2.TYPE_ENUMERATION_LITERAL,
            name, EnumerationLiteralNotationUml.class);
//#endif 


//#if -1496139224 
NotationProviderFactory2.getInstance().setDefaultNotation(name);
//#endif 


//#if 1086430825 
(new NotationUtilityUml()).init();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

