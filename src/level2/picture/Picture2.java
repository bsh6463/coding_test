package level2.picture;

import java.util.*;

/**
 * BFS
 */
public class Picture2 {

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea=0;
        int maxSizeOfOneArea=0;
        boolean[][] visited = new boolean[m][n];
        int[] answer = new int[2];

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        long[][] arr = new long[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                arr[i][j] =picture[i][j];
            }
        }

        for(int i=0; i<m; i++){ //y
            for (int j=0; j<n; j++){ //x
                if (arr[i][j] != 0 && !visited[i][j]){
                    //새로운 영역을 찾았다!
                    numberOfArea++;

                    //새로운 영역의 넓이 확인.
                    int size = check(m, n, arr, i, j, visited, dx, dy);

                    if(size> maxSizeOfOneArea){
                        maxSizeOfOneArea=size;
                    }

                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    /**
     * 영역의 넓이 반환.
     */
    public int check(int m, int n, long[][] arr, int i, int j, boolean[][] visited, int[] dx, int[] dy) {
        int area = 1; //영역이 넓이
        long current = arr[i][j];
        visited[i][j] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()){
            int[] point = queue.remove();

            //현재 point 주변 같은 색 찾아서 queue에 넣기

            for (int k=0; k< 4; k++){
                int y = point[0] + dy[k];
                int x = point[1] + dx[k];

                // 0<=x<=n, 0<=y<=m 범위가 아닌경우 pass
                if(x<0 || x>=n || y<0 || y >=m) continue;

                if(!visited[y][x] && arr[y][x] == current){
                    area++;
                    queue.add(new int[]{y,x});
                    visited[y][x] = true;
                }
            }

        }

        return area;

    }

    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        Picture2 coloringBook = new Picture2();
        int[] solution = coloringBook.solution(6, 4, picture);

        System.out.println("number of area : " + solution[0] + ",\nmax area : " + solution[1]);
    }
}


