insert into customer(id,name,phone,email) values(1,'Andie Mydosh','5555550123','andie.mydosh@gmail.com');
insert into customer(id,name,phone,email) values(2,'John Doe','5555550234','john.doe@gmail.com');
insert into customer(id,name,phone,email) values(3,'Jane Doe','5555550345','jane.doe@gmail.com');

insert into product(id,color,size,style) values(1,'Blue','8W','Sport');
insert into product(id,color,size,style) values(2,'Yellow','8M','Sport');
insert into product(id,color,size,style) values(3,'Black','10M','Formal');
insert into product(id,color,size,style) values(4,'White','6K','Casual');
insert into product(id,color,size,style) values(5,'Pink','4K','Casual');
insert into product(id,color,size,style) values(6,'Orange & Black','10M','Sport');
insert into product(id,color,size,style) values(7,'Blue','6W','Sport');
insert into product(id,color,size,style) values(8,'Purple','7W','Sport');
insert into product(id,color,size,style) values(9,'Orange & Black','9M','Sport');

insert into category(id,categoryname) values(1,'Kids');
insert into category(id,categoryname) values(2,'Womens');
insert into category(id,categoryname) values(3,'Mens');

insert into admin(id,adminun,adminpw) values(1,'admin1','admin1pw');
insert into admin(id,adminun,adminpw) values(2,'admin2','admin2pw');


insert into purchase(id,customerid,productid,purchasedate) values(1,1,2,'01Nov2021');
insert into purchase(id,customerid,productid,purchasedate) values(2,3,3,'03Nov2021');
insert into purchase(id,customerid,productid,purchasedate) values(3,2,1,'03Nov2021');
insert into purchase(id,customerid,productid,purchasedate) values(4,1,1,'04Nov2021');
insert into purchase(id,customerid,productid,purchasedate) values(5,3,4,'07Nov2021');
insert into purchase(id,customerid,productid,purchasedate) values(6,2,5,'09Nov2021');
insert into purchase(id,customerid,productid,purchasedate) values(7,1,5,'11Nov2021');
insert into purchase(id,customerid,productid,purchasedate) values(8,3,9,'07Nov2021');
insert into purchase(id,customerid,productid,purchasedate) values(9,2,7,'09Nov2021');
insert into purchase(id,customerid,productid,purchasedate) values(10,1,6,'11Nov2021');