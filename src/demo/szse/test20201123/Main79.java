package demo.szse.test20201123;

import java.io.*;

public class Main79 {

    public static void main(String[] args) throws IOException{
	// write your code here

        InputStream in=new BufferedInputStream(new FileInputStream("/Users/weihuang/Desktop/data/data.txt"));
        System.setIn(in);
        Reader reader=new InputStreamReader(in);
        LineNumberReader lineNumberReader=new LineNumberReader(reader);
        int lineNumer=0;
        char[][] array=new char[1][2];
        while (true)
        {
            String content=lineNumberReader.readLine();

            if (content!=null){
                array[lineNumer++]=content.toCharArray();
            }
            else{
                break;
            }
        }


        Main79 main79=new Main79();
//        System.out.println(main79.exist(array,"ABCCED"));
//        System.out.println(main79.exist(array,"SEE"));
//        System.out.println(main79.exist(array,"ABCB"));

        System.out.println(main79.exist(array,"ba"));
    }


    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;


        boolean[][] visited=new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j]=false;
            }
        }



        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, 0, word, i, j,visited)) {
                    return true;
                }
            }
        }
        return false;

    }


    public boolean dfs(final char[][] board,int index,final String word,int i,int j,boolean[][] visited){
        int rows=board.length;
        int columns=board[0].length;
        char boardValue=board[i][j];
        char wordValue=word.charAt(index);

        boolean ans=false;
//        System.out.println(i+","+j+"==>"+index+"==>"+wordValue);
        visited[i][j]=true;
        if (boardValue==wordValue){
            if (index==word.length()-1){
                return true;
            }
            //上
            if (i>=1 && !visited[i-1][j]){
                ans= ans || dfs(board,index+1,word,i-1,j,visited);
            }
            if (ans)
            {
                return true;
            }
            if (i<rows-1 && !visited[i+1][j])
            //下
            {

                ans= ans || dfs(board,index+1,word,i+1,j,visited);
            }

            if (ans)
            {
                return true;
            }
            //左
            if (j>=1 && !visited[i][j-1])
            {
                ans= ans || dfs(board,index+1,word,i,j-1,visited);
            }

            if (ans)
            {
                return true;
            }
            //右
            if (j<columns-1 && !visited[i][j+1]){
                ans= ans || dfs(board,index+1,word,i,j+1,visited);
            }

            if (ans)
            {
                return true;
            }

            visited[i][j]=false;
            return false;
        }
        else{
            visited[i][j]=false;
            return false;
        }

    }
}
