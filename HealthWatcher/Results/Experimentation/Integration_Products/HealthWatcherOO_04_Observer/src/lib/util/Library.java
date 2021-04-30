package lib.util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Library  { 
public static String getFileListReplace(String[] keywords, String[] newWords, String file)
    throws FileNotFoundException
    { 
String text;
text = readFile(file);
return getWordListReplace(keywords, newWords, text);
} 
public static String getFileReplace(String keyWord, String newWord, String file)
    throws FileNotFoundException
    { 
String text;
text = readFile(file);
return getWordReplace(keyWord, newWord, text);
} 
public static String ajusteString(String aux)
    { 
StringTokenizer stoken;
stoken = new StringTokenizer(aux, (char) 10 + "" + (char) 13);
aux = "";
while (stoken.hasMoreTokens()) //1
{ 
aux = aux + stoken.nextToken() + "\\n";
} 
if(aux.length() < 3)//1
{ 
return aux;
} 
return aux.substring(0, (aux.length() - 2));
} 
private static String readFile(String file) throws FileNotFoundException
    { 
String context;
String aux = null;
FileReader fr = null;
BufferedReader bf = null;
fr = new FileReader(file);
bf = new BufferedReader(fr);
context = new String();
try//1
{ 
aux = bf.readLine();
while (aux != null) //1
{ 
aux += "\n";
context += aux;
aux = bf.readLine();
} 
fr.close();
bf.close();
} 
catch (IOException i) //1
{ 
i.printStackTrace();
} 
return context;
} 
private static String getWordListReplace(String[] keywords, String[] newWords, String text)
    { 
int menorTamanho = 0;
String texto2 = new String(text);
menorTamanho = keywords.length;
if(menorTamanho > newWords.length)//1
{ 
menorTamanho = newWords.length;
} 
for (int i = 0; i < menorTamanho; i++) //1
{ 
texto2 = getWordReplace(keywords[i], newWords[i], texto2);
} 
return texto2;
} 
public static String getFile(String file) throws FileNotFoundException
    { 
return readFile(file);
} 
private static String getWordReplace(String keyword, String newWord, String texto)
    { 
String newText;
int indice;
String texto2 = new String(texto);
newText = new String();
indice = texto2.indexOf(keyword);
while (indice != -1) //1
{ 
newText += texto2.substring(0, indice) + newWord;
texto2 = texto2.substring(indice + keyword.length());
indice = texto2.indexOf(keyword);
} 
return newText + texto2;
} 

 } 
