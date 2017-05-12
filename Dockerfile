FROM ubuntu:14.04
MAINTAINER Sunchan Lee <sunchanlee@inslab.co.kr>

RUN apt-get update && apt-get install -y wget git curl zip openjdk-7-jdk gcc g++ && rm -rf /var/lib/apt/lists/*

ENV JENKINS_VERSION 1.565.3
RUN mkdir /usr/share/jenkins/

COPY init.groovy /tmp/WEB-INF/init.groovy.d/slave-and-ldap-init.groovy
RUN curl -L http://mirrors.jenkins-ci.org/war-stable/$JENKINS_VERSION/jenkins.war -o /usr/share/jenkins/jenkins.war \
  && cd /tmp \
  && zip -g /usr/share/jenkins/jenkins.war WEB-INF/init.groovy.d/*.groovy \
  && rm -rf /tmp/WEB-INF

ENV JENKINS_HOME /var/jenkins_home
VOLUME /var/jenkins_home

# for main web interface:
EXPOSE 8080

ENV AGENT_PORT 50000

# will be used by attached slave agents:
EXPOSE ${AGENT_PORT}

ENV JENKINS_OPTS --prefix=/jenkins

COPY jenkins.sh /usr/local/bin/jenkins.sh
RUN chmod +x /usr/local/bin/jenkins.sh
ENTRYPOINT ["/usr/local/bin/jenkins.sh"]
