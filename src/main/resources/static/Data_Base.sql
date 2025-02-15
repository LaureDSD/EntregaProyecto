-- Insertar tipos de usuarios
INSERT INTO tipo_usuario (nombre, descripcion) VALUES
('usuario', 'Acceso básico al juego, puede crear personajes y jugar.'),
('moderador', 'Acceso medio, puede moderar contenido y usuarios.'),
('administrador', 'Acceso total, puede gestionar todo el sistema.');

INSERT INTO usuarios (imagen_perfil, nombre_usuario_pub, limite_personajes, nombre_usuario_priv, correo, contraseña, ultima_conexion, ip_ultima_conexion, fecha_creacion, estado_cuenta, tipo_usuario)
VALUES
    ('perfil1.jpg', 'Aragorn23', 3, 'aragorn_priv', 'aragorn@example.com', 'contraseña123', '2023-10-01 12:00:00', '192.168.1.1', '2023-10-01 12:00:00', 1, 1),
    ('perfil2.jpg', 'GandalfTheWise', 3, 'gandalf_priv', 'gandalf@example.com', 'contraseña456', '2023-10-02 13:00:00', '192.168.1.2', '2023-10-02 13:00:00', 1, 1),
    ('perfil3.jpg', 'LegolasGreenleaf', 3, 'legolas_priv', 'legolas@example.com', 'contraseña789', '2023-10-03 14:00:00', '192.168.1.3', '2023-10-03 14:00:00', 1, 1),
    ('perfil4.jpg', 'FrodoBaggins', 3, 'frodo_priv', 'frodo@example.com', 'contraseña101', '2023-10-04 15:00:00', '192.168.1.4', '2023-10-04 15:00:00', 1, 1),
    ('perfil5.jpg', 'GimliSonOfGloin', 3, 'gimli_priv', 'gimli@example.com', 'contraseña112', '2023-10-05 16:00:00', '192.168.1.5', '2023-10-05 16:00:00', 1, 1),
    ('perfil6.jpg', 'BoromirOfGondor', 3, 'boromir_priv', 'boromir@example.com', 'contraseña131', '2023-10-06 17:00:00', '192.168.1.6', '2023-10-06 17:00:00', 1, 1),
    ('perfil7.jpg', 'GaladrielLadyOfLight', 3, 'galadriel_priv', 'galadriel@example.com', 'contraseña415', '2023-10-07 18:00:00', '192.168.1.7', '2023-10-07 18:00:00', 1, 1),
    ('perfil8.jpg', 'SarumanTheWhite', 3, 'saruman_priv', 'saruman@example.com', 'contraseña161', '2023-10-08 19:00:00', '192.168.1.8', '2023-10-08 19:00:00', 1, 1),
    ('perfil9.jpg', 'ArwenUndomiel', 3, 'arwen_priv', 'arwen@example.com', 'contraseña718', '2023-10-09 20:00:00', '192.168.1.9', '2023-10-09 20:00:00', 1, 1),
    ('perfil10.jpg', 'SauronTheDarkLord', 3, 'sauron_priv', 'sauron@example.com', 'contraseña192', '2023-10-10 21:00:00', '192.168.1.10', '2023-10-10 21:00:00', 1, 1);

-- Insertar logs
INSERT INTO logs (usuario_id, tipo_log, mensaje, fecha_log) VALUES
(1, 'INFORMACION', 'Usuario1 ha iniciado sesión.', NOW()),
(2, 'FALLO', 'Usuario2 ha intentado iniciar sesión con una contraseña incorrecta.', NOW()),
(3, 'ADVERTENCIA', 'Usuario3 ha intentado acceder a una zona restringida.', NOW()),
(4, 'CREACION', 'Usuario4 ha creado un nuevo personaje.', NOW()),
(5, 'ACTUALIZACION', 'Usuario5 ha actualizado su perfil.', NOW());


-- Actualizar
INSERT INTO clase_persoanje (nombre, descripcion, vida_base, escudo_base, energia_base, mana_base, ataque_fisico_base, ataque_magico_base, defensa_fisica, defensa_magica)
VALUES
    ('Guerrero', 'Un luchador fuerte y resistente, especializado en combate cuerpo a cuerpo.', 150, 20, 60, 20, 20, 5, 15, 5),
    ('Mago', 'Un maestro de las artes arcanas, capaz de lanzar hechizos devastadores.', 80, 5, 30, 100, 5, 25, 5, 20),
    ('Arquero', 'Un tirador experto que ataca desde la distancia con precisión letal.', 100, 10, 70, 30, 15, 10, 10, 10),
    ('Sacerdote', 'Un sanador divino que protege y cura a sus aliados.', 90, 15, 40, 80, 8, 15, 8, 15),
    ('Asesino', 'Un combatiente sigiloso que ataca por sorpresa con golpes críticos.', 110, 5, 80, 20, 25, 5, 5, 5),
    ('Caballero', 'Un defensor acorazado que protege a sus aliados en el frente de batalla.', 140, 30, 50, 30, 18, 8, 20, 10),
    ('Bárbaro', 'Un guerrero salvaje que se enfurece en combate, aumentando su fuerza y resistencia.', 160, 10, 90, 10, 22, 3, 12, 3),
    ('Druida', 'Un guardián de la naturaleza que combina magia y habilidades de transformación.', 120, 15, 60, 70, 10, 18, 10, 15),
    ('Nigromante', 'Un hechicero oscuro que invoca y controla a los muertos.', 85, 5, 35, 90, 6, 22, 6, 18),
    ('Bardo', 'Un artista versátil que usa música y magia para apoyar a sus aliados.', 95, 10, 50, 60, 10, 15, 8, 12);

INSERT INTO grupos (nombre, descripcion,lider_grupo)
VALUES
    ('Los Cuatro Elementos', 'Un grupo de aventureros que dominan los cuatro elementos: fuego, agua, tierra y aire.',1),
    ('Los Guardianes del Amanecer', 'Un equipo de héroes que protegen el mundo de las amenazas que surgen con la luz del amanecer.',2),
    ('Las Sombras del Destino', 'Un grupo sigiloso que opera en las sombras para cumplir misiones peligrosas.',2),
    ('Los Hijos del Trueno', 'Un equipo de guerreros que luchan con la fuerza y el poder del trueno.',3),
    ('Los Exploradores Perdidos', 'Un grupo de aventureros que buscan tesoros y secretos en lugares olvidados.',4),
    ('Los Defensores de la Luz', 'Un equipo de paladines y clérigos que luchan contra las fuerzas de la oscuridad.',5),
    ('Los Cazadores de Bestias', 'Un grupo especializado en la caza de criaturas peligrosas y monstruos.',6),
    ('Los Maestros del Caos', 'Un equipo de magos y hechiceros que manipulan el caos para sus propios fines.',3),
    ('Los Guardianes del Bosque', 'Un grupo de druidas y rangers que protegen la naturaleza y sus secretos.',2),
    ('Los Mercenarios del Hierro', 'Un equipo de mercenarios que aceptan cualquier trabajo a cambio de oro.',2),
    ('La Hermandad de la Luz', 'Un gremio dedicado a proteger a los inocentes y luchar contra las fuerzas de la oscuridad.',4),
    ('Los Mercenarios de Hierro', 'Un grupo de mercenarios que acepta cualquier trabajo, siempre que el pago sea bueno.',5),
    ('El Círculo Arcano', 'Una organización de magos que busca el conocimiento y el poder arcano.',6),
    ('Los Cazadores de Sombras', 'Un gremio especializado en la caza de criaturas oscuras y monstruos.',2),
    ('La Orden del Dragón', 'Una orden de caballeros que venera a los dragones y busca su protección.',3),
    ('Los Ladrones de la Noche', 'Un gremio de ladrones y espías que opera en las sombras.',4),
    ('Los Guardianes del Bosque', 'Un grupo de druidas y rangers que protegen la naturaleza.',2),
    ('Los Forjadores de Leyendas', 'Un gremio de artesanos y herreros que crean armas y armaduras legendarias.',3),
    ('Los Exploradores del Abismo', 'Un grupo de aventureros que explora ruinas antiguas y mazmorras peligrosas.',4),
    ('Los Hijos del Caos', 'Una facción caótica que busca el desorden y la destrucción del orden establecido.',4);

    INSERT INTO personajes (usuario_id, imagen_modelo, nombre, fecha_creacion, clase_id,  grupo_id)
    VALUES
        (1, 'imagen1.jpg', 'Aragorn', '2023-10-01 12:00:00', 1, 1),  -- Guerrero, La Hermandad de la Luz, Los Cuatro Elementos
        (2, 'imagen2.jpg', 'Gandalf', '2023-10-02 13:00:00', 2, 1),  -- Mago, El Círculo Arcano, Los Cuatro Elementos
        (3, 'imagen3.jpg', 'Legolas', '2023-10-03 14:00:00', 3, 1),  -- Arquero, Los Cazadores de Sombras, Los Cuatro Elementos
        (4, 'imagen4.jpg', 'Frodo', '2023-10-04 15:00:00', 4, 2),   -- Sacerdote, Los Mercenarios de Hierro, Los Guardianes del Amanecer
        (5, 'imagen5.jpg', 'Gimli', '2023-10-05 16:00:00', 1, 2),   -- Guerrero, La Orden del Dragón, Los Guardianes del Amanecer
        (6, 'imagen6.jpg', 'Boromir', '2023-10-06 17:00:00', 5, 3), -- Asesino, Los Ladrones de la Noche, Las Sombras del Destino
        (7, 'imagen7.jpg', 'Galadriel', '2023-10-07 18:00:00', 2, 4),-- Mago, Los Guardianes del Bosque, Los Hijos del Trueno
        (8, 'imagen8.jpg', 'Saruman', '2023-10-08 19:00:00', 9, 5), -- Nigromante, Los Forjadores de Leyendas, Los Exploradores Perdidos
        (9, 'imagen9.jpg', 'Arwen', '2023-10-09 20:00:00', 10, 6),  -- Bardo, Los Exploradores del Abismo, Los Defensores de la Luz
        (10, 'imagen10.jpg', 'Sauron', '2023-10-10 21:00:00', 9, 7);-- Nigromante, Los Hijos del Caos, Los Cazadores de Bestias


INSERT INTO estadisticas_personaje (personaje_id, nivel, xp_acumulada, vida_base, escudo_base, energia_base, mana_base, ataque_fisico_base, ataque_magico_base, defensa_fisica, defensa_magica, almas, capacidad_inventario)
VALUES
    (1, 5, 1200, 150, 20, 60, 20, 20, 5, 15, 5, 50, 15),  -- Aragorn
    (2, 10, 5000, 80, 5, 30, 100, 5, 25, 5, 20, 100, 10), -- Gandalf
    (3, 8, 3000, 100, 10, 70, 30, 15, 10, 10, 10, 75, 12), -- Legolas
    (4, 3, 800, 90, 15, 40, 80, 8, 15, 8, 15, 30, 10),    -- Frodo
    (5, 7, 2500, 140, 30, 50, 30, 18, 8, 20, 10, 60, 14),  -- Gimli
    (6, 6, 2000, 110, 5, 80, 20, 25, 5, 5, 5, 40, 12),    -- Boromir
    (7, 12, 8000, 120, 15, 60, 70, 10, 18, 10, 15, 150, 16), -- Galadriel
    (8, 15, 12000, 85, 5, 35, 90, 6, 22, 6, 18, 200, 10), -- Saruman
    (9, 9, 4000, 95, 10, 50, 60, 10, 15, 8, 12, 80, 12),  -- Arwen
    (10, 20, 20000, 160, 10, 90, 10, 22, 3, 12, 3, 300, 18); -- Sauron


-- Insertar registros de personajes
INSERT INTO logros_personaje (personaje_id, normal, miniboss, boss, muertes_totales, total_daño_inflijido, total_daño_recibido, tiempo_total_jugado, mazmorras_totales_superadas)
VALUES
    (1, 50, 5, 2, 3, 15000, 5000, 3600, 10),  -- Aragorn
    (2, 30, 3, 1, 1, 20000, 3000, 4800, 8),   -- Gandalf
    (3, 70, 7, 3, 5, 12000, 7000, 3000, 12),  -- Legolas
    (4, 20, 2, 0, 2, 8000, 4000, 2400, 5),    -- Frodo
    (5, 60, 6, 2, 4, 18000, 6000, 4200, 9),   -- Gimli
    (6, 40, 4, 1, 3, 10000, 5000, 3600, 7),   -- Boromir
    (7, 80, 8, 4, 6, 25000, 8000, 5400, 15),  -- Galadriel
    (8, 100, 10, 5, 8, 30000, 10000, 6000, 20), -- Saruman
    (9, 35, 3, 1, 2, 9000, 3500, 2700, 6),    -- Arwen
    (10, 120, 12, 6, 10, 40000, 12000, 7200, 25); -- Sauron

INSERT INTO tipo_monstruo (nombre, descripcion)
VALUES
    ('Normal', 'Monstruos comunes que se encuentran en áreas abiertas y mazmorras.'),
    ('Miniboss', 'Enemigos más poderosos que los normales, pero menos que los bosses. Suelen guardar tesoros o áreas especiales.'),
    ('Boss', 'Enemigos extremadamente poderosos que actúan como jefes de mazmorras o áreas. Derrotarlos suele ser un gran logro.');


   -- Insertar monstruos
   INSERT INTO monstruos (nombre, tipo_monstruo_id, nivel, descripcion, imagen, vida_base, escudo_base, energia_base, mana_base, ataque_fisico_base, ataque_magico_base, defensa_fisica, defensa_magica, almas, experiencia_otorgada) VALUES
   ('Goblin', 1, 1, 'Un pequeño monstruo verde', 'goblin.jpg', 50, 0, 20, 5, 10, 5, 2, 1, 50, 20),
   ('Ogro', 2, 5, 'Un monstruo grande y fuerte', 'ogro.jpg', 200, 0, 50, 20, 50, 20, 10, 5, 200, 50),
   ('Dragón', 3, 10, 'Un poderoso dragón', 'dragon.jpg', 1000, 100, 200, 50, 200, 100, 30, 20, 1000, 200),
   ('Bandido', 1, 3, 'Un bandido común que ataca a los viajeros', 'bandido.jpg', 80, 0, 30, 12, 20, 15, 5, 3, 80, 30),
   ('Lobo Salvaje', 1, 2, 'Un lobo feroz que habita en los bosques', 'lobo.jpg', 60, 0, 20, 8, 15, 10, 3, 2, 60, 20),
   ('Esqueleto Guerrero', 2, 5, 'Un esqueleto revivido con habilidades de combate', 'esqueleto.jpg', 120, 0, 40, 18, 40, 25, 8, 5, 120, 40),
   ('Araña Gigante', 2, 4, 'Una araña gigante que teje telarañas venenosas', 'araña.jpg', 100, 0, 35, 15, 30, 20, 6, 4, 100, 35),
   ('Bandido Líder', 3, 7, 'El líder de una banda de bandidos', 'bandido_lider.jpg', 200, 50, 60, 25, 80, 50, 12, 8, 200, 60),
   ('Nigromante', 3, 7, 'El líder de esqueletos', 'nigromante.jpg', 200, 50, 60, 25, 80, 50, 12, 8, 200, 60),
   ('Araña', 1, 7, 'Araña pequeña que ataca en grupo', 'araña.jpg', 50, 0, 10, 15, 20, 20, 2, 1, 50, 10),
   ('Lobo Gigante', 2, 10, 'Un lobo gigante que habita en los bosques', 'lobo2.jpg', 100, 0, 40, 8, 25, 10, 3, 2, 100, 40),
   ('Lobo Sagrado', 3, 50, 'Un lobo sagrado feroz que habita en los bosques', 'lobo3.jpg', 200, 100, 40, 8, 25, 10, 3, 2, 200, 40),
   ('Janeiro', 3, 100, 'Un boss peligroso cuanto más le alarga la batalla', 'janeiro.jpg', 50000, 200, 1000, 150, 200, 200, 200, 150, 500, 1000);

   INSERT INTO monstruos (nombre, tipo_monstruo_id, nivel, descripcion, imagen, vida_base, escudo_base, energia_base, mana_base, ataque_fisico_base, ataque_magico_base, defensa_fisica, defensa_magica, almas, experiencia_otorgada)
   VALUES
       ('Troll de Montaña', 2, 8, 'Un troll enorme que habita en las montañas.', 'troll_montana.jpg', 300, 20, 80, 30, 70, 25, 15, 10, 300, 80),
       ('Harpía', 1, 4, 'Una criatura voladora con garras afiladas.', 'harpia.jpg', 90, 0, 40, 15, 25, 20, 5, 5, 90, 30),
       ('Golem de Piedra', 3, 12, 'Un golem creado a partir de roca sólida.', 'golem_piedra.jpg', 500, 100, 120, 50, 100, 40, 30, 20, 500, 120),
       ('Esqueleto Mago', 2, 6, 'Un esqueleto que domina la magia oscura.', 'esqueleto_mago.jpg', 150, 0, 50, 100, 20, 60, 8, 15, 150, 50),
       ('Dragón de Hielo', 3, 15, 'Un dragón que escupe hielo y congela a sus enemigos.', 'dragon_hielo.jpg', 1200, 150, 250, 100, 250, 150, 40, 30, 1200, 250),
       ('Goblin Líder', 2, 5, 'El líder de una tribu de goblins.', 'goblin_lider.jpg', 150, 10, 50, 20, 40, 25, 10, 8, 150, 50),
       ('Serpiente Venenosa', 1, 3, 'Una serpiente que ataca con veneno mortal.', 'serpiente.jpg', 70, 0, 25, 10, 15, 10, 3, 2, 70, 20),
       ('Demonio Menor', 2, 7, 'Un demonio de bajo rango que sirve a poderes oscuros.', 'demonio_menor.jpg', 180, 30, 60, 40, 60, 50, 12, 15, 180, 60),
       ('Gárgola', 2, 6, 'Una estatua animada que protege lugares sagrados.', 'gargola.jpg', 200, 50, 70, 30, 50, 40, 15, 10, 200, 70),
       ('Kraken', 3, 20, 'Una criatura marina gigante que ataca con sus tentáculos.', 'kraken.jpg', 1500, 200, 300, 150, 300, 200, 50, 40, 1500, 300),
       ('Fénix', 3, 18, 'Un ave legendaria que renace de sus cenizas.', 'fenix.jpg', 1000, 150, 200, 200, 150, 250, 30, 40, 1000, 200),
       ('Cíclope', 2, 10, 'Un gigante de un solo ojo con fuerza descomunal.', 'ciclop.jpg', 400, 50, 100, 40, 120, 30, 20, 15, 400, 100),
       ('Hidra', 3, 25, 'Una criatura de múltiples cabezas que regenera sus heridas.', 'hidra.jpg', 2000, 300, 400, 200, 350, 250, 60, 50, 2000, 400),
       ('Licántropo', 2, 9, 'Un humano que se transforma en lobo durante la luna llena.', 'licantropo.jpg', 250, 30, 80, 20, 90, 25, 15, 10, 250, 80),
       ('Basilisco', 3, 14, 'Una serpiente gigante que petrifica con su mirada.', 'basilisco.jpg', 800, 100, 150, 80, 200, 100, 25, 20, 800, 150),
       ('Gigante de Hielo', 2, 11, 'Un gigante que habita en regiones heladas.', 'gigante_hielo.jpg', 600, 80, 120, 50, 150, 60, 25, 20, 600, 120),
       ('Dragón de Fuego', 3, 16, 'Un dragón que escupe llamas y arrasa con todo a su paso.', 'dragon_fuego.jpg', 1300, 200, 300, 120, 300, 200, 45, 35, 1300, 300),
       ('Esqueleto Gigante', 2, 8, 'Un esqueleto de tamaño colosal que aterroriza a sus enemigos.', 'esqueleto_gigante.jpg', 400, 50, 100, 30, 100, 40, 20, 15, 400, 100),
       ('Araña Reina', 3, 13, 'La líder de una colonia de arañas gigantes.', 'araña_reina.jpg', 700, 100, 150, 60, 120, 80, 25, 20, 700, 150),
       ('Leviatán', 3, 30, 'Una criatura marina legendaria que devora barcos enteros.', 'leviatan.jpg', 2500, 500, 500, 300, 500, 400, 80, 60, 2500, 500);


INSERT INTO registro_caza (personaje_id, monstruo_id, fecha_caza, almas_obtenidas, experiencia_obtenida)
VALUES
    (1, 1, '2023-10-01 12:00:00', 50, 20),   -- Aragorn cazó un Goblin
    (2, 3, '2023-10-02 13:00:00', 1000, 200), -- Gandalf cazó un Dragón
    (3, 2, '2023-10-03 14:00:00', 200, 50),  -- Legolas cazó un Ogro
    (4, 5, '2023-10-04 15:00:00', 60, 20),   -- Frodo cazó un Lobo Salvaje
    (5, 4, '2023-10-05 16:00:00', 80, 30),   -- Gimli cazó un Bandido
    (6, 6, '2023-10-06 17:00:00', 120, 40),  -- Boromir cazó un Esqueleto Guerrero
    (7, 7, '2023-10-07 18:00:00', 100, 35),  -- Galadriel cazó una Araña Gigante
    (8, 8, '2023-10-08 19:00:00', 200, 60),  -- Saruman cazó un Bandido Líder
    (9, 9, '2023-10-09 20:00:00', 200, 60),  -- Arwen cazó un Nigromante
    (10, 10, '2023-10-10 21:00:00', 50, 10), -- Sauron cazó una Araña
    (1, 11, '2023-10-11 12:00:00', 100, 40), -- Aragorn cazó un Lobo Gigante
    (2, 12, '2023-10-12 13:00:00', 200, 40), -- Gandalf cazó un Lobo Sagrado
    (3, 13, '2023-10-13 14:00:00', 500, 1000), -- Legolas cazó un Janeiro
    (4, 14, '2023-10-14 15:00:00', 300, 80), -- Frodo cazó un Troll de Montaña
    (5, 15, '2023-10-15 16:00:00', 90, 30),  -- Gimli cazó una Harpía
    (6, 16, '2023-10-16 17:00:00', 500, 120), -- Boromir cazó un Golem de Piedra
    (7, 17, '2023-10-17 18:00:00', 150, 50), -- Galadriel cazó un Esqueleto Mago
    (8, 18, '2023-10-18 19:00:00', 1200, 250), -- Saruman cazó un Dragón de Hielo
    (9, 19, '2023-10-19 20:00:00', 150, 50), -- Arwen cazó un Goblin Líder
    (10, 20, '2023-10-20 21:00:00', 70, 20); -- Sauron cazó una Serpiente Venenosa

    -- Insertar efectos y estados
    INSERT INTO efectos_estados (imagen_icono, nombre, tipo, tipo_afectado, duracion_efecto, intervalos_efecto, acumulaciones, vida_base, escudo_base, energia_base, mana_base, ataque_fisico_base, ataque_magico_base, defensa_fisica, defensa_magica, descripcion)
    VALUES
        ('fuerza_icono.jpg', 'Fuerza Mejorada', 'BUFF', 'PERSONAJE', 60, 10, 1, 0, 0, 0, 0, 20, 0, 0, 0, 'Aumenta el ataque físico en 20 puntos durante 1 minuto.'),
        ('veneno_icono.jpg', 'Veneno', 'DEBUFF', 'MONSTRUO', 30, 5, 3, -10, 0, 0, 0, 0, 0, 0, 0, 'Reduce la vida en 10 puntos cada 5 segundos durante 30 segundos.'),
        ('proteccion_icono.jpg', 'Escudo de Protección', 'BUFF', 'PERSONAJE', 120, 0, 1, 0, 50, 0, 0, 0, 0, 0, 0, 'Aumenta el escudo en 50 puntos durante 2 minutos.'),
        ('congelacion_icono.jpg', 'Congelación', 'DEBUFF', 'MONSTRUO', 20, 0, 1, 0, 0, -20, 0, 0, 0, 0, 0, 'Reduce la energía en 20 puntos durante 20 segundos.'),
        ('regeneracion_icono.jpg', 'Regeneración', 'BUFF', 'PERSONAJE', 60, 10, 1, 10, 0, 0, 0, 0, 0, 0, 0, 'Regenera 10 puntos de vida cada 10 segundos durante 1 minuto.'),
        ('maldicion_icono.jpg', 'Maldición Oscura', 'DEBUFF', 'MONSTRUO', 45, 15, 2, 0, 0, 0, -30, 0, 0, 0, 0, 'Reduce el maná en 30 puntos cada 15 segundos durante 45 segundos.'),
        ('ira_icono.jpg', 'Ira del Guerrero', 'BUFF', 'PERSONAJE', 30, 0, 1, 0, 0, 0, 0, 30, 0, 0, 0, 'Aumenta el ataque físico en 30 puntos durante 30 segundos.'),
        ('ceguera_icono.jpg', 'Ceguera', 'DEBUFF', 'MONSTRUO', 25, 0, 1, 0, 0, 0, 0, -15, 0, 0, 0, 'Reduce el ataque físico en 15 puntos durante 25 segundos.'),
        ('bendicion_icono.jpg', 'Bendición Divina', 'BUFF', 'PERSONAJE', 90, 0, 1, 50, 0, 0, 50, 0, 0, 0, 0, 'Aumenta la vida y el maná en 50 puntos durante 90 segundos.'),
        ('quemadura_icono.jpg', 'Quemadura', 'DEBUFF', 'MONSTRUO', 40, 10, 4, -15, 0, 0, 0, 0, 0, 0, 0, 'Reduce la vida en 15 puntos cada 10 segundos durante 40 segundos.'),
        ('invisibilidad_icono.jpg', 'Invisibilidad', 'BUFF', 'PERSONAJE', 60, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 'Hace al personaje invisible durante 1 minuto.'),
        ('miedo_icono.jpg', 'Miedo', 'DEBUFF', 'MONSTRUO', 30, 0, 1, 0, 0, 0, 0, 0, -20, 0, 0, 'Reduce el ataque mágico en 20 puntos durante 30 segundos.'),
        ('furia_icono.jpg', 'Furia del Dragón', 'BUFF', 'PERSONAJE', 45, 0, 1, 0, 0, 0, 0, 40, 0, 0, 0, 'Aumenta el ataque físico en 40 puntos durante 45 segundos.'),
        ('paralisis_icono.jpg', 'Parálisis', 'DEBUFF', 'MONSTRUO', 20, 0, 1, 0, 0, -30, 0, 0, 0, 0, 0, 'Reduce la energía en 30 puntos durante 20 segundos.'),
        ('aura_sagrada_icono.jpg', 'Aura Sagrada', 'BUFF', 'PERSONAJE', 120, 0, 1, 0, 0, 0, 0, 0, 0, 10, 10, 'Aumenta la defensa física y mágica en 10 puntos durante 2 minutos.'),
        ('corrupcion_icono.jpg', 'Corrupción', 'DEBUFF', 'MONSTRUO', 60, 15, 3, -20, 0, 0, 0, 0, 0, 0, 0, 'Reduce la vida en 20 puntos cada 15 segundos durante 1 minuto.'),
        ('velocidad_icono.jpg', 'Velocidad Mejorada', 'BUFF', 'PERSONAJE', 60, 0, 1, 0, 0, 20, 0, 0, 0, 0, 0, 'Aumenta la energía en 20 puntos durante 1 minuto.'),
        ('silenciamiento_icono.jpg', 'Silenciamiento', 'DEBUFF', 'MONSTRUO', 30, 0, 1, 0, 0, 0, -50, 0, 0, 0, 0, 'Reduce el maná en 50 puntos durante 30 segundos.'),
        ('invulnerabilidad_icono.jpg', 'Invulnerabilidad', 'BUFF', 'PERSONAJE', 10, 0, 1, 0, 100, 0, 0, 0, 0, 0, 0, 'Aumenta el escudo en 100 puntos durante 10 segundos.'),
        ('envenenamiento_icono.jpg', 'Envenenamiento Grave', 'DEBUFF', 'MONSTRUO', 50, 10, 5, -25, 0, 0, 0, 0, 0, 0, 0, 'Reduce la vida en 25 puntos cada 10 segundos durante 50 segundos.');

-- Insertar tipos de mapa
INSERT INTO tipo_mapa (nombre, descripcion)
VALUES
    ('Bosque', 'Un área densamente poblada de árboles y vegetación, hogar de criaturas salvajes y secretos ocultos.'),
    ('Montaña', 'Una región escarpada y rocosa, con altos picos y peligrosas criaturas que habitan en las alturas.'),
    ('Mazmorra', 'Un laberinto subterráneo lleno de trampas, monstruos y tesoros ocultos.'),
    ('Desierto', 'Una vasta extensión de arena y calor extremo, donde el agua es escasa y las criaturas son resistentes.'),
    ('Ciudad', 'Un área urbana llena de vida, comercios y oportunidades para interactuar con otros personajes.'),
    ('Pantano', 'Una zona húmeda y peligrosa, con criaturas venenosas y terrenos traicioneros.'),
    ('Llanura', 'Una extensión abierta de tierra, ideal para viajar pero con peligros ocultos.'),
    ('Cueva', 'Una formación subterránea oscura y misteriosa, hogar de criaturas adaptadas a la oscuridad.'),
    ('Ruinas', 'Restos de una civilización antigua, llenos de secretos, trampas y tesoros perdidos.'),
    ('Isla', 'Una masa de tierra rodeada de agua, con ecosistemas únicos y criaturas exóticas.'),
	('tienda', 'Zona de comercio');

-- Insertar mapas
INSERT INTO mapas (nombre, descripcion, imagen, tipo_mapa_id, nivel_recomendado)
VALUES
    ('Bosque Oscuro', 'Un bosque denso y misterioso lleno de criaturas peligrosas.', 'bosque_oscuro.jpg', 1, 5),
    ('Montañas del Dragón', 'Una cadena montañosa donde los dragones hacen sus nidos.', 'montañas_dragon.jpg', 2, 10),
    ('Mazmorra de las Sombras', 'Una mazmorra oscura y llena de trampas mortales.', 'mazmorra_sombras.jpg', 3, 15),
    ('Desierto Ardiente', 'Un desierto vasto y abrasador con criaturas resistentes al calor.', 'desierto_ardiente.jpg', 4, 8),
    ('Ciudad de los Mercaderes', 'Una bulliciosa ciudad llena de comercios y oportunidades.', 'ciudad_mercaderes.jpg', 5, 3),
    ('Pantano Venenoso', 'Un pantano lleno de criaturas venenosas y terrenos traicioneros.', 'pantano_venenoso.jpg', 6, 7),
    ('Llanuras del Viento', 'Una extensión abierta de tierra con peligros ocultos.', 'llanuras_viento.jpg', 7, 4),
    ('Cueva de Cristal', 'Una cueva brillante con formaciones de cristal y criaturas únicas.', 'cueva_cristal.jpg', 8, 12),
    ('Ruinas Antiguas', 'Restos de una civilización perdida, llenos de secretos y tesoros.', 'ruinas_antiguas.jpg', 9, 20),
    ('Isla del Misterio', 'Una isla remota con ecosistemas únicos y criaturas exóticas.', 'isla_misterio.jpg', 10, 18),
    ('Tienda Central', 'El principal centro de comercio de la región.', 'tienda_central.jpg', 11, 1);

-- Insertar efectos de mapas
INSERT INTO mapa_efecto (mapa_id, efecto_id)
VALUES
    (1, 1),  -- Bosque Oscuro: Fuerza Mejorada
    (1, 2),  -- Bosque Oscuro: Veneno
    (2, 3),  -- Montañas del Dragón: Escudo de Protección
    (2, 4),  -- Montañas del Dragón: Congelación
    (3, 5),  -- Mazmorra de las Sombras: Regeneración
    (3, 6),  -- Mazmorra de las Sombras: Maldición Oscura
    (4, 7),  -- Desierto Ardiente: Ira del Guerrero
    (4, 8),  -- Desierto Ardiente: Ceguera
    (5, 9),  -- Ciudad de los Mercaderes: Bendición Divina
    (5, 10), -- Ciudad de los Mercaderes: Quemadura
    (6, 1),  -- Pantano Venenoso: Fuerza Mejorada
    (6, 2),  -- Pantano Venenoso: Veneno
    (7, 3),  -- Llanuras del Viento: Escudo de Protección
    (7, 4),  -- Llanuras del Viento: Congelación
    (8, 5),  -- Cueva de Cristal: Regeneración
    (8, 6),  -- Cueva de Cristal: Maldición Oscura
    (9, 7),  -- Ruinas Antiguas: Ira del Guerrero
    (9, 8),  -- Ruinas Antiguas: Ceguera
    (10, 9), -- Isla del Misterio: Bendición Divina
    (10, 10);-- Isla del Misterio: Quemadura

-- Insertar tipos de item
INSERT INTO tipo_item (nombre, descripcion)
VALUES
    ('consumible', 'Consumibles que pueden ser usados para restaurar salud, energía, etc.'),
    ('equipo', 'Equipo que puede ser equipado por los personajes.'),
    ('material', 'Materiales que pueden ser usados para misiones o crafteo.');



INSERT INTO items (nombre, tipo_item, descripcion, acumulaciones_max, precio_base, valor_dinamico)
VALUES
    -- Consumibles
    ('Poción de Vida', 1, 'Restaura 50 puntos de vida.', 99, 20, 50),
    ('Poción de Maná', 1, 'Restaura 30 puntos de maná.', 99, 30, 30),
    ('Poción de Energía', 1, 'Restaura 40 puntos de energía.', 99, 25, 40),
    ('Elixir de Vida', 1, 'Restaura 100 puntos de vida.', 99, 50, 100),
    ('Elixir de Maná', 1, 'Restaura 80 puntos de maná.', 99, 60, 80),
    ('Poción de Fuerza', 1, 'Aumenta el ataque físico en 10 puntos durante 5 minutos.', 99, 40, 10),
    ('Poción de Defensa', 1, 'Aumenta la defensa física en 10 puntos durante 5 minutos.', 99, 40, 10),
    ('Poción de Invisibilidad', 1, 'Otorga invisibilidad durante 1 minuto.', 99, 100, 0),

    -- Equipo
    ('Espada de Acero', 2, 'Una espada resistente hecha de acero.', 1, 100, 20),
    ('Escudo de Madera', 2, 'Un escudo ligero hecho de madera.', 1, 50, 10),
    ('Daga Afilada', 2, 'Una daga ligera y rápida.', 1, 80, 15),
    ('Armadura de Platino', 2, 'Una armadura pesada pero muy resistente.', 1, 300, 50),
    ('Anillo de Poder', 2, 'Aumenta el ataque mágico en 15 puntos.', 1, 150, 15),
    ('Martillo de Guerra', 2, 'Un martillo pesado que inflige gran daño.', 1, 200, 30),
    ('Capa del Mago', 2, 'Aumenta la defensa mágica en 20 puntos.', 1, 120, 20),
    ('Báculo Arcano', 2, 'Un báculo que potencia las habilidades mágicas.', 1, 180, 25),
    ('Botas de Velocidad', 2, 'Aumentan la velocidad de movimiento.', 1, 90, 15),
    ('Cinturón de Resistencia', 2, 'Aumenta la resistencia física.', 1, 70, 10),
    ('Guantes de Acero', 2, 'Mejoran la destreza y el ataque.', 1, 110, 18),
    ('Amuleto de Protección', 2, 'Otorga protección mágica.', 1, 130, 20),

    -- Materiales
    ('Hierro', 3, 'Material de crafteo común.', 99, 5, 0),
    ('Piedra Mágica', 3, 'Material raro usado en crafteo avanzado.', 99, 50, 0),
    ('Piedra de Fuego', 3, 'Material usado para crear armas de fuego.', 99, 30, 0),
    ('Cuero', 3, 'Material usado para fabricar armaduras ligeras.', 99, 10, 0),
    ('Cristal Mágico', 3, 'Material mágico usado en encantamientos.', 99, 100, 0),
    ('Madera de Roble', 3, 'Madera resistente usada en crafteo.', 99, 15, 0),
    ('Hueso de Dragón', 3, 'Material legendario usado en crafteo de alto nivel.', 99, 200, 0),
    ('Plata', 3, 'Metal precioso usado en joyería y crafteo.', 99, 40, 0),
    ('Oro', 3, 'Metal valioso usado en crafteo de élite.', 99, 80, 0),
    ('Gema Brillante', 3, 'Gema rara usada en crafteo mágico.', 99, 150, 0);

INSERT INTO item_efecto (item_id, efecto_id)
VALUES
    -- Consumibles
    (1, 5),   -- Poción de Vida: Regeneración
    (2, 9),   -- Poción de Maná: Bendición Divina
    (3, 17),  -- Poción de Energía: Velocidad Mejorada
    (4, 5),   -- Elixir de Vida: Regeneración
    (5, 9),   -- Elixir de Maná: Bendición Divina
    (6, 1),   -- Poción de Fuerza: Fuerza Mejorada
    (7, 15),  -- Poción de Defensa: Aura Sagrada
    (8, 11),  -- Poción de Invisibilidad: Invisibilidad

    -- Equipo
    (9, 1),   -- Espada de Acero: Fuerza Mejorada
    (10, 3),  -- Escudo de Madera: Escudo de Protección
    (11, 1),  -- Daga Afilada: Fuerza Mejorada
    (12, 3),  -- Armadura de Platino: Escudo de Protección
    (13, 9),  -- Anillo de Poder: Bendición Divina
    (14, 1),  -- Martillo de Guerra: Fuerza Mejorada
    (15, 15), -- Capa del Mago: Aura Sagrada
    (16, 9),  -- Báculo Arcano: Bendición Divina
    (17, 17), -- Botas de Velocidad: Velocidad Mejorada
    (18, 15), -- Cinturón de Resistencia: Aura Sagrada
    (19, 1),  -- Guantes de Acero: Fuerza Mejorada
    (20, 15); -- Amuleto de Protección: Aura Sagrada

-- Insertar tipos de equipamiento
INSERT INTO tipo_equipamiento (nombre, descripcion) VALUES
('Arma Principal', 'Arma principal del personaje, como espadas, hachas o bastones.'),
('Arma Secundaria', 'Arma secundaria, como escudos o dagas.'),
('Casco', 'Protege la cabeza de daños físicos y mágicos.'),
('Pecho', 'Protege el torso, ofrece alta defensa.'),
('Pantalón', 'Protege las piernas y ofrece movilidad.'),
('Botas', 'Protegen los pies y aumentan la velocidad.'),
('Accesorio 1', 'Aumenta estadísticas como ataque, defensa o energía.'),
('Accesorio 2', 'Proporciona efectos vida o protección adicional.');

-- Insertar drops de monstruos
INSERT INTO drops_objetos (monstruo_id, item_id, probabilidad)
VALUES
    -- Goblin (monstruo_id = 1)
    (1, 1, 50),   -- Goblin puede soltar Poción de Vida con 50% de probabilidad
    (1, 21, 30),  -- Goblin puede soltar Hierro con 30% de probabilidad
    (1, 24, 10),  -- Goblin puede soltar Cuero con 10% de probabilidad

    -- Ogro (monstruo_id = 2)
    (2, 2, 40),   -- Ogro puede soltar Poción de Maná con 40% de probabilidad
    (2, 21, 50),  -- Ogro puede soltar Hierro con 50% de probabilidad
    (2, 22, 20),  -- Ogro puede soltar Piedra Mágica con 20% de probabilidad

    -- Dragón (monstruo_id = 3)
    (3, 4, 30),   -- Dragón puede soltar Elixir de Vida con 30% de probabilidad
    (3, 5, 30),   -- Dragón puede soltar Elixir de Maná con 30% de probabilidad
    (3, 27, 10),  -- Dragón puede soltar Hueso de Dragón con 10% de probabilidad
    (3, 26, 20),  -- Dragón puede soltar Madera de Roble con 20% de probabilidad

    -- Bandido (monstruo_id = 4)
    (4, 1, 60),   -- Bandido puede soltar Poción de Vida con 60% de probabilidad
    (4, 21, 40),  -- Bandido puede soltar Hierro con 40% de probabilidad
    (4, 24, 20),  -- Bandido puede soltar Cuero con 20% de probabilidad

    -- Lobo Salvaje (monstruo_id = 5)
    (5, 24, 70),  -- Lobo Salvaje puede soltar Cuero con 70% de probabilidad
    (5, 21, 30),  -- Lobo Salvaje puede soltar Hierro con 30% de probabilidad

    -- Esqueleto Guerrero (monstruo_id = 6)
    (6, 2, 40),   -- Esqueleto Guerrero puede soltar Poción de Maná con 40% de probabilidad
    (6, 22, 30),  -- Esqueleto Guerrero puede soltar Piedra Mágica con 30% de probabilidad
    (6, 25, 10),  -- Esqueleto Guerrero puede soltar Cristal Mágico con 10% de probabilidad

    -- Araña Gigante (monstruo_id = 7)
    (7, 24, 80),  -- Araña Gigante puede soltar Cuero con 80% de probabilidad
    (7, 22, 20),  -- Araña Gigante puede soltar Piedra Mágica con 20% de probabilidad

    -- Bandido Líder (monstruo_id = 8)
    (8, 4, 50),   -- Bandido Líder puede soltar Elixir de Vida con 50% de probabilidad
    (8, 5, 50),   -- Bandido Líder puede soltar Elixir de Maná con 50% de probabilidad
    (8, 28, 10),  -- Bandido Líder puede soltar Plata con 10% de probabilidad

    -- Nigromante (monstruo_id = 9)
    (9, 5, 60),   -- Nigromante puede soltar Elixir de Maná con 60% de probabilidad
    (9, 25, 30),  -- Nigromante puede soltar Cristal Mágico con 30% de probabilidad
    (9, 22, 20),  -- Nigromante puede soltar Piedra Mágica con 20% de probabilidad

    -- Araña (monstruo_id = 10)
    (10, 24, 90), -- Araña puede soltar Cuero con 90% de probabilidad
    (10, 21, 10); -- Araña puede soltar Hierro con 10% de probabilidad

-- Insertar objetos equipables
INSERT INTO estadisticas_equipamiento (item_id, tipo_equipamiento_id, vida_base, escudo_base, energia_base, mana_base, ataque_fisico_base, ataque_magico_base, defensa_fisica, defensa_magica)
VALUES
    -- Arma Principal
    (9, 1, 0, 0, 0, 0, 20, 0, 0, 0),   -- Espada de Acero: Aumenta el ataque físico en 20
    (11, 1, 0, 0, 0, 0, 15, 0, 0, 0),  -- Daga Afilada: Aumenta el ataque físico en 15
    (14, 1, 0, 0, 0, 0, 30, 0, 0, 0),  -- Martillo de Guerra: Aumenta el ataque físico en 30
    (16, 1, 0, 0, 0, 0, 0, 25, 0, 0),  -- Báculo Arcano: Aumenta el ataque mágico en 25

    -- Arma Secundaria
    (10, 2, 0, 10, 0, 0, 0, 0, 0, 0),  -- Escudo de Madera: Aumenta el escudo en 10
    (19, 2, 0, 0, 0, 0, 18, 0, 0, 0),  -- Guantes de Acero: Aumenta el ataque físico en 18

    -- Casco
    (12, 3, 0, 0, 0, 0, 0, 0, 15, 10), -- Armadura de Platino: Aumenta la defensa física en 15 y mágica en 10

    -- Pecho
    (12, 4, 0, 0, 0, 0, 0, 0, 50, 0),  -- Armadura de Platino: Aumenta la defensa física en 50

    -- Pantalón
    (12, 5, 0, 0, 0, 0, 0, 0, 30, 0),  -- Armadura de Platino: Aumenta la defensa física en 30

    -- Botas
    (17, 6, 0, 0, 20, 0, 0, 0, 0, 0),  -- Botas de Velocidad: Aumenta la energía en 20

    -- Accesorio 1
    (13, 7, 0, 0, 0, 15, 0, 0, 0, 0),  -- Anillo de Poder: Aumenta el maná en 15
    (20, 7, 0, 0, 0, 0, 0, 0, 20, 20), -- Amuleto de Protección: Aumenta la defensa física y mágica en 20

    -- Accesorio 2
    (15, 8, 0, 0, 0, 0, 0, 20, 0, 0),  -- Capa del Mago: Aumenta la defensa mágica en 20
    (18, 8, 0, 0, 0, 0, 0, 0, 10, 0);  -- Cinturón de Resistencia: Aumenta la defensa física en 10

-- Insertar inventario de personajes
INSERT INTO inventario_personaje (personaje_id, item_id, cantidad, equipado, fecha_obtencion)
VALUES
    -- Aragorn (personaje_id = 1)
    (1, 9, 1, 1, '2023-10-01 12:00:00'),  -- Espada de Acero (equipada)
    (1, 10, 1, 1, '2023-10-01 12:05:00'), -- Escudo de Madera (equipado)
    (1, 1, 5, 0, '2023-10-01 12:10:00'),  -- Poción de Vida (5 unidades, no equipada)
    (1, 21, 10, 0, '2023-10-01 12:15:00'), -- Hierro (10 unidades, no equipado)

    -- Gandalf (personaje_id = 2)
    (2, 16, 1, 1, '2023-10-02 13:00:00'), -- Báculo Arcano (equipado)
    (2, 15, 1, 1, '2023-10-02 13:05:00'), -- Capa del Mago (equipada)
    (2, 2, 3, 0, '2023-10-02 13:10:00'),  -- Poción de Maná (3 unidades, no equipada)
    (2, 22, 5, 0, '2023-10-02 13:15:00'), -- Piedra Mágica (5 unidades, no equipada)

    -- Legolas (personaje_id = 3)
    (3, 11, 1, 1, '2023-10-03 14:00:00'), -- Daga Afilada (equipada)
    (3, 17, 1, 1, '2023-10-03 14:05:00'), -- Botas de Velocidad (equipadas)
    (3, 3, 2, 0, '2023-10-03 14:10:00'),  -- Poción de Energía (2 unidades, no equipada)
    (3, 24, 8, 0, '2023-10-03 14:15:00'), -- Cuero (8 unidades, no equipado)

    -- Frodo (personaje_id = 4)
    (4, 12, 1, 1, '2023-10-04 15:00:00'), -- Armadura de Platino (equipada)
    (4, 18, 1, 1, '2023-10-04 15:05:00'), -- Cinturón de Resistencia (equipado)
    (4, 4, 1, 0, '2023-10-04 15:10:00'),  -- Elixir de Vida (1 unidad, no equipada)
    (4, 25, 3, 0, '2023-10-04 15:15:00'), -- Cristal Mágico (3 unidades, no equipado)

    -- Gimli (personaje_id = 5)
    (5, 14, 1, 1, '2023-10-05 16:00:00'), -- Martillo de Guerra (equipado)
    (5, 10, 1, 1, '2023-10-05 16:05:00'), -- Escudo de Madera (equipado)
    (5, 5, 2, 0, '2023-10-05 16:10:00'),  -- Elixir de Maná (2 unidades, no equipado)
    (5, 26, 4, 0, '2023-10-05 16:15:00'); -- Madera de Roble (4 unidades, no equipada)


-- Insertar habilidades
INSERT INTO habilidades (imagen, nombre, descripcion, nivel_maximo, requisito_nivel, tipo_habilidad, objetivo_habilidad, area_efecto, unidades_afectadas, curacion_base,vida_base, escudo_base, energia_base, mana_base, ataque_fisico_base, ataque_magico_base, defensa_fisica, defensa_magica, enfriamiento)
VALUES
    -- Habilidades Ofensivas
    ('golpe_critico.jpg', 'Golpe Crítico', 'Un ataque poderoso que inflige daño crítico.', 5, 1, 'OFENSIVA', 'ENEMIGO', 1, 1, 0, 0, 20, 0, 50, 0,0, 0, 0, 10),
    ('bola_fuego.jpg', 'Bola de Fuego', 'Lanza una bola de fuego que quema a los enemigos.', 3, 3, 'OFENSIVA', 'ENEMIGO', 3, 3, 0, 0, 0, 30, 0, 0,40, 0, 0, 15),
    ('rayo_helado.jpg', 'Rayo Helado', 'Un rayo de hielo que congela a los enemigos.', 4, 5, 'OFENSIVA', 'ENEMIGO', 2, 2, 0, 0, 0, 25, 0, 35, 0,0, 0, 12),

    -- Habilidades Defensivas
    ('escudo_proteccion.jpg', 'Escudo de Protección', 'Crea un escudo que absorbe daño.', 3, 2, 'DEFENSIVA', 'JUGADOR', 1, 1, 0, 50, 0, 20, 0,0, 0, 0, 0, 20),
    ('cura_menor.jpg', 'Cura Menor', 'Cura una pequeña cantidad de vida.', 4, 2, 'DEFENSIVA', 'ALIADO', 1, 1, 30, 0, 0, 15, 0, 0, 0, 0,0, 10),
    ('fortalecer.jpg', 'Fortalecer', 'Aumenta la defensa física y mágica.', 2, 4, 'DEFENSIVA', 'JUGADOR', 1, 1, 0, 0, 0, 20, 0, 0, 10,0, 10, 15),

    -- Habilidades de Apoyo
    ('bendicion.jpg', 'Bendición', 'Aumenta el ataque y la defensa de los aliados.', 3, 5, 'APOYO', 'ALIADO', 5, 5, 0, 0, 0, 40, 10, 10, 10,0, 10, 30),
    ('invisibilidad.jpg', 'Invisibilidad', 'Hace al jugador invisible por un tiempo.', 2, 6, 'APOYO', 'JUGADOR', 1, 1, 0, 0, 0, 50, 0, 0, 0,0, 0, 60),
    ('regeneracion.jpg', 'Regeneración', 'Regenera la vida y el maná de los aliados.', 4, 7, 'APOYO', 'ALIADO', 4, 4, 20, 0, 0, 30, 0, 0, 0,0, 0, 25),

    -- Habilidades Ofensivas
    ('corte_sombrio.jpg', 'Corte Sombrío', 'Un ataque rápido que inflige daño oscuro.', 4, 4, 'OFENSIVA', 'ENEMIGO', 1, 1, 0, 0, 25, 0, 40, 0, 0,0, 0, 8),
    ('tormenta_electrica.jpg', 'Tormenta Eléctrica', 'Invoca una tormenta eléctrica que daña a múltiples enemigos.', 3, 6, 'OFENSIVA', 'ENEMIGO', 4, 4, 0, 0, 0, 50, 0, 60,0, 0, 0, 20),
    ('lanzamiento_dual.jpg', 'Lanzamiento Dual', 'Ataca dos veces con armas arrojadizas.', 5, 3, 'OFENSIVA', 'ENEMIGO', 1, 1, 0, 0, 30, 0, 35, 0,0, 0, 0, 12),

    -- Habilidades Defensivas
    ('escudo_divino.jpg', 'Escudo Divino', 'Protege al jugador con un escudo mágico.', 3, 5, 'DEFENSIVA', 'JUGADOR', 1, 1, 0, 100, 0, 40, 0, 0, 0,0, 0, 30),
    ('regeneracion_rapida.jpg', 'Regeneración Rápida', 'Cura una cantidad moderada de vida rápidamente.', 4, 4, 'DEFENSIVA', 'ALIADO', 1, 1, 50, 0, 0, 25, 0, 0,0, 0, 0, 15),
    ('aura_proteccion.jpg', 'Aura de Protección', 'Aumenta la defensa de todos los aliados en un área.', 3, 7, 'DEFENSIVA', 'ALIADO', 5, 5, 0, 0, 0, 35, 0, 0, 15,0, 15, 25),

    -- Habilidades de Apoyo
    ('bendicion_sagrada.jpg', 'Bendición Sagrada', 'Aumenta el ataque y la defensa mágica de los aliados.', 4, 8, 'APOYO', 'ALIADO', 5, 5, 0, 0, 0, 50, 15, 15, 0,0, 20, 40),
    ('teletransportacion.jpg', 'Teletransportación', 'Teletransporta al jugador a un lugar seguro.', 2, 9, 'APOYO', 'JUGADOR', 1, 1, 0, 0, 0, 60, 0, 0, 0,0, 0, 90),
    ('lluvia_curacion.jpg', 'Lluvia de Curación', 'Cura a todos los aliados en un área amplia.', 5, 10, 'APOYO', 'ALIADO', 6, 6, 40, 0, 0, 45, 0, 0, 0,0, 0, 35);


-- Insertar efectos de habilidades
INSERT INTO habilidad_efecto (habilidad_id, efecto_id)
VALUES
    -- Golpe Crítico (habilidad_id = 1)
    (1, 1),  -- Golpe Crítico: Fuerza Mejorada

    -- Bola de Fuego (habilidad_id = 2)
    (2, 10), -- Bola de Fuego: Quemadura

    -- Rayo Helado (habilidad_id = 3)
    (3, 4),  -- Rayo Helado: Congelación

    -- Escudo de Protección (habilidad_id = 4)
    (4, 3),  -- Escudo de Protección: Escudo de Protección

    -- Cura Menor (habilidad_id = 5)
    (5, 5),  -- Cura Menor: Regeneración

    -- Fortalecer (habilidad_id = 6)
    (6, 15), -- Fortalecer: Aura Sagrada

    -- Bendición (habilidad_id = 7)
    (7, 9),  -- Bendición: Bendición Divina

    -- Invisibilidad (habilidad_id = 8)
    (8, 11), -- Invisibilidad: Invisibilidad

    -- Regeneración (habilidad_id = 9)
    (9, 5),  -- Regeneración: Regeneración

    -- Corte Sombrío (habilidad_id = 10)
    (10, 1), -- Corte Sombrío: Fuerza Mejorada

    -- Tormenta Eléctrica (habilidad_id = 11)
    (11, 12),-- Tormenta Eléctrica: Parálisis

    -- Lanzamiento Dual (habilidad_id = 12)
    (12, 1), -- Lanzamiento Dual: Fuerza Mejorada

    -- Escudo Divino (habilidad_id = 13)
    (13, 3), -- Escudo Divino: Escudo de Protección

    -- Regeneración Rápida (habilidad_id = 14)
    (14, 5), -- Regeneración Rápida: Regeneración

    -- Aura de Protección (habilidad_id = 15)
    (15, 15),-- Aura de Protección: Aura Sagrada

    -- Bendición Sagrada (habilidad_id = 16)
    (16, 9), -- Bendición Sagrada: Bendición Divina

    -- Teletransportación (habilidad_id = 17)
    (17, 11),-- Teletransportación: Invisibilidad

    -- Lluvia de Curación (habilidad_id = 18)
    (18, 5); -- Lluvia de Curación: Regeneración


-- Insertar habilidades de personajes
INSERT INTO personaje_habilidad (personaje_id, habilidad_id, nivel_habilidad, ultimo_uso)
VALUES
    -- Aragorn (personaje_id = 1)
    (1, 1, 3, '2023-10-01 12:30:00'),  -- Golpe Crítico (nivel 3)
    (1, 4, 2, '2023-10-01 12:35:00'),  -- Escudo de Protección (nivel 2)
    (1, 7, 1, '2023-10-01 12:40:00'),  -- Bendición (nivel 1)

    -- Gandalf (personaje_id = 2)
    (2, 2, 4, '2023-10-02 13:30:00'),  -- Bola de Fuego (nivel 4)
    (2, 5, 3, '2023-10-02 13:35:00'),  -- Cura Menor (nivel 3)
    (2, 8, 2, '2023-10-02 13:40:00'),  -- Invisibilidad (nivel 2)

    -- Legolas (personaje_id = 3)
    (3, 3, 2, '2023-10-03 14:30:00'),  -- Rayo Helado (nivel 2)
    (3, 6, 1, '2023-10-03 14:35:00'),  -- Fortalecer (nivel 1)
    (3, 9, 3, '2023-10-03 14:40:00'),  -- Regeneración (nivel 3)

    -- Frodo (personaje_id = 4)
    (4, 4, 1, '2023-10-04 15:30:00'),  -- Escudo de Protección (nivel 1)
    (4, 7, 2, '2023-10-04 15:35:00'),  -- Bendición (nivel 2)
    (4, 10, 1, '2023-10-04 15:40:00'), -- Corte Sombrío (nivel 1)

    -- Gimli (personaje_id = 5)
    (5, 1, 5, '2023-10-05 16:30:00'),  -- Golpe Crítico (nivel 5)
    (5, 12, 2, '2023-10-05 16:35:00'), -- Lanzamiento Dual (nivel 2)
    (5, 15, 1, '2023-10-05 16:40:00'); -- Aura de Protección (nivel 1)


-- Insertar habilidades de monstruos
INSERT INTO monstruo_habilidad (monstruo_id, habilidad_id, nivel_habilidad, probabilidad_uso)
VALUES
    -- Goblin (monstruo_id = 1)
    (1, 1, 2, 50),  -- Goblin usa Golpe Crítico (nivel 2) con 50% de probabilidad
    (1, 10, 1, 30), -- Goblin usa Corte Sombrío (nivel 1) con 30% de probabilidad

    -- Ogro (monstruo_id = 2)
    (2, 1, 3, 70),  -- Ogro usa Golpe Crítico (nivel 3) con 70% de probabilidad
    (2, 12, 2, 40), -- Ogro usa Lanzamiento Dual (nivel 2) con 40% de probabilidad

    -- Dragón (monstruo_id = 3)
    (3, 2, 4, 80),  -- Dragón usa Bola de Fuego (nivel 4) con 80% de probabilidad
    (3, 3, 3, 60),  -- Dragón usa Rayo Helado (nivel 3) con 60% de probabilidad
    (3, 11, 2, 50), -- Dragón usa Tormenta Eléctrica (nivel 2) con 50% de probabilidad

    -- Bandido (monstruo_id = 4)
    (4, 1, 2, 60),  -- Bandido usa Golpe Crítico (nivel 2) con 60% de probabilidad
    (4, 10, 1, 40), -- Bandido usa Corte Sombrío (nivel 1) con 40% de probabilidad

    -- Lobo Salvaje (monstruo_id = 5)
    (5, 1, 1, 70),  -- Lobo Salvaje usa Golpe Crítico (nivel 1) con 70% de probabilidad

    -- Esqueleto Guerrero (monstruo_id = 6)
    (6, 1, 2, 50),  -- Esqueleto Guerrero usa Golpe Crítico (nivel 2) con 50% de probabilidad
    (6, 12, 1, 30), -- Esqueleto Guerrero usa Lanzamiento Dual (nivel 1) con 30% de probabilidad

    -- Araña Gigante (monstruo_id = 7)
    (7, 10, 2, 60), -- Araña Gigante usa Corte Sombrío (nivel 2) con 60% de probabilidad
    (7, 11, 1, 40), -- Araña Gigante usa Tormenta Eléctrica (nivel 1) con 40% de probabilidad

    -- Bandido Líder (monstruo_id = 8)
    (8, 1, 3, 80),  -- Bandido Líder usa Golpe Crítico (nivel 3) con 80% de probabilidad
    (8, 12, 2, 50), -- Bandido Líder usa Lanzamiento Dual (nivel 2) con 50% de probabilidad

    -- Nigromante (monstruo_id = 9)
    (9, 2, 3, 70),  -- Nigromante usa Bola de Fuego (nivel 3) con 70% de probabilidad
    (9, 3, 2, 50),  -- Nigromante usa Rayo Helado (nivel 2) con 50% de probabilidad

    -- Araña (monstruo_id = 10)
    (10, 10, 1, 60); -- Araña usa Corte Sombrío (nivel 1) con 60% de probabilidad


-- Insertar tipos de NPC
INSERT INTO tipo_npc (nombre, descripcion)
VALUES
    ('Aldeano', 'Un aldeano común que ofrece misiones simples.'),
    ('Mercader', 'Un mercader que vende objetos útiles.'),
    ('Guardia', 'Un guardia que protege la ciudad.'),
    ('Mago', 'Un mago que ofrece misiones mágicas.'),
    ('Herrero', 'Un herrero que puede mejorar tu equipo.'),
    ('Bruja', 'Una bruja que ofrece pociones y hechizos.'),
    ('Explorador', 'Un explorador que conoce los secretos del mundo.'),
    ('Sacerdote', 'Un sacerdote que cura y bendice a los aventureros.'),
    ('Bardo', 'Un bardo que cuenta historias y ofrece entretenimiento.'),
    ('Cazador', 'Un cazador que ofrece misiones de cacería.');


-- Insertar NPCs
INSERT INTO npc (nombre, descripcion, imagen, tipo_npc)
VALUES
    -- Aldeanos
    ('Juan el Granjero', 'Un granjero amable que necesita ayuda con sus cultivos.', 'juan_granjero.jpg', 1),
    ('María la Tejedora', 'Una tejedora que busca materiales para sus telares.', 'maria_tejedora.jpg', 1),

    -- Mercaderes
    ('Luis el Mercader', 'Un mercader que vende objetos útiles para aventureros.', 'luis_mercader.jpg', 2),
    ('Ana la Comerciante', 'Una comerciante que ofrece productos exóticos.', 'ana_comerciante.jpg', 2),

    -- Guardias
    ('Carlos el Guardia', 'Un guardia que protege la entrada de la ciudad.', 'carlos_guardia.jpg', 3),
    ('Sofía la Capitana', 'La capitana de la guardia, conocida por su valentía.', 'sofia_capitana.jpg', 3),

    -- Magos
    ('Merlín el Sabio', 'Un mago anciano que conoce los secretos del mundo.', 'merlin_sabio.jpg', 4),
    ('Elena la Hechicera', 'Una hechicera poderosa que ofrece misiones mágicas.', 'elena_hechicera.jpg', 4),

    -- Herreros
    ('Pedro el Herrero', 'Un herrero experto en forjar armas y armaduras.', 'pedro_herrero.jpg', 5),
    ('Lucía la Forjadora', 'Una forjadora que crea equipo de alta calidad.', 'lucia_forjadora.jpg', 5),

    -- Brujas
    ('Morgana la Bruja', 'Una bruja que vive en el bosque y ofrece pociones.', 'morgana_bruja.jpg', 6),
    ('Helga la Alquimista', 'Una alquimista que busca ingredientes raros.', 'helga_alquimista.jpg', 6),

    -- Exploradores
    ('Lucas el Explorador', 'Un explorador que conoce los rincones más oscuros del mundo.', 'lucas_explorador.jpg', 7),
    ('Isabel la Cartógrafa', 'Una cartógrafa que dibuja mapas detallados.', 'isabel_cartografa.jpg', 7),

    -- Sacerdotes
    ('Padre Miguel', 'Un sacerdote que bendice a los aventureros.', 'padre_miguel.jpg', 8),
    ('Hermana Clara', 'Una monja que cura a los heridos.', 'hermana_clara.jpg', 8),

    -- Bardos
    ('Roberto el Bardo', 'Un bardo que canta historias de héroes antiguos.', 'roberto_bardo.jpg', 9),
    ('Laura la Juglaresa', 'Una juglaresa que entretiene con sus trucos.', 'laura_juglaresa.jpg', 9),

    -- Cazadores
    ('Diego el Cazador', 'Un cazador que rastrea bestias peligrosas.', 'diego_cazador.jpg', 10),
    ('Carmen la Rastreadora', 'Una rastreadora que conoce los hábitos de las criaturas.', 'carmen_rastreadora.jpg', 10);


-- Insertar datos en la tabla misiones
INSERT INTO misiones (nombre, descripcion, nivel_minimo, recompensa_almas, recompensa_experiencia, tiempo_limite)
VALUES
    ('Cosecha en peligro', 'Ayuda al granjero Juan a proteger sus cultivos de las plagas.', 1, 50, 100, 60),
    ('El mercader desaparecido', 'Encuentra al mercader Luis, quien ha desaparecido en el bosque.', 3, 100, 200, 120),
    ('Protege la ciudad', 'Asiste a la capitana Sofía en la defensa de la ciudad contra bandidos.', 5, 200, 400, 180),
    ('El secreto del mago', 'Ayuda al mago Merlín a recuperar un artefacto mágico perdido.', 7, 300, 600, 240),
    ('Forja legendaria', 'Consigue los materiales necesarios para que el herrero Pedro cree una espada legendaria.', 10, 500, 1000, 300),
    ('La poción perdida', 'Ayuda a la bruja Morgana a encontrar los ingredientes para una poción especial.', 2, 80, 150, 90),
    ('Mapa del tesoro', 'Sigue las pistas del explorador Lucas para encontrar un tesoro oculto.', 4, 150, 300, 150),
    ('Bendición divina', 'Obtén la bendición del padre Miguel para protegerte en tu viaje.', 6, 250, 500, 200),
    ('Canción del héroe', 'Ayuda al bardo Roberto a componer una canción sobre tus hazañas.', 8, 350, 700, 250),
    ('Caza mayor', 'Acompaña al cazador Diego en la caza de una bestia peligrosa.', 9, 400, 800, 270),
    ('Protege los cultivos', 'Ayuda al granjero Juan a proteger sus cultivos de las plagas.', 1, 60, 120, 60),
    ('Recupera la mercancía perdida', 'Encuentra la mercancía robada del mercader Luis.', 3, 120, 240, 120),
    ('Entrena a los reclutas', 'Ayuda a la capitana Sofía a entrenar a los nuevos guardias.', 5, 220, 440, 180),
    ('Recupera el grimorio perdido', 'Encuentra el grimorio que el mago Merlín necesita.', 7, 320, 640, 240),
    ('Consigue minerales raros', 'Busca minerales raros para el herrero Pedro.', 10, 520, 1040, 300),
    ('Encuentra la flor mágica', 'Localiza la flor que la bruja Morgana necesita para su poción.', 2, 90, 180, 90),
    ('Explora las ruinas antiguas', 'Investiga las ruinas en busca de secretos.', 4, 160, 320, 150),
    ('Protege el templo', 'Defiende el templo de los invasores.', 6, 260, 520, 200),
    ('Encuentra la lira dorada', 'Busca la lira perdida para el bardo Roberto.', 8, 360, 720, 250),
    ('Caza mayor', 'Caza una bestia peligrosa en el bosque.', 9, 420, 840, 270);


-- Insertar recompensas de misiones
INSERT INTO mision_objetos (mision_id, item_id, cantidad)
VALUES
    -- Cosecha en peligro (mision_id = 1)
    (1, 21, 10),  -- Recolectar 10 unidades de Hierro
    (1, 24, 5),   -- Recolectar 5 unidades de Cuero

    -- El mercader desaparecido (mision_id = 2)
    (2, 22, 3),   -- Recolectar 3 unidades de Piedra Mágica
    (2, 25, 2),   -- Recolectar 2 unidades de Cristal Mágico

    -- Protege la ciudad (mision_id = 3)
    (3, 26, 8),   -- Recolectar 8 unidades de Madera de Roble
    (3, 27, 1),   -- Recolectar 1 unidad de Hueso de Dragón

    -- El secreto del mago (mision_id = 4)
    (4, 22, 5),   -- Recolectar 5 unidades de Piedra Mágica
    (4, 25, 3),   -- Recolectar 3 unidades de Cristal Mágico

    -- Forja legendaria (mision_id = 5)
    (5, 21, 20),  -- Recolectar 20 unidades de Hierro
    (5, 28, 5),   -- Recolectar 5 unidades de Plata
    (5, 29, 2),   -- Recolectar 2 unidades de Oro

    -- La poción perdida (mision_id = 6)
    (6, 22, 4),   -- Recolectar 4 unidades de Piedra Mágica
    (6, 24, 6),   -- Recolectar 6 unidades de Cuero

    -- Mapa del tesoro (mision_id = 7)
    (7, 25, 3),   -- Recolectar 3 unidades de Cristal Mágico
    (7, 26, 10),  -- Recolectar 10 unidades de Madera de Roble

    -- Bendición divina (mision_id = 8)
    (8, 22, 2),   -- Recolectar 2 unidades de Piedra Mágica
    (8, 25, 1),   -- Recolectar 1 unidad de Cristal Mágico

    -- Canción del héroe (mision_id = 9)
    (9, 24, 7),   -- Recolectar 7 unidades de Cuero
    (9, 26, 5),   -- Recolectar 5 unidades de Madera de Roble

    -- Caza mayor (mision_id = 10)
    (10, 27, 3),  -- Recolectar 3 unidades de Hueso de Dragón
    (10, 28, 2);  -- Recolectar 2 unidades de Plata


-- Insertar misiones de personajes
INSERT INTO personaje_mision (personaje_id, mision_id, fecha_inicio, fecha_fin, estado)
VALUES
    -- Aragorn (personaje_id = 1)
    (1, 1, '2023-10-01 12:00:00', '2023-10-01 13:00:00', 'COMPLETADA'),  -- Cosecha en peligro
    (1, 2, '2023-10-02 14:00:00', NULL, 'EN_PROGRESO'),                 -- El mercader desaparecido

    -- Gandalf (personaje_id = 2)
    (2, 3, '2023-10-03 15:00:00', '2023-10-03 17:00:00', 'COMPLETADA'),  -- Protege la ciudad
    (2, 4, '2023-10-04 18:00:00', NULL, 'EN_PROGRESO'),                 -- El secreto del mago

    -- Legolas (personaje_id = 3)
    (3, 5, '2023-10-05 19:00:00', NULL, 'EN_PROGRESO'),                 -- Forja legendaria
    (3, 6, '2023-10-06 20:00:00', '2023-10-06 21:00:00', 'COMPLETADA'),  -- La poción perdida

    -- Frodo (personaje_id = 4)
    (4, 7, '2023-10-07 22:00:00', NULL, 'EN_PROGRESO'),                 -- Mapa del tesoro
    (4, 8, '2023-10-08 23:00:00', '2023-10-09 00:00:00', 'COMPLETADA'),  -- Bendición divina

    -- Gimli (personaje_id = 5)
    (5, 9, '2023-10-09 10:00:00', NULL, 'EN_PROGRESO'),                 -- Canción del héroe
    (5, 10, '2023-10-10 11:00:00', '2023-10-10 12:00:00', 'FALLIDA');   -- Caza mayor


-- Insertar misiones de NPCs
INSERT INTO npc_mision (npc_id, mision_id)
VALUES
    -- Juan el Granjero (npc_id = 1)
    (1, 1),  -- Cosecha en peligro
    (1, 11), -- Misión adicional: Protege los cultivos

    -- Luis el Mercader (npc_id = 2)
    (2, 2),  -- El mercader desaparecido
    (2, 12), -- Misión adicional: Recupera la mercancía perdida

    -- Sofía la Capitana (npc_id = 3)
    (3, 3),  -- Protege la ciudad
    (3, 13), -- Misión adicional: Entrena a los reclutas

    -- Merlín el Sabio (npc_id = 4)
    (4, 4),  -- El secreto del mago
    (4, 14), -- Misión adicional: Recupera el grimorio perdido

    -- Pedro el Herrero (npc_id = 5)
    (5, 5),  -- Forja legendaria
    (5, 15), -- Misión adicional: Consigue minerales raros

    -- Morgana la Bruja (npc_id = 6)
    (6, 6),  -- La poción perdida
    (6, 16), -- Misión adicional: Encuentra la flor mágica

    -- Lucas el Explorador (npc_id = 7)
    (7, 7),  -- Mapa del tesoro
    (7, 17), -- Misión adicional: Explora las ruinas antiguas

    -- Padre Miguel (npc_id = 8)
    (8, 8),  -- Bendición divina
    (8, 18), -- Misión adicional: Protege el templo

    -- Roberto el Bardo (npc_id = 9)
    (9, 9),  -- Canción del héroe
    (9, 19), -- Misión adicional: Encuentra la lira dorada

    -- Diego el Cazador (npc_id = 10)
    (10, 10), -- Caza mayor
    (10, 20); -- Misión adicional: Caza mayor


-- Insertar monstruos en mapas
INSERT INTO mapa_monstruos (mapa_id, monstruo_id, probabilidad_aparicion)
VALUES
    -- Bosque Oscuro (mapa_id = 1)
    (1, 1, 70),  -- Goblin (70% de probabilidad)
    (1, 5, 50),  -- Lobo Salvaje (50% de probabilidad)
    (1, 7, 30),  -- Araña Gigante (30% de probabilidad)

    -- Montañas del Dragón (mapa_id = 2)
    (2, 2, 60),  -- Ogro (60% de probabilidad)
    (2, 3, 40),  -- Dragón (40% de probabilidad)
    (2, 6, 20),  -- Esqueleto Guerrero (20% de probabilidad)

    -- Mazmorra de las Sombras (mapa_id = 3)
    (3, 6, 80),  -- Esqueleto Guerrero (80% de probabilidad)
    (3, 9, 50),  -- Nigromante (50% de probabilidad)
    (3, 10, 30), -- Araña (30% de probabilidad)

    -- Desierto Ardiente (mapa_id = 4)
    (4, 4, 70),  -- Bandido (70% de probabilidad)
    (4, 8, 40),  -- Bandido Líder (40% de probabilidad)
    (4, 11, 20), -- Lobo Gigante (20% de probabilidad)

    -- Ciudad de los Mercaderes (mapa_id = 5)
    (5, 4, 50),  -- Bandido (50% de probabilidad)
    (5, 8, 30),  -- Bandido Líder (30% de probabilidad)

    -- Pantano Venenoso (mapa_id = 6)
    (6, 5, 60),  -- Lobo Salvaje (60% de probabilidad)
    (6, 7, 40),  -- Araña Gigante (40% de probabilidad)
    (6, 10, 20), -- Araña (20% de probabilidad)

    -- Llanuras del Viento (mapa_id = 7)
    (7, 1, 50),  -- Goblin (50% de probabilidad)
    (7, 5, 30),  -- Lobo Salvaje (30% de probabilidad)

    -- Cueva de Cristal (mapa_id = 8)
    (8, 6, 70),  -- Esqueleto Guerrero (70% de probabilidad)
    (8, 9, 50),  -- Nigromante (50% de probabilidad)
    (8, 12, 20), -- Lobo Sagrado (20% de probabilidad)

    -- Ruinas Antiguas (mapa_id = 9)
    (9, 3, 60),  -- Dragón (60% de probabilidad)
    (9, 6, 40),  -- Esqueleto Guerrero (40% de probabilidad)
    (9, 13, 20), -- Janeiro (20% de probabilidad)

    -- Isla del Misterio (mapa_id = 10)
    (10, 3, 50),  -- Dragón (50% de probabilidad)
    (10, 12, 30), -- Lobo Sagrado (30% de probabilidad)
    (10, 14, 20); -- Troll de Montaña (20% de probabilidad)


-- Insertar productos de NPCs
-- Insertar datos en la tabla npc_producto
INSERT INTO npc_producto (npc_id, item_id, precio_compra, precio_venta, cantidad_venta)
VALUES
    -- Aldeanos
    (1, 1, 10, 20, 5),  -- Juan el Granjero vende Poción de Vida
    (1, 2, 15, 30, 3),  -- Juan el Granjero vende Poción de Maná
    (2, 3, 20, 40, 4),  -- María la Tejedora vende Poción de Energía
    (2, 4, 25, 50, 2),  -- María la Tejedora vende Elixir de Vida

    -- Mercaderes
    (3, 5, 50, 100, 10), -- Luis el Mercader vende Elixir de Maná
    (3, 6, 60, 120, 8),  -- Luis el Mercader vende Poción de Fuerza
    (4, 7, 70, 140, 6),  -- Ana la Comerciante vende Poción de Defensa
    (4, 8, 80, 160, 4),  -- Ana la Comerciante vende Poción de Invisibilidad

    -- Guardias
    (5, 9, 30, 60, 7),   -- Carlos el Guardia vende Espada de Acero
    (5, 10, 40, 80, 5),  -- Carlos el Guardia vende Escudo de Madera
    (6, 11, 50, 100, 6), -- Sofía la Capitana vende Daga Afilada
    (6, 12, 60, 120, 4), -- Sofía la Capitana vende Armadura de Platino

    -- Magos
    (7, 13, 100, 200, 3), -- Merlín el Sabio vende Anillo de Poder
    (7, 14, 120, 240, 2), -- Merlín el Sabio vende Martillo de Guerra
    (8, 15, 150, 300, 1), -- Elena la Hechicera vende Capa del Mago
    (8, 16, 200, 400, 1), -- Elena la Hechicera vende Báculo Arcano

    -- Herreros
    (9, 17, 80, 160, 5),  -- Pedro el Herrero vende Botas de Velocidad
    (9, 18, 90, 180, 4),  -- Pedro el Herrero vende Cinturón de Resistencia
    (10, 19, 100, 200, 3), -- Lucía la Forjadora vende Guantes de Acero
    (10, 20, 110, 220, 2); -- Lucía la Forjadora vende Amuleto de Protección


-- Insertar transacciones de NPCs y personajes
-- Insertar datos en la tabla transacciones_npc_personaje
INSERT INTO transacciones_npc_personaje (personaje_id, tipo_transaccion, npc_id, item_id, cantidad, precio_almas, fecha_transaccion)
VALUES
    -- Transacciones de compra
    (1, 'COMPRA', 1, 1, 2, 40, '2023-10-01 10:00:00'),
    (2, 'COMPRA', 3, 5, 1, 100, '2023-10-01 11:30:00'),
    (3, 'COMPRA', 5, 9, 3, 180, '2023-10-02 09:15:00'),
    (4, 'COMPRA', 7, 13, 1, 200, '2023-10-02 14:45:00'),
    -- Transacciones de venta
    (1, 'VENTA', 2, 3, 1, 20, '2023-10-01 12:00:00'),
    (2, 'VENTA', 4, 7, 2, 140, '2023-10-01 15:30:00'),
    (3, 'VENTA', 6, 11, 1, 50, '2023-10-02 10:00:00'),


    -- Más transacciones de compra
    (6, 'COMPRA', 11, 21, 2, 140, '2023-10-03 12:00:00'),
    (7, 'COMPRA', 13, 25, 1, 60, '2023-10-03 13:45:00'),
    (8, 'COMPRA', 15, 29, 4, 200, '2023-10-04 07:30:00'),


    -- Más transacciones de venta
    (6, 'VENTA', 12, 23, 2, 180, '2023-10-03 15:00:00'),
    (7, 'VENTA', 14, 27, 1, 80, '2023-10-03 16:30:00');
