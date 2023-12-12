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

import com.liferay.gestion_demande_visa.exception.NoSuchDemandeException;
import com.liferay.gestion_demande_visa.model.Demande;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the demande service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DemandeUtil
 * @generated
 */
@ProviderType
public interface DemandePersistence extends BasePersistence<Demande> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DemandeUtil} to access the demande persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the demandes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching demandes
	 */
	public java.util.List<Demande> findByGroupId(long groupId);

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
	public java.util.List<Demande> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Demande> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Demande> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Demande> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Demande> orderByComparator);

	/**
	 * Returns the first demande in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	public Demande findByGroupId_First(
			long groupId, OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException;

	/**
	 * Returns the first demande in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande, or <code>null</code> if a matching demande could not be found
	 */
	public Demande fetchByGroupId_First(
		long groupId, OrderByComparator<Demande> orderByComparator);

	/**
	 * Returns the last demande in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	public Demande findByGroupId_Last(
			long groupId, OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException;

	/**
	 * Returns the last demande in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande, or <code>null</code> if a matching demande could not be found
	 */
	public Demande fetchByGroupId_Last(
		long groupId, OrderByComparator<Demande> orderByComparator);

	/**
	 * Returns the demandes before and after the current demande in the ordered set where groupId = &#63;.
	 *
	 * @param demandeId the primary key of the current demande
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next demande
	 * @throws NoSuchDemandeException if a demande with the primary key could not be found
	 */
	public Demande[] findByGroupId_PrevAndNext(
			long demandeId, long groupId,
			OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException;

	/**
	 * Removes all the demandes where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of demandes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching demandes
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the demande where demandeId = &#63; or throws a <code>NoSuchDemandeException</code> if it could not be found.
	 *
	 * @param demandeId the demande ID
	 * @return the matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	public Demande findBydemandeId(long demandeId)
		throws NoSuchDemandeException;

	/**
	 * Returns the demande where demandeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBydemandeId(long)}
	 * @param demandeId the demande ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching demande, or <code>null</code> if a matching demande could not be found
	 */
	@Deprecated
	public Demande fetchBydemandeId(long demandeId, boolean useFinderCache);

	/**
	 * Returns the demande where demandeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param demandeId the demande ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching demande, or <code>null</code> if a matching demande could not be found
	 */
	public Demande fetchBydemandeId(long demandeId);

	/**
	 * Removes the demande where demandeId = &#63; from the database.
	 *
	 * @param demandeId the demande ID
	 * @return the demande that was removed
	 */
	public Demande removeBydemandeId(long demandeId)
		throws NoSuchDemandeException;

	/**
	 * Returns the number of demandes where demandeId = &#63;.
	 *
	 * @param demandeId the demande ID
	 * @return the number of matching demandes
	 */
	public int countBydemandeId(long demandeId);

	/**
	 * Returns all the demandes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching demandes
	 */
	public java.util.List<Demande> findByuserId(long userId);

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
	public java.util.List<Demande> findByuserId(
		long userId, int start, int end);

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
	public java.util.List<Demande> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Demande> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Demande> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Demande> orderByComparator);

	/**
	 * Returns the first demande in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	public Demande findByuserId_First(
			long userId, OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException;

	/**
	 * Returns the first demande in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande, or <code>null</code> if a matching demande could not be found
	 */
	public Demande fetchByuserId_First(
		long userId, OrderByComparator<Demande> orderByComparator);

	/**
	 * Returns the last demande in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	public Demande findByuserId_Last(
			long userId, OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException;

	/**
	 * Returns the last demande in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande, or <code>null</code> if a matching demande could not be found
	 */
	public Demande fetchByuserId_Last(
		long userId, OrderByComparator<Demande> orderByComparator);

	/**
	 * Returns the demandes before and after the current demande in the ordered set where userId = &#63;.
	 *
	 * @param demandeId the primary key of the current demande
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next demande
	 * @throws NoSuchDemandeException if a demande with the primary key could not be found
	 */
	public Demande[] findByuserId_PrevAndNext(
			long demandeId, long userId,
			OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException;

	/**
	 * Removes all the demandes where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of demandes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching demandes
	 */
	public int countByuserId(long userId);

	/**
	 * Returns all the demandes where statue = &#63;.
	 *
	 * @param statue the statue
	 * @return the matching demandes
	 */
	public java.util.List<Demande> findBystatue(String statue);

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
	public java.util.List<Demande> findBystatue(
		String statue, int start, int end);

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
	public java.util.List<Demande> findBystatue(
		String statue, int start, int end,
		OrderByComparator<Demande> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Demande> findBystatue(
		String statue, int start, int end,
		OrderByComparator<Demande> orderByComparator);

	/**
	 * Returns the first demande in the ordered set where statue = &#63;.
	 *
	 * @param statue the statue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	public Demande findBystatue_First(
			String statue, OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException;

	/**
	 * Returns the first demande in the ordered set where statue = &#63;.
	 *
	 * @param statue the statue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande, or <code>null</code> if a matching demande could not be found
	 */
	public Demande fetchBystatue_First(
		String statue, OrderByComparator<Demande> orderByComparator);

	/**
	 * Returns the last demande in the ordered set where statue = &#63;.
	 *
	 * @param statue the statue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	public Demande findBystatue_Last(
			String statue, OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException;

	/**
	 * Returns the last demande in the ordered set where statue = &#63;.
	 *
	 * @param statue the statue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande, or <code>null</code> if a matching demande could not be found
	 */
	public Demande fetchBystatue_Last(
		String statue, OrderByComparator<Demande> orderByComparator);

	/**
	 * Returns the demandes before and after the current demande in the ordered set where statue = &#63;.
	 *
	 * @param demandeId the primary key of the current demande
	 * @param statue the statue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next demande
	 * @throws NoSuchDemandeException if a demande with the primary key could not be found
	 */
	public Demande[] findBystatue_PrevAndNext(
			long demandeId, String statue,
			OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException;

	/**
	 * Removes all the demandes where statue = &#63; from the database.
	 *
	 * @param statue the statue
	 */
	public void removeBystatue(String statue);

	/**
	 * Returns the number of demandes where statue = &#63;.
	 *
	 * @param statue the statue
	 * @return the number of matching demandes
	 */
	public int countBystatue(String statue);

	/**
	 * Caches the demande in the entity cache if it is enabled.
	 *
	 * @param demande the demande
	 */
	public void cacheResult(Demande demande);

	/**
	 * Caches the demandes in the entity cache if it is enabled.
	 *
	 * @param demandes the demandes
	 */
	public void cacheResult(java.util.List<Demande> demandes);

	/**
	 * Creates a new demande with the primary key. Does not add the demande to the database.
	 *
	 * @param demandeId the primary key for the new demande
	 * @return the new demande
	 */
	public Demande create(long demandeId);

	/**
	 * Removes the demande with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param demandeId the primary key of the demande
	 * @return the demande that was removed
	 * @throws NoSuchDemandeException if a demande with the primary key could not be found
	 */
	public Demande remove(long demandeId) throws NoSuchDemandeException;

	public Demande updateImpl(Demande demande);

	/**
	 * Returns the demande with the primary key or throws a <code>NoSuchDemandeException</code> if it could not be found.
	 *
	 * @param demandeId the primary key of the demande
	 * @return the demande
	 * @throws NoSuchDemandeException if a demande with the primary key could not be found
	 */
	public Demande findByPrimaryKey(long demandeId)
		throws NoSuchDemandeException;

	/**
	 * Returns the demande with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param demandeId the primary key of the demande
	 * @return the demande, or <code>null</code> if a demande with the primary key could not be found
	 */
	public Demande fetchByPrimaryKey(long demandeId);

	/**
	 * Returns all the demandes.
	 *
	 * @return the demandes
	 */
	public java.util.List<Demande> findAll();

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
	public java.util.List<Demande> findAll(int start, int end);

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
	public java.util.List<Demande> findAll(
		int start, int end, OrderByComparator<Demande> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Demande> findAll(
		int start, int end, OrderByComparator<Demande> orderByComparator);

	/**
	 * Removes all the demandes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of demandes.
	 *
	 * @return the number of demandes
	 */
	public int countAll();

}