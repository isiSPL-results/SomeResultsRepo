
//#if 1670241616 
// Compilation Unit of /CmdSetPreferredSize.java 
 

//#if 534699970 
package org.argouml.ui.cmd;
//#endif 


//#if -1795236237 
import java.util.ArrayList;
//#endif 


//#if 1667488782 
import java.util.List;
//#endif 


//#if 242876941 
import org.tigris.gef.base.Cmd;
//#endif 


//#if 50826530 
import org.tigris.gef.base.Editor;
//#endif 


//#if -568898857 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1314168718 
import org.tigris.gef.base.SelectionManager;
//#endif 


//#if -468123942 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -580077923 
import org.argouml.i18n.Translator;
//#endif 


//#if -622141675 
public class CmdSetPreferredSize extends 
//#if 1370594155 
Cmd
//#endif 

  { 

//#if 1304593827 
public void doIt()
    { 

//#if -1359666023 
Editor ce = Globals.curEditor();
//#endif 


//#if -993844536 
List<Fig> figs = (List<Fig>) getArg("figs");
//#endif 


//#if -354904983 
if(figs == null)//1
{ 

//#if -835015420 
SelectionManager sm = ce.getSelectionManager();
//#endif 


//#if -410215511 
if(sm.getLocked())//1
{ 

//#if 545726140 
Globals.showStatus(
                    Translator.localize("action.locked-objects-not-modify"));
//#endif 


//#if 1034776284 
return;
//#endif 

} 

//#endif 


//#if -1707842350 
figs = sm.getFigs();
//#endif 

} 

//#endif 


//#if 1235210664 
if(figs == null)//2
{ 

//#if 998988527 
return;
//#endif 

} 

//#endif 


//#if 169232487 
int size = figs.size();
//#endif 


//#if 691948492 
if(size == 0)//1
{ 

//#if 1532963389 
return;
//#endif 

} 

//#endif 


//#if 1161190873 
for (int i = 0; i < size; i++) //1
{ 

//#if -2054342218 
Fig fi = figs.get(i);
//#endif 


//#if -620746583 
if(fi.isResizable()
                    /* But exclude elements that enclose others,
                     * since their algorithms to calculate the minimum size
                     * does not take enclosed objects into account: */
                    && (fi.getEnclosedFigs() == null
                        || fi.getEnclosedFigs().size() == 0))//1
{ 

//#if -177220219 
fi.setSize(fi.getMinimumSize());
//#endif 


//#if -767538431 
Globals.showStatus(Translator.localize("action.setting-size",
                                                       new Object[] {fi}));
//#endif 

} 

//#endif 


//#if 1597132984 
fi.endTrans();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -970855812 
public void undoIt()
    { 
} 

//#endif 


//#if -1486243791 
public void setFigToResize(List figs)
    { 

//#if 683683411 
setArg("figs", figs);
//#endif 

} 

//#endif 


//#if -1922456797 
public CmdSetPreferredSize()
    { 

//#if -1163222424 
super(Translator.localize("action.set-minimum-size"));
//#endif 

} 

//#endif 


//#if 1381988092 
public void setFigToResize(Fig f)
    { 

//#if -1927551213 
List<Fig> figs = new ArrayList<Fig>(1);
//#endif 


//#if 301379235 
figs.add(f);
//#endif 


//#if -774125767 
setArg("figs", figs);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

