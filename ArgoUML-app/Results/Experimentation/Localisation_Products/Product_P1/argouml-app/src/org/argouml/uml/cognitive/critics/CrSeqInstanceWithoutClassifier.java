package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ListSet;
import org.argouml.cognitive.ToDoItem;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
import org.argouml.uml.cognitive.UMLToDoItem;
import org.argouml.uml.diagram.sequence.ui.UMLSequenceDiagram;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
public class CrSeqInstanceWithoutClassifier extends CrUML
  { 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(dm instanceof UMLSequenceDiagram))//1
{ 
return NO_PROBLEM;
} 
UMLSequenceDiagram sd = (UMLSequenceDiagram) dm;
ListSet offs = computeOffenders(sd);
if(offs == null)//1
{ 
return NO_PROBLEM;
} 
return PROBLEM_FOUND;
} 
public ListSet computeOffenders(UMLSequenceDiagram sd)
    { 
Collection figs = sd.getLayer().getContents();
ListSet offs = null;
for (Object obj : figs) //1
{ 
if(!(obj instanceof FigNodeModelElement))//1
{ 
continue;
} 
FigNodeModelElement fn = (FigNodeModelElement) obj;
if(fn != null && (Model.getFacade().isAInstance(fn.getOwner())))//1
{ 
Object minst = fn.getOwner();
if(minst != null)//1
{ 
Collection col = Model.getFacade().getClassifiers(minst);
if(col.size() > 0)//1
{ 
continue;
} 
} 
if(offs == null)//1
{ 
offs = new ListSet();
offs.add(sd);
} 
offs.add(fn);
} 
} 
return offs;
} 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 
UMLSequenceDiagram sd = (UMLSequenceDiagram) dm;
ListSet offs = computeOffenders(sd);
return new UMLToDoItem(this, offs, dsgr);
} 
public CrSeqInstanceWithoutClassifier()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.PATTERNS);
} 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 
if(!isActive())//1
{ 
return false;
} 
ListSet offs = i.getOffenders();
UMLSequenceDiagram sd = (UMLSequenceDiagram) offs.get(0);
ListSet newOffs = computeOffenders(sd);
boolean res = offs.equals(newOffs);
return res;
} 

 } 
