public class Calculator {
    public static final int JUNIOR = 1;
    public static final int SENIOR = 2;
    public static final int SPECIALIST = 3;
    public static final int JUNIOR_PAY_PER_HOUR = 10;
    public static final int SENIOR_PAY_PER_HOUR = 15;
    public static final int SPECIALIST_PAY_PER_HOUR = 22;
    public static final int JUNIOR_REGULAR_WORKHOURS = 8;
    public static final int SENIOR_REGULAR_WORKHOURS = 8;
    public static final int SPECIALIST_REGULAR_WORKHOURS = 9;
    public static final int JUNIOR_MULTIPLIER = 2;
    public static final int SENIOR_MULTIPLIER = 2;
    public static final int SPECIALIST_MULTIPLIER = 3;
    public static final int HERO_HOURS = 20;
    public static final int JUNIOR_HERO_BONUS = 10;
    public static final int SENIOR_HERO_BONUS = 20;
    public static final int SPECIALIST_HERO_BONUS = 30;

    protected int regularSalary(final int workerType, final int hoursWorked) {
        int salary, payPerHour, regularWorkHours, payIncreaseMultiplier;
        if (workerType == JUNIOR) {
            payPerHour = JUNIOR_PAY_PER_HOUR;
            regularWorkHours = JUNIOR_REGULAR_WORKHOURS;
            payIncreaseMultiplier = JUNIOR_MULTIPLIER;
        } else if (workerType == SENIOR) {
            payPerHour = SENIOR_PAY_PER_HOUR;
            regularWorkHours = SENIOR_REGULAR_WORKHOURS;
            payIncreaseMultiplier = SENIOR_MULTIPLIER;
        } else if (workerType == SPECIALIST) {
            payPerHour = SPECIALIST_PAY_PER_HOUR;
            regularWorkHours = SPECIALIST_REGULAR_WORKHOURS;
            payIncreaseMultiplier = SPECIALIST_MULTIPLIER;
        } else {
            throw new IllegalArgumentException("Wrong worker type");
        }
        if (hoursWorked > regularWorkHours) {
            salary = payPerHour * (hoursWorked - regularWorkHours) * payIncreaseMultiplier;
            salary += payPerHour * regularWorkHours;
        } else {
            salary = payPerHour * hoursWorked;
        }
        return salary;
    }

    public int heroBonus(final int workerType, final int hoursWorked) {
        int salary = 0;
        if (hoursWorked > HERO_HOURS) {
            if (workerType == JUNIOR) {
                salary += JUNIOR_HERO_BONUS;
            }
            if (workerType == SENIOR) {
                salary += SENIOR_HERO_BONUS;
            }
            if (workerType == SPECIALIST) {
                salary += SPECIALIST_HERO_BONUS;
            }
        }
        return salary;
    }

    public int finalPay(final int workerType, final int hoursWorked) {
        return regularSalary(workerType, hoursWorked) + heroBonus(workerType, hoursWorked);
    }
}
