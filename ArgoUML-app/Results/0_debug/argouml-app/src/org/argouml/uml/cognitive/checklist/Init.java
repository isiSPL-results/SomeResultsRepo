
//#if -59119667 
// Compilation Unit of /Init.java 
 

//#if -695276905 
package org.argouml.uml.cognitive.checklist;
//#endif 


//#if 1758107917 
import org.argouml.cognitive.checklist.CheckItem;
//#endif 


//#if 1908345481 
import org.argouml.cognitive.checklist.CheckManager;
//#endif 


//#if 1790117122 
import org.argouml.cognitive.checklist.Checklist;
//#endif 


//#if 1715447650 
import org.argouml.i18n.Translator;
//#endif 


//#if 846164776 
import org.argouml.model.Model;
//#endif 


//#if -1199285520 
public class Init  { 

//#if -119226114 
private static void createChecklists()
    { 

//#if -75767595 
Checklist cl;
//#endif 


//#if -239270849 
String cat;
//#endif 


//#if -1459656023 
cl = new Checklist();
//#endif 


//#if -1805246393 
cat = Translator.localize("checklist.class.naming");
//#endif 


//#if -905658403 
newCheckItem(cat, "checklist.class.naming.describe-clearly", cl);
//#endif 


//#if 860325922 
newCheckItem(cat, "checklist.class.naming.is-noun", cl);
//#endif 


//#if 1812601435 
newCheckItem(cat, "checklist.class.naming.misinterpret", cl);
//#endif 


//#if -631207716 
cat = Translator.localize("checklist.class.encoding");
//#endif 


//#if -733976386 
newCheckItem(cat, "checklist.class.encoding.convert-to-attribute", cl);
//#endif 


//#if -719438856 
newCheckItem(cat, "checklist.class.encoding.do-just-one-thing", cl);
//#endif 


//#if -1156260709 
newCheckItem(cat, "checklist.class.encoding.break-into-parts", cl);
//#endif 


//#if 1535655272 
cat = Translator.localize("checklist.class.value");
//#endif 


//#if -433332229 
newCheckItem(cat, "checklist.class.value.start-with-meaningful-values",
                     cl);
//#endif 


//#if 2080022096 
newCheckItem(cat, "checklist.class.value.convert-to-invariant", cl);
//#endif 


//#if 1328664354 
newCheckItem(cat,
                     "checklist.class.value.establish-invariant-in-constructors",
                     cl);
//#endif 


//#if 820063174 
newCheckItem(cat, "checklist.class.value.maintain-invariant", cl);
//#endif 


//#if -2129697990 
cat = Translator.localize("checklist.class.location");
//#endif 


//#if 1240344303 
newCheckItem(cat, "checklist.class.location.move-somewhere", cl);
//#endif 


//#if -781066361 
newCheckItem(cat, "checklist.class.location.planned-subclasses", cl);
//#endif 


//#if 1246745481 
newCheckItem(cat, "checklist.class.location.eliminate-from-model", cl);
//#endif 


//#if 1734150913 
newCheckItem(cat,
                     "checklist.class.location.eliminates-or-affects-something-else",
                     cl);
//#endif 


//#if 311143983 
cat = Translator.localize("checklist.class.updates");
//#endif 


//#if -672448134 
newCheckItem(cat, "checklist.class.updates.reasons-for-update", cl);
//#endif 


//#if -322351958 
newCheckItem(cat, "checklist.class.updates.affects-something-else", cl);
//#endif 


//#if 1906988401 
CheckManager.register(Model.getMetaTypes().getUMLClass(), cl);
//#endif 


//#if 1931337481 
cl = new Checklist();
//#endif 


//#if 1594860523 
cat = Translator.localize("checklist.attribute.naming");
//#endif 


//#if 202568193 
newCheckItem(cat, "checklist.attribute.naming.describe-clearly", cl);
//#endif 


//#if 1269144958 
newCheckItem(cat, "checklist.attribute.naming.is-noun", cl);
//#endif 


//#if 1362034303 
newCheckItem(cat, "checklist.attribute.naming.misinterpret", cl);
//#endif 


//#if -1598573696 
cat = Translator.localize("checklist.attribute.encoding");
//#endif 


//#if -236539778 
newCheckItem(cat, "checklist.attribute.encoding.is-too-restrictive",
                     cl);
//#endif 


//#if 816768194 
newCheckItem(cat,
                     "checklist.attribute.encoding.allow-impossible-values",
                     cl);
//#endif 


//#if 294582485 
newCheckItem(cat, "checklist.attribute.encoding.combine-with-other",
                     cl);
//#endif 


//#if -1302391361 
newCheckItem(cat, "checklist.attribute.encoding.break-into-parts", cl);
//#endif 


//#if -2135604041 
newCheckItem(cat, "checklist.attribute.encoding.is-computable", cl);
//#endif 


//#if 1368241476 
cat = Translator.localize("checklist.attribute.value");
//#endif 


//#if -1821463957 
newCheckItem(cat, "checklist.attribute.value.default-value", cl);
//#endif 


//#if -955025528 
newCheckItem(cat, "checklist.attribute.value.correct-default-value",
                     cl);
//#endif 


//#if 1409301015 
newCheckItem(cat, "checklist.attribute.value.is-correctness-checkable",
                     cl);
//#endif 


//#if 1197903326 
cat = Translator.localize("checklist.attribute.location");
//#endif 


//#if -1946396397 
newCheckItem(cat, "checklist.attribute.location.move-somewhere", cl);
//#endif 


//#if -1665696819 
newCheckItem(cat, "checklist.attribute.location.move-up-hierarchy", cl);
//#endif 


//#if -1383507510 
newCheckItem(cat, "checklist.attribute.location.include-all", cl);
//#endif 


//#if 1214829838 
newCheckItem(cat, "checklist.attribute.location.could-be-eliminated",
                     cl);
//#endif 


//#if -1445770715 
newCheckItem(cat,
                     "checklist.attribute.location.eliminates-or-affects-something-else",
                     cl);
//#endif 


//#if -1659724021 
cat = Translator.localize("checklist.attribute.updates");
//#endif 


//#if -907531050 
newCheckItem(cat, "checklist.attribute.updates.reasons-for-update", cl);
//#endif 


//#if 1969826310 
newCheckItem(cat, "checklist.attribute.updates.affects-something-else",
                     cl);
//#endif 


//#if -1776226829 
newCheckItem(cat,
                     "checklist.attribute.updates.exists-method-for-update",
                     cl);
//#endif 


//#if 1203360640 
newCheckItem(cat,
                     "checklist.attribute.updates.exists-method-for-specific-value",
                     cl);
//#endif 


//#if 1738390299 
CheckManager.register(Model.getMetaTypes().getAttribute(), cl);
//#endif 


//#if 1931337482 
cl = new Checklist();
//#endif 


//#if -867169034 
cat = Translator.localize("checklist.operation.naming");
//#endif 


//#if -1600690292 
newCheckItem(cat, "checklist.operation.naming.describe-clearly", cl);
//#endif 


//#if 1829541080 
newCheckItem(cat, "checklist.operation.naming.is-verb", cl);
//#endif 


//#if 1640624522 
newCheckItem(cat, "checklist.operation.naming.misinterpret", cl);
//#endif 


//#if 689915870 
newCheckItem(cat, "checklist.operation.naming.do-just-one-thing", cl);
//#endif 


//#if -1081997877 
cat = Translator.localize("checklist.operation.encoding");
//#endif 


//#if -1596620860 
newCheckItem(cat,
                     "checklist.operation.encoding.is-returntype-too-restrictive",
                     cl);
//#endif 


//#if 859259423 
newCheckItem(cat,
                     "checklist.operation.encoding.does-returntype-allow-impossible-"
                     + "values", cl);
//#endif 


//#if 1014477024 
newCheckItem(cat,
                     "checklist.operation.encoding.combine-with-other", cl);
//#endif 


//#if 932992138 
newCheckItem(cat, "checklist.operation.encoding.break-into-parts", cl);
//#endif 


//#if -1038951049 
newCheckItem(cat, "checklist.operation.encoding.break-into-series", cl);
//#endif 


//#if -1755393915 
newCheckItem(cat, "checklist.operation.encoding.reduce-number-of-calls",
                     cl);
//#endif 


//#if -1620672807 
cat = Translator.localize("checklist.operation.value");
//#endif 


//#if -2058160853 
newCheckItem(cat, "checklist.operation.value.handle-all-inputs", cl);
//#endif 


//#if -543995577 
newCheckItem(cat, "checklist.operation.value.are-special-cases", cl);
//#endif 


//#if -1279163860 
newCheckItem(cat, "checklist.operation.value.is-correctness-checkable",
                     cl);
//#endif 


//#if 48273625 
newCheckItem(cat,
                     "checklist.operation.value.express-preconditions-possible",
                     cl);
//#endif 


//#if 1093498234 
newCheckItem(cat,
                     "checklist.operation.value.express-postconditions-possible",
                     cl);
//#endif 


//#if -1623389046 
newCheckItem(cat,
                     "checklist.operation.value.how-behave-preconditions-violated",
                     cl);
//#endif 


//#if -167421706 
newCheckItem(cat,
                     "checklist.operation.value.how-behave-postconditions-not-achieved",
                     cl);
//#endif 


//#if 1714479145 
cat = Translator.localize("checklist.operation.location");
//#endif 


//#if 545312414 
newCheckItem(cat, "checklist.operation.location.move-somewhere", cl);
//#endif 


//#if -1088285086 
newCheckItem(cat, "checklist.operation.location.move-up-hierarchy", cl);
//#endif 


//#if -1337145313 
newCheckItem(cat, "checklist.operation.location.include-all", cl);
//#endif 


//#if 2056724067 
newCheckItem(cat, "checklist.operation.location.could-be-eliminated",
                     cl);
//#endif 


//#if 928003440 
newCheckItem(cat,
                     "checklist.operation.location.eliminates-or-affects-something-else",
                     cl);
//#endif 


//#if -1563040272 
CheckManager.register(Model.getMetaTypes().getOperation(), cl);
//#endif 


//#if 1931337483 
cl = new Checklist();
//#endif 


//#if 1143006032 
cat = Translator.localize("checklist.association.naming");
//#endif 


//#if 650766630 
newCheckItem(cat, "checklist.association.naming.describe-clearly", cl);
//#endif 


//#if 154540217 
newCheckItem(cat, "checklist.association.naming.is-noun", cl);
//#endif 


//#if -698265564 
newCheckItem(cat, "checklist.association.naming.misinterpret", cl);
//#endif 


//#if -2039042651 
cat = Translator.localize("checklist.association.encoding");
//#endif 


//#if -1100368057 
newCheckItem(cat, "checklist.association.encoding.convert-to-attribute",
                     cl);
//#endif 


//#if -1728208369 
newCheckItem(cat, "checklist.association.encoding.do-just-one-thing",
                     cl);
//#endif 


//#if -80423004 
newCheckItem(cat, "checklist.association.encoding.break-into-parts",
                     cl);
//#endif 


//#if -447449793 
cat = Translator.localize("checklist.association.value");
//#endif 


//#if -244629742 
newCheckItem(cat,
                     "checklist.association.value.start-with-meaningful-values",
                     cl);
//#endif 


//#if 1071252583 
newCheckItem(cat, "checklist.association.value.convert-to-invariant",
                     cl);
//#endif 


//#if -738944981 
newCheckItem(cat,
                     "checklist.association.value.establish-invariant-in-constructors",
                     cl);
//#endif 


//#if 1824598941 
newCheckItem(cat, "checklist.association.value.maintain-invariant", cl);
//#endif 


//#if 757434371 
cat = Translator.localize("checklist.association.location");
//#endif 


//#if -1498197960 
newCheckItem(cat, "checklist.association.location.move-somewhere", cl);
//#endif 


//#if -1988150192 
newCheckItem(cat, "checklist.association.location.planned-subclasses",
                     cl);
//#endif 


//#if 880353810 
newCheckItem(cat, "checklist.association.location.eliminate-from-model",
                     cl);
//#endif 


//#if -114071311 
newCheckItem(cat,
                     "checklist.association.location.eliminates-or-affects-"
                     + "something-else", cl);
//#endif 


//#if 1512655942 
cat = Translator.localize("checklist.association.updates");
//#endif 


//#if -1681217647 
newCheckItem(cat, "checklist.association.updates.reasons-for-update",
                     cl);
//#endif 


//#if 1204408129 
newCheckItem(cat,
                     "checklist.association.updates.affects-something-else",
                     cl);
//#endif 


//#if 228838742 
CheckManager.register(Model.getMetaTypes().getAssociation(), cl);
//#endif 


//#if 1931337484 
cl = new Checklist();
//#endif 


//#if 1203013192 
cat = Translator.localize("checklist.interface.naming");
//#endif 


//#if -687602722 
newCheckItem(cat, "checklist.interface.naming.describe-clearly", cl);
//#endif 


//#if -200765695 
newCheckItem(cat, "checklist.interface.naming.is-noun", cl);
//#endif 


//#if -1249540388 
newCheckItem(cat, "checklist.interface.naming.misinterpret", cl);
//#endif 


//#if -206736739 
cat = Translator.localize("checklist.interface.encoding");
//#endif 


//#if 1117972479 
newCheckItem(cat, "checklist.interface.encoding.convert-to-attribute",
                     cl);
//#endif 


//#if 1386802263 
newCheckItem(cat, "checklist.interface.encoding.do-just-one-thing", cl);
//#endif 


//#if -2058148772 
newCheckItem(cat, "checklist.interface.encoding.break-into-parts", cl);
//#endif 


//#if 801411911 
cat = Translator.localize("checklist.interface.value");
//#endif 


//#if 1265353050 
newCheckItem(cat,
                     "checklist.interface.value.start-with-meaningful-values",
                     cl);
//#endif 


//#if -108704081 
newCheckItem(cat, "checklist.interface.value.convert-to-invariant", cl);
//#endif 


//#if -904760093 
newCheckItem(cat,
                     "checklist.interface.value.establish-invariant-in-constructors",
                     cl);
//#endif 


//#if -1010145307 
newCheckItem(cat, "checklist.interface.value.maintain-invariant", cl);
//#endif 


//#if -1705227013 
cat = Translator.localize("checklist.interface.location");
//#endif 


//#if 1458399984 
newCheckItem(cat, "checklist.interface.location.move-somewhere", cl);
//#endif 


//#if 87898888 
newCheckItem(cat, "checklist.interface.location.planned-subclasses",
                     cl);
//#endif 


//#if -1196272950 
newCheckItem(cat, "checklist.interface.location.eliminate-from-model",
                     cl);
//#endif 


//#if -1845303230 
newCheckItem(cat,
                     "checklist.interface.location.eliminates-or-affects-something-else",
                     cl);
//#endif 


//#if -922089394 
cat = Translator.localize("checklist.interface.updates");
//#endif 


//#if 1433792985 
newCheckItem(cat, "checklist.interface.updates.reasons-for-update", cl);
//#endif 


//#if 1253488009 
newCheckItem(cat, "checklist.interface.updates.affects-something-else",
                     cl);
//#endif 


//#if -420856354 
CheckManager.register(Model.getMetaTypes().getInterface(), cl);
//#endif 


//#if 1931337485 
cl = new Checklist();
//#endif 


//#if 286277462 
cat = Translator.localize("checklist.instance.general");
//#endif 


//#if -1633244692 
newCheckItem(cat, "checklist.instance.general.describe-clearly", cl);
//#endif 


//#if -994134622 
cat = Translator.localize("checklist.instance.naming");
//#endif 


//#if 125892954 
newCheckItem(cat, "checklist.instance.naming.describe-clearly", cl);
//#endif 


//#if -138663156 
newCheckItem(cat, "checklist.instance.naming.denotes-state", cl);
//#endif 


//#if -2131715496 
newCheckItem(cat, "checklist.instance.naming.misinterpret", cl);
//#endif 


//#if 602364011 
cat = Translator.localize("checklist.instance.structure");
//#endif 


//#if -1617432149 
newCheckItem(cat, "checklist.instance.structure.merged-with-other", cl);
//#endif 


//#if -1885580471 
newCheckItem(cat, "checklist.instance.structure.do-just-one-thing", cl);
//#endif 


//#if 1438521130 
newCheckItem(cat, "checklist.instance.structure.break-into-parts", cl);
//#endif 


//#if 2147393652 
newCheckItem(cat,
                     "checklist.instance.structure.can-write-characteristic-equation",
                     cl);
//#endif 


//#if 202650664 
newCheckItem(cat, "checklist.instance.structure.belong", cl);
//#endif 


//#if 1349092701 
newCheckItem(cat, "checklist.instance.structure.make-internal", cl);
//#endif 


//#if 22913223 
newCheckItem(cat,
                     "checklist.instance.structure.is-state-in-another-machine-"
                     + "exclusive", cl);
//#endif 


//#if 1833601825 
cat = Translator.localize("checklist.instance.actions");
//#endif 


//#if 61022098 
newCheckItem(cat, "checklist.instance.actions.list-entry-actions", cl);
//#endif 


//#if -1931608636 
newCheckItem(cat,
                     "checklist.instance.actions.update-attribute-on-entry",
                     cl);
//#endif 


//#if -1254744267 
newCheckItem(cat, "checklist.instance.actions.list-exit-action", cl);
//#endif 


//#if 1611920246 
newCheckItem(cat, "checklist.instance.actions.update-attribute-on-exit",
                     cl);
//#endif 


//#if -19223640 
newCheckItem(cat, "checklist.instance.actions.list-do-action", cl);
//#endif 


//#if 230052493 
newCheckItem(cat, "checklist.instance.actions.maintained-state", cl);
//#endif 


//#if -297038400 
cat = Translator.localize("checklist.instance.transitions");
//#endif 


//#if -1690236843 
newCheckItem(cat,
                     "checklist.instance.transitions.need-another-transition-into",
                     cl);
//#endif 


//#if -1245136705 
newCheckItem(cat,
                     "checklist.instance.transitions.use-all-transitions-into",
                     cl);
//#endif 


//#if -1798853368 
newCheckItem(cat,
                     "checklist.instance.transitions.combine-with-other-incoming",
                     cl);
//#endif 


//#if -1636527573 
newCheckItem(cat,
                     "checklist.instance.transitions.need-another-transition-out-of",
                     cl);
//#endif 


//#if 902942741 
newCheckItem(cat,
                     "checklist.instance.transitions.use-all-transitions-out-of",
                     cl);
//#endif 


//#if 485514317 
newCheckItem(cat,
                     "checklist.instance.transitions.are-transitions-out-of-exclusive",
                     cl);
//#endif 


//#if 701029326 
newCheckItem(cat,
                     "checklist.instance.transitions.combine-with-other-outgoing",
                     cl);
//#endif 


//#if 926853312 
CheckManager.register(Model.getMetaTypes().getInstance(), cl);
//#endif 


//#if 1931337486 
cl = new Checklist();
//#endif 


//#if 1724720711 
cat = Translator.localize("checklist.link.naming");
//#endif 


//#if 261332479 
newCheckItem(cat, "checklist.link.naming.describe-clearly", cl);
//#endif 


//#if 184146880 
newCheckItem(cat, "checklist.link.naming.is-noun", cl);
//#endif 


//#if 1131501949 
newCheckItem(cat, "checklist.link.naming.misinterpret", cl);
//#endif 


//#if -1356984612 
cat = Translator.localize("checklist.link.encoding");
//#endif 


//#if -448486048 
newCheckItem(cat, "checklist.link.encoding.convert-to-attribute", cl);
//#endif 


//#if 1640632982 
newCheckItem(cat, "checklist.link.encoding.do-just-one-thing", cl);
//#endif 


//#if -664487363 
newCheckItem(cat, "checklist.link.encoding.break-into-parts", cl);
//#endif 


//#if -1121421464 
cat = Translator.localize("checklist.link.value");
//#endif 


//#if 1323186329 
newCheckItem(cat, "checklist.link.value.start-with-meaningful-values",
                     cl);
//#endif 


//#if 145126638 
newCheckItem(cat, "checklist.link.value.convert-to-invariant", cl);
//#endif 


//#if -1633277756 
newCheckItem(cat,
                     "checklist.link.value.establish-invariant-in-constructors",
                     cl);
//#endif 


//#if -1657925148 
newCheckItem(cat, "checklist.link.value.maintain-invariant", cl);
//#endif 


//#if 1439492410 
cat = Translator.localize("checklist.link.location");
//#endif 


//#if -1887632111 
newCheckItem(cat, "checklist.link.location.move-somewhere", cl);
//#endif 


//#if -633283415 
newCheckItem(cat, "checklist.link.location.planned-subclasses", cl);
//#endif 


//#if 1532235819 
newCheckItem(cat, "checklist.link.location.eliminate-from-model", cl);
//#endif 


//#if -874003549 
newCheckItem(cat,
                     "checklist.link.location.eliminates-or-affects-something-else",
                     cl);
//#endif 


//#if -1929025489 
cat = Translator.localize("checklist.link.updates");
//#endif 


//#if 1687623704 
newCheckItem(cat, "checklist.link.updates.reasons-for-update", cl);
//#endif 


//#if -62086072 
newCheckItem(cat, "checklist.link.updates.affects-something-else", cl);
//#endif 


//#if 1896227131 
CheckManager.register(Model.getMetaTypes().getLink(), cl);
//#endif 


//#if 1931337487 
cl = new Checklist();
//#endif 


//#if 607842336 
cat = Translator.localize("checklist.state.naming");
//#endif 


//#if -2080102090 
newCheckItem(cat, "checklist.state.naming.describe-clearly", cl);
//#endif 


//#if -1744934736 
newCheckItem(cat, "checklist.state.naming.denotes-state", cl);
//#endif 


//#if -1906436044 
newCheckItem(cat, "checklist.state.naming.misinterpret", cl);
//#endif 


//#if -578673363 
cat = Translator.localize("checklist.state.structure");
//#endif 


//#if -989342841 
newCheckItem(cat, "checklist.state.structure.merged-with-other", cl);
//#endif 


//#if -1257491163 
newCheckItem(cat, "checklist.state.structure.do-just-one-thing", cl);
//#endif 


//#if -65238578 
newCheckItem(cat, "checklist.state.structure.break-into-parts", cl);
//#endif 


//#if -2054731184 
newCheckItem(cat,
                     "checklist.state.structure.can-write-characteristic-equation",
                     cl);
//#endif 


//#if 641655756 
newCheckItem(cat, "checklist.state.structure.belong", cl);
//#endif 


//#if -856902343 
newCheckItem(cat, "checklist.state.structure.make-internal", cl);
//#endif 


//#if -1612269662 
newCheckItem(cat,
                     "checklist.state.structure.is-state-in-another-machine-exclusive",
                     cl);
//#endif 


//#if -44720029 
cat = Translator.localize("checklist.state.actions");
//#endif 


//#if -1442737610 
newCheckItem(cat, "checklist.state.actions.list-entry-actions", cl);
//#endif 


//#if 1929120416 
newCheckItem(cat, "checklist.state.actions.update-attribute-on-entry",
                     cl);
//#endif 


//#if -921113895 
newCheckItem(cat, "checklist.state.actions.list-exit-action", cl);
//#endif 


//#if -1311581414 
newCheckItem(cat, "checklist.state.actions.update-attribute-on-exit",
                     cl);
//#endif 


//#if -1752952756 
newCheckItem(cat, "checklist.state.actions.list-do-action", cl);
//#endif 


//#if 563682865 
newCheckItem(cat, "checklist.state.actions.maintained-state", cl);
//#endif 


//#if -1402588670 
cat = Translator.localize("checklist.state.transitions");
//#endif 


//#if 184552441 
newCheckItem(cat,
                     "checklist.state.transitions.need-another-transition-into",
                     cl);
//#endif 


//#if -1195168157 
newCheckItem(cat,
                     "checklist.state.transitions.use-all-transitions-into",
                     cl);
//#endif 


//#if 755475684 
newCheckItem(cat,
                     "checklist.state.transitions.combine-with-other-incoming",
                     cl);
//#endif 


//#if 444677327 
newCheckItem(cat,
                     "checklist.state.transitions.need-another-transition-out-of",
                     cl);
//#endif 


//#if 1678077113 
newCheckItem(cat,
                     "checklist.state.transitions.use-all-transitions-out-of",
                     cl);
//#endif 


//#if -931336719 
newCheckItem(cat,
                     "checklist.state.transitions.are-transitions-out-of-exclusive",
                     cl);
//#endif 


//#if -1039608918 
newCheckItem(cat,
                     "checklist.state.transitions.combine-with-other-outgoing",
                     cl);
//#endif 


//#if -1649204218 
CheckManager.register(Model.getMetaTypes().getState(), cl);
//#endif 


//#if 1931337488 
cl = new Checklist();
//#endif 


//#if 75706219 
cat = Translator.localize("checklist.transition.structure");
//#endif 


//#if -1012188409 
newCheckItem(cat, "checklist.transition.structure.start-somewhere-else",
                     cl);
//#endif 


//#if 190008622 
newCheckItem(cat, "checklist.transition.structure.end-somewhere-else",
                     cl);
//#endif 


//#if -797589892 
newCheckItem(cat,
                     "checklist.transition.structure.need-another-like-this",
                     cl);
//#endif 


//#if -307967561 
newCheckItem(cat,
                     "checklist.transition.structure.unneeded-because-of-this",
                     cl);
//#endif 


//#if -2084137082 
cat = Translator.localize("checklist.transition.trigger");
//#endif 


//#if 1729309561 
newCheckItem(cat, "checklist.transition.trigger.needed", cl);
//#endif 


//#if 1212937094 
newCheckItem(cat, "checklist.transition.trigger.happen-too-often", cl);
//#endif 


//#if 496907769 
newCheckItem(cat, "checklist.transition.trigger.happen-too-rarely", cl);
//#endif 


//#if -563847687 
cat = Translator.localize("checklist.transition.guard");
//#endif 


//#if -1454622214 
newCheckItem(cat, "checklist.transition.guard.taken-too-often", cl);
//#endif 


//#if -343081481 
newCheckItem(cat, "checklist.transition.guard.is-too-restrictive", cl);
//#endif 


//#if 503082360 
newCheckItem(cat, "checklist.transition.guard.break-into-parts", cl);
//#endif 


//#if -1594875359 
cat = Translator.localize("checklist.transition.actions");
//#endif 


//#if 1198113005 
newCheckItem(cat, "checklist.transition.actions.should-have", cl);
//#endif 


//#if 1017583592 
newCheckItem(cat, "checklist.transition.actions.should-have-exit", cl);
//#endif 


//#if 1118791570 
newCheckItem(cat, "checklist.transition.actions.should-have-entry", cl);
//#endif 


//#if -1838486955 
newCheckItem(cat, "checklist.transition.actions.is-precondition-met",
                     cl);
//#endif 


//#if 821205149 
newCheckItem(cat,
                     "checklist.transition.actions.is-postcondition-consistant-with-"
                     + "destination", cl);
//#endif 


//#if -85049280 
CheckManager.register(Model.getMetaTypes().getTransition(), cl);
//#endif 


//#if -258080216 
cl = new Checklist();
//#endif 


//#if -1025015546 
cat = Translator.localize("checklist.usecase.naming");
//#endif 


//#if -1313880228 
newCheckItem(cat, "checklist.usecase.naming.describe-clearly", cl);
//#endif 


//#if 1685145027 
newCheckItem(cat, "checklist.usecase.naming.is-noun", cl);
//#endif 


//#if 590002522 
newCheckItem(cat, "checklist.usecase.naming.misinterpret", cl);
//#endif 


//#if 1846326747 
cat = Translator.localize("checklist.usecase.encoding");
//#endif 


//#if -1719560963 
newCheckItem(cat, "checklist.usecase.encoding.convert-to-attribute",
                     cl);
//#endif 


//#if 1291554841 
newCheckItem(cat, "checklist.usecase.encoding.do-just-one-thing", cl);
//#endif 


//#if 1679556698 
newCheckItem(cat, "checklist.usecase.encoding.break-into-parts", cl);
//#endif 


//#if 1560824009 
cat = Translator.localize("checklist.usecase.value");
//#endif 


//#if -1035500772 
newCheckItem(cat,
                     "checklist.usecase.value.start-with-meaningful-values",
                     cl);
//#endif 


//#if -203951503 
newCheckItem(cat, "checklist.usecase.value.convert-to-invariant", cl);
//#endif 


//#if 1917818081 
newCheckItem(cat,
                     "checklist.usecase.value.establish-invariant-in-constructors",
                     cl);
//#endif 


//#if 1050088487 
newCheckItem(cat, "checklist.usecase.value.maintain-invariant", cl);
//#endif 


//#if 347836473 
cat = Translator.localize("checklist.usecase.location");
//#endif 


//#if 832122478 
newCheckItem(cat, "checklist.usecase.location.move-somewhere", cl);
//#endif 


//#if 1430196102 
newCheckItem(cat, "checklist.usecase.location.planned-subclasses", cl);
//#endif 


//#if 261160904 
newCheckItem(cat, "checklist.usecase.location.eliminate-from-model",
                     cl);
//#endif 


//#if -1768695488 
newCheckItem(cat,
                     "checklist.usecase.location.eliminates-or-affects-something-else",
                     cl);
//#endif 


//#if -1271503536 
cat = Translator.localize("checklist.usecase.updates");
//#endif 


//#if 1338545563 
newCheckItem(cat, "checklist.usecase.updates.reasons-for-update", cl);
//#endif 


//#if -810702773 
newCheckItem(cat, "checklist.usecase.updates.affects-something-else",
                     cl);
//#endif 


//#if 795059264 
CheckManager.register(Model.getMetaTypes().getUseCase(), cl);
//#endif 


//#if -258080215 
cl = new Checklist();
//#endif 


//#if -269391740 
cat = Translator.localize("checklist.actor.naming");
//#endif 


//#if -141654118 
newCheckItem(cat, "checklist.actor.naming.describe-clearly", cl);
//#endif 


//#if -1900828731 
newCheckItem(cat, "checklist.actor.naming.is-noun", cl);
//#endif 


//#if 1350518936 
newCheckItem(cat, "checklist.actor.naming.misinterpret", cl);
//#endif 


//#if -2143636007 
cat = Translator.localize("checklist.actor.encoding");
//#endif 


//#if -49107269 
newCheckItem(cat, "checklist.actor.encoding.convert-to-attribute", cl);
//#endif 


//#if 700514075 
newCheckItem(cat, "checklist.actor.encoding.do-just-one-thing", cl);
//#endif 


//#if -1387550440 
newCheckItem(cat, "checklist.actor.encoding.break-into-parts", cl);
//#endif 


//#if 2139388299 
cat = Translator.localize("checklist.actor.value");
//#endif 


//#if -558444514 
newCheckItem(cat, "checklist.actor.value.start-with-meaningful-values",
                     cl);
//#endif 


//#if -794992269 
newCheckItem(cat, "checklist.actor.value.convert-to-invariant", cl);
//#endif 


//#if -717094497 
newCheckItem(cat,
                     "checklist.actor.value.establish-invariant-in-constructors",
                     cl);
//#endif 


//#if -1265607767 
newCheckItem(cat, "checklist.actor.value.maintain-invariant", cl);
//#endif 


//#if 652841015 
cat = Translator.localize("checklist.actor.location");
//#endif 


//#if 2004348588 
newCheckItem(cat, "checklist.actor.location.move-somewhere", cl);
//#endif 


//#if 287801540 
newCheckItem(cat, "checklist.actor.location.planned-subclasses", cl);
//#endif 


//#if 1931614598 
newCheckItem(cat, "checklist.actor.location.eliminate-from-model", cl);
//#endif 


//#if 753252094 
newCheckItem(cat,
                     "checklist.actor.location.eliminates-or-affects-something-else",
                     cl);
//#endif 


//#if 677997970 
cat = Translator.localize("checklist.actor.updates");
//#endif 


//#if 747504797 
newCheckItem(cat, "checklist.actor.updates.reasons-for-update", cl);
//#endif 


//#if -566245811 
newCheckItem(cat, "checklist.actor.updates.affects-something-else", cl);
//#endif 


//#if -1299044830 
CheckManager.register(Model.getMetaTypes().getActor(), cl);
//#endif 

} 

//#endif 


//#if -170084121 
private static void newCheckItem(String category, String key,
                                     Checklist checklist)
    { 

//#if -1711452447 
CheckItem checkitem =
            new UMLCheckItem(category, Translator.localize(key));
//#endif 


//#if -1211033324 
checklist.add(checkitem);
//#endif 

} 

//#endif 


//#if 784772237 
public static void init()
    { 

//#if -183007703 
createChecklists();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

