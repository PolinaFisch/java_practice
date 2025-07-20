package chatgpt.collections.sets.task01;

import java.util.Set;

public class Main {
}

public class SetUtils {

    /**
     * 1. Объединение: возвращает новый Set, содержащий все элементы из a и из b.
     *
     * @param a  первое множество (не null)
     * @param b  второе множество (не null)
     * @return   новое множество с union(a,b)
     * @throws IllegalArgumentException если a или b == null
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) { … }


    /**
     * 2. Пересечение: возвращает новый Set из тех элементов, которые есть и в a, и в b.
     *
     * @param a  первое множество (не null)
     * @param b  второе множество (не null)
     * @return   новое множество с intersection(a,b)
     * @throws IllegalArgumentException если a или b == null
     */
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) { … }


    /**
     * 3. Разность: возвращает новый Set из элементов a, которых нет в b.
     *
     * @param a  первое множество (не null)
     * @param b  второе множество (не null)
     * @return   новое множество с difference(a,b)
     * @throws IllegalArgumentException если a или b == null
     */
    public static <T> Set<T> difference(Set<T> a, Set<T> b) { … }


    /**
     * 4. Симметричная разность: возвращает новый Set элементов,
     *    которые есть в a или в b, но не в обоих сразу.
     *
     * @param a  первое множество (не null)
     * @param b  второе множество (не null)
     * @return   новое множество с symmetricDifference(a,b)
     * @throws IllegalArgumentException если a или b == null
     */
    public static <T> Set<T> symmetricDifference(Set<T> a, Set<T> b) { … }
}
