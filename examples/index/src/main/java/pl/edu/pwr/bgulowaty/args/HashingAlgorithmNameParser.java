package pl.edu.pwr.bgulowaty.args;

import pl.edu.pwr.bgulowaty.HashingAlgorithm;

class HashingAlgorithmNameParser {

    @SuppressWarnings("MethodMayBeStatic")
    HashingAlgorithm parse(String algorithmName) {
        try {
            return HashingAlgorithm.valueOf(algorithmName);
        } catch (IllegalArgumentException e) {
            throw new UnknownHashingAlgorithmException(algorithmName, e);
        }
    }

    static final class UnknownHashingAlgorithmException extends RuntimeException {

        private static final long serialVersionUID = -6068268445943297714L;

        UnknownHashingAlgorithmException(String algorithm, Throwable cause) {
            super("Hashing algorithm " + algorithm + " is not supported.", cause);
        }
    }
}
