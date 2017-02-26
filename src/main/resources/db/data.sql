INSERT INTO categoria_cuarto (nombre,descripcion,precio)
    VALUES ('Individual', 'Ideal para quienes viajan solos.',50.0);

INSERT INTO categoria_cuarto (nombre,descripcion,precio)
    VALUES ('Familiar', 'Ideal para los que desean ahorrar.',100.0);

INSERT INTO cuarto (numero, descripcion,categoria)
    VALUES(1,'Vista a la piscina',1);
INSERT INTO cuarto (numero, descripcion,categoria)
  VALUES(2,'Remodelado recientemente',1);

INSERT INTO cuarto (numero, descripcion,categoria)
  VALUES(2,'Dos camas en la habitaicon', 2 );

INSERT INTO huesped (nombre,email,telefono)
  VALUES('Juan Perez','jperez@gmail.com','78999354');
