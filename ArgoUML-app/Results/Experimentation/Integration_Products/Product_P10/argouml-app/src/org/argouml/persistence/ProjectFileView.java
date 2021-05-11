package org.argouml.persistence;
import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileView;
import org.argouml.application.helpers.ResourceLoaderWrapper;
public final class ProjectFileView extends FileView
  { 
private static ProjectFileView instance = new ProjectFileView();
public static ProjectFileView getInstance()
    { 
return instance;
} 
private ProjectFileView()
    { 
} 
public Icon getIcon(File f)
    { 
AbstractFilePersister persister = PersistenceManager.getInstance()
                                          .getPersisterFromFileName(f.getName());
if(persister != null && persister.hasAnIcon())//1
{ 
return ResourceLoaderWrapper.lookupIconResource("UmlNotation");
} 
else
{ 
return null;
} 
} 

 } 
