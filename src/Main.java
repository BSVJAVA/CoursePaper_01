import java.util.Random;

public class Main {

    private final static Random RANDOM = new Random();
    private final static String[] NAMES = {"Константин", "Денис", "Владимир", "Павел", "Роман", "Вадим", "Евгений", "Виталий"};
    private final static String[] SURNAMES = {"Кузнецов", "Романов", "Владимиров", "Павлов", "Попов", "Круглов", "Вечерко", "Буйнов"};
    private final static String[] MIDDLE_NAME = {"Константинович", "Денисович", "Владимирович", "Павлович", "Романович", "Вадимович", "Евгеньевич", "Витальевич"};
    private final static String[] COMPANY_DEPARTMENT = {"Производственный отдел", "Экономический отдел", "Технический отдел", "Материальный отдел"};
    private final static Employee[] EMPLOYEES = new Employee[10];

    private static void initEmployees() {  //Инициализация сотрудников
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = SURNAMES[RANDOM.nextInt(0, SURNAMES.length)] + " " +
                    NAMES[RANDOM.nextInt(0, NAMES.length)] + " " +
                    MIDDLE_NAME[RANDOM.nextInt(0, MIDDLE_NAME.length)];
            String companyDepartment = COMPANY_DEPARTMENT[RANDOM.nextInt(0, COMPANY_DEPARTMENT.length)];
            EMPLOYEES[i] = new Employee(fullName, companyDepartment, RANDOM.nextInt(100_000, 200_001));
        }
    }


    public static void main(String[] args) {
        System.out.println("Hello, World!");
        initEmployees(); //Инициализация сотрудников
        print(); //Получить список всех сотрудников со всеми имеющимися по ним данным
        System.out.println("Сумма затрат на ЗП = " + sumUpSalaries());
        System.out.println("Сотрудник с минимальной зарплатой: " + findEmployeeMinimumSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + findEmployeeMaximumSalary());
        System.out.println("Средняя зарплата = " + calculateAverageSalary());
        printFullNames(); // Распечатать ФИО сотрудников
    }

    private static void print() {   //Получить список всех сотрудников со всеми имеющимися по ним данным
        for (int i = 0; i < EMPLOYEES.length; i++) {
            System.out.println(EMPLOYEES[i]);
        }
    }

    private static int sumUpSalaries() { //Посчитать сумму затрат на ЗП в месяц
        int sumSalary = 0;
        for (int i = 0; i < EMPLOYEES.length; i++) {
            sumSalary = sumSalary + EMPLOYEES[i].getSalary();
        }
        return sumSalary;
    }

    private static Employee findEmployeeMinimumSalary() { //Найти сотрудника с минимальной ЗП;
        int minimumSalary = EMPLOYEES[0].getSalary();
        int idEmployee = 0;
        for (int i = 1; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i].getSalary() < minimumSalary) {
                minimumSalary = EMPLOYEES[i].getSalary();
                idEmployee = i;
            }
        }
        return EMPLOYEES[idEmployee];
    }

    private static Employee findEmployeeMaximumSalary() { //Найти сотрудника с максимальной ЗП;
        int maximumSalary = EMPLOYEES[0].getSalary();
        int idEmployee = 0;
        for (int i = 1; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i].getSalary() > maximumSalary) {
                maximumSalary = EMPLOYEES[i].getSalary();
                idEmployee = i;
            }
        }
        return EMPLOYEES[idEmployee];
    }

    private static double calculateAverageSalary() { //Подсчитать среднее значение зарплат
        return (double) sumUpSalaries() / EMPLOYEES.length;
    }

    private static void printFullNames() { //Распечатать ФИО всех сотрудников
        for (int i = 0; i < EMPLOYEES.length; i++) {
            System.out.println(EMPLOYEES[i].getFullName());
        }
    }

}