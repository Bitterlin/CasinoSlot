import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


class PlaySound{

    public void playSound(String soundNumber) {
        String pathSoundWinLow = "src/main/resources/winLow.wav";
        String pathSoundWinHight = "src/main/resources/winHight.wav";
        String pathSoundClapYourHands = "src/main/resources/clapYourHands.wav";
        String pathSoundNewGameStart = "src/main/resources/newGameStart.wav";

        String soundExecute = switch (soundNumber) {
            case "winLow" -> pathSoundWinLow;
            case "winHight" -> pathSoundWinHight;
            case "clapYourHands" -> pathSoundClapYourHands;
            default -> pathSoundNewGameStart;
        };

        Runnable runnable = () -> playSound2(soundExecute);
        Thread thread = new Thread( runnable );
        thread.setName( "Thread 1" );
        thread.start();


    }

    private final int BUFFER_SIZE = 128000;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;


    public void playSound2 (String filename){

        String strFilename = filename;

        try {
            soundFile = new File(strFilename);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            audioStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

        audioFormat = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();
        }
    }
