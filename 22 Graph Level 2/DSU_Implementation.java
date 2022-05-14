public class DSU_Implementation {

    public static class UnionFind {
        int[] parent; // root
        int[] rank; // height

        public UnionFind(int vtxs) {
            this.parent = new int[vtxs];
            this.rank = new int[vtxs];
            for (int i = 0; i < vtxs; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < vtxs; i++) {
                rank[i] = 1;
            }

        }

        public void unnion(int vtx1, int vtx2) {
            int rootv1 = find(vtx1);
            int rootv2 = find(vtx2);
            int rankv1 = rank[vtx1]; 
            int rankv2 = rank[vtx2]; 

            if(rankv1>rankv2){
                parent[rootv2]=rootv1;
            }else if(rankv1<rankv2){
                parent[rootv1]=rootv2;
            }else{
                parent[rootv2]=rootv1;
                rank[vtx1]++;
            }
            
            // donothing if euqals
        }

        public int find(int vtx) {
            if (parent[vtx] == vtx) {
                return vtx;
            }
            return parent[vtx] + find(parent[vtx]);
        }

        public boolean isConnected(int vtx1, int vtx2) {
            return find(vtx1) == find(vtx2);
        }
    }

    public static void main(String[] args) {
        UnionFind obj = new UnionFind(10);

        obj.unnion(0, 1);
        obj.unnion(1, 2);
        obj.unnion(4, 8);
        obj.unnion(5, 6);
        obj.unnion(2, 3);
        obj.unnion(6, 7);

        System.out.println(obj.isConnected(2, 1));
        System.out.println(obj.isConnected(2, 6));
        System.out.println(obj.isConnected(8, 3));

    }
}
