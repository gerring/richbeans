/*-
 * Copyright © 2016 Diamond Light Source Ltd.
 *
 * This file is part of GDA.
 *
 * GDA is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License version 3 as published by the Free
 * Software Foundation.
 *
 * GDA is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along
 * with GDA. If not, see <http://www.gnu.org/licenses/>.
 */

package org.eclipse.richbeans.generator.example;

public class SimpleExample extends GuiGeneratorRunnerBase {

	public static void main(String[] args) {
		new SimpleExample().run();
	}

	@Override
	protected Object createTestObject() {
		SimpleBean testBean = new SimpleBean();
		testBean.setName("Read-only name");
		testBean.setDescription("Editable multi-line description");
		testBean.setType(Type.TWO);
		testBean.setCount(4);
		testBean.setX(-5.3); // X is annotated to have a minimum value of zero, so the GUI will mark this as invalid
		testBean.setY(11.8);
		return testBean;
	}
}
