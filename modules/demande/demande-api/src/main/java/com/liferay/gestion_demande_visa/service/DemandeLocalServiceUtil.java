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

package com.liferay.gestion_demande_visa.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Demande. This utility wraps
 * <code>com.liferay.gestion_demande_visa.service.impl.DemandeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DemandeLocalService
 * @generated
 */
@ProviderType
public class DemandeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.gestion_demande_visa.service.impl.DemandeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.gestion_demande_visa.model.Demande addDemande() {
		return getService().addDemande();
	}

	/**
	 * Adds the demande to the database. Also notifies the appropriate model listeners.
	 *
	 * @param demande the demande
	 * @return the demande that was added
	 */
	public static com.liferay.gestion_demande_visa.model.Demande addDemande(
		com.liferay.gestion_demande_visa.model.Demande demande) {

		return getService().addDemande(demande);
	}

	public static com.liferay.gestion_demande_visa.model.Demande addDemande(
			long groupId, long companyId, long userId,
			java.util.Date createDate, java.util.Date modifiedDate,
			String destination, String visaType, java.util.Date tripDate,
			String tripPurpse, String stayDuration, long passport, long photo,
			long flightReservation)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addDemande(
			groupId, companyId, userId, createDate, modifiedDate, destination,
			visaType, tripDate, tripPurpse, stayDuration, passport, photo,
			flightReservation);
	}

	/**
	 * Creates a new demande with the primary key. Does not add the demande to the database.
	 *
	 * @param demandeId the primary key for the new demande
	 * @return the new demande
	 */
	public static com.liferay.gestion_demande_visa.model.Demande createDemande(
		long demandeId) {

		return getService().createDemande(demandeId);
	}

	/**
	 * Deletes the demande from the database. Also notifies the appropriate model listeners.
	 *
	 * @param demande the demande
	 * @return the demande that was removed
	 */
	public static com.liferay.gestion_demande_visa.model.Demande deleteDemande(
		com.liferay.gestion_demande_visa.model.Demande demande) {

		return getService().deleteDemande(demande);
	}

	/**
	 * Deletes the demande with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param demandeId the primary key of the demande
	 * @return the demande that was removed
	 * @throws PortalException if a demande with the primary key could not be found
	 */
	public static com.liferay.gestion_demande_visa.model.Demande deleteDemande(
			long demandeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDemande(demandeId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.gestion_demande_visa.model.impl.DemandeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.gestion_demande_visa.model.impl.DemandeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.gestion_demande_visa.model.Demande fetchDemande(
		long demandeId) {

		return getService().fetchDemande(demandeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the demande with the primary key.
	 *
	 * @param demandeId the primary key of the demande
	 * @return the demande
	 * @throws PortalException if a demande with the primary key could not be found
	 */
	public static com.liferay.gestion_demande_visa.model.Demande getDemande(
			long demandeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDemande(demandeId);
	}

	public static com.liferay.gestion_demande_visa.model.Demande
		getDemandeByDemandeId(long demandeId) {

		return getService().getDemandeByDemandeId(demandeId);
	}

	public static java.util.List<com.liferay.gestion_demande_visa.model.Demande>
		getDemandeByStatue(String statue, int start, int end) {

		return getService().getDemandeByStatue(statue, start, end);
	}

	public static int getDemandeCountByStatue(String statue) {
		return getService().getDemandeCountByStatue(statue);
	}

	public static int getDemandeCountByUserId(long userId) {
		return getService().getDemandeCountByUserId(userId);
	}

	public static java.util.List<com.liferay.gestion_demande_visa.model.Demande>
		getDemandes() {

		return getService().getDemandes();
	}

	/**
	 * Returns a range of all the demandes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.gestion_demande_visa.model.impl.DemandeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of demandes
	 * @param end the upper bound of the range of demandes (not inclusive)
	 * @return the range of demandes
	 */
	public static java.util.List<com.liferay.gestion_demande_visa.model.Demande>
		getDemandes(int start, int end) {

		return getService().getDemandes(start, end);
	}

	public static java.util.Collection
		<com.liferay.gestion_demande_visa.model.Demande> getDemandesByGroupId(
			long groupId) {

		return getService().getDemandesByGroupId(groupId);
	}

	public static java.util.List<com.liferay.gestion_demande_visa.model.Demande>
		getDemandesByUserId(long userId, int start, int end) {

		return getService().getDemandesByUserId(userId, start, end);
	}

	/**
	 * Returns the number of demandes.
	 *
	 * @return the number of demandes
	 */
	public static int getDemandesCount() {
		return getService().getDemandesCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the demande in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param demande the demande
	 * @return the demande that was updated
	 */
	public static com.liferay.gestion_demande_visa.model.Demande updateDemande(
		com.liferay.gestion_demande_visa.model.Demande demande) {

		return getService().updateDemande(demande);
	}

	public static com.liferay.gestion_demande_visa.model.Demande updateDemande(
			long demandeId, long groupId, long companyId, long userId,
			java.util.Date createDate, java.util.Date modifiedDate,
			String destination, String visaType, java.util.Date tripDate,
			String tripPurpse, String stayDuration, long passport, long photo,
			long flightReservation)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateDemande(
			demandeId, groupId, companyId, userId, createDate, modifiedDate,
			destination, visaType, tripDate, tripPurpse, stayDuration, passport,
			photo, flightReservation);
	}

	public static DemandeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DemandeLocalService, DemandeLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DemandeLocalService.class);

		ServiceTracker<DemandeLocalService, DemandeLocalService>
			serviceTracker =
				new ServiceTracker<DemandeLocalService, DemandeLocalService>(
					bundle.getBundleContext(), DemandeLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}