
//#if -223665424
// Compilation Unit of /Library.java


//#if 1706352209
package lib.util;
//#endif


//#if 1552883313
import java.io.BufferedReader;
//#endif


//#if 1551495871
import java.io.FileNotFoundException;
//#endif


//#if 648657716
import java.io.FileReader;
//#endif


//#if 1891395066
import java.io.IOException;
//#endif


//#if -486494687
import java.util.StringTokenizer;
//#endif


//#if -2131677357
public class Library
{

//#if 712471663
    public static String getFileListReplace(String[] keywords, String[] newWords, String file)
    throws FileNotFoundException
    {

//#if 2078453493
        String text;
//#endif


//#if 495641052
        text = readFile(file);
//#endif


//#if 102920762
        return getWordListReplace(keywords, newWords, text);
//#endif

    }

//#endif


//#if -653371337
    public static String getFileReplace(String keyWord, String newWord, String file)
    throws FileNotFoundException
    {

//#if 235482813
        String text;
//#endif


//#if -559701228
        text = readFile(file);
//#endif


//#if 1756621128
        return getWordReplace(keyWord, newWord, text);
//#endif

    }

//#endif


//#if 73481476
    public static String ajusteString(String aux)
    {

//#if -1474888989
        StringTokenizer stoken;
//#endif


//#if -290329424
        stoken = new StringTokenizer(aux, (char) 10 + "" + (char) 13);
//#endif


//#if -1207761426
        aux = "";
//#endif


//#if -1793516139
        while (stoken.hasMoreTokens()) { //1

//#if -1643309854
            aux = aux + stoken.nextToken() + "\\n";
//#endif

        }

//#endif


//#if -44643705
        if(aux.length() < 3) { //1

//#if 520483704
            return aux;
//#endif

        }

//#endif


//#if -261378434
        return aux.substring(0, (aux.length() - 2));
//#endif

    }

//#endif


//#if -1692257800
    private static String readFile(String file) throws FileNotFoundException
    {

//#if 1813507030
        String context;
//#endif


//#if 289727249
        String aux = null;
//#endif


//#if 1785594747
        FileReader fr = null;
//#endif


//#if -665622890
        BufferedReader bf = null;
//#endif


//#if 1964026927
        fr = new FileReader(file);
//#endif


//#if 1615454724
        bf = new BufferedReader(fr);
//#endif


//#if -1160471344
        context = new String();
//#endif


//#if -502431761
        try { //1

//#if -217882777
            aux = bf.readLine();
//#endif


//#if 1801397616
            while (aux != null) { //1

//#if 1647904401
                aux += "\n";
//#endif


//#if 1713923358
                context += aux;
//#endif


//#if -459277447
                aux = bf.readLine();
//#endif

            }

//#endif


//#if -418914596
            fr.close();
//#endif


//#if 537118308
            bf.close();
//#endif

        }

//#if 2014564639
        catch (IOException i) { //1

//#if -1631786174
            i.printStackTrace();
//#endif

        }

//#endif


//#endif


//#if -1251578411
        return context;
//#endif

    }

//#endif


//#if 398059409
    private static String getWordListReplace(String[] keywords, String[] newWords, String text)
    {

//#if 27527409
        int menorTamanho = 0;
//#endif


//#if 2044946719
        String texto2 = new String(text);
//#endif


//#if -502408256
        menorTamanho = keywords.length;
//#endif


//#if -1582392696
        if(menorTamanho > newWords.length) { //1

//#if -1121907525
            menorTamanho = newWords.length;
//#endif

        }

//#endif


//#if -533359040
        for (int i = 0; i < menorTamanho; i++) { //1

//#if -44767366
            texto2 = getWordReplace(keywords[i], newWords[i], texto2);
//#endif

        }

//#endif


//#if -181263640
        return texto2;
//#endif

    }

//#endif


//#if 481114850
    public static String getFile(String file) throws FileNotFoundException
    {

//#if 718344733
        return readFile(file);
//#endif

    }

//#endif


//#if -771788646
    private static String getWordReplace(String keyword, String newWord, String texto)
    {

//#if -1415116452
        String newText;
//#endif


//#if 1903891037
        int indice;
//#endif


//#if 837357726
        String texto2 = new String(texto);
//#endif


//#if 1266463830
        newText = new String();
//#endif


//#if 1948690610
        indice = texto2.indexOf(keyword);
//#endif


//#if -649511160
        while (indice != -1) { //1

//#if 1540545020
            newText += texto2.substring(0, indice) + newWord;
//#endif


//#if 125038058
            texto2 = texto2.substring(indice + keyword.length());
//#endif


//#if 1815210980
            indice = texto2.indexOf(keyword);
//#endif

        }

//#endif


//#if -616697600
        return newText + texto2;
//#endif

    }

//#endif

}

//#endif


//#endif

