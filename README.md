# Data Pipeline
Esta aplicación consume los datos de una API de metrobuses de la ciudad de México, y en conjunto con
Google Maps vincula la ubicación con la Alcaldia correspondiente para dicha ciudad.

## ¿Qué necesito para que funcione?
1. Jdk11
2. API Key de Google Maps para el servicio de Geocodificación, se agrega en el archivo de propiedades.
3. Docker
4. Docker compose
5. Kubernetes (otra forma de desplegar)
6. Minikube
7. Paciencia para configurar Minikube

## **IMPORTANTE**
> Esta aplicación solo tiene un endpoint para consumir los datos el cual está hecho con GraphQL, para cada tipo de consulta se usa una petición
> diferente, pero esas consultas son definidas por el cliente.

## ¿Cómo desplegar esta aplicación con docker-compose?
1. Clona el repositorio en tu computadora
2. Accede a la carpeta con el siguiente comando: **cd tu_carpeta**
3. Genera el archivo .jar del proyecto spring utilizando el comando: **./mvnw clean package** o **mvn clean package**
4. Si ya tienes tu carpeta target, ahora puedes proceder a lanzar el combo: **docker-compose up --build** o simplemente **docker-compose up**

## ¿Cómo desplegar esta aplicación con Kubernetes?  
### Ubicación de archivos de kubernetes: src/main/resources
1. Clonar el repositorio en tu computadora y accede a la carpeta del proyecto.
2. Si no has activado minikube usa **minikube start --driver=tu_driver**, en mi caso utilicé hyperv, caso contrario ve al paso 4.
3. Escribir **eval $(minikube docker-env)** para evaluar los argumentos de docker y compilarlos con minikube.
4. Si ya tienes configurado minikube, comienza desde aquí.
5. Genera el archivo .jar del proyecto spring utilizando el comando: **./mvnw clean package** o **mvn clean package**
6. Genera la imagen docker del proyecto con **docker build -t spring:latest**, quieres guardar la imagen con otro nombre deberás modificar el archivo **app-deployment.yaml**.
7. Accede a la carpeta resources dentro de la carpeta del proyecto con el comando: **cd tu_carpeta** hasta llegar a src/main/resources
8. Desplegar la base de datos con **kubectl apply -f bd-deployment.yaml**.
9. Revisar con el comando **kubectl get deployments** o **kubectl get pods** para revisar que el servicio de base de datos se esté ejecutando ya que la aplicación depende de la base de datos para el despliegue.
10. Desplegar la aplicación con **kubectl apply -f app-deployment.yaml**.
11. Para verificar que la aplicación haya sido desplegada usa **kubectl get deployments**, **kubectl get pods** y **kubectl get svc**.
12. Para saber la ip del servicio a consumir se debe utilizar **minikube service springboot-pipeline-svc --url**, ese es el nombre que se le dió al servicio.
13. La dirección obtenida será la que se debe utilizar para conectar la aplicación cliente con el servicio.
