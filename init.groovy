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
    def ldapHost = env['LDAP_HOST'];
    def ldapPort = env['LDAP_PORT'];
    def baseDN = env['LDAP_BASE_DN'];

    if(ldapHost != null && ldapPort != null && baseDN != null) {
        def ldapUri = "ldap://${ldapHost}:${ldapPort}"
        def ldap = new LDAPSecurityRealm(ldapUri, baseDN, null, null, null, null, null, false);
        if(ldap != null) instance.setSecurityRealm(ldap);
    } else {
        println "--> not set ldap uri and root dn";
    }
}
