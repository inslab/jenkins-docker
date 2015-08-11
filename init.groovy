import hudson.model.*;
import jenkins.model.*;
import hudson.security.*;

Thread.start {
      sleep 10000;
      def instance = Jenkins.getInstance();

      println "--> setting agent port for jnlp";
      instance.setSlaveAgentPort(50000);

      println "--> setting ldap authorization";
      def ldapUri = "ldap://codealley-ldap.cloudapp.net:389";
      def rootDN = "dc=codealley,dc=co";
      def ldap = new LDAPSecurityRealm(ldapUri, rootDN, null, null, null, null, null, false);
      if(ldap != null) instance.setSecurityRealm(ldap);
}
