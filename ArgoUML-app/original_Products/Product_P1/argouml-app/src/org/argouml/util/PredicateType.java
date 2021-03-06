//    PredicateType.java 41 2010-04-03 20:04:12Z marcusvnac $
// Copyright (c) 1996-2008 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies.  This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason.  IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.

package org.argouml.util;

/*
 * A predicate which matches UML element types.
 */
public class PredicateType implements Predicate
{

    private Class patterns[];

    private int patternCount;

    private String printString = null;

    protected PredicateType(Class pats[])
    {
        this(pats, pats.length);
    }

    protected PredicateType(Class pats[], int numPats)
    {
        patterns = pats;
        patternCount = numPats;
    }

    public static PredicateType create()
    {
        return new PredicateType(null, 0);
    }

    public static PredicateType create(Class c0)
    {
        Class classes[] = new Class[1];
        classes[0] = c0;
        return new PredicateType(classes);
    }

    public static PredicateType create(Class c0, Class c1)
    {
        Class classes[] = new Class[2];
        classes[0] = c0;
        classes[1] = c1;
        return new PredicateType(classes);
    }

    public static PredicateType create(Class c0, Class c1, Class c2)
    {
        Class classes[] = new Class[3];
        classes[0] = c0;
        classes[1] = c1;
        classes[2] = c2;
        return new PredicateType(classes);
    }

    public boolean evaluate(Object o)
    {
        if (patternCount == 0) {
            return true;
        }
        for (int i = 0; i < patternCount; i++) {
            if (patterns[i].isInstance(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString()
    {
        if (printString != null) {
            return printString;
        }
        if (patternCount == 0) {
            return "Any Type";
        }
        String res = "";
        for (int i = 0; i < patternCount; i++) {
            String clsName = patterns[i].getName();
            int lastDot = clsName.lastIndexOf(".");
            clsName = clsName.substring(lastDot + 1);
            res += clsName;
            if (i < patternCount - 1) {
                res += ", ";
            }
        }
        printString = res;
        return res;
    }
}
