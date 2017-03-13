package jialei.com;

import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 * Created by JiaLei on 2017/3/7.
 */
public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest() {
        Quest mockQutes = mock(Quest.class);
        BraveKnight knight = new BraveKnight(mockQutes);
        knight.embarkOnQuest();
        verify(mockQutes, times(1)).embark();
    }

}