# Maintenance Management Microservice (SEZG583 Scalable Services Assignment 1)
This repository contains the code for a microservice built as part of Scalable Services Assignment 1. This microservice is one of three others built for this assignment.

This microservice is dockerized. The `Dockerfile` provided is capable of using the built JAR artifact and creating a docker image out of it.

To deploy the service in a single container, the following commands are used:
- To build the artifact (you need to have Java 8)
	```bash
	mvn clean package -Dmaven.test.skip=true
	```
- To build the docker image (run from root of the project, you need to have docker/docker desktop installed)
	```bash
	docker image build . -t=sezg583-assignment-maintenancemgmt
	```
- To run the docker image (you need to have docker/docker desktop installed)
	```bash
	docker run -d -p 9092:9092 sezg583-assignment-maintenancemgmt
	```

Below are few other helper docker commands used:
- To view the built docker images
	```bash
	docker image ls
	```
- To delete a docker image
	```bash
	docker image rm <image_id>
	```
- To view running docker containers
	```bash
	docker ps
	```
- To stop a docker container
	```bash
	docker stop <container_id>
	```
- To stop a docker container
	```bash
	docker stop <container_id>
	```
- To remove a docker container
	```bash
	docker rm <container_id>
	```