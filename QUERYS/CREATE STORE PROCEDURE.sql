CREATE OR REPLACE PROCEDURE prueba_tecnica.sp_insertar_producto_y_listar_del_dia(
    p_id IN PRODUCTOS.ID%TYPE,
    p_nombre IN PRODUCTOS.NOMBRE%TYPE,
    p_fec_registro IN PRODUCTOS.FEC_REGISTRO%TYPE,
    p_cursor OUT SYS_REFCURSOR,
    p_codigo OUT NUMBER,
    p_mensaje OUT VARCHAR2
) AS
BEGIN
    INSERT INTO prueba_tecnica.PRODUCTOS (ID, NOMBRE, FEC_REGISTRO)
    VALUES (p_id, p_nombre, p_fec_registro);
    
    IF SQL%ROWCOUNT > 0 THEN
        p_codigo := 1; -- Código de éxito
        p_mensaje := 'Producto insertado con éxito.';
        
        -- Devolver los productos registrados en el día
        OPEN p_cursor FOR
        SELECT ID, NOMBRE, FEC_REGISTRO FROM prueba_tecnica.PRODUCTOS
        WHERE TRUNC(FEC_REGISTRO) = TRUNC(SYSDATE);
    ELSE
        p_codigo := 0; -- Código de error
        p_mensaje := 'Error al insertar el producto.';
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        p_codigo := 0; -- Código de error
        p_mensaje := SQLERRM;
END sp_insertar_producto_y_listar_del_dia;
/
