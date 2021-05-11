package org.argouml.ui.explorer.rules;
import java.util.Collection;
public abstract class AbstractPerspectiveRule implements PerspectiveRule
  { 
public abstract String getRuleName();public String toString()
    { 
return getRuleName();
} 
public abstract Collection getChildren(Object parent);
 } 
