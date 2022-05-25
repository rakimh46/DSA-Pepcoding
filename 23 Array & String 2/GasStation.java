public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas = 0;
        int totalcost = 0;
        for (int i = 0; i < cost.length; i++) {
            totalcost += cost[i];
            totalgas += gas[i];
        }
        if (totalgas - totalcost < 0) {
            return -1;
        }
        int prefix = gas[0] - cost[0];
        int mingas = prefix;
        int mingasIdx = 0;

        for (int i = 1; i < cost.length; i++) {
            prefix += gas[i] - cost[i];
            if (mingas > prefix) {
                mingas = prefix;
                mingasIdx = i;
            }
        }

        return (mingasIdx + 1) % gas.length;
    }
}
