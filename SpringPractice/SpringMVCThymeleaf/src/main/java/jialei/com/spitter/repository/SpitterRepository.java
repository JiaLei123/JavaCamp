package jialei.com.spitter.repository;

import jialei.com.spitter.model.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
