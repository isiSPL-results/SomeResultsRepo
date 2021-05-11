
//#if -974191987 
// Compilation Unit of /FileFilters.java 
 

//#if 1768645934 
package org.argouml.util;
//#endif 


//#if 143706163 
import javax.swing.filechooser.FileFilter;
//#endif 


//#if 426881451 
import org.argouml.i18n.Translator;
//#endif 


//#if -1457225528 
public class FileFilters  { 

//#if -166607181 
public static final SuffixFilter UNCOMPRESSED_FILE_FILTER = new
    SuffixFilter(FileConstants.UNCOMPRESSED_FILE_EXT.substring(1),
                 "Argo uncompressed project file");
//#endif 


//#if 1158848570 
public static final SuffixFilter COMPRESSED_FILE_FILTER = new
    SuffixFilter(FileConstants.COMPRESSED_FILE_EXT.substring(1),
                 "Argo compressed project file");
//#endif 


//#if -1371896847 
public static final SuffixFilter XMI_FILTER = new
    SuffixFilter("xmi", "XML Metadata Interchange");
//#endif 


//#if 1840081061 
public static final SuffixFilter PGML_FILTER = new
    SuffixFilter("pgml", "Argo diagram");
//#endif 


//#if -1797035800 
public static final SuffixFilter CONFIG_FILTER = new
    SuffixFilter("config", "Argo configutation file");
//#endif 


//#if -876970296 
public static final SuffixFilter HIST_FILTER = new
    SuffixFilter("hist", "Argo history file");
//#endif 


//#if 1935116219 
public static final SuffixFilter LOG_FILTER = new
    SuffixFilter("log", "Argo usage log");
//#endif 


//#if -935796222 
public static final SuffixFilter GIF_FILTER = new
    SuffixFilter("gif", Translator.localize("combobox.filefilter.gif"));
//#endif 


//#if 233541297 
public static final SuffixFilter PNG_FILTER = new
    SuffixFilter("png", Translator.localize("combobox.filefilter.png"));
//#endif 


//#if -471873275 
public static final SuffixFilter PS_FILTER = new
    SuffixFilter("ps", Translator.localize("combobox.filefilter.ps"));
//#endif 


//#if -1385858002 
public static final SuffixFilter EPS_FILTER = new
    SuffixFilter("eps", Translator.localize("combobox.filefilter.eps"));
//#endif 


//#if 1640046050 
public static final SuffixFilter SVG_FILTER = new
    SuffixFilter("svg", Translator.localize("combobox.filefilter.svg"));
//#endif 


//#if 1861295612 
public static String getSuffix(FileFilter filter)
    { 

//#if 1704636929 
if(filter instanceof SuffixFilter)//1
{ 

//#if -1788394817 
return ((SuffixFilter) filter).getSuffix();
//#endif 

} 

//#endif 


//#if 1281644741 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

