// Compilation Unit of /TodoListMemberFilePersister.java 
 

//#if COGNITIVE 
package org.argouml.persistence;
//#endif 


//#if COGNITIVE 
import java.io.IOException;
//#endif 


//#if COGNITIVE 
import java.io.InputStream;
//#endif 


//#if COGNITIVE 
import java.io.InputStreamReader;
//#endif 


//#if COGNITIVE 
import java.io.OutputStream;
//#endif 


//#if COGNITIVE 
import java.io.OutputStreamWriter;
//#endif 


//#if COGNITIVE 
import java.io.PrintWriter;
//#endif 


//#if COGNITIVE 
import java.io.Reader;
//#endif 


//#if COGNITIVE 
import java.io.UnsupportedEncodingException;
//#endif 


//#if COGNITIVE 
import java.net.URL;
//#endif 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.application.api.Argo;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Designer;
//#endif 


//#if COGNITIVE 
import org.argouml.kernel.Project;
//#endif 


//#if COGNITIVE 
import org.argouml.kernel.ProjectMember;
//#endif 


//#if COGNITIVE 
import org.argouml.ocl.OCLExpander;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.ProjectMemberTodoList;
//#endif 


//#if COGNITIVE 
import org.tigris.gef.ocl.ExpansionException;
//#endif 


//#if COGNITIVE 
import org.tigris.gef.ocl.TemplateReader;
//#endif 


//#if COGNITIVE 
class TodoListMemberFilePersister extends MemberFilePersister
  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG =
        Logger.getLogger(ProjectMemberTodoList.class);
//#endif 

private static final String TO_DO_TEE = "/org/argouml/persistence/todo.tee";
@Override
    public void load(Project project, URL url) throws OpenException
    { 
try //1
{ 
load(project, url.openStream());
} 

//#if COGNITIVE 
catch (IOException e) //1
{ 
throw new OpenException(e);
} 

//#endif 


} 

public void load(Project project, InputStream inputStream)
    throws OpenException
    { 
try //1
{ 
TodoParser parser = new TodoParser();
Reader reader = new InputStreamReader(inputStream,
                                                  Argo.getEncoding());
parser.readTodoList(reader);
ProjectMemberTodoList pm = new ProjectMemberTodoList("", project);
project.addMember(pm);
} 

//#if COGNITIVE 
catch (Exception e) //1
{ 
if(e instanceof OpenException)//1
{ 
throw (OpenException) e;
} 

throw new OpenException(e);
} 

//#endif 


} 

public final String getMainTag()
    { 
return "todo";
} 

public void save(ProjectMember member, OutputStream outStream)
    throws SaveException
    { 
OCLExpander expander;
try //1
{ 
expander =
                new OCLExpander(TemplateReader.getInstance()
                                .read(TO_DO_TEE));
} 

//#if COGNITIVE 
catch (ExpansionException e) //1
{ 
throw new SaveException(e);
} 

//#endif 


PrintWriter pw;
try //2
{ 
pw = new PrintWriter(new OutputStreamWriter(outStream, "UTF-8"));
} 

//#if COGNITIVE 
catch (UnsupportedEncodingException e1) //1
{ 
throw new SaveException("UTF-8 encoding not supported on platform",
                                    e1);
} 

//#endif 


try //3
{ 
Designer.disableCritiquing();
expander.expand(pw, member);
} 

//#if COGNITIVE 
catch (ExpansionException e) //1
{ 
throw new SaveException(e);
} 

//#endif 

finally { 
pw.flush();
Designer.enableCritiquing();
} 

} 

 } 

//#endif 


