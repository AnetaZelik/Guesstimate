import org.example.BugReportingComplexity;
import org.example.Guesstimator;
import org.example.TextComplexity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;


public class CounterTest {
    private final Guesstimator guesstimator = new Guesstimator();

    private TextComplexity textComplexity;
    private BugReportingComplexity bugReportingComplexity;
    private int platformsAmount;
    private int devicesAmount;
    private int languagesAmount;

    @Test
    void shouldCountEstimate() {
        // given
        int wordsAmount = 12;
        textComplexity = TextComplexity.MEDIUM;
        bugReportingComplexity = BugReportingComplexity.MEDIUM;
        platformsAmount = 2;
        devicesAmount = 2;
        languagesAmount = 12;

        float expectedGuesstimate = 12 * 2 * 2 * 2 * 2 * 12;

        // when
        float actualGuesstimate = guesstimator.guesstimate(wordsAmount, textComplexity, bugReportingComplexity, platformsAmount, devicesAmount, languagesAmount);

        // then
        Assertions.assertEquals(expectedGuesstimate, actualGuesstimate);
    }

    @Test
    void shouldEstimateFromText() {

        //given
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Proin maximus placerat vulputate.";
        textComplexity = TextComplexity.MEDIUM;
        bugReportingComplexity = BugReportingComplexity.MEDIUM;
        platformsAmount = 2;
        devicesAmount = 2;
        languagesAmount = 12;

        float expectedGuesstimate = 12 * 2 * 2 * 2 * 2 * 12;

        // when
        float actualGuesstimate = guesstimator.guesstimateFromText(text, textComplexity, bugReportingComplexity, platformsAmount, devicesAmount, languagesAmount);

        // then
        Assertions.assertEquals(expectedGuesstimate, actualGuesstimate);

    }

    @Test
    void shouldEstimateFromTextFile() throws IOException {
        //given
        Path path = Path.of("C:\\Users\\v-Aneta.Zelik\\IdeaProjects\\Guesstimate\\src\\main\\resources\\TestText");
        textComplexity = TextComplexity.MEDIUM;
        bugReportingComplexity = BugReportingComplexity.MEDIUM;
        platformsAmount = 2;
        devicesAmount = 2;
        languagesAmount = 12;

        float expectedGuesstimate = 12 * 2 * 2 * 2 * 2 * 12;

        // when
        float actualGuesstimate = guesstimator.guesstimateFromTextFile(path, textComplexity, bugReportingComplexity, platformsAmount, devicesAmount, languagesAmount);

        // then
        Assertions.assertEquals(expectedGuesstimate, actualGuesstimate);
    }
}
