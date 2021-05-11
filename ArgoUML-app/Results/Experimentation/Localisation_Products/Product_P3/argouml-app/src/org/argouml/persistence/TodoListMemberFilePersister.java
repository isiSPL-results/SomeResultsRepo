package org.argouml.persistence;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import org.argouml.application.api.Argo;
import org.argouml.cognitive.Designer;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectMember;
import org.argouml.ocl.OCLExpander;
import org.argouml.uml.cognitive.ProjectMemberTodoList;
import org.tigris.gef.ocl.ExpansionException;
import org.tigris.gef.ocl.TemplateReader;
class TodoListMemberFilePersister extends MemberFilePersister
  { 
private static final String TO_DO_TEE = "/org/argouml/persistence/todo.tee";
@Override
    public void load(Project project, URL url) throws OpenException
    { 
try//1
{ 
load(project, url.openStream());
} 
catch (IOException e) //1
{ 
throw new OpenException(e);
} 
} 
public void load(Project project, InputStream inputStream)
    throws OpenException
    { 
try//1
{ 
TodoParser parser = new TodoParser();
Reader reader = new InputStreamReader(inputStream,
                                                  Argo.getEncoding());
parser.readTodoList(reader);
ProjectMemberTodoList pm = new ProjectMemberTodoList("", project);
project.addMember(pm);
} 
catch (Exception e) //1
{ 
if(e instanceof OpenException)//1
{ 
throw (OpenException) e;
} 
throw new OpenException(e);
} 
} 
public final String getMainTag()
    { 
return "todo";
} 
public void save(ProjectMember member, OutputStream outStream)
    throws SaveException
    { 
OCLExpander expander;
try//1
{ 
expander =
                new OCLExpander(TemplateReader.getInstance()
                                .read(TO_DO_TEE));
} 
catch (ExpansionException e) //1
{ 
throw new SaveException(e);
} 
PrintWriter pw;
try//2
{ 
pw = new PrintWriter(new OutputStreamWriter(outStream, "UTF-8"));
} 
catch (UnsupportedEncodingException e1) //1
{ 
throw new SaveException("UTF-8 encoding not supported on platform",
                                    e1);
} 
try//3
{ 
Designer.disableCritiquing();
expander.expand(pw, member);
} 
catch (ExpansionException e) //1
{ 
throw new SaveException(e);
} 
finally { 
pw.flush();
Designer.enableCritiquing();
} 
} 

 } 
