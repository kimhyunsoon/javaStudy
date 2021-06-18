create table hu_menu(
	idx number constraint hu_menu_pk_idx primary key,
	lid varchar2(15) constraint hu_menu_nn_lid not null,
	name varchar2(30) constraint hu_menu_nn_name not null,
	div varchar2(30),
	huse number default 0 constraint hu_menu_nn_use not null,
	lev number default 9 constraint hu_menu_nn_lev not null,
	udate date,
	idate date
	,constraint hu_menu_lid_fk foreign key(lid) references hu_member(lid) on delete cascade
);

create SEQUENCE humenu_seq start with 1 increment by 1 nocache;
