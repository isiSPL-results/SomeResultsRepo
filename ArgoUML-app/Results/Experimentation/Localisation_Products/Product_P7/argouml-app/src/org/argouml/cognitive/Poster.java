package org.argouml.cognitive;
import java.util.List;
import javax.swing.Icon;
public interface Poster  { 
boolean supports(Decision d);String expand(String desc, ListSet offs);void fixIt(ToDoItem item, Object arg);List<Goal> getSupportedGoals();void unsnooze();void snooze();List<Decision> getSupportedDecisions();boolean containsKnowledgeType(String knowledgeType);boolean stillValid(ToDoItem i, Designer d);boolean supports(Goal g);Icon getClarifier();boolean canFixIt(ToDoItem item);
 } 
