
//#if 1626589434 
// Compilation Unit of /ProjectSettings.java 
 

//#if -617004221 
package org.argouml.kernel;
//#endif 


//#if 150878493 
import java.awt.Font;
//#endif 


//#if -1898069680 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -958059246 
import org.argouml.application.events.ArgoDiagramAppearanceEvent;
//#endif 


//#if 1337685599 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -1363128106 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if -945138039 
import org.argouml.application.events.ArgoNotationEvent;
//#endif 


//#if -1189812345 
import org.argouml.configuration.Configuration;
//#endif 


//#if 666101520 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if -818032809 
import org.argouml.notation.Notation;
//#endif 


//#if 1405208588 
import org.argouml.notation.NotationName;
//#endif 


//#if 555920606 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if -1581130892 
import org.argouml.notation.NotationSettings;
//#endif 


//#if 1216979683 
import org.argouml.uml.diagram.DiagramAppearance;
//#endif 


//#if -861286908 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 256311161 
import org.tigris.gef.undo.Memento;
//#endif 


//#if 1769815049 
import org.tigris.gef.undo.UndoManager;
//#endif 


//#if -869380107 
public class ProjectSettings  { 

//#if 52294472 
private DiagramSettings diaDefault;
//#endif 


//#if 892325385 
private NotationSettings npSettings;
//#endif 


//#if 377715254 
private boolean showExplorerStereotypes;
//#endif 


//#if 1674653769 
private String headerComment =
        "Your copyright and other header comments";
//#endif 


//#if -169427768 
@Deprecated
    public String getHideBidirectionalArrows()
    { 

//#if -1743210012 
return Boolean.toString(getHideBidirectionalArrowsValue());
//#endif 

} 

//#endif 


//#if 1770199643 
@Deprecated
    public boolean getShowBoldNamesValue()
    { 

//#if -1122030713 
return diaDefault.isShowBoldNames();
//#endif 

} 

//#endif 


//#if -1770390878 
@Deprecated
    public int getDefaultStereotypeViewValue()
    { 

//#if 1125916177 
return diaDefault.getDefaultStereotypeViewInt();
//#endif 

} 

//#endif 


//#if -1767291110 
public DiagramSettings getDefaultDiagramSettings()
    { 

//#if 1520158429 
return diaDefault;
//#endif 

} 

//#endif 


//#if -1034686266 
@Deprecated
    public void setShowVisibility(final boolean showem)
    { 

//#if 1193004117 
if(npSettings.isShowVisibilities() == showem)//1
{ 

//#if -724005908 
return;
//#endif 

} 

//#endif 


//#if -20355496 
Memento memento = new Memento() {
            private final ConfigurationKey key = Notation.KEY_SHOW_VISIBILITY;

            public void redo() {
                npSettings.setShowVisibilities(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                npSettings.setShowVisibilities(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
//#endif 


//#if 1455020510 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if 122959795 
public NotationName getNotationName()
    { 

//#if -1704998213 
return Notation.findNotation(getNotationLanguage());
//#endif 

} 

//#endif 


//#if 1210647801 
@Deprecated
    public String getShowTypes()
    { 

//#if -1225515812 
return Boolean.toString(getShowTypesValue());
//#endif 

} 

//#endif 


//#if -1757732155 
@Deprecated
    public int getDefaultShadowWidthValue()
    { 

//#if 130176231 
return diaDefault.getDefaultShadowWidth();
//#endif 

} 

//#endif 


//#if 1715461224 
public boolean setNotationLanguage(final String newLanguage)
    { 

//#if -1481125313 
if(getNotationLanguage().equals(newLanguage))//1
{ 

//#if 1902069674 
return true;
//#endif 

} 

//#endif 


//#if -445920761 
if(Notation.findNotation(newLanguage) == null)//1
{ 

//#if 1742410687 
return false;
//#endif 

} 

//#endif 


//#if 1957182026 
final String oldLanguage = getNotationLanguage();
//#endif 


//#if -1460884356 
Memento memento = new Memento() {
            private final ConfigurationKey key = Notation.KEY_DEFAULT_NOTATION;

            public void redo() {
                npSettings.setNotationLanguage(newLanguage);
                NotationProviderFactory2.setCurrentLanguage(newLanguage);
                fireNotationEvent(key, oldLanguage, newLanguage);
            }

            public void undo() {
                npSettings.setNotationLanguage(oldLanguage);
                NotationProviderFactory2.setCurrentLanguage(oldLanguage);
                fireNotationEvent(key, newLanguage, oldLanguage);
            }
        };
//#endif 


//#if 1344945873 
doUndoable(memento);
//#endif 


//#if 1173398392 
return true;
//#endif 

} 

//#endif 


//#if 316741381 
private void fireDiagramAppearanceEvent(ConfigurationKey key, int oldValue,
                                            int newValue)
    { 

//#if 2065701513 
fireDiagramAppearanceEvent(key, Integer.toString(oldValue), Integer
                                   .toString(newValue));
//#endif 

} 

//#endif 


//#if -1252590329 
@Deprecated
    public void setShowBoldNames(String showbold)
    { 

//#if -1235345464 
setShowBoldNames(Boolean.valueOf(showbold).booleanValue());
//#endif 

} 

//#endif 


//#if 2057724228 
public String getShowStereotypes()
    { 

//#if 1249674744 
return Boolean.toString(getShowStereotypesValue());
//#endif 

} 

//#endif 


//#if 1998826747 
@Deprecated
    public void setShowAssociationNames(final boolean showem)
    { 

//#if 1941376485 
if(npSettings.isShowAssociationNames() == showem)//1
{ 

//#if -608229056 
return;
//#endif 

} 

//#endif 


//#if -1548259637 
Memento memento = new Memento() {
            private final ConfigurationKey key =
                Notation.KEY_SHOW_ASSOCIATION_NAMES;

            public void redo() {
                npSettings.setShowAssociationNames(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                npSettings.setShowAssociationNames(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
//#endif 


//#if -431525673 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if -267437999 
@Deprecated
    public String getRightGuillemot()
    { 

//#if 1960224527 
return getUseGuillemotsValue() ? "\u00bb" : ">>";
//#endif 

} 

//#endif 


//#if -1554193559 
@Deprecated
    public String getShowAssociationNames()
    { 

//#if 734142428 
return Boolean.toString(getShowAssociationNamesValue());
//#endif 

} 

//#endif 


//#if -1809199455 
@Deprecated
    public void setFontName(String newFontName)
    { 

//#if -751397908 
String old = diaDefault.getFontName();
//#endif 


//#if 1504356823 
diaDefault.setFontName(newFontName);
//#endif 


//#if 1882612752 
fireDiagramAppearanceEvent(DiagramAppearance.KEY_FONT_NAME, old,
                                   newFontName);
//#endif 

} 

//#endif 


//#if -1625424942 
public boolean getUseGuillemotsValue()
    { 

//#if 1177563481 
return npSettings.isUseGuillemets();
//#endif 

} 

//#endif 


//#if -1633031878 
@Deprecated
    public void setShowTypes(String showem)
    { 

//#if -561684558 
setShowTypes(Boolean.valueOf(showem).booleanValue());
//#endif 

} 

//#endif 


//#if -2123998422 
@Deprecated
    public void setDefaultShadowWidth(String width)
    { 

//#if -884280602 
setDefaultShadowWidth(Integer.parseInt(width));
//#endif 

} 

//#endif 


//#if -1074319994 
public String getShowBoldNames()
    { 

//#if 1537115247 
return Boolean.toString(getShowBoldNamesValue());
//#endif 

} 

//#endif 


//#if 532100350 
@Deprecated
    public String getLeftGuillemot()
    { 

//#if 212780105 
return getUseGuillemotsValue() ? "\u00ab" : "<<";
//#endif 

} 

//#endif 


//#if 1575600231 
@Deprecated
    public void setShowProperties(final boolean showem)
    { 

//#if -967848756 
if(npSettings.isShowProperties() == showem)//1
{ 

//#if 389102528 
return;
//#endif 

} 

//#endif 


//#if -850854003 
Memento memento = new Memento() {
            private final ConfigurationKey key =
                Notation.KEY_SHOW_PROPERTIES;

            public void redo() {
                npSettings.setShowProperties(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                npSettings.setShowProperties(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
//#endif 


//#if 963520466 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if 1453561343 
@Deprecated
    public boolean getShowAssociationNamesValue()
    { 

//#if 1091436038 
return npSettings.isShowAssociationNames();
//#endif 

} 

//#endif 


//#if -593270733 
@Deprecated
    public void setShowMultiplicity(final boolean showem)
    { 

//#if 1700697571 
if(npSettings.isShowMultiplicities() == showem)//1
{ 

//#if -1419484521 
return;
//#endif 

} 

//#endif 


//#if -826311674 
Memento memento = new Memento() {
            private final ConfigurationKey key = Notation.KEY_SHOW_MULTIPLICITY;

            public void redo() {
                npSettings.setShowMultiplicities(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                npSettings.setShowMultiplicities(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
//#endif 


//#if -356310977 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if 2120962329 
@Deprecated
    public int getFontSize()
    { 

//#if -1934018695 
return diaDefault.getFontSize();
//#endif 

} 

//#endif 


//#if -1872972059 
@Deprecated
    public boolean getShowTypesValue()
    { 

//#if 1388252862 
return npSettings.isShowTypes();
//#endif 

} 

//#endif 


//#if 937562230 
@Deprecated
    public Font getFontPlain()
    { 

//#if 1871850276 
return diaDefault.getFontPlain();
//#endif 

} 

//#endif 


//#if -2715104 
public boolean getShowStereotypesValue()
    { 

//#if 1265265565 
return showExplorerStereotypes;
//#endif 

} 

//#endif 


//#if 1521852372 
private void fireNotationEvent(
        ConfigurationKey key, int oldValue, int newValue)
    { 

//#if 1540511380 
fireNotationEvent(key, Integer.toString(oldValue),
                          Integer.toString(newValue));
//#endif 

} 

//#endif 


//#if 1810485108 
@Deprecated
    public void setDefaultShadowWidth(final int newWidth)
    { 

//#if -181256556 
final int oldValue = diaDefault.getDefaultShadowWidth();
//#endif 


//#if -289648675 
if(oldValue == newWidth)//1
{ 

//#if 314493474 
return;
//#endif 

} 

//#endif 


//#if -354751296 
Memento memento = new Memento() {
            private final ConfigurationKey key =
                Notation.KEY_DEFAULT_SHADOW_WIDTH;

            public void redo() {
                diaDefault.setDefaultShadowWidth(newWidth);
                fireNotationEvent(key, oldValue, newWidth);
            }

            public void undo() {
                diaDefault.setDefaultShadowWidth(oldValue);
                fireNotationEvent(key, newWidth, oldValue);
            }
        };
//#endif 


//#if 564177714 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if 290465129 
@Deprecated
    public void setShowSingularMultiplicities(String showem)
    { 

//#if -2061619285 
setShowSingularMultiplicities(Boolean.valueOf(showem).booleanValue());
//#endif 

} 

//#endif 


//#if 5560467 
public void setUseGuillemots(String showem)
    { 

//#if 747224490 
setUseGuillemots(Boolean.valueOf(showem).booleanValue());
//#endif 

} 

//#endif 


//#if 661448530 
@Deprecated
    public boolean getShowSingularMultiplicitiesValue()
    { 

//#if 461020132 
return npSettings.isShowSingularMultiplicities();
//#endif 

} 

//#endif 


//#if -1670162029 
@Deprecated
    public boolean getShowPropertiesValue()
    { 

//#if 1544973417 
return npSettings.isShowProperties();
//#endif 

} 

//#endif 


//#if 1871765322 
@Deprecated
    public String getDefaultShadowWidth()
    { 

//#if 913118210 
return Integer.valueOf(getDefaultShadowWidthValue()).toString();
//#endif 

} 

//#endif 


//#if -2121257190 
private void init(boolean value, ConfigurationKey key)
    { 

//#if -1950978603 
fireNotationEvent(key, value, value);
//#endif 

} 

//#endif 


//#if -29369884 
@Deprecated
    public void setHideBidirectionalArrows(String hideem)
    { 

//#if -650655524 
setHideBidirectionalArrows(Boolean.valueOf(hideem).booleanValue());
//#endif 

} 

//#endif 


//#if -462322424 
@Deprecated
    public void setShowProperties(String showem)
    { 

//#if 345574238 
setShowProperties(Boolean.valueOf(showem).booleanValue());
//#endif 

} 

//#endif 


//#if 786639015 
@Deprecated
    public void setShowVisibility(String showem)
    { 

//#if 2113714734 
setShowVisibility(Boolean.valueOf(showem).booleanValue());
//#endif 

} 

//#endif 


//#if 320670006 
@Deprecated
    public boolean getHideBidirectionalArrowsValue()
    { 

//#if -514577828 
return !diaDefault.isShowBidirectionalArrows();
//#endif 

} 

//#endif 


//#if -1989257473 
private void fireDiagramAppearanceEvent(ConfigurationKey key,
                                            String oldValue, String newValue)
    { 

//#if 1943448077 
ArgoEventPump.fireEvent(new ArgoDiagramAppearanceEvent(
                                    ArgoEventTypes.DIAGRAM_FONT_CHANGED, new PropertyChangeEvent(
                                        this, key.getKey(), oldValue, newValue)));
//#endif 

} 

//#endif 


//#if 946696348 
@Deprecated
    public void setShowAssociationNames(String showem)
    { 

//#if -365181602 
setShowAssociationNames(Boolean.valueOf(showem).booleanValue());
//#endif 

} 

//#endif 


//#if 1178208294 
@Deprecated
    public void init()
    { 

//#if -1911394639 
init(true, Configuration.makeKey("notation", "all"));
//#endif 


//#if 1944935645 
fireDiagramAppearanceEvent(
            Configuration.makeKey("diagramappearance", "all"),
            0, 0);
//#endif 

} 

//#endif 


//#if 1099919125 
@Deprecated
    public String getShowProperties()
    { 

//#if 256752201 
return Boolean.toString(getShowPropertiesValue());
//#endif 

} 

//#endif 


//#if 1308581494 
@Deprecated
    public String getShowSingularMultiplicities()
    { 

//#if 405465329 
return Boolean.toString(getShowSingularMultiplicitiesValue());
//#endif 

} 

//#endif 


//#if -2086607879 
@Deprecated
    public boolean getShowInitialValueValue()
    { 

//#if -1367027119 
return npSettings.isShowInitialValues();
//#endif 

} 

//#endif 


//#if 522503087 
@Deprecated
    public String getShowInitialValue()
    { 

//#if -1631296419 
return Boolean.toString(getShowInitialValueValue());
//#endif 

} 

//#endif 


//#if -881176873 
public void setHeaderComment(String c)
    { 

//#if -299903682 
headerComment = c;
//#endif 

} 

//#endif 


//#if 207436882 
public String getHeaderComment()
    { 

//#if -1335784249 
return headerComment;
//#endif 

} 

//#endif 


//#if -1209612146 
private void fireNotationEvent(ConfigurationKey key, String oldValue,
                                   String newValue)
    { 

//#if 1524399103 
ArgoEventPump.fireEvent(new ArgoNotationEvent(
                                    ArgoEventTypes.NOTATION_CHANGED, new PropertyChangeEvent(this,
                                            key.getKey(), oldValue, newValue)));
//#endif 

} 

//#endif 


//#if 1376117442 
ProjectSettings()
    { 

//#if 1563374392 
super();
//#endif 


//#if -1620512315 
diaDefault = new DiagramSettings();
//#endif 


//#if 297427081 
npSettings = diaDefault.getNotationSettings();
//#endif 


//#if -1005385549 
String notationLanguage =
            Notation.getConfiguredNotation().getConfigurationValue();
//#endif 


//#if -1413710517 
NotationProviderFactory2.setCurrentLanguage(notationLanguage);
//#endif 


//#if -854127672 
npSettings.setNotationLanguage(notationLanguage);
//#endif 


//#if 1722576301 
diaDefault.setShowBoldNames(Configuration.getBoolean(
                                        Notation.KEY_SHOW_BOLD_NAMES));
//#endif 


//#if 1871304385 
npSettings.setUseGuillemets(Configuration.getBoolean(
                                        Notation.KEY_USE_GUILLEMOTS, false));
//#endif 


//#if 1876998729 
npSettings.setShowAssociationNames(Configuration.getBoolean(
                                               Notation.KEY_SHOW_ASSOCIATION_NAMES, true));
//#endif 


//#if 1711805918 
npSettings.setShowVisibilities(Configuration.getBoolean(
                                           Notation.KEY_SHOW_VISIBILITY));
//#endif 


//#if 1454129028 
npSettings.setShowMultiplicities(Configuration.getBoolean(
                                             Notation.KEY_SHOW_MULTIPLICITY));
//#endif 


//#if -1925015160 
npSettings.setShowInitialValues(Configuration.getBoolean(
                                            Notation.KEY_SHOW_INITIAL_VALUE));
//#endif 


//#if 158962618 
npSettings.setShowProperties(Configuration.getBoolean(
                                         Notation.KEY_SHOW_PROPERTIES));
//#endif 


//#if 701582372 
npSettings.setShowTypes(Configuration.getBoolean(
                                    Notation.KEY_SHOW_TYPES, true));
//#endif 


//#if 1610249055 
diaDefault.setShowBidirectionalArrows(!Configuration.getBoolean(
                Notation.KEY_HIDE_BIDIRECTIONAL_ARROWS, true));
//#endif 


//#if 732590160 
showExplorerStereotypes = Configuration.getBoolean(
                                      Notation.KEY_SHOW_STEREOTYPES);
//#endif 


//#if -391254889 
npSettings.setShowSingularMultiplicities(Configuration.getBoolean(
                    Notation.KEY_SHOW_SINGULAR_MULTIPLICITIES, true));
//#endif 


//#if -487595204 
diaDefault.setDefaultShadowWidth(Configuration.getInteger(
                                             Notation.KEY_DEFAULT_SHADOW_WIDTH, 1));
//#endif 


//#if -2033574081 
diaDefault.setDefaultStereotypeView(Configuration.getInteger(
                                                ProfileConfiguration.KEY_DEFAULT_STEREOTYPE_VIEW,
                                                DiagramAppearance.STEREOTYPE_VIEW_TEXTUAL));
//#endif 


//#if 1588329260 
diaDefault.setFontName(
            DiagramAppearance.getInstance().getConfiguredFontName());
//#endif 


//#if 1334249635 
diaDefault.setFontSize(
            Configuration.getInteger(DiagramAppearance.KEY_FONT_SIZE));
//#endif 

} 

//#endif 


//#if 1714922594 
@Deprecated
    public void setShowInitialValue(String showem)
    { 

//#if -1915098966 
setShowInitialValue(Boolean.valueOf(showem).booleanValue());
//#endif 

} 

//#endif 


//#if 2070412821 
@Deprecated
    public String getDefaultStereotypeView()
    { 

//#if 25523002 
return Integer.valueOf(getDefaultStereotypeViewValue()).toString();
//#endif 

} 

//#endif 


//#if -476172255 
@Deprecated
    public String getShowMultiplicity()
    { 

//#if -1963448026 
return Boolean.toString(getShowMultiplicityValue());
//#endif 

} 

//#endif 


//#if 231959041 
@Deprecated
    public void setGenerationOutputDir(@SuppressWarnings("unused") String od)
    { 
} 

//#endif 


//#if -767641831 
@Deprecated
    public void setShowTypes(final boolean showem)
    { 

//#if -671861484 
if(npSettings.isShowTypes() == showem)//1
{ 

//#if -809354421 
return;
//#endif 

} 

//#endif 


//#if 2088299911 
Memento memento = new Memento() {
            private final ConfigurationKey key = Notation.KEY_SHOW_TYPES;

            public void redo() {
                npSettings.setShowTypes(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                npSettings.setShowTypes(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
//#endif 


//#if 1688431578 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if -366238659 
@Deprecated
    public void setFontSize(int newFontSize)
    { 

//#if 1942355017 
int old = diaDefault.getFontSize();
//#endif 


//#if -137794668 
diaDefault.setFontSize(newFontSize);
//#endif 


//#if 624547277 
fireDiagramAppearanceEvent(DiagramAppearance.KEY_FONT_SIZE, old,
                                   newFontSize);
//#endif 

} 

//#endif 


//#if 2139956107 
@Deprecated
    public Font getFontBoldItalic()
    { 

//#if -1053948754 
return diaDefault.getFontBoldItalic();
//#endif 

} 

//#endif 


//#if 859496191 
@Deprecated
    public String getFontName()
    { 

//#if 831138964 
return diaDefault.getFontName();
//#endif 

} 

//#endif 


//#if -325164925 
@Deprecated
    public void setHideBidirectionalArrows(final boolean hideem)
    { 

//#if 255278252 
if(diaDefault.isShowBidirectionalArrows() == !hideem)//1
{ 

//#if 1843726635 
return;
//#endif 

} 

//#endif 


//#if -125453789 
Memento memento = new Memento() {
            private final ConfigurationKey key =
                Notation.KEY_HIDE_BIDIRECTIONAL_ARROWS;

            public void redo() {
                diaDefault.setShowBidirectionalArrows(!hideem);
                fireNotationEvent(key, !hideem, hideem);
            }

            public void undo() {
                diaDefault.setShowBidirectionalArrows(hideem);
                fireNotationEvent(key, hideem, !hideem);
            }
        };
//#endif 


//#if -275279986 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if -1414390236 
public void setShowStereotypes(final boolean showem)
    { 

//#if -643760247 
if(showExplorerStereotypes == showem)//1
{ 

//#if 1325534935 
return;
//#endif 

} 

//#endif 


//#if -1032829905 
Memento memento = new Memento() {
            private final ConfigurationKey key = Notation.KEY_SHOW_STEREOTYPES;

            public void redo() {
                showExplorerStereotypes = showem;
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                showExplorerStereotypes = !showem;
                fireNotationEvent(key, showem, !showem);
            }
        };
//#endif 


//#if -985007570 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if 1343129651 
public NotationSettings getNotationSettings()
    { 

//#if -1547185457 
return npSettings;
//#endif 

} 

//#endif 


//#if -1169689132 
@Deprecated
    public void setShowMultiplicity(String showem)
    { 

//#if 1030011130 
setShowMultiplicity(Boolean.valueOf(showem).booleanValue());
//#endif 

} 

//#endif 


//#if -711309004 
@Deprecated
    public String getShowVisibility()
    { 

//#if 437292785 
return Boolean.toString(getShowVisibilityValue());
//#endif 

} 

//#endif 


//#if 1777680530 
public String getUseGuillemots()
    { 

//#if -920318841 
return Boolean.toString(getUseGuillemotsValue());
//#endif 

} 

//#endif 


//#if 923784483 
@Deprecated
    public Font getFont(int fontStyle)
    { 

//#if 827586385 
return diaDefault.getFont(fontStyle);
//#endif 

} 

//#endif 


//#if 1833792577 
@Deprecated
    public void setShowInitialValue(final boolean showem)
    { 

//#if 1121871223 
if(npSettings.isShowInitialValues() == showem)//1
{ 

//#if 1219704103 
return;
//#endif 

} 

//#endif 


//#if -559359520 
Memento memento = new Memento() {
            private final ConfigurationKey key =
                Notation.KEY_SHOW_INITIAL_VALUE;

            public void redo() {
                npSettings.setShowInitialValues(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                npSettings.setShowInitialValues(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
//#endif 


//#if 21589636 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if -160758088 
public void setNotationLanguage(NotationName nn)
    { 

//#if 35496060 
setNotationLanguage(nn.getConfigurationValue());
//#endif 

} 

//#endif 


//#if 1347302533 
public void setShowStereotypes(String showem)
    { 

//#if 1030854593 
setShowStereotypes(Boolean.valueOf(showem).booleanValue());
//#endif 

} 

//#endif 


//#if 872872660 
@Deprecated
    public boolean getShowVisibilityValue()
    { 

//#if -999963842 
return npSettings.isShowVisibilities();
//#endif 

} 

//#endif 


//#if -1360932830 
private void fireNotationEvent(ConfigurationKey key, boolean oldValue,
                                   boolean newValue)
    { 

//#if 1416403555 
fireNotationEvent(key, Boolean.toString(oldValue),
                          Boolean.toString(newValue));
//#endif 

} 

//#endif 


//#if -1330417977 
@Deprecated
    public boolean getShowMultiplicityValue()
    { 

//#if 1772541005 
return npSettings.isShowMultiplicities();
//#endif 

} 

//#endif 


//#if -594750456 
@Deprecated
    public void setShowSingularMultiplicities(final boolean showem)
    { 

//#if -1459267245 
if(npSettings.isShowSingularMultiplicities() == showem)//1
{ 

//#if 946363403 
return;
//#endif 

} 

//#endif 


//#if 1920578597 
Memento memento = new Memento() {
            private final ConfigurationKey key =
                Notation.KEY_SHOW_SINGULAR_MULTIPLICITIES;

            public void redo() {
                npSettings.setShowSingularMultiplicities(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                npSettings.setShowSingularMultiplicities(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
//#endif 


//#if -801531784 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if 1156547771 
@Deprecated
    public Font getFontBold()
    { 

//#if 797145092 
return diaDefault.getFontBold();
//#endif 

} 

//#endif 


//#if -1922241082 
private void doUndoable(Memento memento)
    { 

//#if 1303068180 
if(UndoManager.getInstance().isGenerateMementos())//1
{ 

//#if 296241971 
UndoManager.getInstance().addMemento(memento);
//#endif 

} 

//#endif 


//#if 561327271 
memento.redo();
//#endif 


//#if 1424393642 
ProjectManager.getManager().setSaveEnabled(true);
//#endif 

} 

//#endif 


//#if -1473447204 
public String getNotationLanguage()
    { 

//#if -1217966573 
return npSettings.getNotationLanguage();
//#endif 

} 

//#endif 


//#if 566558642 
public void setUseGuillemots(final boolean showem)
    { 

//#if 667853057 
if(getUseGuillemotsValue() == showem)//1
{ 

//#if 235101813 
return;
//#endif 

} 

//#endif 


//#if -1026408288 
Memento memento = new Memento() {
            private final ConfigurationKey key = Notation.KEY_USE_GUILLEMOTS;

            public void redo() {
                npSettings.setUseGuillemets(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                npSettings.setUseGuillemets(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
//#endif 


//#if -2025142923 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if 2115261027 
@Deprecated
    public void setShowBoldNames(final boolean showem)
    { 

//#if -36924058 
if(diaDefault.isShowBoldNames() == showem)//1
{ 

//#if 1988275006 
return;
//#endif 

} 

//#endif 


//#if 544955940 
Memento memento = new Memento() {
            private final ConfigurationKey key = Notation.KEY_SHOW_BOLD_NAMES;

            public void redo() {
                diaDefault.setShowBoldNames(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                diaDefault.setShowBoldNames(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
//#endif 


//#if -1836516878 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if 1442040337 
@Deprecated
    public String getGenerationOutputDir()
    { 

//#if -614227303 
return "";
//#endif 

} 

//#endif 


//#if -1008244614 
@Deprecated
    public void setDefaultStereotypeView(final int newView)
    { 

//#if 179783402 
final int oldValue = diaDefault.getDefaultStereotypeViewInt();
//#endif 


//#if 1031648966 
if(oldValue == newView)//1
{ 

//#if -573717191 
return;
//#endif 

} 

//#endif 


//#if -1791854447 
Memento memento = new Memento() {
            private final ConfigurationKey key =
                ProfileConfiguration.KEY_DEFAULT_STEREOTYPE_VIEW;

            public void redo() {
                diaDefault.setDefaultStereotypeView(newView);
                fireNotationEvent(key, oldValue, newView);
            }

            public void undo() {
                diaDefault.setDefaultStereotypeView(oldValue);
                fireNotationEvent(key, newView, oldValue);
            }
        };
//#endif 


//#if 13661626 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if -1802339226 
@Deprecated
    public Font getFontItalic()
    { 

//#if -1182324889 
return diaDefault.getFontItalic();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

