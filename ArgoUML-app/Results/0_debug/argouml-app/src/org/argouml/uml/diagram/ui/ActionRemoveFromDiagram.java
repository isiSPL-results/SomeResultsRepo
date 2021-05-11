
//#if 888082953 
// Compilation Unit of /ActionRemoveFromDiagram.java 
 

//#if 894372340 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -317560483 
import java.awt.event.ActionEvent;
//#endif 


//#if -1238083565 
import java.util.List;
//#endif 


//#if 1732825937 
import javax.swing.AbstractAction;
//#endif 


//#if -1093852205 
import javax.swing.Action;
//#endif 


//#if -749289609 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1939516088 
import org.argouml.i18n.Translator;
//#endif 


//#if 910935872 
import org.argouml.uml.CommentEdge;
//#endif 


//#if -1114822233 
import org.tigris.gef.base.Editor;
//#endif 


//#if 1950695154 
import org.tigris.gef.base.Globals;
//#endif 


//#if -1493793062 
import org.tigris.gef.di.GraphElement;
//#endif 


//#if 1111887338 
import org.tigris.gef.graph.MutableGraphSupport;
//#endif 


//#if 195652981 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -704870267 
public class ActionRemoveFromDiagram extends 
//#if -2096483448 
AbstractAction
//#endif 

  { 

//#if -1432914932 
public void actionPerformed(ActionEvent ae)
    { 

//#if 2103828742 
Editor ce = Globals.curEditor();
//#endif 


//#if -72581522 
MutableGraphSupport graph = (MutableGraphSupport) ce.getGraphModel();
//#endif 


//#if 1345703182 
List<Fig> figs = ce.getSelectionManager().getFigs();
//#endif 


//#if -869469219 
for (Fig f : figs) //1
{ 

//#if -1756995040 
if(!(f.getOwner() instanceof CommentEdge))//1
{ 

//#if 1470680451 
if(f instanceof GraphElement)//1
{ 

//#if -1973966991 
f.removeFromDiagram();
//#endif 

} 
else
{ 

//#if -665768052 
graph.removeFig(f);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1711718715 
public ActionRemoveFromDiagram(String name)
    { 

//#if -1861031430 
super(name, ResourceLoaderWrapper.lookupIcon("RemoveFromDiagram"));
//#endif 


//#if -1133634238 
String localMnemonic =
            Translator.localize("action.remove-from-diagram.mnemonic");
//#endif 


//#if -1416103053 
if(localMnemonic != null && localMnemonic.length() == 1)//1
{ 

//#if 2081636387 
putValue(Action.MNEMONIC_KEY,
                     Integer.valueOf(localMnemonic.charAt(0)));
//#endif 

} 

//#endif 


//#if 1174013019 
putValue(Action.SHORT_DESCRIPTION, name);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

