
//#if -416763683 
// Compilation Unit of /ArgoParser.java 
 

//#if 525873174 
package org.argouml.persistence;
//#endif 


//#if 265417358 
import java.io.Reader;
//#endif 


//#if 947942706 
import java.util.ArrayList;
//#endif 


//#if 1507903983 
import java.util.List;
//#endif 


//#if -830614360 
import org.argouml.kernel.Project;
//#endif 


//#if -1596719163 
import org.argouml.kernel.ProjectSettings;
//#endif 


//#if 1781497525 
import org.argouml.notation.NotationSettings;
//#endif 


//#if 809215237 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1000112553 
import org.xml.sax.InputSource;
//#endif 


//#if 559873635 
import org.xml.sax.SAXException;
//#endif 


//#if -586265681 
import org.apache.log4j.Logger;
//#endif 


//#if -1381537337 
class ArgoParser extends 
//#if -2019557740 
SAXParserBase
//#endif 

  { 

//#if 1215405054 
private Project project;
//#endif 


//#if -250013127 
private ProjectSettings ps;
//#endif 


//#if -1008983473 
private DiagramSettings diagramDefaults;
//#endif 


//#if 760882644 
private NotationSettings notationSettings;
//#endif 


//#if -2077317564 
private ArgoTokenTable tokens = new ArgoTokenTable();
//#endif 


//#if -391102759 
private List<String> memberList = new ArrayList<String>();
//#endif 


//#if 1708465536 
private static final Logger LOG = Logger.getLogger(ArgoParser.class);
//#endif 


//#if -417899864 
protected void handleActiveDiagram(XMLElement e)
    { 

//#if 369406766 
project.setSavedDiagramName(e.getText().trim());
//#endif 

} 

//#endif 


//#if 496773240 
@Override
    protected boolean isElementOfInterest(String name)
    { 

//#if -422497554 
return tokens.contains(name);
//#endif 

} 

//#endif 


//#if 1480909559 

//#if -255298457 
@SuppressWarnings("deprecation")
//#endif 


    public void handleEndElement(XMLElement e) throws SAXException
    { 

//#if -1869667301 
if(DBG)//1
{ 

//#if -643606226 
LOG.debug("NOTE: ArgoParser handleEndTag:" + e.getName() + ".");
//#endif 

} 

//#endif 


//#if 621048789 
switch (tokens.toToken(e.getName(), false)) //1
{ 
case ArgoTokenTable.TOKEN_MEMBER://1


//#if -461027522 
handleMember(e);
//#endif 


//#if 1505713545 
break;

//#endif 


case ArgoTokenTable.TOKEN_AUTHORNAME://1


//#if -922155924 
handleAuthorName(e);
//#endif 


//#if 1911048859 
break;

//#endif 


case ArgoTokenTable.TOKEN_AUTHOREMAIL://1


//#if -5182169 
handleAuthorEmail(e);
//#endif 


//#if -1992784371 
break;

//#endif 


case ArgoTokenTable.TOKEN_VERSION://1


//#if 865534817 
handleVersion(e);
//#endif 


//#if 1210189242 
break;

//#endif 


case ArgoTokenTable.TOKEN_DESCRIPTION://1


//#if 936457292 
handleDescription(e);
//#endif 


//#if 228014035 
break;

//#endif 


case ArgoTokenTable.TOKEN_SEARCHPATH://1


//#if 1452566661 
handleSearchpath(e);
//#endif 


//#if 1500175005 
break;

//#endif 


case ArgoTokenTable.TOKEN_HISTORYFILE://1


//#if -565766612 
handleHistoryfile(e);
//#endif 


//#if 2045311367 
break;

//#endif 


case ArgoTokenTable.TOKEN_NOTATIONLANGUAGE://1


//#if -1702339854 
handleNotationLanguage(e);
//#endif 


//#if -1232512355 
break;

//#endif 


case ArgoTokenTable.TOKEN_SHOWBOLDNAMES://1


//#if 1603009793 
handleShowBoldNames(e);
//#endif 


//#if -1005943864 
break;

//#endif 


case ArgoTokenTable.TOKEN_USEGUILLEMOTS://1


//#if -950501611 
handleUseGuillemots(e);
//#endif 


//#if -794816320 
break;

//#endif 


case ArgoTokenTable.TOKEN_SHOWVISIBILITY://1


//#if -1570983859 
handleShowVisibility(e);
//#endif 


//#if 2068824387 
break;

//#endif 


case ArgoTokenTable.TOKEN_SHOWMULTIPLICITY://1


//#if -119092667 
handleShowMultiplicity(e);
//#endif 


//#if 1098739150 
break;

//#endif 


case ArgoTokenTable.TOKEN_SHOWINITIALVALUE://1


//#if 1663561188 
handleShowInitialValue(e);
//#endif 


//#if 1890147295 
break;

//#endif 


case ArgoTokenTable.TOKEN_SHOWPROPERTIES://1


//#if 1804871523 
handleShowProperties(e);
//#endif 


//#if -1471747592 
break;

//#endif 


case ArgoTokenTable.TOKEN_SHOWTYPES://1


//#if 392553924 
handleShowTypes(e);
//#endif 


//#if -1190424805 
break;

//#endif 


case ArgoTokenTable.TOKEN_SHOWSTEREOTYPES://1


//#if 2088481012 
handleShowStereotypes(e);
//#endif 


//#if 1310768883 
break;

//#endif 


case ArgoTokenTable.TOKEN_SHOWSINGULARMULTIPLICITIES://1


//#if 780980326 
handleShowSingularMultiplicities(e);
//#endif 


//#if -1363165350 
break;

//#endif 


case ArgoTokenTable.TOKEN_DEFAULTSHADOWWIDTH://1


//#if -1648087365 
handleDefaultShadowWidth(e);
//#endif 


//#if -1007438181 
break;

//#endif 


case ArgoTokenTable.TOKEN_FONTNAME://1


//#if 324408992 
handleFontName(e);
//#endif 


//#if 400738379 
break;

//#endif 


case ArgoTokenTable.TOKEN_FONTSIZE://1


//#if 1553882766 
handleFontSize(e);
//#endif 


//#if -470627901 
break;

//#endif 


case ArgoTokenTable.TOKEN_GENERATION_OUTPUT_DIR://1


//#if 138691805 
break;

//#endif 


case ArgoTokenTable.TOKEN_SHOWASSOCIATIONNAMES://1


//#if 800758980 
handleShowAssociationNames(e);
//#endif 


//#if 1966972677 
break;

//#endif 


case ArgoTokenTable.TOKEN_HIDEBIDIRECTIONALARROWS://1


//#if 986388713 
handleHideBidirectionalArrows(e);
//#endif 


//#if -1530436859 
break;

//#endif 


case ArgoTokenTable.TOKEN_ACTIVE_DIAGRAM://1


//#if -2065963152 
handleActiveDiagram(e);
//#endif 


//#if 398762624 
break;

//#endif 


default://1


//#if 837710935 
if(DBG)//1
{ 

//#if -793186242 
LOG.warn("WARNING: unknown end tag:" + e.getName());
//#endif 

} 

//#endif 


//#if -1856883603 
break;

//#endif 


} 

//#endif 

} 

//#endif 


//#if 177603652 
protected void handleAuthorEmail(XMLElement e)
    { 

//#if 645636225 
String authoremail = e.getText().trim();
//#endif 


//#if -1982008282 
project.setAuthoremail(authoremail);
//#endif 

} 

//#endif 


//#if 61927118 
public void readProject(Project theProject, InputSource source)
    throws SAXException
    { 

//#if 724521437 
if(source == null)//1
{ 

//#if 502589468 
throw new IllegalArgumentException(
                "An InputSource must be supplied");
//#endif 

} 

//#endif 


//#if 640295905 
preRead(theProject);
//#endif 


//#if 320324110 
try //1
{ 

//#if -1755563070 
parse(source);
//#endif 

} 

//#if 1893811983 
catch (SAXException e) //1
{ 

//#if -1782888140 
logError(source.toString(), e);
//#endif 


//#if -313441521 
throw e;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -385799862 
protected void handleHideBidirectionalArrows(XMLElement e)
    { 

//#if -28434381 
String hideBidirectionalArrows = e.getText().trim();
//#endif 


//#if 2074695710 
diagramDefaults.setShowBidirectionalArrows(!
                Boolean.parseBoolean(hideBidirectionalArrows));
//#endif 

} 

//#endif 


//#if 1907938761 
protected void handleShowAssociationNames(XMLElement e)
    { 

//#if -2140216117 
String showAssociationNames = e.getText().trim();
//#endif 


//#if -1692853625 
notationSettings.setShowAssociationNames(
            Boolean.parseBoolean(showAssociationNames));
//#endif 

} 

//#endif 


//#if 1796485235 
protected void handleFontName(XMLElement e)
    { 

//#if -579899380 
String dsw = e.getText().trim();
//#endif 


//#if 1992932146 
diagramDefaults.setFontName(dsw);
//#endif 

} 

//#endif 


//#if -1330454925 
protected void handleNotationLanguage(XMLElement e)
    { 

//#if 101804961 
String language = e.getText().trim();
//#endif 


//#if 1347653711 
boolean success = ps.setNotationLanguage(language);
//#endif 

} 

//#endif 


//#if -407068433 
protected void handleShowBoldNames(XMLElement e)
    { 

//#if -171084018 
String ug = e.getText().trim();
//#endif 


//#if -1238958508 
diagramDefaults.setShowBoldNames(Boolean.parseBoolean(ug));
//#endif 

} 

//#endif 


//#if 1180500089 
protected void handleShowTypes(XMLElement e)
    { 

//#if 1251146209 
String showTypes = e.getText().trim();
//#endif 


//#if -769040619 
notationSettings.setShowTypes(Boolean.parseBoolean(showTypes));
//#endif 

} 

//#endif 


//#if 1910813256 
private void preRead(Project theProject)
    { 

//#if 59373977 
LOG.info("=======================================");
//#endif 


//#if -564189294 
LOG.info("== READING PROJECT " + theProject);
//#endif 


//#if 1815253887 
project = theProject;
//#endif 


//#if -678848619 
ps = project.getProjectSettings();
//#endif 


//#if 923317714 
diagramDefaults = ps.getDefaultDiagramSettings();
//#endif 


//#if -1616277502 
notationSettings = ps.getNotationSettings();
//#endif 

} 

//#endif 


//#if 1050177123 
protected void handleUseGuillemots(XMLElement e)
    { 

//#if -1072158697 
String ug = e.getText().trim();
//#endif 


//#if -1437609091 
ps.setUseGuillemots(ug);
//#endif 

} 

//#endif 


//#if 1822119441 
protected void handleShowMultiplicity(XMLElement e)
    { 

//#if 1474421186 
String showMultiplicity = e.getText().trim();
//#endif 


//#if -1070851558 
notationSettings.setShowMultiplicities(
            Boolean.parseBoolean(showMultiplicity));
//#endif 

} 

//#endif 


//#if 668245443 
protected void handleShowInitialValue(XMLElement e)
    { 

//#if 1201277463 
String showInitialValue = e.getText().trim();
//#endif 


//#if -1990935312 
notationSettings.setShowInitialValues(
            Boolean.parseBoolean(showInitialValue));
//#endif 

} 

//#endif 


//#if -1548659551 
protected void handleArgo(@SuppressWarnings("unused") XMLElement e)
    { 
} 

//#endif 


//#if 1384074245 
protected void handleMember(XMLElement e) throws SAXException
    { 

//#if -1720203868 
if(e == null)//1
{ 

//#if -830741563 
throw new SAXException("XML element is null");
//#endif 

} 

//#endif 


//#if -53840742 
String type = e.getAttribute("type");
//#endif 


//#if 23061870 
memberList.add(type);
//#endif 

} 

//#endif 


//#if 194771989 
private void logError(String projectName, SAXException e)
    { 

//#if -346207901 
LOG.error("Exception reading project================", e);
//#endif 


//#if -1018945946 
LOG.error(projectName);
//#endif 

} 

//#endif 


//#if -1735837662 
public void readProject(Project theProject, Reader reader)
    throws SAXException
    { 

//#if 1963422008 
if(reader == null)//1
{ 

//#if 406872805 
throw new IllegalArgumentException(
                "A reader must be supplied");
//#endif 

} 

//#endif 


//#if 1441552782 
preRead(theProject);
//#endif 


//#if -1581270405 
try //1
{ 

//#if 2131451719 
parse(reader);
//#endif 

} 

//#if -416805469 
catch (SAXException e) //1
{ 

//#if -1751044317 
logError(reader.toString(), e);
//#endif 


//#if -180779688 
throw e;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 914077433 
protected void handleDescription(XMLElement e)
    { 

//#if 41842851 
String description = e.getText().trim();
//#endif 


//#if -2117385019 
project.setDescription(description);
//#endif 

} 

//#endif 


//#if 299521361 
public List<String> getMemberList()
    { 

//#if 1322585482 
return memberList;
//#endif 

} 

//#endif 


//#if -1106497891 
protected void handleShowProperties(XMLElement e)
    { 

//#if -549404288 
String showproperties = e.getText().trim();
//#endif 


//#if -424133050 
notationSettings.setShowProperties(
            Boolean.parseBoolean(showproperties));
//#endif 

} 

//#endif 


//#if -986120146 
public Project getProject()
    { 

//#if -10988716 
return project;
//#endif 

} 

//#endif 


//#if -667710648 
protected void handleDefaultShadowWidth(XMLElement e)
    { 

//#if 1841955362 
String dsw = e.getText().trim();
//#endif 


//#if -1204186168 
diagramDefaults.setDefaultShadowWidth(Integer.parseInt(dsw));
//#endif 

} 

//#endif 


//#if 478778781 
protected void handleVersion(XMLElement e)
    { 

//#if 913947197 
String version = e.getText().trim();
//#endif 


//#if -237661313 
project.setVersion(version);
//#endif 

} 

//#endif 


//#if -1531175369 
public void setProject(Project newProj)
    { 

//#if -1731489936 
project = newProj;
//#endif 


//#if 1490342003 
ps = project.getProjectSettings();
//#endif 

} 

//#endif 


//#if 529617847 
protected void handleAuthorName(XMLElement e)
    { 

//#if 366755548 
String authorname = e.getText().trim();
//#endif 


//#if -648200806 
project.setAuthorname(authorname);
//#endif 

} 

//#endif 


//#if 2120107441 
protected void handleShowStereotypes(XMLElement e)
    { 

//#if 1321063961 
String showStereotypes = e.getText().trim();
//#endif 


//#if -655255289 
ps.setShowStereotypes(Boolean.parseBoolean(showStereotypes));
//#endif 

} 

//#endif 


//#if 1369734123 
protected void handleSettings(@SuppressWarnings("unused") XMLElement e)
    { 
} 

//#endif 


//#if -603369542 
protected void handleDocumentation(
        @SuppressWarnings("unused") XMLElement e)
    { 
} 

//#endif 


//#if 1427643166 
protected void handleShowVisibility(XMLElement e)
    { 

//#if -2101769411 
String showVisibility = e.getText().trim();
//#endif 


//#if -1777595252 
notationSettings.setShowVisibilities(
            Boolean.parseBoolean(showVisibility));
//#endif 

} 

//#endif 


//#if 1301306120 
public ArgoParser()
    { 

//#if -1740165836 
super();
//#endif 

} 

//#endif 


//#if 185546908 
protected void handleShowSingularMultiplicities(XMLElement e)
    { 

//#if -585804073 
String showSingularMultiplicities = e.getText().trim();
//#endif 


//#if 2057948878 
notationSettings.setShowSingularMultiplicities(
            Boolean.parseBoolean(showSingularMultiplicities));
//#endif 

} 

//#endif 


//#if -1692869955 
protected void handleFontSize(XMLElement e)
    { 

//#if 327217736 
String dsw = e.getText().trim();
//#endif 


//#if 623332941 
try //1
{ 

//#if -940613506 
diagramDefaults.setFontSize(Integer.parseInt(dsw));
//#endif 

} 

//#if 788280699 
catch (NumberFormatException e1) //1
{ 

//#if -1045080763 
LOG.error("NumberFormatException while parsing Font Size", e1);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 721488741 
protected void handleHistoryfile(XMLElement e)
    { 

//#if 2026392844 
if(e.getAttribute("name") == null)//1
{ 

//#if -1743004043 
return;
//#endif 

} 

//#endif 


//#if -520011636 
String historyfile = e.getAttribute("name").trim();
//#endif 


//#if -520658426 
project.setHistoryFile(historyfile);
//#endif 

} 

//#endif 


//#if -1960579584 
protected void handleSearchpath(XMLElement e)
    { 

//#if -233578106 
String searchpath = e.getAttribute("href").trim();
//#endif 


//#if 1034075756 
project.addSearchPath(searchpath);
//#endif 

} 

//#endif 


//#if 1830979582 
public void handleStartElement(XMLElement e) throws SAXException
    { 

//#if -1108144762 
if(DBG)//1
{ 

//#if 1793098814 
LOG.debug("NOTE: ArgoParser handleStartTag:" + e.getName());
//#endif 

} 

//#endif 


//#if 1444434199 
switch (tokens.toToken(e.getName(), true)) //1
{ 
case ArgoTokenTable.TOKEN_ARGO://1


//#if -555942632 
handleArgo(e);
//#endif 


//#if 1038218852 
break;

//#endif 


case ArgoTokenTable.TOKEN_DOCUMENTATION://1


//#if -1449491343 
handleDocumentation(e);
//#endif 


//#if 1964037196 
break;

//#endif 


case ArgoTokenTable.TOKEN_SETTINGS://1


//#if -1315076800 
handleSettings(e);
//#endif 


//#if 806153538 
break;

//#endif 


default://1


//#if 1299511576 
if(DBG)//1
{ 

//#if -950187124 
LOG.warn("WARNING: unknown tag:" + e.getName());
//#endif 

} 

//#endif 


//#if 2056470958 
break;

//#endif 


} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

