package lab8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@DataProcessor(processorName = "Sorter")
public class DataSorter implements Processor{
    private ArrayList<String> data;
    private Comparator<String> comparator;
    public DataSorter(Comparator<String> comparator){
        this.comparator = comparator;
    }
    @Override
    public void setData(ArrayList<String> data) {
        this.data = data;
    }
    @Override
    public String call() throws Exception {
        return data.stream().sorted(comparator).collect(Collectors.joining("\n"));
    }
}
