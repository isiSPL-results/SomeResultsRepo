// Compilation Unit of /ITriggerListener.java


//#if  CallButtons
package de.ovgu.featureide.examples.elevator.core.controller;
//#endif


//#if  CallButtons
public interface ITriggerListener
{
    /**
    	 * This methods gets called if a trigger is fired. For example if any floor
    	 * request is triggered.
    	 *
    	 * @param request
    	 *            The floor request that is triggered.
    	 */
    void trigger(Request request);
}

//#endif


