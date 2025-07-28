# Documentación API de Factura


## Endpoints de Factura

### 1. Crear Factura
**POST** `/facturas`

Crea una nueva factura con todos sus detalles.

**Body:**
```json
{
  "rucEmpresa": "1234567890001",
  "numeroDocumento": "001-001-000000001",
  "establecimiento": "001",
  "puntoEmision": "001",
  "fechaEmision": "2024-01-15",
  "cliente": {
    "id": 1
  },
  "detalles": [
    {
      "cantidad": 2,
      "producto": {
        "id": 1
      }
    },
    {
      "cantidad": 1,
      "producto": {
        "id": 2
      }
    }
  ]
}
```

**Respuesta exitosa (201):**
```json
"Factura creada exitosamente"
```

### 2. Obtener Factura por ID
**GET** `/facturas/{id}`

Obtiene una factura específica por su ID.

**Respuesta exitosa (200):**
```json
{
  "id": 1,
  "rucEmpresa": "1234567890001",
  "numeroDocumento": "001-001-000000001",
  "establecimiento": "001",
  "puntoEmision": "001",
  "fechaEmision": "2024-01-15",
  "subtotal": 100.00,
  "totalImpuestos": 12.00,
  "total": 112.00,
  "cliente": {
    "id": 1,
    "cedula": "1234567890",
    "nombre": "Juan",
    "apellido": "Pérez",
    "razonSocial": "Juan Pérez",
    "direccion": "Av. Principal 123",
    "telefono": "0987654321",
    "correo": "juan@email.com"
  },
  "detalles": [
    {
      "id": 1,
      "cantidad": 2,
      "precio": 50.00,
      "subtotal": 100.00,
      "producto": {
        "id": 1,
        "codigoBarras": "123456789",
        "nombre": "Producto 1",
        "categoria": "PRODUCTO",
        "precio": 50.00,
        "stock": 10
      }
    }
  ]
}
```

### 3. Obtener Todas las Facturas
**GET** `/facturas`

Obtiene todas las facturas ordenadas por fecha de emisión descendente.

**Respuesta exitosa (200):**
```json
[
  {
    "id": 1,
    "rucEmpresa": "1234567890001",
    "numeroDocumento": "001-001-000000001",
    "establecimiento": "001",
    "puntoEmision": "001",
    "fechaEmision": "2024-01-15",
    "subtotal": 100.00,
    "totalImpuestos": 12.00,
    "total": 112.00,
    "cliente": {
      "id": 1,
      "cedula": "1234567890",
      "nombre": "Juan",
      "apellido": "Pérez"
    }
  }
]
```

### 4. Actualizar Factura
**PUT** `/facturas/{id}`

Actualiza una factura existente.

**Body:** (mismo formato que crear)

**Respuesta exitosa (200):**
```json
"Factura actualizada exitosamente"
```

### 5. Eliminar Factura
**DELETE** `/facturas/{id}`

Elimina una factura por su ID.

**Respuesta exitosa (200):**
```json
"Factura eliminada exitosamente"
```

### 6. Buscar Factura por Número de Documento
**GET** `/facturas/buscar?numeroDocumento={numeroDocumento}`

Busca una factura por su número de documento.

**Respuesta exitosa (200):**
```json
{
  "id": 1,
  "numeroDocumento": "001-001-000000001",
  "rucEmpresa": "1234567890001",
  "establecimiento": "001",
  "puntoEmision": "001",
  "fechaEmision": "2024-01-15",
  "subtotal": 100.00,
  "totalImpuestos": 12.00,
  "total": 112.00,
  "cliente": {
    "id": 1,
    "cedula": "1234567890",
    "nombre": "Juan",
    "apellido": "Pérez"
  }
}
```

## Endpoints de Cliente

### 1. Crear Cliente
**POST** `/clientes`

Crea un nuevo cliente.

**Body:**
```json
{
  "cedula": "1234567890",
  "nombre": "Juan",
  "apellido": "Pérez",
  "razonSocial": "Juan Pérez",
  "direccion": "Av. Principal 123",
  "telefono": "0987654321",
  "correo": "juan@email.com"
}
```

### 2. Obtener Cliente por ID
**GET** `/clientes/{id}`

Obtiene un cliente específico por su ID.

### 3. Obtener Todos los Clientes
**GET** `/clientes`

Obtiene todos los clientes ordenados por nombre.

### 4. Actualizar Cliente
**PUT** `/clientes/{id}`

Actualiza un cliente existente.

### 5. Eliminar Cliente
**DELETE** `/clientes/{id}`

Elimina un cliente por su ID.

### 6. Buscar Cliente por Cédula
**GET** `/clientes/buscar?cedula={cedula}`

Busca un cliente por su cédula.

## Endpoints de Producto (para autocompletado)

### 1. Buscar Producto por Código de Barras
**GET** `/productos/buscar?codigoBarras={codigoBarras}`

Busca un producto específico por su código de barras para autocompletado en facturas.

**Respuesta exitosa (200):**
```json
{
  "id": 1,
  "codigoBarras": "123456789",
  "nombre": "Producto 1",
  "categoria": "PRODUCTO",
  "precio": 50.00,
  "stock": 10
}
```

### 2. Obtener Todos los Productos
**GET** `/productos`

Obtiene todos los productos o filtra por código de barras.

## Endpoints de Reporte de Facturas

### 1. Obtener Reporte de Facturas
**GET** `/reportes`

Obtiene el reporte de todas las facturas emitidas.

**Respuesta exitosa (200):**
```json
[
  {
    "numeroDocumento": "001-001-000000001",
    "identificacionCliente": "1234567890",
    "nombreCliente": "Juan Pérez",
    "cantidadItems": 2,
    "totalImpuestos": 12.00,
    "total": 112.00
  }
]
```

## Códigos de Error

- **400 Bad Request**: Error en los datos enviados
- **404 Not Found**: Recurso no encontrado
- **500 Internal Server Error**: Error interno del servidor

## Notas Importantes

1. **Cálculo Automático**: Los subtotales, impuestos y totales se calculan automáticamente al crear/actualizar facturas.
2. **Validación de Stock**: Se valida el stock disponible para productos antes de crear facturas.
3. **Fecha de Emisión**: Si no se proporciona, se establece automáticamente la fecha actual.
4. **Impuestos**: Actualmente se aplica un IVA del 12% (se puede mejorar para manejar múltiples impuestos).
5. **Cédula Única**: No se pueden crear clientes con cédulas duplicadas.
6. **Número de Documento Único**: Cada factura debe tener un número de documento único.

## Ejemplo de Uso Completo

### 1. Crear un cliente
```bash
curl -X POST http://localhost:8080/clientes \
  -H "Content-Type: application/json" \
  -d '{
    "cedula": "1234567890",
    "nombre": "Juan",
    "apellido": "Pérez",
    "razonSocial": "Juan Pérez",
    "direccion": "Av. Principal 123",
    "telefono": "0987654321",
    "correo": "juan@email.com"
  }'
```

### 2. Crear una factura
```bash
curl -X POST http://localhost:8080/facturas \
  -H "Content-Type: application/json" \
  -d '{
    "rucEmpresa": "1234567890001",
    "numeroDocumento": "001-001-000000001",
    "establecimiento": "001",
    "puntoEmision": "001",
    "cliente": {"id": 1},
    "detalles": [
      {
        "cantidad": 2,
        "producto": {"id": 1}
      }
    ]
  }'
```

### 3. Obtener reporte de facturas
```bash
curl -X GET http://localhost:8080/reportes
``` 