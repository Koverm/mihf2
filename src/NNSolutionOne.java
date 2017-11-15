import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class NNSolutionOne {

    ArrayList<Integer> input =new ArrayList();
    Random r= new Random(1);
    ArrayList<float[][]> m= new ArrayList<>();

    public void read() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String tmp= br.readLine();
        String []tmp2 = tmp.split(",");
        for (String s: tmp2
             ) {
            input.add(Integer.parseInt(s));
        }
    }

    public void createMatrix(){
        for (int i=0;i < input.size()-1;++i){
            float[][] tmp = new float[input.get(i)][input.get(i+1)];
            for (int j=0;j<input.get(i);j++){
                for (int k=0;k< input.get(i+1);k++){
                    tmp [j][k] = (float) r.nextGaussian()*0.1f;
                }
            }
            m.add(tmp);
        }

    }

    public void write(){
        for (int i=0;i < input.size();++i){
            System.out.print(input.get(i));
            if (i<input.size()-1){
                System.out.print(",");
            }
        }
        System.out.println();
        for (int i=0;i < input.size()-1;++i){
            for (int j=0;j<input.get(i+1);j++) {
                for (int k = 0; k < input.get(i); k++) {
                    System.out.print( m.get(i)[k][j]+",");
                }
                System.out.println("0");
            }
        }
    }

        public static void main(String[] args)throws Exception{
            NNSolutionOne nnso= new NNSolutionOne();
            nnso.read();
            nnso.createMatrix();
            nnso.write();
        }

}
