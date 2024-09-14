import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HabitTracker tracker = new HabitTracker();

        // Ingresar hábitos
        System.out.println("Introduce tus hábitos (escribe 'fin' para terminar):");
        while (true) {
            String habitName = scanner.nextLine();
            if (habitName.equalsIgnoreCase("fin")) {
                break;
            }
            tracker.addHabit(habitName);
        }

        // Registrar progreso diario
        for (int day = 0; day < 7; day++) {
            System.out.println("\nDía " + (day + 1) + ":");
            for (Habit habit : tracker.habits) {
                System.out.print("¿Cumpliste el hábito '" + habit.getName() + "'? (1: sí, 0: no): ");
                int status = scanner.nextInt();
                tracker.markHabitProgress(habit.getName(), day, status);
            }
        }

        // Mostrar progreso diario y semanal
        System.out.println("\nResumen del progreso semanal:");
        tracker.displayWeeklyProgress();
    }
}
