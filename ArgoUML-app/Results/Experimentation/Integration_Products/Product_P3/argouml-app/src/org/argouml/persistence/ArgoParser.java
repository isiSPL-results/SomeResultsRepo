package org.argouml.persistence;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectSettings;
import org.argouml.notation.NotationSettings;
import org.argouml.uml.diagram.DiagramSettings;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
class ArgoParser extends SAXParserBase
  { 
private Project project;
private ProjectSettings ps;
private DiagramSettings diagramDefaults;
private NotationSettings notationSettings;
private ArgoTokenTable tokens = new ArgoTokenTable();
private List<String> memberList = new ArrayList<String>();
protected void handleActiveDiagram(XMLElement e)
    { 
project.setSavedDiagramName(e.getText().trim());
} 
@Override
    protected boolean isElementOfInterest(String name)
    { 
return tokens.contains(name);
} 
@SuppressWarnings("deprecation")

    public void handleEndElement(XMLElement e) throws SAXException
    { 
switch (tokens.toToken(e.getName(), false)) //1
{ 
case ArgoTokenTable.TOKEN_MEMBER://1

handleMember(e);
break;


case ArgoTokenTable.TOKEN_AUTHORNAME://1

handleAuthorName(e);
break;


case ArgoTokenTable.TOKEN_AUTHOREMAIL://1

handleAuthorEmail(e);
break;


case ArgoTokenTable.TOKEN_VERSION://1

handleVersion(e);
break;


case ArgoTokenTable.TOKEN_DESCRIPTION://1

handleDescription(e);
break;


case ArgoTokenTable.TOKEN_SEARCHPATH://1

handleSearchpath(e);
break;


case ArgoTokenTable.TOKEN_HISTORYFILE://1

handleHistoryfile(e);
break;


case ArgoTokenTable.TOKEN_NOTATIONLANGUAGE://1

handleNotationLanguage(e);
break;


case ArgoTokenTable.TOKEN_SHOWBOLDNAMES://1

handleShowBoldNames(e);
break;


case ArgoTokenTable.TOKEN_USEGUILLEMOTS://1

handleUseGuillemots(e);
break;


case ArgoTokenTable.TOKEN_SHOWVISIBILITY://1

handleShowVisibility(e);
break;


case ArgoTokenTable.TOKEN_SHOWMULTIPLICITY://1

handleShowMultiplicity(e);
break;


case ArgoTokenTable.TOKEN_SHOWINITIALVALUE://1

handleShowInitialValue(e);
break;


case ArgoTokenTable.TOKEN_SHOWPROPERTIES://1

handleShowProperties(e);
break;


case ArgoTokenTable.TOKEN_SHOWTYPES://1

handleShowTypes(e);
break;


case ArgoTokenTable.TOKEN_SHOWSTEREOTYPES://1

handleShowStereotypes(e);
break;


case ArgoTokenTable.TOKEN_SHOWSINGULARMULTIPLICITIES://1

handleShowSingularMultiplicities(e);
break;


case ArgoTokenTable.TOKEN_DEFAULTSHADOWWIDTH://1

handleDefaultShadowWidth(e);
break;


case ArgoTokenTable.TOKEN_FONTNAME://1

handleFontName(e);
break;


case ArgoTokenTable.TOKEN_FONTSIZE://1

handleFontSize(e);
break;


case ArgoTokenTable.TOKEN_GENERATION_OUTPUT_DIR://1

break;


case ArgoTokenTable.TOKEN_SHOWASSOCIATIONNAMES://1

handleShowAssociationNames(e);
break;


case ArgoTokenTable.TOKEN_HIDEBIDIRECTIONALARROWS://1

handleHideBidirectionalArrows(e);
break;


case ArgoTokenTable.TOKEN_ACTIVE_DIAGRAM://1

handleActiveDiagram(e);
break;


default://1

break;


} 
} 
protected void handleAuthorEmail(XMLElement e)
    { 
String authoremail = e.getText().trim();
project.setAuthoremail(authoremail);
} 
public void readProject(Project theProject, InputSource source)
    throws SAXException
    { 
if(source == null)//1
{ 
throw new IllegalArgumentException(
                "An InputSource must be supplied");
} 
preRead(theProject);
try//1
{ 
parse(source);
} 
catch (SAXException e) //1
{ 
throw e;
} 
} 
protected void handleHideBidirectionalArrows(XMLElement e)
    { 
String hideBidirectionalArrows = e.getText().trim();
diagramDefaults.setShowBidirectionalArrows(!
                Boolean.parseBoolean(hideBidirectionalArrows));
} 
protected void handleShowAssociationNames(XMLElement e)
    { 
String showAssociationNames = e.getText().trim();
notationSettings.setShowAssociationNames(
            Boolean.parseBoolean(showAssociationNames));
} 
protected void handleFontName(XMLElement e)
    { 
String dsw = e.getText().trim();
diagramDefaults.setFontName(dsw);
} 
protected void handleNotationLanguage(XMLElement e)
    { 
String language = e.getText().trim();
boolean success = ps.setNotationLanguage(language);
} 
protected void handleShowBoldNames(XMLElement e)
    { 
String ug = e.getText().trim();
diagramDefaults.setShowBoldNames(Boolean.parseBoolean(ug));
} 
protected void handleShowTypes(XMLElement e)
    { 
String showTypes = e.getText().trim();
notationSettings.setShowTypes(Boolean.parseBoolean(showTypes));
} 
private void preRead(Project theProject)
    { 
project = theProject;
ps = project.getProjectSettings();
diagramDefaults = ps.getDefaultDiagramSettings();
notationSettings = ps.getNotationSettings();
} 
protected void handleUseGuillemots(XMLElement e)
    { 
String ug = e.getText().trim();
ps.setUseGuillemots(ug);
} 
protected void handleShowMultiplicity(XMLElement e)
    { 
String showMultiplicity = e.getText().trim();
notationSettings.setShowMultiplicities(
            Boolean.parseBoolean(showMultiplicity));
} 
protected void handleShowInitialValue(XMLElement e)
    { 
String showInitialValue = e.getText().trim();
notationSettings.setShowInitialValues(
            Boolean.parseBoolean(showInitialValue));
} 
protected void handleArgo(@SuppressWarnings("unused") XMLElement e)
    { 
} 
protected void handleMember(XMLElement e) throws SAXException
    { 
if(e == null)//1
{ 
throw new SAXException("XML element is null");
} 
String type = e.getAttribute("type");
memberList.add(type);
} 
public void readProject(Project theProject, Reader reader)
    throws SAXException
    { 
if(reader == null)//1
{ 
throw new IllegalArgumentException(
                "A reader must be supplied");
} 
preRead(theProject);
try//1
{ 
parse(reader);
} 
catch (SAXException e) //1
{ 
throw e;
} 
} 
protected void handleDescription(XMLElement e)
    { 
String description = e.getText().trim();
project.setDescription(description);
} 
public List<String> getMemberList()
    { 
return memberList;
} 
protected void handleShowProperties(XMLElement e)
    { 
String showproperties = e.getText().trim();
notationSettings.setShowProperties(
            Boolean.parseBoolean(showproperties));
} 
public Project getProject()
    { 
return project;
} 
protected void handleDefaultShadowWidth(XMLElement e)
    { 
String dsw = e.getText().trim();
diagramDefaults.setDefaultShadowWidth(Integer.parseInt(dsw));
} 
protected void handleVersion(XMLElement e)
    { 
String version = e.getText().trim();
project.setVersion(version);
} 
public void setProject(Project newProj)
    { 
project = newProj;
ps = project.getProjectSettings();
} 
protected void handleAuthorName(XMLElement e)
    { 
String authorname = e.getText().trim();
project.setAuthorname(authorname);
} 
protected void handleShowStereotypes(XMLElement e)
    { 
String showStereotypes = e.getText().trim();
ps.setShowStereotypes(Boolean.parseBoolean(showStereotypes));
} 
protected void handleSettings(@SuppressWarnings("unused") XMLElement e)
    { 
} 
protected void handleDocumentation(
        @SuppressWarnings("unused") XMLElement e)
    { 
} 
protected void handleShowVisibility(XMLElement e)
    { 
String showVisibility = e.getText().trim();
notationSettings.setShowVisibilities(
            Boolean.parseBoolean(showVisibility));
} 
public ArgoParser()
    { 
super();
} 
protected void handleShowSingularMultiplicities(XMLElement e)
    { 
String showSingularMultiplicities = e.getText().trim();
notationSettings.setShowSingularMultiplicities(
            Boolean.parseBoolean(showSingularMultiplicities));
} 
protected void handleFontSize(XMLElement e)
    { 
String dsw = e.getText().trim();
try//1
{ 
diagramDefaults.setFontSize(Integer.parseInt(dsw));
} 
catch (NumberFormatException e1) //1
{ 
} 
} 
protected void handleHistoryfile(XMLElement e)
    { 
if(e.getAttribute("name") == null)//1
{ 
return;
} 
String historyfile = e.getAttribute("name").trim();
project.setHistoryFile(historyfile);
} 
protected void handleSearchpath(XMLElement e)
    { 
String searchpath = e.getAttribute("href").trim();
project.addSearchPath(searchpath);
} 
public void handleStartElement(XMLElement e) throws SAXException
    { 
switch (tokens.toToken(e.getName(), true)) //1
{ 
case ArgoTokenTable.TOKEN_ARGO://1

handleArgo(e);
break;


case ArgoTokenTable.TOKEN_DOCUMENTATION://1

handleDocumentation(e);
break;


case ArgoTokenTable.TOKEN_SETTINGS://1

handleSettings(e);
break;


default://1

break;


} 
} 

 } 
