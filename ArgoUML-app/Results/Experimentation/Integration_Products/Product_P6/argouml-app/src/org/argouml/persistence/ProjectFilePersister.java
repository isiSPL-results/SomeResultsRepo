package org.argouml.persistence;
import java.io.File;
import org.argouml.kernel.Project;
import org.argouml.taskmgmt.ProgressListener;
public interface ProjectFilePersister  { 
public void addProgressListener(ProgressListener listener);Project doLoad(File file) throws OpenException, InterruptedException;public void removeProgressListener(ProgressListener listener);void save(Project project, File file) throws SaveException,
             InterruptedException;
 } 
