DROP DATABASE IF EXISTS api_rpg_bd;
CREATE DATABASE IF NOT EXISTS api_rpg_bd;
USE api_rpg_bd;

-- Tabla: tipo_usuario (Corregido nombre)
CREATE TABLE IF NOT EXISTS tipo_usuario (
    tipo_usuario_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) unique NOT NULL,
    descripcion TEXT NOT NULL,
    INDEX idx_nombre (nombre)
);

-- Tabla: usuarios (Corregido)
CREATE TABLE IF NOT EXISTS usuarios (
    usuario_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    imagen_perfil VARCHAR(255),
    nombre_usuario_pub VARCHAR(100) NOT NULL,
    limite_personajes INT NOT NULL DEFAULT 3,
    nombre_usuario_priv VARCHAR(100) UNIQUE NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    ultima_conexion DATETIME NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    estado_cuenta BOOLEAN NOT NULL DEFAULT 1,
    tipo_usuario_id BIGINT NOT NULL DEFAULT 1,
    FOREIGN KEY (tipo_usuario_id) REFERENCES tipo_usuario(tipo_usuario_id)
    ON DELETE CASCADE,
    INDEX idx_correo (correo),
    INDEX idx_nombre_priv (nombre_usuario_priv)
);

-- Tabla: logs de usuario (Corregido)
CREATE TABLE IF NOT EXISTS logs (
    log_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    usuario_id BIGINT NULL,
    tipo_log ENUM('INFORMACION', 'FALLO', 'ADVERTENCIA', 'CREACION', 'ACTUALIZACION', 'BORRADO') DEFAULT 'INFORMACION',
    mensaje TEXT NOT NULL,
    fecha_log DATETIME NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    INDEX idx_usuario_id (usuario_id)
);

-- Estadisticas generales (Corregido)
CREATE TABLE IF NOT EXISTS estadisticas_generales (
    estadisticas_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    vida INT NOT NULL DEFAULT 0,
    regeneracion_vida INT NOT NULL DEFAULT 0,
    escudo INT NOT NULL DEFAULT 0,
    energia INT NOT NULL DEFAULT 0,
    regeneracion_energia INT NOT NULL DEFAULT 0,
    mana INT NOT NULL DEFAULT 0,
    regeneracion_mana INT NOT NULL DEFAULT 0,
    ataque_fisico INT NOT NULL DEFAULT 0,
    ataque_magico INT NOT NULL DEFAULT 0,
    defensa_fisica INT NOT NULL DEFAULT 0,
    defensa_magica INT NOT NULL DEFAULT 0
);

-- Tabla de clases de personaje (Corregido)
CREATE TABLE IF NOT EXISTS clase_personaje (
    clase_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    imagen VARCHAR(255) NULL,
    nombre VARCHAR(100) unique NOT NULL,
    descripcion TEXT NULL,
    estadisticas_id BIGINT NOT NULL,
    FOREIGN KEY (estadisticas_id) REFERENCES estadisticas_generales(estadisticas_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    INDEX idx_nombre (nombre)
);

-- Tabla de tipo de grupo (Corregido)
CREATE TABLE IF NOT EXISTS tipo_grupo (
    tipo_grupo_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) unique NOT NULL,
    numero_integrantes_max INT NOT NULL DEFAULT 1,
    comparten_exp_drops BOOLEAN NOT NULL DEFAULT FALSE,
    descripcion TEXT
);

-- Tabla de grupos (Corregido)
CREATE TABLE IF NOT EXISTS grupos (
    grupo_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    imagen_logo VARCHAR(255),
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    tipo_grupo_id BIGINT NOT NULL,
    FOREIGN KEY (tipo_grupo_id) REFERENCES tipo_grupo(tipo_grupo_id)
);

-- Tabla: personajes (Corregido)
CREATE TABLE IF NOT EXISTS personajes (
    personaje_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    usuario_id BIGINT NOT NULL,
    imagen_modelo VARCHAR(255),
    nombre VARCHAR(100) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    clase_id BIGINT NOT NULL,
    grupo_id BIGINT NULL,
    nivel INT NOT NULL DEFAULT 1,
    xp_acumulada INT NOT NULL DEFAULT 0,
    almas INT NOT NULL DEFAULT 0,
    capacidad_inventario INT NOT NULL DEFAULT 10,
    estadisticas_id BIGINT NOT NULL,
    FOREIGN KEY (estadisticas_id) REFERENCES estadisticas_generales(estadisticas_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (grupo_id) REFERENCES grupos(grupo_id),
    FOREIGN KEY (clase_id) REFERENCES clase_personaje(clase_id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    INDEX idx_usuario (usuario_id),
    INDEX idx_nombre (nombre)
);

-- Tabla: lidergrupo (Corregido)
CREATE TABLE IF NOT EXISTS lidergrupo (
    lider_grupo_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    grupo_id BIGINT UNIQUE NOT NULL,
    personaje_id BIGINT UNIQUE NOT NULL,
    fecha_nombramiento DATETIME NOT NULL,
    FOREIGN KEY (grupo_id) REFERENCES grupos(grupo_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- Tabla: logros_personaje (Corregido)
CREATE TABLE IF NOT EXISTS logros_personaje (
    personaje_id BIGINT NOT NULL,
    normal INT DEFAULT 0,
    miniboss INT DEFAULT 0,
    boss INT DEFAULT 0,
    muertes_totales INT DEFAULT 0,
    total_daño_inflijido INT DEFAULT 0,
    total_daño_recibido INT DEFAULT 0,
    tiempo_total_jugado INT DEFAULT 0,
    mazmorras_totales_superadas INT DEFAULT 0,
    PRIMARY KEY (personaje_id),
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- Tabla: tipo_monstruo (Corregido)
CREATE TABLE IF NOT EXISTS tipo_monstruo (
    tipo_monstruo_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) unique NOT NULL,
    descripcion TEXT,
    INDEX idx_nombre (nombre)
);

-- Tabla: monstruos (Corregido)
CREATE TABLE IF NOT EXISTS monstruos (
    monstruo_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    tipo_monstruo_id BIGINT NOT NULL,
    nivel INT DEFAULT 1,
    descripcion TEXT NOT NULL,
    imagen VARCHAR(255) NOT NULL,
    almas_otorgadas INT NOT NULL,
    experiencia_otorgada INT NOT NULL DEFAULT 0,
    estadisticas_id BIGINT NOT NULL,
    FOREIGN KEY (estadisticas_id) REFERENCES estadisticas_generales(estadisticas_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (tipo_monstruo_id) REFERENCES tipo_monstruo(tipo_monstruo_id),
    INDEX idx_nombre (nombre),
    INDEX idx_tipo_monstruo (tipo_monstruo_id)
);

-- Tabla: efectos_estados (Corregido)
CREATE TABLE IF NOT EXISTS efectos_estados (
    efecto_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    imagen_icono VARCHAR(255),
    nombre VARCHAR(100) NOT NULL,
    tipo ENUM('BUFF', 'DEBUFF') NOT NULL,
    tipo_afectado ENUM('PERSONAJE', 'MONSTRUO', 'TODO') DEFAULT 'PERSONAJE',
    duracion_efecto DOUBLE NOT NULL DEFAULT 0,
    intervalos_efecto DOUBLE NOT NULL DEFAULT 0,
    acumulaciones INT NOT NULL DEFAULT 0,
    descripcion TEXT NOT NULL,
    estadisticas_id BIGINT NOT NULL,
    FOREIGN KEY (estadisticas_id) REFERENCES estadisticas_generales(estadisticas_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    INDEX idx_nombre (nombre)
);

-- Tabla: Tipo_mapas (Corregido)
CREATE TABLE IF NOT EXISTS tipo_mapa (
    tipo_mapa_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) unique NOT NULL,
    descripcion TEXT NOT NULL,
    INDEX idx_nombre (nombre)
);

-- Tabla: mapas (Corregido)
CREATE TABLE IF NOT EXISTS mapas (
    mapa_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    imagen VARCHAR(255),
    tipo_mapa_id BIGINT NOT NULL,
    nivel_recomendado INT DEFAULT 1,
    FOREIGN KEY (tipo_mapa_id) REFERENCES tipo_mapa(tipo_mapa_id),
    INDEX idx_nombre (nombre),
    INDEX idx_tipoMapaId (tipo_mapa_id)
);

-- Tabla: mapa_efecto (Corregido)
CREATE TABLE IF NOT EXISTS mapa_efecto (
    mapa_id BIGINT NOT NULL,
    efecto_id BIGINT NOT NULL,
    PRIMARY KEY (mapa_id, efecto_id),
    FOREIGN KEY (efecto_id) REFERENCES efectos_estados(efecto_id),
    FOREIGN KEY (mapa_id) REFERENCES mapas(mapa_id)
);

-- Tabla: tipo_item (Corregido)
CREATE TABLE IF NOT EXISTS tipo_item (
    tipo_item_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    imagen VARCHAR(255) NOT NULL,
    nombre VARCHAR(100) unique NOT NULL,
    descripcion TEXT,
    INDEX idx_nombre (nombre)
);

-- Tabla: items (Corregido)
CREATE TABLE IF NOT EXISTS items (
    item_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    imagen VARCHAR(255) NOT NULL,
    tipo_item_id BIGINT NOT NULL,
    descripcion TEXT NOT NULL,
    acumulaciones_max INT NOT NULL DEFAULT 99,
    estadisticas_id BIGINT NULL,
    equipable BOOLEAN NOT NULL,
    FOREIGN KEY (estadisticas_id) REFERENCES estadisticas_generales(estadisticas_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (tipo_item_id) REFERENCES tipo_item(tipo_item_id),
    INDEX idx_nombre (nombre),
    INDEX idx_tipoItem (tipo_item_id)
);

-- Tabla: item_efecto (Corregido)
CREATE TABLE IF NOT EXISTS item_efecto (
    item_id BIGINT NOT NULL,
    efecto_id BIGINT NOT NULL,
    PRIMARY KEY (item_id, efecto_id),
    FOREIGN KEY (efecto_id) REFERENCES efectos_estados(efecto_id),
    FOREIGN KEY (item_id) REFERENCES items(item_id)
);

-- Tabla: drops_objetos (Corregido)
CREATE TABLE IF NOT EXISTS drops_objetos (
    monstruo_id BIGINT NOT NULL,
    item_id BIGINT NOT NULL,
    probabilidad INT NOT NULL DEFAULT 0,
    PRIMARY KEY (monstruo_id, item_id),
    FOREIGN KEY (monstruo_id) REFERENCES monstruos(monstruo_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (item_id) REFERENCES items(item_id),
    INDEX idx_monstruoId (monstruo_id),
    INDEX idx_itemId (item_id)
);

-- Tabla: inventario de personajes (Corregido)
CREATE TABLE IF NOT EXISTS inventario_personaje (
    personaje_id BIGINT NOT NULL,
    item_id BIGINT NOT NULL,
    cantidad INT NOT NULL DEFAULT 1,
    equipado BOOLEAN NOT NULL DEFAULT FALSE,
    fecha_obtencion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (personaje_id, item_id),
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id)
    ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES items(item_id)
    ON DELETE CASCADE,
    INDEX idx_personaje_id (personaje_id),
    INDEX idx_item_id (item_id)
);

-- Tabla: habilidades (Corregido)
CREATE TABLE IF NOT EXISTS habilidades (
    habilidad_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    imagen VARCHAR(255) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    nivel_maximo INT NOT NULL DEFAULT 1,
    requisito_nivel INT NOT NULL DEFAULT 1,
    tipo_habilidad ENUM('OFENSIVA', 'DEFENSIVA', 'APOYO') DEFAULT 'OFENSIVA',
    objetivo_habilidad ENUM('JUGADOR', 'ALIADO', 'ENEMIGO', 'TODO') DEFAULT 'TODO',
    area_efecto DOUBLE NOT NULL DEFAULT 1,
    unidades_afectadas INT NOT NULL DEFAULT 1,
    enfriamiento INT NOT NULL DEFAULT 0,
    estadisticas_id BIGINT NOT NULL,
    FOREIGN KEY (estadisticas_id) REFERENCES estadisticas_generales(estadisticas_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    INDEX idx_nombre (nombre)
);

-- Tabla: habilidad_efecto (Corregido)
CREATE TABLE IF NOT EXISTS habilidad_efecto (
    habilidad_id BIGINT NOT NULL,
    efecto_id BIGINT NOT NULL,
    PRIMARY KEY (efecto_id, habilidad_id),
    FOREIGN KEY (efecto_id) REFERENCES efectos_estados(efecto_id),
    FOREIGN KEY (habilidad_id) REFERENCES habilidades(habilidad_id)
);

-- Tabla: personaje_habilidad (Corregido)
CREATE TABLE IF NOT EXISTS personaje_habilidad (
    personaje_id BIGINT NOT NULL,
    habilidad_id BIGINT NOT NULL,
    nivel_habilidad INT NOT NULL DEFAULT 1,
    probabilidad_fallo DOUBLE NOT NULL DEFAULT 0,
    ultimo_uso DATETIME,
    PRIMARY KEY (personaje_id, habilidad_id),
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id),
    FOREIGN KEY (habilidad_id) REFERENCES habilidades(habilidad_id),
    INDEX idx_personaje_id (personaje_id, habilidad_id)
);

-- Tabla: monstruo_habilidad (Corregido)
CREATE TABLE IF NOT EXISTS monstruo_habilidad (
    monstruo_id BIGINT NOT NULL,
    habilidad_id BIGINT NOT NULL,
    nivel_habilidad INT NOT NULL DEFAULT 1,
    probabilidad_uso DOUBLE DEFAULT 100,
    probabilidad_fallo DOUBLE NOT NULL DEFAULT 0,
    PRIMARY KEY (monstruo_id, habilidad_id),
    FOREIGN KEY (monstruo_id) REFERENCES monstruos(monstruo_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (habilidad_id) REFERENCES habilidades(habilidad_id),
    INDEX idx_monstruo_id (monstruo_id),
    INDEX idx_habilidad_id (habilidad_id)
);

-- Tabla: tipo_npc (Corregido)
CREATE TABLE IF NOT EXISTS tipo_npc (
    tipo_npc_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) unique NOT NULL,
    descripcion TEXT NOT NULL,
    INDEX idx_nombre (nombre)
);

-- Tabla: npc (Corregido)
CREATE TABLE IF NOT EXISTS npc (
    npc_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    imagen VARCHAR(255) NOT NULL,
    tipo_npc_id BIGINT NOT NULL,
    FOREIGN KEY (tipo_npc_id) REFERENCES tipo_npc(tipo_npc_id),
    INDEX idx_nombre (nombre)
);

-- Tabla: misiones (Corregido)
CREATE TABLE IF NOT EXISTS misiones (
    mision_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    nivel_minimo INT NOT NULL,
    recompensa_almas INT NOT NULL DEFAULT 0,
    recompensa_experiencia INT NOT NULL DEFAULT 0,
    tiempo_limite INT DEFAULT 30,
    INDEX idx_nombre (nombre)
);

-- Tabla: recompensa_objetos (Corregido)
CREATE TABLE IF NOT EXISTS mision_objetos (
    mision_id BIGINT NOT NULL,
    item_id BIGINT NOT NULL,
    cantidad INT NOT NULL DEFAULT 1,
    PRIMARY KEY (mision_id, item_id),
    FOREIGN KEY (mision_id) REFERENCES misiones(mision_id),
    FOREIGN KEY (item_id) REFERENCES items(item_id),
    INDEX idx_mision_id (mision_id),
    INDEX idx_item_id (item_id)
);

-- Tabla: personaje_mision (Corregido)
CREATE TABLE IF NOT EXISTS personaje_mision (
    personaje_id BIGINT NOT NULL,
    mision_id BIGINT NOT NULL,
    fecha_inicio DATETIME NOT NULL,
    fecha_fin DATETIME NULL,
    estado ENUM('EN_PROGRESO', 'COMPLETADA', 'FALLIDA') DEFAULT 'EN_PROGRESO',
    PRIMARY KEY (personaje_id, mision_id),
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id)
    ON DELETE CASCADE,
    FOREIGN KEY (mision_id) REFERENCES misiones(mision_id),
    INDEX idx_personaje_id (personaje_id),
    INDEX idx_mision_id (mision_id)
);

-- Tabla: npc_mision (Corregido)
CREATE TABLE IF NOT EXISTS npc_mision (
    npc_id BIGINT NOT NULL,
    mision_id BIGINT NOT NULL,
    PRIMARY KEY (npc_id, mision_id),
    FOREIGN KEY (npc_id) REFERENCES npc(npc_id),
    FOREIGN KEY (mision_id) REFERENCES misiones(mision_id),
    INDEX idx_npcId (npc_id),
    INDEX idx_misionId (mision_id)
);

-- Tabla: mapa_monstruos (Corregido)
CREATE TABLE IF NOT EXISTS mapa_monstruos (
    mapa_id BIGINT NOT NULL,
    monstruo_id BIGINT NOT NULL,
    probabilidad_aparicion INT DEFAULT 100,
    PRIMARY KEY (mapa_id, monstruo_id),
    FOREIGN KEY (mapa_id) REFERENCES mapas(mapa_id),
    FOREIGN KEY (monstruo_id) REFERENCES monstruos(monstruo_id),
    INDEX idx_mapaId (mapa_id),
    INDEX idx_monstruoId (monstruo_id)
);

-- Tabla: tienda_producto (Corregido)
CREATE TABLE IF NOT EXISTS npc_producto (
    npc_id BIGINT NOT NULL,
    item_id BIGINT NOT NULL,
    precio_compra INT NOT NULL,
    precio_venta INT NOT NULL,
    cantidad_venta INT NOT NULL,
    PRIMARY KEY (npc_id, item_id),
    FOREIGN KEY (npc_id) REFERENCES npc(npc_id),
    FOREIGN KEY (item_id) REFERENCES items(item_id),
    INDEX idx_npcId (npc_id),
    INDEX idx_itemId (item_id)
);

-- Tabla: transacciones_npc_personaje (Corregido)
CREATE TABLE IF NOT EXISTS transacciones_npc_personaje (
    transaccion_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    personaje_id BIGINT NOT NULL,
    npc_id BIGINT NOT NULL,
    item_id BIGINT NOT NULL,
    tipo_transaccion ENUM('COMPRA', 'VENTA') NOT NULL,
    cantidad INT NOT NULL,
    precio_almas INT NOT NULL,
    fecha_transaccion DATETIME NOT NULL,
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id),
    FOREIGN KEY (npc_id) REFERENCES npc(npc_id),
    FOREIGN KEY (item_id) REFERENCES items(item_id)
);

-- Tabla: registro_jugador_monstruo (Corregido)
CREATE TABLE IF NOT EXISTS registro_jugador_monstruo (
    registro_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    personaje_id BIGINT NOT NULL,
    monstruo_id BIGINT NOT NULL,
    fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    almas_obtenidas INT NOT NULL,
    dano_realizado INT NOT NULL,
    dano_recibido INT NOT NULL,
    experiencia_obtenida INT NOT NULL,
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (monstruo_id) REFERENCES monstruos(monstruo_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);