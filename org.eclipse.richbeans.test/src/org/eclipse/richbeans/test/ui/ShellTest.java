/*-
 *******************************************************************************
 * Copyright (c) 2011, 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthew Gerring - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.richbeans.test.ui;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * 
 * Test which starts a static system for creating shells from the current display
 * 
 * @author Matthew Gerring
 *
 */
public abstract class ShellTest {

	private static TestUI testUI;
	
	@BeforeClass
	public static void startUI() {
		testUI = new TestUI();
		testUI.start();
	}
	
	@AfterClass
	public static void stopUI() {
		testUI.stop();
	}

	@Before
	public void setup() throws InterruptedException, BrokenBarrierException {
		testUI.createBot(this);
	}

	@After
	public void teardown() throws InterruptedException {
		testUI.disposeBot(this);
	}

	/**
	 * Override to create the shell. The calling thread is the thread used for the UI
	 * in this test. Called once per test class.
	 */
	protected abstract Shell createShell(Display display) throws Exception;

	
	protected SWTBot bot;
	public SWTBot getBot() {
		return bot;
	}

	public void setBot(SWTBot bot) {
		this.bot = bot;
	}


	public interface RunnableWithErrorAndValue<T> {
		T run() throws Exception;
	}
	protected <T> T synchExec(RunnableWithErrorAndValue<T> func) throws Exception {
		
		final List<Exception> errors = new ArrayList<>(1);
		final List<T> result = new ArrayList<>(1);
		bot.getDisplay().syncExec(()->{
			try {
				result.add(func.run());
			} catch (Exception ne) {
				errors.add(ne);
			}
		});
		if (!errors.isEmpty()) throw errors.get(0);
		return (!result.isEmpty()) ? result.get(0) : null;
	}
	
	
	public interface RunnableWithError {
		void run() throws Exception;
	}
	protected void synchExec(RunnableWithError func) throws Exception {
		
		final List<Exception> errors = new ArrayList<>(1);
		bot.getDisplay().syncExec(()->{
			try {
			    func.run();
			} catch (Exception ne) {
				errors.add(ne);
			}
		});
		if (!errors.isEmpty()) throw errors.get(0);
	}

}