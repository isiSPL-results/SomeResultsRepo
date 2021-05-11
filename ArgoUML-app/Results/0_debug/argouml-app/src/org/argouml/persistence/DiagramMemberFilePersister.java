
//#if -1161326256 
// Compilation Unit of /DiagramMemberFilePersister.java 
 

//#if -550916101 
package org.argouml.persistence;
//#endif 


//#if 1327400823 
import java.io.IOException;
//#endif 


//#if -690889322 
import java.io.InputStream;
//#endif 


//#if -1992607467 
import java.io.OutputStream;
//#endif 


//#if -1664864414 
import java.io.OutputStreamWriter;
//#endif 


//#if 1561725231 
import java.io.UnsupportedEncodingException;
//#endif 


//#if -792613632 
import java.net.URL;
//#endif 


//#if -1974623114 
import java.util.HashMap;
//#endif 


//#if -1924857144 
import java.util.Map;
//#endif 


//#if 1622697802 
import org.argouml.application.api.Argo;
//#endif 


//#if -537989299 
import org.argouml.kernel.Project;
//#endif 


//#if -88655277 
import org.argouml.kernel.ProjectMember;
//#endif 


//#if -1267333924 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -656949632 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 433870144 
import org.argouml.uml.diagram.ProjectMemberDiagram;
//#endif 


//#if 202914718 
import org.tigris.gef.ocl.ExpansionException;
//#endif 


//#if -2047240759 
import org.tigris.gef.ocl.OCLExpander;
//#endif 


//#if -267502799 
import org.tigris.gef.ocl.TemplateReader;
//#endif 


//#if 348830506 
import org.apache.log4j.Logger;
//#endif 


//#if -1608554388 
class DiagramMemberFilePersister extends 
//#if 785212594 
MemberFilePersister
//#endif 

  { 

//#if -2094116556 
private static final String PGML_TEE = "/org/argouml/persistence/PGML.tee";
//#endif 


//#if -599705218 
private static final Map<String, String> CLASS_TRANSLATIONS =
        new HashMap<String, String>();
//#endif 


//#if -84012403 
private static final Logger LOG =
        Logger.getLogger(DiagramMemberFilePersister.class);
//#endif 


//#if -921451799 
@Override
    public void load(Project project, InputStream inputStream)
    throws OpenException
    { 

//#if 1158386896 
try //1
{ 

//#if 1778793118 
DiagramSettings defaultSettings =
                project.getProjectSettings().getDefaultDiagramSettings();
//#endif 


//#if 589580265 
PGMLStackParser parser = new PGMLStackParser(project.getUUIDRefs(),
                    defaultSettings);
//#endif 


//#if 1711579335 
LOG.info("Adding translations registered by modules");
//#endif 


//#if -773490724 
for (Map.Entry<String, String> translation
                    : CLASS_TRANSLATIONS.entrySet()) //1
{ 

//#if 932274226 
parser.addTranslation(
                    translation.getKey(),
                    translation.getValue());
//#endif 

} 

//#endif 


//#if 2094465063 
ArgoDiagram d = parser.readArgoDiagram(inputStream, false);
//#endif 


//#if 542916242 
inputStream.close();
//#endif 


//#if -2120002232 
project.addMember(d);
//#endif 

} 

//#if -357326606 
catch (Exception e) //1
{ 

//#if 555204112 
if(e instanceof OpenException)//1
{ 

//#if -269168744 
throw (OpenException) e;
//#endif 

} 

//#endif 


//#if 748782531 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1608389593 
@Override
    public String getMainTag()
    { 

//#if -2053660618 
return "pgml";
//#endif 

} 

//#endif 


//#if 369891017 
@Override
    public void load(Project project, URL url) throws OpenException
    { 

//#if -1749468859 
try //1
{ 

//#if 1965184203 
load(project, url.openStream());
//#endif 

} 

//#if -1747190385 
catch (IOException e) //1
{ 

//#if 91773604 
throw new OpenException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -312481585 
@Override
    public void save(ProjectMember member, OutputStream outStream)
    throws SaveException
    { 

//#if -1702980377 
ProjectMemberDiagram diagramMember = (ProjectMemberDiagram) member;
//#endif 


//#if 989222654 
OCLExpander expander;
//#endif 


//#if 810945567 
try //1
{ 

//#if 2090073223 
expander =
                new OCLExpander(
                TemplateReader.getInstance().read(PGML_TEE));
//#endif 

} 

//#if 945945181 
catch (ExpansionException e) //1
{ 

//#if 81390689 
throw new SaveException(e);
//#endif 

} 

//#endif 


//#endif 


//#if -797843126 
OutputStreamWriter outputWriter;
//#endif 


//#if -311577038 
try //2
{ 

//#if 1764130993 
outputWriter =
                new OutputStreamWriter(outStream, Argo.getEncoding());
//#endif 

} 

//#if 1268772686 
catch (UnsupportedEncodingException e1) //1
{ 

//#if -961247070 
throw new SaveException("Bad encoding", e1);
//#endif 

} 

//#endif 


//#endif 


//#if -311547246 
try //3
{ 

//#if 697050824 
expander.expand(outputWriter, diagramMember.getDiagram());
//#endif 

} 

//#if -1200810162 
catch (ExpansionException e) //1
{ 

//#if 2103258069 
throw new SaveException(e);
//#endif 

} 

//#endif 

finally { 

//#if 410899867 
try //1
{ 

//#if 13730623 
outputWriter.flush();
//#endif 

} 

//#if -1949084987 
catch (IOException e) //1
{ 

//#if -5037238 
throw new SaveException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -15080770 
public void addTranslation(
        final String originalClassName,
        final String newClassName)
    { 

//#if -1210962977 
CLASS_TRANSLATIONS.put(originalClassName, newClassName);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

