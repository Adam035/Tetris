package difficulty;

import lombok.Getter;

public enum Difficulty {
    EASY(500),
    MEDIUM(350),
    HARD(200);
    @Getter
    private final int delay;

    Difficulty(int difficulty) {
        this.delay = difficulty;
    }
}
