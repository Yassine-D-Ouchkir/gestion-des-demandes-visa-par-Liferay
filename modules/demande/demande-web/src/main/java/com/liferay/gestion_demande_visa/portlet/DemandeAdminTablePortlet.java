package com.liferay.gestion_demande_visa.portlet;


import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.gestion_demande_visa.constants.DemandeAdminTablePortletKeys;
import com.liferay.gestion_demande_visa.model.Demande;
import com.liferay.gestion_demande_visa.portlet.notification.demandeConfirmation.ConfirmDemandeNotificationHandler;
import com.liferay.gestion_demande_visa.service.DemandeLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"com.liferay.portlet.display-category=category.sample",
				"com.liferay.portlet.header-portlet-css=/css/main.css",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.display-name=DemandeAdminTable",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/demande/demandeAdminTable.jsp",
				"javax.portlet.name="+DemandeAdminTablePortletKeys.DEMANDEADMINTABLE,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user",
				"javax.portlet.supports.mime-type=text/html",
				"mvc.command.name=/traiterDemande"
		},
		service = Portlet.class
	)
public class DemandeAdminTablePortlet extends MVCPortlet {
	@Reference
	DemandeLocalService dls;
	@Reference
	private UserLocalService uls;
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		int curPage = ParamUtil.getInteger(renderRequest, "curPage", 1);
		int itemsPerPage = 10;
		List<Demande> demandes=dls.getDemandeByStatue("encours",(curPage - 1) * itemsPerPage, curPage * itemsPerPage);
		long totalCount = dls.getDemandeCountByStatue("encours");
		renderRequest.setAttribute("demandes", demandes);
		renderRequest.setAttribute("curPage", curPage);
		renderRequest.setAttribute("itemsPerPage", itemsPerPage);
		renderRequest.setAttribute("totalCount", totalCount);
		
		super.render(renderRequest, renderResponse);
		
	}
	
	public void viewDetails(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		System.out.println("in view details");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long demandeId = ParamUtil.getLong(request, "demandeId", 0);
		System.out.println("demande id"+demandeId);
		try {
			Demande demande=dls.getDemande(demandeId);
			System.out.println(demande.getDemandeId());
			Map<String,String> urlMap = getAllFileLink(themeDisplay,demande);
			  request.setAttribute("urlMap", urlMap);
			  response.setRenderParameter("mvcPath","/demande/demandeDetails.jsp");
		
		    response.setRenderParameter("mvcPath", "/demande/demandeDetails.jsp");
		    response.setRenderParameter("demandeId", String.valueOf(demandeId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setRenderParameter("mvcPath", "/demande/demandeDetails.jsp");
		response.setRenderParameter("demandeId", String.valueOf(demandeId));
	}
	
	
	public Map<String, String> getAllFileLink(ThemeDisplay themeDisplay,Demande demande){
		Map<String, String> urlMap = new HashMap<String, String>();//key = file name ,value = url
		long repositoryId = themeDisplay.getScopeGroupId();
		System.out.println("demande id:"+demande.getPassport());
		try {
			FileEntry passportEntry=DLAppServiceUtil.getFileEntry(demande.getPassport());
			System.out.println("demande id:"+demande.getPassport());
			FileEntry photoEntry=DLAppServiceUtil.getFileEntry(demande.getPhoto());
			FileEntry flightReservationEntry=DLAppServiceUtil.getFileEntry(demande.getFlightReservation());
			List<FileEntry> files=new ArrayList<FileEntry>();
			files.add(passportEntry);
			files.add(photoEntry);
			files.add(flightReservationEntry);
			for (FileEntry file : files) {
				String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "/" + 
					      file.getFolderId() +  "/" +file.getTitle();
				String key=file.getTitle();
				switch(key) {
					case "passportEntry":
						urlMap.put("Passport", url);// remove jpg or pdf
						System.out.println("info:"+file.getTitle().split("\\.")[0]+"  "+url);
						break;
					case "photoEntry":
						urlMap.put("Photo", url);// remove jpg or pdf
						System.out.println("info:"+file.getTitle().split("\\.")[0]+"  "+url);
						break;
					case "flyReservationEntry":
						urlMap.put("Reservation du vol", url);// remove jpg or pdf
						System.out.println("info:"+file.getTitle().split("\\.")[0]+"  "+url);
						break;
							
				}
			}
			
			   
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return urlMap;
		
	}
	
	
    public void traiterDemande(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {
        // Get demandeId and status from the request parameters
        long demandeId = ParamUtil.getLong(actionRequest, "demandeId", 0);
        boolean status = ParamUtil.getBoolean(actionRequest, "status");
        try {
            ServiceContext serviceContext=ServiceContextFactory.getInstance(Demande.class.getName(), actionRequest);
			Demande demande=dls.getDemande(demandeId);
			JSONObject payload=JSONFactoryUtil.createJSONObject();
			if (status) {
	            demande.setStatue("accepter");
	            dls.updateDemande(demande);
	            payload.put("status", "accepte");
	            UserNotificationEventLocalServiceUtil.addUserNotificationEvent(
	            		demande.getUserId(), ConfirmDemandeNotificationHandler.PORTLET_ID, System.currentTimeMillis(), 
	            		UserNotificationDeliveryConstants.TYPE_WEBSITE, serviceContext.getUserId(), payload.toJSONString(), false, 
	            		serviceContext);
	        } else {
	        	demande.setStatue("rejeter");
	            dls.updateDemande(demande);
	            payload.put("status", "rejete");
	            UserNotificationEventLocalServiceUtil.addUserNotificationEvent(
	            		demande.getUserId(), ConfirmDemandeNotificationHandler.PORTLET_ID, System.currentTimeMillis(), 
	            		UserNotificationDeliveryConstants.TYPE_WEBSITE, serviceContext.getUserId(), payload.toJSONString(), false, 
	            		serviceContext);
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // For example:
        

        // Redirect back to the detail page
        actionResponse.setRenderParameter("demandeId", String.valueOf(demandeId));
        actionResponse.setRenderParameter("mvcRenderCommandName", "/detail");
    }
	
	
	
}
