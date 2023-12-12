package com.liferay.gestion_demande_visa.portlet;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.gestion_demande_visa.constants.DemandeWebPortletKeys;
import com.liferay.gestion_demande_visa.model.Demande;
import com.liferay.gestion_demande_visa.portlet.notification.add_demande_notification.AddDemandeNotificationHandler;
import com.liferay.gestion_demande_visa.service.DemandeLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;



import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.notifications.NotificationEvent;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;


/**
 * @author HP
 */
@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Visa",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/demande/demandeForm.jsp",
			"javax.portlet.name=" + DemandeWebPortletKeys.DEMANDEWEB,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DemandeWebPortlet extends MVCPortlet {
	@Reference
	private DemandeLocalService dls;
	@Reference
	private UserLocalService userLocalService;
	public void addDemande(ActionRequest request, ActionResponse response) throws PortalException, FileNotFoundException {
		System.out.println("debut de actionPortlet");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Demande.class.getName(), request);
		long groupId=serviceContext.getScopeGroupId();
		long companyId=serviceContext.getCompanyId();
		long userId = serviceContext.getUserId();
		User usr=userLocalService.getUser(userId);
		String destination=ParamUtil.getString(request, "destination");
		String visaType=ParamUtil.getString(request, "visaType");
		Date tripDate=ParamUtil.getDate(request, "tripDate", new SimpleDateFormat("yyyy-mm-dd"));
		String tripPurpse=ParamUtil.getString(request, "tripPurpose");
		String stayDuration=ParamUtil.getString(request, "stayDuration");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		Folder visaDocs=createFolder(request, themeDisplay,DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
				"VisaDocs");
		Folder userFolder=createFolder(request, themeDisplay,visaDocs.getFolderId(),
								usr.getUserId()+"_"+usr.getFirstName()+"_"+usr.getLastName());
		Demande demande=dls.addDemande();
		Folder demandefolder=createFolder(request, themeDisplay,userFolder.getFolderId(),String.valueOf(demande.getDemandeId()));
			
		
		System.out.println("folder id:"+demandefolder.getFolderId());
		long passportFileEntryId=fileUpload("passportEntry",themeDisplay, request,demandefolder);
		long photoFileEntryId=fileUpload("photoEntry",themeDisplay, request,demandefolder);
		long flightReservationFileEntryId=fileUpload("flyReservationEntry",themeDisplay, request,demandefolder);

        

		
		dls.updateDemande(
		    demande.getDemandeId(),groupId, companyId, userId, new Date(), new Date(), destination, visaType, tripDate, tripPurpse, stayDuration,
		    passportFileEntryId, photoFileEntryId, flightReservationFileEntryId);
		JSONObject payload=JSONFactoryUtil.createJSONObject();
		payload.put("nom", usr.getLastName());
		payload.put("prenom", usr.getFirstName());
		long[] Admins=RoleLocalServiceUtil.getUserPrimaryKeys(RoleLocalServiceUtil.getRole(companyId, "Administrator").getRoleId());
		for (long id : Admins) {
			UserNotificationEventLocalServiceUtil.addUserNotificationEvent(id, AddDemandeNotificationHandler.PORTLET_ID, System.currentTimeMillis(), UserNotificationDeliveryConstants.TYPE_WEBSITE, userId, payload.toJSONString(), false, serviceContext);
		}
		
		
	}
	
	
	


	
	public Folder createFolder(ActionRequest actionRequest,ThemeDisplay themeDisplay,long parentFolderId,String folderName)
	{
        boolean folderExist = isFolderExist(themeDisplay,parentFolderId,folderName);
        Folder folder = null;
		if (!folderExist) {
			long repositoryId = themeDisplay.getScopeGroupId();		
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
				folder = DLAppServiceUtil.addFolder(repositoryId,parentFolderId, folderName,"Desc", serviceContext);
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}			
		}else {
			try {
				folder=DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId, folderName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return folder;
	}
	
	public boolean isFolderExist(ThemeDisplay themeDisplay,long parentFolderId,String folderName){
		boolean folderExist = false;
		try {
			DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId, folderName);
			folderExist = true;
			System.out.println("Folder is already Exist");
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return folderExist;
	}
	
	
	public long fileUpload(String fileName,ThemeDisplay themeDisplay,ActionRequest actionRequest,Folder folder)
	{
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
      
			 			
		File file = uploadPortletRequest.getFile(fileName);
		String mimeType = uploadPortletRequest.getContentType();
                    String title = fileName;
		String description = "This file is added via programatically";
		long repositoryId = themeDisplay.getScopeGroupId();
		System.out.println("Title=>"+title);
	    try
	    {  
	    	ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
	    	InputStream is = new FileInputStream( file );
	    	DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), file.getName(), mimeType, 
	    			title, description, "", is, file.length(), serviceContext);
	    	System.out.println(file);
	    	return  DLAppServiceUtil.getFileEntry(repositoryId, folder.getFolderId(), title).getFileEntryId();
	    	
	     } catch (Exception e)
	    {
	       System.out.println(e.getMessage());
	    	e.printStackTrace();
	    	return 0;
	    }

	}
	
	 @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
        // Fetch the demandes from the service
        List<Demande> demandes = dls.getDemandes();

        // Set the demandes as a request attribute to pass it to the JSP
        renderRequest.setAttribute("demandes", demandes);

        super.render(renderRequest, renderResponse);
    }
	 

	
}