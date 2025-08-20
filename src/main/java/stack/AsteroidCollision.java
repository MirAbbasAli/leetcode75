package stack;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids){
            boolean pushCurrent = true;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0){
                int top = stack.peek();

                // Destroy current asteroid
                if (top > Math.abs(asteroid)){
                    pushCurrent = false;
                    break;
                }
                if (top == Math.abs(asteroid)){
                    pushCurrent = false;
                    stack.pop();
                    break;
                } else {
                    stack.pop();
                }
            }
            if (pushCurrent){
                stack.push(asteroid);
            }
        }

        return stack.stream().mapToInt(i->i).toArray();
    }
}
