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

package com.liferay.gestion_demande_visa.service.persistence.impl;

import com.liferay.gestion_demande_visa.exception.NoSuchDemandeException;
import com.liferay.gestion_demande_visa.model.Demande;
import com.liferay.gestion_demande_visa.model.impl.DemandeImpl;
import com.liferay.gestion_demande_visa.model.impl.DemandeModelImpl;
import com.liferay.gestion_demande_visa.service.persistence.DemandePersistence;
import com.liferay.gestion_demande_visa.service.persistence.impl.constants.GDVPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the demande service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DemandePersistence.class)
@ProviderType
public class DemandePersistenceImpl
	extends BasePersistenceImpl<Demande> implements DemandePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DemandeUtil</code> to access the demande persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DemandeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the demandes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching demandes
	 */
	@Override
	public List<Demande> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Demande> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Demande> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Demande> orderByComparator, boolean useFinderCache) {

		return findByGroupId(groupId, start, end, orderByComparator);
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
	@Override
	public List<Demande> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Demande> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGroupId;
			finderArgs = new Object[] {groupId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Demande> list = (List<Demande>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Demande demande : list) {
				if ((groupId != demande.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DEMANDE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DemandeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Demande>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Demande>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first demande in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	@Override
	public Demande findByGroupId_First(
			long groupId, OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException {

		Demande demande = fetchByGroupId_First(groupId, orderByComparator);

		if (demande != null) {
			return demande;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchDemandeException(msg.toString());
	}

	/**
	 * Returns the first demande in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande, or <code>null</code> if a matching demande could not be found
	 */
	@Override
	public Demande fetchByGroupId_First(
		long groupId, OrderByComparator<Demande> orderByComparator) {

		List<Demande> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last demande in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	@Override
	public Demande findByGroupId_Last(
			long groupId, OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException {

		Demande demande = fetchByGroupId_Last(groupId, orderByComparator);

		if (demande != null) {
			return demande;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchDemandeException(msg.toString());
	}

	/**
	 * Returns the last demande in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande, or <code>null</code> if a matching demande could not be found
	 */
	@Override
	public Demande fetchByGroupId_Last(
		long groupId, OrderByComparator<Demande> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Demande> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Demande[] findByGroupId_PrevAndNext(
			long demandeId, long groupId,
			OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException {

		Demande demande = findByPrimaryKey(demandeId);

		Session session = null;

		try {
			session = openSession();

			Demande[] array = new DemandeImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, demande, groupId, orderByComparator, true);

			array[1] = demande;

			array[2] = getByGroupId_PrevAndNext(
				session, demande, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Demande getByGroupId_PrevAndNext(
		Session session, Demande demande, long groupId,
		OrderByComparator<Demande> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEMANDE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DemandeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(demande)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Demande> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the demandes where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Demande demande :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(demande);
		}
	}

	/**
	 * Returns the number of demandes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching demandes
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DEMANDE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"demande.groupId = ?";

	private FinderPath _finderPathFetchBydemandeId;
	private FinderPath _finderPathCountBydemandeId;

	/**
	 * Returns the demande where demandeId = &#63; or throws a <code>NoSuchDemandeException</code> if it could not be found.
	 *
	 * @param demandeId the demande ID
	 * @return the matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	@Override
	public Demande findBydemandeId(long demandeId)
		throws NoSuchDemandeException {

		Demande demande = fetchBydemandeId(demandeId);

		if (demande == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("demandeId=");
			msg.append(demandeId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDemandeException(msg.toString());
		}

		return demande;
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
	@Override
	public Demande fetchBydemandeId(long demandeId, boolean useFinderCache) {
		return fetchBydemandeId(demandeId);
	}

	/**
	 * Returns the demande where demandeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param demandeId the demande ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching demande, or <code>null</code> if a matching demande could not be found
	 */
	@Override
	public Demande fetchBydemandeId(long demandeId) {
		Object[] finderArgs = new Object[] {demandeId};

		Object result = finderCache.getResult(
			_finderPathFetchBydemandeId, finderArgs, this);

		if (result instanceof Demande) {
			Demande demande = (Demande)result;

			if ((demandeId != demande.getDemandeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DEMANDE_WHERE);

			query.append(_FINDER_COLUMN_DEMANDEID_DEMANDEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(demandeId);

				List<Demande> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchBydemandeId, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DemandePersistenceImpl.fetchBydemandeId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Demande demande = list.get(0);

					result = demande;

					cacheResult(demande);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchBydemandeId, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Demande)result;
		}
	}

	/**
	 * Removes the demande where demandeId = &#63; from the database.
	 *
	 * @param demandeId the demande ID
	 * @return the demande that was removed
	 */
	@Override
	public Demande removeBydemandeId(long demandeId)
		throws NoSuchDemandeException {

		Demande demande = findBydemandeId(demandeId);

		return remove(demande);
	}

	/**
	 * Returns the number of demandes where demandeId = &#63;.
	 *
	 * @param demandeId the demande ID
	 * @return the number of matching demandes
	 */
	@Override
	public int countBydemandeId(long demandeId) {
		FinderPath finderPath = _finderPathCountBydemandeId;

		Object[] finderArgs = new Object[] {demandeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DEMANDE_WHERE);

			query.append(_FINDER_COLUMN_DEMANDEID_DEMANDEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(demandeId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DEMANDEID_DEMANDEID_2 =
		"demande.demandeId = ?";

	private FinderPath _finderPathWithPaginationFindByuserId;
	private FinderPath _finderPathWithoutPaginationFindByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns all the demandes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching demandes
	 */
	@Override
	public List<Demande> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Demande> findByuserId(long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
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
	@Override
	public List<Demande> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Demande> orderByComparator, boolean useFinderCache) {

		return findByuserId(userId, start, end, orderByComparator);
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
	@Override
	public List<Demande> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Demande> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByuserId;
			finderArgs = new Object[] {userId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByuserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<Demande> list = (List<Demande>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Demande demande : list) {
				if ((userId != demande.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DEMANDE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DemandeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Demande>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Demande>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first demande in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	@Override
	public Demande findByuserId_First(
			long userId, OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException {

		Demande demande = fetchByuserId_First(userId, orderByComparator);

		if (demande != null) {
			return demande;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchDemandeException(msg.toString());
	}

	/**
	 * Returns the first demande in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande, or <code>null</code> if a matching demande could not be found
	 */
	@Override
	public Demande fetchByuserId_First(
		long userId, OrderByComparator<Demande> orderByComparator) {

		List<Demande> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last demande in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	@Override
	public Demande findByuserId_Last(
			long userId, OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException {

		Demande demande = fetchByuserId_Last(userId, orderByComparator);

		if (demande != null) {
			return demande;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchDemandeException(msg.toString());
	}

	/**
	 * Returns the last demande in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande, or <code>null</code> if a matching demande could not be found
	 */
	@Override
	public Demande fetchByuserId_Last(
		long userId, OrderByComparator<Demande> orderByComparator) {

		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<Demande> list = findByuserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Demande[] findByuserId_PrevAndNext(
			long demandeId, long userId,
			OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException {

		Demande demande = findByPrimaryKey(demandeId);

		Session session = null;

		try {
			session = openSession();

			Demande[] array = new DemandeImpl[3];

			array[0] = getByuserId_PrevAndNext(
				session, demande, userId, orderByComparator, true);

			array[1] = demande;

			array[2] = getByuserId_PrevAndNext(
				session, demande, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Demande getByuserId_PrevAndNext(
		Session session, Demande demande, long userId,
		OrderByComparator<Demande> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEMANDE_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DemandeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(demande)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Demande> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the demandes where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (Demande demande :
				findByuserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(demande);
		}
	}

	/**
	 * Returns the number of demandes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching demandes
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DEMANDE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"demande.userId = ?";

	private FinderPath _finderPathWithPaginationFindBystatue;
	private FinderPath _finderPathWithoutPaginationFindBystatue;
	private FinderPath _finderPathCountBystatue;

	/**
	 * Returns all the demandes where statue = &#63;.
	 *
	 * @param statue the statue
	 * @return the matching demandes
	 */
	@Override
	public List<Demande> findBystatue(String statue) {
		return findBystatue(statue, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Demande> findBystatue(String statue, int start, int end) {
		return findBystatue(statue, start, end, null);
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
	@Override
	public List<Demande> findBystatue(
		String statue, int start, int end,
		OrderByComparator<Demande> orderByComparator, boolean useFinderCache) {

		return findBystatue(statue, start, end, orderByComparator);
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
	@Override
	public List<Demande> findBystatue(
		String statue, int start, int end,
		OrderByComparator<Demande> orderByComparator) {

		statue = Objects.toString(statue, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBystatue;
			finderArgs = new Object[] {statue};
		}
		else {
			finderPath = _finderPathWithPaginationFindBystatue;
			finderArgs = new Object[] {statue, start, end, orderByComparator};
		}

		List<Demande> list = (List<Demande>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Demande demande : list) {
				if (!statue.equals(demande.getStatue())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DEMANDE_WHERE);

			boolean bindStatue = false;

			if (statue.isEmpty()) {
				query.append(_FINDER_COLUMN_STATUE_STATUE_3);
			}
			else {
				bindStatue = true;

				query.append(_FINDER_COLUMN_STATUE_STATUE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DemandeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatue) {
					qPos.add(statue);
				}

				if (!pagination) {
					list = (List<Demande>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Demande>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first demande in the ordered set where statue = &#63;.
	 *
	 * @param statue the statue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	@Override
	public Demande findBystatue_First(
			String statue, OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException {

		Demande demande = fetchBystatue_First(statue, orderByComparator);

		if (demande != null) {
			return demande;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statue=");
		msg.append(statue);

		msg.append("}");

		throw new NoSuchDemandeException(msg.toString());
	}

	/**
	 * Returns the first demande in the ordered set where statue = &#63;.
	 *
	 * @param statue the statue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demande, or <code>null</code> if a matching demande could not be found
	 */
	@Override
	public Demande fetchBystatue_First(
		String statue, OrderByComparator<Demande> orderByComparator) {

		List<Demande> list = findBystatue(statue, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last demande in the ordered set where statue = &#63;.
	 *
	 * @param statue the statue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande
	 * @throws NoSuchDemandeException if a matching demande could not be found
	 */
	@Override
	public Demande findBystatue_Last(
			String statue, OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException {

		Demande demande = fetchBystatue_Last(statue, orderByComparator);

		if (demande != null) {
			return demande;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statue=");
		msg.append(statue);

		msg.append("}");

		throw new NoSuchDemandeException(msg.toString());
	}

	/**
	 * Returns the last demande in the ordered set where statue = &#63;.
	 *
	 * @param statue the statue
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demande, or <code>null</code> if a matching demande could not be found
	 */
	@Override
	public Demande fetchBystatue_Last(
		String statue, OrderByComparator<Demande> orderByComparator) {

		int count = countBystatue(statue);

		if (count == 0) {
			return null;
		}

		List<Demande> list = findBystatue(
			statue, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Demande[] findBystatue_PrevAndNext(
			long demandeId, String statue,
			OrderByComparator<Demande> orderByComparator)
		throws NoSuchDemandeException {

		statue = Objects.toString(statue, "");

		Demande demande = findByPrimaryKey(demandeId);

		Session session = null;

		try {
			session = openSession();

			Demande[] array = new DemandeImpl[3];

			array[0] = getBystatue_PrevAndNext(
				session, demande, statue, orderByComparator, true);

			array[1] = demande;

			array[2] = getBystatue_PrevAndNext(
				session, demande, statue, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Demande getBystatue_PrevAndNext(
		Session session, Demande demande, String statue,
		OrderByComparator<Demande> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEMANDE_WHERE);

		boolean bindStatue = false;

		if (statue.isEmpty()) {
			query.append(_FINDER_COLUMN_STATUE_STATUE_3);
		}
		else {
			bindStatue = true;

			query.append(_FINDER_COLUMN_STATUE_STATUE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DemandeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatue) {
			qPos.add(statue);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(demande)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Demande> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the demandes where statue = &#63; from the database.
	 *
	 * @param statue the statue
	 */
	@Override
	public void removeBystatue(String statue) {
		for (Demande demande :
				findBystatue(
					statue, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(demande);
		}
	}

	/**
	 * Returns the number of demandes where statue = &#63;.
	 *
	 * @param statue the statue
	 * @return the number of matching demandes
	 */
	@Override
	public int countBystatue(String statue) {
		statue = Objects.toString(statue, "");

		FinderPath finderPath = _finderPathCountBystatue;

		Object[] finderArgs = new Object[] {statue};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DEMANDE_WHERE);

			boolean bindStatue = false;

			if (statue.isEmpty()) {
				query.append(_FINDER_COLUMN_STATUE_STATUE_3);
			}
			else {
				bindStatue = true;

				query.append(_FINDER_COLUMN_STATUE_STATUE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatue) {
					qPos.add(statue);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUE_STATUE_2 =
		"demande.statue = ?";

	private static final String _FINDER_COLUMN_STATUE_STATUE_3 =
		"(demande.statue IS NULL OR demande.statue = '')";

	public DemandePersistenceImpl() {
		setModelClass(Demande.class);

		setModelImplClass(DemandeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the demande in the entity cache if it is enabled.
	 *
	 * @param demande the demande
	 */
	@Override
	public void cacheResult(Demande demande) {
		entityCache.putResult(
			entityCacheEnabled, DemandeImpl.class, demande.getPrimaryKey(),
			demande);

		finderCache.putResult(
			_finderPathFetchBydemandeId, new Object[] {demande.getDemandeId()},
			demande);

		demande.resetOriginalValues();
	}

	/**
	 * Caches the demandes in the entity cache if it is enabled.
	 *
	 * @param demandes the demandes
	 */
	@Override
	public void cacheResult(List<Demande> demandes) {
		for (Demande demande : demandes) {
			if (entityCache.getResult(
					entityCacheEnabled, DemandeImpl.class,
					demande.getPrimaryKey()) == null) {

				cacheResult(demande);
			}
			else {
				demande.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all demandes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DemandeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the demande.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Demande demande) {
		entityCache.removeResult(
			entityCacheEnabled, DemandeImpl.class, demande.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DemandeModelImpl)demande, true);
	}

	@Override
	public void clearCache(List<Demande> demandes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Demande demande : demandes) {
			entityCache.removeResult(
				entityCacheEnabled, DemandeImpl.class, demande.getPrimaryKey());

			clearUniqueFindersCache((DemandeModelImpl)demande, true);
		}
	}

	protected void cacheUniqueFindersCache(DemandeModelImpl demandeModelImpl) {
		Object[] args = new Object[] {demandeModelImpl.getDemandeId()};

		finderCache.putResult(
			_finderPathCountBydemandeId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBydemandeId, args, demandeModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		DemandeModelImpl demandeModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {demandeModelImpl.getDemandeId()};

			finderCache.removeResult(_finderPathCountBydemandeId, args);
			finderCache.removeResult(_finderPathFetchBydemandeId, args);
		}

		if ((demandeModelImpl.getColumnBitmask() &
			 _finderPathFetchBydemandeId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				demandeModelImpl.getOriginalDemandeId()
			};

			finderCache.removeResult(_finderPathCountBydemandeId, args);
			finderCache.removeResult(_finderPathFetchBydemandeId, args);
		}
	}

	/**
	 * Creates a new demande with the primary key. Does not add the demande to the database.
	 *
	 * @param demandeId the primary key for the new demande
	 * @return the new demande
	 */
	@Override
	public Demande create(long demandeId) {
		Demande demande = new DemandeImpl();

		demande.setNew(true);
		demande.setPrimaryKey(demandeId);

		demande.setCompanyId(CompanyThreadLocal.getCompanyId());

		return demande;
	}

	/**
	 * Removes the demande with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param demandeId the primary key of the demande
	 * @return the demande that was removed
	 * @throws NoSuchDemandeException if a demande with the primary key could not be found
	 */
	@Override
	public Demande remove(long demandeId) throws NoSuchDemandeException {
		return remove((Serializable)demandeId);
	}

	/**
	 * Removes the demande with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the demande
	 * @return the demande that was removed
	 * @throws NoSuchDemandeException if a demande with the primary key could not be found
	 */
	@Override
	public Demande remove(Serializable primaryKey)
		throws NoSuchDemandeException {

		Session session = null;

		try {
			session = openSession();

			Demande demande = (Demande)session.get(
				DemandeImpl.class, primaryKey);

			if (demande == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDemandeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(demande);
		}
		catch (NoSuchDemandeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Demande removeImpl(Demande demande) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(demande)) {
				demande = (Demande)session.get(
					DemandeImpl.class, demande.getPrimaryKeyObj());
			}

			if (demande != null) {
				session.delete(demande);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (demande != null) {
			clearCache(demande);
		}

		return demande;
	}

	@Override
	public Demande updateImpl(Demande demande) {
		boolean isNew = demande.isNew();

		if (!(demande instanceof DemandeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(demande.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(demande);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in demande proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Demande implementation " +
					demande.getClass());
		}

		DemandeModelImpl demandeModelImpl = (DemandeModelImpl)demande;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (demande.getCreateDate() == null)) {
			if (serviceContext == null) {
				demande.setCreateDate(now);
			}
			else {
				demande.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!demandeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				demande.setModifiedDate(now);
			}
			else {
				demande.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (demande.isNew()) {
				session.save(demande);

				demande.setNew(false);
			}
			else {
				demande = (Demande)session.merge(demande);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {demandeModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {demandeModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByuserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByuserId, args);

			args = new Object[] {demandeModelImpl.getStatue()};

			finderCache.removeResult(_finderPathCountBystatue, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBystatue, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((demandeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					demandeModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {demandeModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((demandeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByuserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					demandeModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByuserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByuserId, args);

				args = new Object[] {demandeModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByuserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByuserId, args);
			}

			if ((demandeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBystatue.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					demandeModelImpl.getOriginalStatue()
				};

				finderCache.removeResult(_finderPathCountBystatue, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBystatue, args);

				args = new Object[] {demandeModelImpl.getStatue()};

				finderCache.removeResult(_finderPathCountBystatue, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBystatue, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, DemandeImpl.class, demande.getPrimaryKey(),
			demande, false);

		clearUniqueFindersCache(demandeModelImpl, false);
		cacheUniqueFindersCache(demandeModelImpl);

		demande.resetOriginalValues();

		return demande;
	}

	/**
	 * Returns the demande with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the demande
	 * @return the demande
	 * @throws NoSuchDemandeException if a demande with the primary key could not be found
	 */
	@Override
	public Demande findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDemandeException {

		Demande demande = fetchByPrimaryKey(primaryKey);

		if (demande == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDemandeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return demande;
	}

	/**
	 * Returns the demande with the primary key or throws a <code>NoSuchDemandeException</code> if it could not be found.
	 *
	 * @param demandeId the primary key of the demande
	 * @return the demande
	 * @throws NoSuchDemandeException if a demande with the primary key could not be found
	 */
	@Override
	public Demande findByPrimaryKey(long demandeId)
		throws NoSuchDemandeException {

		return findByPrimaryKey((Serializable)demandeId);
	}

	/**
	 * Returns the demande with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param demandeId the primary key of the demande
	 * @return the demande, or <code>null</code> if a demande with the primary key could not be found
	 */
	@Override
	public Demande fetchByPrimaryKey(long demandeId) {
		return fetchByPrimaryKey((Serializable)demandeId);
	}

	/**
	 * Returns all the demandes.
	 *
	 * @return the demandes
	 */
	@Override
	public List<Demande> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Demande> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Demande> findAll(
		int start, int end, OrderByComparator<Demande> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
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
	@Override
	public List<Demande> findAll(
		int start, int end, OrderByComparator<Demande> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Demande> list = (List<Demande>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DEMANDE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEMANDE;

				if (pagination) {
					sql = sql.concat(DemandeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Demande>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Demande>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the demandes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Demande demande : findAll()) {
			remove(demande);
		}
	}

	/**
	 * Returns the number of demandes.
	 *
	 * @return the number of demandes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DEMANDE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "demandeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DEMANDE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DemandeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the demande persistence.
	 */
	@Activate
	public void activate() {
		DemandeModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		DemandeModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			DemandeModelImpl.GROUPID_COLUMN_BITMASK |
			DemandeModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathFetchBydemandeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DemandeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBydemandeId",
			new String[] {Long.class.getName()},
			DemandeModelImpl.DEMANDEID_COLUMN_BITMASK);

		_finderPathCountBydemandeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydemandeId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByuserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByuserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] {Long.class.getName()},
			DemandeModelImpl.USERID_COLUMN_BITMASK |
			DemandeModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByuserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindBystatue = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatue",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBystatue = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DemandeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatue",
			new String[] {String.class.getName()},
			DemandeModelImpl.STATUE_COLUMN_BITMASK |
			DemandeModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountBystatue = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatue",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DemandeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = GDVPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.gestion_demande_visa.model.Demande"),
			true);
	}

	@Override
	@Reference(
		target = GDVPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = GDVPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DEMANDE =
		"SELECT demande FROM Demande demande";

	private static final String _SQL_SELECT_DEMANDE_WHERE =
		"SELECT demande FROM Demande demande WHERE ";

	private static final String _SQL_COUNT_DEMANDE =
		"SELECT COUNT(demande) FROM Demande demande";

	private static final String _SQL_COUNT_DEMANDE_WHERE =
		"SELECT COUNT(demande) FROM Demande demande WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "demande.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Demande exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Demande exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DemandePersistenceImpl.class);

	static {
		try {
			Class.forName(GDVPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}