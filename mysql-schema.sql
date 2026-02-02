
    create table members (
        age integer not null,
        member_id bigint not null auto_increment,
        name varchar(255) not null,
        mbti enum ('ENFJ','ENFP','ENTJ','ENTP','ESFJ','ESFP','ESTJ','ESTP','INFJ','INFP','INTJ','INTP','ISFJ','ISFP','ISTJ','ISTP') not null,
        primary key (member_id),
        check ((age>=0))
    ) engine=InnoDB;
