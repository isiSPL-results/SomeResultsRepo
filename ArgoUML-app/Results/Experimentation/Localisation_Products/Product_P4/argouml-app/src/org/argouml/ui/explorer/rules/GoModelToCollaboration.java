package org.argouml.ui.explorer.rules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoModelToCollaboration extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAModel(parent))//1
{ 
Collection col =
                Model.getModelManagementHelper().getAllModelElementsOfKind(
                    parent,
                    Model.getMetaTypes().getCollaboration());
List returnList = new ArrayList();
Iterator it = col.iterator();
while (it.hasNext()) //1
{ 
Object collab = it.next();
if(Model.getFacade().getRepresentedClassifier(collab) == null
                        && Model.getFacade().getRepresentedOperation(collab)
                        == null)//1
{ 
returnList.add(collab);
} 
} 
return returnList;
} 
return Collections.EMPTY_SET;
} 
public Set getDependencies(Object parent)
    { 
return Collections.EMPTY_SET;
} 
public String getRuleName()
    { 
return Translator.localize("misc.model.collaboration");
} 

 } 
