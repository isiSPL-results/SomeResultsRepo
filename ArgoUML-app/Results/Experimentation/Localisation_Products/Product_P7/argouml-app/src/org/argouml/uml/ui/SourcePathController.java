package org.argouml.uml.ui;
import java.io.File;
import java.util.Collection;
public interface SourcePathController  { 
void deleteSourcePath(Object modelElement);File getSourcePath(final Object modelElement);void setSourcePath(SourcePathTableModel srcPaths);Collection getAllModelElementsWithSourcePath();void setSourcePath(Object modelElement, File sourcePath);SourcePathTableModel getSourcePathSettings();
 } 
