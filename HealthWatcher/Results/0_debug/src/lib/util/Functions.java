
//#if -1899271631
// Compilation Unit of /Functions.java


//#if -57399418
package lib.util;
//#endif


//#if -410160408
public class Functions
{

//#if 1550616668
    public Functions()
    {
    }
//#endif


//#if -1528648284
    public void campoPreenchido(Object o)
    {

//#if -552398787
        if(o == null) { //1

//#if 1717073969
            throw new IllegalArgumentException();
//#endif

        }

//#endif

    }

//#endif


//#if 852348471
    public void campoPreenchido(String campo)
    {

//#if -1752395564
        if(campo.length() == 0) { //1

//#if 203441502
            throw new IllegalArgumentException();
//#endif

        }

//#endif


//#if -1795255463
        if(campo == " ") { //1

//#if -507615147
            throw new IllegalArgumentException();
//#endif

        }

//#endif

    }

//#endif


//#if -227953281
    public void campoPreenchido(int campo)
    {

//#if 1173969612
        if(campo == 0) { //1

//#if 618042932
            throw new IllegalArgumentException();
//#endif

        }

//#endif

    }

//#endif


//#if 571923212
    public void campoPreenchido(short campo)
    {

//#if 927929176
        if(campo == 0) { //1

//#if -989868295
            throw new IllegalArgumentException();
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

