package jialei.com.spitter.data;

import jialei.com.spitter.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
