package org.argouml.ui.cmd;
import java.util.ArrayList;
import java.util.List;
import org.tigris.gef.base.Cmd;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.SelectionManager;
import org.tigris.gef.presentation.Fig;
import org.argouml.i18n.Translator;
public class CmdSetPreferredSize extends Cmd
  { 
public void doIt()
    { 
Editor ce = Globals.curEditor();
List<Fig> figs = (List<Fig>) getArg("figs");
if(figs == null)//1
{ 
SelectionManager sm = ce.getSelectionManager();
if(sm.getLocked())//1
{ 
Globals.showStatus(
                    Translator.localize("action.locked-objects-not-modify"));
return;
} 
figs = sm.getFigs();
} 
if(figs == null)//2
{ 
return;
} 
int size = figs.size();
if(size == 0)//1
{ 
return;
} 
for (int i = 0; i < size; i++) //1
{ 
Fig fi = figs.get(i);
if(fi.isResizable()
                    /* But exclude elements that enclose others,
                     * since their algorithms to calculate the minimum size
                     * does not take enclosed objects into account: */
                    && (fi.getEnclosedFigs() == null
                        || fi.getEnclosedFigs().size() == 0))//1
{ 
fi.setSize(fi.getMinimumSize());
Globals.showStatus(Translator.localize("action.setting-size",
                                                       new Object[] {fi}));
} 
fi.endTrans();
} 
} 
public void undoIt()
    { 
} 
public void setFigToResize(List figs)
    { 
setArg("figs", figs);
} 
public CmdSetPreferredSize()
    { 
super(Translator.localize("action.set-minimum-size"));
} 
public void setFigToResize(Fig f)
    { 
List<Fig> figs = new ArrayList<Fig>(1);
figs.add(f);
setArg("figs", figs);
} 

 } 
