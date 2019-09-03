import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5}; // return {2,1}
		
		System.out.println(Arrays.toString(new Solution().solution(progresses, speeds)));
	}

}
class Solution {
	public void work(int idx, int[] progresses, int[] speeds) {
		for (int i = idx; i < progresses.length; i++) {
			if (progresses[i] < 100) 
				progresses[i] += speeds[i];
		}
	}
    public int[] solution(int[] progresses, int[] speeds) {
        int idx = 0;
        Queue<Integer> processNumList = new LinkedList<Integer>();
        while (idx < progresses.length) {
        	work(idx, progresses, speeds);
        	if (progresses[idx] >= 100) {
        		int process = 0;
        		idx++;
        		process++;
        		while (idx < progresses.length && progresses[idx] >= 100) {
        			idx++;
        			process++;
        		}
        		processNumList.add(process);
        	}
        }

        int[] answer = new int[processNumList.size()];
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = processNumList.poll();
        }
        return answer;
    }
}