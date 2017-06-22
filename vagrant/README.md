# ansible + docker + vagrant (virtualbox)

1. Check that all docker images succesful build by gradle in previous steps. Run `docker images`. You should see something like this:

```
services_example/service2          latest                          ba0f7a21195f        About an hour ago   202 MB
services_example/service1          latest                          6179188edf11        About an hour ago   202 MB
services_example/eureka_server     latest                          10d9d36321a2        About an hour ago   212 MB
services_example/config_service    latest                          a65ce4ef829b        About an hour ago   190 MB
```

2. Install following vagrant plugins:
```
vagrant plugin install vagrant-hostmanager
vagrant plugin install vai
```

3. Run `vagrant up`, wait until all virtual machines will start up. After complete you will have two running virtual machines with prepared ansible inventory file in `.vagrant/provisioners/ansible/inventory/vagrant_ansible_inventory`

4. Run `ansible-playbook -i .vagrant/provisioners/ansible/inventory/vagrant_ansible_inventory  -v play-site.yml`

5. Check than all docker containers has been running in virtual machines. If not, disable `recreate` and `restart` in [common config](/vagrant/roles/common/vars/main.yml) and try to run command from 4 again.

6. Check service1 by executing request:

Expected response will by calculated by expression: $value * [multiple.value](/multiply-production.properties) + [increment.value](/public-production.properties)
```bash
curl http://localhost:8081/api?value=2 
