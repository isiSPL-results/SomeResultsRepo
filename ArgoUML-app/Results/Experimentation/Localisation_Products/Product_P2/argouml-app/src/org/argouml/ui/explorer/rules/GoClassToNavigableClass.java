package org.argouml.ui.explorer.rules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoClassToNavigableClass extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(!Model.getFacade().isAClass(parent))//1
{ 
return Collections.EMPTY_SET;
} 
List childClasses = new ArrayList();
Collection ends = Model.getFacade().getAssociationEnds(parent);
if(ends == null)//1
{ 
return Collections.EMPTY_SET;
} 
Iterator it = ends.iterator();
while (it.hasNext()) //1
{ 
Object ae = /*(MAssociationEnd)*/ it.next();
Object asc = Model.getFacade().getAssociation(ae);
Collection allEnds = Model.getFacade().getConnections(asc);
Object otherEnd = null;
Iterator endIt = allEnds.iterator();
if(endIt.hasNext())//1
{ 
otherEnd = /*(MAssociationEnd)*/ endIt.next();
if(ae != otherEnd && endIt.hasNext())//1
{ 
otherEnd = /*(MAssociationEnd)*/ endIt.next();
if(ae != otherEnd)//1
{ 
otherEnd = null;
} 
} 
} 
if(otherEnd == null)//1
{ 
continue;
} 
if(!Model.getFacade().isNavigable(otherEnd))//1
{ 
continue;
} 
if(childClasses.contains(Model.getFacade().getType(otherEnd)))//1
{ 
continue;
} 
childClasses.add(Model.getFacade().getType(otherEnd));
} 
return childClasses;
} 
public String getRuleName()
    { 
return Translator.localize("misc.class.navigable-class");
} 
public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAClass(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 
return Collections.EMPTY_SET;
} 

 } 
