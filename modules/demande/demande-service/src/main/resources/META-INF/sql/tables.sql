create table GDV_Demande (
	demandeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	destination VARCHAR(75) null,
	visaType VARCHAR(75) null,
	tripDate DATE null,
	tripPurpse VARCHAR(75) null,
	stayDuration VARCHAR(75) null,
	passport LONG,
	photo LONG,
	flightReservation LONG,
	statue VARCHAR(75) null
);