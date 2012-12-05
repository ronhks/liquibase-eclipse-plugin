/**
 * Copyright 2012 Nick Wilson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.svcdelivery.liquibase.eclipse.internal.ui;

import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * @author nick
 */
public class RollbackSummaryPage extends WizardPage implements CompleteListener {

	/**
	 * Change set items.
	 */
	private List<ChangeSetTreeItem> items;

	/**
	 * Constructor.
	 * 
	 * @param changeSetItems
	 *            Change set items.
	 */
	protected RollbackSummaryPage(final List<ChangeSetTreeItem> changeSetItems) {
		super("Rollback Summary");
		setTitle("Rollback Summary");
		setMessage("Click Finish to apply the rollbacks.");
		items = changeSetItems;
		setPageComplete(false);
	}

	/**
	 * @param parent
	 *            The parent composite.
	 * @see org.eclipse.jface.dialogs.IDialogPage
	 *      #createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public final void createControl(final Composite parent) {
		final Composite root = new Composite(parent, SWT.NONE);
		root.setLayout(new FillLayout());
		ChangeSetTable cst = new ChangeSetTable(root, SWT.NONE);
		cst.addCompletelistener(this);
		cst.setInput(items);
		setControl(root);
	}

	@Override
	public final void complete(final boolean isComplete) {
		setPageComplete(isComplete);
	}

}