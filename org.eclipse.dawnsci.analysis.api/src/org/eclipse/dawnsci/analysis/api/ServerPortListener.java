/*
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.api;

import java.util.EventListener;

public interface ServerPortListener extends EventListener {

	/**
	 * Called when the port that the RMIServerProvider has changes.
	 * @param evt
	 */
	public void portAssigned(ServerPortEvent evt);
}
