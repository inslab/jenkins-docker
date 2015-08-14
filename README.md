jenkins-docker
==============

Default
-------
Container port : 8080

Jenkins root context path : /jenkins

Slave JNLP agent port : 50000

Environmental variables
-----------------------

AGENT_PORT : slave jnlp agent port

JAVA_OPTS : java options to load jenkins.war

JENKINS_OPTS : jenkins options (default : --prefix=/jenkins)

LDAP_URI : LDAP server uri (ex : ldap://111.222.333.444:389)

LDAP_ROOTDN : ROOT DN value for searching user accounts (ex : dc=example,dc=com)
