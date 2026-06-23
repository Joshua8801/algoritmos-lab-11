package ejercicio6;

import java.util.LinkedList;

public class SessionCache {

    private LinkedList<Session>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public SessionCache(int size) {

        this.size = size;
        table = (LinkedList<Session>[]) new LinkedList[size];

        for(int i=0;i<size;i++) {
            table[i] = new LinkedList<>();
        }

    }

    private int hash(String token) {
        return Math.abs(token.hashCode()) % size;
    }

    public void login(String token, String username, String role, long ttlMs) {

        long expires = System.currentTimeMillis() + ttlMs;
        Session s = new Session(token, username, role, expires);
        
        int pos = hash(token);
        table[pos].add(s);

        System.out.println( "Login: " + username);
    }

    public Session validate(String token) {

        int pos = hash(token);

        for(Session s : table[pos]) {

            if(s.getToken().equals(token)) {

                if(s.expired()) {
                    return null;
                }
                return s;
            }
        }
        return null;
    }

    public void logout(String token) {

        int pos = hash(token);

        for(Session s : table[pos]) {

            if(s.getToken().equals(token)) {

                table[pos].remove(s);

                System.out.println( "Logout realizado");
                return;
            }
        }
    }

    public void cleanExpired() {

        for(int i=0;i<size;i++) {
            table[i].removeIf( s -> s.expired());
        }
    }

    public int activeSessions() {

        int count=0;

        for(LinkedList<Session> list : table) {
            count += list.size();
        }
        return count;
    }
}
