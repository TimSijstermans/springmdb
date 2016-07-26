# springmdb 
Movie Database: Spring backend / Angularjs frontend

Tools used:
- Spring ToolSuite (Java)
- WebStorm - JetBrains (Angular client)

Docker image available at 

https://hub.docker.com/r/timsijstermans/springmdb/

it expects a mysql server to be running at localhost:3306 with password 'root'

Run with: 
docker run --net=host -p 8080:8080 -d springmdb:0.8

https://hub.docker.com/r/timsijstermans/springmdb

Alternatively use the docker-compose file which is included in the repository to spin both up at once on a VM.

Serves REST api at /springmdb/api/

Serves AngularJS frontend at /springmdb/

# Todo:
- Clientside + Serverside Form validation
- New person
- Update on everything
- Delete on persons
- Tests

