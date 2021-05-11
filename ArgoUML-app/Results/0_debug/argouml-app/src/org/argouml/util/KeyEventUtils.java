
//#if 1126864673 
// Compilation Unit of /KeyEventUtils.java 
 

//#if -1933883562 
package org.argouml.util;
//#endif 


//#if 470383552 
import java.awt.event.InputEvent;
//#endif 


//#if 406902741 
import java.awt.event.KeyEvent;
//#endif 


//#if -1624724469 
import java.lang.reflect.Field;
//#endif 


//#if -1050622342 
import java.lang.reflect.Modifier;
//#endif 


//#if 1251236657 
import javax.swing.KeyStroke;
//#endif 


//#if 1003141063 
public class KeyEventUtils  { 

//#if 1551223087 
public static final String MODIFIER_JOINER = " + ";
//#endif 


//#if -312740941 
public static final String SHIFT_MODIFIER = "SHIFT";
//#endif 


//#if -1641326235 
public static final String CTRL_MODIFIER = "CTRL";
//#endif 


//#if -1023983067 
public static final String META_MODIFIER = "META";
//#endif 


//#if -2020831103 
public static final String ALT_MODIFIER = "ALT";
//#endif 


//#if -625923728 
public static final String ALT_GRAPH_MODIFIER = "altGraph";
//#endif 


//#if -293357136 
public static String getModifiersText(int modifiers)
    { 

//#if 2095733304 
StringBuffer buf = new StringBuffer();
//#endif 


//#if 1993098975 
if((modifiers & InputEvent.SHIFT_MASK) != 0)//1
{ 

//#if -498584056 
buf.append(SHIFT_MODIFIER).append(MODIFIER_JOINER);
//#endif 

} 

//#endif 


//#if 299926032 
if((modifiers & InputEvent.CTRL_MASK) != 0)//1
{ 

//#if 2068928683 
buf.append(CTRL_MODIFIER).append(MODIFIER_JOINER);
//#endif 

} 

//#endif 


//#if 2513078 
if((modifiers & InputEvent.META_MASK) != 0)//1
{ 

//#if -1500320827 
buf.append(META_MODIFIER).append(MODIFIER_JOINER);
//#endif 

} 

//#endif 


//#if -94217768 
if((modifiers & InputEvent.ALT_MASK) != 0)//1
{ 

//#if -508052659 
buf.append(ALT_MODIFIER).append(MODIFIER_JOINER);
//#endif 

} 

//#endif 


//#if -282065271 
if((modifiers & InputEvent.ALT_GRAPH_MASK) != 0)//1
{ 

//#if 1683950117 
buf.append(ALT_GRAPH_MODIFIER).append(MODIFIER_JOINER);
//#endif 

} 

//#endif 


//#if -1607510129 
return buf.toString();
//#endif 

} 

//#endif 


//#if 1207408473 
public static final boolean isActionEvent(KeyEvent evt)
    { 

//#if 1620702630 
int keyCode = evt.getKeyCode();
//#endif 


//#if -1437193310 
switch (keyCode) //1
{ 
case KeyEvent.VK_BACK_SPACE://1

case KeyEvent.VK_DELETE://1

case KeyEvent.VK_CANCEL://1

case KeyEvent.VK_HOME://1

case KeyEvent.VK_END://1

case KeyEvent.VK_PAGE_UP://1

case KeyEvent.VK_PAGE_DOWN://1

case KeyEvent.VK_UP://1

case KeyEvent.VK_DOWN://1

case KeyEvent.VK_LEFT://1

case KeyEvent.VK_RIGHT://1

case KeyEvent.VK_KP_LEFT://1

case KeyEvent.VK_KP_UP://1

case KeyEvent.VK_KP_RIGHT://1

case KeyEvent.VK_KP_DOWN://1

case KeyEvent.VK_F1://1

case KeyEvent.VK_F2://1

case KeyEvent.VK_F3://1

case KeyEvent.VK_F4://1

case KeyEvent.VK_F5://1

case KeyEvent.VK_F6://1

case KeyEvent.VK_F7://1

case KeyEvent.VK_F8://1

case KeyEvent.VK_F9://1

case KeyEvent.VK_F10://1

case KeyEvent.VK_F11://1

case KeyEvent.VK_F12://1

case KeyEvent.VK_F13://1

case KeyEvent.VK_F14://1

case KeyEvent.VK_F15://1

case KeyEvent.VK_F16://1

case KeyEvent.VK_F17://1

case KeyEvent.VK_F18://1

case KeyEvent.VK_F19://1

case KeyEvent.VK_F20://1

case KeyEvent.VK_F21://1

case KeyEvent.VK_F22://1

case KeyEvent.VK_F23://1

case KeyEvent.VK_F24://1

case KeyEvent.VK_PRINTSCREEN://1

case KeyEvent.VK_SCROLL_LOCK://1

case KeyEvent.VK_CAPS_LOCK://1

case KeyEvent.VK_NUM_LOCK://1

case KeyEvent.VK_PAUSE://1

case KeyEvent.VK_INSERT://1

case KeyEvent.VK_FINAL://1

case KeyEvent.VK_CONVERT://1

case KeyEvent.VK_NONCONVERT://1

case KeyEvent.VK_ACCEPT://1

case KeyEvent.VK_MODECHANGE://1

case KeyEvent.VK_KANA://1

case KeyEvent.VK_KANJI://1

case KeyEvent.VK_ALPHANUMERIC://1

case KeyEvent.VK_KATAKANA://1

case KeyEvent.VK_HIRAGANA://1

case KeyEvent.VK_FULL_WIDTH://1

case KeyEvent.VK_HALF_WIDTH://1

case KeyEvent.VK_ROMAN_CHARACTERS://1

case KeyEvent.VK_ALL_CANDIDATES://1

case KeyEvent.VK_PREVIOUS_CANDIDATE://1

case KeyEvent.VK_CODE_INPUT://1

case KeyEvent.VK_JAPANESE_KATAKANA://1

case KeyEvent.VK_JAPANESE_HIRAGANA://1

case KeyEvent.VK_JAPANESE_ROMAN://1

case KeyEvent.VK_KANA_LOCK://1

case KeyEvent.VK_INPUT_METHOD_ON_OFF://1

case KeyEvent.VK_AGAIN://1

case KeyEvent.VK_UNDO://1

case KeyEvent.VK_COPY://1

case KeyEvent.VK_PASTE://1

case KeyEvent.VK_CUT://1

case KeyEvent.VK_FIND://1

case KeyEvent.VK_PROPS://1

case KeyEvent.VK_STOP://1

case KeyEvent.VK_HELP://1


//#if -929765893 
return true;
//#endif 


} 

//#endif 


//#if 518855669 
return false;
//#endif 

} 

//#endif 


//#if 592326179 
public static String getKeyText(int keyCode)
    { 

//#if 130699869 
int expectedModifiers =
            (Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL);
//#endif 


//#if 1885443001 
Field[] fields = KeyEvent.class.getDeclaredFields();
//#endif 


//#if -85875320 
for (int i = 0; i < fields.length; i++) //1
{ 

//#if 1736862978 
try //1
{ 

//#if 1555642541 
if(fields[i].getModifiers() == expectedModifiers
                        && fields[i].getType() == Integer.TYPE
                        && fields[i].getName().startsWith("VK_")
                        && fields[i].getInt(KeyEvent.class) == keyCode)//1
{ 

//#if 289991728 
return fields[i].getName().substring(3);
//#endif 

} 

//#endif 

} 

//#if 248763580 
catch (IllegalAccessException e) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 


//#if 298880874 
return "UNKNOWN";
//#endif 

} 

//#endif 


//#if 1637991480 
public static String formatKeyStroke(KeyStroke keyStroke)
    { 

//#if -186595594 
if(keyStroke != null)//1
{ 

//#if 1218755295 
return getModifiersText(keyStroke.getModifiers())
                   + KeyEventUtils.getKeyText(keyStroke.getKeyCode());
//#endif 

} 
else
{ 

//#if -1865504708 
return "";
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

