package desing_pattern.structured;

import javax.print.attribute.standard.Media;

/**
 * 设备器模式(Adapter/Wrapper Pattern):是作为两个不兼容的接口之间的桥梁，它结合了两个接口的功能。
 * @author zhangqisheng
 * 1.意图:将一个类的接口转换成客户希望的另外一个接口
 * 2.角色:
 *       a.target-目标抽象类,
 *       b.adapter-适配器,
 *       c.adaptee适配者类
 * 3.分类：
 *       a.对象适配器,适配器和适配者的关系是关联
 *       b.类适配器，适配器和适配者关系的继承/实现
 */
public class Adapter {

    interface MediaPlayer {
        void play(String audioType,String fileName);
    }
    interface AdvancedMediaPlayer {
        void playVlc(String fileName);
        void playMap4(String fileName);
    }

    static class VlcPlayer implements AdvancedMediaPlayer {

        @Override
        public void playVlc(String fileName) {
            System.out.println("playing vlc file.name:" + fileName);
        }

        @Override
        public void playMap4(String fileName) {
            // 什么都不做
        }
    }

    static class Map4Player  implements AdvancedMediaPlayer {

        @Override
        public void playVlc(String fileName) {
            // 什么都不做
        }

        @Override
        public void playMap4(String fileName) {
            System.out.println("playing map4 file.name" + fileName);

        }
    }

    static class MediaAdapter implements MediaPlayer {

        AdvancedMediaPlayer  advancedMusicPlayer;

        public MediaAdapter(String audioType) {
            if(audioType.equalsIgnoreCase("vlc")) {
                advancedMusicPlayer = new VlcPlayer();
            } else if(audioType.equalsIgnoreCase("mp4")) {
                advancedMusicPlayer = new Map4Player();
            }
        }

        @Override
        public void play(String audioType, String fileName) {
            if(audioType.equalsIgnoreCase("vlc")) {
                advancedMusicPlayer.playVlc(fileName);
            } else if(audioType.equalsIgnoreCase("mp4")) {
                advancedMusicPlayer.playMap4(fileName);
            }
        }
    }
    static class AudioPlayer implements MediaPlayer {

        MediaAdapter mediaAdapter;

        @Override
        public void play(String audioType, String fileName) {
            if(audioType.equalsIgnoreCase("mp3")) {
                System.out.println("playing mp3. file:" + fileName);
            } else if(audioType.equalsIgnoreCase("vlc")
                    || audioType.equalsIgnoreCase("mp4")) {
                mediaAdapter = new MediaAdapter(audioType);
            } else  {
                System.out.println("invalid media." + audioType + "format not supports");
            }
        }
    }

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3","beyond the horizon.mp3");
        audioPlayer.play("mp4","alone.mp4");
        audioPlayer.play("vlc","far far way.vlc");
        audioPlayer.play("avi","mind me.avi");
    }
}
