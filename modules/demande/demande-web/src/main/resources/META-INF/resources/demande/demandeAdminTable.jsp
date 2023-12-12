<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.gestion_demande_visa.model.Demande"%>
<%@page import="java.util.List"%>
<%@ include file="../init.jsp" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">


<% List<Demande> demandes = (List<Demande>) request.getAttribute("demandes"); %>
<% int curPage = (int) request.getAttribute("curPage"); %>
<% int itemsPerPage = (int) request.getAttribute("itemsPerPage"); %>
<% long totalCount = (long) request.getAttribute("totalCount"); %>
<% if (demandes != null && !demandes.isEmpty()) { %>
    <table class="table table-striped">
        <thead>
            <tr>
            	<th>Nom du condidat</th>
                <th>Date de voyage</th>
                <td>Destination</td>
                <th>duree de sejour</th>
                <th>type de visa</th>
                <th>etat</th>
                <th>details</th>
                <!-- Add other column headers as needed -->
            </tr>
        </thead>
        <tbody>
            <% for (Demande demande : demandes) { %>
            <%User condidat=UserLocalServiceUtil.getUser(demande.getUserId());%>
                <tr>
                	<td><%= condidat.getFullName() %></td>
                	<td><%= demande.getTripDate() %></td>
                	<td><%= demande.getTripDate() %></td>
                    <td><%= demande.getStayDuration() %></td>
                    <td><%= demande.getVisaType() %></td>
                    <td><%= demande.getStatue() %></td>
                    <td>
		                <a href="<portlet:actionURL name="viewDetails" ><portlet:param name="demandeId" value="<%= String.valueOf(demande.getDemandeId()) %>" /></portlet:actionURL>">View Details</a>
		            </td>
		                    <!-- Add other table data as needed -->
                </tr>
            <% } %>
        </tbody>
    </table>
    <!-- Display pagination links -->
<ul class="pagination">
    <% long totalPages = (totalCount + itemsPerPage - 1) / itemsPerPage; %>
    <% for (int i = 1; i <= totalPages; i++) { %>
        <li class="page-item <%= curPage == i ? "active" : "" %>">
            <a class="page-link" href="<portlet:renderURL><portlet:param name="curPage" value="<%= String.valueOf(i) %>" /></portlet:renderURL>">
                <%= i %>
            </a>
        </li>
    <% } %>
</ul>

<% } else { %>
    <p>No demandes found.</p>
<% } %>
