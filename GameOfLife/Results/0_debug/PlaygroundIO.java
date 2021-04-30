
//#if -2141056264 
// Compilation Unit of /PlaygroundIO.java 
 

//#if 1406917530 
import java.io.*;
//#endif 


//#if -1128340600 
public class PlaygroundIO  { 

//#if 1582443302 
private static final String FILE_HEADER="Game_of_Life.Playground";
//#endif 


//#if 985084042 
private static final String WIDTH_TOKEN="width ";
//#endif 


//#if 1695121110 
private static final String HEIGHT_TOKEN="height ";
//#endif 


//#if 1099487903 
private static final String DATA_BEGIN_TOKEN="Begin";
//#endif 


//#if -663555105 
private static final String DATA_END_TOKEN="End";
//#endif 


//#if -1280140892 
public static int[][] loadFromFile(  File source) throws IOException
    { 

//#if -1321497171 
if(!source.exists())//1
{ 

//#if -482680418 
throw new IOException("Given File Doesnt Exist" + source.getName());
//#endif 

} 
else

//#if 817303449 
if(!source.canRead())//1
{ 

//#if 660198620 
throw new IOException("Given File Is Not Readable" + source.getName());
//#endif 

} 

//#endif 


//#endif 


//#if -1709332178 
BufferedReader reader=new BufferedReader(new FileReader(source));
//#endif 


//#if 1288600780 
if(!reader.ready())//1
{ 

//#if -61036579 
throw new IOException("Given File Is Empty" + source.getName());
//#endif 

} 

//#endif 


//#if 515013250 
int[][] playground;
//#endif 


//#if -89825887 
String line;
//#endif 


//#if 2013327271 
if(!reader.readLine().equals(FILE_HEADER))//1
{ 

//#if 1633753523 
throw new IOException("Illegal format");
//#endif 

} 

//#endif 


//#if 1632148331 
try //1
{ 

//#if -1709038421 
int width;
//#endif 


//#if -1978521282 
int height;
//#endif 


//#if 960887509 
line=reader.readLine();
//#endif 


//#if -1267898678 
if(!line.startsWith(HEIGHT_TOKEN))//1
{ 

//#if -592136131 
throw new IOException("Illegal format");
//#endif 

} 
else
{ 

//#if 1920573262 
height=Integer.parseInt(line.substring(HEIGHT_TOKEN.length()));
//#endif 

} 

//#endif 


//#if -157200547 
line=reader.readLine();
//#endif 


//#if -42414537 
if(!line.startsWith(WIDTH_TOKEN))//1
{ 

//#if 596392016 
throw new IOException("Illegal format");
//#endif 

} 
else
{ 

//#if -1854379167 
width=Integer.parseInt(line.substring(WIDTH_TOKEN.length()));
//#endif 

} 

//#endif 


//#if -205068575 
if(!reader.readLine().equals(DATA_BEGIN_TOKEN))//1
{ 

//#if -886285555 
throw new IOException("Illegal format");
//#endif 

} 

//#endif 


//#if -780864122 
playground=new int[width][height];
//#endif 


//#if -155224739 
for (int r=0; r < height; r++) //1
{ 

//#if -1426079821 
line=reader.readLine();
//#endif 


//#if 1247914293 
for (int i=0; i < width; i++) //1
{ 

//#if -1627206478 
playground[r][i]=Integer.parseInt(line.substring(i,i + 1));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -74700753 
if(!reader.readLine().equals(DATA_END_TOKEN))//1
{ 

//#if 1907343324 
throw new IOException("Illegal format");
//#endif 

} 

//#endif 

} 

//#if -635094165 
catch (    NumberFormatException e)//1
{ 

//#if 1567232588 
throw new IOException("Illegal format");
//#endif 

} 

//#endif 


//#endif 


//#if 20666075 
return playground;
//#endif 

} 

//#endif 


//#if 1486225967 
private static boolean isSquare(  int[][] pg)
    { 

//#if 495995405 
if(pg.length == 0)//1
{ 

//#if 1979736458 
return true;
//#endif 

} 

//#endif 


//#if -2042733717 
int width=pg[0].length;
//#endif 


//#if 1406180998 
for (int r=1; r < pg.length; r++) //1
{ 

//#if -1503931779 
if(pg[r].length != width)//1
{ 

//#if -981275282 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -407544604 
return true;
//#endif 

} 

//#endif 


//#if -1157965502 
public static void saveToFile(  int[][] pg,  File dest) throws IOException
    { 

//#if -443549276 
FileWriter playgroundWriter=null;
//#endif 


//#if 622237708 
if(dest == null)//1
{ 

//#if -1455383116 
throw new IllegalArgumentException("dest was null");
//#endif 

} 
else

//#if -442463854 
if(pg == null)//1
{ 

//#if 1433131904 
throw new IllegalArgumentException("pg was null");
//#endif 

} 

//#endif 


//#endif 


//#if 1726396383 
if(!isSquare(pg))//1
{ 

//#if 1935488300 
throw new IllegalArgumentException("tried to save a non-square playground");
//#endif 

} 

//#endif 


//#if 587606678 
if(dest.exists())//1
{ 

//#if 618090768 
dest.delete();
//#endif 

} 

//#endif 


//#if -350163741 
if(!dest.createNewFile())//1
{ 

//#if -1943202888 
throw new IOException("File Could Not Be Created" + dest.getName());
//#endif 

} 

//#endif 


//#if 649858110 
if(!dest.canWrite())//1
{ 

//#if -49852504 
throw new IOException("cannot write to" + dest.getName());
//#endif 

} 

//#endif 


//#if 1408010086 
try //1
{ 

//#if -1542326127 
int height=pg.length;
//#endif 


//#if 519211390 
int width=pg[0].length;
//#endif 


//#if 1761197232 
playgroundWriter=new FileWriter(dest);
//#endif 


//#if -355439464 
playgroundWriter.write(FILE_HEADER + "\n");
//#endif 


//#if -1634314761 
playgroundWriter.write(HEIGHT_TOKEN + height + "\n");
//#endif 


//#if 729459885 
playgroundWriter.write(WIDTH_TOKEN + width + "\n");
//#endif 


//#if -1354105440 
playgroundWriter.write(DATA_BEGIN_TOKEN + "\n");
//#endif 


//#if 11509706 
for (int r=0; r < height; r++) //1
{ 

//#if 67960400 
for (int i=0; i < width; i++) //1
{ 

//#if 320749361 
playgroundWriter.write(String.valueOf(pg[r][i]));
//#endif 

} 

//#endif 


//#if -745387757 
playgroundWriter.write("\n");
//#endif 

} 

//#endif 


//#if 754426799 
playgroundWriter.write(DATA_END_TOKEN);
//#endif 

} 

//#if -1415534045 
catch (    final IOException e)//1
{ 

//#if 539151227 
throw new IOException("Unexpected Write Exception Occured");
//#endif 

} 

//#endif 

finally { 

//#if -1805260360 
if(playgroundWriter != null)//1
{ 

//#if -437009785 
playgroundWriter.close();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

