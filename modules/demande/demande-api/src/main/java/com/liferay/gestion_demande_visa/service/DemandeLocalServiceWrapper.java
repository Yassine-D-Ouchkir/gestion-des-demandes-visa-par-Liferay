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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link DemandeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DemandeLocalService
 * @generated
 */
@ProviderType
public class DemandeLocalServiceWrapper
	implements DemandeLocalService, ServiceWrapper<DemandeLocalService> {

	public DemandeLocalServiceWrapper(DemandeLocalService demandeLocalService) {
		_demandeLocalService = demandeLocalService;
	}

	@Override
	public com.liferay.gestion_demande_visa.model.Demande addDemande() {
		return _demandeLocalService.addDemande();
	}

	/**
	 * Adds the demande to the database. Also notifies the appropriate model listeners.
	 *
	 * @param demande the demande
	 * @return the demande that was added
	 */
	@Override
	public com.liferay.gestion_demande_visa.model.Demande addDemande(
		com.liferay.gestion_demande_visa.model.Demande demande) {

		return _demandeLocalService.addDemande(demande);
	}

	@Override
	public com.liferay.gestion_demande_visa.model.Demande addDemande(
			long groupId, long companyId, long userId,
			java.util.Date createDate, java.util.Date modifiedDate,
			String destination, String visaType, java.util.Date tripDate,
			String tripPurpse, String stayDuration, long passport, long photo,
			long flightReservation)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _demandeLocalService.addDemande(
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
	@Override
	public com.liferay.gestion_demande_visa.model.Demande createDemande(
		long demandeId) {

		return _demandeLocalService.createDemande(demandeId);
	}

	/**
	 * Deletes the demande from the database. Also notifies the appropriate model listeners.
	 *
	 * @param demande the demande
	 * @return the demande that was removed
	 */
	@Override
	public com.liferay.gestion_demande_visa.model.Demande deleteDemande(
		com.liferay.gestion_demande_visa.model.Demande demande) {

		return _demandeLocalService.deleteDemande(demande);
	}

	/**
	 * Deletes the demande with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param demandeId the primary key of the demande
	 * @return the demande that was removed
	 * @throws PortalException if a demande with the primary key could not be found
	 */
	@Override
	public com.liferay.gestion_demande_visa.model.Demande deleteDemande(
			long demandeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _demandeLocalService.deleteDemande(demandeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _demandeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _demandeLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _demandeLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _demandeLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _demandeLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _demandeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _demandeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.gestion_demande_visa.model.Demande fetchDemande(
		long demandeId) {

		return _demandeLocalService.fetchDemande(demandeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _demandeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the demande with the primary key.
	 *
	 * @param demandeId the primary key of the demande
	 * @return the demande
	 * @throws PortalException if a demande with the primary key could not be found
	 */
	@Override
	public com.liferay.gestion_demande_visa.model.Demande getDemande(
			long demandeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _demandeLocalService.getDemande(demandeId);
	}

	@Override
	public com.liferay.gestion_demande_visa.model.Demande getDemandeByDemandeId(
		long demandeId) {

		return _demandeLocalService.getDemandeByDemandeId(demandeId);
	}

	@Override
	public java.util.List<com.liferay.gestion_demande_visa.model.Demande>
		getDemandeByStatue(String statue, int start, int end) {

		return _demandeLocalService.getDemandeByStatue(statue, start, end);
	}

	@Override
	public int getDemandeCountByStatue(String statue) {
		return _demandeLocalService.getDemandeCountByStatue(statue);
	}

	@Override
	public int getDemandeCountByUserId(long userId) {
		return _demandeLocalService.getDemandeCountByUserId(userId);
	}

	@Override
	public java.util.List<com.liferay.gestion_demande_visa.model.Demande>
		getDemandes() {

		return _demandeLocalService.getDemandes();
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
	@Override
	public java.util.List<com.liferay.gestion_demande_visa.model.Demande>
		getDemandes(int start, int end) {

		return _demandeLocalService.getDemandes(start, end);
	}

	@Override
	public java.util.Collection<com.liferay.gestion_demande_visa.model.Demande>
		getDemandesByGroupId(long groupId) {

		return _demandeLocalService.getDemandesByGroupId(groupId);
	}

	@Override
	public java.util.List<com.liferay.gestion_demande_visa.model.Demande>
		getDemandesByUserId(long userId, int start, int end) {

		return _demandeLocalService.getDemandesByUserId(userId, start, end);
	}

	/**
	 * Returns the number of demandes.
	 *
	 * @return the number of demandes
	 */
	@Override
	public int getDemandesCount() {
		return _demandeLocalService.getDemandesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _demandeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _demandeLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _demandeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the demande in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param demande the demande
	 * @return the demande that was updated
	 */
	@Override
	public com.liferay.gestion_demande_visa.model.Demande updateDemande(
		com.liferay.gestion_demande_visa.model.Demande demande) {

		return _demandeLocalService.updateDemande(demande);
	}

	@Override
	public com.liferay.gestion_demande_visa.model.Demande updateDemande(
			long demandeId, long groupId, long companyId, long userId,
			java.util.Date createDate, java.util.Date modifiedDate,
			String destination, String visaType, java.util.Date tripDate,
			String tripPurpse, String stayDuration, long passport, long photo,
			long flightReservation)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _demandeLocalService.updateDemande(
			demandeId, groupId, companyId, userId, createDate, modifiedDate,
			destination, visaType, tripDate, tripPurpse, stayDuration, passport,
			photo, flightReservation);
	}

	@Override
	public DemandeLocalService getWrappedService() {
		return _demandeLocalService;
	}

	@Override
	public void setWrappedService(DemandeLocalService demandeLocalService) {
		_demandeLocalService = demandeLocalService;
	}

	private DemandeLocalService _demandeLocalService;

}