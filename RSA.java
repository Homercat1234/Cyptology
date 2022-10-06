import java.math.BigInteger;

class RSA { // An unsecure implementation of rsa

    public static BigInteger[] getPublicKey() { // Creates the public key
        BigInteger P = new BigInteger("59"), Q = new BigInteger("89");
        BigInteger[] publicKey = { P.multiply(Q), new BigInteger("3") };
        return publicKey;
    }

    public static BigInteger[] getPrivateKey(BigInteger[] publicKey) { // Creates the private key
        BigInteger[] factors = new BigInteger[2];
        for (int i = 2, x = 0; i < publicKey[0].intValue(); i++) { // Derive P and Q
            if (publicKey[0].intValue() % i == 0) {
                factors[x] = new BigInteger(Long.toString(i));
                x++;
            }
        }
        BigInteger d = new BigInteger("2").multiply(factors[0].subtract(new BigInteger("1")))
                .multiply(factors[1].subtract(new BigInteger("1"))).add(new BigInteger("1")).divide(publicKey[1]);
        BigInteger[] privateKey = { publicKey[0], d };
        return privateKey;
    }

    public static BigInteger encrypt(BigInteger p, BigInteger[] publicKey) { // Encrypts data.
        BigInteger power = power(p, new BigInteger("1"), publicKey[1], new BigInteger("0"));
        return power.mod(publicKey[0]);
    }

    public static BigInteger decrypt(BigInteger c, BigInteger[] privateKey) { // Decrypts data
        BigInteger power = power(c, new BigInteger("1"), privateKey[1], new BigInteger("0"));
        return power.mod(privateKey[0]);
    }

    public static BigInteger power(BigInteger value, BigInteger number, BigInteger power, BigInteger current) { // calculates the power of of value to power.
        if (current.equals(power))
            return number;
        number = number.multiply(value);
        return power(value, number, power, current.add(new BigInteger("1")));
    }
}
