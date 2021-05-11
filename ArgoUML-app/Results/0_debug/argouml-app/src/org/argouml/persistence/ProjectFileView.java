
//#if 606957835 
// Compilation Unit of /ProjectFileView.java 
 

//#if -1337436924 
package org.argouml.persistence;
//#endif 


//#if 1085389923 
import java.io.File;
//#endif 


//#if -290130118 
import javax.swing.Icon;
//#endif 


//#if 1743899523 
import javax.swing.filechooser.FileView;
//#endif 


//#if -118351891 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -217986348 
public final class ProjectFileView extends 
//#if 1876714316 
FileView
//#endif 

  { 

//#if -1899464180 
private static ProjectFileView instance = new ProjectFileView();
//#endif 


//#if 41681076 
public static ProjectFileView getInstance()
    { 

//#if -127509233 
return instance;
//#endif 

} 

//#endif 


//#if -221868381 
private ProjectFileView()
    { 
} 

//#endif 


//#if -757186715 
public Icon getIcon(File f)
    { 

//#if 1399260611 
AbstractFilePersister persister = PersistenceManager.getInstance()
                                          .getPersisterFromFileName(f.getName());
//#endif 


//#if 184036611 
if(persister != null && persister.hasAnIcon())//1
{ 

//#if -1268826072 
return ResourceLoaderWrapper.lookupIconResource("UmlNotation");
//#endif 

} 
else
{ 

//#if 1224973 
return null;
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

