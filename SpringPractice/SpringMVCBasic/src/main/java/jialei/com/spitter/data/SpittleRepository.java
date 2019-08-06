package jialei.com.spitter.data;

import jialei.com.spitter.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
