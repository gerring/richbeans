/*
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.plotting.api.jreality.overlay.objects;

import org.eclipse.dawnsci.plotting.api.jreality.overlay.Overlay1DProvider;
import org.eclipse.dawnsci.plotting.api.jreality.overlay.Overlay2DProvider;
import org.eclipse.dawnsci.plotting.api.jreality.overlay.OverlayProvider;

/**
 *
 */
public class LineObject extends OverlayObject {

	private double sx,sy,ex,ey;
	
	public LineObject(int primID, OverlayProvider provider) {
		super(primID, provider);
	}
	
	public void setLinePoints(double sx,  double sy, double ex, double ey) {
		this.sx = sx;
		this.ex = ex;
		this.sy = sy;
		this.ey = ey;
	}
	
	public void setLineStart(double sx, double sy) {
		this.sx = sx;
		this.sy = sy;
	}
	
	public void setLineEnd(double ex, double ey) {
		this.ex = ex;
		this.ey = ey;
	}

	@Override
	public void draw() {
		if (provider instanceof Overlay1DProvider) {
			((Overlay1DProvider)provider).drawLine(primID, sx, sy, ex, ey);
		} else if (provider instanceof Overlay2DProvider)
			((Overlay2DProvider)provider).drawLine(primID, sx, sy, ex, ey);
	}
}
