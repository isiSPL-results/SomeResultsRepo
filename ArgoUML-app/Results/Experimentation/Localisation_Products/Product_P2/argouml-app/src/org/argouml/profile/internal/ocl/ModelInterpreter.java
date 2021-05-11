package org.argouml.profile.internal.ocl;
import java.util.Map;
public interface ModelInterpreter  { 
Object getBuiltInSymbol(String sym);Object invokeFeature(Map<String, Object> vt, Object subject,
                         String feature, String type, Object[] parameters);
 } 
