
//#if -1995379829 
// Compilation Unit of /TodoListMemberFilePersister.java 
 

//#if 2146765988 
package org.argouml.persistence;
//#endif 


//#if 1888757038 
import java.io.IOException;
//#endif 


//#if -129533107 
import java.io.InputStream;
//#endif 


//#if 1632484682 
import java.io.InputStreamReader;
//#endif 


//#if -1770433986 
import java.io.OutputStream;
//#endif 


//#if 942343627 
import java.io.OutputStreamWriter;
//#endif 


//#if -1785990025 
import java.io.PrintWriter;
//#endif 


//#if 1219528860 
import java.io.Reader;
//#endif 


//#if -1338593192 
import java.io.UnsupportedEncodingException;
//#endif 


//#if -1921253591 
import java.net.URL;
//#endif 


//#if 574399841 
import org.apache.log4j.Logger;
//#endif 


//#if 2140474099 
import org.argouml.application.api.Argo;
//#endif 


//#if -1396511681 
import org.argouml.cognitive.Designer;
//#endif 


//#if 2069218742 
import org.argouml.kernel.Project;
//#endif 


//#if 429121020 
import org.argouml.kernel.ProjectMember;
//#endif 


//#if 722837743 
import org.argouml.ocl.OCLExpander;
//#endif 


//#if -2073160945 
import org.argouml.uml.cognitive.ProjectMemberTodoList;
//#endif 


//#if 487356821 
import org.tigris.gef.ocl.ExpansionException;
//#endif 


//#if -1396306776 
import org.tigris.gef.ocl.TemplateReader;
//#endif 


//#if 740603882 
class TodoListMemberFilePersister extends 
//#if 1882961599 
MemberFilePersister
//#endif 

  { 

//#if 1734285549 
private static final Logger LOG =
        Logger.getLogger(ProjectMemberTodoList.class);
//#endif 


//#if 2109498780 
private static final String TO_DO_TEE = "/org/argouml/persistence/todo.tee";
//#endif 


//#if 510581270 
@Override
    public void load(Project project, URL url) throws OpenException
    { 

//#if -1504588069 
try //1
{ 

//#if -1201435423 
load(project, url.openStream());
//#endif 

} 

//#if -625305660 
catch (IOException e) //1
{ 

//#if -1268813306 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1150973022 
public void load(Project project, InputStream inputStream)
    throws OpenException
    { 

//#if 1572654129 
try //1
{ 

//#if -580896196 
TodoParser parser = new TodoParser();
//#endif 


//#if -1356873729 
Reader reader = new InputStreamReader(inputStream,
                                                  Argo.getEncoding());
//#endif 


//#if 462025478 
parser.readTodoList(reader);
//#endif 


//#if -1566462603 
ProjectMemberTodoList pm = new ProjectMemberTodoList("", project);
//#endif 


//#if 1631874563 
project.addMember(pm);
//#endif 

} 

//#if 191784749 
catch (Exception e) //1
{ 

//#if -177369704 
if(e instanceof OpenException)//1
{ 

//#if 1671962579 
throw (OpenException) e;
//#endif 

} 

//#endif 


//#if 726374731 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 734221886 
public final String getMainTag()
    { 

//#if -1951452913 
return "todo";
//#endif 

} 

//#endif 


//#if 1539091720 
public void save(ProjectMember member, OutputStream outStream)
    throws SaveException
    { 

//#if 1358587833 
OCLExpander expander;
//#endif 


//#if -1112395750 
try //1
{ 

//#if -2057439590 
expander =
                new OCLExpander(TemplateReader.getInstance()
                                .read(TO_DO_TEE));
//#endif 

} 

//#if 5908895 
catch (ExpansionException e) //1
{ 

//#if -1758835919 
throw new SaveException(e);
//#endif 

} 

//#endif 


//#endif 


//#if -808323304 
PrintWriter pw;
//#endif 


//#if 585944151 
try //2
{ 

//#if 310799890 
pw = new PrintWriter(new OutputStreamWriter(outStream, "UTF-8"));
//#endif 

} 

//#if 590697678 
catch (UnsupportedEncodingException e1) //1
{ 

//#if 1880276951 
throw new SaveException("UTF-8 encoding not supported on platform",
                                    e1);
//#endif 

} 

//#endif 


//#endif 


//#if 585973943 
try //3
{ 

//#if 1568988763 
Designer.disableCritiquing();
//#endif 


//#if 631188159 
expander.expand(pw, member);
//#endif 

} 

//#if -1825989701 
catch (ExpansionException e) //1
{ 

//#if 1764819455 
throw new SaveException(e);
//#endif 

} 

//#endif 

finally { 

//#if -1760439559 
pw.flush();
//#endif 


//#if -505429911 
Designer.enableCritiquing();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

