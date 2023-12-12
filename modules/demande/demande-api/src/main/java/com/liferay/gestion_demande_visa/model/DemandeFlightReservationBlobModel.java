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
 * The Blob model class for lazy loading the flightReservation column in Demande.
 *
 * @author Brian Wing Shun Chan
 * @see Demande
 * @generated
 */
@ProviderType
public class DemandeFlightReservationBlobModel {

	public DemandeFlightReservationBlobModel() {
	}

	public DemandeFlightReservationBlobModel(long demandeId) {
		_demandeId = demandeId;
	}

	public DemandeFlightReservationBlobModel(
		long demandeId, Blob flightReservationBlob) {

		_demandeId = demandeId;
		_flightReservationBlob = flightReservationBlob;
	}

	public long getDemandeId() {
		return _demandeId;
	}

	public void setDemandeId(long demandeId) {
		_demandeId = demandeId;
	}

	public Blob getFlightReservationBlob() {
		return _flightReservationBlob;
	}

	public void setFlightReservationBlob(Blob flightReservationBlob) {
		_flightReservationBlob = flightReservationBlob;
	}

	private long _demandeId;
	private Blob _flightReservationBlob;

}