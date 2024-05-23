package Heap;

import java.util.PriorityQueue;

public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        // PriorityQueue를 사용하여 최소 힙을 구현
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 모든 스코빌 지수를 최소 힙에 추가
        for (int s : scoville) {
            minHeap.add(s);
        }

        int answer = 0;

        // 최소 힙의 최솟값이 K 이상이 될 때까지 반복
        while (minHeap.peek() < K) {
            // 최소 힙에 요소가 2개 미만인 경우 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없음
            if (minHeap.size() < 2) {
                return -1;
            }

            // 가장 맵지 않은 음식 두 개 꺼내기
            int first = minHeap.poll();
            int second = minHeap.poll();

            // 새로운 스코빌 지수를 계산하여 다시 최소 힙에 추가
            int newScoville = first + (second * 2);
            minHeap.add(newScoville);

            // 섞은 횟수 증가
            answer++;
        }

        return answer;
    }
}
