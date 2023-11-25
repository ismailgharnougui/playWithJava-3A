package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import edu.esprit.game.utils.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Level1 {
    
    public static void main(String[] args) {
        List<Employee> employees = Data.employees();

        /* TO DO 1: Afficher tous les employ�s */
        employees.stream().forEach(v -> System.out.println(v));

        /*
		 * TO DO 2: Afficher les employ�s dont le nom commence par la lettre n
         */
        employees.stream().filter(e -> e.getName().startsWith("n")).
                forEach(v -> System.out.println(v));

        /*
		 * TO DO 3: Afficher les employ�s dont le nom commence par la lettre n
		 * et le salaire> 1000
         */
        employees.stream().filter(e -> e.getName().startsWith("n")).
                filter(e -> e.getSalary() > 1000)
                .forEach(e -> System.out.println(e));
        employees.stream().filter(e -> e.getName().startsWith("n") && e.getSalary() > 1000).
                forEach(e -> System.out.println(e));

        /*
		 * TO DO 4: Afficher les employ�s dont le nom commence par la lettre s
		 * tri�s par salaire
         */
        employees.stream().filter(e -> e.getName().startsWith("s")).
                sorted((e1, e2) -> e1.getSalary().compareTo(e2.getSalary()))
                .forEach(e -> System.out.println(e));
List<Employee> li= employees.stream().filter(e -> e.getName().startsWith("s")).
                sorted((e1, e2) -> e1.getSalary().compareTo(e2.getSalary())).
        collect(Collectors.toList());


        /*
		 * TO DO 5: Afficher les noms des employ�s dont le salaire > 600 avec 2
		 * mani�res diff�rentes
         */
 /* First Way */
        employees.stream().filter(e -> e.getSalary() > 600).
                forEach(e -> System.out.println(e.getName()));
        /* Second Way */
        
        Stream<Employee> stem = employees.stream().filter(e -> e.getSalary() > 600);
        
        Stream<String> stre = employees.stream().map(e -> e.getName());
        
        employees.stream().filter(e -> e.getSalary() > 600).
                map(e -> e.getName())
                .forEach(e -> System.out.println(e));

        /*
		 * TO DO 6: Ajouter 200 D pour les employ�s dont le nom commence avec m
		 * et les affich�s ensuite
         */
        employees.stream().filter(e -> e.getName().startsWith("m")).
                forEach(e
                        -> {
                    e.setSalary(e.getSalary() + 200);
                    System.out.println(e);
                });
        
    }
}
