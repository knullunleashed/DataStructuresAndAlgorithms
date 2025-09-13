package Models;

import java.util.List;

public record Employee(int id, String name, double salary, String department, int age, List<String>skills) {
}
