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

package com.liferay.gestion_demande_visa.service.persistence;

import com.liferay.gestion_demande_visa.model.Demande;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the demande service. This utility wraps <code>com.liferay.gestion_demande_visa.service.persistence.impl.DemandePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DemandePersistence
 * @generated
 */
@ProviderType
public class DemandeUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Demande demande) {
		getPersistence().clearCache(demande);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Demande> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Demande> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Demande> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Demande> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Demande> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Demande update(Demande demande) {
		return getPersistence().update(demande);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Demande update(
		Demande demande, ServiceContext serviceContext) {

		return getPersistence().update(demande, serviceContext);
	}

	/**
	 * Returns all the demandes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching demandes
	 */
	public static List<Demande> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the demandes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DemandeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of demandes
	 * @param end the upper bound of the range of demandes (not inclusive)
	 * @return the range of matching demandes
	 */
	public static List<Demande> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the demandes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DemandeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupId(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of demandes
	 * @param end the upper bound of the range of demandes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching demandes
	 */
	@Deprecated
	public static List<Demande> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Demande> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the demandes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DemandeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of demandes
	 * @param end the upper bound of the range of demandes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching demandes
	 */
	public static List<Demande> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Demande> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the first demande in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	public static Demande findByGroupId_First(
			long groupId, OrderByComparator<Demande> orderByComparator)
		throws com.liferay.gestion_demande_visa.exception.
			NoSuchDemandeException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first demande in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande, or <code>null</code> if a matching demande could not be found
	 */
	public static Demande fetchByGroupId_First(
		long groupId, OrderByComparator<Demande> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last demande in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	public static Demande findByGroupId_Last(
			long groupId, OrderByComparator<Demande> orderByComparator)
		throws com.liferay.gestion_demande_visa.exception.
			NoSuchDemandeException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last demande in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande, or <code>null</code> if a matching demande could not be found
	 */
	public static Demande fetchByGroupId_Last(
		long groupId, OrderByComparator<Demande> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the demandes before and after the current demande in the ordered set where groupId = &#63;.
	 *
	 * @param demandeId the primary key of the current demande
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next demande
	 * @throws NoSuchDemandeException if a demande with the primary key could not be found
	 */
	public static Demande[] findByGroupId_PrevAndNext(
			long demandeId, long groupId,
			OrderByComparator<Demande> orderByComparator)
		throws com.liferay.gestion_demande_visa.exception.
			NoSuchDemandeException {

		return getPersistence().findByGroupId_PrevAndNext(
			demandeId, groupId, orderByComparator);
	}

	/**
	 * Removes all the demandes where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of demandes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching demandes
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the demande where demandeId = &#63; or throws a <code>NoSuchDemandeException</code> if it could not be found.
	 *
	 * @param demandeId the demande ID
	 * @return the matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	public static Demande findBydemandeId(long demandeId)
		throws com.liferay.gestion_demande_visa.exception.
			NoSuchDemandeException {

		return getPersistence().findBydemandeId(demandeId);
	}

	/**
	 * Returns the demande where demandeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBydemandeId(long)}
	 * @param demandeId the demande ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching demande, or <code>null</code> if a matching demande could not be found
	 */
	@Deprecated
	public static Demande fetchBydemandeId(
		long demandeId, boolean useFinderCache) {

		return getPersistence().fetchBydemandeId(demandeId, useFinderCache);
	}

	/**
	 * Returns the demande where demandeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param demandeId the demande ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching demande, or <code>null</code> if a matching demande could not be found
	 */
	public static Demande fetchBydemandeId(long demandeId) {
		return getPersistence().fetchBydemandeId(demandeId);
	}

	/**
	 * Removes the demande where demandeId = &#63; from the database.
	 *
	 * @param demandeId the demande ID
	 * @return the demande that was removed
	 */
	public static Demande removeBydemandeId(long demandeId)
		throws com.liferay.gestion_demande_visa.exception.
			NoSuchDemandeException {

		return getPersistence().removeBydemandeId(demandeId);
	}

	/**
	 * Returns the number of demandes where demandeId = &#63;.
	 *
	 * @param demandeId the demande ID
	 * @return the number of matching demandes
	 */
	public static int countBydemandeId(long demandeId) {
		return getPersistence().countBydemandeId(demandeId);
	}

	/**
	 * Returns all the demandes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching demandes
	 */
	public static List<Demande> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

	/**
	 * Returns a range of all the demandes where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DemandeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of demandes
	 * @param end the upper bound of the range of demandes (not inclusive)
	 * @return the range of matching demandes
	 */
	public static List<Demande> findByuserId(long userId, int start, int end) {
		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the demandes where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DemandeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByuserId(long, int, int, OrderByComparator)}
	 * @param userId the user ID
	 * @param start the lower bound of the range of demandes
	 * @param end the upper bound of the range of demandes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching demandes
	 */
	@Deprecated
	public static List<Demande> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Demande> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the demandes where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DemandeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of demandes
	 * @param end the upper bound of the range of demandes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching demandes
	 */
	public static List<Demande> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Demande> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns the first demande in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	public static Demande findByuserId_First(
			long userId, OrderByComparator<Demande> orderByComparator)
		throws com.liferay.gestion_demande_visa.exception.
			NoSuchDemandeException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first demande in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande, or <code>null</code> if a matching demande could not be found
	 */
	public static Demande fetchByuserId_First(
		long userId, OrderByComparator<Demande> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last demande in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	public static Demande findByuserId_Last(
			long userId, OrderByComparator<Demande> orderByComparator)
		throws com.liferay.gestion_demande_visa.exception.
			NoSuchDemandeException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last demande in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande, or <code>null</code> if a matching demande could not be found
	 */
	public static Demande fetchByuserId_Last(
		long userId, OrderByComparator<Demande> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the demandes before and after the current demande in the ordered set where userId = &#63;.
	 *
	 * @param demandeId the primary key of the current demande
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next demande
	 * @throws NoSuchDemandeException if a demande with the primary key could not be found
	 */
	public static Demande[] findByuserId_PrevAndNext(
			long demandeId, long userId,
			OrderByComparator<Demande> orderByComparator)
		throws com.liferay.gestion_demande_visa.exception.
			NoSuchDemandeException {

		return getPersistence().findByuserId_PrevAndNext(
			demandeId, userId, orderByComparator);
	}

	/**
	 * Removes all the demandes where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of demandes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching demandes
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Returns all the demandes where statue = &#63;.
	 *
	 * @param statue the statue
	 * @return the matching demandes
	 */
	public static List<Demande> findBystatue(String statue) {
		return getPersistence().findBystatue(statue);
	}

	/**
	 * Returns a range of all the demandes where statue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DemandeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param statue the statue
	 * @param start the lower bound of the range of demandes
	 * @param end the upper bound of the range of demandes (not inclusive)
	 * @return the range of matching demandes
	 */
	public static List<Demande> findBystatue(
		String statue, int start, int end) {

		return getPersistence().findBystatue(statue, start, end);
	}

	/**
	 * Returns an ordered range of all the demandes where statue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DemandeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findBystatue(String, int, int, OrderByComparator)}
	 * @param statue the statue
	 * @param start the lower bound of the range of demandes
	 * @param end the upper bound of the range of demandes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching demandes
	 */
	@Deprecated
	public static List<Demande> findBystatue(
		String statue, int start, int end,
		OrderByComparator<Demande> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBystatue(
			statue, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the demandes where statue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DemandeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param statue the statue
	 * @param start the lower bound of the range of demandes
	 * @param end the upper bound of the range of demandes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching demandes
	 */
	public static List<Demande> findBystatue(
		String statue, int start, int end,
		OrderByComparator<Demande> orderByComparator) {

		return getPersistence().findBystatue(
			statue, start, end, orderByComparator);
	}

	/**
	 * Returns the first demande in the ordered set where statue = &#63;.
	 *
	 * @param statue the statue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	public static Demande findBystatue_First(
			String statue, OrderByComparator<Demande> orderByComparator)
		throws com.liferay.gestion_demande_visa.exception.
			NoSuchDemandeException {

		return getPersistence().findBystatue_First(statue, orderByComparator);
	}

	/**
	 * Returns the first demande in the ordered set where statue = &#63;.
	 *
	 * @param statue the statue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande, or <code>null</code> if a matching demande could not be found
	 */
	public static Demande fetchBystatue_First(
		String statue, OrderByComparator<Demande> orderByComparator) {

		return getPersistence().fetchBystatue_First(statue, orderByComparator);
	}

	/**
	 * Returns the last demande in the ordered set where statue = &#63;.
	 *
	 * @param statue the statue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	public static Demande findBystatue_Last(
			String statue, OrderByComparator<Demande> orderByComparator)
		throws com.liferay.gestion_demande_visa.exception.
			NoSuchDemandeException {

		return getPersistence().findBystatue_Last(statue, orderByComparator);
	}

	/**
	 * Returns the last demande in the ordered set where statue = &#63;.
	 *
	 * @param statue the statue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande, or <code>null</code> if a matching demande could not be found
	 */
	public static Demande fetchBystatue_Last(
		String statue, OrderByComparator<Demande> orderByComparator) {

		return getPersistence().fetchBystatue_Last(statue, orderByComparator);
	}

	/**
	 * Returns the demandes before and after the current demande in the ordered set where statue = &#63;.
	 *
	 * @param demandeId the primary key of the current demande
	 * @param statue the statue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next demande
	 * @throws NoSuchDemandeException if a demande with the primary key could not be found
	 */
	public static Demande[] findBystatue_PrevAndNext(
			long demandeId, String statue,
			OrderByComparator<Demande> orderByComparator)
		throws com.liferay.gestion_demande_visa.exception.
			NoSuchDemandeException {

		return getPersistence().findBystatue_PrevAndNext(
			demandeId, statue, orderByComparator);
	}

	/**
	 * Removes all the demandes where statue = &#63; from the database.
	 *
	 * @param statue the statue
	 */
	public static void removeBystatue(String statue) {
		getPersistence().removeBystatue(statue);
	}

	/**
	 * Returns the number of demandes where statue = &#63;.
	 *
	 * @param statue the statue
	 * @return the number of matching demandes
	 */
	public static int countBystatue(String statue) {
		return getPersistence().countBystatue(statue);
	}

	/**
	 * Caches the demande in the entity cache if it is enabled.
	 *
	 * @param demande the demande
	 */
	public static void cacheResult(Demande demande) {
		getPersistence().cacheResult(demande);
	}

	/**
	 * Caches the demandes in the entity cache if it is enabled.
	 *
	 * @param demandes the demandes
	 */
	public static void cacheResult(List<Demande> demandes) {
		getPersistence().cacheResult(demandes);
	}

	/**
	 * Creates a new demande with the primary key. Does not add the demande to the database.
	 *
	 * @param demandeId the primary key for the new demande
	 * @return the new demande
	 */
	public static Demande create(long demandeId) {
		return getPersistence().create(demandeId);
	}

	/**
	 * Removes the demande with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param demandeId the primary key of the demande
	 * @return the demande that was removed
	 * @throws NoSuchDemandeException if a demande with the primary key could not be found
	 */
	public static Demande remove(long demandeId)
		throws com.liferay.gestion_demande_visa.exception.
			NoSuchDemandeException {

		return getPersistence().remove(demandeId);
	}

	public static Demande updateImpl(Demande demande) {
		return getPersistence().updateImpl(demande);
	}

	/**
	 * Returns the demande with the primary key or throws a <code>NoSuchDemandeException</code> if it could not be found.
	 *
	 * @param demandeId the primary key of the demande
	 * @return the demande
	 * @throws NoSuchDemandeException if a demande with the primary key could not be found
	 */
	public static Demande findByPrimaryKey(long demandeId)
		throws com.liferay.gestion_demande_visa.exception.
			NoSuchDemandeException {

		return getPersistence().findByPrimaryKey(demandeId);
	}

	/**
	 * Returns the demande with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param demandeId the primary key of the demande
	 * @return the demande, or <code>null</code> if a demande with the primary key could not be found
	 */
	public static Demande fetchByPrimaryKey(long demandeId) {
		return getPersistence().fetchByPrimaryKey(demandeId);
	}

	/**
	 * Returns all the demandes.
	 *
	 * @return the demandes
	 */
	public static List<Demande> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the demandes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DemandeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of demandes
	 * @param end the upper bound of the range of demandes (not inclusive)
	 * @return the range of demandes
	 */
	public static List<Demande> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the demandes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DemandeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of demandes
	 * @param end the upper bound of the range of demandes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of demandes
	 */
	@Deprecated
	public static List<Demande> findAll(
		int start, int end, OrderByComparator<Demande> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the demandes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DemandeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of demandes
	 * @param end the upper bound of the range of demandes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of demandes
	 */
	public static List<Demande> findAll(
		int start, int end, OrderByComparator<Demande> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the demandes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of demandes.
	 *
	 * @return the number of demandes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DemandePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DemandePersistence, DemandePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DemandePersistence.class);

		ServiceTracker<DemandePersistence, DemandePersistence> serviceTracker =
			new ServiceTracker<DemandePersistence, DemandePersistence>(
				bundle.getBundleContext(), DemandePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}