create table hu_login_user
(lid varchar2(15) 
, logdate date
, logoutdate date
, islogin number
,constraint hu_login_user_lid_pk primary key(lid)
,constraint hu_login_user_lid_fk foreign key(lid) references hu_member(lid) on delete cascade 			   		  		 
);