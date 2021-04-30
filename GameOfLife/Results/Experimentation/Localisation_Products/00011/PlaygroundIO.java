import java.io.*;
public class PlaygroundIO  { 
private static final String FILE_HEADER="Game_of_Life.Playground";
private static final String WIDTH_TOKEN="width ";
private static final String HEIGHT_TOKEN="height ";
private static final String DATA_BEGIN_TOKEN="Begin";
private static final String DATA_END_TOKEN="End";
public static int[][] loadFromFile(  File source) throws IOException
    { 
if(!source.exists())//1
{ 
throw new IOException("Given File Doesnt Exist" + source.getName());
} 
else
if(!source.canRead())//1
{ 
throw new IOException("Given File Is Not Readable" + source.getName());
} 
BufferedReader reader=new BufferedReader(new FileReader(source));
if(!reader.ready())//1
{ 
throw new IOException("Given File Is Empty" + source.getName());
} 
int[][] playground;
String line;
if(!reader.readLine().equals(FILE_HEADER))//1
{ 
throw new IOException("Illegal format");
} 
try//1
{ 
int width;
int height;
line=reader.readLine();
if(!line.startsWith(HEIGHT_TOKEN))//1
{ 
throw new IOException("Illegal format");
} 
else
{ 
height=Integer.parseInt(line.substring(HEIGHT_TOKEN.length()));
} 
line=reader.readLine();
if(!line.startsWith(WIDTH_TOKEN))//1
{ 
throw new IOException("Illegal format");
} 
else
{ 
width=Integer.parseInt(line.substring(WIDTH_TOKEN.length()));
} 
if(!reader.readLine().equals(DATA_BEGIN_TOKEN))//1
{ 
throw new IOException("Illegal format");
} 
playground=new int[width][height];
for (int r=0; r < height; r++) //1
{ 
line=reader.readLine();
for (int i=0; i < width; i++) //1
{ 
playground[r][i]=Integer.parseInt(line.substring(i,i + 1));
} 
} 
if(!reader.readLine().equals(DATA_END_TOKEN))//1
{ 
throw new IOException("Illegal format");
} 
} 
catch (    NumberFormatException e)//1
{ 
throw new IOException("Illegal format");
} 
return playground;
} 
private static boolean isSquare(  int[][] pg)
    { 
if(pg.length == 0)//1
{ 
return true;
} 
int width=pg[0].length;
for (int r=1; r < pg.length; r++) //1
{ 
if(pg[r].length != width)//1
{ 
return false;
} 
} 
return true;
} 
public static void saveToFile(  int[][] pg,  File dest) throws IOException
    { 
FileWriter playgroundWriter=null;
if(dest == null)//1
{ 
throw new IllegalArgumentException("dest was null");
} 
else
if(pg == null)//1
{ 
throw new IllegalArgumentException("pg was null");
} 
if(!isSquare(pg))//1
{ 
throw new IllegalArgumentException("tried to save a non-square playground");
} 
if(dest.exists())//1
{ 
dest.delete();
} 
if(!dest.createNewFile())//1
{ 
throw new IOException("File Could Not Be Created" + dest.getName());
} 
if(!dest.canWrite())//1
{ 
throw new IOException("cannot write to" + dest.getName());
} 
try//1
{ 
int height=pg.length;
int width=pg[0].length;
playgroundWriter=new FileWriter(dest);
playgroundWriter.write(FILE_HEADER + "\n");
playgroundWriter.write(HEIGHT_TOKEN + height + "\n");
playgroundWriter.write(WIDTH_TOKEN + width + "\n");
playgroundWriter.write(DATA_BEGIN_TOKEN + "\n");
for (int r=0; r < height; r++) //1
{ 
for (int i=0; i < width; i++) //1
{ 
playgroundWriter.write(String.valueOf(pg[r][i]));
} 
playgroundWriter.write("\n");
} 
playgroundWriter.write(DATA_END_TOKEN);
} 
catch (    final IOException e)//1
{ 
throw new IOException("Unexpected Write Exception Occured");
} 
finally { 
if(playgroundWriter != null)//1
{ 
playgroundWriter.close();
} 
} 
} 

 } 
