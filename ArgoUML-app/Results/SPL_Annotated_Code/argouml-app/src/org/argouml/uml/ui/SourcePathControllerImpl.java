// Compilation Unit of /SourcePathControllerImpl.java 
 
package org.argouml.uml.ui;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.uml.reveng.ImportInterface;
public class SourcePathControllerImpl implements SourcePathController
  { 
public void setSourcePath(Object modelElement, File sourcePath)
    { 
Object tv =
            Model.getFacade().getTaggedValue(
                modelElement, ImportInterface.SOURCE_PATH_TAG);
if(tv == null)//1
{ 
Model.getExtensionMechanismsHelper().addTaggedValue(
                modelElement,
                Model.getExtensionMechanismsFactory().buildTaggedValue(
                    ImportInterface.SOURCE_PATH_TAG,
                    sourcePath.toString()));
} 
else
{ 
Model.getExtensionMechanismsHelper().setValueOfTag(
                tv, sourcePath.toString());
} 

} 

public void setSourcePath(SourcePathTableModel srcPaths)
    { 
for (int i = 0; i < srcPaths.getRowCount(); i++) //1
{ 
setSourcePath(srcPaths.getModelElement(i),
                          new File(srcPaths.getMESourcePath(i)));
} 

} 

public Collection getAllModelElementsWithSourcePath()
    { 
Project p = ProjectManager.getManager().getCurrentProject();
Object model = p.getRoot();
Collection elems =
            Model.getModelManagementHelper().getAllModelElementsOfKindWithModel(
                model, Model.getMetaTypes().getModelElement());
ArrayList mElemsWithSrcPath = new ArrayList();
Iterator iter = elems.iterator();
while (iter.hasNext()) //1
{ 
Object me = iter.next();
if(getSourcePath(me) != null)//1
{ 
mElemsWithSrcPath.add(me);
} 

} 

return mElemsWithSrcPath;
} 

public File getSourcePath(Object modelElement)
    { 
Object tv = Model.getFacade().getTaggedValue(modelElement,
                    ImportInterface.SOURCE_PATH_TAG);
if(tv != null)//1
{ 
String srcPath = Model.getFacade().getValueOfTag(tv);
if(srcPath != null)//1
{ 
return new File(srcPath);
} 

} 

return null;
} 

public String toString()
    { 
return "ArgoUML default source path controller.";
} 

public SourcePathTableModel getSourcePathSettings()
    { 
return new SourcePathTableModel(this);
} 

public void deleteSourcePath(Object modelElement)
    { 
Object taggedValue = Model.getFacade().getTaggedValue(modelElement,
                             ImportInterface.SOURCE_PATH_TAG);
Model.getExtensionMechanismsHelper().removeTaggedValue(modelElement,
                taggedValue);
} 

 } 


