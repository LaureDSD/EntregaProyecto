DROP DATABASE IF EXISTS api_rpg_bd;
CREATE DATABASE IF NOT EXISTS api_rpg_bd;
USE api_rpg_bd;

-- Tabla: tipo_musuario (Correcto)
CREATE TABLE IF NOT EXISTS tipo_usuario (
    tipo_usuario_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    INDEX idx_nombre (nombre)
);

-- Tabla: usuarios (Correcto)
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
    token_conexion VARCHAR(255) NULL,
    fecha_creacion DATETIME NOT NULL,
    estado_cuenta BOOLEAN NOT NULL DEFAULT 1,
    tipo_usuario bigint NOT NULL DEFAULT 1,
    FOREIGN KEY (tipo_usuario) REFERENCES tipo_usuario(tipo_usuario_id),
    INDEX idx_correo (correo),
    INDEX idx_nombre_priv (nombre_usuario_priv)
);

-- Tabla: logs de usuario (Correcto)
CREATE TABLE IF NOT EXISTS logs (
    log_id bigint PRIMARY KEY AUTO_INCREMENT,
    usuario_id bigint NULL,
    tipo_log ENUM('INFORMACION','FALLO', 'ADVERTENCIA','CREACION','ACTUALIZACION','BORRADO') DEFAULT 'INFORMACION',
    mensaje TEXT NOT NULL,
    fecha_log DATETIME NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id) 
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    INDEX idx_usuario_id (usuario_id)
);

-- Estadisticas egenrales (Correcto)
CREATE TABLE IF NOT EXISTS estadisticas_generales (
    estadisticas_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    vida_base INT NOT NULL DEFAULT 0,
    regeneracion_vida_base INT NOT NULL DEFAULT 0,
    escudo_base INT NOT NULL DEFAULT 0,
    energia_base INT NOT NULL DEFAULT 0,
    regeneracion_energia_base INT NOT NULL DEFAULT 0,
    mana_base INT NOT NULL DEFAULT 0,
    regeneracion_mana_base INT NOT NULL DEFAULT 0,
    ataque_fisico_base INT NOT NULL DEFAULT 0,
    ataque_magico_base INT NOT NULL DEFAULT 0,
    defensa_fisica INT DEFAULT 0,
    defensa_magica INT DEFAULT 0
);

-- Table de clases de persoanje (Corrrecto)
CREATE TABLE IF NOT EXISTS clase_personaje (
    clase_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
	estadisticas_id BIGINT,
    CONSTRAINT fk_clase_personaje_estadisticas
    FOREIGN KEY (estadisticas_id)
    REFERENCES estadisticas_generales(estadisticas_id)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
    INDEX idx_nombre (nombre)
);

-- Tabla de ipo de grupo (Correcto)
CREATE TABLE tipo_grupo (
    tipo_grupo_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    numero_integrantes_max INT NOT NULL DEFAULT 1,
    comparten_exp_drops boolean not null default false,
    descripcion TEXT
);

-- Tabla de grupos (Correcto)
CREATE TABLE grupos (
    grupo_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    imagen_logo VARCHAR(255),
    nombre VARCHAR(100) NOT NULL,
    lider_grupo_id bigint not null,
    descripcion TEXT,
    tipo_grupo_id BIGINT,
    FOREIGN KEY (tipo_grupo_id) REFERENCES tipo_grupo(tipo_grupo_id)
);

-- Tabla: personajes (Correcto)
CREATE TABLE IF NOT EXISTS personajes (
    personaje_id bigint PRIMARY KEY AUTO_INCREMENT,
    usuario_id bigint NOT NULL,
    imagen_modelo VARCHAR(255),
    nombre VARCHAR(100) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    clase_id bigint NULL,
    grupo_id bigint NULL,
	nivel INT NOT NULL DEFAULT 1,
    xp_acumulada INT NOT NULL DEFAULT 0,
    almas INT NOT NULL DEFAULT 0,
    capacidad_inventario INT NOT NULL DEFAULT 10,
    estadisticas_id BIGINT,
    FOREIGN KEY (estadisticas_id) REFERENCES estadisticas_generales(estadisticas_id)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
    FOREIGN KEY (grupo_id) REFERENCES grupos(grupo_id),
    FOREIGN KEY (clase_id) REFERENCES clase_personaje(clase_id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id) 
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    INDEX idx_usuario_id (usuario_id),
    INDEX idx_nombre (nombre)
);

-- Vincular tabla persoanjes y grupos (Correcto)
alter table grupos add foreign key (lider_grupo_id) references personajes (personaje_id);

-- Tabla: logros_persoanje (Correcto)
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

-- Tabla: tipo_monstruo (Correcto)
CREATE TABLE IF NOT EXISTS tipo_monstruo (
    tipo_monstruo_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    INDEX idx_nombre (nombre)
);
 
-- Tabla: monstruos (Correcto) 
CREATE TABLE IF NOT EXISTS monstruos (
    monstruo_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    tipo_monstruo_id bigint NOT NULL,
	nivel INT DEFAULT 1,
    descripcion TEXT,
    imagen VARCHAR(255),
    almas_otorgadas INT NOT NULL,
    experiencia_otorgada INT DEFAULT 0,
    estadisticas_id BIGINT,
    FOREIGN KEY (estadisticas_id) REFERENCES estadisticas_generales(estadisticas_id)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
    FOREIGN KEY (tipo_monstruo_id) REFERENCES tipo_monstruo(tipo_monstruo_id),
    INDEX idx_nombre (nombre),
    INDEX idx_tipo_monstruo (tipo_monstruo_id)
);
    
    -- Tabla: log_jugador_monstruo (Correcto)
CREATE TABLE registro_jugador_monstruo (
    registro_id BIGINT AUTO_INCREMENT PRIMARY KEY, 
    personaje_id BIGINT NOT NULL,
    dano_realizado INT NOT NULL DEFAULT 0,
    dano_recivido INT NOT NULL DEFAULT 0,
    monstruo_id BIGINT NOT NULL,
    fecha DATETIME NOT NULL,                       
    almas_obtenidas INT NOT NULL,                     
    experiencia_obtenida INT NOT NULL,                  
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id),
    FOREIGN KEY (monstruo_id) REFERENCES monstruos(monstruo_id)      
);

-- Tabla: efectos_estados (Correcto)
CREATE TABLE IF NOT EXISTS efectos_estados (
    efecto_id bigint PRIMARY KEY AUTO_INCREMENT,
    imagen_icono VARCHAR(255),
    nombre VARCHAR(100) NOT NULL,
    tipo ENUM('BUFF', 'DEBUFF') NOT NULL,
    tipo_afectado ENUM('PERSONAJE', 'MONSTRUO', 'TODO') DEFAULT 'personaje',
    duracion_efecto double NOT NULL DEFAULT 0,
    intervalos_efecto double NOT NULL DEFAULT 0,
    acumulaciones INT NOT NULL DEFAULT 0,
    descripcion TEXT,
    estadisticas_id BIGINT,
    FOREIGN KEY (estadisticas_id) REFERENCES estadisticas_generales(estadisticas_id)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
    INDEX idx_nombre (nombre)
);

-- Tabla: Tipo_mapas (Correcto)
CREATE TABLE IF NOT EXISTS tipo_mapa (
    tipo_mapa_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    INDEX idx_nombre (nombre)
);

-- Tabla: mapas (Correcto)
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

-- Tabla: mapa_efecto (Correcto)
CREATE TABLE IF NOT EXISTS mapa_efecto (
    mapa_id bigint NOT NULL,
    efecto_id bigint NOT NULL,
    PRIMARY KEY (mapa_id, efecto_id),
    FOREIGN KEY (efecto_id) REFERENCES efectos_estados(efecto_id),
    FOREIGN KEY (mapa_id) REFERENCES mapas(mapa_id)
);

-- Tabla: tipo_item (Correcto)
-- Tipo del item (Material,Consumible,TipoEquipamiento(Pechera,Casco,Botas,Guantes,Pantalones,Zapatos,Accesorio1,Accesorio2))
CREATE TABLE IF NOT EXISTS tipo_item (
    tipo_item_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    INDEX idx_nombre (nombre)
);

-- Tabla: items
CREATE TABLE IF NOT EXISTS items (
    item_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    tipo_item bigint NOT NULL,
    descripcion TEXT,
    acumulaciones_max INT NOT NULL DEFAULT 99,
    estadisticas_id BIGINT,
    equipable boolean null ,
    FOREIGN KEY (estadisticas_id) REFERENCES estadisticas_generales(estadisticas_id)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
    foreign key (tipo_item) REFERENCES tipo_item(tipo_item_id),
    INDEX idx_nombre (nombre),
    INDEX idx_tipo_item (tipo_item)
);

-- Tabla: item_efecto (Corecto)
CREATE TABLE IF NOT EXISTS item_efecto (
    item_id bigint NOT NULL,
    efecto_id bigint NOT NULL,
    PRIMARY KEY (item_id, efecto_id),
    FOREIGN KEY (efecto_id) REFERENCES efectos_estados(efecto_id),
    FOREIGN KEY (item_id) REFERENCES items(item_id)
);

-- Tabla: drops_objetos (Correcto)
CREATE TABLE IF NOT EXISTS drops_objetos (
    monstruo_id bigint NOT NULL,
    item_id bigint NOT NULL,
    probabilidad INT NOT NULL DEFAULT 0,  -- Probabilidad de que el objeto sea soltado
	primary key(monstruo_id,item_id),
    FOREIGN KEY (monstruo_id) REFERENCES monstruos(monstruo_id) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE,
    FOREIGN KEY (item_id) REFERENCES items(item_id),
    INDEX idx_monstruo_id (monstruo_id),
    INDEX idx_item_id (item_id)
);



-- Tabla: inventario de personajes (Correcto)
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

-- Tabla: habilidades (Correcto) 
CREATE TABLE IF NOT EXISTS habilidades (
    habilidad_id bigint PRIMARY KEY AUTO_INCREMENT,
    imagen VARCHAR(255),
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    nivel_maximo INT NOT NULL DEFAULT 1,
    requisito_nivel INT NOT NULL DEFAULT 1,
    tipo_habilidad ENUM('OFENSIVA', 'DEFENSIVA','APOYO') DEFAULT 'ofensiva',
    objetivo_habilidad ENUM('JUGADOR','ALIADO','ENEMIGO','TODO') DEFAULT 'todo',
    area_efecto double NOT NULL DEFAULT 1,
    unidades_afectadas INT NOT NULL DEFAULT 1,
    enfriamiento INT NOT NULL DEFAULT 0,
    estadisticas_id BIGINT,
    FOREIGN KEY (estadisticas_id) REFERENCES estadisticas_generales(estadisticas_id)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
    INDEX idx_nombre (nombre)
);

-- Tabla: habilidad_efecto (Correcto)
CREATE TABLE IF NOT EXISTS habilidad_efecto (
    habilidad_id bigint NOT NULL,
    efecto_id bigint NOT NULL,
    PRIMARY KEY (efecto_id, habilidad_id),
    FOREIGN KEY (efecto_id) REFERENCES efectos_estados(efecto_id),
    FOREIGN KEY (habilidad_id) REFERENCES habilidades(habilidad_id)
);

-- Tabla: personaje_habilidad (Correcto)
CREATE TABLE IF NOT EXISTS personaje_habilidad (
    personaje_id bigint NOT NULL,
    habilidad_id bigint NOT NULL,
    nivel_habilidad int NOT NULL DEFAULT 1,
    probabilidad_fallo double NOT NULL DEFAULT 1,
    ultimo_uso DATETIME,
    PRIMARY KEY (personaje_id, habilidad_id),
    FOREIGN KEY (personaje_id) REFERENCES personajes(personaje_id),
    FOREIGN KEY (habilidad_id) REFERENCES habilidades(habilidad_id),
    INDEX idx_personaje_id (personaje_id,habilidad_id)
);

-- Tabla: monstruo_habilidad (Correcto)
CREATE TABLE IF NOT EXISTS monstruo_habilidad (
    monstruo_id bigint NOT NULL,
    habilidad_id bigint NOT NULL,
    nivel_habilidad INT NOT NULL DEFAULT 1,
    probabilidad_uso double DEFAULT 100,
    probabilidad_fallo double NOT NULL DEFAULT 1,
    PRIMARY KEY (monstruo_id, habilidad_id),
    FOREIGN KEY (monstruo_id) REFERENCES monstruos(monstruo_id) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE,
    FOREIGN KEY (habilidad_id) REFERENCES habilidades(habilidad_id),
    INDEX idx_monstruo_id (monstruo_id),
    INDEX idx_habilidad_id (habilidad_id)
);

-- Tabla: tipo_npc (Correcto)
CREATE TABLE IF NOT EXISTS tipo_npc (
    tipo_npc_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    INDEX idx_nombre (nombre)
);

-- Tabla: npc (Correcto)
CREATE TABLE IF NOT EXISTS npc (
    npc_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    imagen VARCHAR(255),
    tipo_npc bigint NOT NULL,
    FOREIGN KEY (tipo_npc) REFERENCES tipo_npc(tipo_npc_id),
    INDEX idx_nombre (nombre)
);

-- Tabla: misiones (Correcto)
CREATE TABLE IF NOT EXISTS misiones (
    mision_id bigint PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    nivel_minimo INT NOT NULL,
    recompensa_almas INT not null DEFAULT 0,
    recompensa_experiencia INT not null DEFAULT 0,
    tiempo_limite INT NULL DEFAULT 30,
    INDEX idx_nombre (nombre)
);

-- Tabla: recompensa_objetos (Correcto)
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

-- Tabla: personaje_mision (Correcto)
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

-- Tabla: npc_mision (Correcto) MUCHOS A MUCHOS CLASICO
CREATE TABLE IF NOT EXISTS npc_mision (
    npc_id bigint NOT NULL,
    mision_id bigint NOT NULL,
    PRIMARY KEY (npc_id, mision_id),
    FOREIGN KEY (npc_id) REFERENCES npc(npc_id),
    FOREIGN KEY (mision_id) REFERENCES misiones(mision_id),
    INDEX idx_npc_id (npc_id),
    INDEX idx_mision_id (mision_id)
);

-- Tabla: mapa_monstruos (Correcto) 
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

-- Tabla: tienda_producto (Corecto)
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

-- Tabla: transacciones_comercio (Correcto)
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