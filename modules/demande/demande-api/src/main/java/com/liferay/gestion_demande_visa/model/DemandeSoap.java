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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.gestion_demande_visa.service.http.DemandeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class DemandeSoap implements Serializable {

	public static DemandeSoap toSoapModel(Demande model) {
		DemandeSoap soapModel = new DemandeSoap();

		soapModel.setDemandeId(model.getDemandeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDestination(model.getDestination());
		soapModel.setVisaType(model.getVisaType());
		soapModel.setTripDate(model.getTripDate());
		soapModel.setTripPurpse(model.getTripPurpse());
		soapModel.setStayDuration(model.getStayDuration());
		soapModel.setPassport(model.getPassport());
		soapModel.setPhoto(model.getPhoto());
		soapModel.setFlightReservation(model.getFlightReservation());
		soapModel.setStatue(model.getStatue());

		return soapModel;
	}

	public static DemandeSoap[] toSoapModels(Demande[] models) {
		DemandeSoap[] soapModels = new DemandeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DemandeSoap[][] toSoapModels(Demande[][] models) {
		DemandeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DemandeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DemandeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DemandeSoap[] toSoapModels(List<Demande> models) {
		List<DemandeSoap> soapModels = new ArrayList<DemandeSoap>(
			models.size());

		for (Demande model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DemandeSoap[soapModels.size()]);
	}

	public DemandeSoap() {
	}

	public long getPrimaryKey() {
		return _demandeId;
	}

	public void setPrimaryKey(long pk) {
		setDemandeId(pk);
	}

	public long getDemandeId() {
		return _demandeId;
	}

	public void setDemandeId(long demandeId) {
		_demandeId = demandeId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getDestination() {
		return _destination;
	}

	public void setDestination(String destination) {
		_destination = destination;
	}

	public String getVisaType() {
		return _visaType;
	}

	public void setVisaType(String visaType) {
		_visaType = visaType;
	}

	public Date getTripDate() {
		return _tripDate;
	}

	public void setTripDate(Date tripDate) {
		_tripDate = tripDate;
	}

	public String getTripPurpse() {
		return _tripPurpse;
	}

	public void setTripPurpse(String tripPurpse) {
		_tripPurpse = tripPurpse;
	}

	public String getStayDuration() {
		return _stayDuration;
	}

	public void setStayDuration(String stayDuration) {
		_stayDuration = stayDuration;
	}

	public long getPassport() {
		return _passport;
	}

	public void setPassport(long passport) {
		_passport = passport;
	}

	public long getPhoto() {
		return _photo;
	}

	public void setPhoto(long photo) {
		_photo = photo;
	}

	public long getFlightReservation() {
		return _flightReservation;
	}

	public void setFlightReservation(long flightReservation) {
		_flightReservation = flightReservation;
	}

	public String getStatue() {
		return _statue;
	}

	public void setStatue(String statue) {
		_statue = statue;
	}

	private long _demandeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _destination;
	private String _visaType;
	private Date _tripDate;
	private String _tripPurpse;
	private String _stayDuration;
	private long _passport;
	private long _photo;
	private long _flightReservation;
	private String _statue;

}