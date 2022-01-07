package alok.test.logic.maxoccurances;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        int[] data = {1, 2, 3, 4, 5, 2, 1, 2, 5, 9, 10, 12, 11, 10};
        int k = 3;

        System.out.println(Arrays.toString(getTopBrokers(data, k)));

    }

    static int[] getTopBrokers(int[] ids, int k) {

        Map<Integer,AuditLog> idOccurrences = new HashMap<>();
        for (int id: ids) {
            idOccurrences.compute(id, (key, val) -> {
                if (val == null) {
                    return new AuditLog(id, 1);
                }
                val.setOccurrences(val.getOccurrences() + 1);
                return val;
            });
        }

        List<AuditLog> entrySet = new ArrayList<>(idOccurrences.values());

        Collections.sort(entrySet);

        k = Math.min(entrySet.size(), k);

        int[] elements = new int[k];

        for (int i = 0 ; i < k; ++i) {
            elements[i] = entrySet.get(i).getId();
        }

        return elements;
    }
}

class AuditLog implements Comparable<AuditLog> {

    private int id;
    private int occurrences;

    public AuditLog(int id, int occurrences) {
        this.id = id;
        this.occurrences = occurrences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditLog auditLog = (AuditLog) o;
        return id == auditLog.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    @Override
    public int compareTo(AuditLog o) {

        if (occurrences < o.occurrences) {
            return 1;
        }

        if (occurrences > o.occurrences) {
            return -1;
        }

        return 0;
    }
}