public class Habit {
    private String name;
    private int[] progress; // Guardar progreso diario para 7 días de la semana

    public Habit(String name) {
        this.name = name;
        this.progress = new int[7]; // Suponemos que el progreso se mide de 0 a 1 (0: no cumplido, 1: cumplido)
    }

    public String getName() {
        return name;
    }

    public void markDay(int day, int status) {
        if (day >= 0 && day < 7) {
            progress[day] = status; // 0 o 1 según si cumplió el hábito
        }
    }

    public int getProgressForDay(int day) {
        return progress[day];
    }

    public int[] getProgress() {
        return progress;
    }

    public double getWeeklyProgress() {
        int total = 0;
        for (int day : progress) {
            total += day;
        }
        return (total / 7.0) * 100; // Porcentaje de progreso semanal
    }
}
