
insert into worker values(100,30,'Ivan','Ivanov',4500,'+380687838139','Уборщик')
insert into worker values(101,30,'Кардан','шляпа',4500,'+380687838139','Уборщик')



-- insert into servicess values(101,300,'Занятия 3 раза в неделю ','Студент - кочка 1')
--
-- insert into servicess values(102,250,'Занятия 2 раза в неделю ','Студент - не кочка 2')
--
-- insert into servicess values(103,300,'Занятия 1 раз в неделю ','Студент - мертвый 3')

insert into servicess values(101,100,'Занятия 3 раза в неделю ','Стандарт')

insert into servicess values(102,200,'Занятия 2 раза в неделю ','Средний')

insert into servicess values(103,300,'Занятия 1 раз в неделю ','Ускореный')

insert into customer values(1000,1,'ssd@msd','Administrator',null,'1234',1,'ADMIN',1,101)

insert into question values(1000,true,'simple text for demonstrate it works','Заголовок',true,'textLine',1000)

insert into question values(1001,true,'and another one','Заголовок2',true,'textLine',1000)

insert into answer values(101,'first answer',1000)

insert into answer values(102,'Another answer',1001)

insert into answer values(103,'answer 2',1000)

insert into answer values(104, 'Another answer 2',1001)