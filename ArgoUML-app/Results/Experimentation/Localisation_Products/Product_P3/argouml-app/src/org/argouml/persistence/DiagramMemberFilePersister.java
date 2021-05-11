package org.argouml.persistence;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.argouml.application.api.Argo;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectMember;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ProjectMemberDiagram;
import org.tigris.gef.ocl.ExpansionException;
import org.tigris.gef.ocl.OCLExpander;
import org.tigris.gef.ocl.TemplateReader;
class DiagramMemberFilePersister extends MemberFilePersister
  { 
private static final String PGML_TEE = "/org/argouml/persistence/PGML.tee";
private static final Map<String, String> CLASS_TRANSLATIONS =
        new HashMap<String, String>();
@Override
    public void load(Project project, InputStream inputStream)
    throws OpenException
    { 
try//1
{ 
DiagramSettings defaultSettings =
                project.getProjectSettings().getDefaultDiagramSettings();
PGMLStackParser parser = new PGMLStackParser(project.getUUIDRefs(),
                    defaultSettings);
for (Map.Entry<String, String> translation
                    : CLASS_TRANSLATIONS.entrySet()) //1
{ 
parser.addTranslation(
                    translation.getKey(),
                    translation.getValue());
} 
ArgoDiagram d = parser.readArgoDiagram(inputStream, false);
inputStream.close();
project.addMember(d);
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
@Override
    public String getMainTag()
    { 
return "pgml";
} 
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
@Override
    public void save(ProjectMember member, OutputStream outStream)
    throws SaveException
    { 
ProjectMemberDiagram diagramMember = (ProjectMemberDiagram) member;
OCLExpander expander;
try//1
{ 
expander =
                new OCLExpander(
                TemplateReader.getInstance().read(PGML_TEE));
} 
catch (ExpansionException e) //1
{ 
throw new SaveException(e);
} 
OutputStreamWriter outputWriter;
try//2
{ 
outputWriter =
                new OutputStreamWriter(outStream, Argo.getEncoding());
} 
catch (UnsupportedEncodingException e1) //1
{ 
throw new SaveException("Bad encoding", e1);
} 
try//3
{ 
expander.expand(outputWriter, diagramMember.getDiagram());
} 
catch (ExpansionException e) //1
{ 
throw new SaveException(e);
} 
finally { 
try//1
{ 
outputWriter.flush();
} 
catch (IOException e) //1
{ 
throw new SaveException(e);
} 
} 
} 
public void addTranslation(
        final String originalClassName,
        final String newClassName)
    { 
CLASS_TRANSLATIONS.put(originalClassName, newClassName);
} 

 } 
