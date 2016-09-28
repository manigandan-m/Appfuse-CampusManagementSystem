
    alter table address 
        drop 
        foreign key FK_mt4igjt4rdt2ci29x8ex67jop;

    alter table app_user 
        drop 
        foreign key FK_ltbhj43xjmmebuwsfny9c5fqw;

    alter table period_subject_detail 
        drop 
        foreign key FK_j2m0thn96fv38d1yi8o9ocnl3;

    alter table period_subject_detail 
        drop 
        foreign key FK_biv84gnft8yeh0re6v7kggcdb;

    alter table standard 
        drop 
        foreign key FK_4l60mvnvsyvwbtwm2wco4bskr;

    alter table student 
        drop 
        foreign key FK_68vjf5euo8uefjxvyd4lm6dvm;

    alter table student 
        drop 
        foreign key FK_bkix9btnoi1n917ll7bplkvg5;

    alter table subject 
        drop 
        foreign key FK_fkrkkgfsklfqgviif4152pbps;

    alter table subject 
        drop 
        foreign key FK_mfaxpk6kddu09sjmjbry39j5w;

    alter table teacher 
        drop 
        foreign key FK_ih20pr4twvb71fvoeypi8crnl;

    alter table user_role 
        drop 
        foreign key FK_it77eq964jhfqtu54081ebtio;

    alter table user_role 
        drop 
        foreign key FK_apcc8lxk2xnug8377fatvbn04;

    drop table if exists address;

    drop table if exists app_user;

    drop table if exists period_subject_detail;

    drop table if exists role;

    drop table if exists standard;

    drop table if exists student;

    drop table if exists subject;

    drop table if exists teacher;

    drop table if exists user_role;

    create table address (
        address_id integer not null auto_increment,
        city varchar(255),
        country varchar(255),
        house_number varchar(255),
        pincode integer,
        state varchar(255),
        street_name varchar(255),
        id bigint,
        primary key (address_id)
    ) ENGINE=InnoDB;

    create table app_user (
        id bigint not null auto_increment,
        account_expired bit not null,
        account_locked bit not null,
        blood_group varchar(255),
        credentials_expired bit not null,
        date_of_birth varchar(255),
        email varchar(255) not null,
        account_enabled bit,
        first_name varchar(50) not null,
        gender varchar(255),
        last_name varchar(50) not null,
        nationality varchar(255),
        password varchar(255) not null,
        password_hint varchar(255),
        phone_number varchar(255),
        religion varchar(255),
        username varchar(50) not null,
        version integer,
        website varchar(255),
        role_id bigint,
        primary key (id)
    ) ENGINE=InnoDB;

    create table period_subject_detail (
        period_subject_id integer not null auto_increment,
        period_id integer,
        subject_code varchar(255),
        standard_id integer,
        teacher_id integer,
        primary key (period_subject_id)
    ) ENGINE=InnoDB;

    create table role (
        id bigint not null auto_increment,
        description varchar(64),
        name varchar(20),
        primary key (id)
    ) ENGINE=InnoDB;

    create table standard (
        standard_id integer not null auto_increment,
        standard_name varchar(255),
        coordinator_id integer,
        primary key (standard_id)
    ) ENGINE=InnoDB;

    create table student (
        roll_number integer not null auto_increment,
        admission_category varchar(255),
        date_of_admission varchar(255),
        total_income bigint,
        father_first_name varchar(255),
        father_last_name varchar(255),
        mother_first_name varchar(255),
        mother_last_name varchar(255),
        standard_id integer,
        user_id bigint,
        primary key (roll_number)
    ) ENGINE=InnoDB;

    create table subject (
        subject_code varchar(255) not null,
        subject_name varchar(255),
        standard_id integer,
        teacher_id integer,
        primary key (subject_code)
    ) ENGINE=InnoDB;

    create table teacher (
        teacher_id integer not null auto_increment,
        date_of_joining varchar(255),
        designation varchar(255),
        marital_status varchar(255),
        months_of_experience integer,
        qualification varchar(255),
        years_of_experience integer,
        id bigint,
        primary key (teacher_id)
    ) ENGINE=InnoDB;

    create table user_role (
        user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) ENGINE=InnoDB;

    alter table app_user 
        add constraint UK_1j9d9a06i600gd43uu3km82jw  unique (email);

    alter table app_user 
        add constraint UK_3k4cplvh82srueuttfkwnylq0  unique (username);

    alter table address 
        add constraint FK_mt4igjt4rdt2ci29x8ex67jop 
        foreign key (id) 
        references app_user (id);

    alter table app_user 
        add constraint FK_ltbhj43xjmmebuwsfny9c5fqw 
        foreign key (role_id) 
        references role (id);

    alter table period_subject_detail 
        add constraint FK_j2m0thn96fv38d1yi8o9ocnl3 
        foreign key (standard_id) 
        references standard (standard_id);

    alter table period_subject_detail 
        add constraint FK_biv84gnft8yeh0re6v7kggcdb 
        foreign key (teacher_id) 
        references teacher (teacher_id);

    alter table standard 
        add constraint FK_4l60mvnvsyvwbtwm2wco4bskr 
        foreign key (coordinator_id) 
        references teacher (teacher_id);

    alter table student 
        add constraint FK_68vjf5euo8uefjxvyd4lm6dvm 
        foreign key (standard_id) 
        references standard (standard_id);

    alter table student 
        add constraint FK_bkix9btnoi1n917ll7bplkvg5 
        foreign key (user_id) 
        references app_user (id) 
        on delete cascade;

    alter table subject 
        add constraint FK_fkrkkgfsklfqgviif4152pbps 
        foreign key (standard_id) 
        references standard (standard_id);

    alter table subject 
        add constraint FK_mfaxpk6kddu09sjmjbry39j5w 
        foreign key (teacher_id) 
        references teacher (teacher_id);

    alter table teacher 
        add constraint FK_ih20pr4twvb71fvoeypi8crnl 
        foreign key (id) 
        references app_user (id) 
        on delete cascade;

    alter table user_role 
        add constraint FK_it77eq964jhfqtu54081ebtio 
        foreign key (role_id) 
        references role (id);

    alter table user_role 
        add constraint FK_apcc8lxk2xnug8377fatvbn04 
        foreign key (user_id) 
        references app_user (id);
