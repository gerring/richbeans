package org.eclipse.richbeans.api.beans;

import org.eclipse.richbeans.api.widget.IFieldWidget;

/**
 * 
 * A bean processor is used to execute vistor patterns on beans.
 * 
 * @author Matthew Gerring
 *
 */
public abstract class BeanProcessor {
	
	/**
	 * The visit method
	 * @param name
	 * @param value
	 * @param box
	 * @throws Exception
	 */
	public abstract void process(String name, Object value, IFieldWidget box) throws Exception;
	
	/**
	 * True if value required (slower). false by default.
	 * @return
	 */
	public boolean requireValue() {
		return false;
	}
}
