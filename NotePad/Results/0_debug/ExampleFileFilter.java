
//#if 1678100174
// Compilation Unit of /ExampleFileFilter.java


//#if 1176180411
import java.io.File;
//#endif


//#if -1288621469
import java.util.Hashtable;
//#endif


//#if 1576413820
import java.util.Enumeration;
//#endif


//#if 12290192
import javax.swing.filechooser.*;
//#endif


//#if 1372920882
public class ExampleFileFilter extends
//#if 653551244
    FileFilter
//#endif

{

//#if 1311827134
    private Hashtable<String, ExampleFileFilter> filters = null;
//#endif


//#if -1175305769
    private String description = null;
//#endif


//#if -1735090936
    private String fullDescription = null;
//#endif


//#if 868598089
    private boolean useExtensionsInDescription = true;
//#endif


//#if 503016429
    public ExampleFileFilter(String[] filters, String description)
    {

//#if 1732712680
        this();
//#endif


//#if -1943162147
        for (int i = 0; i < filters.length; i++) { //1

//#if 776750650
            addExtension(filters[i]);
//#endif

        }

//#endif


//#if -1404152944
        if(description!=null) { //1

//#if -1110099383
            setDescription(description);
//#endif

        }

//#endif

    }

//#endif


//#if -779808135

//#if 223590303
    @SuppressWarnings("rawtypes")
//#endif


    public String getDescription()
    {

//#if 1872482565
        if(fullDescription == null) { //1

//#if -2067148315
            if(description == null || isExtensionListInDescription()) { //1

//#if -1743103498
                fullDescription = description==null ? "(" : description + " (";
//#endif


//#if -1095050573
                Enumeration extensions = filters.keys();
//#endif


//#if -699663188
                if(extensions != null) { //1

//#if -1776875807
                    fullDescription += "." + (String) extensions.nextElement();
//#endif


//#if 1740632998
                    while (extensions.hasMoreElements()) { //1

//#if 1213423178
                        fullDescription += ", ." + (String) extensions.nextElement();
//#endif

                    }

//#endif

                }

//#endif


//#if -310866271
                fullDescription += ")";
//#endif

            } else {

//#if 615940606
                fullDescription = description;
//#endif

            }

//#endif

        }

//#endif


//#if 1189980306
        return fullDescription;
//#endif

    }

//#endif


//#if -119839714
    public ExampleFileFilter()
    {

//#if 1001061085
        this.filters = new Hashtable<String, ExampleFileFilter>();
//#endif

    }

//#endif


//#if -1228394425
    public ExampleFileFilter(String extension, String description)
    {

//#if 2057362073
        this();
//#endif


//#if -1334814590
        if(extension!=null) { //1

//#if 19457537
            addExtension(extension);
//#endif

        }

//#endif


//#if 2053900799
        if(description!=null) { //1

//#if -1683442681
            setDescription(description);
//#endif

        }

//#endif

    }

//#endif


//#if -233298452
    public boolean isExtensionListInDescription()
    {

//#if -311798887
        return useExtensionsInDescription;
//#endif

    }

//#endif


//#if -1840450004
    public String getExtension(File f)
    {

//#if -1304537149
        if(f != null) { //1

//#if -1664687222
            String filename = f.getName();
//#endif


//#if -500280899
            int i = filename.lastIndexOf('.');
//#endif


//#if 879369083
            if(i>0 && i<filename.length()-1) { //1

//#if 1569184131
                return filename.substring(i+1).toLowerCase();
//#endif

            }

//#endif

        }

//#endif


//#if -333265177
        return null;
//#endif

    }

//#endif


//#if 594019928
    public boolean accept(File f)
    {

//#if -2080329055
        if(f != null) { //1

//#if 1648759268
            if(f.isDirectory()) { //1

//#if 798634287
                return true;
//#endif

            }

//#endif


//#if 1906812115
            String extension = getExtension(f);
//#endif


//#if 664228121
            if(extension != null && filters.get(getExtension(f)) != null) { //1

//#if -752254539
                return true;
//#endif

            }

//#endif

        }

//#endif


//#if -349367069
        return false;
//#endif

    }

//#endif


//#if 532183884
    public ExampleFileFilter(String[] filters)
    {

//#if 21840515
        this(filters, null);
//#endif

    }

//#endif


//#if 1512053975
    public void setDescription(String description)
    {

//#if 893979683
        this.description = description;
//#endif


//#if -540907145
        fullDescription = null;
//#endif

    }

//#endif


//#if 736330278
    public ExampleFileFilter(String extension)
    {

//#if 207343392
        this(extension,null);
//#endif

    }

//#endif


//#if 1133846608
    public void addExtension(String extension)
    {

//#if 1274414431
        if(filters == null) { //1

//#if -1789220029
            filters = new Hashtable<String, ExampleFileFilter>(5);
//#endif

        }

//#endif


//#if -1060253664
        filters.put(extension.toLowerCase(), this);
//#endif


//#if -1940490652
        fullDescription = null;
//#endif

    }

//#endif


//#if -1812553298
    public void setExtensionListInDescription(boolean b)
    {

//#if -1975700745
        useExtensionsInDescription = b;
//#endif


//#if -601457055
        fullDescription = null;
//#endif

    }

//#endif

}

//#endif


//#endif

