create table hu_login
(lid varchar2(15) 
,pwd varchar2(15)
,constraint hu_login_lid_pk primary key(lid)
,constraint hu_login_lid_fk foreign key(lid) references hu_member(lid) on delete cascade 			   		  		 
);