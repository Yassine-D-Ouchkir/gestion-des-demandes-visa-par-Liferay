package com.liferay.gestion_demande_visa.portlet;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.gestion_demande_visa.constants.DemandeTablePortletKeys;
import com.liferay.gestion_demande_visa.model.Demande;
import com.liferay.gestion_demande_visa.service.DemandeLocalService;
import com.liferay.gestion_demande_visa.service.DemandeLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
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
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=DemandeTable",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/demande/demandeUserTable.jsp",
			"javax.portlet.name="+DemandeTablePortletKeys.DEMANDETABLE,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
	public class DemandeTablePortlet extends MVCPortlet {

		@Reference
		private DemandeLocalService dls;

		@Override
		public void render(RenderRequest renderRequest, RenderResponse renderResponse)
				throws PortletException, IOException {
			ServiceContext sc;
			try {
				sc = ServiceContextFactory.getInstance(Demande.class.getName(), renderRequest);
			
			long userId=sc.getUserId();
			int curPage = ParamUtil.getInteger(renderRequest, "curPage", 1);
			int itemsPerPage = 10;

			List<Demande> demandes = dls.getDemandesByUserId(userId,(curPage - 1) * itemsPerPage, curPage * itemsPerPage);

			long totalCount = dls.getDemandeCountByUserId(userId);

			renderRequest.setAttribute("demandes", demandes);
			renderRequest.setAttribute("curPage", curPage);
			renderRequest.setAttribute("itemsPerPage", itemsPerPage);
			renderRequest.setAttribute("totalCount", totalCount);

			super.render(renderRequest, renderResponse);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		

	}
