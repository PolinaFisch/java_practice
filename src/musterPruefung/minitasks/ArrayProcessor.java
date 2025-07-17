package musterPruefung.minitasks;

//only one method, can be converted into lambda expression -->
@FunctionalInterface
public interface ArrayProcessor {
    double apply(double[] array);
}
