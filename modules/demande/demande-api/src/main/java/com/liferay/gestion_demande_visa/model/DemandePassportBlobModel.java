/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.gestion_demande_visa.model;

import java.sql.Blob;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The Blob model class for lazy loading the passport column in Demande.
 *
 * @author Brian Wing Shun Chan
 * @see Demande
 * @generated
 */
@ProviderType
public class DemandePassportBlobModel {

	public DemandePassportBlobModel() {
	}

	public DemandePassportBlobModel(long demandeId) {
		_demandeId = demandeId;
	}

	public DemandePassportBlobModel(long demandeId, Blob passportBlob) {
		_demandeId = demandeId;
		_passportBlob = passportBlob;
	}

	public long getDemandeId() {
		return _demandeId;
	}

	public void setDemandeId(long demandeId) {
		_demandeId = demandeId;
	}

	public Blob getPassportBlob() {
		return _passportBlob;
	}

	public void setPassportBlob(Blob passportBlob) {
		_passportBlob = passportBlob;
	}

	private long _demandeId;
	private Blob _passportBlob;

}