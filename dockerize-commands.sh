#After we created the Dockerfile as well as docker-compose.yml file then follow the below commands to deploy in a container

#Generate a spring boot jar that is deployable in docker using below command

#clean up the existing images
#docker stop e-commerce-product-catalog-service-spring-ecommerce-catalog-app
#docker rm e-commerce-product-catalog-service-spring-ecommerce-catalog-app
#docker rmi spring-ecommerce-catalog-app
#docker rmi e-commerce-product-catalog-service-spring-ecommerce-catalog-app

mvn clean package -DskipTests

#create an image using below command
docker build -t spring-ecommerce-catalog-app .

#Run docker-compose command to  install the required libraries
docker-compose up -d