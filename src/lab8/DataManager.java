package lab8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class DataManager {
    private ArrayList<Processor> processors;
    private ArrayList<Future<String>> results;
    private ArrayList<String> data;
    private ExecutorService executor;

    public DataManager(){
        this(Runtime.getRuntime().availableProcessors());
    }
    public DataManager(int threadCount){
        processors = new ArrayList<>();
        results = new ArrayList<>();
        executor = Executors.newFixedThreadPool(threadCount);
    }

    public void registerDataProcessor(Processor processor){
        if (!processor.getClass().isAnnotationPresent(DataProcessor.class)){
            System.out.println(processor.getClass().getName() + " is not a DataProcessor");
            return;
        }
        processors.add(processor);
    }
    public void loadData(String source){
        try(BufferedReader reader = new BufferedReader(new FileReader(source))) {
            data = reader.lines().collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            System.out.println("Couldn't open file "+ source);
        }
    }

    public void processData(){
        processors.forEach((a) -> a.setData(data));
        processors.forEach(((a) -> results.add(executor.submit(a))));
        executor.shutdown();
        try {
            if (!executor.awaitTermination(8000, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
    public void saveData(String destination){
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(destination))){
            for (int i = 0; i < results.size(); i++){
                writer.write(processors.get(i).getClass().getAnnotation(DataProcessor.class).processorName());
                writer.write("\n############\n");
                writer.write(results.get(i).get());
                writer.write("\n############\n\n");
            }
        } catch (InterruptedException | ExecutionException | IOException e) {
            System.out.println("Couldn't open file " + destination);
        }

    }
}
