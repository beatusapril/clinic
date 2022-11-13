CREATE TYPE ROLE AS ENUM ('ADMIN', 'USER');
CREATE TYPE SEX AS ENUM ('MALE', 'FEMALE');

CREATE TABLE public.users (
  id bigserial not null PRIMARY KEY,
  login TEXT NOT NULL,
  password TEXT,
  first_name TEXT,
  last_name TEXT,
  role ROLE NOT NULL,
  sex SEX
);

CREATE TABLE public.clients(
	id bigserial not null PRIMARY KEY,
	first_name text ,
	last_name text,
	patronymic text,
	address TEXT,
	sex SEX
);

CREATE TABLE public.kinds_doctors(
	id bigserial not null PRIMARY KEY,
	name text not null
);

CREATE TABLE public.doctors(
	id bigserial not null PRIMARY KEY,
	firstname TEXT NOT NULL,
	lastname TEXT NOT NULL,
	patronymic TEXT,
	kind_doctor_id BIGINT REFERENCES public.kinds_doctors(id)
);

CREATE TABLE public.services(
	id bigserial NOT NULL PRIMARY KEY,
	name TEXT NOT NULL,
	price DOUBLE PRECISION,
	kind_doctor_id bigint REFERENCES public.kinds_doctors(id)	
);

CREATE TABLE public.schedules(
	id bigserial NOT NULL PRIMARY KEY,
	time_start TIME NOT NULL,
	time_finish TIME NOT NULL,
	day INTEGER NOT NULL,
	doctor_id BIGINT NOT NULL REFERENCES public.doctors
);

CREATE TYPE STATUS AS ENUM ('CREATED', 'COMPLETED', 'IN_WAITING');


CREATE TABLE public.applications (
	id bigserial NOT NULL PRIMARY KEY,
	note TEXT,
	client_id bigint NOT NULL REFERENCES public.clients(id),
	service_id bigint NOT NULL REFERENCES public.services(id),
	date_visit TIMESTAMP,
	status STATUS,
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE public.slots(
     id bigserial NOT NULL PRIMARY KEY,
     date_services TIMESTAMP NOT NULL,
     service_id BIGINT NOT NULL REFERENCES public.services(id),
     schedule_id BIGINT NOT NULL REFERENCES public.schedules(id)
);



