package com.liferay.gestion_demande_visa.portlet.notification.demandeConfirmation;

import com.liferay.gestion_demande_visa.constants.DemandeAdminTablePortletKeys;
import com.liferay.gestion_demande_visa.constants.DemandeWebPortletKeys;
import com.liferay.gestion_demande_visa.portlet.DemandeAdminTablePortlet;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.notifications.UserNotificationDefinition;
import com.liferay.portal.kernel.notifications.UserNotificationDeliveryType;

import org.osgi.service.component.annotations.Component;

@Component(
		  immediate = true,
		  property = {"javax.portlet.name=" + DemandeAdminTablePortletKeys.DEMANDEADMINTABLE},
		  service = UserNotificationDefinition.class
		)
public class ConfirmDemandeNotificationDefinition extends UserNotificationDefinition{

	public ConfirmDemandeNotificationDefinition() {
		super(DemandeAdminTablePortletKeys.DEMANDEADMINTABLE, 0, 10, "receive notification when an admin confirm user's demande");
		// TODO Auto-generated constructor stub
		addUserNotificationDeliveryType(
			      new UserNotificationDeliveryType(
			        "website", UserNotificationDeliveryConstants.TYPE_WEBSITE, true, true));
	}

}
