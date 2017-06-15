# DevOps_playground

1. Step 1. Build docker containers.
```
cd applications/   
gradle buildDocker
````

2. Step 2. Run previous containers with right environment params.
```
cd ansible/
ansible-playbook -i test_hosts site.yml  
```
or if have any probles with docker_my try to add explicit python3 interpreter:
```
ansible-playbook -i test_hosts site.yml -e 'ansible_python_interpreter=/usr/local/bin/python3'
```

3. Step 3. Check that all containers is running
```
docker ps
```
In terminal you should see something like this: 
```
CONTAINER ID        IMAGE                                    COMMAND                  CREATED             STATUS              PORTS                    NAMES
dc194b3b43f0        services_example/service2:latest         "sh -c 'java $JAVA..."   10 minutes ago      Up 31 seconds                                service2-application
e160b8f10e9b        services_example/service1:latest         "sh -c 'java $JAVA..."   10 minutes ago      Up 33 seconds       0.0.0.0:8082->8080/tcp   service1-application
ff13db8e16d6        services_example/eureka_server:latest    "sh -c 'java $JAVA..."   12 minutes ago      Up About a minute   0.0.0.0:8081->8761/tcp   eureka-server-application
ab7e72b21a2e        services_example/config_service:latest   "sh -c 'java $JAVA..."   12 minutes ago      Up About a minute   0.0.0.0:8080->8889/tcp   config-server-application
```

4. Check service1 by executing request:

Expected response will by calculated by expression: $value * [multiple.value](/multiply-production.properties) + [increment.value](/public-production.properties)
```
curl http://localhost:8082/api?value=2 
```
...

5. Profit!
