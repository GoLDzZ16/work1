import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

//"D:\\programms\\schedule.txt"
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("D:\\programms\\schedule.txt"));
        List<String> list = new ArrayList<>();
        while (s.hasNext()) {
            list.add(s.next());
        }
        s.close();
        System.out.println(Arrays.toString(list.toArray()));

        List<String> allPrograms = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).contains(":") && !list.get(i).contains("#")){
                allPrograms.add(list.get(i));
            }
        }
        System.out.println(allPrograms);


// Заполнение данных из файла в channelProgramsMap
        Map<String, List<String>> channelProgramsMap = new HashMap<String, List<String>>(); //все программы
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("#")) {
                List<String> program = new ArrayList<>();
                for (int j = i + 1; j < list.size(); j++) {
                    if (!list.get(j).contains(":")) {
                        if (list.get(j).contains("#")) break;
                        program.add(list.get(j));
                        channelProgramsMap.put(list.get(i), program);
                    }
                }
            }
        }
        System.out.println(channelProgramsMap);

        //время 04:45(допустим)
        List<String> currentPrograms = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("04:45")) {
                currentPrograms.add(list.get(i+1));
            }
        }
        System.out.println(currentPrograms);

        // Поиск программ по названию
//        String searchName = "Доброе утро";
//        List<String> programsByName = new ArrayList<>();
//        for (String program : allPrograms) {
//            if (program.name().equals(searchName)) {
//                programsByName.add(program);
//            }
//        }
//
//
//        // Поиск программ определенного канала в определенном промежутке времени
//        BroadcastsTime startTime = new BroadcastsTime((byte) 18, (byte) 0); // Пример начального времени
//        BroadcastsTime endTime = new BroadcastsTime((byte) 21, (byte) 0); // Пример конечного времени
//        List<String> channelProgramsInTimeRange = new ArrayList<>();
//        for (String program : allPrograms) {
//            if (program.channel().equals(searchChannel) && program.time().between(startTime, endTime)) {
//                channelProgramsInTimeRange.add(program);
//            }
//        }


    }
}