INSERT INTO public.roles (id, role)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.roles (id, role)
VALUES (2, 'ROLE_USER');

INSERT INTO public.locations (country, region, city, street)
VALUES ('Sin Pais', '2', 'Canadá', 'Ontario');
INSERT INTO public.locations (country, region, city, street)
VALUES ('Canadá', 'Ontario', 'Toronto', 'Yonge Street');
INSERT INTO public.locations (country, region, city, street)
VALUES ('México', 'Ciudad de México', 'Ciudad de México', 'Paseo de la Reforma');
INSERT INTO public.locations (country, region, city, street)
VALUES ('Brasil', 'São Paulo', 'São Paulo', 'Avenida Paulista');
INSERT INTO public.locations (country, region, city, street)
VALUES ('Reino Unido', 'Inglaterra', 'Londres', 'Oxford Street');

INSERT INTO public.users (name, surname, email, number, age, occupation, image, description, rating,
                          user_location_id, password)
VALUES ('Alejandro', 'Martínez', 'alejandro.martinez@example.com', '+34611223344', 30, 'Ingeniero',
        '[Enlace a imagen]', 'Apasionado por la tecnología', 4, 1, 'abc123');
INSERT INTO public.users (name, surname, email, number, age, occupation, image, description, rating,
                          user_location_id, password)
VALUES ('Daniel', 'López', 'daniel.lopez@example.com', '+34622446688', 28, 'Abogado', '[Enlace a imagen]',
        'Amante del senderismo', 4, 2, 'qwerty');
INSERT INTO public.users (name, surname, email, number, age, occupation, image, description, rating,
                          user_location_id, password)
VALUES ('Miguel', 'Sánchez', 'miguel.sanchez@example.com', '+34633887722', 35, 'Médico', '[Enlace a imagen]',
        'Disfruta cocinando', 4, 3, '123456');
INSERT INTO public.users (name, surname, email, number, age, occupation, image, description, rating,
                          user_location_id, password)
VALUES ('Javier', 'García', 'javier.garcia@example.com', '+34644559933', 32, 'Profesor', '[Enlace a imagen]',
        'Entusiasta de los viajes', 4, 4, 'password123');
INSERT INTO public.users (name, surname, email, number, age, occupation, image, description, rating,
                          user_location_id, password)
VALUES ('Carlos', 'Rodríguez', 'carlos.rodriguez@example.com', '+34655668844', 40, 'Empresario', '[Enlace a imagen]',
        'Le encanta tocar la guitarra', 4, 5, 'mypass123');
INSERT INTO public.users (name, surname, email, number, age, occupation, image, description, rating,
                          user_location_id, password)
VALUES ('José', 'Pérez', 'jose.perez@example.com', '+34667779955', 33, 'Arquitecto', '[Enlace a imagen]',
        'Aficionado al cine', 4, 1, '123abc');
INSERT INTO public.users (name, surname, email, number, age, occupation, image, description, rating,
                          user_location_id, password)
VALUES ('Antonio', 'Martín', 'antonio.martin@example.com', '+34678901234', 45, 'Chef', '[Enlace a imagen]',
        'Amante de la cocina', 4, 2, 'qwerty123');
INSERT INTO public.users (name, surname, email, number, age, occupation, image, description, rating,
                          user_location_id, password)
VALUES ('Juan', 'Jiménez', 'juan.jimenez@example.com', '+34689012345', 31, 'Periodista', '[Enlace a imagen]',
        'Adicto a la lectura', 4, 3, 'password');
INSERT INTO public.users (name, surname, email, number, age, occupation, image, description, rating,
                          user_location_id, password)
VALUES ('Francisco', 'Ruiz', 'francisco.ruiz@example.com', '+34690123456', 37, 'Fotógrafo', '[Enlace a imagen]',
        'Apasionado por la fotografía', 4, 4, '123qwerty');
INSERT INTO public.users (name, surname, email, number, age, occupation, image, description, rating,
                          user_location_id, password)
VALUES ('David', 'Hernández', 'david.hernandez@example.com', '+34691234567', 29, 'Veterinario', '[Enlace a imagen]',
        'Amante de los animales', 4, 5, 'mypassword');

INSERT INTO public.opinions (user_id, rating, text)
VALUES (1, 4, 'Excelente servicio, altamente recomendado.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (2, 4, 'Una experiencia maravillosa, sin duda volveré.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (3, 4, 'Buen trato y profesionalidad.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (4, 4, 'Servicio rápido y eficiente.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (5, 4, '¡Increíble! No puedo esperar a volver.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (6, 4, 'Me encantó el ambiente y la comida.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (7, 4, 'La comida estaba deliciosa, ¡repetiré seguro!');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (8, 4, 'Lectura muy recomendable, disfruté cada página.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (9, 4, 'Fotos increíbles, capturaron momentos especiales.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (10, 4, 'Excelente atención, el personal es muy amable.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (1, 4, 'Un lugar acogedor con buena música.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (2, 4, 'Servicio impecable, definitivamente regresaré.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (3, 4, 'Recomiendo completamente este lugar.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (4, 4, 'Experiencia única, ¡volveré pronto!');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (5, 4, 'Una de las mejores experiencias de mi vida.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (6, 4, 'Cine de calidad, disfruté cada momento.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (7, 4, 'Platos exquisitos, sabores auténticos.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (8, 4, 'Un libro fascinante, no podía soltarlo.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (9, 4, 'Fotografías asombrosas, talento excepcional.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (10, 4, 'Servicio excepcional, ¡altamente recomendado!');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (1, 4, 'Ambiente relajado, perfecto para una cita.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (2, 4, 'La comida era deliciosa, sin duda volveré.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (3, 4, 'Profesionales muy competentes, excelente atención.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (4, 4, 'Servicio de primera, superó mis expectativas.');
INSERT INTO public.opinions (user_id, rating, text)
VALUES (5, 4, 'Gran experiencia, lo recomendaría a mis amigos.');


INSERT INTO jobs (name, start_date, end_date, schedule_description, job_description, image, job_location_id)
VALUES ('Asistente de ventas navideñas', '2024-11-15', '2024-12-24', 'Horario flexible, incluyendo fines de semana',
        'Ayudar en la atención al cliente y mantener el stock de productos en una tienda durante la temporada navideña',
        'imagen_navidad.jpg', 2);

INSERT INTO jobs (name, start_date, end_date, schedule_description, job_description, image, job_location_id)
VALUES ('Repartidor de comida a domicilio', '2024-09-01', '2024-12-31',
        'Turnos disponibles por las noches y fines de semana',
        'Entregar alimentos a clientes en sus hogares utilizando medios de transporte proporcionados por la empresa',
        'imagen_repartidor.jpg', 3);

INSERT INTO jobs (name, start_date, end_date, schedule_description, job_description, image, job_location_id)
VALUES ('Promotor de eventos deportivos', '2024-08-15', '2024-09-30', 'Horario variable según programación de eventos',
        'Promocionar y vender boletos para eventos deportivos locales', 'imagen_promotor.jpg', 4);

INSERT INTO jobs (name, start_date, end_date, schedule_description, job_description, image, job_location_id)
VALUES ('Ayudante de producción en fábrica', '2024-07-01', '2024-10-31', 'Turnos rotativos de mañana y tarde',
        'Asistir en la línea de producción y realizar tareas de ensamblaje en una fábrica', 'imagen_fabrica.jpg', 5);

INSERT INTO jobs (name, start_date, end_date, schedule_description, job_description, image, job_location_id)
VALUES ('Encuestador de mercado', '2024-10-01', '2024-11-30', 'Horario flexible, incluyendo fines de semana',
        'Realizar encuestas telefónicas y presenciales para recopilar datos de mercado', 'imagen_encuestador.jpg', 1);

INSERT INTO jobs (name, start_date, end_date, schedule_description, job_description, image, job_location_id)
VALUES ('Camarero de temporada en hotel', '2024-06-15', '2024-09-15', 'Turnos de mañana y tarde',
        'Atender a los huéspedes, servir alimentos y bebidas en un hotel durante la temporada alta de verano',
        'imagen_camarero.jpg', 2);

INSERT INTO jobs (name, start_date, end_date, schedule_description, job_description, image, job_location_id)
VALUES ('Operador de atracciones en parque de diversiones', '2024-07-01', '2024-08-31',
        'Turnos rotativos según horario del parque',
        'Operar y mantener atracciones para garantizar la seguridad y diversión de los visitantes', 'imagen_parque.jpg',
        3);

INSERT INTO jobs (name, start_date, end_date, schedule_description, job_description, image, job_location_id)
VALUES ('Monitor de campamento de verano', '2024-07-15', '2024-08-15', 'Horario diurno con actividades programadas',
        'Supervisar y liderar actividades recreativas para niños en un campamento de verano', 'imagen_monitor.jpg', 4);

INSERT INTO jobs (name, start_date, end_date, schedule_description, job_description, image, job_location_id)
VALUES ('Asistente de ventas en tienda de ropa', '2024-08-01', '2024-09-30',
        'Horario flexible, incluyendo fines de semana',
        'Ayudar a los clientes a encontrar productos y mantener la presentación de la tienda', 'imagen_tienda.jpg', 5);

INSERT INTO jobs (name, start_date, end_date, schedule_description, job_description, image, job_location_id)
VALUES ('Guía turístico para excursiones de un día', '2024-06-01', '2024-09-30',
        'Horario diurno con salidas programadas',
        'Conducir tours guiados y proporcionar información sobre lugares de interés locales', 'imagen_guia.jpg', 1);

INSERT INTO jobs (name, start_date, end_date, schedule_description, job_description, image, job_location_id)
VALUES ('Asistente de atención al cliente en feria comercial', '2024-09-15', '2024-10-15',
        'Horario flexible durante el evento',
        'Brindar asistencia a los expositores y visitantes durante una feria comercial', 'imagen_feria.jpg', 2);

INSERT INTO jobs (name, start_date, end_date, schedule_description, job_description, image, job_location_id)
VALUES ('Ayudante de camarero en restaurante de playa', '2024-07-01', '2024-08-31', 'Turnos de tarde y noche',
        'Apoyar al personal de servicio en la preparación y entrega de alimentos y bebidas en un restaurante de playa',
        'imagen_playa.jpg', 3);

INSERT INTO jobs (name, start_date, end_date, schedule_description, job_description, image, job_location_id)
VALUES ('Asistente de producción en estudio de cine', '2024-08-15', '2024-10-15',
        'Turnos flexibles según programación de filmación',
        'Ayudar en la configuración de escenarios y equipos durante la producción de películas', 'imagen_cine.jpg', 4);

INSERT INTO jobs (name, start_date, end_date, schedule_description, job_description, image, job_location_id)
VALUES ('Vendedor ambulante en festival de música', '2024-06-01', '2024-06-30',
        'Horario variable según horario del festival',
        'Venta de comida y bebidas a los asistentes del festival de música', 'imagen_festival.jpg', 5);


-- Relación de personas con trabajos ofertados
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (1, 1);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (2, 2);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (3, 3);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (4, 4);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (5, 5);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (6, 6);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (7, 7);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (8, 8);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (9, 9);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (10, 10);

-- Relación de personas con trabajos guardados como favoritos
INSERT INTO favorite_jobs (favorite_user_id, favorite_job_id)
VALUES (1, 11);
INSERT INTO favorite_jobs (favorite_user_id, favorite_job_id)
VALUES (2, 12);
INSERT INTO favorite_jobs (favorite_user_id, favorite_job_id)
VALUES (3, 13);
INSERT INTO favorite_jobs (favorite_user_id, favorite_job_id)
VALUES (4, 14);
INSERT INTO favorite_jobs (favorite_user_id, favorite_job_id)
VALUES (5, 12);
INSERT INTO favorite_jobs (favorite_user_id, favorite_job_id)
VALUES (6, 7);
INSERT INTO favorite_jobs (favorite_user_id, favorite_job_id)
VALUES (7, 8);
INSERT INTO favorite_jobs (favorite_user_id, favorite_job_id)
VALUES (8, 9);
INSERT INTO favorite_jobs (favorite_user_id, favorite_job_id)
VALUES (9, 10);
INSERT INTO favorite_jobs (favorite_user_id, favorite_job_id)
VALUES (10, 11);

-- Relación de personas con trabajos ofertados (evitando que una persona oferte su propio trabajo)
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (2, 1);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (3, 2);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (4, 3);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (5, 4);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (6, 5);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (7, 6);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (8, 7);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (9, 8);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (10, 9);
INSERT INTO offered_jobs (offered_user_id, offered_job_id)
VALUES (1, 10);