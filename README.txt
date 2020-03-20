El servicio expuesto para obtener el token es, si se coorre local:
localhost:8080/authenticate

El token se entrega luego de vaidar usuario y contraseña (En duro)
username: usuario
password: password

JSON
{
    "username": "usuario",
    "password": "password"
}

El EndPoint para el desarrollo es, si se corre local:
http://localhost:8080/Usuario/agregarUsuario

NOTA: El token entregado se pone en el header 'Authorization'