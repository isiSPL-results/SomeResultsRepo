// Compilation Unit of /ActionSetSourcePath.java 
 
package org.argouml.uml.ui;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.Action;
import javax.swing.JFileChooser;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.reveng.ImportInterface;
import org.argouml.util.ArgoFrame;
import org.tigris.gef.undo.UndoableAction;
public class ActionSetSourcePath extends UndoableAction
  { 
private static final long serialVersionUID = -6455209886706784094L;
protected File getNewDirectory()
    { 
Object obj = TargetManager.getInstance().getTarget();
String name = null;
String type = null;
String path = null;
if(Model.getFacade().isAModelElement(obj))//1
{ 
name = Model.getFacade().getName(obj);
Object tv = Model.getFacade().getTaggedValue(obj,
                        ImportInterface.SOURCE_PATH_TAG);
if(tv != null)//1
{ 
path = Model.getFacade().getValueOfTag(tv);
} 

if(Model.getFacade().isAPackage(obj))//1
{ 
type = "Package";
} 
else
if(Model.getFacade().isAClass(obj))//1
{ 
type = "Class";
} 


if(Model.getFacade().isAInterface(obj))//1
{ 
type = "Interface";
} 

} 
else
{ 
return null;
} 

JFileChooser chooser = null;
File f = null;
if(path != null)//1
{ 
f = new File(path);
} 

if((f != null) && (f.getPath().length() > 0))//1
{ 
chooser = new JFileChooser(f.getPath());
} 

if(chooser == null)//1
{ 
chooser = new JFileChooser();
} 

if(f != null)//1
{ 
chooser.setSelectedFile(f);
} 

String sChooserTitle =
            Translator.localize("action.set-source-path");
if(type != null)//1
{ 
sChooserTitle += ' ' + type;
} 

if(name != null)//1
{ 
sChooserTitle += ' ' + name;
} 

chooser.setDialogTitle(sChooserTitle);
chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
int retval =
            chooser.showDialog(ArgoFrame.getInstance(),
                               Translator.localize("dialog.button.ok"));
if(retval == JFileChooser.APPROVE_OPTION)//1
{ 
return chooser.getSelectedFile();
} 
else
{ 
return null;
} 

} 

@Override
    public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
File f = getNewDirectory();
if(f != null)//1
{ 
Object obj = TargetManager.getInstance().getTarget();
if(Model.getFacade().isAModelElement(obj))//1
{ 
Object tv =
                    Model.getFacade().getTaggedValue(
                        obj, ImportInterface.SOURCE_PATH_TAG);
if(tv == null)//1
{ 
Model.getExtensionMechanismsHelper().addTaggedValue(
                        obj,
                        Model.getExtensionMechanismsFactory()
                        .buildTaggedValue(
                            ImportInterface.SOURCE_PATH_TAG,
                            f.getPath()));
} 
else
{ 
Model.getExtensionMechanismsHelper().setValueOfTag(
                        tv, f.getPath());
} 

} 

} 

} 

public ActionSetSourcePath()
    { 
super(Translator.localize("action.set-source-path"), null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.set-source-path"));
} 

 } 


