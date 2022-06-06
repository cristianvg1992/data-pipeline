# Data Pipeline
Esta aplicación consume los datos de una API de metrobuses de la ciudad de México, y en conjunto con
Google Maps vincula la ubicación con la Alcaldia correspondiente para dicha ciudad.

## ¿Qué necesito para que funcione?
1. Jdk11
2. Docker
3. Docker compose
4. Kubernetes (otra forma de desplegar)
5. Minikube
6. Paciencia para configurar Minikube

## ¿Cómo desplegar esta aplicación con docker-compose?
1. Clona el repositorio en tu computadora
2. Accede a la carpeta con el siguiente comando: **cd tu_carpeta**
3. Genera el archivo .jar del proyecto spring (se anda buscando una mejor forma y mejor optimizada) utilizando el
   comando: **./mvnw clean package** o **mvn clean package**
4. Si ya tienes tu carpeta target, ahora puedes proceder a lanzar el combo: **docker-compose up --build** o simplemente **docker-compose up**

## ¿Cómo desplegar esta aplicación con Kubernetes?
1. Clonar el repositorio en tu computadora y accede a la carpeta del proyecto.
2. Genera el archivo .jar del proyecto spring utilizando el comando: **./mvnw clean package** o **mvn clean package**
3. Accede a la carpeta resources dentro de la carpeta descargada con el comando: **cd tu_carpeta** hasta llegar a src/main/resources
4. Genera la imagen docker del proyecto con **docker build -t spring:latest**, quieres guardar la imagen con otro nombre deberás modificar el archivo **app-deployment.yaml**.
5. Desplegar la base de datos con **kubectl apply -f bd-deployment.yaml**, el archivo se encuentra en la raíz del proyecto.
6. Desplegar la aplicación con **kubectl apply -f app-deployment.yaml**, el archivo se encuentra en la raíz del proyecto.
7. Para verificar que la base de datos haya sido desplegada usa **kubectl get deployments** y **kubectl get pods**
8. Para saber la ip del servicio a consumir se debe utilizar **minikube service springboot-pipeline-svc --url**
9. Esa dirección será la que se debe utilizar para conectar la aplicación cliente con el servicio.
