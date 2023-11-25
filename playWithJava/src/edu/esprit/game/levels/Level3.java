package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import edu.esprit.game.utils.Data;
import java.util.Map;
import java.util.stream.Collectors;
import static jdk.nashorn.internal.objects.NativeArray.map;

public class Level3 {

    public static void main(String[] args) {
        List<Employee> employees = Data.employees();


        /* TO DO 1: Retourner une chaine de caract�re qui contient tous les noms des employ�s */
        String names = employees.stream().map(e -> e.getName()).reduce("test", (a, b) -> a + " " + b);

        System.out.println(names);

        Integer sum = employees.stream().map(e -> e.getSalary()).reduce(0, (a, b) -> a + b);

        System.out.println(sum);
        /* TO DO 2: Retourner une chaine de caract�re qui contient tous les noms des employ�s en majuscule separ�s par # */
        String namesMajSplit = employees.stream().map(e -> e.getName().toUpperCase()).
                reduce("", (a, b) -> a + "#" + b);
        System.out.println(namesMajSplit);
        /* TO DO 3: Retourner une set d'employ�s*/
        Set<Employee> emps = employees.stream().collect(Collectors.toSet());
        System.out.println(emps);

        /* TO DO 4: Retourner une TreeSet d'employ�s (tri par nom) */
        TreeSet<Employee> emps2 = employees.stream().filter(e->e.getSalary()>800).collect(Collectors.toCollection(() -> new TreeSet<>((a, b) -> a.getName().
                compareTo(b.getName()))));
        System.out.println(emps2);
        /* TO DO 5: Retourner une Map qui regroupe les employ�s par salaire */
        Map<Integer, List<Employee>> map = employees.stream().
                collect(Collectors.groupingBy(e -> e.getSalary()));

        map.forEach((e, v) -> {
            System.out.println("Cle :" + e);
            System.out.println("list salaire :" + v);
        });

        map.entrySet().forEach((e) -> {

            System.out.println(e.getKey() + " " + e.getValue());
        });

        /* TO DO 6: Retourner une Map qui regroupe les nom des employ�s par salaire */
        Map<Integer, String> mm = employees.stream().collect(Collectors.toMap(e -> e.getSalary(),
                e -> e.getName(), (a, b) -> a + b));
        System.out.println(mm);
        /* TO DO 7: Retourner le  min, max,average, sum,count des salaires */
        String s = employees.stream().collect(Collectors.summarizingInt(e -> e.getSalary())).toString();

        System.out.println(s);

    }
}
