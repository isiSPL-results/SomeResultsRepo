package org.argouml.persistence;
class XmlFilePersister extends XmiFilePersister
  { 
@Override
    public boolean hasAnIcon()
    { 
return false;
} 
@Override
    public String getExtension()
    { 
return "xml";
} 

 } 
