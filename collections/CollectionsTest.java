import java.util.Collections;//differ Collection which is package of Interface

//Collection c can accept elements of type T or any of its superclasses (lower-bounded wildcard).
//Using ? if and only if the method is type irrelevant and read only.
public static <T> boolean addAll(Collection<? super T> c, T... elements) {
        boolean result = false;
        for (T element : elements)
            result |= c.add(element);
        return result;
}
