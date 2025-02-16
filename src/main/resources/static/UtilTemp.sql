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
    
    INSERT INTO estadisticas_generales (vida_base, regeneracion_vida_base, escudo_base, energia_base, regeneracion_energia_base, mana_base, regeneracion_mana_base, ataque_fisico_base, ataque_magico_base, defensa_fisica, defensa_magica)
VALUES
    (150, 5, 20, 60, 2, 20, 1, 20, 5, 15, 5),  -- Estadísticas para Guerrero
    (80, 3, 5, 30, 1, 100, 5, 5, 25, 5, 20),   -- Estadísticas para Mago
    (100, 4, 10, 70, 3, 30, 2, 15, 10, 10, 10), -- Estadísticas para Arquero
    (90, 2, 15, 40, 1, 80, 3, 8, 15, 8, 15),   -- Estadísticas para Sacerdote
    (110, 3, 5, 80, 2, 20, 1, 25, 5, 5, 5),    -- Estadísticas para Asesino
    (140, 4, 30, 50, 2, 30, 1, 18, 8, 20, 10), -- Estadísticas para Caballero
    (160, 5, 10, 90, 3, 10, 1, 22, 3, 12, 3),  -- Estadísticas para Bárbaro
    (120, 3, 15, 60, 2, 70, 4, 10, 18, 10, 15),-- Estadísticas para Druida
    (85, 2, 5, 35, 1, 90, 5, 6, 22, 6, 18),    -- Estadísticas para Nigromante
    (95, 2, 10, 50, 1, 60, 3, 10, 15, 8, 12);  -- Estadísticas para Bardo
    
    INSERT INTO clase_personaje (nombre, descripcion, estadisticas_id)
VALUES
    ('Guerrero', 'Un luchador fuerte y resistente, especializado en combate cuerpo a cuerpo.', 1),
    ('Mago', 'Un maestro de las artes arcanas, capaz de lanzar hechizos devastadores.', 2),
    ('Arquero', 'Un tirador experto que ataca desde la distancia con precisión letal.', 3),
    ('Sacerdote', 'Un sanador divino que protege y cura a sus aliados.', 4),
    ('Asesino', 'Un combatiente sigiloso que ataca por sorpresa con golpes críticos.', 5),
    ('Caballero', 'Un defensor acorazado que protege a sus aliados en el frente de batalla.', 6),
    ('Bárbaro', 'Un guerrero salvaje que se enfurece en combate, aumentando su fuerza y resistencia.', 7),
    ('Druida', 'Un guardián de la naturaleza que combina magia y habilidades de transformación.', 8),
    ('Nigromante', 'Un hechicero oscuro que invoca y controla a los muertos.', 9),
    ('Bardo', 'Un artista versátil que usa música y magia para apoyar a sus aliados.', 10);
    

    
    INSERT INTO personajes (usuario_id, imagen_modelo, nombre, fecha_creacion, clase_id, grupo_id, nivel, xp_acumulada, almas, capacidad_inventario, estadisticas_id)
VALUES
    (1, 'imagen1.jpg', 'Aragorn', '2023-10-01 12:00:00', 1, 1, 5, 1200, 50, 15, 1),
    (2, 'imagen2.jpg', 'Gandalf', '2023-10-02 13:00:00', 2, 1, 10, 5000, 100, 10, 2),
    (3, 'imagen3.jpg', 'Legolas', '2023-10-03 14:00:00', 3, 1, 8, 3000, 75, 12, 3),
    (4, 'imagen4.jpg', 'Frodo', '2023-10-04 15:00:00', 4, 2, 3, 800, 30, 10, 4),
    (5, 'imagen5.jpg', 'Gimli', '2023-10-05 16:00:00', 1, 2, 7, 2500, 60, 14, 5),
    (6, 'imagen6.jpg', 'Boromir', '2023-10-06 17:00:00', 5, 3, 6, 2000, 40, 12, 6),
    (7, 'imagen7.jpg', 'Galadriel', '2023-10-07 18:00:00', 2, 4, 12, 8000, 150, 16, 7),
    (8, 'imagen8.jpg', 'Saruman', '2023-10-08 19:00:00', 9, 5, 15, 12000, 200, 10, 8),
    (9, 'imagen9.jpg', 'Arwen', '2023-10-09 20:00:00', 10, 6, 9, 4000, 80, 12, 9),
    (10, 'imagen10.jpg', 'Sauron', '2023-10-10 21:00:00', 9, 7, 20, 20000, 300, 18, 10);
    
        INSERT INTO grupos (nombre, descripcion, lider_grupo_id, tipo_grupo_id)
VALUES
    ('Los Cuatro Elementos', 'Un grupo de aventureros que dominan los cuatro elementos: fuego, agua, tierra y aire.', 1, 1),
    ('Los Guardianes del Amanecer', 'Un equipo de héroes que protegen el mundo de las amenazas que surgen con la luz del amanecer.', 2, 1),
    ('Las Sombras del Destino', 'Un grupo sigiloso que opera en las sombras para cumplir misiones peligrosas.', 2, 2),
    ('Los Hijos del Trueno', 'Un equipo de guerreros que luchan con la fuerza y el poder del trueno.', 3, 1),
    ('Los Exploradores Perdidos', 'Un grupo de aventureros que buscan tesoros y secretos en lugares olvidados.', 4, 2),
    ('Los Defensores de la Luz', 'Un equipo de paladines y clérigos que luchan contra las fuerzas de la oscuridad.', 5, 1),
    ('Los Cazadores de Bestias', 'Un grupo especializado en la caza de criaturas peligrosas y monstruos.', 6, 2),
    ('Los Maestros del Caos', 'Un equipo de magos y hechiceros que manipulan el caos para sus propios fines.', 3, 1),
    ('Los Guardianes del Bosque', 'Un grupo de druidas y rangers que protegen la naturaleza y sus secretos.', 2, 2),
    ('Los Mercenarios del Hierro', 'Un equipo de mercenarios que aceptan cualquier trabajo a cambio de oro.', 2, 1);
    
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
    
   INSERT INTO monstruos (nombre, tipo_monstruo_id, nivel, descripcion, imagen, almas_otorgadas, experiencia_otorgada, estadisticas_id)
VALUES
    ('Goblin', 1, 1, 'Un pequeño monstruo verde', 'goblin.jpg', 50, 20, 1),
    ('Ogro', 2, 5, 'Un monstruo grande y fuerte', 'ogro.jpg', 200, 50, 2),
    ('Dragón', 3, 10, 'Un poderoso dragón', 'dragon.jpg', 1000, 200, 3),
    ('Bandido', 1, 3, 'Un bandido común que ataca a los viajeros', 'bandido.jpg', 80, 30, 4),
    ('Lobo Salvaje', 1, 2, 'Un lobo feroz que habita en los bosques', 'lobo.jpg', 60, 20, 5),
    ('Esqueleto Guerrero', 2, 5, 'Un esqueleto revivido con habilidades de combate', 'esqueleto.jpg', 120, 40, 6),
    ('Araña Gigante', 2, 4, 'Una araña gigante que teje telarañas venenosas', 'araña.jpg', 100, 35, 7),
    ('Bandido Líder', 3, 7, 'El líder de una banda de bandidos', 'bandido_lider.jpg', 200, 60, 8),
    ('Nigromante', 3, 7, 'El líder de esqueletos', 'nigromante.jpg', 200, 60, 9),
    ('Araña', 1, 7, 'Araña pequeña que ataca en grupo', 'araña.jpg', 50, 10, 10);
    
  INSERT INTO registro_jugador_monstruo (personaje_id, monstruo_id, dano_realizado, dano_recivido, fecha, almas_obtenidas, experiencia_obtenida)
VALUES
    (1, 1, 100, 20, '2023-10-01 12:00:00', 50, 20),   -- Aragorn cazó un Goblin
    (2, 3, 500, 100, '2023-10-02 13:00:00', 1000, 200), -- Gandalf cazó un Dragón
    (3, 2, 200, 50, '2023-10-03 14:00:00', 200, 50),  -- Legolas cazó un Ogro
    (4, 5, 80, 30, '2023-10-04 15:00:00', 60, 20),    -- Frodo cazó un Lobo Salvaje
    (5, 4, 120, 40, '2023-10-05 16:00:00', 80, 30);   -- Gimli cazó un Bandido  
    
    INSERT INTO efectos_estados (imagen_icono, nombre, tipo, tipo_afectado, duracion_efecto, intervalos_efecto, acumulaciones, descripcion, estadisticas_id)
VALUES
    ('fuerza_icono.jpg', 'Fuerza Mejorada', 'BUFF', 'PERSONAJE', 60, 10, 1, 'Aumenta el ataque físico en 20 puntos durante 1 minuto.', 1),
    ('veneno_icono.jpg', 'Veneno', 'DEBUFF', 'MONSTRUO', 30, 5, 3, 'Reduce la vida en 10 puntos cada 5 segundos durante 30 segundos.', 2),
    ('proteccion_icono.jpg', 'Escudo de Protección', 'BUFF', 'PERSONAJE', 120, 0, 1, 'Aumenta el escudo en 50 puntos durante 2 minutos.', 3);
    
    INSERT INTO tipo_mapa (nombre, descripcion)
VALUES
    ('Bosque', 'Un área densamente poblada de árboles y vegetación, hogar de criaturas salvajes y secretos ocultos.'),
    ('Montaña', 'Una región escarpada y rocosa, con altos picos y peligrosas criaturas que habitan en las alturas.'),
    ('Mazmorra', 'Un laberinto subterráneo lleno de trampas, monstruos y tesoros ocultos.');
    
    INSERT INTO mapas (nombre, descripcion, imagen, tipo_mapa_id, nivel_recomendado)
VALUES
    ('Bosque Oscuro', 'Un bosque denso y misterioso lleno de criaturas peligrosas.', 'bosque_oscuro.jpg', 1, 5),
    ('Montañas del Dragón', 'Una cadena montañosa donde los dragones hacen sus nidos.', 'montañas_dragon.jpg', 2, 10),
    ('Mazmorra de las Sombras', 'Una mazmorra oscura y llena de trampas mortales.', 'mazmorra_sombras.jpg', 3, 15);
    
    INSERT INTO mapa_efecto (mapa_id, efecto_id)
VALUES
    (1, 1),  -- Bosque Oscuro: Fuerza Mejorada
    (2, 2),  -- Montañas del Dragón: Veneno
    (3, 3);  -- Mazmorra de las Sombras: Escudo de Protección
    
    INSERT INTO items (nombre, tipo_item, descripcion, acumulaciones_max, equipable, estadisticas_id)
VALUES
    ('Poción de Vida', 1, 'Restaura 50 puntos de vida.', 99, 0, NULL),
    ('Espada de Acero', 2, 'Una espada resistente hecha de acero.', 1, 1, 1),
    ('Hierro', 3, 'Material de crafteo común.', 99, 0, NULL);
    
    INSERT INTO item_efecto (item_id, efecto_id)
VALUES
    (1, 1),  -- Poción de Vida: Fuerza Mejorada
    (2, 2);  -- Espada de Acero: Veneno
    
    INSERT INTO drops_objetos (monstruo_id, item_id, probabilidad)
VALUES
    (1, 1, 50),  -- Goblin puede soltar Poción de Vida con 50% de probabilidad
    (2, 2, 30);  -- Ogro puede soltar Espada de Acero con 30% de probabilidad
    
    INSERT INTO inventario_personaje (personaje_id, item_id, cantidad, equipado, fecha_obtencion)
VALUES
    (1, 1, 5, 0, '2023-10-01 12:00:00'),  -- Aragorn tiene 5 Pociones de Vida
    (2, 2, 1, 1, '2023-10-02 13:00:00');  -- Gandalf tiene una Espada de Acero equipada
    
  INSERT INTO habilidades (imagen, nombre, descripcion, nivel_maximo, requisito_nivel, tipo_habilidad, objetivo_habilidad, area_efecto, unidades_afectadas, enfriamiento, estadisticas_id)
VALUES
    ('golpe_critico.jpg', 'Golpe Crítico', 'Un ataque poderoso que inflige daño crítico.', 5, 1, 'OFENSIVA', 'ENEMIGO', 1, 1, 10, 1),
    ('bola_fuego.jpg', 'Bola de Fuego', 'Lanza una bola de fuego que quema a los enemigos.', 3, 3, 'OFENSIVA', 'ENEMIGO', 3, 3, 15, 2);  
    
    INSERT INTO habilidad_efecto (habilidad_id, efecto_id)
VALUES
    (1, 1),  -- Golpe Crítico: Fuerza Mejorada
    (2, 2);  -- Bola de Fuego: Veneno
    
 INSERT INTO personaje_habilidad (personaje_id, habilidad_id, nivel_habilidad, probabilidad_fallo, ultimo_uso)
VALUES
    (1, 1, 3, 0.1, '2023-10-01 12:00:00'),  -- Aragorn tiene Golpe Crítico nivel 3
    (2, 2, 1, 0.2, '2023-10-02 13:00:00');  -- Gandalf tiene Bola de Fuego nivel 1   
    
   INSERT INTO monstruo_habilidad (monstruo_id, habilidad_id, nivel_habilidad, probabilidad_uso, probabilidad_fallo)
VALUES
    (1, 1, 2, 50, 10),  -- Goblin usa Golpe Crítico nivel 2 con 50% de probabilidad
    (2, 2, 1, 30, 20);  -- Ogro usa Bola de Fuego nivel 1 con 30% de probabilidad 
    
    INSERT INTO tipo_npc (nombre, descripcion)
VALUES
    ('Aldeano', 'Un aldeano común que ofrece misiones simples.'),
    ('Mercader', 'Un mercader que vende objetos útiles.'),
    ('Guardia', 'Un guardia que protege la ciudad.');
    
  INSERT INTO npc (nombre, descripcion, imagen, tipo_npc)
VALUES
    ('Juan el Granjero', 'Un granjero amable que necesita ayuda con sus cultivos.', 'juan_granjero.jpg', 1),
    ('Luis el Mercader', 'Un mercader que vende objetos útiles para aventureros.', 'luis_mercader.jpg', 2),
    ('Carlos el Guardia', 'Un guardia que protege la entrada de la ciudad.', 'carlos_guardia.jpg', 3);  
    
    INSERT INTO misiones (nombre, descripcion, nivel_minimo, recompensa_almas, recompensa_experiencia, tiempo_limite)
VALUES
    ('Cosecha en peligro', 'Ayuda al granjero Juan a proteger sus cultivos de las plagas.', 1, 50, 100, 60),
    ('El mercader desaparecido', 'Encuentra al mercader Luis, quien ha desaparecido en el bosque.', 3, 100, 200, 120);
    
  INSERT INTO mision_objetos (mision_id, item_id, cantidad)
VALUES
    (1, 1, 5),  -- Cosecha en peligro: Recompensa 5 Pociones de Vida
    (2, 2, 1);  -- El mercader desaparecido: Recompensa 1 Espada de Acero  
    
    INSERT INTO personaje_mision (personaje_id, mision_id, fecha_inicio, fecha_fin, estado)
VALUES
    (1, 1, '2023-10-01 12:00:00', '2023-10-01 13:00:00', 'COMPLETADA'),  -- Aragorn completó Cosecha en peligro
    (2, 2, '2023-10-02 13:00:00', NULL, 'EN_PROGRESO');                 -- Gandalf está en El mercader desaparecido
    
    INSERT INTO npc_mision (npc_id, mision_id)
VALUES
    (1, 1),  -- Juan el Granjero ofrece Cosecha en peligro
    (2, 2);  -- Luis el Mercader ofrece El mercader desaparecido
    

    INSERT INTO mapa_monstruos (mapa_id, monstruo_id, probabilidad_aparicion)
VALUES
    (1, 1, 70),  -- Goblin aparece en Bosque Oscuro con 70% de probabilidad
    (2, 2, 50);  -- Ogro aparece en Montañas del Dragón con 50% de probabilidad
    
    INSERT INTO npc_producto (npc_id, item_id, precio_compra, precio_venta, cantidad_venta)
VALUES
    (2, 1, 10, 20, 5),  -- Luis el Mercader vende Poción de Vida
    (2, 2, 100, 200, 1); -- Luis el Mercader vende Espada de Acero
    
    INSERT INTO transacciones_npc_personaje (personaje_id, tipo_transaccion, npc_id, item_id, cantidad, precio_almas, fecha_transaccion)
VALUES
    (1, 'COMPRA', 2, 1, 2, 40, '2023-10-01 12:00:00'),  -- Aragorn compró 2 Pociones de Vida
    (2, 'COMPRA', 2, 2, 1, 200, '2023-10-02 13:00:00'); -- Gandalf compró 1 Espada de Acero
    
    
    
    
    
    
    
    
    
    
    