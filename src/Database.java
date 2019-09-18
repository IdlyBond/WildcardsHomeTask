import java.util.*;

public class Database<V> {
    private Set<V> base = new HashSet<>();

    public void join(List<? extends V> first, List<? extends V> second, Joins type){
        if (Objects.isNull(first) || Objects.isNull(second) || (first.isEmpty() && second.isEmpty())) return;
        switch (type){
            case FULL:
                fullJoin(first, second);
                break;
            case INNER:
                innerJoin(first, second);
                break;
            case LEFT:
                sideJoin(first, second);
                break;
            case RIGHT:
                sideJoin(second, first);
                break;
        }
    }

    private void fullJoin(List<? extends V> first, List<? extends V> second){
        base.addAll(first);
        base.addAll(second);
    }

    private void innerJoin(List<? extends V> first, List<? extends V> second){
        for (V o1: first){
            for (V o2: second){
                if(o1.equals(o2)) base.add(o1);
            }
        }
    }

    private void sideJoin(List<? extends V> first, List<? extends V> second){
        for (V o1: first){
            boolean isMany = false;
            for (V o2: second){
                if(o1.equals(o2)) {
                    isMany = true;
                    break;
                }
            }
            if (!isMany) base.add(o1);
        }
    }

    public Set<V> getBase(){
        return base;
    }

    public void wipe(){
        base.clear();
    }

}
