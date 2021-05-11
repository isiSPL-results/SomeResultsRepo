
//#if 745236267 
// Compilation Unit of /NotationSettings.java 
 

//#if -1787180852 
package org.argouml.notation;
//#endif 


//#if 2064926439 
import org.tigris.gef.undo.Memento;
//#endif 


//#if -2063919074 
public class NotationSettings  { 

//#if -2127228060 
private static final NotationSettings DEFAULT_SETTINGS =
        initializeDefaultSettings();
//#endif 


//#if 674590557 
private NotationSettings parent;
//#endif 


//#if 2072282753 
private String notationLanguage;
//#endif 


//#if 575158078 
private boolean showAssociationNames;
//#endif 


//#if -1506937904 
private boolean showAssociationNamesSet = false;
//#endif 


//#if 1442248053 
private boolean showVisibilities;
//#endif 


//#if -1275313287 
private boolean showVisibilitiesSet = false;
//#endif 


//#if 205666787 
private boolean showPaths;
//#endif 


//#if 1538005707 
private boolean showPathsSet = false;
//#endif 


//#if 1096666547 
private boolean fullyHandleStereotypes;
//#endif 


//#if 1553060091 
private boolean fullyHandleStereotypesSet = false;
//#endif 


//#if -2031865236 
private boolean useGuillemets;
//#endif 


//#if 655273058 
private boolean useGuillemetsSet = false;
//#endif 


//#if 781426024 
private boolean showMultiplicities;
//#endif 


//#if -1788748570 
private boolean showMultiplicitiesSet = false;
//#endif 


//#if 1290070609 
private boolean showSingularMultiplicities;
//#endif 


//#if 647890461 
private boolean showSingularMultiplicitiesSet = false;
//#endif 


//#if 342225848 
private boolean showTypes;
//#endif 


//#if 516137110 
private boolean showTypesSet = false;
//#endif 


//#if 654340690 
private boolean showProperties;
//#endif 


//#if 1933897532 
private boolean showPropertiesSet = false;
//#endif 


//#if -1331406261 
private boolean showInitialValues;
//#endif 


//#if -243011741 
private boolean showInitialValuesSet = false;
//#endif 


//#if 473093360 
public boolean isShowMultiplicities()
    { 

//#if -905913760 
if(showMultiplicitiesSet)//1
{ 

//#if 918419066 
return showMultiplicities;
//#endif 

} 
else

//#if 1259006489 
if(parent != null)//1
{ 

//#if 1004432267 
return parent.isShowMultiplicities();
//#endif 

} 

//#endif 


//#endif 


//#if -934024190 
return getDefaultSettings().isShowMultiplicities();
//#endif 

} 

//#endif 


//#if -1881605941 
public void setShowProperties(final boolean showem)
    { 

//#if -1839405707 
if(showProperties == showem && showPropertiesSet)//1
{ 

//#if 1334604877 
return;
//#endif 

} 

//#endif 


//#if -1876652156 
final boolean oldValid = showPropertiesSet;
//#endif 


//#if -252318867 
Memento memento = new Memento() {
            public void redo() {
                showProperties = showem;
                showPropertiesSet = true;
            }

            public void undo() {
                showProperties = !showem;
                showPropertiesSet = oldValid;
            }
        };
//#endif 


//#if 180631847 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if -650194891 
public void setShowTypes(final boolean showem)
    { 

//#if 98634287 
if(showTypes == showem && showTypesSet)//1
{ 

//#if 739535274 
return;
//#endif 

} 

//#endif 


//#if 753958090 
final boolean oldValid = showTypesSet;
//#endif 


//#if 1339430495 
Memento memento = new Memento() {
            public void redo() {
                showTypes = showem;
                showTypesSet = true;
            }

            public void undo() {
                showTypes = !showem;
                showTypesSet = oldValid;
            }
        };
//#endif 


//#if 1230913623 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if -2111960989 
public String getNotationLanguage()
    { 

//#if -571020751 
if(notationLanguage == null)//1
{ 

//#if 642502538 
if(parent != null)//1
{ 

//#if -1630132076 
return parent.getNotationLanguage();
//#endif 

} 
else
{ 

//#if 440218815 
return Notation.DEFAULT_NOTATION;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1862551634 
return notationLanguage;
//#endif 

} 

//#endif 


//#if -1739949374 
public void setShowInitialValues(final boolean showem)
    { 

//#if 540116094 
if(showInitialValues == showem && showInitialValuesSet)//1
{ 

//#if 208744725 
return;
//#endif 

} 

//#endif 


//#if 356954374 
final boolean oldValid = showInitialValuesSet;
//#endif 


//#if -1078005302 
Memento memento = new Memento() {
            public void redo() {
                showInitialValues = showem;
                showInitialValuesSet = true;
            }

            public void undo() {
                showInitialValues = !showem;
                showInitialValuesSet = oldValid;
            }
        };
//#endif 


//#if 2056143686 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if -713193766 
public boolean isShowAssociationNames()
    { 

//#if 1594403977 
if(showAssociationNamesSet)//1
{ 

//#if -657890795 
return showAssociationNames;
//#endif 

} 
else

//#if 220518847 
if(parent != null)//1
{ 

//#if 209343681 
return parent.isShowAssociationNames();
//#endif 

} 

//#endif 


//#endif 


//#if -163963797 
return getDefaultSettings().isShowAssociationNames();
//#endif 

} 

//#endif 


//#if -456749051 
public boolean isFullyHandleStereotypes()
    { 

//#if 1601143221 
if(fullyHandleStereotypesSet)//1
{ 

//#if 1495413033 
return fullyHandleStereotypes;
//#endif 

} 
else
{ 

//#if 731556809 
if(parent != null)//1
{ 

//#if -2010914266 
return parent.fullyHandleStereotypes;
//#endif 

} 
else
{ 

//#if 2028758057 
return getDefaultSettings().isFullyHandleStereotypes();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1821972033 
public static NotationSettings getDefaultSettings()
    { 

//#if -976097997 
return DEFAULT_SETTINGS;
//#endif 

} 

//#endif 


//#if 576988376 
public void setFullyHandleStereotypes(boolean newValue)
    { 

//#if 1959969653 
fullyHandleStereotypes = newValue;
//#endif 


//#if -340466774 
fullyHandleStereotypesSet = true;
//#endif 

} 

//#endif 


//#if -981606451 
private void doUndoable(Memento memento)
    { 

//#if -479551008 
memento.redo();
//#endif 

} 

//#endif 


//#if -1005206333 
public NotationSettings()
    { 

//#if 489525080 
super();
//#endif 


//#if 1092858162 
parent = getDefaultSettings();
//#endif 

} 

//#endif 


//#if -431847679 
public boolean setNotationLanguage(final String newLanguage)
    { 

//#if -1777589807 
if(notationLanguage != null
                && notationLanguage.equals(newLanguage))//1
{ 

//#if 1813897777 
return true;
//#endif 

} 

//#endif 


//#if 1380774087 
if(Notation.findNotation(newLanguage) == null)//1
{ 

//#if 884750201 
return false;
//#endif 

} 

//#endif 


//#if 1869981025 
final String oldLanguage = notationLanguage;
//#endif 


//#if -396345405 
Memento memento = new Memento() {
            public void redo() {
                notationLanguage = newLanguage;
                // TODO: We can't have a global "current" language
                // NotationProviderFactory2.setCurrentLanguage(newLanguage);
            }

            public void undo() {
                notationLanguage = oldLanguage;
                // TODO: We can't have a global "current" language
                // NotationProviderFactory2.setCurrentLanguage(oldLanguage);
            }
        };
//#endif 


//#if 373837841 
doUndoable(memento);
//#endif 


//#if -1094833608 
return true;
//#endif 

} 

//#endif 


//#if -1260344205 
private static NotationSettings initializeDefaultSettings()
    { 

//#if -294778963 
NotationSettings settings = new NotationSettings();
//#endif 


//#if 1738412239 
settings.parent = null;
//#endif 


//#if 710780100 
settings.setNotationLanguage(Notation.DEFAULT_NOTATION);
//#endif 


//#if 694166160 
settings.setFullyHandleStereotypes(false);
//#endif 


//#if -1361930896 
settings.setShowAssociationNames(true);
//#endif 


//#if -948305694 
settings.setShowInitialValues(false);
//#endif 


//#if -618679621 
settings.setShowMultiplicities(false);
//#endif 


//#if -1299891382 
settings.setShowPaths(false);
//#endif 


//#if 619030545 
settings.setShowProperties(false);
//#endif 


//#if 521217667 
settings.setShowSingularMultiplicities(true);
//#endif 


//#if 1519071488 
settings.setShowTypes(true);
//#endif 


//#if -1729499954 
settings.setShowVisibilities(false);
//#endif 


//#if -1930888159 
settings.setUseGuillemets(false);
//#endif 


//#if -93604405 
return settings;
//#endif 

} 

//#endif 


//#if 817260801 
public void setUseGuillemets(final boolean showem)
    { 

//#if -1733638634 
if(useGuillemets == showem && useGuillemetsSet)//1
{ 

//#if 916581514 
return;
//#endif 

} 

//#endif 


//#if 1264410749 
final boolean oldValid = useGuillemetsSet;
//#endif 


//#if 1364297776 
Memento memento = new Memento() {
            public void redo() {
                useGuillemets = showem;
                useGuillemetsSet = true;
            }

            public void undo() {
                useGuillemets = !showem;
                useGuillemetsSet = oldValid;
            }
        };
//#endif 


//#if -321842690 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if -57449231 
public NotationSettings(NotationSettings parentSettings)
    { 

//#if 1990453073 
this();
//#endif 


//#if 1200068038 
parent = parentSettings;
//#endif 

} 

//#endif 


//#if -1029749259 
public boolean isShowInitialValues()
    { 

//#if -55903227 
if(showInitialValuesSet)//1
{ 

//#if -1656723296 
return showInitialValues;
//#endif 

} 
else

//#if 1664322904 
if(parent != null)//1
{ 

//#if -1699130764 
return parent.isShowInitialValues();
//#endif 

} 

//#endif 


//#endif 


//#if -1821530941 
return getDefaultSettings().isShowInitialValues();
//#endif 

} 

//#endif 


//#if -1274561722 
public boolean isShowProperties()
    { 

//#if 968818349 
if(showPropertiesSet)//1
{ 

//#if 1593062757 
return showProperties;
//#endif 

} 
else

//#if 1168212588 
if(parent != null)//1
{ 

//#if 1293705630 
return parent.isShowProperties();
//#endif 

} 

//#endif 


//#endif 


//#if 538784271 
return getDefaultSettings().isShowProperties();
//#endif 

} 

//#endif 


//#if 1085803103 
public void setShowAssociationNames(final boolean showem)
    { 

//#if -1862092330 
if(showAssociationNames == showem && showAssociationNamesSet)//1
{ 

//#if -318305734 
return;
//#endif 

} 

//#endif 


//#if -1037449873 
final boolean oldValid = showAssociationNamesSet;
//#endif 


//#if -1107744980 
Memento memento = new Memento() {

            public void redo() {
                showAssociationNames = showem;
                showAssociationNamesSet = true;
            }

            public void undo() {
                showAssociationNames = !showem;
                showAssociationNamesSet = oldValid;
            }
        };
//#endif 


//#if 1699520880 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if 1829213304 
public void setShowPaths(boolean showPaths)
    { 

//#if 452149438 
this.showPaths = showPaths;
//#endif 


//#if -2045821527 
showPathsSet = true;
//#endif 

} 

//#endif 


//#if -728195747 
public boolean isShowPaths()
    { 

//#if -827466696 
if(showPathsSet)//1
{ 

//#if 606674289 
return showPaths;
//#endif 

} 
else

//#if 323611569 
if(parent != null)//1
{ 

//#if -1618973730 
return parent.isShowPaths();
//#endif 

} 

//#endif 


//#endif 


//#if -416307018 
return getDefaultSettings().isShowPaths();
//#endif 

} 

//#endif 


//#if -1929499261 
public boolean isShowVisibilities()
    { 

//#if -809950575 
if(showVisibilitiesSet)//1
{ 

//#if 1891020210 
return showVisibilities;
//#endif 

} 
else

//#if -121155827 
if(parent != null)//1
{ 

//#if -797198088 
return parent.isShowVisibilities();
//#endif 

} 

//#endif 


//#endif 


//#if -396473293 
return getDefaultSettings().isShowVisibilities();
//#endif 

} 

//#endif 


//#if -789832152 
public boolean isShowTypes()
    { 

//#if -307691857 
if(showTypesSet)//1
{ 

//#if -790225589 
return showTypes;
//#endif 

} 
else

//#if 944333639 
if(parent != null)//1
{ 

//#if 648044034 
return parent.isShowTypes();
//#endif 

} 

//#endif 


//#endif 


//#if 137545773 
return getDefaultSettings().isShowTypes();
//#endif 

} 

//#endif 


//#if -998705464 
public void setShowVisibilities(final boolean showem)
    { 

//#if 1450763195 
if(showVisibilities == showem && showVisibilitiesSet)//1
{ 

//#if 1003846875 
return;
//#endif 

} 

//#endif 


//#if -210391167 
final boolean oldValid = showVisibilitiesSet;
//#endif 


//#if 1726795207 
Memento memento = new Memento() {
            public void redo() {
                showVisibilities = showem;
                showVisibilitiesSet = true;
            }

            public void undo() {
                showVisibilities = !showem;
                showVisibilitiesSet = oldValid;
            }
        };
//#endif 


//#if 485877415 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if 1501161767 
public boolean isShowSingularMultiplicities()
    { 

//#if 2128500825 
if(showSingularMultiplicitiesSet)//1
{ 

//#if 1466601167 
return showSingularMultiplicities;
//#endif 

} 
else

//#if -97270187 
if(parent != null)//1
{ 

//#if -2078213873 
return parent.isShowSingularMultiplicities();
//#endif 

} 

//#endif 


//#endif 


//#if -1344685957 
return getDefaultSettings().isShowSingularMultiplicities();
//#endif 

} 

//#endif 


//#if -782789644 
public boolean isUseGuillemets()
    { 

//#if -1022273969 
if(useGuillemetsSet)//1
{ 

//#if 1336191797 
return useGuillemets;
//#endif 

} 
else

//#if -2133538394 
if(parent != null)//1
{ 

//#if 371889863 
return parent.isUseGuillemets();
//#endif 

} 

//#endif 


//#endif 


//#if 1325517 
return getDefaultSettings().isUseGuillemets();
//#endif 

} 

//#endif 


//#if 1956025964 
public void setShowSingularMultiplicities(final boolean showem)
    { 

//#if 660025054 
if(showSingularMultiplicities == showem
                && showSingularMultiplicitiesSet)//1
{ 

//#if -187888706 
return;
//#endif 

} 

//#endif 


//#if -945148838 
final boolean oldValid = showSingularMultiplicitiesSet;
//#endif 


//#if -205805372 
Memento memento = new Memento() {
            public void redo() {
                showSingularMultiplicities = showem;
                showSingularMultiplicitiesSet = true;
            }

            public void undo() {
                showSingularMultiplicities = !showem;
                showSingularMultiplicitiesSet = oldValid;
            }
        };
//#endif 


//#if -1717203054 
doUndoable(memento);
//#endif 

} 

//#endif 


//#if -757465611 
public void setShowMultiplicities(final boolean showem)
    { 

//#if 402504724 
if(showMultiplicities == showem && showMultiplicitiesSet)//1
{ 

//#if 1971169456 
return;
//#endif 

} 

//#endif 


//#if 1295761371 
final boolean oldValid = showMultiplicitiesSet;
//#endif 


//#if 1546018798 
Memento memento = new Memento() {
            public void redo() {
                showMultiplicities = showem;
                showMultiplicitiesSet = true;
            }

            public void undo() {
                showMultiplicities = !showem;
                showMultiplicitiesSet = oldValid;
            }
        };
//#endif 


//#if -159728742 
doUndoable(memento);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

