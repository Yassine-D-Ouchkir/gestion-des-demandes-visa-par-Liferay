package com.liferay.gestion_demande_visa.portlet.notification.add_demande_notification;

import com.liferay.gestion_demande_visa.constants.DemandeWebPortletKeys;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.notifications.UserNotificationDefinition;
import com.liferay.portal.kernel.notifications.UserNotificationDeliveryType;

import org.osgi.service.component.annotations.Component;

@Component(
		  immediate = true,
		  property = {"javax.portlet.name=" + DemandeWebPortletKeys.DEMANDEWEB},
		  service = UserNotificationDefinition.class
		)
public class AddDemandeNotificationDefinition extends UserNotificationDefinition{

	public AddDemandeNotificationDefinition() {
		super(DemandeWebPortletKeys.DEMANDEWEB, 0, 10, "receive notification when add new demande");
		// TODO Auto-generated constructor stub
		addUserNotificationDeliveryType(
			      new UserNotificationDeliveryType(
			        "website", UserNotificationDeliveryConstants.TYPE_WEBSITE, true, true));
	}

}
