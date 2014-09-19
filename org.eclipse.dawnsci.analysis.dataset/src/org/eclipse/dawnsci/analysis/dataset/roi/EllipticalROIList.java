/*
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.dataset.roi;

import java.util.ArrayList;

import org.eclipse.dawnsci.analysis.api.roi.IROI;


/**
 * Wrapper for a list of elliptical ROIs
 */
public class EllipticalROIList extends ArrayList<EllipticalROI> implements ROIList<EllipticalROI> {

	@Override
	public boolean add(IROI roi) {
		if (roi instanceof EllipticalROI)
			return super.add((EllipticalROI) roi);
		return false;
	}

	@Override
	public boolean append(EllipticalROI roi) {
		return super.add(roi);
	}
}
