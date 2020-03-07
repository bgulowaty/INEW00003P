package pl.edu.pwr.bgulowaty;

class HashingAlgorithmNotAvailableException extends RuntimeException {

    private static final long serialVersionUID = 6330288924612070498L;

    public HashingAlgorithmNotAvailableException(HashingAlgorithm hashingAlgorithm) {
        super("Hashing algorithm " + hashingAlgorithm + " is not available.");
    }
}
