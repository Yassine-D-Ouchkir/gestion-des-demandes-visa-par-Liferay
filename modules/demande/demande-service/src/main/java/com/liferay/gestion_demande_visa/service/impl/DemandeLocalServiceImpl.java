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

package com.liferay.gestion_demande_visa.service.impl;

import com.liferay.gestion_demande_visa.model.Demande;
import com.liferay.gestion_demande_visa.service.base.DemandeLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the demande local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.gestion_demande_visa.service.DemandeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DemandeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.gestion_demande_visa.model.Demande",
	service = AopService.class
)
public class DemandeLocalServiceImpl extends DemandeLocalServiceBaseImpl {
	@Reference
	private UserLocalService uls;
	
    public Collection<Demande> getDemandesByGroupId(long groupId) {
        return demandePersistence.findByGroupId(groupId);
    }

    public Demande getDemandeByDemandeId(long demandeId) {
        return demandePersistence.fetchByPrimaryKey(demandeId);
    }
    public List<Demande> getDemandes(){
    	
		return demandePersistence.findAll();
    	
    }

    
    public Demande addDemande(
        long groupId, long companyId, long userId,
        Date createDate, Date modifiedDate,String destination, String visaType, Date tripDate, String tripPurpse, String stayDuration,
        long passport, long photo, long flightReservation) throws PortalException {

        long demandeId = counterLocalService.increment(Demande.class.getName());
        User usr=uls.getUser(userId);
        Demande demande = createDemande(demandeId);

        demande.setGroupId(groupId);
        demande.setCompanyId(companyId);
        demande.setUserId(userId);
        demande.setCreateDate(createDate);
        demande.setModifiedDate(modifiedDate);
        demande.setDestination(destination);
        demande.setVisaType(visaType);
        demande.setTripDate(tripDate);
        demande.setTripPurpse(tripPurpse);
        demande.setStayDuration(stayDuration);
        demande.setStatue("en attente");
     // Save the uploaded files to a folder in the server
        
        demande.setPassport(passport);
        demande.setPhoto(photo);
        demande.setFlightReservation(flightReservation);

        // Save the entity with persistence
        demande = super.addDemande(demande);

        return demande;
    }
    public Demande addDemande() {
    	long demandeId = counterLocalService.increment(Demande.class.getName());
    	Demande demande = createDemande(demandeId);
    	demande = super.addDemande(demande);
        return demande;	
    }
    
    
    
    public Demande updateDemande(
    		long demandeId,long groupId, long companyId, long userId,
            Date createDate, Date modifiedDate, String destination, String visaType, Date tripDate, String tripPurpse, String stayDuration,
            long passport, long photo, long flightReservation) throws PortalException {

            Demande demande = getDemande(demandeId);
            demande.setGroupId(groupId);
            demande.setCompanyId(companyId);
            demande.setUserId(userId);
            demande.setCreateDate(createDate);
            demande.setModifiedDate(modifiedDate);
            demande.setDestination(destination);
            demande.setVisaType(visaType);
            demande.setTripDate(tripDate);
            demande.setTripPurpse(tripPurpse);
            demande.setStayDuration(stayDuration);
            demande.setStatue("encours");
         // Save the uploaded files to a folder in the server
            
            demande.setPassport(passport);
            demande.setPhoto(photo);
            demande.setFlightReservation(flightReservation);
           

            return super.updateDemande(demande);
        }

    public Demande deleteDemande(long demandeId) throws PortalException {
        Demande demande = getDemande(demandeId);

        return super.deleteDemande(demande);
    }
    public List<Demande> getDemandesByUserId(long userId,int start,int end){
    	return demandePersistence.findByuserId(userId, start, end);
    }
    
    @Override
    public List<Demande> getDemandes(int start, int end) {
        return demandePersistence.findAll(start, end);
    }

    @Override
    public int getDemandesCount() {
        return demandePersistence.countAll();
    }
    public int getDemandeCountByUserId(long userId) {
    	return demandePersistence.countByuserId(userId);
    }
    public int getDemandeCountByStatue(String statue) {
    	return demandePersistence.countBystatue(statue);
    }
    
    public List<Demande> getDemandeByStatue(String statue,int start, int end){
    	return demandePersistence.findBystatue(statue, start, end);
    }
  

    
    
}