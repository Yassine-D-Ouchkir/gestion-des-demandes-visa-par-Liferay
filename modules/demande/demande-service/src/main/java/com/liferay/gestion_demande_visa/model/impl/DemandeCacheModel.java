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

package com.liferay.gestion_demande_visa.model.impl;

import com.liferay.gestion_demande_visa.model.Demande;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Demande in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class DemandeCacheModel implements CacheModel<Demande>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DemandeCacheModel)) {
			return false;
		}

		DemandeCacheModel demandeCacheModel = (DemandeCacheModel)obj;

		if (demandeId == demandeCacheModel.demandeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, demandeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{demandeId=");
		sb.append(demandeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", destination=");
		sb.append(destination);
		sb.append(", visaType=");
		sb.append(visaType);
		sb.append(", tripDate=");
		sb.append(tripDate);
		sb.append(", tripPurpse=");
		sb.append(tripPurpse);
		sb.append(", stayDuration=");
		sb.append(stayDuration);
		sb.append(", passport=");
		sb.append(passport);
		sb.append(", photo=");
		sb.append(photo);
		sb.append(", flightReservation=");
		sb.append(flightReservation);
		sb.append(", statue=");
		sb.append(statue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Demande toEntityModel() {
		DemandeImpl demandeImpl = new DemandeImpl();

		demandeImpl.setDemandeId(demandeId);
		demandeImpl.setGroupId(groupId);
		demandeImpl.setCompanyId(companyId);
		demandeImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			demandeImpl.setCreateDate(null);
		}
		else {
			demandeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			demandeImpl.setModifiedDate(null);
		}
		else {
			demandeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (destination == null) {
			demandeImpl.setDestination("");
		}
		else {
			demandeImpl.setDestination(destination);
		}

		if (visaType == null) {
			demandeImpl.setVisaType("");
		}
		else {
			demandeImpl.setVisaType(visaType);
		}

		if (tripDate == Long.MIN_VALUE) {
			demandeImpl.setTripDate(null);
		}
		else {
			demandeImpl.setTripDate(new Date(tripDate));
		}

		if (tripPurpse == null) {
			demandeImpl.setTripPurpse("");
		}
		else {
			demandeImpl.setTripPurpse(tripPurpse);
		}

		if (stayDuration == null) {
			demandeImpl.setStayDuration("");
		}
		else {
			demandeImpl.setStayDuration(stayDuration);
		}

		demandeImpl.setPassport(passport);
		demandeImpl.setPhoto(photo);
		demandeImpl.setFlightReservation(flightReservation);

		if (statue == null) {
			demandeImpl.setStatue("");
		}
		else {
			demandeImpl.setStatue(statue);
		}

		demandeImpl.resetOriginalValues();

		return demandeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		demandeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		destination = objectInput.readUTF();
		visaType = objectInput.readUTF();
		tripDate = objectInput.readLong();
		tripPurpse = objectInput.readUTF();
		stayDuration = objectInput.readUTF();

		passport = objectInput.readLong();

		photo = objectInput.readLong();

		flightReservation = objectInput.readLong();
		statue = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(demandeId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (destination == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(destination);
		}

		if (visaType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(visaType);
		}

		objectOutput.writeLong(tripDate);

		if (tripPurpse == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tripPurpse);
		}

		if (stayDuration == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stayDuration);
		}

		objectOutput.writeLong(passport);

		objectOutput.writeLong(photo);

		objectOutput.writeLong(flightReservation);

		if (statue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statue);
		}
	}

	public long demandeId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String destination;
	public String visaType;
	public long tripDate;
	public String tripPurpse;
	public String stayDuration;
	public long passport;
	public long photo;
	public long flightReservation;
	public String statue;

}