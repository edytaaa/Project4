insert into developer (name, url, description) values ('TheBestDeveloper1', 'www.aaaaaaa.pl', 'Osiedle blisko centrum');
insert into developer (name, url, description) values ('TheBestDeveloper2', 'www.bbbbbbb.pl', 'Cicha lokalizacja osiedla');


insert into developer_info(developer_id, address, nip, regon) values (1, 'ul. Szkolna 1', '111-111-11-11', '11111111');
insert into developer_info(developer_id, address, nip, regon) values (2, 'ul. Szkolna 2', '222-222-22-22', '222222222');


insert into investment(developer_id, name, description, url, finish_date, city, street, number) values
 (1, 'Budynek1', 'Mieszkania w atrakcyjnych cenach', 'www.aaaaaaa.pl', '2018-12-12', 'Wrocław', 'ul. Szkolna', 1);
 insert into investment(developer_id, name, description, url, finish_date, city, street, number) values
 (2, 'Budynek2', 'Mieszkania z zielonymi tarasami', 'www.bbbbbbb.pl', '2019-12-12', 'Wrocław', 'ul. Szkolna', 2);


insert into offer(investment_id, meterage, floor, rooms, url, price, description, state, promoted) values
  (1, 40, 1, 2, 'www.aaaaaaa.pl', 200000, 'Okazja', 'FREE', false);
insert into offer(investment_id, meterage, floor, rooms, url, price, description, state, promoted) values
  (1, 50, 2, 3, 'www.aaaaaaa.pl', 300000, 'Okazja', 'FREE', true);
insert into offer(investment_id, meterage, floor, rooms, url, price, description, state, promoted) values
  (2, 54, 1, 2, 'www.bbbbbbb.pl', 320000, 'Okazja', 'BOOKED', false);
insert into offer(investment_id, meterage, floor, rooms, url, price, description, state, promoted) values
  (2, 67, 2, 3, 'www.bbbbbbb.pl', 380000, 'Okazja', 'FREE', true);
insert into offer(investment_id, meterage, floor, rooms, url, price, description, state, promoted) values
  (2, 82, 3, 4, 'www.bbbbbbb.pl', 400000, 'Okazja', 'BOOKED', false);