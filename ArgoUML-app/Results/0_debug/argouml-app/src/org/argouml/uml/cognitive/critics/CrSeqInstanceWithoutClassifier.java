
//#if 1805000608 
// Compilation Unit of /CrSeqInstanceWithoutClassifier.java 
 

//#if 189679443 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 736003806 
import java.util.Collection;
//#endif 


//#if -464821280 
import org.argouml.cognitive.Designer;
//#endif 


//#if 30093991 
import org.argouml.cognitive.ListSet;
//#endif 


//#if -1984806926 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 797588563 
import org.argouml.model.Model;
//#endif 


//#if -288123243 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -503894664 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if 58125471 
import org.argouml.uml.diagram.sequence.ui.UMLSequenceDiagram;
//#endif 


//#if 1585457003 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if 1277841721 
public class CrSeqInstanceWithoutClassifier extends 
//#if -980949213 
CrUML
//#endif 

  { 

//#if -747389768 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1407067828 
if(!(dm instanceof UMLSequenceDiagram))//1
{ 

//#if 1896186289 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -537069111 
UMLSequenceDiagram sd = (UMLSequenceDiagram) dm;
//#endif 


//#if -500377909 
ListSet offs = computeOffenders(sd);
//#endif 


//#if 1495173846 
if(offs == null)//1
{ 

//#if -115782539 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1962111823 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -1856000882 
public ListSet computeOffenders(UMLSequenceDiagram sd)
    { 

//#if -689943612 
Collection figs = sd.getLayer().getContents();
//#endif 


//#if -1796540876 
ListSet offs = null;
//#endif 


//#if -921372221 
for (Object obj : figs) //1
{ 

//#if 1429683810 
if(!(obj instanceof FigNodeModelElement))//1
{ 

//#if 1062647354 
continue;
//#endif 

} 

//#endif 


//#if 1790855719 
FigNodeModelElement fn = (FigNodeModelElement) obj;
//#endif 


//#if 1515617059 
if(fn != null && (Model.getFacade().isAInstance(fn.getOwner())))//1
{ 

//#if -872253994 
Object minst = fn.getOwner();
//#endif 


//#if 550475305 
if(minst != null)//1
{ 

//#if -2136123147 
Collection col = Model.getFacade().getClassifiers(minst);
//#endif 


//#if 1376656502 
if(col.size() > 0)//1
{ 

//#if -1731709807 
continue;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 665792456 
if(offs == null)//1
{ 

//#if -2017974995 
offs = new ListSet();
//#endif 


//#if -1277962620 
offs.add(sd);
//#endif 

} 

//#endif 


//#if -2103322571 
offs.add(fn);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1442749820 
return offs;
//#endif 

} 

//#endif 


//#if 37560259 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 1676430478 
UMLSequenceDiagram sd = (UMLSequenceDiagram) dm;
//#endif 


//#if -654996186 
ListSet offs = computeOffenders(sd);
//#endif 


//#if -1181177308 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if 1154916944 
public CrSeqInstanceWithoutClassifier()
    { 

//#if 308931149 
setupHeadAndDesc();
//#endif 


//#if 1366792304 
addSupportedDecision(UMLDecision.PATTERNS);
//#endif 

} 

//#endif 


//#if -1142019127 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if 1391824930 
if(!isActive())//1
{ 

//#if -211263396 
return false;
//#endif 

} 

//#endif 


//#if 972116329 
ListSet offs = i.getOffenders();
//#endif 


//#if -160499644 
UMLSequenceDiagram sd = (UMLSequenceDiagram) offs.get(0);
//#endif 


//#if -2048836514 
ListSet newOffs = computeOffenders(sd);
//#endif 


//#if -2124831355 
boolean res = offs.equals(newOffs);
//#endif 


//#if -834561858 
return res;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

