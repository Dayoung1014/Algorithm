import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if(input.equals("end")) break;
            int con=0, linkedC=0, linkedV=0;
            boolean chk = true;
            for(int i=0; i<input.length(); i++) {
                char now = input.charAt(i);
                if(now=='a'|| now=='e'|| now=='i'|| now=='o'|| now=='u') {
                    con++;
                    linkedC++;
                    linkedV=0;
                    if(linkedC==3) {
                        chk=false;
                        break;
                    }
                }
                else {
                    linkedC=0;
                    linkedV++;
                    if(linkedV==3) {
                        chk=false;
                        break;
                    }
                }
                if(i>0 && input.charAt(i-1) == now && now!='e' && now!='o') {
                    chk=false;
                    break;
                }
            }
            if(con==0) chk = false;
            
            sb.append("<"+input+"> is ");
            if(chk) sb.append("acceptable.\n");
            else sb.append("not acceptable.\n");
        }
        System.out.println(sb);

    }
}