import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

public class stream {
    public static void main(String[] args) {

        // stream reader
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            System.out.println("Enter a character: ");
            int letters = isr.read();
            while (isr.ready()) {
                System.out.print((char) letters);
                letters = isr.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // buffer and file reader
        try {
            File fo = new File("new-file.txt");
            fo.createNewFile();
            BufferedReader bf = new BufferedReader(new FileReader("new-file.txt"));
            System.out.println(bf.readLine());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // stream writer & bufferwriter and file writer

        try {
            OutputStream os = System.out;
            os.write("Hello World".getBytes());
            os.flush();

            OutputStreamWriter osw = new OutputStreamWriter(System.out);
            osw.write("Hellow this outputstreamWriter!");
            osw.flush();

            BufferedWriter bw = new BufferedWriter(new FileWriter("new-file.txt"));
            bw.write("All the text has overWritten and new text is added !");
            bw.close();

            BufferedWriter bwAppend = new BufferedWriter(new FileWriter("new-file.txt", true));
            bwAppend.write("This content is used to append in the ..prev");
            bwAppend.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}