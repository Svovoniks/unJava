package lab8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@DataProcessor(processorName = "Filter")
public class DataFilter implements Processor{
    private ArrayList<String> data;
    private Predicate<String> predicate;

    public DataFilter(Predicate<String> predicate){
        this.predicate = predicate;
    }
    @Override
    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public String call() throws Exception {
        return data.stream().filter(predicate).collect(Collectors.joining("\n"));
    }
}
