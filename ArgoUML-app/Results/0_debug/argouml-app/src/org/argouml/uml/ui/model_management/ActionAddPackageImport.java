
//#if 2045505886 
// Compilation Unit of /ActionAddPackageImport.java 
 

//#if 628816298 
package org.argouml.uml.ui.model_management;
//#endif 


//#if -1913110108 
import java.util.ArrayList;
//#endif 


//#if -2132240323 
import java.util.Collection;
//#endif 


//#if 1628667453 
import java.util.List;
//#endif 


//#if -1519626034 
import org.argouml.i18n.Translator;
//#endif 


//#if 1311095444 
import org.argouml.model.Model;
//#endif 


//#if 721704322 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if -112841347 
class ActionAddPackageImport extends 
//#if -1561936196 
AbstractActionAddModelElement2
//#endif 

  { 

//#if -382325734 
@Override
    protected void doIt(Collection selected)
    { 

//#if -319121383 
Object pack = getTarget();
//#endif 


//#if -1492529104 
Model.getModelManagementHelper().setImportedElements(pack, selected);
//#endif 

} 

//#endif 


//#if 597038988 
protected List getSelected()
    { 

//#if 1825694663 
List vec = new ArrayList();
//#endif 


//#if 911729093 
vec.addAll(Model.getFacade().getImportedElements(getTarget()));
//#endif 


//#if 211016204 
return vec;
//#endif 

} 

//#endif 


//#if -1572604221 
protected List getChoices()
    { 

//#if 1130096599 
List vec = new ArrayList();
//#endif 


//#if -1896729724 
vec.addAll(Model.getModelManagementHelper()
                   .getAllPossibleImports(getTarget()));
//#endif 


//#if 532970492 
return vec;
//#endif 

} 

//#endif 


//#if 777275911 
ActionAddPackageImport()
    { 

//#if -435109706 
super();
//#endif 

} 

//#endif 


//#if 151544244 
protected String getDialogTitle()
    { 

//#if -2047455330 
return Translator.localize("dialog.title.add-imported-elements");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

