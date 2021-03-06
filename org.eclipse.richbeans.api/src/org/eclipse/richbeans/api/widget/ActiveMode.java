/*-
 *******************************************************************************
 * Copyright (c) 2011, 2014 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthew Gerring - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.richbeans.api.widget;

/**
 * This enum is used to mark IFieldWidget objects in terms of their behaviour when setActive(...) is called. Most
 * widgets default to SET_VISIBLE_AND_ACTIVE type and are not changeable. Those that are will have an activeMode
 * property in RCP developer.
 */
public enum ActiveMode {
	SET_VISIBLE_AND_ACTIVE,
	SET_ENABLED_AND_ACTIVE,
	ACTIVE_ONLY
}
