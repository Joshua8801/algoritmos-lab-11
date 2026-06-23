package prueba;


import ejercicio6.SessionCache;
import ejercicio6.Session;

public class TestSessionCache {

    public static void main(String[] args) throws Exception {

        SessionCache cache = new SessionCache(7);

        // usuarios
        cache.login( "abc123", "Juan", "ADMIN", 5000 );
        cache.login( "xyz789", "Ana", "USER", 1000 );
        cache.login( "token55", "Luis", "USER", 10000);

        System.out.println("\nVALIDAR");
        System.out.println(cache.validate("abc123"));

        Thread.sleep(2000);

        System.out.println(cache.validate("xyz789"));
        System.out.println(cache.validate("token55"));
        System.out.println("\nLOGOUT");

        cache.logout("abc123");
       
        cache.cleanExpired();

        System.out.println("Sesiones activas: " + cache.activeSessions());
       
    }
}