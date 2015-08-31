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

LDAP_BASE_DN : Base DN value for searching user accounts (ex : dc=example,dc=com)

Installed build tools (compiler)
--------------------------------

JDK7 (OpenJDK 1.7.0_79)

GCC 4.8.4

G++ 4.8.4

Python 2.7.6

