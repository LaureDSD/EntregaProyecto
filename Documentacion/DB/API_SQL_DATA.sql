
USE api_rpg_bd;
-- Insertar tipos de usuarios
INSERT INTO tipo_usuario (nombre, descripcion) VALUES
('USR', 'Acceso básico al juego, puede crear personajes y jugar.'),
('SAD', 'Acceso medio, puede moderar contenido y usuarios.(ADMIN)'),
('ADM', 'Acceso total, puede gestionar todo el sistema.');


INSERT INTO usuarios (imagen_perfil, nombre_usuario_pub, limite_personajes, nombre_usuario_priv, correo, contraseña, ultima_conexion, fecha_creacion, estado_cuenta, tipo_usuario_id)
VALUES
('perfil1.jpg', 'Aragorn23', 3, 'aragorn_priv', 'aragorn@example.com', 'contraseña123', '2023-10-01 12:00:00',  '2023-10-01 12:00:00', 1, 1),
('perfil2.jpg', 'GandalfTheWise', 3, 'gandalf_priv', 'gandalf@example.com', 'contraseña456', '2023-10-02 13:00:00', '2023-10-02 13:00:00', 1, 1),
('perfil3.jpg', 'LegolasGreenleaf', 3, 'legolas_priv', 'legolas@example.com', 'contraseña789', '2023-10-03 14:00:00','2023-10-03 14:00:00', 1, 1),
('perfil4.jpg', 'FrodoBaggins', 3, 'frodo_priv', 'frodo@example.com', 'contraseña101', '2023-10-04 15:00:00',  '2023-10-04 15:00:00', 1, 1),
('perfil5.jpg', 'GimliSonOfGloin', 3, 'gimli_priv', 'gimli@example.com', 'contraseña112', '2023-10-05 16:00:00',  '2023-10-05 16:00:00', 1, 1),
('perfil6.jpg', 'BoromirOfGondor', 3, 'boromir_priv', 'boromir@example.com', 'contraseña131', '2023-10-06 17:00:00',  '2023-10-06 17:00:00', 1, 1),
('perfil7.jpg', 'GaladrielLadyOfLight', 3, 'galadriel_priv', 'galadriel@example.com', 'contraseña415', '2023-10-07 18:00:00', '2023-10-07 18:00:00', 1, 1),
('perfil8.jpg', 'SarumanTheWhite', 3, 'saruman_priv', 'saruman@example.com', 'contraseña161', '2023-10-08 19:00:00',  '2023-10-08 19:00:00', 1, 1),
('perfil9.jpg', 'ArwenUndomiel', 3, 'arwen_priv', 'arwen@example.com', 'contraseña718', '2023-10-09 20:00:00', '2023-10-09 20:00:00', 1, 1),
('perfil10.jpg', 'SauronTheDarkLord', 3, 'sauron_priv', 'sauron@example.com', 'contraseña192', '2023-10-10 21:00:00', '2023-10-10 21:00:00', 1, 1);


-- Insertar logs
INSERT INTO logs (usuario_id, tipo_log, mensaje, fecha_log) VALUES
(1, 'INFORMACION', 'Usuario1 ha iniciado sesión.', NOW()),
(2, 'FALLO', 'Usuario2 ha intentado iniciar sesión con una contraseña incorrecta.', NOW()),
(3, 'ADVERTENCIA', 'Usuario3 ha intentado acceder a una zona restringida.', NOW()),
(4, 'CREACION', 'Usuario4 ha creado un nuevo personaje.', NOW()),
(5, 'ACTUALIZACION', 'Usuario5 ha actualizado su perfil.', NOW());


-- Insertar estadísticas generales
INSERT INTO estadisticas_generales (vida,regeneracion_vida, escudo, energia,regeneracion_energia, mana,regeneracion_mana, ataque_fisico, ataque_magico, defensa_fisica, defensa_magica)
VALUES

(0, 20, 0, 50, 0, 0, 0, 0,0,0,0), -- Golpe Crítico
(0, 0, 30, 0, 0, 40, 0, 0,0,0,0), -- Bola de Fuego
(0, 0, 25, 0, 35, 0, 0, 0,0,0,0), -- Rayo Helado
(50, 0, 20, 0, 0, 0, 0, 0,0,0,0), -- Escudo de Protección
(30, 0, 15, 0, 0, 0, 0, 0,0,0,0), -- Cura Menor
(0, 0, 20, 0, 0, 10, 0, 10,0,0,0), -- Fortalecer
(0, 0, 40, 10, 10, 10, 0, 10,0,0,0), -- Bendición
(0, 0, 50, 0, 0, 0, 0, 0,0,0,0), -- Invisibilidad
(20, 0, 30, 0, 0, 0, 0, 0,0,0,0), -- Regeneración
(0, 25, 0, 40, 0, 0, 0, 0,0,0,0), -- Corte Sombrío
(0, 0, 50, 0, 60, 0, 0, 0,0,0,0), -- Tormenta Eléctrica
(0, 30, 0, 35, 0, 0, 0, 0,0,0,0), -- Lanzamiento Dual
(100, 0, 40, 0, 0, 0, 0, 0,0,0,0), -- Escudo Divino
(50, 0, 25, 0, 0, 0, 0, 0,0,0,0), -- Regeneración Rápida
(0, 0, 35, 0, 0, 15, 0, 15,0,0,0), -- Aura de Protección
(0, 0, 50, 15, 15, 0, 0, 20,0,0,0), -- Bendición Sagrada
(0, 0, 60, 0, 0, 0, 0, 0,0,0,0), -- Teletransportación
(40, 0, 45, 0, 0, 0, 0, 0,0,0,0), -- Lluvia de Curación 18
(50, 0, 0, 0, 0, 0, 0, 0,0,0,0),   -- Poción de Vida
(0, 0, 0, 30, 0, 0, 0, 0,0,0,0),   -- Poción de Maná
(0, 0, 40, 0, 0, 0, 0, 0,0,0,0),   -- Poción de Energía
(100, 0, 0, 0, 0, 0, 0, 0,0,0,0),  -- Elixir de Vida
(0, 0, 0, 80, 0, 0, 0, 0,0,0,0),   -- Elixir de Maná
(0, 0, 0, 0, 10, 0, 0, 0,0,0,0),   -- Poción de Fuerza
(0, 0, 0, 0, 0, 0, 10, 0,0,0,0),   -- Poción de Defensa
(0, 0, 0, 0, 0, 0, 0, 0,0,0,0),    -- Poción de Invisibilidad
(0, 0, 0, 0, 20, 0, 0, 0,0,0,0),   -- Espada de Acero
(0, 10, 0, 0, 0, 0, 0, 0,0,0,0),   -- Escudo de Madera
(0, 0, 0, 0, 15, 0, 0, 0,0,0,0),   -- Daga Afilada
(0, 0, 0, 0, 0, 0, 50, 0,0,0,0),   -- Armadura de Platino
(0, 0, 0, 15, 0, 0, 0, 0,0,0,0),   -- Anillo de Poder
(0, 0, 0, 0, 30, 0, 0, 0,0,0,0),   -- Martillo de Guerra
(0, 0, 0, 0, 0, 0, 0, 20,0,0,0),   -- Capa del Mago
(0, 0, 0, 25, 0, 0, 0, 0,0,0,0),   -- Báculo Arcano
(0, 0, 20, 0, 0, 0, 0, 0,0,0,0),   -- Botas de Velocidad
(0, 0, 0, 0, 0, 0, 10, 0,0,0,0),   -- Cinturón de Resistencia
(0, 0, 0, 0, 18, 0, 0, 0,0,0,0),   -- Guantes de Acero
(0, 0, 0, 0, 0, 0, 20, 20,0,0,0),  -- Amuleto de Protección 38
(0, 0, 0, 0, 20, 0, 0, 0,0,0,0),-- Veneno
(-10, 0, 0, 0, 0, 0, 0, 0,0,0,0),-- Escudo de Protección
(0, 50, 0, 0, 0, 0, 0, 0,0,0,0),-- Congelación
(0, 0, -20, 0, 0, 0, 0, 0,0,0,0),-- Regeneración
(10, 0, 0, 0, 0, 0, 0, 0,0,0,0),-- Maldición Oscura
(0, 0, 0, -30, 0, 0, 0, 0,0,0,0),-- Ira del Guerrero
(0, 0, 0, 0, 30, 0, 0, 0,0,0,0),-- Ceguera
(0, 0, 0, 0, -15, 0, 0, 0,0,0,0),-- Bendición Divina
(50, 0, 0, 50, 0, 0, 0, 0,0,0,0),-- Quemadura
(-15, 0, 0, 0, 0, 0, 0, 0,0,0,0),-- Invisibilidad
(0, 0, 0, 0, 0, 0, 0, 0,0,0,0),-- Miedo
(0, 0, 0, 0, 0, -20, 0, 0,0,0,0),-- Furia del Dragón
(0, 0, 0, 0, 40, 0, 0, 0,0,0,0),-- Parálisis
(0, 0, -30, 0, 0, 0, 0, 0,0,0,0),-- Aura Sagrada
(0, 0, 0, 0, 0, 0, 10, 10,0,0,0),-- Corrupción
(-20, 0, 0, 0, 0, 0, 0, 0,0,0,0),-- Velocidad Mejorada
(0, 0, 20, 0, 0, 0, 0, 0,0,0,0),-- Silenciamiento
(0, 0, 0, -50, 0, 0, 0, 0,0,0,0),-- Invulnerabilidad
(0, 100, 0, 0, 0, 0, 0, 0,0,0,0),-- Envenenamiento Grave
(-25, 0, 0, 0, 0, 0, 0, 0,0,0,0), -- 59
(50, 0, 20, 5, 10, 5, 2, 1,0,0,0),
(200, 0, 50, 20, 50, 20, 10, 5,0,0,0),
(1000, 100, 200, 50, 200, 100, 30, 20,0,0,0),
(80, 0, 30, 12, 20, 15, 5, 3,0,0,0),
(60, 0, 20, 8, 15, 10, 3, 2,0,0,0),
(120, 0, 40, 18, 40, 25, 8, 5,0,0,0),
(100, 0, 35, 15, 30, 20, 6, 4,0,0,0),
(200, 50, 60, 25, 80, 50, 12, 8,0,0,0),
(200, 50, 60, 25, 80, 50, 12, 8,0,0,0),
(50, 0, 10, 15, 20, 20, 2, 1,0,0,0),
(100, 0, 40, 8, 25, 10, 3, 2,0,0,0),
(200, 100, 40, 8, 25, 10, 3, 2,0,0,0),
(50000, 200, 1000, 150, 200, 200, 200, 150,0,0,0),
(300, 20, 80, 30, 70, 25, 15, 10,0,0,0),
(90, 0, 40, 15, 25, 20, 5, 5,0,0,0),
(500, 100, 120, 50, 100, 40, 30, 20,0,0,0),
(1200, 150, 250, 100, 250, 150, 40, 30,0,0,0),
(150, 10, 50, 20, 40, 25, 10, 8,0,0,0),
(70, 0, 25, 10, 15, 10, 3, 2,0,0,0),
(180, 30, 60, 40, 60, 50, 12, 15,0,0,0),
(200, 50, 70, 30, 50, 40, 15, 10,0,0,0),
(1500, 200, 300, 150, 300, 200, 50, 40,0,0,0),
(1000, 150, 200, 200, 150, 250, 30, 40,0,0,0),
(400, 50, 100, 40, 120, 30, 20, 15,0,0,0),
(2000, 300, 400, 200, 350, 250, 60, 50,0,0,0),
(2500, 500, 500, 300, 500, 400, 80, 60,0,0,0),  -- 71
(150, 5, 20, 60, 10, 20, 5, 20, 5, 15, 5),  -- Aragorn
(80, 3, 5, 30, 5, 100, 20, 5, 25, 5, 20),  -- Gandalf
(100, 4, 10, 70, 8, 30, 7, 15, 10, 10, 10), -- Legolas
(90, 3, 15, 40, 8, 80, 15, 8, 15, 8, 15),   -- Frodo
(140, 6, 30, 50, 10, 30, 8, 18, 8, 20, 10), -- Gimli
(110, 4, 5, 80, 10, 20, 10, 25, 5, 5, 5),   -- Boromir
(120, 5, 15, 60, 12, 70, 10, 10, 18, 10, 15), -- Galadriel
(85, 2, 5, 35, 7, 90, 12, 6, 22, 6, 18),   -- Saruman
(95, 3, 10, 50, 8, 60, 15, 10, 15, 8, 12),  -- Arwen
(160, 8, 10, 90, 15, 10, 5, 22, 3, 12, 3),   -- Sauron 81
(150, 20, 60, 20, 20, 5, 15, 5,0,0,0),  -- Guerrero
(80, 5, 30, 100, 5, 25, 5, 20,0,0,0),  -- Mago
(100, 10, 70, 30, 15, 10, 10, 10,0,0,0),  -- Arquero
(90, 15, 40, 80, 8, 15, 8, 15,0,0,0),   -- Sacerdote
(110, 5, 80, 20, 25, 5, 5, 5,0,0,0),    -- Asesino
(140, 30, 50, 30, 18, 8, 20, 10,0,0,0), -- Caballero
(160, 10, 90, 10, 22, 3, 12, 3,0,0,0),  -- Bárbaro
(120, 15, 60, 70, 10, 18, 10, 15,0,0,0), -- Druida
(85, 5, 35, 90, 6, 22, 6, 18,0,0,0),    -- Nigromante
(95, 10, 50, 60, 10, 15, 8, 12,0,0,0);  -- Bardo



INSERT INTO clase_personaje (nombre, descripcion, estadistica_id)
VALUES
    ('Guerrero', 'Un luchador fuerte y resistente, especializado en combate cuerpo a cuerpo.', 82),
    ('Mago', 'Un maestro de las artes arcanas, capaz de lanzar hechizos devastadores.', 83),
    ('Arquero', 'Un tirador experto que ataca desde la distancia con precisión letal.', 84),
    ('Sacerdote', 'Un sanador divino que protege y cura a sus aliados.', 85),
    ('Asesino', 'Un combatiente sigiloso que ataca por sorpresa con golpes críticos.', 86),
    ('Caballero', 'Un defensor acorazado que protege a sus aliados en el frente de batalla.', 87),
    ('Bárbaro', 'Un guerrero salvaje que se enfurece en combate, aumentando su fuerza y resistencia.', 88),
    ('Druida', 'Un guardián de la naturaleza que combina magia y habilidades de transformación.', 89),
    ('Nigromante', 'Un hechicero oscuro que invoca y controla a los muertos.', 90),
    ('Bardo', 'Un artista versátil que usa música y magia para apoyar a sus aliados.', 91);


INSERT INTO tipo_grupo (nombre, numero_integrantes_max, comparten_exp_drops, descripcion) VALUES
('Gremio', 50, FALSE, 'Un grupo grande de jugadores que colaboran para alcanzar objetivos comunes.'),
('Incursión', 10, TRUE, 'Un grupo mediano para enfrentar desafíos de alto nivel.'),
('Party', 5, TRUE, 'Un grupo pequeño para explorar y completar misiones.');



INSERT INTO grupos (nombre, descripcion, tipo_grupo_id) 
VALUES
('Los Cuatro Elementos', 'Un grupo de aventureros que dominan los cuatro elementos: fuego, agua, tierra y aire.',  1),
('Los Guardianes del Amanecer', 'Un equipo de héroes que protegen el mundo de las amenazas que surgen con la luz del amanecer.',  1),
('Las Sombras del Destino', 'Un grupo sigiloso que opera en las sombras para cumplir misiones peligrosas.',  2),
('Los Hijos del Trueno', 'Un equipo de guerreros que luchan con la fuerza y el poder del trueno.', 2),
('Los Exploradores Perdidos', 'Un grupo de aventureros que buscan tesoros y secretos en lugares olvidados.',  3),
('Los Defensores de la Luz', 'Un equipo de paladines y clérigos que luchan contra las fuerzas de la oscuridad.', 3),
('Los Cazadores de Bestias', 'Un grupo especializado en la caza de criaturas peligrosas y monstruos.', 2),
('Los Maestros del Caos', 'Un equipo de magos y hechiceros que manipulan el caos para sus propios fines.', 1);

-- Insertar registros de personajes 

INSERT INTO logros_personaje ( normal, miniboss, boss, muertes_totales, total_daño_inflijido, total_daño_recibido, tiempo_total_jugado, mazmorras_totales_superadas)
VALUES
    ( 50, 5, 2, 3, 15000, 5000, 3600, 10),  -- Aragorn
    ( 30, 3, 1, 1, 20000, 3000, 4800, 8),   -- Gandalf
    ( 70, 7, 3, 5, 12000, 7000, 3000, 12),  -- Legolas
    ( 20, 2, 0, 2, 8000, 4000, 2400, 5),    -- Frodo
    ( 60, 6, 2, 4, 18000, 6000, 4200, 9),   -- Gimli
    ( 40, 4, 1, 3, 10000, 5000, 3600, 7),   -- Boromir
    ( 80, 8, 4, 6, 25000, 8000, 5400, 15),  -- Galadriel
    ( 100, 10, 5, 8, 30000, 10000, 6000, 20), -- Saruman
    (35, 3, 1, 2, 9000, 3500, 2700, 6),    -- Arwen
    ( 120, 12, 6, 10, 40000, 12000, 7200, 25); -- Sauron

INSERT INTO personajes (usuario_id, imagen_modelo, nombre, fecha_creacion, clase_id, grupo_id, nivel, xp_acumulada, almas, capacidad_inventario, estadistica_id,logro_id)
VALUES
(1, 'imagen1.jpg', 'Aragorn', '2023-10-01 12:00:00', 1, 1, 5, 1200, 50, 15, 72,1),
(2, 'imagen2.jpg', 'Gandalf', '2023-10-02 13:00:00', 2, 1, 10, 5000, 100, 10, 73,2),
(3, 'imagen3.jpg', 'Legolas', '2023-10-03 14:00:00', 3, 1, 8, 3000, 75, 12, 74,3),
(4, 'imagen4.jpg', 'Frodo', '2023-10-04 15:00:00', 4, 2, 3, 800, 30, 10, 75,4),
(5, 'imagen5.jpg', 'Gimli', '2023-10-05 16:00:00', 1, 2, 7, 2500, 60, 14, 76,5),
(6, 'imagen6.jpg', 'Boromir', '2023-10-06 17:00:00', 5, 3, 6, 2000, 40, 12, 77,6),
(7, 'imagen7.jpg', 'Galadriel', '2023-10-07 18:00:00', 2, 4, 12, 8000, 150, 16, 78,7),
(8, 'imagen8.jpg', 'Saruman', '2023-10-08 19:00:00', 9, 5, 15, 12000, 200, 10, 79,8),
(9, 'imagen9.jpg', 'Arwen', '2023-10-09 20:00:00', 10, 6, 9, 4000, 80, 12, 80,9),
(10, 'imagen10.jpg', 'Sauron', '2023-10-10 21:00:00', 9, 7, 20, 20000, 300, 18, 81,10);


INSERT INTO lidergrupo (grupo_id, personaje_id, fecha_nombramiento)
VALUES
(1, 1, '2023-10-01 12:00:00'),  -- Aragorn es el líder del grupo 1
(2, 4, '2023-10-04 15:00:00'),  -- Frodo es el líder del grupo 2
(3, 6, '2023-10-06 17:00:00'),  -- Boromir es el líder del grupo 3
(4, 7, '2023-10-07 18:00:00'),  -- Galadriel es el líder del grupo 4
(5, 8, '2023-10-08 19:00:00'),  -- Saruman es el líder del grupo 5
(6, 9, '2023-10-09 20:00:00'),  -- Arwen es el líder del grupo 6
(7, 10, '2023-10-10 21:00:00'); -- Sauron es el líder del grupo 7





INSERT INTO tipo_monstruo (nombre, descripcion) VALUES
('Normal', 'Monstruos comunes que se encuentran en áreas abiertas.'),
('Miniboss', 'Monstruos más poderosos que requieren estrategia para derrotar.'),
('Boss', 'Monstruos extremadamente poderosos que requieren un grupo organizado.');



INSERT INTO monstruos (nombre, tipo_monstruo_id, nivel, descripcion, imagen, almas_otorgadas, experiencia_otorgada, estadistica_id)
VALUES
('Goblin', 1, 1, 'Un pequeño monstruo verde', 'goblin.jpg', 50, 20, 39),
('Ogro', 2, 5, 'Un monstruo grande y fuerte', 'ogro.jpg', 200, 50, 40),
('Dragón', 3, 10, 'Un poderoso dragón', 'dragon.jpg', 1000, 200, 41),
('Bandido', 1, 3, 'Un bandido común que ataca a los viajeros', 'bandido.jpg', 80, 30, 42),
('Lobo Salvaje', 1, 2, 'Un lobo feroz que habita en los bosques', 'lobo.jpg', 60, 20, 43),
('Esqueleto Guerrero', 2, 5, 'Un esqueleto revivido con habilidades de combate', 'esqueleto.jpg', 120, 40, 44),
('Araña Gigante', 2, 4, 'Una araña gigante que teje telarañas venenosas', 'araña.jpg', 100, 35, 45),
('Bandido Líder', 3, 7, 'El líder de una banda de bandidos', 'bandido_lider.jpg', 200, 60, 46),
('Nigromante', 3, 7, 'El líder de esqueletos', 'nigromante.jpg', 200, 60, 47),
('Araña', 1, 7, 'Araña pequeña que ataca en grupo', 'araña.jpg', 50, 10, 48),
('Lobo Gigante', 2, 10, 'Un lobo gigante que habita en los bosques', 'lobo2.jpg', 100, 40, 49),
('Lobo Sagrado', 3, 50, 'Un lobo sagrado feroz que habita en los bosques', 'lobo3.jpg', 200, 40, 50),
('Janeiro', 3, 100, 'Un boss peligroso cuanto más le alarga la batalla', 'janeiro.jpg', 50000, 1000, 51),
('Troll de Montaña', 2, 8, 'Un troll enorme que habita en las montañas.', 'troll_montana.jpg', 300, 80, 52),
('Harpía', 1, 4, 'Una criatura voladora con garras afiladas.', 'harpia.jpg', 90, 30, 53),
('Golem de Piedra', 3, 12, 'Un golem creado a partir de roca sólida.', 'golem_piedra.jpg', 500, 120, 54),
('Esqueleto Mago', 2, 6, 'Un esqueleto que domina la magia oscura.', 'esqueleto_mago.jpg', 150, 50, 55),
('Dragón de Hielo', 3, 15, 'Un dragón que escupe hielo y congela a sus enemigos.', 'dragon_hielo.jpg', 1200, 250, 56),
('Goblin Líder', 2, 5, 'El líder de una tribu de goblins.', 'goblin_lider.jpg', 150, 50, 57),
('Serpiente Venenosa', 1, 3, 'Una serpiente que ataca con veneno mortal.', 'serpiente.jpg', 70, 20, 58),
('Demonio Menor', 2, 7, 'Un demonio de bajo rango que sirve a poderes oscuros.', 'demonio_menor.jpg', 180, 60, 59),
('Gárgola', 2, 6, 'Una estatua animada que protege lugares sagrados.', 'gargola.jpg', 200, 70, 60),
('Kraken', 3, 20, 'Una criatura marina gigante que ataca con sus tentáculos.', 'kraken.jpg', 1500, 300, 61),
('Fénix', 3, 18, 'Un ave legendaria que renace de sus cenizas.', 'fenix.jpg', 1000, 200, 62),
('Cíclope', 2, 10, 'Un gigante de un solo ojo con fuerza descomunal.', 'ciclop.jpg', 400, 100, 63),
('Hidra', 3, 25, 'Una criatura de múltiples cabezas que regenera sus heridas.', 'hidra.jpg', 2000, 400, 64),
('Licántropo', 2, 9, 'Un humano que se transforma en lobo durante la luna llena.', 'licantropo.jpg', 250, 80, 65),
('Basilisco', 3, 14, 'Una serpiente gigante que petrifica con su mirada.', 'basilisco.jpg', 800, 150, 66),
('Gigante de Hielo', 2, 11, 'Un gigante que habita en regiones heladas.', 'gigante_hielo.jpg', 600, 120, 67),
('Dragón de Fuego', 3, 16, 'Un dragón que escupe llamas y arrasa con todo a su paso.', 'dragon_fuego.jpg', 1300, 300, 68),
('Esqueleto Gigante', 2, 8, 'Un esqueleto de tamaño colosal que aterroriza a sus enemigos.', 'esqueleto_gigante.jpg', 400, 100, 69),
('Araña Reina', 3, 13, 'La líder de una colonia de arañas gigantes.', 'araña_reina.jpg', 700, 150, 70),
('Leviatán', 3, 30, 'Una criatura marina legendaria que devora barcos enteros.', 'leviatan.jpg', 2500, 500, 71);

 
INSERT INTO registro_jugador_monstruo (personaje_id, monstruo_id, fecha, almas_obtenidas, experiencia_obtenida, dano_realizado, dano_recibido)
VALUES
    (1, 1, '2023-10-01 12:00:00', 50, 20, 0, 0),   -- Aragorn cazó un Goblin
    (2, 3, '2023-10-02 13:00:00', 1000, 200, 0, 0), -- Gandalf cazó un Dragón
    (3, 2, '2023-10-03 14:00:00', 200, 50, 0, 0),  -- Legolas cazó un Ogro
    (4, 5, '2023-10-04 15:00:00', 60, 20, 0, 0),   -- Frodo cazó un Lobo Salvaje
    (5, 4, '2023-10-05 16:00:00', 80, 30, 0, 0),   -- Gimli cazó un Bandido
    (6, 6, '2023-10-06 17:00:00', 120, 40, 0, 0),  -- Boromir cazó un Esqueleto Guerrero
    (7, 7, '2023-10-07 18:00:00', 100, 35, 0, 0),  -- Galadriel cazó una Araña Gigante
    (8, 8, '2023-10-08 19:00:00', 200, 60, 0, 0),  -- Saruman cazó un Bandido Líder
    (9, 9, '2023-10-09 20:00:00', 200, 60, 0, 0),  -- Arwen cazó un Nigromante
    (10, 10, '2023-10-10 21:00:00', 50, 10, 0, 0), -- Sauron cazó una Araña
    (1, 11, '2023-10-11 12:00:00', 100, 40, 0, 0), -- Aragorn cazó un Lobo Gigante
    (2, 12, '2023-10-12 13:00:00', 200, 40, 0, 0), -- Gandalf cazó un Lobo Sagrado
    (3, 13, '2023-10-13 14:00:00', 500, 1000, 0, 0), -- Legolas cazó un Janeiro
    (4, 14, '2023-10-14 15:00:00', 300, 80, 0, 0), -- Frodo cazó un Troll de Montaña
    (5, 15, '2023-10-15 16:00:00', 90, 30, 0, 0),  -- Gimli cazó una Harpía
    (6, 16, '2023-10-16 17:00:00', 500, 120, 0, 0), -- Boromir cazó un Golem de Piedra
    (7, 17, '2023-10-17 18:00:00', 150, 50, 0, 0), -- Galadriel cazó un Esqueleto Mago
    (8, 18, '2023-10-18 19:00:00', 1200, 250, 0, 0), -- Saruman cazó un Dragón de Hielo
    (9, 19, '2023-10-19 20:00:00', 150, 50, 0, 0), -- Arwen cazó un Goblin Líder
    (10, 20, '2023-10-20 21:00:00', 70, 20, 0, 0); -- Sauron cazó una Serpiente Venenosa
  
  
  -- Insertar efectos y estados
INSERT INTO efectos_estados (imagen, nombre, tipo, tipo_afectado, duracion_efecto, intervalos_efecto, acumulaciones, descripcion, estadistica_id)
VALUES
    ('fuerza_icono.jpg', 'Fuerza Mejorada', 'BUFF', 'PERSONAJE', 60, 10, 1, 'Aumenta el ataque físico en 20 puntos durante 1 minuto.', 39),
    ('veneno_icono.jpg', 'Veneno', 'DEBUFF', 'MONSTRUO', 30, 5, 3, 'Reduce la vida en 10 puntos cada 5 segundos durante 30 segundos.', 40),
    ('proteccion_icono.jpg', 'Escudo de Protección', 'BUFF', 'PERSONAJE', 120, 0, 1, 'Aumenta el escudo en 50 puntos durante 2 minutos.', 41),
    ('congelacion_icono.jpg', 'Congelación', 'DEBUFF', 'MONSTRUO', 20, 0, 1, 'Reduce la energía en 20 puntos durante 20 segundos.', 42),
    ('regeneracion_icono.jpg', 'Regeneración', 'BUFF', 'PERSONAJE', 60, 10, 1, 'Regenera 10 puntos de vida cada 10 segundos durante 1 minuto.', 43),
    ('maldicion_icono.jpg', 'Maldición Oscura', 'DEBUFF', 'MONSTRUO', 45, 15, 2, 'Reduce el maná en 30 puntos cada 15 segundos durante 45 segundos.', 44),
    ('ira_icono.jpg', 'Ira del Guerrero', 'BUFF', 'PERSONAJE', 30, 0, 1, 'Aumenta el ataque físico en 30 puntos durante 30 segundos.', 45),
    ('ceguera_icono.jpg', 'Ceguera', 'DEBUFF', 'MONSTRUO', 25, 0, 1, 'Reduce el ataque físico en 15 puntos durante 25 segundos.', 46),
    ('bendicion_icono.jpg', 'Bendición Divina', 'BUFF', 'PERSONAJE', 90, 0, 1, 'Aumenta la vida y el maná en 50 puntos durante 90 segundos.', 47),
    ('quemadura_icono.jpg', 'Quemadura', 'DEBUFF', 'MONSTRUO', 40, 10, 4, 'Reduce la vida en 15 puntos cada 10 segundos durante 40 segundos.', 48),
    ('invisibilidad_icono.jpg', 'Invisibilidad', 'BUFF', 'PERSONAJE', 60, 0, 1, 'Hace al personaje invisible durante 1 minuto.', 49),
    ('miedo_icono.jpg', 'Miedo', 'DEBUFF', 'MONSTRUO', 30, 0, 1, 'Reduce el ataque mágico en 20 puntos durante 30 segundos.', 50),
    ('furia_icono.jpg', 'Furia del Dragón', 'BUFF', 'PERSONAJE', 45, 0, 1, 'Aumenta el ataque físico en 40 puntos durante 45 segundos.', 51),
    ('paralisis_icono.jpg', 'Parálisis', 'DEBUFF', 'MONSTRUO', 20, 0, 1, 'Reduce la energía en 30 puntos durante 20 segundos.', 52),
    ('aura_sagrada_icono.jpg', 'Aura Sagrada', 'BUFF', 'PERSONAJE', 120, 0, 1, 'Aumenta la defensa física y mágica en 10 puntos durante 2 minutos.', 53),
    ('corrupcion_icono.jpg', 'Corrupción', 'DEBUFF', 'MONSTRUO', 60, 15, 3, 'Reduce la vida en 20 puntos cada 15 segundos durante 1 minuto.', 54),
    ('velocidad_icono.jpg', 'Velocidad Mejorada', 'BUFF', 'PERSONAJE', 60, 0, 1, 'Aumenta la energía en 20 puntos durante 1 minuto.', 55),
    ('silenciamiento_icono.jpg', 'Silenciamiento', 'DEBUFF', 'MONSTRUO', 30, 0, 1, 'Reduce el maná en 50 puntos durante 30 segundos.', 56),
    ('invulnerabilidad_icono.jpg', 'Invulnerabilidad', 'BUFF', 'PERSONAJE', 10, 0, 1, 'Aumenta el escudo en 100 puntos durante 10 segundos.', 57),
    ('envenenamiento_icono.jpg', 'Envenenamiento Grave', 'DEBUFF', 'MONSTRUO', 50, 10, 5, 'Reduce la vida en 25 puntos cada 10 segundos durante 50 segundos.', 58);



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


-- Insertar datos en la tabla tipo_item
INSERT INTO tipo_item (nombre,imagen, descripcion) VALUES
('Material', "imagen.jpg", 'Recursos básicos utilizados para fabricar otros objetos.'),
('Consumible', "imagen.jpg",'Ítems que se gastan al usarlos, como pociones o alimentos.'),
('Pechera',"imagen.jpg", 'Armadura que protege el torso del personaje.'),
('Casco',"imagen.jpg", 'Protección para la cabeza del personaje.'),
('Botas',"imagen.jpg", 'Calzado que protege los pies y puede otorgar bonificaciones.'),
('Guantes',"imagen.jpg", 'Protección para las manos, mejora la destreza o fuerza.'),
('Pantalones',"imagen.jpg", 'Armadura que protege las piernas del personaje.'),
('Zapatos',"imagen.jpg", 'Calzado ligero que puede otorgar agilidad o velocidad.'),
('Accesorio1',"imagen.jpg", 'Accesorio que otorga bonificaciones especiales, como anillos o amuletos.'),
('Accesorio2',"imagen.jpg", 'Segundo espacio para accesorios con efectos únicos.');


-- Insertar ítems
INSERT INTO items (imagen,nombre, tipo_item_id, descripcion, acumulaciones_max, estadistica_id, equipable)
VALUES
    ("img1.jpg",'Poción de Vida', 2, 'Restaura 50 puntos de vida.', 99, 19, FALSE),
    ("img1.jpg",'Poción de Maná', 2, 'Restaura 30 puntos de maná.', 99, 20, FALSE),
    ("img1.jpg",'Poción de Energía', 2, 'Restaura 40 puntos de energía.', 99, 21, FALSE),
    ("img1.jpg",'Elixir de Vida', 2, 'Restaura 100 puntos de vida.', 99, 22, FALSE),
    ("img1.jpg",'Elixir de Maná', 2, 'Restaura 80 puntos de maná.', 99, 23, FALSE),
    ("img1.jpg",'Poción de Fuerza', 2, 'Aumenta el ataque físico en 10 puntos durante 5 minutos.', 99, 24, FALSE),
    ("img1.jpg",'Poción de Defensa', 2, 'Aumenta la defensa física en 10 puntos durante 5 minutos.', 99, 25, FALSE),
    ("img1.jpg",'Poción de Invisibilidad', 2, 'Otorga invisibilidad durante 1 minuto.', 99, 26, FALSE),
    ("img1.jpg",'Espada de Acero', 3, 'Una espada resistente hecha de acero.', 1, 27, TRUE),
    ("img1.jpg",'Escudo de Madera', 4, 'Un escudo ligero hecho de madera.', 1, 28, TRUE),
    ("img1.jpg",'Daga Afilada', 3, 'Una daga ligera y rápida.', 1, 29, TRUE),
    ("img1.jpg",'Armadura de Platino', 5, 'Una armadura pesada pero muy resistente.', 1, 30, TRUE),
    ("img1.jpg",'Anillo de Poder', 9, 'Aumenta el ataque mágico en 15 puntos.', 1, 31, TRUE),
    ("img1.jpg",'Martillo de Guerra', 3, 'Un martillo pesado que inflige gran daño.', 1, 32, TRUE),
    ("img1.jpg",'Capa del Mago', 6, 'Aumenta la defensa mágica en 20 puntos.', 1, 33, TRUE),
    ("img1.jpg",'Báculo Arcano', 3, 'Un báculo que potencia las habilidades mágicas.', 1, 34, TRUE),
    ("img1.jpg",'Botas de Velocidad', 7, 'Aumentan la velocidad de movimiento.', 1, 35, TRUE),
    ("img1.jpg",'Cinturón de Resistencia', 8, 'Aumenta la resistencia física.', 1, 36, TRUE),
    ("img1.jpg",'Guantes de Acero', 6, 'Mejoran la destreza y el ataque.', 1, 37, TRUE),
    ("img1.jpg",'Amuleto de Protección', 9, 'Otorga protección mágica.', 1, 38, TRUE),
    ("img1.jpg",'Hierro', 1, 'Material de crafteo común.', 99, NULL, FALSE),
    ("img1.jpg",'Piedra Mágica', 1, 'Material raro usado en crafteo avanzado.', 99, NULL, FALSE),
    ("img1.jpg",'Piedra de Fuego', 1, 'Material usado para crear armas de fuego.', 99, NULL, FALSE),
    ("img1.jpg",'Cuero', 1, 'Material usado para fabricar armaduras ligeras.', 99, NULL, FALSE),
    ("img1.jpg",'Cristal Mágico', 1, 'Material mágico usado en encantamientos.', 99, NULL, FALSE),
    ("img1.jpg",'Madera de Roble', 1, 'Madera resistente usada en crafteo.', 99, NULL, FALSE),
    ("img1.jpg",'Hueso de Dragón', 1, 'Material legendario usado en crafteo de alto nivel.', 99, NULL, FALSE),
    ("img1.jpg",'Plata', 1, 'Metal precioso usado en joyería y crafteo.', 99, NULL, FALSE),
    ("img1.jpg",'Oro', 1, 'Metal valioso usado en crafteo de élite.', 99, NULL, FALSE),
    ("img1.jpg",'Gema Brillante', 1, 'Gema rara usada en crafteo mágico.', 99, NULL, FALSE);


INSERT INTO item_efecto (item_id, efecto_id)
VALUES

    (1, 5),   -- Poción de Vida: Regeneración
    (2, 9),   -- Poción de Maná: Bendición Divina
    (3, 17),  -- Poción de Energía: Velocidad Mejorada
    (4, 5),   -- Elixir de Vida: Regeneración
    (5, 9),   -- Elixir de Maná: Bendición Divina
    (6, 1),   -- Poción de Fuerza: Fuerza Mejorada
    (7, 15),  -- Poción de Defensa: Aura Sagrada
    (8, 11),  -- Poción de Invisibilidad: Invisibilidad
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

-- Insertar drops de monstruos
INSERT INTO drops_objetos (monstruo_id, item_id, probabilidad)
VALUES
    (1, 1, 50),   -- Goblin puede soltar Poción de Vida con 50% de probabilidad
    (1, 21, 30),  -- Goblin puede soltar Hierro con 30% de probabilidad
    (1, 24, 10),  -- Goblin puede soltar Cuero con 10% de probabilidad
    (2, 2, 40),   -- Ogro puede soltar Poción de Maná con 40% de probabilidad
    (2, 21, 50),  -- Ogro puede soltar Hierro con 50% de probabilidad
    (2, 22, 20),  -- Ogro puede soltar Piedra Mágica con 20% de probabilidad
    (3, 4, 30),   -- Dragón puede soltar Elixir de Vida con 30% de probabilidad
    (3, 5, 30),   -- Dragón puede soltar Elixir de Maná con 30% de probabilidad
    (3, 27, 10),  -- Dragón puede soltar Hueso de Dragón con 10% de probabilidad
    (3, 26, 20),  -- Dragón puede soltar Madera de Roble con 20% de probabilidad
    (4, 1, 60),   -- Bandido puede soltar Poción de Vida con 60% de probabilidad
    (4, 21, 40),  -- Bandido puede soltar Hierro con 40% de probabilidad
    (4, 24, 20),  -- Bandido puede soltar Cuero con 20% de probabilidad
    (5, 24, 70),  -- Lobo Salvaje puede soltar Cuero con 70% de probabilidad
    (5, 21, 30),  -- Lobo Salvaje puede soltar Hierro con 30% de probabilidad
    (6, 2, 40),   -- Esqueleto Guerrero puede soltar Poción de Maná con 40% de probabilidad
    (6, 22, 30),  -- Esqueleto Guerrero puede soltar Piedra Mágica con 30% de probabilidad
    (6, 25, 10),  -- Esqueleto Guerrero puede soltar Cristal Mágico con 10% de probabilidad
    (7, 24, 80),  -- Araña Gigante puede soltar Cuero con 80% de probabilidad
    (7, 22, 20),  -- Araña Gigante puede soltar Piedra Mágica con 20% de probabilidad
    (8, 4, 50),   -- Bandido Líder puede soltar Elixir de Vida con 50% de probabilidad
    (8, 5, 50),   -- Bandido Líder puede soltar Elixir de Maná con 50% de probabilidad
    (8, 28, 10),  -- Bandido Líder puede soltar Plata con 10% de probabilidad
    (9, 5, 60),   -- Nigromante puede soltar Elixir de Maná con 60% de probabilidad
    (9, 25, 30),  -- Nigromante puede soltar Cristal Mágico con 30% de probabilidad
    (9, 22, 20),  -- Nigromante puede soltar Piedra Mágica con 20% de probabilidad
    (10, 24, 90), -- Araña puede soltar Cuero con 90% de probabilidad
    (10, 21, 10); -- Araña puede soltar Hierro con 10% de probabilidad


-- Insertar inventario de personajes
INSERT INTO inventario_personaje (personaje_Id, item_id, cantidad, equipado, fecha_obtencion)
VALUES
    (1, 9, 1, 1, '2023-10-01 12:00:00'),  -- Espada de Acero (equipada)
    (1, 10, 1, 1, '2023-10-01 12:05:00'), -- Escudo de Madera (equipado)
    (1, 1, 5, 0, '2023-10-01 12:10:00'),  -- Poción de Vida (5 unidades, no equipada)
    (1, 21, 10, 0, '2023-10-01 12:15:00'), -- Hierro (10 unidades, no equipado)
    (2, 16, 1, 1, '2023-10-02 13:00:00'), -- Báculo Arcano (equipado)
    (2, 15, 1, 1, '2023-10-02 13:05:00'), -- Capa del Mago (equipada)
    (2, 2, 3, 0, '2023-10-02 13:10:00'),  -- Poción de Maná (3 unidades, no equipada)
    (2, 22, 5, 0, '2023-10-02 13:15:00'), -- Piedra Mágica (5 unidades, no equipada)
    (3, 11, 1, 1, '2023-10-03 14:00:00'), -- Daga Afilada (equipada)
    (3, 17, 1, 1, '2023-10-03 14:05:00'), -- Botas de Velocidad (equipadas)
    (3, 3, 2, 0, '2023-10-03 14:10:00'),  -- Poción de Energía (2 unidades, no equipada)
    (3, 24, 8, 0, '2023-10-03 14:15:00'), -- Cuero (8 unidades, no equipado)
    (4, 12, 1, 1, '2023-10-04 15:00:00'), -- Armadura de Platino (equipada)
    (4, 18, 1, 1, '2023-10-04 15:05:00'), -- Cinturón de Resistencia (equipado)
    (4, 4, 1, 0, '2023-10-04 15:10:00'),  -- Elixir de Vida (1 unidad, no equipada)
    (4, 25, 3, 0, '2023-10-04 15:15:00'), -- Cristal Mágico (3 unidades, no equipado)
    (5, 14, 1, 1, '2023-10-05 16:00:00'), -- Martillo de Guerra (equipado)
    (5, 10, 1, 1, '2023-10-05 16:05:00'), -- Escudo de Madera (equipado)
    (5, 5, 2, 0, '2023-10-05 16:10:00'),  -- Elixir de Maná (2 unidades, no equipado)
    (5, 26, 4, 0, '2023-10-05 16:15:00'); -- Madera de Roble (4 unidades, no equipada)


-- Insertar habilidades
INSERT INTO habilidades (imagen, nombre, descripcion, nivel_maximo, requisito_nivel, tipo_habilidad, objetivo_habilidad, area_efecto, unidades_afectadas, enfriamiento, estadistica_id)
VALUES
    ('golpe_critico.jpg', 'Golpe Crítico', 'Un ataque poderoso que inflige daño crítico.', 5, 1, 'OFENSIVA', 'ENEMIGO', 1, 1, 10, 1),
    ('bola_fuego.jpg', 'Bola de Fuego', 'Lanza una bola de fuego que quema a los enemigos.', 3, 3, 'OFENSIVA', 'ENEMIGO', 3, 3, 15, 2),
    ('rayo_helado.jpg', 'Rayo Helado', 'Un rayo de hielo que congela a los enemigos.', 4, 5, 'OFENSIVA', 'ENEMIGO', 2, 2, 12, 3),
    ('escudo_proteccion.jpg', 'Escudo de Protección', 'Crea un escudo que absorbe daño.', 3, 2, 'DEFENSIVA', 'JUGADOR', 1, 1, 20, 4),
    ('cura_menor.jpg', 'Cura Menor', 'Cura una pequeña cantidad de vida.', 4, 2, 'DEFENSIVA', 'ALIADO', 1, 1, 10, 5),
    ('fortalecer.jpg', 'Fortalecer', 'Aumenta la defensa física y mágica.', 2, 4, 'DEFENSIVA', 'JUGADOR', 1, 1, 15, 6),
    ('bendicion.jpg', 'Bendición', 'Aumenta el ataque y la defensa de los aliados.', 3, 5, 'APOYO', 'ALIADO', 5, 5, 30, 7),
    ('invisibilidad.jpg', 'Invisibilidad', 'Hace al jugador invisible por un tiempo.', 2, 6, 'APOYO', 'JUGADOR', 1, 1, 60, 8),
    ('regeneracion.jpg', 'Regeneración', 'Regenera la vida y el maná de los aliados.', 4, 7, 'APOYO', 'ALIADO', 4, 4, 25, 9),
    ('corte_sombrio.jpg', 'Corte Sombrío', 'Un ataque rápido que inflige daño oscuro.', 4, 4, 'OFENSIVA', 'ENEMIGO', 1, 1, 8, 10),
    ('tormenta_electrica.jpg', 'Tormenta Eléctrica', 'Invoca una tormenta eléctrica que daña a múltiples enemigos.', 3, 6, 'OFENSIVA', 'ENEMIGO', 4, 4, 20, 11),
    ('lanzamiento_dual.jpg', 'Lanzamiento Dual', 'Ataca dos veces con armas arrojadizas.', 5, 3, 'OFENSIVA', 'ENEMIGO', 1, 1, 12, 12),
    ('escudo_divino.jpg', 'Escudo Divino', 'Protege al jugador con un escudo mágico.', 3, 5, 'DEFENSIVA', 'JUGADOR', 1, 1, 30, 13),
    ('regeneracion_rapida.jpg', 'Regeneración Rápida', 'Cura una cantidad moderada de vida rápidamente.', 4, 4, 'DEFENSIVA', 'ALIADO', 1, 1, 15, 14),
    ('aura_proteccion.jpg', 'Aura de Protección', 'Aumenta la defensa de todos los aliados en un área.', 3, 7, 'DEFENSIVA', 'ALIADO', 5, 5, 25, 15),
    ('bendicion_sagrada.jpg', 'Bendición Sagrada', 'Aumenta el ataque y la defensa mágica de los aliados.', 4, 8, 'APOYO', 'ALIADO', 5, 5, 40, 16),
    ('teletransportacion.jpg', 'Teletransportación', 'Teletransporta al jugador a un lugar seguro.', 2, 9, 'APOYO', 'JUGADOR', 1, 1, 90, 17),
    ('lluvia_curacion.jpg', 'Lluvia de Curación', 'Cura a todos los aliados en un área amplia.', 5, 10, 'APOYO', 'ALIADO', 6, 6, 35, 18);

-- Insertar efectos de habilidadeshabilidades
INSERT INTO habilidad_efecto (habilidad_id, efecto_id)
VALUES
    (1, 1),  -- Golpe Crítico: Fuerza Mejorada
    (2, 10), -- Bola de Fuego: Quemadura
    (3, 4),  -- Rayo Helado: Congelación
    (4, 3),  -- Escudo de Protección: Escudo de Protección
    (5, 5),  -- Cura Menor: Regeneración
    (6, 15), -- Fortalecer: Aura Sagrada
    (7, 9),  -- Bendición: Bendición Divina
    (8, 11), -- Invisibilidad: Invisibilidad
    (9, 5),  -- Regeneración: Regeneración
    (10, 1), -- Corte Sombrío: Fuerza Mejorada
    (11, 12),-- Tormenta Eléctrica: Parálisis
    (12, 1), -- Lanzamiento Dual: Fuerza Mejorada
    (13, 3), -- Escudo Divino: Escudo de Protección
    (14, 5), -- Regeneración Rápida: Regeneración
    (15, 15),-- Aura de Protección: Aura Sagrada
    (16, 9), -- Bendición Sagrada: Bendición Divina
    (17, 11),-- Teletransportación: Invisibilidad
    (18, 5); -- Lluvia de Curación: Regeneración

-- Insertar habilidades de personajes
INSERT INTO personaje_habilidad (personaje_id, habilidad_id, nivel_habilidad, ultimo_uso)
VALUES
    (1, 1, 3, '2023-10-01 12:30:00'),  -- Golpe Crítico (nivel 3)
    (1, 4, 2, '2023-10-01 12:35:00'),  -- Escudo de Protección (nivel 2)
    (1, 7, 1, '2023-10-01 12:40:00'),  -- Bendición (nivel 1)
    (2, 2, 4, '2023-10-02 13:30:00'),  -- Bola de Fuego (nivel 4)
    (2, 5, 3, '2023-10-02 13:35:00'),  -- Cura Menor (nivel 3)
    (2, 8, 2, '2023-10-02 13:40:00'),  -- Invisibilidad (nivel 2)
    (3, 3, 2, '2023-10-03 14:30:00'),  -- Rayo Helado (nivel 2)
    (3, 6, 1, '2023-10-03 14:35:00'),  -- Fortalecer (nivel 1)
    (3, 9, 3, '2023-10-03 14:40:00'),  -- Regeneración (nivel 3)
    (4, 4, 1, '2023-10-04 15:30:00'),  -- Escudo de Protección (nivel 1)
    (4, 7, 2, '2023-10-04 15:35:00'),  -- Bendición (nivel 2)
    (4, 10, 1, '2023-10-04 15:40:00'), -- Corte Sombrío (nivel 1)
    (5, 1, 5, '2023-10-05 16:30:00'),  -- Golpe Crítico (nivel 5)
    (5, 12, 2, '2023-10-05 16:35:00'), -- Lanzamiento Dual (nivel 2)
    (5, 15, 1, '2023-10-05 16:40:00'); -- Aura de Protección (nivel 1)
-- Insertar habilidades de monstruos
INSERT INTO monstruo_habilidad (monstruo_id, habilidad_id, nivel_habilidad, probabilidad_uso,probabilidad_fallo)
VALUES
    (1, 1, 2, 50, 50),  -- Goblin usa Golpe Crítico (nivel 2) con 50% de probabilidad
    (1, 10, 1, 30, 50), -- Goblin usa Corte Sombrío (nivel 1) con 30% de probabilidad
    (2, 1, 3, 70, 50),  -- Ogro usa Golpe Crítico (nivel 3) con 70% de probabilidad
    (2, 12, 2, 40, 50), -- Ogro usa Lanzamiento Dual (nivel 2) con 40% de probabilidad
    (3, 2, 4, 80, 50),  -- Dragón usa Bola de Fuego (nivel 4) con 80% de probabilidad
    (3, 3, 3, 60, 50),  -- Dragón usa Rayo Helado (nivel 3) con 60% de probabilidad
    (3, 11, 2, 50, 50), -- Dragón usa Tormenta Eléctrica (nivel 2) con 50% de probabilidad
    (4, 1, 2, 60, 50),  -- Bandido usa Golpe Crítico (nivel 2) con 60% de probabilidad
    (4, 10, 1, 40, 50), -- Bandido usa Corte Sombrío (nivel 1) con 40% de probabilidad
    (5, 1, 1, 70, 50),  -- Lobo Salvaje usa Golpe Crítico (nivel 1) con 70% de probabilidad
    (6, 1, 2, 50, 50),  -- Esqueleto Guerrero usa Golpe Crítico (nivel 2) con 50% de probabilidad
    (6, 12, 1, 30, 50), -- Esqueleto Guerrero usa Lanzamiento Dual (nivel 1) con 30% de probabilidad
    (7, 10, 2, 60, 50), -- Araña Gigante usa Corte Sombrío (nivel 2) con 60% de probabilidad
    (7, 11, 1, 40, 50), -- Araña Gigante usa Tormenta Eléctrica (nivel 1) con 40% de probabilidad
    (8, 1, 3, 80, 50),  -- Bandido Líder usa Golpe Crítico (nivel 3) con 80% de probabilidad
    (8, 12, 2, 50, 50), -- Bandido Líder usa Lanzamiento Dual (nivel 2) con 50% de probabilidad
    (9, 2, 3, 70, 50),  -- Nigromante usa Bola de Fuego (nivel 3) con 70% de probabilidad
    (9, 3, 2, 50, 50),  -- Nigromante usa Rayo Helado (nivel 2) con 50% de probabilidad
    (10, 10, 1, 60, 50); -- Araña usa Corte Sombrío (nivel 1) con 60% de probabilidad

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
INSERT INTO npc (nombre, descripcion, imagen, tipo_npc_id)
VALUES
    ('Juan el Granjero', 'Un granjero amable que necesita ayuda con sus cultivos.', 'juan_granjero.jpg', 1),
    ('María la Tejedora', 'Una tejedora que busca materiales para sus telares.', 'maria_tejedora.jpg', 1),
    ('Luis el Mercader', 'Un mercader que vende objetos útiles para aventureros.', 'luis_mercader.jpg', 2),
    ('Ana la Comerciante', 'Una comerciante que ofrece productos exóticos.', 'ana_comerciante.jpg', 2),
    ('Carlos el Guardia', 'Un guardia que protege la entrada de la ciudad.', 'carlos_guardia.jpg', 3),
    ('Sofía la Capitana', 'La capitana de la guardia, conocida por su valentía.', 'sofia_capitana.jpg', 3),
    ('Merlín el Sabio', 'Un mago anciano que conoce los secretos del mundo.', 'merlin_sabio.jpg', 4),
    ('Elena la Hechicera', 'Una hechicera poderosa que ofrece misiones mágicas.', 'elena_hechicera.jpg', 4),
    ('Pedro el Herrero', 'Un herrero experto en forjar armas y armaduras.', 'pedro_herrero.jpg', 5),
    ('Lucía la Forjadora', 'Una forjadora que crea equipo de alta calidad.', 'lucia_forjadora.jpg', 5),
    ('Morgana la Bruja', 'Una bruja que vive en el bosque y ofrece pociones.', 'morgana_bruja.jpg', 6),
    ('Helga la Alquimista', 'Una alquimista que busca ingredientes raros.', 'helga_alquimista.jpg', 6),
    ('Lucas el Explorador', 'Un explorador que conoce los rincones más oscuros del mundo.', 'lucas_explorador.jpg', 7),
    ('Isabel la Cartógrafa', 'Una cartógrafa que dibuja mapas detallados.', 'isabel_cartografa.jpg', 7),
    ('Padre Miguel', 'Un sacerdote que bendice a los aventureros.', 'padre_miguel.jpg', 8),
    ('Hermana Clara', 'Una monja que cura a los heridos.', 'hermana_clara.jpg', 8),
    ('Roberto el Bardo', 'Un bardo que canta historias de héroes antiguos.', 'roberto_bardo.jpg', 9),
    ('Laura la Juglaresa', 'Una juglaresa que entretiene con sus trucos.', 'laura_juglaresa.jpg', 9),
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
    (2, 22, 3),   -- Recolectar 3 unidades de Piedra Mágica
    (2, 25, 2),   -- Recolectar 2 unidades de Cristal Mágico
    (3, 26, 8),   -- Recolectar 8 unidades de Madera de Roble
    (3, 27, 1),   -- Recolectar 1 unidad de Hueso de Dragón
    (4, 22, 5),   -- Recolectar 5 unidades de Piedra Mágica
    (4, 25, 3),   -- Recolectar 3 unidades de Cristal Mágico
    (5, 21, 20),  -- Recolectar 20 unidades de Hierro
    (5, 28, 5),   -- Recolectar 5 unidades de Plata
    (5, 29, 2),   -- Recolectar 2 unidades de Oro
    (6, 22, 4),   -- Recolectar 4 unidades de Piedra Mágica
    (6, 24, 6),   -- Recolectar 6 unidades de Cuero
    (7, 25, 3),   -- Recolectar 3 unidades de Cristal Mágico
    (7, 26, 10),  -- Recolectar 10 unidades de Madera de Roble
    (8, 22, 2),   -- Recolectar 2 unidades de Piedra Mágica
    (8, 25, 1),   -- Recolectar 1 unidad de Cristal Mágico
    (9, 24, 7),   -- Recolectar 7 unidades de Cuero
    (9, 26, 5),   -- Recolectar 5 unidades de Madera de Roble
    (10, 27, 3),  -- Recolectar 3 unidades de Hueso de Dragón
    (10, 28, 2);  -- Recolectar 2 unidades de Plata
    
-- Insertar misiones de personajes
INSERT INTO personaje_mision (personaje_id, mision_id, fecha_inicio, fecha_fin, estado)
VALUES
    (1, 1, '2023-10-01 12:00:00', '2023-10-01 13:00:00', 'COMPLETADA'),  -- Cosecha en peligro
    (1, 2, '2023-10-02 14:00:00', NULL, 'EN_PROGRESO'),                 -- El mercader desaparecido
    (2, 3, '2023-10-03 15:00:00', '2023-10-03 17:00:00', 'COMPLETADA'),  -- Protege la ciudad
    (2, 4, '2023-10-04 18:00:00', NULL, 'EN_PROGRESO'),                 -- El secreto del mago
    (3, 5, '2023-10-05 19:00:00', NULL, 'EN_PROGRESO'),                 -- Forja legendaria
    (3, 6, '2023-10-06 20:00:00', '2023-10-06 21:00:00', 'COMPLETADA'),  -- La poción perdida
    (4, 7, '2023-10-07 22:00:00', NULL, 'EN_PROGRESO'),                 -- Mapa del tesoro
    (4, 8, '2023-10-08 23:00:00', '2023-10-09 00:00:00', 'COMPLETADA'),  -- Bendición divina
    (5, 9, '2023-10-09 10:00:00', NULL, 'EN_PROGRESO'),                 -- Canción del héroe
    (5, 10, '2023-10-10 11:00:00', '2023-10-10 12:00:00', 'FALLIDA');   -- Caza mayor
-- Insertar misiones de NPCs
INSERT INTO npc_mision (npc_id, mision_id)
VALUES
    (1, 1),  -- Cosecha en peligro
    (1, 11), -- Misión adicional: Protege los cultivos
    (2, 2),  -- El mercader desaparecido
    (2, 12), -- Misión adicional: Recupera la mercancía perdida
    (3, 3),  -- Protege la ciudad
    (3, 13), -- Misión adicional: Entrena a los reclutas
    (4, 4),  -- El secreto del mago
    (4, 14), -- Misión adicional: Recupera el grimorio perdido
    (5, 5),  -- Forja legendaria
    (5, 15), -- Misión adicional: Consigue minerales raros
    (6, 6),  -- La poción perdida
    (6, 16), -- Misión adicional: Encuentra la flor mágica
    (7, 7),  -- Mapa del tesoro
    (7, 17), -- Misión adicional: Explora las ruinas antiguas
    (8, 8),  -- Bendición divina
    (8, 18), -- Misión adicional: Protege el templo
    (9, 9),  -- Canción del héroe
    (9, 19), -- Misión adicional: Encuentra la lira dorada
    (10, 10), -- Caza mayor
    (10, 20); -- Misión adicional: Caza mayor
-- Insertar monstruos en mapas
INSERT INTO mapa_monstruos (mapa_id, monstruo_id, probabilidad_aparicion)
VALUES
    (1, 1, 70),  -- Goblin (70% de probabilidad)
    (1, 5, 50),  -- Lobo Salvaje (50% de probabilidad)
    (1, 7, 30),  -- Araña Gigante (30% de probabilidad)
    (2, 2, 60),  -- Ogro (60% de probabilidad)
    (2, 3, 40),  -- Dragón (40% de probabilidad)
    (2, 6, 20),  -- Esqueleto Guerrero (20% de probabilidad)
    (3, 6, 80),  -- Esqueleto Guerrero (80% de probabilidad)
    (3, 9, 50),  -- Nigromante (50% de probabilidad)
    (3, 10, 30), -- Araña (30% de probabilidad)
    (4, 4, 70),  -- Bandido (70% de probabilidad)
    (4, 8, 40),  -- Bandido Líder (40% de probabilidad)
    (4, 11, 20), -- Lobo Gigante (20% de probabilidad)
    (5, 4, 50),  -- Bandido (50% de probabilidad)
    (5, 8, 30),  -- Bandido Líder (30% de probabilidad)
    (6, 5, 60),  -- Lobo Salvaje (60% de probabilidad)
    (6, 7, 40),  -- Araña Gigante (40% de probabilidad)
    (6, 10, 20), -- Araña (20% de probabilidad)
    (7, 1, 50),  -- Goblin (50% de probabilidad)
    (7, 5, 30),  -- Lobo Salvaje (30% de probabilidad)
    (8, 6, 70),  -- Esqueleto Guerrero (70% de probabilidad)
    (8, 9, 50),  -- Nigromante (50% de probabilidad)
    (8, 12, 20), -- Lobo Sagrado (20% de probabilidad)
    (9, 3, 60),  -- Dragón (60% de probabilidad)
    (9, 6, 40),  -- Esqueleto Guerrero (40% de probabilidad)
    (9, 13, 20), -- Janeiro (20% de probabilidad)
    (10, 3, 50),  -- Dragón (50% de probabilidad)
    (10, 12, 30), -- Lobo Sagrado (30% de probabilidad)
    (10, 14, 20); -- Troll de Montaña (20% de probabilidad)
INSERT INTO npc_producto (npc_id, item_id, precio_compra, precio_venta, cantidad_venta)
VALUES
    (1, 4, 10, 20, 5),  -- Juan el Granjero vende Poción de Vida
    (1, 2, 15, 30, 3),  -- Juan el Granjero vende Poción de Maná
    (2, 3, 20, 40, 4),  -- María la Tejedora vende Poción de Energía
    (2, 4, 25, 50, 2),  -- María la Tejedora vende Elixir de Vida
    (3, 5, 50, 100, 10), -- Luis el Mercader vende Elixir de Maná
    (3, 6, 60, 120, 8),  -- Luis el Mercader vende Poción de Fuerza
    (4, 7, 70, 140, 6),  -- Ana la Comerciante vende Poción de Defensa
    (4, 8, 80, 160, 4),  -- Ana la Comerciante vende Poción de Invisibilidad
    (5, 9, 30, 60, 7),   -- Carlos el Guardia vende Espada de Acero
    (5, 10, 40, 80, 5),  -- Carlos el Guardia vende Escudo de Madera
    (6, 11, 50, 100, 6), -- Sofía la Capitana vende Daga Afilada
    (6, 12, 60, 120, 4), -- Sofía la Capitana vende Armadura de Platino
    (7, 13, 100, 200, 3), -- Merlín el Sabio vende Anillo de Poder
    (7, 14, 120, 240, 2), -- Merlín el Sabio vende Martillo de Guerra
    (8, 15, 150, 300, 1), -- Elena la Hechicera vende Capa del Mago
    (8, 16, 200, 400, 1), -- Elena la Hechicera vende Báculo Arcano
    (9, 17, 80, 160, 5),  -- Pedro el Herrero vende Botas de Velocidad
    (9, 18, 90, 180, 4),  -- Pedro el Herrero vende Cinturón de Resistencia
    (10, 19, 100, 200, 3), -- Lucía la Forjadora vende Guantes de Acero
    (10, 20, 110, 220, 2); -- Lucía la Forjadora vende Cinturón de Resistencia