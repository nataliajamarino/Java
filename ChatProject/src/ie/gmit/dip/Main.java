package ie.gmit.dip;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String args[]) {
        Collection<ChatClient> col = new ArrayList<>();
        Map<ChatClient, Double> map = new HashMap<>();

        map.put(new ChatClient(), 22.22);
    }

    public boolean hasDuplications(Collection<ChatClient> col) {
        for(ChatClient c : col) {
            for (ChatClient d : col) {
                if (c != d && c.getClient().equals(d.getClient())) {
                    return true;
                }
            }
        }

        return false;
    }

    public Double hasDuplications(Map<ChatClient, Double> map) {
        for (ChatClient a : map.keySet()) {
            for (ChatClient b : map.keySet()) {
                if (a != b && a.getClient().equals(b.getClient())) {
                    return map.get(a);
                }
            }
        }

        return 0d;
    }
}
