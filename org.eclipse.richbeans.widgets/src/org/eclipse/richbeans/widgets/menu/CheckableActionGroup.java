/*
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.eclipse.richbeans.widgets.menu;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

/**
 * Class behaves like swing ButtonGroup because I 
 * could not find a jface class for this. Probably
 * because Actions are not very commonly uses and
 * actions are configured via the plugin.xml
 */
public class CheckableActionGroup implements IPropertyChangeListener {

	private Collection<IAction> actions = new ArrayList<IAction>(7);
	
	public void add(IAction action) {
		action.addPropertyChangeListener(this);
		actions.add(action);
	}

	private boolean off = false;
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (off) return;
		try {
			off = true;
			final Action action = (Action)event.getSource();
			final Collection<IAction> others = new ArrayList<IAction>(actions);
			others.remove(action);
			action.setChecked(true);
			for (IAction other : others) other.setChecked(false);
		} finally {
			off = false;
		}
	}
	
	public void clear() {
		for (IAction action : actions) {
			action.removePropertyChangeListener(this);
		}
		actions.clear();
	}
}
