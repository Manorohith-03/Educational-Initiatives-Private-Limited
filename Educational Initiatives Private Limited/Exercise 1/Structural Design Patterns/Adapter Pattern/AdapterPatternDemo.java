import java.util.Scanner;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            AudioPlayer audioPlayer = new AudioPlayer();

            System.out.println("Enter audio type (mp3, mp4): ");
            String audioType = scanner.nextLine();
            System.out.println("Enter file name: ");
            String fileName = scanner.nextLine();

            audioPlayer.play(audioType, fileName);
        }
    }
}

/*Sample Input:
    Enter audio type (mp3, mp4): mp3
    Enter file name: song.mp3
Output:
    Playing mp3 file. Name: song.mp3
 */