package sample;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.*;

import java.net.URL;
import java.security.ProtectionDomain;


public class Main {
    public static void main(String[] args) throws Exception {
        WebAppContext war = new WebAppContext();
        war.setContextPath("/sample");

        ProtectionDomain domain = Main.class.getProtectionDomain();
        URL warLocation = domain.getCodeSource().getLocation();
        war.setWar(warLocation.toExternalForm());

        Configuration[] configurations = {
            new AnnotationConfiguration(),
            new WebInfConfiguration(),
            new WebXmlConfiguration(),
            new MetaInfConfiguration(),
            new FragmentConfiguration(),
            new EnvConfiguration(),
            new PlusConfiguration(),
            new JettyWebXmlConfiguration()
        };

        war.setConfigurations(configurations);

        Server server = new Server(8080);
        server.setHandler(war);
        server.start();
        server.join();
    }
}
