package com.liferay.gestion_demande_visa.portlet.notification.add_demande_notification;

import com.liferay.gestion_demande_visa.constants.DemandeWebPortletKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringUtil;

import org.osgi.service.component.annotations.Component;

@Component(
		  immediate = true,
		  property = {"javax.portlet.name=" + DemandeWebPortletKeys.DEMANDEWEB},
		  service = UserNotificationHandler.class
		)
public class AddDemandeNotificationHandler extends BaseUserNotificationHandler{
	public static final String PORTLET_ID = DemandeWebPortletKeys.DEMANDEWEB;
	  private static final String _BODY_TEMPLATE = "<div class=\"title\">[$TITLE$]</div><div class=\"body\">[$BODY$]</div>";
	  private static final String[] _BODY_REPLACEMENTS = new String[] {"[$TITLE$]", "[$BODY$]"};
	
	public AddDemandeNotificationHandler() {
		// TODO Auto-generated constructor stub
		setPortletId(DemandeWebPortletKeys.DEMANDEWEB);
	}
	
	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {
		// TODO Auto-generated method stub
		JSONObject payload=JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		String html = StringUtil.replace(_BODY_TEMPLATE, _BODY_REPLACEMENTS, new String[] {
				"Nouvelle demande de visa", "Une nouvelle demande de visa a ete ajouter par "+payload.getString("nom")+" "+payload.getString("prenom")+", merci de traiter la demande"
				});
		return html;
	}
	
	
}
