package github.sagubr.security;

import com.nimbusds.jose.JWSAlgorithm;
import io.micronaut.security.token.jwt.signature.rsa.RSASignatureGeneratorConfiguration;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Singleton
@Named("generator")
public class RsaKeysJwkProvider implements RSASignatureGeneratorConfiguration {

    private final RSAPrivateKey privateKey;
    private final RSAPublicKey publicKey;

    public RsaKeysJwkProvider() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();

            this.privateKey = (RSAPrivateKey) keyPair.getPrivate();
            this.publicKey = (RSAPublicKey) keyPair.getPublic();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public RSAPrivateKey getPrivateKey() {
        return this.privateKey;
    }

    @Override
    public RSAPublicKey getPublicKey() {
        return this.publicKey;
    }

    @Override
    public JWSAlgorithm getJwsAlgorithm() {
        return JWSAlgorithm.RS256;
    }

}
