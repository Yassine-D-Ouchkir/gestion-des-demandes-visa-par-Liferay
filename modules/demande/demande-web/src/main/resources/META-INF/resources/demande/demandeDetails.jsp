<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.gestion_demande_visa.model.Demande"%>
<%@page import="com.liferay.gestion_demande_visa.service.DemandeLocalServiceUtil"%>
<%@ include file="../init.jsp" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

<% long demandeId = ParamUtil.getLong(request, "demandeId", 0);%>
<% Demande demande = DemandeLocalServiceUtil.fetchDemande(demandeId); 
System.out.println("dem :"+demande.getDemandeId()); %>

<% if (demande != null) { %>
<div class="container justify-content-center ">
	<div class=" row justify-content-center">
		<div class="col-md-4">
			<div class="card  h-100 justify-content-center">
				
				<div class="card-header ">
					<h3>Information du condidat</h3>
				</div>
				<div class="card-body">
				 <% User condidat=UserLocalServiceUtil.getUser(demande.getUserId()); %>
					<p>nom: <%= condidat.getLastName() %></p>
				    <p>prénom: <%= condidat.getFirstName() %></p>
				    <p>date de néssance: <%= condidat.getBirthday() %> </p>
				</div>
			</div>
			
		    
		</div>
		<div class="col-md-4">
			<div class="card h-100">
				<div class="card-header ">
					<h3>Information de voyage</h3>
				</div>
				<div class="card-body">
				   <p>Destination: <%= demande.getDestination() %></p>
				   <p>Type de visa: <%= demande.getVisaType() %></p>
				   <p>date de voyage: <%= demande.getTripDate() %></p>
				   <p>date de voyage<%= demande.getTripDate() %></p>
				   <p>durée de séjour: <%= demande.getStayDuration() %></p>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="card h-100">
				<div class="card-header ">
					<h3>les fichier joint :</h3>
				</div>
				<div class="card-body">
				   <c:forEach items="${urlMap}" var="links">
				   <div>
				   		<a href="${links.value}" class="btn btn-success mt-3 col-md-6" target="blank">${links.key}</a><br>
				   </div>
	   					
	 				</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<div class="row justify-content-center">
    <!-- Existing code to display the demande details -->

    <%-- Add the Reject and Validate links --%>
    <a href="<portlet:actionURL name="traiterDemande"><portlet:param name="demandeId" value="<%= String.valueOf(demandeId) %>" /><portlet:param name="status" value="false" /></portlet:actionURL>" class="col-md-4 m-3 btn btn-danger mt-3">Reject</a>
    <a href="<portlet:actionURL name="traiterDemande"><portlet:param name="demandeId" value="<%= String.valueOf(demandeId) %>" /><portlet:param name="status" value="true" /></portlet:actionURL>" class="col-md-4 m-3 btn btn-success mt-3">Validate</a>
</div>
	
	<!-- files to be download -->
	
	<!-- Add download links for passport, photo, and flight reservation -->
<!-- Add download links for passport, photo, and flight reservation -->

	 
	
    <!-- Add other details here as needed -->
    
    
<% } else { %>
    <p>No details found for the selected demande.</p>
<% } %>
</div>