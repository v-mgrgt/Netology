import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Pomodoro {
    private final long w; // время работы в секундах
    private final long b; // время отдыха в секундах

    public Pomodoro(long w, long b) {
        this.w = w * 60;
        this.b = b * 60;
    }

    private void printProgressBar(String msg, final long time) throws InterruptedException {
        if (time < 60 || time % 60 != 0)
            throw new IllegalArgumentException("Указано недопустимое значение времени");

        int progressBarLength = 30;
        long stepLength = time / progressBarLength;

        double percentCounter = 0.0;
        double timeCounter = 0.0;

        for (int i = 0; i < progressBarLength + 1; i++) {
            System.out.printf(Locale.ROOT, "%s: %5.1f%% [%s%s] (%3.1f мин. / %.1f мин.)\r",
                    msg, percentCounter, "#".repeat(i), "_".repeat(progressBarLength - i), timeCounter, time / 60.0);

            percentCounter += 100.0 / progressBarLength;
            timeCounter += time / 60.0 / progressBarLength;

            if (i != progressBarLength)
                TimeUnit.SECONDS.sleep(stepLength);
        }

        System.out.println();
    }

    public void start() throws InterruptedException {
        printProgressBar("Время работать", w);
        printProgressBar("Время отдыхать", b);
    }
}
