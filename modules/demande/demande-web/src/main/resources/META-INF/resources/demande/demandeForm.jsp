<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ include file="../init.jsp" %>

<portlet:defineObjects />

<portlet:actionURL name="addDemande" var="addDemandeURL" />



<%
    // Liste de noms de pays
    List<String> countryNames = Arrays.asList(
        "États-Unis", "Canada", "Royaume-Uni", "France", "Allemagne",
        "Japon", "Brésil", "Australie", "Inde", "Afrique du Sud"
    );
%>

<aui:form action="<%= addDemandeURL %>" method="post" enctype="multipart/form-data">
	<aui:select label="Destination" name="destination" required="true">
    <% for (String countryName : countryNames) { %>
        <aui:option label="<%= countryName %>" value="<%= countryName %>" />
    <% } %>
</aui:select>
    <aui:select label="Type de visa" name="visaType" required="true">
        <aui:option label="Visa Affaires" value="affaires" />
        <aui:option label="Visa Touristique" value="touristique" />
        <aui:option label="Visa de travail" value="travail" />
        <aui:option label="Visa étudiant" value="etudiant" />
        <aui:option label="Visa journaliste et médias" value="journaliste" />
    </aui:select>
    <aui:input label="Durée du séjour" name="stayDuration" required="true" />
    <aui:input label="But du voyage" name="tripPurpose" required="true" />
    <aui:input label="Date du voyage" type="date" name="tripDate" required="true" />
    <!-- File inputs with fileUpload attribute -->
    <aui:input type="file" label="Passport" name="passportEntry" required="true" />
    <aui:input type="file" label="Photo d'identité" name="photoEntry" required="true" />
    <aui:input type="file" label="Réservation du vol" name="flyReservationEntry" required="true" />
    <!-- File upload using Documents and Media portlet -->
    <aui:button-row>
        <aui:button type="submit" value="Soumettre" />
    </aui:button-row>
</aui:form>
