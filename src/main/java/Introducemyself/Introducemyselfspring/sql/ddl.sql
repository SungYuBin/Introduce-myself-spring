alter table intro_db.userinfo modify column idx INT NOT NULL AUTO_INCREMENT PRIMARY KEY;
select * from intro_db.userinfo;

insert into intro_db.userinfo values("12","12","12","12");

desc intro_db.userinfo; // 조건확인하기