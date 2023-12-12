package com.liferay.gestion_demande_visa.portlet.notification.demandeConfirmation;

import com.liferay.gestion_demande_visa.constants.DemandeAdminTablePortletKeys;
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
		  property = {"javax.portlet.name=" + DemandeAdminTablePortletKeys.DEMANDEADMINTABLE},
		  service = UserNotificationHandler.class
		)
public class ConfirmDemandeNotificationHandler extends BaseUserNotificationHandler{
	public static final String PORTLET_ID = DemandeAdminTablePortletKeys.DEMANDEADMINTABLE;
	  private static final String _BODY_TEMPLATE = "<div class=\"title\">[$TITLE$]</div><div class=\"body\">[$BODY$]</div>";
	  private static final String[] _BODY_REPLACEMENTS = new String[] {"[$TITLE$]", "[$BODY$]"};
	
	public ConfirmDemandeNotificationHandler() {
		// TODO Auto-generated constructor stub
		setPortletId(PORTLET_ID);
	}
	
	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {
		// TODO Auto-generated method stub
		JSONObject payload=JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		String html = StringUtil.replace(_BODY_TEMPLATE, _BODY_REPLACEMENTS, new String[] {
				"Confirmation de demande", "Votre demande a ete "+payload.getString("status")+", consulter 'demande visa -> vos demandes' pour plus de detail "
				});
		return html;
	}
	
	
}
