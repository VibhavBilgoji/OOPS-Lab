import java.util.Scanner;

class MediaPlayer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Media myMedia;

        System.out.println("Enter Audio Title:");
        String audioTitle = sc.nextLine();
        myMedia = new Audio(audioTitle);
        myMedia.play();

        System.out.println("\n----------------------------\n");

        System.out.println("Enter Video Title:");
        String videoTitle = sc.nextLine();
        myMedia = new Video(videoTitle);
        myMedia.play();

        sc.close();
    }
}

abstract class Media{
    String title;
    abstract void play();
    public Media(String t){
        System.out.println("---Media (abstract class) constructor called---");
        title = t;
    }
}

class Audio extends Media{
    public Audio(String t){
        super(t);
        System.out.println("---Audio (subclass) constructor called---");
    }
    void play(){
        System.out.println("Playing audio: " + title);
    }
}

class Video extends Media{
    public Video(String t){
        super(t);
        System.out.println("---Video (subclass) constructor called---");
    }
    void play(){
        System.out.println("Playing video: " + title);
    }
}