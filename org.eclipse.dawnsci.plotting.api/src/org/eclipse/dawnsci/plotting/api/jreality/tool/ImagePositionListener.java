/*
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.plotting.api.jreality.tool;

import java.util.EventListener;

/**
 * ImagePositionListener listens to mouse dragging inside the image to notify
 * interested parties of the current position of the mouse cursor inside the
 * image.
 */
public interface ImagePositionListener extends EventListener {

	/**
	 * Image position start
	 * @param event ImagePositionEvent object
	 */
	public void imageStart(IImagePositionEvent event);
	
	/**
	 * Image position while dragging
	 * @param event ImagePositionEvent object
	 */
	public void imageDragged(IImagePositionEvent event);
	
	/**
	 * Image position finished
	 * @param event ImagePositionEvent object
	 */
	public void imageFinished(IImagePositionEvent event);
	
}
