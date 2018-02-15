
create table if not exists customers(
cutomerNumber long PRIMARY KEY  not null,
activeRecommendation boolean not null
);

create table if not exists  recommendations(
id long IDENTITY PRIMARY KEY  not null,
recommendation varchar(100),
customer_id long,
foreign key (customer_id) references customers(cutomerNumber)
);