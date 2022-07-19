# ecabs

modules
-----------------------------------
config-server     # for project properties management
eureka-server     # check and monitor the status of projects
booking-domain    # check and monitor the status of projects
booking-dao       # project tables and models
booking-parent-service    # project common services
booking-database-service  # h2 database server for the project
booking-producer-service  # message producer service
booking-consumer-service  # message consumer service

for rabbitMQ
execute: docker-compose up, you can see more info at: docker-compose.yml file
