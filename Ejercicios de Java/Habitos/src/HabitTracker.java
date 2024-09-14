import java.util.ArrayList;
import java.util.List;

public class HabitTracker {
    public List<Habit> habits;

    public HabitTracker() {
        this.habits = new ArrayList<>();
    }

    public void addHabit(String habitName) {
        habits.add(new Habit(habitName));
    }

    public void markHabitProgress(String habitName, int day, int status) {
        for (Habit habit : habits) {
            if (habit.getName().equalsIgnoreCase(habitName)) {
                habit.markDay(day, status);
                break;
            }
        }
    }

    public void displayDailyProgress(int day) {
        System.out.println("Progreso diario para el día " + (day + 1) + ":");
        for (Habit habit : habits) {
            System.out.println(habit.getName() + ": " + (habit.getProgressForDay(day) == 1 ? "Cumplido" : "No cumplido"));
        }
    }

    public void displayWeeklyProgress() {
        System.out.println("Progreso semanal:");
        for (Habit habit : habits) {
            System.out.printf("%s: %.2f%% cumplido%n", habit.getName(), habit.getWeeklyProgress());
        }
    }
}
