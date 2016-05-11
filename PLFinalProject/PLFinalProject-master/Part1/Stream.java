// to run
// (exec 'import Stream; toReturn = Stream.main()')

import java.lang.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class Stream {
    public static void main() throws IOException {

        ArrayList<List<String>> emp = new ArrayList<List<String>>();

        String path = System.getProperty("user.dir");
        File file = new File(path + "/employees.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            List<String> items = Arrays.asList(line.split(", "));

            emp.add(items);
        }

        //remove empty end
        emp.remove(emp.size() - 1);

        //Stream 1
        System.out.println("1) print ename and sal");
        emp.stream()
                .forEach(e -> { System.out.println(e.get(1)+" "+e.get(7)); });
        System.out.println();

        //Stream 2
        System.out.println("2) print ename and sal where sal>1000");
        emp.stream()
                .filter(e -> Integer.parseInt(e.get(7)) > 1000)
                .forEach(e -> { System.out.println(e.get(1)+" "+e.get(7)); });
        System.out.println();

        //Stream 3
        System.out.println("3) print out position and sal for sal > 1500");
        emp.stream()
                .filter(e -> Integer.parseInt(e.get(7)) > 1500)
                .forEach(e -> { System.out.println(e.get(6)+ " "+e.get(7)); });
        System.out.println();
    }
}