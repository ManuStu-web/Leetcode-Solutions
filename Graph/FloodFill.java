class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x, int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniCol = image[sr][sc];
        if(iniCol==color)
        {
            return image;
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr,sc));
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int row = p.x;
            int col = p.y;

            image[row][col]=color;
            if(row>0 && image[row-1][col]==iniCol)
            {
                q.offer(new Pair(row-1,col));
            }

            if(row<image.length-1 && image[row+1][col]==iniCol)
            {
                q.offer(new Pair(row+1,col));
            }

            if(col>0 && image[row][col-1]==iniCol)
            {
                q.offer(new Pair(row,col-1));
            }

            if(col<image[0].length-1 && image[row][col+1]==iniCol)
            {
                q.offer(new Pair(row,col+1));
            }
        }

        return image;
    }
}
