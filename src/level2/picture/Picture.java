package level2.picture;

/**
 * 재귀함수 방법
 * stack over flow 발생.. 로직은 맞는듯.
 */
public class Picture {

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea=0;
        int maxSizeOfOneArea=0;
        long[][] arr = new long[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                arr[i][j] =picture[i][j];
            }
        }

        for(int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (arr[i][j] != 0){
                    //새로운 영역을 찾았다!
                    numberOfArea++;

                    //새로운 영역의 넓이 확인.
                    int size = check(m, n, arr, i, j);

                    if(size> maxSizeOfOneArea){
                        maxSizeOfOneArea=size;
                    }

                }
            }
        }


        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    /**
     * 영역의 넓이 반환.
     */
    public int check(int m, int n, long[][] arr, int i, int j) {
        int area = 1; //해당 영역의 넓이

        //방분했으니 음수로 변경해줌
        long current= arr[i][j];

        //방문한 노드는 읍수로 변경
        arr[i][j] = -1;

        if(i>=1 && arr[i -1][j]== current){
            //같은 색깔이 있는 경우 해당 지접으로 이동해서 다시 인접 확인.
            //인접한 노드 중에서 같은 색갈인 노드들의 넓이를 가져옴.
            area += check(m, n, arr, i-1, j);
        }

        if(i+1<=m && arr[i +1][j]== current){
            area += check(m, n, arr, i+1, j);
        }

        if(j>=1 && arr[i][j -1]== current){
            area +=  check(m, n, arr, i, j-1);
        }

        if(j+1<=n && arr[i][j +1]== current){
            area += check(m, n, arr, i, j+1);
        }

        return area;
    }

    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        Picture coloringBook = new Picture();
        int[] solution = coloringBook.solution(6, 4, picture);

        System.out.println("number of area : " + solution[0] + "max area : " + solution[1]);
    }
}


