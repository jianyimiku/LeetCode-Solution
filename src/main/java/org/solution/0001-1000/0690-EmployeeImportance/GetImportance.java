import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。
// 比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。
// 他们相应的重要度为 15 , 10 , 5 。那么员工 1 的数据结构是 [1, 15, [2]] ，
// 员工2的数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。
// 注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
// 现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
@SuppressWarnings("all")
class GetImportance {
    int res = 0;
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>(employees.size());
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        addRes(employeeMap, id);
        return res;
    }

    public void addRes(Map<Integer, Employee> employeeMap, int id) {
        Employee employee = employeeMap.get(id);
        res += employee.importance;
        if (employee.subordinates.size() > 0) {
            for (Integer e : employee.subordinates) {
                addRes(employeeMap, e);
            }
        }
    }

    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }


    public static void main(String[] args) {
        GetImportance getImportance = new GetImportance();
    }
}