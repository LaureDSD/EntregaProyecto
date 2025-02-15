
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

