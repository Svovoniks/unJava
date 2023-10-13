package lab8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public interface Processor extends Callable<String> {
    void setData(ArrayList<String> data);
}
