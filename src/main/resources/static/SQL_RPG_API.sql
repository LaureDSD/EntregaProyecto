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

-- Insertar usuarios
INSERT INTO usuarios (imagen_perfil, nombre_usuario_pub, limite_personajes, nombre_usuario_priv, correo, contraseña, ultima_conexion, ip_ultima_conexion, fecha_creacion, estado_cuenta, tipo_usuario) VALUES
('img1.jpg', 'Usuario1', 3, 'user1', 'user1@example.com', 'password1', NOW(), '192.168.1.1', NOW(), 1, 1),
('img2.jpg', 'Usuario2', 3, 'user2', 'user2@example.com', 'password2', NOW(), '192.168.1.2', NOW(), 1, 2),
('img3.jpg', 'Usuario3', 3, 'user3', 'user3@example.com', 'password3', NOW(), '192.168.1.3', NOW(), 1, 3),
('img4.jpg', 'Usuario4', 3, 'user4', 'user4@example.com', 'password4', NOW(), '192.168.1.4', NOW(), 1, 1),
('img5.jpg', 'Usuario5', 3, 'user5', 'user5@example.com', 'password5', NOW(), '192.168.1.5', NOW(), 1, 1);


-- Tabla: logs de usuario
CREATE TABLE IF NOT EXISTS logs (
    log_id bigint PRIMARY KEY AUTO_INCREMENT,
    usuario_id INT NULL,
    tipo_log ENUM('informacion','fallo', 'advertencia','creacion','actulizacion','borrado') DEFAULT 'informacion',
    mensaje TEXT NOT NULL,
    fecha_log DATETIME NOT NULL,
    INDEX idx_usuario_id (usuario_id)
);

-- Insertar logs
INSERT INTO logs (usuario_id, tipo_log, mensaje, fecha_log) VALUES
(1, 'informacion', 'Usuario1 ha iniciado sesión.', NOW()),
(2, 'fallo', 'Usuario2 ha intentado iniciar sesión con una contraseña incorrecta.', NOW()),
(3, 'advertencia', 'Usuario3 ha intentado acceder a una zona restringida.', NOW()),
(4, 'creacion', 'Usuario4 ha creado un nuevo personaje.', NOW()),
(5, 'actulizacion', 'Usuario5 ha actualizado su perfil.', NOW());

-- Tabla: personajes
CREATE TABLE IF NOT EXISTS personajes (
    personaje_id bigint PRIMARY KEY AUTO_INCREMENT,
    usuario_id bigint NOT NULL,
    imagen_modelo VARCHAR(255),
    nombre VARCHAR(100) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id) 
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    INDEX idx_usuario_id (usuario_id),
    INDEX idx_nombre (nombre)
);

-- Insertar personajes
INSERT INTO personajes (usuario_id, imagen_modelo, nombre, fecha_creacion) VALUES
(1, 'model1.jpg', 'Guerrero1', NOW()),
(1, 'model2.jpg', 'Mago1', NOW()),
(2, 'model3.jpg', 'Arquero1', NOW()),
(3, 'model4.jpg', 'Hechicero1', NOW()),
(4, 'model5.jpg', 'Caballero1', NOW());

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

-- Insertar estadísticas de personajes
INSERT INTO estadisticas_personaje (personaje_id, nivel, xp_acumulada, vida_base,escudo_base, energia_base,mana_base, ataque_fisico_base,ataque_magico_base, defensa_fisica,defensa_magica, almas, capacidad_inventario) VALUES
(1, 1, 0, 100,0, 50,50, 10,8, 5,5, 0, 10),
(2, 1, 0, 80,0, 60,60, 8,8, 4, 0,5, 10),
(3, 1, 0, 90,0, 55,55, 9, 6,8, 0,5, 10),
(4, 1, 0, 70,0, 70,70, 7, 3,8, 0,5, 10),
(5, 1, 0, 120,0, 40,40, 12, 7,8,5, 0, 10);


-- Tabla: registro_cacerias
CREATE TABLE if not exists registro_personaje (
    registro_id bigint PRIMARY KEY AUTO_INCREMENT,
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
INSERT INTO registro_personaje (personaje_id, normal, miniboss, boss, muertes_totales, total_daño_inflijido, total_daño_recibido, tiempo_total_jugado, mazmorras_totales_superadas) VALUES
(1, 10, 2, 1, 0, 500, 200, 3600, 1),
(2, 5, 1, 0, 1, 300, 150, 1800, 0),
(3, 8, 3, 2, 0, 700, 300, 5400, 2),
(4, 3, 0, 0, 2, 100, 50, 900, 0),
(5, 15, 5, 3, 0, 1000, 400, 7200, 3);

-- Tabla: tipo_monstruo
CREATE TABLE IF NOT EXISTS tipo_monstruo (
    tipo_monstruo_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    INDEX idx_nombre (nombre)
);

-- Insertar tipos de monstruos
INSERT INTO tipo_monstruo (nombre, descripcion) VALUES
('normal', 'Monstruos comunes que se encuentran en cualquier zona.'),
('miniboss', 'Monstruos más fuertes que los normales, pero no tan poderosos como los jefes.'),
('boss', 'Jefes de mazmorra o zona, extremadamente poderosos.');

-- Tabla: monstruos
CREATE TABLE IF NOT EXISTS monstruos (
    monstruo_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    tipo_monstruo_id bigint NOT NULL,
	nivel INT DEFAULT 1,
    descripcion TEXT,
    imagen VARCHAR(255),
    vida_maxima INT NOT NULL,
    energia_maxima INT NOT NULL DEFAULT 0,
    ataque_base INT NOT NULL DEFAULT 0,
    defensa INT NOT NULL DEFAULT 0,
    almas INT NOT NULL,
    experiencia_otorgada INT DEFAULT 0,
    FOREIGN KEY (tipo_monstruo_id) REFERENCES tipo_monstruo(tipo_monstruo_id),
    INDEX idx_nombre (nombre),
    INDEX idx_tipo_monstruo (tipo_monstruo_id)
);

-- Insertar monstruos
INSERT INTO monstruos (nombre, tipo_monstruo_id, nivel, descripcion, imagen, vida_maxima, energia_maxima, ataque_base, defensa, almas, experiencia_otorgada) VALUES
('Goblin', 1, 1, 'Un pequeño monstruo verde', 'goblin.jpg', 50, 20, 5, 2, 10, 5),
('Ogro', 2, 5, 'Un monstruo grande y fuerte', 'ogro.jpg', 200, 50, 20, 10, 50, 20),
('Dragón', 3, 10, 'Un poderoso dragón', 'dragon.jpg', 1000, 200, 50, 30, 200, 100),
('Bandido', 1, 3, 'Un bandido común que ataca a los viajeros', 'bandido.jpg', 80, 30, 12, 5, 20, 15),
('Lobo Salvaje', 1, 2, 'Un lobo feroz que habita en los bosques', 'lobo.jpg', 60, 20, 8, 3, 15, 10),
('Esqueleto Guerrero', 2, 5, 'Un esqueleto revivido con habilidades de combate', 'esqueleto.jpg', 120, 40, 18, 8, 40, 25),
('Araña Gigante', 2, 4, 'Una araña gigante que teje telarañas venenosas', 'araña.jpg', 100, 35, 15, 6, 30, 20),
('Bandido Líder', 3, 7, 'El líder de una banda de bandidos', 'bandido_lider.jpg', 200, 60, 25, 12, 80, 50),
('Nigromante', 3, 7, 'El líder de esqueletos', 'nigromante.jpg', 200, 60, 25, 12, 80, 50),
('Araña', 1, 7, 'Araña pequeña que ataca en grupo', 'araña.jpg', 50, 10, 15, 2, 20, 20),
('Lobo Gigante', 2, 10, 'Un lobo gigante que habita en los bosques', 'lobo2.jpg', 100, 40, 8, 3, 25, 10),
('Lobo Sagrado', 3, 50, 'Un lobo sagrado feroz que habita en los bosques', 'lobo3.jpg', 200, 40, 8, 3, 25, 10),
('Janeiro', 3, 100, 'Un boss peligroso cuanto más le alarga la batalla', 'janeiro.jpg', 500, 1000, 150, 200, 200, 200);


-- Tabla: efectos_estados
CREATE TABLE IF NOT EXISTS efectos_estados (
    efecto_id bigint PRIMARY KEY AUTO_INCREMENT,
    imagen_icono VARCHAR(255),
    nombre VARCHAR(100) NOT NULL,
    tipo ENUM('buff', 'debuff') NOT NULL,
    tipo_afectado ENUM('personaje', 'monstruo', 'todo') DEFAULT 'personaje',
    duracion_efecto INT NOT NULL DEFAULT 0,
    intervalos_efecto INT NOT NULL DEFAULT 0,
    acumulaciones INT NOT NULL DEFAULT 0,
    ataque INT DEFAULT 0,
    defensa INT DEFAULT 0,
    vida INT DEFAULT 0,
    energia INT DEFAULT 0,
    descripcion TEXT,
    INDEX idx_nombre (nombre)
);

-- Insertar efectos y estados
INSERT INTO efectos_estados (imagen_icono, nombre, tipo, tipo_afectado, duracion_efecto, intervalos_efecto, ataque, defensa, vida, energia, descripcion) VALUES
('potenciacion.png', 'Fuerza', 'buff', 'personaje', 5, 1, 5, 0, 0, 0, 'Aumenta el ataque en 5 puntos'),
('veneno.png', 'Veneno', 'debuff', 'personaje', 3, 1, 0, 0, -3, 0, 'Reduce la vida en 3 puntos por turno'),
('venenoV2.png', 'VenenoV2', 'debuff', 'todo', 5, 1, 0, 0, -5, 0, 'Reduce la vida en 5 puntos por turno'),
('proteccion.png', 'Protección', 'buff', 'personaje', 3, 1, 0, 10, 0, 0, 'Aumenta la defensa en 10 puntos'),
('fuerza.png', 'Fuerza Mejorada', 'buff', 'personaje', 4, 1, 10, 0, 0, 0, 'Aumenta el ataque en 10 puntos'),
('fortaleza.png', 'Defensa Mejorada', 'buff', 'personaje', 4, 1, 0, 30, 0, 0, 'Aumenta la defensa en 10 puntos'),
('regeneracion.png', 'Regen de vida', 'buff', 'personaje', 4, 2, 0, 0, 50, 0, 'Regenera vida a intervalos regulares');

CREATE TABLE IF NOT EXISTS tipo_mapa (
    tipo_mapa_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    INDEX idx_nombre (nombre)
);

-- Insertar tipos de mapa
INSERT INTO tipo_mapa (nombre, descripcion) VALUES
('mazmorra', 'Un lugar peligroso lleno de enemigos y tesoros.'),
('ciudad', 'Un área segura con NPCs y servicios.'),
('bosque', 'Un área natural con criaturas y recursos.'),
('montaña', 'Un terreno elevado con desafíos únicos.'),
('desierto', 'Un terreno muy caliente'),
('cueva', 'Un lugar oscuro y misterioso.'),
('pantano', 'Un terreno muy húmedo'),
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
INSERT INTO mapas (nombre, descripcion, imagen, tipo_mapa_id, nivel_recomendado) VALUES
('Mazmorra Oscura', 'Una mazmorra llena de peligros', 'mazmorra.jpg', 1, 1),
('Ciudad de los Héroes', 'Una ciudad segura para descansar', 'ciudad.jpg', 2, 1),
('Bosque Encantado', 'Un bosque lleno de criaturas mágicas', 'bosque.jpg', 3, 3),
('Bosque Tenebroso', 'Un bosque oscuro lleno de criaturas peligrosas', 'bosque_tenebroso.jpg', 3, 4),
('Ciudad de los Caídos', 'Una ciudad llena de bandidos', 'ciudad_caidos.jpg', 2, 1),
('Montaña del Dragón', 'Una montaña donde habita un poderoso dragón', 'montaña_dragon.jpg', 4, 8),
('Pantano Maldito', 'Un pantano lleno de criaturas venenosas', 'pantano_maldito.jpg', 7, 5);

-- Tabla: mapa_efecto
CREATE TABLE IF NOT EXISTS mapa_efecto (
    mapa_id bigint NOT NULL,
    efecto_id bigint NOT NULL,
    PRIMARY KEY (mapa_id, efecto_id),
    FOREIGN KEY (efecto_id) REFERENCES efectos_estados(efecto_id),
    FOREIGN KEY (mapa_id) REFERENCES mapas(mapa_id)
);

-- Insertar efectos de mapas
INSERT INTO mapa_efecto (mapa_id, efecto_id) VALUES
(1, 1),  -- Mazmorra Oscura tiene efecto Fuerza
(2, 2),  -- Ciudad de los Héroes tiene efecto Veneno
(3, 3),  -- Bosque Encantado tiene efecto VenenoV2
(4, 4),  -- Bosque Tenebroso tiene efecto Protección
(5, 5);  -- Ciudad de los Caídos tiene efecto Fuerza Mejorada

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
    ataque INT DEFAULT 0,
    defensa INT DEFAULT 0,
    vida INT DEFAULT 0,
    energia INT DEFAULT 0,
    FOREIGN KEY (item_id) REFERENCES items(item_id) ON DELETE CASCADE,
    FOREIGN KEY (tipo_equipamiento_id) REFERENCES tipo_equipamiento(tipo_equipamiento_id),
    INDEX idx_tipo_equipamiento (tipo_equipamiento_id)
);

-- Insertar objetos equipables
INSERT INTO estadisticas_equipamiento (item_id, tipo_equipamiento_id, ataque, defensa, vida, energia) VALUES
(2, 1, 10, 0, 0, 0),  -- Espada de Acero es un Arma Principal
(8, 1, 15, 0, 0, 0),  -- Espada Larga es un Arma Principal
(9, 2, 0, 10, 0, 0),  -- Escudo de Hierro es un Arma Secundaria
(6, 7, 0, 0, 20, 0),  -- Gema Brillante es un Accesorio 1
(7, 8, 0, 0, 0, 30);  -- Mapa del Tesoro es un Accesorio 2

/*
-- Tabla: inventario_personaje
CREATE TABLE IF NOT EXISTS inventario_personaje (
    inventario_id INT PRIMARY KEY AUTO_INCREMENT,
    personaje_id INT NOT NULL,
    item_id INT NOT NULL,
    cantidad INT NOT NULL DEFAULT 1,
    equipado BOOLEAN DEFAULT 0,
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES items(item_id) ON DELETE CASCADE,
    INDEX idx_personaje_id (personaje_id),
    INDEX idx_item_id (item_id)
);

-- Insertar inventario de personajes
INSERT INTO inventario_personaje (personaje_id, item_id, cantidad, equipado) VALUES
(1, 1, 5, 0),  -- Guerrero1 tiene 5 Pociones de Vida
(1, 2, 1, 1),  -- Guerrero1 tiene 1 Espada de Acero equipada
(2, 4, 3, 0),  -- Mago1 tiene 3 Pociones de Energía
(3, 3, 10, 0), -- Arquero1 tiene 10 Hierbas Mágicas
(4, 5, 2, 0);  -- Hechicero1 tiene 2 Pociones de Veneno

-- Tabla: equipamiento_personaje
CREATE TABLE IF NOT EXISTS equipamiento_personaje (
    personaje_id INT NOT NULL,
    equipamiento_id INT NOT NULL,
    PRIMARY KEY (personaje_id, equipamiento_id),
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id),
    FOREIGN KEY (equipamiento_id) REFERENCES objetos_equipables(equipamiento_id),
    INDEX idx_personaje_id (personaje_id),
    INDEX idx_equipamiento_id (equipamiento_id)
);

-- Insertar equipamiento de personajes
INSERT INTO equipamiento_personaje (personaje_id, equipamiento_id) VALUES
(1, 1),  -- Guerrero1 equipa Espada de Acero
(2, 2),  -- Mago1 equipa Escudo de Hierro
(3, 3),  -- Arquero1 equipa Espada Larga
(4, 4),  -- Hechicero1 equipa Gema Brillante
(5, 5);  -- Caballero1 equipa Mapa del Tesoro
*/
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
    tipo_habilidad ENUM('ofensiva', 'defensiva','apoyo') DEFAULT 'ofensiva',
    objetivo_habilidad ENUM('jugador','aliado','enemigo','todo') DEFAULT 'todo',
    area_efecto INT NOT NULL DEFAULT 1,
    unidades_afectadas INT NOT NULL DEFAULT 1,
    consumo_energia INT NOT NULL DEFAULT 0,
    daño_base INT NOT NULL DEFAULT 0,
    curacion_base INT NOT NULL DEFAULT 0,
    enfriamiento INT NOT NULL DEFAULT 0, 
    INDEX idx_nombre (nombre)
);

-- Insertar habilidades
INSERT INTO habilidades (imagen, nombre, descripcion, tipo_habilidad, objetivo_habilidad, area_efecto, consumo_energia, daño_base, curacion_base, enfriamiento) VALUES
('habilidad1.png', 'Corte rápido', 'Un ataque rápido con la espada', 'ofensiva', 'enemigo', 1, 10, 15, 0, 2),
('habilidad2.png', 'Curación menor', 'Cura 20 puntos de vida', 'defensiva', 'jugador', 1, 15, 0, 20, 3),
('corte_sombra.png', 'Corte de Sombra', 'Un ataque rápido que ignora la defensa', 'ofensiva', 'enemigo', 1, 20, 25, 0, 3),
('escudo_proteccion.png', 'Escudo de Protección', 'Aumenta la defensa temporalmente', 'defensiva', 'jugador', 1, 15, 0, 0, 4),
('lluvia_flechas.png', 'Lluvia de Flechas', 'Ataque de área que afecta a múltiples enemigos', 'ofensiva', 'enemigo', 3, 25, 20, 0, 5);

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
    fecha_limite INT NULL DEFAULT 30,
    INDEX idx_nombre (nombre)
);

-- Insertar misiones
INSERT INTO misiones (nombre, descripcion, nivel_minimo, recompensa_almas, recompensa_experiencia, fecha_limite) VALUES
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
    estado ENUM('en_progreso', 'completada', 'fallida') DEFAULT 'en_progreso',
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
    tipo_transaccion ENUM('compra', 'venta') NOT NULL,
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





-- Vistas

drop view if exists estadisticas_personaje_completo;
CREATE VIEW estadisticas_personaje_completo AS
SELECT 
    p.personaje_id,
    p.nombre AS nombre_personaje,
    ep.nivel,
    ep.vida_base,
    ep.energia_base,
    ep.ataque_base,
    ep.defensa,
    ep.almas,
    ep.capacidad_inventario,
    SUM(ies.ataque) AS ataque_equipamiento,
    SUM(ies.defensa) AS defensa_equipamiento,
    SUM(ies.vida) AS vida_equipamiento,
    SUM(ies.energia) AS energia_equipamiento
FROM estadisticas_personaje ep
JOIN personajes p ON ep.personaje_id = p.personaje_id
LEFT JOIN inventario_personaje ip ON p.personaje_id = ip.personaje_id AND ip.equipado = 1
LEFT JOIN estadisticas_equipamiento ies ON ip.item_id = ies.item_id
GROUP BY p.personaje_id;











-- Trigers y funciones
DROP TRIGGER IF EXISTS verificar_limite_personajes;
-- DROP TRIGGER IF EXISTS hash_contraseña;
DROP TRIGGER IF EXISTS BI_inventario_personaje;
DROP TRIGGER IF EXISTS BU_inventario_personaje;
DROP TRIGGER IF EXISTS AD_inventario_personaje;


/*
-- encriptar contrasenas
DELIMITER //

CREATE TRIGGER hash_contraseña
BEFORE INSERT ON usuarios
FOR EACH ROW
BEGIN
    SET NEW.contraseña = SHA2(NEW.contraseña, 256);
END//

DELIMITER ;
*/

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
    DECLARE ataque_item INT;
    DECLARE defensa_item INT;
    DECLARE vida_item INT;
    DECLARE energia_item INT;

    -- Obtener el tipo de equipamiento y las estadísticas del ítem
    SELECT 
        tipo_equipamiento_id, 
        ataque, 
        defensa, 
        vida, 
        energia
    INTO 
        tipo_equipamiento, 
        ataque_item, 
        defensa_item, 
        vida_item, 
        energia_item
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
            ataque_base = ataque_base + ataque_item,
            defensa = defensa + defensa_item,
            vida_base = vida_base + vida_item,
            energia_base = energia_base + energia_item
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
    DECLARE ataque_item INT;
    DECLARE defensa_item INT;
    DECLARE vida_item INT;
    DECLARE energia_item INT;
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
        ataque, 
        defensa, 
        vida, 
        energia
    INTO 
        tipo_equipamiento, 
        ataque_item, 
        defensa_item, 
        vida_item, 
        energia_item
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
            ataque_base = ataque_base - ataque_item,
            defensa = defensa - defensa_item,
            vida_base = vida_base - vida_item,
            energia_base = energia_base - energia_item
        WHERE personaje_id = NEW.personaje_id;
    END IF;

    -- Sumar las estadísticas si se equipa un ítem
    IF OLD.equipado = 0 AND NEW.equipado = 1 THEN
        UPDATE estadisticas_personaje
        SET 
            ataque_base = ataque_base + ataque_item,
            defensa = defensa + defensa_item,
            vida_base = vida_base + vida_item,
            energia_base = energia_base + energia_item
        WHERE personaje_id = NEW.personaje_id;
    END IF;
END//

DELIMITER ;

DELIMITER //

CREATE TRIGGER AD_inventario_personaje
AFTER DELETE ON inventario_personaje
FOR EACH ROW
BEGIN
    DECLARE tipo_equipamiento INT;
    DECLARE ataque_item INT;
    DECLARE defensa_item INT;
    DECLARE vida_item INT;
    DECLARE energia_item INT;

    -- Obtener el tipo de equipamiento y las estadísticas del ítem eliminado
    SELECT 
        tipo_equipamiento_id, 
        ataque, 
        defensa, 
        vida, 
        energia
    INTO 
        tipo_equipamiento, 
        ataque_item, 
        defensa_item, 
        vida_item, 
        energia_item
    FROM estadisticas_equipamiento
    WHERE item_id = OLD.item_id;

    -- Si el ítem eliminado estaba equipado, restar sus estadísticas
    IF OLD.equipado = 1 THEN
        UPDATE estadisticas_personaje
        SET 
            ataque_base = ataque_base - ataque_item,
            defensa = defensa - defensa_item,
            vida_base = vida_base - vida_item,
            energia_base = energia_base - energia_item
        WHERE personaje_id = OLD.personaje_id;
    END IF;
END//

DELIMITER ;