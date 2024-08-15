package Data;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import javax.management.DescriptorKey;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    @Description("Test returns a Plateau when provided a valid input")
    void getInstance() {

        Plateau plateau1 = Plateau.getInstance(5, 5);
        Plateau instanceCall = Plateau.getInstance();

        assertSame(plateau1, instanceCall);
    }
}