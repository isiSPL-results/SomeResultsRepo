package org.argouml.taskmgmt;
public interface ProgressMonitor extends ProgressListener
  { 
void updateProgress(int progress);void updateMainTask(String name);public void close();void updateSubTask(String name);void setMaximumProgress(int max);void notifyNullAction();boolean isCanceled();void notifyMessage(String title, String introduction, String message);
 } 
