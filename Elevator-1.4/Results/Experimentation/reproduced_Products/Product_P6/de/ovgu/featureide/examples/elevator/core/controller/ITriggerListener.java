package de.ovgu.featureide.examples.elevator.core.controller;
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
