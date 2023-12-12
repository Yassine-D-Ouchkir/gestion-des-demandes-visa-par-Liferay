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
                <th>Date de voyage</th>
                <th>Destination</th>
                <th>duree de sejour</th>
                <th>type de visa</th>
                <th>etat</th>
                
                <!-- Add other column headers as needed -->
            </tr>
        </thead>
        <tbody>
            <% for (Demande demande : demandes) { %>
                <tr>
                    <td><%= demande.getTripDate() %></td>
                    <td><%= demande.getDestination() %></td>
                    <td><%= demande.getStayDuration() %></td>
                    <td><%= demande.getVisaType()%></td>
                    <% if (demande.getStatue().equals("encours")) { %>
		            <td>
		                <!-- Ajouter la barre de progression de niveau moyen -->
		                <div class="progress">
		                    <div class="progress-bar  progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%;">50%</div>
		                </div>
		            </td>
		        <% } else { %>
		            <td><div class="progress">
		                    <div class="progress-bar bg-success progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">100%</div>
		                </div></td>
		        <% } %>
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
