// Compilation Unit of /ModuleInterface.java 
 
package org.argouml.moduleloader;
public interface ModuleInterface  { 
int DESCRIPTION = 0;
int AUTHOR = 1;
int VERSION = 2;
int DOWNLOADSITE = 3;
String getName();
String getInfo(int type);
boolean enable();
boolean disable();
 } 


