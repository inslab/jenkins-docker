import hudson.model.*;
import jenkins.model.*;
import hudson.security.*;

Thread.start {
    sleep 10000;
    def instance = Jenkins.getInstance();

    def env = System.getenv();
    def agentPort = env['AGENT_PORT'];
    println "--> setting agent port for jnlp";
    if(agentPort != null) {
        instance.setSlaveAgentPort(agentPort.toInteger());
    } else {
        println "--> not set agent port";
    }

    println "--> setting ldap authorization";
    def ldapUri = env['LDAP_URI'];
    def rootDN = env['LDAP_ROOTDN'];

    if(ldapUri != null && rootDN != null) {
        def ldap = new LDAPSecurityRealm(ldapUri, rootDN, null, null, null, null, null, false);
        if(ldap != null) instance.setSecurityRealm(ldap);
    } else {
        println "--> not set ldap uri and root dn";
    }
}
