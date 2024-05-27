create schema Wallet;
use Wallet;
create table User(
		id INT AUTO_INCREMENT PRIMARY KEY,
		nombre VARCHAR(100) NOT NULL,
		email VARCHAR(100) ,
		contrasena VARCHAR(100) NOT NULL
        
);


create table Transacciones(
	id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    retiro INT,
    deposito INT ,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    saldo INT,
    FOREIGN KEY (usuario_id) REFERENCES User(id)
);

insert into User (nombre, email, contrasena) values ('Paul','arra2@gmail.com','1234');
insert into Transacciones(usuario_id, retiro, deposito,saldo) values('1','0','0','0');

select * from User;
select * from transacciones;

drop table Transacciones;
drop table User;


CREATE USER 'nuevousuario'@'%' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON * . * TO 'nuevousuario'@'%';