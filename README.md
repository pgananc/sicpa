# SICPA
***
Sistema administración de empresas.

# admin-enterprise
***
Aplicación Back End para la administración de los servicios REST.

## Prerrequisitos para ejecutar el proyecto
***
- Instalar JDK versión 8

- Instalar BDD postgresql v13.4

- Instalar PGAdmin v4

- Instalar maven 3.6.3


## Proceso de construcción de aplicación
***
1. Modificación de clave de base de datos. 

   - Usuario BDD: postgres

   - Contraseña BDD: contraseña (Cambiar la clave por la correpondiente en el archivo application.properties)
   - Nombre BDD: admin-enterprise

2. Restaurar backup de BDD llamado admin-enterprise.sql ubicado en el repositorio: https://github.com/pgananc/sicpa.git.

3. Cargar el script script_inicial.sql  ubicado en el repositorio: https://github.com/pgananc/sicpa.git.

4. Clonar el repositorio público con el siguiente comando: git clone --branch "main" https://github.com/pgananc/sicpa.git

5. Abrir una consola sobre la ruta del proyecto admin-enterprise.

6. Ejecutar el comando: mvn clean install

    



# Enterprise front end
***

Aplicación Front End para adminsitración.


## Prerrequisitos para ejecutar el proyecto
***

- Instalar node.js 14.0.2

- Instalar npm 7.23.0

- Instalar angular CLI 14.0.2

- Descargar nginx-1.21.3


## Proceso de construcción de aplicación
***

1. Abrir una consola sobre la ruta del proyecto companies-app

2. Ejecutar el comando: npm install

3. Ejecutar el comando ng build 

    (Se genera la carpeta companies-app dentro ruta_aplicativo/dist)

## Proceso de ejecución de aplicación
***

1. Copiar la carpeta companies-app que senecuentra dentro ruta_aplicativo/dist

2. Editar sudo nano /etc/ngix/sites-enabled/default
  Colocar lo que se encuentra en el archivo configuracion_nginx.txt.


   Para ingresar al sistema de administración:

              http://localhost/companies-app
               

     

 
**DISFRUTA DEL APLICATIVO**

**DEVELOPER:** Pablo Ganan

**Correo:** pablos.ganan@gmail.com
