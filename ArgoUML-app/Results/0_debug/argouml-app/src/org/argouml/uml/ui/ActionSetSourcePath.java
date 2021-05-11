
//#if -1486412194 
// Compilation Unit of /ActionSetSourcePath.java 
 

//#if 413813327 
package org.argouml.uml.ui;
//#endif 


//#if -140443491 
import java.awt.event.ActionEvent;
//#endif 


//#if -291950375 
import java.io.File;
//#endif 


//#if -2012808429 
import javax.swing.Action;
//#endif 


//#if 1643035988 
import javax.swing.JFileChooser;
//#endif 


//#if -1159791752 
import org.argouml.i18n.Translator;
//#endif 


//#if -1797766594 
import org.argouml.model.Model;
//#endif 


//#if -1851198876 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1779407751 
import org.argouml.uml.reveng.ImportInterface;
//#endif 


//#if -1557127860 
import org.argouml.util.ArgoFrame;
//#endif 


//#if -1845142989 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -976742526 
public class ActionSetSourcePath extends 
//#if -1995582621 
UndoableAction
//#endif 

  { 

//#if -178088897 
private static final long serialVersionUID = -6455209886706784094L;
//#endif 


//#if 1582709641 
protected File getNewDirectory()
    { 

//#if -1041570007 
Object obj = TargetManager.getInstance().getTarget();
//#endif 


//#if 701491152 
String name = null;
//#endif 


//#if 26639679 
String type = null;
//#endif 


//#if -2009221654 
String path = null;
//#endif 


//#if 706720744 
if(Model.getFacade().isAModelElement(obj))//1
{ 

//#if 1760849105 
name = Model.getFacade().getName(obj);
//#endif 


//#if -998101751 
Object tv = Model.getFacade().getTaggedValue(obj,
                        ImportInterface.SOURCE_PATH_TAG);
//#endif 


//#if 630036021 
if(tv != null)//1
{ 

//#if -1030042897 
path = Model.getFacade().getValueOfTag(tv);
//#endif 

} 

//#endif 


//#if -267974007 
if(Model.getFacade().isAPackage(obj))//1
{ 

//#if 311850768 
type = "Package";
//#endif 

} 
else

//#if 356742331 
if(Model.getFacade().isAClass(obj))//1
{ 

//#if -1181435371 
type = "Class";
//#endif 

} 

//#endif 


//#endif 


//#if 10490806 
if(Model.getFacade().isAInterface(obj))//1
{ 

//#if 2030450984 
type = "Interface";
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1752922614 
return null;
//#endif 

} 

//#endif 


//#if -1180516704 
JFileChooser chooser = null;
//#endif 


//#if 656851204 
File f = null;
//#endif 


//#if -58702946 
if(path != null)//1
{ 

//#if 948291400 
f = new File(path);
//#endif 

} 

//#endif 


//#if -1566495984 
if((f != null) && (f.getPath().length() > 0))//1
{ 

//#if -1346591365 
chooser = new JFileChooser(f.getPath());
//#endif 

} 

//#endif 


//#if -2070364676 
if(chooser == null)//1
{ 

//#if -485758244 
chooser = new JFileChooser();
//#endif 

} 

//#endif 


//#if -561857149 
if(f != null)//1
{ 

//#if -602534800 
chooser.setSelectedFile(f);
//#endif 

} 

//#endif 


//#if -471329948 
String sChooserTitle =
            Translator.localize("action.set-source-path");
//#endif 


//#if 46880883 
if(type != null)//1
{ 

//#if 1652522685 
sChooserTitle += ' ' + type;
//#endif 

} 

//#endif 


//#if 1144722052 
if(name != null)//1
{ 

//#if 179153768 
sChooserTitle += ' ' + name;
//#endif 

} 

//#endif 


//#if -1273553256 
chooser.setDialogTitle(sChooserTitle);
//#endif 


//#if 729313860 
chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//#endif 


//#if -1100969021 
int retval =
            chooser.showDialog(ArgoFrame.getInstance(),
                               Translator.localize("dialog.button.ok"));
//#endif 


//#if 1170964538 
if(retval == JFileChooser.APPROVE_OPTION)//1
{ 

//#if 1342103522 
return chooser.getSelectedFile();
//#endif 

} 
else
{ 

//#if -2085259775 
return null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2060162608 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if -450453859 
super.actionPerformed(e);
//#endif 


//#if -136310349 
File f = getNewDirectory();
//#endif 


//#if -503008177 
if(f != null)//1
{ 

//#if 642845820 
Object obj = TargetManager.getInstance().getTarget();
//#endif 


//#if 148260533 
if(Model.getFacade().isAModelElement(obj))//1
{ 

//#if 1044816697 
Object tv =
                    Model.getFacade().getTaggedValue(
                        obj, ImportInterface.SOURCE_PATH_TAG);
//#endif 


//#if -1373377591 
if(tv == null)//1
{ 

//#if -1889448293 
Model.getExtensionMechanismsHelper().addTaggedValue(
                        obj,
                        Model.getExtensionMechanismsFactory()
                        .buildTaggedValue(
                            ImportInterface.SOURCE_PATH_TAG,
                            f.getPath()));
//#endif 

} 
else
{ 

//#if 491562192 
Model.getExtensionMechanismsHelper().setValueOfTag(
                        tv, f.getPath());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1954856299 
public ActionSetSourcePath()
    { 

//#if 1901360930 
super(Translator.localize("action.set-source-path"), null);
//#endif 


//#if 1434684605 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.set-source-path"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

