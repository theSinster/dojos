import java.util.ArrayList;
import java.util.Arrays;

public class BusinessTasks {

    public String getTask(String[] list, int n) {
        ArrayList<String> taskList = new ArrayList<>(Arrays.asList(list));

        int indexToBeRemoved = 0;
        while (taskList.size() > 1) {
            indexToBeRemoved = calculateIndexToBeRemoved(taskList.size(), n, indexToBeRemoved);
            taskList.remove(indexToBeRemoved);
        }
        return taskList.get(0);
    }

    private int calculateIndexToBeRemoved(int sizeOfList, int seed, int currentIndex) {
        int newPosition = (seed + currentIndex) % sizeOfList;
        if (newPosition == 0) {
            return sizeOfList - 1;
        }
        return newPosition - 1;
    }
}
