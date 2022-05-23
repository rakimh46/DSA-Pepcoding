public class ReachNumber {
    // pepecoding
    public int reachNumber(int target) {
        if (target < 0) {
            target = Math.abs(target);
        }
        if (target == 1) {
            return 1;
        }

        int jump = 0;
        int s = 0;
        while (s < target) {
            jump++;
            s += jump;
        }

        if (s == target) {
            return jump;
        } else if ((s - target) % 2 == 0) {
            return jump;
        } else {
            if ((s - target + jump + 1) % 2 == 0) {
                return jump + 1;
            } else {
                return jump + 2;
            }
        }

    }

    // leetcode
    public int reachNumber2(int target) {
        int sum = 0, steps = 0;
        if (target == 0)
            return 0;
        target = Math.abs(target);
        while (sum < target) {
            sum += steps;
            steps++;
        }

        while (((sum - target) % 2 != 0)) {
            sum += steps;
            steps++;
        }
        return steps - 1;
    }
}
