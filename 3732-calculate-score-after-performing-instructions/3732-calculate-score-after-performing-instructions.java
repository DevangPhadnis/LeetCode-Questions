class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        Long answer = 0L;
        int index = 0;
        boolean visited[] = new boolean[instructions.length];
        Arrays.fill(visited, false);
        while(index >=0 && index < instructions.length && !visited[index]) {
            if(instructions[index].equals("jump")) {
                visited[index] = true;
                index+=values[index];
            }
            else {
                answer+=Long.valueOf(values[index]);
                visited[index] = true;
                index = index+1;
            }
        }
        return answer;
    }
}