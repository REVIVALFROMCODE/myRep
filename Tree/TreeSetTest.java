import java.util.*;

public class TreeSetTest {
    //customize comparator
    TreeSet<Data> treeSet = new TreeSet<>(new Comparator<Data>() {
        @Override
        public int compare(Data o1, Data o2) {
            return o2.number-o1.number;
        }
    });
    private static class Data{
        int number;
        Data(int number){this.number = number;}
        static Data valueOf(int number){
            return new Data(number);
        }
    }
    private static class DataList{
        static List asDataList(int... numbers){
            List<Data> result = new ArrayList<>();
            for (int num : numbers) {
                result.add(Data.valueOf(num));
            }
            return result;
        }
    }
    public void test(){
        Collection<Data> samples = DataList.asDataList(1,2,3,4);
        this.treeSet.addAll(samples);
        for(Data data : treeSet){
            System.out.println(data.number);
        }
    }
}
