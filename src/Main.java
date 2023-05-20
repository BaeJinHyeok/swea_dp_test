import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N,M;
    private static int[][] board;

    private static final int[] dx = {-1, -1, -1};
    private static final int[] dy = {-1, 0, 1};

    private static BufferedReader br;
    private  static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        play();
        print();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");

            for(int j =0; j < M; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    private static void play(){
        for(int i =1; i <N; i++){
            for( int j=0; j<M; j++){

                int max = Integer.MIN_VALUE;
                System.out.println(max);

                for(int d = 0; d <3; d++){
                    int nx = i +dx[d];// 행
                    int ny = i +dy[d];// 열

                    if(nx <0 || ny < 0 || nx >= N || ny >= M) continue;
                    int cell = board[nx][ny];
                    System.out.println(cell);
                    max=Math.max(max, cell);
                }
                board[i][j] +=max;
            }

        }
    }
    private static void print(){
        int result = Integer.MIN_VALUE;

        for(int i=0; i<M; i++)
            result= Math.max(result,board[N-1][i]);

        System.out.println(result);
    }
}

