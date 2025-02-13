DROP DATABASE IF EXISTS api_rpg_bd;
CREATE DATABASE IF NOT EXISTS api_rpg_bd;
USE api_rpg_bd;

-- Tabla: tipo_musuario
CREATE TABLE IF NOT EXISTS tipo_usuario (
    tipo_usuario_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    INDEX idx_nombre (nombre)
);

-- Insertar tipos de usuarios
INSERT INTO tipo_usuario (nombre, descripcion) VALUES
('usuario', 'Acceso básico al juego, puede crear personajes y jugar.'),
('moderador', 'Acceso medio, puede moderar contenido y usuarios.'),
('administrador', 'Acceso total, puede gestionar todo el sistema.');

-- Tabla: usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    usuario_id bigint PRIMARY KEY AUTO_INCREMENT,
    imagen_perfil VARCHAR(255),
    nombre_usuario_pub VARCHAR(100) NOT NULL,
    limite_personajes INT NOT NULL DEFAULT 3,
    nombre_usuario_priv VARCHAR(100) UNIQUE NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    ultima_conexion DATETIME,
    ip_ultima_conexion VARCHAR(45) NULL,
    fecha_creacion DATETIME NOT NULL,
    estado_cuenta BOOLEAN NOT NULL DEFAULT 1,
    tipo_usuario bigint NOT NULL DEFAULT 1,
    FOREIGN KEY (tipo_usuario) REFERENCES tipo_usuario(tipo_usuario_id),
    INDEX idx_correo (correo),
    INDEX idx_nombre_priv (nombre_usuario_priv)
);

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

-- Tabla: logs de usuario
CREATE TABLE IF NOT EXISTS logs (
    log_id bigint PRIMARY KEY AUTO_INCREMENT,
    usuario_id INT NULL,
    tipo_log ENUM('INFORMACION','FALLO', 'ADVERTENCIA','CREACION','ACTUALIZACION','BORRADO') DEFAULT 'INFORMACION',
    mensaje TEXT NOT NULL,
    fecha_log DATETIME NOT NULL,
    INDEX idx_usuario_id (usuario_id)
);

-- Insertar logs
INSERT INTO logs (usuario_id, tipo_log, mensaje, fecha_log) VALUES
(1, 'INFORMACION', 'Usuario1 ha iniciado sesión.', NOW()),
(2, 'FALLO', 'Usuario2 ha intentado iniciar sesión con una contraseña incorrecta.', NOW()),
(3, 'ADVERTENCIA', 'Usuario3 ha intentado acceder a una zona restringida.', NOW()),
(4, 'CREACION', 'Usuario4 ha creado un nuevo personaje.', NOW()),
(5, 'ACTUALIZACION', 'Usuario5 ha actualizado su perfil.', NOW());

CREATE TABLE IF NOT EXISTS clase_persoanje (
    clase_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
	vida_base INT NOT NULL DEFAULT 100,
    escudo_base INT NOT NULL DEFAULT 0,
    energia_base INT NOT NULL DEFAULT 50,
    mana_base INT NOT NULL DEFAULT 50,
    ataque_fisico_base INT NOT NULL DEFAULT 10,
    ataque_magico_base INT NOT NULL DEFAULT 10,
    defensa_fisica INT DEFAULT 0,
    defensa_magica INT DEFAULT 0,
    INDEX idx_nombre (nombre)
);

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

CREATE TABLE gremios (
    gremio_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);

INSERT INTO gremios (nombre, descripcion)
VALUES
    ('La Hermandad de la Luz', 'Un gremio dedicado a proteger a los inocentes y luchar contra las fuerzas de la oscuridad.'),
    ('Los Mercenarios de Hierro', 'Un grupo de mercenarios que acepta cualquier trabajo, siempre que el pago sea bueno.'),
    ('El Círculo Arcano', 'Una organización de magos que busca el conocimiento y el poder arcano.'),
    ('Los Cazadores de Sombras', 'Un gremio especializado en la caza de criaturas oscuras y monstruos.'),
    ('La Orden del Dragón', 'Una orden de caballeros que venera a los dragones y busca su protección.'),
    ('Los Ladrones de la Noche', 'Un gremio de ladrones y espías que opera en las sombras.'),
    ('Los Guardianes del Bosque', 'Un grupo de druidas y rangers que protegen la naturaleza.'),
    ('Los Forjadores de Leyendas', 'Un gremio de artesanos y herreros que crean armas y armaduras legendarias.'),
    ('Los Exploradores del Abismo', 'Un grupo de aventureros que explora ruinas antiguas y mazmorras peligrosas.'),
    ('Los Hijos del Caos', 'Una facción caótica que busca el desorden y la destrucción del orden establecido.');

CREATE TABLE grupos (
    grupo_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);
INSERT INTO grupos (nombre, descripcion)
VALUES
    ('Los Cuatro Elementos', 'Un grupo de aventureros que dominan los cuatro elementos: fuego, agua, tierra y aire.'),
    ('Los Guardianes del Amanecer', 'Un equipo de héroes que protegen el mundo de las amenazas que surgen con la luz del amanecer.'),
    ('Las Sombras del Destino', 'Un grupo sigiloso que opera en las sombras para cumplir misiones peligrosas.'),
    ('Los Hijos del Trueno', 'Un equipo de guerreros que luchan con la fuerza y el poder del trueno.'),
    ('Los Exploradores Perdidos', 'Un grupo de aventureros que buscan tesoros y secretos en lugares olvidados.'),
    ('Los Defensores de la Luz', 'Un equipo de paladines y clérigos que luchan contra las fuerzas de la oscuridad.'),
    ('Los Cazadores de Bestias', 'Un grupo especializado en la caza de criaturas peligrosas y monstruos.'),
    ('Los Maestros del Caos', 'Un equipo de magos y hechiceros que manipulan el caos para sus propios fines.'),
    ('Los Guardianes del Bosque', 'Un grupo de druidas y rangers que protegen la naturaleza y sus secretos.'),
    ('Los Mercenarios del Hierro', 'Un equipo de mercenarios que aceptan cualquier trabajo a cambio de oro.');

-- Tabla: personajes
CREATE TABLE IF NOT EXISTS personajes (
    personaje_id bigint PRIMARY KEY AUTO_INCREMENT,
    usuario_id bigint NOT NULL,
    imagen_modelo VARCHAR(255),
    nombre VARCHAR(100) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    clase_id bigint NULL,
    gremio_id bigint NULL,
    grupo_id bigint NULL,
    FOREIGN KEY (gremio_id) REFERENCES gremios(gremio_id),
    FOREIGN KEY (grupo_id) REFERENCES grupos(grupo_id),
    FOREIGN KEY (clase_id) REFERENCES clase_persoanje(clase_id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id) 
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    INDEX idx_usuario_id (usuario_id),
    INDEX idx_nombre (nombre)
);

INSERT INTO personajes (usuario_id, imagen_modelo, nombre, fecha_creacion, clase_id, gremio_id, grupo_id)
VALUES
    (1, 'imagen1.jpg', 'Aragorn', '2023-10-01 12:00:00', 1, 1, 1),  -- Guerrero, La Hermandad de la Luz, Los Cuatro Elementos
    (2, 'imagen2.jpg', 'Gandalf', '2023-10-02 13:00:00', 2, 3, 1),  -- Mago, El Círculo Arcano, Los Cuatro Elementos
    (3, 'imagen3.jpg', 'Legolas', '2023-10-03 14:00:00', 3, 4, 1),  -- Arquero, Los Cazadores de Sombras, Los Cuatro Elementos
    (4, 'imagen4.jpg', 'Frodo', '2023-10-04 15:00:00', 4, 2, 2),   -- Sacerdote, Los Mercenarios de Hierro, Los Guardianes del Amanecer
    (5, 'imagen5.jpg', 'Gimli', '2023-10-05 16:00:00', 1, 5, 2),   -- Guerrero, La Orden del Dragón, Los Guardianes del Amanecer
    (6, 'imagen6.jpg', 'Boromir', '2023-10-06 17:00:00', 5, 6, 3), -- Asesino, Los Ladrones de la Noche, Las Sombras del Destino
    (7, 'imagen7.jpg', 'Galadriel', '2023-10-07 18:00:00', 2, 7, 4),-- Mago, Los Guardianes del Bosque, Los Hijos del Trueno
    (8, 'imagen8.jpg', 'Saruman', '2023-10-08 19:00:00', 9, 8, 5), -- Nigromante, Los Forjadores de Leyendas, Los Exploradores Perdidos
    (9, 'imagen9.jpg', 'Arwen', '2023-10-09 20:00:00', 10, 9, 6),  -- Bardo, Los Exploradores del Abismo, Los Defensores de la Luz
    (10, 'imagen10.jpg', 'Sauron', '2023-10-10 21:00:00', 9, 10, 7);-- Nigromante, Los Hijos del Caos, Los Cazadores de Bestias





CREATE TABLE IF NOT EXISTS estadisticas_personaje (
    personaje_id bigint PRIMARY KEY,
    nivel INT NOT NULL DEFAULT 1,
    xp_acumulada INT NOT NULL DEFAULT 0,
    vida_base INT NOT NULL DEFAULT 100,
    escudo_base INT NOT NULL DEFAULT 0,
    energia_base INT NOT NULL DEFAULT 50,
    mana_base INT NOT NULL DEFAULT 50,
    ataque_fisico_base INT NOT NULL DEFAULT 10,
    ataque_magico_base INT NOT NULL DEFAULT 10,
    defensa_fisica INT DEFAULT 0,
    defensa_magica INT DEFAULT 0,
    almas INT NOT NULL DEFAULT 0,
    capacidad_inventario INT NOT NULL DEFAULT 10,
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

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


-- Tabla: logros_cacerias
CREATE TABLE if not exists logros_personaje (
    personaje_id bigint NOT NULL,
    normal INT DEFAULT 0,
    miniboss INT DEFAULT 0,
    boss INT DEFAULT 0,
    muertes_totales INT DEFAULT 0,
    total_daño_inflijido INT DEFAULT 0,
    total_daño_recibido INT DEFAULT 0,
    tiempo_total_jugado INT DEFAULT 0,
    mazmorras_totales_superadas INT DEFAULT 0,
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE
);

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

-- Tabla: tipo_monstruo
CREATE TABLE IF NOT EXISTS tipo_monstruo (
    tipo_monstruo_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    INDEX idx_nombre (nombre)
);

INSERT INTO tipo_monstruo (nombre, descripcion)
VALUES
    ('Normal', 'Monstruos comunes que se encuentran en áreas abiertas y mazmorras.'),
    ('Miniboss', 'Enemigos más poderosos que los normales, pero menos que los bosses. Suelen guardar tesoros o áreas especiales.'),
    ('Boss', 'Enemigos extremadamente poderosos que actúan como jefes de mazmorras o áreas. Derrotarlos suele ser un gran logro.'),
    ('Élite', 'Monstruos raros y poderosos que son más fuertes que los normales pero no tanto como los bosses.'),
    ('Legendario', 'Monstruos únicos y extremadamente poderosos, a menudo relacionados con historias o misiones especiales.'),
    ('Criatura de Caos', 'Monstruos corruptos por el caos, con habilidades impredecibles y peligrosas.'),
    ('Guardian', 'Monstruos que protegen lugares sagrados o tesoros valiosos.'),
    ('Depredador', 'Monstruos ágiles y letales que cazan a sus presas en manadas o en solitario.'),
    ('Espíritu', 'Entidades espirituales o fantasmas que suelen ser inmunes a ciertos tipos de daño.'),
    ('Gigante', 'Monstruos de gran tamaño y fuerza bruta, pero lentos y predecibles.');
    
    
-- Tabla: monstruos
CREATE TABLE IF NOT EXISTS monstruos (
    monstruo_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    tipo_monstruo_id bigint NOT NULL,
	nivel INT DEFAULT 1,
    descripcion TEXT,
    imagen VARCHAR(255),
    vida_base INT NOT NULL DEFAULT 100,
    escudo_base INT NOT NULL DEFAULT 0,
    energia_base INT NOT NULL DEFAULT 50,
    mana_base INT NOT NULL DEFAULT 50,
    ataque_fisico_base INT NOT NULL DEFAULT 10,
    ataque_magico_base INT NOT NULL DEFAULT 10,
    defensa_fisica INT DEFAULT 0,
    defensa_magica INT DEFAULT 0,
    almas INT NOT NULL,
    experiencia_otorgada INT DEFAULT 0,
    FOREIGN KEY (tipo_monstruo_id) REFERENCES tipo_monstruo(tipo_monstruo_id),
    INDEX idx_nombre (nombre),
    INDEX idx_tipo_monstruo (tipo_monstruo_id)
);

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
    
CREATE TABLE registro_caza (
    registro_caza_id BIGINT AUTO_INCREMENT PRIMARY KEY, 
    personaje_id BIGINT NOT NULL,                        
    monstruo_id BIGINT NOT NULL,                         
    fecha_caza DATETIME NOT NULL,                       
    almas_obtenidas INT NOT NULL,                     
    experiencia_obtenida INT NOT NULL,                  
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id),
    FOREIGN KEY (monstruo_id) REFERENCES monstruos(monstruo_id)      
);

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
    
-- Tabla: efectos_estados
CREATE TABLE IF NOT EXISTS efectos_estados (
    efecto_id bigint PRIMARY KEY AUTO_INCREMENT,
    imagen_icono VARCHAR(255),
    nombre VARCHAR(100) NOT NULL,
    tipo ENUM('BUFF', 'DEBUFF') NOT NULL,
    tipo_afectado ENUM('PERSONAJE', 'MONSTRUO', 'TODO') DEFAULT 'personaje',
    duracion_efecto INT NOT NULL DEFAULT 0,
    intervalos_efecto INT NOT NULL DEFAULT 0,
    acumulaciones INT NOT NULL DEFAULT 0,
    vida_base INT NOT NULL DEFAULT 0,
	escudo_base INT NOT NULL DEFAULT 0,
    energia_base INT NOT NULL DEFAULT 0,
    mana_base INT NOT NULL DEFAULT 0,
    ataque_fisico_base INT NOT NULL DEFAULT 0,
    ataque_magico_base INT NOT NULL DEFAULT 0,
    defensa_fisica INT DEFAULT 0,
    defensa_magica INT DEFAULT 0,
    descripcion TEXT,
    INDEX idx_nombre (nombre)
);

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


CREATE TABLE IF NOT EXISTS tipo_mapa (
    tipo_mapa_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    INDEX idx_nombre (nombre)
);

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

-- Tabla: mapas
CREATE TABLE IF NOT EXISTS mapas (
    mapa_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    imagen VARCHAR(255),
    tipo_mapa_id bigint NOT NULL,
    nivel_recomendado INT DEFAULT 1,
    FOREIGN KEY (tipo_mapa_id) REFERENCES tipo_mapa(tipo_mapa_id),
    INDEX idx_nombre (nombre),
    INDEX idx_tipo_mapa (tipo_mapa_id)
);

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

-- Tabla: mapa_efecto
CREATE TABLE IF NOT EXISTS mapa_efecto (
    mapa_id bigint NOT NULL,
    efecto_id bigint NOT NULL,
    PRIMARY KEY (mapa_id, efecto_id),
    FOREIGN KEY (efecto_id) REFERENCES efectos_estados(efecto_id),
    FOREIGN KEY (mapa_id) REFERENCES mapas(mapa_id)
);

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

-- Tabla: tipo_item
CREATE TABLE IF NOT EXISTS tipo_item (
    tipo_item_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    INDEX idx_nombre (nombre)
);

-- Insertar tipos de item
INSERT INTO tipo_item (nombre, descripcion) VALUES
('consumible', 'Consumibles que pueden ser usados para restaurar salud, energía, etc.'),
('equipo', 'Equipo que puede ser equipado por los personajes.'),
('material', 'Materiales que pueden ser usados para misiones o crafteo.');

-- Tabla: items
CREATE TABLE IF NOT EXISTS items (
    item_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    tipo_item bigint NOT NULL,
    descripcion TEXT,
    acumulaciones_max INT NOT NULL DEFAULT 99,
    precio_base INT DEFAULT 0,
    valor_dinamico INT DEFAULT 0,
    foreign key (tipo_item) REFERENCES tipo_item(tipo_item_id),
    INDEX idx_nombre (nombre),
    INDEX idx_tipo_item (tipo_item)
);

-- Insertar items
INSERT INTO items (nombre, tipo_item, descripcion, acumulaciones_max, precio_base, valor_dinamico) VALUES
('Poción de Vida', 1, 'Restaura 50 puntos de vida', 99, 10, 5),
('Espada de Acero', 2, 'Una espada básica', 1, 50, 10),
('Hierba Mágica', 3, 'Material para misiones', 99, 5, 2),
('Poción de Energía', 1, 'Restaura 30 puntos de energía', 99, 20, 5),
('Poción de Veneno', 1, 'Aplica veneno al enemigo', 99, 15, 3),
('Gema Brillante', 3, 'Una gema valiosa para misiones', 99, 100, 20),
('Mapa del Tesoro', 3, 'Un mapa que lleva a un tesoro escondido', 1, 200, 50),
('Espada Larga', 2, 'Una espada más poderosa que la de acero', 1, 80, 15),
('Escudo de Hierro', 2, 'Escudo básico', 1, 40, 10);

-- Tabla: item_efecto
CREATE TABLE IF NOT EXISTS item_efecto (
    item_id bigint NOT NULL,
    efecto_id bigint NOT NULL,
    PRIMARY KEY (item_id, efecto_id),
    FOREIGN KEY (efecto_id) REFERENCES efectos_estados(efecto_id),
    FOREIGN KEY (item_id) REFERENCES items(item_id)
);

-- Insertar efectos de items
INSERT INTO item_efecto (item_id, efecto_id) VALUES
(1, 1),  -- Poción de Vida tiene efecto Fuerza
(2, 2),  -- Espada de Acero tiene efecto Veneno
(3, 3),  -- Hierba Mágica tiene efecto VenenoV2
(4, 4),  -- Poción de Energía tiene efecto Protección
(5, 5);  -- Poción de Veneno tiene efecto Fuerza Mejorada

-- Tabla: tipos_equipamiento
CREATE TABLE IF NOT EXISTS tipo_equipamiento (
    tipo_equipamiento_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    INDEX idx_nombre (nombre)
);

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


-- Tabla: drops_objetos
CREATE TABLE IF NOT EXISTS drops_objetos (
    monstruo_id bigint NOT NULL,
    item_id bigint NOT NULL,
    probabilidad INT NOT NULL DEFAULT 100,  -- Probabilidad de que el objeto sea soltado
	primary key(monstruo_id,item_id),
    FOREIGN KEY (monstruo_id) REFERENCES monstruos(monstruo_id) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE,
    FOREIGN KEY (item_id) REFERENCES items(item_id),
    INDEX idx_monstruo_id (monstruo_id),
    INDEX idx_item_id (item_id)
);

-- Insertar drops de monstruos
INSERT INTO drops_objetos (monstruo_id, item_id, probabilidad) VALUES
(1, 1, 50),  -- Goblin puede soltar Poción de Vida
(2, 2, 30),  -- Ogro puede soltar Espada de Acero
(3, 3, 20),  -- Dragón puede soltar Hierba Mágica
(4, 4, 40),  -- Bandido puede soltar Poción de Energía
(5, 5, 10);  -- Lobo Salvaje puede soltar Poción de Veneno

-- Tabla: objetos_equipables
CREATE TABLE IF NOT EXISTS estadisticas_equipamiento ( 
    equipamiento_id bigint PRIMARY KEY AUTO_INCREMENT,
    item_id bigint NOT NULL,
    tipo_equipamiento_id bigint NOT NULL,
    vida_base INT NOT NULL DEFAULT 0,
	escudo_base INT NOT NULL DEFAULT 0,
    energia_base INT NOT NULL DEFAULT 0,
    mana_base INT NOT NULL DEFAULT 0,
    ataque_fisico_base INT NOT NULL DEFAULT 0,
    ataque_magico_base INT NOT NULL DEFAULT 0,
    defensa_fisica INT DEFAULT 0,
    defensa_magica INT DEFAULT 0,
    FOREIGN KEY (item_id) REFERENCES items(item_id) ON DELETE CASCADE,
    FOREIGN KEY (tipo_equipamiento_id) REFERENCES tipo_equipamiento(tipo_equipamiento_id),
    INDEX idx_tipo_equipamiento (tipo_equipamiento_id)
);

-- Insertar objetos equipables
INSERT INTO estadisticas_equipamiento (item_id, tipo_equipamiento_id, vida_base, escudo_base, energia_base, mana_base, ataque_fisico_base, ataque_magico_base, defensa_fisica, defensa_magica) VALUES
(2, 1, 0, 0, 0, 0, 10, 0, 0, 0),  -- Espada de Acero es un Arma Principal (aumenta ataque físico)
(8, 1, 0, 0, 0, 0, 15, 0, 0, 0),  -- Espada Larga es un Arma Principal (aumenta ataque físico)
(9, 2, 0, 10, 0, 0, 0, 0, 5, 5),  -- Escudo de Hierro es un Arma Secundaria (aumenta escudo y defensas)
(6, 7, 0, 0, 20, 0, 0, 0, 0, 0),  -- Gema Brillante es un Accesorio 1 (aumenta energía)
(7, 8, 0, 0, 0, 30, 0, 0, 0, 0);  -- Mapa del Tesoro es un Accesorio 2 (aumenta maná)

-- Tabla: inventario de personajes
CREATE TABLE IF NOT EXISTS inventario_personaje (
    personaje_id bigint NOT NULL,
    item_id bigint NOT NULL,
    cantidad INT NOT NULL DEFAULT 1,
    equipado BOOLEAN DEFAULT 0,
	fecha_obtencion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    primary key(personaje_id,item_id),
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES items(item_id) ON DELETE CASCADE,
    INDEX idx_personaje_id (personaje_id),
    INDEX idx_item_id (item_id)
);
-- Insertar inventario de personajes
INSERT INTO inventario_personaje (personaje_id, item_id, cantidad, equipado) VALUES
-- Guerrero1
(1, 1, 5, 0),  -- 5 Pociones de Vida (no equipables)
(1, 2, 1, 1),     -- 1 Espada de Acero (equipada, tipo: Arma Principal)
-- Mago1
(2, 4, 3, 0),  -- 3 Pociones de Energía (no equipables)
(2, 9, 1, 1),     -- 1 Escudo de Hierro (equipado, tipo: Arma Secundaria)
-- Arquero1
(3, 3, 10, 0), -- 10 Hierbas Mágicas (no equipables)
(3, 8, 1, 1),     -- 1 Espada Larga (equipada, tipo: Arma Principal)
-- Hechicero1
(4, 5, 2, 0),  -- 2 Pociones de Veneno (no equipables)
(4, 6, 1, 1),     -- 1 Gema Brillante (equipada, tipo: Accesorio 1)
-- Caballero1
(5, 7, 1, 1);     -- 1 Mapa del Tesoro (equipado, tipo: Accesorio 2)

-- Tabla: habilidades 
CREATE TABLE IF NOT EXISTS habilidades (
    habilidad_id bigint PRIMARY KEY AUTO_INCREMENT,
    imagen VARCHAR(255),
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    nivel_maximo INT NOT NULL DEFAULT 1,
    requisito_nivel INT NOT NULL DEFAULT 1,
    tipo_habilidad ENUM('OFENSIVA', 'DEFENSIVA','APOYO') DEFAULT 'ofensiva',
    objetivo_habilidad ENUM('JUGADOR','ALIADO','ENEMIGO','TODO') DEFAULT 'todo',
    area_efecto INT NOT NULL DEFAULT 1,
    unidades_afectadas INT NOT NULL DEFAULT 1,
    curacion_base INT NOT NULL DEFAULT 0,
    escudo_base INT NOT NULL DEFAULT 0,
    energia_base INT NOT NULL DEFAULT 30,
    mana_base INT NOT NULL DEFAULT 0,
    ataque_fisico_base INT NOT NULL DEFAULT 0,
    ataque_magico_base INT NOT NULL DEFAULT 0,
    defensa_fisica INT DEFAULT 0,
    defensa_magica INT DEFAULT 0,
    enfriamiento INT NOT NULL DEFAULT 0, 
    INDEX idx_nombre (nombre)
);

-- Insertar habilidades
INSERT INTO habilidades (imagen, nombre, descripcion, tipo_habilidad, objetivo_habilidad, area_efecto, unidades_afectadas, curacion_base, escudo_base, energia_base, mana_base, ataque_fisico_base, ataque_magico_base, defensa_fisica, defensa_magica, enfriamiento) VALUES
('habilidad1.png', 'Corte rápido', 'Un ataque rápido con la espada', 'ofensiva', 'enemigo', 1, 1, 0, 0, 10, 0, 15, 0, 0, 0, 2),
('habilidad2.png', 'Curación menor', 'Cura 20 puntos de vida', 'defensiva', 'jugador', 1, 1, 20, 0, 15, 0, 0, 0, 0, 0, 3),
('corte_sombra.png', 'Corte de Sombra', 'Un ataque rápido que ignora la defensa', 'ofensiva', 'enemigo', 1, 1, 0, 0, 20, 0, 25, 0, 0, 0, 3),
('escudo_proteccion.png', 'Escudo de Protección', 'Aumenta la defensa temporalmente', 'defensiva', 'jugador', 1, 1, 0, 30, 15, 0, 0, 0, 10, 10, 4),
('lluvia_flechas.png', 'Lluvia de Flechas', 'Ataque de área que afecta a múltiples enemigos', 'ofensiva', 'enemigo', 3, 3, 0, 0, 25, 0, 20, 0, 0, 0, 5);


-- Tabla: habilidad_efecto
CREATE TABLE IF NOT EXISTS habilidad_efecto (
    habilidad_id bigint NOT NULL,
    efecto_id bigint NOT NULL,
    PRIMARY KEY (efecto_id, habilidad_id),
    FOREIGN KEY (efecto_id) REFERENCES efectos_estados(efecto_id),
    FOREIGN KEY (habilidad_id) REFERENCES habilidades(habilidad_id)
);

-- Insertar efectos de habilidades
INSERT INTO habilidad_efecto (habilidad_id, efecto_id) VALUES
(1, 1),  -- Corte rápido tiene efecto Fuerza
(2, 2),  -- Curación menor tiene efecto Veneno
(3, 3),  -- Corte de Sombra tiene efecto VenenoV2
(4, 4),  -- Escudo de Protección tiene efecto Protección
(5, 5);  -- Lluvia de Flechas tiene efecto Fuerza Mejorada

-- Tabla: personaje_habilidad
CREATE TABLE IF NOT EXISTS personaje_habilidad (
    personaje_id bigint NOT NULL,
    habilidad_id bigint NOT NULL,
    nivel INT NOT NULL DEFAULT 1,
    ultimo_uso DATETIME,
    PRIMARY KEY (personaje_id, habilidad_id),
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id),
    FOREIGN KEY (habilidad_id) REFERENCES habilidades(habilidad_id),
    INDEX idx_personaje_id (personaje_id,habilidad_id)
);

-- Insertar habilidades de personajes
INSERT INTO personaje_habilidad (personaje_id, habilidad_id, nivel, ultimo_uso) VALUES
(1, 1, 1, NOW()),  -- Guerrero1 tiene Corte rápido
(2, 2, 1, NOW()),  -- Mago1 tiene Curación menor
(3, 3, 1, NOW()),  -- Arquero1 tiene Corte de Sombra
(4, 4, 1, NOW()),  -- Hechicero1 tiene Escudo de Protección
(5, 5, 1, NOW());  -- Caballero1 tiene Lluvia de Flechas

-- Tabla: monstruo_habilidad
CREATE TABLE IF NOT EXISTS monstruo_habilidad (
    monstruo_id bigint NOT NULL,
    habilidad_id bigint NOT NULL,
    nivel_habilidad INT NOT NULL DEFAULT 1,
    probabilidad_uso INT DEFAULT 100,
    PRIMARY KEY (monstruo_id, habilidad_id),
    FOREIGN KEY (monstruo_id) REFERENCES monstruos(monstruo_id) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE,
    FOREIGN KEY (habilidad_id) REFERENCES habilidades(habilidad_id),
    INDEX idx_monstruo_id (monstruo_id),
    INDEX idx_habilidad_id (habilidad_id)
);

-- Insertar habilidades de monstruos
INSERT INTO monstruo_habilidad (monstruo_id, habilidad_id, nivel_habilidad, probabilidad_uso) VALUES
(1, 1, 1, 50),  -- Goblin tiene Corte rápido
(2, 2, 1, 30),  -- Ogro tiene Curación menor
(3, 3, 1, 70),  -- Dragón tiene Corte de Sombra
(4, 4, 1, 40),  -- Bandido tiene Escudo de Protección
(5, 5, 1, 60);  -- Lobo Salvaje tiene Lluvia de Flechas

-- Tabla: tipo_npc
CREATE TABLE IF NOT EXISTS tipo_npc (
    tipo_npc_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    INDEX idx_nombre (nombre)
);

-- Insertar tipos de NPC
INSERT INTO tipo_npc (nombre, descripcion) VALUES
('Aldeano', 'Un aldeano común que ofrece misiones simples.'),
('Mercader', 'Un mercader que vende objetos útiles.'),
('Guardia', 'Un guardia que protege la ciudad.'),
('Mago', 'Un mago que ofrece misiones mágicas.'),
('Herrero', 'Un herrero que puede mejorar tu equipo.');

-- Tabla: npc
CREATE TABLE IF NOT EXISTS npc (
    npc_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    imagen VARCHAR(255),
    tipo_npc bigint NOT NULL,
    FOREIGN KEY (tipo_npc) REFERENCES tipo_npc(tipo_npc_id),
    INDEX idx_nombre (nombre)
);

-- Insertar NPCs
INSERT INTO npc (nombre, descripcion, imagen, tipo_npc) VALUES
('Aldeano', 'Un aldeano común que ofrece misiones simples.', 'aldeano.jpg', 1),
('Mercader', 'Un mercader que vende objetos útiles.', 'mercader.jpg', 2),
('Guardia', 'Un guardia que protege la ciudad.', 'guardia.jpg', 3),
('Mago', 'Un mago que ofrece misiones mágicas.', 'mago.jpg', 4),
('Herrero', 'Un herrero que puede mejorar tu equipo.', 'herrero.jpg', 5);

-- Tabla: misiones
CREATE TABLE IF NOT EXISTS misiones (
    mision_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    nivel_minimo INT NOT NULL,
    recompensa_almas INT DEFAULT 0,
    recompensa_experiencia INT DEFAULT 0,
    tiempo_limite INT NULL DEFAULT 30,
    INDEX idx_nombre (nombre)
);

-- Insertar misiones
INSERT INTO misiones (nombre, descripcion, nivel_minimo, recompensa_almas, recompensa_experiencia, tiempo_limite) VALUES
('Cazar Goblin', 'Derrota a 5 Goblins', 1, 50, 100, 30),
('Recoger Hierbas', 'Recoge 10 Hierbas Mágicas', 2, 30, 50, 20),
('Derrota a los Bandidos', 'Elimina a 5 bandidos que aterrorizan la región', 3, 100, 200, 40),
('Rescata al Niño Perdido', 'Encuentra y lleva al niño perdido de vuelta a la ciudad', 2, 60, 150, 30),
('Caza de Lobos', 'Caza 3 lobos salvajes para proteger a los aldeanos', 2, 40, 100, 20),
('El Tesoro del Bandido Líder', 'Derrota al bandido líder y recupera el mapa del tesoro', 5, 150, 300, 50),
('La Maldición del Esqueleto', 'Derrota al esqueleto guerrero que maldice el bosque', 4, 80, 250, 35);

-- Tabla: recompensa_objetos
CREATE TABLE IF NOT EXISTS mision_objetos (
    mision_id bigint NOT NULL,
    item_id bigint NOT NULL,
    cantidad INT NOT NULL DEFAULT 1,
    PRIMARY KEY(mision_id,item_id),
    FOREIGN KEY (mision_id) REFERENCES misiones(mision_id),
    FOREIGN KEY (item_id) REFERENCES items(item_id),
    INDEX idx_mision_id (mision_id),
    INDEX idx_item_id (item_id)
);

-- Insertar recompensas de misiones
INSERT INTO mision_objetos (mision_id, item_id, cantidad) VALUES
(1, 1, 1),  -- Cazar Goblin recompensa con Poción de Vida
(2, 3, 10), -- Recoger Hierbas recompensa con Hierba Mágica
(3, 2, 1),  -- Derrota a los Bandidos recompensa con Espada de Acero
(4, 4, 2),  -- Rescata al Niño Perdido recompensa con Poción de Energía
(5, 5, 1);  -- Caza de Lobos recompensa con Poción de Veneno

-- Tabla: personaje_mision
CREATE TABLE IF NOT EXISTS personaje_mision (
    personaje_id bigint NOT NULL,
    mision_id bigint NOT NULL,
    fecha_inicio DATETIME NOT NULL,
    fecha_fin DATETIME NULL,
    estado ENUM('EN_PROGRESO', 'COMPLETADA', 'FALLIDA') DEFAULT 'EN_PROGRESO',
    PRIMARY KEY (personaje_id, mision_id),
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id),
    FOREIGN KEY (mision_id) REFERENCES misiones(mision_id),
    INDEX idx_personaje_id (personaje_id),
    INDEX idx_mision_id (mision_id)
);

-- Insertar misiones de personajes
INSERT INTO personaje_mision (personaje_id, mision_id, fecha_inicio, fecha_fin, estado) VALUES
(1, 1, NOW(), NULL, 'en_progreso'),  -- Guerrero1 está en la misión Cazar Goblin
(2, 2, NOW(), NULL, 'en_progreso'),  -- Mago1 está en la misión Recoger Hierbas
(3, 3, NOW(), NULL, 'en_progreso'),  -- Arquero1 está en la misión Derrota a los Bandidos
(4, 4, NOW(), NULL, 'en_progreso'),  -- Hechicero1 está en la misión Rescata al Niño Perdido
(5, 5, NOW(), NULL, 'en_progreso');  -- Caballero1 está en la misión Caza de Lobos

-- Tabla: npc_mision
CREATE TABLE IF NOT EXISTS npc_mision (
    npc_id bigint NOT NULL,
    mision_id bigint NOT NULL,
    PRIMARY KEY (npc_id, mision_id),
    FOREIGN KEY (npc_id) REFERENCES npc(npc_id),
    FOREIGN KEY (mision_id) REFERENCES misiones(mision_id),
    INDEX idx_npc_id (npc_id),
    INDEX idx_mision_id (mision_id)
);

-- Insertar misiones de NPCs
INSERT INTO npc_mision (npc_id, mision_id) VALUES
(1, 1),  -- Aldeano ofrece la misión Cazar Goblin
(1, 2),  -- Aldeano ofrece la misión Recoger Hierbas
(3, 3),  -- Guardia ofrece la misión Derrota a los Bandidos
(4, 4),  -- Mago ofrece la misión Rescata al Niño Perdido
(5, 5);  -- Herrero ofrece la misión Caza de Lobos

-- Tabla: mapa_monstruos
CREATE TABLE IF NOT EXISTS mapa_monstruos (
    mapa_id bigint NOT NULL,
    monstruo_id bigint NOT NULL,
    probabilidad_aparicion INT DEFAULT 100,
    PRIMARY KEY (mapa_id, monstruo_id),
    FOREIGN KEY (mapa_id) REFERENCES mapas(mapa_id),
    FOREIGN KEY (monstruo_id) REFERENCES monstruos(monstruo_id),
    INDEX idx_mapa_id (mapa_id),
    INDEX idx_monstruo_id (monstruo_id)
);

-- Insertar monstruos en mapas
INSERT INTO mapa_monstruos (mapa_id, monstruo_id, probabilidad_aparicion) VALUES
(1, 1, 80),  -- Mazmorra Oscura tiene Goblins
(2, 2, 50),  -- Ciudad de los Héroes tiene Ogros
(3, 3, 30),  -- Bosque Encantado tiene Dragones
(4, 4, 70),  -- Bosque Tenebroso tiene Bandidos
(5, 5, 60);  -- Ciudad de los Caídos tiene Lobos Salvajes

-- Tabla: tienda_producto
CREATE TABLE IF NOT EXISTS npc_producto (
    npc_id bigint NOT NULL,
    item_id bigint NOT NULL,
    precio_compra INT NOT NULL,
    precio_venta INT NOT NULL,
    cantidad_venta INT NOT NULL,
    PRIMARY KEY (npc_id, item_id),
    FOREIGN KEY (npc_id) REFERENCES npc(npc_id),
    FOREIGN KEY (item_id) REFERENCES items(item_id),
    INDEX idx_npc_id (npc_id),
    INDEX idx_item_id (item_id)
);

-- Insertar productos de NPCs
INSERT INTO npc_producto (npc_id, item_id, precio_compra, precio_venta, cantidad_venta) VALUES
(2, 1, 15, 10, 10),  -- Mercader vende Poción de Vida
(2, 4, 25, 20, 5),   -- Mercader vende Poción de Energía
(5, 2, 60, 50, 1),   -- Herrero vende Espada de Acero
(5, 8, 90, 80, 1);   -- Herrero vende Espada Larga


-- Tabla: transacciones_comercio
CREATE TABLE IF NOT EXISTS transacciones_npc_personaje (
    transaccion_id bigint PRIMARY KEY AUTO_INCREMENT,
    personaje_id bigint NOT NULL,
    tipo_transaccion ENUM('COMPRA', 'VENTA') NOT NULL,
    npc_id bigint not NULL,
    item_id bigint NOT NULL,
    cantidad INT NOT NULL DEFAULT 1,
    precio_almas INT NOT NULL,
    fecha_transaccion DATETIME NOT NULL,
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id),
    FOREIGN KEY (npc_id) REFERENCES npc(npc_id),
    FOREIGN KEY (item_id) REFERENCES items(item_id),
    INDEX idx_personaje_id (personaje_id),
    INDEX idx_npc_id (npc_id),
    INDEX idx_item_id (item_id)
);

-- Insertar transacciones de NPCs y personajes
INSERT INTO transacciones_npc_personaje (personaje_id, tipo_transaccion, npc_id, item_id, cantidad, precio_almas, fecha_transaccion) VALUES
(1, 'compra', 2, 1, 5, 50, NOW()),  -- Guerrero1 compra 5 Pociones de Vida
(2, 'venta', 2, 4, 3, 60, NOW()),   -- Mago1 vende 3 Pociones de Energía
(3, 'compra', 5, 2, 1, 60, NOW()),  -- Arquero1 compra 1 Espada de Acero
(4, 'venta', 5, 8, 1, 90, NOW()),   -- Hechicero1 vende 1 Espada Larga
(5, 'compra', 2, 3, 10, 50, NOW()); -- Caballero1 compra 10 Hierbas Mágicas






-- Drop existing views
DROP VIEW IF EXISTS estadisticas_personaje_completo;
DROP VIEW IF EXISTS inventario_completo;
DROP VIEW IF EXISTS habilidades_completas;
DROP VIEW IF EXISTS mapas_detalles_completos;


CREATE VIEW estadisticas_personaje_completo AS
SELECT 
    p.personaje_id,
    p.nombre AS nombre_personaje,
    ep.nivel,
    ep.vida_base,
    ep.escudo_base,
    ep.energia_base,
    ep.mana_base,
    ep.ataque_fisico_base,
    ep.ataque_magico_base,
    ep.defensa_fisica,
    ep.defensa_magica,
    ep.almas,
    ep.capacidad_inventario,
    COALESCE(SUM(ee.vida_base), 0) AS vida_equipamiento,
    COALESCE(SUM(ee.escudo_base), 0) AS escudo_equipamiento,
    COALESCE(SUM(ee.energia_base), 0) AS energia_equipamiento,
    COALESCE(SUM(ee.mana_base), 0) AS mana_equipamiento,
    COALESCE(SUM(ee.ataque_fisico_base), 0) AS ataque_fisico_equipamiento,
    COALESCE(SUM(ee.ataque_magico_base), 0) AS ataque_magico_equipamiento,
    COALESCE(SUM(ee.defensa_fisica), 0) AS defensa_fisica_equipamiento,
    COALESCE(SUM(ee.defensa_magica), 0) AS defensa_magica_equipamiento
FROM estadisticas_personaje ep
JOIN personajes p ON ep.personaje_id = p.personaje_id
LEFT JOIN inventario_personaje ip ON p.personaje_id = ip.personaje_id AND ip.equipado = 1
LEFT JOIN estadisticas_equipamiento ee ON ip.item_id = ee.item_id
GROUP BY p.personaje_id;

DROP VIEW IF EXISTS inventario_completo;

CREATE VIEW inventario_completo AS
SELECT 
    ip.personaje_id,
    p.nombre AS nombre_personaje,
    ip.item_id,
    i.nombre AS nombre_item,
    i.descripcion AS descripcion_item,
    ip.cantidad,
    ip.equipado,
    ip.fecha_obtencion,
    ti.nombre AS tipo_item,
    ee.vida_base AS vida_item,
    ee.escudo_base AS escudo_item,
    ee.energia_base AS energia_item,
    ee.mana_base AS mana_item,
    ee.ataque_fisico_base AS ataque_fisico_item,
    ee.ataque_magico_base AS ataque_magico_item,
    ee.defensa_fisica AS defensa_fisica_item,
    ee.defensa_magica AS defensa_magica_item,
    te.nombre AS tipo_equipamiento
FROM inventario_personaje ip
JOIN items i ON ip.item_id = i.item_id
JOIN tipo_item ti ON i.tipo_item = ti.tipo_item_id
LEFT JOIN estadisticas_equipamiento ee ON ip.item_id = ee.item_id
LEFT JOIN tipo_equipamiento te ON ee.tipo_equipamiento_id = te.tipo_equipamiento_id
JOIN personajes p ON ip.personaje_id = p.personaje_id;

DROP VIEW IF EXISTS habilidades_completas;

CREATE VIEW habilidades_completas AS
SELECT 
    h.habilidad_id,
    h.nombre AS nombre_habilidad,
    h.descripcion AS descripcion_habilidad,
    h.nivel_maximo,
    h.requisito_nivel,
    h.tipo_habilidad,
    h.objetivo_habilidad,
    h.area_efecto,
    h.unidades_afectadas,
    h.curacion_base,
    h.escudo_base,
    h.energia_base,
    h.mana_base,
    h.ataque_fisico_base,
    h.ataque_magico_base,
    h.defensa_fisica,
    h.defensa_magica,
    h.enfriamiento,
    he.efecto_id,
    ee.nombre AS nombre_efecto,
    ee.descripcion AS descripcion_efecto
FROM habilidades h
LEFT JOIN habilidad_efecto he ON h.habilidad_id = he.habilidad_id
LEFT JOIN efectos_estados ee ON he.efecto_id = ee.efecto_id;


DROP VIEW IF EXISTS mapas_detalles_completos;

CREATE VIEW mapas_detalles_completos AS
SELECT 
    ma.mapa_id,
    ma.nombre AS nombre_mapa,
    ma.descripcion AS descripcion_mapa,
    ma.imagen,
    ma.nivel_recomendado,
    tm.nombre AS tipo_mapa,
    tm.descripcion AS descripcion_tipo_mapa,
    mm.monstruo_id,
    mo.nombre AS nombre_monstruo,
    mm.probabilidad_aparicion,
    me.efecto_id,
    ee.nombre AS nombre_efecto,
    ee.descripcion AS descripcion_efecto
FROM mapas ma
JOIN tipo_mapa tm ON ma.tipo_mapa_id = tm.tipo_mapa_id
LEFT JOIN mapa_monstruos mm ON ma.mapa_id = mm.mapa_id
LEFT JOIN monstruos mo ON mm.monstruo_id = mo.monstruo_id
LEFT JOIN mapa_efecto me ON ma.mapa_id = me.mapa_id
LEFT JOIN efectos_estados ee ON me.efecto_id = ee.efecto_id;






-- Trigers y funciones
DROP TRIGGER IF EXISTS AI_actualizar_logros_caza;
DROP TRIGGER IF EXISTS AI_validar_misiones_caza;
DROP TRIGGER IF EXISTS BI_verificar_limite_personajes;
DROP TRIGGER IF EXISTS hash_contraseña;
DROP TRIGGER IF EXISTS BI_inventario_personaje;
DROP TRIGGER IF EXISTS BU_inventario_personaje;
DROP TRIGGER IF EXISTS AD_inventario_personaje;




-- encriptar contrasenas
DELIMITER //

CREATE TRIGGER hash_contraseña
BEFORE INSERT ON usuarios
FOR EACH ROW
BEGIN
    SET NEW.contraseña = SHA2(NEW.contraseña, 256);
END//

DELIMITER ;


DELIMITER //

CREATE TRIGGER BI_verificar_limite_personajes
BEFORE INSERT ON personajes
FOR EACH ROW
BEGIN
    DECLARE personajes_count INT;

    -- Contar cuántos personajes tiene el usuario
    SELECT COUNT(*) INTO personajes_count
    FROM personajes
    WHERE usuario_id = NEW.usuario_id;

    -- Verificar si el límite de personajes ha sido alcanzado
    IF personajes_count >= (SELECT limite_personajes FROM usuarios WHERE usuario_id = NEW.usuario_id) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Límite de personajes alcanzado para este usuario';
    END IF;
END//

DELIMITER ;

DELIMITER //

CREATE TRIGGER BI_inventario_personaje
BEFORE INSERT ON inventario_personaje
FOR EACH ROW
BEGIN
    DECLARE tipo_equipamiento INT;
    DECLARE vida_item INT;
    DECLARE escudo_item INT;
    DECLARE energia_item INT;
    DECLARE mana_item INT;
    DECLARE ataque_fisico_item INT;
    DECLARE ataque_magico_item INT;
    DECLARE defensa_fisica_item INT;
    DECLARE defensa_magica_item INT;

    -- Obtener el tipo de equipamiento y las estadísticas del ítem
    SELECT 
        tipo_equipamiento_id, 
        vida_base, 
        escudo_base, 
        energia_base, 
        mana_base, 
        ataque_fisico_base, 
        ataque_magico_base, 
        defensa_fisica, 
        defensa_magica
    INTO 
        tipo_equipamiento, 
        vida_item, 
        escudo_item, 
        energia_item, 
        mana_item, 
        ataque_fisico_item, 
        ataque_magico_item, 
        defensa_fisica_item, 
        defensa_magica_item
    FROM estadisticas_equipamiento
    WHERE item_id = NEW.item_id;

    -- Verificar si ya hay un ítem equipado del mismo tipo
    IF NEW.equipado = 1 AND tipo_equipamiento IS NOT NULL THEN
        IF (
            SELECT COUNT(*)
            FROM inventario_personaje ip
            JOIN estadisticas_equipamiento ee ON ip.item_id = ee.item_id
            WHERE ip.personaje_id = NEW.personaje_id
              AND ee.tipo_equipamiento_id = tipo_equipamiento
              AND ip.equipado = 1
        ) > 0 THEN
            SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'El personaje ya tiene un ítem de este tipo equipado.';
        END IF;

        -- Sumar las estadísticas del ítem al personaje
        UPDATE estadisticas_personaje
        SET 
            vida_base = vida_base + vida_item,
            escudo_base = escudo_base + escudo_item,
            energia_base = energia_base + energia_item,
            mana_base = mana_base + mana_item,
            ataque_fisico_base = ataque_fisico_base + ataque_fisico_item,
            ataque_magico_base = ataque_magico_base + ataque_magico_item,
            defensa_fisica = defensa_fisica + defensa_fisica_item,
            defensa_magica = defensa_magica + defensa_magica_item
        WHERE personaje_id = NEW.personaje_id;
    END IF;
END//

DELIMITER ;

DELIMITER //

CREATE TRIGGER BU_inventario_personaje
BEFORE UPDATE ON inventario_personaje
FOR EACH ROW
BEGIN
    DECLARE tipo_equipamiento INT;
    DECLARE vida_item INT;
    DECLARE escudo_item INT;
    DECLARE energia_item INT;
    DECLARE mana_item INT;
    DECLARE ataque_fisico_item INT;
    DECLARE ataque_magico_item INT;
    DECLARE defensa_fisica_item INT;
    DECLARE defensa_magica_item INT;
    DECLARE max_inventory INT;
    DECLARE max_stack INT;
    DECLARE total_spaces INT;
    DECLARE available_spaces INT;
    DECLARE items_to_add INT;

    -- Validar que la cantidad no sea negativa
    IF NEW.cantidad < 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La cantidad no puede ser negativa.';
    END IF;

    -- Obtener la capacidad del inventario y el máximo de acumulación del ítem
    SELECT 
        ep.capacidad_inventario, 
        i.acumulaciones_max
    INTO 
        max_inventory, 
        max_stack
    FROM estadisticas_personaje ep
    JOIN items i ON i.item_id = NEW.item_id
    WHERE ep.personaje_id = NEW.personaje_id;

    -- Validar que max_stack no sea 0 para evitar división por cero
    IF max_stack = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El ítem no puede tener un máximo de acumulación de 0.';
    END IF;

    -- Calcular el total de espacios ocupados en el inventario (excluyendo el ítem que se está actualizando)
    SELECT SUM(CEIL(cantidad / acumulaciones_max)) INTO total_spaces
    FROM inventario_personaje ip
    JOIN items i ON ip.item_id = i.item_id
    WHERE ip.personaje_id = NEW.personaje_id
      AND ip.item_id != NEW.item_id;  -- Excluir el ítem que se está actualizando

    -- Calcular los espacios disponibles
    SET available_spaces = max_inventory - total_spaces;

    -- Calcular cuántos ítems se pueden agregar
    SET items_to_add = LEAST(NEW.cantidad, available_spaces * max_stack);

    -- Si no hay espacio suficiente, ajustar la cantidad y generar una advertencia
    IF items_to_add < NEW.cantidad THEN
        SET NEW.cantidad = items_to_add;
        SIGNAL SQLSTATE '01000' 
        SET MESSAGE_TEXT = 'El inventario está lleno. Solo se agregaron algunos ítems.';
    END IF;

    -- Obtener el tipo de equipamiento y las estadísticas del ítem
    SELECT 
        tipo_equipamiento_id, 
        vida_base, 
        escudo_base, 
        energia_base, 
        mana_base, 
        ataque_fisico_base, 
        ataque_magico_base, 
        defensa_fisica, 
        defensa_magica
    INTO 
        tipo_equipamiento, 
        vida_item, 
        escudo_item, 
        energia_item, 
        mana_item, 
        ataque_fisico_item, 
        ataque_magico_item, 
        defensa_fisica_item, 
        defensa_magica_item
    FROM estadisticas_equipamiento
    WHERE item_id = NEW.item_id;

    -- Verificar si ya hay un ítem equipado del mismo tipo
    IF NEW.equipado = 1 AND tipo_equipamiento IS NOT NULL THEN
        IF (
            SELECT COUNT(*)
            FROM inventario_personaje ip
            JOIN estadisticas_equipamiento ee ON ip.item_id = ee.item_id
            WHERE ip.personaje_id = NEW.personaje_id
              AND ee.tipo_equipamiento_id = tipo_equipamiento
              AND ip.equipado = 1
              AND ip.item_id != NEW.item_id  -- Excluir el ítem que se está actualizando
        ) > 0 THEN
            SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'El personaje ya tiene un ítem de este tipo equipado.';
        END IF;
    END IF;

    -- Restar las estadísticas si se desequipa un ítem
    IF OLD.equipado = 1 AND NEW.equipado = 0 THEN
        UPDATE estadisticas_personaje
        SET 
            vida_base = vida_base - vida_item,
            escudo_base = escudo_base - escudo_item,
            energia_base = energia_base - energia_item,
            mana_base = mana_base - mana_item,
            ataque_fisico_base = ataque_fisico_base - ataque_fisico_item,
            ataque_magico_base = ataque_magico_base - ataque_magico_item,
            defensa_fisica = defensa_fisica - defensa_fisica_item,
            defensa_magica = defensa_magica - defensa_magica_item
        WHERE personaje_id = NEW.personaje_id;
    END IF;

    -- Sumar las estadísticas si se equipa un ítem
    IF OLD.equipado = 0 AND NEW.equipado = 1 THEN
        UPDATE estadisticas_personaje
        SET 
            vida_base = vida_base + vida_item,
            escudo_base = escudo_base + escudo_item,
            energia_base = energia_base + energia_item,
            mana_base = mana

DELIMITER //

CREATE TRIGGER AD_inventario_personaje
AFTER DELETE ON inventario_personaje
FOR EACH ROW
BEGIN
    DECLARE tipo_equipamiento INT;
    DECLARE vida_item INT;
    DECLARE escudo_item INT;
    DECLARE energia_item INT;
    DECLARE mana_item INT;
    DECLARE ataque_fisico_item INT;
    DECLARE ataque_magico_item INT;
    DECLARE defensa_fisica_item INT;
    DECLARE defensa_magica_item INT;

    -- Obtener el tipo de equipamiento y las estadísticas del ítem eliminado
    SELECT 
        tipo_equipamiento_id, 
        vida_base, 
        escudo_base, 
        energia_base, 
        mana_base, 
        ataque_fisico_base, 
        ataque_magico_base, 
        defensa_fisica, 
        defensa_magica
    INTO 
        tipo_equipamiento, 
        vida_item, 
        escudo_item, 
        energia_item, 
        mana_item, 
        ataque_fisico_item, 
        ataque_magico_item, 
        defensa_fisica_item, 
        defensa_magica_item
    FROM estadisticas_equipamiento
    WHERE item_id = OLD.item_id;

    -- Si el ítem eliminado estaba equipado, restar sus estadísticas
    IF OLD.equipado = 1 THEN
        UPDATE estadisticas_personaje
        SET 
            vida_base = vida_base - vida_item,
            escudo_base = escudo_base - escudo_item,
            energia_base = energia_base - energia_item,
            mana_base = mana_base - mana_item,
            ataque_fisico_base = ataque_fisico_base - ataque_fisico_item,
            ataque_magico_base = ataque_magico_base - ataque_magico_item,
            defensa_fisica = defensa_fisica - defensa_fisica_item,
            defensa_magica = defensa_magica - defensa_magica_item
        WHERE personaje_id = OLD.personaje_id;
    END IF;
END//

DELIMITER ;

DELIMITER //

CREATE TRIGGER AI_actualizar_logros_caza
AFTER INSERT ON registro_caza
FOR EACH ROW
BEGIN
    DECLARE tipo_monstruo ENUM('NORMAL', 'MINIBOSS', 'BOSS');

    -- Obtener el tipo de monstruo derrotado
    SELECT tipo_monstruo INTO tipo_monstruo
    FROM monstruos
    WHERE monstruo_id = NEW.monstruo_id;

    -- Actualizar los logros del personaje según el tipo de monstruo
    CASE tipo_monstruo
        WHEN 'normal' THEN
            UPDATE logros_personaje
            SET normal = normal + 1
            WHERE personaje_id = NEW.personaje_id;
        WHEN 'miniboss' THEN
            UPDATE logros_personaje
            SET miniboss = miniboss + 1
            WHERE personaje_id = NEW.personaje_id;
        WHEN 'boss' THEN
            UPDATE logros_personaje
            SET boss = boss + 1
            WHERE personaje_id = NEW.personaje_id;
    END CASE;
END//

DELIMITER ;


DELIMITER //

CREATE TRIGGER AI_validar_misiones_caza
AFTER INSERT ON registro_caza
FOR EACH ROW
BEGIN
    DECLARE mision_id BIGINT;
    DECLARE monstruo_requerido_id BIGINT;
    DECLARE cantidad_requerida INT;
    DECLARE tiempo_limite INT;
    DECLARE fecha_inicio_mision DATETIME;
    DECLARE cantidad_actual INT;
    DECLARE tiempo_transcurrido INT;

    -- Cursor para recorrer las misiones relacionadas con la caza de monstruos
    DECLARE cur_misiones CURSOR FOR
    SELECT m.mision_id, mo.monstruo_id, mo.cantidad, m.tiempo_limite
    FROM misiones m
    JOIN mision_objetos mo ON m.mision_id = mo.mision_id
    WHERE mo.monstruo_id IS NOT NULL;

    -- Handler para cuando no haya más filas en el cursor
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET @fin = 1;

    -- Abrir el cursor
    OPEN cur_misiones;

    -- Recorrer las misiones
    bucle_misiones: LOOP
        FETCH cur_misiones INTO mision_id, monstruo_requerido_id, cantidad_requerida, tiempo_limite;
        IF @fin = 1 THEN
            LEAVE bucle_misiones;
        END IF;

        -- Verificar si el monstruo cazado coincide con el requerido por la misión
        IF NEW.monstruo_id = monstruo_requerido_id THEN
            -- Obtener la fecha de inicio de la misión para este personaje
            SELECT fecha_inicio INTO fecha_inicio_mision
            FROM personaje_mision
            WHERE personaje_id = NEW.personaje_id
              AND mision_id = mision_id;

            -- Calcular el tiempo transcurrido desde que se aceptó la misión
            SET tiempo_transcurrido = TIMESTAMPDIFF(MINUTE, fecha_inicio_mision, NOW());

            -- Verificar si el tiempo transcurrido es menor o igual al tiempo límite
            IF tiempo_transcurrido <= tiempo_limite THEN
                -- Obtener la cantidad actual de monstruos cazados para esta misión
                SELECT COUNT(*) INTO cantidad_actual
                FROM registro_caza rc
                WHERE rc.personaje_id = NEW.personaje_id
                  AND rc.monstruo_id = monstruo_requerido_id
                  AND rc.fecha_caza BETWEEN fecha_inicio_mision AND NOW();

                -- Verificar si se ha alcanzado la cantidad requerida
                IF cantidad_actual >= cantidad_requerida THEN
                    -- Actualizar el estado de la misión a "completada"
                    UPDATE personaje_mision
                    SET estado = 'completada'
                    WHERE personaje_id = NEW.personaje_id
                      AND mision_id = mision_id;
                END IF;
            ELSE
                -- Si se excedió el tiempo límite, marcar la misión como "fallida"
                UPDATE personaje_mision
                SET estado = 'fallida'
                WHERE personaje_id = NEW.personaje_id
                  AND mision_id = mision_id;
            END IF;
        END IF;
    END LOOP bucle_misiones;

    -- Cerrar el cursor
    CLOSE cur_misiones;
END//

DELIMITER ;

