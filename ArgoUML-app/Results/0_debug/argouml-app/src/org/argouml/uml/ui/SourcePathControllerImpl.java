
//#if -485174959 
// Compilation Unit of /SourcePathControllerImpl.java 
 

//#if -513596771 
package org.argouml.uml.ui;
//#endif 


//#if -1594559413 
import java.io.File;
//#endif 


//#if 1281230492 
import java.util.ArrayList;
//#endif 


//#if -1891929531 
import java.util.Collection;
//#endif 


//#if 578710645 
import java.util.Iterator;
//#endif 


//#if -1515735042 
import org.argouml.kernel.Project;
//#endif 


//#if 591716651 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 699417484 
import org.argouml.model.Model;
//#endif 


//#if 40361323 
import org.argouml.uml.reveng.ImportInterface;
//#endif 


//#if 184950488 
public class SourcePathControllerImpl implements 
//#if -977027959 
SourcePathController
//#endif 

  { 

//#if -1017440125 
public void setSourcePath(Object modelElement, File sourcePath)
    { 

//#if 1336422043 
Object tv =
            Model.getFacade().getTaggedValue(
                modelElement, ImportInterface.SOURCE_PATH_TAG);
//#endif 


//#if 282247967 
if(tv == null)//1
{ 

//#if -158455093 
Model.getExtensionMechanismsHelper().addTaggedValue(
                modelElement,
                Model.getExtensionMechanismsFactory().buildTaggedValue(
                    ImportInterface.SOURCE_PATH_TAG,
                    sourcePath.toString()));
//#endif 

} 
else
{ 

//#if -454073349 
Model.getExtensionMechanismsHelper().setValueOfTag(
                tv, sourcePath.toString());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -520219212 
public void setSourcePath(SourcePathTableModel srcPaths)
    { 

//#if -873547384 
for (int i = 0; i < srcPaths.getRowCount(); i++) //1
{ 

//#if 1449165218 
setSourcePath(srcPaths.getModelElement(i),
                          new File(srcPaths.getMESourcePath(i)));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1431048648 
public Collection getAllModelElementsWithSourcePath()
    { 

//#if 480482583 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 2028208162 
Object model = p.getRoot();
//#endif 


//#if -9277540 
Collection elems =
            Model.getModelManagementHelper().getAllModelElementsOfKindWithModel(
                model, Model.getMetaTypes().getModelElement());
//#endif 


//#if 441385130 
ArrayList mElemsWithSrcPath = new ArrayList();
//#endif 


//#if 435960922 
Iterator iter = elems.iterator();
//#endif 


//#if 1941071622 
while (iter.hasNext()) //1
{ 

//#if 502411467 
Object me = iter.next();
//#endif 


//#if -357765877 
if(getSourcePath(me) != null)//1
{ 

//#if -1767627400 
mElemsWithSrcPath.add(me);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1888821326 
return mElemsWithSrcPath;
//#endif 

} 

//#endif 


//#if 1358224723 
public File getSourcePath(Object modelElement)
    { 

//#if 185082768 
Object tv = Model.getFacade().getTaggedValue(modelElement,
                    ImportInterface.SOURCE_PATH_TAG);
//#endif 


//#if -781783258 
if(tv != null)//1
{ 

//#if -1773318182 
String srcPath = Model.getFacade().getValueOfTag(tv);
//#endif 


//#if 259159688 
if(srcPath != null)//1
{ 

//#if 1433231058 
return new File(srcPath);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 851432594 
return null;
//#endif 

} 

//#endif 


//#if 1422136916 
public String toString()
    { 

//#if 1075652544 
return "ArgoUML default source path controller.";
//#endif 

} 

//#endif 


//#if -1021989463 
public SourcePathTableModel getSourcePathSettings()
    { 

//#if -61061007 
return new SourcePathTableModel(this);
//#endif 

} 

//#endif 


//#if -771693372 
public void deleteSourcePath(Object modelElement)
    { 

//#if 1457057083 
Object taggedValue = Model.getFacade().getTaggedValue(modelElement,
                             ImportInterface.SOURCE_PATH_TAG);
//#endif 


//#if 1744066580 
Model.getExtensionMechanismsHelper().removeTaggedValue(modelElement,
                taggedValue);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

