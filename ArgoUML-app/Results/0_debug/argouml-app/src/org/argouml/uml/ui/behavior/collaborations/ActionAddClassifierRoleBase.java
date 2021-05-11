
//#if 245218176 
// Compilation Unit of /ActionAddClassifierRoleBase.java 
 

//#if 2064290232 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if 330203955 
import java.util.ArrayList;
//#endif 


//#if -1308981106 
import java.util.Collection;
//#endif 


//#if 19939150 
import java.util.List;
//#endif 


//#if 1200331613 
import org.argouml.i18n.Translator;
//#endif 


//#if -1531798365 
import org.argouml.model.Model;
//#endif 


//#if 387625681 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if -2091767762 
public class ActionAddClassifierRoleBase extends 
//#if -1544256812 
AbstractActionAddModelElement2
//#endif 

  { 

//#if -397656477 
public static final ActionAddClassifierRoleBase SINGLETON =
        new ActionAddClassifierRoleBase();
//#endif 


//#if 1308754859 
protected List getChoices()
    { 

//#if -1230089819 
List vec = new ArrayList();
//#endif 


//#if -86436948 
vec.addAll(Model.getCollaborationsHelper()
                   .getAllPossibleBases(getTarget()));
//#endif 


//#if -117163154 
return vec;
//#endif 

} 

//#endif 


//#if -275142748 
protected List getSelected()
    { 

//#if -1412310873 
List vec = new ArrayList();
//#endif 


//#if -2054583820 
vec.addAll(Model.getFacade().getBases(getTarget()));
//#endif 


//#if -664307412 
return vec;
//#endif 

} 

//#endif 


//#if -1984916860 
protected ActionAddClassifierRoleBase()
    { 

//#if 2097377350 
super();
//#endif 

} 

//#endif 


//#if 611779490 
protected void doIt(Collection selected)
    { 

//#if 681766991 
Object role = getTarget();
//#endif 


//#if -1504602873 
Model.getCollaborationsHelper().setBases(role, selected);
//#endif 

} 

//#endif 


//#if 699605148 
protected String getDialogTitle()
    { 

//#if -976891480 
return Translator.localize("dialog.title.add-bases");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

