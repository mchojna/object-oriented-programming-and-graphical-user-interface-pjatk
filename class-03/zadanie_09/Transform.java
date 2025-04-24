@FunctionalInterface
interface Transform<T, R> {
    R apply(T arg);
}

