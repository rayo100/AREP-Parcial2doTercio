# Parcial2doTercio-AREP

Diseñé, construya y despliegue un aplicación web para investigar la conjetura de Collatz. El programa debe estar desplegado en un microcontenedor Docker corriendo en AWS. 
Las tecnologías usadas en la solución deben ser maven, git, github, maven, sparkjava, html5, y js. No use liberías adicionales.

## Requisitos

1. Incluya instrucciones de cómo clonarlo, compilarlo, y ejecutarlo.
2. Descripción del proyecto en el README con pantalazos que muestren el funcionamiento.
3. Descripción de cómo correrlo en EC2
4. Video de menos de un minuto del funcionamiento (lo puede tomar con el celular una vez funcione o con teams)

## Cómo correrlo en tu equipo


Para clonarlo, ve a tu directorio de preferencia y escribe el siguiente comando
```
git clone https://github.com/rayo100/Parcial2doTercio-AREP.git
```
Luego, digita el comando 
```
cd Parcial2doTercio-AREP
```
Finalmente ejecuta:
```
mvn clean install
```
Para correrlo desde un dispositivo con sistema operativo Windows, corre el siguiente comando
```
java -cp "target/classes;target/dependency/*" org.example.CollaztService
```
Para correrlo desde un dispositivo con sistema operativo Linux o Apple, corre el siguiente comando
```
java -cp "target/classes:target/dependency/*" org.example.CollaztService
```

Al realizar los pasos anteriores dirigete al browser e ingresa al siguiete enlace http://localhost:5000/index.html

Te debería aparecer algo así

![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/c6e9d9ce-3467-4e28-ae11-33f2600b4a28)

Ahora puedes probar con cualquier número y obtener la secuencia que quieras.

## Probando la funcionalidad 

![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/be3b692e-e6cd-4c3e-95d3-d2f0a60bf8ac)

![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/c645eead-fae1-4fca-8f91-0f7d123ded82)

![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/e920f210-4daa-4599-903c-9ba0b92a4091)

## Cómo correrlo con docker
Iniciamos construyendo la imagen en Docker
Ejecutamos los siguientes comandos:
```
docker build --tag parcialdos . -f Dockerfile
```
![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/8afe7d0b-56c9-4f79-b296-133ae2751230)

```
docker images
```
Se dedería poder ver así:

![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/6287a266-fa5c-419e-acb1-24571993c6e2)

A partir de la imagen creada, iniciamos una instancia de un contenedor docker independiente de la consola (opción “-d”) y con el puerto 6000 enlazado a un puerto físico de su máquina (opción -p):
```
docker run -d -p 34000:6000 --name firstdockercontainer parcialdos
```
![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/7a668670-7440-4bca-9c26-6b44d16c1a0d)

Asegúrese que el contenedor está corriendo
```
docker ps
```
![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/864fd459-d57a-49e3-9b72-66b8d1916beb)

Acceda por el browser a http://localhost:34000/index.html y verifique la funcionalidad

![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/3f5aa9fb-3fbf-4dfe-9da5-4e9154ff8350)

Creamos un repositorio en dockerhub para subir la imagen 

![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/3eb0a8d9-fd05-4cab-9b35-74aa6a206aff)

Ejecutamos el siguiente comando para crear una referencia a la imagen con el nombre del repositorio a donde desea subirla:
```
docker tag parcialdos cesar0616/parcialsegundotercio
```
Veificicamos:
```
docker images
```
![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/a5e719d2-7986-4732-9551-ddb9e367bf9f)

Autentícamos en su nuestra cuenta de dockerhub (ingrese su usuario y clave si es requerida):
```
docker login
```
![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/1eac49be-5b4e-48d2-8a1a-9d813bc86eb7)


Empujamos la imagen al repositorio en DockerHub que cremos anteriormente
```
docker push cesar0616/parcialsegundotercio:latest
```
![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/736027f3-8b37-4d60-a47b-e813dd4bdb35)

Verificamos que la imagen se haya subido correctamente:

![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/19ef5524-5d09-4226-853e-9dde78e47a23)


## Cómo correrlo en EC2
Ahora vamos a AWS Academy
Conectese a la instancia EC2 corriendo

![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/84f931b2-ef18-4ea9-93bc-b18f5a9cff89)

Realice la instalación de docker en nuestra máquina:
```
sudo yum update -y
```
```
sudo yum install docker
```

Inicie el servicio de docker
```
sudo service docker start
```

Configure el usuario en el grupo de docker para no tener que ingresar “sudo” cada vez que invoca un comando
```
sudo usermod -a -G docker ec2-user
```

OJO!!! Desconectese de la máquina virtual e ingrese nuevamente para que la configuración de grupos de usuarios tenga efecto.

A partir de la imagen creada en Dockerhub cree una instancia de un contenedor docker independiente de la consola (opción “-d”) y con el puerto 6000 enlazado a un puerto físico de su máquina (opción -p):
```
docker run -d -p 42000:6000 --name parcialdos cesar0616/parcialsegundotercio
```

Abra los puertos de entrada del security group de la máxima virtual para acceder al servicio

Verifique que pueda acceder  en una url similar a esta (la url específica depende de los valores de su maquina virtual EC2)

http://ec2-52-91-173-12.compute-1.amazonaws.com:42000/index.html

![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/0fcdf959-576d-4e34-a395-87d59e755287)

## Video aplicación desplegada en AWS

https://www.youtube.com/watch?v=BMpsMpFBMBk

## Autor

Cesar Vásquez







