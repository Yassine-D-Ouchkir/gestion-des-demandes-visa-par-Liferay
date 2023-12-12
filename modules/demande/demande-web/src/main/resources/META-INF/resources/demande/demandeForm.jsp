<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ include file="../init.jsp" %>

<portlet:defineObjects />

<portlet:actionURL name="addDemande" var="addDemandeURL" />



<%
    // Liste de noms de pays
    List<String> countryNames = Arrays.asList(
        "�tats-Unis", "Canada", "Royaume-Uni", "France", "Allemagne",
        "Japon", "Br�sil", "Australie", "Inde", "Afrique du Sud"
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
        <aui:option label="Visa �tudiant" value="etudiant" />
        <aui:option label="Visa journaliste et m�dias" value="journaliste" />
    </aui:select>
    <aui:input label="Dur�e du s�jour" name="stayDuration" required="true" />
    <aui:input label="But du voyage" name="tripPurpose" required="true" />
    <aui:input label="Date du voyage" type="date" name="tripDate" required="true" />
    <!-- File inputs with fileUpload attribute -->
    <aui:input type="file" label="Passport" name="passportEntry" required="true" />
    <aui:input type="file" label="Photo d'identit�" name="photoEntry" required="true" />
    <aui:input type="file" label="R�servation du vol" name="flyReservationEntry" required="true" />
    <!-- File upload using Documents and Media portlet -->
    <aui:button-row>
        <aui:button type="submit" value="Soumettre" />
    </aui:button-row>
</aui:form>
