import java.io.File;
import java.util.Hashtable;
import java.util.Enumeration;
import javax.swing.filechooser.*;
public class ExampleFileFilter extends FileFilter
  { 
private Hashtable<String, ExampleFileFilter> filters = null;
private String description = null;
private String fullDescription = null;
private boolean useExtensionsInDescription = true;
public ExampleFileFilter(String[] filters, String description)
    { 
this();
for (int i = 0; i < filters.length; i++) //1
{ 
addExtension(filters[i]);
} 
if(description!=null)//1
{ 
setDescription(description);
} 
} 
@SuppressWarnings("rawtypes")

    public String getDescription()
    { 
if(fullDescription == null)//1
{ 
if(description == null || isExtensionListInDescription())//1
{ 
fullDescription = description==null ? "(" : description + " (";
Enumeration extensions = filters.keys();
if(extensions != null)//1
{ 
fullDescription += "." + (String) extensions.nextElement();
while (extensions.hasMoreElements()) //1
{ 
fullDescription += ", ." + (String) extensions.nextElement();
} 
} 
fullDescription += ")";
} 
else
{ 
fullDescription = description;
} 
} 
return fullDescription;
} 
public ExampleFileFilter()
    { 
this.filters = new Hashtable<String, ExampleFileFilter>();
} 
public ExampleFileFilter(String extension, String description)
    { 
this();
if(extension!=null)//1
{ 
addExtension(extension);
} 
if(description!=null)//1
{ 
setDescription(description);
} 
} 
public boolean isExtensionListInDescription()
    { 
return useExtensionsInDescription;
} 
public String getExtension(File f)
    { 
if(f != null)//1
{ 
String filename = f.getName();
int i = filename.lastIndexOf('.');
if(i>0 && i<filename.length()-1)//1
{ 
return filename.substring(i+1).toLowerCase();
} 
} 
return null;
} 
public boolean accept(File f)
    { 
if(f != null)//1
{ 
if(f.isDirectory())//1
{ 
return true;
} 
String extension = getExtension(f);
if(extension != null && filters.get(getExtension(f)) != null)//1
{ 
return true;
} 
} 
return false;
} 
public ExampleFileFilter(String[] filters)
    { 
this(filters, null);
} 
public void setDescription(String description)
    { 
this.description = description;
fullDescription = null;
} 
public ExampleFileFilter(String extension)
    { 
this(extension,null);
} 
public void addExtension(String extension)
    { 
if(filters == null)//1
{ 
filters = new Hashtable<String, ExampleFileFilter>(5);
} 
filters.put(extension.toLowerCase(), this);
fullDescription = null;
} 
public void setExtensionListInDescription(boolean b)
    { 
useExtensionsInDescription = b;
fullDescription = null;
} 

 } 
