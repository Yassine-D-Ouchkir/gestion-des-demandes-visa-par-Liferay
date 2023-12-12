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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Demande}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Demande
 * @generated
 */
@ProviderType
public class DemandeWrapper
	extends BaseModelWrapper<Demande>
	implements Demande, ModelWrapper<Demande> {

	public DemandeWrapper(Demande demande) {
		super(demande);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("demandeId", getDemandeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("destination", getDestination());
		attributes.put("visaType", getVisaType());
		attributes.put("tripDate", getTripDate());
		attributes.put("tripPurpse", getTripPurpse());
		attributes.put("stayDuration", getStayDuration());
		attributes.put("passport", getPassport());
		attributes.put("photo", getPhoto());
		attributes.put("flightReservation", getFlightReservation());
		attributes.put("statue", getStatue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long demandeId = (Long)attributes.get("demandeId");

		if (demandeId != null) {
			setDemandeId(demandeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String destination = (String)attributes.get("destination");

		if (destination != null) {
			setDestination(destination);
		}

		String visaType = (String)attributes.get("visaType");

		if (visaType != null) {
			setVisaType(visaType);
		}

		Date tripDate = (Date)attributes.get("tripDate");

		if (tripDate != null) {
			setTripDate(tripDate);
		}

		String tripPurpse = (String)attributes.get("tripPurpse");

		if (tripPurpse != null) {
			setTripPurpse(tripPurpse);
		}

		String stayDuration = (String)attributes.get("stayDuration");

		if (stayDuration != null) {
			setStayDuration(stayDuration);
		}

		Long passport = (Long)attributes.get("passport");

		if (passport != null) {
			setPassport(passport);
		}

		Long photo = (Long)attributes.get("photo");

		if (photo != null) {
			setPhoto(photo);
		}

		Long flightReservation = (Long)attributes.get("flightReservation");

		if (flightReservation != null) {
			setFlightReservation(flightReservation);
		}

		String statue = (String)attributes.get("statue");

		if (statue != null) {
			setStatue(statue);
		}
	}

	/**
	 * Returns the company ID of this demande.
	 *
	 * @return the company ID of this demande
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this demande.
	 *
	 * @return the create date of this demande
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the demande ID of this demande.
	 *
	 * @return the demande ID of this demande
	 */
	@Override
	public long getDemandeId() {
		return model.getDemandeId();
	}

	/**
	 * Returns the destination of this demande.
	 *
	 * @return the destination of this demande
	 */
	@Override
	public String getDestination() {
		return model.getDestination();
	}

	/**
	 * Returns the flight reservation of this demande.
	 *
	 * @return the flight reservation of this demande
	 */
	@Override
	public long getFlightReservation() {
		return model.getFlightReservation();
	}

	/**
	 * Returns the group ID of this demande.
	 *
	 * @return the group ID of this demande
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this demande.
	 *
	 * @return the modified date of this demande
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the passport of this demande.
	 *
	 * @return the passport of this demande
	 */
	@Override
	public long getPassport() {
		return model.getPassport();
	}

	/**
	 * Returns the photo of this demande.
	 *
	 * @return the photo of this demande
	 */
	@Override
	public long getPhoto() {
		return model.getPhoto();
	}

	/**
	 * Returns the primary key of this demande.
	 *
	 * @return the primary key of this demande
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the statue of this demande.
	 *
	 * @return the statue of this demande
	 */
	@Override
	public String getStatue() {
		return model.getStatue();
	}

	/**
	 * Returns the stay duration of this demande.
	 *
	 * @return the stay duration of this demande
	 */
	@Override
	public String getStayDuration() {
		return model.getStayDuration();
	}

	/**
	 * Returns the trip date of this demande.
	 *
	 * @return the trip date of this demande
	 */
	@Override
	public Date getTripDate() {
		return model.getTripDate();
	}

	/**
	 * Returns the trip purpse of this demande.
	 *
	 * @return the trip purpse of this demande
	 */
	@Override
	public String getTripPurpse() {
		return model.getTripPurpse();
	}

	/**
	 * Returns the user ID of this demande.
	 *
	 * @return the user ID of this demande
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this demande.
	 *
	 * @return the user uuid of this demande
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the visa type of this demande.
	 *
	 * @return the visa type of this demande
	 */
	@Override
	public String getVisaType() {
		return model.getVisaType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this demande.
	 *
	 * @param companyId the company ID of this demande
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this demande.
	 *
	 * @param createDate the create date of this demande
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the demande ID of this demande.
	 *
	 * @param demandeId the demande ID of this demande
	 */
	@Override
	public void setDemandeId(long demandeId) {
		model.setDemandeId(demandeId);
	}

	/**
	 * Sets the destination of this demande.
	 *
	 * @param destination the destination of this demande
	 */
	@Override
	public void setDestination(String destination) {
		model.setDestination(destination);
	}

	/**
	 * Sets the flight reservation of this demande.
	 *
	 * @param flightReservation the flight reservation of this demande
	 */
	@Override
	public void setFlightReservation(long flightReservation) {
		model.setFlightReservation(flightReservation);
	}

	/**
	 * Sets the group ID of this demande.
	 *
	 * @param groupId the group ID of this demande
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this demande.
	 *
	 * @param modifiedDate the modified date of this demande
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the passport of this demande.
	 *
	 * @param passport the passport of this demande
	 */
	@Override
	public void setPassport(long passport) {
		model.setPassport(passport);
	}

	/**
	 * Sets the photo of this demande.
	 *
	 * @param photo the photo of this demande
	 */
	@Override
	public void setPhoto(long photo) {
		model.setPhoto(photo);
	}

	/**
	 * Sets the primary key of this demande.
	 *
	 * @param primaryKey the primary key of this demande
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the statue of this demande.
	 *
	 * @param statue the statue of this demande
	 */
	@Override
	public void setStatue(String statue) {
		model.setStatue(statue);
	}

	/**
	 * Sets the stay duration of this demande.
	 *
	 * @param stayDuration the stay duration of this demande
	 */
	@Override
	public void setStayDuration(String stayDuration) {
		model.setStayDuration(stayDuration);
	}

	/**
	 * Sets the trip date of this demande.
	 *
	 * @param tripDate the trip date of this demande
	 */
	@Override
	public void setTripDate(Date tripDate) {
		model.setTripDate(tripDate);
	}

	/**
	 * Sets the trip purpse of this demande.
	 *
	 * @param tripPurpse the trip purpse of this demande
	 */
	@Override
	public void setTripPurpse(String tripPurpse) {
		model.setTripPurpse(tripPurpse);
	}

	/**
	 * Sets the user ID of this demande.
	 *
	 * @param userId the user ID of this demande
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this demande.
	 *
	 * @param userUuid the user uuid of this demande
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the visa type of this demande.
	 *
	 * @param visaType the visa type of this demande
	 */
	@Override
	public void setVisaType(String visaType) {
		model.setVisaType(visaType);
	}

	@Override
	protected DemandeWrapper wrap(Demande demande) {
		return new DemandeWrapper(demande);
	}

}