import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class NNSolutionTwo {


    ArrayList<Integer> input =new ArrayList();
    Random r= new Random(1);
    ArrayList<float[][]> m= new ArrayList<>();
    ArrayList<float[]> b ;
    int sum=0;

    public void read() throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String tmp= br.readLine();
        String []tmp2 = tmp.split(",");
        for (String s: tmp2
                ) {
            input.add(Integer.parseInt(s));
        }

        for (int i=1; i<input.size();i++){
            sum+=input.get(i);
        }
        b = new ArrayList<>();
        for (int i=0;i < input.size()-1;++i){
            float[][] tmp3 = new float[input.get(i)][input.get(i+1)];
            int n=0;
            float [] tmp4 =new float[input.get(i+1)];
            for (int j=0;j<input.get(i+1);j++){
                tmp= br.readLine();
                tmp2 = tmp.split(",");
                for (int k=0;k< input.get(i);k++){

                    tmp3 [k][j] = Float.parseFloat(tmp2[k]);
                }

                tmp4[n]=Float.parseFloat(tmp2[input.get(i)]);
                n++;
            }
            b.add(tmp4);
            m.add(tmp3);
        }
        tmp= br.readLine();
        tmp2 = tmp.split(",");
        int n= Integer.parseInt(tmp2[0]);
        System.out.println(n);
        for (int i=0; i<n; ++i){

            float[] t= new float[input.get(0)];
            tmp= br.readLine();
            tmp2 = tmp.split(",");
            for(int j=0;j<input.get(0);j++){
                t[j]=Float.parseFloat(tmp2[j]);
            }
            for (int j = 0; j <input.size()-2 ; j++) {
                t = multipleM(t,m.get(j));
                t = addM(t,b.get(j));
                relu(t);
            }

            t = multipleM(t,m.get(m.size()-1));
            t = addM(t,b.get(b.size()-1));

            for (int j = 0; j < t.length-1; j++) {
                System.out.print(t[j]+",");
            }
            System.out.println(t[t.length-1]);
        }
    }
    private void relu(float [] to){
        for(int i=0;i<to.length;i++){
            if (to[i]<0){
                to[i] = 0;
            }
        }
    }
    private float[] addM(float[] v1 , float[] v2){
        float[] t= new float[v1.length];
        for (int i = 0; i <v1.length ; i++) {
            t[i] = v1[i]+v2 [i];
        }
        return t;
    }

    private float[] multipleM(float[] v , float[][] m)throws Exception{
        float[] t= new float[m[0].length];
        for (int i=0;i<m[0].length;i++){
            for(int j=0;j<v.length ;j++){
                t[i]+=v[j]*m[j][i];
            }
        }
        return t;
    }

    public static void main(String[] args)throws Exception{
        NNSolutionTwo nnst= new NNSolutionTwo();
        nnst.read();
    }
}
