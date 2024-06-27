public class Map {
    int row ,col ;
    String[][] map;
    int [][] bomb ;
    int iterator_bomp = 0 ;
    int size_bomb;
    public Map(int  a , int    b, int n){
        row = a;
        col = b;
        map = new String[row][col];
        for(int i = 0 ; i<row ; i++){
            for(int j = 0 ; j<col ; j++){
                map[i][j]="?";
            }
        }
        bomb = new int[n][2];
        size_bomb  = n ;
    }
    public void show_map(){
        for(int i = 0 ; i<row ; i++){
            for(int j = 0 ; j<col ; j++){
                System.out.print(map[i][j]+"   ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void add_bomb(int i , int j ){
        bomb[iterator_bomp][0]=i-1;
        bomb[iterator_bomp][1]=j-1;
        iterator_bomp++;
    }
    public void show_bomb(){
        for(int i = 0 ; i<size_bomb ; i++){
            System.out.println(bomb[i][0]+" "+ bomb[i][1]);
        }
    }
    public boolean check_bomb(int a , int b){
        for(int i = 0 ; i<size_bomb ; i++){
            if(bomb[i][0]==a && bomb[i][1]==b){
                return true;
            }
        }
        return false ;
    }
    public boolean change_map(int n , int m ){
        int a =n-1 ;
        int b = m -1  ;
        if(check_bomb(a,b)==true){
            map[a][b]="f";
            show_map();
            System.out.println("The Robot Failed!");
            return true;
        }
        if(check_bomb(a,b)==false){
            map[a][b]="c";
            for(int i=0 ; i<row ; i++){
                for(int j = 0 ; j<col ; j++){
                    if(map[i][j]=="?" && check_bomb(i,j)==false){
                        return false;
                    }
                }
            }
            show_map();
            System.out.println("The Robot Succeeded!");
            return true;
        }
        return false;
    }

}
