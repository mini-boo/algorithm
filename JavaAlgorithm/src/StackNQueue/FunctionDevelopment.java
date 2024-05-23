package StackNQueue;

import java.util.*;

class FunctionDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            q.add((int) Math.ceil((100-progresses[i])/(double) speeds[i]));
        }

        ArrayList<Integer> list = new ArrayList<>();

        int x = q.poll();
        int count = 1;
        while (!q.isEmpty()) {
            if (x >= q.peek()) {
                count++;
                q.poll();
            } else {
                list.add(count);
                count = 1;
                x = q.poll();
            }
        }
        list.add(count);

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }


        return answer;
    }
}
