/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.manageaccounts.api.impl;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.manageaccounts.api.ManageAccountsService;
import org.openmrs.module.manageaccounts.api.db.ManageAccountsDAO;

/**
 * It is a default implementation of {@link ManageAccountsService}.
 */
public class ManageAccountsServiceImpl extends BaseOpenmrsService implements ManageAccountsService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private ManageAccountsDAO dao;
	
	/**
     * @param dao the dao to set
     */
    public void setDao(ManageAccountsDAO dao) {
	    this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public ManageAccountsDAO getDao() {
	    return dao;
    }
}