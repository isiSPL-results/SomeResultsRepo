
//#if -726763627 
// Compilation Unit of /UMLToDoItem.java 
 

//#if -382832663 
package org.argouml.uml.cognitive;
//#endif 


//#if 1079952243 
import java.util.Iterator;
//#endif 


//#if -932805284 
import org.argouml.cognitive.Critic;
//#endif 


//#if -1798159227 
import org.argouml.cognitive.Designer;
//#endif 


//#if -522323656 
import org.argouml.cognitive.Highlightable;
//#endif 


//#if 541272418 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 1938152355 
import org.argouml.cognitive.Poster;
//#endif 


//#if 976822423 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -55037700 
import org.argouml.kernel.Project;
//#endif 


//#if 1487400557 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 704944974 
import org.argouml.model.Model;
//#endif 


//#if -1454401804 
import org.argouml.ui.ProjectActions;
//#endif 


//#if -740895361 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 987866949 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 592322003 
public class UMLToDoItem extends 
//#if 1363199463 
ToDoItem
//#endif 

  { 

//#if -1711258438 
@Override
    protected void checkArgument(Object dm)
    { 

//#if -1563321988 
if(!Model.getFacade().isAUMLElement(dm)
                && !(dm instanceof Fig)
                && !(dm instanceof Diagram))//1
{ 

//#if -204438994 
throw new IllegalArgumentException(
                "The offender must be a model element, "
                + "a Fig or a Diagram");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1928772636 
public UMLToDoItem(Poster poster, String h, int p, String d, String m)
    { 

//#if 1186921131 
super(poster, h, p, d, m);
//#endif 

} 

//#endif 


//#if 1205762732 
public UMLToDoItem(Critic c)
    { 

//#if 1234265152 
super(c);
//#endif 

} 

//#endif 


//#if -1788944478 
@Override
    public ListSet getOffenders()
    { 

//#if -825001829 
final ListSet offenders = super.getOffenders();
//#endif 


//#if 1741749993 
assert offenders.size() <= 0
        || Model.getFacade().isAUMLElement(offenders.get(0))
        || offenders.get(0) instanceof Fig
        || offenders.get(0) instanceof Diagram;
//#endif 


//#if -99932664 
return offenders;
//#endif 

} 

//#endif 


//#if -35780936 
@Override
    public void select()
    { 

//#if 1282428804 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 732819614 
for (Object dm : getOffenders()) //1
{ 

//#if 1398946082 
if(dm instanceof Highlightable)//1
{ 

//#if -627455038 
((Highlightable) dm).setHighlight(true);
//#endif 

} 
else

//#if -226577024 
if(p != null)//1
{ 

//#if 305390999 
Iterator iterFigs = p.findFigsForMember(dm).iterator();
//#endif 


//#if 1999752146 
while (iterFigs.hasNext()) //1
{ 

//#if 1093810980 
Object f = iterFigs.next();
//#endif 


//#if 1443553505 
if(f instanceof Highlightable)//1
{ 

//#if 1515640656 
((Highlightable) f).setHighlight(true);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 1815756064 
public UMLToDoItem(Poster poster, String h, int p, String d, String m,
                       ListSet offs)
    { 

//#if -1007412458 
super(poster, h, p, d, m, offs);
//#endif 

} 

//#endif 


//#if -664553361 
public UMLToDoItem(Critic c, Object dm, Designer dsgr)
    { 

//#if 646787439 
super(c, dm, dsgr);
//#endif 

} 

//#endif 


//#if -1812594823 
@Override
    public void deselect()
    { 

//#if -859777897 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 459614065 
for (Object dm : getOffenders()) //1
{ 

//#if 282518256 
if(dm instanceof Highlightable)//1
{ 

//#if 601723130 
((Highlightable) dm).setHighlight(false);
//#endif 

} 
else

//#if 2140035283 
if(p != null)//1
{ 

//#if -662270744 
Iterator iterFigs = p.findFigsForMember(dm).iterator();
//#endif 


//#if 1274680867 
while (iterFigs.hasNext()) //1
{ 

//#if -1305854534 
Object f = iterFigs.next();
//#endif 


//#if -27465333 
if(f instanceof Highlightable)//1
{ 

//#if -411812810 
((Highlightable) f).setHighlight(false);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 1411443058 
@Override
    public void action()
    { 

//#if 369855082 
deselect();
//#endif 


//#if 1039933325 
ProjectActions.jumpToDiagramShowing(getOffenders());
//#endif 


//#if -1403425525 
select();
//#endif 

} 

//#endif 


//#if -378883919 
public UMLToDoItem(Critic c, ListSet offs, Designer dsgr)
    { 

//#if 1511901231 
super(c, offs, dsgr);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

